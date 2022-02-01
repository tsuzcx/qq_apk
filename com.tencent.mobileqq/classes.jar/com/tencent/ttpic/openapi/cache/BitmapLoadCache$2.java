package com.tencent.ttpic.openapi.cache;

import android.graphics.Bitmap;
import java.util.HashMap;

class BitmapLoadCache$2
  implements Runnable
{
  BitmapLoadCache$2(BitmapLoadCache paramBitmapLoadCache, int paramInt, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (!BitmapLoadCache.access$200(this.this$0).containsKey(Integer.valueOf(this.val$index))) {
      BitmapLoadCache.access$200(this.this$0).put(Integer.valueOf(this.val$index), this.val$newBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.cache.BitmapLoadCache.2
 * JD-Core Version:    0.7.0.1
 */