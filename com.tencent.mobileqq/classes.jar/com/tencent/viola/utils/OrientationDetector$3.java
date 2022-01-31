package com.tencent.viola.utils;

import android.view.OrientationEventListener;

class OrientationDetector$3
  implements Runnable
{
  OrientationDetector$3(OrientationDetector paramOrientationDetector, boolean paramBoolean) {}
  
  public void run()
  {
    synchronized (OrientationDetector.access$400(this.this$0))
    {
      if (OrientationDetector.access$500(this.this$0) == null) {
        return;
      }
    }
    try
    {
      if (this.val$enable) {
        if (OrientationDetector.access$500(this.this$0).canDetectOrientation()) {
          OrientationDetector.access$500(this.this$0).enable();
        }
      }
      for (;;)
      {
        label53:
        return;
        localObject2 = finally;
        throw localObject2;
        OrientationDetector.access$500(this.this$0).disable();
      }
    }
    catch (Throwable localThrowable)
    {
      break label53;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.utils.OrientationDetector.3
 * JD-Core Version:    0.7.0.1
 */