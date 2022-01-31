package dov.com.tencent.mobileqq.shortvideo;

import axle;
import bkzd;
import blag;
import blah;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.io.File;

public final class PendantVersionManager$1
  implements Runnable
{
  public void run()
  {
    String str1 = axle.a(VideoEnvironment.a());
    String str2 = bkzd.a();
    File[] arrayOfFile = new File(str1).listFiles();
    int i = bkzd.a().length;
    int j;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int m;
    if ((arrayOfFile != null) && (arrayOfFile.length > i + 2))
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
          if ((!str2.equalsIgnoreCase((String)localObject2)) && (!bkzd.a((String)localObject2)))
          {
            localObject3 = blag.a((String)localObject2);
            m = ((blah)localObject3).a();
            if (m == 0) {
              break label218;
            }
            VideoEnvironment.a("[executeClearHistoryPendantCache] errorCodec=" + m + " filename=" + (String)localObject2, null);
            localObject2 = new File(str1 + (String)localObject2);
            if ((((File)localObject2).exists()) && (((File)localObject2).isFile())) {
              ((File)localObject2).delete();
            }
          }
        }
        label218:
        localObject3 = ((blah)localObject3).a();
      }
    }
    label418:
    for (;;)
    {
      try
      {
        m = Integer.parseInt((String)localObject3);
        if (m >= j) {
          break label418;
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
      VideoEnvironment.a("[executeClearHistoryPendantCache] deleteName=" + (String)localObject1 + "  validNumPendantCache=" + i + " leastVersion=" + j, null);
      if (i >= 2)
      {
        localObject1 = new File(str1 + (String)localObject1);
        if ((((File)localObject1).exists()) && (((File)localObject1).isFile()))
        {
          VideoEnvironment.a("[executeClearHistoryPendantCache] deletePath=" + ((File)localObject1).getAbsolutePath(), null);
          ((File)localObject1).delete();
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.PendantVersionManager.1
 * JD-Core Version:    0.7.0.1
 */