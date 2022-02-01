package com.tencent.mobileqq.guild.client;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GuildClientSelectRoleListAdapter$RoleItemViewHolder$1
  implements View.OnClickListener
{
  GuildClientSelectRoleListAdapter$RoleItemViewHolder$1(GuildClientSelectRoleListAdapter.RoleItemViewHolder paramRoleItemViewHolder) {}
  
  public void onClick(View paramView)
  {
    ((CheckBox)paramView.findViewById(2131430681)).setChecked(true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientSelectRoleListAdapter.RoleItemViewHolder.1
 * JD-Core Version:    0.7.0.1
 */