package com.tencent.qg.loader;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class QGOfflineDownloader$1
  implements AsyncBack
{
  public void loaded(String paramString, int paramInt)
  {
    if (((paramInt != 0) || (paramString == null) || (!paramString.contains("url"))) && (paramInt != 7)) {
      QGLoader.b.set(false);
    }
    Object localObject = this.c;
    ((QGOfflineDownloader)localObject).a = -1;
    if (paramInt != -1) {
      if (paramInt != 0)
      {
        if ((paramInt != 5) && (paramInt != 7)) {
          if (paramInt != 8) {
            ((QGOfflineDownloader)localObject).a(this.a);
          } else {
            ((QGOfflineDownloader)localObject).a(this.a, this.b);
          }
        }
      }
      else if (paramString == null) {
        ((QGOfflineDownloader)localObject).a(this.a, this.b);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(", DownloadStatus = ");
      ((StringBuilder)localObject).append(this.c.a);
      QLog.d("QGDownloader.offline", 2, new Object[] { "onSoDownload loaded. code = ", Integer.valueOf(paramInt), ", param1:", paramString, ((StringBuilder)localObject).toString() });
    }
  }
  
  public void progress(int paramInt)
  {
    this.c.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.loader.QGOfflineDownloader.1
 * JD-Core Version:    0.7.0.1
 */