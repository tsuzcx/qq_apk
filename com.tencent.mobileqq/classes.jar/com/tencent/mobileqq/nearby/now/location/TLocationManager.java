package com.tencent.mobileqq.nearby.now.location;

import aetd;
import aetf;
import aetg;
import aeti;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.model.LocationInfo;
import com.tencent.util.LogUtil;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class TLocationManager
  implements Handler.Callback
{
  private volatile long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(this);
  private TencentLocationManager jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager;
  public String a;
  private LinkedBlockingQueue jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue = new LinkedBlockingQueue();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public String b = "";
  public String c = "";
  
  public TLocationManager(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager = TencentLocationManager.getInstance(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(null);
  }
  
  private void a(LocationListener paramLocationListener)
  {
    LogUtil.i("TLocationManager", "into get location");
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    Object localObject;
    if ((this.jdField_a_of_type_Long + 3600000L >= System.currentTimeMillis()) && (this.b != null) && (this.jdField_a_of_type_JavaLangString != null))
    {
      LogUtil.i("TLocationManager", "2 use cache");
      localObject = new LocationInfo();
      ((LocationInfo)localObject).city = this.c;
      ((LocationInfo)localObject).lat = this.b;
      ((LocationInfo)localObject).lng = this.jdField_a_of_type_JavaLangString;
      if (paramLocationListener != null) {
        paramLocationListener.a((LocationInfo)localObject);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
    TencentLocationRequest localTencentLocationRequest;
    do
    {
      return;
      localObject = new aeti(this, paramLocationListener);
      if (Build.VERSION.SDK_INT >= 23) {}
      localTencentLocationRequest = TencentLocationRequest.create();
      localTencentLocationRequest.setRequestLevel(3);
      ((aeti)localObject).a();
    } while ((this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager != null) && (this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.requestLocationUpdates(localTencentLocationRequest, (TencentLocationListener)localObject) == 0));
    LogUtil.i("TLocationManager", "getLocation: fail, cause sdk is null, or request return is not 0");
    ((aeti)localObject).b();
    a((aeti)localObject, paramLocationListener);
  }
  
  private void a(@Nullable LocationListener paramLocationListener, LocationInfo paramLocationInfo)
  {
    LogUtil.i("TLocationManager", "notifyLocationSuccess()");
    if (paramLocationListener != null)
    {
      LogUtil.i("TLocationManager", "notifyLocationSuccess() not null");
      ThreadManager.getUIHandler().post(new aetf(this, paramLocationInfo, paramLocationListener));
    }
  }
  
  private void b(@Nullable LocationListener paramLocationListener, LocationInfo paramLocationInfo)
  {
    Log.i("TLocationManager", "notifyLocationFail()");
    if (paramLocationListener != null)
    {
      Log.i("TLocationManager", "notifyLocationFail: not null");
      ThreadManager.getUIHandler().post(new aetg(this, paramLocationListener, paramLocationInfo));
    }
  }
  
  public LocationInfo a(LocationListener paramLocationListener)
  {
    LogUtil.i("TLocationManager", "into sendLocationRequest");
    if ((this.jdField_a_of_type_Long + 3600000L >= System.currentTimeMillis()) && (this.b != null) && (this.jdField_a_of_type_JavaLangString != null))
    {
      LogUtil.i("TLocationManager", "1 use cache");
      LocationInfo localLocationInfo = new LocationInfo();
      localLocationInfo.city = this.c;
      localLocationInfo.lat = this.b;
      localLocationInfo.lng = this.jdField_a_of_type_JavaLangString;
      if (paramLocationListener != null) {
        paramLocationListener.a(localLocationInfo);
      }
      return localLocationInfo;
    }
    if (paramLocationListener != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.offer(paramLocationListener);
      LogUtil.i("TLocationManager", "3 isRun = " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      }
    }
    for (;;)
    {
      return null;
      LogUtil.i("TLocationManager", "locationListener is null");
    }
  }
  
  public void a(aeti paramaeti, LocationListener paramLocationListener)
  {
    LogUtil.i("TLocationManager", "into locationFail");
    if (this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager != null) {
      this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.removeUpdates(paramaeti);
    }
    paramaeti = new LocationInfo();
    paramaeti.lng = "";
    paramaeti.lat = "";
    paramaeti.city = "";
    b(paramLocationListener, paramaeti);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void a(TencentLocation paramTencentLocation, aeti paramaeti, @Nullable LocationListener paramLocationListener)
  {
    LogUtil.i("TLocationManager", "into locationSuccess");
    if (this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager != null) {
      this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.removeUpdates(paramaeti);
    }
    paramaeti = paramTencentLocation.getProvince();
    String str = paramTencentLocation.getCity();
    double d1 = paramTencentLocation.getLongitude();
    double d2 = paramTencentLocation.getLatitude();
    LogUtil.i("TLocationManager", "locationSucc city is " + str);
    if (TextUtils.isEmpty(str)) {
      if (TextUtils.isEmpty(paramaeti)) {}
    }
    for (paramTencentLocation = paramaeti;; paramTencentLocation = str)
    {
      paramaeti = new LocationInfo();
      paramaeti.lng = String.valueOf(d1);
      paramaeti.lat = String.valueOf(d2);
      paramaeti.city = paramTencentLocation;
      a(paramLocationListener, paramaeti);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.c = paramaeti.getCity();
      this.jdField_a_of_type_JavaLangString = paramaeti.getLng();
      this.b = paramaeti.getLat();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
      LogUtil.i("TLocationManager", "locationSuccess: city & prov is null!");
      LocationHelper.a(d2, d1, new aetd(this, d1, d2, paramLocationListener));
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      paramMessage = (LocationListener)this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.poll();
      if (paramMessage != null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        LogUtil.i("TLocationManager", "1 isRun = " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
        a(paramMessage);
        return false;
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      LogUtil.i("TLocationManager", "2 isRun = " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      return false;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.location.TLocationManager
 * JD-Core Version:    0.7.0.1
 */