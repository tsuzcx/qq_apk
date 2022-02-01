package com.tencent.mobileqq.filemanager.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public class FavFileInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FavFileInfo> CREATOR = new FavFileInfo.1();
  public long a;
  public String a;
  public boolean a;
  long[] a;
  public long b;
  public String b;
  public long c;
  public String c;
  public long d;
  public String d;
  public long e;
  public String e;
  public long f;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l = "";
  public String m = "";
  public String n;
  public String o;
  
  public FavFileInfo()
  {
    this.jdField_d_of_type_Long = -1L;
    this.jdField_e_of_type_Long = -1L;
    this.jdField_f_of_type_Long = -1L;
    this.jdField_a_of_type_ArrayOfLong = new long[5];
  }
  
  public FavFileInfo(Parcel paramParcel)
  {
    this.jdField_d_of_type_Long = -1L;
    this.jdField_e_of_type_Long = -1L;
    this.jdField_f_of_type_Long = -1L;
    this.jdField_a_of_type_ArrayOfLong = new long[5];
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_c_of_type_Long = paramParcel.readLong();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.jdField_f_of_type_JavaLangString = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
    this.n = paramParcel.readString();
    this.o = paramParcel.readString();
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
    this.jdField_d_of_type_Long = paramParcel.readLong();
    this.jdField_e_of_type_Long = paramParcel.readLong();
    this.l = paramParcel.readString();
    this.jdField_f_of_type_Long = paramParcel.readLong();
    this.m = paramParcel.readString();
  }
  
  public long a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 5)) {
      return this.jdField_a_of_type_ArrayOfLong[paramInt];
    }
    return 0L;
  }
  
  public String a()
  {
    if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
      return this.jdField_f_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(this.k)) {
      this.jdField_f_of_type_JavaLangString = this.k;
    } else if (!TextUtils.isEmpty(this.j)) {
      this.jdField_f_of_type_JavaLangString = this.j;
    } else if (!TextUtils.isEmpty(this.i)) {
      this.jdField_f_of_type_JavaLangString = this.i;
    } else if (!TextUtils.isEmpty(this.h)) {
      this.jdField_f_of_type_JavaLangString = this.h;
    } else if (!TextUtils.isEmpty(this.g)) {
      this.jdField_f_of_type_JavaLangString = this.g;
    }
    return this.jdField_f_of_type_JavaLangString;
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= 5) {
        return;
      }
      this.jdField_a_of_type_ArrayOfLong[paramInt] = paramLong;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.n);
    paramParcel.writeString(this.o);
    paramParcel.writeByte((byte)this.jdField_a_of_type_Boolean);
    paramParcel.writeLong(this.jdField_d_of_type_Long);
    paramParcel.writeLong(this.jdField_e_of_type_Long);
    paramParcel.writeString(this.l);
    paramParcel.writeLong(this.jdField_f_of_type_Long);
    paramParcel.writeString(this.m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FavFileInfo
 * JD-Core Version:    0.7.0.1
 */