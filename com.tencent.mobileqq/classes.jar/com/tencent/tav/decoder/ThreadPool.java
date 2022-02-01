package com.tencent.tav.decoder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool
{
  private static ExecutorService threadPool = Executors.newFixedThreadPool(3);
  
  static void execute(Runnable paramRunnable)
  {
    threadPool.execute(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.decoder.ThreadPool
 * JD-Core Version:    0.7.0.1
 */