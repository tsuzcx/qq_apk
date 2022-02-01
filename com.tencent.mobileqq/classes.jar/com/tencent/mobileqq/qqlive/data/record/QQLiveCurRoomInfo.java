package com.tencent.mobileqq.qqlive.data.record;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public class QQLiveCurRoomInfo
  implements Parcelable
{
  public static final Parcelable.Creator<QQLiveCurRoomInfo> CREATOR = new QQLiveCurRoomInfo.1();
  public static final int ROOM_TYPE_ANCHOR = 1;
  public static final int ROOM_TYPE_AUDIENCE = 2;
  public static final int ROOM_TYPE_UNKNOW = 0;
  public boolean isFloatWindow;
  public boolean playingAudio;
  public boolean playingVideo;
  public int processContextHashCode;
  public int processId;
  public String programId;
  public long roomId;
  public int roomType;
  public long uid;
  public boolean usingAudioRecord;
  public boolean usingCamera;
  public boolean usingScreenCapture;
  
  public QQLiveCurRoomInfo()
  {
    this.roomType = 0;
  }
  
  public QQLiveCurRoomInfo(Parcel paramParcel)
  {
    boolean bool2 = false;
    this.roomType = 0;
    this.roomType = paramParcel.readInt();
    this.roomId = paramParcel.readLong();
    this.programId = paramParcel.readString();
    this.uid = paramParcel.readLong();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.isFloatWindow = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.playingVideo = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.playingAudio = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.usingAudioRecord = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.usingCamera = bool1;
    boolean bool1 = bool2;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    }
    this.usingScreenCapture = bool1;
    this.processId = paramParcel.readInt();
    this.processContextHashCode = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean isConditionEquals(QQLiveCurRoomInfo paramQQLiveCurRoomInfo)
  {
    if (paramQQLiveCurRoomInfo != null)
    {
      if (paramQQLiveCurRoomInfo == this) {
        return true;
      }
      return (paramQQLiveCurRoomInfo.roomId == this.roomId) && (paramQQLiveCurRoomInfo.roomType == this.roomType) && (TextUtils.equals(paramQQLiveCurRoomInfo.programId, this.programId));
    }
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQLiveCurRoomInfo{roomType=");
    localStringBuilder.append(this.roomType);
    localStringBuilder.append(", roomId=");
    localStringBuilder.append(this.roomId);
    localStringBuilder.append(", programId=");
    localStringBuilder.append(this.programId);
    localStringBuilder.append(", uid=");
    localStringBuilder.append(this.uid);
    localStringBuilder.append(", isFloatWindow=");
    localStringBuilder.append(this.isFloatWindow);
    localStringBuilder.append(", playingVideo=");
    localStringBuilder.append(this.playingVideo);
    localStringBuilder.append(", playingAudio=");
    localStringBuilder.append(this.playingAudio);
    localStringBuilder.append(", usingAudioRecord=");
    localStringBuilder.append(this.usingAudioRecord);
    localStringBuilder.append(", usingCamera=");
    localStringBuilder.append(this.usingCamera);
    localStringBuilder.append(", usingScreenCapture=");
    localStringBuilder.append(this.usingScreenCapture);
    localStringBuilder.append(", processId=");
    localStringBuilder.append(this.processId);
    localStringBuilder.append(", processContextHashCode=");
    localStringBuilder.append(this.processContextHashCode);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.roomType);
    paramParcel.writeLong(this.roomId);
    paramParcel.writeString(this.programId);
    paramParcel.writeLong(this.uid);
    paramParcel.writeByte((byte)this.isFloatWindow);
    paramParcel.writeByte((byte)this.playingVideo);
    paramParcel.writeByte((byte)this.playingAudio);
    paramParcel.writeByte((byte)this.usingAudioRecord);
    paramParcel.writeByte((byte)this.usingCamera);
    paramParcel.writeByte((byte)this.usingScreenCapture);
    paramParcel.writeInt(this.processId);
    paramParcel.writeInt(this.processContextHashCode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.record.QQLiveCurRoomInfo
 * JD-Core Version:    0.7.0.1
 */