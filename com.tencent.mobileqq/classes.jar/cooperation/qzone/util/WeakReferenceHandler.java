package cooperation.qzone.util;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public abstract class WeakReferenceHandler<T>
  extends Handler
{
  private WeakReference<T> mTarget;
  
  public WeakReferenceHandler(T paramT)
  {
    this.mTarget = new WeakReference(paramT);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    Object localObject = this.mTarget.get();
    if (localObject != null) {
      handleMessage(localObject, paramMessage);
    }
  }
  
  public abstract void handleMessage(T paramT, Message paramMessage);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.util.WeakReferenceHandler
 * JD-Core Version:    0.7.0.1
 */