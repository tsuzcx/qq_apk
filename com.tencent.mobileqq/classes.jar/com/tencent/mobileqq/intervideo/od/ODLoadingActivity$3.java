package com.tencent.mobileqq.intervideo.od;

import android.os.Bundle;
import com.tencent.mobileqq.intervideo.IVPluginManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class ODLoadingActivity$3
  implements Runnable
{
  ODLoadingActivity$3(ODLoadingActivity paramODLoadingActivity, Future paramFuture, long paramLong, Bundle paramBundle) {}
  
  public void run()
  {
    try
    {
      ((IVPluginManager)this.a.get(6L, TimeUnit.SECONDS)).enter(this.this$0, this.b, this.c, ODLoadingActivity.c(this.this$0));
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ODLoadingActivity", 2, "getBizPm fail", localException);
      }
      this.this$0.runOnUiThread(new ODLoadingActivity.3.1(this));
      this.this$0.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.od.ODLoadingActivity.3
 * JD-Core Version:    0.7.0.1
 */