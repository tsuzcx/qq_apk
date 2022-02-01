package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.ITroopHandlerService;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0xb36.oidb_cmd0xb36.RspBody;
import tencent.im.oidb.cmd0xb36.oidb_cmd0xb36.ToastInfo;

class BizTroopInfoServiceImpl$1
  implements Runnable
{
  BizTroopInfoServiceImpl$1(BizTroopInfoServiceImpl paramBizTroopInfoServiceImpl) {}
  
  public void run()
  {
    Object localObject = this.this$0.mMapOfSurveyList.values();
    long l = NetConnInfoCenter.getServerTime();
    if (this.this$0.app == null)
    {
      QLog.e(".troop.survey", 1, "Error: check survey list expire, app is null!");
      return;
    }
    ITroopHandlerService localITroopHandlerService = (ITroopHandlerService)this.this$0.app.getRuntimeService(ITroopHandlerService.class, "");
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      oidb_cmd0xb36.RspBody localRspBody = (oidb_cmd0xb36.RspBody)((Iterator)localObject).next();
      if ((localRspBody.toast.expired.has()) && (localRspBody.toast.expired.get() < l))
      {
        String str = String.valueOf(localRspBody.group_id.get());
        if (QLog.isColorLevel()) {
          QLog.d(".troop.survey", 2, new Object[] { "group id ", str, "request survey toast, expiredTime: ", Integer.valueOf(localRspBody.toast.expired.get()) });
        }
        localITroopHandlerService.send_oidb_0xb36_1(str, 0);
      }
    }
    BizTroopInfoServiceImpl.access$000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.BizTroopInfoServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */