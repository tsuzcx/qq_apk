package com.tencent.shadow.dynamic.host;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class NotFoundException
  extends Exception
  implements Parcelable
{
  public static final Parcelable.Creator<NotFoundException> CREATOR = new NotFoundException.1();
  
  protected NotFoundException(Parcel paramParcel)
  {
    super(paramParcel.readString());
  }
  
  public NotFoundException(String paramString)
  {
    super(paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(getMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.NotFoundException
 * JD-Core Version:    0.7.0.1
 */