package com.tencent.mobileqq.qqexpand.plugin.entrance;

import android.net.TrafficStats;
import com.tencent.mobileqq.qqexpand.utils.ILog;
import com.tencent.mobileqq.qqexpand.utils.LogUtils;
import com.tencent.mobileqq.qroute.module.IQRoutePluginInstallListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/qqexpand/plugin/entrance/ExpandPluginLauncher$installPlugin$1", "Lcom/tencent/mobileqq/qroute/module/IQRoutePluginInstallListener;", "onInstallBegin", "", "p0", "", "onInstallDownloadProgress", "p1", "", "p2", "onInstallError", "onInstallFinish", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandPluginLauncher$installPlugin$1
  implements IQRoutePluginInstallListener
{
  public void onInstallBegin(@Nullable String paramString)
  {
    paramString = LogUtils.a;
    if (QLog.isColorLevel()) {
      paramString.a().a("ExpandPluginLauncher", 2, "onInstallBegin");
    }
    paramString = (ExpandPluginLoadingFragment)ExpandPluginLauncher.a(this.a).get();
    if (paramString != null) {
      ExpandPluginLoadingFragment.a(paramString, LoadingStatus.LOADING, 0, 0, 6, null);
    }
  }
  
  public void onInstallDownloadProgress(@Nullable String paramString, int paramInt1, int paramInt2)
  {
    ExpandPluginLauncher.b(this.a, true);
    ExpandPluginLauncher.c(this.a, true);
    Object localObject = (ExpandPluginLoadingFragment)ExpandPluginLauncher.a(this.a).get();
    if (localObject != null) {
      ((ExpandPluginLoadingFragment)localObject).b();
    }
    if (ExpandPluginLauncher.e(this.a) == 0L) {
      ExpandPluginLauncher.a(this.a, TrafficStats.getTotalRxBytes());
    }
    double d1 = paramInt1;
    Double.isNaN(d1);
    double d2 = paramInt2;
    Double.isNaN(d2);
    d1 = d1 * 1.0D / d2;
    d2 = 100;
    Double.isNaN(d2);
    int i = (int)(d1 * d2);
    localObject = LogUtils.a;
    if (QLog.isColorLevel())
    {
      localObject = ((LogUtils)localObject).a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInstallDownloadProgress ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(' ');
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(' ');
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(' ');
      localStringBuilder.append(i);
      ((ILog)localObject).a("ExpandPluginLauncher", 2, localStringBuilder.toString());
    }
    if (i == 100)
    {
      paramString = (ExpandPluginLoadingFragment)ExpandPluginLauncher.a(this.a).get();
      if (paramString != null) {
        paramString.c();
      }
      ExpandPluginLauncher.c(this.a, false);
    }
    paramString = (ExpandPluginLoadingFragment)ExpandPluginLauncher.a(this.a).get();
    if (paramString != null) {
      paramString.a(i);
    }
    if (ExpandPluginLauncher.f(this.a) == 0L) {
      ExpandPluginLauncher.b(this.a, System.currentTimeMillis());
    }
    if ((System.currentTimeMillis() - ExpandPluginLauncher.f(this.a) > 300) && (!ExpandPluginLauncher.g(this.a)))
    {
      ExpandPluginLauncher.d(this.a, true);
      paramString = this.a;
      ExpandPluginLauncher.a(paramString, paramInt2 - paramInt1, ExpandPluginLauncher.e(paramString));
    }
  }
  
  public void onInstallError(@Nullable String paramString, int paramInt)
  {
    Object localObject = LogUtils.a;
    Throwable localThrowable = (Throwable)null;
    localObject = ((LogUtils)localObject).a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onInstallError ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(' ');
    localStringBuilder.append(paramInt);
    ((ILog)localObject).a("ExpandPluginLauncher", 1, localStringBuilder.toString(), localThrowable);
    if (!ExpandPluginLauncher.d(this.a)) {
      return;
    }
    paramString = (ExpandPluginLoadingFragment)ExpandPluginLauncher.a(this.a).get();
    if (paramString != null) {
      paramString.a(LoadingStatus.LOADING_ERROR, 2, paramInt);
    }
  }
  
  public void onInstallFinish(@Nullable String paramString)
  {
    paramString = LogUtils.a;
    if (QLog.isColorLevel()) {
      paramString.a().a("ExpandPluginLauncher", 2, "onInstallFinish");
    }
    if (ExpandPluginLauncher.a(this.a).get() != null)
    {
      paramString = this.a;
      ExpandPluginLauncher.a(paramString, ExpandPluginLauncher.c(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.plugin.entrance.ExpandPluginLauncher.installPlugin.1
 * JD-Core Version:    0.7.0.1
 */