package com.tencent.open.downloadnew;

import android.os.Handler;
import android.os.Looper;
import bjwq;
import bjxd;
import bjxq;
import bjxr;

public class MyAppApi$YYBDownloadListener$1
  implements Runnable
{
  public MyAppApi$YYBDownloadListener$1(bjxq parambjxq, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Bjxq.a.a != null) && (this.jdField_a_of_type_Bjxq.a.a.isShowing())) {
      this.jdField_a_of_type_Bjxq.a.a.dismiss();
    }
    bjwq.a().c(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
    new Handler(Looper.getMainLooper()).postAtTime(new MyAppApi.YYBDownloadListener.1.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener.1
 * JD-Core Version:    0.7.0.1
 */