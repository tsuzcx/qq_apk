package com.tencent.mobileqq.vas.adv.base.support.app;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.vas.adv.base.servlet.VasAdvServlet;
import com.tencent.mobileqq.vas.adv.base.servlet.VasAdvServlet.Companion;
import com.tencent.mobileqq.webview.swift.WebViewWrapper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebAccelerator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/base/support/app/VasAdvAppImpl;", "Lcom/tencent/mobileqq/vas/adv/base/support/app/VasAdvAppInterface;", "()V", "isTbsInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "account", "", "context", "Landroid/content/Context;", "execute", "", "runnable", "Ljava/lang/Runnable;", "networkJob", "", "autoRetrieve", "getAppRuntime", "Lmqq/app/AppRuntime;", "initJsEnvironment", "webView", "Landroid/view/View;", "initTbsEnvironment", "initTbsEnvironmentImpl", "isAppInstalled", "pkgName", "", "atomic", "postDelayed", "delay", "preloadWebView", "runOnUiThread", "sendCmd", "cmd", "cmdKey", "reqBytes", "", "callback", "Lcom/tencent/mobileqq/vas/adv/base/support/app/VasAdvCallback;", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasAdvAppImpl
  implements VasAdvAppInterface
{
  private final AtomicBoolean a = new AtomicBoolean(false);
  
  private final void a(View paramView)
  {
    View localView = paramView;
    if (!(paramView instanceof TouchWebView)) {
      localView = null;
    }
    VasAdvAppInterface.DefaultImpls.a(this, (Runnable)new VasAdvAppImpl.initJsEnvironment.1(this, (TouchWebView)localView), false, false, 6, null);
  }
  
  private final boolean a(AtomicBoolean paramAtomicBoolean)
  {
    return paramAtomicBoolean.compareAndSet(false, true);
  }
  
  private final void e()
  {
    Boolean localBoolean = Boolean.valueOf(true);
    QbSdk.initTbsSettings(MapsKt.mutableMapOf(new Pair[] { TuplesKt.to("use_speedy_classloader", localBoolean), TuplesKt.to("use_dexloader_service", localBoolean) }));
    WebAccelerator.initTbsEnvironment(b(), 2);
  }
  
  private final AppRuntime f()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    Intrinsics.checkExpressionValueIsNotNull(localAppRuntime, "MobileQQ.sMobileQQ.waitAppRuntime(null)");
    return localAppRuntime;
  }
  
  public long a()
  {
    return f().getLongAccountUin();
  }
  
  public void a(@NotNull Runnable paramRunnable, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramRunnable, "runnable");
    ThreadManager.getUIHandler().postDelayed(paramRunnable, paramLong);
  }
  
  public void a(@NotNull Runnable paramRunnable, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramRunnable, "runnable");
    int i;
    if (paramBoolean1) {
      i = 128;
    } else {
      i = 16;
    }
    ThreadManager.excute(paramRunnable, i, null, paramBoolean2);
  }
  
  public void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull byte[] paramArrayOfByte, @NotNull VasAdvCallback paramVasAdvCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "cmd");
    Intrinsics.checkParameterIsNotNull(paramString2, "cmdKey");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "reqBytes");
    Intrinsics.checkParameterIsNotNull(paramVasAdvCallback, "callback");
    VasAdvServlet.a.a(paramString1, paramString2, paramArrayOfByte, paramVasAdvCallback);
  }
  
  public boolean a(@NotNull Context paramContext, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return PackageUtil.a(paramContext, paramString);
  }
  
  @NotNull
  public Context b()
  {
    BaseApplication localBaseApplication = MobileQQ.context;
    Intrinsics.checkExpressionValueIsNotNull(localBaseApplication, "MobileQQ.context");
    return (Context)localBaseApplication;
  }
  
  public void c()
  {
    if (a(this.a)) {
      VasAdvAppInterface.DefaultImpls.a(this, (Runnable)new VasAdvAppImpl.initTbsEnvironment.1(this), false, false, 6, null);
    }
  }
  
  @Nullable
  public View d()
  {
    Object localObject1 = f();
    if (localObject1 != null)
    {
      localObject1 = (AppInterface)localObject1;
      Object localObject2 = new Intent();
      ((Intent)localObject2).putExtra("ignoreLoginWeb", true);
      localObject1 = new WebViewWrapper((AppRuntime)localObject1, null, (Intent)localObject2, b(), true).c();
      localObject2 = (View)localObject1;
      a((View)localObject2);
      ((TouchWebView)localObject1).setBackgroundColor(0);
      ((TouchWebView)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      ((TouchWebView)localObject1).setVisibility(8);
      return localObject2;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.common.app.AppInterface");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.base.support.app.VasAdvAppImpl
 * JD-Core Version:    0.7.0.1
 */