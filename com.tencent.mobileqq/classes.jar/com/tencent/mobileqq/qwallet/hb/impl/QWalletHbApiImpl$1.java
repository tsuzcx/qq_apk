package com.tencent.mobileqq.qwallet.hb.impl;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.troopmanager.api.TroopManagerBizObserver;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;

final class QWalletHbApiImpl$1
  extends TroopManagerBizObserver
{
  QWalletHbApiImpl$1(BaseSessionInfo paramBaseSessionInfo) {}
  
  protected void onGetTroopInfoForSetJoinTypeRet(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo, Object[] paramArrayOfObject)
  {
    if (paramBoolean)
    {
      QWalletHelperImpl.saveLastUpdateToopMemberNumTime(this.a.b);
      if (QLog.isColorLevel())
      {
        paramArrayOfObject = new StringBuilder();
        paramArrayOfObject.append("onGetTroopInfoForSetJoinTypeRet 群uin：");
        paramArrayOfObject.append(this.a.b);
        paramArrayOfObject.append(" 群成员个数：");
        paramArrayOfObject.append(paramTroopInfo.wMemberNum);
        QLog.d("PlusPanelUtils", 2, paramArrayOfObject.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.impl.QWalletHbApiImpl.1
 * JD-Core Version:    0.7.0.1
 */