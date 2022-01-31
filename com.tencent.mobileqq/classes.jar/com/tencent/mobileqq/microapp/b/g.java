package com.tencent.mobileqq.microapp.b;

import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import java.util.concurrent.atomic.AtomicInteger;

final class g
  implements ThreadExcutor.IThreadListener
{
  public void onAdded()
  {
    f.a().getAndIncrement();
  }
  
  public void onPostRun()
  {
    f.a().getAndDecrement();
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.b.g
 * JD-Core Version:    0.7.0.1
 */