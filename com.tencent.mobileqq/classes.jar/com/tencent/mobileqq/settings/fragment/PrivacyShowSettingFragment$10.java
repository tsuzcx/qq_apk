package com.tencent.mobileqq.settings.fragment;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

class PrivacyShowSettingFragment$10
  implements Runnable
{
  PrivacyShowSettingFragment$10(PrivacyShowSettingFragment paramPrivacyShowSettingFragment, boolean paramBoolean) {}
  
  public void run()
  {
    FriendsManager localFriendsManager = (FriendsManager)this.this$0.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Card localCard = localFriendsManager.a(this.this$0.a.getCurrentAccountUin());
    if (localCard != null)
    {
      if (!this.a) {}
      for (boolean bool = true;; bool = false)
      {
        localCard.isHidePrettyGroutIdentity = bool;
        if (localFriendsManager.a(localCard)) {
          break;
        }
        QLog.e("vip_pretty.IphoneTitleBarFragment", 1, "onGetPrettyOwnerFlag save card flag=" + this.a + " failed");
        return;
      }
      QLog.e("vip_pretty.IphoneTitleBarFragment", 1, "onGetPrettyOwnerFlag save card flag=" + this.a + " success");
      return;
    }
    QLog.e("vip_pretty.IphoneTitleBarFragment", 1, "onGetPrettyOwnerFlag save card failed because card is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PrivacyShowSettingFragment.10
 * JD-Core Version:    0.7.0.1
 */