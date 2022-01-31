package com.tencent.mobileqq.structmsg;

import aert;
import android.text.TextUtils;
import axup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import nol;

public class AbsStructMsgElement$1
  implements Runnable
{
  public AbsStructMsgElement$1(axup paramaxup1, axup paramaxup2, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    long l = NetConnInfoCenter.getServerTime();
    int j = -1;
    int i = j;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Axup.Q)) {}
    try
    {
      i = Integer.parseInt(this.this$0.Q);
      if (aert.a(this.jdField_a_of_type_Axup.R, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        j = 1;
        nol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_Axup.R, "0X80055C7", "0X80055C7", i, 0, Long.toString(l), Long.toString(this.jdField_a_of_type_Axup.a), this.jdField_a_of_type_Axup.c, Integer.toString(j), false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsStructMsgElement.1
 * JD-Core Version:    0.7.0.1
 */