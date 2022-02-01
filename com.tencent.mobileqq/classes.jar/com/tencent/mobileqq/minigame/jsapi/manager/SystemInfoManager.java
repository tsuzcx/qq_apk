package com.tencent.mobileqq.minigame.jsapi.manager;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.provider.Settings.Secure;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.minigame.jsapi.callbacks.IGameUI;
import org.json.JSONObject;

public class SystemInfoManager
{
  private static final String DISPLAY_NOTCH_STATUS = "display_notch_status";
  private static final String TAG = "SystemInfoManager";
  private Activity mActivity;
  private Context mAppContext;
  private float mDensity;
  private IGameUI mIGameUI;
  private boolean mIsHideNotchSwitchOpen;
  private boolean mIsLandscape;
  private int mScreenHeightPixels;
  private int mScreenWidthPixels;
  private int mStatusBarHeight;
  private JSONObject mSystemInfo;
  
  public SystemInfoManager(Context paramContext)
  {
    this.mAppContext = paramContext.getApplicationContext();
    DisplayMetrics localDisplayMetrics = DisplayUtil.getDisplayMetrics(paramContext);
    this.mDensity = localDisplayMetrics.density;
    this.mScreenWidthPixels = localDisplayMetrics.widthPixels;
    this.mScreenHeightPixels = localDisplayMetrics.heightPixels;
    this.mStatusBarHeight = DisplayUtil.getStatusBarHeight(paramContext);
    if (Build.MANUFACTURER.equalsIgnoreCase("huawei")) {
      if (Settings.Secure.getInt(paramContext.getContentResolver(), "display_notch_status", 0) != 1) {
        break label82;
      }
    }
    for (;;)
    {
      this.mIsHideNotchSwitchOpen = bool;
      return;
      label82:
      bool = false;
    }
  }
  
  private boolean isLandscape()
  {
    return this.mIsLandscape;
  }
  
  public int getScreenHeight()
  {
    return this.mScreenHeightPixels;
  }
  
  public float getScreenWidth()
  {
    return this.mScreenWidthPixels;
  }
  
