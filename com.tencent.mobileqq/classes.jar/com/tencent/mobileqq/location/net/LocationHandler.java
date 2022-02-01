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
  private static final Handler f = new Handler(ThreadManager.getSubThreadLooper());
  private int a = -1;
  private final LocationDataHandler b;
  private LocationObserver c;
  private TroopMngObserver d;
  private FriendObserver e;
  private volatile boolean g = false;
  private final AppInterface h;
  
  public LocationHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.h = paramAppInterface;
    d();
    this.b = new LocationDataHandler(paramAppInterface.getAccount());
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
    this.c = new LocationObserver();
    this.d = new LocationHandler.1(this);
    this.e = new LocationHandler.2(this);
    this.h.addObserver(this.c);
    this.h.addObserver(this.d);
    this.h.addObserver(this.e);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.b.a(paramInt, paramString);
  }
  
  public void a(OnUpdateUserLocationListener paramOnUpdateUserLocationListener)
  {
    this.b.b(paramOnUpdateUserLocationListener);
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey)
  {
    LocationShareRoomManager.a().a(paramRoomKey);
    LocationRoom.RoomKey localRoomKey = new LocationRoom.RoomKey(LocationShareLocationManager.a().a.d(), LocationShareLocationManager.a().a.e());
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
      this.b.b(localRoomKey);
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
    this.b.b(paramRoomKey, paramInt);
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, int paramInt1, int paramInt2)
  {
    this.b.a(paramRoomKey, paramInt1, paramInt2);
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, LocationRoom.Venue paramVenue, List<LocationItem> paramList)
  {
    this.b.a(paramRoomKey, paramVenue, paramList);
  }
  
  public int b()
  {
    return this.a;
  }
  
  public LocationRoom b(LocationRoom.RoomKey paramRoomKey)
  {
    return this.b.a(paramRoomKey);
  }
  
  public void b(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void b(OnUpdateUserLocationListener paramOnUpdateUserLocationListener)
  {
    this.b.a(paramOnUpdateUserLocationListener);
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
    this.b.a(paramRoomKey, paramInt);
  }
  
  public void c()
  {
    this.a = -1;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return LocationObserverBase.class;
  }
  
  public void onApplicationBackground()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "[LocationManager] onAppBackground: invoked. ");
    }
    this.g = false;
    f.postDelayed(new LocationHandler.3(this), 60000L);
    if (!LocationShareLocationManager.a().b()) {
      return;
    }
    Object localObject = new NotificationCompat.Builder(BaseApplication.getContext());
    ((NotificationCompat.Builder)localObject).setContentText(BaseApplication.getContext().getString(2131892203)).setWhen(System.currentTimeMillis()).setSmallIcon(2130842313).setAutoCancel(true);
    localObject = ((NotificationCompat.Builder)localObject).build();
    QQNotificationManager.addChannelIfNeed((Notification)localObject, "CHANNEL_ID_OTHER");
    QQNotificationManager.getInstance().notify("LocationHandler", 525, (Notification)localObject);
    f.postDelayed(new LocationHandler.4(this), 3000L);
  }
  
  public void onApplicationForeground()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "[LocationManager] onAppForeground: invoked. ");
    }
    QQNotificationManager.getInstance().cancel("LocationHandler", 525);
    this.g = true;
    f.removeCallbacksAndMessages(null);
  }
  
  public void onBackgroundTimeTick(long paramLong) {}
  
  public void onBackgroundUnguardTimeTick(long paramLong) {}
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "onDestroy: invoked. ");
    }
    LocationShareLocationManager.a().a(LocationShareRoomManager.a().a, true);
    this.h.removeObserver(this.d);
    this.h.removeObserver(this.e);
    this.h.removeObserver(this.c);
    LocationShareRoomManager.a().c.c();
    LocationShareLocationManager.a().a.b();
    this.b.a();
  }
  
  public void onLiteTimeTick(long paramLong) {}
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("QQLBSShareSvc.room_operation".equals(paramFromServiceMsg.getServiceCmd()))
    {
      LocationShareRoomManager.a().b.b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("QQLBSShareSvc.report_location".equals(paramFromServiceMsg.getServiceCmd()))
    {
      LocationShareLocationManager.a().a.b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("QQLBSShareSvc.room_query".equals(paramFromServiceMsg.getServiceCmd()))
    {
      LocationShareRoomManager.a().c.b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("QQLBSShareSvc.assembly_point_operation".equals(paramFromServiceMsg.getServiceCmd())) {
      LocationShareVenueManager.a().a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void onScreensStateChanged(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationHandler
 * JD-Core Version:    0.7.0.1
 */