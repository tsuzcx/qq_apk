package com.tencent.mobileqq.guild.client;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GuildClientTitleDisplaySettingListAdapter$ViewHolder$1
  implements View.OnClickListener
{
  GuildClientTitleDisplaySettingListAdapter$ViewHolder$1(GuildClientTitleDisplaySettingListAdapter.ViewHolder paramViewHolder) {}
  
  public void onClick(View paramView)
  {
    if (!QQGuildUIUtil.a()) {
      ((CheckBox)paramView.findViewById(2131430673)).setChecked(true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientTitleDisplaySettingListAdapter.ViewHolder.1
 * JD-Core Version:    0.7.0.1
 */