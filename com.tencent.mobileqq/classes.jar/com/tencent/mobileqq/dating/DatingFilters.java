package com.tencent.mobileqq.dating;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import appoint.define.appoint_define.LocaleInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBStringField;
import java.io.UnsupportedEncodingException;

public class DatingFilters
  implements Parcelable
{
  public static final Parcelable.Creator<DatingFilters> CREATOR = new DatingFilters.1();
  public static final int[] a;
  public static final String[] a;
  public static final int[] b;
  public static final String[] b;
  public static String[] c;
  public int a;
  public appoint_define.LocaleInfo a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f = 0;
  public int g;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { HardCodeUtil.a(2131702888), "18-22岁", "23-26岁", "27-35岁", "35岁以上" };
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 22, 26, 35, 120 };
    jdField_b_of_type_ArrayOfInt = new int[] { 0, 18, 23, 27, 36 };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { HardCodeUtil.a(2131702886), HardCodeUtil.a(2131702892), HardCodeUtil.a(2131702891), HardCodeUtil.a(2131702889), HardCodeUtil.a(2131702887) };
    jdField_c_of_type_ArrayOfJavaLangString = new String[] { HardCodeUtil.a(2131702894), HardCodeUtil.a(2131702896), HardCodeUtil.a(2131702893), HardCodeUtil.a(2131702890), HardCodeUtil.a(2131702885), HardCodeUtil.a(2131702895) };
  }
  
  private DatingFilters(Parcel paramParcel)
  {
    this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo = null;
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
    paramParcel = paramParcel.readString();
    if ((paramParcel == null) || (paramParcel.equals("")))
    {
      this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo = null;
      return;
    }
    try
    {
      appoint_define.LocaleInfo localLocaleInfo = new appoint_define.LocaleInfo();
      localLocaleInfo.mergeFrom(paramParcel.getBytes("ISO-8859-1"));
      this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo = localLocaleInfo;
      return;
    }
    catch (Exception paramParcel)
    {
      this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo = null;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (DatingFilters)paramObject;
      if (this.e != paramObject.e) {
        return false;
      }
      if (this.f != paramObject.f) {
        return false;
      }
      if (this.jdField_c_of_type_Int != paramObject.jdField_c_of_type_Int) {
        return false;
      }
      if (this.jdField_b_of_type_Int != paramObject.jdField_b_of_type_Int) {
        return false;
      }
      if (this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int) {
        return false;
      }
    } while ((this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo == paramObject.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo) || ((this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo != null) && (paramObject.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo != null) && (this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo.str_name.get().equals(paramObject.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo.str_name.get()))));
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DatingFilters [gender=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", datingTime=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", datingContent=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", age=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", career=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", dest=");
    if (this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo == null) {}
    for (String str = "null";; str = this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo.str_name.get())
    {
      localStringBuilder.append(str);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    try
    {
      if (this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo == null) {}
      for (String str = "";; str = new String(this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo.toByteArray(), "ISO-8859-1"))
      {
        paramParcel.writeString(str);
        return;
      }
      return;
    }
    catch (UnsupportedEncodingException paramParcel)
    {
      paramParcel.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingFilters
 * JD-Core Version:    0.7.0.1
 */