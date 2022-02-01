package com.tencent.mobileqq.qqexpand.plugin.entrance;

import com.tencent.mobileqq.qqexpand.utils.ILog;
import com.tencent.mobileqq.qqexpand.utils.LogUtils;
import com.tencent.mobileqq.qroute.module.IQRoutePlugin.OnOpenResultListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "result", "", "onOpenResult"}, k=3, mv={1, 1, 16})
final class ExpandPluginLauncher$preloadPlugin$params$1$2
  implements IQRoutePlugin.OnOpenResultListener
{
  public static final 2 a = new 2();
  
  public final void onOpenResult(boolean paramBoolean)
  {
    ILog localILog = LogUtils.a.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preloadPlugin: open plugin result ");
    localStringBuilder.append(paramBoolean);
    localILog.a("ExpandPluginLauncher", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.plugin.entrance.ExpandPluginLauncher.preloadPlugin.params.1.2
 * JD-Core Version:    0.7.0.1
 */