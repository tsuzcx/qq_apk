package com.tencent.qqlive.module.videoreport.dtreport.lazy;

import com.tencent.qqlive.module.videoreport.Log;

class LazyInitObserver$4
  implements Runnable
{
  LazyInitObserver$4(LazyInitObserver paramLazyInitObserver) {}
  
  public void run()
  {
    Log.d("LazyInitSequence", "start to proceed");
    LazyInitObserver.access$302(this.this$0, true);
    LazyInitObserver.access$400(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.lazy.LazyInitObserver.4
 * JD-Core Version:    0.7.0.1
 */