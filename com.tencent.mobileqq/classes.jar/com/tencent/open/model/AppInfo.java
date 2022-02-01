package com.tencent.open.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.qqconnect.Appinfo;

public class AppInfo
  implements Parcelable
{
  public static final Parcelable.Creator<AppInfo> CREATOR = new AppInfo.1();
  private int a = -1;
  private int b = -1;
  private String c = "";
  private String d = "";
  private boolean e;
  
  public AppInfo(int paramInt, String paramString1, String paramString2)
  {
    this.e = false;
    this.a = paramInt;
    this.c = paramString1;
    this.d = paramString2;
  }
  
  protected AppInfo(Parcel paramParcel)
  {
    boolean bool = false;
    this.e = false;
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.e = bool;
  }
  
  public AppInfo(qqconnect.Appinfo paramAppinfo)
  {
    this.e = false;
    if (paramAppinfo.appid.has()) {
      this.a = paramAppinfo.appid.get();
    }
    if (paramAppinfo.app_name.has()) {
      this.c = paramAppinfo.app_name.get();
    }
    if (paramAppinfo.app_type.has()) {
      this.b = paramAppinfo.app_type.get();
    }
    if (paramAppinfo.icon_url.has()) {
      this.d = paramAppinfo.icon_url.get();
    }
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public String b()
  {
    int i = this.b;
    if (i != 100)
    {
      switch (i)
      {
      default: 
        return HardCodeUtil.a(2131898859);
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
        return "";
      case 2: 
        return HardCodeUtil.a(2131898860);
      case 1: 
        return HardCodeUtil.a(2131898861);
      }
      return HardCodeUtil.a(2131898858);
    }
    return "";
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean e()
  {
    return this.e;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("AppInfo{");
    localStringBuilder.append("mId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mName='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", type='");
    localStringBuilder.append(b());
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeByte((byte)this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.model.AppInfo
 * JD-Core Version:    0.7.0.1
 */