package com.tencent.mobileqq.shortvideo;

import azek;
import azel;
import com.tencent.video.decode.ShortVideoSoLoad;
import java.io.File;

final class VideoEnvironment$1
  implements Runnable
{
  public void run()
  {
    String str1 = ShortVideoSoLoad.getShortVideoSoPath(VideoEnvironment.a());
    Object localObject1 = new File(str1 + VideoEnvironment.b());
    if (((File)localObject1).exists()) {
      ((File)localObject1).delete();
    }
    localObject1 = new File(str1 + VideoEnvironment.c());
    if (((File)localObject1).exists()) {
      ((File)localObject1).delete();
    }
    String str2 = azek.a();
    File[] arrayOfFile = new File(str1).listFiles();
    int i = VideoEnvironment.a().length;
    int j;
    Object localObject2;
    Object localObject3;
    int m;
    if ((arrayOfFile != null) && (arrayOfFile.length > i + 3))
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
          if ((!str2.equalsIgnoreCase((String)localObject2)) && (!VideoEnvironment.a((String)localObject2)))
          {
            localObject3 = azek.a((String)localObject2);
            m = ((azel)localObject3).a();
            if (m == 0) {
              break label306;
            }
            VideoEnvironment.a("[executeClearHistorySOLibFile] errorCodec=" + m + "  filename=" + (String)localObject2, null);
            localObject2 = new File(str1 + (String)localObject2);
            if ((((File)localObject2).exists()) && (((File)localObject2).isFile())) {
              ((File)localObject2).delete();
            }
          }
        }
        label306:
        localObject3 = ((azel)localObject3).b();
      }
    }
    label506:
    for (;;)
    {
      try
      {
        m = Integer.parseInt((String)localObject3);
        if (m >= j) {
          break label506;
        }
        j = m;
        localObject1 = localObject2;
        i += 1;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        VideoEnvironment.a("[executeClearHistorySOLibFile] filename=" + (String)localObject2 + "  tempVersion=" + (String)localObject3, localNumberFormatException);
      }
      break;
      VideoEnvironment.a("[executeClearHistorySOLibFile] deleteName=" + (String)localObject1 + "  validNumLibso=" + i + " leastVersion=" + j, null);
      if (i >= 3)
      {
        localObject1 = new File(str1 + (String)localObject1);
        if ((((File)localObject1).exists()) && (((File)localObject1).isFile()))
        {
          VideoEnvironment.a("[executeClearHistorySOLibFile] deletePath=" + ((File)localObject1).getAbsolutePath(), null);
          ((File)localObject1).delete();
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.VideoEnvironment.1
 * JD-Core Version:    0.7.0.1
 */