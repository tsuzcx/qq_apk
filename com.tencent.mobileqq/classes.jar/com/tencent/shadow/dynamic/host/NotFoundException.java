package com.tencent.shadow.dynamic.host;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.shadow.proguard.n;

public class NotFoundException
  extends Exception
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new n();
  
  public NotFoundException(Parcel paramParcel)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.NotFoundException
 * JD-Core Version:    0.7.0.1
 */