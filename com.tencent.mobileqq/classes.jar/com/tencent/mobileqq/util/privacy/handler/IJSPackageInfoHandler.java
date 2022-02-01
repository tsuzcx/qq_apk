package com.tencent.mobileqq.util.privacy.handler;

import android.content.Context;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/util/privacy/handler/IJSPackageInfoHandler;", "", "getParams", "Lcom/tencent/mobileqq/util/privacy/handler/BusinessData;", "params", "", "handleJsPackageInfoRequest", "context", "Landroid/content/Context;", "methodName", "args", "", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/Object;", "Companion", "QQCommon_release"}, k=1, mv={1, 1, 16})
public abstract interface IJSPackageInfoHandler
{
  public static final IJSPackageInfoHandler.Companion a = IJSPackageInfoHandler.Companion.a;
  
  @Nullable
  public abstract Object a(@NotNull Context paramContext, @NotNull String paramString, @NotNull String... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.privacy.handler.IJSPackageInfoHandler
 * JD-Core Version:    0.7.0.1
 */