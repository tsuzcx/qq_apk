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
    Object localObject = (FriendsManager)this.this$0.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Card localCard = ((FriendsManager)localObject).a(this.this$0.a.getCurrentAccountUin());
    if (localCard != null)
    {
      localCard.isHidePrettyGroutIdentity = (this.a ^ true);
      if (!((FriendsManager)localObject).a(localCard))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onGetPrettyOwnerFlag save card flag=");
        ((StringBuilder)localObject).append(this.a);
        ((StringBuilder)localObject).append(" failed");
        QLog.e("vip_pretty.IphoneTitleBarFragment", 1, ((StringBuilder)localObject).toString());
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetPrettyOwnerFlag save card flag=");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append(" success");
      QLog.e("vip_pretty.IphoneTitleBarFragment", 1, ((StringBuilder)localObject).toString());
      return;
    }
    QLog.e("vip_pretty.IphoneTitleBarFragment", 1, "onGetPrettyOwnerFlag save card failed because card is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PrivacyShowSettingFragment.10
 * JD-Core Version:    0.7.0.1
 */