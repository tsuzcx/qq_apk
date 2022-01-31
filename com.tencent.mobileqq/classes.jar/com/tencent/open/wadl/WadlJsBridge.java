package com.tencent.open.wadl;

import alrf;
import alrg;
import alrh;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.open.business.base.IJsCallBack;
import com.tencent.open.business.base.JsCallbackManager;
import com.tencent.open.downloadnew.UpdateManager;
import com.tencent.open.downloadnew.UpdateManager.OnCheckUpdateListener;
import com.tencent.smtt.sdk.WebView;
import cooperation.wadl.ipc.WadlProxyServiceUtil;
import cooperation.wadl.ipc.WadlProxyServiceWrap;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WadlJsBridge
  extends BaseInterface
  implements IJsCallBack
{
  private static WadlJSBridgePackageInstallReceiver jdField_a_of_type_ComTencentOpenWadlWadlJSBridgePackageInstallReceiver;
  private static WadlJsBridge jdField_a_of_type_ComTencentOpenWadlWadlJsBridge;
  private static boolean b;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext = a().getApplication().getBaseContext();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private UpdateManager.OnCheckUpdateListener jdField_a_of_type_ComTencentOpenDownloadnewUpdateManager$OnCheckUpdateListener;
  private WadlJsBridgeCall jdField_a_of_type_ComTencentOpenWadlWadlJsBridgeCall;
  private WadlJsBridgeCallBack jdField_a_of_type_ComTencentOpenWadlWadlJsBridgeCallBack;
  private WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public WadlJsBridge(Activity paramActivity, WebView paramWebView)
  {
    String str = GameCenterUtils.a(this.jdField_a_of_type_AndroidContentContext);
    WLog.b("WadlJsBridge", "wadlJsBridge init processName=" + str);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramWebView;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentOpenWadlWadlJsBridgeCall = new WadlJsBridgeCall(this.jdField_a_of_type_AndroidContentContext);
    WadlProxyServiceUtil.a(a());
    if ((paramActivity != null) && (paramWebView != null))
    {
      registerPackageInstallNotificationReceiver(this.jdField_a_of_type_AndroidContentContext, str);
      JsCallbackManager.a().a(this);
      this.jdField_a_of_type_Boolean = true;
    }
    WLog.b("WadlJsBridge", "wadlJsBridge init needJSCallBack=" + this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentOpenWadlWadlJsBridgeCallBack = new WadlJsBridgeCallBack(this.jdField_a_of_type_Boolean, this);
    WadlProxyServiceUtil.a(this.jdField_a_of_type_ComTencentOpenWadlWadlJsBridgeCallBack);
    a();
    WadlProxyServiceUtil.a().c();
  }
  
  private AppRuntime a()
  {
    return BaseApplicationImpl.getApplication().getRuntime();
  }
  
  private void a()
  {
    if (!b)
    {
      b = true;
      ThreadManager.executeOnSubThread(new alrf(this));
    }
  }
  
  private static void a(Context paramContext, BroadcastReceiver paramBroadcastReceiver)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addDataScheme("package");
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
    if (paramContext != null) {
      paramContext.registerReceiver(paramBroadcastReceiver, localIntentFilter);
    }
  }
  
  public static void registerPackageInstallNotificationReceiver(Context paramContext, String paramString)
  {
    if ((jdField_a_of_type_ComTencentOpenWadlWadlJSBridgePackageInstallReceiver == null) && (paramContext != null))
    {
      WLog.b("WadlJsBridge", "##@registerPackageInstallNotificationReceiver and processName=" + paramString);
      jdField_a_of_type_ComTencentOpenWadlWadlJSBridgePackageInstallReceiver = new WadlJSBridgePackageInstallReceiver(paramString);
      a(paramContext, jdField_a_of_type_ComTencentOpenWadlWadlJSBridgePackageInstallReceiver);
    }
  }
  
  public static void startDownload(String paramString, boolean paramBoolean, int paramInt)
  {
    WLog.b("WadlJsBridge", "##@startDownload(Delay Task):" + paramString + " ," + paramBoolean + "," + paramInt + ",isWiFi=" + AppNetConnInfo.isWifiConn());
    if (jdField_a_of_type_ComTencentOpenWadlWadlJsBridge == null) {
      jdField_a_of_type_ComTencentOpenWadlWadlJsBridge = new WadlJsBridge(null, null);
    }
    jdField_a_of_type_ComTencentOpenWadlWadlJsBridge.jdField_a_of_type_ComTencentOpenWadlWadlJsBridgeCall.a(paramString, paramBoolean, paramInt);
  }
  
  public void checkUpdate(String paramString)
  {
    WLog.b("WadlJsBridge", "checkUpdate params=" + paramString);
    checkUpdate(paramString, "");
  }
  
  public void checkUpdate(String paramString1, String paramString2)
  {
    WLog.b("WadlJsBridge", "checkUpdate params=" + paramString1 + ",guid=" + paramString2);
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
        this.jdField_a_of_type_ComTencentOpenDownloadnewUpdateManager$OnCheckUpdateListener = new alrh(this, paramString1);
        UpdateManager.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewUpdateManager$OnCheckUpdateListener);
      }
      UpdateManager.a().a(paramString2);
      return;
    }
    catch (JSONException paramString1)
    {
      WLog.a("WadlJsBridge", "##@httpRequest JSONException", paramString1);
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
    WLog.b("WadlJsBridge", "enter delDelayDownloadTasks()");
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("tasks");
      int i = 0;
      while (i < paramString.length())
      {
        GameCenterUtils.b(paramString.get(i).toString(), "DELAY_LIST");
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
    WLog.b("WadlJsBridge", "deleteDownload appid=" + paramString1 + ",sendTime=" + paramString2);
    this.jdField_a_of_type_ComTencentOpenWadlWadlJsBridgeCall.a(0, paramString1, paramString2);
  }
  
  public void destroy()
  {
    WLog.b("WadlJsBridge", "##@doOnDestroy()");
    super.doOnDestroy();
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidAppActivity != null) {
      JsCallbackManager.a().b(this);
    }
    WadlProxyServiceUtil.b(this.jdField_a_of_type_ComTencentOpenWadlWadlJsBridgeCallBack);
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewUpdateManager$OnCheckUpdateListener != null)
    {
      UpdateManager.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewUpdateManager$OnCheckUpdateListener);
      this.jdField_a_of_type_ComTencentOpenDownloadnewUpdateManager$OnCheckUpdateListener = null;
    }
  }
  
  public int doDownloadAction(String paramString)
  {
    WLog.a("WadlJsBridge", 1, "receive webview js call=" + paramString);
    String str = "";
    if (this.jdField_a_of_type_ComTencentSmttSdkWebView != null) {
      str = this.jdField_a_of_type_ComTencentSmttSdkWebView.getUrl();
    }
    int i = this.jdField_a_of_type_ComTencentOpenWadlWadlJsBridgeCall.a(paramString, true, 0, str);
    WLog.b("WadlJsBridge", "doDownloadAction result=" + i);
    return i;
  }
  
  public void doGCDownloadAction(String paramString)
  {
    WLog.b("WadlJsBridge", "enter doGCDownloadAction(String pParamsJson)");
    doDownloadAction(paramString);
  }
  
  public String getAppVersionCode(String paramString)
  {
    WLog.b("WadlJsBridge", "##@getAppVersionCode:" + paramString);
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
    WLog.b("WadlJsBridge", "##@getAppVersionName:" + paramString);
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
  
  public void getDelayDownloadTasks()
  {
    WLog.b("WadlJsBridge", "##@getDelayDownloadTasks() BEGIN");
    Object localObject = GameCenterUtils.a("DELAY_LIST");
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
    WLog.b("WadlJsBridge", "##@getDelayDownloadTasks() END");
  }
  
  public String getDownloadVersion()
  {
    WLog.b("WadlJsBridge", "enter getDownloadVersion");
    String str = String.valueOf(3);
    getDownloadVersionJsCallBack(str);
    return str;
  }
  
  public void getDownloadVersionJsCallBack(String paramString)
  {
    jsCallBack("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getDownloadVersion',{\"version\":\"" + paramString + "\",\"r\":\"-1\"});}void(0);");
  }
  
  public void getInstalledAppVersionCode(String paramString1, String paramString2)
  {
    WLog.b("WadlJsBridge", "##@enter getInstalledAppVersionCode(BEGIN)" + paramString1 + " : " + paramString2);
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
    this.jdField_a_of_type_ComTencentOpenWadlWadlJsBridgeCall.c(paramString);
  }
  
  public void getQueryDownloadAction(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentOpenWadlWadlJsBridgeCall.a(paramString1, paramString2);
  }
  
  public void getQueryDownloadActionByVia(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("ALL_TASK_QUERY_IDENTITY")))
    {
      this.jdField_a_of_type_ComTencentOpenWadlWadlJsBridgeCall.a();
      return;
    }
    this.jdField_a_of_type_ComTencentOpenWadlWadlJsBridgeCall.d(paramString);
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
    WLog.b("WadlJsBridge", "##@firstTime entry:" + bool);
    return bool;
  }
  
  public boolean isNeedJSCallBack()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void jsCallBack(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidOsHandler.post(new alrg(this, paramString));
    }
  }
  
  public void registerDownloadCallBackListener(String paramString)
  {
    WLog.b("WadlJsBridge", "enter registerDownloadCallBackListener");
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.wadl.WadlJsBridge
 * JD-Core Version:    0.7.0.1
 */