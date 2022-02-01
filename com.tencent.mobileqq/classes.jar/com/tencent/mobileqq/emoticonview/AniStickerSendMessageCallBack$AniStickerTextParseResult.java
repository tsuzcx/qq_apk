package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.anisticker.RandomAniStickerConfigBean;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;

public class AniStickerSendMessageCallBack$AniStickerTextParseResult
{
  public boolean configAniSticker = false;
  public int emoLocalId;
  public int emoType;
  public String msg;
  public boolean sessionAvailable = false;
  public boolean singleAniSticker = false;
  
  public boolean isAniStickerEnable()
  {
    if ((this.sessionAvailable) && (this.singleAniSticker) && (this.configAniSticker))
    {
      if (QQSysFaceUtil.isRandomAniSticker(this.emoLocalId)) {
        return ((RandomAniStickerConfigBean)QConfigManager.b().b(773)).a;
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.AniStickerSendMessageCallBack.AniStickerTextParseResult
 * JD-Core Version:    0.7.0.1
 */