package com.tencent.qqmini.sdk.runtime;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class BaseUIProxy$1
  implements Runnable
{
  BaseUIProxy$1(BaseUIProxy paramBaseUIProxy, Bundle paramBundle) {}
  
  public void run()
  {
    try
    {
      ResultReceiver localResultReceiver = (ResultReceiver)this.val$bundle.getParcelable("receiver");
      if (localResultReceiver != null)
      {
        QMLog.i("minisdk-start_UIProxy", "notify resultReceiver.");
        localResultReceiver.send(0, new Bundle());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start_UIProxy", "exception when notify resultReceiver.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.BaseUIProxy.1
 * JD-Core Version:    0.7.0.1
 */