package com.tencent.mobileqq.kandian.base.imagecrop.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;

public class AspectRatio
  implements Parcelable
{
  public static final Parcelable.Creator<AspectRatio> CREATOR = new AspectRatio.1();
  private final float jdField_a_of_type_Float;
  @Nullable
  private final String jdField_a_of_type_JavaLangString;
  private final float b;
  
  protected AspectRatio(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Float = paramParcel.readFloat();
    this.b = paramParcel.readFloat();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeFloat(this.jdField_a_of_type_Float);
    paramParcel.writeFloat(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.imagecrop.model.AspectRatio
 * JD-Core Version:    0.7.0.1
 */