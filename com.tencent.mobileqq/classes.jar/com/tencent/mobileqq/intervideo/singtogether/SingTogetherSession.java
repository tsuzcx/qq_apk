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
  public long b;
  public String c;
  public int d;
  public String e;
  public String f;
  public long g;
  public String h;
  
  public SingTogetherSession(int paramInt, String paramString)
  {
    this.l = 4;
    this.m = paramInt;
    this.n = paramString;
  }
  
  private SingTogetherSession(Parcel paramParcel)
  {
    this.l = paramParcel.readInt();
    this.m = paramParcel.readInt();
    this.n = paramParcel.readString();
    this.p = paramParcel.readInt();
    this.t = paramParcel.readLong();
    this.q = paramParcel.readInt();
    this.r = paramParcel.readString();
    this.o = paramParcel.readInt();
    this.f = paramParcel.readString();
    this.g = paramParcel.readLong();
    this.h = paramParcel.readString();
    this.x = paramParcel.readLong();
  }
  
  private String c(QQAppInterface paramQQAppInterface)
  {
    int i = this.a;
    if (i == 1) {
      return paramQQAppInterface.getApp().getString(2131897457);
    }
    if (i == 3) {
      return paramQQAppInterface.getApp().getString(2131897465);
    }
    if (i == 2) {
      return paramQQAppInterface.getApp().getString(2131897463);
    }
    return d(paramQQAppInterface);
  }
  
  private String d(QQAppInterface paramQQAppInterface)
  {
    String str;
    if (!TextUtils.isEmpty(this.r))
    {
      str = a(paramQQAppInterface, this.r);
      if (!TextUtils.isEmpty(str)) {
        str = TogetherUtils.a(16, str);
      } else {
        str = paramQQAppInterface.getApp().getString(2131897453);
      }
    }
    else
    {
      str = paramQQAppInterface.getApp().getString(2131897453);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(paramQQAppInterface.getApp().getString(2131897454));
    return localStringBuilder.toString();
  }
  
  public String a()
  {
    if (this.p == 4) {
      return "";
    }
    return this.f;
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    if (this.p == 4) {
      return paramQQAppInterface.getApp().getString(2131897458);
    }
    int i = this.m;
    Object localObject2 = "";
    Object localObject1;
    if (i == 2)
    {
      if (this.g > 0L)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.g);
        ((StringBuilder)localObject1).append("");
        localObject2 = a(paramQQAppInterface, ((StringBuilder)localObject1).toString());
      }
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = paramQQAppInterface.getApp().getString(2131897453);
      }
    }
    else
    {
      localObject1 = localObject2;
      if (this.m == 1)
      {
        if (this.g > 0L)
        {
          localObject1 = this.n;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.g);
          ((StringBuilder)localObject2).append("");
          localObject2 = a(paramQQAppInterface, (String)localObject1, ((StringBuilder)localObject2).toString());
        }
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = paramQQAppInterface.getApp().getString(2131897481);
        }
      }
    }
    if (TextUtils.isEmpty(this.h)) {
      paramQQAppInterface = paramQQAppInterface.getApp().getString(2131897464);
    } else {
      paramQQAppInterface = String.format(paramQQAppInterface.getApp().getString(2131897461), new Object[] { this.h });
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(paramQQAppInterface);
    return ((StringBuilder)localObject2).toString();
  }
  
  public String a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    if (paramBoolean) {
      return paramQQAppInterface.getApp().getString(2131897467);
    }
    String str = "";
    if (this.p == 3) {
      return "";
    }
    if (this.m == 2) {
      return c(paramQQAppInterface);
    }
    if (this.m == 1) {
      str = a(paramQQAppInterface, 2131897460, 2131897456, 2131897454);
    }
    return str;
  }
  
  public int b()
  {
    return ThemeImageWrapper.MODE_CIRCLE;
  }
  
  public String b(QQAppInterface paramQQAppInterface)
  {
    int i = this.p;
    String str = "";
    if (i == 3) {
      return "";
    }
    if (this.m == 2) {
      return c(paramQQAppInterface);
    }
    if (this.m == 1) {
      str = a(paramQQAppInterface, 2131897459, 2131897455);
    }
    return str;
  }
  
  public int c()
  {
    return 2130838298;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ListenTogetherSession{type=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", uin='");
    localStringBuilder.append(this.n);
    localStringBuilder.append('\'');
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.p);
    localStringBuilder.append(", timeStamp=");
    localStringBuilder.append(this.t);
    localStringBuilder.append(", userState=");
    localStringBuilder.append(this.q);
    localStringBuilder.append(", creator='");
    localStringBuilder.append(this.r);
    localStringBuilder.append('\'');
    localStringBuilder.append(", joinNum='");
    localStringBuilder.append(this.o);
    localStringBuilder.append('\'');
    localStringBuilder.append(", serviceType='");
    localStringBuilder.append(this.l);
    localStringBuilder.append('\'');
    localStringBuilder.append(", roomCover='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", singerUin='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", songName='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", identifyId=");
    localStringBuilder.append(this.x);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.l);
    paramParcel.writeInt(this.m);
    paramParcel.writeString(this.n);
    paramParcel.writeInt(this.p);
    paramParcel.writeLong(this.t);
    paramParcel.writeInt(this.q);
    paramParcel.writeString(this.r);
    paramParcel.writeInt(this.o);
    paramParcel.writeString(this.f);
    paramParcel.writeLong(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeLong(this.x);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.singtogether.SingTogetherSession
 * JD-Core Version:    0.7.0.1
 */