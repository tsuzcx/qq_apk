package com.tencent.mobileqq.profilesetting;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilesetting/ReqSetSettingItem;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "fieldId", "", "fromState", "toState", "(III)V", "getFieldId", "()I", "setFieldId", "(I)V", "getFromState", "setFromState", "getToState", "setToState", "describeContents", "toString", "", "writeToParcel", "", "flags", "Companion", "profilecard-temp-api_release"}, k=1, mv={1, 1, 16})
public final class ReqSetSettingItem
  implements Parcelable
{
  @JvmField
  @NotNull
  public static final Parcelable.Creator<ReqSetSettingItem> CREATOR = (Parcelable.Creator)new ReqSetSettingItem.Companion.CREATOR.1();
  public static final ReqSetSettingItem.Companion a = new ReqSetSettingItem.Companion(null);
  private int b;
  private int c;
  private int d;
  
  public ReqSetSettingItem(int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
  }
  
  public ReqSetSettingItem(@NotNull Parcel paramParcel)
  {
    this(paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt());
  }
  
  public final int a()
  {
    return this.b;
  }
  
  public final int b()
  {
    return this.c;
  }
  
  public final int c()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[');
    localStringBuilder.append(this.b);
    localStringBuilder.append(", from=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", to=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ReqSetSettingItem
 * JD-Core Version:    0.7.0.1
 */