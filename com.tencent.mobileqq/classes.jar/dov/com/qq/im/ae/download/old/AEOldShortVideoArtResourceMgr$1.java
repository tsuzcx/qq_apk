package dov.com.qq.im.ae.download.old;

import com.tencent.aelight.camera.qqstory.api.IVideoFilterTools;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

final class AEOldShortVideoArtResourceMgr$1
  implements Runnable
{
  public void run()
  {
    String str1 = AEOldShortVideoArtResourceMgr.b();
    String str2 = AEOldShortVideoArtResourceMgr.a();
    File[] arrayOfFile = new File(str1).listFiles();
    if ((arrayOfFile != null) && (arrayOfFile.length > 2))
    {
      int k = 0;
      Object localObject1 = "unknown";
      int m = 0;
      int j;
      for (int i = 2147483647; k < arrayOfFile.length; i = j)
      {
        int n;
        if (arrayOfFile[k] == null)
        {
          n = m;
          localObject2 = localObject1;
          j = i;
        }
        else
        {
          localObject2 = arrayOfFile[k].getName();
          if (str2.equalsIgnoreCase((String)localObject2))
          {
            n = m;
            localObject2 = localObject1;
            j = i;
          }
          else
          {
            Object localObject3 = AEOldShortVideoSoManager.a((String)localObject2);
            j = ((AEOldShortVideoSoManager.CfgParser)localObject3).d();
            if (j != 0)
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("[executeClearArtFilterSoCache] errorCodec=");
              ((StringBuilder)localObject3).append(j);
              ((StringBuilder)localObject3).append(" filename=");
              ((StringBuilder)localObject3).append((String)localObject2);
              VideoEnvironment.LogDownLoad(((StringBuilder)localObject3).toString(), null);
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
              localObject3 = ((AEOldShortVideoSoManager.CfgParser)localObject3).a();
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
                localStringBuilder.append("[executeClearArtFilterSoCache] filename=");
                localStringBuilder.append((String)localObject2);
                localStringBuilder.append("  tempVersion=");
                localStringBuilder.append((String)localObject3);
                VideoEnvironment.LogDownLoad(localStringBuilder.toString(), localNumberFormatException);
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
      ((StringBuilder)localObject2).append("[executeClearArtFilterSoCache] deleteName=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("  validNumPendantCache=");
      ((StringBuilder)localObject2).append(m);
      ((StringBuilder)localObject2).append(" leastVersion=");
      ((StringBuilder)localObject2).append(i);
      VideoEnvironment.LogDownLoad(((StringBuilder)localObject2).toString(), null);
      if (m >= 2)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str1);
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject1 = new File(((StringBuilder)localObject2).toString());
        if ((((File)localObject1).exists()) && (((File)localObject1).isFile()))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[executeClearArtFilterSoCache] deletePath=");
          ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
          VideoEnvironment.LogDownLoad(((StringBuilder)localObject2).toString(), null);
          ((File)localObject1).delete();
        }
      }
    }
    if (new File(((IVideoFilterTools)QRoute.api(IVideoFilterTools.class)).getCommonPrefix()).exists()) {
      FileUtils.deleteDirectory(((IVideoFilterTools)QRoute.api(IVideoFilterTools.class)).getCommonPrefix());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldShortVideoArtResourceMgr.1
 * JD-Core Version:    0.7.0.1
 */