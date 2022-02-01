package com.tencent.tbs.one.impl.common;

import com.tencent.tbs.one.impl.base.ProgressiveCallback;
import com.tencent.tbs.one.impl.base.ThreadUtils;

public class CoreThreadCallback<T>
  extends ProgressiveCallback<T>
{
  public void onCompleted(T paramT)
  {
    ThreadUtils.runOnCoreThread(new CoreThreadCallback.2(this, paramT));
  }
  
  public void onError(int paramInt, String paramString, Throwable paramThrowable)
  {
    ThreadUtils.runOnCoreThread(new CoreThreadCallback.3(this, paramInt, paramString, paramThrowable));
  }
  
  public void onProgressChanged(int paramInt1, int paramInt2)
  {
    ThreadUtils.runOnCoreThread(new CoreThreadCallback.1(this, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.CoreThreadCallback
 * JD-Core Version:    0.7.0.1
 */