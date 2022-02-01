package com.tencent.thumbplayer.core.common;

class TPLoadLibFromApk$LibraryBrokenHandler
  implements Thread.UncaughtExceptionHandler
{
  private Thread.UncaughtExceptionHandler mParent;
  
  TPLoadLibFromApk$LibraryBrokenHandler(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    this.mParent = paramUncaughtExceptionHandler;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    boolean bool = paramThrowable instanceof UnsatisfiedLinkError;
    k = 0;
    int i;
    if ((!bool) && ((!(paramThrowable instanceof NoSuchMethodError)) || (!paramThrowable.getMessage().matches(".*sig(nature)?[=:].*")))) {
      i = 0;
    } else {
      i = 1;
    }
    j = k;
    if (i != 0) {}
    try
    {
      TPLoadLibFromApk.access$100(TPLoadLibFromApk.access$000());
      j = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Throwable localThrowable;
        j = k;
      }
    }
    localThrowable = paramThrowable;
    if (j != 0) {
      localThrowable = new UnsatisfiedLinkError("Invalid so detected and recovered.").initCause(paramThrowable);
    }
    this.mParent.uncaughtException(paramThread, localThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPLoadLibFromApk.LibraryBrokenHandler
 * JD-Core Version:    0.7.0.1
 */