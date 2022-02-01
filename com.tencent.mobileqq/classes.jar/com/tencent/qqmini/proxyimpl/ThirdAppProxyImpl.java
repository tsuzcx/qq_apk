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
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private WadlProxyServiceCallBackInterface jdField_a_of_type_ComTencentGamecenterWadlBizListenerWadlProxyServiceCallBackInterface = new ThirdAppProxyImpl.1(this);
  private HashMap<String, ThirdAppProxy.AppDownloadListener> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean = false;
  private HashMap<String, AsyncResult> b = new HashMap();
  private HashMap<String, AsyncResult> c = new HashMap();
  private HashMap<String, List<AsyncResult>> d = new HashMap();
  private HashMap<String, JSONObject> e = new HashMap();
  private HashMap<String, WadlParams> f = new HashMap();
  private HashMap<String, Integer> g = new HashMap();
  
  private WadlParams a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      WadlParams localWadlParams = new WadlParams();
      localWadlParams.l = "SmallGame";
      localWadlParams.c = "10036618";
      localWadlParams.d = 6;
      localWadlParams.jdField_e_of_type_JavaLangString = paramJSONObject.optString("android_download_url");
      localWadlParams.a = paramJSONObject.optString("appid");
      localWadlParams.jdField_e_of_type_Int = paramJSONObject.optInt("version_code");
      localWadlParams.f = paramJSONObject.optString("pkg_name");
      localWadlParams.j = paramJSONObject.optString("app_name");
      localWadlParams.k = paramJSONObject.optString("app_icon");
      localWadlParams.m = "interrupt";
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
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramAppDownloadListener);
  }
  
  public void init()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    WadlProxyServiceUtil.a().a(this.jdField_a_of_type_ComTencentGamecenterWadlBizListenerWadlProxyServiceCallBackInterface);
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
      localWadlParams1.b(2);
      localWadlParams1.b = 5;
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
          paramString.b(7);
        } else {
          paramString.b(6);
        }
        paramString.b = 2;
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
    localWadlParams.b(2);
    localWadlParams.b = 3;
    WadlProxyServiceUtil.a().a(0, paramString);
    return true;
  }
  
  public void unInit()
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap != null)
    {
      localHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashMap = null;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = null;
    WadlProxyServiceUtil.a().b(this.jdField_a_of_type_ComTencentGamecenterWadlBizListenerWadlProxyServiceCallBackInterface);
    WadlProxyServiceUtil.a().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ThirdAppProxyImpl
 * JD-Core Version:    0.7.0.1
 */