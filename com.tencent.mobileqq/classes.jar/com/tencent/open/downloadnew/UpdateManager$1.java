package com.tencent.open.downloadnew;

import com.tencent.open.base.LogUtility;
import java.io.File;

class UpdateManager$1
  implements Runnable
{
  UpdateManager$1(UpdateManager paramUpdateManager, String paramString, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      File localFile = new File(this.a);
      if (localFile.exists())
      {
        long l = localFile.length();
        DownloadManager.b().a(this.b, l);
        return;
      }
      LogUtility.c(UpdateManager.b, "patchNewApk report file not exists");
      return;
    }
    catch (Exception localException)
    {
      LogUtility.c(UpdateManager.b, "patchNewApk report>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.UpdateManager.1
 * JD-Core Version:    0.7.0.1
 */