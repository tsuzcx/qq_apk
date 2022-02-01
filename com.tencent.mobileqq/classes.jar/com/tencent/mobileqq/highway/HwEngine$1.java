package com.tencent.mobileqq.highway;

import com.tencent.mobileqq.highway.netprobe.WeakNetCallback;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;

class HwEngine$1
  implements WeakNetCallback
{
  HwEngine$1(HwEngine paramHwEngine) {}
  
  public void onResultOverflow(HashMap<String, String> paramHashMap)
  {
    if (paramHashMap != null)
    {
      if (paramHashMap.isEmpty()) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("probe result upload to dengta, count ");
      ((StringBuilder)localObject).append(paramHashMap.size());
      BdhLogUtil.LogEvent("P", ((StringBuilder)localObject).toString());
      localObject = new RdmReq();
      ((RdmReq)localObject).isMerge = false;
      ((RdmReq)localObject).isRealTime = true;
      ((RdmReq)localObject).isSucceed = true;
      ((RdmReq)localObject).eventName = "actWeaknetProbe";
      ((RdmReq)localObject).elapse = 0L;
      ((RdmReq)localObject).size = 0L;
      ((RdmReq)localObject).params = paramHashMap;
      try
      {
        paramHashMap = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), (RdmReq)localObject);
        paramHashMap.setAppId(HwEngine.appId);
        paramHashMap.setTimeout(30000L);
        MsfServiceSdk.get().sendMsg(paramHashMap);
        return;
      }
      catch (Exception paramHashMap)
      {
        paramHashMap.printStackTrace();
        BdhLogUtil.LogException("P", "upload report has exception ", paramHashMap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.HwEngine.1
 * JD-Core Version:    0.7.0.1
 */