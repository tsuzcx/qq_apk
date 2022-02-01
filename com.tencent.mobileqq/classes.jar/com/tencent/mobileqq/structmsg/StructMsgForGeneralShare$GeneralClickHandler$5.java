package com.tencent.mobileqq.structmsg;

import android.text.TextUtils;
import bdpi;
import bgpy;
import com.tencent.mobileqq.app.QQAppInterface;

public class StructMsgForGeneralShare$GeneralClickHandler$5
  implements Runnable
{
  public StructMsgForGeneralShare$GeneralClickHandler$5(bdpi parambdpi, String paramString, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    String str2 = bgpy.b(this.jdField_a_of_type_JavaLangString, "robot_uin");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "0";
    }
    bgpy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8009FA4", str1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler.5
 * JD-Core Version:    0.7.0.1
 */