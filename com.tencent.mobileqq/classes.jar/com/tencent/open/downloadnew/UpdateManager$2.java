package com.tencent.open.downloadnew;

import com.tencent.open.base.LogUtility;
import java.io.File;

class UpdateManager$2
  implements Runnable
{
  UpdateManager$2(UpdateManager paramUpdateManager, String paramString, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      File localFile = new File(this.jdField_a_of_type_JavaLangString);
      if (localFile.exists())
      {
        long l = localFile.length();
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.c = l;
        DownloadManager.a().g(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
        return;
      }
      LogUtility.c(UpdateManager.jdField_a_of_type_JavaLangString, "patchNewApk file not exists");
      return;
    }
    catch (Exception localException)
    {
      LogUtility.c(UpdateManager.jdField_a_of_type_JavaLangString, "patchNewApk>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.downloadnew.UpdateManager.2
 * JD-Core Version:    0.7.0.1
 */