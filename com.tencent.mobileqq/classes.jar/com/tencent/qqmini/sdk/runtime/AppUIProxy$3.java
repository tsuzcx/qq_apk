package com.tencent.qqmini.sdk.runtime;

import android.app.Activity;

class AppUIProxy$3
  implements Runnable
{
  AppUIProxy$3(AppUIProxy paramAppUIProxy) {}
  
  public void run()
  {
    if (this.this$0.mActivity != null) {
      this.this$0.mActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppUIProxy.3
 * JD-Core Version:    0.7.0.1
 */