package com.tencent.tbs.one.impl.e;

import android.os.Process;
import com.tencent.tbs.one.impl.a.c;
import java.io.File;

public final class a
  extends Thread
{
  private final File a;
  
  public a(File paramFile)
  {
    this.a = paramFile;
  }
  
  public final void run()
  {
    int i = 0;
    super.run();
    com.tencent.tbs.one.impl.a.f.a("Running cleanup thread", new Object[0]);
    c.a(com.tencent.tbs.one.impl.common.f.a(this.a, Process.myPid()));
    File[] arrayOfFile = com.tencent.tbs.one.impl.common.f.a(this.a).listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      while (i < j)
      {
        f.d(arrayOfFile[i]);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.a
 * JD-Core Version:    0.7.0.1
 */