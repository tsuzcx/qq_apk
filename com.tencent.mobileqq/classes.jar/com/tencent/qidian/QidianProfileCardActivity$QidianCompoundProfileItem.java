package com.tencent.qidian;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class QidianProfileCardActivity$QidianCompoundProfileItem
  implements Parcelable
{
  public static final Parcelable.Creator<QidianCompoundProfileItem> CREATOR = new QidianProfileCardActivity.QidianCompoundProfileItem.1();
  public int a;
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public String d;
  public String e;
  
  public QidianProfileCardActivity$QidianCompoundProfileItem()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    paramParcel.writeByte((byte)this.jdField_a_of_type_Boolean);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeByte((byte)this.jdField_b_of_type_Boolean);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.QidianCompoundProfileItem
 * JD-Core Version:    0.7.0.1
 */