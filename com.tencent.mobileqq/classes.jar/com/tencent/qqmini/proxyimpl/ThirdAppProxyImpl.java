package com.tencent.qqmini.proxyimpl;

import android.content.Context;
import android.text.TextUtils;
import bked;
import bkem;
import bkeu;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.core.proxy.ThirdAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ThirdAppProxy.AppDownloadListener;
import cooperation.wadl.ipc.WadlParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class ThirdAppProxyImpl
  extends ThirdAppProxy
{
  private static final String CHANNEL = "10036618";
  public static final int DOWNLOAD_ERRCODE_URL_INVALID = -1000;
  private static final int MAX_RETRY_COUNT = 3;
  private static final String TAG = "ThirdAppProxyImpl";
  private static final String VIA = "SmallGame";
  private HashMap<String, JSONObject> mAppJsonInfo = new HashMap();
  private Context mContext;
  private HashMap<String, ThirdAppProxy.AppDownloadListener> mDownloadListenerMap;
  private HashMap<String, AsyncResult> mInstallCallbackMap = new HashMap();
  private boolean mIsInitFlag;
  private HashMap<String, Integer> mProgressMap = new HashMap();
  private HashMap<String, AsyncResult> mQueryCallbackMap = new HashMap();
  private HashMap<String, List<AsyncResult>> mQueryDownloadInfoListenerMap = new HashMap();
  private int mRetryCount;
  private bked mWadlCallback = new ThirdAppProxyImpl.1(this);
  private HashMap<String, WadlParams> mWadlParams = new HashMap();
  private bkem mWadlProxyService;
  
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
      QLog.i("ThirdAppProxyImpl", 1, "createWadlParams exception happend:", paramJSONObject);
    }
    return null;
  }
  
  public void addDownloadListener(String paramString, ThirdAppProxy.AppDownloadListener paramAppDownloadListener)
  {
    if (this.mDownloadListenerMap == null) {
      this.mDownloadListenerMap = new HashMap();
    }
    this.mDownloadListenerMap.put(paramString, paramAppDownloadListener);
  }
  
  public void init()
  {
    if (this.mIsInitFlag) {
      return;
    }
    this.mIsInitFlag = true;
    this.mRetryCount = 0;
    this.mDownloadListenerMap = new HashMap();
    this.mWadlProxyService = new bkem();
    this.mWadlProxyService.a(this.mWadlCallback);
  }
  
  public boolean installApp(String paramString, AsyncResult paramAsyncResult)
  {
    if ((this.mWadlProxyService == null) || (TextUtils.isEmpty(paramString)) || (paramAsyncResult == null)) {
      return false;
    }
    WadlParams localWadlParams2 = createWadlParams((JSONObject)this.mAppJsonInfo.get(paramString));
    WadlParams localWadlParams1 = localWadlParams2;
    if (localWadlParams2 == null) {
      localWadlParams1 = (WadlParams)this.mWadlParams.get(paramString);
    }
    if (localWadlParams1 == null)
    {
      paramAsyncResult.onReceiveResult(false, null);
      return false;
    }
    localWadlParams1.b(2);
    localWadlParams1.jdField_b_of_type_Int = 5;
    this.mWadlProxyService.b(localWadlParams1);
    paramAsyncResult.onReceiveResult(true, null);
    return true;
  }
  
  public void queryApkDownloadInfo(String paramString, AsyncResult paramAsyncResult)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramAsyncResult == null)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    paramString = new ThirdAppProxyImpl.QueryDownloadInfoListener(this, paramString, paramAsyncResult);
    bkeu.a().a(paramString);
    bkeu.a().a("10036618", localArrayList);
  }
  
  public void queryDownloadTask(String paramString, AsyncResult paramAsyncResult)
  {
    if (paramAsyncResult == null) {
      return;
    }
    if ((this.mWadlProxyService == null) || (TextUtils.isEmpty(paramString))) {
      paramAsyncResult.onReceiveResult(false, null);
    }
    this.mQueryCallbackMap.put(paramString, paramAsyncResult);
    paramAsyncResult = new ArrayList();
    paramAsyncResult.add(paramString);
    this.mWadlProxyService.a(paramAsyncResult);
  }
  
  public void removeDownloadListener(String paramString)
  {
    if (this.mDownloadListenerMap != null) {
      this.mDownloadListenerMap.remove(paramString);
    }
  }
  
  public void startDownload(String paramString, JSONObject paramJSONObject, boolean paramBoolean, ThirdAppProxy.AppDownloadListener paramAppDownloadListener)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramJSONObject == null))
    {
      QLog.i("ThirdAppProxyImpl", 1, "startDownload, url is empty!");
      if (paramAppDownloadListener != null) {
        paramAppDownloadListener.onDownloadFailed(-1000, -1, "url is invalid");
      }
      return;
    }
    if (paramAppDownloadListener != null) {
      addDownloadListener(paramString, paramAppDownloadListener);
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
          break label124;
        }
        paramString.b(7);
        paramString.jdField_b_of_type_Int = 2;
        this.mWadlProxyService.a(paramString);
        return;
      }
      catch (Exception paramString)
      {
        QLog.i("ThirdAppProxyImpl", 1, "startDownload---exception happend:", paramString);
      }
      if (paramAppDownloadListener == null) {
        break;
      }
      paramAppDownloadListener.onDownloadFailed(-1000, -2, "url is invalid");
      return;
      label124:
      paramString.b(6);
    }
  }
  
  public boolean stopDownloadTask(String paramString)
  {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ThirdAppProxyImpl
 * JD-Core Version:    0.7.0.1
 */