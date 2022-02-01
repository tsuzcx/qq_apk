package com.tencent.mobileqq.vas.adv.base.support.app;

import android.content.Context;
import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/base/support/app/VasAdvAppInterface;", "", "account", "", "context", "Landroid/content/Context;", "execute", "", "runnable", "Ljava/lang/Runnable;", "networkJob", "", "autoRetrieve", "initTbsEnvironment", "isAppInstalled", "pkgName", "", "postDelayed", "delay", "preloadWebView", "Landroid/view/View;", "runOnUiThread", "sendCmd", "cmd", "cmdKey", "reqBytes", "", "callback", "Lcom/tencent/mobileqq/vas/adv/base/support/app/VasAdvCallback;", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface VasAdvAppInterface
{
  public abstract long a();
  
  public abstract void a(@NotNull Runnable paramRunnable, long paramLong);
  
  public abstract void a(@NotNull Runnable paramRunnable, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull byte[] paramArrayOfByte, @NotNull VasAdvCallback paramVasAdvCallback);
  
  public abstract boolean a(@NotNull Context paramContext, @Nullable String paramString);
  
  @NotNull
  public abstract Context b();
  
  public abstract void c();
  
  @Nullable
  public abstract View d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.base.support.app.VasAdvAppInterface
 * JD-Core Version:    0.7.0.1
 */