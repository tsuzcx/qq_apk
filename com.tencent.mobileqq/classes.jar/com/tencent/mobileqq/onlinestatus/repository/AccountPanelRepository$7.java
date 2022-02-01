package com.tencent.mobileqq.onlinestatus.repository;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModel;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class AccountPanelRepository$7
  extends AvatarObserver
{
  AccountPanelRepository$7(AccountPanelRepository paramAccountPanelRepository) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (localAppRuntime != null))
    {
      AccountPanelRepository.a(this.a).d().setValue(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanelRepository", 2, String.format("onUpdateCustomHead, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      }
      return;
    }
    QLog.d("AccountPanelRepository", 1, String.format("onUpdateCustomHead return, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.repository.AccountPanelRepository.7
 * JD-Core Version:    0.7.0.1
 */