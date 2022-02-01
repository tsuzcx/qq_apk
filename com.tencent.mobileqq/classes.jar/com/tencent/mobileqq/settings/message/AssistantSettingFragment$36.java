package com.tencent.mobileqq.settings.message;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.fragment.BottomTabSettingFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingFragment$36
  implements View.OnClickListener
{
  AssistantSettingFragment$36(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.setFlags(268435456);
    localIntent.putExtra("KEY_ENTRANCE", "VALUE_QQ_SETTING_FRAGMENT");
    QPublicFragmentActivity.Launcher.a(paramView.getContext(), localIntent, QPublicFragmentActivity.class, BottomTabSettingFragment.class);
    ReportController.b(BaseApplicationImpl.getApplication().getRuntime(), "CliOper", "", "", "bottom_tab", "entrance_clk", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.36
 * JD-Core Version:    0.7.0.1
 */