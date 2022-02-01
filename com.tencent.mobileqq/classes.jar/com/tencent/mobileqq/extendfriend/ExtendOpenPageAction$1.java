package com.tencent.mobileqq.extendfriend;

import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ExtendOpenPageAction$1
  implements Runnable
{
  ExtendOpenPageAction$1(ExtendOpenPageAction paramExtendOpenPageAction) {}
  
  public void run()
  {
    QLog.d("expand.ExtendOpenPageAction", 2, "gotoSafetyReport, thread:" + Thread.currentThread().getName());
    String str = (String)this.this$0.jdField_a_of_type_JavaUtilHashMap.get("uin");
    NewReportPlugin.a((BaseActivity)this.this$0.jdField_a_of_type_AndroidContentContext, 1044, str, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendOpenPageAction.1
 * JD-Core Version:    0.7.0.1
 */