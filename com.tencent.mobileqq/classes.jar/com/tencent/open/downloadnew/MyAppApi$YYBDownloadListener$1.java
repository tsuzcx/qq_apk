package com.tencent.open.downloadnew;

import android.os.Handler;
import android.os.Looper;
import bdle;
import bdlr;
import bdme;
import bdmf;

public class MyAppApi$YYBDownloadListener$1
  implements Runnable
{
  public MyAppApi$YYBDownloadListener$1(bdme parambdme, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Bdme.a.a != null) && (this.jdField_a_of_type_Bdme.a.a.isShowing())) {
      this.jdField_a_of_type_Bdme.a.a.dismiss();
    }
    bdle.a().c(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
    new Handler(Looper.getMainLooper()).postAtTime(new MyAppApi.YYBDownloadListener.1.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener.1
 * JD-Core Version:    0.7.0.1
 */