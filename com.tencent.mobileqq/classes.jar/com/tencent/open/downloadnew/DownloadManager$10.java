package com.tencent.open.downloadnew;

import com.tencent.open.base.ImageUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.img.ImageCache;
import com.tencent.open.base.img.ImageDownCallback;

class DownloadManager$10
  implements ImageDownCallback
{
  DownloadManager$10(DownloadManager paramDownloadManager, DownloadInfo paramDownloadInfo) {}
  
  public void a(String paramString1, String paramString2, String paramString3) {}
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    LogUtility.d("DownloadManager_", ">>download apk icon err,should load another size icon");
    ImageCache.a("app", ImageUtil.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.c, 75), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.10
 * JD-Core Version:    0.7.0.1
 */