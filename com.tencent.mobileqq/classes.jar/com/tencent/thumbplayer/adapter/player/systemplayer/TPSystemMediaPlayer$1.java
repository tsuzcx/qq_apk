package com.tencent.thumbplayer.adapter.player.systemplayer;

import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSubtitleDataListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSubtitleFrameOutListener;
import com.tencent.thumbplayer.adapter.player.thumbplayer.TPThumbPlayerUtils;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.core.common.TPSubtitleFrame;

class TPSystemMediaPlayer$1
  implements ITPSysPlayerExternalSubtitle.IOnSubTitleListener
{
  TPSystemMediaPlayer$1(TPSystemMediaPlayer paramTPSystemMediaPlayer) {}
  
  public void onEventInfo() {}
  
  public void onSubtitleFrameData(TPSubtitleFrame paramTPSubtitleFrame)
  {
    paramTPSubtitleFrame = TPThumbPlayerUtils.convert2TPSubtitleFrameBuffer(paramTPSubtitleFrame);
    ITPPlayerBaseListener.IOnSubtitleFrameOutListener localIOnSubtitleFrameOutListener = TPSystemMediaPlayer.access$300(this.this$0);
    if (localIOnSubtitleFrameOutListener != null) {
      localIOnSubtitleFrameOutListener.onSubtitleFrameOut(paramTPSubtitleFrame);
    }
  }
  
  public void onSubtitleInfo(ITPSysPlayerExternalSubtitle.SubtitleData paramSubtitleData)
  {
    TPSubtitleData localTPSubtitleData = new TPSubtitleData();
    localTPSubtitleData.subtitleData = paramSubtitleData.text;
    paramSubtitleData = TPSystemMediaPlayer.access$200(this.this$0);
    if (paramSubtitleData != null) {
      paramSubtitleData.onSubtitleData(localTPSubtitleData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemMediaPlayer.1
 * JD-Core Version:    0.7.0.1
 */