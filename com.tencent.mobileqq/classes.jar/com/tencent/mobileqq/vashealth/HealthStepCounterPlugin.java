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
  public static int a = -1;
  static long jdField_a_of_type_Long = 0L;
  private static HealthStepCounterPlugin.StepShakeListener jdField_a_of_type_ComTencentMobileqqVashealthHealthStepCounterPlugin$StepShakeListener;
  static boolean jdField_a_of_type_Boolean = false;
  static int jdField_b_of_type_Int = 0;
  static boolean jdField_b_of_type_Boolean = true;
  public Activity a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  String jdField_a_of_type_JavaLangString = null;
  public HashMap<String, Long> a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver = new HealthStepCounterPlugin.6(this);
  String jdField_b_of_type_JavaLangString = null;
  public HashMap<String, Long> b;
  int jdField_c_of_type_Int = 0;
  String jdField_c_of_type_JavaLangString;
  public HashMap<String, Long> c;
  int jdField_d_of_type_Int = 0;
  String jdField_d_of_type_JavaLangString = null;
  String e = null;
  String f = null;
  
  public HealthStepCounterPlugin()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    this.mPluginNameSpace = "healthkit";
  }
  
  /* Error */
  private JSONObject a(String paramString)
  {
    // Byte code:
    //   0: new 82	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 83	org/json/JSONObject:<init>	()V
    //   7: astore 9
    //   9: new 82	org/json/JSONObject
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 86	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17: astore_1
    //   18: aload_1
    //   19: ldc 88
    //   21: invokevirtual 92	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   24: astore 10
    //   26: aload_1
    //   27: ldc 94
    //   29: invokevirtual 98	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   32: istore_2
    //   33: aload_1
    //   34: ldc 100
    //   36: invokevirtual 98	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   39: istore_3
    //   40: aload_1
    //   41: ldc 102
    //   43: invokevirtual 98	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   46: istore 4
    //   48: aload_1
    //   49: ldc 104
    //   51: invokevirtual 98	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   54: istore 5
    //   56: aload_0
    //   57: getfield 108	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   60: invokevirtual 113	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   63: astore_1
    //   64: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   67: ifeq +59 -> 126
    //   70: new 121	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   77: astore 8
    //   79: aload 8
    //   81: ldc 124
    //   83: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 8
    //   89: aload_1
    //   90: invokevirtual 134	com/tencent/biz/pubaccount/CustomWebView:getWidth	()I
    //   93: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload 8
    //   99: ldc 139
    //   101: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 8
    //   107: aload_1
    //   108: invokevirtual 142	com/tencent/biz/pubaccount/CustomWebView:getHeight	()I
    //   111: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: ldc 144
    //   117: iconst_2
    //   118: aload 8
    //   120: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 152	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: aload_1
    //   127: invokevirtual 134	com/tencent/biz/pubaccount/CustomWebView:getWidth	()I
    //   130: aload_1
    //   131: invokevirtual 142	com/tencent/biz/pubaccount/CustomWebView:getHeight	()I
    //   134: getstatic 158	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   137: invokestatic 164	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   140: astore 8
    //   142: aload_1
    //   143: new 166	android/graphics/Canvas
    //   146: dup
    //   147: aload 8
    //   149: invokespecial 169	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   152: invokevirtual 173	com/tencent/biz/pubaccount/CustomWebView:draw	(Landroid/graphics/Canvas;)V
    //   155: aload_0
    //   156: getfield 108	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   159: invokevirtual 176	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   162: invokevirtual 182	android/app/Activity:getWindowManager	()Landroid/view/WindowManager;
    //   165: invokeinterface 188 1 0
    //   170: invokevirtual 191	android/view/Display:getWidth	()I
    //   173: istore 6
    //   175: aload_0
    //   176: getfield 108	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   179: invokevirtual 176	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   182: invokevirtual 182	android/app/Activity:getWindowManager	()Landroid/view/WindowManager;
    //   185: invokeinterface 188 1 0
    //   190: invokevirtual 192	android/view/Display:getHeight	()I
    //   193: istore 7
    //   195: iload_2
    //   196: iflt +298 -> 494
    //   199: iload_3
    //   200: iflt +294 -> 494
    //   203: iload 4
    //   205: iload 6
    //   207: if_icmpgt +287 -> 494
    //   210: iload 5
    //   212: iload 7
    //   214: if_icmple +6 -> 220
    //   217: goto +277 -> 494
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
    //   244: invokestatic 195	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   247: astore_1
    //   248: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   251: ifeq +41 -> 292
    //   254: new 121	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   261: astore 8
    //   263: aload 8
    //   265: ldc 197
    //   267: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload 8
    //   273: aload_1
    //   274: invokevirtual 200	android/graphics/Bitmap:getByteCount	()I
    //   277: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: ldc 144
    //   283: iconst_2
    //   284: aload 8
    //   286: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokestatic 202	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   292: new 204	java/io/File
    //   295: dup
    //   296: ldc 206
    //   298: invokestatic 211	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   301: invokespecial 212	java/io/File:<init>	(Ljava/lang/String;)V
    //   304: astore 8
    //   306: aload 8
    //   308: invokevirtual 215	java/io/File:mkdirs	()Z
    //   311: pop
    //   312: aload 8
    //   314: invokevirtual 218	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   317: astore 8
    //   319: new 121	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   326: astore 11
    //   328: aload 11
    //   330: aload 8
    //   332: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload 11
    //   338: getstatic 221	java/io/File:separator	Ljava/lang/String;
    //   341: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload 11
    //   347: invokestatic 227	java/lang/System:currentTimeMillis	()J
    //   350: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: aload 11
    //   356: ldc 232
    //   358: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload 11
    //   364: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: astore 8
    //   369: aload_1
    //   370: new 204	java/io/File
    //   373: dup
    //   374: aload 8
    //   376: invokespecial 212	java/io/File:<init>	(Ljava/lang/String;)V
    //   379: invokestatic 237	com/tencent/mobileqq/utils/BaseImageUtil:a	(Landroid/graphics/Bitmap;Ljava/io/File;)V
    //   382: aload_1
    //   383: ifnull +56 -> 439
    //   386: aload 9
    //   388: ldc 239
    //   390: iconst_0
    //   391: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   394: pop
    //   395: aload 9
    //   397: ldc 245
    //   399: aload 8
    //   401: invokevirtual 248	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   404: pop
    //   405: aload_0
    //   406: aload 10
    //   408: iconst_1
    //   409: anewarray 250	java/lang/String
    //   412: dup
    //   413: iconst_0
    //   414: aload 9
    //   416: invokevirtual 251	org/json/JSONObject:toString	()Ljava/lang/String;
    //   419: aastore
    //   420: invokevirtual 255	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   423: aload_0
    //   424: getfield 257	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   427: astore_1
    //   428: aload_1
    //   429: ifnull +7 -> 436
    //   432: aload_1
    //   433: invokevirtual 262	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   436: aload 9
    //   438: areturn
    //   439: aload 9
    //   441: ldc 239
    //   443: bipush 254
    //   445: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   448: pop
    //   449: aload 9
    //   451: ldc 245
    //   453: ldc_w 264
    //   456: invokevirtual 248	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   459: pop
    //   460: aload_0
    //   461: aload 10
    //   463: iconst_1
    //   464: anewarray 250	java/lang/String
    //   467: dup
    //   468: iconst_0
    //   469: aload 9
    //   471: invokevirtual 251	org/json/JSONObject:toString	()Ljava/lang/String;
    //   474: aastore
    //   475: invokevirtual 255	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   478: aload_0
    //   479: getfield 257	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   482: astore_1
    //   483: aload_1
    //   484: ifnull +7 -> 491
    //   487: aload_1
    //   488: invokevirtual 262	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   491: aload 9
    //   493: areturn
    //   494: aload 9
    //   496: ldc 239
    //   498: iconst_m1
    //   499: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   502: pop
    //   503: aload 9
    //   505: ldc 245
    //   507: ldc_w 264
    //   510: invokevirtual 248	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   513: pop
    //   514: aload_0
    //   515: aload 10
    //   517: iconst_1
    //   518: anewarray 250	java/lang/String
    //   521: dup
    //   522: iconst_0
    //   523: aload 9
    //   525: invokevirtual 251	org/json/JSONObject:toString	()Ljava/lang/String;
    //   528: aastore
    //   529: invokevirtual 255	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   532: aload_0
    //   533: getfield 257	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   536: astore_1
    //   537: aload_1
    //   538: ifnull +7 -> 545
    //   541: aload_1
    //   542: invokevirtual 262	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   545: aload 9
    //   547: areturn
    //   548: astore_1
    //   549: goto +64 -> 613
    //   552: astore_1
    //   553: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   556: ifeq +42 -> 598
    //   559: new 121	java/lang/StringBuilder
    //   562: dup
    //   563: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   566: astore 8
    //   568: aload 8
    //   570: ldc_w 266
    //   573: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: pop
    //   577: aload 8
    //   579: aload_1
    //   580: invokevirtual 267	java/lang/Exception:toString	()Ljava/lang/String;
    //   583: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: pop
    //   587: ldc 144
    //   589: iconst_2
    //   590: aload 8
    //   592: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   595: invokestatic 202	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   598: aload_0
    //   599: getfield 257	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   602: astore_1
    //   603: aload_1
    //   604: ifnull +7 -> 611
    //   607: aload_1
    //   608: invokevirtual 262	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   611: aconst_null
    //   612: areturn
    //   613: aload_0
    //   614: getfield 257	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   617: astore 8
    //   619: aload 8
    //   621: ifnull +8 -> 629
    //   624: aload 8
    //   626: invokevirtual 262	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   629: aload_1
    //   630: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	631	0	this	HealthStepCounterPlugin
    //   0	631	1	paramString	String
    //   32	207	2	i	int
    //   39	201	3	j	int
    //   46	195	4	k	int
    //   54	189	5	m	int
    //   173	35	6	n	int
    //   193	22	7	i1	int
    //   77	548	8	localObject	Object
    //   7	539	9	localJSONObject	JSONObject
    //   24	492	10	str	String
    //   326	37	11	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	126	548	finally
    //   126	195	548	finally
    //   236	248	548	finally
    //   248	292	548	finally
    //   292	382	548	finally
    //   386	423	548	finally
    //   439	478	548	finally
    //   494	532	548	finally
    //   553	598	548	finally
    //   0	126	552	java/lang/Exception
    //   126	195	552	java/lang/Exception
    //   236	248	552	java/lang/Exception
    //   248	292	552	java/lang/Exception
    //   292	382	552	java/lang/Exception
    //   386	423	552	java/lang/Exception
    //   439	478	552	java/lang/Exception
    //   494	532	552	java/lang/Exception
  }
  
  private void a(String paramString)
  {
    Object localObject1;
    Object localObject2;
    if (jdField_a_of_type_ComTencentMobileqqVashealthHealthStepCounterPlugin$StepShakeListener == null)
    {
      localObject1 = new HealthStepCounterPlugin.StepShakeListener(null);
      localObject2 = (SensorManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("sensor");
      ((SensorManager)localObject2).registerListener((SensorEventListener)localObject1, ((SensorManager)localObject2).getDefaultSensor(1), 0);
      jdField_a_of_type_ComTencentMobileqqVashealthHealthStepCounterPlugin$StepShakeListener = (HealthStepCounterPlugin.StepShakeListener)localObject1;
      QLog.d("HealthStepCounterPlugin", 1, "register shakelistener");
    }
    try
    {
      this.jdField_d_of_type_JavaLangString = new JSONObject(paramString).getString("callback");
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        localObject1 = (SensorManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("sensor");
        localObject2 = ((SensorManager)localObject1).getDefaultSensor(19);
        if ((Build.VERSION.SDK_INT >= 19) && (localObject2 != null))
        {
          HealthStepCounterPlugin.7 local7 = new HealthStepCounterPlugin.7(this);
          ((SensorManager)localObject1).registerListener(local7, (Sensor)localObject2, 3, 0);
          ((SensorManager)localObject1).flush(local7);
          localObject1 = new NewIntent(this.mRuntime.a().getApplication(), StepCounterServlert.class);
          ((NewIntent)localObject1).putExtra("msf_cmd_type", "cmd_refresh_steps");
          ((NewIntent)localObject1).putExtra("json_string", paramString);
          ((NewIntent)localObject1).setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
          this.mRuntime.a().startServlet((NewIntent)localObject1);
          return;
        }
        this.e = "Unsupported model found.";
        paramString = new JSONObject();
      }
    }
    catch (Throwable localThrowable)
    {
      try
      {
        paramString.put("retCode", jdField_a_of_type_Int);
        paramString.put("msg", this.e);
        label251:
        callJs(this.jdField_d_of_type_JavaLangString, new String[] { paramString.toString() });
        return;
        localThrowable = localThrowable;
      }
      catch (Exception localException)
      {
        break label251;
      }
    }
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
        boolean bool = NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidAppActivity);
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
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("yundong_report.steps")) {
          l1 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get("yundong_report.steps")).longValue();
        }
        if (l1 <= 0L) {
          break label1254;
        }
        if (paramString1.toString().getBytes().length > l1)
        {
          paramString1 = new JSONObject();
          paramString1.put("ssoRet", 101);
          paramString1.put("businessRet", 0);
          paramString1.put("msg", HardCodeUtil.a(2131705544));
          super.callJs(str, new String[] { paramString1.toString() });
          return;
        }
        if (this.jdField_c_of_type_JavaUtilHashMap.containsKey("yundong_report.steps"))
        {
          long l2 = ((Long)this.jdField_c_of_type_JavaUtilHashMap.get("yundong_report.steps")).longValue();
          l1 = 1000L;
          if (this.jdField_b_of_type_JavaUtilHashMap.containsKey("yundong_report.steps")) {
            l1 = ((Long)this.jdField_b_of_type_JavaUtilHashMap.get("yundong_report.steps")).longValue();
          }
          if ((l1 > 0L) && (System.currentTimeMillis() - l2 < l1))
          {
            paramString1 = new JSONObject();
            paramString1.put("ssoRet", 102);
            paramString1.put("businessRet", 0);
            paramString1.put("msg", HardCodeUtil.a(2131705543));
            super.callJs(str, new String[] { paramString1.toString() });
            this.jdField_c_of_type_JavaUtilHashMap.put("yundong_report.steps", Long.valueOf(System.currentTimeMillis()));
            return;
          }
        }
        this.jdField_c_of_type_JavaUtilHashMap.put("yundong_report.steps", Long.valueOf(System.currentTimeMillis()));
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
            int i = paramString2.getInt(localStringBuilder.toString());
            localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject);
            localStringBuilder.append("_init");
            int j = paramString2.getInt(localStringBuilder.toString());
            localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject);
            localStringBuilder.append("_offset");
            j = i - j + paramString2.getInt(localStringBuilder.toString());
            paramString2 = SSOHttpUtils.a();
            i = j;
            if (paramString2[1] != -1)
            {
              i = j;
              if (paramString2[1] > j)
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("use device step:");
                ((StringBuilder)localObject).append(paramString2[1]);
                ((StringBuilder)localObject).append(" instead of:");
                ((StringBuilder)localObject).append(j);
                QLog.e("HealthStepCounterPlugin", 1, ((StringBuilder)localObject).toString());
                i = paramString2[1];
              }
            }
            l1 = NetConnInfoCenter.getServerTime();
            paramString2 = new JSONArray();
            localObject = new JSONObject();
            ((JSONObject)localObject).put("type", 1);
            ((JSONObject)localObject).put("time", l1);
            ((JSONObject)localObject).put("steps", i);
            paramString2.put(localObject);
            paramString1.put("oauth_consumer_key", 1002);
            paramString1.put("data", paramString2);
            paramString1.put("version", "8.7.0");
            if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
              this.jdField_a_of_type_JavaLangString = URLEncoder.encode(Build.MODEL, "utf-8");
            }
            paramString1.put("model", this.jdField_a_of_type_JavaLangString);
            if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
            {
              paramString2 = TimeZone.getDefault();
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(paramString2.getDisplayName(false, 0));
              ((StringBuilder)localObject).append(" ");
              ((StringBuilder)localObject).append(paramString2.getID());
              this.jdField_c_of_type_JavaLangString = ((StringBuilder)localObject).toString();
            }
            paramString1.put("zone", String.valueOf(this.jdField_c_of_type_JavaLangString));
            if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
              this.jdField_b_of_type_JavaLangString = MobileInfoUtil.getImei();
            }
            paramString1.put("imei", String.valueOf(this.jdField_b_of_type_JavaLangString));
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
            ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.7.0");
            paramString2 = new WebSSOAgent.UniSsoServerReq();
            paramString2.comm.set((MessageMicro)localObject);
            paramString2.reqdata.set(paramString1.toString());
            paramString1 = new HealthStepCounterPlugin.3(this);
            if (this.mRuntime == null) {
              break label1253;
            }
            localObject = new NewIntent(this.mRuntime.a().getApplicationContext(), WebSSOAgentServlet.class);
            ((NewIntent)localObject).putExtra("extra_cmd", "yundong_report.steps");
            ((NewIntent)localObject).putExtra("extra_data", paramString2.toByteArray());
            ((NewIntent)localObject).putExtra("extra_callbackid", str);
            ((NewIntent)localObject).setObserver(paramString1);
            this.mRuntime.a().startServlet((NewIntent)localObject);
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
    //   0: new 82	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 83	org/json/JSONObject:<init>	()V
    //   7: astore 8
    //   9: invokestatic 227	java/lang/System:currentTimeMillis	()J
    //   12: lstore_3
    //   13: aload_0
    //   14: getfield 108	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   17: ifnull +1067 -> 1084
    //   20: aload_0
    //   21: getfield 282	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   24: ifnull +1060 -> 1084
    //   27: new 82	org/json/JSONObject
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 86	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   35: astore_1
    //   36: aload_1
    //   37: ldc 88
    //   39: invokevirtual 92	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   42: astore 9
    //   44: aload 9
    //   46: invokestatic 308	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   49: ifeq +6 -> 55
    //   52: aload 8
    //   54: areturn
    //   55: aload_1
    //   56: ldc_w 614
    //   59: invokevirtual 445	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   62: istore_2
    //   63: aload_1
    //   64: ldc 245
    //   66: invokevirtual 92	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   69: astore 10
    //   71: new 616	android/graphics/BitmapFactory$Options
    //   74: dup
    //   75: invokespecial 617	android/graphics/BitmapFactory$Options:<init>	()V
    //   78: astore_1
    //   79: aload_1
    //   80: iconst_1
    //   81: putfield 620	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   84: aload 10
    //   86: aload_1
    //   87: invokestatic 626	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   90: astore 6
    //   92: aload_1
    //   93: iconst_0
    //   94: putfield 620	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   97: aload 10
    //   99: aload_1
    //   100: invokestatic 626	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   103: astore_1
    //   104: goto +53 -> 157
    //   107: astore 7
    //   109: aload 6
    //   111: astore_1
    //   112: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq +42 -> 157
    //   118: new 121	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   125: astore_1
    //   126: aload_1
    //   127: ldc_w 266
    //   130: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload_1
    //   135: aload 7
    //   137: invokevirtual 627	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   140: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: ldc 144
    //   146: iconst_2
    //   147: aload_1
    //   148: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 202	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: aload 6
    //   156: astore_1
    //   157: new 204	java/io/File
    //   160: dup
    //   161: aload 10
    //   163: invokespecial 212	java/io/File:<init>	(Ljava/lang/String;)V
    //   166: astore 6
    //   168: new 629	java/io/FileOutputStream
    //   171: dup
    //   172: aload 6
    //   174: invokespecial 632	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   177: astore 6
    //   179: aload_1
    //   180: getstatic 638	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   183: bipush 80
    //   185: aload 6
    //   187: invokevirtual 642	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   190: istore 5
    //   192: aload_0
    //   193: getfield 257	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   196: ifnull +904 -> 1100
    //   199: aload_0
    //   200: getfield 257	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   203: invokevirtual 645	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   206: ifeq +894 -> 1100
    //   209: aload_0
    //   210: getfield 257	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   213: invokevirtual 262	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   216: goto +884 -> 1100
    //   219: new 121	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   226: astore 7
    //   228: aload 7
    //   230: getstatic 650	com/tencent/mobileqq/app/AppConstants:SDCARD_IMG_SAVE	Ljava/lang/String;
    //   233: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload 7
    //   239: getstatic 221	java/io/File:separator	Ljava/lang/String;
    //   242: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload 7
    //   248: invokestatic 227	java/lang/System:currentTimeMillis	()J
    //   251: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload 7
    //   257: ldc 232
    //   259: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: new 204	java/io/File
    //   266: dup
    //   267: aload 7
    //   269: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokespecial 212	java/io/File:<init>	(Ljava/lang/String;)V
    //   275: astore 7
    //   277: aload_1
    //   278: aload 7
    //   280: invokestatic 237	com/tencent/mobileqq/utils/BaseImageUtil:a	(Landroid/graphics/Bitmap;Ljava/io/File;)V
    //   283: new 652	android/content/Intent
    //   286: dup
    //   287: ldc_w 654
    //   290: invokespecial 655	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   293: astore_1
    //   294: aload_1
    //   295: aload 7
    //   297: invokestatic 661	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   300: invokevirtual 665	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   303: pop
    //   304: aload_0
    //   305: getfield 108	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   308: invokevirtual 176	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   311: invokevirtual 587	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   314: aload_1
    //   315: invokevirtual 671	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   318: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   321: ifeq +422 -> 743
    //   324: new 121	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   331: astore_1
    //   332: aload_1
    //   333: ldc_w 673
    //   336: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload_1
    //   341: getstatic 650	com/tencent/mobileqq/app/AppConstants:SDCARD_IMG_SAVE	Ljava/lang/String;
    //   344: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: ldc 144
    //   350: iconst_2
    //   351: aload_1
    //   352: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   355: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   358: goto +385 -> 743
    //   361: invokestatic 678	com/tencent/mobileqq/wxapi/WXShareHelper:a	()Lcom/tencent/mobileqq/wxapi/WXShareHelper;
    //   364: invokevirtual 680	com/tencent/mobileqq/wxapi/WXShareHelper:a	()Z
    //   367: ifeq +16 -> 383
    //   370: invokestatic 678	com/tencent/mobileqq/wxapi/WXShareHelper:a	()Lcom/tencent/mobileqq/wxapi/WXShareHelper;
    //   373: aload 10
    //   375: aload_1
    //   376: iconst_1
    //   377: invokevirtual 683	com/tencent/mobileqq/wxapi/WXShareHelper:a	(Ljava/lang/String;Landroid/graphics/Bitmap;I)V
    //   380: goto +363 -> 743
    //   383: aload_0
    //   384: getfield 108	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   387: invokevirtual 113	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   390: new 685	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin$4
    //   393: dup
    //   394: aload_0
    //   395: invokespecial 686	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin$4:<init>	(Lcom/tencent/mobileqq/vashealth/HealthStepCounterPlugin;)V
    //   398: invokevirtual 690	com/tencent/biz/pubaccount/CustomWebView:post	(Ljava/lang/Runnable;)Z
    //   401: pop
    //   402: goto +341 -> 743
    //   405: invokestatic 678	com/tencent/mobileqq/wxapi/WXShareHelper:a	()Lcom/tencent/mobileqq/wxapi/WXShareHelper;
    //   408: invokevirtual 680	com/tencent/mobileqq/wxapi/WXShareHelper:a	()Z
    //   411: ifeq +16 -> 427
    //   414: invokestatic 678	com/tencent/mobileqq/wxapi/WXShareHelper:a	()Lcom/tencent/mobileqq/wxapi/WXShareHelper;
    //   417: aload 10
    //   419: aload_1
    //   420: iconst_0
    //   421: invokevirtual 683	com/tencent/mobileqq/wxapi/WXShareHelper:a	(Ljava/lang/String;Landroid/graphics/Bitmap;I)V
    //   424: goto +319 -> 743
    //   427: aload_0
    //   428: getfield 108	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   431: invokevirtual 113	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   434: new 692	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin$5
    //   437: dup
    //   438: aload_0
    //   439: invokespecial 693	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin$5:<init>	(Lcom/tencent/mobileqq/vashealth/HealthStepCounterPlugin;)V
    //   442: invokevirtual 690	com/tencent/biz/pubaccount/CustomWebView:post	(Ljava/lang/Runnable;)Z
    //   445: pop
    //   446: goto +297 -> 743
    //   449: new 695	android/os/Bundle
    //   452: dup
    //   453: invokespecial 696	android/os/Bundle:<init>	()V
    //   456: astore_1
    //   457: new 698	java/util/ArrayList
    //   460: dup
    //   461: invokespecial 699	java/util/ArrayList:<init>	()V
    //   464: astore 7
    //   466: aload 7
    //   468: aload 10
    //   470: invokestatic 704	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   473: invokevirtual 707	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   476: pop
    //   477: aload_1
    //   478: ldc_w 709
    //   481: aload 7
    //   483: invokevirtual 713	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   486: aload_1
    //   487: ldc_w 715
    //   490: ldc_w 716
    //   493: invokestatic 408	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   496: invokevirtual 719	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   499: aload_1
    //   500: ldc_w 721
    //   503: bipush 7
    //   505: invokevirtual 725	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   508: aload_1
    //   509: ldc_w 727
    //   512: iconst_0
    //   513: invokevirtual 731	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   516: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   519: ifeq +39 -> 558
    //   522: new 121	java/lang/StringBuilder
    //   525: dup
    //   526: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   529: astore 7
    //   531: aload 7
    //   533: ldc_w 733
    //   536: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: pop
    //   540: aload 7
    //   542: aload_1
    //   543: invokevirtual 604	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   546: pop
    //   547: ldc 144
    //   549: iconst_2
    //   550: aload 7
    //   552: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   555: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   558: ldc_w 735
    //   561: invokestatic 534	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   564: checkcast 735	com/tencent/qzonehub/api/IQzoneShareApi
    //   567: aload_0
    //   568: getfield 108	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   571: invokevirtual 331	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   574: aload_0
    //   575: getfield 108	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   578: invokevirtual 176	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   581: aload_1
    //   582: aconst_null
    //   583: invokeinterface 739 5 0
    //   588: goto +155 -> 743
    //   591: new 695	android/os/Bundle
    //   594: dup
    //   595: invokespecial 696	android/os/Bundle:<init>	()V
    //   598: astore_1
    //   599: aload_1
    //   600: ldc_w 741
    //   603: iconst_1
    //   604: invokevirtual 725	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   607: aload_1
    //   608: ldc_w 743
    //   611: aload 10
    //   613: invokevirtual 719	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   616: aload_1
    //   617: ldc_w 745
    //   620: aload 10
    //   622: invokevirtual 719	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   625: aload_1
    //   626: ldc_w 747
    //   629: aload 10
    //   631: invokevirtual 719	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   634: aload_1
    //   635: ldc_w 749
    //   638: aload 10
    //   640: invokevirtual 719	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   643: aload_1
    //   644: ldc_w 751
    //   647: iconst_1
    //   648: invokevirtual 731	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   651: new 652	android/content/Intent
    //   654: dup
    //   655: invokespecial 752	android/content/Intent:<init>	()V
    //   658: astore 7
    //   660: aload 7
    //   662: aload_1
    //   663: invokevirtual 756	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   666: pop
    //   667: aload 7
    //   669: aload_0
    //   670: getfield 282	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   673: ldc_w 758
    //   676: invokestatic 534	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   679: checkcast 758	com/tencent/mobileqq/forward/api/IForwardApi
    //   682: invokeinterface 762 1 0
    //   687: invokevirtual 766	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   690: pop
    //   691: aload 7
    //   693: ldc_w 768
    //   696: aload_0
    //   697: getfield 282	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   700: invokevirtual 773	java/lang/Object:getClass	()Ljava/lang/Class;
    //   703: invokevirtual 778	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   706: invokevirtual 779	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   709: pop
    //   710: aload 7
    //   712: ldc_w 781
    //   715: iconst_m1
    //   716: invokevirtual 784	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   719: pop
    //   720: aload 7
    //   722: ldc_w 786
    //   725: ldc_w 264
    //   728: invokevirtual 779	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   731: pop
    //   732: aload_0
    //   733: getfield 282	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   736: aload 7
    //   738: bipush 21
    //   740: invokevirtual 790	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   743: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   746: ifeq +39 -> 785
    //   749: new 121	java/lang/StringBuilder
    //   752: dup
    //   753: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   756: astore_1
    //   757: aload_1
    //   758: ldc_w 792
    //   761: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: pop
    //   765: aload_1
    //   766: invokestatic 227	java/lang/System:currentTimeMillis	()J
    //   769: lload_3
    //   770: lsub
    //   771: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   774: pop
    //   775: ldc 144
    //   777: iconst_2
    //   778: aload_1
    //   779: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   782: invokestatic 152	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   785: aload 6
    //   787: invokevirtual 795	java/io/FileOutputStream:close	()V
    //   790: goto +87 -> 877
    //   793: astore_1
    //   794: goto +232 -> 1026
    //   797: astore 7
    //   799: aload 6
    //   801: astore_1
    //   802: aload 7
    //   804: astore 6
    //   806: goto +14 -> 820
    //   809: astore_1
    //   810: aconst_null
    //   811: astore 6
    //   813: goto +213 -> 1026
    //   816: astore 6
    //   818: aconst_null
    //   819: astore_1
    //   820: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   823: ifeq +43 -> 866
    //   826: new 121	java/lang/StringBuilder
    //   829: dup
    //   830: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   833: astore 7
    //   835: aload 7
    //   837: ldc_w 266
    //   840: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: pop
    //   844: aload 7
    //   846: aload 6
    //   848: invokevirtual 796	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   851: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   854: pop
    //   855: ldc 144
    //   857: iconst_2
    //   858: aload 7
    //   860: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   863: invokestatic 202	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   866: aload_1
    //   867: ifnull +7 -> 874
    //   870: aload_1
    //   871: invokevirtual 795	java/io/FileOutputStream:close	()V
    //   874: iconst_0
    //   875: istore 5
    //   877: new 82	org/json/JSONObject
    //   880: dup
    //   881: invokespecial 83	org/json/JSONObject:<init>	()V
    //   884: astore_1
    //   885: iload 5
    //   887: ifeq +63 -> 950
    //   890: aload_1
    //   891: ldc_w 798
    //   894: iconst_0
    //   895: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   898: pop
    //   899: aload_1
    //   900: ldc_w 368
    //   903: ldc_w 799
    //   906: invokestatic 408	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   909: invokevirtual 248	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   912: pop
    //   913: aload_1
    //   914: ldc_w 801
    //   917: aload 10
    //   919: invokevirtual 248	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   922: pop
    //   923: aload 8
    //   925: ldc 239
    //   927: iconst_0
    //   928: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   931: pop
    //   932: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   935: ifeq +62 -> 997
    //   938: ldc 144
    //   940: iconst_2
    //   941: ldc_w 803
    //   944: invokestatic 152	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   947: goto +50 -> 997
    //   950: aload_1
    //   951: ldc_w 798
    //   954: iconst_m1
    //   955: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   958: pop
    //   959: aload_1
    //   960: ldc_w 368
    //   963: ldc_w 804
    //   966: invokestatic 408	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   969: invokevirtual 248	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   972: pop
    //   973: aload 8
    //   975: ldc 239
    //   977: iconst_m1
    //   978: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   981: pop
    //   982: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   985: ifeq +12 -> 997
    //   988: ldc 144
    //   990: iconst_2
    //   991: ldc_w 806
    //   994: invokestatic 152	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   997: aload_0
    //   998: aload 9
    //   1000: iconst_1
    //   1001: anewarray 250	java/lang/String
    //   1004: dup
    //   1005: iconst_0
    //   1006: aload 8
    //   1008: invokevirtual 251	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1011: aastore
    //   1012: invokevirtual 255	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1015: aload 8
    //   1017: areturn
    //   1018: astore 7
    //   1020: aload_1
    //   1021: astore 6
    //   1023: aload 7
    //   1025: astore_1
    //   1026: aload 6
    //   1028: ifnull +8 -> 1036
    //   1031: aload 6
    //   1033: invokevirtual 795	java/io/FileOutputStream:close	()V
    //   1036: aload_1
    //   1037: athrow
    //   1038: astore_1
    //   1039: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1042: ifeq +42 -> 1084
    //   1045: new 121	java/lang/StringBuilder
    //   1048: dup
    //   1049: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1052: astore 6
    //   1054: aload 6
    //   1056: ldc_w 266
    //   1059: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1062: pop
    //   1063: aload 6
    //   1065: aload_1
    //   1066: invokevirtual 267	java/lang/Exception:toString	()Ljava/lang/String;
    //   1069: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1072: pop
    //   1073: ldc 144
    //   1075: iconst_2
    //   1076: aload 6
    //   1078: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1081: invokestatic 202	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1084: aload 8
    //   1086: areturn
    //   1087: astore_1
    //   1088: goto -211 -> 877
    //   1091: astore_1
    //   1092: goto -218 -> 874
    //   1095: astore 6
    //   1097: goto -61 -> 1036
    //   1100: iload_2
    //   1101: iconst_1
    //   1102: if_icmpeq -511 -> 591
    //   1105: iload_2
    //   1106: iconst_2
    //   1107: if_icmpeq -658 -> 449
    //   1110: iload_2
    //   1111: iconst_3
    //   1112: if_icmpeq -707 -> 405
    //   1115: iload_2
    //   1116: iconst_4
    //   1117: if_icmpeq -756 -> 361
    //   1120: iload_2
    //   1121: iconst_5
    //   1122: if_icmpeq -903 -> 219
    //   1125: goto -382 -> 743
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1128	0	this	HealthStepCounterPlugin
    //   0	1128	1	paramString	String
    //   62	1061	2	i	int
    //   12	758	3	l	long
    //   190	696	5	bool	boolean
    //   90	722	6	localObject1	Object
    //   816	31	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   1021	56	6	localObject2	Object
    //   1095	1	6	localIOException	java.io.IOException
    //   107	29	7	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   226	511	7	localObject3	Object
    //   797	6	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   833	26	7	localStringBuilder	StringBuilder
    //   1018	6	7	localObject4	Object
    //   7	1078	8	localJSONObject	JSONObject
    //   42	957	9	str1	String
    //   69	849	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   97	104	107	java/lang/OutOfMemoryError
    //   179	216	793	finally
    //   219	358	793	finally
    //   361	380	793	finally
    //   383	402	793	finally
    //   405	424	793	finally
    //   427	446	793	finally
    //   449	558	793	finally
    //   558	588	793	finally
    //   591	743	793	finally
    //   743	785	793	finally
    //   179	216	797	java/io/FileNotFoundException
    //   219	358	797	java/io/FileNotFoundException
    //   361	380	797	java/io/FileNotFoundException
    //   383	402	797	java/io/FileNotFoundException
    //   405	424	797	java/io/FileNotFoundException
    //   427	446	797	java/io/FileNotFoundException
    //   449	558	797	java/io/FileNotFoundException
    //   558	588	797	java/io/FileNotFoundException
    //   591	743	797	java/io/FileNotFoundException
    //   743	785	797	java/io/FileNotFoundException
    //   168	179	809	finally
    //   168	179	816	java/io/FileNotFoundException
    //   820	866	1018	finally
    //   27	52	1038	java/lang/Exception
    //   55	97	1038	java/lang/Exception
    //   97	104	1038	java/lang/Exception
    //   112	154	1038	java/lang/Exception
    //   157	168	1038	java/lang/Exception
    //   785	790	1038	java/lang/Exception
    //   870	874	1038	java/lang/Exception
    //   877	885	1038	java/lang/Exception
    //   890	947	1038	java/lang/Exception
    //   950	997	1038	java/lang/Exception
    //   997	1015	1038	java/lang/Exception
    //   1031	1036	1038	java/lang/Exception
    //   1036	1038	1038	java/lang/Exception
    //   785	790	1087	java/io/IOException
    //   870	874	1091	java/io/IOException
    //   1031	1036	1095	java/io/IOException
  }
  
  private void b(String paramString)
  {
    try
    {
      IX5WebViewExtension localIX5WebViewExtension = this.mRuntime.a().getX5WebViewExtension();
      if (localIX5WebViewExtension == null) {
        return;
      }
      paramString = new JSONObject(paramString).optString("serviceWorkerURL");
      paramString = paramString.substring(1, paramString.length() - 1).split(",");
      int i = 0;
      while (i < paramString.length)
      {
        Object localObject = paramString[i];
        localIX5WebViewExtension.updateServiceWorkerBackground(paramString[i]);
        i += 1;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private JSONObject c(String paramString)
  {
    Object localObject = this.mRuntime.a().getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mRuntime.a().getCurrentAccountUin());
    localStringBuilder.append(".qqsport");
    int i = ((MobileQQ)localObject).getSharedPreferences(localStringBuilder.toString(), 4).getInt("STEP_RED_PACK_STATUS", 0);
    localObject = new JSONObject();
    try
    {
      paramString = new JSONObject(paramString).getString("callback");
      ((JSONObject)localObject).put("status", i);
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
  
  private JSONObject d(String paramString)
  {
    Object localObject1 = this.mRuntime.a().getApplication();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.mRuntime.a().getCurrentAccountUin());
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
          i = 0;
          ((JSONObject)localObject1).put("status", i);
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
      int i = -1;
    }
  }
  
  /* Error */
  protected boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 144
    //   8: iconst_2
    //   9: ldc_w 876
    //   12: invokestatic 152	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_2
    //   16: ifnull +1195 -> 1211
    //   19: ldc 71
    //   21: aload_3
    //   22: invokevirtual 879	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   25: ifeq +1186 -> 1211
    //   28: aload 4
    //   30: ifnonnull +5 -> 35
    //   33: iconst_0
    //   34: ireturn
    //   35: aload 4
    //   37: ldc_w 881
    //   40: invokevirtual 879	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   43: istore 7
    //   45: iload 7
    //   47: ifeq +194 -> 241
    //   50: aload 5
    //   52: arraylength
    //   53: ifle +1168 -> 1221
    //   56: aload_0
    //   57: getfield 282	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   60: ldc_w 284
    //   63: invokevirtual 288	android/app/Activity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   66: checkcast 290	android/hardware/SensorManager
    //   69: astore_1
    //   70: getstatic 316	android/os/Build$VERSION:SDK_INT	I
    //   73: bipush 19
    //   75: if_icmplt +80 -> 155
    //   78: aload_1
    //   79: bipush 19
    //   81: invokevirtual 294	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   84: ifnonnull +6 -> 90
    //   87: goto +68 -> 155
    //   90: new 328	mqq/app/NewIntent
    //   93: dup
    //   94: aload_0
    //   95: getfield 108	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   98: invokevirtual 331	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   101: invokevirtual 337	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   104: ldc_w 339
    //   107: invokespecial 342	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   110: astore_1
    //   111: aload_1
    //   112: ldc_w 344
    //   115: ldc_w 346
    //   118: invokevirtual 350	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   121: pop
    //   122: aload_1
    //   123: ldc_w 352
    //   126: aload 5
    //   128: iconst_0
    //   129: aaload
    //   130: invokevirtual 350	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   133: pop
    //   134: aload_1
    //   135: aload_0
    //   136: getfield 69	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_MqqObserverBusinessObserver	Lmqq/observer/BusinessObserver;
    //   139: invokevirtual 356	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   142: aload_0
    //   143: getfield 108	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   146: invokevirtual 331	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   149: aload_1
    //   150: invokevirtual 360	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   153: iconst_1
    //   154: ireturn
    //   155: new 82	org/json/JSONObject
    //   158: dup
    //   159: aload 5
    //   161: iconst_0
    //   162: aaload
    //   163: invokespecial 86	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   166: ldc 88
    //   168: invokevirtual 92	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   171: astore_1
    //   172: aload_1
    //   173: invokestatic 308	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   176: ifeq +5 -> 181
    //   179: iconst_0
    //   180: ireturn
    //   181: new 82	org/json/JSONObject
    //   184: dup
    //   185: invokespecial 83	org/json/JSONObject:<init>	()V
    //   188: astore_2
    //   189: aload_2
    //   190: ldc_w 376
    //   193: sipush 255
    //   196: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   199: pop
    //   200: aload_2
    //   201: ldc_w 378
    //   204: iconst_0
    //   205: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   208: pop
    //   209: aload_2
    //   210: ldc_w 368
    //   213: ldc_w 882
    //   216: invokestatic 408	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   219: invokevirtual 248	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   222: pop
    //   223: aload_0
    //   224: aload_1
    //   225: iconst_1
    //   226: anewarray 250	java/lang/String
    //   229: dup
    //   230: iconst_0
    //   231: aload_2
    //   232: invokevirtual 251	org/json/JSONObject:toString	()Ljava/lang/String;
    //   235: aastore
    //   236: invokespecial 381	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   239: iconst_1
    //   240: ireturn
    //   241: aload 4
    //   243: ldc_w 884
    //   246: invokevirtual 879	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   249: ifeq +333 -> 582
    //   252: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   255: ifeq +38 -> 293
    //   258: new 121	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   265: astore_1
    //   266: aload_1
    //   267: ldc_w 886
    //   270: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload_1
    //   275: aload 5
    //   277: iconst_0
    //   278: aaload
    //   279: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: ldc 144
    //   285: iconst_2
    //   286: aload_1
    //   287: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 152	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: ldc_w 888
    //   296: invokestatic 534	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   299: checkcast 888	com/tencent/mobileqq/dpc/api/IDPCApi
    //   302: getstatic 894	com/tencent/mobileqq/dpc/enumname/DPCNames:health_ban	Lcom/tencent/mobileqq/dpc/enumname/DPCNames;
    //   305: invokevirtual 897	com/tencent/mobileqq/dpc/enumname/DPCNames:name	()Ljava/lang/String;
    //   308: ldc_w 264
    //   311: invokeinterface 900 3 0
    //   316: astore_1
    //   317: aload_1
    //   318: invokestatic 308	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   321: ifne +78 -> 399
    //   324: aload_1
    //   325: invokestatic 905	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   328: ifne +71 -> 399
    //   331: new 82	org/json/JSONObject
    //   334: dup
    //   335: invokespecial 83	org/json/JSONObject:<init>	()V
    //   338: astore_1
    //   339: new 82	org/json/JSONObject
    //   342: dup
    //   343: aload 5
    //   345: iconst_0
    //   346: aaload
    //   347: invokespecial 86	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   350: ldc 88
    //   352: invokevirtual 92	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   355: astore_2
    //   356: aload_1
    //   357: ldc_w 378
    //   360: sipush 202
    //   363: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   366: pop
    //   367: aload_1
    //   368: ldc_w 368
    //   371: ldc_w 906
    //   374: invokestatic 408	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   377: invokevirtual 248	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   380: pop
    //   381: aload_0
    //   382: aload_2
    //   383: iconst_1
    //   384: anewarray 250	java/lang/String
    //   387: dup
    //   388: iconst_0
    //   389: aload_1
    //   390: invokevirtual 251	org/json/JSONObject:toString	()Ljava/lang/String;
    //   393: aastore
    //   394: invokespecial 381	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   397: iconst_1
    //   398: ireturn
    //   399: new 82	org/json/JSONObject
    //   402: dup
    //   403: invokespecial 83	org/json/JSONObject:<init>	()V
    //   406: astore_1
    //   407: new 82	org/json/JSONObject
    //   410: dup
    //   411: aload 5
    //   413: iconst_0
    //   414: aaload
    //   415: invokespecial 86	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   418: astore_3
    //   419: aload_3
    //   420: ldc 88
    //   422: invokevirtual 92	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   425: astore_2
    //   426: aload_3
    //   427: ldc_w 908
    //   430: invokevirtual 424	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   433: istore 7
    //   435: aload_0
    //   436: getfield 282	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   439: ifnull +784 -> 1223
    //   442: new 328	mqq/app/NewIntent
    //   445: dup
    //   446: aload_0
    //   447: getfield 282	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   450: ldc_w 339
    //   453: invokespecial 342	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   456: astore_3
    //   457: aload_3
    //   458: ldc_w 344
    //   461: ldc_w 910
    //   464: invokevirtual 350	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   467: pop
    //   468: aload_3
    //   469: ldc_w 908
    //   472: iload 7
    //   474: invokevirtual 913	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   477: pop
    //   478: aload_0
    //   479: getfield 108	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   482: invokevirtual 331	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   485: aload_3
    //   486: invokevirtual 360	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   489: aload_1
    //   490: ldc_w 378
    //   493: iconst_0
    //   494: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   497: pop
    //   498: aload_1
    //   499: ldc_w 368
    //   502: ldc_w 914
    //   505: invokestatic 408	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   508: invokevirtual 248	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   511: pop
    //   512: aload_0
    //   513: aload_2
    //   514: iconst_1
    //   515: anewarray 250	java/lang/String
    //   518: dup
    //   519: iconst_0
    //   520: aload_1
    //   521: invokevirtual 251	org/json/JSONObject:toString	()Ljava/lang/String;
    //   524: aastore
    //   525: invokespecial 381	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   528: iconst_1
    //   529: istore 6
    //   531: goto +3 -> 534
    //   534: iload 6
    //   536: ifne +693 -> 1229
    //   539: aload_1
    //   540: ldc_w 378
    //   543: sipush 201
    //   546: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   549: pop
    //   550: aload_1
    //   551: ldc_w 368
    //   554: ldc_w 915
    //   557: invokestatic 408	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   560: invokevirtual 248	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   563: pop
    //   564: aload_0
    //   565: aload_2
    //   566: iconst_1
    //   567: anewarray 250	java/lang/String
    //   570: dup
    //   571: iconst_0
    //   572: aload_1
    //   573: invokevirtual 251	org/json/JSONObject:toString	()Ljava/lang/String;
    //   576: aastore
    //   577: invokespecial 381	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   580: iconst_1
    //   581: ireturn
    //   582: aload 4
    //   584: ldc_w 917
    //   587: invokevirtual 879	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   590: istore 7
    //   592: aconst_null
    //   593: astore_2
    //   594: iload 7
    //   596: ifeq +104 -> 700
    //   599: aload_0
    //   600: getfield 257	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   603: ifnonnull +45 -> 648
    //   606: aload_0
    //   607: getfield 108	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   610: invokevirtual 920	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/mobileqq/webview/swift/WebViewProvider;
    //   613: checkcast 922	com/tencent/mobileqq/webview/swift/WebViewFragment
    //   616: astore_1
    //   617: aload_1
    //   618: ifnull +613 -> 1231
    //   621: ldc_w 924
    //   624: invokestatic 534	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   627: checkcast 924	com/tencent/mobileqq/webprocess/temp/api/IWebviewApi
    //   630: aload_1
    //   631: invokeinterface 927 2 0
    //   636: checkcast 259	com/tencent/mobileqq/widget/QQProgressDialog
    //   639: astore_1
    //   640: goto +3 -> 643
    //   643: aload_0
    //   644: aload_1
    //   645: putfield 257	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   648: aload_0
    //   649: getfield 257	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   652: ifnull +28 -> 680
    //   655: aload_0
    //   656: getfield 257	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   659: ldc_w 928
    //   662: invokevirtual 931	com/tencent/mobileqq/widget/QQProgressDialog:c	(I)V
    //   665: aload_0
    //   666: getfield 257	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   669: iconst_0
    //   670: invokevirtual 934	com/tencent/mobileqq/widget/QQProgressDialog:setCancelable	(Z)V
    //   673: aload_0
    //   674: getfield 257	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   677: invokevirtual 937	com/tencent/mobileqq/widget/QQProgressDialog:show	()V
    //   680: new 939	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin$1
    //   683: dup
    //   684: aload_0
    //   685: aload 5
    //   687: iconst_0
    //   688: aaload
    //   689: invokespecial 942	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin$1:<init>	(Lcom/tencent/mobileqq/vashealth/HealthStepCounterPlugin;Ljava/lang/String;)V
    //   692: iconst_5
    //   693: aconst_null
    //   694: iconst_1
    //   695: invokestatic 947	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   698: iconst_1
    //   699: ireturn
    //   700: aload 4
    //   702: ldc_w 949
    //   705: invokevirtual 879	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   708: ifeq +106 -> 814
    //   711: aload 5
    //   713: iconst_0
    //   714: aaload
    //   715: astore_2
    //   716: aload_0
    //   717: getfield 257	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   720: ifnonnull +45 -> 765
    //   723: aload_0
    //   724: getfield 108	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   727: invokevirtual 920	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/mobileqq/webview/swift/WebViewProvider;
    //   730: checkcast 922	com/tencent/mobileqq/webview/swift/WebViewFragment
    //   733: astore_1
    //   734: aload_1
    //   735: ifnull +501 -> 1236
    //   738: ldc_w 924
    //   741: invokestatic 534	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   744: checkcast 924	com/tencent/mobileqq/webprocess/temp/api/IWebviewApi
    //   747: aload_1
    //   748: invokeinterface 927 2 0
    //   753: checkcast 259	com/tencent/mobileqq/widget/QQProgressDialog
    //   756: astore_1
    //   757: goto +3 -> 760
    //   760: aload_0
    //   761: aload_1
    //   762: putfield 257	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   765: aload_0
    //   766: getfield 257	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   769: ifnull +28 -> 797
    //   772: aload_0
    //   773: getfield 257	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   776: ldc_w 928
    //   779: invokevirtual 931	com/tencent/mobileqq/widget/QQProgressDialog:c	(I)V
    //   782: aload_0
    //   783: getfield 257	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   786: iconst_0
    //   787: invokevirtual 934	com/tencent/mobileqq/widget/QQProgressDialog:setCancelable	(Z)V
    //   790: aload_0
    //   791: getfield 257	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   794: invokevirtual 937	com/tencent/mobileqq/widget/QQProgressDialog:show	()V
    //   797: new 951	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin$2
    //   800: dup
    //   801: aload_0
    //   802: aload_2
    //   803: invokespecial 952	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin$2:<init>	(Lcom/tencent/mobileqq/vashealth/HealthStepCounterPlugin;Ljava/lang/String;)V
    //   806: iconst_5
    //   807: aconst_null
    //   808: iconst_1
    //   809: invokestatic 947	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   812: iconst_1
    //   813: ireturn
    //   814: aload 4
    //   816: ldc_w 954
    //   819: invokevirtual 879	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   822: ifeq +13 -> 835
    //   825: aload_0
    //   826: aload 5
    //   828: iconst_0
    //   829: aaload
    //   830: invokespecial 956	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:a	(Ljava/lang/String;)V
    //   833: iconst_0
    //   834: ireturn
    //   835: aload 4
    //   837: ldc_w 958
    //   840: invokevirtual 879	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   843: ifeq +94 -> 937
    //   846: new 82	org/json/JSONObject
    //   849: dup
    //   850: aload 5
    //   852: iconst_0
    //   853: aaload
    //   854: invokespecial 86	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   857: ldc 88
    //   859: invokevirtual 92	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   862: astore_1
    //   863: new 328	mqq/app/NewIntent
    //   866: dup
    //   867: aload_0
    //   868: getfield 108	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   871: invokevirtual 331	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   874: invokevirtual 337	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   877: ldc_w 339
    //   880: invokespecial 342	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   883: astore_2
    //   884: aload_2
    //   885: ldc_w 344
    //   888: ldc_w 346
    //   891: invokevirtual 350	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   894: pop
    //   895: aload_2
    //   896: ldc_w 352
    //   899: aload 5
    //   901: iconst_0
    //   902: aaload
    //   903: invokevirtual 350	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   906: pop
    //   907: aload_2
    //   908: ldc_w 960
    //   911: aload_1
    //   912: invokevirtual 350	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   915: pop
    //   916: aload_2
    //   917: aload_0
    //   918: getfield 69	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_MqqObserverBusinessObserver	Lmqq/observer/BusinessObserver;
    //   921: invokevirtual 356	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   924: aload_0
    //   925: getfield 108	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   928: invokevirtual 331	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   931: aload_2
    //   932: invokevirtual 360	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   935: iconst_0
    //   936: ireturn
    //   937: ldc_w 962
    //   940: aload 4
    //   942: invokevirtual 879	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   945: ifeq +165 -> 1110
    //   948: new 82	org/json/JSONObject
    //   951: dup
    //   952: invokespecial 83	org/json/JSONObject:<init>	()V
    //   955: astore_3
    //   956: aload_2
    //   957: astore_1
    //   958: aload_0
    //   959: getfield 108	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   962: invokevirtual 176	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   965: astore 4
    //   967: aload_2
    //   968: astore_1
    //   969: new 82	org/json/JSONObject
    //   972: dup
    //   973: aload 5
    //   975: iconst_0
    //   976: aaload
    //   977: invokespecial 86	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   980: ldc 88
    //   982: invokevirtual 92	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   985: astore_2
    //   986: aload_2
    //   987: astore_1
    //   988: new 652	android/content/Intent
    //   991: dup
    //   992: ldc_w 964
    //   995: invokespecial 655	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   998: astore 5
    //   1000: aload_2
    //   1001: astore_1
    //   1002: new 121	java/lang/StringBuilder
    //   1005: dup
    //   1006: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1009: astore 8
    //   1011: aload_2
    //   1012: astore_1
    //   1013: aload 8
    //   1015: ldc_w 966
    //   1018: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1021: pop
    //   1022: aload_2
    //   1023: astore_1
    //   1024: aload 8
    //   1026: aload 4
    //   1028: invokevirtual 969	android/app/Activity:getPackageName	()Ljava/lang/String;
    //   1031: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1034: pop
    //   1035: aload_2
    //   1036: astore_1
    //   1037: aload 5
    //   1039: aload 8
    //   1041: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1044: invokestatic 973	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   1047: invokevirtual 665	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   1050: pop
    //   1051: aload_2
    //   1052: astore_1
    //   1053: aload 4
    //   1055: aload 5
    //   1057: invokevirtual 976	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   1060: aload_2
    //   1061: astore_1
    //   1062: aload_3
    //   1063: ldc_w 978
    //   1066: iconst_0
    //   1067: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1070: pop
    //   1071: aload_2
    //   1072: astore_1
    //   1073: goto +12 -> 1085
    //   1076: aload_3
    //   1077: ldc_w 978
    //   1080: iconst_m1
    //   1081: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1084: pop
    //   1085: aload_1
    //   1086: invokestatic 308	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1089: ifne +122 -> 1211
    //   1092: aload_0
    //   1093: aload_1
    //   1094: iconst_1
    //   1095: anewarray 250	java/lang/String
    //   1098: dup
    //   1099: iconst_0
    //   1100: aload_3
    //   1101: invokevirtual 251	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1104: aastore
    //   1105: invokevirtual 255	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1108: iconst_0
    //   1109: ireturn
    //   1110: aload 4
    //   1112: ldc_w 980
    //   1115: invokevirtual 879	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1118: ifeq +14 -> 1132
    //   1121: aload_0
    //   1122: aload 5
    //   1124: iconst_0
    //   1125: aaload
    //   1126: invokespecial 982	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:c	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1129: pop
    //   1130: iconst_1
    //   1131: ireturn
    //   1132: aload 4
    //   1134: ldc_w 984
    //   1137: invokevirtual 879	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1140: ifeq +14 -> 1154
    //   1143: aload_0
    //   1144: aload 5
    //   1146: iconst_0
    //   1147: aaload
    //   1148: invokespecial 986	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:d	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1151: pop
    //   1152: iconst_1
    //   1153: ireturn
    //   1154: aload 4
    //   1156: ldc_w 987
    //   1159: invokevirtual 879	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1162: ifeq +49 -> 1211
    //   1165: aload_0
    //   1166: aload 5
    //   1168: iconst_0
    //   1169: aaload
    //   1170: invokespecial 989	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:b	(Ljava/lang/String;)V
    //   1173: iconst_0
    //   1174: ireturn
    //   1175: astore_1
    //   1176: new 121	java/lang/StringBuilder
    //   1179: dup
    //   1180: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1183: astore_2
    //   1184: aload_2
    //   1185: ldc_w 991
    //   1188: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1191: pop
    //   1192: aload_2
    //   1193: aload_1
    //   1194: invokevirtual 267	java/lang/Exception:toString	()Ljava/lang/String;
    //   1197: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1200: pop
    //   1201: ldc 144
    //   1203: iconst_2
    //   1204: aload_2
    //   1205: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1208: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   529	696	6	i	int
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
    this.jdField_a_of_type_AndroidAppActivity = this.mRuntime.a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (jdField_a_of_type_ComTencentMobileqqVashealthHealthStepCounterPlugin$StepShakeListener != null)
    {
      ((SensorManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("sensor")).unregisterListener(jdField_a_of_type_ComTencentMobileqqVashealthHealthStepCounterPlugin$StepShakeListener);
      jdField_a_of_type_ComTencentMobileqqVashealthHealthStepCounterPlugin$StepShakeListener = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthStepCounterPlugin
 * JD-Core Version:    0.7.0.1
 */