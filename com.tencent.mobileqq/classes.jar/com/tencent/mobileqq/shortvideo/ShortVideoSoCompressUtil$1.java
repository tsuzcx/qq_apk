package com.tencent.mobileqq.shortvideo;

import com.tencent.video.decode.ShortVideoSoLoad;
import java.io.File;

final class ShortVideoSoCompressUtil$1
  implements Runnable
{
  public void run()
  {
    String str1 = ShortVideoSoLoad.getShortVideoSoPath(VideoEnvironment.getContext());
    String str2 = ShortVideoSoManager.a();
    File[] arrayOfFile = new File(str1).listFiles();
    int i = ShortVideoSoCompressUtil.a().length;
    int j;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int m;
    if ((arrayOfFile != null) && (arrayOfFile.length > i + 3))
    {
      j = 2147483647;
      localObject1 = "unknown";
      int n = arrayOfFile.length;
      int k = 0;
      i = 0;
      if (k < n)
      {
        localObject2 = arrayOfFile[k];
        if (localObject2 == null) {}
        for (;;)
        {
          k += 1;
          break;
          localObject2 = ((File)localObject2).getName();
          if ((!str2.equalsIgnoreCase((String)localObject2)) && (!ShortVideoSoCompressUtil.a((String)localObject2)))
          {
            localObject3 = ShortVideoSoManager.a((String)localObject2);
            m = ((ShortVideoSoManager.CfgParser)localObject3).a();
            if (m == 0) {
              break label223;
            }
            ShortVideoSoCompressUtil.a("[executeClearHistorySOLibFile] errorCodec=" + m + "  filename=" + (String)localObject2);
            localObject2 = new File(str1 + (String)localObject2);
            if ((((File)localObject2).exists()) && (((File)localObject2).isFile())) {
              ((File)localObject2).delete();
            }
          }
        }
        label223:
        localObject3 = ((ShortVideoSoManager.CfgParser)localObject3).b();
      }
    }
    label423:
    for (;;)
    {
      try
      {
        m = Integer.parseInt((String)localObject3);
        if (m >= j) {
          break label423;
        }
        j = m;
        localObject1 = localObject2;
        i += 1;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        ShortVideoSoCompressUtil.a("ShortVideoSoCompressUtil", "[executeClearHistorySOLibFile] filename=" + (String)localObject2 + "  tempVersion=" + (String)localObject3, localNumberFormatException);
      }
      break;
      ShortVideoSoCompressUtil.a("[executeClearHistorySOLibFile] deleteName=" + (String)localObject1 + "  validNumLibSo=" + i + " leastVersion=" + j);
      if (i >= 3)
      {
        localObject1 = new File(str1 + (String)localObject1);
        if ((((File)localObject1).exists()) && (((File)localObject1).isFile()))
        {
          ShortVideoSoCompressUtil.a("[executeClearHistorySOLibFile] deletePath=" + ((File)localObject1).getAbsolutePath());
          ((File)localObject1).delete();
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoSoCompressUtil.1
 * JD-Core Version:    0.7.0.1
 */