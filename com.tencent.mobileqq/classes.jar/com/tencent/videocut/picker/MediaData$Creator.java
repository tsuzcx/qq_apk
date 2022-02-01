package com.tencent.videocut.picker;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class MediaData$Creator
  implements Parcelable.Creator
{
  @NotNull
  public final Object createFromParcel(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "in");
    return new MediaData(paramParcel.readInt(), paramParcel.readString(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readLong(), paramParcel.readLong(), paramParcel.readLong(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString());
  }
  
  @NotNull
  public final Object[] newArray(int paramInt)
  {
    return new MediaData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.picker.MediaData.Creator
 * JD-Core Version:    0.7.0.1
 */