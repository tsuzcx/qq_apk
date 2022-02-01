package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.jsp.WebSSOAgentServlet;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONObject;

public class FunnyPicJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BUSINESS_NAME = "qutu";
  public static final String TAG = "FunnyPicJsPlugin";
  public Bundle mReqBundle;
  
  public FunnyPicJsPlugin()
  {
    this.mPluginNameSpace = "qutu";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("handleJsRequest, url=");
      paramJsBridgeListener.append(paramString1);
      paramJsBridgeListener.append(", pkgName=");
      paramJsBridgeListener.append(paramString2);
      paramJsBridgeListener.append(", methodName=");
      paramJsBridgeListener.append(paramString3);
      QLog.d("FunnyPicJsPlugin", 2, paramJsBridgeListener.toString());
    }
    if ((paramString1 != null) && ("qutu".equals(paramString2)))
    {
      if (paramString3 == null) {
        return false;
      }
      try
      {
        paramJsBridgeListener = WebViewPlugin.getJsonFromJSBridge(paramString1);
        if (paramJsBridgeListener == null) {
          return true;
        }
        boolean bool = QLog.isColorLevel();
        if (bool) {
          try
          {
            paramString1 = new StringBuilder();
            paramString1.append("handleJsRequest JSON = ");
            paramString1.append(paramJsBridgeListener.toString());
            QLog.d("FunnyPicJsPlugin", 2, paramString1.toString());
          }
          catch (Throwable paramJsBridgeListener)
          {
            paramString1 = null;
          }
        }
        for (;;)
        {
          break;
          paramString1 = paramJsBridgeListener.optString("callback");
          try
          {
            if (TextUtils.isEmpty(paramString1))
            {
              QLog.e("FunnyPicJsPlugin", 1, "callback id is null, so return");
              return true;
            }
            if ("getCurrentPkgInfo".equals(paramString3))
            {
              this.mReqBundle.clear();
              this.mReqBundle.putString("jsonContent", paramJsBridgeListener.toString());
              super.sendRemoteReq(DataFactory.a("ipc_funnypic_query_info", paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
              return true;
            }
            if ("addQutu".equals(paramString3))
            {
              paramString2 = this.mRuntime.a();
              if ((paramString2 != null) && (!NetworkUtil.isNetworkAvailable(paramString2)))
              {
                paramJsBridgeListener = new JSONObject();
                paramJsBridgeListener.put("result", 1);
                paramString2 = new StringBuilder();
                paramString2.append(paramString1);
                paramString2.append("(");
                paramString2.append(paramJsBridgeListener.toString());
                paramString2.append(");");
                super.callJs(paramString2.toString());
                return true;
              }
              if (!"mounted".equals(Environment.getExternalStorageState()))
              {
                QQToast.a(MobileQQ.getContext(), HardCodeUtil.a(2131705093), 0).a();
                paramJsBridgeListener = new JSONObject();
                paramJsBridgeListener.put("result", 1);
                paramString2 = new StringBuilder();
                paramString2.append(paramString1);
                paramString2.append("(");
                paramString2.append(paramJsBridgeListener.toString());
                paramString2.append(");");
                super.callJs(paramString2.toString());
                return true;
              }
              int j = paramJsBridgeListener.getInt("action");
              paramString2 = paramJsBridgeListener.getJSONArray("uids");
              int k = paramString2.length();
              int i = -1;
              if (k > 0) {
                i = ((JSONObject)paramString2.get(0)).getInt("pkgid");
              }
              paramString3 = new WebSSOAgent.UniSsoServerReqComm();
              paramString2 = paramString3.platform;
              try
              {
                paramString2.set(109L);
                paramString3.osver.set(Build.VERSION.RELEASE);
                paramString3.mqqver.set("8.7.0");
                paramString2 = new WebSSOAgent.UniSsoServerReq();
                paramString2.comm.set(paramString3);
                JSONObject localJSONObject = new JSONObject();
                localJSONObject.put("appid", "10");
                paramString3 = String.valueOf(i);
                localJSONObject.put("itemid", paramString3);
                paramVarArgs = new JSONArray();
                paramVarArgs.put(localJSONObject);
                localJSONObject = new JSONObject();
                localJSONObject.put("itemlist", paramVarArgs);
                localJSONObject.put("authType", "1");
                paramString2.reqdata.set(localJSONObject.toString());
                paramJsBridgeListener = new FunnyPicJsPlugin.1(this, paramString3, paramJsBridgeListener, j, paramString1);
                paramString3 = this.mRuntime.a();
                if (paramString3 != null)
                {
                  paramVarArgs = new NewIntent(this.mRuntime.a().getApp(), WebSSOAgentServlet.class);
                  paramVarArgs.putExtra("extra_cmd", "AuthProxy.check");
                  paramVarArgs.putExtra("extra_data", paramString2.toByteArray());
                  paramVarArgs.setObserver(paramJsBridgeListener);
                  paramString3.startServlet(paramVarArgs);
                  return true;
                }
              }
              catch (Throwable paramJsBridgeListener) {}
            }
          }
          catch (Throwable paramJsBridgeListener) {}
        }
        try
        {
          paramString2 = new JSONObject();
          paramString2.put("result", 1);
          paramString2.put("message", paramJsBridgeListener.getMessage());
          paramString3 = new StringBuilder();
          paramString3.append(paramString1);
          paramString3.append("(");
          paramString3.append(paramString2.toString());
          paramString3.append(");");
          super.callJs(paramString3.toString());
          return true;
        }
        catch (Exception paramString1)
        {
          break label815;
        }
      }
      catch (Throwable paramJsBridgeListener)
      {
        paramString1 = null;
        if (QLog.isColorLevel()) {
          QLog.e("FunnyPicJsPlugin", 2, paramJsBridgeListener.getMessage());
        }
      }
      label815:
      if (QLog.isColorLevel()) {
        QLog.e("FunnyPicJsPlugin", 2, paramJsBridgeListener.getMessage());
      }
      return true;
    }
    else
    {
      return false;
    }
  }
  
  protected void onCreate()
  {
    this.mRuntime.a();
    this.mReqBundle = new Bundle();
    super.onCreate();
  }
  
  /* Error */
  public void onResponse(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +582 -> 583
    //   4: aload_1
    //   5: ldc_w 339
    //   8: iconst_0
    //   9: invokevirtual 342	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   12: aload_0
    //   13: getfield 122	com/tencent/mobileqq/vaswebviewplugin/FunnyPicJsPlugin:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/OnRemoteRespObserver;
    //   16: getfield 128	com/tencent/mobileqq/emosm/OnRemoteRespObserver:key	I
    //   19: if_icmpne +564 -> 583
    //   22: aload_1
    //   23: ldc_w 344
    //   26: invokevirtual 347	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   29: astore 6
    //   31: aload_1
    //   32: ldc_w 349
    //   35: invokevirtual 347	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   38: astore 5
    //   40: aload 6
    //   42: ifnull +541 -> 583
    //   45: ldc_w 351
    //   48: aload 6
    //   50: invokevirtual 73	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   53: ifeq +357 -> 410
    //   56: aload_1
    //   57: ldc 154
    //   59: iconst_0
    //   60: invokevirtual 342	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   63: istore_2
    //   64: new 83	org/json/JSONObject
    //   67: dup
    //   68: invokespecial 152	org/json/JSONObject:<init>	()V
    //   71: astore 6
    //   73: aload 6
    //   75: ldc 154
    //   77: iload_2
    //   78: invokevirtual 158	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   81: pop
    //   82: aload_1
    //   83: ldc_w 353
    //   86: invokevirtual 347	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   89: astore 7
    //   91: aload 7
    //   93: ifnull +491 -> 584
    //   96: aload 6
    //   98: ldc_w 353
    //   101: new 83	org/json/JSONObject
    //   104: dup
    //   105: aload 7
    //   107: invokespecial 355	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   110: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   113: pop
    //   114: goto +3 -> 117
    //   117: iload_2
    //   118: ifeq +28 -> 146
    //   121: aload_1
    //   122: ldc_w 331
    //   125: invokevirtual 347	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   128: astore 7
    //   130: aload 7
    //   132: ifnull +14 -> 146
    //   135: aload 6
    //   137: ldc_w 331
    //   140: aload 7
    //   142: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   145: pop
    //   146: aload_1
    //   147: ldc_w 357
    //   150: iconst_0
    //   151: invokevirtual 361	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   154: istore 4
    //   156: aload_0
    //   157: getfield 140	com/tencent/mobileqq/vaswebviewplugin/FunnyPicJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   160: invokevirtual 145	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   163: astore 10
    //   165: iload 4
    //   167: ifeq +420 -> 587
    //   170: aload 10
    //   172: ifnull +415 -> 587
    //   175: aload_0
    //   176: getfield 365	com/tencent/mobileqq/vaswebviewplugin/FunnyPicJsPlugin:isDestroy	Z
    //   179: ifne +408 -> 587
    //   182: aload 10
    //   184: invokevirtual 370	android/app/Activity:isFinishing	()Z
    //   187: ifne +400 -> 587
    //   190: aload_1
    //   191: ldc_w 372
    //   194: invokevirtual 376	android/os/Bundle:getStringArrayList	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   197: astore 7
    //   199: aload_1
    //   200: ldc_w 378
    //   203: invokevirtual 376	android/os/Bundle:getStringArrayList	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   206: astore 8
    //   208: aload_1
    //   209: ldc_w 380
    //   212: invokevirtual 376	android/os/Bundle:getStringArrayList	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   215: astore 9
    //   217: aload_1
    //   218: ldc_w 382
    //   221: invokevirtual 383	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   224: istore_2
    //   225: aload_1
    //   226: ldc_w 385
    //   229: invokevirtual 383	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   232: istore_3
    //   233: new 387	com/tencent/mobileqq/qroute/route/ActivityURIRequest
    //   236: dup
    //   237: aload 10
    //   239: ldc_w 389
    //   242: invokespecial 392	com/tencent/mobileqq/qroute/route/ActivityURIRequest:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   245: astore_1
    //   246: aload_1
    //   247: ldc_w 393
    //   250: invokevirtual 397	com/tencent/mobileqq/qroute/route/ActivityURIRequest:setFlags	(I)Lcom/tencent/mobileqq/qroute/route/ActivityURIRequest;
    //   253: pop
    //   254: aload_1
    //   255: invokevirtual 401	com/tencent/mobileqq/qroute/route/ActivityURIRequest:extra	()Landroid/os/Bundle;
    //   258: ldc_w 403
    //   261: iconst_1
    //   262: invokevirtual 407	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   265: aload_1
    //   266: invokevirtual 401	com/tencent/mobileqq/qroute/route/ActivityURIRequest:extra	()Landroid/os/Bundle;
    //   269: ldc_w 372
    //   272: aload 7
    //   274: invokevirtual 411	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   277: aload_1
    //   278: invokevirtual 401	com/tencent/mobileqq/qroute/route/ActivityURIRequest:extra	()Landroid/os/Bundle;
    //   281: ldc_w 378
    //   284: aload 8
    //   286: invokevirtual 411	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   289: aload_1
    //   290: invokevirtual 401	com/tencent/mobileqq/qroute/route/ActivityURIRequest:extra	()Landroid/os/Bundle;
    //   293: ldc_w 380
    //   296: aload 9
    //   298: invokevirtual 411	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   301: aload_1
    //   302: invokevirtual 401	com/tencent/mobileqq/qroute/route/ActivityURIRequest:extra	()Landroid/os/Bundle;
    //   305: ldc_w 385
    //   308: iload_3
    //   309: invokevirtual 415	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   312: aload_1
    //   313: invokevirtual 401	com/tencent/mobileqq/qroute/route/ActivityURIRequest:extra	()Landroid/os/Bundle;
    //   316: ldc_w 382
    //   319: iload_2
    //   320: invokevirtual 415	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   323: aload_1
    //   324: invokestatic 421	com/tencent/mobileqq/qroute/QRoute:startUri	(Lcom/tencent/mobileqq/qroute/route/URIRequest;)V
    //   327: goto +3 -> 330
    //   330: new 48	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   337: astore_1
    //   338: aload_1
    //   339: aload 5
    //   341: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload_1
    //   346: ldc 160
    //   348: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: aload_1
    //   353: aload 6
    //   355: invokevirtual 84	org/json/JSONObject:toString	()Ljava/lang/String;
    //   358: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload_1
    //   363: ldc 162
    //   365: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload_1
    //   370: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: astore_1
    //   374: aload_0
    //   375: aload_1
    //   376: invokespecial 33	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;)V
    //   379: return
    //   380: astore_1
    //   381: goto +12 -> 393
    //   384: astore_1
    //   385: goto +8 -> 393
    //   388: astore_1
    //   389: goto +4 -> 393
    //   392: astore_1
    //   393: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   396: ifeq +187 -> 583
    //   399: ldc 11
    //   401: iconst_2
    //   402: aload_1
    //   403: invokevirtual 422	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   406: invokestatic 425	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   409: return
    //   410: ldc 118
    //   412: aload 6
    //   414: invokevirtual 73	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   417: ifeq +160 -> 577
    //   420: aload_1
    //   421: ldc 154
    //   423: iconst_0
    //   424: invokevirtual 342	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   427: istore_2
    //   428: new 83	org/json/JSONObject
    //   431: dup
    //   432: invokespecial 152	org/json/JSONObject:<init>	()V
    //   435: astore 6
    //   437: aload 6
    //   439: ldc 154
    //   441: iload_2
    //   442: invokevirtual 158	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   445: pop
    //   446: iload_2
    //   447: ifne +35 -> 482
    //   450: aload_1
    //   451: ldc_w 353
    //   454: invokevirtual 347	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   457: astore_1
    //   458: aload_1
    //   459: ifnull +52 -> 511
    //   462: aload 6
    //   464: ldc_w 353
    //   467: new 83	org/json/JSONObject
    //   470: dup
    //   471: aload_1
    //   472: invokespecial 355	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   475: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   478: pop
    //   479: goto +32 -> 511
    //   482: aload_1
    //   483: ldc_w 331
    //   486: invokevirtual 347	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   489: astore_1
    //   490: aload_1
    //   491: ifnull +20 -> 511
    //   494: aload 6
    //   496: ldc_w 353
    //   499: new 83	org/json/JSONObject
    //   502: dup
    //   503: aload_1
    //   504: invokespecial 355	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   507: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   510: pop
    //   511: new 48	java/lang/StringBuilder
    //   514: dup
    //   515: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   518: astore_1
    //   519: aload_1
    //   520: aload 5
    //   522: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: pop
    //   526: aload_1
    //   527: ldc 160
    //   529: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: pop
    //   533: aload_1
    //   534: aload 6
    //   536: invokevirtual 84	org/json/JSONObject:toString	()Ljava/lang/String;
    //   539: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: pop
    //   543: aload_1
    //   544: ldc 162
    //   546: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: pop
    //   550: aload_0
    //   551: aload_1
    //   552: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   555: invokespecial 33	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;)V
    //   558: return
    //   559: astore_1
    //   560: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   563: ifeq +20 -> 583
    //   566: ldc 11
    //   568: iconst_2
    //   569: aload_1
    //   570: invokevirtual 422	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   573: invokestatic 425	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   576: return
    //   577: aload_0
    //   578: aload_1
    //   579: invokespecial 427	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:onResponse	(Landroid/os/Bundle;)V
    //   582: return
    //   583: return
    //   584: goto -467 -> 117
    //   587: goto -257 -> 330
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	590	0	this	FunnyPicJsPlugin
    //   0	590	1	paramBundle	Bundle
    //   63	384	2	i	int
    //   232	77	3	j	int
    //   154	12	4	bool	boolean
    //   38	483	5	str	String
    //   29	506	6	localObject1	java.lang.Object
    //   89	184	7	localObject2	java.lang.Object
    //   206	79	8	localArrayList1	java.util.ArrayList
    //   215	82	9	localArrayList2	java.util.ArrayList
    //   163	75	10	localActivity	android.app.Activity
    // Exception table:
    //   from	to	target	type
    //   374	379	380	java/lang/Exception
    //   175	327	384	java/lang/Exception
    //   330	374	384	java/lang/Exception
    //   96	114	388	java/lang/Exception
    //   121	130	388	java/lang/Exception
    //   135	146	388	java/lang/Exception
    //   146	165	388	java/lang/Exception
    //   56	91	392	java/lang/Exception
    //   420	446	559	java/lang/Exception
    //   450	458	559	java/lang/Exception
    //   462	479	559	java/lang/Exception
    //   482	490	559	java/lang/Exception
    //   494	511	559	java/lang/Exception
    //   511	558	559	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.FunnyPicJsPlugin
 * JD-Core Version:    0.7.0.1
 */