package com.tencent.mobileqq.guild.mainframe.container.discover;

import android.content.Intent;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.container.GuildBaseContainer;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class GuildDiscoverController
  extends GuildBaseContainer
  implements QQGuildDiscoverFragment.QQGuidDiscoverAnimationListener
{
  private static final int b = ViewUtils.dpToPx(12.0F);
  private ViewGroup c = null;
  private QQGuildDiscoverFragment d;
  
  public GuildDiscoverController(GuildMainViewContext paramGuildMainViewContext)
  {
    super(paramGuildMainViewContext);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.c = paramViewGroup;
  }
  
  public void a(Object paramObject)
  {
    GuildDiscoverAnimationManager.c = true;
    l();
    if (this.d != null)
    {
      paramObject = new StringBuilder();
      paramObject.append("show. isAnimationEnd=");
      QQGuildDiscoverFragment localQQGuildDiscoverFragment = this.d;
      paramObject.append(QQGuildDiscoverFragment.a);
      paramObject.append("， shouldShowDiscoverFragment = ");
      paramObject.append(GuildDiscoverAnimationManager.c);
      QLog.i("GuildDiscover.GuildDiscoverController", 2, paramObject.toString());
      this.d.c();
    }
    this.a.a(false, b);
  }
  
  public void b(boolean paramBoolean) {}
  
  public boolean b(Object paramObject)
  {
    return false;
  }
  
  public void e()
  {
    if (this.d != null)
    {
      a().g().beginTransaction().remove(this.d).commitAllowingStateLoss();
      this.d = null;
    }
  }
  
  public void f()
  {
    super.f();
  }
  
  public void g()
  {
    QQGuildDiscoverFragment localQQGuildDiscoverFragment = this.d;
    if (localQQGuildDiscoverFragment != null) {
      localQQGuildDiscoverFragment.b();
    }
  }
  
  public int i()
  {
    return 2;
  }
  
  public void j()
  {
    GuildDiscoverAnimationManager.c = false;
    if ((this.d != null) && (QQGuildDiscoverFragment.a) && (!GuildDiscoverAnimationManager.c))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hide. isAnimationEnd=");
      QQGuildDiscoverFragment localQQGuildDiscoverFragment = this.d;
      localStringBuilder.append(QQGuildDiscoverFragment.a);
      localStringBuilder.append("， shouldShowDiscoverFragment = ");
      localStringBuilder.append(GuildDiscoverAnimationManager.c);
      QLog.i("GuildDiscover.GuildDiscoverController", 2, localStringBuilder.toString());
      this.d.d();
    }
  }
  
  public void k()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onHiddenCurFragment. isAnimationEnd=");
    QQGuildDiscoverFragment localQQGuildDiscoverFragment = this.d;
    localStringBuilder.append(QQGuildDiscoverFragment.a);
    localStringBuilder.append("， shouldShowDiscoverFragment = ");
    localStringBuilder.append(GuildDiscoverAnimationManager.c);
    QLog.i("GuildDiscover.GuildDiscoverController", 2, localStringBuilder.toString());
    if ((this.d != null) && (QQGuildDiscoverFragment.a) && (!GuildDiscoverAnimationManager.c))
    {
      this.d.d();
      return;
    }
    this.d.c();
  }
  
  protected void l()
  {
    FragmentManager localFragmentManager = a().g();
    if (this.d == null)
    {
      this.d = QQGuildDiscoverFragment.a(new Intent());
      this.d.a(this.c);
      this.d.a(a());
      localFragmentManager.beginTransaction().add(this.c.getId(), this.d, "GuildDiscoverController_QQGuildDiscoverFragment").commitAllowingStateLoss();
      this.d.a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.GuildDiscoverController
 * JD-Core Version:    0.7.0.1
 */