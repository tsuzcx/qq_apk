package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import aryc;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;

public class SpecialCareInfo
  extends Entity
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<SpecialCareInfo> CREATOR = new aryc();
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
      localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      do
      {
        Object localObject = this;
      } while (!QLog.isColorLevel());
      QLog.d("Q.contacttab.", 2, "SpecialCareInfo clone failed." + localCloneNotSupportedException.toString());
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
    localStringBuilder.append("\n |-").append("uin:").append(this.uin);
    localStringBuilder.append("\n |-").append("status:").append(getStatus());
    localStringBuilder.append("\n |-").append("dateTime:").append(this.dateTime);
    localStringBuilder.append("\n |-").append("globalSwitch:").append(this.globalSwitch);
    localStringBuilder.append("\n |-").append("specialRingSwitch:").append(this.specialRingSwitch);
    localStringBuilder.append("\n |-").append("friendRingId:").append(this.friendRingId);
    localStringBuilder.append("\n |-").append("qzoneSwitch:").append(this.qzoneSwitch);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.SpecialCareInfo
 * JD-Core Version:    0.7.0.1
 */