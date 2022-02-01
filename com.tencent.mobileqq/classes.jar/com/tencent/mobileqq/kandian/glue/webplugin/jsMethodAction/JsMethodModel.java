package com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/webplugin/jsMethodAction/JsMethodModel;", "", "retCode", "", "msg", "", "data", "Lorg/json/JSONObject;", "(ILjava/lang/String;Lorg/json/JSONObject;)V", "getData", "()Lorg/json/JSONObject;", "setData", "(Lorg/json/JSONObject;)V", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "getRetCode", "()I", "setRetCode", "(I)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toJson", "toString", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class JsMethodModel
{
  public static final JsMethodModel.Companion a = new JsMethodModel.Companion(null);
  private int b;
  @NotNull
  private String c;
  @Nullable
  private JSONObject d;
  
  public JsMethodModel(int paramInt, @NotNull String paramString, @Nullable JSONObject paramJSONObject)
  {
    this.b = paramInt;
    this.c = paramString;
    this.d = paramJSONObject;
  }
  
  @NotNull
  public final JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("retCode", this.b);
      localJSONObject.put("msg", this.c);
      if (this.d != null) {
        localJSONObject.put("data", this.d);
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof JsMethodModel))
      {
        paramObject = (JsMethodModel)paramObject;
        if ((this.b == paramObject.b) && (Intrinsics.areEqual(this.c, paramObject.c)) && (Intrinsics.areEqual(this.d, paramObject.d))) {}
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
    int k = this.b;
    Object localObject = this.c;
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.d;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return (k * 31 + i) * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("JsMethodModel(retCode=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", msg=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", data=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction.JsMethodModel
 * JD-Core Version:    0.7.0.1
 */