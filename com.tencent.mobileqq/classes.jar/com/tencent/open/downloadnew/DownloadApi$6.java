package com.tencent.open.downloadnew;

import com.tencent.open.base.LogUtility;
import java.util.ArrayList;
import java.util.List;

final class DownloadApi$6
  implements Runnable
{
  DownloadApi$6(String paramString, DownloadQueryListener paramDownloadQueryListener) {}
  
  public void run()
  {
    LogUtility.a(DownloadApi.a, "getQueryDownloadActionByVia enter");
    try
    {
      new ArrayList();
      List localList = DownloadManager.b().l(this.a);
      localObject = DownloadApi.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getQueryDownloadActionByVia result = ");
      localStringBuilder.append(localList);
      LogUtility.a((String)localObject, localStringBuilder.toString());
      if (this.b != null)
      {
        this.b.a(localList);
        return;
      }
    }
    catch (Exception localException)
    {
      LogUtility.c(DownloadApi.a, "getQueryDownloadActionByVia Exception>>>", localException);
      Object localObject = this.b;
      if (localObject != null) {
        ((DownloadQueryListener)localObject).a(-1, localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadApi.6
 * JD-Core Version:    0.7.0.1
 */