package com.tencent.mobileqq.pic;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.qphone.base.util.BaseApplication;

public class CompressInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CompressInfo> CREATOR = new CompressInfo.1();
  public int a;
  public ThumbWidthHeightDP a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  public int e;
  public String e;
  public boolean e;
  public int f;
  public String f;
  public boolean f;
  public int g;
  public boolean g;
  public int h = 2;
  public int i;
  public int j = -1;
  
  public CompressInfo()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
  }
  
  private CompressInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    a(paramParcel);
  }
  
  public CompressInfo(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = paramString;
    this.jdField_g_of_type_Int = paramInt;
  }
  
  public CompressInfo(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = paramString;
    this.jdField_g_of_type_Int = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  public void a(Parcel paramParcel)
  {
    boolean[] arrayOfBoolean = new boolean[7];
    paramParcel.readBooleanArray(arrayOfBoolean);
    this.jdField_a_of_type_Boolean = arrayOfBoolean[0];
    this.jdField_b_of_type_Boolean = arrayOfBoolean[1];
    this.jdField_a_of_type_Boolean = arrayOfBoolean[0];
    this.jdField_b_of_type_Boolean = arrayOfBoolean[1];
    this.jdField_c_of_type_Boolean = arrayOfBoolean[2];
    this.jdField_d_of_type_Boolean = arrayOfBoolean[3];
    this.jdField_e_of_type_Boolean = arrayOfBoolean[4];
    this.jdField_f_of_type_Boolean = arrayOfBoolean[5];
    this.jdField_g_of_type_Boolean = arrayOfBoolean[6];
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.jdField_f_of_type_Int = paramParcel.readInt();
    this.jdField_g_of_type_Int = paramParcel.readInt();
    this.h = paramParcel.readInt();
    this.i = paramParcel.readInt();
    this.jdField_f_of_type_JavaLangString = paramParcel.readString();
    this.j = paramParcel.readInt();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = true;
    BaseApplication localBaseApplication = BaseApplication.getContext();
    int k;
    if (paramBoolean) {
      k = 2131691038;
    } else {
      k = 2131691034;
    }
    this.jdField_b_of_type_JavaLangString = localBaseApplication.getString(k);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nCompressInfo");
    localStringBuilder.append("\n|-");
    localStringBuilder.append("localUUID:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("isSuccess:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("isOOM:");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("isOOS:");
    localStringBuilder.append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("oomMsg:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("srcPath:");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("specPath:");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("destPath:");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("picType:");
    localStringBuilder.append(this.jdField_f_of_type_Int);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("picQuality:");
    localStringBuilder.append(this.jdField_g_of_type_Int);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("networkType:");
    localStringBuilder.append(this.h);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("sampleCompressCnt:");
    localStringBuilder.append(this.i);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("compressMsg:");
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("isResultOriginal:");
    localStringBuilder.append(this.jdField_e_of_type_Boolean);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("uinType:");
    localStringBuilder.append(this.j);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("mCheckJpgQualityAndSize:");
    localStringBuilder.append(this.jdField_g_of_type_Boolean);
    localStringBuilder.append("\n|-");
    localStringBuilder.append("isOverride:");
    localStringBuilder.append(this.jdField_f_of_type_Boolean);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeBooleanArray(new boolean[] { this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean, this.jdField_e_of_type_Boolean, this.jdField_f_of_type_Boolean, this.jdField_g_of_type_Boolean });
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeInt(this.jdField_g_of_type_Int);
    paramParcel.writeInt(this.h);
    paramParcel.writeInt(this.i);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeInt(this.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.CompressInfo
 * JD-Core Version:    0.7.0.1
 */