package com.tencent.mobileqq.highway.utils;

import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import java.util.Map;

public class TransactionReport
{
  public static final String REPORT_TAG_ACTBDHCHANNEL = "actBDHTaskAndroid";
  
  public static void report(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3)
  {
    Object localObject = new HashMap();
    int i = paramInt2;
    if (paramInt2 == -1) {
      i = 0;
    }
    ((HashMap)localObject).put("param_buz_id", String.valueOf(paramInt3));
    ((HashMap)localObject).put("param_FailCode", String.valueOf(i));
    RdmReq localRdmReq = new RdmReq();
    localRdmReq.eventName = "actBDHTaskAndroid";
    localRdmReq.elapse = paramLong1;
    localRdmReq.size = paramLong2;
    if (i == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localRdmReq.isSucceed = bool;
      localRdmReq.params = ((Map)localObject);
      try
      {
        localObject = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), localRdmReq);
        ((ToServiceMsg)localObject).setAppId(paramInt1);
        ((ToServiceMsg)localObject).setTimeout(30000L);
        MsfServiceSdk.get().sendMsg((ToServiceMsg)localObject);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.highway.utils.TransactionReport
 * JD-Core Version:    0.7.0.1
 */