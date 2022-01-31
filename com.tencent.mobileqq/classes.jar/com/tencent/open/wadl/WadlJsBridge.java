package com.tencent.open.wadl;

import aact;
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
import bdal;
import bfil;
import bfim;
import bflh;
import bfli;
import bfnq;
import bfns;
import bfnt;
import bfnu;
import bfnv;
import bfnw;
import bkel;
import bkem;
import bkeu;
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
  implements bfil
{
  private static WadlJsBridge jdField_a_of_type_ComTencentOpenWadlWadlJsBridge;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext = a().getApplication().getBaseContext();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bfli jdField_a_of_type_Bfli;
  private bfnv jdField_a_of_type_Bfnv;
  private bfnw jdField_a_of_type_Bfnw;
  private WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public WadlJsBridge(Activity paramActivity, WebView paramWebView)
  {
    this(paramActivity, paramWebView, null);
  }
  
  public WadlJsBridge(Activity paramActivity, WebView paramWebView, bfnw parambfnw)
  {
    bfnq.c("WadlJsBridge", "wadlJsBridge init");
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramWebView;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Bfnv = new bfnv();
    bkel.a();
    if ((paramActivity != null) && (paramWebView != null))
    {
      bfim.a().a(this);
      this.jdField_a_of_type_Boolean = true;
    }
    bfnq.c("WadlJsBridge", "wadlJsBridge init needJSCallBack=" + this.jdField_a_of_type_Boolean);
    paramActivity = parambfnw;
    if (parambfnw == null) {
      paramActivity = new bfnw(this.jdField_a_of_type_Boolean, this);
    }
    this.jdField_a_of_type_Bfnw = paramActivity;
    bkel.a(this.jdField_a_of_type_Bfnw);
    bkel.a().c();
    bkeu.a().a(this.jdField_a_of_type_Bfnw);
  }
  
  private AppRuntime a()
  {
    return BaseApplicationImpl.getApplication().getRuntime();
  }
  
  public static void startDownload(String paramString, boolean paramBoolean, int paramInt)
  {
    bfnq.c("WadlJsBridge", "##@startDownload(Delay Task):" + paramString + " ," + paramBoolean + "," + paramInt + ",isWiFi=" + AppNetConnInfo.isWifiConn());
    if (jdField_a_of_type_ComTencentOpenWadlWadlJsBridge == null) {
      jdField_a_of_type_ComTencentOpenWadlWadlJsBridge = new WadlJsBridge(null, null);
    }
    jdField_a_of_type_ComTencentOpenWadlWadlJsBridge.jdField_a_of_type_Bfnv.a(paramString, paramBoolean, paramInt);
  }
  
  public bfnv a()
  {
    return this.jdField_a_of_type_Bfnv;
  }
  
  public void checkUpdate(String paramString)
  {
    bfnq.c("WadlJsBridge", "checkUpdate params=" + paramString);
    checkUpdate(paramString, "");
  }
  
  public void checkUpdate(String paramString1, String paramString2)
  {
    bfnq.c("WadlJsBridge", "checkUpdate params=" + paramString1 + ",guid=" + paramString2);
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
      if (this.jdField_a_of_type_Bfli == null)
      {
        this.jdField_a_of_type_Bfli = new bfnu(this, paramString1);
        bflh.a().a(this.jdField_a_of_type_Bfli);
      }
      bflh.a().a(paramString2);
      return;
    }
    catch (JSONException paramString1)
    {
      bfnq.a("WadlJsBridge", "##@httpRequest JSONException", paramString1);
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
    bfnq.c("WadlJsBridge", "enter delDelayDownloadTasks()");
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("tasks");
      int i = 0;
      while (i < paramString.length())
      {
        aact.b(paramString.get(i).toString(), "DELAY_LIST");
        i += 1;
      }
      jsCallBack("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.delDelayDownloadTasks',{\"result\" : 0 });}void(0);");
      return;
    }
    catch (Exception paramString)
    {
      bfnq.a("WadlJsBridge", "delDelayDownloadTasks>>>", paramString);
    }
  }
  
  public void deleteDownload(String paramString1, String paramString2)
  {
    bfnq.c("WadlJsBridge", "deleteDownload appid=" + paramString1 + ", sendTime=" + paramString2);
    this.jdField_a_of_type_Bfnv.a(0, paramString1, paramString2);
  }
  
  public void destroy()
  {
    bfnq.c("WadlJsBridge", "##@doOnDestroy()");
    super.doOnDestroy();
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidAppActivity != null) {
      bfim.a().b(this);
    }
    bkel.b(this.jdField_a_of_type_Bfnw);
    if (this.jdField_a_of_type_Bfli != null)
    {
      bflh.a().b(this.jdField_a_of_type_Bfli);
      this.jdField_a_of_type_Bfli = null;
    }
    bkeu.a().b(this.jdField_a_of_type_Bfnw);
  }
  
  public int doDownloadAction(String paramString)
  {
    bfnq.a("WadlJsBridge", 1, "receive webview js call=" + paramString);
    String str = "";
    if (this.jdField_a_of_type_ComTencentSmttSdkWebView != null) {
      str = this.jdField_a_of_type_ComTencentSmttSdkWebView.getUrl();
    }
    int i = this.jdField_a_of_type_Bfnv.a(paramString, true, 0, str);
    bfnq.c("WadlJsBridge", "doDownloadAction result=" + i);
    return i;
  }
  
  public void doGCDownloadAction(String paramString)
  {
    bfnq.c("WadlJsBridge", "enter doGCDownloadAction(String pParamsJson)");
    doDownloadAction(paramString);
  }
  
  public String getAppVersionCode(String paramString)
  {
    bfnq.c("WadlJsBridge", "##@getAppVersionCode:" + paramString);
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
    bfnq.c("WadlJsBridge", "##@getAppVersionName:" + paramString);
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
      long l = bdal.b();
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public void getDelayDownloadTasks()
  {
    bfnq.c("WadlJsBridge", "##@getDelayDownloadTasks() BEGIN");
    Object localObject = aact.a("DELAY_LIST");
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
              bfnq.a("WadlJsBridge", "getDelayDownloadTasks>>>", localJSONException);
            }
          }
        }
      }
    }
    jsCallBack("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getDelayDownloadTasks',{\"result\" : 0, \"task\":" + localJSONArray.toString() + "});}void(0);");
    bfnq.c("WadlJsBridge", "##@getDelayDownloadTasks() END");
  }
  
  public String getDownloadVersion()
  {
    bfnq.c("WadlJsBridge", "enter getDownloadVersion");
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
    bfnq.c("WadlJsBridge", "##@enter getInstalledAppVersionCode(BEGIN)" + paramString1 + " : " + paramString2);
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
    this.jdField_a_of_type_Bfnv.d(paramString);
  }
  
  public void getQueryDownloadAction(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Bfnv.a(paramString1, paramString2);
  }
  
  public void getQueryDownloadActionByVia(String paramString)
  {
    if ("ALL_TASK_QUERY_IDENTITY".equals(paramString))
    {
      this.jdField_a_of_type_Bfnv.c(paramString);
      return;
    }
    this.jdField_a_of_type_Bfnv.e(paramString);
  }
  
  public String getValidWebSsoCmds(String paramString)
  {
    paramString = (bfns)bfnt.a().a("comminfo");
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
          bfnq.a("WadlJsBridge", "getValidWebSsoCmds>>>", paramString);
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        bfnq.c("WadlJsBridge", "getValidWebSsoCmds...cmdsJsonStr=" + paramString);
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
    bfnq.c("WadlJsBridge", "##@firstTime entry:" + bool);
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
    this.jdField_a_of_type_Bfnv.a();
  }
  
  public boolean queryInterrupt(String paramString)
  {
    return false;
  }
  
  public void registerDownloadCallBackListener(String paramString)
  {
    bfnq.c("WadlJsBridge", "enter registerDownloadCallBackListener");
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void requestWebSso(String paramString)
  {
    if (QLog.isColorLevel()) {
      bfnq.c("WadlJsBridge", "requestWebSso...jsonParams=" + paramString);
    }
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.getString("webssoCmdId");
      JSONObject localJSONObject = paramString.getJSONObject("webssoReq");
      paramString = (bfns)bfnt.a().a("comminfo");
      if (paramString != null) {}
      for (paramString = paramString.a(); (TextUtils.isEmpty(str)) || (paramString == null) || (!paramString.contains(str)); paramString = bkeu.a)
      {
        jsCallBack("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.requestWebSso',{\"cmd\": " + str + ", \"webssoReq\":" + localJSONObject.toString() + ", \"ret\":-2});}void(0);");
        return;
      }
      paramString = new Bundle();
      paramString.putString("webssoReqJson", localJSONObject.toString());
      bkeu.a().a(str, localJSONObject, paramString);
      return;
    }
    catch (Exception paramString)
    {
      bfnq.a("WadlJsBridge", "requestWebSso>>>", paramString);
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