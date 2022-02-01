package cooperation.vip.impl;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.webview.swift.WebViewWrapper;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.vip.VasAdvAppInterface;
import cooperation.vip.VasAdvAppInterface.DefaultImpls;
import cooperation.vip.VasAdvCallback;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcooperation/vip/impl/VasAdvAppImpl;", "Lcooperation/vip/VasAdvAppInterface;", "()V", "isTbsInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "account", "", "context", "Landroid/content/Context;", "execute", "", "runnable", "Ljava/lang/Runnable;", "networkJob", "", "autoRetrieve", "initJsEnvironment", "webView", "Landroid/view/View;", "initTbsEnvironment", "isAppInstalled", "pkgName", "", "postDelayed", "delay", "preloadWebView", "runOnUiThread", "sendCmd", "cmd", "cmdKey", "reqBytes", "", "callback", "Lcooperation/vip/VasAdvCallback;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasAdvAppImpl
  implements VasAdvAppInterface
{
  private final AtomicBoolean a = new AtomicBoolean(false);
  
  private final void a(View paramView)
  {
    if (!(paramView instanceof TouchWebView)) {
      paramView = null;
    }
    for (;;)
    {
      VasAdvAppInterface.DefaultImpls.a(this, (Runnable)new VasAdvAppImpl.initJsEnvironment.1((TouchWebView)paramView), false, false, 6, null);
      return;
    }
  }
  
  public long a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
    localObject = ((BaseApplicationImpl)localObject).getRuntime();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication().runtime");
    return ((AppRuntime)localObject).getLongAccountUin();
  }
  
  @NotNull
  public Context a()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.context;
    Intrinsics.checkExpressionValueIsNotNull(localBaseApplication, "BaseApplicationImpl.context");
    return (Context)localBaseApplication;
  }
  
  @Nullable
  public View a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
    localObject = ((BaseApplicationImpl)localObject).getRuntime();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.common.app.AppInterface");
    }
    localObject = (AppInterface)localObject;
    Intent localIntent = new Intent();
    localIntent.putExtra("ignoreLoginWeb", true);
    localObject = new WebViewWrapper((AppRuntime)localObject, null, localIntent, a(), true).a();
    a((View)localObject);
    ((TouchWebView)localObject).setBackgroundColor(0);
    ((TouchWebView)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    ((TouchWebView)localObject).setVisibility(8);
    return (View)localObject;
  }
  
  public void a()
  {
    if (this.a.compareAndSet(false, true)) {
      VasAdvAppInterface.DefaultImpls.a(this, (Runnable)new VasAdvAppImpl.initTbsEnvironment.1(this), false, false, 6, null);
    }
  }
  
  public void a(@NotNull Runnable paramRunnable, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramRunnable, "runnable");
    ThreadManager.getUIHandler().postDelayed(paramRunnable, paramLong);
  }
  
  public void a(@NotNull Runnable paramRunnable, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramRunnable, "runnable");
    if (paramBoolean1) {}
    for (int i = 128;; i = 16)
    {
      ThreadManager.excute(paramRunnable, i, null, paramBoolean2);
      return;
    }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.impl.VasAdvAppImpl
 * JD-Core Version:    0.7.0.1
 */