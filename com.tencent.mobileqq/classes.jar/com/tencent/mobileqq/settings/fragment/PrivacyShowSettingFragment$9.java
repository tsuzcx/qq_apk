package com.tencent.mobileqq.settings.fragment;

import android.support.v4.app.FragmentActivity;
import android.widget.CompoundButton;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import mqq.app.AppRuntime;

class PrivacyShowSettingFragment$9
  extends CardObserver
{
  PrivacyShowSettingFragment$9(PrivacyShowSettingFragment paramPrivacyShowSettingFragment) {}
  
  public void onGetAllowSeeLoginDays(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if ((paramString != null) && (paramString.equals(this.a.a.getCurrentAccountUin())))
    {
      if (paramBoolean1) {
        PrivacyShowSettingFragment.a(this.a, PrivacyShowSettingFragment.e(this.a).a(), paramBoolean2);
      }
      return;
    }
    QLog.e("IphoneTitleBarFragment", 2, "onGetAllowSeeLoginDays isSuccess " + paramBoolean1 + "isAllow:" + paramBoolean2 + "uin empty!");
  }
  
  public void onGetPrettyOwnerFlag(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      return;
    }
    if (paramObject != null) {}
    for (;;)
    {
      try
      {
        paramBoolean = ((Boolean)paramObject).booleanValue();
        PrivacyShowSettingFragment.a(this.a, paramBoolean);
        PrivacyShowSettingFragment.b(this.a).setChecked(paramBoolean);
        QLog.e("vip_pretty.IphoneTitleBarFragment", 1, "onGetPrettyOwnerFlag " + paramBoolean);
        return;
      }
      catch (Exception paramObject)
      {
        QLog.e("vip_pretty.IphoneTitleBarFragment", 1, "onGetPrettyOwnerFlag ex:" + paramObject);
        return;
      }
      paramBoolean = false;
    }
  }
  
  public void onSetAllowSeeLoginDays(boolean paramBoolean)
  {
    Card localCard = ((FriendsManager)this.a.a.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.a.a.getCurrentAccountUin());
    PrivacyShowSettingFragment.a(this.a, PrivacyShowSettingFragment.e(this.a).a(), localCard.allowPeopleSee);
  }
  
  public void onSetMedal(boolean paramBoolean)
  {
    int i = 1;
    boolean bool = false;
    if (!paramBoolean)
    {
      QQToast.a(this.a.a.getApp(), 1, this.a.getString(2131719116), 3000).b(this.a.getActivity().getTitleBarHeight());
      localObject1 = this.a;
      localObject2 = PrivacyShowSettingFragment.a(this.a).a();
      paramBoolean = bool;
      if (!PrivacyShowSettingFragment.a(this.a).a().isChecked()) {
        paramBoolean = true;
      }
      PrivacyShowSettingFragment.a((PrivacyShowSettingFragment)localObject1, (CompoundButton)localObject2, paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarFragment", 2, "PrivacyShowSettingFragment onSetMedal failed");
      }
      return;
    }
    Object localObject1 = ((FriendsManager)this.a.a.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.a.a.getCurrentAccountUin());
    if (!this.a.getActivity().isFinishing())
    {
      localObject2 = this.a;
      Switch localSwitch = PrivacyShowSettingFragment.a(this.a).a();
      if (((Card)localObject1).medalSwitchDisable) {
        break label267;
      }
      paramBoolean = true;
      PrivacyShowSettingFragment.a((PrivacyShowSettingFragment)localObject2, localSwitch, paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarFragment", 2, "PrivacyShowSettingFragment onSetMedal medalSwitchDisable= " + ((Card)localObject1).medalSwitchDisable);
      }
    }
    Object localObject2 = this.a.a;
    if (((Card)localObject1).medalSwitchDisable) {}
    for (;;)
    {
      ReportController.b((AppRuntime)localObject2, "dc00898", "", "", "0X80073A0", "0X80073A0", i, 0, "", "", "", "");
      return;
      label267:
      paramBoolean = false;
      break;
      i = 0;
    }
  }
  
  public void onSetPrettyOwnerFlag(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      return;
    }
    if (paramObject != null) {}
    for (;;)
    {
      try
      {
        paramBoolean = ((Boolean)paramObject).booleanValue();
        PrivacyShowSettingFragment.a(this.a, paramBoolean);
        QLog.e("vip_pretty.IphoneTitleBarFragment", 1, "onSetPrettyOwnerFlag " + paramBoolean);
        return;
      }
      catch (Exception paramObject)
      {
        QLog.e("vip_pretty.IphoneTitleBarFragment", 1, "onSetPrettyOwnerFlag ex:" + paramObject);
        return;
      }
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PrivacyShowSettingFragment.9
 * JD-Core Version:    0.7.0.1
 */