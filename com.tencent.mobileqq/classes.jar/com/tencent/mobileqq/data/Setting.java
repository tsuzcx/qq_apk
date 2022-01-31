package com.tencent.mobileqq.data;

import aboh;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class Setting
  extends Entity
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new aboh();
  public byte bFaceFlags;
  public byte bHeadType;
  public byte bSourceType;
  public byte bUsrType;
  public long headImgTimestamp;
  public short systemHeadID;
  @unique
  public String uin;
  public long updateTimestamp;
  public String url;
  
  public Setting clone()
  {
    Setting localSetting = new Setting();
    localSetting.uin = this.uin;
    localSetting.headImgTimestamp = this.headImgTimestamp;
    localSetting.systemHeadID = this.systemHeadID;
    localSetting.bFaceFlags = this.bFaceFlags;
    localSetting.bUsrType = this.bUsrType;
    localSetting.bHeadType = this.bHeadType;
    localSetting.url = this.url;
    localSetting.bSourceType = this.bSourceType;
    localSetting.updateTimestamp = this.updateTimestamp;
    return localSetting;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.uin = paramParcel.readString();
    this.headImgTimestamp = paramParcel.readLong();
    this.systemHeadID = ((short)paramParcel.readInt());
    this.bFaceFlags = paramParcel.readByte();
    this.bUsrType = paramParcel.readByte();
    this.bHeadType = paramParcel.readByte();
    this.url = paramParcel.readString();
    this.bSourceType = paramParcel.readByte();
    this.updateTimestamp = paramParcel.readLong();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("[uin:").append(this.uin);
    localStringBuilder.append(",headImgTimestamp:").append(this.headImgTimestamp);
    localStringBuilder.append(",systemHeadId:").append(this.systemHeadID);
    localStringBuilder.append(",bFaceFlags:").append(this.bFaceFlags);
    localStringBuilder.append(",bUsrType:").append(this.bUsrType);
    localStringBuilder.append(",bHeadType:").append(this.bHeadType);
    localStringBuilder.append(",bSourceType:").append(this.bSourceType);
    localStringBuilder.append(",updateTimestamp:").append(this.updateTimestamp);
    localStringBuilder.append(",url:").append(this.url).append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.uin);
    paramParcel.writeLong(this.headImgTimestamp);
    paramParcel.writeInt(this.systemHeadID);
    paramParcel.writeByte(this.bFaceFlags);
    paramParcel.writeByte(this.bUsrType);
    paramParcel.writeByte(this.bHeadType);
    paramParcel.writeString(this.url);
    paramParcel.writeByte(this.bSourceType);
    paramParcel.writeLong(this.updateTimestamp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.Setting
 * JD-Core Version:    0.7.0.1
 */