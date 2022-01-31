package com.tribe.async.reactive;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.log.SLog;
import com.tribe.async.utils.AssertUtils;
import java.lang.ref.WeakReference;

public class UIThreadOffFunction<IN>
  extends StreamFunction<IN, IN>
{
  private static final int MSG_THREAD_OFF_ERROR = 2;
  private static final int MSG_THREAD_OFF_RESULT = 1;
  private static final String TAG = "async.UIThreadOffFunction";
  private Handler mHandler = new InnerHandler(Looper.getMainLooper());
  private WeakReference<IEventReceiver> mRef;
  
  public UIThreadOffFunction(@Nullable IEventReceiver paramIEventReceiver)
  {
    if (paramIEventReceiver != null) {
      this.mRef = new WeakReference(paramIEventReceiver);
    }
  }
  
  private boolean isValidate()
  {
    if (this.mRef == null) {
      return true;
    }
    IEventReceiver localIEventReceiver = (IEventReceiver)this.mRef.get();
    if (localIEventReceiver == null)
    {
      SLog.w("async.UIThreadOffFunction", "receiver is null for WeakReference.");
      return false;
    }
    return localIEventReceiver.isValidate();
  }
  
  protected void call(IN paramIN)
  {
    if (!isValidate()) {
      return;
    }
    Message.obtain(this.mHandler, 1, paramIN).sendToTarget();
  }
  
  protected void error(Error paramError)
  {
    if (!isValidate()) {
      return;
    }
    Message.obtain(this.mHandler, 2, paramError).sendToTarget();
  }
  
  private class InnerHandler
    extends Handler
  {
    public InnerHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (!UIThreadOffFunction.this.isValidate()) {
        return;
      }
      AssertUtils.checkNotNull(paramMessage.obj);
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1: 
        paramMessage = paramMessage.obj;
        UIThreadOffFunction.this.notifyResult(paramMessage);
        return;
      }
      paramMessage = (Error)paramMessage.obj;
      UIThreadOffFunction.this.notifyError(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tribe.async.reactive.UIThreadOffFunction
 * JD-Core Version:    0.7.0.1
 */