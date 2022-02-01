package com.tencent.mobileqq.kandian.biz.push;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/push/RIJPushNotifyParam;", "", "status", "", "isDarkMode", "", "avatarUrl", "", "uin", "marginBottom", "useNightMode", "logicAction", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "isOpenPushNotify", "isDefaultOpen", "buttonId", "", "(IZLjava/lang/String;Ljava/lang/String;IZLkotlin/jvm/functions/Function3;)V", "getAvatarUrl", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", "()Z", "setDarkMode", "(Z)V", "getLogicAction", "()Lkotlin/jvm/functions/Function3;", "setLogicAction", "(Lkotlin/jvm/functions/Function3;)V", "getMarginBottom", "()I", "setMarginBottom", "(I)V", "getStatus", "setStatus", "getUin", "setUin", "getUseNightMode", "setUseNightMode", "toString", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJPushNotifyParam
{
  public static final RIJPushNotifyParam.Companion a = new RIJPushNotifyParam.Companion(null);
  private int b;
  private boolean c;
  @NotNull
  private String d;
  @NotNull
  private String e;
  private int f;
  private boolean g;
  @NotNull
  private Function3<? super Boolean, ? super Boolean, ? super Integer, Unit> h;
  
  public RIJPushNotifyParam(int paramInt1, boolean paramBoolean1, @NotNull String paramString1, @NotNull String paramString2, int paramInt2, boolean paramBoolean2, @NotNull Function3<? super Boolean, ? super Boolean, ? super Integer, Unit> paramFunction3)
  {
    this.b = paramInt1;
    this.c = paramBoolean1;
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramInt2;
    this.g = paramBoolean2;
    this.h = paramFunction3;
  }
  
  public final int a()
  {
    return this.b;
  }
  
  public final boolean b()
  {
    return this.c;
  }
  
  @NotNull
  public final String c()
  {
    return this.d;
  }
  
  @NotNull
  public final String d()
  {
    return this.e;
  }
  
  public final int e()
  {
    return this.f;
  }
  
  public final boolean f()
  {
    return this.g;
  }
  
  @NotNull
  public final Function3<Boolean, Boolean, Integer, Unit> g()
  {
    return this.h;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("status: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" , isDarkMode: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" , avatarUrl: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" , marginBottom: ");
    localStringBuilder.append(this.f);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyParam
 * JD-Core Version:    0.7.0.1
 */