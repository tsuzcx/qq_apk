package com.tencent.tfm.metrics;

import android.os.Looper;

class AndroidCollector$1
  extends Thread
{
  AndroidCollector$1(AndroidCollector paramAndroidCollector, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    Looper.prepare();
    AndroidCollector localAndroidCollector = this.this$0;
    AndroidCollector.access$002(localAndroidCollector, new AndroidCollector.CollectorHandler(localAndroidCollector));
    AndroidCollector.access$000(this.this$0).schedule();
    Looper.loop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfm.metrics.AndroidCollector.1
 * JD-Core Version:    0.7.0.1
 */