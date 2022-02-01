package com.tencent.mobileqq.conditionsearch;

import android.os.Build.VERSION;
import apqo;

public class LocationSelectActivity$2
  implements Runnable
{
  LocationSelectActivity$2(LocationSelectActivity paramLocationSelectActivity) {}
  
  public void run()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.this$0.requestPermissions(new apqo(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      return;
    }
    LocationSelectActivity.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.LocationSelectActivity.2
 * JD-Core Version:    0.7.0.1
 */