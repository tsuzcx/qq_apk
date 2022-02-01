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
    int i = this.a;
    if (i == 1) {
      return paramQQAppInterface.getApp().getString(2131699426);
    }
    if (i == 3) {
      return paramQQAppInterface.getApp().getString(2131699434);
    }
    if (i == 2) {
      return paramQQAppInterface.getApp().getString(2131699432);
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
      } else {
        str = paramQQAppInterface.getApp().getString(2131699422);
      }
    }
    else
    {
      str = paramQQAppInterface.getApp().getString(2131699422);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(paramQQAppInterface.getApp().getString(2131699423));
    return localStringBuilder.toString();
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
      return paramQQAppInterface.getApp().getString(2131699427);
    }
    int i = this.jdField_f_of_type_Int;
    Object localObject2 = "";
    Object localObject1;
    if (i == 2)
    {
      if (this.b > 0L)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.b);
        ((StringBuilder)localObject1).append("");
        localObject2 = a(paramQQAppInterface, ((StringBuilder)localObject1).toString());
      }
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = paramQQAppInterface.getApp().getString(2131699422);
      }
    }
    else
    {
      localObject1 = localObject2;
      if (this.jdField_f_of_type_Int == 1)
      {
        if (this.b > 0L)
        {
          localObject1 = this.jdField_e_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.b);
          ((StringBuilder)localObject2).append("");
          localObject2 = a(paramQQAppInterface, (String)localObject1, ((StringBuilder)localObject2).toString());
        }
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = paramQQAppInterface.getApp().getString(2131699450);
        }
      }
    }
    if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      paramQQAppInterface = paramQQAppInterface.getApp().getString(2131699433);
    } else {
      paramQQAppInterface = String.format(paramQQAppInterface.getApp().getString(2131699430), new Object[] { this.jdField_d_of_type_JavaLangString });
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(paramQQAppInterface);
    return ((StringBuilder)localObject2).toString();
  }
  
  public String a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    if (paramBoolean) {
      return paramQQAppInterface.getApp().getString(2131699436);
    }
    String str = "";
    if (this.h == 3) {
      return "";
    }
    if (this.jdField_f_of_type_Int == 2) {
      return c(paramQQAppInterface);
    }
    if (this.jdField_f_of_type_Int == 1) {
      str = a(paramQQAppInterface, 2131699429, 2131699425, 2131699423);
    }
    return str;
  }
  
  public int b()
  {
    return 2130838233;
  }
  
  public String b(QQAppInterface paramQQAppInterface)
  {
    int i = this.h;
    String str = "";
    if (i == 3) {
      return "";
    }
    if (this.jdField_f_of_type_Int == 2) {
      return c(paramQQAppInterface);
    }
    if (this.jdField_f_of_type_Int == 1) {
      str = a(paramQQAppInterface, 2131699428, 2131699424);
    }
    return str;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ListenTogetherSession{type=");
    localStringBuilder.append(this.jdField_f_of_type_Int);
    localStringBuilder.append(", uin='");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", timeStamp=");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append(", userState=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", creator='");
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", joinNum='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", serviceType='");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append('\'');
    localStringBuilder.append(", roomCover='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", singerUin='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", songName='");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", identifyId=");
    localStringBuilder.append(this.jdField_d_of_type_Long);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.singtogether.SingTogetherSession
 * JD-Core Version:    0.7.0.1
 */