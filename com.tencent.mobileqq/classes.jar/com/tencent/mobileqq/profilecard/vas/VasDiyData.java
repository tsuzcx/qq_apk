package com.tencent.mobileqq.profilecard.vas;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/vas/VasDiyData;", "", "urlPrefix", "", "titleStyle", "", "mainColor", "headerJson", "bodyJson", "Lorg/json/JSONObject;", "bgJson", "(Ljava/lang/String;IILjava/lang/Object;Lorg/json/JSONObject;Ljava/lang/Object;)V", "getBgJson", "()Ljava/lang/Object;", "getBodyJson", "()Lorg/json/JSONObject;", "getHeaderJson", "getMainColor", "()I", "getTitleStyle", "getUrlPrefix", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasDiyData
{
  @NotNull
  private final Object bgJson;
  @NotNull
  private final JSONObject bodyJson;
  @NotNull
  private final Object headerJson;
  private final int mainColor;
  private final int titleStyle;
  @NotNull
  private final String urlPrefix;
  
  public VasDiyData(@NotNull String paramString, int paramInt1, int paramInt2, @NotNull Object paramObject1, @NotNull JSONObject paramJSONObject, @NotNull Object paramObject2)
  {
    this.urlPrefix = paramString;
    this.titleStyle = paramInt1;
    this.mainColor = paramInt2;
    this.headerJson = paramObject1;
    this.bodyJson = paramJSONObject;
    this.bgJson = paramObject2;
  }
  
  @NotNull
  public final String component1()
  {
    return this.urlPrefix;
  }
  
  public final int component2()
  {
    return this.titleStyle;
  }
  
  public final int component3()
  {
    return this.mainColor;
  }
  
  @NotNull
  public final Object component4()
  {
    return this.headerJson;
  }
  
  @NotNull
  public final JSONObject component5()
  {
    return this.bodyJson;
  }
  
  @NotNull
  public final Object component6()
  {
    return this.bgJson;
  }
  
  @NotNull
  public final VasDiyData copy(@NotNull String paramString, int paramInt1, int paramInt2, @NotNull Object paramObject1, @NotNull JSONObject paramJSONObject, @NotNull Object paramObject2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "urlPrefix");
    Intrinsics.checkParameterIsNotNull(paramObject1, "headerJson");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "bodyJson");
    Intrinsics.checkParameterIsNotNull(paramObject2, "bgJson");
    return new VasDiyData(paramString, paramInt1, paramInt2, paramObject1, paramJSONObject, paramObject2);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof VasDiyData))
      {
        paramObject = (VasDiyData)paramObject;
        if ((!Intrinsics.areEqual(this.urlPrefix, paramObject.urlPrefix)) || (this.titleStyle != paramObject.titleStyle) || (this.mainColor != paramObject.mainColor) || (!Intrinsics.areEqual(this.headerJson, paramObject.headerJson)) || (!Intrinsics.areEqual(this.bodyJson, paramObject.bodyJson)) || (!Intrinsics.areEqual(this.bgJson, paramObject.bgJson))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  @NotNull
  public final Object getBgJson()
  {
    return this.bgJson;
  }
  
  @NotNull
  public final JSONObject getBodyJson()
  {
    return this.bodyJson;
  }
  
  @NotNull
  public final Object getHeaderJson()
  {
    return this.headerJson;
  }
  
  public final int getMainColor()
  {
    return this.mainColor;
  }
  
  public final int getTitleStyle()
  {
    return this.titleStyle;
  }
  
  @NotNull
  public final String getUrlPrefix()
  {
    return this.urlPrefix;
  }
  
  public int hashCode()
  {
    int m = 0;
    Object localObject = this.urlPrefix;
    int i;
    int n;
    int i1;
    int j;
    if (localObject != null)
    {
      i = localObject.hashCode();
      n = this.titleStyle;
      i1 = this.mainColor;
      localObject = this.headerJson;
      if (localObject == null) {
        break label119;
      }
      j = localObject.hashCode();
      label49:
      localObject = this.bodyJson;
      if (localObject == null) {
        break label124;
      }
    }
    label119:
    label124:
    for (int k = localObject.hashCode();; k = 0)
    {
      localObject = this.bgJson;
      if (localObject != null) {
        m = localObject.hashCode();
      }
      return (k + (j + ((i * 31 + n) * 31 + i1) * 31) * 31) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label49;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "VasDiyData(urlPrefix=" + this.urlPrefix + ", titleStyle=" + this.titleStyle + ", mainColor=" + this.mainColor + ", headerJson=" + this.headerJson + ", bodyJson=" + this.bodyJson + ", bgJson=" + this.bgJson + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.VasDiyData
 * JD-Core Version:    0.7.0.1
 */