package com.tencent.mobileqq.qqlive.data.trtc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class QQLiveRoomParams
  implements Parcelable
{
  public static final Parcelable.Creator<QQLiveRoomParams> CREATOR = new QQLiveRoomParams.1();
  private String mBussinessInfo = "";
  private int mRoleType = 0;
  private long mRoomId = 0L;
  private int mScene = 1;
  private String mStreamId;
  private String mUserDefineRecordId = "";
  private String mUserId = "";
  private String mUserSig;
  
  private QQLiveRoomParams() {}
  
  protected QQLiveRoomParams(Parcel paramParcel)
  {
    this.mUserId = paramParcel.readString();
    this.mRoomId = paramParcel.readLong();
    this.mUserSig = paramParcel.readString();
    this.mRoleType = paramParcel.readInt();
    this.mStreamId = paramParcel.readString();
    this.mUserDefineRecordId = paramParcel.readString();
    this.mBussinessInfo = paramParcel.readString();
    this.mScene = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getBussinessInfo()
  {
    return this.mBussinessInfo;
  }
  
  public int getRoleType()
  {
    return this.mRoleType;
  }
  
  public long getRoomId()
  {
    return this.mRoomId;
  }
  
  public int getScene()
  {
    return this.mScene;
  }
  
  public String getStreamId()
  {
    return this.mStreamId;
  }
  
  public String getUserDefineRecordId()
  {
    return this.mUserDefineRecordId;
  }
  
  public String getUserId()
  {
    return this.mUserId;
  }
  
  public String getUserSig()
  {
    return this.mUserSig;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mUserId);
    paramParcel.writeLong(this.mRoomId);
    paramParcel.writeString(this.mUserSig);
    paramParcel.writeInt(this.mRoleType);
    paramParcel.writeString(this.mStreamId);
    paramParcel.writeString(this.mUserDefineRecordId);
    paramParcel.writeString(this.mBussinessInfo);
    paramParcel.writeInt(this.mScene);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.trtc.QQLiveRoomParams
 * JD-Core Version:    0.7.0.1
 */