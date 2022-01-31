package com.tencent.mobileqq.triton.render.monitor;

class BlackScreenMonitor$1
  implements Runnable
{
  BlackScreenMonitor$1(BlackScreenMonitor paramBlackScreenMonitor, int[] paramArrayOfInt) {}
  
  public void run()
  {
    int j = 0;
    int k = this.val$bitmapBuffer[0];
    int i = 1;
    if (i < 16384) {
      if (this.val$bitmapBuffer[i] == k) {}
    }
    for (i = j;; i = 1)
    {
      if (i != 0)
      {
        if (BlackScreenMonitor.access$000(this.this$0) <= 0L) {
          BlackScreenMonitor.access$002(this.this$0, System.currentTimeMillis());
        }
        return;
        i += 1;
        break;
      }
      BlackScreenMonitor.access$002(this.this$0, -1L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.render.monitor.BlackScreenMonitor.1
 * JD-Core Version:    0.7.0.1
 */