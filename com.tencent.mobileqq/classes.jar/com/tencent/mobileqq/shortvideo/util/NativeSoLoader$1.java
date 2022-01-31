package com.tencent.mobileqq.shortvideo.util;

import axkx;
import java.util.concurrent.atomic.AtomicBoolean;

public final class NativeSoLoader$1
  implements Runnable
{
  public void run()
  {
    if (!axkx.a().get())
    {
      boolean bool = axkx.a("TKGLRenderer");
      axkx.a().getAndSet(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.NativeSoLoader.1
 * JD-Core Version:    0.7.0.1
 */