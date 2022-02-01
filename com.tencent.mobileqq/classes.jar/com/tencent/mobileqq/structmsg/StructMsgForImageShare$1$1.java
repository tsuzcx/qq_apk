package com.tencent.mobileqq.structmsg;

import ahiu;
import bchy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import odq;

public class StructMsgForImageShare$1$1
  implements Runnable
{
  public StructMsgForImageShare$1$1(bchy parambchy, StructMsgForImageShare paramStructMsgForImageShare, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    long l = NetConnInfoCenter.getServerTime();
    if (ahiu.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
    odq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uin, "0X80055C7", "0X80055C7", 0, 0, Long.toString(l), Long.toString(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.msgId), this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mMsgAction, Integer.toString(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mPromotionType), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForImageShare.1.1
 * JD-Core Version:    0.7.0.1
 */