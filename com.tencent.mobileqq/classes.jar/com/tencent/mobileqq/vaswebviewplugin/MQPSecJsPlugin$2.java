package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import bazo;
import bbac;
import bbeu;
import bbms;

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
        bazo localbazo = this.this$0.mRuntime.a(this.this$0.mRuntime.a());
        if ((localbazo != null) && ((localbazo instanceof bbeu)))
        {
          MQPSecJsPlugin.access$102(this.this$0, new bbms(this.this$0.activity, ((bbeu)localbazo).b()));
          MQPSecJsPlugin.access$100(this.this$0).setCancelable(false);
          MQPSecJsPlugin.access$100(this.this$0).c(2131629253);
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