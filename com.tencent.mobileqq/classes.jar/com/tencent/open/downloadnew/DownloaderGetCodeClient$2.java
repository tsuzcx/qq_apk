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
    LogUtility.c("DownloaderGetCodeClient", "EIPCResultCallback onCallback pkgName|" + paramEIPCResult + " versionCode|" + i + " isSuc|" + bool + " code|" + str1);
    for (;;)
    {
      ApkGetCodeListener localApkGetCodeListener;
      Bundle localBundle;
      try
      {
        localObject1 = DownloaderGetCodeClient.a(this.a, paramEIPCResult, i);
        String str2 = (String)DownloaderGetCodeClient.a(this.a).get(localObject1);
        Object localObject2 = (List)DownloaderGetCodeClient.b(this.a).get(localObject1);
        if (localObject2 == null) {
          break label315;
        }
        localObject2 = ((List)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localApkGetCodeListener = (ApkGetCodeListener)((Iterator)localObject2).next();
        if (localApkGetCodeListener == null) {
          continue;
        }
        localBundle = new Bundle();
        if (TextUtils.isEmpty(str2))
        {
          localApkGetCodeListener.a(paramEIPCResult, i, str1, bool, localBundle);
          continue;
        }
        localBundle.putString(DownloadConstants.a, str2);
      }
      finally {}
      localApkGetCodeListener.a(paramEIPCResult, i, str1, bool, localBundle);
    }
    DownloaderGetCodeClient.b(this.a).remove(localObject1);
    for (;;)
    {
      return;
      label315:
      LogUtility.c("DownloaderGetCodeClient", "EIPCResultCallback onCallback getCodeListener is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloaderGetCodeClient.2
 * JD-Core Version:    0.7.0.1
 */