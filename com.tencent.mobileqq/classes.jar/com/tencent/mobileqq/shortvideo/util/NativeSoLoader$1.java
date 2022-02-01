package com.tencent.mobileqq.shortvideo.util;

import java.util.concurrent.atomic.AtomicBoolean;

final class NativeSoLoader$1
  implements Runnable
{
  public void run()
  {
    if (!NativeSoLoader.a().get())
    {
      boolean bool = NativeSoLoader.a("TKGLRenderer");
      NativeSoLoader.a().getAndSet(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.NativeSoLoader.1
 * JD-Core Version:    0.7.0.1
 */