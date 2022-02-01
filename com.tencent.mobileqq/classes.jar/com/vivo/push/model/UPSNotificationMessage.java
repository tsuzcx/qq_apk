package com.vivo.push.model;

import java.util.HashMap;
import java.util.Map;

public class UPSNotificationMessage
{
  public static final int CUSTOM = 3;
  public static final int ISMACROREPLACE = 1;
  public static final int OPENACTIVITY = 4;
  public static final int OPENAPP = 1;
  public static final int OPENURL = 2;
  public static final int UNKNOWN = 0;
  private String mAdClickCheckUrl;
  private int mCompatibleType;
  private String mContent;
  private String mCoverUrl;
  private String mIconUrl;
  private int mIsMacroReplace;
  private long mMsgId;
  private int mNotifyType;
  private Map<String, String> mParams = new HashMap();
  private String mPurePicUrl;
  private boolean mShowTime;
  private String mSkipContent;
  private int mSkipType;
  private int mTargetType;
  private String mTitle;
  private String mTragetContent;
  
  public void clearCoverUrl()
  {
    this.mIconUrl = "";
  }
  
  public void clearPurePicUrl()
  {
    this.mPurePicUrl = "";
  }
  
  public String getAdClickCheckUrl()
  {
    return this.mAdClickCheckUrl;
  }
  
  public int getCompatibleType()
  {
    return this.mCompatibleType;
  }
  
  public String getContent()
  {
    return this.mContent;
  }
  
  public String getCoverUrl()
  {
    return this.mCoverUrl;
  }
  
  public String getIconUrl()
  {
    return this.mIconUrl;
  }
  
  public int getIsMacroReplace()
  {
    return this.mIsMacroReplace;
  }
  
  public long getMsgId()
  {
    return this.mMsgId;
  }
  
  public int getNotifyType()
  {
    return this.mNotifyType;
  }
  
  public Map<String, String> getParams()
  {
    return this.mParams;
  }
  
  public String getPurePicUrl()
  {
    return this.mPurePicUrl;
  }
  
  public String getSkipContent()
  {
    return this.mSkipContent;
  }
  
  public int getSkipType()
  {
    return this.mSkipType;
  }
  
  public int getTargetType()
  {
    return this.mTargetType;
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public String getTragetContent()
  {
    return this.mTragetContent;
  }
  
  public boolean isMacroReplace()
  {
    return this.mIsMacroReplace == 1;
  }
  
  public boolean isShowTime()
  {
    return this.mShowTime;
  }
  
  public void setAdClickCheckUrl(String paramString)
  {
    this.mAdClickCheckUrl = paramString;
  }
  
  public void setCompatibleType(int paramInt)
  {
    this.mCompatibleType = paramInt;
  }
  
  public void setContent(String paramString)
  {
    this.mContent = paramString;
  }
  
  public void setCoverUrl(String paramString)
  {
    this.mCoverUrl = paramString;
  }
  
  public void setIconUrl(String paramString)
  {
    this.mIconUrl = paramString;
  }
  
  public void setIsMacroReplace(int paramInt)
  {
    this.mIsMacroReplace = paramInt;
  }
  
  public void setMsgId(long paramLong)
  {
    this.mMsgId = paramLong;
  }
  
  public void setNotifyType(int paramInt)
  {
    this.mNotifyType = paramInt;
  }
  
  public void setParams(Map<String, String> paramMap)
  {
    this.mParams = paramMap;
  }
  
  public void setPurePicUrl(String paramString)
  {
    this.mPurePicUrl = paramString;
  }
  
  public void setShowTime(boolean paramBoolean)
  {
    this.mShowTime = paramBoolean;
  }
  
  public void setSkipContent(String paramString)
  {
    this.mSkipContent = paramString;
  }
  
  public void setSkipType(int paramInt)
  {
    this.mSkipType = paramInt;
  }
  
  public void setTargetType(int paramInt)
  {
    this.mTargetType = paramInt;
  }
  
  public void setTitle(String paramString)
  {
    this.mTitle = paramString;
  }
  
  public void setTragetContext(String paramString)
  {
    this.mTragetContent = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("UPSNotificationMessage{mTargetType=");
    localStringBuilder.append(this.mTargetType);
    localStringBuilder.append(", mTragetContent='");
    localStringBuilder.append(this.mTragetContent);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mTitle='");
    localStringBuilder.append(this.mTitle);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mContent='");
    localStringBuilder.append(this.mContent);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mNotifyType=");
    localStringBuilder.append(this.mNotifyType);
    localStringBuilder.append(", mPurePicUrl='");
    localStringBuilder.append(this.mPurePicUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mIconUrl='");
    localStringBuilder.append(this.mIconUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mCoverUrl='");
    localStringBuilder.append(this.mCoverUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mSkipContent='");
    localStringBuilder.append(this.mSkipContent);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mSkipType=");
    localStringBuilder.append(this.mSkipType);
    localStringBuilder.append(", mShowTime=");
    localStringBuilder.append(this.mShowTime);
    localStringBuilder.append(", mMsgId=");
    localStringBuilder.append(this.mMsgId);
    localStringBuilder.append(", mParams=");
    localStringBuilder.append(this.mParams);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.model.UPSNotificationMessage
 * JD-Core Version:    0.7.0.1
 */