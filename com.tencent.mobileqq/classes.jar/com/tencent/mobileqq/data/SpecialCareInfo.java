package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;

@KeepClassConstructor
public class SpecialCareInfo
  extends Entity
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<SpecialCareInfo> CREATOR = new SpecialCareInfo.1();
  public long dateTime;
  public int friendRingId;
  public int globalSwitch;
  public int groupFriendSwitch;
  public int qzoneSwitch;
  public int specialRingSwitch;
  @unique
  public String uin;
  public byte[] zoneInfo;
  
  public SpecialCareInfo() {}
  
  public SpecialCareInfo(Parcel paramParcel)
  {
    this.uin = paramParcel.readString();
    this.dateTime = paramParcel.readLong();
    this.globalSwitch = paramParcel.readInt();
    this.specialRingSwitch = paramParcel.readInt();
    this.friendRingId = paramParcel.readInt();
    this.qzoneSwitch = paramParcel.readInt();
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("SpecialCareInfo clone failed.");
        localStringBuilder.append(localCloneNotSupportedException.toString());
        QLog.d("Q.contacttab.", 2, localStringBuilder.toString());
      }
    }
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n SpecialCareInfo");
    localStringBuilder.append("\n |-");
    localStringBuilder.append("uin:");
    localStringBuilder.append(this.uin);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("status:");
    localStringBuilder.append(getStatus());
    localStringBuilder.append("\n |-");
    localStringBuilder.append("dateTime:");
    localStringBuilder.append(this.dateTime);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("globalSwitch:");
    localStringBuilder.append(this.globalSwitch);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("specialRingSwitch:");
    localStringBuilder.append(this.specialRingSwitch);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("friendRingId:");
    localStringBuilder.append(this.friendRingId);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("qzoneSwitch:");
    localStringBuilder.append(this.qzoneSwitch);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.uin);
    paramParcel.writeLong(this.dateTime);
    paramParcel.writeInt(this.globalSwitch);
    paramParcel.writeInt(this.specialRingSwitch);
    paramParcel.writeInt(this.friendRingId);
    paramParcel.writeInt(this.qzoneSwitch);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.SpecialCareInfo
 * JD-Core Version:    0.7.0.1
 */