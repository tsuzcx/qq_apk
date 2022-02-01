package com.tencent.tkd.weibo.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/bean/EditObject$EditObjectType;", "", "Landroid/os/Parcelable;", "(Ljava/lang/String;I)V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "TYPE_NORMAL", "TYPE_AT", "TYPE_TOPIC", "TYPE_URL", "tkd-weibo-richtext_release"}, k=1, mv={1, 1, 16})
@Parcelize
public enum EditObject$EditObjectType
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new EditObject.EditObjectType.Creator();
  
  static
  {
    EditObjectType localEditObjectType1 = new EditObjectType("TYPE_NORMAL", 0);
    TYPE_NORMAL = localEditObjectType1;
    EditObjectType localEditObjectType2 = new EditObjectType("TYPE_AT", 1);
    TYPE_AT = localEditObjectType2;
    EditObjectType localEditObjectType3 = new EditObjectType("TYPE_TOPIC", 2);
    TYPE_TOPIC = localEditObjectType3;
    EditObjectType localEditObjectType4 = new EditObjectType("TYPE_URL", 3);
    TYPE_URL = localEditObjectType4;
    $VALUES = new EditObjectType[] { localEditObjectType1, localEditObjectType2, localEditObjectType3, localEditObjectType4 };
  }
  
  private EditObject$EditObjectType() {}
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeString(name());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.weibo.bean.EditObject.EditObjectType
 * JD-Core Version:    0.7.0.1
 */