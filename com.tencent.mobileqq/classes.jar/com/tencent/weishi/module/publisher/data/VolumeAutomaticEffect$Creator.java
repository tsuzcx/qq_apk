package com.tencent.weishi.module.publisher.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class VolumeAutomaticEffect$Creator
  implements Parcelable.Creator
{
  @NotNull
  public final Object createFromParcel(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "in");
    return new VolumeAutomaticEffect(paramParcel.readLong(), paramParcel.readLong(), paramParcel.readLong(), (VolumeRange)VolumeRange.CREATOR.createFromParcel(paramParcel));
  }
  
  @NotNull
  public final Object[] newArray(int paramInt)
  {
    return new VolumeAutomaticEffect[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weishi.module.publisher.data.VolumeAutomaticEffect.Creator
 * JD-Core Version:    0.7.0.1
 */