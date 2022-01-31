package com.tencent.mobileqq.teamwork;

import ahyg;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TeamWorkFileImportInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ahyg();
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  public int e;
  public String e;
  public boolean e;
  
  public TeamWorkFileImportInfo()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public TeamWorkFileImportInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      this.jdField_c_of_type_Int = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label177;
      }
      bool1 = true;
      label114:
      this.jdField_b_of_type_Boolean = bool1;
      this.jdField_e_of_type_Int = paramParcel.readInt();
      this.jdField_c_of_type_Long = paramParcel.readLong();
      this.jdField_b_of_type_Long = paramParcel.readLong();
      if (paramParcel.readByte() == 0) {
        break label182;
      }
      bool1 = true;
      label152:
      this.jdField_c_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label187;
      }
    }
    label177:
    label182:
    label187:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_e_of_type_Boolean = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label114;
      bool1 = false;
      break label152;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.jdField_c_of_type_Int);
      if (!this.jdField_b_of_type_Boolean) {
        break label172;
      }
      paramInt = 1;
      label106:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.jdField_e_of_type_Int);
      paramParcel.writeLong(this.jdField_c_of_type_Long);
      paramParcel.writeLong(this.jdField_b_of_type_Long);
      if (!this.jdField_c_of_type_Boolean) {
        break label177;
      }
      paramInt = 1;
      label145:
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_e_of_type_Boolean) {
        break label182;
      }
    }
    label172:
    label177:
    label182:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label106;
      paramInt = 0;
      break label145;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo
 * JD-Core Version:    0.7.0.1
 */