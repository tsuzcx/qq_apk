package com.tencent.open.agent.auth.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.agent.auth.ISelectPermissionContract.Presenter;
import com.tencent.open.agent.auth.ISelectPermissionContract.View;
import com.tencent.open.agent.auth.model.ILocalDataSource;
import com.tencent.open.agent.authority.AuthCallback;
import com.tencent.open.agent.entity.AuthMemoryCache;
import com.tencent.open.agent.entity.Permission;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.ParseUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.model.AccountManage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class SelectPermissionPresenter
  implements ISelectPermissionContract.Presenter
{
  private AppRuntime a;
  private ILocalDataSource b;
  private ISelectPermissionContract.View c;
  private int d;
  private List<Permission> e = new ArrayList();
  private long f;
  private long g;
  private long h;
  private long i;
  private long j;
  private long k;
  private String l;
  private boolean m;
  private Activity n;
  private AuthCallback o = new SelectPermissionPresenter.3(this);
  
  public SelectPermissionPresenter(ISelectPermissionContract.View paramView, ILocalDataSource paramILocalDataSource)
  {
    this.c = paramView;
    this.n = paramView.c();
    this.b = paramILocalDataSource;
    this.a = MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  private void a(int paramInt)
  {
    AccountInfo localAccountInfo = AuthMemoryCache.a().d(g());
    AccountManage.a().a(localAccountInfo.a, g(), paramInt, new SelectPermissionPresenter.4(this));
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    Object localObject = AuthMemoryCache.a().d(g());
    AuthReporter.a(paramInt, (AccountInfo)localObject);
    String str = g();
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = ((AccountInfo)localObject).a;
    }
    AuthReporter.a(paramInt, str, (String)localObject);
    localObject = new Intent();
    ((Intent)localObject).putExtra("key_cancel_auth", 0);
    ((Intent)localObject).putExtra("key_error_code", paramInt);
    ((Intent)localObject).putExtra("key_error_msg", paramString2);
    ((Intent)localObject).putExtra("key_error_detail", paramString3);
    ((Intent)localObject).putExtra("key_response", paramString1);
    SSOLog.a("SelectPermissionPresenter", new Object[] { "OpenVirtual.setSdkResult, error: ", Integer.valueOf(paramInt), ", msg:", paramString2, ", detail:", paramString3 });
    this.n.setResult(102, (Intent)localObject);
    this.n.finish();
    this.c.b();
  }
  
  private void a(String paramString1, String paramString2)
  {
    AccountInfo localAccountInfo = AuthMemoryCache.a().d(paramString2);
    if (localAccountInfo != null) {
      this.b.a(paramString1, paramString2, localAccountInfo.a);
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    this.b.a(paramString1, paramString2);
  }
  
  private void b(boolean paramBoolean)
  {
    AccountInfo localAccountInfo = AuthMemoryCache.a().d(g());
    AuthReporter.a("KEY_AUTHORIZE_REQUEST", localAccountInfo, paramBoolean);
    if ((localAccountInfo != null) && (localAccountInfo.a != null))
    {
      String str;
      if (paramBoolean) {
        str = "0X800B65E";
      } else {
        str = "0X800B65F";
      }
      AuthReporter.a(localAccountInfo.a, str);
    }
    if (paramBoolean) {
      AuthorityUtil.e("0X800BA80");
    }
  }
  
  private void d()
  {
    AccountInfo localAccountInfo = AuthMemoryCache.a().d(g());
    AuthReporter.a("KEY_LOGIN_STAGE_2_NEW_TOTAL", localAccountInfo);
    AuthReporter.a("KEY_LOGIN_STAGE_2_2_NEW_TOTAL", localAccountInfo);
    AuthReporter.a("KEY_LOGIN_STAGE_3_TOTAL");
    this.c.a();
    ThreadManager.executeOnNetWorkThread(new SelectPermissionPresenter.2(this));
  }
  
  private void e()
  {
    AuthUIUtil.a(this.n, HardCodeUtil.a(2131905669), false);
    if (f())
    {
      SSOLog.a("SelectPermissionPresenter", new Object[] { "finishAndToLogin but Activity isFinishing" });
      return;
    }
    SSOLog.a("SelectPermissionPresenter", new Object[] { "finishAndToLogin" });
    Intent localIntent = new Intent();
    localIntent.putExtra("key_need_login", 1);
    this.n.setResult(102, localIntent);
    this.n.finish();
  }
  
  private boolean f()
  {
    Activity localActivity = this.n;
    return (localActivity == null) || (localActivity.isFinishing());
  }
  
  private String g()
  {
    long l2 = this.g;
    long l1 = l2;
    if (l2 == 0L) {
      l1 = this.f;
    }
    return String.valueOf(l1);
  }
  
  private String h()
  {
    return String.valueOf(this.f);
  }
  
  public List<Permission> a()
  {
    Object localObject = AuthMemoryCache.a().e(g());
    if (localObject == null) {
      return null;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Permission localPermission1 = (Permission)((Iterator)localObject).next();
      Permission localPermission2 = new Permission();
      localPermission2.a = localPermission1.a;
      if ((localPermission2.a == 2) || (localPermission2.a == 3))
      {
        localPermission2.d = localPermission1.d;
        localPermission2.e = localPermission1.e;
        localPermission2.c = localPermission1.c;
        localPermission2.b = localPermission1.b;
        boolean bool;
        if (localPermission2.a == 2) {
          bool = true;
        } else {
          bool = false;
        }
        localPermission2.f = bool;
        this.e.add(localPermission2);
      }
    }
    return this.e;
  }
  
  public void a(Intent paramIntent)
  {
    this.l = paramIntent.getStringExtra("pkg_name");
    this.m = paramIntent.getBooleanExtra("is_from_qr_login", false);
    this.k = paramIntent.getLongExtra("vid", 0L);
    this.f = ParseUtil.a(paramIntent.getStringExtra("appId"));
    this.g = ParseUtil.a(paramIntent.getStringExtra("key_proxy_appid"));
    this.j = paramIntent.getLongExtra("login_cost", 0L);
    this.i = paramIntent.getLongExtra("authListCostTime", 0L);
    this.h = paramIntent.getLongExtra("authStartTime", SystemClock.elapsedRealtime());
    SSOLog.a("SelectPermissionPresenter", new Object[] { "onCreateView3 mCurrentAppId=", Long.valueOf(this.f), ", mProxyCurrentAppId=", Long.valueOf(this.g), ", mIsFromQrLogin=", Boolean.valueOf(this.m) });
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    ThreadManager.executeOnFileThread(new SelectPermissionPresenter.1(this));
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(((Permission)localIterator.next()).b);
      localStringBuilder.append(" ");
    }
    return localStringBuilder.toString();
  }
  
  public void c()
  {
    SSOLog.a("SelectPermissionPresenter", new Object[] { "doAuth" });
    this.d = 0;
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.SelectPermissionPresenter
 * JD-Core Version:    0.7.0.1
 */