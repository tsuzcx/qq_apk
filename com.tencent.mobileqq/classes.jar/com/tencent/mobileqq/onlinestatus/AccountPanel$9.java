package com.tencent.mobileqq.onlinestatus;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.qphone.base.util.QLog;

class AccountPanel$9
  extends AvatarObserver
{
  AccountPanel$9(AccountPanel paramAccountPanel) {}
  
  public void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (AccountPanel.a(this.a) == null) || (AccountPanel.a(this.a).isFinishing()) || (AccountPanel.a(this.a) == null)) {
      QLog.d("AccountPanel", 1, String.format("onUpdateCustomHead return, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
    do
    {
      return;
      AccountPanel.AccountItemViewHolder localAccountItemViewHolder = AccountPanel.a(this.a, paramString);
      if (localAccountItemViewHolder != null) {
        localAccountItemViewHolder.a(FaceDrawable.getFaceDrawable(AccountPanel.a(this.a), 1, paramString));
      }
    } while (!QLog.isColorLevel());
    QLog.d("AccountPanel", 2, String.format("onUpdateCustomHead, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.9
 * JD-Core Version:    0.7.0.1
 */