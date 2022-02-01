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
  public String a;
  public int b;
  public String c;
  public String d;
  public BarrageInfo.Sender e;
  public String f;
  public QQText g;
  public QQText h;
  
  public BarrageInfo() {}
  
  protected BarrageInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = ((BarrageInfo.Sender)paramParcel.readParcelable(BarrageInfo.Sender.class.getClassLoader()));
    this.f = paramParcel.readString();
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
    if (!TextUtils.isEmpty(this.c)) {
      this.g = new QQText(EmotionCodecUtils.c(BarrageItemView.a.b(a(this.c))), 7, 15);
    }
  }
  
  public void b()
  {
    BarrageInfo.Sender localSender = this.e;
    if ((localSender != null) && (!TextUtils.isEmpty(localSender.b))) {
      this.h = new QQText(EmotionCodecUtils.c(a(this.e.b)), 7, 15);
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
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", comment='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", commentCornerUrl='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", sender=");
    Object localObject = this.e;
    if (localObject != null) {
      localObject = ((BarrageInfo.Sender)localObject).toString();
    } else {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", uin=");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeParcelable(this.e, paramInt);
    paramParcel.writeString(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.barrage.BarrageInfo
 * JD-Core Version:    0.7.0.1
 */