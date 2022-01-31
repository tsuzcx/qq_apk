package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import bccw;
import bcdp;
import bcii;
import bcqf;

class MQPSecJsPlugin$2
  implements Runnable
{
  MQPSecJsPlugin$2(MQPSecJsPlugin paramMQPSecJsPlugin) {}
  
  public void run()
  {
    try
    {
      if ((MQPSecJsPlugin.access$100(this.this$0) == null) && (!this.this$0.activity.isFinishing()))
      {
        bccw localbccw = this.this$0.mRuntime.a(this.this$0.mRuntime.a());
        if ((localbccw != null) && ((localbccw instanceof bcii)))
        {
          MQPSecJsPlugin.access$102(this.this$0, new bcqf(this.this$0.activity, ((bcii)localbccw).b()));
          MQPSecJsPlugin.access$100(this.this$0).setCancelable(false);
          MQPSecJsPlugin.access$100(this.this$0).c(2131694931);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
    if ((MQPSecJsPlugin.access$100(this.this$0) != null) && (!MQPSecJsPlugin.access$100(this.this$0).isShowing())) {
      MQPSecJsPlugin.access$100(this.this$0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */