package com.tencent.mobileqq.onlinestatus.location;

import android.os.Looper;
import com.tencent.map.geolocation.TencentDirectionListener;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.lang.reflect.Field;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class LocationHandler
{
  public static LatLng a;
  private volatile LocationHandler.LocationChangeListener b;
  private TencentLocationManager c;
  private TencentLocationListener d;
  private TencentDirectionListener e;
  private double f = 0.0D;
  private TencentLocation g = null;
  
  private void a(boolean paramBoolean)
  {
    try
    {
      if (this.b != null)
      {
        Object localObject3 = new LatLng(this.g.getLatitude(), this.g.getLongitude());
        Object localObject1 = localObject3;
        if (QLog.isColorLevel())
        {
          localObject1 = localObject3;
          if (a != null) {
            localObject1 = a;
          }
        }
        localObject1 = new Location((LatLng)localObject1, this.g.getProvider(), this.g.getAccuracy(), this.g.getTime());
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("[status][loc] notifyLocationUpdate location: ");
          ((StringBuilder)localObject3).append(localObject1);
          QLog.e("LocationHandler", 2, ((StringBuilder)localObject3).toString());
        }
        this.b.a((Location)localObject1, Double.valueOf(this.f), paramBoolean);
      }
      return;
    }
    finally {}
  }
  
  private void b()
  {
    try
    {
      Object localObject = this.c;
      if (localObject == null)
      {
        QLog.e("LocationHandler", 1, "mLocationManager is null");
        return;
      }
      localObject = this.c.getClass().getDeclaredField("c");
      if (localObject == null)
      {
        QLog.e("LocationHandler", 1, "field c is null");
        return;
      }
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(this.c);
      if (localObject == null)
      {
        QLog.e("LocationHandler", 1, "cObject is null");
        return;
      }
      Field localField = localObject.getClass().getDeclaredField("b");
      if (localField == null)
      {
        QLog.e("LocationHandler", 1, "field b is null");
        return;
      }
      localField.setAccessible(true);
      localObject = localField.get(localObject);
      if (localObject == null)
      {
        QLog.e("LocationHandler", 1, "bObject is null");
        return;
      }
      localField = localObject.getClass().getDeclaredField("g");
      if (localField == null)
      {
        QLog.e("LocationHandler", 1, "field g is null");
        return;
      }
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
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "stopLocationUpdate: invoked. ");
    }
    TencentLocationManager localTencentLocationManager = this.c;
    if (localTencentLocationManager != null)
    {
      this.e = null;
      localTencentLocationManager.removeUpdates(this.d);
      this.c.stopDirectionUpdate();
      b();
    }
  }
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = new LocationHandler.1(this, paramBoolean1);
    MqqHandler localMqqHandler = ThreadManager.getUIHandler();
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "[LocationManager] startLocationUpdate: invoked.  add over time runnable");
    }
    if (paramBoolean1) {
      localMqqHandler.postDelayed((Runnable)localObject, 15000L);
    }
    this.c = TencentLocationManager.getInstance(MobileQQ.sMobileQQ);
    this.d = new LocationHandler.2(this, (Runnable)localObject, localMqqHandler);
    this.e = new LocationHandler.3(this);
    int i = this.c.requestLocationUpdates(TencentLocationRequest.create().setInterval(paramLong), this.d);
    if (i != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[LocationManager] requestLocationUpdates: invoked. error: ");
      ((StringBuilder)localObject).append(i);
      QLog.e("LocationHandler", 1, ((StringBuilder)localObject).toString());
      QQToast.makeText(MobileQQ.sMobileQQ, "地图定位系统初始化失败，请稍后重试", 0).show();
      if (this.b != null) {
        this.b.b(i);
      }
    }
    if (paramBoolean2)
    {
      i = this.c.startDirectionUpdates(this.e, Looper.myLooper());
      if (i != 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[LocationManager] startDirectionUpdates: invoked. error: ");
        ((StringBuilder)localObject).append(i);
        QLog.e("LocationHandler", 1, ((StringBuilder)localObject).toString());
        QQToast.makeText(MobileQQ.sMobileQQ, 1, "方向箭头暂不可用", 0).show();
      }
    }
  }
  
  public void a(LocationHandler.LocationChangeListener paramLocationChangeListener)
  {
    try
    {
      this.b = paramLocationChangeListener;
      return;
    }
    finally
    {
      paramLocationChangeListener = finally;
      throw paramLocationChangeListener;
    }
  }
  
  public void b(LocationHandler.LocationChangeListener paramLocationChangeListener)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("removeLocationListener: invoked. listener: ");
        localStringBuilder.append(paramLocationChangeListener);
        localStringBuilder.append(" mLocationListener: ");
        localStringBuilder.append(this.b);
        QLog.d("LocationHandler", 2, localStringBuilder.toString());
      }
      if (paramLocationChangeListener == this.b) {
        this.b = null;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.location.LocationHandler
 * JD-Core Version:    0.7.0.1
 */