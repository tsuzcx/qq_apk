package com.tencent.tkd.topicsdk.ucrop.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/ucrop/model/AspectRatio;", "Landroid/os/Parcelable;", "aspectRatioTitle", "", "aspectRatioX", "", "aspectRatioY", "(Ljava/lang/String;FF)V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAspectRatioTitle", "()Ljava/lang/String;", "getAspectRatioX", "()F", "getAspectRatioY", "describeContents", "", "writeToParcel", "", "dest", "flags", "CREATOR", "topicsdk-ucrop_release"}, k=1, mv={1, 1, 16})
public final class AspectRatio
  implements Parcelable
{
  public static final AspectRatio.CREATOR CREATOR = new AspectRatio.CREATOR(null);
  private final float jdField_a_of_type_Float;
  @Nullable
  private final String jdField_a_of_type_JavaLangString;
  private final float b;
  
  private AspectRatio(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Float = paramParcel.readFloat();
    this.b = paramParcel.readFloat();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "dest");
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeFloat(this.jdField_a_of_type_Float);
    paramParcel.writeFloat(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.model.AspectRatio
 * JD-Core Version:    0.7.0.1
 */