package com.tencent.qidian;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class QidianProfileCardActivity$QidianSimpleProfileItem
  implements Parcelable
{
  public static final Parcelable.Creator<QidianSimpleProfileItem> CREATOR = new QidianProfileCardActivity.QidianSimpleProfileItem.1();
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  
  public QidianProfileCardActivity$QidianSimpleProfileItem()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeByte((byte)this.jdField_a_of_type_Boolean);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeByte((byte)this.jdField_b_of_type_Boolean);
    paramParcel.writeByte((byte)this.jdField_c_of_type_Boolean);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.QidianSimpleProfileItem
 * JD-Core Version:    0.7.0.1
 */