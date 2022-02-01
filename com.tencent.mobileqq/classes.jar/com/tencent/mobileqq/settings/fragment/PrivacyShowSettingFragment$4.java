package com.tencent.mobileqq.settings.fragment;

import android.support.v4.app.FragmentActivity;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class PrivacyShowSettingFragment$4
  implements CompoundButton.OnCheckedChangeListener
{
  PrivacyShowSettingFragment$4(PrivacyShowSettingFragment paramPrivacyShowSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = true;
    Object localObject = this.a.a;
    int i;
    if (paramBoolean)
    {
      i = 1;
      ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800B866", "0X800B866", i, 0, "", "", "", "");
      if (NetworkUtil.g(this.a.getActivity())) {
        break label120;
      }
      QQToast.a(BaseApplication.getContext(), 1, 2131694511, 0).b(this.a.getActivity().getTitleBarHeight());
      localObject = PrivacyShowSettingFragment.b(this.a);
      if (paramBoolean) {
        break label114;
      }
      label93:
      ((FormSwitchItem)localObject).setChecked(bool);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      i = 0;
      break;
      label114:
      bool = false;
      break label93;
      label120:
      ((CardHandler)this.a.a.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).g(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PrivacyShowSettingFragment.4
 * JD-Core Version:    0.7.0.1
 */