package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.AudioInfo;
import cooperation.troop_homework.TroopHomeworkHelper;

class AudioItem$1
  implements Runnable
{
  AudioItem$1(AudioItem paramAudioItem, AudioInfo paramAudioInfo) {}
  
  public void run()
  {
    String str = TroopHomeworkHelper.a(this.a.b);
    this.a.b(str);
    if (!TextUtils.isEmpty(str)) {
      ((Activity)AudioItem.a(this.this$0)).runOnUiThread(new AudioItem.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.1
 * JD-Core Version:    0.7.0.1
 */