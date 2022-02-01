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
  public static LatLng b;
  private static volatile LocationShareLocationManager c;
  public ReportLocationHandler a = new ReportLocationHandler();
  private volatile LocationShareLocationManager.LocationChangeListener d;
  private TencentLocationManager e;
  private TencentLocationListener f;
  private TencentDirectionListener g;
  private double h = 0.0D;
  private LatLng i = null;
  private LocationRoom.RoomKey j;
  
  public static LocationShareLocationManager a()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new LocationShareLocationManager();
        }
      }
      finally {}
    }
    return c;
  }
  
  private void d()
  {
    try
    {
      Object localObject = this.e.getClass().getDeclaredField("c");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(this.e);
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
  
  public void a(int paramInt, String paramString)
  {
    this.a.a(paramString, paramInt, new LocationShareLocationManager.5(this));
  }
  
  public void a(Activity paramActivity, LocationRoom paramLocationRoom)
  {
    if (b()) {
      return;
    }
    this.j = paramLocationRoom.e();
    LocationShareRoomManager.a().a = this.j;
    if (GuardManager.sInstance != null) {
      GuardManager.sInstance.registerCallBack(LocationHandler.a());
    }
    LocationShareLocationManager.1 local1 = new LocationShareLocationManager.1(this, new SoftReference(paramActivity));
    MqqHandler localMqqHandler = ThreadManager.getUIHandler();
    boolean bool = this.a.a(this.j);
    if (bool)
    {
      LocationShareRoomManager.a().a(this.j.a(), this.j.b());
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.LocationShare", 2, "[LocationManager] startLocationUpdate: invoked.  add over time runnable");
      }
      localMqqHandler.postDelayed(local1, 15000L);
    }
    this.e = TencentLocationManager.getInstance(BaseApplication.getContext());
    this.f = new LocationShareLocationManager.2(this, bool, local1, localMqqHandler, paramLocationRoom);
    this.g = new LocationShareLocationManager.3(this);
    int k = this.e.requestLocationUpdates(TencentLocationRequest.create().setInterval(2000L), this.f);
    if (k != 0)
    {
      paramLocationRoom = new StringBuilder();
      paramLocationRoom.append("[LocationManager] requestLocationUpdates: invoked. error: ");
      paramLocationRoom.append(k);
      QLog.e("Q.LocationShare", 1, paramLocationRoom.toString());
      QQToast.makeText(BaseApplication.getContext(), "地图定位系统初始化失败，请稍后重试", 0).show();
      if (paramActivity != null) {
        paramActivity.finish();
      }
    }
    k = this.e.startDirectionUpdates(this.g, Looper.myLooper());
    if (k != 0)
    {
      paramActivity = new StringBuilder();
      paramActivity.append("[LocationManager] startDirectionUpdates: invoked. error: ");
      paramActivity.append(k);
      QLog.e("Q.LocationShare", 1, paramActivity.toString());
      QQToast.makeText(BaseApplication.getContext(), 1, "方向箭头暂不可用", 0).show();
    }
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramRoomKey != null) && (!paramRoomKey.equals(this.j))) {
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
    this.j = null;
    if (GuardManager.sInstance != null) {
      GuardManager.sInstance.unregisterCallback(LocationHandler.a());
    }
    paramRoomKey = this.e;
    if (paramRoomKey != null)
    {
      this.g = null;
      paramRoomKey.removeUpdates(this.f);
      this.e.stopDirectionUpdate();
      d();
      this.e = null;
    }
    this.a.b();
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
      this.d = paramLocationChangeListener;
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
      if (this.d != null) {
        this.d.a(this.i, Double.valueOf(this.h), paramBoolean);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
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
        QLog.d("Q.LocationShare", 2, new Object[] { "removeLocationListener: invoked. listener: ", localStringBuilder.toString(), this.d });
      }
      if (paramLocationChangeListener == this.d) {
        this.d = null;
      }
      return;
    }
    finally {}
  }
  
  public boolean b()
  {
    return this.j != null;
  }
  
  public LatLng c()
  {
    if (this.i == null) {
      QLog.d("Q.LocationShare", 1, "[LocationManager] getSelfLatLng: invoked. location null detected");
    }
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationShareLocationManager
 * JD-Core Version:    0.7.0.1
 */