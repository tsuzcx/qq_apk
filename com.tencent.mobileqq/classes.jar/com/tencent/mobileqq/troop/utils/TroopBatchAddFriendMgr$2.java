package com.tencent.mobileqq.troop.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troopAddFrd.Scene;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

class TroopBatchAddFriendMgr$2
  extends TroopObserver
{
  TroopBatchAddFriendMgr$2(TroopBatchAddFriendMgr paramTroopBatchAddFriendMgr) {}
  
  public void onUpdateTroopGetMemberList(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    Object localObject = (Long)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if ((localObject == null) || (((Long)localObject).longValue() == 0L)) {
      break label31;
    }
    label31:
    while (!Scene.a(paramInt2)) {
      return;
    }
    if (paramBoolean)
    {
      paramInt1 = 1;
      label47:
      if (paramList != null) {
        break label224;
      }
    }
    label224:
    for (int i = 0;; i = paramList.size())
    {
      QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 1, String.format("onUpdateTroopGetMemberList suc_troopUin_type_ts=%d_%s_%d_%d_%d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Long.valueOf(paramLong), Integer.valueOf(i) }));
      if (((Long)localObject).longValue() != paramLong) {
        break;
      }
      paramList = (Long)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      if (!paramBoolean) {
        break label235;
      }
      paramList = PreferenceManager.getDefaultSharedPreferences(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      localObject = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_members", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString });
      paramList.edit().putLong((String)localObject, paramLong).apply();
      TroopBatchAddFriendMgr.a(this.a, paramString, true, paramLong, 2);
      return;
      paramInt1 = 0;
      break label47;
    }
    label235:
    this.a.a(paramString, paramLong, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr.2
 * JD-Core Version:    0.7.0.1
 */