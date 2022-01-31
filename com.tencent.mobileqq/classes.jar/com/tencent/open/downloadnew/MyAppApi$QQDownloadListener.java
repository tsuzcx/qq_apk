package com.tencent.open.downloadnew;

import aktb;
import aktc;
import com.tencent.mobileqq.app.ThreadManager;
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
    LogUtility.b("MyAppApi", "onDownloadTaskProgressChanged  receiveDataLen:" + paramLong1 + ",totalDataLen:" + paramLong2);
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    DownloadManager localDownloadManager = DownloadManager.a();
    DownloadInfo localDownloadInfo2 = localDownloadManager.a(paramTMAssistantCallYYBParamStruct.SNGAppId);
    DownloadInfo localDownloadInfo1 = localDownloadInfo2;
    if (localDownloadInfo2 == null)
    {
      localDownloadInfo1 = this.a.a(paramTMAssistantCallYYBParamStruct, null);
      localDownloadManager.e(localDownloadInfo1);
    }
    localDownloadInfo1.g = i;
    localDownloadInfo1.a(2);
    localDownloadManager.a(2, localDownloadInfo1);
    LogUtility.a("MyAppApi", "onDownloadTaskProgressChanged info state=" + localDownloadInfo1.a() + " progress=" + localDownloadInfo1.g);
  }
  
  public void onDownloadTaskStateChanged(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, int paramInt1, int paramInt2, String paramString)
  {
    this.a.b = true;
    MyAppApi.a(this.a, true);
    LogUtility.b("MyAppApi", "onDownloadTaskStateChanged");
    ThreadManager.getSubThreadHandler().post(new aktb(this, paramTMAssistantCallYYBParamStruct, paramInt1, paramInt2, paramString));
  }
  
  public void onQQDownloaderInvalid()
  {
    LogUtility.b("MyAppApi", "应用宝挂了");
    ThreadManager.getSubThreadHandler().post(new aktc(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.QQDownloadListener
 * JD-Core Version:    0.7.0.1
 */