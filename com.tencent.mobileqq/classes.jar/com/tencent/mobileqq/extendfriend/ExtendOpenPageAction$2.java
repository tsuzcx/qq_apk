package com.tencent.mobileqq.extendfriend;

import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ExtendOpenPageAction$2
  implements Runnable
{
  ExtendOpenPageAction$2(ExtendOpenPageAction paramExtendOpenPageAction) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("gotoSafetyReport, thread:");
    ((StringBuilder)localObject).append(Thread.currentThread().getName());
    QLog.d("expand.ExtendOpenPageAction", 2, ((StringBuilder)localObject).toString());
    localObject = (String)this.this$0.f.get("uin");
    NewReportPlugin.a((QBaseActivity)this.this$0.b, 1044, (String)localObject, this.this$0.a.getCurrentAccountUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendOpenPageAction.2
 * JD-Core Version:    0.7.0.1
 */