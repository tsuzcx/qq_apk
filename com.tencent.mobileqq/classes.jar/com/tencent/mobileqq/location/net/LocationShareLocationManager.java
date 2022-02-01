package com.tencent.mobileqq.location.net;

import android.app.Activity;
import android.os.Looper;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.map.geolocation.TencentDirectionListener;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.location.api.IFloatMapService;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class LocationShareLocationManager
{
  private static volatile LocationShareLocationManager jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareLocationManager;
  public static LatLng a;
  private double jdField_a_of_type_Double = 0.0D;
  private TencentDirectionListener jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener;
  private TencentLocationListener jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener;
  private TencentLocationManager jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager;
  private LocationRoom.RoomKey jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey;
  private volatile LocationShareLocationManager.LocationChangeListener jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareLocationManager$LocationChangeListener;
  public ReportLocationHandler a;
  private LatLng b = null;
  
  private LocationShareLocationManager()
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationNetReportLocationHandler = new ReportLocationHandler();
  }
  
  public static LocationShareLocationManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareLocationManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareLocationManager == null) {
          jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareLocationManager = new LocationShareLocationManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareLocationManager;
  }
  
  private void a()
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
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
    }
  }
  
  public LatLng a()
  {
    if (this.b == null) {
      QLog.d("Q.LocationShare", 1, "[LocationManager] getSelfLatLng: invoked. location null detected");
    }
    return this.b;
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationNetReportLocationHandler.a(paramString, paramInt, new LocationShareLocationManager.5(this));
  }
  
  public void a(Activity paramActivity, LocationRoom paramLocationRoom)
  {
    if (a()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey = paramLocationRoom.a();
    LocationShareRoomManager.a().jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey;
    if (GuardManager.a != null) {
      GuardManager.a.a(LocationHandler.a());
    }
    LocationShareLocationManager.1 local1 = new LocationShareLocationManager.1(this, new SoftReference(paramActivity));
    MqqHandler localMqqHandler = ThreadManager.getUIHandler();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqLocationNetReportLocationHandler.a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey);
    if (bool)
    {
      LocationShareRoomManager.a().a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a(), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a());
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.LocationShare", 2, "[LocationManager] startLocationUpdate: invoked.  add over time runnable");
      }
      localMqqHandler.postDelayed(local1, 15000L);
    }
    this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager = TencentLocationManager.getInstance(BaseApplication.getContext());
    this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener = new LocationShareLocationManager.2(this, bool, local1, localMqqHandler, paramLocationRoom);
    this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener = new LocationShareLocationManager.3(this);
    int i = this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.requestLocationUpdates(TencentLocationRequest.create().setInterval(2000L), this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener);
    if (i != 0)
    {
      paramLocationRoom = new StringBuilder();
      paramLocationRoom.append("[LocationManager] requestLocationUpdates: invoked. error: ");
      paramLocationRoom.append(i);
      QLog.e("Q.LocationShare", 1, paramLocationRoom.toString());
      QQToast.a(BaseApplication.getContext(), "地图定位系统初始化失败，请稍后重试", 0).a();
      if (paramActivity != null) {
        paramActivity.finish();
      }
    }
    i = this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.startDirectionUpdates(this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener, Looper.myLooper());
    if (i != 0)
    {
      paramActivity = new StringBuilder();
      paramActivity.append("[LocationManager] startDirectionUpdates: invoked. error: ");
      paramActivity.append(i);
      QLog.e("Q.LocationShare", 1, paramActivity.toString());
      QQToast.a(BaseApplication.getContext(), 1, "方向箭头暂不可用", 0).a();
    }
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramRoomKey != null) && (!paramRoomKey.equals(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey))) {
      return;
    }
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      ThreadManager.getUIHandler().post(new LocationShareLocationManager.4(this, paramRoomKey, paramBoolean));
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopLocationSharing: invoked. roomKey: ");
      localStringBuilder.append(paramRoomKey);
      QLog.d("Q.LocationShare", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey = null;
    if (GuardManager.a != null) {
      GuardManager.a.b(LocationHandler.a());
    }
    paramRoomKey = this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager;
    if (paramRoomKey != null)
    {
      this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener = null;
      paramRoomKey.removeUpdates(this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener);
      this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.stopDirectionUpdate();
      a();
      this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationNetReportLocationHandler.a();
    QQNotificationManager.getInstance().cancel("Q.LocationShare", 525);
    try
    {
      ((IFloatMapService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFloatMapService.class, "")).quitFloat(-1);
      return;
    }
    catch (Throwable paramRoomKey)
    {
      QLog.e("Q.LocationShare", 1, "stopLocationSharing: failed. ", paramRoomKey);
    }
  }
  
  public void a(LocationShareLocationManager.LocationChangeListener paramLocationChangeListener)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareLocationManager$LocationChangeListener = paramLocationChangeListener;
      return;
    }
    finally
    {
      paramLocationChangeListener = finally;
      throw paramLocationChangeListener;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareLocationManager$LocationChangeListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareLocationManager$LocationChangeListener.a(this.b, Double.valueOf(this.jdField_a_of_type_Double), paramBoolean);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey != null;
  }
  
  public void b(LocationShareLocationManager.LocationChangeListener paramLocationChangeListener)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramLocationChangeListener);
        localStringBuilder.append(" mLocationListener: ");
        QLog.d("Q.LocationShare", 2, new Object[] { "removeLocationListener: invoked. listener: ", localStringBuilder.toString(), this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareLocationManager$LocationChangeListener });
      }
      if (paramLocationChangeListener == this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareLocationManager$LocationChangeListener) {
        this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareLocationManager$LocationChangeListener = null;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationShareLocationManager
 * JD-Core Version:    0.7.0.1
 */