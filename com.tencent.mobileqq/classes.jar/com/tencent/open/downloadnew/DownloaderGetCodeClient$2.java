package com.tencent.open.downloadnew;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.open.base.LogUtility;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class DownloaderGetCodeClient$2
  implements EIPCResultCallback
{
  DownloaderGetCodeClient$2(DownloaderGetCodeClient paramDownloaderGetCodeClient) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    LogUtility.c("DownloaderGetCodeClient", "EIPCResultCallback onCallback...");
    if (paramEIPCResult == null) {
      return;
    }
    Object localObject1 = paramEIPCResult.data;
    if (localObject1 == null)
    {
      LogUtility.c("DownloaderGetCodeClient", "EIPCResultCallback onCallback data is null...");
      return;
    }
    paramEIPCResult = ((Bundle)localObject1).getString("PackageName");
    int i = ((Bundle)localObject1).getInt("VersionCode");
    DownloaderGetCodeClient.a(this.a).put(DownloaderGetCodeClient.a(this.a, paramEIPCResult, i), Boolean.valueOf(false));
    String str1 = ((Bundle)localObject1).getString("Code");
    boolean bool = ((Bundle)localObject1).getBoolean("IsSuccess");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("EIPCResultCallback onCallback pkgName|");
    ((StringBuilder)localObject1).append(paramEIPCResult);
    ((StringBuilder)localObject1).append(" versionCode|");
    ((StringBuilder)localObject1).append(i);
    ((StringBuilder)localObject1).append(" isSuc|");
    ((StringBuilder)localObject1).append(bool);
    ((StringBuilder)localObject1).append(" code|");
    ((StringBuilder)localObject1).append(str1);
    LogUtility.c("DownloaderGetCodeClient", ((StringBuilder)localObject1).toString());
    try
    {
      localObject1 = DownloaderGetCodeClient.a(this.a, paramEIPCResult, i);
      String str2 = (String)DownloaderGetCodeClient.c(this.a).get(localObject1);
      Object localObject2 = (List)DownloaderGetCodeClient.d(this.a).get(localObject1);
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ApkGetCodeListener localApkGetCodeListener = (ApkGetCodeListener)((Iterator)localObject2).next();
          if (localApkGetCodeListener != null)
          {
            Bundle localBundle = new Bundle();
            if (TextUtils.isEmpty(str2))
            {
              localApkGetCodeListener.a(paramEIPCResult, i, str1, bool, localBundle);
            }
            else
            {
              localBundle.putString(DownloadConstants.a, str2);
              localApkGetCodeListener.a(paramEIPCResult, i, str1, bool, localBundle);
            }
          }
        }
        DownloaderGetCodeClient.d(this.a).remove(localObject1);
      }
      else
      {
        LogUtility.c("DownloaderGetCodeClient", "EIPCResultCallback onCallback getCodeListener is null");
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramEIPCResult;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloaderGetCodeClient.2
 * JD-Core Version:    0.7.0.1
 */