package com.tencent.open.downloadnew;

import android.text.TextUtils;
import bjko;
import bjlo;
import bjmt;
import bjoa;

public class MyAppApi$YYBDownloadListener$2
  implements Runnable
{
  public MyAppApi$YYBDownloadListener$2(bjoa parambjoa, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    bjko.c("MyAppApi", "rooted and start silent install...");
    long l = System.currentTimeMillis();
    if (bjmt.a(l))
    {
      if ((bjlo.a()) && (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.l))) {
        bjlo.b(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.l);
      }
    }
    else {
      return;
    }
    bjko.c("MyAppApi", "root confused and remember user operation time!");
    bjmt.a(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener.2
 * JD-Core Version:    0.7.0.1
 */