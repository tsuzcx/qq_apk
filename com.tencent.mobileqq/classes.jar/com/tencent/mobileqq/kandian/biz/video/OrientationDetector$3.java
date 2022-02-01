package com.tencent.mobileqq.kandian.biz.video;

import android.view.OrientationEventListener;
import com.tencent.qphone.base.util.QLog;

class OrientationDetector$3
  implements Runnable
{
  OrientationDetector$3(OrientationDetector paramOrientationDetector, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    synchronized (OrientationDetector.a(this.this$0))
    {
      if (QLog.isColorLevel())
      {
        ??? = OrientationDetector.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("run: innerEnable: enable=");
        localStringBuilder.append(this.a);
        localStringBuilder.append(", mEventListener=");
        localStringBuilder.append(OrientationDetector.a(this.this$0));
        QLog.d((String)???, 2, localStringBuilder.toString());
      }
      if (OrientationDetector.a(this.this$0) == null) {
        return;
      }
      try
      {
        if (this.a)
        {
          if (OrientationDetector.a(this.this$0).canDetectOrientation()) {
            OrientationDetector.a(this.this$0).enable();
          }
        }
        else {
          OrientationDetector.a(this.this$0).disable();
        }
      }
      catch (Throwable localThrowable)
      {
        label128:
        break label128;
      }
      if (this.b) {
        synchronized (OrientationDetector.a(this.this$0))
        {
          OrientationDetector.a(this.this$0, null);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.OrientationDetector.3
 * JD-Core Version:    0.7.0.1
 */