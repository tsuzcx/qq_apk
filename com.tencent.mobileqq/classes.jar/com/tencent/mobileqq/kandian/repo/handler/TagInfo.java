package com.tencent.mobileqq.kandian.repo.handler;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TagInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TagInfo> CREATOR = new TagInfo.1();
  private final long a;
  private final String b;
  private final double c;
  private final long d;
  
  public TagInfo(long paramLong1, String paramString, double paramDouble, long paramLong2)
  {
    this.a = paramLong1;
    this.b = paramString;
    this.c = paramDouble;
    this.d = paramLong2;
  }
  
  protected TagInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = paramParcel.readString();
    this.c = paramParcel.readDouble();
    this.d = paramParcel.readLong();
  }
  
  public long a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public double c()
  {
    return this.c;
  }
  
  public long d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (TagInfo)paramObject;
      if (this.a != paramObject.a) {
        return false;
      }
      if (Double.compare(paramObject.c, this.c) != 0) {
        return false;
      }
      if (this.d != paramObject.d) {
        return false;
      }
      return this.b.equals(paramObject.b);
    }
    return false;
  }
  
  public int hashCode()
  {
    long l = this.a;
    int i = (int)(l ^ l >>> 32);
    int j = this.b.hashCode();
    l = Double.doubleToLongBits(this.c);
    int k = (int)(l ^ l >>> 32);
    l = this.d;
    return ((i * 31 + j) * 31 + k) * 31 + (int)(l ^ l >>> 32);
  }
  
  public String toString()
  {
    return this.b;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeDouble(this.c);
    paramParcel.writeLong(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.TagInfo
 * JD-Core Version:    0.7.0.1
 */