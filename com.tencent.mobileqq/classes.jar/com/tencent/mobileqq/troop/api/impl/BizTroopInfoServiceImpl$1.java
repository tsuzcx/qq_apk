package com.tencent.mobileqq.troop.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.ITroopHandlerService;
import com.tencent.mobileqq.troop.troopsurvey.api.ITroopSurveyHandler;
import com.tencent.mobileqq.troop.troopsurvey.handler.TroopSurveyHandler;
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
    Object localObject1 = this.this$0.mMapOfSurveyList.values();
    long l = NetConnInfoCenter.getServerTime();
    if (this.this$0.app == null)
    {
      QLog.e(".troop.survey", 1, "Error: check survey list expire, app is null!");
      return;
    }
    Object localObject2 = (ITroopHandlerService)this.this$0.app.getRuntimeService(ITroopHandlerService.class, "");
    localObject1 = ((Collection)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (oidb_cmd0xb36.RspBody)((Iterator)localObject1).next();
      if ((((oidb_cmd0xb36.RspBody)localObject2).toast.expired.has()) && (((oidb_cmd0xb36.RspBody)localObject2).toast.expired.get() < l))
      {
        String str = String.valueOf(((oidb_cmd0xb36.RspBody)localObject2).group_id.get());
        if (QLog.isColorLevel()) {
          QLog.d(".troop.survey", 2, new Object[] { "group id ", str, "request survey toast, expiredTime: ", Integer.valueOf(((oidb_cmd0xb36.RspBody)localObject2).toast.expired.get()) });
        }
        if ((this.this$0.app instanceof AppInterface)) {
          ((ITroopSurveyHandler)((AppInterface)this.this$0.app).getBusinessHandler(TroopSurveyHandler.class.getName())).a(str, 0);
        }
      }
    }
    BizTroopInfoServiceImpl.access$000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.BizTroopInfoServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */