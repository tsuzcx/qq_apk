package com.tencent.tkd.weibo.bean;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class EditObject$EditObjectType$Creator
  implements Parcelable.Creator
{
  @NotNull
  public final Object createFromParcel(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "in");
    return (EditObject.EditObjectType)Enum.valueOf(EditObject.EditObjectType.class, paramParcel.readString());
  }
  
  @NotNull
  public final Object[] newArray(int paramInt)
  {
    return new EditObject.EditObjectType[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.bean.EditObject.EditObjectType.Creator
 * JD-Core Version:    0.7.0.1
 */