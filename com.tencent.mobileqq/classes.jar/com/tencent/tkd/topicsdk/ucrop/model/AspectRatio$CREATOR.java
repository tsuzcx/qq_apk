package com.tencent.tkd.topicsdk.ucrop.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/ucrop/model/AspectRatio$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/tkd/topicsdk/ucrop/model/AspectRatio;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/tkd/topicsdk/ucrop/model/AspectRatio;", "topicsdk-ucrop_release"}, k=1, mv={1, 1, 16})
public final class AspectRatio$CREATOR
  implements Parcelable.Creator<AspectRatio>
{
  @NotNull
  public AspectRatio a(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    return new AspectRatio(paramParcel, null);
  }
  
  @NotNull
  public AspectRatio[] a(int paramInt)
  {
    return new AspectRatio[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.model.AspectRatio.CREATOR
 * JD-Core Version:    0.7.0.1
 */