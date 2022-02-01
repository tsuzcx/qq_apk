package com.tencent.mobileqq.location.net;

import android.app.Notification;
import android.os.Handler;
import android.support.v4.app.NotificationCompat.Builder;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.location.OnUpdateUserLocationListener;
import com.tencent.mobileqq.location.api.ILocationUtilApi;
import com.tencent.mobileqq.location.data.LocationItem;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;

public class LocationHandler
  extends BusinessHandler
  implements IGuardInterface
{
  private static final Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  private int jdField_a_of_type_Int = -1;
  private final AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private FriendObserver jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver;
  private final LocationDataHandler jdField_a_of_type_ComTencentMobileqqLocationNetLocationDataHandler;
  private LocationObserver jdField_a_of_type_ComTencentMobileqqLocationNetLocationObserver;
  private TroopMngObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver;
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public LocationHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    d();
    this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationDataHandler = new LocationDataHandler(paramAppInterface.getAccount());
  }
  
  public static int a(int paramInt)
  {
    if (paramInt != 2)
    {
      if (paramInt != 3) {
        return 0;
      }
      return 1;
    }
    return 2;
  }
  
  public static LocationHandler a()
  {
    return (LocationHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(((ILocationUtilApi)QRoute.api(ILocationUtilApi.class)).getClassName());
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationObserver = new LocationObserver();
    this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver = new LocationHandler.1(this);
    this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver = new LocationHandler.2(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
  }
  
  public void G_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "[LocationManager] onAppForeground: invoked. ");
    }
    QQNotificationManager.getInstance().cancel("LocationHandler", 525);
    this.jdField_a_of_type_Boolean = true;
    jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void H_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "[LocationManager] onAppBackground: invoked. ");
    }
    this.jdField_a_of_type_Boolean = false;
    jdField_a_of_type_AndroidOsHandler.postDelayed(new LocationHandler.3(this), 60000L);
    if (!LocationShareLocationManager.a().a()) {
      return;
    }
    Object localObject = new NotificationCompat.Builder(BaseApplication.getContext());
    ((NotificationCompat.Builder)localObject).setContentText(BaseApplication.getContext().getString(2131694520)).setWhen(System.currentTimeMillis()).setSmallIcon(2130841471).setAutoCancel(true);
    localObject = ((NotificationCompat.Builder)localObject).build();
    QQNotificationManager.addChannelIfNeed((Notification)localObject, "CHANNEL_ID_OTHER");
    QQNotificationManager.getInstance().notify("LocationHandler", 525, (Notification)localObject);
    jdField_a_of_type_AndroidOsHandler.postDelayed(new LocationHandler.4(this), 3000L);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public LocationRoom a(LocationRoom.RoomKey paramRoomKey)
  {
    return this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationDataHandler.a(paramRoomKey);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationDataHandler.a(paramInt, paramString);
  }
  
  public void a(long paramLong) {}
  
  public void a(OnUpdateUserLocationListener paramOnUpdateUserLocationListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationDataHandler.b(paramOnUpdateUserLocationListener);
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey)
  {
    LocationShareRoomManager.a().a(paramRoomKey);
    LocationRoom.RoomKey localRoomKey = new LocationRoom.RoomKey(LocationShareLocationManager.a().a.a(), LocationShareLocationManager.a().a.a());
    if (!localRoomKey.equals(paramRoomKey))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("notifyRoomChanging: invoked. new roomKey: ");
        localStringBuilder.append(paramRoomKey);
        localStringBuilder.append(" org roomKey: ");
        localStringBuilder.append(localRoomKey);
        QLog.d("LocationHandler", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationDataHandler.a(localRoomKey);
    }
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyKickOff: invoked. roomKey: ");
      localStringBuilder.append(paramRoomKey);
      localStringBuilder.append(" clientType: ");
      localStringBuilder.append(paramInt);
      QLog.d("LocationHandler", 2, localStringBuilder.toString());
    }
    LocationShareLocationManager.a().a(paramRoomKey, true);
    this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationDataHandler.b(paramRoomKey, paramInt);
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationDataHandler.a(paramRoomKey, paramInt1, paramInt2);
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, LocationRoom.Venue paramVenue, List<LocationItem> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationDataHandler.a(paramRoomKey, paramVenue, paramList);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(long paramLong) {}
  
  public void b(OnUpdateUserLocationListener paramOnUpdateUserLocationListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationDataHandler.a(paramOnUpdateUserLocationListener);
  }
  
  public void b(LocationRoom.RoomKey paramRoomKey, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyRoomClosing: invoked. roomKey: ");
      localStringBuilder.append(paramRoomKey);
      localStringBuilder.append(" reason: ");
      localStringBuilder.append(paramInt);
      QLog.d("LocationHandler", 2, localStringBuilder.toString());
    }
    LocationShareLocationManager.a().a(paramRoomKey, false);
    this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationDataHandler.a(paramRoomKey, paramInt);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public void c(long paramLong) {}
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return LocationObserverBase.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "onDestroy: invoked. ");
    }
    LocationShareLocationManager.a().a(LocationShareRoomManager.a().jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey, true);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationObserver);
    LocationShareRoomManager.a().jdField_a_of_type_ComTencentMobileqqLocationNetRoomQueryHandler.b();
    LocationShareLocationManager.a().a.a();
    this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationDataHandler.a();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("QQLBSShareSvc.room_operation".equals(paramFromServiceMsg.getServiceCmd()))
    {
      LocationShareRoomManager.a().jdField_a_of_type_ComTencentMobileqqLocationNetRoomOperateHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("QQLBSShareSvc.report_location".equals(paramFromServiceMsg.getServiceCmd()))
    {
      LocationShareLocationManager.a().a.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("QQLBSShareSvc.room_query".equals(paramFromServiceMsg.getServiceCmd()))
    {
      LocationShareRoomManager.a().jdField_a_of_type_ComTencentMobileqqLocationNetRoomQueryHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("QQLBSShareSvc.assembly_point_operation".equals(paramFromServiceMsg.getServiceCmd())) {
      LocationShareVenueManager.a().a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationHandler
 * JD-Core Version:    0.7.0.1
 */