package com.tencent.view;

import android.os.HandlerThread;
import com.tencent.ttpic.baseutils.api.ApiHelper;
import com.tencent.ttpic.baseutils.log.LogUtils;

class FilterEngineFactory$1
  implements Runnable
{
  FilterEngineFactory$1(FilterEngineFactory paramFilterEngineFactory) {}
  
  public void run()
  {
    if (FilterEngineFactory.access$000(this.this$0) != null)
    {
      FilterEngineFactory.access$000(this.this$0).destroyEgl();
      FilterEngineFactory.access$002(this.this$0, null);
    }
    if ((FilterEngineFactory.access$100(this.this$0) != null) && (FilterEngineFactory.access$100(this.this$0).isAlive()))
    {
      if (ApiHelper.hasJellyBeanMR2()) {
        FilterEngineFactory.access$100(this.this$0).quitSafely();
      } else {
        FilterEngineFactory.access$100(this.this$0).quit();
      }
      FilterEngineFactory.access$102(this.this$0, null);
      LogUtils.d("FilterEngine", "mGlThread = null");
    }
    FilterEngineFactory.access$202(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.view.FilterEngineFactory.1
 * JD-Core Version:    0.7.0.1
 */