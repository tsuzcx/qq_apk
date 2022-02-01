package com.tencent.mobileqq.guild.webview.methods;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/webview/methods/CheckGuildTabOpenMethod$InvokeResult$Companion;", "", "()V", "fromIpcResult", "Lcom/tencent/mobileqq/guild/webview/methods/CheckGuildTabOpenMethod$InvokeResult;", "bundle", "Landroid/os/Bundle;", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class CheckGuildTabOpenMethod$InvokeResult$Companion
{
  @NotNull
  public final CheckGuildTabOpenMethod.InvokeResult a(@NotNull Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramBundle, "bundle");
    if (!paramBundle.getBoolean("ret", false)) {
      return new CheckGuildTabOpenMethod.InvokeResult(-204, "Tab未开启, 请重试", 1000);
    }
    return new CheckGuildTabOpenMethod.InvokeResult(0, "Tab已开启", 0, 4, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.webview.methods.CheckGuildTabOpenMethod.InvokeResult.Companion
 * JD-Core Version:    0.7.0.1
 */