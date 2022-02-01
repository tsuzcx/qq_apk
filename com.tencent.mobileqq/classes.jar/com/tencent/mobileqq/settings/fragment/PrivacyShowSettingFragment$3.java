package com.tencent.mobileqq.settings.fragment;

import android.support.v4.app.FragmentActivity;
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
    boolean bool = ((FriendsManager)this.this$0.a.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.this$0.a.getCurrentAccountUin()).medalSwitchDisable;
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarFragment", 2, "PermissionPrivacyFragment initUI medalSwitchDisable = " + bool);
    }
    this.this$0.getActivity().runOnUiThread(new PrivacyShowSettingFragment.3.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PrivacyShowSettingFragment.3
 * JD-Core Version:    0.7.0.1
 */