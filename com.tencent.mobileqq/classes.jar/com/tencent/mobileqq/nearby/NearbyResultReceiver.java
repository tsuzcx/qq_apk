package com.tencent.mobileqq.nearby;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

public class NearbyResultReceiver
  extends ResultReceiver
{
  NearbyFakeActivity a;
  
  public NearbyResultReceiver(Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void a(NearbyFakeActivity paramNearbyFakeActivity)
  {
    this.a = paramNearbyFakeActivity;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if (paramInt == 0)
    {
      NearbyFakeActivity localNearbyFakeActivity = this.a;
      if (localNearbyFakeActivity != null) {
        localNearbyFakeActivity.a();
      }
    }
    super.onReceiveResult(paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyResultReceiver
 * JD-Core Version:    0.7.0.1
 */