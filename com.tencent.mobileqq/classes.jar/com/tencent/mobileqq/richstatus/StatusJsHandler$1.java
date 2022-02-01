package com.tencent.mobileqq.richstatus;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import com.tencent.mobileqq.qmethodmonitor.monitor.LocationMonitor;

class StatusJsHandler$1
  implements Runnable
{
  StatusJsHandler$1(StatusJsHandler paramStatusJsHandler, LocationManager paramLocationManager) {}
  
  public void run()
  {
    Object localObject1 = new Criteria();
    ((Criteria)localObject1).setAltitudeRequired(false);
    ((Criteria)localObject1).setBearingRequired(false);
    ((Criteria)localObject1).setCostAllowed(true);
    ((Criteria)localObject1).setPowerRequirement(1);
    label200:
    try
    {
      ((Criteria)localObject1).setAccuracy(1);
      localObject2 = this.a.getBestProvider((Criteria)localObject1, true);
      localObject2 = LocationMonitor.getLastKnownLocation(this.a, (String)localObject2);
      localObject3 = this.this$0;
      localObject4 = this.this$0.g;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((Location)localObject2).getLongitude());
      localStringBuilder.append(",");
      localStringBuilder.append(((Location)localObject2).getLatitude());
      ((StatusJsHandler)localObject3).a((String)localObject4, localStringBuilder.toString());
      return;
    }
    catch (Exception localException2)
    {
      Object localObject2;
      Object localObject3;
      Object localObject4;
      label115:
      break label115;
    }
    try
    {
      ((Criteria)localObject1).setAccuracy(2);
      localObject1 = this.a.getBestProvider((Criteria)localObject1, true);
      localObject1 = LocationMonitor.getLastKnownLocation(this.a, (String)localObject1);
      localObject2 = this.this$0;
      localObject3 = this.this$0.g;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(((Location)localObject1).getLongitude());
      ((StringBuilder)localObject4).append(",");
      ((StringBuilder)localObject4).append(((Location)localObject1).getLatitude());
      ((StatusJsHandler)localObject2).a((String)localObject3, ((StringBuilder)localObject4).toString());
      return;
    }
    catch (Exception localException1)
    {
      break label200;
    }
    localObject1 = this.this$0;
    ((StatusJsHandler)localObject1).a(((StatusJsHandler)localObject1).g, "0, 0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusJsHandler.1
 * JD-Core Version:    0.7.0.1
 */