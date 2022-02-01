package com.tencent.mobileqq.vashealth.config;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vashealth/config/HealthConfigBean;", "", "isRedirectAIO", "", "mainPageUrl", "", "mainPageUrlSearch", "mainPageUrlSearchPA", "mainPageUrlContact", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()Z", "getMainPageUrl", "()Ljava/lang/String;", "getMainPageUrlContact", "getMainPageUrlSearch", "getMainPageUrlSearchPA", "Companion", "health-impl_release"}, k=1, mv={1, 1, 16})
public final class HealthConfigBean
{
  public static final HealthConfigBean.Companion a = new HealthConfigBean.Companion(null);
  private final boolean b;
  @NotNull
  private final String c;
  @NotNull
  private final String d;
  @NotNull
  private final String e;
  @NotNull
  private final String f;
  
  public HealthConfigBean()
  {
    this(false, null, null, null, null, 31, null);
  }
  
  public HealthConfigBean(boolean paramBoolean, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4)
  {
    this.b = paramBoolean;
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramString4;
  }
  
  public final boolean a()
  {
    return this.b;
  }
  
  @NotNull
  public final String b()
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
  
  @NotNull
  public final String e()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.config.HealthConfigBean
 * JD-Core Version:    0.7.0.1
 */