package com.tencent.thumbplayer.adapter.player.systemplayer;

import com.tencent.thumbplayer.api.TPSubtitleRenderModel;

public abstract interface ITPSysPlayerExternalSubtitle
{
  public abstract void pauseAsync();
  
  public abstract void prepare();
  
  public abstract void release();
  
  public abstract void reset();
  
  public abstract void setDataSource(String paramString, long paramLong);
  
  public abstract void setOnSubTitleListener(ITPSysPlayerExternalSubtitle.IOnSubTitleListener paramIOnSubTitleListener);
  
  public abstract void setPlayerPositionListener(ITPSysPlayerExternalSubtitle.IPlayPositionListener paramIPlayPositionListener);
  
  public abstract void setSubtitleRenderModel(TPSubtitleRenderModel paramTPSubtitleRenderModel);
  
  public abstract void setSubtitleType(int paramInt);
  
  public abstract void setTrackSelectListener(ITPSysPlayerExternalSubtitle.IOnTrackSelectListener paramIOnTrackSelectListener);
  
  public abstract void startAsync();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.ITPSysPlayerExternalSubtitle
 * JD-Core Version:    0.7.0.1
 */