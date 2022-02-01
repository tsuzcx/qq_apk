package com.tencent.open.wadl;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.gamecenter.wadl.biz.entity.WadlCommConfig;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.gamecenter.wadl.util.WLog;
import com.tencent.mobileqq.gamecenter.data.PadFaceAd;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePadFaceFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.open.business.base.IJsCallBack;
import com.tencent.open.business.base.JsCallbackManager;
import com.tencent.open.downloadnew.UpdateManager;
import com.tencent.open.downloadnew.UpdateManager.OnCheckUpdateListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.Pair;
import cooperation.wadl.ipc.WadlProxyServiceUtil;
import cooperation.wadl.ipc.WadlProxyServiceWrap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WadlJsBridge
  extends BaseInterface
  implements IJsCallBack
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private UpdateManager.OnCheckUpdateListener jdField_a_of_type_ComTencentOpenDownloadnewUpdateManager$OnCheckUpdateListener;
  private WadlJsBridgeCallBack jdField_a_of_type_ComTencentOpenWadlWadlJsBridgeCallBack;
  private WadlJsBridgeResCallback jdField_a_of_type_ComTencentOpenWadlWadlJsBridgeResCallback;
  private WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  private String jdField_a_of_type_JavaLangString = "";
  private WeakReference<Activity> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public WadlJsBridge(Activity paramActivity, WebView paramWebView)
  {
    this(paramActivity, paramWebView, null);
    this.jdField_a_of_type_ComTencentOpenWadlWadlJsBridgeResCallback = new WadlJsBridgeResCallback(this);
    WadlProxyServiceUtil.a().a(this.jdField_a_of_type_ComTencentOpenWadlWadlJsBridgeResCallback);
  }
  
  public WadlJsBridge(Activity paramActivity, WebView paramWebView, WadlJsBridgeCallBack paramWadlJsBridgeCallBack)
  {
    WLog.c("WadlJsBridge", "wadlJsBridge init");
    if (paramActivity != null) {}
    for (WeakReference localWeakReference = new WeakReference(paramActivity);; localWeakReference = null)
    {
      this.jdField_a_of_type_MqqUtilWeakReference = localWeakReference;
      this.jdField_a_of_type_ComTencentSmttSdkWebView = paramWebView;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
      if ((paramActivity != null) && (paramWebView != null))
      {
        JsCallbackManager.a().a(this);
        this.jdField_a_of_type_Boolean = true;
      }
      WLog.c("WadlJsBridge", "wadlJsBridge init needJSCallBack=" + this.jdField_a_of_type_Boolean);
      paramActivity = paramWadlJsBridgeCallBack;
      if (paramWadlJsBridgeCallBack == null) {
        paramActivity = new WadlJsBridgeCallBack(this.jdField_a_of_type_Boolean, this);
      }
      this.jdField_a_of_type_ComTencentOpenWadlWadlJsBridgeCallBack = paramActivity;
      WadlProxyServiceUtil.a().a(this.jdField_a_of_type_ComTencentOpenWadlWadlJsBridgeCallBack);
      ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).addListener(this.jdField_a_of_type_ComTencentOpenWadlWadlJsBridgeCallBack);
      return;
    }
  }
  
  public void checkUpdate(String paramString)
  {
    WLog.c("WadlJsBridge", "checkUpdate params=" + paramString);
    checkUpdate(paramString, "");
  }
  
  public void checkUpdate(String paramString1, String paramString2)
  {
    WLog.c("WadlJsBridge", "checkUpdate params=" + paramString1 + ",guid=" + paramString2);
    if (!hasRight()) {
      return;
    }
    try
    {
      Object localObject = new JSONObject(paramString1);
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = ((JSONObject)localObject).optString("guid");
      }
      paramString2 = new ArrayList();
      localObject = ((JSONObject)localObject).optJSONArray("packageNames");
      if (localObject != null)
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          paramString2.add(((JSONArray)localObject).getString(i));
          i += 1;
        }
      }
      if (this.jdField_a_of_type_ComTencentOpenDownloadnewUpdateManager$OnCheckUpdateListener == null)
      {
        this.jdField_a_of_type_ComTencentOpenDownloadnewUpdateManager$OnCheckUpdateListener = new WadlJsBridge.JsCheckUpdateCallback(this, paramString1);
        UpdateManager.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewUpdateManager$OnCheckUpdateListener);
      }
      UpdateManager.a().a(paramString2);
      return;
    }
    catch (JSONException paramString1)
    {
      WLog.a("WadlJsBridge", "httpRequest JSONException", paramString1);
    }
  }
  
  public void clearFirstRimeEntryFlag()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("wadl_jstask_file", 0).edit();
    localEditor.putBoolean("firstTime", false);
    localEditor.commit();
  }
  
  public void delDelayDownloadTasks(String paramString)
  {
    WLog.c("WadlJsBridge", "enter delDelayDownloadTasks()");
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("tasks");
      int i = 0;
      while (i < paramString.length())
      {
        GameCenterUtils.a(paramString.get(i).toString(), "DELAY_LIST");
        i += 1;
      }
      jsCallBack("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.delDelayDownloadTasks',{\"result\" : 0 });}void(0);");
      return;
    }
    catch (Exception paramString)
    {
      WLog.a("WadlJsBridge", "delDelayDownloadTasks>>>", paramString);
    }
  }
  
  public void deleteDownload(String paramString1, String paramString2)
  {
    WLog.c("WadlJsBridge", "deleteDownload appid=" + paramString1 + ", sendTime=" + paramString2);
    WadlProxyServiceUtil.a().c(0, paramString1);
  }
  
  public void destroy()
  {
    WLog.c("WadlJsBridge", "doOnDestroy()");
    super.doOnDestroy();
    if (this.jdField_a_of_type_Boolean)
    {
      JsCallbackManager.a().b(this);
      this.jdField_a_of_type_Boolean = false;
    }
    WadlProxyServiceUtil.a().b(this.jdField_a_of_type_ComTencentOpenWadlWadlJsBridgeCallBack);
    WadlProxyServiceUtil.a().b(this.jdField_a_of_type_ComTencentOpenWadlWadlJsBridgeResCallback);
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewUpdateManager$OnCheckUpdateListener != null)
    {
      UpdateManager.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewUpdateManager$OnCheckUpdateListener);
      this.jdField_a_of_type_ComTencentOpenDownloadnewUpdateManager$OnCheckUpdateListener = null;
    }
    ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).removeListener(this.jdField_a_of_type_ComTencentOpenWadlWadlJsBridgeCallBack);
  }
  
  public int doDownloadAction(String paramString)
  {
    WLog.c("WadlJsBridge", "doDownloadAction jsonParams=" + paramString);
    Object localObject1 = "";
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentSmttSdkWebView != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentSmttSdkWebView.getUrl();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = this.jdField_a_of_type_ComTencentSmttSdkWebView.getOriginalUrl();
      }
    }
    for (;;)
    {
      localObject2 = new WadlParams(paramString);
      ((WadlParams)localObject2).d = 0;
      if (TextUtils.isEmpty(((WadlParams)localObject2).m)) {
        ((WadlParams)localObject2).m = ((String)localObject1);
      }
      WadlProxyServiceUtil.a().a((WadlParams)localObject2);
      if ((((WadlParams)localObject2).b == 2) || (((WadlParams)localObject2).b == 12))
      {
        if (this.jdField_a_of_type_MqqUtilWeakReference == null) {
          break label212;
        }
        paramString = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
        if (paramString == null) {
          break label217;
        }
      }
      label212:
      label217:
      for (paramString = paramString.getIntent();; paramString = null)
      {
        paramString = GameCenterUtils.a(paramString);
        GameCenterUtils.a(null, "558", "205906", ((WadlParams)localObject2).jdField_a_of_type_JavaLangString, "55801", "4", "430", new String[] { String.valueOf(paramString.first), (String)paramString.second, ((WadlParams)localObject2).c, ((WadlParams)localObject2).e, localObject1 });
        return 0;
        paramString = null;
        break;
      }
    }
  }
  
  public void doGCDownloadAction(String paramString)
  {
    WLog.c("WadlJsBridge", "doGCDownloadAction jsonParams=" + paramString);
    doDownloadAction(paramString);
  }
  
  public int doResDownloadAction(String paramString)
  {
    WLog.c("WadlJsBridge", "doResDownloadAction jsonParams=" + paramString);
    Object localObject = "";
    if (this.jdField_a_of_type_ComTencentSmttSdkWebView != null)
    {
      String str = this.jdField_a_of_type_ComTencentSmttSdkWebView.getUrl();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = this.jdField_a_of_type_ComTencentSmttSdkWebView.getOriginalUrl();
      }
    }
    paramString = new WadlParams(paramString);
    paramString.d = 0;
    if (TextUtils.isEmpty(paramString.m)) {
      paramString.m = ((String)localObject);
    }
    WadlProxyServiceUtil.a().d(paramString);
    return 0;
  }
  
  public String getAppVersionCode(String paramString)
  {
    WLog.c("WadlJsBridge", "getAppVersionCode packageName=" + paramString);
    int i = GameCenterUtils.a(paramString);
    if (i == -1) {
      return "";
    }
    return String.valueOf(i);
  }
  
  public String getAppVersionName(String paramString)
  {
    WLog.c("WadlJsBridge", "getAppVersionName:" + paramString);
    paramString = GameCenterUtils.a(paramString);
    if (paramString != null) {
      return paramString.versionName + "";
    }
    return "";
  }
  
  public long getAvailableBytes()
  {
    try
    {
      long l = Utils.b();
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public void getDelayDownloadTasks()
  {
    WLog.c("WadlJsBridge", "getDelayDownloadTasks() BEGIN");
    Object localObject = GameCenterSpUtils.a("DELAY_LIST");
    JSONArray localJSONArray = new JSONArray();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\|");
      int i = 0;
      for (;;)
      {
        if (i < localObject.length)
        {
          JSONObject localJSONObject = new JSONObject();
          if (!TextUtils.isEmpty(localObject[i])) {}
          try
          {
            localJSONObject.put("appid", localObject[i]);
            localJSONArray.put(localJSONObject);
            i += 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              WLog.a("WadlJsBridge", "getDelayDownloadTasks>>>", localJSONException);
            }
          }
        }
      }
    }
    jsCallBack("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getDelayDownloadTasks',{\"result\" : 0, \"task\":" + localJSONArray.toString() + "});}void(0);");
    WLog.c("WadlJsBridge", "getDelayDownloadTasks() END");
  }
  
  public String getDownloadVersion()
  {
    WLog.c("WadlJsBridge", "enter getDownloadVersion");
    String str = String.valueOf(4);
    jsCallBack("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getDownloadVersion',{\"version\":\"" + str + "\",\"r\":\"-1\"});}void(0);");
    return str;
  }
  
  public void getInstalledAppVersionCode(String paramString1, String paramString2)
  {
    WLog.c("WadlJsBridge", "getInstalledAppVersionCode packageNameJsonStr=" + paramString1 + ",guid=" + paramString2);
    if (!hasRight()) {
      return;
    }
    str1 = paramString2;
    try
    {
      Object localObject1 = new JSONObject(paramString1);
      paramString1 = paramString2;
      str1 = paramString2;
      if (TextUtils.isEmpty(paramString2))
      {
        str1 = paramString2;
        paramString1 = ((JSONObject)localObject1).optString("guid");
      }
      str1 = paramString1;
      JSONArray localJSONArray1 = ((JSONObject)localObject1).optJSONArray("packageNames");
      str1 = paramString1;
      JSONArray localJSONArray2 = new JSONArray();
      if (localJSONArray1 != null)
      {
        int i = 0;
        for (;;)
        {
          str1 = paramString1;
          if (i >= localJSONArray1.length()) {
            break;
          }
          str1 = paramString1;
          String str3 = localJSONArray1.getString(i);
          str1 = paramString1;
          Object localObject2 = GameCenterUtils.a(str3);
          String str2 = "";
          localObject1 = "";
          paramString2 = "";
          if (localObject2 != null)
          {
            str1 = paramString1;
            str2 = String.valueOf(((PackageInfo)localObject2).versionCode);
            str1 = paramString1;
            localObject1 = ((PackageInfo)localObject2).versionName;
            str1 = paramString1;
            paramString2 = GameCenterUtils.b(GameCenterUtils.a(str3));
          }
          str1 = paramString1;
          localObject2 = new JSONObject();
          str1 = paramString1;
          ((JSONObject)localObject2).put("packageName", str3);
          str1 = paramString1;
          ((JSONObject)localObject2).put("versionCode", str2);
          str1 = paramString1;
          ((JSONObject)localObject2).put("versionName", localObject1);
          str1 = paramString1;
          ((JSONObject)localObject2).put("channel", paramString2);
          str1 = paramString1;
          localJSONArray2.put(localObject2);
          i += 1;
        }
      }
      str1 = paramString1;
      paramString1 = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getInstalledAppVersionCode',{'guid':'" + paramString1 + "','r':'0','data':'" + localJSONArray2.toString() + "'});}void(0);";
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1 = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getInstalledAppVersionCode',{\"guid\":\"" + str1 + "\",\"r\":\"-1\"});}void(0);";
      }
    }
    jsCallBack(paramString1);
  }
  
  public String getInterfaceName()
  {
    return "wadl_download";
  }
  
  public String getJsCallbackMethod()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void getQueryDownloadAction(String paramString)
  {
    for (;;)
    {
      ArrayList localArrayList;
      int i;
      try
      {
        paramString = new JSONObject(paramString).getJSONArray("infolist");
        int j = paramString.length();
        localArrayList = new ArrayList();
        i = 0;
        if (i < j)
        {
          String str = paramString.getJSONObject(i).optString("appid");
          if (TextUtils.isEmpty(str)) {
            break label99;
          }
          localArrayList.add(str);
        }
      }
      catch (Exception paramString)
      {
        WLog.a("WadlJsBridge", "query getQueryDownloadAction>>>", paramString);
        return;
      }
      if (localArrayList.size() > 0)
      {
        WadlProxyServiceUtil.a().a(localArrayList);
        return;
        label99:
        i += 1;
      }
    }
  }
  
  public void getQueryDownloadAction(String paramString1, String paramString2)
  {
    for (;;)
    {
      int i;
      try
      {
        paramString1 = new JSONArray(paramString1);
        int j = paramString1.length();
        paramString2 = new ArrayList();
        i = 0;
        if (i < j)
        {
          String str = paramString1.getJSONObject(i).optString("appid");
          if (!TextUtils.isEmpty(str)) {
            paramString2.add(str);
          }
        }
        else
        {
          if (paramString2.size() > 0) {
            WadlProxyServiceUtil.a().a(paramString2);
          }
          return;
        }
      }
      catch (JSONException paramString1)
      {
        WLog.a("WadlJsBridge", "getQueryDownloadAction exception", paramString1);
        return;
      }
      i += 1;
    }
  }
  
  public void getQueryDownloadActionByVia(String paramString)
  {
    if ("ALL_TASK_QUERY_IDENTITY".equals(paramString))
    {
      WadlProxyServiceUtil.a().a();
      return;
    }
    try
    {
      paramString = new JSONObject(paramString).getString("via");
      WadlProxyServiceUtil.a().a(paramString);
      return;
    }
    catch (Exception paramString)
    {
      WLog.a("WadlJsBridge", "query getQueryDownloadActionByVia>>>", paramString);
    }
  }
  
  public String getValidWebSsoCmds(String paramString)
  {
    paramString = (WadlCommConfig)((IQQGameConfigService)QRoute.api(IQQGameConfigService.class)).getConfig("comminfo");
    JSONArray localJSONArray;
    if (paramString != null)
    {
      paramString = paramString.a();
      if (paramString != null) {
        try
        {
          localJSONArray = new JSONArray();
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            localJSONArray.put(paramString.next());
            continue;
            paramString = "";
          }
        }
        catch (Throwable paramString)
        {
          WLog.a("WadlJsBridge", "getValidWebSsoCmds>>>", paramString);
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        WLog.c("WadlJsBridge", "getValidWebSsoCmds...cmdsJsonStr=" + paramString);
      }
      return paramString;
      paramString = null;
      break;
      paramString = localJSONArray.toString();
    }
  }
  
  public WebView getWebview()
  {
    return this.jdField_a_of_type_ComTencentSmttSdkWebView;
  }
  
  public boolean isFirstTimeEntry()
  {
    boolean bool = BaseApplicationImpl.getApplication().getSharedPreferences("wadl_jstask_file", 0).getBoolean("firstTime", true);
    WLog.c("WadlJsBridge", "firstTime entry:" + bool);
    return bool;
  }
  
  public boolean isNeedJSCallBack()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void jsCallBack(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidOsHandler.post(new WadlJsBridge.1(this, paramString));
    }
  }
  
  public void queryAllDownloadRes()
  {
    WadlProxyServiceUtil.a().b();
  }
  
  public void queryAllDownloadTask()
  {
    WadlProxyServiceUtil.a().a();
  }
  
  public void registerDownloadCallBackListener(String paramString)
  {
    WLog.c("WadlJsBridge", "enter registerDownloadCallBackListener");
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int registerResCallBack(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentOpenWadlWadlJsBridgeResCallback != null) {
      this.jdField_a_of_type_ComTencentOpenWadlWadlJsBridgeResCallback.a(paramString);
    }
    return 0;
  }
  
  public void requestWebSso(String paramString)
  {
    if (QLog.isColorLevel()) {
      WLog.c("WadlJsBridge", "requestWebSso...jsonParams=" + paramString);
    }
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.getString("webssoCmdId");
      JSONObject localJSONObject = paramString.getJSONObject("webssoReq");
      paramString = (WadlCommConfig)((IQQGameConfigService)QRoute.api(IQQGameConfigService.class)).getConfig("comminfo");
      if (paramString != null) {}
      for (paramString = paramString.a(); (TextUtils.isEmpty(str)) || (paramString == null) || (!paramString.contains(str)); paramString = GameCenterUtil.a)
      {
        jsCallBack("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.requestWebSso',{\"cmd\": " + str + ", \"webssoReq\":" + localJSONObject.toString() + ", \"ret\":-2});}void(0);");
        return;
      }
      paramString = new Bundle();
      paramString.putString("webssoReqJson", localJSONObject.toString());
      ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).requestWebSso(str, localJSONObject, paramString);
      return;
    }
    catch (Exception paramString)
    {
      WLog.a("WadlJsBridge", "requestWebSso>>>", paramString);
    }
  }
  
  public int showPadFace(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    try
    {
      PadFaceAd localPadFaceAd = new PadFaceAd(new JSONObject(paramString));
      if (this.jdField_a_of_type_MqqUtilWeakReference != null) {}
      for (paramString = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(); (localPadFaceAd.isValid()) && (paramString != null); paramString = null)
      {
        QQGamePadFaceFragment.a(paramString, localPadFaceAd);
        return 0;
      }
      return -1;
    }
    catch (JSONException paramString) {}
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.wadl.WadlJsBridge
 * JD-Core Version:    0.7.0.1
 */