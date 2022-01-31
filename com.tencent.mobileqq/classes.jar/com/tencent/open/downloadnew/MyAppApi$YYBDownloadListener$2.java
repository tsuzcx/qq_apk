package com.tencent.open.downloadnew;

import android.text.TextUtils;
import bfhg;
import bfij;
import bfjt;
import bflb;

public class MyAppApi$YYBDownloadListener$2
  implements Runnable
{
  public MyAppApi$YYBDownloadListener$2(bflb parambflb, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    bfhg.c("MyAppApi", "rooted and start silent install...");
    long l = System.currentTimeMillis();
    if (bfjt.a(l))
    {
      if ((bfij.a()) && (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.l))) {
        bfij.b(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.l);
      }
    }
    else {
      return;
    }
    bfhg.c("MyAppApi", "root confused and remember user operation time!");
    bfjt.a(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener.2
 * JD-Core Version:    0.7.0.1
 */