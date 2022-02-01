package com.tencent.util;

import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class MqqWeakReferenceHandler
  extends MqqHandler
{
  private WeakReference<Handler.Callback> a;
  
  public MqqWeakReferenceHandler(Handler.Callback paramCallback)
  {
    this.a = new WeakReference(paramCallback);
  }
  
  public MqqWeakReferenceHandler(Looper paramLooper, Handler.Callback paramCallback)
  {
    super(paramLooper);
    this.a = new WeakReference(paramCallback);
  }
  
  public MqqWeakReferenceHandler(Looper paramLooper, Handler.Callback paramCallback, boolean paramBoolean)
  {
    super(paramLooper, null, paramBoolean);
    this.a = new WeakReference(paramCallback);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Handler.Callback localCallback = (Handler.Callback)this.a.get();
    if (localCallback != null) {
      localCallback.handleMessage(paramMessage);
    }
  }
  
  public String toString()
  {
    Handler.Callback localCallback = (Handler.Callback)this.a.get();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" ");
    localStringBuilder.append(localCallback);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.util.MqqWeakReferenceHandler
 * JD-Core Version:    0.7.0.1
 */