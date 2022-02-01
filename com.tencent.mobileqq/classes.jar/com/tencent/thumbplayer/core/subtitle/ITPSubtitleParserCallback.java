package com.tencent.thumbplayer.core.subtitle;

import com.tencent.thumbplayer.core.common.TPSubtitleFrame;

public abstract interface ITPSubtitleParserCallback
{
  public abstract long onGetCurrentPlayPositionMs();
  
  public abstract void onLoadResult(int paramInt);
  
  public abstract void onSelectResult(int paramInt, long paramLong);
  
  public abstract void onSubtitleFrame(TPSubtitleFrame paramTPSubtitleFrame);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.subtitle.ITPSubtitleParserCallback
 * JD-Core Version:    0.7.0.1
 */