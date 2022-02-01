package com.tencent.mtt.hippy.a;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mtt.hippy.HippyGlobalConfigs;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.UIThreadUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import java.util.HashMap;
import java.util.Stack;

public class k
  implements View.OnClickListener, c.a, m, o.a
{
  j a;
  g b;
  ProgressDialog c;
  c d;
  private h e;
  private HashMap<Context, e> f;
  private Stack<e> g;
  private o h;
  
  k(HippyGlobalConfigs paramHippyGlobalConfigs, String paramString1, String paramString2)
  {
    this.a = new j(paramHippyGlobalConfigs, paramString1);
    this.e = new h(paramString1, paramString2);
    this.g = new Stack();
    this.f = new HashMap();
    this.h = new o(this.a);
  }
  
  private void f()
  {
    Context localContext = null;
    if (this.g.size() > 0) {
      localContext = ((e)this.g.peek()).getContext();
    }
    if (localContext == null) {
      return;
    }
    if (this.c == null)
    {
      this.c = new ReportProgressDialog(localContext);
      this.c.setCancelable(true);
      this.c.setProgressStyle(0);
    }
    this.c.show();
  }
  
  public void a()
  {
    b();
  }
  
  public void a(HippyRootView paramHippyRootView)
  {
    LogUtils.d("DevServerImpl", "hippy DevServerImpl attachToHost");
    Context localContext = paramHippyRootView.getHost();
    e locale = new e(localContext);
    locale.setOnClickListener(this);
    if ((localContext instanceof Activity)) {
      ((ViewGroup)((Activity)localContext).getWindow().getDecorView()).addView(locale);
    }
    for (;;)
    {
      this.f.put(localContext, locale);
      this.g.push(locale);
      return;
      paramHippyRootView.addView(locale);
    }
  }
  
  public void a(f paramf)
  {
    f();
    this.a.a(new k.2(this), this.e.d(), this.e.c(), this.e.b(), this.e.a());
  }
  
  public void a(g paramg)
  {
    this.b = paramg;
  }
  
  public void a(Throwable paramThrowable)
  {
    if (this.c != null) {
      this.c.dismiss();
    }
    if (this.g.size() <= 0) {}
    while ((this.d != null) && (this.d.isShowing())) {
      return;
    }
    UIThreadUtils.runOnUiThread(new k.3(this, paramThrowable));
  }
  
  public void b()
  {
    a(null);
  }
  
  public void b(HippyRootView paramHippyRootView)
  {
    LogUtils.d("DevServerImpl", "hippy DevServerImpl detachFromHost");
    Object localObject = paramHippyRootView.getHost();
    paramHippyRootView = (e)this.f.get(localObject);
    if (paramHippyRootView != null)
    {
      this.g.remove(paramHippyRootView);
      this.f.remove(localObject);
      localObject = paramHippyRootView.getParent();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView(paramHippyRootView);
      }
    }
  }
  
  void c()
  {
    if (this.e.e())
    {
      this.h.a(this);
      return;
    }
    this.h.a();
  }
  
  public void d()
  {
    b();
  }
  
  public void e()
  {
    b();
  }
  
  public void onClick(View paramView)
  {
    boolean bool = this.e.e();
    if ((paramView.getContext() instanceof Application))
    {
      LogUtils.e("DevServerImpl", "Hippy context is an Application, so can not show a dialog!");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramView.getContext());
    if (bool) {}
    for (String str = "Disable Live Reload";; str = "Enable Live Reload")
    {
      k.1 local1 = new k.1(this, bool);
      localBuilder.setItems(new String[] { "Reload", str }, local1).show();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.a.k
 * JD-Core Version:    0.7.0.1
 */