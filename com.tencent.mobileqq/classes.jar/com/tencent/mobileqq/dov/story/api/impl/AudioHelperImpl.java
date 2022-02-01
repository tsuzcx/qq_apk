package com.tencent.mobileqq.dov.story.api.impl;

import com.tencent.mobileqq.dov.story.api.IAudioHelper;
import com.tencent.mobileqq.utils.QQAudioHelper;

public class AudioHelperImpl
  implements IAudioHelper
{
  public boolean isHuaWeiGreen()
  {
    return QQAudioHelper.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dov.story.api.impl.AudioHelperImpl
 * JD-Core Version:    0.7.0.1
 */