package com.tencent.mobileqq.teamwork.api.impl;

import com.tencent.mobileqq.teamwork.api.IAudioHelper;
import com.tencent.mobileqq.utils.QQAudioHelper;

public class AudioHelperImpl
  implements IAudioHelper
{
  public int getDebugValue(int paramInt)
  {
    return QQAudioHelper.a(paramInt);
  }
  
  public boolean isDev()
  {
    return QQAudioHelper.b();
  }
  
  public void writeTestLog(String paramString)
  {
    QQAudioHelper.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.AudioHelperImpl
 * JD-Core Version:    0.7.0.1
 */