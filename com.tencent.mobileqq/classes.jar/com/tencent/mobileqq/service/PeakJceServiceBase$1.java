package com.tencent.mobileqq.service;

import android.os.Bundle;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

class PeakJceServiceBase$1
  implements Runnable
{
  PeakJceServiceBase$1(PeakJceServiceBase paramPeakJceServiceBase, ToServiceMsg paramToServiceMsg, Class paramClass) {}
  
  public void run()
  {
    localObject = this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getServiceCmd();
    StringBuilder localStringBuilder1;
    if (QLog.isColorLevel())
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("req cmd: ");
      localStringBuilder1.append((String)localObject);
      QLog.d("PeakJceServiceBase", 2, localStringBuilder1.toString());
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
      this.this$0.b(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, this.jdField_a_of_type_JavaLangClass);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (!QLog.isColorLevel()) {
        break label261;
      }
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("handleRequest Exception. cmd = ");
      localStringBuilder2.append((String)localObject);
      QLog.e("PeakJceServiceBase", 2, localStringBuilder2.toString(), localException);
      localObject = new FromServiceMsg(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getUin(), (String)localObject);
      ((FromServiceMsg)localObject).setMsgFail();
      this.this$0.a(false, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, (FromServiceMsg)localObject, localException);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label129:
      break label129;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("handleRequest OutOfMemoryError. cmd = ");
      localStringBuilder1.append((String)localObject);
      QLog.d("PeakJceServiceBase", 2, localStringBuilder1.toString());
    }
    localObject = new FromServiceMsg(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getUin(), (String)localObject);
    ((FromServiceMsg)localObject).setMsgFail();
    this.this$0.a(false, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, (FromServiceMsg)localObject, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.PeakJceServiceBase.1
 * JD-Core Version:    0.7.0.1
 */