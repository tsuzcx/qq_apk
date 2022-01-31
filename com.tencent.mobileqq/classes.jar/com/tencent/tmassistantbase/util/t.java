package com.tencent.tmassistantbase.util;

import java.util.concurrent.atomic.AtomicBoolean;

final class t
  implements Runnable
{
  public void run()
  {
    if ((r.h == null) || (!r.g()) || (r.t.get())) {
      return;
    }
    new u(this, "TMLogInitThread").start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.t
 * JD-Core Version:    0.7.0.1
 */