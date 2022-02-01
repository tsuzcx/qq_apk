package com.tencent.mobileqq.settings.message;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.dialogutils.TipsDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingFragment$5
  implements View.OnClickListener
{
  AssistantSettingFragment$5(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onClick(View paramView)
  {
    new TipsDialog(this.a.getActivity()).a(this.a.getActivity().getString(2131695297)).b(this.a.getActivity().getString(2131695296)).c(this.a.getActivity().getString(2131692958)).show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.5
 * JD-Core Version:    0.7.0.1
 */