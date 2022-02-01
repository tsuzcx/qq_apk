package com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.nickitem;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import mqq.app.AppRuntime;

public class GuildLiveNickLayoutRobotItem
  extends NickLayoutRobotItem
{
  public GuildLiveNickLayoutRobotItem(Context paramContext, AppRuntime paramAppRuntime)
  {
    super(paramContext, paramAppRuntime);
  }
  
  public View a()
  {
    View localView = super.a();
    this.c.setBackgroundResource(2130840893);
    Resources localResources = this.c.getContext().getResources();
    this.c.setTextColor(localResources.getColor(2131166216));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.nickitem.GuildLiveNickLayoutRobotItem
 * JD-Core Version:    0.7.0.1
 */