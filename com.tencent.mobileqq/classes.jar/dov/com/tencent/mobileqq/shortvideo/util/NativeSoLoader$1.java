package dov.com.tencent.mobileqq.shortvideo.util;

import blcl;
import java.util.concurrent.atomic.AtomicBoolean;

public final class NativeSoLoader$1
  implements Runnable
{
  public void run()
  {
    if (!blcl.a().get())
    {
      boolean bool = blcl.a("TKGLRenderer");
      blcl.a().getAndSet(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.util.NativeSoLoader.1
 * JD-Core Version:    0.7.0.1
 */