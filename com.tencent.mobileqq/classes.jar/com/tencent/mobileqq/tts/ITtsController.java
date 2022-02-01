package com.tencent.mobileqq.tts;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ITtsController
  extends QRouteApi
{
  public static final int BUSINESS_MESSAGE_READ = 0;
  public static final int BUSINESS_VOICE_ASSISTANT = 1;
  
  public abstract void destroy();
  
  public abstract String getSpeech();
  
  public abstract void init(String paramString1, String paramString2, int paramInt);
  
  public abstract boolean isWorking();
  
  public abstract void setTtsListener(TtsListener paramTtsListener);
  
  public abstract void speak(String paramString, int paramInt);
  
  public abstract void speak(String paramString1, String paramString2);
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tts.ITtsController
 * JD-Core Version:    0.7.0.1
 */