  /* Error */
  public JSONObject getSystemInfo()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 112	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mSystemInfo	Lorg/json/JSONObject;
    //   4: ifnull +8 -> 12
    //   7: aload_0
    //   8: getfield 112	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mSystemInfo	Lorg/json/JSONObject;
    //   11: areturn
    //   12: new 114	org/json/JSONObject
    //   15: dup
    //   16: invokespecial 115	org/json/JSONObject:<init>	()V
    //   19: astore 6
    //   21: aload 6
    //   23: ldc 117
    //   25: getstatic 120	android/os/Build:BRAND	Ljava/lang/String;
    //   28: invokevirtual 124	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   31: pop
    //   32: aload 6
    //   34: ldc 126
    //   36: getstatic 129	android/os/Build:MODEL	Ljava/lang/String;
    //   39: invokevirtual 124	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   42: pop
    //   43: aload_0
    //   44: invokespecial 131	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:isLandscape	()Z
    //   47: ifeq +623 -> 670
    //   50: aload_0
    //   51: getfield 59	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mScreenWidthPixels	I
    //   54: aload_0
    //   55: getfield 64	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mScreenHeightPixels	I
    //   58: invokestatic 137	java/lang/Math:min	(II)I
    //   61: istore_2
    //   62: aload_0
    //   63: getfield 59	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mScreenWidthPixels	I
    //   66: aload_0
    //   67: getfield 64	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mScreenHeightPixels	I
    //   70: invokestatic 140	java/lang/Math:max	(II)I
    //   73: istore_1
    //   74: iload_2
    //   75: i2f
    //   76: aload_0
    //   77: getfield 54	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mDensity	F
    //   80: fdiv
    //   81: f2i
    //   82: istore_3
    //   83: iload_1
    //   84: i2f
    //   85: aload_0
    //   86: getfield 54	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mDensity	F
    //   89: fdiv
    //   90: f2i
    //   91: istore_2
    //   92: aload 6
    //   94: ldc 142
    //   96: aload_0
    //   97: getfield 54	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mDensity	F
    //   100: f2d
    //   101: invokevirtual 145	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   104: pop
    //   105: aload 6
    //   107: ldc 147
    //   109: aload_0
    //   110: getfield 54	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mDensity	F
    //   113: f2d
    //   114: invokevirtual 145	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   117: pop
    //   118: aload_0
    //   119: getfield 70	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mStatusBarHeight	I
    //   122: i2f
    //   123: aload_0
    //   124: getfield 54	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mDensity	F
    //   127: fdiv
    //   128: f2i
    //   129: istore 4
    //   131: iload_2
    //   132: istore_1
    //   133: aload_0
    //   134: invokespecial 131	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:isLandscape	()Z
    //   137: ifeq +17 -> 154
    //   140: iload_2
    //   141: istore_1
    //   142: aload_0
    //   143: getfield 95	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mIsHideNotchSwitchOpen	Z
    //   146: ifeq +8 -> 154
    //   149: iload_2
    //   150: iload 4
    //   152: isub
    //   153: istore_1
    //   154: aload_0
    //   155: getfield 149	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mIGameUI	Lcom/tencent/mobileqq/minigame/jsapi/callbacks/IGameUI;
    //   158: ifnull +560 -> 718
    //   161: aload_0
    //   162: getfield 149	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mIGameUI	Lcom/tencent/mobileqq/minigame/jsapi/callbacks/IGameUI;
    //   165: invokeinterface 155 1 0
    //   170: ifnull +548 -> 718
    //   173: aload_0
    //   174: getfield 149	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mIGameUI	Lcom/tencent/mobileqq/minigame/jsapi/callbacks/IGameUI;
    //   177: invokeinterface 155 1 0
    //   182: invokevirtual 160	android/view/View:getMeasuredWidth	()I
    //   185: i2f
    //   186: aload_0
    //   187: getfield 54	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mDensity	F
    //   190: fdiv
    //   191: f2i
    //   192: istore_2
    //   193: aload_0
    //   194: getfield 149	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mIGameUI	Lcom/tencent/mobileqq/minigame/jsapi/callbacks/IGameUI;
    //   197: invokeinterface 155 1 0
    //   202: invokevirtual 163	android/view/View:getMeasuredHeight	()I
    //   205: i2f
    //   206: aload_0
    //   207: getfield 54	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mDensity	F
    //   210: fdiv
    //   211: f2i
    //   212: istore 5
    //   214: iload_2
    //   215: ifeq +503 -> 718
    //   218: iload 5
    //   220: ifeq +498 -> 718
    //   223: iload 5
    //   225: istore_1
    //   226: aload_0
    //   227: getfield 165	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mActivity	Landroid/app/Activity;
    //   230: aload_0
    //   231: getfield 165	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mActivity	Landroid/app/Activity;
    //   234: invokestatic 171	cooperation/qzone/util/SystemUtil:getNotchHeight	(Landroid/content/Context;Landroid/app/Activity;)I
    //   237: i2f
    //   238: aload_0
    //   239: getfield 54	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mDensity	F
    //   242: fdiv
    //   243: f2i
    //   244: istore 5
    //   246: iload 5
    //   248: istore_3
    //   249: iload 5
    //   251: ifne +6 -> 257
    //   254: iload 4
    //   256: istore_3
    //   257: new 114	org/json/JSONObject
    //   260: dup
    //   261: invokespecial 115	org/json/JSONObject:<init>	()V
    //   264: astore 7
    //   266: aload 7
    //   268: ldc 173
    //   270: iconst_0
    //   271: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   274: pop
    //   275: aload 7
    //   277: ldc 178
    //   279: iload_3
    //   280: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   283: pop
    //   284: aload 7
    //   286: ldc 180
    //   288: iload_2
    //   289: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   292: pop
    //   293: aload 7
    //   295: ldc 182
    //   297: iload_1
    //   298: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   301: pop
    //   302: aload 7
    //   304: ldc 184
    //   306: iload_2
    //   307: iconst_0
    //   308: isub
    //   309: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   312: pop
    //   313: aload 7
    //   315: ldc 186
    //   317: iload_1
    //   318: iload_3
    //   319: isub
    //   320: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   323: pop
    //   324: aload 6
    //   326: ldc 188
    //   328: iload_2
    //   329: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   332: pop
    //   333: aload 6
    //   335: ldc 190
    //   337: iload_1
    //   338: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   341: pop
    //   342: aload 6
    //   344: ldc 192
    //   346: iload_2
    //   347: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   350: pop
    //   351: aload 6
    //   353: ldc 194
    //   355: iload_1
    //   356: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   359: pop
    //   360: aload 6
    //   362: ldc 196
    //   364: iload 4
    //   366: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   369: pop
    //   370: aload 6
    //   372: ldc 198
    //   374: ldc 200
    //   376: invokevirtual 124	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   379: pop
    //   380: aload 6
    //   382: ldc 202
    //   384: new 204	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   391: ldc 207
    //   393: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: getstatic 216	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   399: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokevirtual 124	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   408: pop
    //   409: aload 6
    //   411: ldc 222
    //   413: ldc 224
    //   415: invokevirtual 124	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   418: pop
    //   419: aload 6
    //   421: ldc 226
    //   423: bipush 16
    //   425: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   428: pop
    //   429: aload 6
    //   431: ldc 228
    //   433: invokestatic 233	com/tencent/mobileqq/minigame/utils/DeviceUtil:getDeviceBenchmarkLevel	()I
    //   436: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   439: pop
    //   440: aload 6
    //   442: ldc 235
    //   444: invokestatic 240	com/tencent/mobileqq/utils/DeviceInfoUtil:getQQVersion	()Ljava/lang/String;
    //   447: invokevirtual 124	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   450: pop
    //   451: aload 6
    //   453: ldc 242
    //   455: ldc 244
    //   457: invokevirtual 124	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   460: pop
    //   461: aload 6
    //   463: ldc 246
    //   465: aload 7
    //   467: invokevirtual 124	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   470: pop
    //   471: new 114	org/json/JSONObject
    //   474: dup
    //   475: invokespecial 115	org/json/JSONObject:<init>	()V
    //   478: astore 7
    //   480: aload_0
    //   481: getfield 41	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mAppContext	Landroid/content/Context;
    //   484: ldc 247
    //   486: invokestatic 251	com/tencent/mobileqq/mini/util/DisplayUtil:dip2px	(Landroid/content/Context;F)I
    //   489: istore_2
    //   490: invokestatic 256	dov/com/tencent/mobileqq/richmedia/capture/util/LiuHaiUtils:b	()Z
    //   493: ifeq +220 -> 713
    //   496: aload_0
    //   497: invokespecial 131	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:isLandscape	()Z
    //   500: ifne +213 -> 713
    //   503: aload_0
    //   504: getfield 70	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mStatusBarHeight	I
    //   507: istore_1
    //   508: aload 7
    //   510: ldc_w 258
    //   513: iload_1
    //   514: iload_2
    //   515: iadd
    //   516: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   519: pop
    //   520: aload 7
    //   522: ldc_w 260
    //   525: aload_0
    //   526: getfield 41	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mAppContext	Landroid/content/Context;
    //   529: ldc_w 261
    //   532: invokestatic 251	com/tencent/mobileqq/mini/util/DisplayUtil:dip2px	(Landroid/content/Context;F)I
    //   535: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   538: pop
    //   539: aload 7
    //   541: ldc_w 263
    //   544: aload_0
    //   545: getfield 41	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mAppContext	Landroid/content/Context;
    //   548: ldc_w 264
    //   551: invokestatic 251	com/tencent/mobileqq/mini/util/DisplayUtil:dip2px	(Landroid/content/Context;F)I
    //   554: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   557: pop
    //   558: aload 7
    //   560: ldc_w 266
    //   563: aload_0
    //   564: getfield 41	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mAppContext	Landroid/content/Context;
    //   567: ldc_w 267
    //   570: invokestatic 251	com/tencent/mobileqq/mini/util/DisplayUtil:dip2px	(Landroid/content/Context;F)I
    //   573: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   576: pop
    //   577: aload 6
    //   579: ldc_w 269
    //   582: aload 7
    //   584: invokevirtual 124	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   587: pop
    //   588: aload_0
    //   589: aload 6
    //   591: putfield 112	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mSystemInfo	Lorg/json/JSONObject;
    //   594: invokestatic 275	com/tencent/mobileqq/minigame/utils/GameLog:getInstance	()Lcom/tencent/mobileqq/minigame/utils/GameLog;
    //   597: ldc 11
    //   599: new 204	java/lang/StringBuilder
    //   602: dup
    //   603: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   606: ldc_w 277
    //   609: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: aload_0
    //   613: getfield 112	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mSystemInfo	Lorg/json/JSONObject;
    //   616: invokevirtual 278	org/json/JSONObject:toString	()Ljava/lang/String;
    //   619: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: invokevirtual 282	com/tencent/mobileqq/minigame/utils/GameLog:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   628: pop
    //   629: aload 6
    //   631: areturn
    //   632: astore 7
    //   634: invokestatic 275	com/tencent/mobileqq/minigame/utils/GameLog:getInstance	()Lcom/tencent/mobileqq/minigame/utils/GameLog;
    //   637: ldc 11
    //   639: new 204	java/lang/StringBuilder
    //   642: dup
    //   643: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   646: ldc_w 284
    //   649: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: aload 7
    //   654: invokevirtual 287	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   657: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   663: invokevirtual 290	com/tencent/mobileqq/minigame/utils/GameLog:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   666: pop
    //   667: aload 6
    //   669: areturn
    //   670: aload_0
    //   671: getfield 59	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mScreenWidthPixels	I
    //   674: aload_0
    //   675: getfield 64	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mScreenHeightPixels	I
    //   678: invokestatic 140	java/lang/Math:max	(II)I
    //   681: istore_2
    //   682: aload_0
    //   683: getfield 59	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mScreenWidthPixels	I
    //   686: aload_0
    //   687: getfield 64	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mScreenHeightPixels	I
    //   690: invokestatic 137	java/lang/Math:min	(II)I
    //   693: istore_1
    //   694: goto -620 -> 74
    //   697: astore 8
    //   699: ldc 11
    //   701: iconst_1
    //   702: ldc_w 292
    //   705: aload 8
    //   707: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   710: goto -386 -> 324
    //   713: iconst_0
    //   714: istore_1
    //   715: goto -207 -> 508
    //   718: iload_1
    //   719: istore_2
    //   720: iload_3
    //   721: istore_1
    //   722: goto -496 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	725	0	this	SystemInfoManager
    //   73	649	1	i	int
    //   61	659	2	j	int
    //   82	639	3	k	int
    //   129	236	4	m	int
    //   212	38	5	n	int
    //   19	649	6	localJSONObject1	JSONObject
    //   264	319	7	localJSONObject2	JSONObject
    //   632	21	7	localException	java.lang.Exception
    //   697	9	8	localJSONException	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   21	74	632	java/lang/Exception
    //   74	131	632	java/lang/Exception
    //   133	140	632	java/lang/Exception
    //   142	149	632	java/lang/Exception
    //   154	214	632	java/lang/Exception
    //   226	246	632	java/lang/Exception
    //   257	266	632	java/lang/Exception
    //   266	324	632	java/lang/Exception
    //   324	508	632	java/lang/Exception
    //   508	629	632	java/lang/Exception
    //   670	694	632	java/lang/Exception
    //   699	710	632	java/lang/Exception
    //   266	324	697	org/json/JSONException
  }
  
  public void setActivity(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  public void setGameUI(IGameUI paramIGameUI)
  {
    this.mIGameUI = paramIGameUI;
  }
  
  public void setLandscape(boolean paramBoolean)
  {
    this.mIsLandscape = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.manager.SystemInfoManager
 * JD-Core Version:    0.7.0.1
 */