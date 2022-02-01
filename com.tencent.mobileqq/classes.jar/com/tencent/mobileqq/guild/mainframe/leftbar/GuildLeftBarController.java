package com.tencent.mobileqq.guild.mainframe.leftbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewLifeCycle;

public class GuildLeftBarController
  extends GuildMainViewLifeCycle
{
  private View b;
  private GuildListController c;
  
  public GuildLeftBarController(GuildMainViewContext paramGuildMainViewContext, GuildLeftBarController.OnLeftBarItemCountUpdateListener paramOnLeftBarItemCountUpdateListener)
  {
    super(paramGuildMainViewContext);
    this.c = new GuildListController(paramGuildMainViewContext, paramOnLeftBarItemCountUpdateListener);
  }
  
  public void a(View paramView)
  {
    if ((this.b == null) && ((paramView instanceof ViewGroup)))
    {
      LayoutInflater localLayoutInflater = LayoutInflater.from(paramView.getContext());
      paramView = (ViewGroup)paramView;
      this.b = localLayoutInflater.inflate(2131625081, paramView, false);
      paramView.addView(this.b);
    }
    this.c.a(this.b);
  }
  
  public void b(boolean paramBoolean)
  {
    this.c.b(paramBoolean);
  }
  
  public void e()
  {
    this.c.e();
  }
  
  public void f()
  {
    this.c.f();
  }
  
  public void g()
  {
    this.c.g();
  }
  
  public GuildListController i()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.leftbar.GuildLeftBarController
 * JD-Core Version:    0.7.0.1
 */