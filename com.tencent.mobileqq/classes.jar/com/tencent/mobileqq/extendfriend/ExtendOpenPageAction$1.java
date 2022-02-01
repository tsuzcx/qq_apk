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
    String str = (String)this.this$0.jdField_a_of_type_JavaUtilHashMap.get("uin");
    NewReportPlugin.a((QBaseActivity)this.this$0.jdField_a_of_type_AndroidContentContext, str, NewReportPlugin.b(str, NewReportPlugin.b(2)), "0", null, this.this$0.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getCurrentAccountUin(), 20005, null, new Bundle());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendOpenPageAction.1
 * JD-Core Version:    0.7.0.1
 */