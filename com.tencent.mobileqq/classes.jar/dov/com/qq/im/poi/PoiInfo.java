package dov.com.qq.im.poi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bmfc;

public class PoiInfo
  implements Parcelable
{
  public static final Parcelable.Creator<PoiInfo> CREATOR = new bmfc();
  public int a;
  public long a;
  public String a;
  public int b;
  public String b;
  
  public PoiInfo() {}
  
  private PoiInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id:").append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", latitude:").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", longitude:").append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", name:").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", address").append(this.jdField_b_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.poi.PoiInfo
 * JD-Core Version:    0.7.0.1
 */