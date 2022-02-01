package com.tencent.mobileqq.onlinestatus;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;

class AccountPanel$10
  extends FriendListObserver
{
  AccountPanel$10(AccountPanel paramAccountPanel) {}
  
  public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (AccountPanel.a(this.a) == null) || (AccountPanel.a(this.a).isFinishing()) || (AccountPanel.a(this.a) == null))
    {
      QLog.d("AccountPanel", 1, String.format("onUpdateFriendInfo return, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      return;
    }
    AccountPanel.AccountItemViewHolder localAccountItemViewHolder = AccountPanel.a(this.a, paramString);
    Object localObject;
    if (localAccountItemViewHolder != null)
    {
      if (localAccountItemViewHolder.jdField_a_of_type_Int != 2) {
        break label147;
      }
      localObject = ContactUtils.c(AccountPanel.a(this.a), paramString, false);
    }
    for (;;)
    {
      localAccountItemViewHolder.a((CharSequence)localObject);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AccountPanel", 2, String.format("onUpdateFriendInfo, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      return;
      label147:
      localObject = (SimpleAccount)localAccountItemViewHolder.jdField_a_of_type_AndroidViewView.getTag(2131361897);
      if (localObject != null) {
        localObject = SubAccountControll.a(AccountPanel.a(this.a), (SimpleAccount)localObject);
      } else {
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.10
 * JD-Core Version:    0.7.0.1
 */