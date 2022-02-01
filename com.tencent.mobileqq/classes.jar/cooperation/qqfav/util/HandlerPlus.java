package cooperation.qqfav.util;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import java.lang.ref.WeakReference;

public class HandlerPlus
  extends Handler
{
  private WeakReference<Handler.Callback> a;
  private final SparseArray<HandlerPlus.TimerRunnable> b = new SparseArray();
  
  public HandlerPlus(Handler.Callback paramCallback)
  {
    this.a = new WeakReference(paramCallback);
  }
  
  public HandlerPlus(Looper paramLooper, Handler.Callback paramCallback)
  {
    super(paramLooper);
    this.a = new WeakReference(paramCallback);
  }
  
  public boolean a(Runnable paramRunnable, int paramInt, long paramLong1, long paramLong2)
  {
    synchronized (this.b)
    {
      HandlerPlus.TimerRunnable localTimerRunnable2 = (HandlerPlus.TimerRunnable)this.b.get(paramRunnable.hashCode());
      HandlerPlus.TimerRunnable localTimerRunnable1 = localTimerRunnable2;
      if (localTimerRunnable2 == null)
      {
        localTimerRunnable1 = new HandlerPlus.TimerRunnable(this, paramRunnable, null);
        this.b.put(paramRunnable.hashCode(), localTimerRunnable1);
      }
      localTimerRunnable1.a = paramInt;
      localTimerRunnable1.b = paramLong1;
      return postDelayed(localTimerRunnable1, paramLong2);
    }
  }
  
  public final void handleMessage(Message paramMessage)
  {
    Handler.Callback localCallback = (Handler.Callback)this.a.get();
    if (localCallback != null) {
      localCallback.handleMessage(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.util.HandlerPlus
 * JD-Core Version:    0.7.0.1
 */