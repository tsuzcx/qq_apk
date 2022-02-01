package com.tencent.rmonitor.base.meta;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/meta/LooperMeta;", "Lcom/tencent/rmonitor/base/meta/MonitorMeta;", "looperParams", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getLooperParams", "()Lorg/json/JSONObject;", "setLooperParams", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class LooperMeta
  extends MonitorMeta
{
  @Nullable
  private JSONObject looperParams;
  
  public LooperMeta()
  {
    this(null, 1, null);
  }
  
  public LooperMeta(@Nullable JSONObject paramJSONObject)
  {
    this.looperParams = paramJSONObject;
  }
  
  @Nullable
  public final JSONObject component1()
  {
    return this.looperParams;
  }
  
  @NotNull
  public final LooperMeta copy(@Nullable JSONObject paramJSONObject)
  {
    return new LooperMeta(paramJSONObject);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof LooperMeta))
      {
        paramObject = (LooperMeta)paramObject;
        if (Intrinsics.areEqual(this.looperParams, paramObject.looperParams)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @Nullable
  public final JSONObject getLooperParams()
  {
    return this.looperParams;
  }
  
  public int hashCode()
  {
    JSONObject localJSONObject = this.looperParams;
    if (localJSONObject != null) {
      return localJSONObject.hashCode();
    }
    return 0;
  }
  
  public final void setLooperParams(@Nullable JSONObject paramJSONObject)
  {
    this.looperParams = paramJSONObject;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LooperMeta(looperParams=");
    localStringBuilder.append(this.looperParams);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.meta.LooperMeta
 * JD-Core Version:    0.7.0.1
 */