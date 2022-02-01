package com.tencent.mobileqq.qwallet.preload.impl;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.QWalletIPCConnector;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.DownloadCallback;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathsListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.qwallet.preload.ResourceInfo;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.LinkedList;
import java.util.List;
import mqq.app.AppRuntime;

public class PreloadServiceProxyImpl
  extends PreloadManagerAbs
  implements IPreloadServiceProxy
{
  private static final String TAG = "PreloadServiceProxy";
  
  private void download(String paramString1, Bundle paramBundle, IPreloadService.DownloadCallback paramDownloadCallback, String paramString2)
  {
    paramBundle.putParcelable("receiver", PreloadStaticApi.a(new PreloadServiceProxyImpl.1(this, null, paramDownloadCallback, paramString2)));
    if (paramString1.equals("downloadModule")) {
      QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "downloadModule", paramBundle, null);
    }
    while (!paramString1.equals("downloadRes")) {
      return;
    }
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "downloadRes", paramBundle, null);
  }
  
  @Deprecated
  public void downloadModule(String paramString1, String paramString2, IPreloadService.DownloadCallback paramDownloadCallback)
  {
    if (!(this.mApp instanceof QQAppInterface))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("id", paramString1);
      localBundle.putString("config_str", paramString2);
      download("downloadModule", localBundle, paramDownloadCallback, paramString1);
    }
  }
  
  @Deprecated
  public void downloadRes(String paramString1, String paramString2, IPreloadService.DownloadCallback paramDownloadCallback)
  {
    if (!(this.mApp instanceof QQAppInterface))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("id", paramString1);
      localBundle.putString("config_str", paramString2);
      download("downloadRes", localBundle, paramDownloadCallback, null);
    }
  }
  
  public void downloadUrls(List<String> paramList, IPreloadService.OnGetPathListener paramOnGetPathListener)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("method_type", 2);
    localBundle.putStringArray("url", (String[])paramList.toArray(new String[paramList.size()]));
    localBundle.putParcelable("receiver", PreloadStaticApi.a(new PreloadServiceProxyImpl.5(this, null, paramOnGetPathListener)));
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "preloadCommon", localBundle, null);
  }
  
  public void getFilePathByResID(String paramString, ResultReceiver paramResultReceiver)
  {
    if (paramResultReceiver == null) {
      return;
    }
    if (!(this.mApp instanceof QQAppInterface))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("id", paramString);
      QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "getFilePathByResID", localBundle, new PreloadServiceProxyImpl.2(this, paramResultReceiver));
      return;
    }
    paramResultReceiver.send(0, new Bundle());
  }
  
  public ResourceInfo getResInfoByResId(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!(this.mApp instanceof QQAppInterface))
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("res_id", paramString);
      QWalletIPCConnector.a().a();
      paramString = QIPCClientHelper.getInstance().getClient().callServer("QWalletIPCModule", "getResInfoByResID", (Bundle)localObject1);
      localObject1 = localObject2;
      if (paramString != null)
      {
        localObject1 = localObject2;
        if (paramString.isSuccess()) {
          localObject1 = (ResourceInfo)paramString.data.getSerializable("res_info");
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PreloadServiceProxy", 2, "getResInfoByResID:" + localObject1);
    }
    return localObject1;
  }
  
  public void getResPath(DownloadParam paramDownloadParam, IPreloadService.OnGetPathListener paramOnGetPathListener)
  {
    if ((paramDownloadParam == null) || (TextUtils.isEmpty(paramDownloadParam.url))) {}
    do
    {
      return;
      if (!(this.mApp instanceof QQAppInterface))
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("method_type", 1);
        localBundle.putSerializable("download_params", paramDownloadParam);
        QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "preloadCommon", localBundle, new PreloadServiceProxyImpl.3(this, paramOnGetPathListener, paramDownloadParam));
        return;
      }
    } while (paramOnGetPathListener == null);
    paramOnGetPathListener.onResult(1, IPreloadService.PathResult.getFailRes(paramDownloadParam.url));
  }
  
  public void getResPath(LinkedList<DownloadParam> paramLinkedList, IPreloadService.OnGetPathsListener paramOnGetPathsListener)
  {
    if (paramLinkedList == null) {
      if (paramOnGetPathsListener != null) {
        paramOnGetPathsListener.a(1, null);
      }
    }
    do
    {
      return;
      if (!(this.mApp instanceof QQAppInterface))
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("method_type", 3);
        localBundle.putSerializable("download_params", paramLinkedList);
        QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "preloadCommon", localBundle, new PreloadServiceProxyImpl.4(this, paramOnGetPathsListener));
        return;
      }
    } while (paramOnGetPathsListener == null);
    paramOnGetPathsListener.a(1, null);
  }
  
  public PreloadResourceImpl getResourceByResID(String paramString)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((this.mApp instanceof QQAppInterface)) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadServiceProxy", 2, "getResourceByResID:" + paramString + "|" + localObject1);
      }
      return localObject1;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("res_id", paramString);
      QWalletIPCConnector.a().a();
      EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("QWalletIPCModule", "getResourceByResID", (Bundle)localObject1);
      localObject1 = localObject2;
      if (localEIPCResult != null)
      {
        localObject1 = localObject2;
        if (localEIPCResult.isSuccess()) {
          localObject1 = (PreloadResourceImpl)localEIPCResult.data.getSerializable("res_info");
        }
      }
    }
  }
  
  public String getVideoResPathByID(String paramString)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((this.mApp instanceof QQAppInterface)) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadServiceProxy", 2, "getVideoResPathByID:" + paramString + "|" + (String)localObject1);
      }
      return localObject1;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("mid", paramString);
      QWalletIPCConnector.a().a();
      EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("QWalletIPCModule", "getVideoResPathByMID", (Bundle)localObject1);
      localObject1 = localObject2;
      if (localEIPCResult != null)
      {
        localObject1 = localObject2;
        if (localEIPCResult.isSuccess()) {
          localObject1 = localEIPCResult.data.getString("path");
        }
      }
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    super.onCreate(paramAppRuntime);
    QWalletIPCConnector.a().a();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceProxyImpl
 * JD-Core Version:    0.7.0.1
 */