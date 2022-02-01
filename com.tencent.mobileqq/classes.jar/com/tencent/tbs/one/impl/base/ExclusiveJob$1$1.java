package com.tencent.tbs.one.impl.base;

import java.util.concurrent.Callable;

class ExclusiveJob$1$1
  implements Callable<Boolean>
{
  ExclusiveJob$1$1(ExclusiveJob.1 param1) {}
  
  public Boolean call()
  {
    if (!this.this$1.this$0.isCancelled()) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.base.ExclusiveJob.1.1
 * JD-Core Version:    0.7.0.1
 */