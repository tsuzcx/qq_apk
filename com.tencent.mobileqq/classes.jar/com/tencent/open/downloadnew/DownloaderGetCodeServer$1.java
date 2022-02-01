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
    LogUtility.c("DownloaderWriteCodeIPC", "onCall action|" + paramString + " params|" + paramBundle + " callbackId|" + paramInt);
    Object localObject = DownloaderGetCodeServer.a(this.a);
    if (localObject == null) {
      LogUtility.c("DownloaderWriteCodeIPC", "onCall action but appInterface is null");
    }
    String str;
    int i;
    do
    {
      do
      {
        return null;
      } while ((!"DownloaderWriteCodeIPC_Action__GetCode".equals(paramString)) || (paramBundle == null));
      str = paramBundle.getString("PackageName");
      i = paramBundle.getInt("VersionCode");
      LogUtility.c("DownloaderWriteCodeIPC", "onCall action|" + paramString + " packageName|" + str + " versionCode|" + i);
    } while (str == null);
    ((QQAppInterface)localObject).addDefaultObservers(DownloaderGetCodeServer.a(this.a));
    paramString = (ConfigHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
    localObject = str + "_" + i;
    paramBundle.putInt("CallbackId", paramInt);
    paramBundle = new Bundle(paramBundle);
    DownloaderGetCodeServer.a(this.a).put(localObject, paramBundle);
    paramString.a(str, i, (String)localObject);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloaderGetCodeServer.1
 * JD-Core Version:    0.7.0.1
 */