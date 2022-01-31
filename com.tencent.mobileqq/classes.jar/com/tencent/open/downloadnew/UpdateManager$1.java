package com.tencent.open.downloadnew;

import bfhg;
import bfkb;
import bflh;
import java.io.File;

public class UpdateManager$1
  implements Runnable
{
  public UpdateManager$1(bflh parambflh, String paramString, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      File localFile = new File(this.jdField_a_of_type_JavaLangString);
      if (localFile.exists())
      {
        long l = localFile.length();
        bfkb.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo, l);
        return;
      }
      bfhg.c(bflh.jdField_a_of_type_JavaLangString, "patchNewApk report file not exists");
      return;
    }
    catch (Exception localException)
    {
      bfhg.c(bflh.jdField_a_of_type_JavaLangString, "patchNewApk report>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.UpdateManager.1
 * JD-Core Version:    0.7.0.1
 */