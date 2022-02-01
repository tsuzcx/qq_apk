package com.tencent.mobileqq.troop.onlinemember.handler;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberService;
import com.tencent.mobileqq.troop.onlinemember.api.TroopOnlineMemberObserver;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a.ReqBody;

class TroopOnlineMemberHandler$3
  implements Runnable
{
  TroopOnlineMemberHandler$3(TroopOnlineMemberHandler paramTroopOnlineMemberHandler, String paramString) {}
  
  public void run()
  {
    Object localObject1 = (ITroopOnlineMemberService)TroopOnlineMemberHandler.c(this.this$0).getRuntimeService(ITroopOnlineMemberService.class, "");
    if (NetConnInfoCenter.getServerTime() < ((ITroopOnlineMemberService)localObject1).getAllGameOnlineNextReqTime(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopOnlineMemberHandler", 2, "getAllGameOnlineMemberList, too frequency");
      }
      localObject1 = ((ITroopOnlineMemberService)localObject1).getAllGameOnlineList(this.a);
      this.this$0.notifyUI(TroopOnlineMemberObserver.e, true, new Object[] { this.a, localObject1 });
      return;
    }
    try
    {
      localObject2 = (ITroopInfoService)TroopOnlineMemberHandler.d(this.this$0).getRuntimeService(ITroopInfoService.class, "");
      localObject1 = new oidb_0xa2a.ReqBody();
      ((oidb_0xa2a.ReqBody)localObject1).group_id.set(Long.valueOf(this.a).longValue());
      ((oidb_0xa2a.ReqBody)localObject1).is_private.set(((ITroopInfoService)localObject2).isQidianPrivateTroop(this.a));
      localObject2 = ((ITroopInfoService)localObject2).getTroopInfo(this.a);
      if (localObject2 != null)
      {
        ((oidb_0xa2a.ReqBody)localObject1).hok_appid.set((int)((TroopInfo)localObject2).hlGuildAppid);
        ((oidb_0xa2a.ReqBody)localObject1).hok_type.set((int)((TroopInfo)localObject2).hlGuildSubType);
      }
      localObject1 = this.this$0.makeOIDBPkg("OidbSvc.0xa2a_6", 2602, 6, ((oidb_0xa2a.ReqBody)localObject1).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putString("troopUin", this.a);
      this.this$0.sendPbReq((ToServiceMsg)localObject1);
      return;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getAllGameOnlineMemberList, e=");
      ((StringBuilder)localObject2).append(localException.toString());
      QLog.i("TroopOnlineMemberHandler", 1, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.onlinemember.handler.TroopOnlineMemberHandler.3
 * JD-Core Version:    0.7.0.1
 */