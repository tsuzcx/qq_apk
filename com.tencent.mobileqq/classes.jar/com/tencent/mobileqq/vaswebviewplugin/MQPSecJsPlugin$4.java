package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import bhni;
import bhod;
import bhsw;
import com.tencent.mobileqq.widget.QQToast;

class MQPSecJsPlugin$4
  implements Runnable
{
  MQPSecJsPlugin$4(MQPSecJsPlugin paramMQPSecJsPlugin) {}
  
  public void run()
  {
    bhni localbhni = this.this$0.mRuntime.a(this.this$0.mRuntime.a());
    if ((localbhni != null) && ((localbhni instanceof bhsw))) {
      QQToast.a(this.this$0.activity, this.this$0.activity.getString(2131691985), 0).b(((bhsw)localbhni).getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */