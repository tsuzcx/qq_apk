package com.tencent.timi.game.userinfo.impl.view;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleRegistry;
import com.tencent.timi.game.databasecore.impl.notify.DbNotifyListener;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.api.view.IUserInfoView;
import com.tencent.timi.game.userinfo.api.view.UserInfoViewWrapper;
import com.tencent.timi.game.userinfo.impl.loader.UserInfoAutoLoader;
import com.tencent.timi.game.userinfo.impl.loader.UserInfoAutoLoader.Companion;
import com.tencent.timi.game.userinfo.impl.util.UserInfoDbUtil;
import com.tencent.timi.game.userinfo.impl.util.UserInfoUtil;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;

public class UserInfoViewWrapperImpl
  extends UserInfoViewWrapper
{
  DbNotifyListener a = new UserInfoViewWrapperImpl.2(this);
  private boolean b = false;
  private IUserInfoView c;
  private long d;
  private boolean e = true;
  private LifecycleRegistry f;
  private IResultListener<IUserInfo> g = new UserInfoViewWrapperImpl.1(this);
  private IResultListener<IUserInfo> h = new UserInfoViewWrapperImpl.3(this);
  
  public UserInfoViewWrapperImpl(IUserInfoView paramIUserInfoView)
  {
    super(paramIUserInfoView);
    this.c = paramIUserInfoView;
    this.f = new LifecycleRegistry(this);
  }
  
  public static boolean b(long paramLong)
  {
    return false;
  }
  
  private void e()
  {
    if (this.d != 0L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUserInfoError ,");
      localStringBuilder.append(Logger.b(this.d));
      Logger.b("UserInfoViewWrapperImpl", localStringBuilder.toString());
      UserInfoAutoLoader.a.a().a(Long.valueOf(this.d));
    }
    this.c.d();
  }
  
  private void f()
  {
    if (!this.e) {
      return;
    }
    if ((!this.b) && (this.d != 0L))
    {
      UserInfoUtil.a.a(this.a);
      this.b = true;
      UserInfoDbUtil.a.a(this.d, this.h);
    }
  }
  
  private void g()
  {
    if (!this.e) {
      return;
    }
    UserInfoUtil.a.b(this.a);
    this.b = false;
  }
  
  public long a()
  {
    return this.d;
  }
  
  public void a(long paramLong)
  {
    a(paramLong, null, true);
  }
  
  public void a(long paramLong, IUserInfo paramIUserInfo, boolean paramBoolean)
  {
    if (paramLong == 0L)
    {
      this.d = 0L;
      this.c.c();
      return;
    }
    boolean bool1;
    if (this.d != paramLong) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = this.c.a();
    paramIUserInfo = new StringBuilder();
    paramIUserInfo.append("setUserIdWithInitUserInfo ");
    paramIUserInfo.append(bool1);
    paramIUserInfo.append(",");
    paramIUserInfo.append(bool2);
    paramIUserInfo.append(",");
    paramIUserInfo.append(Logger.b(this.d));
    Logger.a("UserInfoViewWrapperImpl", paramIUserInfo.toString());
    if ((bool1) || (this.c.a()))
    {
      this.d = paramLong;
      this.e = paramBoolean;
      f();
      if (b(paramLong))
      {
        this.c.b();
        return;
      }
      UserInfoDbUtil.a.a(this.d, this.g);
    }
  }
  
  public void b()
  {
    this.d = 0L;
    g();
  }
  
  public void c()
  {
    this.f.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    this.f.handleLifecycleEvent(Lifecycle.Event.ON_START);
    f();
  }
  
  public void d()
  {
    this.f.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    g();
  }
  
  @NonNull
  public Lifecycle getLifecycle()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.view.UserInfoViewWrapperImpl
 * JD-Core Version:    0.7.0.1
 */