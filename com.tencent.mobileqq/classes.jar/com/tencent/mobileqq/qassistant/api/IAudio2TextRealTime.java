package com.tencent.mobileqq.qassistant.api;

import com.tencent.mobileqq.qassistant.listener.IAudio2TextResultCallBack;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IAudio2TextRealTime
  extends IRuntimeService
{
  public abstract void finishAudio2Text();
  
  public abstract void invokeAudio2Text(IAudio2TextResultCallBack paramIAudio2TextResultCallBack);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.api.IAudio2TextRealTime
 * JD-Core Version:    0.7.0.1
 */