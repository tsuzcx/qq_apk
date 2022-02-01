package com.tencent.mobileqq.service;

import android.os.Bundle;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

class MobileQQServiceBase$1
  implements Runnable
{
  MobileQQServiceBase$1(MobileQQServiceBase paramMobileQQServiceBase, ToServiceMsg paramToServiceMsg) {}
  
  public void run()
  {
    localObject = this.val$request.getServiceCmd();
    StringBuilder localStringBuilder1;
    if (QLog.isColorLevel())
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("req cmd: ");
      localStringBuilder1.append((String)localObject);
      QLog.d("MobileQQServiceBase", 2, localStringBuilder1.toString());
    }
    if ("MessageSvc.PbSendMsg".equalsIgnoreCase((String)localObject))
    {
      long l1 = this.val$request.extraData.getLong("msg_send_time", 0L);
      if (l1 != 0L)
      {
        long l2 = System.currentTimeMillis();
        this.val$request.extraData.putLong("msg_request_time", l2);
        this.val$request.extraData.putLong("msg_send_to_request_cost", l2 - l1);
      }
    }
    try
    {
      this.this$0.realHandleRequest(this.val$request, this.this$0.getServlet());
      return;
    }
    catch (Exception localException)
    {
      if (!QLog.isColorLevel()) {
        break label259;
      }
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("handleRequest Exception. cmd = ");
      localStringBuilder2.append((String)localObject);
      QLog.e("MobileQQServiceBase", 2, localStringBuilder2.toString(), localException);
      localObject = new FromServiceMsg(this.val$request.getUin(), (String)localObject);
      ((FromServiceMsg)localObject).setMsgFail();
      this.this$0.handleResponse(false, this.val$request, (FromServiceMsg)localObject, localException);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label132:
      break label132;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("handleRequest OutOfMemoryError. cmd = ");
      localStringBuilder1.append((String)localObject);
      QLog.d("MobileQQServiceBase", 2, localStringBuilder1.toString());
    }
    localObject = new FromServiceMsg(this.val$request.getUin(), (String)localObject);
    ((FromServiceMsg)localObject).setMsgFail();
    this.this$0.handleResponse(false, this.val$request, (FromServiceMsg)localObject, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.MobileQQServiceBase.1
 * JD-Core Version:    0.7.0.1
 */