package com.tencent.open.downloadnew;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.base.LogUtility;
import com.tencent.tmassistantsdk.ITMAssistantCallBackListener;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import mqq.os.MqqHandler;

public class MyAppApi$QQDownloadListener
  implements ITMAssistantCallBackListener
{
  protected MyAppApi$QQDownloadListener(MyAppApi paramMyAppApi) {}
  
  public void onDownloadTaskProgressChanged(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, long paramLong1, long paramLong2)
  {
    MyAppApi.a(this.a, true);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDownloadTaskProgressChanged  receiveDataLen:");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append(",totalDataLen:");
    ((StringBuilder)localObject).append(paramLong2);
    LogUtility.b("MyAppApi", ((StringBuilder)localObject).toString());
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    DownloadManager localDownloadManager = DownloadManager.a();
    DownloadInfo localDownloadInfo = localDownloadManager.a(paramTMAssistantCallYYBParamStruct.SNGAppId);
    localObject = localDownloadInfo;
    if (localDownloadInfo == null)
    {
      localObject = this.a.a(paramTMAssistantCallYYBParamStruct, null);
      localDownloadManager.e((DownloadInfo)localObject);
    }
    ((DownloadInfo)localObject).f = i;
    ((DownloadInfo)localObject).a(2);
    localDownloadManager.a(2, (DownloadInfo)localObject);
    DownloadManagerV2.a().a(paramTMAssistantCallYYBParamStruct, i);
    paramTMAssistantCallYYBParamStruct = new StringBuilder();
    paramTMAssistantCallYYBParamStruct.append("onDownloadTaskProgressChanged info state=");
    paramTMAssistantCallYYBParamStruct.append(((DownloadInfo)localObject).a());
    paramTMAssistantCallYYBParamStruct.append(" progress=");
    paramTMAssistantCallYYBParamStruct.append(((DownloadInfo)localObject).f);
    LogUtility.a("MyAppApi", paramTMAssistantCallYYBParamStruct.toString());
  }
  
  public void onDownloadTaskStateChanged(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, int paramInt1, int paramInt2, String paramString)
  {
    MyAppApi localMyAppApi = this.a;
    localMyAppApi.b = true;
    MyAppApi.a(localMyAppApi, true);
    LogUtility.b("MyAppApi", "onDownloadTaskStateChanged");
    ThreadManager.getSubThreadHandler().post(new MyAppApi.QQDownloadListener.1(this, paramTMAssistantCallYYBParamStruct, paramInt1, paramInt2, paramString));
  }
  
  public void onQQDownloaderInvalid()
  {
    LogUtility.b("MyAppApi", HardCodeUtil.a(2131707080));
    ThreadManager.getSubThreadHandler().post(new MyAppApi.QQDownloadListener.2(this));
  }
  
  public void onServiceFree()
  {
    LogUtility.b("MyAppApi", "OnServiceFree");
    try
    {
      ((TMAssistantCallYYB_V2)this.a.a).releaseIPCConnected();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.QQDownloadListener
 * JD-Core Version:    0.7.0.1
 */