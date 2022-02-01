package com.tencent.mobileqq.filemanager.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class OfflineFileInfo
  implements Parcelable
{
  public static final Parcelable.Creator<OfflineFileInfo> CREATOR = new OfflineFileInfo.1();
  public int a;
  public long a;
  public String a;
  public boolean a;
  private int b;
  public long b;
  public String b;
  public long c;
  public String c;
  public long d;
  public String d;
  public String e;
  
  public OfflineFileInfo()
  {
    this.jdField_b_of_type_Int = 1;
  }
  
  public OfflineFileInfo(Parcel paramParcel)
  {
    this.jdField_b_of_type_Int = 1;
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_c_of_type_Long = paramParcel.readLong();
    this.jdField_d_of_type_Long = paramParcel.readLong();
    this.e = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    if (this.jdField_b_of_type_Int == 2)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bSend[").append(this.jdField_a_of_type_Boolean).append("]");
    localStringBuilder.append("strUuid[").append(this.jdField_a_of_type_JavaLangString).append("]");
    localStringBuilder.append("uFriendUin[").append(this.jdField_a_of_type_Long).append("]");
    localStringBuilder.append("nDangerLv[").append(this.jdField_a_of_type_Int).append("]");
    localStringBuilder.append("strFileName[").append(this.jdField_c_of_type_JavaLangString).append("]");
    localStringBuilder.append("nFileSize[").append(this.jdField_b_of_type_Long).append("]");
    localStringBuilder.append("nLiftTime[").append(this.jdField_c_of_type_Long).append("]");
    localStringBuilder.append("nUploadTime[").append(this.jdField_d_of_type_Long).append("]");
    localStringBuilder.append("md5[").append(this.jdField_d_of_type_JavaLangString).append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (this.jdField_b_of_type_Int = 2;; this.jdField_b_of_type_Int = 1)
    {
      paramParcel.writeInt(this.jdField_b_of_type_Int);
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      paramParcel.writeLong(this.jdField_a_of_type_Long);
      paramParcel.writeInt(this.jdField_a_of_type_Int);
      paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
      paramParcel.writeLong(this.jdField_b_of_type_Long);
      paramParcel.writeLong(this.jdField_c_of_type_Long);
      paramParcel.writeLong(this.jdField_d_of_type_Long);
      paramParcel.writeString(this.e);
      paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.OfflineFileInfo
 * JD-Core Version:    0.7.0.1
 */