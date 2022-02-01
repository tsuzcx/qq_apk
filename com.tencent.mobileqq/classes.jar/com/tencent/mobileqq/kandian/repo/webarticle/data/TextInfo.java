package com.tencent.mobileqq.kandian.repo.webarticle.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/webarticle/data/TextInfo;", "Lcom/tencent/mobileqq/kandian/repo/webarticle/data/BaseInfo;", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "style", "getStyle", "setStyle", "process", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class TextInfo
  extends BaseInfo
{
  @NotNull
  private String content = "";
  @NotNull
  private String style = "";
  
  public TextInfo(@NotNull JSONObject paramJSONObject)
  {
    process(paramJSONObject);
  }
  
  @NotNull
  public final String getContent()
  {
    return this.content;
  }
  
  @NotNull
  public final String getStyle()
  {
    return this.style;
  }
  
  public void process(@NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "json");
    paramJSONObject = paramJSONObject.optString("desc");
    Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "json.optString(\"desc\")");
    this.content = paramJSONObject;
  }
  
  public final void setContent(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.content = paramString;
  }
  
  public final void setStyle(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.style = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.webarticle.data.TextInfo
 * JD-Core Version:    0.7.0.1
 */