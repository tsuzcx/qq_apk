package com.tencent.mobileqq.kandian.base.imagecrop.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;

public class AspectRatio
  implements Parcelable
{
  public static final Parcelable.Creator<AspectRatio> CREATOR = new AspectRatio.1();
  @Nullable
  private final String a;
  private final float b;
  private final float c;
  
  protected AspectRatio(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readFloat();
    this.c = paramParcel.readFloat();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeFloat(this.b);
    paramParcel.writeFloat(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.imagecrop.model.AspectRatio
 * JD-Core Version:    0.7.0.1
 */