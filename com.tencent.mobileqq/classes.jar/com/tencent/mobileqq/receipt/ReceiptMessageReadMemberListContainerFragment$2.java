package com.tencent.mobileqq.receipt;

import anca;
import android.content.SharedPreferences;
import azul;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.BaseApplication;

class ReceiptMessageReadMemberListContainerFragment$2
  implements Runnable
{
  ReceiptMessageReadMemberListContainerFragment$2(ReceiptMessageReadMemberListContainerFragment paramReceiptMessageReadMemberListContainerFragment) {}
  
  public void run()
  {
    if (!this.this$0.isAdded()) {
      return;
    }
    if (ReceiptMessageReadMemberListContainerFragment.a(this.this$0).getApp().getSharedPreferences("last_update_time" + ReceiptMessageReadMemberListContainerFragment.a(this.this$0).getCurrentAccountUin(), 4).getLong("key_last_update_time" + ReceiptMessageReadMemberListContainerFragment.a(this.this$0), 0L) - ReceiptMessageReadMemberListContainerFragment.b(this.this$0) * 1000L > 60000L)
    {
      ReceiptMessageReadMemberListContainerFragment.a(this.this$0).sendEmptyMessage(4);
      return;
    }
    anca localanca = (anca)ReceiptMessageReadMemberListContainerFragment.a(this.this$0).getBusinessHandler(20);
    TroopInfo localTroopInfo = ((TroopManager)ReceiptMessageReadMemberListContainerFragment.a(this.this$0).getManager(52)).b(Long.toString(ReceiptMessageReadMemberListContainerFragment.a(this.this$0)));
    if (localTroopInfo == null)
    {
      ReceiptMessageReadMemberListContainerFragment.a(this.this$0).sendEmptyMessage(-1);
      return;
    }
    ReceiptMessageReadMemberListContainerFragment.a(this.this$0).addObserver(ReceiptMessageReadMemberListContainerFragment.a(this.this$0), true);
    localanca.a(true, localTroopInfo.troopuin, localTroopInfo.troopcode, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment.2
 * JD-Core Version:    0.7.0.1
 */