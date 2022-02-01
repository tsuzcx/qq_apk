package com.tencent.mobileqq.kandian.repo.comment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/comment/CommentReportInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/kandian/repo/comment/CommentReportInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mobileqq/kandian/repo/comment/CommentReportInfo;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class CommentReportInfo$CREATOR
  implements Parcelable.Creator<CommentReportInfo>
{
  @NotNull
  public CommentReportInfo a(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    return new CommentReportInfo(paramParcel);
  }
  
  @NotNull
  public CommentReportInfo[] a(int paramInt)
  {
    return new CommentReportInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.comment.CommentReportInfo.CREATOR
 * JD-Core Version:    0.7.0.1
 */