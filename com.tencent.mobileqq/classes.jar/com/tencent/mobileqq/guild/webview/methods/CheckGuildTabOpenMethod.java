package com.tencent.mobileqq.guild.webview.methods;

import com.tencent.mobileqq.guild.ipc.methods.IsShowGuildTabMethod;
import com.tencent.mobileqq.guild.util.GuildIpcUtils;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/webview/methods/CheckGuildTabOpenMethod;", "Lcom/tencent/mobileqq/guild/webview/methods/AbsJsBridgeMethod;", "()V", "onInvoke", "", "url", "", "pkgName", "method", "Companion", "InvokeResult", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class CheckGuildTabOpenMethod
  extends AbsJsBridgeMethod
{
  public static final CheckGuildTabOpenMethod.Companion a = new CheckGuildTabOpenMethod.Companion(null);
  
  protected boolean a(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "url");
    Intrinsics.checkParameterIsNotNull(paramString2, "pkgName");
    Intrinsics.checkParameterIsNotNull(paramString3, "method");
    paramString2 = GuildIpcUtils.a(IsShowGuildTabMethod.class, new Object[0]);
    paramString1 = CheckGuildTabOpenMethod.InvokeResult.a;
    paramString2 = paramString2.data;
    Intrinsics.checkExpressionValueIsNotNull(paramString2, "result.data");
    a(paramString1.a(paramString2).a());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.webview.methods.CheckGuildTabOpenMethod
 * JD-Core Version:    0.7.0.1
 */