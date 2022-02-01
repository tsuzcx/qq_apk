package com.tencent.open.downloadnew;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.open.base.LogUtility;
import eipc.EIPCResult;
import java.util.Map;

class DownloaderGetCodeServer$1
  extends QIPCModule
{
  DownloaderGetCodeServer$1(DownloaderGetCodeServer paramDownloaderGetCodeServer, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onCall action|");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(" params|");
    ((StringBuilder)localObject1).append(paramBundle);
    ((StringBuilder)localObject1).append(" callbackId|");
    ((StringBuilder)localObject1).append(paramInt);
    LogUtility.c("DownloaderWriteCodeIPC", ((StringBuilder)localObject1).toString());
    Object localObject2 = DownloaderGetCodeServer.a(this.a);
    if (localObject2 == null)
    {
      LogUtility.c("DownloaderWriteCodeIPC", "onCall action but appInterface is null");
      return null;
    }
    if (("DownloaderWriteCodeIPC_Action__GetCode".equals(paramString)) && (paramBundle != null))
    {
      localObject1 = paramBundle.getString("PackageName");
      int i = paramBundle.getInt("VersionCode");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCall action|");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" packageName|");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(" versionCode|");
      localStringBuilder.append(i);
      LogUtility.c("DownloaderWriteCodeIPC", localStringBuilder.toString());
      if (localObject1 != null)
      {
        ((QQAppInterface)localObject2).addDefaultObservers(DownloaderGetCodeServer.b(this.a));
        paramString = (ConfigHandler)((QQAppInterface)localObject2).getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(i);
        localObject2 = ((StringBuilder)localObject2).toString();
        paramBundle.putInt("CallbackId", paramInt);
        paramBundle = new Bundle(paramBundle);
        DownloaderGetCodeServer.c(this.a).put(localObject2, paramBundle);
        paramString.a((String)localObject1, i, (String)localObject2);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloaderGetCodeServer.1
 * JD-Core Version:    0.7.0.1
 */