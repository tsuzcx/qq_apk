package com.tencent.mobileqq.kandian.biz.comment.entity;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/entity/SimpleCommentData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/SimpleCommentData;", "()V", "RIJ_SHANGHAI_PHP", "", "SCENE_MAIN_COMMENT", "SCENE_SUB_COMMENT", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/tencent/mobileqq/kandian/biz/comment/entity/SimpleCommentData;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class SimpleCommentData$CREATOR
  implements Parcelable.Creator<SimpleCommentData>
{
  @NotNull
  public SimpleCommentData a(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    return new SimpleCommentData(paramParcel);
  }
  
  @NotNull
  public SimpleCommentData[] a(int paramInt)
  {
    return new SimpleCommentData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.entity.SimpleCommentData.CREATOR
 * JD-Core Version:    0.7.0.1
 */