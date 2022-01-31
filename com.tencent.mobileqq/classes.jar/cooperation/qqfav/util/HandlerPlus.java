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
  private final SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public HandlerPlus(Handler.Callback paramCallback)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramCallback);
  }
  
  public HandlerPlus(Looper paramLooper, Handler.Callback paramCallback)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramCallback);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    Handler.Callback localCallback = (Handler.Callback)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localCallback != null) {
      localCallback.handleMessage(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqfav.util.HandlerPlus
 * JD-Core Version:    0.7.0.1
 */