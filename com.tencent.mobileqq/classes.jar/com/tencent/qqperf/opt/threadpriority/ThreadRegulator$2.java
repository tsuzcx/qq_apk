package com.tencent.qqperf.opt.threadpriority;

class ThreadRegulator$2
  implements Runnable
{
  ThreadRegulator$2(ThreadRegulator paramThreadRegulator) {}
  
  public void run()
  {
    if (ThreadRegulator.a(this.this$0) == null) {}
    ThreadRegulator.CpuBusyness localCpuBusyness;
    do
    {
      return;
      localCpuBusyness = ThreadRegulator.a(this.this$0);
      ThreadRegulator.a(this.this$0, null);
    } while (localCpuBusyness == null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.opt.threadpriority.ThreadRegulator.2
 * JD-Core Version:    0.7.0.1
 */