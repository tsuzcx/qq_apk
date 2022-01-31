package com.tencent.open.downloadnew;

import bdii;
import bdle;
import bdmk;
import java.io.File;

public class UpdateManager$1
  implements Runnable
{
  public UpdateManager$1(bdmk parambdmk, String paramString, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      File localFile = new File(this.jdField_a_of_type_JavaLangString);
      if (localFile.exists())
      {
        long l = localFile.length();
        bdle.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo, l);
        return;
      }
      bdii.c(bdmk.jdField_a_of_type_JavaLangString, "patchNewApk report file not exists");
      return;
    }
    catch (Exception localException)
    {
      bdii.c(bdmk.jdField_a_of_type_JavaLangString, "patchNewApk report>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.UpdateManager.1
 * JD-Core Version:    0.7.0.1
 */