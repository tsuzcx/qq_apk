package com.tencent.rmonitor.heapdump;

import android.os.Process;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

class ForkJvmHeapDumper$1
  implements Runnable
{
  ForkJvmHeapDumper$1(ForkJvmHeapDumper paramForkJvmHeapDumper, AtomicBoolean paramAtomicBoolean, int paramInt) {}
  
  public void run()
  {
    Log.i("ForkJvmHeapDumper", "wait sub process dump timeout.");
    this.a.set(true);
    Process.killProcess(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.heapdump.ForkJvmHeapDumper.1
 * JD-Core Version:    0.7.0.1
 */