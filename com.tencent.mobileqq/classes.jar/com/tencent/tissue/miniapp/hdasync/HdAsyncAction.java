package com.tencent.tissue.miniapp.hdasync;

import android.os.Looper;
import java.util.concurrent.ExecutorService;

public abstract class HdAsyncAction
  extends BaseAction
{
  public HdAsyncAction(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public HdAsyncAction(ExecutorService paramExecutorService)
  {
    super(paramExecutorService);
  }
  
  public abstract HdAsyncResult call(Object paramObject);
  
  public HdAsyncResult doNext(boolean paramBoolean)
  {
    return doNext(paramBoolean, null);
  }
  
  public HdAsyncResult doNext(boolean paramBoolean, Object paramObject)
  {
    return new HdAsyncResult(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tissue.miniapp.hdasync.HdAsyncAction
 * JD-Core Version:    0.7.0.1
 */