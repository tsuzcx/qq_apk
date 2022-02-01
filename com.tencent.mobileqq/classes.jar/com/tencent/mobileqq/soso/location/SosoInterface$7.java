package com.tencent.mobileqq.soso.location;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;

final class SosoInterface$7
  implements Runnable
{
  SosoInterface$7(SosoInterfaceOnLocationListener paramSosoInterfaceOnLocationListener) {}
  
  public void run()
  {
    Object localObject = SosoInterface.getCanUsedLbsInfoCache(this.val$lis.maxCacheInterval, this.val$lis.goonListener, this.val$lis.level, this.val$lis.reqLocation);
    if (localObject != null)
    {
      if (this.val$lis.uiThread) {
        SosoInterface.access$1900(this.val$lis, 0, (SosoLbsInfo)localObject);
      } else {
        this.val$lis.onLocationFinish(0, (SosoLbsInfo)localObject);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startLocation() lis=");
        ((StringBuilder)localObject).append(this.val$lis.tag);
        ((StringBuilder)localObject).append(" use cache and callback now");
        QLog.d("SOSO.LBS", 2, ((StringBuilder)localObject).toString());
      }
      SosoInterface.access$2000(true, this.val$lis.reqLocation, 0L, 0, this.val$lis.tag, "ERROR_OK", this.val$lis.askGPS, this.val$lis.level, true);
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startLocation() reqLoc=");
      localStringBuilder.append(this.val$lis.reqLocation);
      localStringBuilder.append(" askGPS=");
      localStringBuilder.append(this.val$lis.askGPS);
      localStringBuilder.append(" level=");
      localStringBuilder.append(this.val$lis.level);
      localStringBuilder.append(" caller=");
      localStringBuilder.append(this.val$lis.tag);
      localStringBuilder.append(" ui=");
      localStringBuilder.append(this.val$lis.uiThread);
      localStringBuilder.append(" goon=");
      localStringBuilder.append(this.val$lis.goonListener);
      if (SosoInterface.access$2100().get() == 0) {
        localObject = " do startLocation";
      } else {
        localObject = " waitting...";
      }
      localStringBuilder.append((String)localObject);
      QLog.d("SOSO.LBS", 2, localStringBuilder.toString());
    }
    SosoInterface.access$2200(this.val$lis);
    if (SosoInterface.access$2100().get() == 0)
    {
      if (this.val$lis == SosoInterface.access$2300()) {
        SosoInterface.access$2100().set(1);
      } else {
        SosoInterface.access$2100().set(2);
      }
      this.val$lis.sTime = SystemClock.elapsedRealtime();
      localObject = TencentLocationRequest.create();
      ((TencentLocationRequest)localObject).setInterval(SosoInterface.sContinuousLocationInterval);
      ((TencentLocationRequest)localObject).setRequestLevel(this.val$lis.level);
      ((TencentLocationRequest)localObject).setAllowCache(true);
      ((TencentLocationRequest)localObject).setAllowGPS(this.val$lis.askGPS);
      ((TencentLocationRequest)localObject).setCheckInterval(30000L);
      TencentExtraKeys.setRequestRawData((TencentLocationRequest)localObject, this.val$lis.reqLocation ^ true);
      ((TencentLocationRequest)localObject).getExtras().putInt("qq_level", this.val$lis.level);
      ((TencentLocationRequest)localObject).getExtras().putBoolean("qq_reqLocation", this.val$lis.reqLocation);
      ((TencentLocationRequest)localObject).getExtras().putString("qq_caller", this.val$lis.tag);
      ((TencentLocationRequest)localObject).getExtras().putBoolean("qq_goonListener", this.val$lis.goonListener);
      SosoInterface.access$902(0);
      SosoInterface.access$802(SystemClock.elapsedRealtime());
      SosoInterface.access$1102(0);
      this.val$lis.requesting = true;
      if (SosoInterface.access$2400() == null) {
        SosoInterface.access$2402(TencentLocationManager.getInstance(MobileQQ.sMobileQQ.getApplicationContext()));
      }
      if (SosoInterface.access$200().hasMessages(1001)) {
        SosoInterface.access$200().removeMessages(1001);
      }
      SosoInterface.access$200().sendEmptyMessageDelayed(1001, 35000L);
      SosoInterface.access$2502(0);
      int i = SosoInterface.access$2400().requestLocationUpdates((TencentLocationRequest)localObject, SosoInterface.access$2600(), ThreadManager.getSubThreadLooper());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("location manager requestLocationUpdates result is: ");
      ((StringBuilder)localObject).append(i);
      QLog.i("SOSO.LBS", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SOSO.LBS", 2, "status != REQ_STOP");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soso.location.SosoInterface.7
 * JD-Core Version:    0.7.0.1
 */