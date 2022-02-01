package com.tencent.util;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class WeakReferenceHandler
  extends Handler
{
  private WeakReference<Handler.Callback> a;
  
  public WeakReferenceHandler(Handler.Callback paramCallback)
  {
    this.a = new WeakReference(paramCallback);
  }
  
  public WeakReferenceHandler(Looper paramLooper, Handler.Callback paramCallback)
  {
    super(paramLooper);
    this.a = new WeakReference(paramCallback);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Handler.Callback localCallback = (Handler.Callback)this.a.get();
    if (localCallback != null)
    {
      localCallback.handleMessage(paramMessage);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramMessage = new StringBuilder();
      paramMessage.append("handleMessage cb is null! handler = ");
      paramMessage.append(this);
      QLog.d("WeakReferenceHandler", 2, paramMessage.toString());
    }
  }
  
  public String toString()
  {
    Object localObject = (Handler.Callback)this.a.get();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WH");
    if (localObject != null) {
      localObject = localObject.toString();
    } else {
      localObject = "None callback";
    }
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.util.WeakReferenceHandler
 * JD-Core Version:    0.7.0.1
 */