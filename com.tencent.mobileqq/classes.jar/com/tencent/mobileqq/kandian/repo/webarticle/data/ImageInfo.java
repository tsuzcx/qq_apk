package com.tencent.mobileqq.kandian.repo.webarticle.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/webarticle/data/ImageInfo;", "Lcom/tencent/mobileqq/kandian/repo/webarticle/data/BaseInfo;", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "imageHeight", "", "getImageHeight", "()Ljava/lang/String;", "setImageHeight", "(Ljava/lang/String;)V", "imageUrl", "getImageUrl", "setImageUrl", "imageWidth", "getImageWidth", "setImageWidth", "process", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ImageInfo
  extends BaseInfo
{
  @NotNull
  private String imageHeight = "";
  @NotNull
  private String imageUrl = "";
  @NotNull
  private String imageWidth = "";
  
  public ImageInfo(@NotNull JSONObject paramJSONObject)
  {
    process(paramJSONObject);
  }
  
  @NotNull
  public final String getImageHeight()
  {
    return this.imageHeight;
  }
  
  @NotNull
  public final String getImageUrl()
  {
    return this.imageUrl;
  }
  
  @NotNull
  public final String getImageWidth()
  {
    return this.imageWidth;
  }
  
  public void process(@NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "json");
    Object localObject2 = paramJSONObject.optJSONObject("imgurlgif");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramJSONObject.optJSONObject("imgurl0");
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = paramJSONObject.optJSONObject("imgurl640");
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramJSONObject.optJSONObject("imgurl1000");
    }
    paramJSONObject = ((JSONObject)localObject1).optString("imgurl");
    Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "imageJson.optString(\"imgurl\")");
    this.imageUrl = paramJSONObject;
    paramJSONObject = ((JSONObject)localObject1).optString("width");
    Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "imageJson.optString(\"width\")");
    this.imageWidth = paramJSONObject;
    paramJSONObject = ((JSONObject)localObject1).optString("height");
    Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "imageJson.optString(\"height\")");
    this.imageHeight = paramJSONObject;
  }
  
  public final void setImageHeight(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.imageHeight = paramString;
  }
  
  public final void setImageUrl(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.imageUrl = paramString;
  }
  
  public final void setImageWidth(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.imageWidth = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.webarticle.data.ImageInfo
 * JD-Core Version:    0.7.0.1
 */