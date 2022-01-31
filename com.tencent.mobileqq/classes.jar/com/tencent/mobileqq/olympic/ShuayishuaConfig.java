package com.tencent.mobileqq.olympic;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import awav;
import java.io.Serializable;
import java.util.ArrayList;

public class ShuayishuaConfig
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<ShuayishuaConfig> CREATOR = new awav();
  public String LUIconImg;
  public String LUIconImgMd5;
  public String actTime;
  public String bgImg;
  public String bgMd5;
  public String grabBeginWording1;
  public String grabBeginWording2;
  public ArrayList<String> grabWordingList = new ArrayList();
  public int id;
  public String noRPWording1;
  public String noRPWording2;
  public String pendantImg;
  public String pendantImgMd5;
  public long realBegin;
  public long realEnd;
  public long timer;
  public String tipWording;
  public String topWording;
  public String torchAnimMd5;
  public String torchAnimUrl;
  public String torchLogoImg;
  public String torchLogoImgMd5;
  public int type;
  public long uiBegin;
  public long uiEnd;
  
  public ShuayishuaConfig() {}
  
  public ShuayishuaConfig(Parcel paramParcel)
  {
    this.type = paramParcel.readInt();
    this.id = paramParcel.readInt();
    this.realBegin = paramParcel.readLong();
    this.realEnd = paramParcel.readLong();
    this.uiBegin = paramParcel.readLong();
    this.uiEnd = paramParcel.readLong();
    this.bgImg = paramParcel.readString();
    this.bgMd5 = paramParcel.readString();
    this.topWording = paramParcel.readString();
    this.actTime = paramParcel.readString();
    this.LUIconImg = paramParcel.readString();
    this.LUIconImgMd5 = paramParcel.readString();
    this.pendantImg = paramParcel.readString();
    this.pendantImgMd5 = paramParcel.readString();
    this.timer = paramParcel.readLong();
    this.tipWording = paramParcel.readString();
    this.grabBeginWording1 = paramParcel.readString();
    this.grabBeginWording2 = paramParcel.readString();
    this.torchLogoImg = paramParcel.readString();
    this.torchLogoImgMd5 = paramParcel.readString();
    paramParcel.readStringList(this.grabWordingList);
    this.noRPWording1 = paramParcel.readString();
    this.noRPWording2 = paramParcel.readString();
    this.torchAnimUrl = paramParcel.readString();
    this.torchAnimMd5 = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append("(");
    localStringBuilder.append("type=").append(this.type).append(",");
    localStringBuilder.append("id=").append(this.id).append(",");
    localStringBuilder.append("realBegin=").append(this.realBegin).append(",");
    localStringBuilder.append("realEnd=").append(this.realEnd).append(",");
    localStringBuilder.append("uiBegin=").append(this.uiBegin).append(",");
    localStringBuilder.append("uiEnd=").append(this.uiEnd).append(",");
    localStringBuilder.append("bgImg=").append(this.bgImg).append(",");
    localStringBuilder.append("bgMd5=").append(this.bgMd5).append(",");
    localStringBuilder.append("topWording=").append(this.topWording).append(",");
    localStringBuilder.append("actTime=").append(this.actTime).append(",");
    localStringBuilder.append("LUIconImg=").append(this.LUIconImg).append(",");
    localStringBuilder.append("LUIconImgMd5=").append(this.LUIconImgMd5).append(",");
    localStringBuilder.append("pendantImg=").append(this.pendantImg).append(",");
    localStringBuilder.append("pendantImgMd5=").append(this.pendantImgMd5).append(",");
    localStringBuilder.append("timer=").append(this.timer).append(",");
    localStringBuilder.append("tipWording=").append(this.tipWording).append(",");
    localStringBuilder.append("grabBeginWording1=").append(this.grabBeginWording1).append(",");
    localStringBuilder.append("grabBeginWording2=").append(this.grabBeginWording2).append(",");
    localStringBuilder.append("torchLogoImg=").append(this.torchLogoImg).append(",");
    localStringBuilder.append("torchLogoImgMd5=").append(this.torchLogoImgMd5).append(",");
    localStringBuilder.append("noRPWording1=").append(this.noRPWording1).append(",");
    localStringBuilder.append("noRPWording2=").append(this.noRPWording2).append(",");
    localStringBuilder.append("grabWordingList=").append(this.grabWordingList).append(",");
    localStringBuilder.append("torchAnimUrl=").append(this.torchAnimUrl).append(",");
    localStringBuilder.append("torchAnimMd5=").append(this.torchAnimMd5);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.type);
    paramParcel.writeInt(this.id);
    paramParcel.writeLong(this.realBegin);
    paramParcel.writeLong(this.realEnd);
    paramParcel.writeLong(this.uiBegin);
    paramParcel.writeLong(this.uiEnd);
    paramParcel.writeString(this.bgImg);
    paramParcel.writeString(this.bgMd5);
    paramParcel.writeString(this.topWording);
    paramParcel.writeString(this.actTime);
    paramParcel.writeString(this.LUIconImg);
    paramParcel.writeString(this.LUIconImgMd5);
    paramParcel.writeString(this.pendantImg);
    paramParcel.writeString(this.pendantImgMd5);
    paramParcel.writeLong(this.timer);
    paramParcel.writeString(this.tipWording);
    paramParcel.writeString(this.grabBeginWording1);
    paramParcel.writeString(this.grabBeginWording2);
    paramParcel.writeString(this.torchLogoImg);
    paramParcel.writeString(this.torchLogoImgMd5);
    paramParcel.writeStringList(this.grabWordingList);
    paramParcel.writeString(this.noRPWording1);
    paramParcel.writeString(this.noRPWording2);
    paramParcel.writeString(this.torchAnimUrl);
    paramParcel.writeString(this.torchAnimMd5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.ShuayishuaConfig
 * JD-Core Version:    0.7.0.1
 */