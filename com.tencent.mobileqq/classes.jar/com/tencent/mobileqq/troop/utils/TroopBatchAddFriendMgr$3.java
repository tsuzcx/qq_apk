package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.troop.observer.TroopRedDotObserver;
import com.tencent.qphone.base.util.QLog;

class TroopBatchAddFriendMgr$3
  extends TroopRedDotObserver
{
  TroopBatchAddFriendMgr$3(TroopBatchAddFriendMgr paramTroopBatchAddFriendMgr) {}
  
  protected void a(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2)
  {
    if (!Long.toString(101509131L).equalsIgnoreCase(paramString2)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("onChangeTroopAIORedPoint clear active suc_troopUin_appid_from0x8c2 %b_%s_%s_%b", new Object[] { Boolean.valueOf(paramBoolean1), paramString1, paramString2, Boolean.valueOf(paramBoolean2) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr.3
 * JD-Core Version:    0.7.0.1
 */