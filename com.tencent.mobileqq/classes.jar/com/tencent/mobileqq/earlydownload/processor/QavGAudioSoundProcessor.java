package com.tencent.mobileqq.earlydownload.processor;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.handler.QavGAudioSoundHandler;
import com.tencent.mobileqq.earlydownload.inject.BaseEarlyHandlerProcessor;
import mqq.app.AppRuntime;

public class QavGAudioSoundProcessor
  extends BaseEarlyHandlerProcessor
{
  public EarlyHandler a(AppRuntime paramAppRuntime)
  {
    return new QavGAudioSoundHandler((QQAppInterface)paramAppRuntime);
  }
  
  public String a()
  {
    return "qq.android.qav.muteaudio";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.processor.QavGAudioSoundProcessor
 * JD-Core Version:    0.7.0.1
 */