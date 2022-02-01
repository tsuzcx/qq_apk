package com.tencent.mobileqq.qqgamepub.config;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqgamepub/config/DnFlutterConfigBean;", "", "()V", "configStr", "", "getConfigStr", "()Ljava/lang/String;", "setConfigStr", "(Ljava/lang/String;)V", "dynamicSwitch", "", "getDynamicSwitch", "()I", "setDynamicSwitch", "(I)V", "packageName", "getPackageName", "setPackageName", "preDownloadSwitch", "getPreDownloadSwitch", "setPreDownloadSwitch", "resourceMd5", "getResourceMd5", "setResourceMd5", "resourceSign", "getResourceSign", "setResourceSign", "resourceUrl", "getResourceUrl", "setResourceUrl", "version", "getVersion", "setVersion", "toJsonObject", "Lorg/json/JSONObject;", "toString", "Companion", "qqgamepubaccount-api_release"}, k=1, mv={1, 1, 16})
public final class DnFlutterConfigBean
{
  public static final DnFlutterConfigBean.Companion a = new DnFlutterConfigBean.Companion(null);
  private int b;
  private int c;
  @NotNull
  private String d = "";
  @NotNull
  private String e = "";
  @NotNull
  private String f = "";
  @NotNull
  private String g = "";
  @NotNull
  private String h = "";
  @NotNull
  private String i = "";
  
  public final int a()
  {
    return this.b;
  }
  
  public final void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.d = paramString;
  }
  
  public final int b()
  {
    return this.c;
  }
  
  public final void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.e = paramString;
  }
  
  @NotNull
  public final String c()
  {
    return this.d;
  }
  
  public final void c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.f = paramString;
  }
  
  @NotNull
  public final String d()
  {
    return this.e;
  }
  
  public final void d(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.g = paramString;
  }
  
  @NotNull
  public final String e()
  {
    return this.f;
  }
  
  public final void e(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.h = paramString;
  }
  
  @NotNull
  public final String f()
  {
    return this.g;
  }
  
  public final void f(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.i = paramString;
  }
  
  @NotNull
  public final String g()
  {
    return this.h;
  }
  
  @NotNull
  public final String h()
  {
    return this.i;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DnFlutterConfigBean{dynamicSwitch=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",preDownloadSwitch=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(".version=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(',');
    localStringBuilder.append(" resourceUrl=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",resourceMd5=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",resourceSign=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(",packageName=");
    localStringBuilder.append(this.h);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.config.DnFlutterConfigBean
 * JD-Core Version:    0.7.0.1
 */