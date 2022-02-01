package com.tencent.mobileqq.location.net;

import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

abstract class BaseProto<T extends BusinessHandler>
{
  protected final boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = QLog.isColorLevel();
    int i = 0;
    if (bool) {
      QLog.d("BaseProto", 2, new Object[] { "ssoLinkOk: invoked. ", " req: ", paramToServiceMsg, " res: ", paramFromServiceMsg, " data: ", paramObject });
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramObject == null) || (!paramFromServiceMsg.isSuccess())) {
      i = 1;
    }
    return i ^ 0x1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.BaseProto
 * JD-Core Version:    0.7.0.1
 */