package com.tencent.mobileqq.receipt;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ReceiptMessageReadMemberListContainerFragment$3
  extends TroopObserver
{
  ReceiptMessageReadMemberListContainerFragment$3(ReceiptMessageReadMemberListContainerFragment paramReceiptMessageReadMemberListContainerFragment) {}
  
  protected void onUpdateTroopGetMemberList(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if (paramBoolean)
    {
      if (!this.a.isAdded())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReceiptMessageReadMemberListContainerFragment", 2, "onUpdateTroopGetMemberList succ with fragment is detached");
        }
        return;
      }
      paramString = ReceiptMessageReadMemberListContainerFragment.a(this.a).getApp();
      paramList = new StringBuilder();
      paramList.append("last_update_time");
      paramList.append(ReceiptMessageReadMemberListContainerFragment.a(this.a).getCurrentAccountUin());
      paramString = paramString.getSharedPreferences(paramList.toString(), 4).edit();
      paramList = new StringBuilder();
      paramList.append("key_last_update_time");
      paramList.append(ReceiptMessageReadMemberListContainerFragment.a(this.a));
      paramString.putLong(paramList.toString(), paramLong).apply();
      ReceiptMessageReadMemberListContainerFragment.a(this.a).sendEmptyMessage(4);
      ReceiptMessageReadMemberListContainerFragment.a(this.a).removeObserver(this);
      return;
    }
    ReceiptMessageReadMemberListContainerFragment.a(this.a).sendEmptyMessage(-1);
    QLog.d("ReceiptMessageReadMemberListContainerFragment", 1, "mTroopModifyObserver onUpdateTroopGetMemberList fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment.3
 * JD-Core Version:    0.7.0.1
 */