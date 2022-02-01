package com.tencent.mobileqq.qqexpand.flutter.router;

import android.net.Uri;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/flutter/router/BaseRouter;", "", "()V", "getRouterName", "", "openRouterPath", "", "pageUri", "Landroid/net/Uri;", "urlParams", "", "exts", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public abstract class BaseRouter
{
  @NotNull
  public abstract String a();
  
  public void a(@NotNull Uri paramUri, @Nullable Map<Object, ? extends Object> paramMap1, @Nullable Map<Object, ? extends Object> paramMap2)
  {
    Intrinsics.checkParameterIsNotNull(paramUri, "pageUri");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.router.BaseRouter
 * JD-Core Version:    0.7.0.1
 */