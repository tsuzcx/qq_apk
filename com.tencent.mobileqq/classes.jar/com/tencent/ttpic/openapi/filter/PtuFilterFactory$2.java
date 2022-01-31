package com.tencent.ttpic.openapi.filter;

import android.graphics.Bitmap;
import com.tencent.view.FilterEngineFactory;

final class PtuFilterFactory$2
  implements Runnable
{
  PtuFilterFactory$2(Bitmap paramBitmap, int paramInt1, int paramInt2, float paramFloat, Runnable paramRunnable) {}
  
  public void run()
  {
    FilterEngineFactory.getInstance().usecurruntContext();
    PtuFilterFactory.renderBitmapByFilterID(this.val$src, this.val$filterId, this.val$effectIndex, this.val$adjustParam);
    if (this.val$run != null) {
      this.val$run.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.PtuFilterFactory.2
 * JD-Core Version:    0.7.0.1
 */