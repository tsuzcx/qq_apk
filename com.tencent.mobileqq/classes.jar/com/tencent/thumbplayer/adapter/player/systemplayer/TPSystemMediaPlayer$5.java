package com.tencent.thumbplayer.adapter.player.systemplayer;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnTimedTextListener;
import android.media.TimedText;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSubtitleDataListener;
import com.tencent.thumbplayer.api.TPSubtitleData;

class TPSystemMediaPlayer$5
  implements MediaPlayer.OnTimedTextListener
{
  TPSystemMediaPlayer$5(TPSystemMediaPlayer paramTPSystemMediaPlayer) {}
  
  public void onTimedText(MediaPlayer paramMediaPlayer, TimedText paramTimedText)
  {
    TPSubtitleData localTPSubtitleData;
    if (TPSystemMediaPlayer.access$2600(this.this$0) != null)
    {
      localTPSubtitleData = new TPSubtitleData();
      if (paramTimedText == null) {
        break label69;
      }
    }
    label69:
    for (paramMediaPlayer = paramTimedText.getText();; paramMediaPlayer = "")
    {
      localTPSubtitleData.subtitleData = paramMediaPlayer;
      localTPSubtitleData.trackIndex = TPSystemMediaPlayer.access$2700(this.this$0);
      localTPSubtitleData.startPositionMs = this.this$0.getCurrentPositionMs();
      TPSystemMediaPlayer.access$2600(this.this$0).onSubtitleData(localTPSubtitleData);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemMediaPlayer.5
 * JD-Core Version:    0.7.0.1
 */