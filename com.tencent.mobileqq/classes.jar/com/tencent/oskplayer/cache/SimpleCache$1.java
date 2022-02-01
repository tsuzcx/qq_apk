package com.tencent.oskplayer.cache;

import android.os.ConditionVariable;

class SimpleCache$1
  extends Thread
{
  SimpleCache$1(SimpleCache paramSimpleCache, ConditionVariable paramConditionVariable) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      this.val$conditionVariable.open();
      SimpleCache.access$000(this.this$0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.cache.SimpleCache.1
 * JD-Core Version:    0.7.0.1
 */