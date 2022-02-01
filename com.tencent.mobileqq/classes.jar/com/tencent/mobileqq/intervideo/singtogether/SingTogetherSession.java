package com.tencent.mobileqq.intervideo.singtogether;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import aurb;
import bddf;
import bddg;
import bjuk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class SingTogetherSession
  extends bddf
  implements Parcelable
{
  public static final Parcelable.Creator<SingTogetherSession> CREATOR = new aurb();
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  public String b;
  public String c;
  public String d;
  
  public SingTogetherSession(int paramInt, String paramString)
  {
    this.jdField_d_of_type_Int = 4;
    this.jdField_e_of_type_Int = paramInt;
    this.jdField_e_of_type_JavaLangString = paramString;
  }
  
  private SingTogetherSession(Parcel paramParcel)
  {
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.g = paramParcel.readInt();
    this.jdField_c_of_type_Long = paramParcel.readLong();
    this.h = paramParcel.readInt();
    this.jdField_f_of_type_JavaLangString = paramParcel.readString();
    this.jdField_f_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readLong();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_Long = paramParcel.readLong();
  }
  
  private String c(QQAppInterface paramQQAppInterface)
  {
    if (this.a == 1) {
      return paramQQAppInterface.getApp().getString(2131698664);
    }
    if (this.a == 3) {
      return paramQQAppInterface.getApp().getString(2131698672);
    }
    if (this.a == 2) {
      return paramQQAppInterface.getApp().getString(2131698670);
    }
    return d(paramQQAppInterface);
  }
  
  private String d(QQAppInterface paramQQAppInterface)
  {
    String str;
    if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
    {
      str = a(paramQQAppInterface, this.jdField_f_of_type_JavaLangString);
      if (!TextUtils.isEmpty(str)) {
        str = bddg.a(16, str);
      }
    }
    for (;;)
    {
      return str + paramQQAppInterface.getApp().getString(2131698661);
      str = paramQQAppInterface.getApp().getString(2131698660);
      continue;
      str = paramQQAppInterface.getApp().getString(2131698660);
    }
  }
  
  public int a()
  {
    return bjuk.a;
  }
  
  public String a()
  {
    if (this.g == 4) {
      return "";
    }
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    if (this.g == 4) {
      return paramQQAppInterface.getApp().getString(2131698665);
    }
    String str2 = "";
    String str1;
    if (this.jdField_e_of_type_Int == 2)
    {
      if (this.b > 0L) {
        str2 = a(paramQQAppInterface, this.b + "");
      }
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = paramQQAppInterface.getApp().getString(2131698660);
      }
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        break label197;
      }
    }
    label197:
    for (paramQQAppInterface = paramQQAppInterface.getApp().getString(2131698671);; paramQQAppInterface = String.format(paramQQAppInterface.getApp().getString(2131698668), new Object[] { this.jdField_d_of_type_JavaLangString }))
    {
      return str1 + paramQQAppInterface;
      str1 = str2;
      if (this.jdField_e_of_type_Int != 1) {
        break;
      }
      if (this.b > 0L) {
        str2 = a(paramQQAppInterface, this.jdField_e_of_type_JavaLangString, this.b + "");
      }
      str1 = str2;
      if (!TextUtils.isEmpty(str2)) {
        break;
      }
      str1 = paramQQAppInterface.getApp().getString(2131698688);
      break;
    }
  }
  
  public String a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    Object localObject;
    if (paramBoolean) {
      localObject = paramQQAppInterface.getApp().getString(2131698674);
    }
    do
    {
      String str;
      do
      {
        return localObject;
        str = "";
        localObject = str;
      } while (this.g == 3);
      if (this.jdField_e_of_type_Int == 2) {
        return c(paramQQAppInterface);
      }
      localObject = str;
    } while (this.jdField_e_of_type_Int != 1);
    return a(paramQQAppInterface, 2131698667, 2131698663, 2131698661);
  }
  
  public int b()
  {
    return 2130838321;
  }
  
  public String b(QQAppInterface paramQQAppInterface)
  {
    if (this.g == 3) {}
    do
    {
      return "";
      if (this.jdField_e_of_type_Int == 2) {
        return c(paramQQAppInterface);
      }
    } while (this.jdField_e_of_type_Int != 1);
    return a(paramQQAppInterface, 2131698666, 2131698662);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "ListenTogetherSession{type=" + this.jdField_e_of_type_Int + ", uin='" + this.jdField_e_of_type_JavaLangString + '\'' + ", status=" + this.g + ", timeStamp=" + this.jdField_c_of_type_Long + ", userState=" + this.h + ", creator='" + this.jdField_f_of_type_JavaLangString + '\'' + ", joinNum='" + this.jdField_f_of_type_Int + '\'' + ", serviceType='" + this.jdField_d_of_type_Int + '\'' + ", roomCover='" + this.jdField_c_of_type_JavaLangString + '\'' + ", singerUin='" + this.b + '\'' + ", songName='" + this.jdField_d_of_type_JavaLangString + '\'' + ", identifyId=" + this.jdField_d_of_type_Long + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeInt(this.g);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeInt(this.h);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeLong(this.b);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_d_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.singtogether.SingTogetherSession
 * JD-Core Version:    0.7.0.1
 */