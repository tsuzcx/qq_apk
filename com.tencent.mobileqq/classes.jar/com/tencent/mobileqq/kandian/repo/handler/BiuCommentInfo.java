package com.tencent.mobileqq.kandian.repo.handler;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class BiuCommentInfo
  implements Parcelable, Serializable, Cloneable
{
  public static final Parcelable.Creator<BiuCommentInfo> CREATOR = new BiuCommentInfo.1();
  public static final int OP_TYPE_AT = 1;
  public static final int OP_TYPE_BIU = 0;
  public static final int OP_TYPE_COMMUNITY = 4;
  public static final int OP_TYPE_TOPIC = 2;
  public static final int OP_TYPE_URL = 3;
  public JumpInfo jumpInfo;
  public String mBiuComment;
  public int mBiuTime;
  public Long mFeedId;
  public int mFeedsType = 1;
  public int mOpType = 0;
  public String mOrigBiuComment;
  public Long mUin;
  public UGCVoiceInfo ugcVoiceInfo;
  
  public BiuCommentInfo() {}
  
  protected BiuCommentInfo(Parcel paramParcel)
  {
    this.mBiuTime = paramParcel.readInt();
    this.mUin = ((Long)paramParcel.readValue(Long.class.getClassLoader()));
    this.mFeedId = ((Long)paramParcel.readValue(Long.class.getClassLoader()));
    this.mBiuComment = paramParcel.readString();
    this.mOrigBiuComment = paramParcel.readString();
    this.mFeedsType = paramParcel.readInt();
    this.jumpInfo = ((JumpInfo)paramParcel.readParcelable(JumpInfo.class.getClassLoader()));
    this.mOpType = paramParcel.readInt();
    this.ugcVoiceInfo = ((UGCVoiceInfo)paramParcel.readParcelable(UGCVoiceInfo.class.getClassLoader()));
  }
  
  public BiuCommentInfo(Long paramLong1, Long paramLong2, String paramString)
  {
    this.mUin = paramLong1;
    this.mFeedId = paramLong2;
    this.mBiuComment = paramString;
  }
  
  public BiuCommentInfo(String paramString1, Long paramLong, String paramString2)
  {
    try
    {
      this.mUin = Long.valueOf(paramString1);
    }
    catch (Exception paramString1)
    {
      label25:
      break label25;
    }
    this.mUin = Long.valueOf(0L);
    this.mFeedId = paramLong;
    this.mBiuComment = paramString2;
  }
  
  public BiuCommentInfo(String paramString1, Long paramLong, String paramString2, int paramInt)
  {
    this(paramString1, paramLong, paramString2);
    this.mOpType = paramInt;
  }
  
  public BiuCommentInfo(String paramString1, Long paramLong, String paramString2, int paramInt, JumpInfo paramJumpInfo)
  {
    this(paramString1, paramLong, paramString2, paramInt);
    this.jumpInfo = paramJumpInfo;
  }
  
  public BiuCommentInfo(String paramString1, Long paramLong, String paramString2, int paramInt, JumpInfo paramJumpInfo, UGCVoiceInfo paramUGCVoiceInfo)
  {
    this(paramString1, paramLong, paramString2, paramInt, paramJumpInfo);
    this.ugcVoiceInfo = paramUGCVoiceInfo;
  }
  
  public BiuCommentInfo clone()
  {
    try
    {
      BiuCommentInfo localBiuCommentInfo = (BiuCommentInfo)super.clone();
      return localBiuCommentInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label10:
      break label10;
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("biuTime=");
    localStringBuilder.append(this.mBiuTime);
    localStringBuilder.append("uin=");
    localStringBuilder.append(this.mUin);
    localStringBuilder.append("feedId=");
    localStringBuilder.append(this.mFeedId);
    localStringBuilder.append("comment=");
    localStringBuilder.append(this.mBiuComment);
    localStringBuilder.append("feedsType=");
    localStringBuilder.append(this.mFeedsType);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mBiuTime);
    paramParcel.writeValue(this.mUin);
    paramParcel.writeValue(this.mFeedId);
    paramParcel.writeString(this.mBiuComment);
    paramParcel.writeString(this.mOrigBiuComment);
    paramParcel.writeInt(this.mFeedsType);
    paramParcel.writeParcelable(this.jumpInfo, paramInt);
    paramParcel.writeInt(this.mOpType);
    paramParcel.writeParcelable(this.ugcVoiceInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo
 * JD-Core Version:    0.7.0.1
 */