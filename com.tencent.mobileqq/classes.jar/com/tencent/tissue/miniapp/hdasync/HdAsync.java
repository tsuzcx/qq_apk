package com.tencent.tissue.miniapp.hdasync;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.atomic.AtomicInteger;

public class HdAsync
{
  public static final String TAG = "HdAsync";
  private HdAsyncActionGroup actionGroup;
  private Object host;
  private boolean isCalling = false;
  private boolean isCanceled = false;
  private boolean isDone = false;
  
  private HdAsync(Object paramObject)
  {
    this.host = paramObject;
    this.actionGroup = new HdAsyncActionGroup();
  }
  
  private void executeAction(Object paramObject, boolean paramBoolean)
  {
    try
    {
      executeActionWithoutLock(paramObject, paramBoolean);
      return;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
  
  private void executeActionWithoutLock(Object paramObject, boolean paramBoolean)
  {
    int i = 0;
    if ((this.actionGroup != null) && (!this.actionGroup.allActionFinish()))
    {
      if ((!paramBoolean) || (this.isCanceled)) {}
      do
      {
        return;
        localObject1 = this.actionGroup.poll();
      } while (localObject1 == null);
      Object localObject1 = ((HdAsyncActionGroup.ActionArray)localObject1).array;
      int j = localObject1.length;
      label57:
      Object localObject2;
      if (i < j)
      {
        localObject2 = localObject1[i];
        if (localObject2.looper != null) {
          break label84;
        }
      }
      for (;;)
      {
        i += 1;
        break label57;
        break;
        label84:
        localObject2.setHdAsync(this);
        Handler localHandler = new Handler(localObject2.looper, new HdAsync.HandlerCallback(this));
        Message localMessage = Message.obtain();
        HdAsync.Data localData = new HdAsync.Data();
        localData.action = localObject2;
        localData.args = paramObject;
        localMessage.obj = localData;
        if (localObject2.delay == 0L) {
          localHandler.sendMessage(localMessage);
        } else {
          localHandler.sendMessageDelayed(localMessage, localObject2.delay);
        }
      }
    }
    this.isCalling = false;
    this.isDone = true;
    destroyWithoutLock();
  }
  
  public static HdAsync with(Object paramObject)
  {
    return new HdAsync(paramObject);
  }
  
  public HdAsync append(HdAsync paramHdAsync)
  {
    if (paramHdAsync != null) {}
    try
    {
      this.actionGroup.append(paramHdAsync.actionGroup);
      return this;
    }
    finally
    {
      paramHdAsync = finally;
      throw paramHdAsync;
    }
  }
  
  public HdAsync both(int paramInt, HdAsyncCountDownAction... paramVarArgs)
  {
    if (paramVarArgs != null) {}
    try
    {
      AtomicInteger localAtomicInteger = new AtomicInteger(paramInt);
      int i = paramVarArgs.length;
      paramInt = 0;
      while (paramInt < i)
      {
        HdAsyncCountDownAction localHdAsyncCountDownAction = paramVarArgs[paramInt];
        localHdAsyncCountDownAction.setHost(this.host);
        localHdAsyncCountDownAction.setCountDownNum(localAtomicInteger);
        paramInt += 1;
      }
      this.actionGroup.both(paramVarArgs);
      return this;
    }
    finally {}
  }
  
  public HdAsync both(HdAsyncAction... paramVarArgs)
  {
    if (paramVarArgs != null) {}
    for (;;)
    {
      int i;
      try
      {
        int j = paramVarArgs.length;
        i = 0;
        if (i < j)
        {
          HdAsyncAction localHdAsyncAction = paramVarArgs[i];
          if (localHdAsyncAction != null) {
            localHdAsyncAction.setHost(this.host);
          }
        }
        else
        {
          this.actionGroup.both(paramVarArgs);
          return this;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public HdAsync call()
  {
    try
    {
      this.isCanceled = false;
      if (!this.isCalling)
      {
        this.isCalling = true;
        executeActionWithoutLock(null, true);
      }
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public HdAsync call(Object paramObject)
  {
    try
    {
      this.isCanceled = false;
      if (!this.isCalling)
      {
        this.isCalling = true;
        executeActionWithoutLock(paramObject, true);
      }
      return this;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
  
  public void cancel()
  {
    try
    {
      this.isCanceled = true;
      this.isCalling = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public HdAsync delay(HdAsyncAction paramHdAsyncAction, long paramLong)
  {
    if (paramHdAsyncAction != null) {}
    try
    {
      paramHdAsyncAction.setHost(this.host);
      this.actionGroup.delay(paramHdAsyncAction, paramLong);
      return this;
    }
    finally
    {
      paramHdAsyncAction = finally;
      throw paramHdAsyncAction;
    }
  }
  
  public void destroy()
  {
    try
    {
      destroyWithoutLock();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void destroyWithoutLock()
  {
    if (this.actionGroup != null) {
      this.actionGroup.clear();
    }
  }
  
  public boolean isDone()
  {
    return this.isDone;
  }
  
  public HdAsync resume()
  {
    call();
    return this;
  }
  
  public HdAsync resume(Object paramObject)
  {
    call(paramObject);
    return this;
  }
  
  public HdAsync then(HdAsyncAction paramHdAsyncAction)
  {
    if (paramHdAsyncAction != null) {}
    try
    {
      paramHdAsyncAction.setHost(this.host);
      this.actionGroup.then(paramHdAsyncAction);
      return this;
    }
    finally
    {
      paramHdAsyncAction = finally;
      throw paramHdAsyncAction;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tissue.miniapp.hdasync.HdAsync
 * JD-Core Version:    0.7.0.1
 */