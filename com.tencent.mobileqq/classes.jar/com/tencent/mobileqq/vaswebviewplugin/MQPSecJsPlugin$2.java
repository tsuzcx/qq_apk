package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import bifb;
import bifw;
import bikl;
import bisl;

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
        bifb localbifb = this.this$0.mRuntime.a(this.this$0.mRuntime.a());
        if ((localbifb != null) && ((localbifb instanceof bikl)))
        {
          MQPSecJsPlugin.access$102(this.this$0, new bisl(this.this$0.activity, ((bikl)localbifb).getTitleBarHeight()));
          MQPSecJsPlugin.access$100(this.this$0).setCancelable(false);
          MQPSecJsPlugin.access$100(this.this$0).c(2131694477);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */