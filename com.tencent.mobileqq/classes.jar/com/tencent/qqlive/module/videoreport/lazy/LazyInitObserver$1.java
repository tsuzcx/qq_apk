package com.tencent.qqlive.module.videoreport.lazy;

import com.tencent.qqlive.module.videoreport.Log;

class LazyInitObserver$1
  implements Runnable
{
  LazyInitObserver$1(LazyInitObserver paramLazyInitObserver) {}
  
  public void run()
  {
    Log.d("LazyInitSequence", "start to proceed");
    LazyInitObserver.access$102(this.this$0, true);
    LazyInitObserver.access$200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.lazy.LazyInitObserver.1
 * JD-Core Version:    0.7.0.1
 */