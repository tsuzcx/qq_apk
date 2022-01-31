package com.tencent.mobileqq.gallery.model.pic;

import android.os.Parcel;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;

public class AIOPicData
  extends GalleryBaseData
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
  public int h;
  public long h;
  public String h;
  public boolean h;
  public int i;
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
  
  public AIOPicData()
  {
    this.jdField_a_of_type_JavaLangString = "I:N";
    this.jdField_c_of_type_JavaLangString = "I:N";
    this.jdField_d_of_type_JavaLangString = "I:N";
    this.jdField_e_of_type_JavaLangString = "I:N";
    this.jdField_d_of_type_Int = 0;
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(int paramInt)
  {
    this.jdField_h_of_type_Int = paramInt;
  }
  
  public void a(Parcel paramParcel)
  {
    boolean bool2 = true;
    super.a(paramParcel);
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
        break label315;
      }
      bool1 = true;
      label102:
      this.jdField_h_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label320;
      }
      bool1 = true;
      label116:
      this.jdField_i_of_type_Boolean = bool1;
      this.jdField_c_of_type_Int = paramParcel.readInt();
      this.jdField_d_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_JavaLangObject = paramParcel.readValue(null);
      if (paramParcel.readByte() == 0) {
        break label325;
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
        break label330;
      }
      bool1 = true;
      label242:
      this.jdField_k_of_type_Boolean = bool1;
      this.jdField_g_of_type_Int = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label335;
      }
      bool1 = true;
      label265:
      this.jdField_l_of_type_Boolean = bool1;
      this.jdField_l_of_type_JavaLangString = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label340;
      }
    }
    label315:
    label320:
    label325:
    label330:
    label335:
    label340:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_m_of_type_Boolean = bool1;
      this.jdField_m_of_type_JavaLangString = paramParcel.readString();
      this.n = paramParcel.readString();
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
  
  public int describeContents()
  {
    return 0;
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
        break label316;
      }
      paramInt = 1;
      label104:
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_i_of_type_Boolean) {
        break label321;
      }
      paramInt = 1;
      label119:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.jdField_c_of_type_Int);
      paramParcel.writeInt(this.jdField_d_of_type_Int);
      paramParcel.writeValue(this.jdField_a_of_type_JavaLangObject);
      if (!this.jdField_j_of_type_Boolean) {
        break label326;
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
        break label331;
      }
      paramInt = 1;
      label245:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.jdField_g_of_type_Int);
      if (!this.jdField_l_of_type_Boolean) {
        break label336;
      }
      paramInt = 1;
      label267:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.jdField_l_of_type_JavaLangString);
      if (!this.jdField_m_of_type_Boolean) {
        break label341;
      }
    }
    label316:
    label321:
    label326:
    label331:
    label336:
    label341:
    for (paramInt = i1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.jdField_m_of_type_JavaLangString);
      paramParcel.writeString(this.n);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.model.pic.AIOPicData
 * JD-Core Version:    0.7.0.1
 */