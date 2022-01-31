package com.tencent.mobileqq.troop.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bbqk;

public class TroopBarMyBar
  implements Parcelable
{
  public static final Parcelable.Creator<TroopBarMyBar> CREATOR = new bbqk();
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
  
  public TroopBarMyBar(long paramLong, String paramString)
  {
    this.jdField_c_of_type_JavaLangString = String.valueOf(paramLong);
    this.jdField_a_of_type_JavaLangString = paramString;
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
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      str = "";
      paramParcel.writeString(str);
      paramParcel.writeInt(this.h);
      paramParcel.writeInt(this.i);
      if (this.jdField_b_of_type_JavaLangString != null) {
        break label172;
      }
      str = "";
      label97:
      paramParcel.writeString(str);
      if (this.jdField_c_of_type_JavaLangString != null) {
        break label180;
      }
      str = "";
      label112:
      paramParcel.writeString(str);
      paramParcel.writeInt(this.j);
      if (this.jdField_d_of_type_JavaLangString != null) {
        break label188;
      }
      str = "";
      label135:
      paramParcel.writeString(str);
      paramParcel.writeInt(this.k);
      if (this.jdField_e_of_type_JavaLangString != null) {
        break label196;
      }
    }
    label172:
    label180:
    label188:
    label196:
    for (String str = "";; str = this.jdField_e_of_type_JavaLangString)
    {
      paramParcel.writeString(str);
      return;
      str = this.jdField_a_of_type_JavaLangString;
      break;
      str = this.jdField_b_of_type_JavaLangString;
      break label97;
      str = this.jdField_c_of_type_JavaLangString;
      break label112;
      str = this.jdField_d_of_type_JavaLangString;
      break label135;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopBarMyBar
 * JD-Core Version:    0.7.0.1
 */