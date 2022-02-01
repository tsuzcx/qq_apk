package com.tencent.mobileqq.settings.message;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.config.business.qvip.QVipAutoPttConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipAutoPttProcessor;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vip.QVipConfigManager;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingFragment$35
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingFragment$35(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!AssistantSettingFragment.l(this.a)) {
      if (!NetworkUtil.isNetworkAvailable(this.a.getBaseActivity()))
      {
        QQToast.makeText(BaseApplication.getContext(), 1, 2131892158, 0).show(this.a.getBaseActivity().getTitleBarHeight());
        AssistantSettingFragment.e(this.a).setChecked(paramBoolean ^ true);
      }
      else
      {
        Object localObject = QVipAutoPttProcessor.e();
        if ((paramBoolean) && (((QVipAutoPttConfig)localObject).a <= 1))
        {
          if (!QVipConfigManager.a(AssistantSettingFragment.c(this.a), "have_show_ptt_tip", false))
          {
            QLog.e("vip_ptt.AssistantSettingFragment", 1, "open the ptt check box and tip to user");
            AssistantSettingFragment.m(this.a);
          }
        }
        else if ((paramBoolean) && (!VasUtil.b(AssistantSettingFragment.c(this.a)).getVipStatus().isSVip()))
        {
          QLog.e("vip_ptt.AssistantSettingFragment", 1, "open the ptt check box but u r not svip");
          AssistantSettingFragment.n(this.a);
          AssistantSettingFragment.e(this.a).setChecked(false);
          break label351;
        }
        if ((!paramBoolean) && (((QVipAutoPttConfig)localObject).a <= 1)) {
          QVipConfigManager.b(AssistantSettingFragment.c(this.a), "have_add_ptt_gray_msg", false);
        }
        AssistantSettingFragment.b(this.a, paramBoolean);
        ((CardHandler)AssistantSettingFragment.c(this.a).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).o(paramBoolean);
        ReportClickEventHelper.a(AssistantSettingFragment.c(this.a), "0X800B884", paramBoolean);
        if (VasUtil.b(AssistantSettingFragment.c(this.a)).getVipStatus().isVip()) {
          localObject = "vip";
        } else if (VasUtil.b(AssistantSettingFragment.c(this.a)).getVipStatus().isSVip()) {
          localObject = "svip";
        } else {
          localObject = "normal";
        }
        QQAppInterface localQQAppInterface = AssistantSettingFragment.c(this.a);
        int i;
        if (paramBoolean) {
          i = 1;
        } else {
          i = 2;
        }
        ReportController.b(localQQAppInterface, "dc00898", "", "", "", "0X800A415", i, 0, "", "", "", (String)localObject);
      }
    }
    label351:
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.35
 * JD-Core Version:    0.7.0.1
 */