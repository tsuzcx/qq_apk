package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import alrv;
import android.app.Activity;
import android.content.BroadcastReceiver;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.app.AuthorizeCenter.AuthorizeInfo;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.appbrand.utils.ShortcutUtils;
import com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OtherJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_ADD_SHORTCUR = "saveAppToDesktop";
  public static final String MA_PERMISSION_BROADCAST = "com.tencent.msg.permission.pushnotify";
  public static final String MINI_APP_SCAN_DATA_RESULT = "com.tencent.mobileqq.mini.out.plugins.scanResultData";
  public static final String MINI_APP_SCAN_RESULT = "com.tencent.mobileqq.mini.out.plugins.scanResultAction";
  public static final String MINI_APP_SCAN_RESULT_TYPE = "com.tencent.mobileqq.mini.out.plugins.scanResultType";
  private static final Set<String> S_EVENT_MAP = new OtherJsPlugin.1();
  private static final String TAG = OtherJsPlugin.class.getSimpleName();
  private BroadcastReceiver scanResultReceiver;
  
  private void addColorSign(boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1;
    if (isMiniGameRuntime())
    {
      localObject1 = localObject2;
      if (this.jsPluginEngine.appBrandRuntime.activity != null)
      {
        localObject1 = localObject2;
        if ((this.jsPluginEngine.appBrandRuntime.activity instanceof GameActivity)) {
          localObject1 = ((GameActivity)this.jsPluginEngine.appBrandRuntime.activity).getColorNoteController();
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        if (((alrv)localObject1).c()) {
          break label173;
        }
        if (!((alrv)localObject1).b()) {
          break label160;
        }
        if (!paramBoolean) {
          break;
        }
        AppBrandTask.runTaskOnUiThread(new OtherJsPlugin.5(this, (alrv)localObject1));
      }
      return;
      localObject1 = localObject2;
      if (this.jsPluginEngine.appBrandRuntime != null)
      {
        localObject1 = localObject2;
        if ((this.jsPluginEngine.appBrandRuntime.activity instanceof AppBrandUI)) {
          localObject1 = ((AppBrandUI)this.jsPluginEngine.appBrandRuntime.activity).getColorNoteController();
        }
      }
    }
    AppBrandTask.runTaskOnUiThread(new OtherJsPlugin.6(this, (alrv)localObject1));
    return;
    label160:
    AppBrandTask.runTaskOnUiThread(new OtherJsPlugin.7(this, (alrv)localObject1));
    return;
    label173:
    AppBrandTask.runTaskOnUiThread(new OtherJsPlugin.8(this));
  }
  
  private void callbackSettingEvent(AuthorizeCenter paramAuthorizeCenter, String paramString, JsRuntime paramJsRuntime, int paramInt)
  {
    if (paramAuthorizeCenter == null) {
      return;
    }
    Object localObject = paramAuthorizeCenter.getAuthorizeList(6);
    JSONArray localJSONArray;
    for (;;)
    {
      try
      {
        paramAuthorizeCenter = new JSONObject();
        localJSONArray = new JSONArray();
        localObject = ((List)localObject).iterator();
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        AuthorizeCenter.AuthorizeInfo localAuthorizeInfo = (AuthorizeCenter.AuthorizeInfo)((Iterator)localObject).next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("scope", localAuthorizeInfo.scopeName);
        int i;
        if (localAuthorizeInfo.authFlag == 2)
        {
          i = 1;
          localJSONObject.put("state", i);
          localJSONArray.put(localJSONObject);
        }
        else
        {
          i = 0;
        }
      }
      catch (JSONException paramAuthorizeCenter)
      {
        QLog.e(TAG, 1, paramString + " error.", paramAuthorizeCenter);
        this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString, null, paramInt);
        return;
      }
    }
    paramAuthorizeCenter.put("authSetting", localJSONArray);
    this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString, paramAuthorizeCenter, paramInt);
  }
  
  private void callbackSettingEvent(String paramString, JsRuntime paramJsRuntime, int paramInt)
  {
    callbackSettingEvent(AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getAuthorizeCenter(this.jsPluginEngine.appBrandRuntime.appId), paramString, paramJsRuntime, paramInt);
  }
  
  /* Error */
  private void enterQRCode(com.tencent.mobileqq.app.BaseActivity paramBaseActivity, String paramString, JsRuntime paramJsRuntime, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_1
    //   4: invokestatic 239	ahbv:a	(Lcom/tencent/mobileqq/app/BaseActivity;)Z
    //   7: ifne +19 -> 26
    //   10: aload_0
    //   11: getfield 79	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/OtherJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   14: aload_3
    //   15: ldc 241
    //   17: aconst_null
    //   18: ldc 243
    //   20: iload 4
    //   22: invokevirtual 246	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;I)V
    //   25: return
    //   26: new 248	java/util/ArrayList
    //   29: dup
    //   30: invokespecial 249	java/util/ArrayList:<init>	()V
    //   33: pop
    //   34: aload_2
    //   35: invokestatic 255	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   38: ifne +204 -> 242
    //   41: new 139	org/json/JSONObject
    //   44: dup
    //   45: aload_2
    //   46: invokespecial 258	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   49: astore_2
    //   50: aload_2
    //   51: ifnull +13 -> 64
    //   54: aload_2
    //   55: ldc_w 260
    //   58: iconst_0
    //   59: invokevirtual 264	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   62: istore 5
    //   64: new 266	android/content/Intent
    //   67: dup
    //   68: aload_1
    //   69: ldc_w 268
    //   72: invokespecial 271	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   75: astore_2
    //   76: aload_2
    //   77: ldc_w 273
    //   80: aload_1
    //   81: ldc_w 274
    //   84: invokevirtual 280	com/tencent/mobileqq/app/BaseActivity:getString	(I)Ljava/lang/String;
    //   87: invokevirtual 284	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   90: pop
    //   91: aload_2
    //   92: ldc_w 286
    //   95: aload_1
    //   96: ldc_w 274
    //   99: invokevirtual 280	com/tencent/mobileqq/app/BaseActivity:getString	(I)Ljava/lang/String;
    //   102: invokevirtual 284	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   105: pop
    //   106: aload_2
    //   107: ldc_w 288
    //   110: invokestatic 294	java/lang/System:currentTimeMillis	()J
    //   113: invokevirtual 297	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   116: pop
    //   117: aload_2
    //   118: ldc_w 299
    //   121: ldc_w 301
    //   124: invokevirtual 284	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   127: pop
    //   128: iload 5
    //   130: ifeq +12 -> 142
    //   133: aload_2
    //   134: ldc_w 303
    //   137: iconst_1
    //   138: invokevirtual 306	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   141: pop
    //   142: aload_2
    //   143: ldc_w 307
    //   146: invokevirtual 311	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   149: pop
    //   150: aload_0
    //   151: getfield 67	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/OtherJsPlugin:scanResultReceiver	Landroid/content/BroadcastReceiver;
    //   154: ifnull +16 -> 170
    //   157: aload_1
    //   158: aload_0
    //   159: getfield 67	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/OtherJsPlugin:scanResultReceiver	Landroid/content/BroadcastReceiver;
    //   162: invokevirtual 315	com/tencent/mobileqq/app/BaseActivity:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   165: aload_0
    //   166: aconst_null
    //   167: putfield 67	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/OtherJsPlugin:scanResultReceiver	Landroid/content/BroadcastReceiver;
    //   170: aload_0
    //   171: new 317	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/OtherJsPlugin$9
    //   174: dup
    //   175: aload_0
    //   176: aload_3
    //   177: iload 4
    //   179: invokespecial 320	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/OtherJsPlugin$9:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/OtherJsPlugin;Lcom/tencent/mobileqq/mini/webview/JsRuntime;I)V
    //   182: putfield 67	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/OtherJsPlugin:scanResultReceiver	Landroid/content/BroadcastReceiver;
    //   185: new 322	android/content/IntentFilter
    //   188: dup
    //   189: ldc 17
    //   191: invokespecial 323	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   194: astore_3
    //   195: aload_1
    //   196: aload_0
    //   197: getfield 67	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/OtherJsPlugin:scanResultReceiver	Landroid/content/BroadcastReceiver;
    //   200: aload_3
    //   201: ldc 11
    //   203: aconst_null
    //   204: invokevirtual 327	com/tencent/mobileqq/app/BaseActivity:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   207: pop
    //   208: aload_1
    //   209: aload_2
    //   210: invokevirtual 331	com/tencent/mobileqq/app/BaseActivity:startActivity	(Landroid/content/Intent;)V
    //   213: return
    //   214: astore_2
    //   215: getstatic 36	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/OtherJsPlugin:TAG	Ljava/lang/String;
    //   218: iconst_1
    //   219: new 183	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   226: ldc_w 333
    //   229: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload_2
    //   233: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 339	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   242: aconst_null
    //   243: astore_2
    //   244: goto -194 -> 50
    //   247: astore 6
    //   249: getstatic 36	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/OtherJsPlugin:TAG	Ljava/lang/String;
    //   252: iconst_1
    //   253: new 183	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   260: ldc_w 341
    //   263: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload 6
    //   268: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokestatic 339	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   277: goto -112 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	OtherJsPlugin
    //   0	280	1	paramBaseActivity	com.tencent.mobileqq.app.BaseActivity
    //   0	280	2	paramString	String
    //   0	280	3	paramJsRuntime	JsRuntime
    //   0	280	4	paramInt	int
    //   1	128	5	bool	boolean
    //   247	20	6	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   41	50	214	java/lang/Exception
    //   157	165	247	java/lang/Exception
  }
  
  private void insertColorNote(alrv paramalrv)
  {
    if (isMiniGameRuntime()) {
      if ((this.jsPluginEngine.appBrandRuntime.activity != null) && ((this.jsPluginEngine.appBrandRuntime.activity instanceof GameActivity))) {
        ((GameActivity)this.jsPluginEngine.appBrandRuntime.activity).setColorNoteWithOutMoveTaskToBackThisTime();
      }
    }
    for (;;)
    {
      paramalrv.e();
      return;
      if ((this.jsPluginEngine.appBrandRuntime != null) && ((this.jsPluginEngine.appBrandRuntime.activity instanceof AppBrandUI))) {
        ((AppBrandUI)this.jsPluginEngine.appBrandRuntime.activity).setColorNoteWithOutMoveTaskToBackThisTime();
      }
    }
  }
  
  private void openSettingActivity(Activity paramActivity, ApkgInfo paramApkgInfo)
  {
    if (paramApkgInfo == null)
    {
      QLog.e(TAG, 1, "openSettingActivity, appInfo:" + paramApkgInfo);
      return;
    }
    PermissionSettingFragment.launchForResult(paramActivity, paramApkgInfo.appId, paramApkgInfo.apkgName, 5);
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d(TAG, 2, "handleNativeRequest event=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt + ",webview=" + paramJsRuntime);
    if ("saveAppToDesktop".equals(paramString1)) {}
    for (;;)
    {
      try
      {
        ShortcutUtils.addShortcut(this.jsPluginEngine.getActivityContext(), this.jsPluginEngine.appBrandRuntime.getApkgInfo(), new OtherJsPlugin.2(this, paramString1, paramJsRuntime, paramInt));
        return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
      }
      catch (Throwable localThrowable)
      {
        QLog.e(TAG, 1, localThrowable, new Object[0]);
        paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail(paramString1, null).toString());
        continue;
      }
      if ("openSetting".equals(paramString1))
      {
        MiniAppController.getInstance().setActivityResultListener(new OtherJsPlugin.3(this, paramString1, paramJsRuntime, paramInt));
        openSettingActivity(this.jsPluginEngine.getActivityContext(), this.jsPluginEngine.appBrandRuntime.getApkgInfo());
      }
      else if ("getSetting".equals(paramString1))
      {
        AuthorizeCenter localAuthorizeCenter = AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getAuthorizeCenter(this.jsPluginEngine.appBrandRuntime.appId);
        if (localAuthorizeCenter == null)
        {
          QLog.e(TAG, 1, "getSetting, but authorizeCenter is null?!");
          return "";
        }
        if (localAuthorizeCenter.isAuthorizeSynchronized()) {
          callbackSettingEvent(localAuthorizeCenter, paramString1, paramJsRuntime, paramInt);
        } else {
          MiniAppCmdUtil.getInstance().getAuthList(null, getAppId(), new OtherJsPlugin.4(this, localAuthorizeCenter, paramString1, paramJsRuntime, paramInt));
        }
      }
      else if ("scanCode".equals(paramString1))
      {
        enterQRCode(this.jsPluginEngine.getActivityContext(), paramString2, paramJsRuntime, paramInt);
      }
      else if ("addColorSign".equals(paramString1))
      {
        this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
        addColorSign(false);
      }
      else if ("addColorSignDirectly".equals(paramString1))
      {
        this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
        addColorSign(true);
      }
    }
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.OtherJsPlugin
 * JD-Core Version:    0.7.0.1
 */