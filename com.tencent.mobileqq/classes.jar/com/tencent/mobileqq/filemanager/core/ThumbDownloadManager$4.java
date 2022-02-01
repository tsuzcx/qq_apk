package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.app.QQAppInterface;

class ThumbDownloadManager$4
  implements HttpThumbDownloader.ThumbEventCallback
{
  ThumbDownloadManager$4(ThumbDownloadManager paramThumbDownloadManager) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString1, boolean paramBoolean, int paramInt, String paramString2, long paramLong)
  {
    ThumbDownloadManager.c(this.a, paramString1);
    ThumbDownloadManager.d(this.a).getFileManagerNotifyCenter().a(paramBoolean, 60, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), paramString2, paramString1 });
    ThumbDownloadManager.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.ThumbDownloadManager.4
 * JD-Core Version:    0.7.0.1
 */