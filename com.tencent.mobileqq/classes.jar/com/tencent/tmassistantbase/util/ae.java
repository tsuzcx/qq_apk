package com.tencent.tmassistantbase.util;

import java.util.concurrent.atomic.AtomicBoolean;

final class ae
  implements Runnable
{
  public void run()
  {
    if ((ac.h == null) || (!ac.g()) || (ac.t.get())) {
      return;
    }
    new af(this, "TMLogInitThread").start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.ae
 * JD-Core Version:    0.7.0.1
 */