package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import bifb;
import bifw;
import bikl;
import com.tencent.mobileqq.widget.QQToast;

class MQPSecJsPlugin$4
  implements Runnable
{
  MQPSecJsPlugin$4(MQPSecJsPlugin paramMQPSecJsPlugin) {}
  
  public void run()
  {
    bifb localbifb = this.this$0.mRuntime.a(this.this$0.mRuntime.a());
    if ((localbifb != null) && ((localbifb instanceof bikl))) {
      QQToast.a(this.this$0.activity, this.this$0.activity.getString(2131692125), 0).b(((bikl)localbifb).getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */