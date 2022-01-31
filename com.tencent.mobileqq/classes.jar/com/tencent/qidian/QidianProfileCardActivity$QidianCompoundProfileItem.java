package com.tencent.qidian;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bfuz;

public class QidianProfileCardActivity$QidianCompoundProfileItem
  implements Parcelable
{
  public static final Parcelable.Creator<QidianCompoundProfileItem> CREATOR = new bfuz();
  public int a;
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public String d;
  public String e;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.jdField_a_of_type_Int);
      if (!this.jdField_b_of_type_Boolean) {
        break label86;
      }
    }
    label86:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.d);
      paramParcel.writeString(this.e);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.QidianCompoundProfileItem
 * JD-Core Version:    0.7.0.1
 */