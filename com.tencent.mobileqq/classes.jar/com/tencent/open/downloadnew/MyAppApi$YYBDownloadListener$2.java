package com.tencent.open.downloadnew;

import android.text.TextUtils;
import bisy;
import biub;
import bivk;
import biwr;

public class MyAppApi$YYBDownloadListener$2
  implements Runnable
{
  public MyAppApi$YYBDownloadListener$2(biwr parambiwr, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    bisy.c("MyAppApi", "rooted and start silent install...");
    long l = System.currentTimeMillis();
    if (bivk.a(l))
    {
      if ((biub.a()) && (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.l))) {
        biub.b(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.l);
      }
    }
    else {
      return;
    }
    bisy.c("MyAppApi", "root confused and remember user operation time!");
    bivk.a(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener.2
 * JD-Core Version:    0.7.0.1
 */