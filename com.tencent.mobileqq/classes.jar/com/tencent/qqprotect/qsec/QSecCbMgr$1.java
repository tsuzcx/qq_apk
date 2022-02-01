package com.tencent.qqprotect.qsec;

import com.tencent.ims.QSecControlBitsQuery.QSecCbResp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

class QSecCbMgr$1
  implements SecSvcHandlerHelper.ISecSvcRespListener
{
  QSecCbMgr$1(QSecCbMgr paramQSecCbMgr) {}
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.isSuccess()) {
      if (paramObject == null) {
        return;
      }
    }
    int i;
    do
    {
      try
      {
        localQSecCbResp = new QSecControlBitsQuery.QSecCbResp();
        localQSecCbResp.mergeFrom((byte[])paramObject);
        int j = -1;
        i = j;
        if (localQSecCbResp.u32_status == null) {
          continue;
        }
        i = j;
        if (!localQSecCbResp.u32_status.has()) {
          continue;
        }
        i = localQSecCbResp.u32_status.get();
      }
      catch (Exception paramToServiceMsg)
      {
        QSecControlBitsQuery.QSecCbResp localQSecCbResp;
        paramToServiceMsg.printStackTrace();
      }
      if ((localQSecCbResp.u32_time_interval != null) && (localQSecCbResp.u32_time_interval.has())) {
        localQSecCbResp.u32_time_interval.get();
      }
      paramFromServiceMsg = null;
      paramToServiceMsg = paramFromServiceMsg;
      if (localQSecCbResp.str_cbstr != null)
      {
        paramToServiceMsg = paramFromServiceMsg;
        if (localQSecCbResp.str_cbstr.has()) {
          paramToServiceMsg = localQSecCbResp.str_cbstr.get();
        }
      }
      if (paramToServiceMsg != null)
      {
        if (paramToServiceMsg.equals("")) {
          return;
        }
        QSecCbMgr.a(this.a, paramToServiceMsg);
        return;
      }
      return;
      return;
    } while (i == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecCbMgr.1
 * JD-Core Version:    0.7.0.1
 */