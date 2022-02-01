package com.tencent.mobileqq.guild.mainframe.container.facade;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.main.AppTroopItemShowManager;
import com.tencent.mobileqq.guild.main.QQGuildChannelView;
import com.tencent.mobileqq.guild.main.QQGuildChannelView.ConstructParams;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.AbsGestureListener;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildChatFrameGestureManager;
import com.tencent.mobileqq.guild.mainframe.container.discover.GuildDiscoverAnimationManager;
import com.tencent.qphone.base.util.QLog;

public class GuildFacadeChannelFrameController
  extends GuildFacadeFrameBaseController
{
  public final long a = 2000L;
  private final long d = 2000L;
  private final long e = 2000L;
  private long f = 2000L;
  private final QQGuildChannelView.ConstructParams g;
  private QQGuildChannelView h;
  private ViewGroup i;
  private final Handler j = new Handler(Looper.getMainLooper());
  private final Runnable k = new GuildFacadeChannelFrameController.1(this);
  private final Runnable l = new GuildFacadeChannelFrameController.2(this);
  private final Runnable m = new GuildFacadeChannelFrameController.3(this);
  private AbsGestureListener n = new GuildFacadeChannelFrameController.4(this);
  
  public GuildFacadeChannelFrameController(GuildMainViewContext paramGuildMainViewContext, ViewGroup paramViewGroup, @NonNull QQGuildChannelView.ConstructParams paramConstructParams)
  {
    super(paramGuildMainViewContext, paramConstructParams.b);
    this.i = paramViewGroup;
    this.g = paramConstructParams;
    a();
  }
  
  private void i()
  {
    QQGuildChannelView localQQGuildChannelView = this.h;
    if (localQQGuildChannelView != null) {
      localQQGuildChannelView.a(false);
    }
  }
  
  private void j()
  {
    QQGuildChannelView localQQGuildChannelView = this.h;
    if (localQQGuildChannelView != null) {
      localQQGuildChannelView.d();
    }
  }
  
  private void k()
  {
    QQGuildChannelView localQQGuildChannelView = this.h;
    if (localQQGuildChannelView != null) {
      localQQGuildChannelView.b(false);
    }
  }
  
  private void l()
  {
    Object localObject = this.h;
    if (localObject != null) {
      this.f = ((QQGuildChannelView)localObject).getLastServerLiveRefreshLimit();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateLiveRefreshTimeLimit: last limit[");
      ((StringBuilder)localObject).append(this.f);
      ((StringBuilder)localObject).append("]");
      QLog.i("GuildFacadeChannelFrameController", 1, ((StringBuilder)localObject).toString());
    }
    if (this.f == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GuildFacadeChannelFrameController", 1, "updateLiveRefreshTimeLimit: time limit can not be 0.");
      }
      this.f = 2000L;
    }
  }
  
  private void m()
  {
    n();
    this.j.postDelayed(this.k, 2000L);
  }
  
  private void n()
  {
    this.j.removeCallbacks(this.k);
  }
  
  private void o()
  {
    p();
    l();
    this.j.postDelayed(this.l, this.f);
  }
  
  private void p()
  {
    this.j.removeCallbacks(this.l);
  }
  
  private void q()
  {
    r();
    this.j.postDelayed(this.m, 2000L);
  }
  
  private void r()
  {
    this.j.removeCallbacks(this.m);
  }
  
  private void s()
  {
    QQGuildChannelView localQQGuildChannelView = this.h;
    if (localQQGuildChannelView != null) {
      localQQGuildChannelView.b();
    }
  }
  
  private void t()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GuildFacadeChannelFrameController", 1, "updateTroopInfo");
    }
    AppTroopItemShowManager.a().b();
    QQGuildChannelView localQQGuildChannelView = this.h;
    if (localQQGuildChannelView != null) {
      localQQGuildChannelView.b(true);
    }
  }
  
  public void a()
  {
    super.a();
    this.h = new QQGuildChannelView(this.c, this.g);
    this.i.setClipChildren(false);
    this.h.setClipChildren(false);
    this.i.addView(this.h);
    this.c.f().a(this.n);
  }
  
  public void a(FacadeArgsData paramFacadeArgsData)
  {
    super.a(paramFacadeArgsData);
    QQGuildChannelView localQQGuildChannelView = this.h;
    if (localQQGuildChannelView == null)
    {
      QLog.e("GuildFacadeChannelFrameController", 1, "update guild error");
      return;
    }
    localQQGuildChannelView.a(paramFacadeArgsData);
    this.h.setVisibility(0);
    t();
    if (GuildDiscoverAnimationManager.a) {
      this.h.postDelayed(new GuildFacadeChannelFrameController.5(this), 10L);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QQGuildChannelView localQQGuildChannelView = this.h;
    if (localQQGuildChannelView != null) {
      localQQGuildChannelView.c(paramBoolean);
    }
  }
  
  public void b()
  {
    super.b();
    QQGuildChannelView localQQGuildChannelView = this.h;
    if (localQQGuildChannelView != null)
    {
      localQQGuildChannelView.h();
      this.i.removeView(this.h);
      n();
      p();
      r();
    }
    this.h = null;
    this.c.f().b(this.n);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildFacadeChannelFrameController", 1, "onBeforeAccountChanged");
    }
    QQGuildChannelView localQQGuildChannelView = this.h;
    if (localQQGuildChannelView != null) {
      localQQGuildChannelView.g();
    }
  }
  
  public void d()
  {
    n();
    p();
    r();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildFacadeChannelFrameController", 1, "resume");
    }
    m();
    o();
    q();
    s();
    t();
  }
  
  public void f()
  {
    QQGuildChannelView localQQGuildChannelView = this.h;
    if (localQQGuildChannelView != null) {
      localQQGuildChannelView.setVisibility(0);
    }
    m();
    o();
    q();
  }
  
  public void g()
  {
    QQGuildChannelView localQQGuildChannelView = this.h;
    if (localQQGuildChannelView != null) {
      localQQGuildChannelView.setVisibility(8);
    }
    n();
    r();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.facade.GuildFacadeChannelFrameController
 * JD-Core Version:    0.7.0.1
 */