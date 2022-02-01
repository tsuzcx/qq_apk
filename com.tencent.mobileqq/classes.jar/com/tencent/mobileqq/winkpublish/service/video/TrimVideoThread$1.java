package com.tencent.mobileqq.winkpublish.service.video;

import android.os.Handler;

class TrimVideoThread$1
  implements Runnable
{
  TrimVideoThread$1(TrimVideoThread paramTrimVideoThread) {}
  
  public void run()
  {
    if (TrimVideoThread.a(this.this$0) < 80)
    {
      localTrimVideoThread = this.this$0;
      TrimVideoThread.a(localTrimVideoThread, TrimVideoThread.a(localTrimVideoThread) + 10);
    }
    else if (TrimVideoThread.a(this.this$0) < 90)
    {
      localTrimVideoThread = this.this$0;
      TrimVideoThread.a(localTrimVideoThread, TrimVideoThread.a(localTrimVideoThread) + 5);
    }
    else
    {
      if (TrimVideoThread.a(this.this$0) >= 98) {
        return;
      }
      localTrimVideoThread = this.this$0;
      TrimVideoThread.a(localTrimVideoThread, TrimVideoThread.a(localTrimVideoThread) + 2);
    }
    TrimVideoThread localTrimVideoThread = this.this$0;
    TrimVideoThread.a(localTrimVideoThread, 1002, TrimVideoThread.a(localTrimVideoThread));
    TrimVideoThread.b(this.this$0).postDelayed(this, 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.service.video.TrimVideoThread.1
 * JD-Core Version:    0.7.0.1
 */