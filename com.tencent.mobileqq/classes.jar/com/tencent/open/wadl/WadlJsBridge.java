package com.tencent.open.wadl;

import abet;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import bftf;
import biao;
import biap;
import bide;
import bidf;
import bifn;
import bifp;
import bifq;
import bifr;
import bifs;
import bift;
import bldt;
import bldu;
import blec;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WadlJsBridge
  extends BaseInterface
  implements biao
{
  private static WadlJsBridge jdField_a_of_type_ComTencentOpenWadlWadlJsBridge;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bidf jdField_a_of_type_Bidf;
  private bifs jdField_a_of_type_Bifs;
  private bift jdField_a_of_type_Bift;
  private WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public WadlJsBridge(Activity paramActivity, WebView paramWebView)
  {
    this(paramActivity, paramWebView, null);
  }
  
  public WadlJsBridge(Activity paramActivity, WebView paramWebView, bift parambift)
  {
    bifn.c("WadlJsBridge", "wadlJsBridge init");
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramWebView;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Bifs = new bifs(this.jdField_a_of_type_AndroidAppActivity, paramWebView);
    bldt.a();
    if ((paramActivity != null) && (paramWebView != null))
    {
      biap.a().a(this);
      this.jdField_a_of_type_Boolean = true;
    }
    bifn.c("WadlJsBridge", "wadlJsBridge init needJSCallBack=" + this.jdField_a_of_type_Boolean);
    paramActivity = parambift;
    if (parambift == null) {
      paramActivity = new bift(this.jdField_a_of_type_Boolean, this);
    }
    this.jdField_a_of_type_Bift = paramActivity;
    bldt.a(this.jdField_a_of_type_Bift);
    blec.a().a(this.jdField_a_of_type_Bift);
  }
  
  public static void startDownload(String paramString, boolean paramBoolean, int paramInt)
  {
    bifn.c("WadlJsBridge", "##@startDownload(Delay Task):" + paramString + " ," + paramBoolean + "," + paramInt + ",isWiFi=" + AppNetConnInfo.isWifiConn());
    if (jdField_a_of_type_ComTencentOpenWadlWadlJsBridge == null) {
      jdField_a_of_type_ComTencentOpenWadlWadlJsBridge = new WadlJsBridge(null, null);
    }
    jdField_a_of_type_ComTencentOpenWadlWadlJsBridge.jdField_a_of_type_Bifs.a(paramString, paramBoolean, paramInt);
  }
  
  public bifs a()
  {
    return this.jdField_a_of_type_Bifs;
  }
  
  public void checkUpdate(String paramString)
  {
    bifn.c("WadlJsBridge", "checkUpdate params=" + paramString);
    checkUpdate(paramString, "");
  }
  
  public void checkUpdate(String paramString1, String paramString2)
  {
    bifn.c("WadlJsBridge", "checkUpdate params=" + paramString1 + ",guid=" + paramString2);
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
      if (this.jdField_a_of_type_Bidf == null)
      {
        this.jdField_a_of_type_Bidf = new bifr(this, paramString1);
        bide.a().a(this.jdField_a_of_type_Bidf);
      }
      bide.a().a(paramString2);
      return;
    }
    catch (JSONException paramString1)
    {
      bifn.a("WadlJsBridge", "##@httpRequest JSONException", paramString1);
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
    bifn.c("WadlJsBridge", "enter delDelayDownloadTasks()");
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("tasks");
      int i = 0;
      while (i < paramString.length())
      {
        abet.b(paramString.get(i).toString(), "DELAY_LIST");
        i += 1;
      }
      jsCallBack("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.delDelayDownloadTasks',{\"result\" : 0 });}void(0);");
      return;
    }
    catch (Exception paramString)
    {
      bifn.a("WadlJsBridge", "delDelayDownloadTasks>>>", paramString);
    }
  }
  
  public void deleteDownload(String paramString1, String paramString2)
  {
    bifn.c("WadlJsBridge", "deleteDownload appid=" + paramString1 + ", sendTime=" + paramString2);
    bldt.a().c(0, paramString1);
  }
  
  public void destroy()
  {
    bifn.c("WadlJsBridge", "##@doOnDestroy()");
    super.doOnDestroy();
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidAppActivity != null) {
      biap.a().b(this);
    }
    bldt.b(this.jdField_a_of_type_Bift);
    if (this.jdField_a_of_type_Bidf != null)
    {
      bide.a().b(this.jdField_a_of_type_Bidf);
      this.jdField_a_of_type_Bidf = null;
    }
    blec.a().b(this.jdField_a_of_type_Bift);
  }
  
  public int doDownloadAction(String paramString)
  {
    bifn.a("WadlJsBridge", 1, "receive webview js call=" + paramString);
    String str = "";
    if (this.jdField_a_of_type_ComTencentSmttSdkWebView != null) {
      str = this.jdField_a_of_type_ComTencentSmttSdkWebView.getUrl();
    }
    int i = this.jdField_a_of_type_Bifs.a(paramString, true, 0, str);
    bifn.c("WadlJsBridge", "doDownloadAction result=" + i);
    return i;
  }
  
  public void doGCDownloadAction(String paramString)
  {
    bifn.c("WadlJsBridge", "enter doGCDownloadAction(String pParamsJson)");
    doDownloadAction(paramString);
  }
  
  public String getAppVersionCode(String paramString)
  {
    bifn.c("WadlJsBridge", "##@getAppVersionCode packageName=" + paramString);
    int i = abet.a(paramString);
    if (i == -1) {
      return "";
    }
    return String.valueOf(i);
  }
  
  public String getAppVersionName(String paramString)
  {
    bifn.c("WadlJsBridge", "##@getAppVersionName:" + paramString);
    paramString = abet.a(paramString);
    if (paramString != null) {
      return paramString.versionName + "";
    }
    return "";
  }
  
  public long getAvailableBytes()
  {
    try
    {
      long l = bftf.b();
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public void getDelayDownloadTasks()
  {
    bifn.c("WadlJsBridge", "##@getDelayDownloadTasks() BEGIN");
    Object localObject = abet.a("DELAY_LIST");
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
              bifn.a("WadlJsBridge", "getDelayDownloadTasks>>>", localJSONException);
            }
          }
        }
      }
    }
    jsCallBack("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getDelayDownloadTasks',{\"result\" : 0, \"task\":" + localJSONArray.toString() + "});}void(0);");
    bifn.c("WadlJsBridge", "##@getDelayDownloadTasks() END");
  }
  
  public String getDownloadVersion()
  {
    bifn.c("WadlJsBridge", "enter getDownloadVersion");
    String str = String.valueOf(4);
    jsCallBack("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getDownloadVersion',{\"version\":\"" + str + "\",\"r\":\"-1\"});}void(0);");
    return str;
  }
  
  public void getInstalledAppVersionCode(String paramString1, String paramString2)
  {
    bifn.c("WadlJsBridge", "getInstalledAppVersionCode packageNameJsonStr=" + paramString1 + ",guid=" + paramString2);
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
          Object localObject2 = abet.a(str3);
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
            paramString2 = abet.d(abet.c(str3));
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
        bifn.a("WadlJsBridge", "query getQueryDownloadAction>>>", paramString);
        return;
      }
      if (localArrayList.size() > 0)
      {
        bldt.a().a(localArrayList);
        return;
        label99:
        i += 1;
      }
    }
  }
  
  public void getQueryDownloadAction(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Bifs.a(paramString1, paramString2);
  }
  
  public void getQueryDownloadActionByVia(String paramString)
  {
    if ("ALL_TASK_QUERY_IDENTITY".equals(paramString))
    {
      bldt.a().a("ALL_TASK_QUERY_IDENTITY");
      return;
    }
    try
    {
      paramString = new JSONObject(paramString).getString("via");
      bldt.a().a(paramString);
      return;
    }
    catch (Exception paramString)
    {
      bifn.a("WadlJsBridge", "query getQueryDownloadActionByVia>>>", paramString);
    }
  }
  
  public String getValidWebSsoCmds(String paramString)
  {
    paramString = (bifp)bifq.a().a("comminfo");
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
          bifn.a("WadlJsBridge", "getValidWebSsoCmds>>>", paramString);
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        bifn.c("WadlJsBridge", "getValidWebSsoCmds...cmdsJsonStr=" + paramString);
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
    bifn.c("WadlJsBridge", "##@firstTime entry:" + bool);
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
    bldt.a().b();
  }
  
  public void registerDownloadCallBackListener(String paramString)
  {
    bifn.c("WadlJsBridge", "enter registerDownloadCallBackListener");
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void requestWebSso(String paramString)
  {
    if (QLog.isColorLevel()) {
      bifn.c("WadlJsBridge", "requestWebSso...jsonParams=" + paramString);
    }
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.getString("webssoCmdId");
      JSONObject localJSONObject = paramString.getJSONObject("webssoReq");
      paramString = (bifp)bifq.a().a("comminfo");
      if (paramString != null) {}
      for (paramString = paramString.a(); (TextUtils.isEmpty(str)) || (paramString == null) || (!paramString.contains(str)); paramString = blec.a)
      {
        jsCallBack("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.requestWebSso',{\"cmd\": " + str + ", \"webssoReq\":" + localJSONObject.toString() + ", \"ret\":-2});}void(0);");
        return;
      }
      paramString = new Bundle();
      paramString.putString("webssoReqJson", localJSONObject.toString());
      blec.a().a(str, localJSONObject, paramString);
      return;
    }
    catch (Exception paramString)
    {
      bifn.a("WadlJsBridge", "requestWebSso>>>", paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.wadl.WadlJsBridge
 * JD-Core Version:    0.7.0.1
 */