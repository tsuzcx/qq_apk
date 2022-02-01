package com.tencent.open.downloadnew;

import android.text.TextUtils;
import bjtx;
import bjva;
import bjwj;
import bjxq;

public class MyAppApi$YYBDownloadListener$2
  implements Runnable
{
  public MyAppApi$YYBDownloadListener$2(bjxq parambjxq, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    bjtx.c("MyAppApi", "rooted and start silent install...");
    long l = System.currentTimeMillis();
    if (bjwj.a(l))
    {
      if ((bjva.a()) && (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.l))) {
        bjva.b(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.l);
      }
    }
    else {
      return;
    }
    bjtx.c("MyAppApi", "root confused and remember user operation time!");
    bjwj.a(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener.2
 * JD-Core Version:    0.7.0.1
 */