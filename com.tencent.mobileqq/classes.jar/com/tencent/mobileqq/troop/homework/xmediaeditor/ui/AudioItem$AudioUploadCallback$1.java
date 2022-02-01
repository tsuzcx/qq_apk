package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.AudioInfo;

class AudioItem$AudioUploadCallback$1
  implements Runnable
{
  AudioItem$AudioUploadCallback$1(AudioItem.AudioUploadCallback paramAudioUploadCallback) {}
  
  public void run()
  {
    AudioItem.AudioViewHolder localAudioViewHolder;
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo.c < this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiAudioItem.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().getItemCount())
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiAudioItem.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiAudioItem.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo.c), true);
      localAudioViewHolder = (AudioItem.AudioViewHolder)this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiAudioItem.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo.c);
      if (localAudioViewHolder != null)
      {
        if (!this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo.a) {
          break label171;
        }
        AnimationDrawable localAnimationDrawable = (AnimationDrawable)AudioItem.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiAudioItem).getResources().getDrawable(2130772285);
        localAudioViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localAnimationDrawable);
        localAnimationDrawable.start();
      }
    }
    for (;;)
    {
      localAudioViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localAudioViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localAudioViewHolder.c.setVisibility(4);
      return;
      label171:
      localAudioViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847396);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.1
 * JD-Core Version:    0.7.0.1
 */