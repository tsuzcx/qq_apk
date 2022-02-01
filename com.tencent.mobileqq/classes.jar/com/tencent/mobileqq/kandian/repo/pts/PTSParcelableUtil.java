package com.tencent.mobileqq.kandian.repo.pts;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PTSParcelableUtil
{
  public static Parcel a(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    return localParcel;
  }
  
  public static <T> T a(byte[] paramArrayOfByte, Parcelable.Creator<T> paramCreator)
  {
    paramArrayOfByte = a(paramArrayOfByte);
    paramCreator = paramCreator.createFromParcel(paramArrayOfByte);
    paramArrayOfByte.recycle();
    return paramCreator;
  }
  
  public static byte[] a(Parcelable paramParcelable)
  {
    Parcel localParcel = Parcel.obtain();
    paramParcelable.writeToParcel(localParcel, 0);
    paramParcelable = localParcel.marshall();
    localParcel.recycle();
    return paramParcelable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.pts.PTSParcelableUtil
 * JD-Core Version:    0.7.0.1
 */