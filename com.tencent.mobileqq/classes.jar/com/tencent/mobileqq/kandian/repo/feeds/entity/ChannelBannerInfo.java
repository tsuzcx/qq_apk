package com.tencent.mobileqq.kandian.repo.feeds.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/feeds/entity/ChannelBannerInfo;", "", "()V", "cardReportJson", "", "getCardReportJson", "()Ljava/lang/String;", "setCardReportJson", "(Ljava/lang/String;)V", "channelId", "", "getChannelId", "()I", "setChannelId", "(I)V", "dynamicJson", "getDynamicJson", "setDynamicJson", "pageName", "getPageName", "setPageName", "uniqueId", "getUniqueId", "setUniqueId", "toString", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class ChannelBannerInfo
{
  private int jdField_a_of_type_Int = -1;
  @NotNull
  private String jdField_a_of_type_JavaLangString = "";
  @NotNull
  private String b = "";
  @NotNull
  private String c = "";
  @NotNull
  private String d = "";
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
  
  public final void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.b = paramString;
  }
  
  @NotNull
  public final String c()
  {
    return this.c;
  }
  
  public final void c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.c = paramString;
  }
  
  @NotNull
  public final String d()
  {
    return this.d;
  }
  
  public final void d(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.d = paramString;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("channelId = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", uniqueId = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", pageName = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", \n dynamicJson = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", \n cardReportJson = ");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelBannerInfo
 * JD-Core Version:    0.7.0.1
 */