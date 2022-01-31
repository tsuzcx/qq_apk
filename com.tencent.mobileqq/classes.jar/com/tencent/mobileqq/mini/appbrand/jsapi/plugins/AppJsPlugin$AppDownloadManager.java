package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.Context;
import android.text.TextUtils;
import bkik;
import bkit;
import bkjb;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class AppJsPlugin$AppDownloadManager
{
  public static final int DOWNLOAD_ERRCODE_URL_INVALID = -1000;
  private static final int MAX_RETRY_COUNT = 3;
  private static final String TAG = "AppJsPlugin_AppDownloadManager";
  private HashMap<String, JSONObject> mAppJsonInfo = new HashMap();
  private Context mContext;
  private HashMap<String, AppJsPlugin.IDownloadListener> mDownloadListenerMap;
  private HashMap<String, AppJsPlugin.IWaldlCallback> mInstallCallbackMap = new HashMap();
  private boolean mIsInitFlag;
  private HashMap<String, Integer> mProgressMap = new HashMap();
  private HashMap<String, AppJsPlugin.IWaldlCallback> mQueryCallbackMap = new HashMap();
  private HashMap<String, List<AppJsPlugin.IWaldlCallback>> mQueryDownloadInfoListenerMap = new HashMap();
  private int mRetryCount;
  private bkik mWadlCallback = new AppJsPlugin.AppDownloadManager.1(this);
  private HashMap<String, WadlParams> mWadlParams = new HashMap();
  private bkit mWadlProxyService;
  
  public AppJsPlugin$AppDownloadManager(AppJsPlugin paramAppJsPlugin, Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private WadlParams createWadlParams(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      WadlParams localWadlParams = new WadlParams();
      localWadlParams.m = "SmallGame";
      localWadlParams.jdField_d_of_type_JavaLangString = "10036618";
      localWadlParams.jdField_d_of_type_Int = 6;
      localWadlParams.jdField_b_of_type_JavaLangString = paramJSONObject.optString("android_download_url");
      localWadlParams.a = paramJSONObject.optString("appid");
      localWadlParams.f = paramJSONObject.optInt("version_code");
      localWadlParams.j = paramJSONObject.optString("pkg_name");
      localWadlParams.k = paramJSONObject.optString("app_name");
      localWadlParams.l = paramJSONObject.optString("app_icon");
      localWadlParams.n = "interrupt";
      return localWadlParams;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.i("AppJsPlugin_AppDownloadManager", 1, "createWadlParams exception happend:", paramJSONObject);
    }
    return null;
  }
  
  private void queryDownloadTask(String paramString, AppJsPlugin.IWaldlCallback paramIWaldlCallback)
  {
    if (paramIWaldlCallback == null) {
      return;
    }
    init();
    if ((this.mWadlProxyService == null) || (TextUtils.isEmpty(paramString))) {
      paramIWaldlCallback.onResult(false, null);
    }
    this.mQueryCallbackMap.put(paramString, paramIWaldlCallback);
    paramIWaldlCallback = new ArrayList();
    paramIWaldlCallback.add(paramString);
    this.mWadlProxyService.a(paramIWaldlCallback);
  }
  
  public void addDownloadListener(String paramString, AppJsPlugin.IDownloadListener paramIDownloadListener)
  {
    if (this.mDownloadListenerMap == null) {
      this.mDownloadListenerMap = new HashMap();
    }
    this.mDownloadListenerMap.put(paramString, paramIDownloadListener);
  }
  
  public void init()
  {
    if (this.mIsInitFlag) {
      return;
    }
    this.mIsInitFlag = true;
    this.mRetryCount = 0;
    this.mDownloadListenerMap = new HashMap();
    this.mWadlProxyService = new bkit();
    this.mWadlProxyService.a(this.mWadlCallback);
  }
  
  public boolean installApp(String paramString, AppJsPlugin.IWaldlCallback paramIWaldlCallback)
  {
    init();
    if ((this.mWadlProxyService == null) || (TextUtils.isEmpty(paramString)) || (paramIWaldlCallback == null)) {
      return false;
    }
    WadlParams localWadlParams2 = createWadlParams((JSONObject)this.mAppJsonInfo.get(paramString));
    WadlParams localWadlParams1 = localWadlParams2;
    if (localWadlParams2 == null) {
      localWadlParams1 = (WadlParams)this.mWadlParams.get(paramString);
    }
    if (localWadlParams1 == null)
    {
      paramIWaldlCallback.onResult(false, null);
      return false;
    }
    localWadlParams1.b(2);
    localWadlParams1.jdField_b_of_type_Int = 5;
    this.mWadlProxyService.b(localWadlParams1);
    paramIWaldlCallback.onResult(true, null);
    return true;
  }
  
  public void queryApkDownloadInfo(String paramString, AppJsPlugin.IWaldlCallback paramIWaldlCallback)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramIWaldlCallback == null)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    paramString = new AppJsPlugin.AppDownloadManager.QueryDownloadInfoListener(this, paramString, paramIWaldlCallback);
    bkjb.a().a(paramString);
    bkjb.a().a("10036618", localArrayList);
  }
  
  public void removeDownloadListener(String paramString)
  {
    if (this.mDownloadListenerMap != null) {
      this.mDownloadListenerMap.remove(paramString);
    }
  }
  
  public void startDownload(String paramString, JSONObject paramJSONObject, boolean paramBoolean, AppJsPlugin.IDownloadListener paramIDownloadListener)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramJSONObject == null))
    {
      QLog.i("AppJsPlugin_AppDownloadManager", 1, "startDownload, url is empty!");
      if (paramIDownloadListener != null) {
        paramIDownloadListener.onDownloadFailed(-1000, -1, "url is invalid");
      }
      return;
    }
    init();
    if (paramIDownloadListener != null) {
      addDownloadListener(paramString, paramIDownloadListener);
    }
    for (;;)
    {
      try
      {
        this.mAppJsonInfo.put(paramString, paramJSONObject);
        paramString = createWadlParams(paramJSONObject);
        if (paramString == null) {
          break;
        }
        if (!paramBoolean) {
          break label129;
        }
        paramString.b(7);
        paramString.jdField_b_of_type_Int = 2;
        this.mWadlProxyService.a(paramString);
        return;
      }
      catch (Exception paramString)
      {
        QLog.i("AppJsPlugin_AppDownloadManager", 1, "startDownload---exception happend:", paramString);
      }
      if (paramIDownloadListener == null) {
        break;
      }
      paramIDownloadListener.onDownloadFailed(-1000, -2, "url is invalid");
      return;
      label129:
      paramString.b(6);
    }
  }
  
  public boolean stopDownloadTask(String paramString)
  {
    init();
    if ((this.mWadlProxyService == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    WadlParams localWadlParams = createWadlParams((JSONObject)this.mAppJsonInfo.get(paramString));
    if (localWadlParams == null) {
      return false;
    }
    localWadlParams.b(2);
    localWadlParams.jdField_b_of_type_Int = 3;
    this.mWadlProxyService.a(6, paramString);
    return true;
  }
  
  public void unInit()
  {
    if (this.mDownloadListenerMap != null)
    {
      this.mDownloadListenerMap.clear();
      this.mDownloadListenerMap = null;
    }
    this.mIsInitFlag = false;
    this.mRetryCount = 0;
    this.mContext = null;
    if (this.mWadlProxyService != null)
    {
      this.mWadlProxyService.b(this.mWadlCallback);
      this.mWadlProxyService.d();
      this.mWadlProxyService = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AppJsPlugin.AppDownloadManager
 * JD-Core Version:    0.7.0.1
 */