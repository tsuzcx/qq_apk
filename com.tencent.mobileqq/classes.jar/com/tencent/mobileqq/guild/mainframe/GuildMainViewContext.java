package com.tencent.mobileqq.guild.mainframe;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildAttachContainerController;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildChatFrameGestureManager;
import com.tencent.mobileqq.guild.mainframe.container.GuildContainerController;
import com.tencent.mobileqq.guild.mainframe.leftbar.GuildLeftBarController;
import com.tencent.mobileqq.guild.mainframe.leftbar.GuildListController;
import mqq.app.AppRuntime;

public class GuildMainViewContext
{
  private GuildContextProvider a;
  
  public GuildMainViewContext(GuildContextProvider paramGuildContextProvider)
  {
    this.a = paramGuildContextProvider;
  }
  
  public <T> T a(int paramInt)
  {
    return this.a.a(paramInt);
  }
  
  public AppRuntime a()
  {
    return this.a.g();
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.a.l() == null) {
      return;
    }
    this.a.l().a(paramInt, paramObject);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.a.j().i().a(paramInt, paramString);
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    this.a.j().i().a(paramInt, paramString, paramBundle);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    Object localObject = e();
    if (localObject != null) {
      ((GuildAttachContainerController)localObject).c(paramBoolean);
    }
    localObject = d();
    if (localObject != null) {
      ((GuildContainerController)localObject).a(paramInt);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      this.a.m().e(paramBoolean1);
      return;
    }
    this.a.m().d(paramBoolean1);
  }
  
  public QBaseActivity b()
  {
    return (QBaseActivity)this.a.e();
  }
  
  public void b(int paramInt, String paramString)
  {
    this.a.j().i().a(paramInt, paramString, null);
  }
  
  public GuildLeftBarController c()
  {
    return this.a.j();
  }
  
  public GuildContainerController d()
  {
    return this.a.l();
  }
  
  public GuildAttachContainerController e()
  {
    return this.a.m();
  }
  
  public GuildChatFrameGestureManager f()
  {
    return this.a.n();
  }
  
  public FragmentManager g()
  {
    return this.a.p();
  }
  
  public DragFrameLayout h()
  {
    return this.a.o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.GuildMainViewContext
 * JD-Core Version:    0.7.0.1
 */