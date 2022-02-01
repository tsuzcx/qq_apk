package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.app.Activity;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.AudioInfo;
import cooperation.troop_homework.TroopHomeworkHelper.UploadCallback;

class AudioItem$AudioUploadCallback
  implements TroopHomeworkHelper.UploadCallback
{
  AudioInfo jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo;
  
  public AudioItem$AudioUploadCallback(AudioItem paramAudioItem, AudioInfo paramAudioInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo = paramAudioInfo;
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo.g = 3;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo.c(paramString);
    ((Activity)AudioItem.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiAudioItem)).runOnUiThread(new AudioItem.AudioUploadCallback.1(this));
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo.g = 2;
    ((Activity)AudioItem.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiAudioItem)).runOnUiThread(new AudioItem.AudioUploadCallback.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback
 * JD-Core Version:    0.7.0.1
 */