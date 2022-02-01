package com.tencent.qzonehub.api.impl;

import android.content.Intent;
import com.tencent.qzonehub.api.IRecordAndChangeVoiceService;
import cooperation.qzone.RecordAndChangeVoiceService;

public class RecordAndChangeVoiceServiceImpl
  implements IRecordAndChangeVoiceService
{
  public void cleanData()
  {
    RecordAndChangeVoiceService.getInstance().cleanData();
  }
  
  public void onReceiveRecordData(Intent paramIntent, int paramInt)
  {
    RecordAndChangeVoiceService.getInstance().onReceiveRecordData(paramIntent, paramInt);
  }
  
  public void stopPlayingMoodVoice()
  {
    RecordAndChangeVoiceService.getInstance().stopPlayingMoodVoice();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.RecordAndChangeVoiceServiceImpl
 * JD-Core Version:    0.7.0.1
 */