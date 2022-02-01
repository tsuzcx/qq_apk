package com.tencent.mobileqq.receipt;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
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
    Object localObject1 = ReceiptMessageReadMemberListContainerFragment.c(this.this$0).getApp();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("last_update_time");
    ((StringBuilder)localObject2).append(ReceiptMessageReadMemberListContainerFragment.c(this.this$0).getCurrentAccountUin());
    localObject1 = ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 4);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("key_last_update_time");
    ((StringBuilder)localObject2).append(ReceiptMessageReadMemberListContainerFragment.d(this.this$0));
    if (((SharedPreferences)localObject1).getLong(((StringBuilder)localObject2).toString(), 0L) - ReceiptMessageReadMemberListContainerFragment.e(this.this$0) * 1000L > 60000L)
    {
      ReceiptMessageReadMemberListContainerFragment.f(this.this$0).sendEmptyMessage(4);
      return;
    }
    localObject1 = (ITroopMemberListHandler)ReceiptMessageReadMemberListContainerFragment.c(this.this$0).getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER);
    localObject2 = ((TroopManager)ReceiptMessageReadMemberListContainerFragment.c(this.this$0).getManager(QQManagerFactory.TROOP_MANAGER)).f(Long.toString(ReceiptMessageReadMemberListContainerFragment.d(this.this$0)));
    if (localObject2 == null)
    {
      ReceiptMessageReadMemberListContainerFragment.f(this.this$0).sendEmptyMessage(-1);
      return;
    }
    ReceiptMessageReadMemberListContainerFragment.c(this.this$0).addObserver(ReceiptMessageReadMemberListContainerFragment.g(this.this$0), true);
    ((ITroopMemberListHandler)localObject1).a(true, ((TroopInfo)localObject2).troopuin, ((TroopInfo)localObject2).troopcode, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment.2
 * JD-Core Version:    0.7.0.1
 */