package com.tencent.open.appstore.dl;

import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;

class DownloadManagerV2$24
  implements Runnable
{
  DownloadManagerV2$24(DownloadManagerV2 paramDownloadManagerV2, String paramString, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    DownloadInfo localDownloadInfo = DownloadManagerV2.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.b);
    if (localDownloadInfo == null)
    {
      LogUtility.d("DownloadManagerV2", "OnDownloadSDKTaskProgressChanged info == null");
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnDownloadSDKTaskProgressChanged info state=");
      localStringBuilder.append(localDownloadInfo.a());
      localStringBuilder.append(" progress=");
      localStringBuilder.append(localDownloadInfo.f);
      LogUtility.a("DownloadManagerV2", localStringBuilder.toString());
    }
    this.this$0.a(2, localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.24
 * JD-Core Version:    0.7.0.1
 */