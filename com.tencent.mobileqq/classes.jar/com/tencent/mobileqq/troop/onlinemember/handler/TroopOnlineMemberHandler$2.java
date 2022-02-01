package com.tencent.mobileqq.troop.onlinemember.handler;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberService;
import com.tencent.mobileqq.troop.onlinemember.api.TroopOnlineMemberObserver;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a.ReqBody;

class TroopOnlineMemberHandler$2
  implements Runnable
{
  TroopOnlineMemberHandler$2(TroopOnlineMemberHandler paramTroopOnlineMemberHandler, String paramString) {}
  
  public void run()
  {
    Object localObject2 = (ITroopOnlineMemberService)TroopOnlineMemberHandler.a(this.this$0).getRuntimeService(ITroopOnlineMemberService.class, "");
    Object localObject1;
    if ((((ITroopOnlineMemberService)localObject2).getRequestListServiceType(this.a) != 3) && (NetConnInfoCenter.getServerTime() < ((ITroopOnlineMemberService)localObject2).getAllNextReqTime(this.a)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopOnlineMemberHandler", 2, "getAllOnlineMemberList, too frequency");
      }
      localObject1 = ((ITroopOnlineMemberService)localObject2).getAllOnlineList(this.a);
      this.this$0.notifyUI(TroopOnlineMemberObserver.d, true, new Object[] { this.a, localObject1 });
      return;
    }
    for (;;)
    {
      try
      {
        localObject1 = (ITroopInfoService)TroopOnlineMemberHandler.b(this.this$0).getRuntimeService(ITroopInfoService.class, "");
        if (((ITroopOnlineMemberService)localObject2).getRequestListServiceType(this.a) == 3)
        {
          i = 4;
          localObject2 = new oidb_0xa2a.ReqBody();
          ((oidb_0xa2a.ReqBody)localObject2).group_id.set(Long.valueOf(this.a).longValue());
          ((oidb_0xa2a.ReqBody)localObject2).is_private.set(((ITroopInfoService)localObject1).isQidianPrivateTroop(this.a));
          localObject1 = this.this$0.makeOIDBPkg("OidbSvc.0xa2a_1", 2602, i, ((oidb_0xa2a.ReqBody)localObject2).toByteArray());
          ((ToServiceMsg)localObject1).extraData.putString("troopUin", this.a);
          this.this$0.sendPbReq((ToServiceMsg)localObject1);
          return;
        }
      }
      catch (Exception localException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getAllOnlineMemberList, e=");
        ((StringBuilder)localObject2).append(localException.toString());
        QLog.i("TroopOnlineMemberHandler", 1, ((StringBuilder)localObject2).toString());
        return;
      }
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.onlinemember.handler.TroopOnlineMemberHandler.2
 * JD-Core Version:    0.7.0.1
 */