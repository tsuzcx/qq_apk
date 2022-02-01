package com.tencent.thumbplayer.api.richmedia;

public abstract interface ITPRichMediaSynchronizerListener
{
  public abstract void onDeselectFeatureSuccess(ITPRichMediaSynchronizer paramITPRichMediaSynchronizer, int paramInt);
  
  public abstract void onRichMediaError(ITPRichMediaSynchronizer paramITPRichMediaSynchronizer, int paramInt);
  
  public abstract void onRichMediaFeatureData(ITPRichMediaSynchronizer paramITPRichMediaSynchronizer, int paramInt, TPRichMediaFeatureData paramTPRichMediaFeatureData);
  
  public abstract void onRichMediaFeatureFailure(ITPRichMediaSynchronizer paramITPRichMediaSynchronizer, int paramInt1, int paramInt2);
  
  public abstract void onRichMediaInfo(ITPRichMediaSynchronizer paramITPRichMediaSynchronizer, int paramInt, long paramLong1, long paramLong2, long paramLong3, Object paramObject);
  
  public abstract void onRichMediaPrepared(ITPRichMediaSynchronizer paramITPRichMediaSynchronizer);
  
  public abstract void onSelectFeatureSuccess(ITPRichMediaSynchronizer paramITPRichMediaSynchronizer, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizerListener
 * JD-Core Version:    0.7.0.1
 */