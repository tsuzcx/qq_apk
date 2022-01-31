package com.tencent.open.downloadnew;

import android.text.TextUtils;
import bdht;
import bdiw;
import bdkh;
import bdlp;

public class MyAppApi$YYBDownloadListener$2
  implements Runnable
{
  public MyAppApi$YYBDownloadListener$2(bdlp parambdlp, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    bdht.c("MyAppApi", "rooted and start silent install...");
    long l = System.currentTimeMillis();
    if (bdkh.a(l))
    {
      if ((bdiw.a()) && (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.l))) {
        bdiw.b(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.l);
      }
    }
    else {
      return;
    }
    bdht.c("MyAppApi", "root confused and remember user operation time!");
    bdkh.a(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener.2
 * JD-Core Version:    0.7.0.1
 */