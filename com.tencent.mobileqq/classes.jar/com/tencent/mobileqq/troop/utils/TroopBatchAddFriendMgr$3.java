package com.tencent.mobileqq.troop.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.troopAddFrd.Scene;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

class TroopBatchAddFriendMgr$3
  extends TroopBusinessObserver
{
  TroopBatchAddFriendMgr$3(TroopBatchAddFriendMgr paramTroopBatchAddFriendMgr) {}
  
  public void onBAFSecurityCheckResult(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2)
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
  
  public void onChangeTroopAIORedPoint(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2)
  {
    if (!Long.toString(101509131L).equalsIgnoreCase(paramString2)) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("onChangeTroopAIORedPoint clear active suc_troopUin_appid_from0x8c2 %b_%s_%s_%b", new Object[] { Boolean.valueOf(paramBoolean1), paramString1, paramString2, Boolean.valueOf(paramBoolean2) }));
  }
  
  public void onTroopBatchAddFrdsDataPrepareErr(boolean paramBoolean, String paramString, long paramLong, int paramInt)
  {
    if (!Scene.a(paramInt)) {}
    Long localLong;
    do
    {
      return;
      localLong = (Long)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      TroopBatchAddFriendMgr.a(this.a, paramString, false, paramLong, 0);
    } while (!QLog.isColorLevel());
    if (localLong == null) {}
    for (long l = 0L;; l = localLong.longValue())
    {
      QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("onTroopBatchAddFrdsDataPrepareErr troopUin_ts_type_reqTs=%s_%d_%d_%d", new Object[] { paramString, Long.valueOf(l), Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
      return;
    }
  }
  
  public void onTroopBatchGetMemberRemark(boolean paramBoolean1, String paramString, long paramLong, int paramInt, boolean paramBoolean2)
  {
    Object localObject = (Long)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if ((localObject == null) || (((Long)localObject).longValue() == 0L)) {}
    do
    {
      do
      {
        return;
      } while (!Scene.a(paramInt));
      if (QLog.isColorLevel()) {
        QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("onTroopBatchGetMemberRemark suc_troopUin_type_ts_curTs_bInc=%b_%s_%d_%d_%d_%b", new Object[] { Boolean.valueOf(paramBoolean1), paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong), Long.valueOf(((Long)localObject).longValue()), Boolean.valueOf(paramBoolean2) }));
      }
    } while (paramLong != ((Long)localObject).longValue());
    localObject = (Long)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    if (paramBoolean1)
    {
      localObject = PreferenceManager.getDefaultSharedPreferences(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      String str = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_remarks", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString });
      ((SharedPreferences)localObject).edit().putLong(str, paramLong).apply();
    }
    TroopBatchAddFriendMgr.a(this.a, paramString, true, paramLong, 5);
  }
  
  public void onTroopBatchReqMemberCmnFrds(boolean paramBoolean1, String paramString1, String paramString2, long paramLong, int paramInt, boolean paramBoolean2, boolean paramBoolean3, HashMap<String, Integer> paramHashMap, List<String> paramList)
  {
    paramString2 = (Long)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
    if ((paramString2 == null) || (paramString2.longValue() == 0L)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!Scene.a(paramInt));
        if (QLog.isColorLevel()) {
          QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("onTroopBatchReqMemberCmnFrds suc_troopUin_type_ts_curTs_bInc=%b_%s_%d_%d_%d_%b", new Object[] { Boolean.valueOf(paramBoolean1), paramString1, Integer.valueOf(paramInt), Long.valueOf(paramLong), Long.valueOf(paramString2.longValue()), Boolean.valueOf(paramBoolean3) }));
        }
      } while (paramLong != paramString2.longValue());
      if ((paramBoolean2) || (!paramBoolean1)) {
        paramString2 = (Long)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString1);
      }
      if (!paramBoolean1)
      {
        this.a.a(paramString1, paramLong, paramInt);
        return;
      }
    } while ((!paramBoolean1) || (!paramBoolean2));
    paramString2 = PreferenceManager.getDefaultSharedPreferences(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
    paramHashMap = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_cmnfrds", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString1 });
    paramString2.edit().putLong(paramHashMap, paramLong).apply();
    TroopBatchAddFriendMgr.a(this.a, paramString1, true, paramLong, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr.3
 * JD-Core Version:    0.7.0.1
 */