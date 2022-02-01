package com.tencent.mobileqq.kandian.biz.viola.barrage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;

public class BarrageInfo
  implements Parcelable
{
  public static final Parcelable.Creator<BarrageInfo> CREATOR = new BarrageInfo.1();
  public int a;
  public BarrageInfo.Sender a;
  public QQText a;
  public String a;
  public QQText b;
  public String b;
  public String c;
  public String d;
  
  public BarrageInfo() {}
  
  protected BarrageInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.c = paramParcel.readString();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageInfo$Sender = ((BarrageInfo.Sender)paramParcel.readParcelable(BarrageInfo.Sender.class.getClassLoader()));
    this.d = paramParcel.readString();
  }
  
  private static String a(String paramString)
  {
    String str;
    StringBuilder localStringBuilder;
    if (paramString != null)
    {
      str = paramString;
      try
      {
        if ("".equals(paramString)) {
          return "";
        }
        str = paramString;
        paramString = paramString.replace("\r\n", " ").replace("\n", " ");
        str = paramString;
        localStringBuilder = new StringBuilder(paramString);
        for (;;)
        {
          str = paramString;
          if (localStringBuilder.length() <= 0) {
            break;
          }
          str = paramString;
          if (!Character.isWhitespace(localStringBuilder.charAt(0))) {
            break;
          }
          str = paramString;
          localStringBuilder.deleteCharAt(0);
        }
        str = paramString;
        for (int i = localStringBuilder.length(); i > 0; i = localStringBuilder.length())
        {
          i -= 1;
          str = paramString;
          if (!Character.isWhitespace(localStringBuilder.charAt(i))) {
            break;
          }
          str = paramString;
          localStringBuilder.deleteCharAt(i);
          str = paramString;
        }
        str = paramString;
        paramString = localStringBuilder.toString();
        return paramString;
      }
      catch (Exception paramString) {}
    }
    else
    {
      return "";
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("error. string: ");
      localStringBuilder.append(str);
      localStringBuilder.append(", errorInfo: ");
      localStringBuilder.append(paramString.getMessage());
      QLog.e("BarrageInfo", 2, localStringBuilder.toString());
    }
    if (str != null) {
      return str;
    }
    return "";
  }
  
  public void a()
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqTextQQText = new QQText(EmotionCodecUtils.b(BarrageItemView.a.a(a(this.jdField_b_of_type_JavaLangString))), 7, 15);
    }
  }
  
  public void b()
  {
    BarrageInfo.Sender localSender = this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageInfo$Sender;
    if ((localSender != null) && (!TextUtils.isEmpty(localSender.jdField_b_of_type_JavaLangString))) {
      this.jdField_b_of_type_ComTencentMobileqqTextQQText = new QQText(EmotionCodecUtils.b(a(this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageInfo$Sender.jdField_b_of_type_JavaLangString)), 7, 15);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BarrageInfo{id='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", comment='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", commentCornerUrl='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", sender=");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageInfo$Sender;
    if (localObject != null) {
      localObject = ((BarrageInfo.Sender)localObject).toString();
    } else {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", uin=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageInfo$Sender, paramInt);
    paramParcel.writeString(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.barrage.BarrageInfo
 * JD-Core Version:    0.7.0.1
 */