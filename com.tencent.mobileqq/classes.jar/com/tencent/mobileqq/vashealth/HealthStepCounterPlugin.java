package com.tencent.mobileqq.vashealth;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WebSSOAgent.UniSsoServerReq;
import com.tencent.gamecenter.wadl.biz.entity.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vashealth.websso.WebSSOAgentServlet;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HealthStepCounterPlugin
  extends WebViewPlugin
{
  static long d = 0L;
  public static int l = -1;
  static int n = 0;
  static boolean o = false;
  static boolean p = true;
  private static HealthStepCounterPlugin.StepShakeListener t;
  public HashMap<String, Long> a = new HashMap();
  public HashMap<String, Long> b = new HashMap();
  public HashMap<String, Long> c = new HashMap();
  public Activity e;
  String f = null;
  String g = null;
  String h;
  AtomicBoolean i = new AtomicBoolean(false);
  String j = null;
  String k = null;
  String m = null;
  int q = 0;
  int r = 0;
  private QQProgressDialog s;
  private BusinessObserver u = new HealthStepCounterPlugin.6(this);
  
  public HealthStepCounterPlugin()
  {
    this.mPluginNameSpace = "healthkit";
  }
  
  /* Error */
  private JSONObject a(String paramString)
  {
    // Byte code:
    //   0: new 97	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 98	org/json/JSONObject:<init>	()V
    //   7: astore 9
    //   9: new 97	org/json/JSONObject
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 101	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17: astore_1
    //   18: aload_1
    //   19: ldc 103
    //   21: invokevirtual 107	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   24: astore 10
    //   26: aload_1
    //   27: ldc 109
    //   29: invokevirtual 113	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   32: istore_2
    //   33: aload_1
    //   34: ldc 115
    //   36: invokevirtual 113	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   39: istore_3
    //   40: aload_1
    //   41: ldc 117
    //   43: invokevirtual 113	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   46: istore 4
    //   48: aload_1
    //   49: ldc 118
    //   51: invokevirtual 113	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   54: istore 5
    //   56: aload_0
    //   57: getfield 122	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   60: invokevirtual 127	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   63: astore_1
    //   64: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   67: ifeq +59 -> 126
    //   70: new 135	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   77: astore 8
    //   79: aload 8
    //   81: ldc 138
    //   83: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 8
    //   89: aload_1
    //   90: invokevirtual 148	com/tencent/biz/pubaccount/CustomWebView:getWidth	()I
    //   93: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload 8
    //   99: ldc 153
    //   101: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 8
    //   107: aload_1
    //   108: invokevirtual 156	com/tencent/biz/pubaccount/CustomWebView:getHeight	()I
    //   111: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: ldc 158
    //   117: iconst_2
    //   118: aload 8
    //   120: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 165	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: aload_1
    //   127: invokevirtual 148	com/tencent/biz/pubaccount/CustomWebView:getWidth	()I
    //   130: aload_1
    //   131: invokevirtual 156	com/tencent/biz/pubaccount/CustomWebView:getHeight	()I
    //   134: getstatic 171	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   137: invokestatic 177	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   140: astore 8
    //   142: aload_1
    //   143: new 179	android/graphics/Canvas
    //   146: dup
    //   147: aload 8
    //   149: invokespecial 182	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   152: invokevirtual 186	com/tencent/biz/pubaccount/CustomWebView:draw	(Landroid/graphics/Canvas;)V
    //   155: aload_0
    //   156: getfield 122	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   159: invokevirtual 189	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   162: invokevirtual 195	android/app/Activity:getWindowManager	()Landroid/view/WindowManager;
    //   165: invokeinterface 201 1 0
    //   170: invokevirtual 204	android/view/Display:getWidth	()I
    //   173: istore 6
    //   175: aload_0
    //   176: getfield 122	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   179: invokevirtual 189	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   182: invokevirtual 195	android/app/Activity:getWindowManager	()Landroid/view/WindowManager;
    //   185: invokeinterface 201 1 0
    //   190: invokevirtual 205	android/view/Display:getHeight	()I
    //   193: istore 7
    //   195: iload_2
    //   196: iflt +300 -> 496
    //   199: iload_3
    //   200: iflt +296 -> 496
    //   203: iload 4
    //   205: iload 6
    //   207: if_icmpgt +289 -> 496
    //   210: iload 5
    //   212: iload 7
    //   214: if_icmple +6 -> 220
    //   217: goto +279 -> 496
    //   220: aload 8
    //   222: astore_1
    //   223: iload 4
    //   225: ifle +23 -> 248
    //   228: aload 8
    //   230: astore_1
    //   231: iload 5
    //   233: ifle +15 -> 248
    //   236: aload 8
    //   238: iload_2
    //   239: iload_3
    //   240: iload 4
    //   242: iload 5
    //   244: invokestatic 208	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   247: astore_1
    //   248: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   251: ifeq +41 -> 292
    //   254: new 135	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   261: astore 8
    //   263: aload 8
    //   265: ldc 210
    //   267: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload 8
    //   273: aload_1
    //   274: invokevirtual 213	android/graphics/Bitmap:getByteCount	()I
    //   277: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: ldc 158
    //   283: iconst_2
    //   284: aload 8
    //   286: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   292: new 217	java/io/File
    //   295: dup
    //   296: ldc 219
    //   298: invokestatic 224	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   301: invokespecial 225	java/io/File:<init>	(Ljava/lang/String;)V
    //   304: astore 8
    //   306: aload 8
    //   308: invokevirtual 228	java/io/File:mkdirs	()Z
    //   311: pop
    //   312: aload 8
    //   314: invokevirtual 231	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   317: astore 8
    //   319: new 135	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   326: astore 11
    //   328: aload 11
    //   330: aload 8
    //   332: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload 11
    //   338: getstatic 234	java/io/File:separator	Ljava/lang/String;
    //   341: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload 11
    //   347: invokestatic 240	java/lang/System:currentTimeMillis	()J
    //   350: invokevirtual 243	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: aload 11
    //   356: ldc 245
    //   358: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload 11
    //   364: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: astore 8
    //   369: aload_1
    //   370: new 217	java/io/File
    //   373: dup
    //   374: aload 8
    //   376: invokespecial 225	java/io/File:<init>	(Ljava/lang/String;)V
    //   379: invokestatic 250	com/tencent/mobileqq/utils/BaseImageUtil:a	(Landroid/graphics/Bitmap;Ljava/io/File;)V
    //   382: aload_1
    //   383: ifnull +57 -> 440
    //   386: aload 9
    //   388: ldc 252
    //   390: iconst_0
    //   391: invokevirtual 256	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   394: pop
    //   395: aload 9
    //   397: ldc_w 258
    //   400: aload 8
    //   402: invokevirtual 261	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   405: pop
    //   406: aload_0
    //   407: aload 10
    //   409: iconst_1
    //   410: anewarray 263	java/lang/String
    //   413: dup
    //   414: iconst_0
    //   415: aload 9
    //   417: invokevirtual 264	org/json/JSONObject:toString	()Ljava/lang/String;
    //   420: aastore
    //   421: invokevirtual 268	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   424: aload_0
    //   425: getfield 270	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:s	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   428: astore_1
    //   429: aload_1
    //   430: ifnull +7 -> 437
    //   433: aload_1
    //   434: invokevirtual 275	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   437: aload 9
    //   439: areturn
    //   440: aload 9
    //   442: ldc 252
    //   444: bipush 254
    //   446: invokevirtual 256	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   449: pop
    //   450: aload 9
    //   452: ldc_w 258
    //   455: ldc_w 277
    //   458: invokevirtual 261	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   461: pop
    //   462: aload_0
    //   463: aload 10
    //   465: iconst_1
    //   466: anewarray 263	java/lang/String
    //   469: dup
    //   470: iconst_0
    //   471: aload 9
    //   473: invokevirtual 264	org/json/JSONObject:toString	()Ljava/lang/String;
    //   476: aastore
    //   477: invokevirtual 268	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   480: aload_0
    //   481: getfield 270	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:s	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   484: astore_1
    //   485: aload_1
    //   486: ifnull +7 -> 493
    //   489: aload_1
    //   490: invokevirtual 275	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   493: aload 9
    //   495: areturn
    //   496: aload 9
    //   498: ldc 252
    //   500: iconst_m1
    //   501: invokevirtual 256	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   504: pop
    //   505: aload 9
    //   507: ldc_w 258
    //   510: ldc_w 277
    //   513: invokevirtual 261	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   516: pop
    //   517: aload_0
    //   518: aload 10
    //   520: iconst_1
    //   521: anewarray 263	java/lang/String
    //   524: dup
    //   525: iconst_0
    //   526: aload 9
    //   528: invokevirtual 264	org/json/JSONObject:toString	()Ljava/lang/String;
    //   531: aastore
    //   532: invokevirtual 268	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   535: aload_0
    //   536: getfield 270	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:s	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   539: astore_1
    //   540: aload_1
    //   541: ifnull +7 -> 548
    //   544: aload_1
    //   545: invokevirtual 275	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   548: aload 9
    //   550: areturn
    //   551: astore_1
    //   552: goto +64 -> 616
    //   555: astore_1
    //   556: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   559: ifeq +42 -> 601
    //   562: new 135	java/lang/StringBuilder
    //   565: dup
    //   566: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   569: astore 8
    //   571: aload 8
    //   573: ldc_w 279
    //   576: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: pop
    //   580: aload 8
    //   582: aload_1
    //   583: invokevirtual 280	java/lang/Exception:toString	()Ljava/lang/String;
    //   586: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: pop
    //   590: ldc 158
    //   592: iconst_2
    //   593: aload 8
    //   595: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   598: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   601: aload_0
    //   602: getfield 270	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:s	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   605: astore_1
    //   606: aload_1
    //   607: ifnull +7 -> 614
    //   610: aload_1
    //   611: invokevirtual 275	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   614: aconst_null
    //   615: areturn
    //   616: aload_0
    //   617: getfield 270	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:s	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   620: astore 8
    //   622: aload 8
    //   624: ifnull +8 -> 632
    //   627: aload 8
    //   629: invokevirtual 275	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   632: aload_1
    //   633: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	634	0	this	HealthStepCounterPlugin
    //   0	634	1	paramString	String
    //   32	207	2	i1	int
    //   39	201	3	i2	int
    //   46	195	4	i3	int
    //   54	189	5	i4	int
    //   173	35	6	i5	int
    //   193	22	7	i6	int
    //   77	551	8	localObject	Object
    //   7	542	9	localJSONObject	JSONObject
    //   24	495	10	str	String
    //   326	37	11	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	126	551	finally
    //   126	195	551	finally
    //   236	248	551	finally
    //   248	292	551	finally
    //   292	382	551	finally
    //   386	424	551	finally
    //   440	480	551	finally
    //   496	535	551	finally
    //   556	601	551	finally
    //   0	126	555	java/lang/Exception
    //   126	195	555	java/lang/Exception
    //   236	248	555	java/lang/Exception
    //   248	292	555	java/lang/Exception
    //   292	382	555	java/lang/Exception
    //   386	424	555	java/lang/Exception
    //   440	480	555	java/lang/Exception
    //   496	535	555	java/lang/Exception
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    label1253:
    label1254:
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramString1);
        String str = paramString1.getString("callback");
        if (TextUtils.isEmpty(str)) {
          return;
        }
        boolean bool = NetworkUtil.isNetworkAvailable(this.e);
        if (!bool)
        {
          paramString1 = new JSONObject();
          paramString1.put("ssoRet", 103);
          paramString1.put("businessRet", 0);
          paramString1.put("msg", "MSF未连接");
          super.callJs(str, new String[] { paramString1.toString() });
          return;
        }
        long l1 = 10240L;
        if (this.a.containsKey("yundong_report.steps")) {
          l1 = ((Long)this.a.get("yundong_report.steps")).longValue();
        }
        if (l1 <= 0L) {
          break label1254;
        }
        if (paramString1.toString().getBytes().length > l1)
        {
          paramString1 = new JSONObject();
          paramString1.put("ssoRet", 101);
          paramString1.put("businessRet", 0);
          paramString1.put("msg", HardCodeUtil.a(2131903430));
          super.callJs(str, new String[] { paramString1.toString() });
          return;
        }
        if (this.c.containsKey("yundong_report.steps"))
        {
          long l2 = ((Long)this.c.get("yundong_report.steps")).longValue();
          l1 = 1000L;
          if (this.b.containsKey("yundong_report.steps")) {
            l1 = ((Long)this.b.get("yundong_report.steps")).longValue();
          }
          if ((l1 > 0L) && (System.currentTimeMillis() - l2 < l1))
          {
            paramString1 = new JSONObject();
            paramString1.put("ssoRet", 102);
            paramString1.put("businessRet", 0);
            paramString1.put("msg", HardCodeUtil.a(2131903429));
            super.callJs(str, new String[] { paramString1.toString() });
            this.c.put("yundong_report.steps", Long.valueOf(System.currentTimeMillis()));
            return;
          }
        }
        this.c.put("yundong_report.steps", Long.valueOf(System.currentTimeMillis()));
        paramString2 = new JSONObject(paramString2);
        if (!paramString2.getBoolean("isStepCounterEnable"))
        {
          QLog.i("HealthStepCounterPlugin", 1, "web process report step found step counter off!");
          return;
        }
        Object localObject = String.valueOf(SSOHttpUtils.a());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("_total");
        if (paramString2.has(localStringBuilder.toString()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("_init");
          if (paramString2.has(localStringBuilder.toString()))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject);
            localStringBuilder.append("_offset");
            if (!paramString2.has(localStringBuilder.toString())) {
              return;
            }
            localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject);
            localStringBuilder.append("_total");
            int i1 = paramString2.getInt(localStringBuilder.toString());
            localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject);
            localStringBuilder.append("_init");
            int i2 = paramString2.getInt(localStringBuilder.toString());
            localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject);
            localStringBuilder.append("_offset");
            i2 = i1 - i2 + paramString2.getInt(localStringBuilder.toString());
            paramString2 = SSOHttpUtils.e();
            i1 = i2;
            if (paramString2[1] != -1)
            {
              i1 = i2;
              if (paramString2[1] > i2)
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("use device step:");
                ((StringBuilder)localObject).append(paramString2[1]);
                ((StringBuilder)localObject).append(" instead of:");
                ((StringBuilder)localObject).append(i2);
                QLog.e("HealthStepCounterPlugin", 1, ((StringBuilder)localObject).toString());
                i1 = paramString2[1];
              }
            }
            l1 = NetConnInfoCenter.getServerTime();
            paramString2 = new JSONArray();
            localObject = new JSONObject();
            ((JSONObject)localObject).put("type", 1);
            ((JSONObject)localObject).put("time", l1);
            ((JSONObject)localObject).put("steps", i1);
            paramString2.put(localObject);
            paramString1.put("oauth_consumer_key", 1002);
            paramString1.put("data", paramString2);
            paramString1.put("version", "8.8.17");
            if (TextUtils.isEmpty(this.f)) {
              this.f = URLEncoder.encode(Build.MODEL, "utf-8");
            }
            paramString1.put("model", this.f);
            if (TextUtils.isEmpty(this.h))
            {
              paramString2 = TimeZone.getDefault();
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(paramString2.getDisplayName(false, 0));
              ((StringBuilder)localObject).append(" ");
              ((StringBuilder)localObject).append(paramString2.getID());
              this.h = ((StringBuilder)localObject).toString();
            }
            paramString1.put("zone", String.valueOf(this.h));
            if (TextUtils.isEmpty(this.g)) {
              this.g = MobileInfoUtil.getImei();
            }
            paramString1.put("imei", String.valueOf(this.g));
            paramString1.put("adcode", ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCityCode());
            if (QLog.isColorLevel())
            {
              paramString2 = new StringBuilder();
              paramString2.append("parameters:");
              paramString2.append(paramString1.toString());
              QLog.i("HealthStepCounterPlugin", 2, paramString2.toString());
            }
            localObject = new WebSSOAgent.UniSsoServerReqComm();
            ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
            ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
            ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.8.17");
            paramString2 = new WebSSOAgent.UniSsoServerReq();
            paramString2.comm.set((MessageMicro)localObject);
            paramString2.reqdata.set(paramString1.toString());
            paramString1 = new HealthStepCounterPlugin.3(this);
            if (this.mRuntime == null) {
              break label1253;
            }
            localObject = new NewIntent(this.mRuntime.d().getApplicationContext(), WebSSOAgentServlet.class);
            ((NewIntent)localObject).putExtra("extra_cmd", "yundong_report.steps");
            ((NewIntent)localObject).putExtra("extra_data", paramString2.toByteArray());
            ((NewIntent)localObject).putExtra("extra_callbackid", str);
            ((NewIntent)localObject).setObserver(paramString1);
            this.mRuntime.b().startServlet((NewIntent)localObject);
            return;
          }
        }
        return;
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("Exception:");
          paramString2.append(paramString1);
          QLog.e("HealthStepCounterPlugin", 2, paramString2.toString());
        }
      }
      return;
    }
  }
  
  /* Error */
  private JSONObject b(String paramString)
  {
    // Byte code:
    //   0: new 97	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 98	org/json/JSONObject:<init>	()V
    //   7: astore 8
    //   9: invokestatic 240	java/lang/System:currentTimeMillis	()J
    //   12: lstore_3
    //   13: aload_0
    //   14: getfield 122	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   17: ifnull +1068 -> 1085
    //   20: aload_0
    //   21: getfield 292	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:e	Landroid/app/Activity;
    //   24: ifnull +1061 -> 1085
    //   27: new 97	org/json/JSONObject
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 101	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   35: astore_1
    //   36: aload_1
    //   37: ldc 103
    //   39: invokevirtual 107	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   42: astore 9
    //   44: aload 9
    //   46: invokestatic 290	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   49: ifeq +6 -> 55
    //   52: aload 8
    //   54: areturn
    //   55: aload_1
    //   56: ldc_w 565
    //   59: invokevirtual 371	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   62: istore_2
    //   63: aload_1
    //   64: ldc_w 258
    //   67: invokevirtual 107	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   70: astore 10
    //   72: new 567	android/graphics/BitmapFactory$Options
    //   75: dup
    //   76: invokespecial 568	android/graphics/BitmapFactory$Options:<init>	()V
    //   79: astore_1
    //   80: aload_1
    //   81: iconst_1
    //   82: putfield 571	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   85: aload 10
    //   87: aload_1
    //   88: invokestatic 577	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   91: astore 6
    //   93: aload_1
    //   94: iconst_0
    //   95: putfield 571	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   98: aload 10
    //   100: aload_1
    //   101: invokestatic 577	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   104: astore_1
    //   105: goto +53 -> 158
    //   108: astore 7
    //   110: aload 6
    //   112: astore_1
    //   113: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   116: ifeq +42 -> 158
    //   119: new 135	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   126: astore_1
    //   127: aload_1
    //   128: ldc_w 279
    //   131: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload_1
    //   136: aload 7
    //   138: invokevirtual 578	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   141: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: ldc 158
    //   147: iconst_2
    //   148: aload_1
    //   149: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: aload 6
    //   157: astore_1
    //   158: new 217	java/io/File
    //   161: dup
    //   162: aload 10
    //   164: invokespecial 225	java/io/File:<init>	(Ljava/lang/String;)V
    //   167: astore 6
    //   169: new 580	java/io/FileOutputStream
    //   172: dup
    //   173: aload 6
    //   175: invokespecial 583	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   178: astore 6
    //   180: aload_1
    //   181: getstatic 589	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   184: bipush 80
    //   186: aload 6
    //   188: invokevirtual 593	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   191: istore 5
    //   193: aload_0
    //   194: getfield 270	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:s	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   197: ifnull +904 -> 1101
    //   200: aload_0
    //   201: getfield 270	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:s	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   204: invokevirtual 596	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   207: ifeq +894 -> 1101
    //   210: aload_0
    //   211: getfield 270	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:s	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   214: invokevirtual 275	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   217: goto +884 -> 1101
    //   220: new 135	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   227: astore 7
    //   229: aload 7
    //   231: getstatic 601	com/tencent/mobileqq/app/AppConstants:SDCARD_IMG_SAVE	Ljava/lang/String;
    //   234: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload 7
    //   240: getstatic 234	java/io/File:separator	Ljava/lang/String;
    //   243: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload 7
    //   249: invokestatic 240	java/lang/System:currentTimeMillis	()J
    //   252: invokevirtual 243	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload 7
    //   258: ldc 245
    //   260: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: new 217	java/io/File
    //   267: dup
    //   268: aload 7
    //   270: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokespecial 225	java/io/File:<init>	(Ljava/lang/String;)V
    //   276: astore 7
    //   278: aload_1
    //   279: aload 7
    //   281: invokestatic 250	com/tencent/mobileqq/utils/BaseImageUtil:a	(Landroid/graphics/Bitmap;Ljava/io/File;)V
    //   284: new 603	android/content/Intent
    //   287: dup
    //   288: ldc_w 605
    //   291: invokespecial 606	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   294: astore_1
    //   295: aload_1
    //   296: aload 7
    //   298: invokestatic 612	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   301: invokevirtual 616	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   304: pop
    //   305: aload_0
    //   306: getfield 122	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   309: invokevirtual 189	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   312: invokevirtual 518	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   315: aload_1
    //   316: invokevirtual 622	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   319: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +422 -> 744
    //   325: new 135	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   332: astore_1
    //   333: aload_1
    //   334: ldc_w 624
    //   337: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload_1
    //   342: getstatic 601	com/tencent/mobileqq/app/AppConstants:SDCARD_IMG_SAVE	Ljava/lang/String;
    //   345: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: ldc 158
    //   351: iconst_2
    //   352: aload_1
    //   353: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokestatic 626	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   359: goto +385 -> 744
    //   362: invokestatic 631	com/tencent/mobileqq/wxapi/WXShareHelper:a	()Lcom/tencent/mobileqq/wxapi/WXShareHelper;
    //   365: invokevirtual 633	com/tencent/mobileqq/wxapi/WXShareHelper:b	()Z
    //   368: ifeq +16 -> 384
    //   371: invokestatic 631	com/tencent/mobileqq/wxapi/WXShareHelper:a	()Lcom/tencent/mobileqq/wxapi/WXShareHelper;
    //   374: aload 10
    //   376: aload_1
    //   377: iconst_1
    //   378: invokevirtual 636	com/tencent/mobileqq/wxapi/WXShareHelper:a	(Ljava/lang/String;Landroid/graphics/Bitmap;I)V
    //   381: goto +363 -> 744
    //   384: aload_0
    //   385: getfield 122	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   388: invokevirtual 127	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   391: new 638	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin$4
    //   394: dup
    //   395: aload_0
    //   396: invokespecial 639	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin$4:<init>	(Lcom/tencent/mobileqq/vashealth/HealthStepCounterPlugin;)V
    //   399: invokevirtual 643	com/tencent/biz/pubaccount/CustomWebView:post	(Ljava/lang/Runnable;)Z
    //   402: pop
    //   403: goto +341 -> 744
    //   406: invokestatic 631	com/tencent/mobileqq/wxapi/WXShareHelper:a	()Lcom/tencent/mobileqq/wxapi/WXShareHelper;
    //   409: invokevirtual 633	com/tencent/mobileqq/wxapi/WXShareHelper:b	()Z
    //   412: ifeq +16 -> 428
    //   415: invokestatic 631	com/tencent/mobileqq/wxapi/WXShareHelper:a	()Lcom/tencent/mobileqq/wxapi/WXShareHelper;
    //   418: aload 10
    //   420: aload_1
    //   421: iconst_0
    //   422: invokevirtual 636	com/tencent/mobileqq/wxapi/WXShareHelper:a	(Ljava/lang/String;Landroid/graphics/Bitmap;I)V
    //   425: goto +319 -> 744
    //   428: aload_0
    //   429: getfield 122	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   432: invokevirtual 127	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   435: new 645	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin$5
    //   438: dup
    //   439: aload_0
    //   440: invokespecial 646	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin$5:<init>	(Lcom/tencent/mobileqq/vashealth/HealthStepCounterPlugin;)V
    //   443: invokevirtual 643	com/tencent/biz/pubaccount/CustomWebView:post	(Ljava/lang/Runnable;)Z
    //   446: pop
    //   447: goto +297 -> 744
    //   450: new 648	android/os/Bundle
    //   453: dup
    //   454: invokespecial 649	android/os/Bundle:<init>	()V
    //   457: astore_1
    //   458: new 651	java/util/ArrayList
    //   461: dup
    //   462: invokespecial 652	java/util/ArrayList:<init>	()V
    //   465: astore 7
    //   467: aload 7
    //   469: aload 10
    //   471: invokestatic 657	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   474: invokevirtual 660	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   477: pop
    //   478: aload_1
    //   479: ldc_w 662
    //   482: aload 7
    //   484: invokevirtual 666	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   487: aload_1
    //   488: ldc_w 668
    //   491: ldc_w 669
    //   494: invokestatic 334	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   497: invokevirtual 672	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   500: aload_1
    //   501: ldc_w 674
    //   504: bipush 7
    //   506: invokevirtual 678	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   509: aload_1
    //   510: ldc_w 680
    //   513: iconst_0
    //   514: invokevirtual 684	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   517: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   520: ifeq +39 -> 559
    //   523: new 135	java/lang/StringBuilder
    //   526: dup
    //   527: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   530: astore 7
    //   532: aload 7
    //   534: ldc_w 686
    //   537: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: aload 7
    //   543: aload_1
    //   544: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   547: pop
    //   548: ldc 158
    //   550: iconst_2
    //   551: aload 7
    //   553: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   556: invokestatic 626	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   559: ldc_w 688
    //   562: invokestatic 460	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   565: checkcast 688	com/tencent/qzonehub/api/IQzoneShareApi
    //   568: aload_0
    //   569: getfield 122	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   572: invokevirtual 546	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:b	()Lcom/tencent/common/app/AppInterface;
    //   575: aload_0
    //   576: getfield 122	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   579: invokevirtual 189	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   582: aload_1
    //   583: aconst_null
    //   584: invokeinterface 692 5 0
    //   589: goto +155 -> 744
    //   592: new 648	android/os/Bundle
    //   595: dup
    //   596: invokespecial 649	android/os/Bundle:<init>	()V
    //   599: astore_1
    //   600: aload_1
    //   601: ldc_w 694
    //   604: iconst_1
    //   605: invokevirtual 678	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   608: aload_1
    //   609: ldc_w 696
    //   612: aload 10
    //   614: invokevirtual 672	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   617: aload_1
    //   618: ldc_w 698
    //   621: aload 10
    //   623: invokevirtual 672	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   626: aload_1
    //   627: ldc_w 700
    //   630: aload 10
    //   632: invokevirtual 672	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   635: aload_1
    //   636: ldc_w 702
    //   639: aload 10
    //   641: invokevirtual 672	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   644: aload_1
    //   645: ldc_w 704
    //   648: iconst_1
    //   649: invokevirtual 684	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   652: new 603	android/content/Intent
    //   655: dup
    //   656: invokespecial 705	android/content/Intent:<init>	()V
    //   659: astore 7
    //   661: aload 7
    //   663: aload_1
    //   664: invokevirtual 709	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   667: pop
    //   668: aload 7
    //   670: aload_0
    //   671: getfield 292	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:e	Landroid/app/Activity;
    //   674: ldc_w 711
    //   677: invokestatic 460	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   680: checkcast 711	com/tencent/mobileqq/forward/api/IForwardApi
    //   683: invokeinterface 715 1 0
    //   688: invokevirtual 719	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   691: pop
    //   692: aload 7
    //   694: ldc_w 721
    //   697: aload_0
    //   698: getfield 292	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:e	Landroid/app/Activity;
    //   701: invokevirtual 726	java/lang/Object:getClass	()Ljava/lang/Class;
    //   704: invokevirtual 731	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   707: invokevirtual 732	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   710: pop
    //   711: aload 7
    //   713: ldc_w 734
    //   716: iconst_m1
    //   717: invokevirtual 737	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   720: pop
    //   721: aload 7
    //   723: ldc_w 739
    //   726: ldc_w 277
    //   729: invokevirtual 732	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   732: pop
    //   733: aload_0
    //   734: getfield 292	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:e	Landroid/app/Activity;
    //   737: aload 7
    //   739: bipush 21
    //   741: invokevirtual 743	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   744: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   747: ifeq +39 -> 786
    //   750: new 135	java/lang/StringBuilder
    //   753: dup
    //   754: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   757: astore_1
    //   758: aload_1
    //   759: ldc_w 745
    //   762: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: pop
    //   766: aload_1
    //   767: invokestatic 240	java/lang/System:currentTimeMillis	()J
    //   770: lload_3
    //   771: lsub
    //   772: invokevirtual 243	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   775: pop
    //   776: ldc 158
    //   778: iconst_2
    //   779: aload_1
    //   780: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   783: invokestatic 165	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   786: aload 6
    //   788: invokevirtual 748	java/io/FileOutputStream:close	()V
    //   791: goto +87 -> 878
    //   794: astore_1
    //   795: goto +232 -> 1027
    //   798: astore 7
    //   800: aload 6
    //   802: astore_1
    //   803: aload 7
    //   805: astore 6
    //   807: goto +14 -> 821
    //   810: astore_1
    //   811: aconst_null
    //   812: astore 6
    //   814: goto +213 -> 1027
    //   817: astore 6
    //   819: aconst_null
    //   820: astore_1
    //   821: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   824: ifeq +43 -> 867
    //   827: new 135	java/lang/StringBuilder
    //   830: dup
    //   831: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   834: astore 7
    //   836: aload 7
    //   838: ldc_w 279
    //   841: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   844: pop
    //   845: aload 7
    //   847: aload 6
    //   849: invokevirtual 749	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   852: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   855: pop
    //   856: ldc 158
    //   858: iconst_2
    //   859: aload 7
    //   861: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   864: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   867: aload_1
    //   868: ifnull +7 -> 875
    //   871: aload_1
    //   872: invokevirtual 748	java/io/FileOutputStream:close	()V
    //   875: iconst_0
    //   876: istore 5
    //   878: new 97	org/json/JSONObject
    //   881: dup
    //   882: invokespecial 98	org/json/JSONObject:<init>	()V
    //   885: astore_1
    //   886: iload 5
    //   888: ifeq +63 -> 951
    //   891: aload_1
    //   892: ldc_w 751
    //   895: iconst_0
    //   896: invokevirtual 256	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   899: pop
    //   900: aload_1
    //   901: ldc_w 304
    //   904: ldc_w 752
    //   907: invokestatic 334	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   910: invokevirtual 261	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   913: pop
    //   914: aload_1
    //   915: ldc_w 754
    //   918: aload 10
    //   920: invokevirtual 261	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   923: pop
    //   924: aload 8
    //   926: ldc 252
    //   928: iconst_0
    //   929: invokevirtual 256	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   932: pop
    //   933: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   936: ifeq +62 -> 998
    //   939: ldc 158
    //   941: iconst_2
    //   942: ldc_w 756
    //   945: invokestatic 165	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   948: goto +50 -> 998
    //   951: aload_1
    //   952: ldc_w 751
    //   955: iconst_m1
    //   956: invokevirtual 256	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   959: pop
    //   960: aload_1
    //   961: ldc_w 304
    //   964: ldc_w 757
    //   967: invokestatic 334	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   970: invokevirtual 261	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   973: pop
    //   974: aload 8
    //   976: ldc 252
    //   978: iconst_m1
    //   979: invokevirtual 256	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   982: pop
    //   983: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   986: ifeq +12 -> 998
    //   989: ldc 158
    //   991: iconst_2
    //   992: ldc_w 759
    //   995: invokestatic 165	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   998: aload_0
    //   999: aload 9
    //   1001: iconst_1
    //   1002: anewarray 263	java/lang/String
    //   1005: dup
    //   1006: iconst_0
    //   1007: aload 8
    //   1009: invokevirtual 264	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1012: aastore
    //   1013: invokevirtual 268	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1016: aload 8
    //   1018: areturn
    //   1019: astore 7
    //   1021: aload_1
    //   1022: astore 6
    //   1024: aload 7
    //   1026: astore_1
    //   1027: aload 6
    //   1029: ifnull +8 -> 1037
    //   1032: aload 6
    //   1034: invokevirtual 748	java/io/FileOutputStream:close	()V
    //   1037: aload_1
    //   1038: athrow
    //   1039: astore_1
    //   1040: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1043: ifeq +42 -> 1085
    //   1046: new 135	java/lang/StringBuilder
    //   1049: dup
    //   1050: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   1053: astore 6
    //   1055: aload 6
    //   1057: ldc_w 279
    //   1060: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1063: pop
    //   1064: aload 6
    //   1066: aload_1
    //   1067: invokevirtual 280	java/lang/Exception:toString	()Ljava/lang/String;
    //   1070: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1073: pop
    //   1074: ldc 158
    //   1076: iconst_2
    //   1077: aload 6
    //   1079: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1082: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1085: aload 8
    //   1087: areturn
    //   1088: astore_1
    //   1089: goto -211 -> 878
    //   1092: astore_1
    //   1093: goto -218 -> 875
    //   1096: astore 6
    //   1098: goto -61 -> 1037
    //   1101: iload_2
    //   1102: iconst_1
    //   1103: if_icmpeq -511 -> 592
    //   1106: iload_2
    //   1107: iconst_2
    //   1108: if_icmpeq -658 -> 450
    //   1111: iload_2
    //   1112: iconst_3
    //   1113: if_icmpeq -707 -> 406
    //   1116: iload_2
    //   1117: iconst_4
    //   1118: if_icmpeq -756 -> 362
    //   1121: iload_2
    //   1122: iconst_5
    //   1123: if_icmpeq -903 -> 220
    //   1126: goto -382 -> 744
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1129	0	this	HealthStepCounterPlugin
    //   0	1129	1	paramString	String
    //   62	1062	2	i1	int
    //   12	759	3	l1	long
    //   191	696	5	bool	boolean
    //   91	722	6	localObject1	Object
    //   817	31	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   1022	56	6	localObject2	Object
    //   1096	1	6	localIOException	java.io.IOException
    //   108	29	7	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   227	511	7	localObject3	Object
    //   798	6	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   834	26	7	localStringBuilder	StringBuilder
    //   1019	6	7	localObject4	Object
    //   7	1079	8	localJSONObject	JSONObject
    //   42	958	9	str1	String
    //   70	849	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   98	105	108	java/lang/OutOfMemoryError
    //   180	217	794	finally
    //   220	359	794	finally
    //   362	381	794	finally
    //   384	403	794	finally
    //   406	425	794	finally
    //   428	447	794	finally
    //   450	559	794	finally
    //   559	589	794	finally
    //   592	744	794	finally
    //   744	786	794	finally
    //   180	217	798	java/io/FileNotFoundException
    //   220	359	798	java/io/FileNotFoundException
    //   362	381	798	java/io/FileNotFoundException
    //   384	403	798	java/io/FileNotFoundException
    //   406	425	798	java/io/FileNotFoundException
    //   428	447	798	java/io/FileNotFoundException
    //   450	559	798	java/io/FileNotFoundException
    //   559	589	798	java/io/FileNotFoundException
    //   592	744	798	java/io/FileNotFoundException
    //   744	786	798	java/io/FileNotFoundException
    //   169	180	810	finally
    //   169	180	817	java/io/FileNotFoundException
    //   821	867	1019	finally
    //   27	52	1039	java/lang/Exception
    //   55	98	1039	java/lang/Exception
    //   98	105	1039	java/lang/Exception
    //   113	155	1039	java/lang/Exception
    //   158	169	1039	java/lang/Exception
    //   786	791	1039	java/lang/Exception
    //   871	875	1039	java/lang/Exception
    //   878	886	1039	java/lang/Exception
    //   891	948	1039	java/lang/Exception
    //   951	998	1039	java/lang/Exception
    //   998	1016	1039	java/lang/Exception
    //   1032	1037	1039	java/lang/Exception
    //   1037	1039	1039	java/lang/Exception
    //   786	791	1088	java/io/IOException
    //   871	875	1092	java/io/IOException
    //   1032	1037	1096	java/io/IOException
  }
  
  private void c(String paramString)
  {
    Object localObject1;
    Object localObject2;
    if (t == null)
    {
      localObject1 = new HealthStepCounterPlugin.StepShakeListener(null);
      localObject2 = (SensorManager)this.e.getSystemService("sensor");
      ((SensorManager)localObject2).registerListener((SensorEventListener)localObject1, ((SensorManager)localObject2).getDefaultSensor(1), 0);
      t = (HealthStepCounterPlugin.StepShakeListener)localObject1;
      QLog.d("HealthStepCounterPlugin", 1, "register shakelistener");
    }
    try
    {
      this.j = new JSONObject(paramString).getString("callback");
      if (!TextUtils.isEmpty(this.j))
      {
        this.i.set(true);
        localObject1 = (SensorManager)this.e.getSystemService("sensor");
        localObject2 = ((SensorManager)localObject1).getDefaultSensor(19);
        if ((Build.VERSION.SDK_INT >= 19) && (localObject2 != null))
        {
          HealthStepCounterPlugin.7 local7 = new HealthStepCounterPlugin.7(this);
          ((SensorManager)localObject1).registerListener(local7, (Sensor)localObject2, 3, 0);
          ((SensorManager)localObject1).flush(local7);
          localObject1 = new NewIntent(this.mRuntime.b().getApplication(), StepCounterServlert.class);
          ((NewIntent)localObject1).putExtra("msf_cmd_type", "cmd_refresh_steps");
          ((NewIntent)localObject1).putExtra("json_string", paramString);
          ((NewIntent)localObject1).setObserver(this.u);
          this.mRuntime.b().startServlet((NewIntent)localObject1);
          return;
        }
        this.k = "Unsupported model found.";
        paramString = new JSONObject();
      }
    }
    catch (Throwable localThrowable)
    {
      try
      {
        paramString.put("retCode", l);
        paramString.put("msg", this.k);
        label251:
        callJs(this.j, new String[] { paramString.toString() });
        return;
        localThrowable = localThrowable;
      }
      catch (Exception localException)
      {
        break label251;
      }
    }
  }
  
  private JSONObject d(String paramString)
  {
    Object localObject = this.mRuntime.b().getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mRuntime.b().getCurrentAccountUin());
    localStringBuilder.append(".qqsport");
    int i1 = ((MobileQQ)localObject).getSharedPreferences(localStringBuilder.toString(), 4).getInt("STEP_RED_PACK_STATUS", 0);
    localObject = new JSONObject();
    try
    {
      paramString = new JSONObject(paramString).getString("callback");
      ((JSONObject)localObject).put("status", i1);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getStepRedPackStatus:");
      localStringBuilder.append(((JSONObject)localObject).toString());
      QLog.i("HealthStepCounterPlugin", 1, localStringBuilder.toString());
      callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
      return localObject;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return localObject;
  }
  
  private JSONObject e(String paramString)
  {
    Object localObject1 = this.mRuntime.b().getApplication();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.mRuntime.b().getCurrentAccountUin());
    ((StringBuilder)localObject2).append(".qqsport");
    localObject2 = ((MobileQQ)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 4).edit();
    localObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        ((SharedPreferences.Editor)localObject2).putInt("STEP_RED_PACK_STATUS", paramString.optInt("status"));
        boolean bool = ((SharedPreferences.Editor)localObject2).commit();
        paramString = paramString.getString("callback");
        if (bool == true)
        {
          i1 = 0;
          ((JSONObject)localObject1).put("status", i1);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("setStepRedPackStatus:");
          ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
          QLog.i("HealthStepCounterPlugin", 1, ((StringBuilder)localObject2).toString());
          callJs(paramString, new String[] { ((JSONObject)localObject1).toString() });
          return localObject1;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return localObject1;
      }
      int i1 = -1;
    }
  }
  
  private void f(String paramString)
  {
    try
    {
      IX5WebViewExtension localIX5WebViewExtension = this.mRuntime.a().getX5WebViewExtension();
      if (localIX5WebViewExtension == null) {
        return;
      }
      paramString = new JSONObject(paramString).optString("serviceWorkerURL");
      paramString = paramString.substring(1, paramString.length() - 1).split(",");
      int i1 = 0;
      while (i1 < paramString.length)
      {
        Object localObject = paramString[i1];
        localIX5WebViewExtension.updateServiceWorkerBackground(paramString[i1]);
        i1 += 1;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  /* Error */
  protected boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 158
    //   8: iconst_2
    //   9: ldc_w 889
    //   12: invokestatic 165	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_2
    //   16: ifnull +1195 -> 1211
    //   19: ldc 86
    //   21: aload_3
    //   22: invokevirtual 892	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   25: ifeq +1186 -> 1211
    //   28: aload 4
    //   30: ifnonnull +5 -> 35
    //   33: iconst_0
    //   34: ireturn
    //   35: aload 4
    //   37: ldc_w 894
    //   40: invokevirtual 892	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   43: istore 7
    //   45: iload 7
    //   47: ifeq +194 -> 241
    //   50: aload 5
    //   52: arraylength
    //   53: ifle +1168 -> 1221
    //   56: aload_0
    //   57: getfield 292	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:e	Landroid/app/Activity;
    //   60: ldc_w 770
    //   63: invokevirtual 774	android/app/Activity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   66: checkcast 776	android/hardware/SensorManager
    //   69: astore_1
    //   70: getstatic 791	android/os/Build$VERSION:SDK_INT	I
    //   73: bipush 19
    //   75: if_icmplt +80 -> 155
    //   78: aload_1
    //   79: bipush 19
    //   81: invokevirtual 780	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   84: ifnonnull +6 -> 90
    //   87: goto +68 -> 155
    //   90: new 514	mqq/app/NewIntent
    //   93: dup
    //   94: aload_0
    //   95: getfield 122	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   98: invokevirtual 546	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:b	()Lcom/tencent/common/app/AppInterface;
    //   101: invokevirtual 805	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   104: ldc_w 807
    //   107: invokespecial 523	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   110: astore_1
    //   111: aload_1
    //   112: ldc_w 809
    //   115: ldc_w 811
    //   118: invokevirtual 529	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   121: pop
    //   122: aload_1
    //   123: ldc_w 813
    //   126: aload 5
    //   128: iconst_0
    //   129: aaload
    //   130: invokevirtual 529	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   133: pop
    //   134: aload_1
    //   135: aload_0
    //   136: getfield 84	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:u	Lmqq/observer/BusinessObserver;
    //   139: invokevirtual 543	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   142: aload_0
    //   143: getfield 122	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   146: invokevirtual 546	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:b	()Lcom/tencent/common/app/AppInterface;
    //   149: aload_1
    //   150: invokevirtual 552	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   153: iconst_1
    //   154: ireturn
    //   155: new 97	org/json/JSONObject
    //   158: dup
    //   159: aload 5
    //   161: iconst_0
    //   162: aaload
    //   163: invokespecial 101	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   166: ldc 103
    //   168: invokevirtual 107	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   171: astore_1
    //   172: aload_1
    //   173: invokestatic 290	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   176: ifeq +5 -> 181
    //   179: iconst_0
    //   180: ireturn
    //   181: new 97	org/json/JSONObject
    //   184: dup
    //   185: invokespecial 98	org/json/JSONObject:<init>	()V
    //   188: astore_2
    //   189: aload_2
    //   190: ldc_w 300
    //   193: sipush 255
    //   196: invokevirtual 256	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   199: pop
    //   200: aload_2
    //   201: ldc_w 302
    //   204: iconst_0
    //   205: invokevirtual 256	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   208: pop
    //   209: aload_2
    //   210: ldc_w 304
    //   213: ldc_w 895
    //   216: invokestatic 334	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   219: invokevirtual 261	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   222: pop
    //   223: aload_0
    //   224: aload_1
    //   225: iconst_1
    //   226: anewarray 263	java/lang/String
    //   229: dup
    //   230: iconst_0
    //   231: aload_2
    //   232: invokevirtual 264	org/json/JSONObject:toString	()Ljava/lang/String;
    //   235: aastore
    //   236: invokespecial 307	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   239: iconst_1
    //   240: ireturn
    //   241: aload 4
    //   243: ldc_w 897
    //   246: invokevirtual 892	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   249: ifeq +333 -> 582
    //   252: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   255: ifeq +38 -> 293
    //   258: new 135	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   265: astore_1
    //   266: aload_1
    //   267: ldc_w 899
    //   270: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload_1
    //   275: aload 5
    //   277: iconst_0
    //   278: aaload
    //   279: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: ldc 158
    //   285: iconst_2
    //   286: aload_1
    //   287: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 165	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: ldc_w 901
    //   296: invokestatic 460	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   299: checkcast 901	com/tencent/mobileqq/dpc/api/IDPCApi
    //   302: getstatic 907	com/tencent/mobileqq/dpc/enumname/DPCNames:health_ban	Lcom/tencent/mobileqq/dpc/enumname/DPCNames;
    //   305: invokevirtual 910	com/tencent/mobileqq/dpc/enumname/DPCNames:name	()Ljava/lang/String;
    //   308: ldc_w 277
    //   311: invokeinterface 913 3 0
    //   316: astore_1
    //   317: aload_1
    //   318: invokestatic 290	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   321: ifne +78 -> 399
    //   324: aload_1
    //   325: invokestatic 918	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   328: ifne +71 -> 399
    //   331: new 97	org/json/JSONObject
    //   334: dup
    //   335: invokespecial 98	org/json/JSONObject:<init>	()V
    //   338: astore_1
    //   339: new 97	org/json/JSONObject
    //   342: dup
    //   343: aload 5
    //   345: iconst_0
    //   346: aaload
    //   347: invokespecial 101	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   350: ldc 103
    //   352: invokevirtual 107	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   355: astore_2
    //   356: aload_1
    //   357: ldc_w 302
    //   360: sipush 202
    //   363: invokevirtual 256	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   366: pop
    //   367: aload_1
    //   368: ldc_w 304
    //   371: ldc_w 919
    //   374: invokestatic 334	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   377: invokevirtual 261	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   380: pop
    //   381: aload_0
    //   382: aload_2
    //   383: iconst_1
    //   384: anewarray 263	java/lang/String
    //   387: dup
    //   388: iconst_0
    //   389: aload_1
    //   390: invokevirtual 264	org/json/JSONObject:toString	()Ljava/lang/String;
    //   393: aastore
    //   394: invokespecial 307	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   397: iconst_1
    //   398: ireturn
    //   399: new 97	org/json/JSONObject
    //   402: dup
    //   403: invokespecial 98	org/json/JSONObject:<init>	()V
    //   406: astore_1
    //   407: new 97	org/json/JSONObject
    //   410: dup
    //   411: aload 5
    //   413: iconst_0
    //   414: aaload
    //   415: invokespecial 101	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   418: astore_3
    //   419: aload_3
    //   420: ldc 103
    //   422: invokevirtual 107	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   425: astore_2
    //   426: aload_3
    //   427: ldc_w 921
    //   430: invokevirtual 350	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   433: istore 7
    //   435: aload_0
    //   436: getfield 292	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:e	Landroid/app/Activity;
    //   439: ifnull +784 -> 1223
    //   442: new 514	mqq/app/NewIntent
    //   445: dup
    //   446: aload_0
    //   447: getfield 292	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:e	Landroid/app/Activity;
    //   450: ldc_w 807
    //   453: invokespecial 523	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   456: astore_3
    //   457: aload_3
    //   458: ldc_w 809
    //   461: ldc_w 923
    //   464: invokevirtual 529	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   467: pop
    //   468: aload_3
    //   469: ldc_w 921
    //   472: iload 7
    //   474: invokevirtual 926	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   477: pop
    //   478: aload_0
    //   479: getfield 122	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   482: invokevirtual 546	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:b	()Lcom/tencent/common/app/AppInterface;
    //   485: aload_3
    //   486: invokevirtual 552	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   489: aload_1
    //   490: ldc_w 302
    //   493: iconst_0
    //   494: invokevirtual 256	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   497: pop
    //   498: aload_1
    //   499: ldc_w 304
    //   502: ldc_w 927
    //   505: invokestatic 334	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   508: invokevirtual 261	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   511: pop
    //   512: aload_0
    //   513: aload_2
    //   514: iconst_1
    //   515: anewarray 263	java/lang/String
    //   518: dup
    //   519: iconst_0
    //   520: aload_1
    //   521: invokevirtual 264	org/json/JSONObject:toString	()Ljava/lang/String;
    //   524: aastore
    //   525: invokespecial 307	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   528: iconst_1
    //   529: istore 6
    //   531: goto +3 -> 534
    //   534: iload 6
    //   536: ifne +693 -> 1229
    //   539: aload_1
    //   540: ldc_w 302
    //   543: sipush 201
    //   546: invokevirtual 256	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   549: pop
    //   550: aload_1
    //   551: ldc_w 304
    //   554: ldc_w 928
    //   557: invokestatic 334	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   560: invokevirtual 261	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   563: pop
    //   564: aload_0
    //   565: aload_2
    //   566: iconst_1
    //   567: anewarray 263	java/lang/String
    //   570: dup
    //   571: iconst_0
    //   572: aload_1
    //   573: invokevirtual 264	org/json/JSONObject:toString	()Ljava/lang/String;
    //   576: aastore
    //   577: invokespecial 307	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   580: iconst_1
    //   581: ireturn
    //   582: aload 4
    //   584: ldc_w 930
    //   587: invokevirtual 892	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   590: istore 7
    //   592: aconst_null
    //   593: astore_2
    //   594: iload 7
    //   596: ifeq +104 -> 700
    //   599: aload_0
    //   600: getfield 270	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:s	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   603: ifnonnull +45 -> 648
    //   606: aload_0
    //   607: getfield 122	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   610: invokevirtual 933	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:f	()Lcom/tencent/mobileqq/webview/swift/WebViewProvider;
    //   613: checkcast 935	com/tencent/mobileqq/webview/swift/WebViewFragment
    //   616: astore_1
    //   617: aload_1
    //   618: ifnull +613 -> 1231
    //   621: ldc_w 937
    //   624: invokestatic 460	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   627: checkcast 937	com/tencent/mobileqq/webprocess/temp/api/IWebviewApi
    //   630: aload_1
    //   631: invokeinterface 940 2 0
    //   636: checkcast 272	com/tencent/mobileqq/widget/QQProgressDialog
    //   639: astore_1
    //   640: goto +3 -> 643
    //   643: aload_0
    //   644: aload_1
    //   645: putfield 270	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:s	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   648: aload_0
    //   649: getfield 270	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:s	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   652: ifnull +28 -> 680
    //   655: aload_0
    //   656: getfield 270	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:s	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   659: ldc_w 941
    //   662: invokevirtual 944	com/tencent/mobileqq/widget/QQProgressDialog:c	(I)V
    //   665: aload_0
    //   666: getfield 270	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:s	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   669: iconst_0
    //   670: invokevirtual 947	com/tencent/mobileqq/widget/QQProgressDialog:setCancelable	(Z)V
    //   673: aload_0
    //   674: getfield 270	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:s	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   677: invokevirtual 950	com/tencent/mobileqq/widget/QQProgressDialog:show	()V
    //   680: new 952	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin$1
    //   683: dup
    //   684: aload_0
    //   685: aload 5
    //   687: iconst_0
    //   688: aaload
    //   689: invokespecial 955	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin$1:<init>	(Lcom/tencent/mobileqq/vashealth/HealthStepCounterPlugin;Ljava/lang/String;)V
    //   692: iconst_5
    //   693: aconst_null
    //   694: iconst_1
    //   695: invokestatic 960	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   698: iconst_1
    //   699: ireturn
    //   700: aload 4
    //   702: ldc_w 962
    //   705: invokevirtual 892	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   708: ifeq +106 -> 814
    //   711: aload 5
    //   713: iconst_0
    //   714: aaload
    //   715: astore_2
    //   716: aload_0
    //   717: getfield 270	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:s	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   720: ifnonnull +45 -> 765
    //   723: aload_0
    //   724: getfield 122	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   727: invokevirtual 933	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:f	()Lcom/tencent/mobileqq/webview/swift/WebViewProvider;
    //   730: checkcast 935	com/tencent/mobileqq/webview/swift/WebViewFragment
    //   733: astore_1
    //   734: aload_1
    //   735: ifnull +501 -> 1236
    //   738: ldc_w 937
    //   741: invokestatic 460	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   744: checkcast 937	com/tencent/mobileqq/webprocess/temp/api/IWebviewApi
    //   747: aload_1
    //   748: invokeinterface 940 2 0
    //   753: checkcast 272	com/tencent/mobileqq/widget/QQProgressDialog
    //   756: astore_1
    //   757: goto +3 -> 760
    //   760: aload_0
    //   761: aload_1
    //   762: putfield 270	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:s	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   765: aload_0
    //   766: getfield 270	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:s	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   769: ifnull +28 -> 797
    //   772: aload_0
    //   773: getfield 270	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:s	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   776: ldc_w 941
    //   779: invokevirtual 944	com/tencent/mobileqq/widget/QQProgressDialog:c	(I)V
    //   782: aload_0
    //   783: getfield 270	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:s	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   786: iconst_0
    //   787: invokevirtual 947	com/tencent/mobileqq/widget/QQProgressDialog:setCancelable	(Z)V
    //   790: aload_0
    //   791: getfield 270	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:s	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   794: invokevirtual 950	com/tencent/mobileqq/widget/QQProgressDialog:show	()V
    //   797: new 964	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin$2
    //   800: dup
    //   801: aload_0
    //   802: aload_2
    //   803: invokespecial 965	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin$2:<init>	(Lcom/tencent/mobileqq/vashealth/HealthStepCounterPlugin;Ljava/lang/String;)V
    //   806: iconst_5
    //   807: aconst_null
    //   808: iconst_1
    //   809: invokestatic 960	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   812: iconst_1
    //   813: ireturn
    //   814: aload 4
    //   816: ldc_w 967
    //   819: invokevirtual 892	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   822: ifeq +13 -> 835
    //   825: aload_0
    //   826: aload 5
    //   828: iconst_0
    //   829: aaload
    //   830: invokespecial 969	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:c	(Ljava/lang/String;)V
    //   833: iconst_0
    //   834: ireturn
    //   835: aload 4
    //   837: ldc_w 971
    //   840: invokevirtual 892	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   843: ifeq +94 -> 937
    //   846: new 97	org/json/JSONObject
    //   849: dup
    //   850: aload 5
    //   852: iconst_0
    //   853: aaload
    //   854: invokespecial 101	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   857: ldc 103
    //   859: invokevirtual 107	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   862: astore_1
    //   863: new 514	mqq/app/NewIntent
    //   866: dup
    //   867: aload_0
    //   868: getfield 122	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   871: invokevirtual 546	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:b	()Lcom/tencent/common/app/AppInterface;
    //   874: invokevirtual 805	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   877: ldc_w 807
    //   880: invokespecial 523	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   883: astore_2
    //   884: aload_2
    //   885: ldc_w 809
    //   888: ldc_w 811
    //   891: invokevirtual 529	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   894: pop
    //   895: aload_2
    //   896: ldc_w 813
    //   899: aload 5
    //   901: iconst_0
    //   902: aaload
    //   903: invokevirtual 529	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   906: pop
    //   907: aload_2
    //   908: ldc_w 973
    //   911: aload_1
    //   912: invokevirtual 529	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   915: pop
    //   916: aload_2
    //   917: aload_0
    //   918: getfield 84	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:u	Lmqq/observer/BusinessObserver;
    //   921: invokevirtual 543	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   924: aload_0
    //   925: getfield 122	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   928: invokevirtual 546	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:b	()Lcom/tencent/common/app/AppInterface;
    //   931: aload_2
    //   932: invokevirtual 552	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   935: iconst_0
    //   936: ireturn
    //   937: ldc_w 975
    //   940: aload 4
    //   942: invokevirtual 892	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   945: ifeq +165 -> 1110
    //   948: new 97	org/json/JSONObject
    //   951: dup
    //   952: invokespecial 98	org/json/JSONObject:<init>	()V
    //   955: astore_3
    //   956: aload_2
    //   957: astore_1
    //   958: aload_0
    //   959: getfield 122	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   962: invokevirtual 189	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   965: astore 4
    //   967: aload_2
    //   968: astore_1
    //   969: new 97	org/json/JSONObject
    //   972: dup
    //   973: aload 5
    //   975: iconst_0
    //   976: aaload
    //   977: invokespecial 101	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   980: ldc 103
    //   982: invokevirtual 107	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   985: astore_2
    //   986: aload_2
    //   987: astore_1
    //   988: new 603	android/content/Intent
    //   991: dup
    //   992: ldc_w 977
    //   995: invokespecial 606	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   998: astore 5
    //   1000: aload_2
    //   1001: astore_1
    //   1002: new 135	java/lang/StringBuilder
    //   1005: dup
    //   1006: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   1009: astore 8
    //   1011: aload_2
    //   1012: astore_1
    //   1013: aload 8
    //   1015: ldc_w 979
    //   1018: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1021: pop
    //   1022: aload_2
    //   1023: astore_1
    //   1024: aload 8
    //   1026: aload 4
    //   1028: invokevirtual 982	android/app/Activity:getPackageName	()Ljava/lang/String;
    //   1031: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1034: pop
    //   1035: aload_2
    //   1036: astore_1
    //   1037: aload 5
    //   1039: aload 8
    //   1041: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1044: invokestatic 986	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   1047: invokevirtual 616	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   1050: pop
    //   1051: aload_2
    //   1052: astore_1
    //   1053: aload 4
    //   1055: aload 5
    //   1057: invokevirtual 989	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   1060: aload_2
    //   1061: astore_1
    //   1062: aload_3
    //   1063: ldc_w 991
    //   1066: iconst_0
    //   1067: invokevirtual 256	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1070: pop
    //   1071: aload_2
    //   1072: astore_1
    //   1073: goto +12 -> 1085
    //   1076: aload_3
    //   1077: ldc_w 991
    //   1080: iconst_m1
    //   1081: invokevirtual 256	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1084: pop
    //   1085: aload_1
    //   1086: invokestatic 290	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1089: ifne +122 -> 1211
    //   1092: aload_0
    //   1093: aload_1
    //   1094: iconst_1
    //   1095: anewarray 263	java/lang/String
    //   1098: dup
    //   1099: iconst_0
    //   1100: aload_3
    //   1101: invokevirtual 264	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1104: aastore
    //   1105: invokevirtual 268	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1108: iconst_0
    //   1109: ireturn
    //   1110: aload 4
    //   1112: ldc_w 993
    //   1115: invokevirtual 892	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1118: ifeq +14 -> 1132
    //   1121: aload_0
    //   1122: aload 5
    //   1124: iconst_0
    //   1125: aaload
    //   1126: invokespecial 995	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:d	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1129: pop
    //   1130: iconst_1
    //   1131: ireturn
    //   1132: aload 4
    //   1134: ldc_w 997
    //   1137: invokevirtual 892	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1140: ifeq +14 -> 1154
    //   1143: aload_0
    //   1144: aload 5
    //   1146: iconst_0
    //   1147: aaload
    //   1148: invokespecial 999	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:e	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1151: pop
    //   1152: iconst_1
    //   1153: ireturn
    //   1154: aload 4
    //   1156: ldc_w 1000
    //   1159: invokevirtual 892	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1162: ifeq +49 -> 1211
    //   1165: aload_0
    //   1166: aload 5
    //   1168: iconst_0
    //   1169: aaload
    //   1170: invokespecial 1002	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:f	(Ljava/lang/String;)V
    //   1173: iconst_0
    //   1174: ireturn
    //   1175: astore_1
    //   1176: new 135	java/lang/StringBuilder
    //   1179: dup
    //   1180: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   1183: astore_2
    //   1184: aload_2
    //   1185: ldc_w 1004
    //   1188: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1191: pop
    //   1192: aload_2
    //   1193: aload_1
    //   1194: invokevirtual 280	java/lang/Exception:toString	()Ljava/lang/String;
    //   1197: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1200: pop
    //   1201: ldc 158
    //   1203: iconst_2
    //   1204: aload_2
    //   1205: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1208: invokestatic 626	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1211: iconst_0
    //   1212: ireturn
    //   1213: astore_2
    //   1214: goto -138 -> 1076
    //   1217: astore_2
    //   1218: goto -133 -> 1085
    //   1221: iconst_1
    //   1222: ireturn
    //   1223: iconst_0
    //   1224: istore 6
    //   1226: goto -692 -> 534
    //   1229: iconst_1
    //   1230: ireturn
    //   1231: aconst_null
    //   1232: astore_1
    //   1233: goto -590 -> 643
    //   1236: aconst_null
    //   1237: astore_1
    //   1238: goto -478 -> 760
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1241	0	this	HealthStepCounterPlugin
    //   0	1241	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	1241	2	paramString1	String
    //   0	1241	3	paramString2	String
    //   0	1241	4	paramString3	String
    //   0	1241	5	paramVarArgs	String[]
    //   529	696	6	i1	int
    //   43	552	7	bool	boolean
    //   1009	31	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   35	45	1175	java/lang/Exception
    //   50	87	1175	java/lang/Exception
    //   90	153	1175	java/lang/Exception
    //   155	179	1175	java/lang/Exception
    //   181	239	1175	java/lang/Exception
    //   241	293	1175	java/lang/Exception
    //   293	397	1175	java/lang/Exception
    //   399	528	1175	java/lang/Exception
    //   539	580	1175	java/lang/Exception
    //   582	592	1175	java/lang/Exception
    //   599	617	1175	java/lang/Exception
    //   621	640	1175	java/lang/Exception
    //   643	648	1175	java/lang/Exception
    //   648	680	1175	java/lang/Exception
    //   680	698	1175	java/lang/Exception
    //   700	711	1175	java/lang/Exception
    //   716	734	1175	java/lang/Exception
    //   738	757	1175	java/lang/Exception
    //   760	765	1175	java/lang/Exception
    //   765	797	1175	java/lang/Exception
    //   797	812	1175	java/lang/Exception
    //   814	833	1175	java/lang/Exception
    //   835	935	1175	java/lang/Exception
    //   937	956	1175	java/lang/Exception
    //   1076	1085	1175	java/lang/Exception
    //   1085	1108	1175	java/lang/Exception
    //   1110	1130	1175	java/lang/Exception
    //   1132	1152	1175	java/lang/Exception
    //   1154	1173	1175	java/lang/Exception
    //   958	967	1213	java/lang/Exception
    //   969	986	1213	java/lang/Exception
    //   988	1000	1213	java/lang/Exception
    //   1002	1011	1213	java/lang/Exception
    //   1013	1022	1213	java/lang/Exception
    //   1024	1035	1213	java/lang/Exception
    //   1037	1051	1213	java/lang/Exception
    //   1053	1060	1213	java/lang/Exception
    //   1062	1071	1213	java/lang/Exception
    //   1076	1085	1217	org/json/JSONException
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.e = this.mRuntime.d();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (t != null)
    {
      ((SensorManager)this.e.getSystemService("sensor")).unregisterListener(t);
      t = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthStepCounterPlugin
 * JD-Core Version:    0.7.0.1
 */