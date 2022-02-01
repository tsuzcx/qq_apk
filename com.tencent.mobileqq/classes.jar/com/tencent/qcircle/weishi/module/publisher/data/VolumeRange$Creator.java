package com.tencent.qcircle.weishi.module.publisher.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class VolumeRange$Creator
  implements Parcelable.Creator
{
  @NotNull
  public final Object createFromParcel(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "in");
    return new VolumeRange(paramParcel.readFloat(), paramParcel.readFloat());
  }
  
  @NotNull
  public final Object[] newArray(int paramInt)
  {
    return new VolumeRange[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weishi.module.publisher.data.VolumeRange.Creator
 * JD-Core Version:    0.7.0.1
 */