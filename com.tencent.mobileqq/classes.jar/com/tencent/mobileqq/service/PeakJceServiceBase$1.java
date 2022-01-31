package com.tencent.mobileqq.service;

import alwg;
import android.os.Bundle;
import avyw;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class PeakJceServiceBase$1
  implements Runnable
{
  public PeakJceServiceBase$1(avyw paramavyw, ToServiceMsg paramToServiceMsg, alwg paramalwg, Class paramClass) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d("PeakJceServiceBase", 2, "req cmd: " + (String)localObject);
    }
    if ("MessageSvc.PbSendMsg".equalsIgnoreCase((String)localObject))
    {
      long l1 = this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.extraData.getLong("msg_send_time", 0L);
      if (l1 != 0L)
      {
        long l2 = System.currentTimeMillis();
        this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.extraData.putLong("msg_request_time", l2);
        this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.extraData.putLong("msg_send_to_request_cost", l2 - l1);
      }
    }
    try
    {
      this.this$0.b(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, this.jdField_a_of_type_Alwg, this.jdField_a_of_type_JavaLangClass);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("PeakJceServiceBase", 2, "handleRequest Exception. cmd = " + (String)localObject, localException);
      }
      localObject = new FromServiceMsg(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getUin(), (String)localObject);
      ((FromServiceMsg)localObject).setMsgFail();
      this.this$0.a(false, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, (FromServiceMsg)localObject, localException);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PeakJceServiceBase", 2, "handleRequest OutOfMemoryError. cmd = " + (String)localObject);
      }
      localObject = new FromServiceMsg(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getUin(), (String)localObject);
      ((FromServiceMsg)localObject).setMsgFail();
      this.this$0.a(false, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, (FromServiceMsg)localObject, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.service.PeakJceServiceBase.1
 * JD-Core Version:    0.7.0.1
 */