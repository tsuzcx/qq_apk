package com.tencent.mobileqq.onlinestatus.repository;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModel;
import com.tencent.mobileqq.relation.api.IFriendsUtils.FriendListObserverInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class AccountPanelRepository$8
  implements IFriendsUtils.FriendListObserverInterface
{
  AccountPanelRepository$8(AccountPanelRepository paramAccountPanelRepository) {}
  
  public void a(String paramString, boolean paramBoolean)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (localAppRuntime != null))
    {
      AccountPanelRepository.a(this.a).c().setValue(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanelRepository", 2, String.format("onUpdateFriendInfo, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      }
      return;
    }
    QLog.d("AccountPanelRepository", 1, String.format("onUpdateFriendInfo return, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.repository.AccountPanelRepository.8
 * JD-Core Version:    0.7.0.1
 */