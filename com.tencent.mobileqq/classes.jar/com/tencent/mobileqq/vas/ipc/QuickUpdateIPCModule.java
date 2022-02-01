package com.tencent.mobileqq.vas.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.vas.aidl.IDownloadListener;
import com.tencent.mobileqq.vas.aidl.IDownloadListener.Stub;
import com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback;
import com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.QueryItemCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QuickUpdateIPCModule
  extends QIPCModule
{
  private static String ACTION_DOWNLOAD = "download";
  private static String ACTION_QUERY_VERSION = "query_version";
  private static final String BID = "bid";
  private static final String BINDER = "binder";
  public static final String NAME = "QuickUpdateIPCModule";
  private static final String PARAMS = "params";
  private static final String SCID = "scid";
  private static final String TAG = "QuickUpdateIPCModule";
  private static QuickUpdateIPCModule sInstance;
  
  public QuickUpdateIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static void download(long paramLong, String paramString, IDownloadListener paramIDownloadListener)
  {
    Bundle localBundle = new Bundle();
    if (paramIDownloadListener != null) {
      localBundle.putParcelable("binder", new BinderWarpper(paramIDownloadListener.asBinder()));
    }
    localBundle.putLong("bid", paramLong);
    localBundle.putString("scid", paramString);
    QIPCClientHelper.getInstance().callServer("QuickUpdateIPCModule", ACTION_DOWNLOAD, localBundle, null);
  }
  
  public static QuickUpdateIPCModule getInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new QuickUpdateIPCModule("QuickUpdateIPCModule");
      }
      QuickUpdateIPCModule localQuickUpdateIPCModule = sInstance;
      return localQuickUpdateIPCModule;
    }
    finally {}
  }
  
  public static void queryItemVersion(int paramInt, String paramString, boolean paramBoolean, QueryItemCallback paramQueryItemCallback)
  {
    QuickUpdateIPCModule.Params localParams = new QuickUpdateIPCModule.Params(null);
    localParams.intVal = paramInt;
    localParams.boolVal = paramBoolean;
    localParams.strVal1 = paramString;
    paramString = new Bundle();
    paramString.putSerializable("params", localParams);
    QIPCClientHelper.getInstance().callServer("QuickUpdateIPCModule", ACTION_QUERY_VERSION, paramString, new QuickUpdateIPCModule.2(paramQueryItemCallback));
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    paramBundle.setClassLoader(BinderWarpper.class.getClassLoader());
    Object localObject;
    if (ACTION_DOWNLOAD.equals(paramString))
    {
      long l = paramBundle.getLong("bid");
      localObject = paramBundle.getString("scid");
      if (paramBundle.containsKey("binder")) {
        paramString = new QuickUpdateIPCModule.RemoteListener(l, (String)localObject, IDownloadListener.Stub.asInterface(((BinderWarpper)paramBundle.getParcelable("binder")).a), null);
      } else {
        paramString = null;
      }
      paramBundle = new StringBuilder();
      paramBundle.append("download listener: ");
      paramBundle.append(paramString);
      QLog.e("QuickUpdateIPCModule", 1, paramBundle.toString());
      UpdateCallbackSelector.getCallback(l).download(l, (String)localObject, paramString, false);
      return null;
    }
    if (ACTION_QUERY_VERSION.equals(paramString))
    {
      paramString = (QuickUpdateIPCModule.Params)paramBundle.getSerializable("params");
      localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (localObject == null)
      {
        QLog.e("QuickUpdateIPCModule", 1, "onCall fail null application");
        callbackResult(paramInt, EIPCResult.createResult(-102, paramBundle));
        return null;
      }
      ((IVasQuickUpdateService)((AppRuntime)localObject).getRuntimeService(IVasQuickUpdateService.class, "")).queryItemVersion(paramString.intVal, paramString.strVal1, paramString.boolVal, false, 10000L, new QuickUpdateIPCModule.1(this, paramInt));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ipc.QuickUpdateIPCModule
 * JD-Core Version:    0.7.0.1
 */