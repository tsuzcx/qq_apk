package com.tencent.weseevideo.model.extra;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/model/extra/ExtraInfoModel;", "Ljava/io/Serializable;", "frameInfoModel", "Lcom/tencent/weseevideo/model/extra/FrameInfoModel;", "faceInfoModel", "Lcom/tencent/weseevideo/model/extra/FaceInfoModel;", "(Lcom/tencent/weseevideo/model/extra/FrameInfoModel;Lcom/tencent/weseevideo/model/extra/FaceInfoModel;)V", "getFaceInfoModel", "()Lcom/tencent/weseevideo/model/extra/FaceInfoModel;", "getFrameInfoModel", "()Lcom/tencent/weseevideo/model/extra/FrameInfoModel;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class ExtraInfoModel
  implements Serializable
{
  @Nullable
  private final FaceInfoModel faceInfoModel;
  @Nullable
  private final FrameInfoModel frameInfoModel;
  
  public ExtraInfoModel()
  {
    this(null, null, 3, null);
  }
  
  public ExtraInfoModel(@Nullable FrameInfoModel paramFrameInfoModel, @Nullable FaceInfoModel paramFaceInfoModel)
  {
    this.frameInfoModel = paramFrameInfoModel;
    this.faceInfoModel = paramFaceInfoModel;
  }
  
  @Nullable
  public final FrameInfoModel component1()
  {
    return this.frameInfoModel;
  }
  
  @Nullable
  public final FaceInfoModel component2()
  {
    return this.faceInfoModel;
  }
  
  @NotNull
  public final ExtraInfoModel copy(@Nullable FrameInfoModel paramFrameInfoModel, @Nullable FaceInfoModel paramFaceInfoModel)
  {
    return new ExtraInfoModel(paramFrameInfoModel, paramFaceInfoModel);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof ExtraInfoModel))
      {
        paramObject = (ExtraInfoModel)paramObject;
        if ((!Intrinsics.areEqual(this.frameInfoModel, paramObject.frameInfoModel)) || (!Intrinsics.areEqual(this.faceInfoModel, paramObject.faceInfoModel))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  @Nullable
  public final FaceInfoModel getFaceInfoModel()
  {
    return this.faceInfoModel;
  }
  
  @Nullable
  public final FrameInfoModel getFrameInfoModel()
  {
    return this.frameInfoModel;
  }
  
  public int hashCode()
  {
    int j = 0;
    Object localObject = this.frameInfoModel;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.faceInfoModel;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      return i * 31 + j;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "ExtraInfoModel(frameInfoModel=" + this.frameInfoModel + ", faceInfoModel=" + this.faceInfoModel + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.model.extra.ExtraInfoModel
 * JD-Core Version:    0.7.0.1
 */