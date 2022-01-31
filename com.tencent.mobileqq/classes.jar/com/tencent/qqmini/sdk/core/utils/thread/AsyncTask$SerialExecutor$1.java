package com.tencent.qqmini.sdk.core.utils.thread;

import bdhm;

public class AsyncTask$SerialExecutor$1
  implements Runnable
{
  public AsyncTask$SerialExecutor$1(bdhm parambdhm, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      this.a.run();
      return;
    }
    finally
    {
      this.this$0.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.thread.AsyncTask.SerialExecutor.1
 * JD-Core Version:    0.7.0.1
 */