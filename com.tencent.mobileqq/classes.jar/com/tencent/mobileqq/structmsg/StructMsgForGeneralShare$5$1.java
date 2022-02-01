package com.tencent.mobileqq.structmsg;

import aido;
import bdom;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import olh;

public class StructMsgForGeneralShare$5$1
  implements Runnable
{
  public StructMsgForGeneralShare$5$1(bdom parambdom, StructMsgForGeneralShare paramStructMsgForGeneralShare, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    long l = NetConnInfoCenter.getServerTime();
    if (aido.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
    for (int i = 1;; i = 0)
    {
      olh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.uin, "0X80055C7", "0X80055C7", 0, 0, Long.toString(l), Long.toString(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.msgId), this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.mMsgAction, Integer.toString(i), false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.5.1
 * JD-Core Version:    0.7.0.1
 */