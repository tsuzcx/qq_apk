package com.tencent.tbs.one.impl.base;

import java.io.File;
import java.util.concurrent.Callable;

final class ProcessLock$1
  implements Callable<ProcessLock>
{
  ProcessLock$1(File paramFile) {}
  
  public ProcessLock call()
  {
    return ProcessLock.tryAcquire(this.val$file);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.base.ProcessLock.1
 * JD-Core Version:    0.7.0.1
 */