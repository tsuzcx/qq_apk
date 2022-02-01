package com.tencent.mobileqq.kandian.repo.comment.entity;

import androidx.annotation.NonNull;
import java.io.Serializable;

public class RIJBiuAndCommentRequestData
  implements Serializable
{
  private int mCommentType;
  private int mContentSrc;
  private String mContentString;
  private boolean mIsBiu;
  private boolean mIsDiffuseToFriends;
  private boolean mIsSecondReply;
  private int mListShowType;
  private String mMediaPicHeight;
  private String mMediaPicUrl;
  private String mMediaPicWidth;
  private String mMediaTextInfo;
  private String mReplyCommentId;
  private String mReplyParentCommentId;
  private String mReplyUin;
  private String mRowKey;
  
  public int getCommentType()
  {
    return this.mCommentType;
  }
  
  public int getContentSrc()
  {
    return this.mContentSrc;
  }
  
  public String getContentString()
  {
    return this.mContentString;
  }
  
  public int getListShowType()
  {
    return this.mListShowType;
  }
  
  public String getMediaPicHeight()
  {
    return this.mMediaPicHeight;
  }
  
  public String getMediaPicUrl()
  {
    return this.mMediaPicUrl;
  }
  
  public String getMediaPicWidth()
  {
    return this.mMediaPicWidth;
  }
  
  public String getMediaTextInfo()
  {
    return this.mMediaTextInfo;
  }
  
  public String getReplyCommentId()
  {
    return this.mReplyCommentId;
  }
  
  public String getReplyParentCommentId()
  {
    return this.mReplyParentCommentId;
  }
  
  public String getReplyUin()
  {
    return this.mReplyUin;
  }
  
  public String getRowKey()
  {
    return this.mRowKey;
  }
  
  public boolean isBiu()
  {
    return this.mIsBiu;
  }
  
  public boolean isDiffuseToFriends()
  {
    return this.mIsDiffuseToFriends;
  }
  
  public boolean isIsSecondReply()
  {
    return this.mIsSecondReply;
  }
  
  public void setBiu(boolean paramBoolean)
  {
    this.mIsBiu = paramBoolean;
  }
  
  public void setCommentType(int paramInt)
  {
    this.mCommentType = paramInt;
  }
  
  public void setContentSrc(int paramInt)
  {
    this.mContentSrc = paramInt;
  }
  
  public void setContentString(String paramString)
  {
    this.mContentString = paramString;
  }
  
  public void setDiffuseToFriends(boolean paramBoolean)
  {
    this.mIsDiffuseToFriends = paramBoolean;
  }
  
  public void setIsSecondReply(boolean paramBoolean)
  {
    this.mIsSecondReply = paramBoolean;
  }
  
  public void setListShowType(int paramInt)
  {
    this.mListShowType = paramInt;
  }
  
  public void setMediaPicHeight(String paramString)
  {
    this.mMediaPicHeight = paramString;
  }
  
  public void setMediaPicUrl(String paramString)
  {
    this.mMediaPicUrl = paramString;
  }
  
  public void setMediaPicWidth(String paramString)
  {
    this.mMediaPicWidth = paramString;
  }
  
  public void setMediaTextInfo(String paramString)
  {
    this.mMediaTextInfo = paramString;
  }
  
  public void setReplyCommentId(String paramString)
  {
    this.mReplyCommentId = paramString;
  }
  
  public void setReplyParentCommentId(String paramString)
  {
    this.mReplyParentCommentId = paramString;
  }
  
  public void setReplyUin(String paramString)
  {
    this.mReplyUin = paramString;
  }
  
  public void setRowKey(String paramString)
  {
    this.mRowKey = paramString;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RIJBiuAndCommentRequestData{mRowKey='");
    localStringBuilder.append(this.mRowKey);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mContentSrc=");
    localStringBuilder.append(this.mContentSrc);
    localStringBuilder.append(", mIsBiu=");
    localStringBuilder.append(this.mIsBiu);
    localStringBuilder.append(", mIsDiffuseToFriends=");
    localStringBuilder.append(this.mIsDiffuseToFriends);
    localStringBuilder.append(", mContentString='");
    localStringBuilder.append(this.mContentString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mIsSecondReply=");
    localStringBuilder.append(this.mIsSecondReply);
    localStringBuilder.append(", mLocalCommentId='");
    localStringBuilder.append(this.mReplyCommentId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mReplyUin='");
    localStringBuilder.append(this.mReplyUin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mCommentType=");
    localStringBuilder.append(this.mCommentType);
    localStringBuilder.append(", mListShowType=");
    localStringBuilder.append(this.mListShowType);
    localStringBuilder.append(", mMediaTextInfo='");
    localStringBuilder.append(this.mMediaTextInfo);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mMediaPicUrl='");
    localStringBuilder.append(this.mMediaPicUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mMediaPicWidth='");
    localStringBuilder.append(this.mMediaPicWidth);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mMediaPicHeight='");
    localStringBuilder.append(this.mMediaPicHeight);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.comment.entity.RIJBiuAndCommentRequestData
 * JD-Core Version:    0.7.0.1
 */