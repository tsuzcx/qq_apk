package com.tencent.mobileqq.qqguildsdk.search.selector;

import java.util.concurrent.ConcurrentHashMap;

class SearchEngine$SearchThread
  extends Thread
{
  SearchEngine$SearchThread(SearchEngine paramSearchEngine) {}
  
  public void run()
  {
    for (;;)
    {
      if (this.this$0.c()) {
        ((Runnable)SearchEngine.b(this.this$0).remove(SearchEngine.a(this.this$0))).run();
      }
      try
      {
        Thread.sleep(500L);
        boolean bool = SearchEngine.b(this.this$0).isEmpty();
        if (bool) {
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.search.selector.SearchEngine.SearchThread
 * JD-Core Version:    0.7.0.1
 */