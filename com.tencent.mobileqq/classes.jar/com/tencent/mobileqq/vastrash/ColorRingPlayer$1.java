package com.tencent.mobileqq.vastrash;

import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class ColorRingPlayer$1
  implements MediaPlayer.OnCompletionListener
{
  ColorRingPlayer$1(ColorRingPlayer paramColorRingPlayer, AudioManager paramAudioManager) {}
  
  public void onCompletion(MediaPlayer arg1)
  {
    synchronized (this.b.b)
    {
      ???.release();
      this.b.c = null;
      ??? = this.b;
      ???.d = 0;
      ???.n.setProgress(0);
      this.b.m.setImageDrawable(this.b.e.getResources().getDrawable(2130848969));
      this.a.abandonAudioFocus(this.b.u);
      synchronized (this.b.a)
      {
        this.b.a.a = 6;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vastrash.ColorRingPlayer.1
 * JD-Core Version:    0.7.0.1
 */