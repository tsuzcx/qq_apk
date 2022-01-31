package com.tencent.open.downloadnew;

import bcds;
import bcgo;
import bchu;
import java.io.File;

public class UpdateManager$2
  implements Runnable
{
  public UpdateManager$2(bchu parambchu, String paramString, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      File localFile = new File(this.jdField_a_of_type_JavaLangString);
      if (localFile.exists())
      {
        long l = localFile.length();
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.c = l;
        bcgo.a().g(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
        return;
      }
      bcds.c(bchu.jdField_a_of_type_JavaLangString, "patchNewApk file not exists");
      return;
    }
    catch (Exception localException)
    {
      bcds.c(bchu.jdField_a_of_type_JavaLangString, "patchNewApk>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.UpdateManager.2
 * JD-Core Version:    0.7.0.1
 */