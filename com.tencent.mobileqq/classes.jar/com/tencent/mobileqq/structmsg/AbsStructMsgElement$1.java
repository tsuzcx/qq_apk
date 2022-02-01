package com.tencent.mobileqq.structmsg;

import aido;
import android.text.TextUtils;
import bdnu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import olh;

public class AbsStructMsgElement$1
  implements Runnable
{
  public AbsStructMsgElement$1(bdnu parambdnu1, bdnu parambdnu2, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    long l = NetConnInfoCenter.getServerTime();
    int j = -1;
    int i = j;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Bdnu.aa)) {}
    try
    {
      i = Integer.parseInt(this.this$0.aa);
      if (aido.a(this.jdField_a_of_type_Bdnu.ab, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        j = 1;
        olh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_Bdnu.ab, "0X80055C7", "0X80055C7", i, 0, Long.toString(l), Long.toString(this.jdField_a_of_type_Bdnu.a), this.jdField_a_of_type_Bdnu.c, Integer.toString(j), false);
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        i = j;
        continue;
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsStructMsgElement.1
 * JD-Core Version:    0.7.0.1
 */