package com.tencent.mobileqq.intervideo.audioroom.colornote;

import com.tencent.mobileqq.colornote.swipeback.OnColorNoteAnimFinishListener;

class QQVoiceColorNoteProxy$1
  implements OnColorNoteAnimFinishListener
{
  QQVoiceColorNoteProxy$1(QQVoiceColorNoteProxy paramQQVoiceColorNoteProxy, OnColorNoteAnimFinish paramOnColorNoteAnimFinish) {}
  
  public void onColorNoteAnimFinish()
  {
    OnColorNoteAnimFinish localOnColorNoteAnimFinish = this.jdField_a_of_type_ComTencentMobileqqIntervideoAudioroomColornoteOnColorNoteAnimFinish;
    if (localOnColorNoteAnimFinish != null) {
      localOnColorNoteAnimFinish.onColorNoteAnimFinish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.audioroom.colornote.QQVoiceColorNoteProxy.1
 * JD-Core Version:    0.7.0.1
 */