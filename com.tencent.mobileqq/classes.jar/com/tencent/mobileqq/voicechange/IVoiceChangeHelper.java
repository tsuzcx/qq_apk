package com.tencent.mobileqq.voicechange;

import android.content.Context;
import com.tencent.mobileqq.qqaudio.audioprocessor.AudioComponentProcessor;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IVoiceChangeHelper
  extends QRouteApi
{
  public abstract AudioComponentProcessor createVoiceChangeObj(Context paramContext, int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.voicechange.IVoiceChangeHelper
 * JD-Core Version:    0.7.0.1
 */