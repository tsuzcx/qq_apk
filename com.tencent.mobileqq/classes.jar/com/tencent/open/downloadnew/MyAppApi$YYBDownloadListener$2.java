package com.tencent.open.downloadnew;

import android.text.TextUtils;
import bdii;
import bdjl;
import bdkw;
import bdme;

public class MyAppApi$YYBDownloadListener$2
  implements Runnable
{
  public MyAppApi$YYBDownloadListener$2(bdme parambdme, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    bdii.c("MyAppApi", "rooted and start silent install...");
    long l = System.currentTimeMillis();
    if (bdkw.a(l))
    {
      if ((bdjl.a()) && (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.l))) {
        bdjl.b(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.l);
      }
    }
    else {
      return;
    }
    bdii.c("MyAppApi", "root confused and remember user operation time!");
    bdkw.a(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener.2
 * JD-Core Version:    0.7.0.1
 */