package com.tencent.open.downloadnew;

import android.os.Bundle;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.open.base.LogUtility;
import eipc.EIPCResult;
import java.util.Map;

class DownloaderGetCodeServer$GetAuthCodeObserver
  extends ConfigObserver
{
  private DownloaderGetCodeServer$GetAuthCodeObserver(DownloaderGetCodeServer paramDownloaderGetCodeServer) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("GetAuthCodeObserver onGetAuthCode isSuccess|");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" code|");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" reqId|");
    ((StringBuilder)localObject).append(paramString2);
    LogUtility.c("DownloaderWriteCodeIPC", ((StringBuilder)localObject).toString());
    if (paramString2 == null) {
      return;
    }
    localObject = (Bundle)DownloaderGetCodeServer.a(this.a).get(paramString2);
    if (localObject == null)
    {
      paramString1 = new StringBuilder();
      paramString1.append("GetAuthCodeObserver reqId|");
      paramString1.append(paramString2);
      paramString1.append("  but params context is null");
      LogUtility.c("DownloaderWriteCodeIPC", paramString1.toString());
      return;
    }
    int i = ((Bundle)localObject).getInt("CallbackId");
    paramString2 = new Bundle();
    paramString2.putString("PackageName", ((Bundle)localObject).getString("PackageName"));
    paramString2.putInt("VersionCode", ((Bundle)localObject).getInt("VersionCode"));
    if (paramBoolean)
    {
      paramString2.putBoolean("IsSuccess", true);
      paramString2.putString("Code", paramString1);
    }
    else
    {
      paramString2.putBoolean("IsSuccess", false);
    }
    paramString1 = new StringBuilder();
    paramString1.append("GetAuthCodeObserver callbackId|");
    paramString1.append(i);
    paramString1.append(" result|");
    paramString1.append(paramString2);
    LogUtility.c("DownloaderWriteCodeIPC", paramString1.toString());
    DownloaderGetCodeServer.a(this.a).callbackResult(i, EIPCResult.createSuccessResult(paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloaderGetCodeServer.GetAuthCodeObserver
 * JD-Core Version:    0.7.0.1
 */