package com.tencent.mobileqq.vaswebviewplugin;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class VasWebviewJsPluginV2
  extends VasWebviewJsPlugin
{
  private static final String TAG = "VasWebviewJsPluginV2";
  protected static final int THREADMODE_DEFAULT = 0;
  protected static final int THREADMODE_FILE = 2;
  protected static final int THREADMODE_UI = 1;
  private Map<String, VasWebviewJsPluginV2.SubscriberMethod> mMethodCache = null;
  
  public VasWebviewJsPluginV2(String paramString)
  {
    this.mPluginNameSpace = paramString;
  }
  
  private List<VasWebviewJsPluginV2.SubscriberMethod> findJSBMethod(Class<?> paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    paramClass = paramClass.getDeclaredMethods();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramClass[i];
      if (QLog.isColorLevel())
      {
        QLog.e("VasWebviewJsPluginV2", 1, "method : " + ((Method)localObject).toString());
        QLog.e("VasWebviewJsPluginV2", 1, "annotations : " + Arrays.toString(((Method)localObject).getAnnotations()));
      }
      VasWebviewJsPluginV2.JsbridgeSubscribe localJsbridgeSubscribe = (VasWebviewJsPluginV2.JsbridgeSubscribe)((Method)localObject).getAnnotation(VasWebviewJsPluginV2.JsbridgeSubscribe.class);
      if ((localJsbridgeSubscribe != null) && (!TextUtils.isEmpty(localJsbridgeSubscribe.method())))
      {
        localObject = new VasWebviewJsPluginV2.SubscriberMethod((Method)localObject, localJsbridgeSubscribe.method(), localJsbridgeSubscribe.threadMode(), localJsbridgeSubscribe.args());
        if (QLog.isColorLevel()) {
          QLog.e("VasWebviewJsPluginV2", 1, "register : " + ((VasWebviewJsPluginV2.SubscriberMethod)localObject).toString());
        }
        localArrayList.add(localObject);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  /* Error */
  public final boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +47 -> 50
    //   6: ldc 8
    //   8: iconst_2
    //   9: new 48	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   16: ldc 121
    //   18: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_2
    //   22: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc 123
    //   27: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_3
    //   31: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc 125
    //   36: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload 4
    //   41: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload_2
    //   51: ifnull +19 -> 70
    //   54: aload_0
    //   55: getfield 28	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPluginV2:mPluginNameSpace	Ljava/lang/String;
    //   58: aload_3
    //   59: invokevirtual 133	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   62: ifeq +8 -> 70
    //   65: aload 4
    //   67: ifnonnull +5 -> 72
    //   70: iconst_0
    //   71: ireturn
    //   72: aload_2
    //   73: invokestatic 139	com/tencent/mobileqq/webview/swift/WebViewPlugin:getJsonFromJSBridge	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   76: astore_3
    //   77: aload_3
    //   78: ifnonnull +348 -> 426
    //   81: aload_2
    //   82: ldc 141
    //   84: invokevirtual 145	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   87: istore 6
    //   89: iload 6
    //   91: iconst_m1
    //   92: if_icmpeq +16 -> 108
    //   95: iload 6
    //   97: iconst_1
    //   98: iadd
    //   99: aload_2
    //   100: invokevirtual 148	java/lang/String:length	()I
    //   103: iconst_1
    //   104: isub
    //   105: if_icmple +5 -> 110
    //   108: iconst_1
    //   109: ireturn
    //   110: aload_2
    //   111: iload 6
    //   113: iconst_1
    //   114: iadd
    //   115: invokevirtual 152	java/lang/String:substring	(I)Ljava/lang/String;
    //   118: ldc 154
    //   120: invokestatic 160	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   123: astore 7
    //   125: new 162	org/json/JSONObject
    //   128: dup
    //   129: invokespecial 163	org/json/JSONObject:<init>	()V
    //   132: astore_3
    //   133: aload_3
    //   134: ldc 165
    //   136: aload 7
    //   138: invokevirtual 169	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   141: pop
    //   142: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   145: ifeq +31 -> 176
    //   148: ldc 8
    //   150: iconst_2
    //   151: new 48	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   158: ldc 171
    //   160: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_3
    //   164: invokevirtual 172	org/json/JSONObject:toString	()Ljava/lang/String;
    //   167: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: aload_3
    //   177: ldc 165
    //   179: invokevirtual 176	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   182: astore 7
    //   184: aload_0
    //   185: getfield 25	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPluginV2:mMethodCache	Ljava/util/Map;
    //   188: ifnonnull +129 -> 317
    //   191: aload_0
    //   192: aload_0
    //   193: invokevirtual 182	java/lang/Object:getClass	()Ljava/lang/Class;
    //   196: invokespecial 184	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPluginV2:findJSBMethod	(Ljava/lang/Class;)Ljava/util/List;
    //   199: astore 8
    //   201: aload_0
    //   202: monitorenter
    //   203: aload_0
    //   204: getfield 25	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPluginV2:mMethodCache	Ljava/util/Map;
    //   207: ifnonnull +108 -> 315
    //   210: aload_0
    //   211: new 186	java/util/HashMap
    //   214: dup
    //   215: aload 8
    //   217: invokeinterface 189 1 0
    //   222: iconst_2
    //   223: imul
    //   224: invokespecial 192	java/util/HashMap:<init>	(I)V
    //   227: putfield 25	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPluginV2:mMethodCache	Ljava/util/Map;
    //   230: aload 8
    //   232: invokeinterface 196 1 0
    //   237: astore 8
    //   239: aload 8
    //   241: invokeinterface 201 1 0
    //   246: ifeq +69 -> 315
    //   249: aload 8
    //   251: invokeinterface 205 1 0
    //   256: checkcast 94	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPluginV2$SubscriberMethod
    //   259: astore 9
    //   261: aload_0
    //   262: getfield 25	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPluginV2:mMethodCache	Ljava/util/Map;
    //   265: aload 9
    //   267: getfield 208	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPluginV2$SubscriberMethod:scheme	Ljava/lang/String;
    //   270: aload 9
    //   272: invokeinterface 213 3 0
    //   277: pop
    //   278: goto -39 -> 239
    //   281: astore_1
    //   282: aload_0
    //   283: monitorexit
    //   284: aload_1
    //   285: athrow
    //   286: astore_1
    //   287: ldc 215
    //   289: iconst_1
    //   290: new 48	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   297: ldc 217
    //   299: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: aload_2
    //   303: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: aload_1
    //   310: invokestatic 220	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   313: iconst_1
    //   314: ireturn
    //   315: aload_0
    //   316: monitorexit
    //   317: aload_0
    //   318: getfield 25	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPluginV2:mMethodCache	Ljava/util/Map;
    //   321: aload 4
    //   323: invokeinterface 224 2 0
    //   328: checkcast 94	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPluginV2$SubscriberMethod
    //   331: astore 4
    //   333: aload 4
    //   335: ifnull +80 -> 415
    //   338: aload 4
    //   340: aload_0
    //   341: new 226	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPluginV2$JsData
    //   344: dup
    //   345: aload 7
    //   347: aload_1
    //   348: aload_2
    //   349: aload 5
    //   351: invokespecial 229	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPluginV2$JsData:<init>	(Ljava/lang/String;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;[Ljava/lang/String;)V
    //   354: aload_3
    //   355: invokevirtual 233	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPluginV2$SubscriberMethod:buildSafeRunnable	(Lcom/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPluginV2;Lcom/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPluginV2$JsData;Lorg/json/JSONObject;)Ljava/lang/Runnable;
    //   358: astore_1
    //   359: aload 4
    //   361: getfield 235	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPluginV2$SubscriberMethod:threadMode	I
    //   364: ifne +11 -> 375
    //   367: aload_1
    //   368: invokeinterface 240 1 0
    //   373: iconst_1
    //   374: ireturn
    //   375: aload 4
    //   377: getfield 235	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPluginV2$SubscriberMethod:threadMode	I
    //   380: iconst_1
    //   381: if_icmpne +14 -> 395
    //   384: invokestatic 246	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   387: aload_1
    //   388: invokevirtual 252	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   391: pop
    //   392: goto -19 -> 373
    //   395: aload 4
    //   397: getfield 235	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPluginV2$SubscriberMethod:threadMode	I
    //   400: iconst_2
    //   401: if_icmpne -28 -> 373
    //   404: invokestatic 255	com/tencent/mobileqq/app/ThreadManager:getFileThreadHandler	()Lmqq/os/MqqHandler;
    //   407: aload_1
    //   408: invokevirtual 252	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   411: pop
    //   412: goto -39 -> 373
    //   415: ldc 8
    //   417: iconst_1
    //   418: ldc_w 257
    //   421: invokestatic 66	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   424: iconst_0
    //   425: ireturn
    //   426: goto -284 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	429	0	this	VasWebviewJsPluginV2
    //   0	429	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	429	2	paramString1	String
    //   0	429	3	paramString2	String
    //   0	429	4	paramString3	String
    //   0	429	5	paramVarArgs	String[]
    //   87	28	6	i	int
    //   123	223	7	str	String
    //   199	51	8	localObject	Object
    //   259	12	9	localSubscriberMethod	VasWebviewJsPluginV2.SubscriberMethod
    // Exception table:
    //   from	to	target	type
    //   203	239	281	finally
    //   239	278	281	finally
    //   282	284	281	finally
    //   315	317	281	finally
    //   110	142	286	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPluginV2
 * JD-Core Version:    0.7.0.1
 */