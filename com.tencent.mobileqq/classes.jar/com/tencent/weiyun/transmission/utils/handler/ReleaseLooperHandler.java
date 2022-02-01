package com.tencent.weiyun.transmission.utils.handler;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.weiyun.transmission.utils.TsLog;
import com.tencent.weiyun.transmission.utils.thread.ThreadUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReleaseLooperHandler
  implements Handler.Callback, DispatchCallback
{
  private static final long DELAY_RELEASE = 10000L;
  private List<Handler.Callback> mCallbackList;
  private Handler mQueueHandler;
  private Looper mQueueLooper;
  private String mThreadName;
  private List<Integer> mWhatList;
  
  public ReleaseLooperHandler(String paramString)
  {
    this.mThreadName = paramString;
    this.mCallbackList = new ArrayList();
  }
  
  private void checkEnd()
  {
    List localList = this.mWhatList;
    if ((localList != null) && (localList.size() == 0)) {
      ThreadUtils.postDelayed(new ReleaseLooperHandler.1(this), 10000L);
    }
  }
  
  private void initIfNeed()
  {
    try
    {
      if (this.mQueueHandler == null)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("init queue ");
        ((StringBuilder)localObject1).append(this.mThreadName);
        ((StringBuilder)localObject1).append(" thread handler");
        TsLog.i(((StringBuilder)localObject1).toString());
        localObject1 = new HandlerThread(this.mThreadName);
        ((HandlerThread)localObject1).start();
        this.mQueueLooper = ((HandlerThread)localObject1).getLooper();
        this.mWhatList = new ArrayList();
        this.mQueueHandler = new CntHandler(this.mQueueLooper, this, this);
      }
      return;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  private void releaseInner()
  {
    try
    {
      if ((this.mWhatList != null) && (this.mWhatList.size() == 0))
      {
        this.mQueueHandler = null;
        this.mWhatList.clear();
        this.mWhatList = null;
        this.mQueueLooper.quit();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("end queue ");
        localStringBuilder.append(this.mThreadName);
        localStringBuilder.append(" thread handler");
        TsLog.i(localStringBuilder.toString());
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void addCallback(Handler.Callback paramCallback)
  {
    try
    {
      this.mCallbackList.add(paramCallback);
      return;
    }
    finally
    {
      paramCallback = finally;
      throw paramCallback;
    }
  }
  
  public void dispatchMsgFinished(Message paramMessage)
  {
    try
    {
      this.mWhatList.remove(Integer.valueOf(paramMessage.what));
      checkEnd();
      return;
    }
    finally
    {
      paramMessage = finally;
      throw paramMessage;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject = this.mCallbackList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((Handler.Callback)((Iterator)localObject).next()).handleMessage(paramMessage)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void release()
  {
    try
    {
      checkEnd();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void removeCallback(Handler.Callback paramCallback)
  {
    try
    {
      this.mCallbackList.remove(paramCallback);
      return;
    }
    finally
    {
      paramCallback = finally;
      throw paramCallback;
    }
  }
  
  public void removeMessages(int paramInt)
  {
    try
    {
      initIfNeed();
      Iterator localIterator = this.mWhatList.iterator();
      while (localIterator.hasNext()) {
        if (((Integer)localIterator.next()).intValue() == paramInt) {
          localIterator.remove();
        }
      }
      this.mQueueHandler.removeMessages(paramInt);
      checkEnd();
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public final boolean sendEmptyMessage(int paramInt)
  {
    try
    {
      initIfNeed();
      this.mWhatList.add(Integer.valueOf(paramInt));
      boolean bool = this.mQueueHandler.sendEmptyMessage(paramInt);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean sendEmptyMessageDelayed(int paramInt, long paramLong)
  {
    try
    {
      initIfNeed();
      this.mWhatList.add(Integer.valueOf(paramInt));
      boolean bool = this.mQueueHandler.sendEmptyMessageDelayed(paramInt, paramLong);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean sendMessage(Message paramMessage)
  {
    try
    {
      initIfNeed();
      this.mWhatList.add(Integer.valueOf(paramMessage.what));
      boolean bool = this.mQueueHandler.sendMessage(paramMessage);
      return bool;
    }
    finally
    {
      paramMessage = finally;
      throw paramMessage;
    }
  }
  
  public final boolean sendMessageDelayed(Message paramMessage, long paramLong)
  {
    try
    {
      initIfNeed();
      this.mWhatList.add(Integer.valueOf(paramMessage.what));
      boolean bool = this.mQueueHandler.sendMessageDelayed(paramMessage, paramLong);
      return bool;
    }
    finally
    {
      paramMessage = finally;
      throw paramMessage;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler
 * JD-Core Version:    0.7.0.1
 */