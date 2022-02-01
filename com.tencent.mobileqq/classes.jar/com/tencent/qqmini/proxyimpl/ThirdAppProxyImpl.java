package com.tencent.qqmini.proxyimpl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceWrap;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdAppProxy.AppDownloadListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

@ProxyService(proxy=ThirdAppProxy.class)
public class ThirdAppProxyImpl
  extends ThirdAppProxy
{
  private HashMap<String, ThirdAppProxy.AppDownloadListener> a;
  private HashMap<String, AsyncResult> b = new HashMap();
  private HashMap<String, AsyncResult> c = new HashMap();
  private HashMap<String, List<AsyncResult>> d = new HashMap();
  private HashMap<String, JSONObject> e = new HashMap();
  private HashMap<String, WadlParams> f = new HashMap();
  private Context g;
  private boolean h = false;
  private int i = 0;
  private HashMap<String, Integer> j = new HashMap();
  private WadlProxyServiceCallBackInterface k = new ThirdAppProxyImpl.1(this);
  
  private WadlParams a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      WadlParams localWadlParams = new WadlParams();
      localWadlParams.w = "SmallGame";
      localWadlParams.i = "10036618";
      localWadlParams.h = 6;
      localWadlParams.k = paramJSONObject.optString("android_download_url");
      localWadlParams.e = paramJSONObject.optString("appid");
      localWadlParams.l = paramJSONObject.optInt("version_code");
      localWadlParams.m = paramJSONObject.optString("pkg_name");
      localWadlParams.u = paramJSONObject.optString("app_name");
      localWadlParams.v = paramJSONObject.optString("app_icon");
      localWadlParams.x = "interrupt";
      return localWadlParams;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.i("ThirdAppProxyImpl", 1, "createWadlParams exception happend:", paramJSONObject);
    }
    return null;
  }
  
  public void a(String paramString, ThirdAppProxy.AppDownloadListener paramAppDownloadListener)
  {
    if (this.a == null) {
      this.a = new HashMap();
    }
    this.a.put(paramString, paramAppDownloadListener);
  }
  
  public void init()
  {
    if (this.h) {
      return;
    }
    this.h = true;
    this.i = 0;
    this.a = new HashMap();
    WadlProxyServiceUtil.a().a(this.k);
  }
  
  public boolean installApp(String paramString, AsyncResult paramAsyncResult)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramAsyncResult == null) {
        return false;
      }
      WadlParams localWadlParams2 = a((JSONObject)this.e.get(paramString));
      WadlParams localWadlParams1 = localWadlParams2;
      if (localWadlParams2 == null) {
        localWadlParams1 = (WadlParams)this.f.get(paramString);
      }
      if (localWadlParams1 == null)
      {
        paramAsyncResult.onReceiveResult(false, null);
        return false;
      }
      localWadlParams1.c(2);
      localWadlParams1.c = 5;
      WadlProxyServiceUtil.a().c(localWadlParams1);
      paramAsyncResult.onReceiveResult(true, null);
      return true;
    }
    return false;
  }
  
  public void queryApkDownloadInfo(String paramString, AsyncResult paramAsyncResult)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramAsyncResult == null) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramString);
      paramString = new ThirdAppProxyImpl.QueryDownloadInfoListener(this, paramString, paramAsyncResult);
      ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).addListener(paramString);
      ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).getApkDownloadInfo("10036618", localArrayList);
    }
  }
  
  public void queryDownloadTask(String paramString, AsyncResult paramAsyncResult)
  {
    if (paramAsyncResult == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      paramAsyncResult.onReceiveResult(false, null);
    }
    this.b.put(paramString, paramAsyncResult);
    paramAsyncResult = new ArrayList();
    paramAsyncResult.add(paramString);
    WadlProxyServiceUtil.a().a(paramAsyncResult);
  }
  
  public void startDownload(String paramString, JSONObject paramJSONObject, boolean paramBoolean, ThirdAppProxy.AppDownloadListener paramAppDownloadListener)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramJSONObject != null))
    {
      if (paramAppDownloadListener != null) {
        a(paramString, paramAppDownloadListener);
      }
      try
      {
        this.e.put(paramString, paramJSONObject);
        paramString = a(paramJSONObject);
        if (paramString == null) {
          return;
        }
        if (paramBoolean) {
          paramString.c(7);
        } else {
          paramString.c(6);
        }
        paramString.c = 2;
        WadlProxyServiceUtil.a().b(paramString);
        return;
      }
      catch (Exception paramString)
      {
        QLog.i("ThirdAppProxyImpl", 1, "startDownload---exception happend:", paramString);
        if (paramAppDownloadListener != null) {
          paramAppDownloadListener.onDownloadFailed(-1000, -2, "url is invalid");
        }
        return;
      }
    }
    QLog.i("ThirdAppProxyImpl", 1, "startDownload, url is empty!");
    if (paramAppDownloadListener != null) {
      paramAppDownloadListener.onDownloadFailed(-1000, -1, "url is invalid");
    }
  }
  
  public boolean stopDownloadTask(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    WadlParams localWadlParams = a((JSONObject)this.e.get(paramString));
    if (localWadlParams == null) {
      return false;
    }
    localWadlParams.c(2);
    localWadlParams.c = 3;
    WadlProxyServiceUtil.a().a(0, paramString);
    return true;
  }
  
  public void unInit()
  {
    HashMap localHashMap = this.a;
    if (localHashMap != null)
    {
      localHashMap.clear();
      this.a = null;
    }
    this.h = false;
    this.i = 0;
    this.g = null;
    WadlProxyServiceUtil.a().b(this.k);
    WadlProxyServiceUtil.a().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ThirdAppProxyImpl
 * JD-Core Version:    0.7.0.1
 */