package com.tencent.mobileqq.settings.fragment;

import android.support.v4.app.FragmentActivity;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class PrivacyShowSettingFragment$6
  implements CompoundButton.OnCheckedChangeListener
{
  PrivacyShowSettingFragment$6(PrivacyShowSettingFragment paramPrivacyShowSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (((paramCompoundButton == PrivacyShowSettingFragment.c(this.a).a()) || (paramCompoundButton == PrivacyShowSettingFragment.d(this.a).a())) && (!NetworkUtil.d(this.a.getActivity())))
    {
      this.a.a(2131694507, 1);
      localObject = this.a;
      if (!paramBoolean)
      {
        bool = true;
        PrivacyShowSettingFragment.a((PrivacyShowSettingFragment)localObject, paramCompoundButton, bool);
      }
    }
    label222:
    label364:
    label495:
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
        return;
        bool = false;
        break;
        if (paramCompoundButton != PrivacyShowSettingFragment.c(this.a).a()) {
          break label222;
        }
        if (AppSetting.d) {
          PrivacyShowSettingFragment.c(this.a).setContentDescription(HardCodeUtil.a(2131707906));
        }
        PrivacyShowSettingFragment.a(this.a, PrivacyShowSettingFragment.c(this.a).a(), paramBoolean);
        this.a.a.setVisibilityForNetWorkStatus(paramBoolean, true);
        if (paramBoolean) {
          ReportController.b(this.a.a, "dc00898", "", "", "0X800B862", "0X800B862", 1, 0, "", "", "", "");
        } else {
          ReportController.b(this.a.a, "dc00898", "", "", "0X800B862", "0X800B862", 0, 0, "", "", "", "");
        }
      }
      if (paramCompoundButton == PrivacyShowSettingFragment.d(this.a).a())
      {
        localObject = this.a.a;
        if (paramBoolean) {}
        for (i = 1;; i = 0)
        {
          ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800B863", "0X800B863", i, 0, "", "", "", "");
          if (AppSetting.d) {
            PrivacyShowSettingFragment.d(this.a).setContentDescription(HardCodeUtil.a(2131707897));
          }
          PrivacyShowSettingFragment.a(this.a, PrivacyShowSettingFragment.d(this.a).a(), paramBoolean);
          this.a.a.setVisibilityForInputStatus(paramBoolean, true);
          break;
        }
      }
      if (paramCompoundButton == PrivacyShowSettingFragment.a(this.a).a())
      {
        localObject = this.a.a;
        if (paramBoolean)
        {
          i = 1;
          ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800B864", "0X800B864", i, 0, "", "", "", "");
          if (!NetworkUtil.d(this.a.a.getApplication().getApplicationContext()))
          {
            QQToast.a(this.a.getActivity().getApplicationContext(), 2131719116, 1).a();
            localObject = this.a;
            if (paramBoolean) {
              break label489;
            }
            bool = true;
            PrivacyShowSettingFragment.a((PrivacyShowSettingFragment)localObject, paramCompoundButton, bool);
          }
          localObject = (CardHandler)this.a.a.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
          if (paramBoolean) {
            break label495;
          }
        }
        for (bool = true;; bool = false)
        {
          ((CardHandler)localObject).k(bool);
          break;
          i = 0;
          break label364;
          bool = false;
          break label441;
        }
      }
    } while (paramCompoundButton != PrivacyShowSettingFragment.e(this.a).a());
    label441:
    label489:
    Object localObject = this.a.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800B86A", "0X800B86A", i, 0, "", "", "", "");
      if (!NetworkUtil.d(this.a.getActivity())) {
        break label617;
      }
      if (AppSetting.d) {
        PrivacyShowSettingFragment.e(this.a).setContentDescription(HardCodeUtil.a(2131707907));
      }
      ((CardHandler)this.a.a.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).i(paramBoolean);
      break;
    }
    label617:
    localObject = this.a;
    label636:
    Switch localSwitch;
    if (PrivacyShowSettingFragment.a(this.a) != null)
    {
      i = 2131694507;
      PrivacyShowSettingFragment.a((PrivacyShowSettingFragment)localObject, i);
      localObject = this.a;
      localSwitch = PrivacyShowSettingFragment.e(this.a).a();
      if (paramBoolean) {
        break label685;
      }
    }
    label685:
    for (boolean bool = true;; bool = false)
    {
      PrivacyShowSettingFragment.a((PrivacyShowSettingFragment)localObject, localSwitch, bool);
      break;
      i = 2131719116;
      break label636;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PrivacyShowSettingFragment.6
 * JD-Core Version:    0.7.0.1
 */