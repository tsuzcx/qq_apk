package com.tencent.open.downloadnew;

import android.os.Handler;
import android.os.Looper;
import bcgo;
import bchb;
import bcho;
import bchp;

public class MyAppApi$YYBDownloadListener$1
  implements Runnable
{
  public MyAppApi$YYBDownloadListener$1(bcho parambcho, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Bcho.a.a != null) && (this.jdField_a_of_type_Bcho.a.a.isShowing())) {
      this.jdField_a_of_type_Bcho.a.a.dismiss();
    }
    bcgo.a().c(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
    new Handler(Looper.getMainLooper()).postAtTime(new MyAppApi.YYBDownloadListener.1.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener.1
 * JD-Core Version:    0.7.0.1
 */