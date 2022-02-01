package com.tencent.tkd.topicsdk.bean;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class OriginContentInfo$Creator
  implements Parcelable.Creator
{
  @NotNull
  public final Object createFromParcel(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "in");
    return new OriginContentInfo(paramParcel.readInt(), (List)paramParcel.createStringArrayList(), paramParcel.readLong(), paramParcel.readString(), paramParcel.readInt(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString());
  }
  
  @NotNull
  public final Object[] newArray(int paramInt)
  {
    return new OriginContentInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.OriginContentInfo.Creator
 * JD-Core Version:    0.7.0.1
 */