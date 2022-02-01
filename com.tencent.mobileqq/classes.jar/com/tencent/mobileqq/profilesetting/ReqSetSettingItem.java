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
  public static final ReqSetSettingItem.Companion a;
  private int a;
  private int b;
  private int c;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqProfilesettingReqSetSettingItem$Companion = new ReqSetSettingItem.Companion(null);
  }
  
  public ReqSetSettingItem(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public ReqSetSettingItem(@NotNull Parcel paramParcel)
  {
    this(paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt());
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final int c()
  {
    return this.c;
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
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", from=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", to=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ReqSetSettingItem
 * JD-Core Version:    0.7.0.1
 */