package com.tencent.thumbplayer.adapter.player.systemplayer;

import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSubtitleDataListener;
import com.tencent.thumbplayer.api.TPSubtitleData;

class TPSystemMediaPlayer$1
  implements ITPSysPlayerExternalSubtitle.IOnSubTitleListener
{
  TPSystemMediaPlayer$1(TPSystemMediaPlayer paramTPSystemMediaPlayer) {}
  
  public void onEventInfo() {}
  
  public void onSubtileInfo(ITPSysPlayerExternalSubtitle.SubtileData paramSubtileData)
  {
    TPSubtitleData localTPSubtitleData = new TPSubtitleData();
    localTPSubtitleData.subtitleData = paramSubtileData.text;
    paramSubtileData = TPSystemMediaPlayer.access$200(this.this$0);
    if (paramSubtileData != null) {
      paramSubtileData.onSubtitleData(localTPSubtitleData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemMediaPlayer.1
 * JD-Core Version:    0.7.0.1
 */