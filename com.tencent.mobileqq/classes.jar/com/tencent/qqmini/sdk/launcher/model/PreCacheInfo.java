package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bdnc;

public class PreCacheInfo
  implements Parcelable
{
  public static final Parcelable.Creator<PreCacheInfo> CREATOR = new bdnc();
  public long a;
  public String a;
  public String b;
  
  public PreCacheInfo() {}
  
  public PreCacheInfo(String paramString1, String paramString2, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "getDataUrl:" + this.jdField_a_of_type_JavaLangString + "  preCacheKey:" + this.b + "  expireTime:" + this.jdField_a_of_type_Long;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.PreCacheInfo
 * JD-Core Version:    0.7.0.1
 */