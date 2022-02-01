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
    if (this.a.a.g < this.a.b.b.getAdapter().getItemCount())
    {
      this.a.b.c.a(this.a.b.b.findViewHolderForAdapterPosition(this.a.a.g), true);
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
        localAudioViewHolder.d.setVisibility(0);
        localAudioViewHolder.a.setVisibility(0);
        localAudioViewHolder.c.setVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.1
 * JD-Core Version:    0.7.0.1
 */