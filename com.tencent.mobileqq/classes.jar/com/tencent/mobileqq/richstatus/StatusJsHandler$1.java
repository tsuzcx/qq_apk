package com.tencent.mobileqq.richstatus;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;

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
    try
    {
      ((Criteria)localObject1).setAccuracy(1);
      Object localObject2 = this.a.getBestProvider((Criteria)localObject1, true);
      localObject2 = this.a.getLastKnownLocation((String)localObject2);
      this.this$0.a(this.this$0.b, ((Location)localObject2).getLongitude() + "," + ((Location)localObject2).getLatitude());
      return;
    }
    catch (Exception localException2)
    {
      try
      {
        ((Criteria)localObject1).setAccuracy(2);
        localObject1 = this.a.getBestProvider((Criteria)localObject1, true);
        localObject1 = this.a.getLastKnownLocation((String)localObject1);
        this.this$0.a(this.this$0.b, ((Location)localObject1).getLongitude() + "," + ((Location)localObject1).getLatitude());
        return;
      }
      catch (Exception localException1)
      {
        this.this$0.a(this.this$0.b, "0, 0");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusJsHandler.1
 * JD-Core Version:    0.7.0.1
 */