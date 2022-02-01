package com.tencent.mobileqq.data;

import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo.QQEmoConfigItem;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;

public class AniStickerInfo
{
  public String aniStickerId;
  public String aniStickerPackId;
  public int aniStickerType;
  public int localId;
  public String randomKey;
  public int sevrId;
  public String text;
  
  public void convert(AniStickerInfo paramAniStickerInfo)
  {
    this.aniStickerType = paramAniStickerInfo.aniStickerType;
    this.aniStickerPackId = paramAniStickerInfo.aniStickerPackId;
    this.aniStickerId = paramAniStickerInfo.aniStickerId;
    this.sevrId = paramAniStickerInfo.sevrId;
    this.localId = paramAniStickerInfo.localId;
    this.text = paramAniStickerInfo.text;
  }
  
  public void convert(QQSysAndEmojiResInfo.QQEmoConfigItem paramQQEmoConfigItem)
  {
    this.aniStickerType = paramQQEmoConfigItem.AniStickerType;
    this.aniStickerPackId = paramQQEmoConfigItem.AniStickerPackId;
    this.aniStickerId = paramQQEmoConfigItem.AniStickerId;
    if (paramQQEmoConfigItem.QSid != null)
    {
      this.sevrId = Integer.parseInt(paramQQEmoConfigItem.QSid);
      this.localId = QQSysFaceUtil.convertToLocal(this.sevrId);
    }
    this.text = paramQQEmoConfigItem.QDes;
  }
  
  public String getCacheKey()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.localId);
    localStringBuilder.append("_");
    localStringBuilder.append(this.sevrId);
    return localStringBuilder.toString();
  }
  
  public String getFilePath()
  {
    return QQSysAndEmojiResMgr.getAniStickerFullResPath(this.aniStickerPackId, this.aniStickerId);
  }
  
  public String getResultId()
  {
    return null;
  }
  
  public String getSurpriseId()
  {
    return null;
  }
  
  public void setResultId(String paramString) {}
  
  public void setSurpriseId(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.AniStickerInfo
 * JD-Core Version:    0.7.0.1
 */