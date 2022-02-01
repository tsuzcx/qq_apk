package com.tencent.mobileqq.msgbackup.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import avuo;
import java.util.List;

public class MsgBackupUserData
  implements Parcelable
{
  public static final Parcelable.Creator<MsgBackupUserData> CREATOR = new avuo();
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private List<Integer> jdField_a_of_type_JavaUtilList;
  private String b;
  private String c;
  
  public MsgBackupUserData(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    paramParcel.readList(this.jdField_a_of_type_JavaUtilList, getClass().getClassLoader());
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
  }
  
  private MsgBackupUserData(String paramString1, List<Integer> paramList, String paramString2, String paramString3, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<Integer> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("--UserData--");
    localStringBuilder.append(", ip: ").append(this.jdField_a_of_type_JavaLangString).append(",ports: ").append(this.jdField_a_of_type_JavaUtilList).append(",bssid: ").append(this.c).append(", ssid: ").append(this.b).append(", platfrom: ").append(this.jdField_a_of_type_Int);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeList(this.jdField_a_of_type_JavaUtilList);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgBackupUserData
 * JD-Core Version:    0.7.0.1
 */