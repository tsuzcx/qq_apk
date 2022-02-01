package com.tencent.mobileqq.troop.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troopAddFrd.Scene;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

class TroopBatchAddFriendMgr$2
  extends TroopObserver
{
  TroopBatchAddFriendMgr$2(TroopBatchAddFriendMgr paramTroopBatchAddFriendMgr) {}
  
  protected void onBAFSecurityCheckResult(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("onBAFSecurityCheckResult suc_result_troopUin_type_ts=%b_%d_%s_%d_%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), paramString1, Integer.valueOf(paramInt2), Long.valueOf(paramLong) }));
    }
    if (!Scene.a(paramInt2)) {
      return;
    }
    if ((paramBoolean) && (paramInt1 == 1))
    {
      TroopBatchAddFriendMgr.a(this.a, paramString1, true, paramLong, 1);
      return;
    }
    this.a.a(paramString1, paramLong, paramInt2);
  }
  
  protected void onTroopBatchAddFrdsDataPrepareErr(boolean paramBoolean, String paramString, long paramLong, int paramInt)
  {
    if (!Scene.a(paramInt)) {
      return;
    }
    Long localLong = (Long)this.a.b.remove(paramString);
    TroopBatchAddFriendMgr.a(this.a, paramString, false, paramLong, 0);
    if (QLog.isColorLevel())
    {
      long l;
      if (localLong == null) {
        l = 0L;
      } else {
        l = localLong.longValue();
      }
      QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("onTroopBatchAddFrdsDataPrepareErr troopUin_ts_type_reqTs=%s_%d_%d_%d", new Object[] { paramString, Long.valueOf(l), Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
    }
  }
  
  protected void onTroopBatchGetMemberRemark(boolean paramBoolean1, String paramString, long paramLong, int paramInt, boolean paramBoolean2)
  {
    Object localObject = (Long)this.a.b.get(paramString);
    if (localObject != null)
    {
      if (((Long)localObject).longValue() == 0L) {
        return;
      }
      if (!Scene.a(paramInt)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("onTroopBatchGetMemberRemark suc_troopUin_type_ts_curTs_bInc=%b_%s_%d_%d_%d_%b", new Object[] { Boolean.valueOf(paramBoolean1), paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong), Long.valueOf(((Long)localObject).longValue()), Boolean.valueOf(paramBoolean2) }));
      }
      if (paramLong == ((Long)localObject).longValue())
      {
        localObject = (Long)this.a.b.remove(paramString);
        if (paramBoolean1)
        {
          localObject = PreferenceManager.getDefaultSharedPreferences(this.a.a.getApp());
          String str = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_remarks", this.a.a.getCurrentAccountUin(), paramString });
          ((SharedPreferences)localObject).edit().putLong(str, paramLong).apply();
        }
        TroopBatchAddFriendMgr.a(this.a, paramString, true, paramLong, 5);
      }
    }
  }
  
  protected void onTroopBatchReqMemberCmnFrds(boolean paramBoolean1, String paramString1, String paramString2, long paramLong, int paramInt, boolean paramBoolean2, boolean paramBoolean3, HashMap<String, Integer> paramHashMap, List<String> paramList)
  {
    paramString2 = (Long)this.a.b.get(paramString1);
    if (paramString2 != null)
    {
      if (paramString2.longValue() == 0L) {
        return;
      }
      if (!Scene.a(paramInt)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("onTroopBatchReqMemberCmnFrds suc_troopUin_type_ts_curTs_bInc=%b_%s_%d_%d_%d_%b", new Object[] { Boolean.valueOf(paramBoolean1), paramString1, Integer.valueOf(paramInt), Long.valueOf(paramLong), Long.valueOf(paramString2.longValue()), Boolean.valueOf(paramBoolean3) }));
      }
      if (paramLong == paramString2.longValue())
      {
        if ((paramBoolean2) || (!paramBoolean1)) {
          paramString2 = (Long)this.a.b.remove(paramString1);
        }
        if (!paramBoolean1)
        {
          this.a.a(paramString1, paramLong, paramInt);
          return;
        }
        if ((paramBoolean1) && (paramBoolean2))
        {
          paramString2 = PreferenceManager.getDefaultSharedPreferences(this.a.a.getApp());
          paramHashMap = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_cmnfrds", this.a.a.getCurrentAccountUin(), paramString1 });
          paramString2.edit().putLong(paramHashMap, paramLong).apply();
          TroopBatchAddFriendMgr.a(this.a, paramString1, true, paramLong, 3);
        }
      }
    }
  }
  
  protected void onUpdateTroopGetMemberList(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr.2
 * JD-Core Version:    0.7.0.1
 */