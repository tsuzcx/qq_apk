package com.tencent.mobileqq.tribe.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TroopBarMyBar
  implements Parcelable
{
  public static final Parcelable.Creator<TroopBarMyBar> CREATOR = new TroopBarMyBar.1();
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public int g;
  public int h;
  public int i;
  public int j;
  public int k;
  
  public TroopBarMyBar(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString1, int paramInt8, int paramInt9, String paramString2, String paramString3, int paramInt10, String paramString4, int paramInt11, String paramString5)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_d_of_type_Int = paramInt4;
    this.jdField_e_of_type_Int = paramInt5;
    this.f = paramInt6;
    this.g = paramInt7;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.h = paramInt8;
    this.i = paramInt9;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.j = paramInt10;
    this.jdField_d_of_type_JavaLangString = paramString4;
    this.k = paramInt11;
    this.jdField_e_of_type_JavaLangString = paramString5;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof TroopBarMyBar)) {
      return ((TroopBarMyBar)paramObject).jdField_c_of_type_JavaLangString.equals(this.jdField_c_of_type_JavaLangString);
    }
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    String str2 = this.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramParcel.writeString(str1);
    paramParcel.writeInt(this.h);
    paramParcel.writeInt(this.i);
    str2 = this.jdField_b_of_type_JavaLangString;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramParcel.writeString(str1);
    str2 = this.jdField_c_of_type_JavaLangString;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramParcel.writeString(str1);
    paramParcel.writeInt(this.j);
    str2 = this.jdField_d_of_type_JavaLangString;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramParcel.writeString(str1);
    paramParcel.writeInt(this.k);
    str2 = this.jdField_e_of_type_JavaLangString;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramParcel.writeString(str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.data.TroopBarMyBar
 * JD-Core Version:    0.7.0.1
 */