package com.tencent.qapmsdk.impl.instrumentation;

import android.view.ViewTreeObserver.OnWindowFocusChangeListener;
import com.tencent.qapmsdk.impl.appstate.h;
import java.util.concurrent.atomic.AtomicBoolean;

final class QAPMAppInstrumentation$1
  implements ViewTreeObserver.OnWindowFocusChangeListener
{
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!com.tencent.qapmsdk.impl.appstate.b.a) {
        QAPMAppInstrumentation.appStateTimeInfo.i();
      } else if (com.tencent.qapmsdk.impl.g.b.f.get()) {
        QAPMAppInstrumentation.activityTrace.g();
      }
      com.tencent.qapmsdk.impl.g.b.f.set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMAppInstrumentation.1
 * JD-Core Version:    0.7.0.1
 */