package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.troopmanager.api.TroopManagerBizObserver;
import com.tencent.qphone.base.util.QLog;

final class QAVGroupConfig$1
  extends TroopManagerBizObserver
{
  QAVGroupConfig$1(long paramLong, String paramString1, QQAppInterface paramQQAppInterface, String paramString2) {}
  
  protected void onGetTroopInfoForSetJoinTypeRet(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo, Object[] paramArrayOfObject)
  {
    if (this.a != paramLong) {
      return;
    }
    paramTroopInfo = new StringBuilder();
    paramTroopInfo.append("onGetTroopInfoForSetJoinTypeRet[");
    paramTroopInfo.append(this.b);
    paramTroopInfo.append("], troopuin[");
    paramTroopInfo.append(paramLong);
    paramTroopInfo.append("], nFlag[");
    paramTroopInfo.append(paramInt);
    paramTroopInfo.append("], isMyFlag[");
    boolean bool;
    if ((paramInt & 0x1) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramTroopInfo.append(bool);
    paramTroopInfo.append("], isSuccess[");
    paramTroopInfo.append(paramBoolean);
    paramTroopInfo.append("]");
    QLog.w("QAVGroupConfig", 1, paramTroopInfo.toString());
    if (paramInt == 480)
    {
      if (paramBoolean)
      {
        paramTroopInfo = new StringBuilder();
        paramTroopInfo.append(this.b);
        paramTroopInfo.append(".onGetTroopInfoForSetJoinTypeRet");
        QAVGroupConfig.GroupInviteFlag.a(paramTroopInfo.toString(), this.c, this.d);
      }
      this.c.removeObserver(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QAVGroupConfig.1
 * JD-Core Version:    0.7.0.1
 */