package com.tencent.mobileqq.settings.message;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.dialogutils.TipsDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingFragment$5
  implements View.OnClickListener
{
  AssistantSettingFragment$5(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onClick(View paramView)
  {
    new TipsDialog(this.a.getBaseActivity()).a(this.a.getBaseActivity().getString(2131893041)).b(this.a.getBaseActivity().getString(2131893040)).c(this.a.getBaseActivity().getString(2131890029)).show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.5
 * JD-Core Version:    0.7.0.1
 */