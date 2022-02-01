package com.tencent.thumbplayer.adapter.player.systemplayer;

import com.tencent.thumbplayer.core.common.TPSubtitleFrame;

public abstract interface ITPSysPlayerExternalSubtitle$IOnSubTitleListener
{
  public abstract void onEventInfo();
  
  public abstract void onSubtitleFrameData(TPSubtitleFrame paramTPSubtitleFrame);
  
  public abstract void onSubtitleInfo(ITPSysPlayerExternalSubtitle.SubtitleData paramSubtitleData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.ITPSysPlayerExternalSubtitle.IOnSubTitleListener
 * JD-Core Version:    0.7.0.1
 */