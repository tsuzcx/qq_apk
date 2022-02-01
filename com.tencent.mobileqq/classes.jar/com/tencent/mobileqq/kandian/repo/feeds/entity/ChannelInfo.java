package com.tencent.mobileqq.kandian.repo.feeds.entity;

import com.tencent.mobileqq.persistence.Entity;

public class ChannelInfo
  extends Entity
  implements Cloneable
{
  public static final int GIF_CHANNEL_TYPE = 4;
  public static final int LOCAL_CHANNEL_TYPE = 1;
  public static final int NORMAL_CHANNEL_TYPE = 0;
  public static final int PICTURE_CHANNEL_TYPE = 2;
  public static final String TABLE_NAME = "ChannelInfo";
  public static final int VIDEO_CHANNEL_TYPE = 3;
  public int mChannelID = -1;
  public String mChannelName = "";
  public int mChannelType = 0;
  public int mFollowNum;
  public int mFontColor = -16777216;
  public int mFrameColor = -3355444;
  public String mHeaderPicUrl;
  public boolean mIsFirstReq = false;
  public boolean mIsFollowed;
  public boolean mIsSystemRecomm;
  public boolean mIsTopic;
  public String mJumpUrl = null;
  public boolean mShow = false;
  public int mSortOrder = 0;
  
  public ChannelInfo clone()
  {
    try
    {
      ChannelInfo localChannelInfo = (ChannelInfo)super.clone();
      return localChannelInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ChannelInfo:[");
    localStringBuilder.append("\n |-");
    localStringBuilder.append("mChannelID: ");
    localStringBuilder.append(this.mChannelID);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("mChannelName: ");
    localStringBuilder.append(this.mChannelName);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("mChannelType: ");
    localStringBuilder.append(this.mChannelType);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("mHeaderPicUrl: ");
    localStringBuilder.append(this.mHeaderPicUrl);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("mFollowNum: ");
    localStringBuilder.append(this.mFollowNum);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("mIsFollowed:");
    localStringBuilder.append(this.mIsFollowed);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("mIsSystemRecomm:");
    localStringBuilder.append(this.mIsSystemRecomm);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("mIsTopic:");
    localStringBuilder.append(this.mIsTopic);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelInfo
 * JD-Core Version:    0.7.0.1
 */