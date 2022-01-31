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
  private final SparseArray<HandlerPlus.TimerRunnable> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private WeakReference<Handler.Callback> jdField_a_of_type_JavaLangRefWeakReference;
  
  public HandlerPlus(Handler.Callback paramCallback)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramCallback);
  }
  
  public HandlerPlus(Looper paramLooper, Handler.Callback paramCallback)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramCallback);
  }
  
  public boolean a(Runnable paramRunnable, int paramInt, long paramLong1, long paramLong2)
  {
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      HandlerPlus.TimerRunnable localTimerRunnable2 = (HandlerPlus.TimerRunnable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramRunnable.hashCode());
      HandlerPlus.TimerRunnable localTimerRunnable1 = localTimerRunnable2;
      if (localTimerRunnable2 == null)
      {
        localTimerRunnable1 = new HandlerPlus.TimerRunnable(this, paramRunnable, null);
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramRunnable.hashCode(), localTimerRunnable1);
      }
      localTimerRunnable1.jdField_a_of_type_Int = paramInt;
      localTimerRunnable1.jdField_a_of_type_Long = paramLong1;
      return postDelayed(localTimerRunnable1, paramLong2);
    }
  }
  
  public final void handleMessage(Message paramMessage)
  {
    Handler.Callback localCallback = (Handler.Callback)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localCallback != null) {
      localCallback.handleMessage(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqfav.util.HandlerPlus
 * JD-Core Version:    0.7.0.1
 */