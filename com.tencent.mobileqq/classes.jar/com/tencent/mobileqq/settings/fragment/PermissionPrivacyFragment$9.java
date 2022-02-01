package com.tencent.mobileqq.settings.fragment;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contact.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.activity.contact.phonecontact.permission.PermissionParam;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;

class PermissionPrivacyFragment$9
  implements CompoundButton.OnCheckedChangeListener
{
  PermissionPrivacyFragment$9(PermissionPrivacyFragment paramPermissionPrivacyFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i;
    if (paramCompoundButton == this.a.a.a()) {
      if (paramBoolean)
      {
        i = 1;
        ReportController.b(PermissionPrivacyFragment.a(this.a), "CliOper", "", "", "Setting_tab", "Clk_signature_qzone", 0, i, String.valueOf(i), "", "", "");
        if (!paramBoolean) {
          break label152;
        }
        i = 1;
        label58:
        ReportController.b(null, "dc00898", "", "", "0X800B85B", "0X800B85B", i, 0, "", "0", "0", "");
        if ((!NetworkUtil.d(this.a.getActivity())) || (PermissionPrivacyFragment.a(this.a) == null)) {
          break label157;
        }
        if (AppSetting.d) {
          this.a.a.setContentDescription(HardCodeUtil.a(2131707904));
        }
        PermissionPrivacyFragment.a(this.a).a(paramBoolean);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      i = 0;
      break;
      label152:
      i = 0;
      break label58;
      label157:
      Object localObject1 = this.a;
      label176:
      Object localObject2;
      if (PermissionPrivacyFragment.a(this.a) != null)
      {
        i = 2131694507;
        PermissionPrivacyFragment.a((PermissionPrivacyFragment)localObject1, i);
        localObject1 = this.a;
        localObject2 = this.a.a.a();
        if (paramBoolean) {
          break label225;
        }
      }
      label225:
      for (boolean bool = true;; bool = false)
      {
        PermissionPrivacyFragment.a((PermissionPrivacyFragment)localObject1, (CompoundButton)localObject2, bool);
        break;
        i = 2131719116;
        break label176;
      }
      if (paramCompoundButton == this.a.b.a())
      {
        if (paramBoolean) {}
        for (i = 1;; i = 0)
        {
          ReportController.b(null, "dc00898", "", "", "0X800B85C", "0X800B85C", i, 0, "", "0", "0", "");
          if (AppSetting.d) {
            this.a.b.setContentDescription(this.a.getString(2131699171));
          }
          localObject1 = new PermissionPrivacyFragment.9.1(this, (ContactSyncManager)PermissionPrivacyFragment.a(this.a).getManager(QQManagerFactory.MGR_SYNC_CONTACT), paramBoolean);
          localObject2 = new PermissionPrivacyFragment.9.2(this);
          if (!paramBoolean) {
            break label459;
          }
          if ((!PermissionChecker.a()) || (!VersionUtils.k())) {
            break label449;
          }
          PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)PermissionPrivacyFragment.a(this.a).getManager(QQManagerFactory.CONTACT_MANAGER);
          PermissionParam localPermissionParam = new PermissionParam();
          localPermissionParam.jdField_a_of_type_JavaLangRunnable = ((Runnable)localObject1);
          localPermissionParam.b = ((Runnable)localObject2);
          localPermissionParam.jdField_a_of_type_Int = 7;
          localPhoneContactManagerImp.a().a(this.a.getActivity(), localPermissionParam, this.a, new String[] { "android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS" });
          break;
        }
        label449:
        ((Runnable)localObject1).run();
        continue;
        label459:
        ((Runnable)localObject1).run();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PermissionPrivacyFragment.9
 * JD-Core Version:    0.7.0.1
 */