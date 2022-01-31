package com.tencent.open.wadl;

import aahi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import bdeu;
import bfmu;
import bfmv;
import bfpq;
import bfpr;
import bfrz;
import bfsb;
import bfsc;
import bfsd;
import bfse;
import bfsf;
import bkis;
import bkit;
import bkjb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.gamecenter.data.PadFaceAd;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePadFaceFragment;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WadlJsBridge
  extends BaseInterface
  implements bfmu
{
  private static WadlJsBridge jdField_a_of_type_ComTencentOpenWadlWadlJsBridge;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext = a().getApplication().getBaseContext();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bfpr jdField_a_of_type_Bfpr;
  private bfse jdField_a_of_type_Bfse;
  private bfsf jdField_a_of_type_Bfsf;
  private WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public WadlJsBridge(Activity paramActivity, WebView paramWebView)
  {
    this(paramActivity, paramWebView, null);
  }
  
  public WadlJsBridge(Activity paramActivity, WebView paramWebView, bfsf parambfsf)
  {
    bfrz.c("WadlJsBridge", "wadlJsBridge init");
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramWebView;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Bfse = new bfse();
    bkis.a();
    if ((paramActivity != null) && (paramWebView != null))
    {
      bfmv.a().a(this);
      this.jdField_a_of_type_Boolean = true;
    }
    bfrz.c("WadlJsBridge", "wadlJsBridge init needJSCallBack=" + this.jdField_a_of_type_Boolean);
    paramActivity = parambfsf;
    if (parambfsf == null) {
      paramActivity = new bfsf(this.jdField_a_of_type_Boolean, this);
    }
    this.jdField_a_of_type_Bfsf = paramActivity;
    bkis.a(this.jdField_a_of_type_Bfsf);
    bkis.a().c();
    bkjb.a().a(this.jdField_a_of_type_Bfsf);
  }
  
  private AppRuntime a()
  {
    return BaseApplicationImpl.getApplication().getRuntime();
  }
  
  public static void startDownload(String paramString, boolean paramBoolean, int paramInt)
  {
    bfrz.c("WadlJsBridge", "##@startDownload(Delay Task):" + paramString + " ," + paramBoolean + "," + paramInt + ",isWiFi=" + AppNetConnInfo.isWifiConn());
    if (jdField_a_of_type_ComTencentOpenWadlWadlJsBridge == null) {
      jdField_a_of_type_ComTencentOpenWadlWadlJsBridge = new WadlJsBridge(null, null);
    }
    jdField_a_of_type_ComTencentOpenWadlWadlJsBridge.jdField_a_of_type_Bfse.a(paramString, paramBoolean, paramInt);
  }
  
  public bfse a()
  {
    return this.jdField_a_of_type_Bfse;
  }
  
  public void checkUpdate(String paramString)
  {
    bfrz.c("WadlJsBridge", "checkUpdate params=" + paramString);
    checkUpdate(paramString, "");
  }
  
  public void checkUpdate(String paramString1, String paramString2)
  {
    bfrz.c("WadlJsBridge", "checkUpdate params=" + paramString1 + ",guid=" + paramString2);
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
      if (this.jdField_a_of_type_Bfpr == null)
      {
        this.jdField_a_of_type_Bfpr = new bfsd(this, paramString1);
        bfpq.a().a(this.jdField_a_of_type_Bfpr);
      }
      bfpq.a().a(paramString2);
      return;
    }
    catch (JSONException paramString1)
    {
      bfrz.a("WadlJsBridge", "##@httpRequest JSONException", paramString1);
    }
  }
  
  public void clearFirstRimeEntryFlag()
  {
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("wadl_jstask_file", 0).edit();
      localEditor.putBoolean("firstTime", false);
      localEditor.commit();
    }
  }
  
  public void delDelayDownloadTasks(String paramString)
  {
    bfrz.c("WadlJsBridge", "enter delDelayDownloadTasks()");
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("tasks");
      int i = 0;
      while (i < paramString.length())
      {
        aahi.b(paramString.get(i).toString(), "DELAY_LIST");
        i += 1;
      }
      jsCallBack("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.delDelayDownloadTasks',{\"result\" : 0 });}void(0);");
      return;
    }
    catch (Exception paramString)
    {
      bfrz.a("WadlJsBridge", "delDelayDownloadTasks>>>", paramString);
    }
  }
  
  public void deleteDownload(String paramString1, String paramString2)
  {
    bfrz.c("WadlJsBridge", "deleteDownload appid=" + paramString1 + ", sendTime=" + paramString2);
    this.jdField_a_of_type_Bfse.a(0, paramString1, paramString2);
  }
  
  public void destroy()
  {
    bfrz.c("WadlJsBridge", "##@doOnDestroy()");
    super.doOnDestroy();
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidAppActivity != null) {
      bfmv.a().b(this);
    }
    bkis.b(this.jdField_a_of_type_Bfsf);
    if (this.jdField_a_of_type_Bfpr != null)
    {
      bfpq.a().b(this.jdField_a_of_type_Bfpr);
      this.jdField_a_of_type_Bfpr = null;
    }
    bkjb.a().b(this.jdField_a_of_type_Bfsf);
  }
  
  public int doDownloadAction(String paramString)
  {
    bfrz.a("WadlJsBridge", 1, "receive webview js call=" + paramString);
    String str = "";
    if (this.jdField_a_of_type_ComTencentSmttSdkWebView != null) {
      str = this.jdField_a_of_type_ComTencentSmttSdkWebView.getUrl();
    }
    int i = this.jdField_a_of_type_Bfse.a(paramString, true, 0, str);
    bfrz.c("WadlJsBridge", "doDownloadAction result=" + i);
    return i;
  }
  
  public void doGCDownloadAction(String paramString)
  {
    bfrz.c("WadlJsBridge", "enter doGCDownloadAction(String pParamsJson)");
    doDownloadAction(paramString);
  }
  
  public String getAppVersionCode(String paramString)
  {
    bfrz.c("WadlJsBridge", "##@getAppVersionCode:" + paramString);
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_AndroidContentContext == null)) {
      return "";
    }
    try
    {
      paramString = this.jdField_a_of_type_AndroidContentContext.getPackageManager().getPackageInfo(paramString, 0);
      if (paramString != null)
      {
        paramString = paramString.versionCode + "";
        return paramString;
      }
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public String getAppVersionName(String paramString)
  {
    bfrz.c("WadlJsBridge", "##@getAppVersionName:" + paramString);
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_AndroidContentContext == null)) {
      return "";
    }
    try
    {
      paramString = this.jdField_a_of_type_AndroidContentContext.getPackageManager().getPackageInfo(paramString, 0);
      if (paramString != null)
      {
        paramString = paramString.versionName + "";
        return paramString;
      }
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public long getAvailableBytes()
  {
    try
    {
      long l = bdeu.b();
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public void getDelayDownloadTasks()
  {
    bfrz.c("WadlJsBridge", "##@getDelayDownloadTasks() BEGIN");
    Object localObject = aahi.a("DELAY_LIST");
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
              bfrz.a("WadlJsBridge", "getDelayDownloadTasks>>>", localJSONException);
            }
          }
        }
      }
    }
    jsCallBack("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getDelayDownloadTasks',{\"result\" : 0, \"task\":" + localJSONArray.toString() + "});}void(0);");
    bfrz.c("WadlJsBridge", "##@getDelayDownloadTasks() END");
  }
  
  public String getDownloadVersion()
  {
    bfrz.c("WadlJsBridge", "enter getDownloadVersion");
    String str = String.valueOf(4);
    getDownloadVersionJsCallBack(str);
    return str;
  }
  
  public void getDownloadVersionJsCallBack(String paramString)
  {
    jsCallBack("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getDownloadVersion',{\"version\":\"" + paramString + "\",\"r\":\"-1\"});}void(0);");
  }
  
  public void getInstalledAppVersionCode(String paramString1, String paramString2)
  {
    bfrz.c("WadlJsBridge", "##@enter getInstalledAppVersionCode(BEGIN)" + paramString1 + " : " + paramString2);
    if (!hasRight()) {
      return;
    }
    str1 = paramString2;
    try
    {
      Object localObject = new JSONObject(paramString1);
      paramString1 = paramString2;
      str1 = paramString2;
      if (TextUtils.isEmpty(paramString2))
      {
        str1 = paramString2;
        paramString1 = ((JSONObject)localObject).optString("guid");
      }
      str1 = paramString1;
      paramString2 = ((JSONObject)localObject).optJSONArray("packageNames");
      str1 = paramString1;
      localObject = new JSONArray();
      if (paramString2 != null)
      {
        int i = 0;
        for (;;)
        {
          str1 = paramString1;
          if (i >= paramString2.length()) {
            break;
          }
          str1 = paramString1;
          String str2 = paramString2.getString(i);
          str1 = paramString1;
          String str3 = getAppVersionCode(str2);
          str1 = paramString1;
          String str4 = getAppVersionName(str2);
          str1 = paramString1;
          JSONObject localJSONObject = new JSONObject();
          str1 = paramString1;
          localJSONObject.put("packageName", str2);
          str1 = paramString1;
          localJSONObject.put("versionCode", str3);
          str1 = paramString1;
          localJSONObject.put("versionName", str4);
          str1 = paramString1;
          ((JSONArray)localObject).put(localJSONObject);
          i += 1;
        }
      }
      str1 = paramString1;
      paramString1 = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getInstalledAppVersionCode',{'guid':'" + paramString1 + "','r':'0','data':'" + ((JSONArray)localObject).toString() + "'});}void(0);";
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
    this.jdField_a_of_type_Bfse.d(paramString);
  }
  
  public void getQueryDownloadAction(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Bfse.a(paramString1, paramString2);
  }
  
  public void getQueryDownloadActionByVia(String paramString)
  {
    if ("ALL_TASK_QUERY_IDENTITY".equals(paramString))
    {
      this.jdField_a_of_type_Bfse.c(paramString);
      return;
    }
    this.jdField_a_of_type_Bfse.e(paramString);
  }
  
  public String getValidWebSsoCmds(String paramString)
  {
    paramString = (bfsb)bfsc.a().a("comminfo");
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
          bfrz.a("WadlJsBridge", "getValidWebSsoCmds>>>", paramString);
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        bfrz.c("WadlJsBridge", "getValidWebSsoCmds...cmdsJsonStr=" + paramString);
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
  
  public boolean hasRight()
  {
    return super.hasRight();
  }
  
  public boolean isFirstTimeEntry()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return false;
    }
    boolean bool = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("wadl_jstask_file", 0).getBoolean("firstTime", true);
    bfrz.c("WadlJsBridge", "##@firstTime entry:" + bool);
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
  
  public void queryAllDownloadTask()
  {
    this.jdField_a_of_type_Bfse.a();
  }
  
  public boolean queryInterrupt(String paramString)
  {
    return false;
  }
  
  public void registerDownloadCallBackListener(String paramString)
  {
    bfrz.c("WadlJsBridge", "enter registerDownloadCallBackListener");
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void requestWebSso(String paramString)
  {
    if (QLog.isColorLevel()) {
      bfrz.c("WadlJsBridge", "requestWebSso...jsonParams=" + paramString);
    }
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.getString("webssoCmdId");
      JSONObject localJSONObject = paramString.getJSONObject("webssoReq");
      paramString = (bfsb)bfsc.a().a("comminfo");
      if (paramString != null) {}
      for (paramString = paramString.a(); (TextUtils.isEmpty(str)) || (paramString == null) || (!paramString.contains(str)); paramString = bkjb.a)
      {
        jsCallBack("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.requestWebSso',{\"cmd\": " + str + ", \"webssoReq\":" + localJSONObject.toString() + ", \"ret\":-2});}void(0);");
        return;
      }
      paramString = new Bundle();
      paramString.putString("webssoReqJson", localJSONObject.toString());
      bkjb.a().a(str, localJSONObject, paramString);
      return;
    }
    catch (Exception paramString)
    {
      bfrz.a("WadlJsBridge", "requestWebSso>>>", paramString);
    }
  }
  
  public int showPadFace(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return -1;
      try
      {
        paramString = new PadFaceAd(new JSONObject(paramString));
        if (paramString.isValid())
        {
          QQGamePadFaceFragment.a(this.jdField_a_of_type_AndroidAppActivity, paramString);
          return 0;
        }
      }
      catch (JSONException paramString) {}
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.wadl.WadlJsBridge
 * JD-Core Version:    0.7.0.1
 */