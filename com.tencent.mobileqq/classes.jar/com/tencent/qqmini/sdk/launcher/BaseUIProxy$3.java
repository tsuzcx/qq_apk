package com.tencent.qqmini.sdk.launcher;

import android.app.Activity;
import bepy;

public class BaseUIProxy$3
  implements Runnable
{
  public BaseUIProxy$3(bepy parambepy) {}
  
  public void run()
  {
    if (this.this$0.mActivity != null) {
      this.this$0.mActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.BaseUIProxy.3
 * JD-Core Version:    0.7.0.1
 */