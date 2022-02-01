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
    //   47: ifeq +616 -> 663
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
    //   158: ifnull +553 -> 711
    //   161: aload_0
    //   162: getfield 149	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mIGameUI	Lcom/tencent/mobileqq/minigame/jsapi/callbacks/IGameUI;
    //   165: invokeinterface 155 1 0
    //   170: ifnull +541 -> 711
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
    //   215: ifeq +496 -> 711
    //   218: iload 5
    //   220: ifeq +491 -> 711
    //   223: iload 5
    //   225: istore_1
    //   226: aload_0
    //   227: getfield 165	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mActivity	Landroid/app/Activity;
    //   230: aload_0
    //   231: getfield 165	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mActivity	Landroid/app/Activity;
    //   234: invokestatic 171	bnlc:a	(Landroid/content/Context;Landroid/app/Activity;)I
    //   237: istore 5
    //   239: iload 5
    //   241: istore_3
    //   242: iload 5
    //   244: ifne +6 -> 250
    //   247: iload 4
    //   249: istore_3
    //   250: new 114	org/json/JSONObject
    //   253: dup
    //   254: invokespecial 115	org/json/JSONObject:<init>	()V
    //   257: astore 7
    //   259: aload 7
    //   261: ldc 173
    //   263: iconst_0
    //   264: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   267: pop
    //   268: aload 7
    //   270: ldc 178
    //   272: iload_3
    //   273: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   276: pop
    //   277: aload 7
    //   279: ldc 180
    //   281: iload_2
    //   282: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   285: pop
    //   286: aload 7
    //   288: ldc 182
    //   290: iload_1
    //   291: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   294: pop
    //   295: aload 7
    //   297: ldc 184
    //   299: iload_2
    //   300: iconst_0
    //   301: isub
    //   302: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   305: pop
    //   306: aload 7
    //   308: ldc 186
    //   310: iload_1
    //   311: iload_3
    //   312: isub
    //   313: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   316: pop
    //   317: aload 6
    //   319: ldc 188
    //   321: iload_2
    //   322: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   325: pop
    //   326: aload 6
    //   328: ldc 190
    //   330: iload_1
    //   331: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   334: pop
    //   335: aload 6
    //   337: ldc 192
    //   339: iload_2
    //   340: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   343: pop
    //   344: aload 6
    //   346: ldc 194
    //   348: iload_1
    //   349: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   352: pop
    //   353: aload 6
    //   355: ldc 196
    //   357: iload 4
    //   359: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   362: pop
    //   363: aload 6
    //   365: ldc 198
    //   367: ldc 200
    //   369: invokevirtual 124	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   372: pop
    //   373: aload 6
    //   375: ldc 202
    //   377: new 204	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   384: ldc 207
    //   386: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: getstatic 216	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   392: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   398: invokevirtual 124	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   401: pop
    //   402: aload 6
    //   404: ldc 222
    //   406: ldc 224
    //   408: invokevirtual 124	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   411: pop
    //   412: aload 6
    //   414: ldc 226
    //   416: bipush 16
    //   418: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   421: pop
    //   422: aload 6
    //   424: ldc 228
    //   426: invokestatic 233	com/tencent/mobileqq/minigame/utils/DeviceUtil:getDeviceBenchmarkLevel	()I
    //   429: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   432: pop
    //   433: aload 6
    //   435: ldc 235
    //   437: invokestatic 240	bhlo:c	()Ljava/lang/String;
    //   440: invokevirtual 124	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   443: pop
    //   444: aload 6
    //   446: ldc 242
    //   448: ldc 244
    //   450: invokevirtual 124	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   453: pop
    //   454: aload 6
    //   456: ldc 246
    //   458: aload 7
    //   460: invokevirtual 124	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   463: pop
    //   464: new 114	org/json/JSONObject
    //   467: dup
    //   468: invokespecial 115	org/json/JSONObject:<init>	()V
    //   471: astore 7
    //   473: aload_0
    //   474: getfield 41	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mAppContext	Landroid/content/Context;
    //   477: ldc 247
    //   479: invokestatic 251	com/tencent/mobileqq/mini/util/DisplayUtil:dip2px	(Landroid/content/Context;F)I
    //   482: istore_2
    //   483: invokestatic 256	dov/com/tencent/mobileqq/richmedia/capture/util/LiuHaiUtils:b	()Z
    //   486: ifeq +220 -> 706
    //   489: aload_0
    //   490: invokespecial 131	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:isLandscape	()Z
    //   493: ifne +213 -> 706
    //   496: aload_0
    //   497: getfield 70	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mStatusBarHeight	I
    //   500: istore_1
    //   501: aload 7
    //   503: ldc_w 258
    //   506: iload_1
    //   507: iload_2
    //   508: iadd
    //   509: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   512: pop
    //   513: aload 7
    //   515: ldc_w 260
    //   518: aload_0
    //   519: getfield 41	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mAppContext	Landroid/content/Context;
    //   522: ldc_w 261
    //   525: invokestatic 251	com/tencent/mobileqq/mini/util/DisplayUtil:dip2px	(Landroid/content/Context;F)I
    //   528: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   531: pop
    //   532: aload 7
    //   534: ldc_w 263
    //   537: aload_0
    //   538: getfield 41	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mAppContext	Landroid/content/Context;
    //   541: ldc_w 264
    //   544: invokestatic 251	com/tencent/mobileqq/mini/util/DisplayUtil:dip2px	(Landroid/content/Context;F)I
    //   547: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   550: pop
    //   551: aload 7
    //   553: ldc_w 266
    //   556: aload_0
    //   557: getfield 41	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mAppContext	Landroid/content/Context;
    //   560: ldc_w 267
    //   563: invokestatic 251	com/tencent/mobileqq/mini/util/DisplayUtil:dip2px	(Landroid/content/Context;F)I
    //   566: invokevirtual 176	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   569: pop
    //   570: aload 6
    //   572: ldc_w 269
    //   575: aload 7
    //   577: invokevirtual 124	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   580: pop
    //   581: aload_0
    //   582: aload 6
    //   584: putfield 112	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mSystemInfo	Lorg/json/JSONObject;
    //   587: invokestatic 275	com/tencent/mobileqq/minigame/utils/GameLog:getInstance	()Lcom/tencent/mobileqq/minigame/utils/GameLog;
    //   590: ldc 11
    //   592: new 204	java/lang/StringBuilder
    //   595: dup
    //   596: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   599: ldc_w 277
    //   602: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: aload_0
    //   606: getfield 112	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mSystemInfo	Lorg/json/JSONObject;
    //   609: invokevirtual 278	org/json/JSONObject:toString	()Ljava/lang/String;
    //   612: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   618: invokevirtual 282	com/tencent/mobileqq/minigame/utils/GameLog:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   621: pop
    //   622: aload 6
    //   624: areturn
    //   625: astore 7
    //   627: invokestatic 275	com/tencent/mobileqq/minigame/utils/GameLog:getInstance	()Lcom/tencent/mobileqq/minigame/utils/GameLog;
    //   630: ldc 11
    //   632: new 204	java/lang/StringBuilder
    //   635: dup
    //   636: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   639: ldc_w 284
    //   642: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: aload 7
    //   647: invokevirtual 287	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   650: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   656: invokevirtual 290	com/tencent/mobileqq/minigame/utils/GameLog:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   659: pop
    //   660: aload 6
    //   662: areturn
    //   663: aload_0
    //   664: getfield 59	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mScreenWidthPixels	I
    //   667: aload_0
    //   668: getfield 64	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mScreenHeightPixels	I
    //   671: invokestatic 140	java/lang/Math:max	(II)I
    //   674: istore_2
    //   675: aload_0
    //   676: getfield 59	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mScreenWidthPixels	I
    //   679: aload_0
    //   680: getfield 64	com/tencent/mobileqq/minigame/jsapi/manager/SystemInfoManager:mScreenHeightPixels	I
    //   683: invokestatic 137	java/lang/Math:min	(II)I
    //   686: istore_1
    //   687: goto -613 -> 74
    //   690: astore 8
    //   692: ldc 11
    //   694: iconst_1
    //   695: ldc_w 292
    //   698: aload 8
    //   700: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   703: goto -386 -> 317
    //   706: iconst_0
    //   707: istore_1
    //   708: goto -207 -> 501
    //   711: iload_1
    //   712: istore_2
    //   713: iload_3
    //   714: istore_1
    //   715: goto -489 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	718	0	this	SystemInfoManager
    //   73	642	1	i	int
    //   61	652	2	j	int
    //   82	632	3	k	int
    //   129	229	4	m	int
    //   212	31	5	n	int
    //   19	642	6	localJSONObject1	JSONObject
    //   257	319	7	localJSONObject2	JSONObject
    //   625	21	7	localException	java.lang.Exception
    //   690	9	8	localJSONException	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   21	74	625	java/lang/Exception
    //   74	131	625	java/lang/Exception
    //   133	140	625	java/lang/Exception
    //   142	149	625	java/lang/Exception
    //   154	214	625	java/lang/Exception
    //   226	239	625	java/lang/Exception
    //   250	259	625	java/lang/Exception
    //   259	317	625	java/lang/Exception
    //   317	501	625	java/lang/Exception
    //   501	622	625	java/lang/Exception
    //   663	687	625	java/lang/Exception
    //   692	703	625	java/lang/Exception
    //   259	317	690	org/json/JSONException
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