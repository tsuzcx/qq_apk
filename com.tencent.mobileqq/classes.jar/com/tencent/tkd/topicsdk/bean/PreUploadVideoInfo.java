package com.tencent.tkd.topicsdk.bean;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/PreUploadVideoInfo;", "Ljava/io/Serializable;", "publishId", "", "videoInfo", "Lcom/tencent/tkd/topicsdk/bean/VideoInfo;", "scene", "communityId", "(Ljava/lang/String;Lcom/tencent/tkd/topicsdk/bean/VideoInfo;Ljava/lang/String;Ljava/lang/String;)V", "getCommunityId", "()Ljava/lang/String;", "getPublishId", "setPublishId", "(Ljava/lang/String;)V", "getScene", "getVideoInfo", "()Lcom/tencent/tkd/topicsdk/bean/VideoInfo;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PreUploadVideoInfo
  implements Serializable
{
  @NotNull
  private final String communityId;
  @NotNull
  private String publishId;
  @NotNull
  private final String scene;
  @NotNull
  private final VideoInfo videoInfo;
  
  public PreUploadVideoInfo(@NotNull String paramString1, @NotNull VideoInfo paramVideoInfo, @NotNull String paramString2, @NotNull String paramString3)
  {
    this.publishId = paramString1;
    this.videoInfo = paramVideoInfo;
    this.scene = paramString2;
    this.communityId = paramString3;
  }
  
  @NotNull
  public final String component1()
  {
    return this.publishId;
  }
  
  @NotNull
  public final VideoInfo component2()
  {
    return this.videoInfo;
  }
  
  @NotNull
  public final String component3()
  {
    return this.scene;
  }
  
  @NotNull
  public final String component4()
  {
    return this.communityId;
  }
  
  @NotNull
  public final PreUploadVideoInfo copy(@NotNull String paramString1, @NotNull VideoInfo paramVideoInfo, @NotNull String paramString2, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "publishId");
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramString2, "scene");
    Intrinsics.checkParameterIsNotNull(paramString3, "communityId");
    return new PreUploadVideoInfo(paramString1, paramVideoInfo, paramString2, paramString3);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof PreUploadVideoInfo))
      {
        paramObject = (PreUploadVideoInfo)paramObject;
        if ((Intrinsics.areEqual(this.publishId, paramObject.publishId)) && (Intrinsics.areEqual(this.videoInfo, paramObject.videoInfo)) && (Intrinsics.areEqual(this.scene, paramObject.scene)) && (Intrinsics.areEqual(this.communityId, paramObject.communityId))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final String getCommunityId()
  {
    return this.communityId;
  }
  
  @NotNull
  public final String getPublishId()
  {
    return this.publishId;
  }
  
  @NotNull
  public final String getScene()
  {
    return this.scene;
  }
  
  @NotNull
  public final VideoInfo getVideoInfo()
  {
    return this.videoInfo;
  }
  
  public int hashCode()
  {
    Object localObject = this.publishId;
    int m = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.videoInfo;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.scene;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.communityId;
    if (localObject != null) {
      m = localObject.hashCode();
    }
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final void setPublishId(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.publishId = paramString;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PreUploadVideoInfo(publishId=");
    localStringBuilder.append(this.publishId);
    localStringBuilder.append(", videoInfo=");
    localStringBuilder.append(this.videoInfo);
    localStringBuilder.append(", scene=");
    localStringBuilder.append(this.scene);
    localStringBuilder.append(", communityId=");
    localStringBuilder.append(this.communityId);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.PreUploadVideoInfo
 * JD-Core Version:    0.7.0.1
 */