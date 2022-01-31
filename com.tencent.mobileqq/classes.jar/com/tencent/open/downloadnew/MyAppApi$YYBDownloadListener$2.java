package com.tencent.open.downloadnew;

import android.text.TextUtils;
import bflp;
import bfms;
import bfoc;
import bfpk;

public class MyAppApi$YYBDownloadListener$2
  implements Runnable
{
  public MyAppApi$YYBDownloadListener$2(bfpk parambfpk, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    bflp.c("MyAppApi", "rooted and start silent install...");
    long l = System.currentTimeMillis();
    if (bfoc.a(l))
    {
      if ((bfms.a()) && (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.l))) {
        bfms.b(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.l);
      }
    }
    else {
      return;
    }
    bflp.c("MyAppApi", "root confused and remember user operation time!");
    bfoc.a(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener.2
 * JD-Core Version:    0.7.0.1
 */