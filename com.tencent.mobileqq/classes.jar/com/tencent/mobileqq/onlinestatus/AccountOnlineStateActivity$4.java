package com.tencent.mobileqq.onlinestatus;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime.Status;

class AccountOnlineStateActivity$4
  extends CardObserver
{
  AccountOnlineStateActivity$4(AccountOnlineStateActivity paramAccountOnlineStateActivity) {}
  
  public void onGetAutoReplyList(boolean paramBoolean, List<AutoReplyText> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, String.format("onGetAutoReplyList, isSuccess: %s, selectId: %s, replyList: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramList }));
    }
    if (AccountOnlineStateActivity.a(this.a) != null) {
      AccountOnlineStateActivity.a(this.a).runOnUiThread(new AccountOnlineStateActivity.4.1(this, paramBoolean, paramList));
    }
  }
  
  public void onSetAutoReplyList(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      OnlineStatusItem localOnlineStatusItem = AccountOnlineStateActivity.a(this.a).a();
      AppRuntime.Status localStatus = OnLineStatusHelper.a().a(localOnlineStatusItem);
      if ((localStatus != null) && (!AccountOnlineStateActivity.a(this.a, localOnlineStatusItem, localStatus)))
      {
        AccountOnlineStateActivity.a(this.a, true);
        AccountOnlineStateActivity.a(this.a).updateOnlineStatus(localStatus, localOnlineStatusItem.a);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountOnlineStateActivity", 2, "onSetAutoReplyList, isSuccess: " + paramBoolean);
      }
      return;
      AccountOnlineStateActivity.a(this.a, true, 0);
      continue;
      AccountOnlineStateActivity.a(this.a, false, -2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity.4
 * JD-Core Version:    0.7.0.1
 */