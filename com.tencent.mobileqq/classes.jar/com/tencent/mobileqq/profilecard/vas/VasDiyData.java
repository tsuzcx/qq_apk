package com.tencent.mobileqq.profilecard.vas;

import com.tencent.mobileqq.profilecard.entity.IProfileBusinessInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/vas/VasDiyData;", "Lcom/tencent/mobileqq/profilecard/entity/IProfileBusinessInfo;", "urlPrefix", "", "titleStyle", "", "mainColor", "headerJson", "", "bodyJson", "Lorg/json/JSONObject;", "bgJson", "(Ljava/lang/String;IILjava/lang/Object;Lorg/json/JSONObject;Ljava/lang/Object;)V", "getBgJson", "()Ljava/lang/Object;", "getBodyJson", "()Lorg/json/JSONObject;", "getHeaderJson", "getMainColor", "()I", "getTitleStyle", "getUrlPrefix", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasDiyData
  implements IProfileBusinessInfo
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
    if (this != paramObject) {
      if ((paramObject instanceof VasDiyData))
      {
        paramObject = (VasDiyData)paramObject;
        if ((Intrinsics.areEqual(this.urlPrefix, paramObject.urlPrefix)) && (this.titleStyle == paramObject.titleStyle) && (this.mainColor == paramObject.mainColor) && (Intrinsics.areEqual(this.headerJson, paramObject.headerJson)) && (Intrinsics.areEqual(this.bodyJson, paramObject.bodyJson)) && (Intrinsics.areEqual(this.bgJson, paramObject.bgJson))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
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
    Object localObject = this.urlPrefix;
    int m = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    int n = this.titleStyle;
    int i1 = this.mainColor;
    localObject = this.headerJson;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.bodyJson;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.bgJson;
    if (localObject != null) {
      m = localObject.hashCode();
    }
    return ((((i * 31 + n) * 31 + i1) * 31 + j) * 31 + k) * 31 + m;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VasDiyData(urlPrefix=");
    localStringBuilder.append(this.urlPrefix);
    localStringBuilder.append(", titleStyle=");
    localStringBuilder.append(this.titleStyle);
    localStringBuilder.append(", mainColor=");
    localStringBuilder.append(this.mainColor);
    localStringBuilder.append(", headerJson=");
    localStringBuilder.append(this.headerJson);
    localStringBuilder.append(", bodyJson=");
    localStringBuilder.append(this.bodyJson);
    localStringBuilder.append(", bgJson=");
    localStringBuilder.append(this.bgJson);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.VasDiyData
 * JD-Core Version:    0.7.0.1
 */