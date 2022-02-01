package com.tencent.mobileqq.kandian.biz.viola.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/api/IViolaBaseView$ViolaCreactPageObject;", "", "url", "", "param", "Lorg/json/JSONObject;", "cache", "isChannel", "", "colorNoteData", "(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;ILjava/lang/String;)V", "getCache", "()Ljava/lang/String;", "getColorNoteData", "()I", "getParam", "()Lorg/json/JSONObject;", "getUrl", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class IViolaBaseView$ViolaCreactPageObject
{
  @NotNull
  private final String a;
  @Nullable
  private final JSONObject b;
  @Nullable
  private final String c;
  private final int d;
  @Nullable
  private final String e;
  
  public IViolaBaseView$ViolaCreactPageObject(@NotNull String paramString1, @Nullable JSONObject paramJSONObject, @Nullable String paramString2, int paramInt, @Nullable String paramString3)
  {
    this.a = paramString1;
    this.b = paramJSONObject;
    this.c = paramString2;
    this.d = paramInt;
    this.e = paramString3;
  }
  
  @NotNull
  public final String a()
  {
    return this.a;
  }
  
  @Nullable
  public final JSONObject b()
  {
    return this.b;
  }
  
  @Nullable
  public final String c()
  {
    return this.c;
  }
  
  public final int d()
  {
    return this.d;
  }
  
  @Nullable
  public final String e()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.api.IViolaBaseView.ViolaCreactPageObject
 * JD-Core Version:    0.7.0.1
 */