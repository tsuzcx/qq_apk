package com.tencent.mobileqq.intervideo.singtogether;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.together.TogetherSession;
import com.tencent.mobileqq.together.TogetherUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ThemeImageWrapper;

public class SingTogetherSession
  extends TogetherSession
  implements Parcelable
{
  public static final Parcelable.Creator<SingTogetherSession> CREATOR = new SingTogetherSession.1();
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
    this.jdField_e_of_type_Int = 4;
    this.jdField_f_of_type_Int = paramInt;
    this.jdField_e_of_type_JavaLangString = paramString;
  }
  
  private SingTogetherSession(Parcel paramParcel)
  {
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.jdField_f_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.h = paramParcel.readInt();
    this.jdField_c_of_type_Long = paramParcel.readLong();
    this.i = paramParcel.readInt();
    this.jdField_f_of_type_JavaLangString = paramParcel.readString();
    this.g = paramParcel.readInt();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readLong();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_Long = paramParcel.readLong();
  }
  
  private String c(QQAppInterface paramQQAppInterface)
  {
    if (this.a == 1) {
      return paramQQAppInterface.getApp().getString(2131699321);
    }
    if (this.a == 3) {
      return paramQQAppInterface.getApp().getString(2131699329);
    }
    if (this.a == 2) {
      return paramQQAppInterface.getApp().getString(2131699327);
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
        str = TogetherUtils.a(16, str);
      }
    }
    for (;;)
    {
      return str + paramQQAppInterface.getApp().getString(2131699318);
      str = paramQQAppInterface.getApp().getString(2131699317);
      continue;
      str = paramQQAppInterface.getApp().getString(2131699317);
    }
  }
  
  public int a()
  {
    return ThemeImageWrapper.MODE_CIRCLE;
  }
  
  public String a()
  {
    if (this.h == 4) {
      return "";
    }
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    if (this.h == 4) {
      return paramQQAppInterface.getApp().getString(2131699322);
    }
    String str2 = "";
    String str1;
    if (this.jdField_f_of_type_Int == 2)
    {
      if (this.b > 0L) {
        str2 = a(paramQQAppInterface, this.b + "");
      }
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = paramQQAppInterface.getApp().getString(2131699317);
      }
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        break label197;
      }
    }
    label197:
    for (paramQQAppInterface = paramQQAppInterface.getApp().getString(2131699328);; paramQQAppInterface = String.format(paramQQAppInterface.getApp().getString(2131699325), new Object[] { this.jdField_d_of_type_JavaLangString }))
    {
      return str1 + paramQQAppInterface;
      str1 = str2;
      if (this.jdField_f_of_type_Int != 1) {
        break;
      }
      if (this.b > 0L) {
        str2 = a(paramQQAppInterface, this.jdField_e_of_type_JavaLangString, this.b + "");
      }
      str1 = str2;
      if (!TextUtils.isEmpty(str2)) {
        break;
      }
      str1 = paramQQAppInterface.getApp().getString(2131699345);
      break;
    }
  }
  
  public String a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    Object localObject;
    if (paramBoolean) {
      localObject = paramQQAppInterface.getApp().getString(2131699331);
    }
    do
    {
      String str;
      do
      {
        return localObject;
        str = "";
        localObject = str;
      } while (this.h == 3);
      if (this.jdField_f_of_type_Int == 2) {
        return c(paramQQAppInterface);
      }
      localObject = str;
    } while (this.jdField_f_of_type_Int != 1);
    return a(paramQQAppInterface, 2131699324, 2131699320, 2131699318);
  }
  
  public int b()
  {
    return 2130838403;
  }
  
  public String b(QQAppInterface paramQQAppInterface)
  {
    if (this.h == 3) {}
    do
    {
      return "";
      if (this.jdField_f_of_type_Int == 2) {
        return c(paramQQAppInterface);
      }
    } while (this.jdField_f_of_type_Int != 1);
    return a(paramQQAppInterface, 2131699323, 2131699319);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "ListenTogetherSession{type=" + this.jdField_f_of_type_Int + ", uin='" + this.jdField_e_of_type_JavaLangString + '\'' + ", status=" + this.h + ", timeStamp=" + this.jdField_c_of_type_Long + ", userState=" + this.i + ", creator='" + this.jdField_f_of_type_JavaLangString + '\'' + ", joinNum='" + this.g + '\'' + ", serviceType='" + this.jdField_e_of_type_Int + '\'' + ", roomCover='" + this.jdField_c_of_type_JavaLangString + '\'' + ", singerUin='" + this.b + '\'' + ", songName='" + this.jdField_d_of_type_JavaLangString + '\'' + ", identifyId=" + this.jdField_d_of_type_Long + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeInt(this.h);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeInt(this.i);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeInt(this.g);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeLong(this.b);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_d_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.singtogether.SingTogetherSession
 * JD-Core Version:    0.7.0.1
 */