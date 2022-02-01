package com.tencent.mobileqq.emoticon;

public class QQSysAndEmojiResMgr$DownloadResItem
{
  public static final int TYPE_CONFIG_RES = 1;
  public static final int TYPE_EMOJI_RES = 3;
  public static final int TYPE_SYSFACE_RES = 2;
  public String mMd5;
  public String mName;
  public int mType;
  public String mUrl;
  
  public QQSysAndEmojiResMgr$DownloadResItem(String paramString1, String paramString2, int paramInt)
  {
    this.mUrl = paramString1;
    this.mMd5 = paramString2;
    this.mName = paramString1.substring(paramString1.lastIndexOf("/") + 1);
    this.mType = paramInt;
  }
  
  public String getSignature()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mUrl);
    localStringBuilder.append("_");
    localStringBuilder.append(this.mMd5);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr.DownloadResItem
 * JD-Core Version:    0.7.0.1
 */