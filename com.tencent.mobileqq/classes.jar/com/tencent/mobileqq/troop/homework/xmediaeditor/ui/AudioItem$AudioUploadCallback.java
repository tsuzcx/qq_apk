package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.app.Activity;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.AudioInfo;
import cooperation.troop_homework.TroopHomeworkHelper.UploadCallback;

class AudioItem$AudioUploadCallback
  implements TroopHomeworkHelper.UploadCallback
{
  AudioInfo a;
  
  public AudioItem$AudioUploadCallback(AudioItem paramAudioItem, AudioInfo paramAudioInfo)
  {
    this.a = paramAudioInfo;
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString)
  {
    AudioInfo localAudioInfo = this.a;
    localAudioInfo.o = 3;
    localAudioInfo.b(paramString);
    ((Activity)AudioItem.a(this.b)).runOnUiThread(new AudioItem.AudioUploadCallback.1(this));
  }
  
  public void b(int paramInt)
  {
    this.a.o = 2;
    ((Activity)AudioItem.a(this.b)).runOnUiThread(new AudioItem.AudioUploadCallback.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback
 * JD-Core Version:    0.7.0.1
 */