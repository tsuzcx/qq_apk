package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.AudioInfo;

class AudioItem$AudioUploadCallback$2
  implements Runnable
{
  AudioItem$AudioUploadCallback$2(AudioItem.AudioUploadCallback paramAudioUploadCallback) {}
  
  public void run()
  {
    AudioItem.AudioViewHolder localAudioViewHolder = (AudioItem.AudioViewHolder)this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiAudioItem.a.findViewHolderForAdapterPosition(this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo.c);
    if (localAudioViewHolder != null)
    {
      if (!this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo.a) {
        break label103;
      }
      AnimationDrawable localAnimationDrawable = (AnimationDrawable)AudioItem.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiAudioItem).getResources().getDrawable(2130772285);
      localAudioViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localAnimationDrawable);
      localAnimationDrawable.start();
    }
    for (;;)
    {
      localAudioViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      localAudioViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      localAudioViewHolder.c.setVisibility(0);
      return;
      label103:
      localAudioViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847396);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.2
 * JD-Core Version:    0.7.0.1
 */