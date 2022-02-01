package com.tencent.viola.utils;

import android.view.OrientationEventListener;

class OrientationDetector$3
  implements Runnable
{
  OrientationDetector$3(OrientationDetector paramOrientationDetector, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    synchronized (OrientationDetector.access$600(this.this$0))
    {
      if (OrientationDetector.access$700(this.this$0) == null) {
        return;
      }
    }
    try
    {
      if (this.val$enable)
      {
        if (OrientationDetector.access$700(this.this$0).canDetectOrientation()) {
          OrientationDetector.access$700(this.this$0).enable();
        }
        if (!this.val$isDestory) {}
      }
    }
    catch (Throwable localThrowable)
    {
      synchronized (OrientationDetector.access$600(this.this$0))
      {
        for (;;)
        {
          OrientationDetector.access$702(this.this$0, null);
          return;
          localObject3 = finally;
          throw localObject3;
          OrientationDetector.access$700(this.this$0).disable();
        }
        localThrowable = localThrowable;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.utils.OrientationDetector.3
 * JD-Core Version:    0.7.0.1
 */