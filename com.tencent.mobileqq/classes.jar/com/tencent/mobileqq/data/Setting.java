package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class Setting
  extends Entity
  implements Parcelable
{
  public static final Parcelable.Creator<Setting> CREATOR = new Setting.1();
  public byte bFaceFlags;
  public byte bHeadType;
  public byte bSourceType;
  public byte bUsrType;
  public long headImgTimestamp = 0L;
  public short systemHeadID = 0;
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
    localStringBuilder.append("[uin:");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(",headImgTimestamp:");
    localStringBuilder.append(this.headImgTimestamp);
    localStringBuilder.append(",systemHeadId:");
    localStringBuilder.append(this.systemHeadID);
    localStringBuilder.append(",bFaceFlags:");
    localStringBuilder.append(this.bFaceFlags);
    localStringBuilder.append(",bUsrType:");
    localStringBuilder.append(this.bUsrType);
    localStringBuilder.append(",bHeadType:");
    localStringBuilder.append(this.bHeadType);
    localStringBuilder.append(",bSourceType:");
    localStringBuilder.append(this.bSourceType);
    localStringBuilder.append(",updateTimestamp:");
    localStringBuilder.append(this.updateTimestamp);
    localStringBuilder.append(",url:");
    localStringBuilder.append(this.url);
    localStringBuilder.append("]");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.Setting
 * JD-Core Version:    0.7.0.1
 */