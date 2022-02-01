package com.tencent.mobileqq.kandian.repo.handler;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TagInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TagInfo> CREATOR = new TagInfo.1();
  private final double jdField_a_of_type_Double;
  private final long jdField_a_of_type_Long;
  private final String jdField_a_of_type_JavaLangString;
  private final long b;
  
  public TagInfo(long paramLong1, String paramString, double paramDouble, long paramLong2)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Double = paramDouble;
    this.b = paramLong2;
  }
  
  protected TagInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Double = paramParcel.readDouble();
    this.b = paramParcel.readLong();
  }
  
  public double a()
  {
    return this.jdField_a_of_type_Double;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public long b()
  {
    return this.b;
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
      if (this.jdField_a_of_type_Long != paramObject.jdField_a_of_type_Long) {
        return false;
      }
      if (Double.compare(paramObject.jdField_a_of_type_Double, this.jdField_a_of_type_Double) != 0) {
        return false;
      }
      if (this.b != paramObject.b) {
        return false;
      }
      return this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString);
    }
    return false;
  }
  
  public int hashCode()
  {
    long l = this.jdField_a_of_type_Long;
    int i = (int)(l ^ l >>> 32);
    int j = this.jdField_a_of_type_JavaLangString.hashCode();
    l = Double.doubleToLongBits(this.jdField_a_of_type_Double);
    int k = (int)(l ^ l >>> 32);
    l = this.b;
    return ((i * 31 + j) * 31 + k) * 31 + (int)(l ^ l >>> 32);
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeDouble(this.jdField_a_of_type_Double);
    paramParcel.writeLong(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.TagInfo
 * JD-Core Version:    0.7.0.1
 */