package com.tencent.mobileqq.emoticonview.api.impl;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.EmotionUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IPicEmoticonInfoService;
import java.io.Serializable;

public class PicEmoticonInfoServiceImpl
  implements IPicEmoticonInfoService
{
  public void send(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo, Emoticon paramEmoticon, Serializable paramSerializable)
  {
    PicEmoticonInfo.send(paramBaseQQAppInterface, paramContext, paramBaseSessionInfo, paramEmoticon, paramSerializable);
  }
  
  public void startSoundDrawablePlay(URLDrawable paramURLDrawable)
  {
    EmotionUtils.startSoundDrawablePlay(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.PicEmoticonInfoServiceImpl
 * JD-Core Version:    0.7.0.1
 */