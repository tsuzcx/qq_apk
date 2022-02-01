package com.tencent.mobileqq.settings.fragment;

import android.support.v4.app.FragmentActivity;
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
  
  public void onGetCalReactiveDays(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!this.a.getActivity().isFinishing()))
    {
      if (paramBoolean2) {
        break label110;
      }
      this.a.j.setRightText(HardCodeUtil.a(2131699151));
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        Card localCard = ((FriendsManager)PermissionPrivacyFragment.a(this.a).getManager(QQManagerFactory.FRIENDS_MANAGER)).b(PermissionPrivacyFragment.a(this.a).getCurrentAccountUin());
        QLog.d("PermissionPrivacyFragment", 2, "PermissionPrivacyFragment onGetCalReactiveDays isAllow= " + paramBoolean2 + "card.allowCalInteractive=" + localCard.allowCalInteractive);
      }
      return;
      label110:
      this.a.j.setRightText(HardCodeUtil.a(2131699152));
    }
  }
  
  public void onGetTroopHonorSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!this.a.getActivity().isFinishing()))
    {
      if (!paramBoolean2) {
        break label110;
      }
      PermissionPrivacyFragment.a(this.a).setRightText(HardCodeUtil.a(2131699151));
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        Card localCard = ((FriendsManager)PermissionPrivacyFragment.a(this.a).getManager(QQManagerFactory.FRIENDS_MANAGER)).b(PermissionPrivacyFragment.a(this.a).getCurrentAccountUin());
        QLog.d("PermissionPrivacyFragment", 2, "PermissionPrivacyFragment onGetTroopHonorSwitch isAllow= " + paramBoolean2 + "card.troopHonorSwitch=" + localCard.troopHonorSwitch);
      }
      return;
      label110:
      PermissionPrivacyFragment.a(this.a).setRightText(HardCodeUtil.a(2131699152));
    }
  }
  
  public void onSetCalReactiveDays(boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if ((paramBoolean) && (!this.a.getActivity().isFinishing()))
    {
      Card localCard = ((FriendsManager)PermissionPrivacyFragment.a(this.a).getManager(QQManagerFactory.FRIENDS_MANAGER)).b(PermissionPrivacyFragment.a(this.a).getCurrentAccountUin());
      if (localCard.allowCalInteractive) {
        break label112;
      }
      this.a.j.setRightText(HardCodeUtil.a(2131699151));
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("PermissionPrivacyFragment onSetCalReactiveDays isAllow= ");
        if (localCard.allowCalInteractive) {
          break label130;
        }
      }
    }
    label130:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("PermissionPrivacyFragment", 2, paramBoolean);
      return;
      label112:
      this.a.j.setRightText(HardCodeUtil.a(2131699152));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PermissionPrivacyFragment.6
 * JD-Core Version:    0.7.0.1
 */