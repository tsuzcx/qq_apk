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

class AssistantSettingFragment$32
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingFragment$32(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!AssistantSettingFragment.a(this.a)) {
      if (!NetworkUtil.isNetworkAvailable(this.a.getBaseActivity()))
      {
        QQToast.a(BaseApplication.getContext(), 1, 2131694476, 0).b(this.a.getBaseActivity().getTitleBarHeight());
        AssistantSettingFragment.b(this.a).setChecked(paramBoolean ^ true);
      }
      else
      {
        Object localObject = QVipAutoPttProcessor.c();
        if ((paramBoolean) && (((QVipAutoPttConfig)localObject).a <= 1))
        {
          if (!QVipConfigManager.a(AssistantSettingFragment.a(this.a), "have_show_ptt_tip", false))
          {
            QLog.e("vip_ptt.AssistantSettingFragment", 1, "open the ptt check box and tip to user");
            AssistantSettingFragment.b(this.a);
          }
        }
        else if ((paramBoolean) && (!VasUtil.a(AssistantSettingFragment.a(this.a)).getVipStatus().isSVip()))
        {
          QLog.e("vip_ptt.AssistantSettingFragment", 1, "open the ptt check box but u r not svip");
          AssistantSettingFragment.c(this.a);
          AssistantSettingFragment.b(this.a).setChecked(false);
          break label351;
        }
        if ((!paramBoolean) && (((QVipAutoPttConfig)localObject).a <= 1)) {
          QVipConfigManager.b(AssistantSettingFragment.a(this.a), "have_add_ptt_gray_msg", false);
        }
        AssistantSettingFragment.a(this.a, paramBoolean);
        ((CardHandler)AssistantSettingFragment.a(this.a).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).p(paramBoolean);
        ReportClickEventHelper.a(AssistantSettingFragment.a(this.a), "0X800B884", paramBoolean);
        if (VasUtil.a(AssistantSettingFragment.a(this.a)).getVipStatus().isVip()) {
          localObject = "vip";
        } else if (VasUtil.a(AssistantSettingFragment.a(this.a)).getVipStatus().isSVip()) {
          localObject = "svip";
        } else {
          localObject = "normal";
        }
        QQAppInterface localQQAppInterface = AssistantSettingFragment.a(this.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.32
 * JD-Core Version:    0.7.0.1
 */