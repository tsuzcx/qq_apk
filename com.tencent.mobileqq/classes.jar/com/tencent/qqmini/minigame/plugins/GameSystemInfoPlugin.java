package com.tencent.qqmini.minigame.plugins;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class GameSystemInfoPlugin
  extends BaseJsPlugin
{
  private static final String DISPLAY_NOTCH_STATUS = "display_notch_status";
  public static final String TAG = "SystemInfoPlugin";
  private MiniAppProxy mMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
  
  /* Error */
  private JSONObject getGameSystemInfo(Context paramContext, MiniAppProxy paramMiniAppProxy, DisplayMetrics paramDisplayMetrics, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: aload_3
    //   5: ifnonnull +5 -> 10
    //   8: aconst_null
    //   9: areturn
    //   10: aload_0
    //   11: getfield 39	com/tencent/qqmini/minigame/plugins/GameSystemInfoPlugin:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   14: invokeinterface 45 1 0
    //   19: astore 16
    //   21: new 47	org/json/JSONObject
    //   24: dup
    //   25: invokespecial 48	org/json/JSONObject:<init>	()V
    //   28: astore 15
    //   30: aload_3
    //   31: getfield 54	android/util/DisplayMetrics:density	F
    //   34: f2d
    //   35: dstore 7
    //   37: aload_3
    //   38: getfield 58	android/util/DisplayMetrics:widthPixels	I
    //   41: istore 9
    //   43: aload_3
    //   44: getfield 61	android/util/DisplayMetrics:heightPixels	I
    //   47: istore 12
    //   49: aload_1
    //   50: invokestatic 67	com/tencent/qqmini/sdk/launcher/utils/DisplayUtil:getStatusBarHeight	(Landroid/content/Context;)I
    //   53: istore 11
    //   55: aload_0
    //   56: aload_1
    //   57: iconst_0
    //   58: invokespecial 71	com/tencent/qqmini/minigame/plugins/GameSystemInfoPlugin:processHuaweiNotchStatus	(Landroid/content/Context;Z)Z
    //   61: istore 14
    //   63: aload 15
    //   65: ldc 73
    //   67: getstatic 78	android/os/Build:BRAND	Ljava/lang/String;
    //   70: invokevirtual 82	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   73: pop
    //   74: aload 15
    //   76: ldc 84
    //   78: getstatic 87	android/os/Build:MODEL	Ljava/lang/String;
    //   81: invokevirtual 82	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   84: pop
    //   85: iload 6
    //   87: ifeq +523 -> 610
    //   90: iload 9
    //   92: iload 12
    //   94: invokestatic 93	java/lang/Math:min	(II)I
    //   97: istore 10
    //   99: iload 9
    //   101: iload 12
    //   103: invokestatic 96	java/lang/Math:max	(II)I
    //   106: istore 9
    //   108: iload 10
    //   110: i2d
    //   111: dload 7
    //   113: ddiv
    //   114: d2i
    //   115: istore 10
    //   117: iload 9
    //   119: i2d
    //   120: dload 7
    //   122: ddiv
    //   123: d2i
    //   124: istore 12
    //   126: aload 15
    //   128: ldc 98
    //   130: dload 7
    //   132: invokevirtual 101	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   135: pop
    //   136: aload 15
    //   138: ldc 103
    //   140: dload 7
    //   142: invokevirtual 101	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   145: pop
    //   146: iload 11
    //   148: i2d
    //   149: dload 7
    //   151: ddiv
    //   152: d2i
    //   153: istore 13
    //   155: iload 12
    //   157: istore 9
    //   159: iload 6
    //   161: ifeq +19 -> 180
    //   164: iload 12
    //   166: istore 9
    //   168: iload 14
    //   170: ifeq +10 -> 180
    //   173: iload 12
    //   175: iload 13
    //   177: isub
    //   178: istore 9
    //   180: iload 4
    //   182: ifle +469 -> 651
    //   185: iload 5
    //   187: ifle +464 -> 651
    //   190: iload 4
    //   192: i2d
    //   193: dload 7
    //   195: ddiv
    //   196: d2i
    //   197: istore 12
    //   199: iload 5
    //   201: i2d
    //   202: dload 7
    //   204: ddiv
    //   205: d2i
    //   206: istore 4
    //   208: iload 12
    //   210: ifeq +441 -> 651
    //   213: iload 4
    //   215: ifeq +436 -> 651
    //   218: iload 12
    //   220: istore 5
    //   222: aload_0
    //   223: aload 16
    //   225: dload 7
    //   227: iload 13
    //   229: invokespecial 107	com/tencent/qqmini/minigame/plugins/GameSystemInfoPlugin:getSafeAreaTop	(Landroid/app/Activity;DI)I
    //   232: istore 9
    //   234: new 47	org/json/JSONObject
    //   237: dup
    //   238: invokespecial 48	org/json/JSONObject:<init>	()V
    //   241: astore_3
    //   242: aload_3
    //   243: ldc 109
    //   245: iconst_0
    //   246: invokevirtual 112	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   249: pop
    //   250: aload_3
    //   251: ldc 114
    //   253: iload 9
    //   255: invokevirtual 112	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   258: pop
    //   259: aload_3
    //   260: ldc 116
    //   262: iload 5
    //   264: invokevirtual 112	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   267: pop
    //   268: aload_3
    //   269: ldc 118
    //   271: iload 4
    //   273: invokevirtual 112	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   276: pop
    //   277: aload_3
    //   278: ldc 120
    //   280: iload 5
    //   282: iconst_0
    //   283: isub
    //   284: invokevirtual 112	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   287: pop
    //   288: aload_3
    //   289: ldc 122
    //   291: iload 4
    //   293: iload 9
    //   295: isub
    //   296: invokevirtual 112	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   299: pop
    //   300: aload 15
    //   302: ldc 124
    //   304: iload 5
    //   306: invokevirtual 112	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   309: pop
    //   310: aload 15
    //   312: ldc 126
    //   314: iload 4
    //   316: invokevirtual 112	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   319: pop
    //   320: aload 15
    //   322: ldc 128
    //   324: iload 5
    //   326: invokevirtual 112	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   329: pop
    //   330: aload 15
    //   332: ldc 130
    //   334: iload 4
    //   336: invokevirtual 112	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   339: pop
    //   340: aload 15
    //   342: ldc 132
    //   344: iload 13
    //   346: invokevirtual 112	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   349: pop
    //   350: aload 15
    //   352: ldc 134
    //   354: ldc 136
    //   356: invokevirtual 82	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   359: pop
    //   360: aload 15
    //   362: ldc 138
    //   364: new 140	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   371: ldc 143
    //   373: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: getstatic 152	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   379: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: invokevirtual 82	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   388: pop
    //   389: aload 15
    //   391: ldc 158
    //   393: ldc 160
    //   395: invokevirtual 82	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   398: pop
    //   399: aload 15
    //   401: ldc 162
    //   403: bipush 16
    //   405: invokevirtual 112	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   408: pop
    //   409: aload 15
    //   411: ldc 164
    //   413: invokestatic 170	com/tencent/qqmini/sdk/core/utils/DeviceUtil:getDeviceBenchmarkLevel	()I
    //   416: invokevirtual 112	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   419: pop
    //   420: aload 15
    //   422: ldc 172
    //   424: aload_3
    //   425: invokevirtual 82	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   428: pop
    //   429: aload_2
    //   430: ifnull +27 -> 457
    //   433: aload 15
    //   435: ldc 174
    //   437: aload_2
    //   438: invokevirtual 177	com/tencent/qqmini/sdk/launcher/core/proxy/MiniAppProxy:getAppVersion	()Ljava/lang/String;
    //   441: invokevirtual 82	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   444: pop
    //   445: aload 15
    //   447: ldc 179
    //   449: aload_2
    //   450: invokevirtual 182	com/tencent/qqmini/sdk/launcher/core/proxy/MiniAppProxy:getAppName	()Ljava/lang/String;
    //   453: invokevirtual 82	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   456: pop
    //   457: new 47	org/json/JSONObject
    //   460: dup
    //   461: invokespecial 48	org/json/JSONObject:<init>	()V
    //   464: astore_2
    //   465: aload_1
    //   466: ldc 183
    //   468: invokestatic 187	com/tencent/qqmini/sdk/launcher/utils/DisplayUtil:dip2px	(Landroid/content/Context;F)I
    //   471: istore 5
    //   473: invokestatic 193	com/tencent/qqmini/sdk/launcher/utils/LiuHaiUtils:isLiuHaiUseValid	()Z
    //   476: ifeq +169 -> 645
    //   479: iload 6
    //   481: ifne +164 -> 645
    //   484: iload 11
    //   486: istore 4
    //   488: aload_2
    //   489: ldc 195
    //   491: iload 4
    //   493: iload 5
    //   495: iadd
    //   496: invokevirtual 112	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   499: pop
    //   500: aload_2
    //   501: ldc 197
    //   503: aload_1
    //   504: ldc 198
    //   506: invokestatic 187	com/tencent/qqmini/sdk/launcher/utils/DisplayUtil:dip2px	(Landroid/content/Context;F)I
    //   509: invokevirtual 112	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   512: pop
    //   513: aload_2
    //   514: ldc 200
    //   516: aload_1
    //   517: ldc 201
    //   519: invokestatic 187	com/tencent/qqmini/sdk/launcher/utils/DisplayUtil:dip2px	(Landroid/content/Context;F)I
    //   522: invokevirtual 112	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   525: pop
    //   526: aload_2
    //   527: ldc 203
    //   529: aload_1
    //   530: ldc 204
    //   532: invokestatic 187	com/tencent/qqmini/sdk/launcher/utils/DisplayUtil:dip2px	(Landroid/content/Context;F)I
    //   535: invokevirtual 112	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   538: pop
    //   539: aload 15
    //   541: ldc 206
    //   543: aload_2
    //   544: invokevirtual 82	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   547: pop
    //   548: ldc 12
    //   550: new 140	java/lang/StringBuilder
    //   553: dup
    //   554: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   557: ldc 208
    //   559: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: aload 15
    //   564: invokevirtual 209	org/json/JSONObject:toString	()Ljava/lang/String;
    //   567: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   573: invokestatic 215	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   576: aload 15
    //   578: areturn
    //   579: astore_1
    //   580: ldc 12
    //   582: new 140	java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   589: ldc 217
    //   591: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: aload_1
    //   595: invokevirtual 220	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   598: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   604: invokestatic 223	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   607: aload 15
    //   609: areturn
    //   610: iload 9
    //   612: iload 12
    //   614: invokestatic 96	java/lang/Math:max	(II)I
    //   617: istore 10
    //   619: iload 9
    //   621: iload 12
    //   623: invokestatic 93	java/lang/Math:min	(II)I
    //   626: istore 9
    //   628: goto -520 -> 108
    //   631: astore 16
    //   633: ldc 12
    //   635: ldc 225
    //   637: aload 16
    //   639: invokestatic 228	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   642: goto -342 -> 300
    //   645: iconst_0
    //   646: istore 4
    //   648: goto -160 -> 488
    //   651: iload 9
    //   653: istore 5
    //   655: iload 10
    //   657: istore 4
    //   659: goto -437 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	662	0	this	GameSystemInfoPlugin
    //   0	662	1	paramContext	Context
    //   0	662	2	paramMiniAppProxy	MiniAppProxy
    //   0	662	3	paramDisplayMetrics	DisplayMetrics
    //   0	662	4	paramInt1	int
    //   0	662	5	paramInt2	int
    //   0	662	6	paramBoolean	boolean
    //   35	191	7	d	double
    //   41	611	9	i	int
    //   97	559	10	j	int
    //   53	432	11	k	int
    //   47	575	12	m	int
    //   153	192	13	n	int
    //   61	108	14	bool	boolean
    //   28	580	15	localJSONObject	JSONObject
    //   19	205	16	localActivity	Activity
    //   631	7	16	localJSONException	JSONException
    // Exception table:
    //   from	to	target	type
    //   30	85	579	java/lang/Exception
    //   90	108	579	java/lang/Exception
    //   108	155	579	java/lang/Exception
    //   190	208	579	java/lang/Exception
    //   222	242	579	java/lang/Exception
    //   242	300	579	java/lang/Exception
    //   300	429	579	java/lang/Exception
    //   433	457	579	java/lang/Exception
    //   457	479	579	java/lang/Exception
    //   488	576	579	java/lang/Exception
    //   610	628	579	java/lang/Exception
    //   633	642	579	java/lang/Exception
    //   242	300	631	org/json/JSONException
  }
  
  private int getSafeAreaTop(Activity paramActivity, double paramDouble, int paramInt)
  {
    int i = (int)(ImmersiveUtils.getNotchHeight(paramActivity, paramActivity) / paramDouble);
    int j = i;
    if (i == 0)
    {
      j = i;
      if (TextUtils.isEmpty(this.mApkgInfo.mConfigStr)) {}
    }
    for (;;)
    {
      try
      {
        boolean bool = new JSONObject(this.mApkgInfo.mConfigStr).optBoolean("showStatusBar", false);
        if (bool)
        {
          j = paramInt;
          return j;
        }
      }
      catch (JSONException paramActivity)
      {
        QMLog.e("SystemInfoPlugin", "safeAreaTop JSONException:", paramActivity);
        return i;
      }
      paramInt = i;
    }
  }
  
  private boolean processHuaweiNotchStatus(Context paramContext, boolean paramBoolean)
  {
    if (Build.MANUFACTURER.equalsIgnoreCase("huawei")) {
      return Settings.Secure.getInt(paramContext.getContentResolver(), "display_notch_status", 0) == 1;
    }
    return paramBoolean;
  }
  
  @JsEvent({"getSystemInfo", "getSystemInfoSync"})
  public String handleGetSystemInfo(RequestEvent paramRequestEvent)
  {
    if ((this.mMiniAppContext == null) || (this.mMiniAppContext.getContext() == null))
    {
      QMLog.e("SystemInfoPlugin", "getSystemInfo error,context is NULL");
      return paramRequestEvent.fail();
    }
    Object localObject = DisplayUtil.getDisplayMetrics(this.mContext);
    int i;
    int j;
    if (localObject != null)
    {
      i = PageAction.obtain(this.mMiniAppContext).getSurfaceViewWidth();
      j = PageAction.obtain(this.mMiniAppContext).getSurfaceViewHeight();
    }
    for (localObject = getGameSystemInfo(this.mMiniAppContext.getContext(), this.mMiniAppProxy, (DisplayMetrics)localObject, i, j, this.mMiniAppContext.isOrientationLandscape());; localObject = null)
    {
      if (localObject == null) {
        return paramRequestEvent.fail();
      }
      String str = ((JSONObject)localObject).toString();
      if ("getSystemInfo".equals(paramRequestEvent.event))
      {
        paramRequestEvent.evaluateCallbackJs(str);
        return str;
      }
      return ((JSONObject)localObject).toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.GameSystemInfoPlugin
 * JD-Core Version:    0.7.0.1
 */