package com.tencent.mobileqq.troop.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.temporaryban.TemporaryBanJoinTroopAbilityHelper;
import com.tencent.qphone.base.util.QLog;
import trpc.mizarproto.passthrough.FunctionLockMsg.FunctionLockBeatRsp;

class JoinTroopUtil$1
  extends TroopMngObserver
{
  JoinTroopUtil$1(JoinTroopUtil paramJoinTroopUtil) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    JoinTroopUtil.a(this.a, false, paramInt1, paramInt2, null);
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    JoinTroopUtil.a(this.a, true, paramInt1, paramInt2, paramString);
  }
  
  protected void a(String paramString)
  {
    JoinTroopUtil.a(this.a, paramString);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    JoinTroopUtil.a(this.a, paramBoolean, paramLong, paramTroopInfo);
  }
  
  public void a(boolean paramBoolean, String paramString, FunctionLockMsg.FunctionLockBeatRsp paramFunctionLockBeatRsp)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onJoinTroopTemporaryBan troopUin = ");
      localStringBuilder.append(paramString);
      QLog.d("AddTroopUtil", 2, localStringBuilder.toString());
    }
    if ((JoinTroopUtil.a(this.a) != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (!paramString.equals(JoinTroopUtil.a(this.a).troopUin)) {
        return;
      }
      TemporaryBanJoinTroopAbilityHelper.a().a(JoinTroopUtil.b(this.a), JoinTroopUtil.c(this.a), paramFunctionLockBeatRsp, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.JoinTroopUtil.1
 * JD-Core Version:    0.7.0.1
 */