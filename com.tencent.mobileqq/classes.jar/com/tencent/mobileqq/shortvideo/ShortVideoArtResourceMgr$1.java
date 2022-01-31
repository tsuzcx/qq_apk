package com.tencent.mobileqq.shortvideo;

import ahww;
import axdn;
import axev;
import axew;
import bbdx;
import java.io.File;

public final class ShortVideoArtResourceMgr$1
  implements Runnable
{
  public void run()
  {
    String str1 = axdn.b();
    String str2 = axdn.a();
    File[] arrayOfFile = new File(str1).listFiles();
    int j;
    Object localObject1;
    int i;
    Object localObject2;
    Object localObject3;
    int m;
    if ((arrayOfFile != null) && (arrayOfFile.length > 2))
    {
      j = 2147483647;
      localObject1 = "unknown";
      int k = 0;
      i = 0;
      if (k < arrayOfFile.length)
      {
        if (arrayOfFile[k] == null) {}
        for (;;)
        {
          k += 1;
          break;
          localObject2 = arrayOfFile[k].getName();
          if (!str2.equalsIgnoreCase((String)localObject2))
          {
            localObject3 = axev.a((String)localObject2);
            m = ((axew)localObject3).a();
            if (m == 0) {
              break label197;
            }
            VideoEnvironment.a("[executeClearArtFilterSoCache] errorCodec=" + m + " filename=" + (String)localObject2, null);
            localObject2 = new File(str1 + (String)localObject2);
            if ((((File)localObject2).exists()) && (((File)localObject2).isFile())) {
              ((File)localObject2).delete();
            }
          }
        }
        label197:
        localObject3 = ((axew)localObject3).b();
      }
    }
    label419:
    for (;;)
    {
      try
      {
        m = Integer.parseInt((String)localObject3);
        if (m >= j) {
          break label419;
        }
        j = m;
        localObject1 = localObject2;
        i += 1;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        VideoEnvironment.a("[executeClearArtFilterSoCache] filename=" + (String)localObject2 + "  tempVersion=" + (String)localObject3, localNumberFormatException);
      }
      break;
      VideoEnvironment.a("[executeClearArtFilterSoCache] deleteName=" + (String)localObject1 + "  validNumPendantCache=" + i + " leastVersion=" + j, null);
      if (i >= 2)
      {
        localObject1 = new File(str1 + (String)localObject1);
        if ((((File)localObject1).exists()) && (((File)localObject1).isFile()))
        {
          VideoEnvironment.a("[executeClearArtFilterSoCache] deletePath=" + ((File)localObject1).getAbsolutePath(), null);
          ((File)localObject1).delete();
        }
      }
      if (new File(ahww.c).exists()) {
        bbdx.a(ahww.c);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoArtResourceMgr.1
 * JD-Core Version:    0.7.0.1
 */