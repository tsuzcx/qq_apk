package com.tencent.ttpic.openapi.cache;

import android.graphics.Bitmap;
import android.util.Log;
import com.tencent.ttpic.baseutils.thread.HandlerThreadManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

class BitmapLoadCache$3
  implements Runnable
{
  BitmapLoadCache$3(BitmapLoadCache paramBitmapLoadCache) {}
  
  public void run()
  {
    if (BitmapLoadCache.access$200(this.this$0) != null) {
      BitmapLoadCache.access$200(this.this$0).clear();
    }
    if (this.this$0.mCanUseBitmaps != null) {
      this.this$0.mCanUseBitmaps.clear();
    }
    if (this.this$0.mTotalCache != null)
    {
      Iterator localIterator = this.this$0.mTotalCache.iterator();
      while (localIterator.hasNext())
      {
        Bitmap localBitmap = (Bitmap)localIterator.next();
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          Log.i(BitmapLoadCache.access$300(this.this$0), "recycle:" + localBitmap.hashCode());
          localBitmap.recycle();
        }
      }
      this.this$0.mTotalCache.clear();
    }
    HandlerThreadManager.getInstance().destroyHandlerThread(BitmapLoadCache.access$300(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.cache.BitmapLoadCache.3
 * JD-Core Version:    0.7.0.1
 */