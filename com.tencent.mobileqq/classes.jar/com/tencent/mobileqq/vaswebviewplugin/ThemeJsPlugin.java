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
    setup(localJSONObject, paramString3, this.mThemeDiyModule.b(paramString1, paramString2), true);
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
    //   4: ifge +231 -> 235
    //   7: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +42 -> 52
    //   13: new 214	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   20: astore 6
    //   22: aload 6
    //   24: ldc 217
    //   26: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 6
    //   32: aload 8
    //   34: getfield 223	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   37: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: ldc 17
    //   43: iconst_2
    //   44: aload 6
    //   46: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 193	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: new 115	org/json/JSONObject
    //   55: dup
    //   56: invokespecial 116	org/json/JSONObject:<init>	()V
    //   59: astore 6
    //   61: aload 6
    //   63: ldc 232
    //   65: iconst_2
    //   66: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   69: pop
    //   70: aload 6
    //   72: ldc 237
    //   74: ldc 239
    //   76: invokevirtual 122	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   79: pop
    //   80: aload 8
    //   82: aload 5
    //   84: iconst_1
    //   85: anewarray 126	java/lang/String
    //   88: dup
    //   89: iconst_0
    //   90: aload 6
    //   92: invokevirtual 240	org/json/JSONObject:toString	()Ljava/lang/String;
    //   95: aastore
    //   96: invokevirtual 244	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   99: getstatic 248	com/tencent/mobileqq/vas/theme/ThemeReporter:a	Ljava/lang/String;
    //   102: astore 5
    //   104: aload_0
    //   105: aconst_null
    //   106: iconst_0
    //   107: aload_2
    //   108: lconst_0
    //   109: ldc 250
    //   111: ldc 252
    //   113: ldc 254
    //   115: sipush 153
    //   118: aload 5
    //   120: bipush 10
    //   122: aload_3
    //   123: ldc_w 256
    //   126: invokevirtual 260	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   129: iload_1
    //   130: iconst_m1
    //   131: if_icmpne +15 -> 146
    //   134: aload_0
    //   135: getfield 223	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   138: astore_2
    //   139: aload_2
    //   140: ifnull +73 -> 213
    //   143: goto +66 -> 209
    //   146: return
    //   147: astore_2
    //   148: goto +67 -> 215
    //   151: astore_2
    //   152: goto +8 -> 160
    //   155: astore_2
    //   156: goto +59 -> 215
    //   159: astore_2
    //   160: new 214	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   167: astore_3
    //   168: aload_3
    //   169: ldc_w 262
    //   172: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload_3
    //   177: aload_2
    //   178: invokevirtual 265	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   181: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: ldc 17
    //   187: iconst_2
    //   188: aload_3
    //   189: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 268	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   195: iload_1
    //   196: iconst_m1
    //   197: if_icmpne +16 -> 213
    //   200: aload_0
    //   201: getfield 223	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   204: astore_2
    //   205: aload_2
    //   206: ifnull +7 -> 213
    //   209: aload_2
    //   210: invokevirtual 273	com/tencent/mobileqq/utils/QQCustomDialog:dismiss	()V
    //   213: return
    //   214: astore_2
    //   215: iload_1
    //   216: iconst_m1
    //   217: if_icmpne +16 -> 233
    //   220: aload_0
    //   221: getfield 223	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   224: astore_3
    //   225: aload_3
    //   226: ifnull +7 -> 233
    //   229: aload_3
    //   230: invokevirtual 273	com/tencent/mobileqq/utils/QQCustomDialog:dismiss	()V
    //   233: aload_2
    //   234: athrow
    //   235: aload 8
    //   237: getfield 73	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:downloadThemeMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   240: aload_2
    //   241: invokevirtual 274	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   244: checkcast 276	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo
    //   247: astore 7
    //   249: aload 7
    //   251: astore 6
    //   253: aload 7
    //   255: ifnonnull +14 -> 269
    //   258: aload 8
    //   260: getfield 278	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:context	Landroid/content/Context;
    //   263: aload_2
    //   264: invokestatic 284	com/tencent/mobileqq/vas/theme/api/ThemeUtil:getThemeInfo	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo;
    //   267: astore 6
    //   269: aload 6
    //   271: astore 7
    //   273: aload 6
    //   275: ifnonnull +18 -> 293
    //   278: new 276	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo
    //   281: dup
    //   282: invokespecial 285	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo:<init>	()V
    //   285: astore 7
    //   287: aload 7
    //   289: aload_2
    //   290: putfield 288	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo:themeId	Ljava/lang/String;
    //   293: aload 7
    //   295: iload 4
    //   297: putfield 292	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo:isVoiceTheme	Z
    //   300: aload 8
    //   302: getfield 278	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:context	Landroid/content/Context;
    //   305: aload 7
    //   307: invokestatic 296	com/tencent/mobileqq/vas/theme/api/ThemeUtil:setThemeInfo	(Landroid/content/Context;Lcom/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo;)Ljava/lang/Boolean;
    //   310: pop
    //   311: aload 8
    //   313: getfield 73	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:downloadThemeMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   316: aload_2
    //   317: aload 7
    //   319: invokevirtual 299	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   322: pop
    //   323: aload 8
    //   325: aload_2
    //   326: putfield 105	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:currDownloadingThemeId	Ljava/lang/String;
    //   329: aload_2
    //   330: putstatic 301	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:loadingThemeIdForJsCall	Ljava/lang/String;
    //   333: aload_0
    //   334: aconst_null
    //   335: iconst_0
    //   336: aload_2
    //   337: lconst_0
    //   338: aconst_null
    //   339: aconst_null
    //   340: ldc 254
    //   342: sipush 153
    //   345: getstatic 248	com/tencent/mobileqq/vas/theme/ThemeReporter:a	Ljava/lang/String;
    //   348: bipush 11
    //   350: aload_3
    //   351: ldc_w 256
    //   354: invokevirtual 260	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   357: ldc2_w 302
    //   360: aload_2
    //   361: invokestatic 306	com/tencent/mobileqq/vas/theme/api/ThemeUtil:getThemeConfigID	(Ljava/lang/String;)Ljava/lang/String;
    //   364: new 308	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$8
    //   367: dup
    //   368: aload 8
    //   370: aload 5
    //   372: invokespecial 311	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$8:<init>	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;Ljava/lang/String;)V
    //   375: invokestatic 317	com/tencent/mobileqq/vas/ipc/QuickUpdateIPCModule:download	(JLjava/lang/String;Lcom/tencent/mobileqq/vas/aidl/IDownloadListener;)V
    //   378: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	this	ThemeJsPlugin
    //   0	379	1	paramInt	int
    //   0	379	2	paramString1	String
    //   0	379	3	paramString2	String
    //   0	379	4	paramBoolean	boolean
    //   0	379	5	paramString3	String
    //   20	254	6	localObject1	Object
    //   247	71	7	localObject2	Object
    //   1	368	8	localThemeJsPlugin	ThemeJsPlugin
    // Exception table:
    //   from	to	target	type
    //   104	129	147	finally
    //   104	129	151	java/lang/Exception
    //   52	104	155	finally
    //   52	104	159	java/lang/Exception
    //   160	195	214	finally
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void onCreate()
  {
    if ((this.mRuntime.b() != null) && ((this.mRuntime.b() instanceof BrowserAppInterface))) {
      this.app = ((BrowserAppInterface)this.mRuntime.b());
    }
    this.context = this.mRuntime.d().getApplicationContext();
    this.mThemeDiyModule = new ThemeDiyModule(this.context, this.app);
    this.mThemeDiyModule.a(this.mThemeDiyImpl);
    super.onCreate();
    this.rootView = this.mRuntime.d().getWindow().getDecorView().getRootView();
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
                if ((!TextUtils.isEmpty(str2)) && (str2.equals(this.mCallbackId)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (this.mThemeinfo != null) && (((String)localObject3).equals(this.mThemeinfo.themeId)) && (!DarkModeManager.b(this.mRuntime.d(), (String)localObject3, new ThemeJsPlugin.10(this, (String)localObject3)))) {
                  if (!SimpleUIUtil.e())
                  {
                    this.mThemeDiyModule.b();
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
              super.callJs(str2, new String[] { new JSONResult(???.getInt("result_int"), HardCodeUtil.a(2131912232)).a() });
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
        break label704;
      }
      if (localObject2 != null) {
        break label695;
      }
      paramJSONObject = ThemeUtil.getThemeInfo(this.context, (String)localObject1);
      if ((paramThemeLocator != null) && (paramThemeLocator.h())) {
        break label704;
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
        break label710;
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
      label695:
      i = 1;
      paramJSONObject = (JSONObject)localObject2;
      break;
      label704:
      i = 0;
      break;
      label710:
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
    label1097:
    label1149:
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
              this.mThemeDiyModule.b();
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
                break label1149;
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
        break label1097;
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
    //   5: invokevirtual 651	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8: astore 10
    //   10: aload_1
    //   11: ldc 118
    //   13: invokevirtual 651	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16: astore 11
    //   18: aload_1
    //   19: ldc_w 849
    //   22: ldc_w 850
    //   25: invokevirtual 761	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   28: istore 4
    //   30: aload_1
    //   31: ldc_w 758
    //   34: iconst_0
    //   35: invokevirtual 761	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   38: istore 5
    //   40: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: istore 6
    //   45: iload 6
    //   47: ifeq +98 -> 145
    //   50: new 214	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   57: astore 9
    //   59: aload 9
    //   61: ldc_w 852
    //   64: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload 9
    //   70: aload 10
    //   72: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload 9
    //   78: ldc_w 854
    //   81: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 9
    //   87: aload 11
    //   89: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 9
    //   95: ldc_w 856
    //   98: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload 9
    //   104: iload 4
    //   106: invokevirtual 467	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload 9
    //   112: ldc_w 783
    //   115: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload 9
    //   121: iload 5
    //   123: invokevirtual 467	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: ldc 17
    //   129: iconst_2
    //   130: aload 9
    //   132: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 390	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: goto +7 -> 145
    //   141: astore_1
    //   142: goto +790 -> 932
    //   145: aload 11
    //   147: invokestatic 136	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   150: ifeq +212 -> 362
    //   153: new 214	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   160: astore_1
    //   161: aload_1
    //   162: ldc_w 858
    //   165: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload_1
    //   170: aload 10
    //   172: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload_1
    //   177: ldc_w 854
    //   180: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_1
    //   185: aload 11
    //   187: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_1
    //   192: ldc_w 856
    //   195: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload_1
    //   200: iload 4
    //   202: invokevirtual 467	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload_1
    //   207: ldc_w 783
    //   210: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload_1
    //   215: iload 5
    //   217: invokevirtual 467	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: ldc 17
    //   223: iconst_1
    //   224: aload_1
    //   225: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 268	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   231: new 115	org/json/JSONObject
    //   234: dup
    //   235: invokespecial 116	org/json/JSONObject:<init>	()V
    //   238: astore_1
    //   239: aload_1
    //   240: ldc 232
    //   242: bipush 248
    //   244: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   247: pop
    //   248: aload_1
    //   249: ldc 237
    //   251: ldc_w 860
    //   254: invokevirtual 122	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   257: pop
    //   258: aload_0
    //   259: aload_2
    //   260: iconst_1
    //   261: anewarray 126	java/lang/String
    //   264: dup
    //   265: iconst_0
    //   266: aload_1
    //   267: invokevirtual 240	org/json/JSONObject:toString	()Ljava/lang/String;
    //   270: aastore
    //   271: invokespecial 525	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   274: aload_0
    //   275: aconst_null
    //   276: iconst_0
    //   277: aload 11
    //   279: lconst_0
    //   280: aconst_null
    //   281: aconst_null
    //   282: ldc 254
    //   284: sipush 153
    //   287: getstatic 248	com/tencent/mobileqq/vas/theme/ThemeReporter:a	Ljava/lang/String;
    //   290: bipush 248
    //   292: aload 10
    //   294: ldc_w 256
    //   297: invokevirtual 260	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   300: aconst_null
    //   301: ldc_w 862
    //   304: ldc_w 864
    //   307: ldc_w 866
    //   310: aconst_null
    //   311: fconst_0
    //   312: invokestatic 871	com/tencent/mobileqq/vas/VasMonitorHandler:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   315: new 75	java/util/HashMap
    //   318: dup
    //   319: invokespecial 76	java/util/HashMap:<init>	()V
    //   322: astore_1
    //   323: aload_1
    //   324: ldc_w 864
    //   327: ldc_w 873
    //   330: invokevirtual 874	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   333: pop
    //   334: invokestatic 880	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   337: invokestatic 886	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   340: ldc_w 256
    //   343: ldc_w 862
    //   346: iconst_0
    //   347: lconst_0
    //   348: ldc2_w 887
    //   351: aload_1
    //   352: ldc_w 256
    //   355: iconst_1
    //   356: invokevirtual 892	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   359: aload_0
    //   360: monitorexit
    //   361: return
    //   362: aload_0
    //   363: getfield 278	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:context	Landroid/content/Context;
    //   366: aload 11
    //   368: invokestatic 284	com/tencent/mobileqq/vas/theme/api/ThemeUtil:getThemeInfo	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo;
    //   371: astore 9
    //   373: aload_3
    //   374: ifnull +720 -> 1094
    //   377: aload_3
    //   378: invokevirtual 894	com/tencent/mobileqq/vas/theme/api/ThemeLocator:i	()Z
    //   381: ifeq +713 -> 1094
    //   384: iconst_1
    //   385: istore 6
    //   387: goto +3 -> 390
    //   390: aload_3
    //   391: ifnull +709 -> 1100
    //   394: aload_3
    //   395: invokevirtual 660	com/tencent/mobileqq/vas/theme/api/ThemeLocator:h	()Z
    //   398: ifeq +702 -> 1100
    //   401: iconst_1
    //   402: istore 7
    //   404: goto +699 -> 1103
    //   407: aload_1
    //   408: ldc_w 896
    //   411: iconst_0
    //   412: invokevirtual 900	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   415: ifne +719 -> 1134
    //   418: iconst_1
    //   419: istore 4
    //   421: goto +3 -> 424
    //   424: aload_0
    //   425: getfield 78	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportMap	Ljava/util/HashMap;
    //   428: astore_1
    //   429: new 214	java/lang/StringBuilder
    //   432: dup
    //   433: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   436: astore_3
    //   437: aload_3
    //   438: aload 11
    //   440: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: pop
    //   444: aload_3
    //   445: ldc_w 409
    //   448: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: aload_3
    //   453: aload 10
    //   455: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: aload_1
    //   460: aload_3
    //   461: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: invokevirtual 794	java/lang/String:hashCode	()I
    //   467: invokestatic 798	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   470: getstatic 248	com/tencent/mobileqq/vas/theme/ThemeReporter:a	Ljava/lang/String;
    //   473: invokevirtual 874	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   476: pop
    //   477: aload_0
    //   478: getfield 278	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:context	Landroid/content/Context;
    //   481: invokestatic 906	com/tencent/mobileqq/utils/NetworkUtil:getSystemNetwork	(Landroid/content/Context;)I
    //   484: istore 5
    //   486: iload 4
    //   488: ifeq +190 -> 678
    //   491: iload 5
    //   493: iconst_1
    //   494: if_icmple +184 -> 678
    //   497: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   500: ifeq +12 -> 512
    //   503: ldc 17
    //   505: iconst_2
    //   506: ldc_w 908
    //   509: invokestatic 193	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   512: aload_0
    //   513: getfield 333	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   516: invokevirtual 346	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   519: iconst_2
    //   520: new 910	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$4
    //   523: dup
    //   524: aload_0
    //   525: aload 11
    //   527: aload 10
    //   529: iload 6
    //   531: aload_2
    //   532: invokespecial 913	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$4:<init>	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
    //   535: ldc_w 915
    //   538: invokestatic 920	com/tencent/mobileqq/vip/CUKingCardHelper:a	(Landroid/app/Activity;ILcom/tencent/mobileqq/vip/CUKingCardHelper$CUKingDialogListener;Ljava/lang/String;)Z
    //   541: ifeq +546 -> 1087
    //   544: aload_0
    //   545: new 922	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$5
    //   548: dup
    //   549: aload_0
    //   550: aload_0
    //   551: getfield 333	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   554: invokevirtual 346	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   557: ldc_w 923
    //   560: aload 11
    //   562: aload 10
    //   564: iload 6
    //   566: aload_2
    //   567: invokespecial 926	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$5:<init>	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
    //   570: putfield 223	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   573: aload_0
    //   574: getfield 223	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   577: ldc_w 927
    //   580: invokevirtual 930	com/tencent/mobileqq/utils/QQCustomDialog:setContentView	(I)V
    //   583: aload_0
    //   584: getfield 223	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   587: ldc_w 931
    //   590: invokestatic 630	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   593: invokevirtual 935	com/tencent/mobileqq/utils/QQCustomDialog:setTitle	(Ljava/lang/String;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   596: pop
    //   597: aload_0
    //   598: getfield 223	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   601: ldc_w 936
    //   604: invokevirtual 940	com/tencent/mobileqq/utils/QQCustomDialog:setMessage	(I)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   607: pop
    //   608: aload_0
    //   609: getfield 223	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   612: iconst_0
    //   613: invokevirtual 944	com/tencent/mobileqq/utils/QQCustomDialog:setCanceledOnTouchOutside	(Z)V
    //   616: aload_0
    //   617: getfield 223	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   620: ldc_w 945
    //   623: new 947	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$6
    //   626: dup
    //   627: aload_0
    //   628: aload 11
    //   630: aload 10
    //   632: iload 6
    //   634: aload_2
    //   635: invokespecial 948	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$6:<init>	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
    //   638: invokevirtual 952	com/tencent/mobileqq/utils/QQCustomDialog:setNegativeButton	(ILandroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   641: pop
    //   642: aload_0
    //   643: getfield 223	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   646: ldc_w 953
    //   649: new 955	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$7
    //   652: dup
    //   653: aload_0
    //   654: aload 11
    //   656: aload 10
    //   658: iload 6
    //   660: aload_2
    //   661: invokespecial 956	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$7:<init>	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
    //   664: invokevirtual 959	com/tencent/mobileqq/utils/QQCustomDialog:setPositiveButton	(ILandroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   667: pop
    //   668: aload_0
    //   669: getfield 223	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:dialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   672: invokevirtual 962	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   675: goto +412 -> 1087
    //   678: aload_0
    //   679: iconst_1
    //   680: aload 11
    //   682: aload 10
    //   684: iload 6
    //   686: aload_2
    //   687: invokevirtual 964	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:gotoDownload	(ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
    //   690: goto +397 -> 1087
    //   693: aload 9
    //   695: astore_1
    //   696: aload 9
    //   698: ifnonnull +55 -> 753
    //   701: new 276	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo
    //   704: dup
    //   705: invokespecial 285	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo:<init>	()V
    //   708: astore_1
    //   709: aload_1
    //   710: aload 11
    //   712: putfield 288	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo:themeId	Ljava/lang/String;
    //   715: aload_1
    //   716: ldc_w 965
    //   719: putfield 968	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo:zipVer	I
    //   722: aload_1
    //   723: ldc 140
    //   725: putfield 720	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo:version	Ljava/lang/String;
    //   728: aload_1
    //   729: ldc_w 670
    //   732: putfield 683	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   735: iload 5
    //   737: iconst_1
    //   738: if_icmpne +402 -> 1140
    //   741: iconst_1
    //   742: istore 8
    //   744: goto +3 -> 747
    //   747: aload_1
    //   748: iload 8
    //   750: putfield 292	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo:isVoiceTheme	Z
    //   753: new 214	java/lang/StringBuilder
    //   756: dup
    //   757: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   760: astore_3
    //   761: aload_3
    //   762: ldc_w 970
    //   765: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   768: pop
    //   769: aload_3
    //   770: aload 11
    //   772: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: pop
    //   776: aload_3
    //   777: ldc_w 972
    //   780: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: pop
    //   784: aload_3
    //   785: iload 6
    //   787: invokevirtual 520	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   790: pop
    //   791: aload_3
    //   792: ldc_w 974
    //   795: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: pop
    //   799: aload_3
    //   800: iload 7
    //   802: invokevirtual 520	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   805: pop
    //   806: ldc 17
    //   808: iconst_1
    //   809: aload_3
    //   810: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   813: invokestatic 390	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   816: aload_1
    //   817: ldc_w 670
    //   820: putfield 683	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   823: aload_1
    //   824: getfield 700	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo:size	J
    //   827: lconst_1
    //   828: lcmp
    //   829: ifge +10 -> 839
    //   832: aload_1
    //   833: ldc2_w 975
    //   836: putfield 700	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo:size	J
    //   839: aload_1
    //   840: aload_1
    //   841: getfield 700	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo:size	J
    //   844: putfield 692	com/tencent/mobileqq/vas/theme/api/ThemeUtil$ThemeInfo:downsize	J
    //   847: aload_0
    //   848: getfield 73	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:downloadThemeMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   851: aload 11
    //   853: aload_1
    //   854: invokevirtual 299	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   857: pop
    //   858: new 115	org/json/JSONObject
    //   861: dup
    //   862: invokespecial 116	org/json/JSONObject:<init>	()V
    //   865: astore_1
    //   866: aload_1
    //   867: ldc 232
    //   869: iconst_3
    //   870: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   873: pop
    //   874: aload_1
    //   875: ldc 237
    //   877: ldc_w 978
    //   880: invokevirtual 122	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   883: pop
    //   884: aload_0
    //   885: aload_2
    //   886: iconst_1
    //   887: anewarray 126	java/lang/String
    //   890: dup
    //   891: iconst_0
    //   892: aload_1
    //   893: invokevirtual 240	org/json/JSONObject:toString	()Ljava/lang/String;
    //   896: aastore
    //   897: invokespecial 525	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   900: aload_0
    //   901: aconst_null
    //   902: iconst_0
    //   903: aload 11
    //   905: lconst_0
    //   906: ldc 250
    //   908: ldc_w 980
    //   911: ldc 254
    //   913: sipush 153
    //   916: getstatic 248	com/tencent/mobileqq/vas/theme/ThemeReporter:a	Ljava/lang/String;
    //   919: iconst_2
    //   920: aload 10
    //   922: ldc_w 256
    //   925: invokevirtual 260	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   928: aload_0
    //   929: monitorexit
    //   930: return
    //   931: astore_1
    //   932: goto +83 -> 1015
    //   935: astore_1
    //   936: goto +154 -> 1090
    //   939: astore_1
    //   940: aload_0
    //   941: aload_2
    //   942: aload_1
    //   943: invokevirtual 265	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   946: invokespecial 727	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJsOnError	(Ljava/lang/String;Ljava/lang/String;)V
    //   949: new 214	java/lang/StringBuilder
    //   952: dup
    //   953: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   956: astore_2
    //   957: aload_2
    //   958: ldc_w 982
    //   961: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: pop
    //   965: aload_2
    //   966: aload_1
    //   967: invokevirtual 265	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   970: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: pop
    //   974: ldc 17
    //   976: iconst_1
    //   977: aload_2
    //   978: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   981: invokestatic 268	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   984: aload_0
    //   985: aconst_null
    //   986: iconst_0
    //   987: ldc_w 256
    //   990: lconst_0
    //   991: aconst_null
    //   992: aconst_null
    //   993: ldc 254
    //   995: sipush 153
    //   998: getstatic 248	com/tencent/mobileqq/vas/theme/ThemeReporter:a	Ljava/lang/String;
    //   1001: bipush 221
    //   1003: ldc_w 256
    //   1006: ldc_w 256
    //   1009: invokevirtual 260	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   1012: goto +75 -> 1087
    //   1015: aload_0
    //   1016: aload_2
    //   1017: aload_1
    //   1018: invokevirtual 983	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1021: invokespecial 727	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJsOnError	(Ljava/lang/String;Ljava/lang/String;)V
    //   1024: new 214	java/lang/StringBuilder
    //   1027: dup
    //   1028: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   1031: astore_2
    //   1032: aload_2
    //   1033: ldc_w 985
    //   1036: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: pop
    //   1040: aload_2
    //   1041: aload_1
    //   1042: invokevirtual 983	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1045: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: pop
    //   1049: ldc 17
    //   1051: iconst_1
    //   1052: aload_2
    //   1053: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1056: invokestatic 268	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1059: aload_0
    //   1060: aconst_null
    //   1061: iconst_0
    //   1062: ldc_w 256
    //   1065: lconst_0
    //   1066: aconst_null
    //   1067: aconst_null
    //   1068: ldc 254
    //   1070: sipush 153
    //   1073: getstatic 248	com/tencent/mobileqq/vas/theme/ThemeReporter:a	Ljava/lang/String;
    //   1076: bipush 220
    //   1078: ldc_w 256
    //   1081: ldc_w 256
    //   1084: invokevirtual 260	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:reportTheme	(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   1087: aload_0
    //   1088: monitorexit
    //   1089: return
    //   1090: aload_0
    //   1091: monitorexit
    //   1092: aload_1
    //   1093: athrow
    //   1094: iconst_0
    //   1095: istore 6
    //   1097: goto -707 -> 390
    //   1100: iconst_0
    //   1101: istore 7
    //   1103: iload 6
    //   1105: ifne -412 -> 693
    //   1108: iload 7
    //   1110: ifeq +6 -> 1116
    //   1113: goto -420 -> 693
    //   1116: iload 5
    //   1118: iconst_1
    //   1119: if_icmpne +9 -> 1128
    //   1122: iconst_1
    //   1123: istore 6
    //   1125: goto -718 -> 407
    //   1128: iconst_0
    //   1129: istore 6
    //   1131: goto -724 -> 407
    //   1134: iconst_0
    //   1135: istore 4
    //   1137: goto -713 -> 424
    //   1140: iconst_0
    //   1141: istore 8
    //   1143: goto -396 -> 747
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1146	0	this	ThemeJsPlugin
    //   0	1146	1	paramJSONObject	JSONObject
    //   0	1146	2	paramString	String
    //   0	1146	3	paramThemeLocator	ThemeLocator
    //   28	1108	4	i	int
    //   38	1082	5	j	int
    //   43	1087	6	bool1	boolean
    //   402	707	7	bool2	boolean
    //   742	400	8	bool3	boolean
    //   57	640	9	localObject	Object
    //   8	913	10	str1	String
    //   16	888	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   50	138	141	org/json/JSONException
    //   2	45	931	org/json/JSONException
    //   145	359	931	org/json/JSONException
    //   362	373	931	org/json/JSONException
    //   377	384	931	org/json/JSONException
    //   394	401	931	org/json/JSONException
    //   407	418	931	org/json/JSONException
    //   424	486	931	org/json/JSONException
    //   497	512	931	org/json/JSONException
    //   512	675	931	org/json/JSONException
    //   678	690	931	org/json/JSONException
    //   701	735	931	org/json/JSONException
    //   747	753	931	org/json/JSONException
    //   753	839	931	org/json/JSONException
    //   839	928	931	org/json/JSONException
    //   2	45	935	finally
    //   50	138	935	finally
    //   145	359	935	finally
    //   362	373	935	finally
    //   377	384	935	finally
    //   394	401	935	finally
    //   407	418	935	finally
    //   424	486	935	finally
    //   497	512	935	finally
    //   512	675	935	finally
    //   678	690	935	finally
    //   701	735	935	finally
    //   747	753	935	finally
    //   753	839	935	finally
    //   839	928	935	finally
    //   940	1012	935	finally
    //   1015	1087	935	finally
    //   2	45	939	java/lang/Exception
    //   50	138	939	java/lang/Exception
    //   145	359	939	java/lang/Exception
    //   362	373	939	java/lang/Exception
    //   377	384	939	java/lang/Exception
    //   394	401	939	java/lang/Exception
    //   407	418	939	java/lang/Exception
    //   424	486	939	java/lang/Exception
    //   497	512	939	java/lang/Exception
    //   512	675	939	java/lang/Exception
    //   678	690	939	java/lang/Exception
    //   701	735	939	java/lang/Exception
    //   747	753	939	java/lang/Exception
    //   753	839	939	java/lang/Exception
    //   839	928	939	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin
 * JD-Core Version:    0.7.0.1
 */