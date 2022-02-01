package com.tencent.mobileqq.data;

import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;

public class AniStickerResultInfo
  extends AniStickerInfo
{
  public String resultId;
  
  public AniStickerResultInfo(AniStickerInfo paramAniStickerInfo)
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
    localStringBuilder.append(this.resultId);
    return localStringBuilder.toString();
  }
  
  public String getFilePath()
  {
    return QQSysAndEmojiResMgr.getAniStickerRandomResultFullResPath(this.aniStickerPackId, this.aniStickerId, this.resultId);
  }
  
  public String getResultId()
  {
    return this.resultId;
  }
  
  public void setResultId(String paramString)
  {
    this.resultId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.AniStickerResultInfo
 * JD-Core Version:    0.7.0.1
 */