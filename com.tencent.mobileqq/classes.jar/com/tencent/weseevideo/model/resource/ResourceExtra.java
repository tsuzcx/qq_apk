package com.tencent.weseevideo.model.resource;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Deprecated(message="nest class")
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/model/resource/ResourceExtra;", "Ljava/io/Serializable;", "threeDPath", "Lcom/tencent/weseevideo/model/resource/Path3DInfo;", "(Lcom/tencent/weseevideo/model/resource/Path3DInfo;)V", "getThreeDPath", "()Lcom/tencent/weseevideo/model/resource/Path3DInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class ResourceExtra
  implements Serializable
{
  @SerializedName("3d_path")
  @NotNull
  private final Path3DInfo threeDPath;
  
  public ResourceExtra(@NotNull Path3DInfo paramPath3DInfo)
  {
    this.threeDPath = paramPath3DInfo;
  }
  
  @NotNull
  public final Path3DInfo component1()
  {
    return this.threeDPath;
  }
  
  @NotNull
  public final ResourceExtra copy(@NotNull Path3DInfo paramPath3DInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramPath3DInfo, "threeDPath");
    return new ResourceExtra(paramPath3DInfo);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof ResourceExtra))
      {
        paramObject = (ResourceExtra)paramObject;
        if (!Intrinsics.areEqual(this.threeDPath, paramObject.threeDPath)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  @NotNull
  public final Path3DInfo getThreeDPath()
  {
    return this.threeDPath;
  }
  
  public int hashCode()
  {
    Path3DInfo localPath3DInfo = this.threeDPath;
    if (localPath3DInfo != null) {
      return localPath3DInfo.hashCode();
    }
    return 0;
  }
  
  @NotNull
  public String toString()
  {
    return "ResourceExtra(threeDPath=" + this.threeDPath + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.model.resource.ResourceExtra
 * JD-Core Version:    0.7.0.1
 */