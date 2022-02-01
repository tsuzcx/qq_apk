package com.tencent.rmonitor.base.config;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/config/WhiteUrl;", "", "()V", "Companion", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class WhiteUrl
{
  @JvmField
  @NotNull
  public static final ArrayList<String> a = new ArrayList((Collection)CollectionsKt.listOf(new String[] { "sngapm.qq.com", "ten.sngapm.qq.com", "qapm.qq.com" }));
  public static final WhiteUrl.Companion b = new WhiteUrl.Companion(null);
  
  @JvmStatic
  public static final void a(@NotNull String paramString)
  {
    b.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.config.WhiteUrl
 * JD-Core Version:    0.7.0.1
 */