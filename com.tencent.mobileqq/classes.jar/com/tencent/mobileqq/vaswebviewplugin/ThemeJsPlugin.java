package com.tencent.mobileqq.vaswebviewplugin;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.manager.api.IThemeSwitchManager;
import com.tencent.mobileqq.vas.theme.JSONResult;
import com.tencent.mobileqq.vas.theme.ThemeIPCModule;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.vas.theme.diy.ThemeDiyModule;
import com.tencent.mobileqq.vas.theme.diy.ThemeDiyModule.ThemeDiyImpl;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ThemeJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BUSINESS_NAME = "theme";
  public static final byte REQUEST_CODE = 1;
  private static final String SAVE_DIY_THEME = "saveDiyTheme";
  public static final String TAG = "ThemeJsPlugin";
  static final int THEME_OPTION_ERROR = -1;
  static final int THEME_OPTION_FILE_LOSE_ERROR = 4;
  static final int THEME_OPTION_PKG_NOT_EXISTS = 1;
  static final int THEME_OPTION_PKG_UNZIP_ERROR = 2;
  static final int THEME_OPTION_SAVE_THEMEINFO_ERROR = 3;
  static final int THEME_OPTION_SET_SV_ERROR = 5;
  static final int THEME_OPTION_SUCCESS = 0;
  private static final String XM_3 = "Xiaomi_MI 3";
  public static String loadingThemeIdForJsCall;
  public BrowserAppInterface app;
  public Context context;
  private String currDownloadingThemeId;
  long currentTimeMillis = 0L;
  QQCustomDialog dialog;
  private ConcurrentHashMap<String, ThemeUtil.ThemeInfo> downloadThemeMap = new ConcurrentHashMap();
  String mCallbackId;
  private String mCurrentMethodName;
  Object mLock = new Object();
  ThemeDiyModule.ThemeDiyImpl mThemeDiyImpl = new ThemeJsPlugin.2(this);
  private ThemeDiyModule mThemeDiyModule;
  ThemeUtil.ThemeInfo mThemeinfo;
  HashMap<Integer, String> reportMap = new HashMap();
  View rootView;
  public QQProgressDialog themeSwitchDialog;
  
  public ThemeJsPlugin()
  {
    this.mPluginNameSpace = "theme";
  }
  
  public void diyThemeSetup(String paramString1, String paramString2, String paramString3)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", paramString1);
      boolean bool = "999".equals(paramString1);
      if ((!bool) && (!TextUtils.isEmpty(paramString2))) {
        localJSONObject.put("version", paramString2);
      } else {
        localJSONObject.put("version", "20000000");
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    setup(localJSONObject, paramString3, this.mThemeDiyModule.a(paramString1, paramString2), true);
  }
  
  protected boolean excuteEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 128L)
    {
      paramString = paramMap.get("intent");
      if ((paramString != null) && ((paramString instanceof Intent)))
      {
        paramString = ((Intent)paramString).getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        paramMap = this.mCallbackId;
        if (paramMap != null) {
          this.mThemeDiyModule.a(paramString, paramMap);
        }
      }
      return true;
    }
    if (paramLong == 8589934604L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ThemeJsPlugin", 2, "EVENT_THEME_POSTCHANGED");
      }
      onPostThemeChanged();
      return true;
    }
    if (paramLong == 8589934593L) {
      return false;
    }
    if (8589934600L == paramLong) {}
    return false;
  }
  
  protected long getPluginBusiness()
  {
    return 2147483680L;
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 128L;
  }
  
  /* Error */
  void gotoDownload(int paramInt, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: astore 8
    //   3: iload_1
    //   4: ifge +230 -> 234
    //   7: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +42 -> 52
    //   13: new 213	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   20: astore 6
    //   22: aload 6
    //   24: ldc 216
    //   26: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 6
    //   32: aload 8
    //   34: getfield 222	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   37: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: ldc 17
    //   43: iconst_2
    //   44: aload 6
    //   46: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 192	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: new 115	org/json/JSONObject
    //   55: dup
    //   56: invokespecial 116	org/json/JSONObject:<init>	()V
    //   59: astore 6
    //   61: aload 6
    //   63: ldc 231
    //   65: iconst_2
    //   66: invokevirtual 234	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   69: pop
    //   70: aload 6
    //   72: ldc 236
    //   74: ldc 238
    //   76: invokevirtual 122	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   79: pop
    //   80: aload 8
    //   82: aload 5
    //   84: iconst_1
    //   85: anewarray 126	java/lang/String
    //   88: dup
    //   89: iconst_0
    //   90: aload 6
    //   92: invokevirtual 239	org/json/JSONObject:toString	()Ljava/lang/String;
    //   95: aastore
    //   96: invokevirtual 243	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   99: getstatic 247	com/tencent/mobileqq/vas/theme/ThemeReporter:a	Ljava/lang/String;
    //   102: astore 5
    //   104: aload_0
    //   105: aconst_null
    //   106: iconst_0
    //   107: aload_2
    //   108: lconst_0
    //   109: ldc 249
    //   111: ldc 251
    //   113: ldc 253
    //   115: sipush 153
    //   118: aload 5
    //   120: bipush 10
    //   122: aload_3
    //   123: ldc 255
    //   125: invokevirtual 259	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   128: iload_1
    //   129: iconst_m1
    //   130: if_icmpne +15 -> 145
    //   133: aload_0
    //   134: getfield 222	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   137: astore_2
    //   138: aload_2
    //   139: ifnull +73 -> 212
    //   142: goto +66 -> 208
    //   145: return
    //   146: astore_2
    //   147: goto +67 -> 214
    //   150: astore_2
    //   151: goto +8 -> 159
    //   154: astore_2
    //   155: goto +59 -> 214
    //   158: astore_2
    //   159: new 213	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   166: astore_3
    //   167: aload_3
    //   168: ldc_w 261
    //   171: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_3
    //   176: aload_2
    //   177: invokevirtual 264	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   180: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: ldc 17
    //   186: iconst_2
    //   187: aload_3
    //   188: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 267	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   194: iload_1
    //   195: iconst_m1
    //   196: if_icmpne +16 -> 212
    //   199: aload_0
    //   200: getfield 222	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   203: astore_2
    //   204: aload_2
    //   205: ifnull +7 -> 212
    //   208: aload_2
    //   209: invokevirtual 272	com/tencent/mobileqq/utils/QQCustomDialog:dismiss	()V
    //   212: return
    //   213: astore_2
    //   214: iload_1
    //   215: iconst_m1
    //   216: if_icmpne +16 -> 232
    //   219: aload_0
    //   220: getfield 222	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   223: astore_3
    //   224: aload_3
    //   225: ifnull +7 -> 232
    //   228: aload_3
    //   229: invokevirtual 272	com/tencent/mobileqq/utils/QQCustomDialog:dismiss	()V
    //   232: aload_2
    //   233: athrow
    //   234: aload 8
    //   236: getfield 73	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:downloadThemeMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   239: aload_2
    //   240: invokevirtual 273	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   243: checkcast 275	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo
    //   246: astore 7
    //   248: aload 7
    //   250: astore 6
    //   252: aload 7
    //   254: ifnonnull +14 -> 268
    //   257: aload 8
    //   259: getfield 277	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:context	Landroid/content/Context;
    //   262: aload_2
    //   263: invokestatic 283	com/tencent/mobileqq/vas/theme/api/ThemeUtil:getThemeInfo	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo;
    //   266: astore 6
    //   268: aload 6
    //   270: astore 7
    //   272: aload 6
    //   274: ifnonnull +18 -> 292
    //   277: new 275	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo
    //   280: dup
    //   281: invokespecial 284	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo:<init>	()V
    //   284: astore 7
    //   286: aload 7
    //   288: aload_2
    //   289: putfield 287	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo:themeId	Ljava/lang/String;
    //   292: aload 7
    //   294: iload 4
    //   296: putfield 291	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo:isVoiceTheme	Z
    //   299: aload 8
    //   301: getfield 277	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:context	Landroid/content/Context;
    //   304: aload 7
    //   306: invokestatic 295	com/tencent/mobileqq/vas/theme/api/ThemeUtil:setThemeInfo	(Landroid/content/Context;Lcom/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo;)Ljava/lang/Boolean;
    //   309: pop
    //   310: aload 8
    //   312: getfield 73	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:downloadThemeMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   315: aload_2
    //   316: aload 7
    //   318: invokevirtual 298	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   321: pop
    //   322: aload 8
    //   324: aload_2
    //   325: putfield 105	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:currDownloadingThemeId	Ljava/lang/String;
    //   328: aload_2
    //   329: putstatic 300	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:loadingThemeIdForJsCall	Ljava/lang/String;
    //   332: aload_0
    //   333: aconst_null
    //   334: iconst_0
    //   335: aload_2
    //   336: lconst_0
    //   337: aconst_null
    //   338: aconst_null
    //   339: ldc 253
    //   341: sipush 153
    //   344: getstatic 247	com/tencent/mobileqq/vas/theme/ThemeReporter:a	Ljava/lang/String;
    //   347: bipush 11
    //   349: aload_3
    //   350: ldc 255
    //   352: invokevirtual 259	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   355: ldc2_w 301
    //   358: aload_2
    //   359: invokestatic 305	com/tencent/mobileqq/vas/theme/api/ThemeUtil:getThemeConfigID	(Ljava/lang/String;)Ljava/lang/String;
    //   362: new 307	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$8
    //   365: dup
    //   366: aload 8
    //   368: aload 5
    //   370: invokespecial 310	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$8:<init>	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;Ljava/lang/String;)V
    //   373: invokestatic 316	com/tencent/mobileqq/vas/ipc/QuickUpdateIPCModule:download	(JLjava/lang/String;Lcom/tencent/mobileqq/vas/aidl/IDownloadListener;)V
    //   376: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	377	0	this	ThemeJsPlugin
    //   0	377	1	paramInt	int
    //   0	377	2	paramString1	String
    //   0	377	3	paramString2	String
    //   0	377	4	paramBoolean	boolean
    //   0	377	5	paramString3	String
    //   20	253	6	localObject1	Object
    //   246	71	7	localObject2	Object
    //   1	366	8	localThemeJsPlugin	ThemeJsPlugin
    // Exception table:
    //   from	to	target	type
    //   104	128	146	finally
    //   104	128	150	java/lang/Exception
    //   52	104	154	finally
    //   52	104	158	java/lang/Exception
    //   159	194	213	finally
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void onCreate()
  {
    if ((this.mRuntime.a() != null) && ((this.mRuntime.a() instanceof BrowserAppInterface))) {
      this.app = ((BrowserAppInterface)this.mRuntime.a());
    }
    this.context = this.mRuntime.a().getApplicationContext();
    this.mThemeDiyModule = new ThemeDiyModule(this.context, this.app);
    this.mThemeDiyModule.a(this.mThemeDiyImpl);
    super.onCreate();
    this.rootView = this.mRuntime.a().getWindow().getDecorView().getRootView();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreate, nowThemeId=");
    localStringBuilder.append(ThemeUtil.getCurrentThemeId());
    localStringBuilder.append(", userThemeId=");
    localStringBuilder.append(ThemeUtil.getUserCurrentThemeId(this.app));
    QLog.d("ThemeJsPlugin", 1, localStringBuilder.toString());
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  @SuppressLint({"NewApi"})
  public void onPostThemeChanged()
  {
    Object localObject;
    if (QLog.isColorLevel()) {
      if (loadingThemeIdForJsCall != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ThemeDebugKeyLog:switch to themeid ");
        ((StringBuilder)localObject).append(loadingThemeIdForJsCall);
        QLog.d("ThemeJsPlugin", 2, ((StringBuilder)localObject).toString());
      }
      else
      {
        QLog.d("ThemeJsPlugin", 2, "ThemeDebugKeyLog:switch ok");
      }
    }
    if (this.rootView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeJsPlugin", 2, "titleView is null");
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Build.MANUFACTURER);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(Build.MODEL);
      localObject = ((StringBuilder)localObject).toString();
      if ((Build.VERSION.SDK_INT >= 16) && (((String)localObject).contains("Xiaomi_MI 3"))) {
        this.rootView.setLayerType(1, null);
      }
      localObject = this.themeSwitchDialog;
      if ((localObject != null) && (((QQProgressDialog)localObject).isShowing())) {
        this.themeSwitchDialog.dismiss();
      }
    }
    VasUtil.a().getThemeSwitchManager().onPostThemeChanged();
  }
  
  void onPushMsg(Bundle paramBundle)
  {
    int i = paramBundle.getInt("result");
    if (paramBundle.getInt("type") == 2)
    {
      int j = paramBundle.getInt("id");
      paramBundle = paramBundle.getString("url");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("DOWNLOAD_BACKGROUND:");
        localStringBuilder.append(j);
        localStringBuilder.append(", themeId");
        localStringBuilder.append(j);
        localStringBuilder.append(", bgPath:");
        localStringBuilder.append(paramBundle);
        QLog.i("ThemeJsPlugin", 2, localStringBuilder.toString());
      }
      if (i != 0)
      {
        callJs(this.mCallbackId, new String[] { new JSONResult(-1, "bg image download failed").a() });
        this.mCallbackId = null;
        return;
      }
      this.mThemeDiyModule.a(this.mCallbackId);
    }
  }
  
  public void onResponse(Bundle arg1)
  {
    if (??? != null)
    {
      int i = ???.getInt("respkey", 0);
      String str1 = ???.getString("cmd");
      String str2 = ???.getString("callbackid");
      Object localObject1 = ???.getBundle("response");
      if (localObject1 == null) {
        return;
      }
      if (i == this.mOnRemoteResp.key)
      {
        i = ???.getInt("failcode", 1000);
        Object localObject3;
        if ((TextUtils.isEmpty(str1)) || (QLog.isColorLevel()) || (1001 == i))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("response:");
          ((StringBuilder)localObject3).append(str1);
          ((StringBuilder)localObject3).append(", backCode=");
          ((StringBuilder)localObject3).append(i);
          ((StringBuilder)localObject3).append(", isTimeOut=");
          boolean bool;
          if (1001 == i) {
            bool = true;
          } else {
            bool = false;
          }
          ((StringBuilder)localObject3).append(bool);
          QLog.d("ThemeJsPlugin", 2, ((StringBuilder)localObject3).toString());
        }
        if (TextUtils.isEmpty(str1)) {
          return;
        }
        try
        {
          if ("stopdownload".equals(str1))
          {
            ??? = new JSONObject();
            ???.put("result", 0);
            ???.put("message", "Download process paused.");
            super.callJs(str2, new String[] { ???.toString() });
            return;
          }
          if ("weekLoopGetData".equals(str1))
          {
            ??? = new JSONObject();
            ???.put("result", 0);
            localObject3 = ((Bundle)localObject1).getString("seriesID");
            localObject1 = ((Bundle)localObject1).getString("themeArray");
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("IPC_THEME_WEEK_LOOP_GET respone seriesID:");
              localStringBuilder2.append((String)localObject3);
              localStringBuilder2.append(", themeArr:");
              localStringBuilder2.append((String)localObject1);
              QLog.d("ThemeJsPlugin", 2, localStringBuilder2.toString());
            }
            ???.put("seriesID", localObject3);
            ???.put("themeArray", localObject1);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("useSeriesID is ");
            ((StringBuilder)localObject1).append((String)localObject3);
            ???.put("message", ((StringBuilder)localObject1).toString());
            super.callJs(str2, new String[] { ???.toString() });
            return;
          }
          if ("themeQueryLocal".equals(str1))
          {
            ??? = new JSONObject();
            localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("localInfo", new JSONObject(((Bundle)localObject1).getString("themeId")));
            ((JSONObject)localObject3).put("currentId", ThemeUtil.getCurrentThemeId());
            i = ThemeUtil.getUinThemePreferences(this.app).getInt("stripUserTheme", 0);
            if (i != 0) {
              ThemeUtil.getUinThemePreferences(this.app).edit().remove("stripUserTheme").commit();
            }
            ???.put("result", 0);
            ???.put("message", "ok");
            ???.put("data", localObject3);
            ???.put("authResult", i);
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("ThemeJsHandler queryLocal ok:");
              ((StringBuilder)localObject1).append(???.toString());
              QLog.i("ThemeJsPlugin", 2, ((StringBuilder)localObject1).toString());
            }
            callJs(str2, new String[] { ???.toString() });
            return;
          }
          if ("setSVTheme".equals(str1))
          {
            localObject3 = ((Bundle)localObject1).getString("themeId");
            i = ((Bundle)localObject1).getInt("themeStatus", -1);
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("IPC_THEME_SET_SERVER respone themeId:");
              ((StringBuilder)localObject1).append((String)localObject3);
              ((StringBuilder)localObject1).append(", ret:");
              ((StringBuilder)localObject1).append(i);
              QLog.d("ThemeJsPlugin", 2, ((StringBuilder)localObject1).toString());
            }
            if (i == 0) {
              synchronized (this.mLock)
              {
                if ((!TextUtils.isEmpty(str2)) && (str2.equals(this.mCallbackId)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (this.mThemeinfo != null) && (((String)localObject3).equals(this.mThemeinfo.themeId)) && (!DarkModeManager.a(this.mRuntime.a(), (String)localObject3, new ThemeJsPlugin.10(this, (String)localObject3)))) {
                  if (!SimpleUIUtil.a())
                  {
                    this.mThemeDiyModule.a();
                    ThemeIPCModule.a((String)localObject3, new ThemeJsPlugin.ThemeSwitchListener(this, (String)localObject3, true));
                  }
                  else
                  {
                    if (!ThemeUtil.isFixTheme((String)localObject3)) {
                      ThemeSwitchUtil.a(this.app, (String)localObject3, "20000000");
                    }
                    new ThemeJsPlugin.ThemeSwitchListener(this, (String)localObject3, false).postSwitch(0);
                  }
                }
                return;
              }
            }
            if ("saveDiyTheme".equals(this.mCurrentMethodName))
            {
              super.callJs(str2, new String[] { new JSONResult(???.getInt("result_int"), HardCodeUtil.a(2131714726)).a() });
              return;
            }
            ??? = new JSONObject();
            ???.put("themeId", localObject3);
            ???.put("result", 5);
            ???.put("message", "setup theme setSV error.");
            super.callJs(str2, new String[] { ???.toString() });
            return;
          }
          super.onResponse(???);
          return;
        }
        catch (Throwable ???)
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("onResponse Throwable cmd:");
          localStringBuilder1.append(str1);
          localStringBuilder1.append(", msg：");
          localStringBuilder1.append(QLog.getStackTraceString(???));
          QLog.e("ThemeJsPlugin", 1, localStringBuilder1.toString());
          callJsOnError(str2, ???.getMessage());
        }
      }
    }
  }
  
  public void queryInfo(JSONObject paramJSONObject, String paramString, ThemeLocator paramThemeLocator)
  {
    int i;
    try
    {
      paramJSONObject = paramJSONObject.optString("id");
      bool = TextUtils.isEmpty(paramJSONObject);
      localObject1 = paramJSONObject;
      if (bool)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("queryInfo err themeId=null：");
        ((StringBuilder)localObject1).append(paramJSONObject);
        QLog.e("ThemeJsPlugin", 1, ((StringBuilder)localObject1).toString());
        localObject1 = "1000";
      }
      localObject2 = (ThemeUtil.ThemeInfo)this.downloadThemeMap.get(localObject1);
      paramJSONObject = (JSONObject)localObject2;
      if ("1000".equals(localObject1)) {
        break label702;
      }
      if (localObject2 != null) {
        break label693;
      }
      paramJSONObject = ThemeUtil.getThemeInfo(this.context, (String)localObject1);
      if ((paramThemeLocator != null) && (paramThemeLocator.a())) {
        break label702;
      }
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("queryInfo zip is missing: ");
      paramJSONObject.append(paramThemeLocator);
      QLog.e("ThemeJsPlugin", 1, paramJSONObject.toString());
      paramJSONObject = null;
      ThemeUtil.removeThemeInfo(this.context, (String)localObject1);
    }
    catch (Throwable paramJSONObject)
    {
      boolean bool;
      Object localObject1;
      StringBuilder localStringBuilder;
      long l;
      double d1;
      double d2;
      paramThemeLocator = new StringBuilder();
      paramThemeLocator.append("queryInfo Exception：");
      paramThemeLocator.append(paramJSONObject.getMessage());
      QLog.e("ThemeJsPlugin", 1, paramThemeLocator.toString());
      super.callJsOnError(paramString, paramJSONObject.getMessage());
      reportTheme(null, 0, "", 0L, null, null, "200", 152, ThemeReporter.a, -35, "1", "");
    }
    paramThemeLocator = new JSONObject();
    paramThemeLocator.put("result", 0);
    paramThemeLocator.put("message", "ok");
    Object localObject2 = new JSONObject();
    bool = "1000".equals(localObject1);
    if (bool)
    {
      ((JSONObject)localObject2).put("status", Integer.parseInt("3"));
      ((JSONObject)localObject2).put("version", 0);
      ((JSONObject)localObject2).put("progress", 100);
    }
    else if (paramJSONObject == null)
    {
      ((JSONObject)localObject2).put("status", Integer.parseInt("1"));
      ((JSONObject)localObject2).put("version", 0);
      ((JSONObject)localObject2).put("progress", 0);
    }
    else
    {
      if ("2".equals(paramJSONObject.status)) {
        if (i != 0)
        {
          if (!((String)localObject1).equals(this.currDownloadingThemeId)) {
            paramJSONObject.status = "4";
          }
        }
        else {
          paramJSONObject.status = "1";
        }
      }
      if ("5".equals(paramJSONObject.status)) {
        paramJSONObject.status = "3";
      }
      ((JSONObject)localObject2).put("status", Integer.parseInt(paramJSONObject.status));
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("queryInfo downsize:");
        localStringBuilder.append(paramJSONObject.downsize);
        localStringBuilder.append(",size:");
        localStringBuilder.append(paramJSONObject.size);
        QLog.i("ThemeJsPlugin", 2, localStringBuilder.toString());
      }
      if (paramJSONObject.size <= 0L) {
        break label708;
      }
      l = paramJSONObject.downsize;
      d1 = l;
      Double.isNaN(d1);
      l = paramJSONObject.size;
      d2 = l;
      Double.isNaN(d2);
      d1 = d1 * 1.0D / d2;
      i = (int)Math.floor(d1 * 100.0D);
    }
    for (;;)
    {
      i = Math.min(i, 100);
      ((JSONObject)localObject2).put("version", paramJSONObject.version);
      ((JSONObject)localObject2).put("progress", i);
      paramThemeLocator.put("data", localObject2);
      super.callJs(paramString, new String[] { paramThemeLocator.toString() });
      if (QLog.isColorLevel())
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("queryInfo,themeId=");
        paramJSONObject.append((String)localObject1);
        paramJSONObject.append("result=");
        paramJSONObject.append(paramThemeLocator.toString());
        QLog.i("ThemeJsPlugin", 2, paramJSONObject.toString());
        return;
      }
      return;
      label693:
      i = 1;
      paramJSONObject = (JSONObject)localObject2;
      break;
      label702:
      i = 0;
      break;
      label708:
      i = 0;
    }
  }
  
  void reportTheme(String paramString1, int paramInt1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, int paramInt3, String paramString7, String paramString8)
  {
    new Handler(Looper.getMainLooper()).postDelayed(new ThemeJsPlugin.1(this, paramString2, paramInt1, paramString1, paramLong, paramString3, paramString4, paramString5, paramInt2, paramInt3, paramString7, paramString8, paramString6), 2000L);
  }
  
  public void setup(JSONObject paramJSONObject, String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    ??? = paramString;
    Object localObject3;
    if (paramBoolean)
    {
      localObject3 = "201";
      localObject1 = ???;
    }
    label1096:
    label1148:
    for (;;)
    {
      try
      {
        str1 = paramJSONObject.optString("id");
        localObject1 = ???;
        str2 = paramJSONObject.optString("version", "0");
        localObject1 = ???;
        int i = paramJSONObject.optInt("isSound", 0);
        localObject1 = ???;
        str3 = paramJSONObject.optString("seriesID", null);
        localObject1 = ???;
        localJSONArray = paramJSONObject.optJSONArray("themeArray");
        localObject1 = ???;
        l = paramJSONObject.optLong("startTime", 0L);
        localObject1 = ???;
        if (!TextUtils.isEmpty(str1))
        {
          localObject1 = ???;
          if (!TextUtils.isEmpty(str3))
          {
            if (localJSONArray != null)
            {
              localObject1 = ???;
              if (localJSONArray.length() < 1) {}
            }
          }
          else
          {
            localObject1 = ???;
            paramJSONObject = ThemeUtil.getCurrentThemeId();
            localObject1 = ???;
            if (QLog.isColorLevel())
            {
              localObject1 = ???;
              localObject3 = new StringBuilder();
              localObject1 = ???;
              ((StringBuilder)localObject3).append("ThemeJsHandler setup,themeId=");
              localObject1 = ???;
              ((StringBuilder)localObject3).append(str1);
              localObject1 = ???;
              ((StringBuilder)localObject3).append(",version=");
              localObject1 = ???;
              ((StringBuilder)localObject3).append(str2);
              localObject1 = ???;
              ((StringBuilder)localObject3).append(",isSound=");
              localObject1 = ???;
              ((StringBuilder)localObject3).append(i);
              localObject1 = ???;
              ((StringBuilder)localObject3).append(" isDiyTheme:");
              localObject1 = ???;
              ((StringBuilder)localObject3).append(paramBoolean);
              localObject1 = ???;
              ((StringBuilder)localObject3).append(" currentThemeId:");
              localObject1 = ???;
              ((StringBuilder)localObject3).append(paramJSONObject);
              localObject1 = ???;
              QLog.i("ThemeJsPlugin", 2, ((StringBuilder)localObject3).toString());
            }
            localObject1 = ???;
            boolean bool = str1.equals(paramJSONObject);
            if ((!bool) || (paramBoolean)) {}
          }
        }
      }
      catch (Throwable paramJSONObject)
      {
        String str1;
        String str2;
        String str3;
        JSONArray localJSONArray;
        long l;
        paramString = (String)localObject1;
      }
      try
      {
        paramBoolean = QLog.isColorLevel();
        if (paramBoolean)
        {
          localObject1 = ???;
          paramJSONObject = new StringBuilder();
          localObject1 = ???;
          paramJSONObject.append("ThemeJsHandler setup the same theme,themeId=");
          localObject1 = ???;
          paramJSONObject.append(str1);
          localObject1 = ???;
          paramJSONObject.append(",version=");
          localObject1 = ???;
          paramJSONObject.append(str2);
          localObject1 = ???;
          QLog.i("ThemeJsPlugin", 2, paramJSONObject.toString());
        }
        paramJSONObject = new JSONObject();
        paramJSONObject.put("result", 0);
        paramJSONObject.put("message", "set the same theme");
        super.callJs((String)???, new String[] { paramJSONObject.toString() });
        paramJSONObject = this.reportMap;
        paramBundle = new StringBuilder();
        paramBundle.append(str1);
        paramBundle.append("_");
        paramBundle.append(str2);
        paramBoolean = paramJSONObject.containsKey(Integer.valueOf(paramBundle.toString().hashCode()));
        if (paramBoolean)
        {
          localObject1 = ???;
          paramJSONObject = this.reportMap;
          localObject1 = ???;
          paramBundle = new StringBuilder();
          localObject1 = ???;
          paramBundle.append(str1);
          localObject1 = ???;
          paramBundle.append("_");
          localObject1 = ???;
          paramBundle.append(str2);
          localObject1 = ???;
          paramJSONObject = (String)paramJSONObject.get(Integer.valueOf(paramBundle.toString().hashCode()));
        }
        else
        {
          paramJSONObject = ThemeReporter.b;
        }
        reportTheme(null, 1, str1, 0L, null, null, "200", 155, paramJSONObject, 23, str2, "0");
        synchronized (this.mLock)
        {
          localObject1 = ThemeUtil.getThemeInfo(this.context, str1);
          paramJSONObject = (JSONObject)localObject1;
          if (localObject1 == null)
          {
            paramJSONObject = new ThemeUtil.ThemeInfo();
            paramJSONObject.themeId = str1;
            paramJSONObject.version = str2;
            if ("1000".equals(str1)) {
              paramJSONObject.status = "5";
            }
            ThemeUtil.setThemeInfo(this.context, paramJSONObject);
          }
          this.mThemeinfo = paramJSONObject;
          this.mThemeinfo.seriesID = str3;
          this.mThemeinfo.themeArray = localJSONArray;
          this.mThemeinfo.startTime = (l * 1000L);
          paramJSONObject = paramString;
          try
          {
            this.mCallbackId = paramJSONObject;
            if ("1103".equals(str1))
            {
              this.mThemeDiyModule.a();
              paramString = paramJSONObject;
            }
            paramJSONObject = finally;
          }
          finally
          {
            try
            {
              ThemeIPCModule.a(str1, new ThemeJsPlugin.ThemeSwitchListener(this, str1, true));
              continue;
              if (paramBundle != null) {
                break label1148;
              }
              paramString = paramJSONObject;
              paramBundle = new Bundle();
              paramString = paramJSONObject;
              paramBundle.putString("themeId", str1);
              paramString = paramJSONObject;
              paramBundle.putString("seriesID", str3);
              paramString = paramJSONObject;
              super.sendRemoteReq(DataFactory.a("setSVTheme", paramJSONObject, this.mOnRemoteResp.key, paramBundle), false, true);
              paramString = paramJSONObject;
              localObject1 = paramJSONObject;
              if (QLog.isColorLevel())
              {
                localObject1 = paramJSONObject;
                paramString = new StringBuilder();
                localObject1 = paramJSONObject;
                paramString.append("setup server :id:");
                localObject1 = paramJSONObject;
                paramString.append(str1);
                localObject1 = paramJSONObject;
                QLog.i("ThemeJsPlugin", 2, paramString.toString());
              }
              return;
            }
            finally
            {
              localObject1 = paramString;
              continue;
            }
            paramJSONObject = finally;
          }
        }
        localObject1 = paramString;
        paramString = (String)localObject1;
        throw paramJSONObject;
      }
      catch (Throwable paramJSONObject)
      {
        break label1096;
      }
      localObject1 = ???;
      paramJSONObject = new StringBuilder();
      localObject1 = ???;
      paramJSONObject.append("ThemeJsHandler setup setWeekLoopThemeArray err,seriesID=");
      localObject1 = ???;
      paramJSONObject.append(str3);
      localObject1 = ???;
      paramJSONObject.append(",themeArray=");
      localObject1 = ???;
      paramJSONObject.append(localJSONArray);
      localObject1 = ???;
      QLog.e("ThemeJsPlugin", 1, paramJSONObject.toString());
      localObject1 = ???;
      paramJSONObject = new JSONObject();
      localObject1 = ???;
      paramJSONObject.put("result", 1);
      localObject1 = ???;
      paramJSONObject.put("message", "seriesID || themeArray data error");
      localObject1 = ???;
      super.callJs((String)???, new String[] { paramJSONObject.toString() });
      localObject1 = ???;
      paramJSONObject = ThemeReporter.a;
      paramString = (String)???;
      try
      {
        reportTheme(null, 0, str1, 0L, null, null, (String)localObject3, 155, paramJSONObject, -8, str2, "");
        return;
      }
      catch (Throwable paramJSONObject) {}
      callJsOnError(paramString, paramJSONObject.getMessage());
      paramString = new StringBuilder();
      paramString.append("setup theme error:");
      paramString.append(paramJSONObject.getMessage());
      QLog.e("ThemeJsPlugin", 1, paramString.toString());
      return;
      localObject3 = "200";
      break;
    }
  }
  
  public void startDownload(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      ThemeIPCModule.a(paramJSONObject.optString("id"), new ThemeJsPlugin.3(this, paramJSONObject, paramString));
      return;
    }
    finally
    {
      paramJSONObject = finally;
      throw paramJSONObject;
    }
  }
  
  /* Error */
  public void startDownload(JSONObject paramJSONObject, String paramString, ThemeLocator paramThemeLocator)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ldc 138
    //   5: invokevirtual 650	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8: astore 10
    //   10: aload_1
    //   11: ldc 118
    //   13: invokevirtual 650	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16: astore 11
    //   18: aload_1
    //   19: ldc_w 847
    //   22: ldc_w 848
    //   25: invokevirtual 758	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   28: istore 4
    //   30: aload_1
    //   31: ldc_w 755
    //   34: iconst_0
    //   35: invokevirtual 758	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   38: istore 5
    //   40: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: istore 6
    //   45: iload 6
    //   47: ifeq +98 -> 145
    //   50: new 213	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   57: astore 9
    //   59: aload 9
    //   61: ldc_w 850
    //   64: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload 9
    //   70: aload 10
    //   72: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload 9
    //   78: ldc_w 852
    //   81: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 9
    //   87: aload 11
    //   89: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 9
    //   95: ldc_w 854
    //   98: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload 9
    //   104: iload 4
    //   106: invokevirtual 466	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload 9
    //   112: ldc_w 780
    //   115: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload 9
    //   121: iload 5
    //   123: invokevirtual 466	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: ldc 17
    //   129: iconst_2
    //   130: aload 9
    //   132: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 389	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: goto +7 -> 145
    //   141: astore_1
    //   142: goto +786 -> 928
    //   145: aload 11
    //   147: invokestatic 136	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   150: ifeq +209 -> 359
    //   153: new 213	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   160: astore_1
    //   161: aload_1
    //   162: ldc_w 856
    //   165: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload_1
    //   170: aload 10
    //   172: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload_1
    //   177: ldc_w 852
    //   180: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_1
    //   185: aload 11
    //   187: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_1
    //   192: ldc_w 854
    //   195: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload_1
    //   200: iload 4
    //   202: invokevirtual 466	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload_1
    //   207: ldc_w 780
    //   210: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload_1
    //   215: iload 5
    //   217: invokevirtual 466	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: ldc 17
    //   223: iconst_1
    //   224: aload_1
    //   225: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 267	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   231: new 115	org/json/JSONObject
    //   234: dup
    //   235: invokespecial 116	org/json/JSONObject:<init>	()V
    //   238: astore_1
    //   239: aload_1
    //   240: ldc 231
    //   242: bipush 248
    //   244: invokevirtual 234	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   247: pop
    //   248: aload_1
    //   249: ldc 236
    //   251: ldc_w 858
    //   254: invokevirtual 122	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   257: pop
    //   258: aload_0
    //   259: aload_2
    //   260: iconst_1
    //   261: anewarray 126	java/lang/String
    //   264: dup
    //   265: iconst_0
    //   266: aload_1
    //   267: invokevirtual 239	org/json/JSONObject:toString	()Ljava/lang/String;
    //   270: aastore
    //   271: invokespecial 524	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   274: aload_0
    //   275: aconst_null
    //   276: iconst_0
    //   277: aload 11
    //   279: lconst_0
    //   280: aconst_null
    //   281: aconst_null
    //   282: ldc 253
    //   284: sipush 153
    //   287: getstatic 247	com/tencent/mobileqq/vas/theme/ThemeReporter:a	Ljava/lang/String;
    //   290: bipush 248
    //   292: aload 10
    //   294: ldc 255
    //   296: invokevirtual 259	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   299: aconst_null
    //   300: ldc_w 860
    //   303: ldc_w 862
    //   306: ldc_w 864
    //   309: aconst_null
    //   310: fconst_0
    //   311: invokestatic 869	com/tencent/mobileqq/vas/VasMonitorHandler:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   314: new 75	java/util/HashMap
    //   317: dup
    //   318: invokespecial 76	java/util/HashMap:<init>	()V
    //   321: astore_1
    //   322: aload_1
    //   323: ldc_w 862
    //   326: ldc_w 871
    //   329: invokevirtual 872	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   332: pop
    //   333: invokestatic 878	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   336: invokestatic 884	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   339: ldc 255
    //   341: ldc_w 860
    //   344: iconst_0
    //   345: lconst_0
    //   346: ldc2_w 885
    //   349: aload_1
    //   350: ldc 255
    //   352: iconst_1
    //   353: invokevirtual 890	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   356: aload_0
    //   357: monitorexit
    //   358: return
    //   359: aload_0
    //   360: getfield 277	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:context	Landroid/content/Context;
    //   363: aload 11
    //   365: invokestatic 283	com/tencent/mobileqq/vas/theme/api/ThemeUtil:getThemeInfo	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo;
    //   368: astore 9
    //   370: aload_3
    //   371: ifnull +713 -> 1084
    //   374: aload_3
    //   375: invokevirtual 892	com/tencent/mobileqq/vas/theme/api/ThemeLocator:b	()Z
    //   378: ifeq +706 -> 1084
    //   381: iconst_1
    //   382: istore 6
    //   384: goto +3 -> 387
    //   387: aload_3
    //   388: ifnull +702 -> 1090
    //   391: aload_3
    //   392: invokevirtual 657	com/tencent/mobileqq/vas/theme/api/ThemeLocator:a	()Z
    //   395: ifeq +695 -> 1090
    //   398: iconst_1
    //   399: istore 7
    //   401: goto +692 -> 1093
    //   404: aload_1
    //   405: ldc_w 894
    //   408: iconst_0
    //   409: invokevirtual 898	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   412: ifne +712 -> 1124
    //   415: iconst_1
    //   416: istore 4
    //   418: goto +3 -> 421
    //   421: aload_0
    //   422: getfield 78	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportMap	Ljava/util/HashMap;
    //   425: astore_1
    //   426: new 213	java/lang/StringBuilder
    //   429: dup
    //   430: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   433: astore_3
    //   434: aload_3
    //   435: aload 11
    //   437: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: pop
    //   441: aload_3
    //   442: ldc_w 408
    //   445: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: pop
    //   449: aload_3
    //   450: aload 10
    //   452: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: pop
    //   456: aload_1
    //   457: aload_3
    //   458: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokevirtual 791	java/lang/String:hashCode	()I
    //   464: invokestatic 795	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   467: getstatic 247	com/tencent/mobileqq/vas/theme/ThemeReporter:a	Ljava/lang/String;
    //   470: invokevirtual 872	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   473: pop
    //   474: aload_0
    //   475: getfield 277	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:context	Landroid/content/Context;
    //   478: invokestatic 904	com/tencent/mobileqq/utils/NetworkUtil:getSystemNetwork	(Landroid/content/Context;)I
    //   481: istore 5
    //   483: iload 4
    //   485: ifeq +190 -> 675
    //   488: iload 5
    //   490: iconst_1
    //   491: if_icmple +184 -> 675
    //   494: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   497: ifeq +12 -> 509
    //   500: ldc 17
    //   502: iconst_2
    //   503: ldc_w 906
    //   506: invokestatic 192	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   509: aload_0
    //   510: getfield 332	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   513: invokevirtual 344	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   516: iconst_2
    //   517: new 908	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$4
    //   520: dup
    //   521: aload_0
    //   522: aload 11
    //   524: aload 10
    //   526: iload 6
    //   528: aload_2
    //   529: invokespecial 911	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$4:<init>	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
    //   532: ldc_w 913
    //   535: invokestatic 918	com/tencent/mobileqq/vip/CUKingCardHelper:a	(Landroid/app/Activity;ILcom/tencent/mobileqq/vip/CUKingCardHelper$CUKingDialogListener;Ljava/lang/String;)Z
    //   538: ifeq +539 -> 1077
    //   541: aload_0
    //   542: new 920	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$5
    //   545: dup
    //   546: aload_0
    //   547: aload_0
    //   548: getfield 332	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   551: invokevirtual 344	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   554: ldc_w 921
    //   557: aload 11
    //   559: aload 10
    //   561: iload 6
    //   563: aload_2
    //   564: invokespecial 924	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$5:<init>	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
    //   567: putfield 222	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   570: aload_0
    //   571: getfield 222	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   574: ldc_w 925
    //   577: invokevirtual 928	com/tencent/mobileqq/utils/QQCustomDialog:setContentView	(I)V
    //   580: aload_0
    //   581: getfield 222	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   584: ldc_w 929
    //   587: invokestatic 629	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   590: invokevirtual 933	com/tencent/mobileqq/utils/QQCustomDialog:setTitle	(Ljava/lang/String;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   593: pop
    //   594: aload_0
    //   595: getfield 222	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   598: ldc_w 934
    //   601: invokevirtual 938	com/tencent/mobileqq/utils/QQCustomDialog:setMessage	(I)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   604: pop
    //   605: aload_0
    //   606: getfield 222	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   609: iconst_0
    //   610: invokevirtual 942	com/tencent/mobileqq/utils/QQCustomDialog:setCanceledOnTouchOutside	(Z)V
    //   613: aload_0
    //   614: getfield 222	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   617: ldc_w 943
    //   620: new 945	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$6
    //   623: dup
    //   624: aload_0
    //   625: aload 11
    //   627: aload 10
    //   629: iload 6
    //   631: aload_2
    //   632: invokespecial 946	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$6:<init>	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
    //   635: invokevirtual 950	com/tencent/mobileqq/utils/QQCustomDialog:setNegativeButton	(ILandroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   638: pop
    //   639: aload_0
    //   640: getfield 222	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   643: ldc_w 951
    //   646: new 953	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$7
    //   649: dup
    //   650: aload_0
    //   651: aload 11
    //   653: aload 10
    //   655: iload 6
    //   657: aload_2
    //   658: invokespecial 954	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$7:<init>	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
    //   661: invokevirtual 957	com/tencent/mobileqq/utils/QQCustomDialog:setPositiveButton	(ILandroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   664: pop
    //   665: aload_0
    //   666: getfield 222	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   669: invokevirtual 960	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   672: goto +405 -> 1077
    //   675: aload_0
    //   676: iconst_1
    //   677: aload 11
    //   679: aload 10
    //   681: iload 6
    //   683: aload_2
    //   684: invokevirtual 962	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:gotoDownload	(ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
    //   687: goto +390 -> 1077
    //   690: aload 9
    //   692: astore_1
    //   693: aload 9
    //   695: ifnonnull +55 -> 750
    //   698: new 275	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo
    //   701: dup
    //   702: invokespecial 284	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo:<init>	()V
    //   705: astore_1
    //   706: aload_1
    //   707: aload 11
    //   709: putfield 287	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo:themeId	Ljava/lang/String;
    //   712: aload_1
    //   713: ldc_w 963
    //   716: putfield 966	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo:zipVer	I
    //   719: aload_1
    //   720: ldc 140
    //   722: putfield 717	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo:version	Ljava/lang/String;
    //   725: aload_1
    //   726: ldc_w 667
    //   729: putfield 680	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   732: iload 5
    //   734: iconst_1
    //   735: if_icmpne +395 -> 1130
    //   738: iconst_1
    //   739: istore 8
    //   741: goto +3 -> 744
    //   744: aload_1
    //   745: iload 8
    //   747: putfield 291	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo:isVoiceTheme	Z
    //   750: new 213	java/lang/StringBuilder
    //   753: dup
    //   754: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   757: astore_3
    //   758: aload_3
    //   759: ldc_w 968
    //   762: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: pop
    //   766: aload_3
    //   767: aload 11
    //   769: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   772: pop
    //   773: aload_3
    //   774: ldc_w 970
    //   777: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   780: pop
    //   781: aload_3
    //   782: iload 6
    //   784: invokevirtual 519	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   787: pop
    //   788: aload_3
    //   789: ldc_w 972
    //   792: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: pop
    //   796: aload_3
    //   797: iload 7
    //   799: invokevirtual 519	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   802: pop
    //   803: ldc 17
    //   805: iconst_1
    //   806: aload_3
    //   807: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   810: invokestatic 389	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   813: aload_1
    //   814: ldc_w 667
    //   817: putfield 680	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   820: aload_1
    //   821: getfield 697	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo:size	J
    //   824: lconst_1
    //   825: lcmp
    //   826: ifge +10 -> 836
    //   829: aload_1
    //   830: ldc2_w 973
    //   833: putfield 697	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo:size	J
    //   836: aload_1
    //   837: aload_1
    //   838: getfield 697	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo:size	J
    //   841: putfield 689	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo:downsize	J
    //   844: aload_0
    //   845: getfield 73	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:downloadThemeMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   848: aload 11
    //   850: aload_1
    //   851: invokevirtual 298	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   854: pop
    //   855: new 115	org/json/JSONObject
    //   858: dup
    //   859: invokespecial 116	org/json/JSONObject:<init>	()V
    //   862: astore_1
    //   863: aload_1
    //   864: ldc 231
    //   866: iconst_3
    //   867: invokevirtual 234	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   870: pop
    //   871: aload_1
    //   872: ldc 236
    //   874: ldc_w 976
    //   877: invokevirtual 122	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   880: pop
    //   881: aload_0
    //   882: aload_2
    //   883: iconst_1
    //   884: anewarray 126	java/lang/String
    //   887: dup
    //   888: iconst_0
    //   889: aload_1
    //   890: invokevirtual 239	org/json/JSONObject:toString	()Ljava/lang/String;
    //   893: aastore
    //   894: invokespecial 524	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   897: aload_0
    //   898: aconst_null
    //   899: iconst_0
    //   900: aload 11
    //   902: lconst_0
    //   903: ldc 249
    //   905: ldc_w 978
    //   908: ldc 253
    //   910: sipush 153
    //   913: getstatic 247	com/tencent/mobileqq/vas/theme/ThemeReporter:a	Ljava/lang/String;
    //   916: iconst_2
    //   917: aload 10
    //   919: ldc 255
    //   921: invokevirtual 259	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   924: aload_0
    //   925: monitorexit
    //   926: return
    //   927: astore_1
    //   928: goto +80 -> 1008
    //   931: astore_1
    //   932: goto +148 -> 1080
    //   935: astore_1
    //   936: aload_0
    //   937: aload_2
    //   938: aload_1
    //   939: invokevirtual 264	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   942: invokespecial 724	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJsOnError	(Ljava/lang/String;Ljava/lang/String;)V
    //   945: new 213	java/lang/StringBuilder
    //   948: dup
    //   949: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   952: astore_2
    //   953: aload_2
    //   954: ldc_w 980
    //   957: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   960: pop
    //   961: aload_2
    //   962: aload_1
    //   963: invokevirtual 264	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   966: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   969: pop
    //   970: ldc 17
    //   972: iconst_1
    //   973: aload_2
    //   974: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   977: invokestatic 267	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   980: aload_0
    //   981: aconst_null
    //   982: iconst_0
    //   983: ldc 255
    //   985: lconst_0
    //   986: aconst_null
    //   987: aconst_null
    //   988: ldc 253
    //   990: sipush 153
    //   993: getstatic 247	com/tencent/mobileqq/vas/theme/ThemeReporter:a	Ljava/lang/String;
    //   996: bipush 221
    //   998: ldc 255
    //   1000: ldc 255
    //   1002: invokevirtual 259	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   1005: goto +72 -> 1077
    //   1008: aload_0
    //   1009: aload_2
    //   1010: aload_1
    //   1011: invokevirtual 981	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1014: invokespecial 724	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJsOnError	(Ljava/lang/String;Ljava/lang/String;)V
    //   1017: new 213	java/lang/StringBuilder
    //   1020: dup
    //   1021: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   1024: astore_2
    //   1025: aload_2
    //   1026: ldc_w 983
    //   1029: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1032: pop
    //   1033: aload_2
    //   1034: aload_1
    //   1035: invokevirtual 981	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1038: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1041: pop
    //   1042: ldc 17
    //   1044: iconst_1
    //   1045: aload_2
    //   1046: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1049: invokestatic 267	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1052: aload_0
    //   1053: aconst_null
    //   1054: iconst_0
    //   1055: ldc 255
    //   1057: lconst_0
    //   1058: aconst_null
    //   1059: aconst_null
    //   1060: ldc 253
    //   1062: sipush 153
    //   1065: getstatic 247	com/tencent/mobileqq/vas/theme/ThemeReporter:a	Ljava/lang/String;
    //   1068: bipush 220
    //   1070: ldc 255
    //   1072: ldc 255
    //   1074: invokevirtual 259	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   1077: aload_0
    //   1078: monitorexit
    //   1079: return
    //   1080: aload_0
    //   1081: monitorexit
    //   1082: aload_1
    //   1083: athrow
    //   1084: iconst_0
    //   1085: istore 6
    //   1087: goto -700 -> 387
    //   1090: iconst_0
    //   1091: istore 7
    //   1093: iload 6
    //   1095: ifne -405 -> 690
    //   1098: iload 7
    //   1100: ifeq +6 -> 1106
    //   1103: goto -413 -> 690
    //   1106: iload 5
    //   1108: iconst_1
    //   1109: if_icmpne +9 -> 1118
    //   1112: iconst_1
    //   1113: istore 6
    //   1115: goto -711 -> 404
    //   1118: iconst_0
    //   1119: istore 6
    //   1121: goto -717 -> 404
    //   1124: iconst_0
    //   1125: istore 4
    //   1127: goto -706 -> 421
    //   1130: iconst_0
    //   1131: istore 8
    //   1133: goto -389 -> 744
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1136	0	this	ThemeJsPlugin
    //   0	1136	1	paramJSONObject	JSONObject
    //   0	1136	2	paramString	String
    //   0	1136	3	paramThemeLocator	ThemeLocator
    //   28	1098	4	i	int
    //   38	1072	5	j	int
    //   43	1077	6	bool1	boolean
    //   399	700	7	bool2	boolean
    //   739	393	8	bool3	boolean
    //   57	637	9	localObject	Object
    //   8	910	10	str1	String
    //   16	885	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   50	138	141	org/json/JSONException
    //   2	45	927	org/json/JSONException
    //   145	356	927	org/json/JSONException
    //   359	370	927	org/json/JSONException
    //   374	381	927	org/json/JSONException
    //   391	398	927	org/json/JSONException
    //   404	415	927	org/json/JSONException
    //   421	483	927	org/json/JSONException
    //   494	509	927	org/json/JSONException
    //   509	672	927	org/json/JSONException
    //   675	687	927	org/json/JSONException
    //   698	732	927	org/json/JSONException
    //   744	750	927	org/json/JSONException
    //   750	836	927	org/json/JSONException
    //   836	924	927	org/json/JSONException
    //   2	45	931	finally
    //   50	138	931	finally
    //   145	356	931	finally
    //   359	370	931	finally
    //   374	381	931	finally
    //   391	398	931	finally
    //   404	415	931	finally
    //   421	483	931	finally
    //   494	509	931	finally
    //   509	672	931	finally
    //   675	687	931	finally
    //   698	732	931	finally
    //   744	750	931	finally
    //   750	836	931	finally
    //   836	924	931	finally
    //   936	1005	931	finally
    //   1008	1077	931	finally
    //   2	45	935	java/lang/Exception
    //   50	138	935	java/lang/Exception
    //   145	356	935	java/lang/Exception
    //   359	370	935	java/lang/Exception
    //   374	381	935	java/lang/Exception
    //   391	398	935	java/lang/Exception
    //   404	415	935	java/lang/Exception
    //   421	483	935	java/lang/Exception
    //   494	509	935	java/lang/Exception
    //   509	672	935	java/lang/Exception
    //   675	687	935	java/lang/Exception
    //   698	732	935	java/lang/Exception
    //   744	750	935	java/lang/Exception
    //   750	836	935	java/lang/Exception
    //   836	924	935	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin
 * JD-Core Version:    0.7.0.1
 */