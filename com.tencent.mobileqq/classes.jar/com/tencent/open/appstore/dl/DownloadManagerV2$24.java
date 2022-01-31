package com.tencent.open.appstore.dl;

import bdhk;
import bdii;
import com.tencent.open.downloadnew.DownloadInfo;

public class DownloadManagerV2$24
  implements Runnable
{
  public DownloadManagerV2$24(bdhk parambdhk, String paramString, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    DownloadInfo localDownloadInfo = bdhk.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.b);
    if (localDownloadInfo == null) {
      bdii.d("DownloadManagerV2", "OnDownloadSDKTaskProgressChanged info == null");
    }
    for (;;)
    {
      this.this$0.a(2, localDownloadInfo);
      return;
      bdii.a("DownloadManagerV2", "OnDownloadSDKTaskProgressChanged info state=" + localDownloadInfo.a() + " progress=" + localDownloadInfo.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.24
 * JD-Core Version:    0.7.0.1
 */