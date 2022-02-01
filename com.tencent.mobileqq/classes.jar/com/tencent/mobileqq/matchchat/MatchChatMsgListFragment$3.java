package com.tencent.mobileqq.matchchat;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MatchChatMsgListFragment$3
  implements View.OnClickListener
{
  MatchChatMsgListFragment$3(MatchChatMsgListFragment paramMatchChatMsgListFragment) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.a, "dc00898", "", "", "0X800A698", "0X800A698", 0, 0, "", "", "", "");
    Intent localIntent = new Intent();
    PublicFragmentActivity.a(this.a.getActivity(), localIntent, MatchChatSettingFragment.class);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatMsgListFragment.3
 * JD-Core Version:    0.7.0.1
 */