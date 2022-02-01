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
    AudioItem.AudioViewHolder localAudioViewHolder = (AudioItem.AudioViewHolder)this.a.b.b.findViewHolderForAdapterPosition(this.a.a.g);
    if (localAudioViewHolder != null)
    {
      if (this.a.a.f)
      {
        AnimationDrawable localAnimationDrawable = (AnimationDrawable)AudioItem.a(this.a.b).getResources().getDrawable(2130772405);
        localAudioViewHolder.a.setImageDrawable(localAnimationDrawable);
        localAnimationDrawable.start();
      }
      else
      {
        localAudioViewHolder.a.setImageResource(2130848916);
      }
      localAudioViewHolder.d.setVisibility(4);
      localAudioViewHolder.a.setVisibility(4);
      localAudioViewHolder.c.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.2
 * JD-Core Version:    0.7.0.1
 */