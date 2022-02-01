package com.tencent.mobileqq.shortvideo.widget;

import android.os.Handler;

class TCProgressBar$TimerRefresh
  implements Runnable
{
  TCProgressBar$TimerRefresh(TCProgressBar paramTCProgressBar) {}
  
  public void run()
  {
    if (this.this$0.a == 3)
    {
      this.this$0.F.postDelayed(new TimerRefresh(this.this$0), this.this$0.e);
      this.this$0.A.n ^= true;
      this.this$0.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.widget.TCProgressBar.TimerRefresh
 * JD-Core Version:    0.7.0.1
 */