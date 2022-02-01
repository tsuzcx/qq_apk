package com.tencent.mobileqq.mini.config;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/mini/config/FileMaterialConfig$Item;", "", "mimeType", "", "ext", "(Ljava/lang/String;Ljava/lang/String;)V", "getExt", "()Ljava/lang/String;", "getMimeType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class FileMaterialConfig$Item
{
  @NotNull
  private final String ext;
  @NotNull
  private final String mimeType;
  
  public FileMaterialConfig$Item(@NotNull String paramString1, @NotNull String paramString2)
  {
    this.mimeType = paramString1;
    this.ext = paramString2;
  }
  
  @NotNull
  public final String component1()
  {
    return this.mimeType;
  }
  
  @NotNull
  public final String component2()
  {
    return this.ext;
  }
  
  @NotNull
  public final Item copy(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "mimeType");
    Intrinsics.checkParameterIsNotNull(paramString2, "ext");
    return new Item(paramString1, paramString2);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Item))
      {
        paramObject = (Item)paramObject;
        if ((Intrinsics.areEqual(this.mimeType, paramObject.mimeType)) && (Intrinsics.areEqual(this.ext, paramObject.ext))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final String getExt()
  {
    return this.ext;
  }
  
  @NotNull
  public final String getMimeType()
  {
    return this.mimeType;
  }
  
  public int hashCode()
  {
    String str = this.mimeType;
    int j = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.ext;
    if (str != null) {
      j = str.hashCode();
    }
    return i * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mt: ");
    localStringBuilder.append(this.mimeType);
    localStringBuilder.append(", ext: ");
    localStringBuilder.append(this.ext);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.config.FileMaterialConfig.Item
 * JD-Core Version:    0.7.0.1
 */