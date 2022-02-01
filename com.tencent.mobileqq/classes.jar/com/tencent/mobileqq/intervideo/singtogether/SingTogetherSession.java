package com.tencent.mobileqq.intervideo.singtogether;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import avlq;
import bdrn;
import bdro;
import bkpg;
import com.tencent.mobileqq.app.QQAppInterface;

public class SingTogetherSession
  extends bdrn
  implements Parcelable
{
  public static final Parcelable.Creator<SingTogetherSession> CREATOR = new avlq();
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
    String str = "";
    if (this.jdField_e_of_type_Int == 2) {
      if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
      {
        paramQQAppInterface = a(paramQQAppInterface, this.jdField_f_of_type_JavaLangString);
        if (!TextUtils.isEmpty(paramQQAppInterface)) {
          str = bdro.a(16, paramQQAppInterface);
        }
      }
    }
    for (;;)
    {
      return str + "发起一起K歌";
      str = "好友";
      continue;
      str = "好友";
      continue;
      if (this.jdField_e_of_type_Int == 1) {
        if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
        {
          paramQQAppInterface = a(paramQQAppInterface, this.jdField_e_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString);
          if (!TextUtils.isEmpty(paramQQAppInterface)) {
            str = bdro.a(16, paramQQAppInterface);
          } else {
            str = "群友";
          }
        }
        else
        {
          str = "群友";
        }
      }
    }
  }
  
  public int a()
  {
    return bkpg.a;
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
      return "暂无歌曲，等你来点歌。";
    }
    String str = "";
    Object localObject;
    if (this.jdField_e_of_type_Int == 2)
    {
      if (this.b > 0L) {
        str = a(paramQQAppInterface, this.b + "");
      }
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "好友";
      }
      localObject = new StringBuilder().append((String)localObject).append("正在唱");
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        break label176;
      }
    }
    label176:
    for (paramQQAppInterface = "歌";; paramQQAppInterface = "《" + this.jdField_d_of_type_JavaLangString + "》")
    {
      return paramQQAppInterface;
      localObject = str;
      if (this.jdField_e_of_type_Int != 1) {
        break;
      }
      if (this.b > 0L) {
        str = a(paramQQAppInterface, this.jdField_e_of_type_JavaLangString, this.b + "");
      }
      localObject = str;
      if (!TextUtils.isEmpty(str)) {
        break;
      }
      localObject = "群友";
      break;
    }
  }
  
  public String a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    if (paramBoolean) {
      return "收起";
    }
    return b(paramQQAppInterface);
  }
  
  public int b()
  {
    return 2130838286;
  }
  
  public String b(QQAppInterface paramQQAppInterface)
  {
    if (this.g == 3) {}
    do
    {
      return "";
      if (this.jdField_e_of_type_Int == 2)
      {
        if (this.a == 1) {
          return "我正在K歌";
        }
        if (this.a == 3) {
          return "你们正在一起K歌";
        }
        if (this.a == 2) {
          return "对方正在K歌";
        }
        return c(paramQQAppInterface);
      }
    } while (this.jdField_e_of_type_Int != 1);
    if (this.jdField_f_of_type_Int > 1) {
      return this.jdField_f_of_type_Int + "人正在一起K歌";
    }
    if (this.jdField_f_of_type_Int == 1) {
      return this.jdField_f_of_type_Int + "人正在K歌";
    }
    return c(paramQQAppInterface);
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