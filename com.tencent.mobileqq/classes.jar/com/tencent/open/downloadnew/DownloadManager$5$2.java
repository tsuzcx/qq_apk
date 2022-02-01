package com.tencent.open.downloadnew;

import bisy;
import bivr;
import bivx;

public class DownloadManager$5$2
  implements Runnable
{
  public DownloadManager$5$2(bivx parambivx, long paramLong1, long paramLong2, String paramString) {}
  
  public void run()
  {
    int i = (int)((float)this.jdField_a_of_type_Long * 100.0F / (float)this.b);
    DownloadInfo localDownloadInfo = this.jdField_a_of_type_Bivx.a.c(this.jdField_a_of_type_JavaLangString, i);
    if (localDownloadInfo == null) {
      bisy.d("DownloadManager_", "OnDownloadSDKTaskProgressChanged info == null");
    }
    for (;;)
    {
      this.jdField_a_of_type_Bivx.a.a(2, localDownloadInfo);
      return;
      bisy.a("DownloadManager_", "OnDownloadSDKTaskProgressChanged info state=" + localDownloadInfo.a() + " progress=" + localDownloadInfo.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.5.2
 * JD-Core Version:    0.7.0.1
 */