package com.tencent.ttpic.openapi.cache;

class BitmapLoadCache$PreloadRunnable
  implements Runnable
{
  private int mCurIndex;
  
  private BitmapLoadCache$PreloadRunnable(BitmapLoadCache paramBitmapLoadCache) {}
  
  public void run()
  {
    BitmapLoadCache.access$100(this.this$0, this.mCurIndex, false);
  }
  
  public void setCurIndex(int paramInt)
  {
    this.mCurIndex = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.cache.BitmapLoadCache.PreloadRunnable
 * JD-Core Version:    0.7.0.1
 */