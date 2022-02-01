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
    int j = 1;
    int i;
    if (((paramThrowable instanceof UnsatisfiedLinkError)) || (((paramThrowable instanceof NoSuchMethodError)) && (paramThrowable.getMessage().matches(".*sig(nature)?[=:].*"))))
    {
      i = 1;
      if (i == 0) {
        break label91;
      }
    }
    for (;;)
    {
      try
      {
        TPLoadLibFromApk.access$100(TPLoadLibFromApk.access$000());
        i = j;
      }
      catch (Exception localException)
      {
        Throwable localThrowable;
        i = 0;
        continue;
      }
      localThrowable = paramThrowable;
      if (i != 0) {
        localThrowable = new UnsatisfiedLinkError("Invalid so detected and recovered.").initCause(paramThrowable);
      }
      this.mParent.uncaughtException(paramThread, localThrowable);
      return;
      i = 0;
      break;
      label91:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPLoadLibFromApk.LibraryBrokenHandler
 * JD-Core Version:    0.7.0.1
 */