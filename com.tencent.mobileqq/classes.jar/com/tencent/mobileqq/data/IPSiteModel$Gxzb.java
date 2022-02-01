package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import mqq.app.MobileQQ;

public class IPSiteModel$Gxzb
  implements Parcelable
{
  public static final String BACKGROUND;
  public static final String BUBBLE;
  public static final String CARD;
  public static final Parcelable.Creator<Gxzb> CREATOR = new IPSiteModel.Gxzb.1();
  public static final String EMOJI = MobileQQ.sMobileQQ.getString(2131916985);
  public static final String FONT;
  public static final String FUNCALL;
  public static final String PENDANT;
  public static final String REDPACKT;
  public static final String THEME;
  public String appName;
  public int appid;
  public String cover;
  public int feeType;
  public String id;
  public String name;
  
  static
  {
    BUBBLE = MobileQQ.sMobileQQ.getString(2131916982);
    THEME = MobileQQ.sMobileQQ.getString(2131916993);
    PENDANT = MobileQQ.sMobileQQ.getString(2131916989);
    FONT = MobileQQ.sMobileQQ.getString(2131916987);
    BACKGROUND = MobileQQ.sMobileQQ.getString(2131916981);
    FUNCALL = MobileQQ.sMobileQQ.getString(2131916988);
    CARD = MobileQQ.sMobileQQ.getString(2131916983);
    REDPACKT = MobileQQ.sMobileQQ.getString(2131916991);
  }
  
  public IPSiteModel$Gxzb() {}
  
  public IPSiteModel$Gxzb(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    this.appid = paramInt1;
    this.appName = paramString1;
    this.cover = paramString2;
    this.feeType = paramInt2;
    this.id = paramString3;
    this.name = paramString4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Gxzb{appid=");
    localStringBuilder.append(this.appid);
    localStringBuilder.append(", appName='");
    localStringBuilder.append(this.appName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", cover='");
    localStringBuilder.append(this.cover);
    localStringBuilder.append('\'');
    localStringBuilder.append(", feeType=");
    localStringBuilder.append(this.feeType);
    localStringBuilder.append(", id='");
    localStringBuilder.append(this.id);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.appid);
    paramParcel.writeString(this.appName);
    paramParcel.writeString(this.cover);
    paramParcel.writeInt(this.feeType);
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.name);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.IPSiteModel.Gxzb
 * JD-Core Version:    0.7.0.1
 */