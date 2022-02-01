package com.tencent.tkd.weibo.bean;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/bean/EditObject$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/tkd/weibo/bean/EditObject;", "()V", "serialVersionUID", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/tkd/weibo/bean/EditObject;", "tkd-weibo-richtext_release"}, k=1, mv={1, 1, 16})
public final class EditObject$CREATOR
  implements Parcelable.Creator<EditObject>
{
  @NotNull
  public EditObject a(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    return new EditObject(paramParcel);
  }
  
  @NotNull
  public EditObject[] a(int paramInt)
  {
    return new EditObject[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.bean.EditObject.CREATOR
 * JD-Core Version:    0.7.0.1
 */