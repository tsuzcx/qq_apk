package com.tencent.mobileqq.settings.message;

import android.support.v4.app.FragmentActivity;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.qvip.QVipAutoPttConfig;
import com.tencent.mobileqq.config.business.qvip.QVipAutoPttProcessor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vip.QVipConfigManager;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingFragment$31
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingFragment$31(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    int i = 1;
    if (AssistantSettingFragment.a(this.a)) {}
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if (NetworkUtil.g(this.a.getActivity())) {
        break;
      }
      QQToast.a(BaseApplication.getContext(), 1, 2131694511, 0).b(this.a.getActivity().getTitleBarHeight());
      localObject = AssistantSettingFragment.b(this.a);
      if (!paramBoolean) {
        bool = true;
      }
      ((FormSwitchItem)localObject).setChecked(bool);
    }
    Object localObject = QVipAutoPttProcessor.c();
    label136:
    label225:
    QQAppInterface localQQAppInterface;
    if ((paramBoolean) && (((QVipAutoPttConfig)localObject).a <= 1))
    {
      if (!QVipConfigManager.a(AssistantSettingFragment.a(this.a), "have_show_ptt_tip", false))
      {
        QLog.e("vip_ptt.AssistantSettingFragment", 1, "open the ptt check box and tip to user");
        AssistantSettingFragment.b(this.a);
      }
      if ((!paramBoolean) && (((QVipAutoPttConfig)localObject).a <= 1)) {
        QVipConfigManager.b(AssistantSettingFragment.a(this.a), "have_add_ptt_gray_msg", false);
      }
      AssistantSettingFragment.a(this.a, paramBoolean);
      ((CardHandler)AssistantSettingFragment.a(this.a).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).p(paramBoolean);
      ReportClickEventHelper.a(AssistantSettingFragment.a(this.a), "0X800B884", paramBoolean);
      localObject = "normal";
      if (!VipUtils.c(AssistantSettingFragment.a(this.a))) {
        break label312;
      }
      localObject = "vip";
      localQQAppInterface = AssistantSettingFragment.a(this.a);
      if (!paramBoolean) {
        break label332;
      }
    }
    for (;;)
    {
      ReportController.b(localQQAppInterface, "dc00898", "", "", "", "0X800A415", i, 0, "", "", "", (String)localObject);
      break;
      if ((!paramBoolean) || (VipUtils.b(AssistantSettingFragment.a(this.a)))) {
        break label136;
      }
      QLog.e("vip_ptt.AssistantSettingFragment", 1, "open the ptt check box but u r not svip");
      AssistantSettingFragment.c(this.a);
      AssistantSettingFragment.b(this.a).setChecked(false);
      break;
      label312:
      if (!VipUtils.b(AssistantSettingFragment.a(this.a))) {
        break label225;
      }
      localObject = "svip";
      break label225;
      label332:
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.31
 * JD-Core Version:    0.7.0.1
 */