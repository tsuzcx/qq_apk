package com.tencent.mobileqq.richmediabrowser.model;

import android.os.Parcel;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;

public class AIOPictureData
  extends AIOBrowserBaseData
{
  public Object a;
  public String a;
  public String b = "I:N";
  public int c;
  public String c;
  public int d;
  public String d;
  public boolean d;
  public int e;
  public long e;
  public String e;
  public boolean e;
  public int f;
  public long f;
  public String f;
  public boolean f;
  public int g;
  public long g;
  public String g;
  public boolean g;
  public long h;
  public String h;
  public boolean h;
  public long i;
  public String i;
  public boolean i;
  public String j;
  public boolean j;
  public String k;
  public boolean k;
  public String l;
  public boolean l;
  public String m;
  public boolean m;
  public String n;
  public String o;
  public String p;
  
  public AIOPictureData()
  {
    this.jdField_a_of_type_JavaLangString = "I:N";
    this.jdField_c_of_type_JavaLangString = "I:N";
    this.jdField_d_of_type_JavaLangString = "I:N";
    this.jdField_e_of_type_JavaLangString = "I:N";
    this.jdField_d_of_type_Int = 0;
  }
  
  public int getType()
  {
    return 100;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    boolean bool2 = true;
    super.readFromParcel(paramParcel);
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.jdField_g_of_type_Long = paramParcel.readLong();
    this.jdField_h_of_type_Long = paramParcel.readLong();
    this.jdField_e_of_type_Long = paramParcel.readLong();
    this.jdField_f_of_type_Long = paramParcel.readLong();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jdField_g_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label331;
      }
      bool1 = true;
      label102:
      this.jdField_h_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label336;
      }
      bool1 = true;
      label116:
      this.jdField_i_of_type_Boolean = bool1;
      this.jdField_c_of_type_Int = paramParcel.readInt();
      this.jdField_d_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_JavaLangObject = paramParcel.readValue(null);
      if (paramParcel.readByte() == 0) {
        break label341;
      }
      bool1 = true;
      label155:
      this.jdField_j_of_type_Boolean = bool1;
      this.jdField_i_of_type_Long = paramParcel.readLong();
      this.jdField_g_of_type_JavaLangString = paramParcel.readString();
      this.jdField_h_of_type_JavaLangString = paramParcel.readString();
      this.jdField_e_of_type_Int = paramParcel.readInt();
      this.jdField_f_of_type_Int = paramParcel.readInt();
      this.jdField_i_of_type_JavaLangString = paramParcel.readString();
      this.jdField_f_of_type_JavaLangString = paramParcel.readString();
      this.jdField_j_of_type_JavaLangString = paramParcel.readString();
      this.jdField_k_of_type_JavaLangString = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label346;
      }
      bool1 = true;
      label242:
      this.jdField_k_of_type_Boolean = bool1;
      this.jdField_g_of_type_Int = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label351;
      }
      bool1 = true;
      label265:
      this.jdField_l_of_type_Boolean = bool1;
      this.jdField_l_of_type_JavaLangString = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label356;
      }
    }
    label331:
    label336:
    label341:
    label346:
    label351:
    label356:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_m_of_type_Boolean = bool1;
      this.jdField_m_of_type_JavaLangString = paramParcel.readString();
      this.n = paramParcel.readString();
      this.o = paramParcel.readString();
      this.p = paramParcel.readString();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label102;
      bool1 = false;
      break label116;
      bool1 = false;
      break label155;
      bool1 = false;
      break label242;
      bool1 = false;
      break label265;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = 1;
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_g_of_type_Long);
    paramParcel.writeLong(this.jdField_h_of_type_Long);
    paramParcel.writeLong(this.jdField_e_of_type_Long);
    paramParcel.writeLong(this.jdField_f_of_type_Long);
    if (this.jdField_g_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_h_of_type_Boolean) {
        break label332;
      }
      paramInt = 1;
      label104:
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_i_of_type_Boolean) {
        break label337;
      }
      paramInt = 1;
      label119:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.jdField_c_of_type_Int);
      paramParcel.writeInt(this.jdField_d_of_type_Int);
      paramParcel.writeValue(this.jdField_a_of_type_JavaLangObject);
      if (!this.jdField_j_of_type_Boolean) {
        break label342;
      }
      paramInt = 1;
      label158:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.jdField_i_of_type_Long);
      paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
      paramParcel.writeInt(this.jdField_e_of_type_Int);
      paramParcel.writeInt(this.jdField_f_of_type_Int);
      paramParcel.writeString(this.jdField_i_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_j_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_k_of_type_JavaLangString);
      if (!this.jdField_k_of_type_Boolean) {
        break label347;
      }
      paramInt = 1;
      label245:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.jdField_g_of_type_Int);
      if (!this.jdField_l_of_type_Boolean) {
        break label352;
      }
      paramInt = 1;
      label267:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.jdField_l_of_type_JavaLangString);
      if (!this.jdField_m_of_type_Boolean) {
        break label357;
      }
    }
    label332:
    label337:
    label342:
    label347:
    label352:
    label357:
    for (paramInt = i1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.jdField_m_of_type_JavaLangString);
      paramParcel.writeString(this.n);
      paramParcel.writeString(this.o);
      paramParcel.writeString(this.p);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label104;
      paramInt = 0;
      break label119;
      paramInt = 0;
      break label158;
      paramInt = 0;
      break label245;
      paramInt = 0;
      break label267;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.model.AIOPictureData
 * JD-Core Version:    0.7.0.1
 */