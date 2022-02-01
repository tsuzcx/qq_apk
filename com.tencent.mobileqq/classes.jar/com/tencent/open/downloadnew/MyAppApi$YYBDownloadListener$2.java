package com.tencent.open.downloadnew;

import android.text.TextUtils;
import bhzm;
import biam;
import bibr;
import bicy;

public class MyAppApi$YYBDownloadListener$2
  implements Runnable
{
  public MyAppApi$YYBDownloadListener$2(bicy parambicy, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    bhzm.c("MyAppApi", "rooted and start silent install...");
    long l = System.currentTimeMillis();
    if (bibr.a(l))
    {
      if ((biam.a()) && (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.l))) {
        biam.b(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.l);
      }
    }
    else {
      return;
    }
    bhzm.c("MyAppApi", "root confused and remember user operation time!");
    bibr.a(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener.2
 * JD-Core Version:    0.7.0.1
 */