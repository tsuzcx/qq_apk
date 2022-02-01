package com.tencent.tbs.one.impl.base;

import java.io.File;
import java.util.concurrent.Callable;

final class ProcessLock$2
  implements Callable<ProcessLock>
{
  ProcessLock$2(Callable paramCallable, File paramFile) {}
  
  public ProcessLock call()
  {
    if (!((Boolean)this.val$loopPredication.call()).booleanValue()) {
      throw new Exception("Aborted");
    }
    return ProcessLock.tryAcquire(this.val$file);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.base.ProcessLock.2
 * JD-Core Version:    0.7.0.1
 */