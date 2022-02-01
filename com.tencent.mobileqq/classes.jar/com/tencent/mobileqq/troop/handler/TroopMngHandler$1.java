package com.tencent.mobileqq.troop.handler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopSystemMsgUtilApi;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

class TroopMngHandler$1
  extends TroopObserver
{
  TroopMngHandler$1(TroopMngHandler paramTroopMngHandler, long paramLong, int paramInt) {}
  
  public void onGet0x88d_Result(boolean paramBoolean, String paramString1, String paramString2, oidb_0x88d.GroupInfo paramGroupInfo)
  {
    if ((paramString1.equals(String.valueOf(this.a))) && (paramString2.equals("SUBCMD_GET_TROOP_TAG")))
    {
      Object localObject = null;
      paramString2 = localObject;
      if (paramBoolean)
      {
        paramString2 = localObject;
        if (paramGroupInfo != null)
        {
          paramString2 = TroopMngHandler.a(this.c, this.a, paramGroupInfo);
          paramGroupInfo = (ITroopSystemMsgUtilApi)QRoute.api(ITroopSystemMsgUtilApi.class);
          paramGroupInfo.saveTroopNameToSP(TroopMngHandler.a(this.c).getApp(), paramString2.troopuin, paramString2.troopname);
          paramGroupInfo.saveTroopOptionToSP(TroopMngHandler.b(this.c).getApp(), paramString2.troopuin, paramString2.cGroupOption);
          paramGroupInfo.saveTroopQuestionToSP(TroopMngHandler.c(this.c).getApp(), paramString2.troopuin, paramString2.joinTroopQuestion);
          paramGroupInfo.saveTroopAnswerToSP(TroopMngHandler.d(this.c).getApp(), paramString2.troopuin, paramString2.joinTroopAnswer);
        }
      }
      this.c.notifyUI(TroopMngObserver.g, paramBoolean, new Object[] { Long.valueOf(this.a), Integer.valueOf(this.b), paramString2 });
      TroopMngHandler.e(this.c).removeObserver(this);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder(150);
        paramString2.append("handle_oidb_0x88d_1");
        paramString2.append("|isSuccess = ");
        paramString2.append(paramBoolean);
        paramString2.append("|troopuin = ");
        paramString2.append(paramString1);
        paramString2.append("|flag = ");
        paramString2.append(this.b);
        QLog.i("Q.troopquestionverify.", 2, paramString2.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.handler.TroopMngHandler.1
 * JD-Core Version:    0.7.0.1
 */