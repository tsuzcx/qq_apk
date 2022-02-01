package com.tencent.mobileqq.settings.fragment;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

class PrivacyShowSettingFragment$3
  implements Runnable
{
  PrivacyShowSettingFragment$3(PrivacyShowSettingFragment paramPrivacyShowSettingFragment) {}
  
  public void run()
  {
    boolean bool = ((FriendsManager)this.this$0.a.getManager(QQManagerFactory.FRIENDS_MANAGER)).g(this.this$0.a.getCurrentAccountUin()).medalSwitchDisable;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PermissionPrivacyFragment initUI medalSwitchDisable = ");
      localStringBuilder.append(bool);
      QLog.d("IphoneTitleBarFragment", 2, localStringBuilder.toString());
    }
    this.this$0.getBaseActivity().runOnUiThread(new PrivacyShowSettingFragment.3.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PrivacyShowSettingFragment.3
 * JD-Core Version:    0.7.0.1
 */