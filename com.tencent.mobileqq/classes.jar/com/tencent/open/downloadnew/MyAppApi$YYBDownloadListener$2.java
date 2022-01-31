package com.tencent.open.downloadnew;

import android.text.TextUtils;
import bcds;
import bcev;
import bcgg;
import bcho;

public class MyAppApi$YYBDownloadListener$2
  implements Runnable
{
  public MyAppApi$YYBDownloadListener$2(bcho parambcho, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    bcds.c("MyAppApi", "rooted and start silent install...");
    long l = System.currentTimeMillis();
    if (bcgg.a(l))
    {
      if ((bcev.a()) && (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.l))) {
        bcev.b(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.l);
      }
    }
    else {
      return;
    }
    bcds.c("MyAppApi", "root confused and remember user operation time!");
    bcgg.a(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener.2
 * JD-Core Version:    0.7.0.1
 */