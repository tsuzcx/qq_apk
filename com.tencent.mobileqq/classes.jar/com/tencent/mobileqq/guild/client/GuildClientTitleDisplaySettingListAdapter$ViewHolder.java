package com.tencent.mobileqq.guild.client;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.data.IClientInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInstructionInfo;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;

class GuildClientTitleDisplaySettingListAdapter$ViewHolder
{
  private TextView a;
  private TextView b;
  private CheckBox c;
  
  public View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131625029, null);
    paramViewGroup.setTag(this);
    this.a = ((TextView)paramViewGroup.findViewById(2131430786));
    this.b = ((TextView)paramViewGroup.findViewById(2131430784));
    this.c = ((CheckBox)paramViewGroup.findViewById(2131430673));
    paramViewGroup.setOnClickListener(new GuildClientTitleDisplaySettingListAdapter.ViewHolder.1(this));
    QQGuildUtil.a(paramViewGroup, "em_sgrp_otherapp_identity_choose", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
    return paramViewGroup;
  }
  
  public void a(Context paramContext, int paramInt1, IClientInfo paramIClientInfo, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      this.a.setText(paramContext.getString(2131890237));
      this.b.setVisibility(8);
    }
    else
    {
      this.a.setText(paramIClientInfo.b());
      this.b.setText(paramIClientInfo.c().e());
    }
    this.c.setTag(Integer.valueOf(paramInt1));
    if (paramInt2 == paramInt1)
    {
      this.c.setChecked(true);
      this.c.setVisibility(0);
      return;
    }
    this.c.setChecked(false);
    this.c.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientTitleDisplaySettingListAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */