package com.tencent.open.downloadnew;

import bjko;
import bjna;
import bjog;
import java.io.File;

public class UpdateManager$1
  implements Runnable
{
  public UpdateManager$1(bjog parambjog, String paramString, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      File localFile = new File(this.jdField_a_of_type_JavaLangString);
      if (localFile.exists())
      {
        long l = localFile.length();
        bjna.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo, l);
        return;
      }
      bjko.c(bjog.jdField_a_of_type_JavaLangString, "patchNewApk report file not exists");
      return;
    }
    catch (Exception localException)
    {
      bjko.c(bjog.jdField_a_of_type_JavaLangString, "patchNewApk report>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.UpdateManager.1
 * JD-Core Version:    0.7.0.1
 */