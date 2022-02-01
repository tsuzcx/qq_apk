package com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.nickitem;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import mqq.app.AppRuntime;

public abstract class AbsGuildNickLayoutItem
{
  protected Context a;
  protected AppRuntime b;
  
  public AbsGuildNickLayoutItem(Context paramContext, AppRuntime paramAppRuntime)
  {
    this.a = paramContext;
    this.b = paramAppRuntime;
  }
  
  public abstract View a();
  
  public abstract void a(AbsGuildNickLayoutItem.Data paramData);
  
  public ViewGroup.LayoutParams b()
  {
    return new ViewGroup.LayoutParams(-2, -2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.nickitem.AbsGuildNickLayoutItem
 * JD-Core Version:    0.7.0.1
 */