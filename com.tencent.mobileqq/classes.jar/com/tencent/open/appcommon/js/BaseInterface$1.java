package com.tencent.open.appcommon.js;

import com.tencent.smtt.sdk.WebView;
import java.util.List;
import java.util.TimerTask;

class BaseInterface$1
  extends TimerTask
{
  BaseInterface$1(BaseInterface paramBaseInterface, WebView paramWebView, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.optLef <= 0)
    {
      cancel();
      this.this$0.firstIn = true;
    }
    if (this.this$0.batchCallbackQueue.size() > 0) {
      this.this$0.batchCallback(this.jdField_a_of_type_ComTencentSmttSdkWebView, this.jdField_a_of_type_Long);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.js.BaseInterface.1
 * JD-Core Version:    0.7.0.1
 */