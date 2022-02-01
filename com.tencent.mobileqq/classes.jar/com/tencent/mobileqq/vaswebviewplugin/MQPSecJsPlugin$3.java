package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.widget.QQProgressDialog;

class MQPSecJsPlugin$3
  implements Runnable
{
  MQPSecJsPlugin$3(MQPSecJsPlugin paramMQPSecJsPlugin) {}
  
  public void run()
  {
    try
    {
      if ((MQPSecJsPlugin.access$100(this.this$0) != null) && (MQPSecJsPlugin.access$100(this.this$0).isShowing()))
      {
        MQPSecJsPlugin.access$100(this.this$0).dismiss();
        MQPSecJsPlugin.access$100(this.this$0).cancel();
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    MQPSecJsPlugin.access$102(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */