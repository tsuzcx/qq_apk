package com.tencent.mobileqq.settings.message;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.fragment.BottomTabSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingFragment$32
  implements View.OnClickListener
{
  AssistantSettingFragment$32(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.setFlags(268435456);
    PublicFragmentActivity.Launcher.a(paramView.getContext(), localIntent, PublicFragmentActivity.class, BottomTabSettingFragment.class);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.32
 * JD-Core Version:    0.7.0.1
 */