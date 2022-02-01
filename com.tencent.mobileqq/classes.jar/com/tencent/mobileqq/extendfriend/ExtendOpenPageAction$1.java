package com.tencent.mobileqq.extendfriend;

import android.os.Bundle;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import java.util.HashMap;

class ExtendOpenPageAction$1
  implements Runnable
{
  ExtendOpenPageAction$1(ExtendOpenPageAction paramExtendOpenPageAction) {}
  
  public void run()
  {
    String str = (String)this.this$0.f.get("uin");
    NewReportPlugin.a((QBaseActivity)this.this$0.b, str, NewReportPlugin.b(str, NewReportPlugin.c(2)), "0", null, this.this$0.a.getCurrentAccountUin(), 20005, null, new Bundle());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendOpenPageAction.1
 * JD-Core Version:    0.7.0.1
 */