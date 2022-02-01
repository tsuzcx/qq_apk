package com.tencent.thumbplayer.api.richmedia;

public abstract interface ITPRichMediaAsyncRequesterListener
{
  public abstract void onFeatureDataRequestFailure(ITPRichMediaAsyncRequester paramITPRichMediaAsyncRequester, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void onFeatureDataRequestSuccess(ITPRichMediaAsyncRequester paramITPRichMediaAsyncRequester, int paramInt1, int paramInt2, TPRichMediaFeatureData paramTPRichMediaFeatureData);
  
  public abstract void onRequesterError(ITPRichMediaAsyncRequester paramITPRichMediaAsyncRequester, int paramInt);
  
  public abstract void onRequesterPrepared(ITPRichMediaAsyncRequester paramITPRichMediaAsyncRequester);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequesterListener
 * JD-Core Version:    0.7.0.1
 */