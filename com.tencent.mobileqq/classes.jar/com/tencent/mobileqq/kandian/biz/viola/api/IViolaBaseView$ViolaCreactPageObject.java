package com.tencent.mobileqq.kandian.biz.viola.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/api/IViolaBaseView$ViolaCreactPageObject;", "", "url", "", "param", "Lorg/json/JSONObject;", "cache", "isChannel", "", "colorNoteData", "(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;ILjava/lang/String;)V", "getCache", "()Ljava/lang/String;", "getColorNoteData", "()I", "getParam", "()Lorg/json/JSONObject;", "getUrl", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class IViolaBaseView$ViolaCreactPageObject
{
  private final int jdField_a_of_type_Int;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  @Nullable
  private final JSONObject jdField_a_of_type_OrgJsonJSONObject;
  @Nullable
  private final String b;
  @Nullable
  private final String c;
  
  public IViolaBaseView$ViolaCreactPageObject(@NotNull String paramString1, @Nullable JSONObject paramJSONObject, @Nullable String paramString2, int paramInt, @Nullable String paramString3)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    this.b = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    this.c = paramString3;
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
  
  @Nullable
  public final JSONObject a()
  {
    return this.jdField_a_of_type_OrgJsonJSONObject;
  }
  
  @Nullable
  public final String b()
  {
    return this.b;
  }
  
  @Nullable
  public final String c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.api.IViolaBaseView.ViolaCreactPageObject
 * JD-Core Version:    0.7.0.1
 */