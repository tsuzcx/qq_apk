package com.tencent.thumbplayer.api.resourceloader;

public abstract interface ITPAssetResourceLoadingDataRequest
{
  public abstract long getCurrentOffset();
  
  public abstract long getRequestedLength();
  
  public abstract long getRequestedOffset();
  
  public abstract void notifyDataReady(long paramLong1, long paramLong2);
  
  public abstract void respondWithData(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingDataRequest
 * JD-Core Version:    0.7.0.1
 */