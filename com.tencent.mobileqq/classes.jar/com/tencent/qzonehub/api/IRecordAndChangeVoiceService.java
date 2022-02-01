package com.tencent.qzonehub.api;

import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IRecordAndChangeVoiceService
  extends QRouteApi
{
  public static final int FROM_VOICE_MOOD = 1;
  
  public abstract void cleanData();
  
  public abstract void onReceiveRecordData(Intent paramIntent, int paramInt);
  
  public abstract void stopPlayingMoodVoice();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qzonehub.api.IRecordAndChangeVoiceService
 * JD-Core Version:    0.7.0.1
 */