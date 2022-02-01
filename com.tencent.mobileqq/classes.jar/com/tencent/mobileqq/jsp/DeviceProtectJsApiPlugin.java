package com.tencent.mobileqq.jsp;

import android.text.TextUtils;
import com.tencent.mobileqq.login.api.authdev.IAuthDevUgHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceProtectJsApiPlugin
  extends WebViewPlugin
{
  private String a;
  
  public DeviceProtectJsApiPlugin()
  {
    this.mPluginNameSpace = "deviceProtect";
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: invokestatic 26	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   3: invokevirtual 30	com/tencent/mobileqq/qipc/QIPCClientHelper:getClient	()Leipc/EIPCClient;
    //   6: ldc 32
    //   8: ldc 34
    //   10: aconst_null
    //   11: invokevirtual 40	eipc/EIPCClient:callServer	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Leipc/EIPCResult;
    //   14: astore 10
    //   16: aload 10
    //   18: getfield 46	eipc/EIPCResult:code	I
    //   21: istore_1
    //   22: iload_1
    //   23: ifeq +51 -> 74
    //   26: ldc 48
    //   28: iconst_1
    //   29: ldc 50
    //   31: invokestatic 56	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: new 58	org/json/JSONObject
    //   37: dup
    //   38: invokespecial 59	org/json/JSONObject:<init>	()V
    //   41: astore_2
    //   42: aload_2
    //   43: ldc 61
    //   45: iconst_m1
    //   46: invokevirtual 65	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   49: pop
    //   50: aload_0
    //   51: aload_0
    //   52: getfield 67	com/tencent/mobileqq/jsp/DeviceProtectJsApiPlugin:a	Ljava/lang/String;
    //   55: iconst_1
    //   56: anewarray 69	java/lang/String
    //   59: dup
    //   60: iconst_0
    //   61: aload_2
    //   62: invokevirtual 73	org/json/JSONObject:toString	()Ljava/lang/String;
    //   65: aastore
    //   66: invokevirtual 77	com/tencent/mobileqq/jsp/DeviceProtectJsApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   69: return
    //   70: astore_2
    //   71: goto +428 -> 499
    //   74: new 58	org/json/JSONObject
    //   77: dup
    //   78: invokespecial 59	org/json/JSONObject:<init>	()V
    //   81: astore 9
    //   83: new 58	org/json/JSONObject
    //   86: dup
    //   87: invokespecial 59	org/json/JSONObject:<init>	()V
    //   90: astore_2
    //   91: aload 10
    //   93: getfield 81	eipc/EIPCResult:data	Landroid/os/Bundle;
    //   96: ldc 83
    //   98: ldc 85
    //   100: invokevirtual 91	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   103: astore_3
    //   104: aload 10
    //   106: getfield 81	eipc/EIPCResult:data	Landroid/os/Bundle;
    //   109: ldc 93
    //   111: ldc 85
    //   113: invokevirtual 91	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   116: astore 4
    //   118: aload 10
    //   120: getfield 81	eipc/EIPCResult:data	Landroid/os/Bundle;
    //   123: ldc 95
    //   125: ldc 85
    //   127: invokevirtual 91	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   130: astore 5
    //   132: aload 10
    //   134: getfield 81	eipc/EIPCResult:data	Landroid/os/Bundle;
    //   137: ldc 97
    //   139: ldc 85
    //   141: invokevirtual 91	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   144: astore 6
    //   146: aload 10
    //   148: getfield 81	eipc/EIPCResult:data	Landroid/os/Bundle;
    //   151: ldc 99
    //   153: ldc 85
    //   155: invokevirtual 91	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   158: astore 7
    //   160: aload 10
    //   162: getfield 81	eipc/EIPCResult:data	Landroid/os/Bundle;
    //   165: ldc 101
    //   167: ldc 85
    //   169: invokevirtual 91	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   172: astore 8
    //   174: aload 10
    //   176: getfield 81	eipc/EIPCResult:data	Landroid/os/Bundle;
    //   179: ldc 103
    //   181: ldc 85
    //   183: invokevirtual 91	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   186: astore 10
    //   188: aload_2
    //   189: ldc 83
    //   191: aload_3
    //   192: invokevirtual 106	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   195: pop
    //   196: aload_2
    //   197: ldc 93
    //   199: aload 4
    //   201: invokevirtual 106	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   204: pop
    //   205: aload_2
    //   206: ldc 95
    //   208: aload 5
    //   210: invokevirtual 106	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   213: pop
    //   214: aload_2
    //   215: ldc 97
    //   217: aload 6
    //   219: invokevirtual 106	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   222: pop
    //   223: aload_2
    //   224: ldc 99
    //   226: aload 7
    //   228: invokevirtual 106	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   231: pop
    //   232: aload_2
    //   233: ldc 101
    //   235: aload 8
    //   237: invokevirtual 106	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   240: pop
    //   241: aload_2
    //   242: ldc 103
    //   244: aload 10
    //   246: invokevirtual 106	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   249: pop
    //   250: new 108	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   257: astore 11
    //   259: aload 11
    //   261: aload 7
    //   263: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload 11
    //   269: ldc 115
    //   271: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: aload 11
    //   277: aload 8
    //   279: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload_2
    //   284: ldc 117
    //   286: aload 11
    //   288: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokevirtual 106	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   294: pop
    //   295: aload 9
    //   297: ldc 61
    //   299: iconst_0
    //   300: invokevirtual 65	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   303: pop
    //   304: aload 9
    //   306: ldc 120
    //   308: aload_2
    //   309: invokevirtual 106	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   312: pop
    //   313: aload_0
    //   314: astore_2
    //   315: aload_2
    //   316: aload_2
    //   317: getfield 67	com/tencent/mobileqq/jsp/DeviceProtectJsApiPlugin:a	Ljava/lang/String;
    //   320: iconst_1
    //   321: anewarray 69	java/lang/String
    //   324: dup
    //   325: iconst_0
    //   326: aload 9
    //   328: invokevirtual 73	org/json/JSONObject:toString	()Ljava/lang/String;
    //   331: aastore
    //   332: invokevirtual 77	com/tencent/mobileqq/jsp/DeviceProtectJsApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   335: new 108	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   342: astore_2
    //   343: aload_2
    //   344: ldc 122
    //   346: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload_2
    //   351: aload_3
    //   352: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload_2
    //   357: ldc 124
    //   359: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: pop
    //   363: aload_2
    //   364: aload 4
    //   366: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload_2
    //   371: ldc 126
    //   373: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: aload_2
    //   378: aload 5
    //   380: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: aload_2
    //   385: ldc 128
    //   387: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: aload_2
    //   392: aload 6
    //   394: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload_2
    //   399: ldc 130
    //   401: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: pop
    //   405: aload_2
    //   406: aload 7
    //   408: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: pop
    //   412: aload_2
    //   413: ldc 132
    //   415: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload_2
    //   420: aload 8
    //   422: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: aload_2
    //   427: ldc 134
    //   429: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: aload_2
    //   434: aload 10
    //   436: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: pop
    //   440: new 108	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   447: astore_3
    //   448: aload_3
    //   449: ldc 136
    //   451: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: pop
    //   455: aload_3
    //   456: aload_2
    //   457: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   460: pop
    //   461: aload_3
    //   462: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: astore_2
    //   466: ldc 48
    //   468: iconst_1
    //   469: aload_2
    //   470: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   473: return
    //   474: astore_2
    //   475: goto +24 -> 499
    //   478: astore_2
    //   479: goto +16 -> 495
    //   482: astore_2
    //   483: goto +12 -> 495
    //   486: astore_2
    //   487: goto +12 -> 499
    //   490: astore_2
    //   491: goto +4 -> 495
    //   494: astore_2
    //   495: goto +4 -> 499
    //   498: astore_2
    //   499: aload_0
    //   500: astore_3
    //   501: new 58	org/json/JSONObject
    //   504: dup
    //   505: invokespecial 59	org/json/JSONObject:<init>	()V
    //   508: astore 4
    //   510: aload 4
    //   512: ldc 61
    //   514: iconst_m1
    //   515: invokevirtual 65	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   518: pop
    //   519: aload_3
    //   520: aload_3
    //   521: getfield 67	com/tencent/mobileqq/jsp/DeviceProtectJsApiPlugin:a	Ljava/lang/String;
    //   524: iconst_1
    //   525: anewarray 69	java/lang/String
    //   528: dup
    //   529: iconst_0
    //   530: aload 4
    //   532: invokevirtual 73	org/json/JSONObject:toString	()Ljava/lang/String;
    //   535: aastore
    //   536: invokevirtual 77	com/tencent/mobileqq/jsp/DeviceProtectJsApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   539: goto +13 -> 552
    //   542: astore_3
    //   543: ldc 48
    //   545: iconst_1
    //   546: ldc 144
    //   548: aload_3
    //   549: invokestatic 147	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   552: ldc 48
    //   554: iconst_1
    //   555: ldc 149
    //   557: aload_2
    //   558: invokestatic 147	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   561: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	562	0	this	DeviceProtectJsApiPlugin
    //   21	2	1	i	int
    //   41	21	2	localJSONObject1	JSONObject
    //   70	1	2	localException1	java.lang.Exception
    //   90	380	2	localObject1	Object
    //   474	1	2	localException2	java.lang.Exception
    //   478	1	2	localException3	java.lang.Exception
    //   482	1	2	localException4	java.lang.Exception
    //   486	1	2	localException5	java.lang.Exception
    //   490	1	2	localException6	java.lang.Exception
    //   494	1	2	localException7	java.lang.Exception
    //   498	60	2	localException8	java.lang.Exception
    //   103	418	3	localObject2	Object
    //   542	7	3	localJSONException	JSONException
    //   116	415	4	localObject3	Object
    //   130	249	5	str1	String
    //   144	249	6	str2	String
    //   158	249	7	str3	String
    //   172	249	8	str4	String
    //   81	246	9	localJSONObject2	JSONObject
    //   14	421	10	localObject4	Object
    //   257	30	11	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   26	69	70	java/lang/Exception
    //   466	473	474	java/lang/Exception
    //   315	466	478	java/lang/Exception
    //   295	313	482	java/lang/Exception
    //   146	295	486	java/lang/Exception
    //   132	146	490	java/lang/Exception
    //   118	132	494	java/lang/Exception
    //   0	22	498	java/lang/Exception
    //   74	118	498	java/lang/Exception
    //   501	539	542	org/json/JSONException
  }
  
  private void a(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length >= 1))
    {
      if ((this.mRuntime != null) && (this.mRuntime.d() != null)) {
        try
        {
          Object localObject = new JSONObject(paramVarArgs[0]);
          paramVarArgs = ((JSONObject)localObject).getString("phoneNo");
          localObject = ((JSONObject)localObject).optString("countryCode");
          if (TextUtils.isEmpty(paramVarArgs))
          {
            QLog.d("DeviceProtectJsApiPlugin", 1, "handlePhoneChanged: phone is empty");
            return;
          }
          ((IAuthDevUgHelper)QRoute.api(IAuthDevUgHelper.class)).notifyPhoneChanged(this.mRuntime.d(), paramVarArgs, (String)localObject);
          return;
        }
        catch (JSONException paramVarArgs)
        {
          QLog.e("DeviceProtectJsApiPlugin", 1, "handlePhoneChanged: json exception.", paramVarArgs);
          return;
        }
      }
      QLog.d("DeviceProtectJsApiPlugin", 1, "handlePhoneChanged: activity is null.");
      return;
    }
    QLog.d("DeviceProtectJsApiPlugin", 1, "handlePhoneChanged: no args, return.");
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("DeviceProtectJsApiPlugin", 1, "Call getDeviceInfo error, url is empty");
      return false;
    }
    paramJsBridgeListener = new StringBuilder();
    paramJsBridgeListener.append("Call DeviceProtectJsApiPlugin handleJsRequest, url");
    paramJsBridgeListener.append(paramString1);
    paramJsBridgeListener.append(" pkgName:");
    paramJsBridgeListener.append(paramString2);
    QLog.d("DeviceProtectJsApiPlugin", 1, paramJsBridgeListener.toString());
    if ("deviceProtect".equals(paramString2))
    {
      if ("getDeviceInfo".equals(paramString3))
      {
        paramJsBridgeListener = new StringBuilder();
        paramJsBridgeListener.append("Call getDeviceInfo, args:");
        paramJsBridgeListener.append(paramVarArgs);
        QLog.d("DeviceProtectJsApiPlugin", 1, paramJsBridgeListener.toString());
        paramJsBridgeListener = paramString1.split("#");
        if ((paramJsBridgeListener != null) && (paramJsBridgeListener.length == 2))
        {
          this.a = paramJsBridgeListener[1];
          a();
          return true;
        }
        QLog.e("DeviceProtectJsApiPlugin", 1, "Call getDeviceInfo error, jsapi does not contain callback");
        return false;
      }
      if ("changePhoneNo".equals(paramString3))
      {
        QLog.d("DeviceProtectJsApiPlugin", 1, "handleJsRequest: changePhoneNo");
        a(paramVarArgs);
        return true;
      }
    }
    return false;
  }
  
  protected void onCreate()
  {
    super.onCreate();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.DeviceProtectJsApiPlugin
 * JD-Core Version:    0.7.0.1
 */