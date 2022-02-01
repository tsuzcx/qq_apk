package com.tencent.mobileqq.weather.webpage;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/weather/webpage/WebPageData;", "", "event", "", "jsFunction", "", "jsParams", "bgUrl", "arkLoadState", "arkHeight", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getArkHeight", "()I", "getArkLoadState", "getBgUrl", "()Ljava/lang/String;", "getEvent", "getJsFunction", "getJsParams", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "qq-weather-impl_release"}, k=1, mv={1, 1, 16})
public final class WebPageData
{
  public static final WebPageData.Companion a;
  private final int jdField_a_of_type_Int;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  private final int jdField_b_of_type_Int;
  @NotNull
  private final String jdField_b_of_type_JavaLangString;
  private final int jdField_c_of_type_Int;
  @NotNull
  private final String jdField_c_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqWeatherWebpageWebPageData$Companion = new WebPageData.Companion(null);
  }
  
  public WebPageData(int paramInt1, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  @NotNull
  public final String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public final int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  @NotNull
  public final String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof WebPageData))
      {
        paramObject = (WebPageData)paramObject;
        if ((this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && (Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) && (Intrinsics.areEqual(this.jdField_b_of_type_JavaLangString, paramObject.jdField_b_of_type_JavaLangString)) && (Intrinsics.areEqual(this.jdField_c_of_type_JavaLangString, paramObject.jdField_c_of_type_JavaLangString)) && (this.jdField_b_of_type_Int == paramObject.jdField_b_of_type_Int) && (this.jdField_c_of_type_Int == paramObject.jdField_c_of_type_Int)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int m = this.jdField_a_of_type_Int;
    String str = this.jdField_a_of_type_JavaLangString;
    int k = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.jdField_b_of_type_JavaLangString;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.jdField_c_of_type_JavaLangString;
    if (str != null) {
      k = str.hashCode();
    }
    return ((((m * 31 + i) * 31 + j) * 31 + k) * 31 + this.jdField_b_of_type_Int) * 31 + this.jdField_c_of_type_Int;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WebPageData(event=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", jsFunction=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", jsParams=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", bgUrl=");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(", arkLoadState=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", arkHeight=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weather.webpage.WebPageData
 * JD-Core Version:    0.7.0.1
 */