package com.tencent.thumbplayer.adapter.player.systemplayer;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnTimedTextListener;
import android.media.TimedText;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSubtitleDataListener;
import com.tencent.thumbplayer.api.TPSubtitleData;

class TPSystemMediaPlayer$7
  implements MediaPlayer.OnTimedTextListener
{
  TPSystemMediaPlayer$7(TPSystemMediaPlayer paramTPSystemMediaPlayer) {}
  
  public void onTimedText(MediaPlayer paramMediaPlayer, TimedText paramTimedText)
  {
    if (TPSystemMediaPlayer.access$200(this.this$0) != null)
    {
      TPSubtitleData localTPSubtitleData = new TPSubtitleData();
      if (paramTimedText != null) {
        paramMediaPlayer = paramTimedText.getText();
      } else {
        paramMediaPlayer = "";
      }
      localTPSubtitleData.subtitleData = paramMediaPlayer;
      localTPSubtitleData.trackIndex = TPSystemMediaPlayer.access$3300(this.this$0);
      localTPSubtitleData.startPositionMs = this.this$0.getCurrentPositionMs();
      TPSystemMediaPlayer.access$200(this.this$0).onSubtitleData(localTPSubtitleData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemMediaPlayer.7
 * JD-Core Version:    0.7.0.1
 */