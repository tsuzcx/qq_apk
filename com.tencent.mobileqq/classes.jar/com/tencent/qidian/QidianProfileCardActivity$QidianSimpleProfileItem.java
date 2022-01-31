package com.tencent.qidian;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bfva;

public class QidianProfileCardActivity$QidianSimpleProfileItem
  implements Parcelable
{
  public static final Parcelable.Creator<QidianSimpleProfileItem> CREATOR = new bfva();
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public String c;
  public boolean c;
  
  public QidianProfileCardActivity$QidianSimpleProfileItem()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 0;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.jdField_a_of_type_Int);
      paramParcel.writeInt(this.jdField_b_of_type_Int);
      paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
      if (!this.jdField_b_of_type_Boolean) {
        break label93;
      }
      paramInt = 1;
      label66:
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_c_of_type_Boolean) {
        break label98;
      }
    }
    label93:
    label98:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label66;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.QidianSimpleProfileItem
 * JD-Core Version:    0.7.0.1
 */