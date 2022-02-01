package com.tencent.rmonitor.bigbitmap;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.rmonitor.common.util.ClassUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

class RootViewDetectListener$1
  extends Handler
{
  RootViewDetectListener$1(RootViewDetectListener paramRootViewDetectListener, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(@NotNull Message paramMessage)
  {
    if ((RootViewDetectListener.a(this.a) != null) && (RootViewDetectListener.a(this.a).get() != null) && ((RootViewDetectListener.a(this.a).get() instanceof ViewGroup)))
    {
      paramMessage = new ArrayList();
      RootViewDetectListener localRootViewDetectListener = this.a;
      RootViewDetectListener.a(localRootViewDetectListener, paramMessage, RootViewDetectListener.b(localRootViewDetectListener), ClassUtil.a(RootViewDetectListener.a(this.a).get(), null), (View)RootViewDetectListener.a(this.a).get());
      if (paramMessage.size() > 0) {
        RootViewDetectListener.a(this.a, paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.bigbitmap.RootViewDetectListener.1
 * JD-Core Version:    0.7.0.1
 */