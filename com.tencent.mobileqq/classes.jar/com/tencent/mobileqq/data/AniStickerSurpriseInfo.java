package com.tencent.mobileqq.data;

import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;

public class AniStickerSurpriseInfo
  extends AniStickerInfo
{
  public String surpriseId;
  
  public AniStickerSurpriseInfo(AniStickerInfo paramAniStickerInfo)
  {
    convert(paramAniStickerInfo);
  }
  
  public String getCacheKey()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.localId);
    localStringBuilder.append("_");
    localStringBuilder.append(this.sevrId);
    localStringBuilder.append("_");
    localStringBuilder.append(this.surpriseId);
    return localStringBuilder.toString();
  }
  
  public String getFilePath()
  {
    return QQSysAndEmojiResMgr.getAniStickerRandomResultFullResPath(this.aniStickerPackId, this.aniStickerId, this.surpriseId);
  }
  
  public String getSurpriseId()
  {
    return this.surpriseId;
  }
  
  public void setSurpriseId(String paramString)
  {
    this.surpriseId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.AniStickerSurpriseInfo
 * JD-Core Version:    0.7.0.1
 */