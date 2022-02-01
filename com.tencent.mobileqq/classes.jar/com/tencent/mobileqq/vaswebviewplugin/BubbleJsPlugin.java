package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class BubbleJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BUSINESS_NAME = "bubble";
  private static final String OBJECT_NAME = "bubble";
  public static final String TAG = "BubbleJsPlugin";
  private Bundle mReqBundle;
  
  public BubbleJsPlugin()
  {
    this.mPluginNameSpace = "bubble";
  }
  
  public void diySetup(JSONObject paramJSONObject, String paramString)
  {
    int i = paramJSONObject.getInt("id");
    int j = paramJSONObject.getInt("textId");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("diySetup ");
      localStringBuilder.append(paramJSONObject.toString());
      QLog.i("BubbleJsPlugin", 2, localStringBuilder.toString());
    }
    this.mReqBundle.clear();
    this.mReqBundle.putInt("id", i);
    this.mReqBundle.putInt("textId", j);
    super.sendRemoteReq(DataFactory.a("diy_setup", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
    startDownload(paramJSONObject, "");
    if (QLog.isColorLevel()) {
      QLog.d("BubbleJsPlugin", 2, paramJSONObject.toString());
    }
  }
  
  protected long getPluginBusiness()
  {
    return 2147483712L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
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
      QLog.d("BubbleJsPlugin", 2, paramJsBridgeListener.toString());
    }
    if ((paramString1 != null) && ("bubble".equals(paramString2)) && (paramString3 != null)) {
      try
      {
        paramJsBridgeListener = WebViewPlugin.getJsonFromJSBridge(paramString1);
        if (paramJsBridgeListener == null) {
          return true;
        }
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("handleJsRequest JSON = ");
          paramString1.append(paramJsBridgeListener.toString());
          QLog.d("BubbleJsPlugin", 2, paramString1.toString());
        }
        paramString1 = paramJsBridgeListener.optString("callback");
        if (TextUtils.isEmpty(paramString1))
        {
          QLog.e("BubbleJsPlugin", 1, "callback id is null, so return");
          return true;
        }
        if ("queryInfo".equals(paramString3))
        {
          queryInfo(paramJsBridgeListener, paramString1);
          return true;
        }
        if ("queryLocal".equals(paramString3))
        {
          queryLocal(paramJsBridgeListener, paramString1);
          return true;
        }
        if ("setup".equals(paramString3))
        {
          setup(paramJsBridgeListener, paramString1);
          return true;
        }
        if ("startDownload".equals(paramString3))
        {
          startDownload(paramJsBridgeListener, paramString1);
          return true;
        }
        if ("stopDownload".equals(paramString3))
        {
          stopDownload(paramJsBridgeListener, paramString1);
          return true;
        }
        if ("openSecMsg".equalsIgnoreCase(paramString3)) {
          return true;
        }
        if ("isSecGroupAvailable".equalsIgnoreCase(paramString3)) {
          return true;
        }
        if ("openSecGroup".equalsIgnoreCase(paramString3)) {
          return true;
        }
        if ("diySetup".equalsIgnoreCase(paramString3))
        {
          diySetup(paramJsBridgeListener, paramString1);
          return true;
        }
        paramJsBridgeListener = new StringBuilder();
        paramJsBridgeListener.append(" unsupport method name ");
        paramJsBridgeListener.append(paramString3);
        throw new Exception(paramJsBridgeListener.toString());
      }
      catch (Throwable paramJsBridgeListener)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BubbleJsPlugin", 2, paramJsBridgeListener.getMessage());
        }
        return true;
      }
    }
    return false;
  }
  
  protected void onCreate()
  {
    this.mReqBundle = new Bundle();
    super.onCreate();
  }
  
  public void onPushMsg(Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPushMsg=");
      ((StringBuilder)localObject).append(paramBundle);
      QLog.i("BubbleJsPlugin", 2, ((StringBuilder)localObject).toString());
    }
    int i = paramBundle.getInt("srcType");
    int j;
    if ((i != 0) && (i == 3))
    {
      i = paramBundle.getInt("id");
      j = paramBundle.getInt("result");
      paramBundle = paramBundle.getString("callbackId");
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("id", i);
      ((JSONObject)localObject).put("result", j);
      label105:
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramBundle);
      localStringBuilder.append("(");
      localStringBuilder.append(((JSONObject)localObject).toString());
      localStringBuilder.append(");");
      super.callJs(localStringBuilder.toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      break label105;
    }
  }
  
  /* Error */
  protected void onResponse(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +862 -> 863
    //   4: aload_1
    //   5: ldc 222
    //   7: iconst_0
    //   8: invokevirtual 225	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   11: aload_0
    //   12: getfield 75	com/tencent/mobileqq/vaswebviewplugin/BubbleJsPlugin:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/OnRemoteRespObserver;
    //   15: getfield 81	com/tencent/mobileqq/emosm/OnRemoteRespObserver:key	I
    //   18: if_icmpne +845 -> 863
    //   21: aload_1
    //   22: ldc 227
    //   24: invokevirtual 207	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   27: astore 7
    //   29: aload_1
    //   30: ldc 229
    //   32: invokevirtual 207	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   35: astore 5
    //   37: aload_1
    //   38: ldc 231
    //   40: invokevirtual 235	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   43: astore 6
    //   45: aload 6
    //   47: ifnull +18 -> 65
    //   50: aload 6
    //   52: aload_0
    //   53: getfield 239	com/tencent/mobileqq/vaswebviewplugin/BubbleJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   56: invokevirtual 244	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   59: invokevirtual 250	android/app/Activity:getClassLoader	()Ljava/lang/ClassLoader;
    //   62: invokevirtual 254	android/os/Bundle:setClassLoader	(Ljava/lang/ClassLoader;)V
    //   65: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +40 -> 108
    //   71: new 42	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   78: astore 8
    //   80: aload 8
    //   82: ldc_w 256
    //   85: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 8
    //   91: aload 7
    //   93: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: ldc 12
    //   99: iconst_2
    //   100: aload 8
    //   102: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 58	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: aload 7
    //   110: ifnull +753 -> 863
    //   113: ldc 154
    //   115: aload 7
    //   117: invokevirtual 119	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   120: ifeq +83 -> 203
    //   123: new 28	org/json/JSONObject
    //   126: dup
    //   127: invokespecial 208	org/json/JSONObject:<init>	()V
    //   130: astore_1
    //   131: aload_1
    //   132: ldc 202
    //   134: iconst_0
    //   135: invokevirtual 212	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   138: pop
    //   139: aload_1
    //   140: ldc_w 258
    //   143: ldc_w 260
    //   146: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   149: pop
    //   150: new 42	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   157: astore 6
    //   159: aload 6
    //   161: aload 5
    //   163: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 6
    //   169: ldc 214
    //   171: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload 6
    //   177: aload_1
    //   178: invokevirtual 53	org/json/JSONObject:toString	()Ljava/lang/String;
    //   181: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload 6
    //   187: ldc 216
    //   189: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload_0
    //   194: aload 6
    //   196: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokespecial 219	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;)V
    //   202: return
    //   203: ldc 71
    //   205: aload 7
    //   207: invokevirtual 119	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   210: ifeq +83 -> 293
    //   213: new 28	org/json/JSONObject
    //   216: dup
    //   217: invokespecial 208	org/json/JSONObject:<init>	()V
    //   220: astore_1
    //   221: aload_1
    //   222: ldc 202
    //   224: iconst_0
    //   225: invokevirtual 212	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   228: pop
    //   229: aload_1
    //   230: ldc_w 265
    //   233: ldc_w 260
    //   236: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   239: pop
    //   240: new 42	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   247: astore 6
    //   249: aload 6
    //   251: aload 5
    //   253: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload 6
    //   259: ldc 214
    //   261: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload 6
    //   267: aload_1
    //   268: invokevirtual 53	org/json/JSONObject:toString	()Ljava/lang/String;
    //   271: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: aload 6
    //   277: ldc 216
    //   279: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload_0
    //   284: aload 6
    //   286: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokespecial 219	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;)V
    //   292: return
    //   293: ldc 150
    //   295: aload 7
    //   297: invokevirtual 119	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   300: ifeq +371 -> 671
    //   303: aload 6
    //   305: ifnull +365 -> 670
    //   308: aload 6
    //   310: ldc 26
    //   312: invokevirtual 200	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   315: istore_2
    //   316: aload 6
    //   318: ldc_w 267
    //   321: invokevirtual 207	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   324: astore 8
    //   326: aload 6
    //   328: ldc_w 269
    //   331: invokevirtual 272	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   334: istore 4
    //   336: aload 6
    //   338: ldc_w 274
    //   341: iconst_0
    //   342: invokevirtual 225	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   345: istore_3
    //   346: new 28	org/json/JSONObject
    //   349: dup
    //   350: invokespecial 208	org/json/JSONObject:<init>	()V
    //   353: astore_1
    //   354: aload_1
    //   355: ldc_w 258
    //   358: ldc_w 260
    //   361: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   364: pop
    //   365: new 28	org/json/JSONObject
    //   368: dup
    //   369: invokespecial 208	org/json/JSONObject:<init>	()V
    //   372: astore 7
    //   374: aload 7
    //   376: ldc_w 276
    //   379: iload_2
    //   380: invokevirtual 212	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   383: pop
    //   384: aload 7
    //   386: ldc_w 267
    //   389: aload 8
    //   391: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   394: pop
    //   395: aload 7
    //   397: ldc_w 274
    //   400: iload_3
    //   401: invokevirtual 212	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   404: pop
    //   405: iload 4
    //   407: ifeq +129 -> 536
    //   410: aload 7
    //   412: ldc_w 269
    //   415: iconst_1
    //   416: invokevirtual 212	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   419: pop
    //   420: aload 6
    //   422: ldc_w 278
    //   425: invokevirtual 207	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   428: astore 8
    //   430: aload 8
    //   432: invokestatic 139	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   435: ifne +14 -> 449
    //   438: aload 7
    //   440: ldc_w 278
    //   443: aload 8
    //   445: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   448: pop
    //   449: aload 6
    //   451: ldc_w 280
    //   454: invokevirtual 207	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   457: astore 8
    //   459: aload 8
    //   461: invokestatic 139	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   464: ifne +14 -> 478
    //   467: aload 7
    //   469: ldc_w 280
    //   472: aload 8
    //   474: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   477: pop
    //   478: aload 6
    //   480: ldc_w 282
    //   483: invokevirtual 207	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   486: astore 8
    //   488: aload 8
    //   490: invokestatic 139	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   493: ifne +14 -> 507
    //   496: aload 7
    //   498: ldc_w 282
    //   501: aload 8
    //   503: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   506: pop
    //   507: aload 6
    //   509: ldc_w 284
    //   512: invokevirtual 207	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   515: astore 6
    //   517: aload 6
    //   519: invokestatic 139	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   522: ifne +14 -> 536
    //   525: aload 7
    //   527: ldc_w 284
    //   530: aload 6
    //   532: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   535: pop
    //   536: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   539: ifeq +43 -> 582
    //   542: new 42	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   549: astore 6
    //   551: aload 6
    //   553: ldc_w 286
    //   556: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: pop
    //   560: aload 6
    //   562: aload 7
    //   564: invokevirtual 53	org/json/JSONObject:toString	()Ljava/lang/String;
    //   567: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: pop
    //   571: ldc 12
    //   573: iconst_2
    //   574: aload 6
    //   576: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   579: invokestatic 58	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   582: aload_1
    //   583: ldc_w 288
    //   586: aload 7
    //   588: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   591: pop
    //   592: aload_1
    //   593: ldc 202
    //   595: iconst_0
    //   596: invokevirtual 212	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   599: pop
    //   600: new 42	java/lang/StringBuilder
    //   603: dup
    //   604: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   607: astore 6
    //   609: aload 6
    //   611: aload 5
    //   613: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: pop
    //   617: aload 6
    //   619: ldc 214
    //   621: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: pop
    //   625: aload 6
    //   627: aload_1
    //   628: invokevirtual 53	org/json/JSONObject:toString	()Ljava/lang/String;
    //   631: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: pop
    //   635: aload 6
    //   637: ldc 216
    //   639: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: pop
    //   643: aload 6
    //   645: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: astore_1
    //   649: aload_0
    //   650: aload_1
    //   651: invokespecial 219	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;)V
    //   654: return
    //   655: astore_1
    //   656: goto +4 -> 660
    //   659: astore_1
    //   660: ldc 12
    //   662: iconst_1
    //   663: ldc 93
    //   665: aload_1
    //   666: invokestatic 291	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   669: return
    //   670: return
    //   671: ldc_w 293
    //   674: aload 7
    //   676: invokevirtual 119	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   679: ifeq +85 -> 764
    //   682: aload 6
    //   684: ifnull +79 -> 763
    //   687: aload 6
    //   689: ldc 202
    //   691: invokevirtual 207	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   694: astore_1
    //   695: aload_1
    //   696: invokestatic 139	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   699: ifne +64 -> 763
    //   702: new 28	org/json/JSONObject
    //   705: dup
    //   706: aload_1
    //   707: invokespecial 294	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   710: astore_1
    //   711: new 42	java/lang/StringBuilder
    //   714: dup
    //   715: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   718: astore 6
    //   720: aload 6
    //   722: aload 5
    //   724: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: pop
    //   728: aload 6
    //   730: ldc 214
    //   732: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: pop
    //   736: aload 6
    //   738: aload_1
    //   739: invokevirtual 53	org/json/JSONObject:toString	()Ljava/lang/String;
    //   742: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: pop
    //   746: aload 6
    //   748: ldc 216
    //   750: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: pop
    //   754: aload_0
    //   755: aload 6
    //   757: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   760: invokespecial 219	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;)V
    //   763: return
    //   764: ldc_w 296
    //   767: aload 7
    //   769: invokevirtual 119	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   772: ifeq +85 -> 857
    //   775: aload 6
    //   777: ifnull +79 -> 856
    //   780: aload 6
    //   782: ldc 202
    //   784: invokevirtual 207	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   787: astore_1
    //   788: aload_1
    //   789: invokestatic 139	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   792: ifne +64 -> 856
    //   795: new 28	org/json/JSONObject
    //   798: dup
    //   799: aload_1
    //   800: invokespecial 294	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   803: astore_1
    //   804: new 42	java/lang/StringBuilder
    //   807: dup
    //   808: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   811: astore 6
    //   813: aload 6
    //   815: aload 5
    //   817: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: pop
    //   821: aload 6
    //   823: ldc 214
    //   825: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: pop
    //   829: aload 6
    //   831: aload_1
    //   832: invokevirtual 53	org/json/JSONObject:toString	()Ljava/lang/String;
    //   835: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: pop
    //   839: aload 6
    //   841: ldc 216
    //   843: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   846: pop
    //   847: aload_0
    //   848: aload 6
    //   850: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   853: invokespecial 219	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;)V
    //   856: return
    //   857: aload_0
    //   858: aload_1
    //   859: invokespecial 298	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:onResponse	(Landroid/os/Bundle;)V
    //   862: return
    //   863: return
    //   864: astore_1
    //   865: return
    //   866: astore_1
    //   867: return
    //   868: astore_1
    //   869: return
    //   870: astore_1
    //   871: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	872	0	this	BubbleJsPlugin
    //   0	872	1	paramBundle	Bundle
    //   315	65	2	i	int
    //   345	56	3	j	int
    //   334	72	4	bool	boolean
    //   35	781	5	str	String
    //   43	806	6	localObject1	Object
    //   27	741	7	localObject2	Object
    //   78	424	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   649	654	655	org/json/JSONException
    //   354	405	659	org/json/JSONException
    //   410	449	659	org/json/JSONException
    //   449	478	659	org/json/JSONException
    //   478	507	659	org/json/JSONException
    //   507	536	659	org/json/JSONException
    //   536	582	659	org/json/JSONException
    //   582	649	659	org/json/JSONException
    //   123	202	864	org/json/JSONException
    //   213	292	866	org/json/JSONException
    //   702	763	868	org/json/JSONException
    //   795	856	870	org/json/JSONException
  }
  
  public void queryInfo(JSONObject paramJSONObject, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("queryInfo ");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QLog.i("BubbleJsPlugin", 2, ((StringBuilder)localObject).toString());
    }
    int i = paramJSONObject.getInt("id");
    if (i == 0)
    {
      paramJSONObject = new JSONObject();
      localObject = new JSONObject();
      ((JSONObject)localObject).put("status", 3);
      ((JSONObject)localObject).put("progress", 100);
      paramJSONObject.put("result", 0);
      paramJSONObject.put("message", HardCodeUtil.a(2131899452));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("(");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      ((StringBuilder)localObject).append(");");
      super.callJs(((StringBuilder)localObject).toString());
      return;
    }
    this.mReqBundle.clear();
    this.mReqBundle.putInt("id", i);
    super.sendRemoteReq(DataFactory.a("queryBubbleInfo", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
  
  public void queryLocal(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryLocal ");
      localStringBuilder.append(paramJSONObject.toString());
      QLog.i("BubbleJsPlugin", 2, localStringBuilder.toString());
    }
    paramString = DataFactory.a("queryLocal", paramString, this.mOnRemoteResp.key, new Bundle());
    if (paramJSONObject != null) {
      try
      {
        if (paramJSONObject.has("type")) {
          paramString.putString("type", paramJSONObject.getString("type"));
        }
      }
      catch (JSONException paramJSONObject)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BubbleJsPlugin", 2, paramJSONObject.getMessage());
        }
      }
    }
    super.sendRemoteReq(paramString, false, false);
  }
  
  public void setup(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setup ");
      localStringBuilder.append(paramJSONObject.toString());
      QLog.i("BubbleJsPlugin", 2, localStringBuilder.toString());
    }
    this.mReqBundle.clear();
    int i;
    if (paramJSONObject.has("id"))
    {
      i = paramJSONObject.getInt("id");
      this.mReqBundle.putInt("id", i);
    }
    if (paramJSONObject.has("voiceprintId"))
    {
      i = paramJSONObject.optInt("voiceprintId", 0);
      this.mReqBundle.putInt("voiceprintId", i);
    }
    super.sendRemoteReq(DataFactory.a("setup", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
  
  public void startDownload(JSONObject paramJSONObject, String paramString)
  {
    int i = paramJSONObject.getInt("id");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startDownload ");
      localStringBuilder.append(paramJSONObject.toString());
      QLog.i("BubbleJsPlugin", 2, localStringBuilder.toString());
    }
    this.mReqBundle.clear();
    this.mReqBundle.putInt("id", i);
    super.sendRemoteReq(DataFactory.a("bubble_startDownLoad", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
  
  public void stopDownload(JSONObject paramJSONObject, String paramString)
  {
    int i = paramJSONObject.getInt("id");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopDownload ");
      localStringBuilder.append(paramJSONObject.toString());
      QLog.i("BubbleJsPlugin", 2, localStringBuilder.toString());
    }
    this.mReqBundle.clear();
    this.mReqBundle.putInt("id", i);
    super.sendRemoteReq(DataFactory.a("bubble_StopDownLoad", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.BubbleJsPlugin
 * JD-Core Version:    0.7.0.1
 */