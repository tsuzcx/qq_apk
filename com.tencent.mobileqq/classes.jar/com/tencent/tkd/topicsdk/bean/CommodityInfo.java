package com.tencent.tkd.topicsdk.bean;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/CommodityInfo;", "Ljava/io/Serializable;", "id", "", "num", "name", "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getNum", "getUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class CommodityInfo
  implements Serializable
{
  @NotNull
  private final String id;
  @NotNull
  private final String name;
  @NotNull
  private final String num;
  @NotNull
  private final String url;
  
  public CommodityInfo(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4)
  {
    this.id = paramString1;
    this.num = paramString2;
    this.name = paramString3;
    this.url = paramString4;
  }
  
  @NotNull
  public final String component1()
  {
    return this.id;
  }
  
  @NotNull
  public final String component2()
  {
    return this.num;
  }
  
  @NotNull
  public final String component3()
  {
    return this.name;
  }
  
  @NotNull
  public final String component4()
  {
    return this.url;
  }
  
  @NotNull
  public final CommodityInfo copy(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "id");
    Intrinsics.checkParameterIsNotNull(paramString2, "num");
    Intrinsics.checkParameterIsNotNull(paramString3, "name");
    Intrinsics.checkParameterIsNotNull(paramString4, "url");
    return new CommodityInfo(paramString1, paramString2, paramString3, paramString4);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof CommodityInfo))
      {
        paramObject = (CommodityInfo)paramObject;
        if ((Intrinsics.areEqual(this.id, paramObject.id)) && (Intrinsics.areEqual(this.num, paramObject.num)) && (Intrinsics.areEqual(this.name, paramObject.name)) && (Intrinsics.areEqual(this.url, paramObject.url))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final String getId()
  {
    return this.id;
  }
  
  @NotNull
  public final String getName()
  {
    return this.name;
  }
  
  @NotNull
  public final String getNum()
  {
    return this.num;
  }
  
  @NotNull
  public final String getUrl()
  {
    return this.url;
  }
  
  public int hashCode()
  {
    String str = this.id;
    int m = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.num;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.name;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.url;
    if (str != null) {
      m = str.hashCode();
    }
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CommodityInfo(id=");
    localStringBuilder.append(this.id);
    localStringBuilder.append(", num=");
    localStringBuilder.append(this.num);
    localStringBuilder.append(", name=");
    localStringBuilder.append(this.name);
    localStringBuilder.append(", url=");
    localStringBuilder.append(this.url);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.CommodityInfo
 * JD-Core Version:    0.7.0.1
 */