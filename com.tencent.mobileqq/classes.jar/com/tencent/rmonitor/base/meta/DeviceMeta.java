package com.tencent.rmonitor.base.meta;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/meta/DeviceMeta;", "Lcom/tencent/rmonitor/base/meta/MonitorMeta;", "params", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getParams", "()Lorg/json/JSONObject;", "setParams", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class DeviceMeta
  extends MonitorMeta
{
  @Nullable
  private JSONObject params;
  
  public DeviceMeta()
  {
    this(null, 1, null);
  }
  
  public DeviceMeta(@Nullable JSONObject paramJSONObject)
  {
    this.params = paramJSONObject;
  }
  
  @Nullable
  public final JSONObject component1()
  {
    return this.params;
  }
  
  @NotNull
  public final DeviceMeta copy(@Nullable JSONObject paramJSONObject)
  {
    return new DeviceMeta(paramJSONObject);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof DeviceMeta))
      {
        paramObject = (DeviceMeta)paramObject;
        if (Intrinsics.areEqual(this.params, paramObject.params)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @Nullable
  public final JSONObject getParams()
  {
    return this.params;
  }
  
  public int hashCode()
  {
    JSONObject localJSONObject = this.params;
    if (localJSONObject != null) {
      return localJSONObject.hashCode();
    }
    return 0;
  }
  
  public final void setParams(@Nullable JSONObject paramJSONObject)
  {
    this.params = paramJSONObject;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceMeta(params=");
    localStringBuilder.append(this.params);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.meta.DeviceMeta
 * JD-Core Version:    0.7.0.1
 */