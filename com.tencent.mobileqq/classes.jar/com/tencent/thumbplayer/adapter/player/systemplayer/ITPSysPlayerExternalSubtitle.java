package com.tencent.thumbplayer.adapter.player.systemplayer;

public abstract interface ITPSysPlayerExternalSubtitle
{
  public abstract void prepare();
  
  public abstract void release();
  
  public abstract void reset();
  
  public abstract void setDataSource(String paramString);
  
  public abstract void setOnSubTitleListener(ITPSysPlayerExternalSubtitle.IOnSubTitleListener paramIOnSubTitleListener);
  
  public abstract void setPlayerPostionListener(ITPSysPlayerExternalSubtitle.IPlayPositionListener paramIPlayPositionListener);
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.ITPSysPlayerExternalSubtitle
 * JD-Core Version:    0.7.0.1
 */