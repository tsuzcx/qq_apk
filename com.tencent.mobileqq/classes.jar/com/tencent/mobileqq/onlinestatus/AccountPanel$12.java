package com.tencent.mobileqq.onlinestatus;

import android.text.TextUtils;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.subaccount.logic.SubAccountThirdQQBackProtocData;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;

class AccountPanel$12
  extends MessageObserver
{
  AccountPanel$12(AccountPanel paramAccountPanel) {}
  
  public void onGetSubAccountMsg(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (AccountPanel.a(this.a, paramString, paramSubAccountBackProtocData))
    {
      QLog.d("AccountPanel", 1, String.format("onGetSubAccountMsg return, isSuccess: %s, subAccount: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      return;
    }
    AccountPanel.a(this.a, paramBoolean, paramString, true);
  }
  
  public void onSubAccountMsgNumConfirm(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (AccountPanel.a(this.a) == null)) {
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("AccountPanel onSubAccountMsgNumConfirm isSuccess=").append(paramBoolean).append(" subUin=").append(paramString1).append(" set need2ConfirmMsgNum=");
      if (paramBoolean) {
        break label127;
      }
    }
    label127:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("AccountPanel", 2, paramBoolean + " nextAction=" + paramString2);
      if (paramString1.equals(AccountPanel.a(this.a).getUin())) {
        this.a.a(AccountPanel.a(this.a));
      }
      AccountPanel.a(this.a, null);
      return;
    }
  }
  
  public void onSubAccountThirdQQUnreadMsgNum(boolean paramBoolean, String paramString, SubAccountThirdQQBackProtocData paramSubAccountThirdQQBackProtocData)
  {
    if (AccountPanel.a(this.a, paramBoolean, paramString, paramSubAccountThirdQQBackProtocData)) {
      return;
    }
    AccountPanel.a(this.a, paramBoolean, paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.12
 * JD-Core Version:    0.7.0.1
 */