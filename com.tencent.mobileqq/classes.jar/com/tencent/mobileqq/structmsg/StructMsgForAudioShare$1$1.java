package com.tencent.mobileqq.structmsg;

import agti;
import azve;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import nrt;

public class StructMsgForAudioShare$1$1
  implements Runnable
{
  public StructMsgForAudioShare$1$1(azve paramazve, StructMsgForAudioShare paramStructMsgForAudioShare, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    long l = NetConnInfoCenter.getServerTime();
    if (agti.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForAudioShare.uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
    for (int i = 1;; i = 0)
    {
      nrt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForAudioShare.uin, "0X80055C7", "0X80055C7", 0, 0, Long.toString(l), Long.toString(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForAudioShare.msgId), this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForAudioShare.mMsgAction, Integer.toString(i), false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForAudioShare.1.1
 * JD-Core Version:    0.7.0.1
 */