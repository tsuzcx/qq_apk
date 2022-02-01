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
      try
      {
        if (this.val$enable)
        {
          if (OrientationDetector.access$700(this.this$0).canDetectOrientation()) {
            OrientationDetector.access$700(this.this$0).enable();
          }
        }
        else {
          OrientationDetector.access$700(this.this$0).disable();
        }
      }
      catch (Throwable localThrowable)
      {
        label66:
        break label66;
      }
      if (this.val$isDestory) {
        synchronized (OrientationDetector.access$600(this.this$0))
        {
          OrientationDetector.access$702(this.this$0, null);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.utils.OrientationDetector.3
 * JD-Core Version:    0.7.0.1
 */