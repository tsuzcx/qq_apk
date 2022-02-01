package com.tencent.open.agent.auth.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.auth.ISelectPermissionContract.View;
import com.tencent.open.agent.authority.AuthResponse;
import com.tencent.open.agent.entity.AuthMemoryCache;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.model.AccountInfo;
import org.json.JSONException;
import org.json.JSONObject;

class SelectPermissionPresenter$3$1
  implements Runnable
{
  SelectPermissionPresenter$3$1(SelectPermissionPresenter.3 param3, boolean paramBoolean, AuthResponse paramAuthResponse, int paramInt) {}
  
  public void run()
  {
    if ((this.a) && (this.b != null))
    {
      SelectPermissionPresenter.a(this.d.a, true);
      SelectPermissionPresenter.a(this.d.a, this.b.e.get(), SelectPermissionPresenter.b(this.d.a));
      SelectPermissionPresenter.b(this.d.a, this.b.e.get(), this.b.g.get());
    }
    for (;;)
    {
      try
      {
        long l1 = SystemClock.elapsedRealtime();
        long l2 = SelectPermissionPresenter.l(this.d.a);
        Object localObject1 = this.b;
        long l3 = SelectPermissionPresenter.m(this.d.a);
        long l4 = SelectPermissionPresenter.n(this.d.a);
        if (SelectPermissionPresenter.f(this.d.a) == 0L) {
          break label596;
        }
        bool = true;
        localObject1 = AuthorityUtil.a((AuthResponse)localObject1, l3, l4, l1 - l2, bool);
        SelectPermissionPresenter.a(this.d.a, this.b.a.get(), ((JSONObject)localObject1).toString(), null, null);
      }
      catch (JSONException localJSONException)
      {
        SSOLog.c("SelectPermissionPresenter", "catch JSONException", localJSONException);
      }
      int i = this.c;
      Object localObject2;
      if (i == 110509)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onDoAuthorize mAuthRetryCountBy110509=");
        ((StringBuilder)localObject2).append(SelectPermissionPresenter.o(this.d.a));
        SSOLog.a("SelectPermissionPresenter", new Object[] { ((StringBuilder)localObject2).toString() });
        if (SelectPermissionPresenter.o(this.d.a) >= 2)
        {
          SelectPermissionPresenter.p(this.d.a);
        }
        else
        {
          SelectPermissionPresenter.q(this.d.a);
          SelectPermissionPresenter.a(this.d.a, 3);
        }
        SelectPermissionPresenter.a(this.d.a, false);
      }
      else if (i == 110537)
      {
        SSOLog.a("SelectPermissionPresenter", new Object[] { "onDoAuthorize 110537" });
        AuthUIUtil.a(SelectPermissionPresenter.k(this.d.a), HardCodeUtil.a(2131905671), false);
        SelectPermissionPresenter.p(this.d.a);
      }
      else if (i == 100044)
      {
        localObject2 = AuthMemoryCache.a().d(SelectPermissionPresenter.b(this.d.a));
        String str1 = SelectPermissionPresenter.k(this.d.a).getIntent().getStringExtra("packagename");
        String str2 = SelectPermissionPresenter.k(this.d.a).getIntent().getStringExtra("packagesign");
        AuthReporter.a(((AccountInfo)localObject2).a, SelectPermissionPresenter.b(this.d.a), str1, str2);
        localObject2 = AuthorityUtil.a(this.b, SelectPermissionPresenter.k(this.d.a).getResources(), this.c);
        AuthUIUtil.a(SelectPermissionPresenter.k(this.d.a), (String)localObject2, new SelectPermissionPresenter.3.1.1(this));
      }
      else
      {
        localObject2 = AuthorityUtil.a(this.b, SelectPermissionPresenter.k(this.d.a).getResources(), this.c);
        AuthUIUtil.a(SelectPermissionPresenter.k(this.d.a), (String)localObject2, false);
        SelectPermissionPresenter.a(this.d.a, false);
      }
      SelectPermissionPresenter.c(this.d.a).b();
      return;
      label596:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.SelectPermissionPresenter.3.1
 * JD-Core Version:    0.7.0.1
 */