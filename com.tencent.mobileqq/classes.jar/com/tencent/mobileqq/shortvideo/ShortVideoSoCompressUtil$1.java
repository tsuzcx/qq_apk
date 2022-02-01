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
    if ((arrayOfFile != null) && (arrayOfFile.length > i + 3))
    {
      int i1 = arrayOfFile.length;
      int k = 0;
      Object localObject1 = "unknown";
      int m = 0;
      int j;
      for (i = 2147483647; k < i1; i = j)
      {
        localObject2 = arrayOfFile[k];
        int n;
        if (localObject2 == null)
        {
          n = m;
          localObject2 = localObject1;
          j = i;
        }
        else
        {
          localObject2 = ((File)localObject2).getName();
          if (str2.equalsIgnoreCase((String)localObject2))
          {
            n = m;
            localObject2 = localObject1;
            j = i;
          }
          else if (ShortVideoSoCompressUtil.a((String)localObject2))
          {
            n = m;
            localObject2 = localObject1;
            j = i;
          }
          else
          {
            Object localObject3 = ShortVideoSoManager.a((String)localObject2);
            j = ((ShortVideoSoManager.CfgParser)localObject3).a();
            if (j != 0)
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("[executeClearHistorySOLibFile] errorCodec=");
              ((StringBuilder)localObject3).append(j);
              ((StringBuilder)localObject3).append("  filename=");
              ((StringBuilder)localObject3).append((String)localObject2);
              ShortVideoSoCompressUtil.a(((StringBuilder)localObject3).toString());
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(str1);
              ((StringBuilder)localObject3).append((String)localObject2);
              localObject3 = new File(((StringBuilder)localObject3).toString());
              n = m;
              localObject2 = localObject1;
              j = i;
              if (((File)localObject3).exists())
              {
                n = m;
                localObject2 = localObject1;
                j = i;
                if (((File)localObject3).isFile())
                {
                  ((File)localObject3).delete();
                  n = m;
                  localObject2 = localObject1;
                  j = i;
                }
              }
            }
            else
            {
              localObject3 = ((ShortVideoSoManager.CfgParser)localObject3).b();
              try
              {
                n = Integer.parseInt((String)localObject3);
                j = i;
                if (n < i)
                {
                  localObject1 = localObject2;
                  j = n;
                }
                n = m + 1;
                localObject2 = localObject1;
              }
              catch (NumberFormatException localNumberFormatException)
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("[executeClearHistorySOLibFile] filename=");
                localStringBuilder.append((String)localObject2);
                localStringBuilder.append("  tempVersion=");
                localStringBuilder.append((String)localObject3);
                ShortVideoSoCompressUtil.a("ShortVideoSoCompressUtil", localStringBuilder.toString(), localNumberFormatException);
                j = i;
                localObject2 = localObject1;
                n = m;
              }
            }
          }
        }
        k += 1;
        m = n;
        localObject1 = localObject2;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[executeClearHistorySOLibFile] deleteName=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("  validNumLibSo=");
      ((StringBuilder)localObject2).append(m);
      ((StringBuilder)localObject2).append(" leastVersion=");
      ((StringBuilder)localObject2).append(i);
      ShortVideoSoCompressUtil.a(((StringBuilder)localObject2).toString());
      if (m >= 3)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str1);
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject1 = new File(((StringBuilder)localObject2).toString());
        if ((((File)localObject1).exists()) && (((File)localObject1).isFile()))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[executeClearHistorySOLibFile] deletePath=");
          ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
          ShortVideoSoCompressUtil.a(((StringBuilder)localObject2).toString());
          ((File)localObject1).delete();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoSoCompressUtil.1
 * JD-Core Version:    0.7.0.1
 */