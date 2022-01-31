package com.tencent.mobileqq.shortvideo.util;

import azgd;
import java.util.concurrent.atomic.AtomicBoolean;

public final class NativeSoLoader$1
  implements Runnable
{
  public void run()
  {
    if (!azgd.a().get())
    {
      boolean bool = azgd.a("TKGLRenderer");
      azgd.a().getAndSet(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.NativeSoLoader.1
 * JD-Core Version:    0.7.0.1
 */