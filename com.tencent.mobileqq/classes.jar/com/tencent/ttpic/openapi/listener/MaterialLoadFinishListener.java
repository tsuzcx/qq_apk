package com.tencent.ttpic.openapi.listener;

public abstract interface MaterialLoadFinishListener
  extends IStickerListener
{
  public abstract void onFiltersReady();
  
  public abstract void onLoadFinish(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.listener.MaterialLoadFinishListener
 * JD-Core Version:    0.7.0.1
 */