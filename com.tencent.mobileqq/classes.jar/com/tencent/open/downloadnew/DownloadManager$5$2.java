package com.tencent.open.downloadnew;

import bjtx;
import bjwq;
import bjww;

public class DownloadManager$5$2
  implements Runnable
{
  public DownloadManager$5$2(bjww parambjww, long paramLong1, long paramLong2, String paramString) {}
  
  public void run()
  {
    int i = (int)((float)this.jdField_a_of_type_Long * 100.0F / (float)this.b);
    DownloadInfo localDownloadInfo = this.jdField_a_of_type_Bjww.a.c(this.jdField_a_of_type_JavaLangString, i);
    if (localDownloadInfo == null) {
      bjtx.d("DownloadManager_", "OnDownloadSDKTaskProgressChanged info == null");
    }
    for (;;)
    {
      this.jdField_a_of_type_Bjww.a.a(2, localDownloadInfo);
      return;
      bjtx.a("DownloadManager_", "OnDownloadSDKTaskProgressChanged info state=" + localDownloadInfo.a() + " progress=" + localDownloadInfo.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.5.2
 * JD-Core Version:    0.7.0.1
 */