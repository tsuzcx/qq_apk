package com.tencent.mobileqq.location.net;

import android.app.Activity;
import android.app.Notification;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.NotificationCompat.Builder;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.map.geolocation.TencentDirectionListener;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.guardinterface.IGuardInterface;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.location.OnUpdateUserLocationListener;
import com.tencent.mobileqq.location.api.IFloatMapService;
import com.tencent.mobileqq.location.api.ILocationUtilApi;
import com.tencent.mobileqq.location.data.LocationItem;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.util.LocationProtoUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class LocationHandler
  extends BusinessHandler
  implements IGuardInterface
{
  private static Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  public static LatLng a;
  private double jdField_a_of_type_Double = 0.0D;
  private int jdField_a_of_type_Int = -1;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private TencentDirectionListener jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener;
  private TencentLocationListener jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener;
  private TencentLocationManager jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager;
  private FriendObserver jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver;
  private LocationRoom.RoomKey jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey;
  private LocationDataHandler jdField_a_of_type_ComTencentMobileqqLocationNetLocationDataHandler;
  private volatile LocationHandler.LocationChangeListener jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler$LocationChangeListener;
  private LocationHandler.VenueOptResultCallback jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler$VenueOptResultCallback;
  private LocationObserver jdField_a_of_type_ComTencentMobileqqLocationNetLocationObserver;
  public ReportLocationHandler a;
  public RoomOperateHandler a;
  public RoomQueryHandler a;
  private VenueOperateHandler jdField_a_of_type_ComTencentMobileqqLocationNetVenueOperateHandler;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private LocationRoom.RoomKey jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey;
  private LatLng jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelLatLng = null;
  private volatile boolean jdField_b_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng = null;
  }
  
  public LocationHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    d();
    i();
  }
  
  static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 3: 
      return 1;
    }
    return 2;
  }
  
  public static LocationHandler a()
  {
    return (LocationHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(((ILocationUtilApi)QRoute.api(ILocationUtilApi.class)).getClassName());
  }
  
  private void c(boolean paramBoolean)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler$LocationChangeListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler$LocationChangeListener.a(this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, Double.valueOf(this.jdField_a_of_type_Double), paramBoolean);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationNetRoomOperateHandler = new RoomOperateHandler(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqLocationNetReportLocationHandler = new ReportLocationHandler(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqLocationNetRoomQueryHandler = new RoomQueryHandler(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqLocationNetVenueOperateHandler = new VenueOperateHandler(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationObserver = new LocationObserver(this);
    e();
    f();
    h();
    this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationDataHandler = new LocationDataHandler(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount());
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new LocationHandler.1(this);
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver = new LocationHandler.2(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
  }
  
  private void g()
  {
    try
    {
      Object localObject = this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.getClass().getDeclaredField("c");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager);
      Field localField = localObject.getClass().getDeclaredField("b");
      localField.setAccessible(true);
      localObject = localField.get(localObject);
      localField = localObject.getClass().getDeclaredField("g");
      localField.setAccessible(true);
      localField.set(localObject, null);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
    }
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, new Object[] { "addRelationChainObservers: invoked. ", " TAG: ", "LocationHandler" });
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationObserver);
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, new Object[] { "removeRelationChainObservers: invoked. ", " TAG: ", "LocationHandler" });
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationObserver);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public LocationRoom.RoomKey a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey;
  }
  
  public LocationRoom a(LocationRoom.RoomKey paramRoomKey)
  {
    return this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationDataHandler.a(paramRoomKey);
  }
  
  LatLng a()
  {
    if (this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelLatLng == null) {
      QLog.d("LocationHandler", 1, "[LocationManager] getSelfLatLng: invoked. location null detected");
    }
    return this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelLatLng;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "[LocationManager] onAppForeground: invoked. ");
    }
    QQNotificationManager.getInstance().cancel("LocationHandler", 525);
    this.jdField_b_of_type_Boolean = true;
    jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, String paramString)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "[LocationManager] createOrJoinRoom: invoked.");
    }
    if (paramInt == 0) {
      if (!LocationProtoUtil.a(paramString)) {}
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationNetRoomOperateHandler.a(i, paramInt, paramString);
      return;
      i = 1;
      continue;
      if (paramInt == 1)
      {
        if (!LocationProtoUtil.b(paramString)) {
          i = 1;
        }
      }
      else
      {
        QLog.d("LocationHandler", 1, new Object[] { "createOrJoinRoom: invoked. (进入已关闭的房间，需要兜底逻辑[弹窗、刷新本地标志等]) ", " operateType: ", Integer.valueOf(0), " mLocationShareFragment.sessionUinType: ", Integer.valueOf(paramInt) });
        i = 0;
      }
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    if (LocationProtoUtil.a(paramInt1, paramString))
    {
      ReportController.b(null, "CliOper", "", "", "0X800A76C", "0X800A76C", a(paramInt2), 0, "" + paramInt3, "0", "0", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X800A765", "0X800A765", paramInt3, 0, "", "0", "0", "");
  }
  
  public void a(long paramLong) {}
  
  public void a(Activity paramActivity, LocationRoom paramLocationRoom)
  {
    if (b()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey = paramLocationRoom.a();
    if (GuardManager.a != null) {
      GuardManager.a.a(this);
    }
    LocationHandler.3 local3 = new LocationHandler.3(this, new SoftReference(paramActivity));
    MqqHandler localMqqHandler = ThreadManager.getUIHandler();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqLocationNetReportLocationHandler.a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey);
    if (bool) {
      a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a(), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager = TencentLocationManager.getInstance(BaseApplication.getContext());
      this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener = new LocationHandler.4(this, bool, local3, localMqqHandler, paramLocationRoom);
      this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener = new LocationHandler.5(this);
      int i = this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.requestLocationUpdates(TencentLocationRequest.create().setInterval(2000L), this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener);
      if (i != 0)
      {
        QLog.e("LocationHandler", 1, "[LocationManager] requestLocationUpdates: invoked. error: " + i);
        QQToast.a(BaseApplication.getContext(), "地图定位系统初始化失败，请稍后重试", 0).a();
        if (paramActivity != null) {
          paramActivity.finish();
        }
      }
      i = this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.startDirectionUpdates(this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener, Looper.myLooper());
      if (i == 0) {
        break;
      }
      QLog.e("LocationHandler", 1, "[LocationManager] startDirectionUpdates: invoked. error: " + i);
      QQToast.a(BaseApplication.getContext(), 1, "方向箭头暂不可用", 0).a();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "[LocationManager] startLocationUpdate: invoked.  add over time runnable");
      }
      localMqqHandler.postDelayed(local3, 15000L);
    }
  }
  
  public void a(OnUpdateUserLocationListener paramOnUpdateUserLocationListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationDataHandler.b(paramOnUpdateUserLocationListener);
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey)
  {
    this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey = paramRoomKey;
  }
  
  void a(LocationRoom.RoomKey paramRoomKey, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "notifyKickOff: invoked. roomKey: " + paramRoomKey + " clientType: " + paramInt);
    }
    a(paramRoomKey, true);
    this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationDataHandler.b(paramRoomKey, paramInt);
  }
  
  void a(LocationRoom.RoomKey paramRoomKey, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationDataHandler.a(paramRoomKey, paramInt1, paramInt2);
  }
  
  void a(LocationRoom.RoomKey paramRoomKey, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler$VenueOptResultCallback != null)
    {
      Pair localPair = this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler$VenueOptResultCallback.a();
      if ((localPair != null) && (paramRoomKey.equals(localPair.first)) && (paramVenue.equals(localPair.second)))
      {
        this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler$VenueOptResultCallback.a(paramRoomKey, paramVenue, paramInt1, paramBoolean, paramInt2);
        this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler$VenueOptResultCallback = null;
      }
    }
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, LocationRoom.Venue paramVenue, LocationHandler.VenueOptResultCallback paramVenueOptResultCallback)
  {
    if ((paramRoomKey == null) || ((paramVenue == null) && (paramVenueOptResultCallback != null)))
    {
      paramVenueOptResultCallback.a(paramRoomKey, paramVenue, 1, false, -1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler$VenueOptResultCallback = paramVenueOptResultCallback;
    this.jdField_a_of_type_ComTencentMobileqqLocationNetVenueOperateHandler.a(paramRoomKey, paramVenue);
  }
  
  void a(LocationRoom.RoomKey paramRoomKey, LocationRoom.Venue paramVenue, List<LocationItem> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationDataHandler.a(paramRoomKey, paramVenue, paramList);
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, String paramString)
  {
    if ((a(paramRoomKey).b()) && (!this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount().equals(paramString))) {
      QQToast.a(BaseApplication.getContext(), 2131693875, 0).a();
    }
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramRoomKey != null) && (!paramRoomKey.equals(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey))) {}
    for (;;)
    {
      return;
      if (Looper.getMainLooper() != Looper.myLooper())
      {
        ThreadManager.getUIHandler().post(new LocationHandler.7(this, paramRoomKey, paramBoolean));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "stopLocationSharing: invoked. roomKey: " + paramRoomKey);
      }
      this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey = null;
      if (GuardManager.a != null) {
        GuardManager.a.b(this);
      }
      if (this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager != null)
      {
        this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener = null;
        this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.removeUpdates(this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener);
        this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.stopDirectionUpdate();
        g();
        this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqLocationNetReportLocationHandler.a();
      QQNotificationManager.getInstance().cancel("LocationHandler", 525);
      paramRoomKey = MobileQQ.sMobileQQ.waitAppRuntime(null);
      try
      {
        paramRoomKey = (IFloatMapService)paramRoomKey.getRuntimeService(IFloatMapService.class, "");
        if (paramRoomKey != null)
        {
          paramRoomKey.quitFloat(-1);
          return;
        }
      }
      catch (Throwable paramRoomKey)
      {
        QLog.e("LocationHandler", 1, "stopLocationSharing: failed. ", paramRoomKey);
      }
    }
  }
  
  public void a(LocationHandler.LocationChangeListener paramLocationChangeListener)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler$LocationChangeListener = paramLocationChangeListener;
      return;
    }
    finally
    {
      paramLocationChangeListener = finally;
      throw paramLocationChangeListener;
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, new Object[] { "joinOrCreateRoomNotReEntry: invoked. ", " isJoinOrCreateRoomNotReEntry: ", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "[LocationManager] onAppBackground: invoked. ");
    }
    this.jdField_b_of_type_Boolean = false;
    jdField_a_of_type_AndroidOsHandler.postDelayed(new LocationHandler.8(this), 60000L);
    if (!b()) {
      return;
    }
    Object localObject = new NotificationCompat.Builder(BaseApplication.getContext());
    ((NotificationCompat.Builder)localObject).setContentText(BaseApplication.getContext().getString(2131694555)).setWhen(System.currentTimeMillis()).setSmallIcon(2130841588).setAutoCancel(true);
    localObject = ((NotificationCompat.Builder)localObject).build();
    QQNotificationManager.addChannelIfNeed((Notification)localObject, "CHANNEL_ID_OTHER");
    QQNotificationManager.getInstance().notify("LocationHandler", 525, (Notification)localObject);
    jdField_a_of_type_AndroidOsHandler.postDelayed(new LocationHandler.9(this), 3000L);
  }
  
  public void b(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationNetReportLocationHandler.a(paramString, new LocationHandler.6(this, paramInt, paramString));
  }
  
  public void b(long paramLong) {}
  
  public void b(OnUpdateUserLocationListener paramOnUpdateUserLocationListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationDataHandler.a(paramOnUpdateUserLocationListener);
  }
  
  public void b(LocationRoom.RoomKey paramRoomKey)
  {
    if (a(paramRoomKey).b()) {
      QQToast.a(BaseApplication.getContext(), 2131693877, 0).a();
    }
  }
  
  public void b(LocationRoom.RoomKey paramRoomKey, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "notifyRoomClosing: invoked. roomKey: " + paramRoomKey + " reason: " + paramInt);
    }
    a(paramRoomKey, false);
    this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationDataHandler.a(paramRoomKey, paramInt);
  }
  
  public void b(LocationRoom.RoomKey paramRoomKey, LocationRoom.Venue paramVenue, LocationHandler.VenueOptResultCallback paramVenueOptResultCallback)
  {
    if ((paramRoomKey == null) || ((paramVenue == null) && (paramVenueOptResultCallback != null)))
    {
      paramVenueOptResultCallback.a(paramRoomKey, paramVenue, 3, false, -1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler$VenueOptResultCallback = paramVenueOptResultCallback;
    this.jdField_a_of_type_ComTencentMobileqqLocationNetVenueOperateHandler.b(paramRoomKey, paramVenue);
  }
  
  public void b(LocationHandler.LocationChangeListener paramLocationChangeListener)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "removeLocationListener: invoked. listener: " + paramLocationChangeListener + " mLocationListener: " + this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler$LocationChangeListener);
      }
      if (paramLocationChangeListener == this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler$LocationChangeListener) {
        this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler$LocationChangeListener = null;
      }
      return;
    }
    finally {}
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, new Object[] { "setJoinOrCreateRoomNotReEntry: invoked. ", " joinOrCreateRoomNotReEntry: ", Boolean.valueOf(paramBoolean) });
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey != null;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public void c(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationDataHandler.a(paramInt, paramString);
  }
  
  public void c(long paramLong) {}
  
  public void c(LocationRoom.RoomKey paramRoomKey)
  {
    if (a(paramRoomKey).b()) {
      QQToast.a(BaseApplication.getContext(), 2131693876, 0).a();
    }
  }
  
  public void d(LocationRoom.RoomKey paramRoomKey)
  {
    this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey = paramRoomKey;
    LocationRoom.RoomKey localRoomKey = new LocationRoom.RoomKey(this.jdField_a_of_type_ComTencentMobileqqLocationNetReportLocationHandler.a(), this.jdField_a_of_type_ComTencentMobileqqLocationNetReportLocationHandler.a());
    if (!localRoomKey.equals(paramRoomKey))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "notifyRoomChanging: invoked. new roomKey: " + paramRoomKey + " org roomKey: " + localRoomKey);
      }
      this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationDataHandler.a(localRoomKey);
    }
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return LocationObserverBase.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "onDestroy: invoked. ");
    }
    a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey, true);
    j();
    k();
    this.jdField_a_of_type_ComTencentMobileqqLocationNetRoomQueryHandler.b();
    this.jdField_a_of_type_ComTencentMobileqqLocationNetReportLocationHandler.a();
    this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationDataHandler.a();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("QQLBSShareSvc.room_operation".equals(paramFromServiceMsg.getServiceCmd())) {
      this.jdField_a_of_type_ComTencentMobileqqLocationNetRoomOperateHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if ("QQLBSShareSvc.report_location".equals(paramFromServiceMsg.getServiceCmd()))
      {
        this.jdField_a_of_type_ComTencentMobileqqLocationNetReportLocationHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQLBSShareSvc.room_query".equals(paramFromServiceMsg.getServiceCmd()))
      {
        this.jdField_a_of_type_ComTencentMobileqqLocationNetRoomQueryHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"QQLBSShareSvc.assembly_point_operation".equals(paramFromServiceMsg.getServiceCmd()));
    this.jdField_a_of_type_ComTencentMobileqqLocationNetVenueOperateHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationHandler
 * JD-Core Version:    0.7.0.1
 */