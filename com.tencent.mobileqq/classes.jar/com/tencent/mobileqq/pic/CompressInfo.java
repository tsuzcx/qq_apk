package com.tencent.mobileqq.pic;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import azpo;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.qphone.base.util.BaseApplication;

public class CompressInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CompressInfo> CREATOR = new azpo();
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
  }
  
  private CompressInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_d_of_type_Boolean = true;
    a(paramParcel);
  }
  
  public CompressInfo(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_c_of_type_JavaLangString = paramString;
    this.jdField_g_of_type_Int = paramInt;
  }
  
  public CompressInfo(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_d_of_type_Boolean = true;
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
    if (paramBoolean) {}
    for (int k = 2131690886;; k = 2131690882)
    {
      this.jdField_b_of_type_JavaLangString = localBaseApplication.getString(k);
      return;
    }
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
    localStringBuilder.append("\n|-").append("localUUID:").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\n|-").append("isSuccess:").append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("\n|-").append("isOOM:").append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("\n|-").append("isOOS:").append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append("\n|-").append("oomMsg:").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("\n|-").append("srcPath:").append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("\n|-").append("specPath:").append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append("\n|-").append("destPath:").append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append("\n|-").append("picType:").append(this.jdField_f_of_type_Int);
    localStringBuilder.append("\n|-").append("picQuality:").append(this.jdField_g_of_type_Int);
    localStringBuilder.append("\n|-").append("networkType:").append(this.h);
    localStringBuilder.append("\n|-").append("sampleCompressCnt:").append(this.i);
    localStringBuilder.append("\n|-").append("compressMsg:").append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append("\n|-").append("isResultOriginal:").append(this.jdField_e_of_type_Boolean);
    localStringBuilder.append("\n|-").append("uinType:").append(this.j);
    localStringBuilder.append("\n|-").append("mCheckJpgQualityAndSize:").append(this.jdField_g_of_type_Boolean);
    localStringBuilder.append("\n|-").append("isOverride:").append(this.jdField_f_of_type_Boolean);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.CompressInfo
 * JD-Core Version:    0.7.0.1
 */