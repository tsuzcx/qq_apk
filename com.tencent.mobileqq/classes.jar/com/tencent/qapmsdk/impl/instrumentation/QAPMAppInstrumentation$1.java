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
      if (com.tencent.qapmsdk.impl.appstate.b.a) {
        break label24;
      }
      QAPMAppInstrumentation.appStateTimeInfo.i();
    }
    for (;;)
    {
      com.tencent.qapmsdk.impl.g.b.f.set(false);
      return;
      label24:
      if (com.tencent.qapmsdk.impl.g.b.f.get()) {
        QAPMAppInstrumentation.activityTrace.g();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMAppInstrumentation.1
 * JD-Core Version:    0.7.0.1
 */