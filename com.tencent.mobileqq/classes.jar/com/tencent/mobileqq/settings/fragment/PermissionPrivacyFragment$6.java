package com.tencent.mobileqq.settings.fragment;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;

class PermissionPrivacyFragment$6
  extends CardObserver
{
  PermissionPrivacyFragment$6(PermissionPrivacyFragment paramPermissionPrivacyFragment) {}
  
  protected void onGetCalReactiveDays(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!this.a.getBaseActivity().isFinishing()))
    {
      if (!paramBoolean2) {
        this.a.j.setRightText(HardCodeUtil.a(2131699255));
      } else {
        this.a.j.setRightText(HardCodeUtil.a(2131699256));
      }
      if (QLog.isColorLevel())
      {
        Card localCard = ((FriendsManager)PermissionPrivacyFragment.a(this.a).getManager(QQManagerFactory.FRIENDS_MANAGER)).b(PermissionPrivacyFragment.a(this.a).getCurrentAccountUin());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PermissionPrivacyFragment onGetCalReactiveDays isAllow= ");
        localStringBuilder.append(paramBoolean2);
        localStringBuilder.append("card.allowCalInteractive=");
        localStringBuilder.append(localCard.allowCalInteractive);
        QLog.d("PermissionPrivacyFragment", 2, localStringBuilder.toString());
      }
    }
  }
  
  protected void onGetTroopHonorSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!this.a.getBaseActivity().isFinishing()))
    {
      if (paramBoolean2) {
        PermissionPrivacyFragment.a(this.a).setRightText(HardCodeUtil.a(2131699255));
      } else {
        PermissionPrivacyFragment.a(this.a).setRightText(HardCodeUtil.a(2131699256));
      }
      if (QLog.isColorLevel())
      {
        Card localCard = ((FriendsManager)PermissionPrivacyFragment.a(this.a).getManager(QQManagerFactory.FRIENDS_MANAGER)).b(PermissionPrivacyFragment.a(this.a).getCurrentAccountUin());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PermissionPrivacyFragment onGetTroopHonorSwitch isAllow= ");
        localStringBuilder.append(paramBoolean2);
        localStringBuilder.append("card.troopHonorSwitch=");
        localStringBuilder.append(localCard.troopHonorSwitch);
        QLog.d("PermissionPrivacyFragment", 2, localStringBuilder.toString());
      }
    }
  }
  
  protected void onSetCalReactiveDays(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.a.getBaseActivity().isFinishing()))
    {
      Card localCard = ((FriendsManager)PermissionPrivacyFragment.a(this.a).getManager(QQManagerFactory.FRIENDS_MANAGER)).b(PermissionPrivacyFragment.a(this.a).getCurrentAccountUin());
      if (!localCard.allowCalInteractive) {
        this.a.j.setRightText(HardCodeUtil.a(2131699255));
      } else {
        this.a.j.setRightText(HardCodeUtil.a(2131699256));
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PermissionPrivacyFragment onSetCalReactiveDays isAllow= ");
        localStringBuilder.append(localCard.allowCalInteractive ^ true);
        QLog.d("PermissionPrivacyFragment", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PermissionPrivacyFragment.6
 * JD-Core Version:    0.7.0.1
 */