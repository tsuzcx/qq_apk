package com.tencent.weseevideo.model.resource;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/model/resource/Path3DInfo;", "", "originalImagePath", "", "depthImagePath", "(Ljava/lang/String;Ljava/lang/String;)V", "getDepthImagePath", "()Ljava/lang/String;", "setDepthImagePath", "(Ljava/lang/String;)V", "getOriginalImagePath", "setOriginalImagePath", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class Path3DInfo
{
  @NotNull
  private String depthImagePath;
  @NotNull
  private String originalImagePath;
  
  public Path3DInfo(@NotNull String paramString1, @NotNull String paramString2)
  {
    this.originalImagePath = paramString1;
    this.depthImagePath = paramString2;
  }
  
  @NotNull
  public final String component1()
  {
    return this.originalImagePath;
  }
  
  @NotNull
  public final String component2()
  {
    return this.depthImagePath;
  }
  
  @NotNull
  public final Path3DInfo copy(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "originalImagePath");
    Intrinsics.checkParameterIsNotNull(paramString2, "depthImagePath");
    return new Path3DInfo(paramString1, paramString2);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Path3DInfo))
      {
        paramObject = (Path3DInfo)paramObject;
        if ((Intrinsics.areEqual(this.originalImagePath, paramObject.originalImagePath)) && (Intrinsics.areEqual(this.depthImagePath, paramObject.depthImagePath))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final String getDepthImagePath()
  {
    return this.depthImagePath;
  }
  
  @NotNull
  public final String getOriginalImagePath()
  {
    return this.originalImagePath;
  }
  
  public int hashCode()
  {
    String str = this.originalImagePath;
    int j = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.depthImagePath;
    if (str != null) {
      j = str.hashCode();
    }
    return i * 31 + j;
  }
  
  public final void setDepthImagePath(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.depthImagePath = paramString;
  }
  
  public final void setOriginalImagePath(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.originalImagePath = paramString;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Path3DInfo(originalImagePath=");
    localStringBuilder.append(this.originalImagePath);
    localStringBuilder.append(", depthImagePath=");
    localStringBuilder.append(this.depthImagePath);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.model.resource.Path3DInfo
 * JD-Core Version:    0.7.0.1
 */