package com.tencent.mobileqq.data;

import ajjy;
import amse;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IPSiteModel$Gxzb
  implements Parcelable
{
  public static final String BACKGROUND;
  public static final String BUBBLE;
  public static final String CARD;
  public static final Parcelable.Creator<Gxzb> CREATOR = new amse();
  public static final String EMOJI = ajjy.a(2131640060);
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
    BUBBLE = ajjy.a(2131640057);
    THEME = ajjy.a(2131640053);
    PENDANT = ajjy.a(2131640056);
    FONT = ajjy.a(2131640058);
    BACKGROUND = ajjy.a(2131640059);
    FUNCALL = ajjy.a(2131640052);
    CARD = ajjy.a(2131640054);
    REDPACKT = ajjy.a(2131640055);
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
    return "Gxzb{appid=" + this.appid + ", appName='" + this.appName + '\'' + ", cover='" + this.cover + '\'' + ", feeType=" + this.feeType + ", id='" + this.id + '\'' + ", name='" + this.name + '\'' + '}';
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.IPSiteModel.Gxzb
 * JD-Core Version:    0.7.0.1
 */