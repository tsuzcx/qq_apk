package com.tencent.mobileqq.shortvideo.util;

import bddx;
import java.util.concurrent.atomic.AtomicBoolean;

public final class NativeSoLoader$1
  implements Runnable
{
  public void run()
  {
    if (!bddx.a().get())
    {
      boolean bool = bddx.a("TKGLRenderer");
      bddx.a().getAndSet(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.NativeSoLoader.1
 * JD-Core Version:    0.7.0.1
 */