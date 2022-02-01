package com.tencent.qqmini.minigame.plugins;

import android.util.DisplayMetrics;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import org.json.JSONObject;

@JsPlugin
public class GameSystemInfoPlugin
  extends BaseJsPlugin
{
  private static final String DISPLAY_NOTCH_STATUS = "display_notch_status";
  public static final String TAG = "SystemInfoPlugin";
  private MiniAppProxy mMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
  
  /* Error */
  private JSONObject getGameSystemInfo(android.content.Context paramContext, MiniAppProxy paramMiniAppProxy, DisplayMetrics paramDisplayMetrics, int paramInt1, int paramInt2, boolean paramBoolean)
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
    //   19: astore 17
    //   21: new 47	org/json/JSONObject
    //   24: dup
    //   25: invokespecial 48	org/json/JSONObject:<init>	()V
    //   28: astore 16
    //   30: aload_3
    //   31: getfield 54	android/util/DisplayMetrics:density	F
    //   34: f2d
    //   35: dstore 7
    //   37: aload_3
    //   38: getfield 58	android/util/DisplayMetrics:widthPixels	I
    //   41: istore 13
    //   43: aload_3
    //   44: getfield 61	android/util/DisplayMetrics:heightPixels	I
    //   47: istore 14
    //   49: aload_1
    //   50: invokestatic 67	com/tencent/qqmini/sdk/launcher/utils/DisplayUtil:getStatusBarHeight	(Landroid/content/Context;)I
    //   53: istore 12
    //   55: getstatic 72	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   58: ldc 74
    //   60: invokevirtual 80	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   63: ifeq +708 -> 771
    //   66: aload_1
    //   67: invokevirtual 86	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   70: ldc 9
    //   72: iconst_0
    //   73: invokestatic 92	android/provider/Settings$Secure:getInt	(Landroid/content/ContentResolver;Ljava/lang/String;I)I
    //   76: iconst_1
    //   77: if_icmpne +710 -> 787
    //   80: iconst_1
    //   81: istore 9
    //   83: goto +694 -> 777
    //   86: aload 16
    //   88: ldc 94
    //   90: getstatic 97	android/os/Build:BRAND	Ljava/lang/String;
    //   93: invokevirtual 101	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   96: pop
    //   97: aload 16
    //   99: ldc 103
    //   101: getstatic 106	android/os/Build:MODEL	Ljava/lang/String;
    //   104: invokevirtual 101	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   107: pop
    //   108: iload 6
    //   110: ifeq +563 -> 673
    //   113: iload 13
    //   115: iload 14
    //   117: invokestatic 112	java/lang/Math:min	(II)I
    //   120: istore 11
    //   122: iload 13
    //   124: iload 14
    //   126: invokestatic 115	java/lang/Math:max	(II)I
    //   129: istore 9
    //   131: iload 11
    //   133: i2d
    //   134: dload 7
    //   136: ddiv
    //   137: d2i
    //   138: istore 13
    //   140: iload 9
    //   142: i2d
    //   143: dload 7
    //   145: ddiv
    //   146: d2i
    //   147: istore 14
    //   149: aload 16
    //   151: ldc 117
    //   153: dload 7
    //   155: invokevirtual 120	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   158: pop
    //   159: aload 16
    //   161: ldc 122
    //   163: dload 7
    //   165: invokevirtual 120	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   168: pop
    //   169: iload 12
    //   171: i2d
    //   172: dload 7
    //   174: ddiv
    //   175: d2i
    //   176: istore 11
    //   178: iload 14
    //   180: istore 9
    //   182: iload 6
    //   184: ifeq +19 -> 203
    //   187: iload 14
    //   189: istore 9
    //   191: iload 10
    //   193: ifeq +10 -> 203
    //   196: iload 14
    //   198: iload 11
    //   200: isub
    //   201: istore 9
    //   203: iload 4
    //   205: ifle +559 -> 764
    //   208: iload 5
    //   210: ifle +554 -> 764
    //   213: iload 4
    //   215: i2d
    //   216: dload 7
    //   218: ddiv
    //   219: d2i
    //   220: istore 4
    //   222: iload 5
    //   224: i2d
    //   225: dload 7
    //   227: ddiv
    //   228: d2i
    //   229: istore 5
    //   231: iload 4
    //   233: ifeq +531 -> 764
    //   236: iload 5
    //   238: ifeq +526 -> 764
    //   241: iload 4
    //   243: istore 9
    //   245: iload 5
    //   247: istore 4
    //   249: aload 17
    //   251: aload 17
    //   253: invokestatic 128	com/tencent/qqmini/sdk/utils/ImmersiveUtils:getNotchHeight	(Landroid/content/Context;Landroid/app/Activity;)I
    //   256: i2d
    //   257: dload 7
    //   259: ddiv
    //   260: d2i
    //   261: istore 10
    //   263: iload 10
    //   265: istore 5
    //   267: iload 10
    //   269: ifne +59 -> 328
    //   272: aload_0
    //   273: getfield 132	com/tencent/qqmini/minigame/plugins/GameSystemInfoPlugin:mApkgInfo	Lcom/tencent/qqmini/sdk/launcher/core/model/ApkgInfo;
    //   276: getfield 137	com/tencent/qqmini/sdk/launcher/core/model/ApkgInfo:mConfigStr	Ljava/lang/String;
    //   279: invokestatic 143	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   282: istore 15
    //   284: iload 10
    //   286: istore 5
    //   288: iload 15
    //   290: ifne +38 -> 328
    //   293: new 47	org/json/JSONObject
    //   296: dup
    //   297: aload_0
    //   298: getfield 132	com/tencent/qqmini/minigame/plugins/GameSystemInfoPlugin:mApkgInfo	Lcom/tencent/qqmini/sdk/launcher/core/model/ApkgInfo;
    //   301: getfield 137	com/tencent/qqmini/sdk/launcher/core/model/ApkgInfo:mConfigStr	Ljava/lang/String;
    //   304: invokespecial 146	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   307: ldc 148
    //   309: iconst_0
    //   310: invokevirtual 152	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   313: istore 15
    //   315: iload 10
    //   317: istore 5
    //   319: iload 15
    //   321: ifeq +7 -> 328
    //   324: iload 11
    //   326: istore 5
    //   328: new 47	org/json/JSONObject
    //   331: dup
    //   332: invokespecial 48	org/json/JSONObject:<init>	()V
    //   335: astore_3
    //   336: aload_3
    //   337: ldc 154
    //   339: iconst_0
    //   340: invokevirtual 157	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   343: pop
    //   344: aload_3
    //   345: ldc 159
    //   347: iload 5
    //   349: invokevirtual 157	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   352: pop
    //   353: aload_3
    //   354: ldc 161
    //   356: iload 9
    //   358: invokevirtual 157	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   361: pop
    //   362: aload_3
    //   363: ldc 163
    //   365: iload 4
    //   367: invokevirtual 157	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   370: pop
    //   371: aload_3
    //   372: ldc 165
    //   374: iload 9
    //   376: iconst_0
    //   377: isub
    //   378: invokevirtual 157	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   381: pop
    //   382: aload_3
    //   383: ldc 167
    //   385: iload 4
    //   387: iload 5
    //   389: isub
    //   390: invokevirtual 157	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   393: pop
    //   394: aload 16
    //   396: ldc 169
    //   398: iload 9
    //   400: invokevirtual 157	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   403: pop
    //   404: aload 16
    //   406: ldc 171
    //   408: iload 4
    //   410: invokevirtual 157	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   413: pop
    //   414: aload 16
    //   416: ldc 173
    //   418: iload 9
    //   420: invokevirtual 157	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   423: pop
    //   424: aload 16
    //   426: ldc 175
    //   428: iload 4
    //   430: invokevirtual 157	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   433: pop
    //   434: aload 16
    //   436: ldc 177
    //   438: iload 11
    //   440: invokevirtual 157	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   443: pop
    //   444: aload 16
    //   446: ldc 179
    //   448: ldc 181
    //   450: invokevirtual 101	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   453: pop
    //   454: aload 16
    //   456: ldc 183
    //   458: new 185	java/lang/StringBuilder
    //   461: dup
    //   462: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   465: ldc 188
    //   467: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: getstatic 197	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   473: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   479: invokevirtual 101	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   482: pop
    //   483: aload 16
    //   485: ldc 203
    //   487: ldc 205
    //   489: invokevirtual 101	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   492: pop
    //   493: aload 16
    //   495: ldc 207
    //   497: bipush 16
    //   499: invokevirtual 157	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   502: pop
    //   503: aload 16
    //   505: ldc 209
    //   507: invokestatic 215	com/tencent/qqmini/sdk/core/utils/DeviceUtil:getDeviceBenchmarkLevel	()I
    //   510: invokevirtual 157	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   513: pop
    //   514: aload 16
    //   516: ldc 217
    //   518: aload_3
    //   519: invokevirtual 101	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   522: pop
    //   523: aload_2
    //   524: ifnull +27 -> 551
    //   527: aload 16
    //   529: ldc 219
    //   531: aload_2
    //   532: invokevirtual 222	com/tencent/qqmini/sdk/launcher/core/proxy/MiniAppProxy:getAppVersion	()Ljava/lang/String;
    //   535: invokevirtual 101	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   538: pop
    //   539: aload 16
    //   541: ldc 224
    //   543: aload_2
    //   544: invokevirtual 227	com/tencent/qqmini/sdk/launcher/core/proxy/MiniAppProxy:getAppName	()Ljava/lang/String;
    //   547: invokevirtual 101	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   550: pop
    //   551: new 47	org/json/JSONObject
    //   554: dup
    //   555: invokespecial 48	org/json/JSONObject:<init>	()V
    //   558: astore_2
    //   559: aload_1
    //   560: ldc 228
    //   562: invokestatic 232	com/tencent/qqmini/sdk/launcher/utils/DisplayUtil:dip2px	(Landroid/content/Context;F)I
    //   565: istore 5
    //   567: invokestatic 238	com/tencent/qqmini/sdk/launcher/utils/LiuHaiUtils:isLiuHaiUseValid	()Z
    //   570: ifeq +188 -> 758
    //   573: iload 6
    //   575: ifne +183 -> 758
    //   578: iload 12
    //   580: istore 4
    //   582: aload_2
    //   583: ldc 240
    //   585: iload 4
    //   587: iload 5
    //   589: iadd
    //   590: invokevirtual 157	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   593: pop
    //   594: aload_2
    //   595: ldc 242
    //   597: aload_1
    //   598: ldc 243
    //   600: invokestatic 232	com/tencent/qqmini/sdk/launcher/utils/DisplayUtil:dip2px	(Landroid/content/Context;F)I
    //   603: invokevirtual 157	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   606: pop
    //   607: aload_2
    //   608: ldc 245
    //   610: aload_1
    //   611: ldc 246
    //   613: invokestatic 232	com/tencent/qqmini/sdk/launcher/utils/DisplayUtil:dip2px	(Landroid/content/Context;F)I
    //   616: invokevirtual 157	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   619: pop
    //   620: aload_2
    //   621: ldc 248
    //   623: aload_1
    //   624: ldc 249
    //   626: invokestatic 232	com/tencent/qqmini/sdk/launcher/utils/DisplayUtil:dip2px	(Landroid/content/Context;F)I
    //   629: invokevirtual 157	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   632: pop
    //   633: aload 16
    //   635: ldc 251
    //   637: aload_2
    //   638: invokevirtual 101	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   641: pop
    //   642: ldc 12
    //   644: new 185	java/lang/StringBuilder
    //   647: dup
    //   648: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   651: ldc 253
    //   653: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: aload 16
    //   658: invokevirtual 254	org/json/JSONObject:toString	()Ljava/lang/String;
    //   661: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   667: invokestatic 260	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   670: goto +114 -> 784
    //   673: iload 13
    //   675: iload 14
    //   677: invokestatic 115	java/lang/Math:max	(II)I
    //   680: istore 11
    //   682: iload 13
    //   684: iload 14
    //   686: invokestatic 112	java/lang/Math:min	(II)I
    //   689: istore 9
    //   691: goto -560 -> 131
    //   694: astore_3
    //   695: ldc 12
    //   697: ldc_w 262
    //   700: aload_3
    //   701: invokestatic 266	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   704: iload 10
    //   706: istore 5
    //   708: goto -380 -> 328
    //   711: astore_1
    //   712: ldc 12
    //   714: new 185	java/lang/StringBuilder
    //   717: dup
    //   718: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   721: ldc_w 268
    //   724: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: aload_1
    //   728: invokevirtual 271	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   731: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   737: invokestatic 273	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   740: goto +44 -> 784
    //   743: astore 17
    //   745: ldc 12
    //   747: ldc_w 275
    //   750: aload 17
    //   752: invokestatic 266	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   755: goto -361 -> 394
    //   758: iconst_0
    //   759: istore 4
    //   761: goto -179 -> 582
    //   764: iload 13
    //   766: istore 4
    //   768: goto -519 -> 249
    //   771: iconst_0
    //   772: istore 10
    //   774: goto -688 -> 86
    //   777: iload 9
    //   779: istore 10
    //   781: goto -695 -> 86
    //   784: aload 16
    //   786: areturn
    //   787: iconst_0
    //   788: istore 9
    //   790: goto -13 -> 777
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	793	0	this	GameSystemInfoPlugin
    //   0	793	1	paramContext	android.content.Context
    //   0	793	2	paramMiniAppProxy	MiniAppProxy
    //   0	793	3	paramDisplayMetrics	DisplayMetrics
    //   0	793	4	paramInt1	int
    //   0	793	5	paramInt2	int
    //   0	793	6	paramBoolean	boolean
    //   35	223	7	d	double
    //   81	708	9	i	int
    //   191	589	10	j	int
    //   120	561	11	k	int
    //   53	526	12	m	int
    //   41	724	13	n	int
    //   47	638	14	i1	int
    //   282	38	15	bool	boolean
    //   28	757	16	localJSONObject	JSONObject
    //   19	233	17	localActivity	android.app.Activity
    //   743	8	17	localJSONException	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   293	315	694	org/json/JSONException
    //   30	80	711	java/lang/Exception
    //   86	108	711	java/lang/Exception
    //   113	131	711	java/lang/Exception
    //   131	178	711	java/lang/Exception
    //   213	231	711	java/lang/Exception
    //   249	263	711	java/lang/Exception
    //   272	284	711	java/lang/Exception
    //   293	315	711	java/lang/Exception
    //   328	336	711	java/lang/Exception
    //   336	394	711	java/lang/Exception
    //   394	523	711	java/lang/Exception
    //   527	551	711	java/lang/Exception
    //   551	573	711	java/lang/Exception
    //   582	670	711	java/lang/Exception
    //   673	691	711	java/lang/Exception
    //   695	704	711	java/lang/Exception
    //   745	755	711	java/lang/Exception
    //   336	394	743	org/json/JSONException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.GameSystemInfoPlugin
 * JD-Core Version:    0.7.0.1
 */