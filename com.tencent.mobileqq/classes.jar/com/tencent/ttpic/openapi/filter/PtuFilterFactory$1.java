package com.tencent.ttpic.openapi.filter;

import android.graphics.Bitmap;
import com.tencent.view.FilterEngineFactory;
import java.util.concurrent.atomic.AtomicBoolean;

final class PtuFilterFactory$1
  implements Runnable
{
  PtuFilterFactory$1(Bitmap paramBitmap, int paramInt1, int paramInt2, float paramFloat, AtomicBoolean paramAtomicBoolean) {}
  
  public void run()
  {
    FilterEngineFactory.getInstance().usecurruntContext();
    PtuFilterFactory.renderBitmapByFilterID(this.val$src, this.val$filterId, this.val$effectIndex, this.val$adjustParam);
    this.val$condition.set(true);
    try
    {
      notify();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.PtuFilterFactory.1
 * JD-Core Version:    0.7.0.1
 */