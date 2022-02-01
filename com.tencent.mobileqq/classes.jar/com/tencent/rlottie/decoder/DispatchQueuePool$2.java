package com.tencent.rlottie.decoder;

class DispatchQueuePool$2
  implements Runnable
{
  DispatchQueuePool$2(DispatchQueuePool paramDispatchQueuePool, Runnable paramRunnable, DispatchQueue paramDispatchQueue) {}
  
  public void run()
  {
    this.a.run();
    DispatchQueue.a(new DispatchQueuePool.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rlottie.decoder.DispatchQueuePool.2
 * JD-Core Version:    0.7.0.1
 */