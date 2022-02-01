package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.emosm.Client.OnRemoteRespObserver;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResultCallback;
import java.util.Map;
import org.json.JSONObject;

public class SignJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String CHANGE_STATUS_CALLBACK_DATA = "change_status_callback_data";
  public static final String LOCATION_SP_KEY = "sign_location_id_";
  public static final String NAME_SPACE = "sign";
  private static final String PARAM_ACTION_ID = "k_action_id";
  private static final String PARAM_ACTION_TEXT = "k_action_text";
  public static final String PARAM_DATA_ID = "k_data_id";
  public static final String PARAM_DATA_TEXT = "k_data_text";
  private static final byte REQUEST_ACTION = 101;
  private static final byte REQUEST_LOCATION = 100;
  private static final String TAG = "SignJsPlugin";
  private final String SIGNATURE_SYNC_IMG_TEMP_FILE = this.SIGNATURE_SYNC_IMG_TEMP_PATH + "temp.png";
  private final String SIGNATURE_SYNC_IMG_TEMP_PATH = AppConstants.SDCARD_SIGNATURE_TEMPLATE_ROOT + "temp/";
  private BrowserAppInterface browserApp;
  private EIPCResultCallback getSignatureCallback = new SignJsPlugin.1(this);
  private boolean isSync;
  private String mActionCallback;
  private String mCachePoiId;
  private String mContentChangeCallback;
  private String mGetSigInfoCallback;
  private String mLocationCallback;
  private String mOpenFontCallback;
  private String mPublishCallback;
  private Bundle mReqBundle;
  private int mSelectTagId;
  private String mSelectTagText;
  
  public SignJsPlugin()
  {
    this.mPluginNameSpace = "sign";
  }
  
  private void handleChangeStatusCallback(Bundle paramBundle, String paramString)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      int i = paramBundle.getInt("result");
      if (i == 100) {
        localJSONObject1.put("result", 0);
      }
      for (;;)
      {
        if (paramBundle.getBoolean("hasTipsInfo", false))
        {
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("type", paramBundle.getInt("tips_type"));
          localJSONObject2.put("titleWording", paramBundle.getString("tips_titleWording"));
          localJSONObject2.put("wording", paramBundle.getString("tips_wording"));
          localJSONObject2.put("rightBtnWording", paramBundle.getString("tips_rightBtnWording"));
          localJSONObject2.put("leftBtnWording", paramBundle.getString("tips_leftBtnWording"));
          localJSONObject2.put("vipType", paramBundle.getString("tips_vipType"));
          localJSONObject2.put("vipMonth", paramBundle.getInt("tips_vipMonth"));
          localJSONObject2.put("url", paramBundle.getString("tips_url"));
          JSONObject localJSONObject3 = new JSONObject();
          localJSONObject3.put("tipsInfo", localJSONObject2);
          localJSONObject1.put("data", localJSONObject3);
        }
        if (paramBundle.containsKey("errorDesc")) {
          localJSONObject1.put("errorDesc", paramBundle.getString("errorDesc"));
        }
        super.callJs(paramString, new String[] { localJSONObject1.toString() });
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SignJsPlugin", 2, "handleChangeStatusCallback Result = " + localJSONObject1.toString());
        return;
        localJSONObject1.put("result", i);
      }
      return;
    }
    catch (Exception paramBundle)
    {
      QLog.e("SignJsPlugin", 1, "handleChangeStatusCallback error: ", paramBundle);
      super.callJs(paramString, new String[] { "{\"result\": -1}" });
    }
  }
  
  protected boolean excuteEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934616L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SignJsPlugin", 2, "onclick open font");
      }
      if (!TextUtils.isEmpty(this.mOpenFontCallback)) {
        super.callJs(this.mOpenFontCallback, new String[] { "{\"result\": 0}" });
      }
      return true;
    }
    if (paramLong == 8589934617L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SignJsPlugin", 2, "change status callback");
      }
      if (!TextUtils.isEmpty(this.mPublishCallback))
      {
        paramString = paramMap.get("change_status_callback_data");
        if (!(paramString instanceof Bundle)) {
          break label119;
        }
        handleChangeStatusCallback((Bundle)paramString, this.mPublishCallback);
        this.mPublishCallback = null;
      }
    }
    for (;;)
    {
      return false;
      label119:
      super.callJs(this.mPublishCallback, new String[] { "{\"result\": -1}" });
      break;
      if (paramLong == 8589934618L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SignJsPlugin", 2, "change status callback");
        }
        if (!TextUtils.isEmpty(this.mContentChangeCallback)) {
          super.callJs(this.mContentChangeCallback, new String[] { "{\"result\": 0}" });
        }
      }
      else if (paramLong == 8589934598L)
      {
        paramString = new Intent();
        if ((this.mSelectTagId > 0) && (!TextUtils.isEmpty(this.mSelectTagText)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("SignJsPlugin", 2, String.format("setResult [%d, %s]", new Object[] { Integer.valueOf(this.mSelectTagId), this.mSelectTagText }));
          }
          paramString.putExtra("key_sign_topic_id", this.mSelectTagId);
          paramString.putExtra("key_sign_topic_name", this.mSelectTagText);
          this.mRuntime.a().setResult(-1, paramString);
        }
      }
    }
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 8589934619L;
  }
  
  /* Error */
  public boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +20 -> 24
    //   7: ldc 14
    //   9: aload_3
    //   10: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13: ifeq +11 -> 24
    //   16: aload 4
    //   18: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifeq +5 -> 26
    //   24: iconst_0
    //   25: ireturn
    //   26: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +50 -> 79
    //   32: ldc 34
    //   34: iconst_2
    //   35: new 60	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   42: ldc_w 307
    //   45: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_2
    //   49: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc_w 309
    //   55: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_3
    //   59: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc_w 311
    //   65: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload 4
    //   70: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   79: aconst_null
    //   80: astore 5
    //   82: aload_2
    //   83: invokestatic 317	com/tencent/mobileqq/webview/swift/WebViewPlugin:getJsonFromJSBridge	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   86: astore_1
    //   87: aload_1
    //   88: ifnonnull +5 -> 93
    //   91: iconst_1
    //   92: ireturn
    //   93: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq +32 -> 128
    //   99: ldc 34
    //   101: iconst_2
    //   102: new 60	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   109: ldc_w 319
    //   112: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload_1
    //   116: invokevirtual 174	org/json/JSONObject:toString	()Ljava/lang/String;
    //   119: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: aload_1
    //   129: ldc_w 321
    //   132: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   135: astore 16
    //   137: aload 16
    //   139: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   142: ifeq +14 -> 156
    //   145: ldc 34
    //   147: iconst_1
    //   148: ldc_w 326
    //   151: invokestatic 328	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: iconst_1
    //   155: ireturn
    //   156: ldc_w 330
    //   159: aload 4
    //   161: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   164: ifeq +302 -> 466
    //   167: aload_1
    //   168: ldc_w 332
    //   171: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   174: astore 5
    //   176: aload 5
    //   178: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   181: ifne +11 -> 192
    //   184: aload 5
    //   186: invokestatic 335	android/text/TextUtils:isDigitsOnly	(Ljava/lang/CharSequence;)Z
    //   189: ifne +20 -> 209
    //   192: aload_0
    //   193: aload 16
    //   195: iconst_1
    //   196: anewarray 173	java/lang/String
    //   199: dup
    //   200: iconst_0
    //   201: ldc 198
    //   203: aastore
    //   204: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   207: iconst_1
    //   208: ireturn
    //   209: aload 5
    //   211: invokestatic 338	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   214: istore 6
    //   216: aload_1
    //   217: ldc_w 340
    //   220: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   223: astore 5
    //   225: aload_1
    //   226: ldc_w 342
    //   229: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   232: astore 13
    //   234: aload_1
    //   235: ldc_w 344
    //   238: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   241: astore 14
    //   243: aload_1
    //   244: ldc_w 346
    //   247: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   250: astore 15
    //   252: aload_0
    //   253: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   256: invokevirtual 351	android/os/Bundle:clear	()V
    //   259: aload_0
    //   260: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   263: ldc_w 332
    //   266: iload 6
    //   268: invokevirtual 355	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   271: aload_0
    //   272: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   275: ldc_w 357
    //   278: aload 5
    //   280: invokevirtual 361	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: aload_0
    //   284: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   287: ldc_w 342
    //   290: aload 13
    //   292: invokevirtual 361	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: aload_0
    //   296: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   299: ldc_w 344
    //   302: aload 14
    //   304: invokevirtual 361	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   307: aload_0
    //   308: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   311: ldc_w 346
    //   314: aload 15
    //   316: invokevirtual 361	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   319: aload_1
    //   320: ldc_w 363
    //   323: invokevirtual 366	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   326: astore 5
    //   328: aload 5
    //   330: ifnull +75 -> 405
    //   333: aload_0
    //   334: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   337: ldc_w 368
    //   340: aload 5
    //   342: ldc_w 370
    //   345: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   348: invokevirtual 361	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   351: aload_0
    //   352: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   355: ldc_w 372
    //   358: aload 5
    //   360: ldc_w 374
    //   363: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   366: invokevirtual 361	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   369: aload_0
    //   370: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   373: ldc_w 376
    //   376: aload 5
    //   378: ldc_w 378
    //   381: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   384: invokevirtual 361	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   387: aload_0
    //   388: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   391: ldc_w 380
    //   394: aload 5
    //   396: ldc_w 382
    //   399: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   402: invokevirtual 361	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   405: aload_1
    //   406: ldc_w 384
    //   409: invokevirtual 388	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   412: astore_1
    //   413: aload_1
    //   414: ifnull +24 -> 438
    //   417: aload_1
    //   418: invokevirtual 394	org/json/JSONArray:length	()I
    //   421: ifle +17 -> 438
    //   424: aload_0
    //   425: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   428: ldc_w 396
    //   431: aload_1
    //   432: invokevirtual 397	org/json/JSONArray:toString	()Ljava/lang/String;
    //   435: invokevirtual 361	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   438: aload_0
    //   439: ldc_w 399
    //   442: aload 16
    //   444: aload_0
    //   445: getfield 403	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/Client$OnRemoteRespObserver;
    //   448: getfield 408	com/tencent/mobileqq/emosm/Client$OnRemoteRespObserver:key	I
    //   451: aload_0
    //   452: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   455: invokestatic 413	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   458: iconst_0
    //   459: iconst_1
    //   460: invokespecial 417	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:sendRemoteReq	(Landroid/os/Bundle;ZZ)V
    //   463: goto +2815 -> 3278
    //   466: ldc_w 419
    //   469: aload 4
    //   471: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   474: ifeq +287 -> 761
    //   477: invokestatic 425	cooperation/qzone/QZoneHelper$UserInfo:getInstance	()Lcooperation/qzone/QZoneHelper$UserInfo;
    //   480: astore 13
    //   482: aload 13
    //   484: aload_0
    //   485: getfield 427	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:browserApp	Lcom/tencent/mobileqq/app/BrowserAppInterface;
    //   488: invokevirtual 432	com/tencent/mobileqq/app/BrowserAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   491: putfield 435	cooperation/qzone/QZoneHelper$UserInfo:qzone_uin	Ljava/lang/String;
    //   494: aload 13
    //   496: aload_0
    //   497: getfield 427	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:browserApp	Lcom/tencent/mobileqq/app/BrowserAppInterface;
    //   500: invokevirtual 438	com/tencent/mobileqq/app/BrowserAppInterface:getCurrentNickname	()Ljava/lang/String;
    //   503: putfield 441	cooperation/qzone/QZoneHelper$UserInfo:nickname	Ljava/lang/String;
    //   506: aload_0
    //   507: aload 16
    //   509: putfield 443	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mLocationCallback	Ljava/lang/String;
    //   512: aload_0
    //   513: getfield 445	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mCachePoiId	Ljava/lang/String;
    //   516: astore 5
    //   518: aload 5
    //   520: astore_1
    //   521: aload 5
    //   523: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   526: ifeq +50 -> 576
    //   529: aload_0
    //   530: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   533: invokevirtual 448	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   536: invokevirtual 454	com/tencent/common/app/AppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   539: new 60	java/lang/StringBuilder
    //   542: dup
    //   543: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   546: ldc 11
    //   548: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: aload_0
    //   552: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   555: invokevirtual 448	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   558: invokevirtual 455	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   561: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   567: ldc_w 457
    //   570: invokeinterface 462 3 0
    //   575: astore_1
    //   576: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   579: ifeq +29 -> 608
    //   582: ldc 34
    //   584: iconst_2
    //   585: new 60	java/lang/StringBuilder
    //   588: dup
    //   589: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   592: ldc_w 464
    //   595: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: aload_1
    //   599: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   605: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   608: new 108	android/os/Bundle
    //   611: dup
    //   612: invokespecial 465	android/os/Bundle:<init>	()V
    //   615: astore 5
    //   617: aload_1
    //   618: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   621: ifne +21 -> 642
    //   624: aload 5
    //   626: ldc_w 467
    //   629: iconst_1
    //   630: invokevirtual 355	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   633: aload 5
    //   635: ldc_w 469
    //   638: aload_1
    //   639: invokevirtual 361	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   642: aload_0
    //   643: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   646: invokevirtual 279	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   649: aload 13
    //   651: ldc 14
    //   653: invokestatic 473	com/tencent/mobileqq/webview/swift/WebViewUtil:a	(Ljava/lang/String;)I
    //   656: bipush 8
    //   658: ishl
    //   659: bipush 100
    //   661: iadd
    //   662: aload 5
    //   664: invokestatic 479	cooperation/qzone/QZoneHelper:forwardToMoodSelectLocation	(Landroid/app/Activity;Lcooperation/qzone/QZoneHelper$UserInfo;ILandroid/os/Bundle;)V
    //   667: goto +2611 -> 3278
    //   670: astore_1
    //   671: aload 16
    //   673: astore 5
    //   675: ldc 34
    //   677: iconst_2
    //   678: new 60	java/lang/StringBuilder
    //   681: dup
    //   682: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   685: ldc_w 481
    //   688: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: aload_2
    //   692: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: ldc_w 309
    //   698: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: aload_3
    //   702: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: ldc_w 311
    //   708: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: aload 4
    //   713: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: ldc_w 483
    //   719: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: aload_1
    //   723: invokevirtual 486	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   726: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   732: invokestatic 328	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   735: aload 5
    //   737: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   740: ifne +2538 -> 3278
    //   743: aload_0
    //   744: aload 5
    //   746: iconst_1
    //   747: anewarray 173	java/lang/String
    //   750: dup
    //   751: iconst_0
    //   752: ldc 198
    //   754: aastore
    //   755: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   758: goto +2520 -> 3278
    //   761: ldc_w 488
    //   764: aload 4
    //   766: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   769: ifeq +37 -> 806
    //   772: new 236	android/content/Intent
    //   775: dup
    //   776: aload_0
    //   777: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   780: invokevirtual 279	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   783: ldc_w 490
    //   786: invokespecial 493	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   789: astore_1
    //   790: aload_0
    //   791: aload 16
    //   793: putfield 495	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mActionCallback	Ljava/lang/String;
    //   796: aload_0
    //   797: aload_1
    //   798: bipush 101
    //   800: invokespecial 499	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   803: goto +2475 -> 3278
    //   806: ldc_w 501
    //   809: aload 4
    //   811: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   814: ifeq +126 -> 940
    //   817: aload_1
    //   818: ldc_w 503
    //   821: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   824: astore 5
    //   826: aload_1
    //   827: ldc_w 505
    //   830: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   833: astore 13
    //   835: aload 5
    //   837: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   840: ifeq +20 -> 860
    //   843: aload_0
    //   844: aload 16
    //   846: iconst_1
    //   847: anewarray 173	java/lang/String
    //   850: dup
    //   851: iconst_0
    //   852: ldc 198
    //   854: aastore
    //   855: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   858: iconst_1
    //   859: ireturn
    //   860: aload_1
    //   861: ldc_w 507
    //   864: invokevirtual 510	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   867: istore 6
    //   869: aload_0
    //   870: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   873: invokevirtual 351	android/os/Bundle:clear	()V
    //   876: aload_0
    //   877: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   880: ldc_w 503
    //   883: aload 5
    //   885: invokevirtual 361	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   888: aload_0
    //   889: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   892: ldc_w 505
    //   895: aload 13
    //   897: invokevirtual 361	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   900: aload_0
    //   901: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   904: ldc_w 507
    //   907: iload 6
    //   909: invokevirtual 355	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   912: aload_0
    //   913: ldc_w 512
    //   916: aload 16
    //   918: aload_0
    //   919: getfield 403	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/Client$OnRemoteRespObserver;
    //   922: getfield 408	com/tencent/mobileqq/emosm/Client$OnRemoteRespObserver:key	I
    //   925: aload_0
    //   926: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   929: invokestatic 413	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   932: iconst_0
    //   933: iconst_1
    //   934: invokespecial 417	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:sendRemoteReq	(Landroid/os/Bundle;ZZ)V
    //   937: goto +2341 -> 3278
    //   940: ldc_w 514
    //   943: aload 4
    //   945: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   948: ifeq +1041 -> 1989
    //   951: aload_1
    //   952: ldc_w 516
    //   955: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   958: astore 5
    //   960: aload_1
    //   961: ldc_w 357
    //   964: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   967: astore 19
    //   969: aload_0
    //   970: getfield 518	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:isSync	Z
    //   973: ifeq +2305 -> 3278
    //   976: aload 5
    //   978: ifnull +16 -> 994
    //   981: aload 5
    //   983: ifnull +71 -> 1054
    //   986: aload 5
    //   988: invokevirtual 520	java/lang/String:isEmpty	()Z
    //   991: ifeq +63 -> 1054
    //   994: aload 19
    //   996: ifnull +2282 -> 3278
    //   999: aload 19
    //   1001: invokevirtual 520	java/lang/String:isEmpty	()Z
    //   1004: ifne +2274 -> 3278
    //   1007: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1010: ifeq +31 -> 1041
    //   1013: ldc_w 522
    //   1016: iconst_4
    //   1017: new 60	java/lang/StringBuilder
    //   1020: dup
    //   1021: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1024: ldc_w 524
    //   1027: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1030: aload 19
    //   1032: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1035: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1038: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1041: aload 19
    //   1043: aconst_null
    //   1044: ldc_w 526
    //   1047: iconst_3
    //   1048: invokestatic 530	cooperation/qzone/QZoneHelper:publishPictureMoodSilently	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;I)V
    //   1051: goto +2227 -> 3278
    //   1054: iconst_0
    //   1055: istore 9
    //   1057: iconst_0
    //   1058: istore 10
    //   1060: iconst_0
    //   1061: istore 11
    //   1063: iconst_0
    //   1064: istore 8
    //   1066: iload 11
    //   1068: istore 6
    //   1070: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1073: ifeq +16 -> 1089
    //   1076: iload 11
    //   1078: istore 6
    //   1080: ldc_w 522
    //   1083: iconst_4
    //   1084: aload 5
    //   1086: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1089: iload 11
    //   1091: istore 6
    //   1093: aload 5
    //   1095: iconst_2
    //   1096: invokestatic 536	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   1099: astore 20
    //   1101: aconst_null
    //   1102: astore_1
    //   1103: aconst_null
    //   1104: astore 17
    //   1106: aconst_null
    //   1107: astore 18
    //   1109: aconst_null
    //   1110: astore 14
    //   1112: aconst_null
    //   1113: astore 15
    //   1115: aload 18
    //   1117: astore 5
    //   1119: aload_1
    //   1120: astore 13
    //   1122: new 538	java/io/File
    //   1125: dup
    //   1126: aload_0
    //   1127: getfield 78	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:SIGNATURE_SYNC_IMG_TEMP_PATH	Ljava/lang/String;
    //   1130: invokespecial 541	java/io/File:<init>	(Ljava/lang/String;)V
    //   1133: astore 21
    //   1135: aload 18
    //   1137: astore 5
    //   1139: aload_1
    //   1140: astore 13
    //   1142: aload 21
    //   1144: invokevirtual 544	java/io/File:exists	()Z
    //   1147: ifne +71 -> 1218
    //   1150: aload 18
    //   1152: astore 5
    //   1154: aload_1
    //   1155: astore 13
    //   1157: aload 21
    //   1159: invokevirtual 547	java/io/File:mkdirs	()Z
    //   1162: istore 12
    //   1164: aload 18
    //   1166: astore 5
    //   1168: aload_1
    //   1169: astore 13
    //   1171: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1174: ifeq +44 -> 1218
    //   1177: aload 18
    //   1179: astore 5
    //   1181: aload_1
    //   1182: astore 13
    //   1184: ldc_w 522
    //   1187: iconst_2
    //   1188: new 60	java/lang/StringBuilder
    //   1191: dup
    //   1192: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1195: ldc_w 549
    //   1198: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1201: iload 12
    //   1203: invokevirtual 552	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1206: ldc_w 554
    //   1209: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1212: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1215: invokestatic 258	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1218: aload 18
    //   1220: astore 5
    //   1222: aload_1
    //   1223: astore 13
    //   1225: new 556	java/io/FileOutputStream
    //   1228: dup
    //   1229: aload_0
    //   1230: getfield 82	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:SIGNATURE_SYNC_IMG_TEMP_FILE	Ljava/lang/String;
    //   1233: invokespecial 557	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   1236: astore_1
    //   1237: new 559	java/io/BufferedOutputStream
    //   1240: dup
    //   1241: aload_1
    //   1242: invokespecial 562	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1245: astore 5
    //   1247: aload 5
    //   1249: aload 20
    //   1251: invokevirtual 566	java/io/BufferedOutputStream:write	([B)V
    //   1254: aload 5
    //   1256: invokevirtual 569	java/io/BufferedOutputStream:flush	()V
    //   1259: aload 5
    //   1261: ifnull +12 -> 1273
    //   1264: iload 11
    //   1266: istore 6
    //   1268: aload 5
    //   1270: invokevirtual 572	java/io/BufferedOutputStream:close	()V
    //   1273: aload_1
    //   1274: ifnull +11 -> 1285
    //   1277: iload 11
    //   1279: istore 6
    //   1281: aload_1
    //   1282: invokevirtual 573	java/io/FileOutputStream:close	()V
    //   1285: iload 11
    //   1287: istore 6
    //   1289: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1292: ifeq +17 -> 1309
    //   1295: iload 11
    //   1297: istore 6
    //   1299: ldc_w 522
    //   1302: iconst_2
    //   1303: ldc_w 575
    //   1306: invokestatic 258	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1309: iload 11
    //   1311: istore 6
    //   1313: aload_0
    //   1314: getfield 82	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:SIGNATURE_SYNC_IMG_TEMP_FILE	Ljava/lang/String;
    //   1317: invokestatic 579	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   1320: ifeq +595 -> 1915
    //   1323: iload 11
    //   1325: istore 6
    //   1327: aload_0
    //   1328: getfield 82	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:SIGNATURE_SYNC_IMG_TEMP_FILE	Ljava/lang/String;
    //   1331: invokestatic 582	com/tencent/mobileqq/utils/FileUtils:f	(Ljava/lang/String;)Z
    //   1334: ifeq +581 -> 1915
    //   1337: iload 11
    //   1339: istore 6
    //   1341: new 584	java/util/ArrayList
    //   1344: dup
    //   1345: invokespecial 585	java/util/ArrayList:<init>	()V
    //   1348: astore_1
    //   1349: iload 11
    //   1351: istore 6
    //   1353: aload_1
    //   1354: aload_0
    //   1355: getfield 82	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:SIGNATURE_SYNC_IMG_TEMP_FILE	Ljava/lang/String;
    //   1358: invokevirtual 588	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1361: pop
    //   1362: iload 11
    //   1364: istore 6
    //   1366: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1369: ifeq +41 -> 1410
    //   1372: iload 11
    //   1374: istore 6
    //   1376: ldc_w 522
    //   1379: iconst_2
    //   1380: new 60	java/lang/StringBuilder
    //   1383: dup
    //   1384: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1387: ldc_w 590
    //   1390: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1393: aload_1
    //   1394: iconst_0
    //   1395: invokevirtual 593	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1398: checkcast 173	java/lang/String
    //   1401: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1404: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1407: invokestatic 258	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1410: iconst_1
    //   1411: istore 6
    //   1413: iconst_1
    //   1414: istore 7
    //   1416: ldc_w 594
    //   1419: invokestatic 599	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1422: aload_1
    //   1423: ldc_w 526
    //   1426: iconst_3
    //   1427: invokestatic 530	cooperation/qzone/QZoneHelper:publishPictureMoodSilently	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;I)V
    //   1430: iconst_1
    //   1431: istore 7
    //   1433: iload 7
    //   1435: ifne +1843 -> 3278
    //   1438: aload 19
    //   1440: ifnull +1838 -> 3278
    //   1443: aload 19
    //   1445: invokevirtual 520	java/lang/String:isEmpty	()Z
    //   1448: ifne +1830 -> 3278
    //   1451: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1454: ifeq +13 -> 1467
    //   1457: ldc_w 522
    //   1460: iconst_4
    //   1461: ldc_w 601
    //   1464: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1467: aload 19
    //   1469: aconst_null
    //   1470: ldc_w 526
    //   1473: iconst_3
    //   1474: invokestatic 530	cooperation/qzone/QZoneHelper:publishPictureMoodSilently	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;I)V
    //   1477: goto +1801 -> 3278
    //   1480: astore_1
    //   1481: iload 11
    //   1483: istore 6
    //   1485: aload_1
    //   1486: invokevirtual 604	java/io/IOException:printStackTrace	()V
    //   1489: goto -180 -> 1309
    //   1492: astore_1
    //   1493: iconst_0
    //   1494: istore 7
    //   1496: iload 7
    //   1498: istore 6
    //   1500: ldc_w 522
    //   1503: iconst_2
    //   1504: ldc_w 606
    //   1507: invokestatic 328	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1510: iload 7
    //   1512: istore 6
    //   1514: aload_1
    //   1515: invokevirtual 607	java/lang/IllegalArgumentException:printStackTrace	()V
    //   1518: iload 7
    //   1520: ifne +1758 -> 3278
    //   1523: aload 19
    //   1525: ifnull +1753 -> 3278
    //   1528: aload 19
    //   1530: invokevirtual 520	java/lang/String:isEmpty	()Z
    //   1533: ifne +1745 -> 3278
    //   1536: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1539: ifeq +13 -> 1552
    //   1542: ldc_w 522
    //   1545: iconst_4
    //   1546: ldc_w 601
    //   1549: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1552: aload 19
    //   1554: aconst_null
    //   1555: ldc_w 526
    //   1558: iconst_3
    //   1559: invokestatic 530	cooperation/qzone/QZoneHelper:publishPictureMoodSilently	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;I)V
    //   1562: goto +1716 -> 3278
    //   1565: astore 14
    //   1567: aload 17
    //   1569: astore_1
    //   1570: aload 15
    //   1572: astore 5
    //   1574: aload_1
    //   1575: astore 13
    //   1577: aload 14
    //   1579: invokevirtual 604	java/io/IOException:printStackTrace	()V
    //   1582: aload 15
    //   1584: ifnull +12 -> 1596
    //   1587: iload 11
    //   1589: istore 6
    //   1591: aload 15
    //   1593: invokevirtual 572	java/io/BufferedOutputStream:close	()V
    //   1596: aload_1
    //   1597: ifnull +11 -> 1608
    //   1600: iload 11
    //   1602: istore 6
    //   1604: aload_1
    //   1605: invokevirtual 573	java/io/FileOutputStream:close	()V
    //   1608: iload 11
    //   1610: istore 6
    //   1612: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1615: ifeq -306 -> 1309
    //   1618: iload 11
    //   1620: istore 6
    //   1622: ldc_w 522
    //   1625: iconst_2
    //   1626: ldc_w 575
    //   1629: invokestatic 258	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1632: goto -323 -> 1309
    //   1635: astore_1
    //   1636: iload 11
    //   1638: istore 6
    //   1640: aload_1
    //   1641: invokevirtual 604	java/io/IOException:printStackTrace	()V
    //   1644: goto -335 -> 1309
    //   1647: astore_1
    //   1648: iload 9
    //   1650: istore 7
    //   1652: iload 7
    //   1654: istore 6
    //   1656: ldc_w 522
    //   1659: iconst_2
    //   1660: ldc_w 609
    //   1663: invokestatic 328	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1666: iload 7
    //   1668: istore 6
    //   1670: aload_1
    //   1671: invokevirtual 610	java/lang/Exception:printStackTrace	()V
    //   1674: iload 7
    //   1676: ifne +1602 -> 3278
    //   1679: aload 19
    //   1681: ifnull +1597 -> 3278
    //   1684: aload 19
    //   1686: invokevirtual 520	java/lang/String:isEmpty	()Z
    //   1689: ifne +1589 -> 3278
    //   1692: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1695: ifeq +13 -> 1708
    //   1698: ldc_w 522
    //   1701: iconst_4
    //   1702: ldc_w 601
    //   1705: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1708: aload 19
    //   1710: aconst_null
    //   1711: ldc_w 526
    //   1714: iconst_3
    //   1715: invokestatic 530	cooperation/qzone/QZoneHelper:publishPictureMoodSilently	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;I)V
    //   1718: goto +1560 -> 3278
    //   1721: astore_1
    //   1722: aload 5
    //   1724: ifnull +12 -> 1736
    //   1727: iload 11
    //   1729: istore 6
    //   1731: aload 5
    //   1733: invokevirtual 572	java/io/BufferedOutputStream:close	()V
    //   1736: aload 13
    //   1738: ifnull +12 -> 1750
    //   1741: iload 11
    //   1743: istore 6
    //   1745: aload 13
    //   1747: invokevirtual 573	java/io/FileOutputStream:close	()V
    //   1750: iload 11
    //   1752: istore 6
    //   1754: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1757: ifeq +17 -> 1774
    //   1760: iload 11
    //   1762: istore 6
    //   1764: ldc_w 522
    //   1767: iconst_2
    //   1768: ldc_w 575
    //   1771: invokestatic 258	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1774: iload 11
    //   1776: istore 6
    //   1778: aload_1
    //   1779: athrow
    //   1780: astore_1
    //   1781: iload 10
    //   1783: istore 7
    //   1785: iload 7
    //   1787: istore 6
    //   1789: ldc_w 522
    //   1792: iconst_2
    //   1793: ldc_w 612
    //   1796: invokestatic 328	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1799: iload 7
    //   1801: istore 6
    //   1803: aload_1
    //   1804: invokevirtual 613	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1807: iload 7
    //   1809: ifne +1469 -> 3278
    //   1812: aload 19
    //   1814: ifnull +1464 -> 3278
    //   1817: aload 19
    //   1819: invokevirtual 520	java/lang/String:isEmpty	()Z
    //   1822: ifne +1456 -> 3278
    //   1825: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1828: ifeq +13 -> 1841
    //   1831: ldc_w 522
    //   1834: iconst_4
    //   1835: ldc_w 601
    //   1838: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1841: aload 19
    //   1843: aconst_null
    //   1844: ldc_w 526
    //   1847: iconst_3
    //   1848: invokestatic 530	cooperation/qzone/QZoneHelper:publishPictureMoodSilently	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;I)V
    //   1851: goto +1427 -> 3278
    //   1854: astore 5
    //   1856: iload 11
    //   1858: istore 6
    //   1860: aload 5
    //   1862: invokevirtual 604	java/io/IOException:printStackTrace	()V
    //   1865: goto -91 -> 1774
    //   1868: astore_1
    //   1869: iload 6
    //   1871: ifne +42 -> 1913
    //   1874: aload 19
    //   1876: ifnull +37 -> 1913
    //   1879: aload 19
    //   1881: invokevirtual 520	java/lang/String:isEmpty	()Z
    //   1884: ifne +29 -> 1913
    //   1887: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1890: ifeq +13 -> 1903
    //   1893: ldc_w 522
    //   1896: iconst_4
    //   1897: ldc_w 601
    //   1900: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1903: aload 19
    //   1905: aconst_null
    //   1906: ldc_w 526
    //   1909: iconst_3
    //   1910: invokestatic 530	cooperation/qzone/QZoneHelper:publishPictureMoodSilently	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;I)V
    //   1913: aload_1
    //   1914: athrow
    //   1915: iload 8
    //   1917: istore 7
    //   1919: iload 11
    //   1921: istore 6
    //   1923: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1926: ifeq -493 -> 1433
    //   1929: iload 11
    //   1931: istore 6
    //   1933: ldc_w 522
    //   1936: iconst_2
    //   1937: new 60	java/lang/StringBuilder
    //   1940: dup
    //   1941: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1944: ldc_w 615
    //   1947: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1950: aload_0
    //   1951: getfield 82	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:SIGNATURE_SYNC_IMG_TEMP_FILE	Ljava/lang/String;
    //   1954: invokestatic 579	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   1957: invokevirtual 552	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1960: ldc_w 617
    //   1963: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1966: aload_0
    //   1967: getfield 82	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:SIGNATURE_SYNC_IMG_TEMP_FILE	Ljava/lang/String;
    //   1970: invokestatic 582	com/tencent/mobileqq/utils/FileUtils:f	(Ljava/lang/String;)Z
    //   1973: invokevirtual 552	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1976: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1979: invokestatic 258	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1982: iload 8
    //   1984: istore 7
    //   1986: goto -553 -> 1433
    //   1989: ldc_w 619
    //   1992: aload 4
    //   1994: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1997: ifeq +31 -> 2028
    //   2000: aload_0
    //   2001: ldc_w 621
    //   2004: aload 16
    //   2006: aload_0
    //   2007: getfield 403	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/Client$OnRemoteRespObserver;
    //   2010: getfield 408	com/tencent/mobileqq/emosm/Client$OnRemoteRespObserver:key	I
    //   2013: aload_0
    //   2014: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   2017: invokestatic 413	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   2020: iconst_0
    //   2021: iconst_1
    //   2022: invokespecial 417	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:sendRemoteReq	(Landroid/os/Bundle;ZZ)V
    //   2025: goto +1253 -> 3278
    //   2028: ldc_w 623
    //   2031: aload 4
    //   2033: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2036: ifeq +41 -> 2077
    //   2039: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2042: ifeq +12 -> 2054
    //   2045: ldc 34
    //   2047: iconst_2
    //   2048: ldc_w 623
    //   2051: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2054: aload_0
    //   2055: aconst_null
    //   2056: putfield 445	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mCachePoiId	Ljava/lang/String;
    //   2059: aload_0
    //   2060: aload 16
    //   2062: iconst_1
    //   2063: anewarray 173	java/lang/String
    //   2066: dup
    //   2067: iconst_0
    //   2068: ldc 214
    //   2070: aastore
    //   2071: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2074: goto +1204 -> 3278
    //   2077: ldc_w 625
    //   2080: aload 4
    //   2082: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2085: ifeq +109 -> 2194
    //   2088: aload_1
    //   2089: ldc_w 627
    //   2092: invokevirtual 510	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2095: istore 6
    //   2097: aload_1
    //   2098: ldc_w 629
    //   2101: invokevirtual 510	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2104: istore 7
    //   2106: aload_1
    //   2107: ldc_w 631
    //   2110: invokevirtual 510	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2113: istore 8
    //   2115: aload_1
    //   2116: ldc_w 370
    //   2119: invokevirtual 510	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2122: istore 9
    //   2124: aload_1
    //   2125: ldc_w 374
    //   2128: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2131: astore 5
    //   2133: aload_1
    //   2134: ldc_w 633
    //   2137: invokevirtual 510	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2140: istore 10
    //   2142: aload_0
    //   2143: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2146: invokevirtual 636	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/mobileqq/webview/swift/WebViewProvider;
    //   2149: astore_1
    //   2150: aload_1
    //   2151: instanceof 638
    //   2154: ifeq +22 -> 2176
    //   2157: aload_1
    //   2158: checkcast 638	com/tencent/mobileqq/richstatus/SignatureEditFragment
    //   2161: iload 6
    //   2163: iload 7
    //   2165: iload 8
    //   2167: iload 9
    //   2169: aload 5
    //   2171: iload 10
    //   2173: invokevirtual 641	com/tencent/mobileqq/richstatus/SignatureEditFragment:a	(IIIILjava/lang/String;I)V
    //   2176: aload_0
    //   2177: aload 16
    //   2179: iconst_1
    //   2180: anewarray 173	java/lang/String
    //   2183: dup
    //   2184: iconst_0
    //   2185: ldc 214
    //   2187: aastore
    //   2188: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2191: goto +1087 -> 3278
    //   2194: ldc_w 643
    //   2197: aload 4
    //   2199: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2202: ifeq +298 -> 2500
    //   2205: aload_0
    //   2206: aload 16
    //   2208: putfield 97	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mGetSigInfoCallback	Ljava/lang/String;
    //   2211: invokestatic 648	com/tencent/mobileqq/richstatus/SignatureManagerForTool:a	()Lcom/tencent/mobileqq/richstatus/SignatureManagerForTool;
    //   2214: getfield 651	com/tencent/mobileqq/richstatus/SignatureManagerForTool:a	Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   2217: ifnonnull +23 -> 2240
    //   2220: invokestatic 656	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   2223: ldc_w 658
    //   2226: getstatic 662	com/etrump/mixlayout/VasFontIPCModule:e	Ljava/lang/String;
    //   2229: aconst_null
    //   2230: aload_0
    //   2231: getfield 89	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:getSignatureCallback	Leipc/EIPCResultCallback;
    //   2234: invokevirtual 666	com/tencent/mobileqq/qipc/QIPCClientHelper:callServer	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Leipc/EIPCResultCallback;)V
    //   2237: goto +1041 -> 3278
    //   2240: invokestatic 648	com/tencent/mobileqq/richstatus/SignatureManagerForTool:a	()Lcom/tencent/mobileqq/richstatus/SignatureManagerForTool;
    //   2243: getfield 651	com/tencent/mobileqq/richstatus/SignatureManagerForTool:a	Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   2246: astore 5
    //   2248: new 103	org/json/JSONObject
    //   2251: dup
    //   2252: invokespecial 104	org/json/JSONObject:<init>	()V
    //   2255: astore_1
    //   2256: aload_1
    //   2257: ldc_w 627
    //   2260: aload 5
    //   2262: getfield 671	com/tencent/mobileqq/richstatus/RichStatus:tplId	I
    //   2265: invokevirtual 116	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2268: pop
    //   2269: aload_1
    //   2270: ldc_w 629
    //   2273: aload 5
    //   2275: getfield 673	com/tencent/mobileqq/richstatus/RichStatus:fontId	I
    //   2278: invokevirtual 116	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2281: pop
    //   2282: aload_1
    //   2283: ldc_w 631
    //   2286: aload 5
    //   2288: getfield 675	com/tencent/mobileqq/richstatus/RichStatus:fontType	I
    //   2291: invokevirtual 116	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2294: pop
    //   2295: aload_1
    //   2296: ldc_w 370
    //   2299: aload 5
    //   2301: getfield 677	com/tencent/mobileqq/richstatus/RichStatus:actionId	I
    //   2304: invokevirtual 116	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2307: pop
    //   2308: aload 5
    //   2310: getfield 679	com/tencent/mobileqq/richstatus/RichStatus:actionText	Ljava/lang/String;
    //   2313: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2316: ifne +158 -> 2474
    //   2319: aload_1
    //   2320: ldc_w 681
    //   2323: aload 5
    //   2325: getfield 679	com/tencent/mobileqq/richstatus/RichStatus:actionText	Ljava/lang/String;
    //   2328: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2331: pop
    //   2332: invokestatic 648	com/tencent/mobileqq/richstatus/SignatureManagerForTool:a	()Lcom/tencent/mobileqq/richstatus/SignatureManagerForTool;
    //   2335: aload 5
    //   2337: getfield 671	com/tencent/mobileqq/richstatus/RichStatus:tplId	I
    //   2340: invokevirtual 684	com/tencent/mobileqq/richstatus/SignatureManagerForTool:a	(I)Lcom/tencent/mobileqq/vas/SignatureTemplateInfo;
    //   2343: astore 13
    //   2345: aload 13
    //   2347: getfield 689	com/tencent/mobileqq/vas/SignatureTemplateInfo:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   2350: invokevirtual 693	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   2353: ifeq +137 -> 2490
    //   2356: aload 5
    //   2358: getfield 697	com/tencent/mobileqq/richstatus/RichStatus:mStickerInfos	Ljava/util/ArrayList;
    //   2361: ifnull +919 -> 3280
    //   2364: aload 5
    //   2366: getfield 697	com/tencent/mobileqq/richstatus/RichStatus:mStickerInfos	Ljava/util/ArrayList;
    //   2369: invokevirtual 698	java/util/ArrayList:isEmpty	()Z
    //   2372: ifeq +914 -> 3286
    //   2375: goto +905 -> 3280
    //   2378: aload_1
    //   2379: ldc_w 700
    //   2382: iload 6
    //   2384: invokevirtual 116	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2387: pop
    //   2388: new 103	org/json/JSONObject
    //   2391: dup
    //   2392: invokespecial 104	org/json/JSONObject:<init>	()V
    //   2395: astore 5
    //   2397: aload 5
    //   2399: ldc 106
    //   2401: iconst_0
    //   2402: invokevirtual 116	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2405: pop
    //   2406: aload 5
    //   2408: ldc 165
    //   2410: aload_1
    //   2411: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2414: pop
    //   2415: aload_0
    //   2416: aload_0
    //   2417: getfield 97	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mGetSigInfoCallback	Ljava/lang/String;
    //   2420: iconst_1
    //   2421: anewarray 173	java/lang/String
    //   2424: dup
    //   2425: iconst_0
    //   2426: aload 5
    //   2428: invokevirtual 174	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2431: aastore
    //   2432: invokevirtual 701	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2435: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2438: ifeq +840 -> 3278
    //   2441: ldc 34
    //   2443: iconst_2
    //   2444: new 60	java/lang/StringBuilder
    //   2447: dup
    //   2448: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   2451: ldc_w 703
    //   2454: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2457: aload 5
    //   2459: invokevirtual 174	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2462: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2465: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2468: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2471: goto +807 -> 3278
    //   2474: aload_1
    //   2475: ldc_w 681
    //   2478: aload 5
    //   2480: invokevirtual 706	com/tencent/mobileqq/richstatus/RichStatus:getPlainText	()Ljava/lang/String;
    //   2483: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2486: pop
    //   2487: goto -155 -> 2332
    //   2490: aload 13
    //   2492: getfield 709	com/tencent/mobileqq/vas/SignatureTemplateInfo:g	I
    //   2495: istore 6
    //   2497: goto -119 -> 2378
    //   2500: ldc_w 711
    //   2503: aload 4
    //   2505: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2508: ifeq +32 -> 2540
    //   2511: aload_0
    //   2512: aload_1
    //   2513: ldc_w 713
    //   2516: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2519: putfield 206	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mOpenFontCallback	Ljava/lang/String;
    //   2522: aload_0
    //   2523: aload 16
    //   2525: iconst_1
    //   2526: anewarray 173	java/lang/String
    //   2529: dup
    //   2530: iconst_0
    //   2531: ldc 214
    //   2533: aastore
    //   2534: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2537: goto +741 -> 3278
    //   2540: ldc_w 715
    //   2543: aload 4
    //   2545: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2548: ifeq +34 -> 2582
    //   2551: aload_0
    //   2552: aload 16
    //   2554: putfield 220	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mPublishCallback	Ljava/lang/String;
    //   2557: aload_0
    //   2558: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2561: invokevirtual 636	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/mobileqq/webview/swift/WebViewProvider;
    //   2564: astore_1
    //   2565: aload_1
    //   2566: instanceof 638
    //   2569: ifeq +709 -> 3278
    //   2572: aload_1
    //   2573: checkcast 638	com/tencent/mobileqq/richstatus/SignatureEditFragment
    //   2576: invokevirtual 717	com/tencent/mobileqq/richstatus/SignatureEditFragment:a	()V
    //   2579: goto +699 -> 3278
    //   2582: ldc_w 719
    //   2585: aload 4
    //   2587: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2590: ifeq +72 -> 2662
    //   2593: aload_0
    //   2594: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2597: invokevirtual 636	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/mobileqq/webview/swift/WebViewProvider;
    //   2600: astore_1
    //   2601: aload_1
    //   2602: instanceof 638
    //   2605: ifeq +18 -> 2623
    //   2608: aload_1
    //   2609: checkcast 638	com/tencent/mobileqq/richstatus/SignatureEditFragment
    //   2612: astore_1
    //   2613: invokestatic 648	com/tencent/mobileqq/richstatus/SignatureManagerForTool:a	()Lcom/tencent/mobileqq/richstatus/SignatureManagerForTool;
    //   2616: aload_1
    //   2617: getfield 720	com/tencent/mobileqq/richstatus/SignatureEditFragment:a	Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   2620: invokevirtual 724	com/tencent/mobileqq/richstatus/SignatureManagerForTool:b	(Lcom/tencent/mobileqq/richstatus/RichStatus;)V
    //   2623: aload_0
    //   2624: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2627: invokevirtual 279	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2630: aload_0
    //   2631: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2634: invokevirtual 448	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   2637: iconst_1
    //   2638: ldc_w 457
    //   2641: invokestatic 729	com/tencent/mobileqq/vas/signature/SignatureEditManager:a	(Landroid/app/Activity;Lcom/tencent/common/app/AppInterface;ILjava/lang/String;)V
    //   2644: aload_0
    //   2645: aload 16
    //   2647: iconst_1
    //   2648: anewarray 173	java/lang/String
    //   2651: dup
    //   2652: iconst_0
    //   2653: ldc 214
    //   2655: aastore
    //   2656: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2659: goto +619 -> 3278
    //   2662: ldc_w 731
    //   2665: aload 4
    //   2667: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2670: ifeq +40 -> 2710
    //   2673: aload_1
    //   2674: ldc_w 733
    //   2677: iconst_0
    //   2678: invokevirtual 736	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   2681: istore 12
    //   2683: aload_0
    //   2684: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2687: invokevirtual 636	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/mobileqq/webview/swift/WebViewProvider;
    //   2690: astore_1
    //   2691: aload_1
    //   2692: instanceof 638
    //   2695: ifeq +583 -> 3278
    //   2698: aload_1
    //   2699: checkcast 638	com/tencent/mobileqq/richstatus/SignatureEditFragment
    //   2702: iload 12
    //   2704: invokevirtual 739	com/tencent/mobileqq/richstatus/SignatureEditFragment:a	(Z)V
    //   2707: goto +571 -> 3278
    //   2710: ldc_w 741
    //   2713: aload 4
    //   2715: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2718: ifeq +95 -> 2813
    //   2721: aload_1
    //   2722: ldc_w 743
    //   2725: iconst_m1
    //   2726: invokevirtual 746	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2729: istore 6
    //   2731: aload_1
    //   2732: ldc_w 629
    //   2735: iconst_m1
    //   2736: invokevirtual 746	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2739: istore 7
    //   2741: new 108	android/os/Bundle
    //   2744: dup
    //   2745: invokespecial 465	android/os/Bundle:<init>	()V
    //   2748: astore 5
    //   2750: aload 5
    //   2752: ldc_w 748
    //   2755: aload_1
    //   2756: ldc 159
    //   2758: ldc_w 750
    //   2761: invokevirtual 752	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2764: invokevirtual 361	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2767: aload_0
    //   2768: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2771: invokevirtual 279	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2774: aload_0
    //   2775: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2778: invokevirtual 448	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   2781: iconst_0
    //   2782: ldc_w 754
    //   2785: iconst_m1
    //   2786: iload 6
    //   2788: iload 7
    //   2790: aload 5
    //   2792: invokestatic 757	com/tencent/mobileqq/vas/signature/SignatureEditManager:a	(Landroid/app/Activity;Lcom/tencent/common/app/AppInterface;ILjava/lang/String;IIILandroid/os/Bundle;)V
    //   2795: aload_0
    //   2796: aload 16
    //   2798: iconst_1
    //   2799: anewarray 173	java/lang/String
    //   2802: dup
    //   2803: iconst_0
    //   2804: ldc 214
    //   2806: aastore
    //   2807: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2810: goto +468 -> 3278
    //   2813: ldc_w 759
    //   2816: aload 4
    //   2818: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2821: ifeq +32 -> 2853
    //   2824: aload_0
    //   2825: aload_1
    //   2826: ldc_w 761
    //   2829: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2832: putfield 232	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mContentChangeCallback	Ljava/lang/String;
    //   2835: aload_0
    //   2836: aload 16
    //   2838: iconst_1
    //   2839: anewarray 173	java/lang/String
    //   2842: dup
    //   2843: iconst_0
    //   2844: ldc 214
    //   2846: aastore
    //   2847: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2850: goto +428 -> 3278
    //   2853: ldc_w 763
    //   2856: aload 4
    //   2858: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2861: ifeq +76 -> 2937
    //   2864: aload_0
    //   2865: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2868: invokevirtual 636	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/mobileqq/webview/swift/WebViewProvider;
    //   2871: astore_1
    //   2872: aload_1
    //   2873: instanceof 638
    //   2876: ifeq +42 -> 2918
    //   2879: aload_0
    //   2880: aload 16
    //   2882: iconst_1
    //   2883: anewarray 173	java/lang/String
    //   2886: dup
    //   2887: iconst_0
    //   2888: ldc_w 765
    //   2891: iconst_1
    //   2892: anewarray 245	java/lang/Object
    //   2895: dup
    //   2896: iconst_0
    //   2897: aload_1
    //   2898: checkcast 638	com/tencent/mobileqq/richstatus/SignatureEditFragment
    //   2901: invokevirtual 767	com/tencent/mobileqq/richstatus/SignatureEditFragment:a	()I
    //   2904: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2907: aastore
    //   2908: invokestatic 255	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2911: aastore
    //   2912: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2915: goto +363 -> 3278
    //   2918: aload_0
    //   2919: aload 16
    //   2921: iconst_1
    //   2922: anewarray 173	java/lang/String
    //   2925: dup
    //   2926: iconst_0
    //   2927: ldc_w 769
    //   2930: aastore
    //   2931: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2934: goto +344 -> 3278
    //   2937: ldc_w 771
    //   2940: aload 4
    //   2942: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2945: ifeq +83 -> 3028
    //   2948: aload_1
    //   2949: ldc_w 773
    //   2952: invokevirtual 510	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2955: istore 6
    //   2957: aload_1
    //   2958: ldc_w 775
    //   2961: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2964: astore_1
    //   2965: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2968: ifeq +31 -> 2999
    //   2971: ldc 34
    //   2973: iconst_2
    //   2974: ldc_w 777
    //   2977: iconst_2
    //   2978: anewarray 245	java/lang/Object
    //   2981: dup
    //   2982: iconst_0
    //   2983: iload 6
    //   2985: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2988: aastore
    //   2989: dup
    //   2990: iconst_1
    //   2991: aload_1
    //   2992: aastore
    //   2993: invokestatic 255	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2996: invokestatic 258	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2999: aload_0
    //   3000: iload 6
    //   3002: putfield 239	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mSelectTagId	I
    //   3005: aload_0
    //   3006: aload_1
    //   3007: putfield 241	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mSelectTagText	Ljava/lang/String;
    //   3010: aload_0
    //   3011: aload 16
    //   3013: iconst_1
    //   3014: anewarray 173	java/lang/String
    //   3017: dup
    //   3018: iconst_0
    //   3019: ldc 214
    //   3021: aastore
    //   3022: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3025: goto +253 -> 3278
    //   3028: ldc_w 779
    //   3031: aload 4
    //   3033: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3036: ifeq +242 -> 3278
    //   3039: aload_1
    //   3040: ldc_w 773
    //   3043: invokevirtual 510	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   3046: istore 6
    //   3048: aload_1
    //   3049: ldc_w 775
    //   3052: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3055: astore 5
    //   3057: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3060: ifeq +32 -> 3092
    //   3063: ldc 34
    //   3065: iconst_2
    //   3066: ldc_w 781
    //   3069: iconst_2
    //   3070: anewarray 245	java/lang/Object
    //   3073: dup
    //   3074: iconst_0
    //   3075: iload 6
    //   3077: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3080: aastore
    //   3081: dup
    //   3082: iconst_1
    //   3083: aload 5
    //   3085: aastore
    //   3086: invokestatic 255	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3089: invokestatic 258	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3092: aload 5
    //   3094: invokestatic 784	com/tencent/mobileqq/richstatus/topic/TopicUtil:a	(Ljava/lang/String;)Z
    //   3097: ifeq +97 -> 3194
    //   3100: iload 6
    //   3102: iflt +92 -> 3194
    //   3105: new 108	android/os/Bundle
    //   3108: dup
    //   3109: invokespecial 465	android/os/Bundle:<init>	()V
    //   3112: astore_1
    //   3113: aload_1
    //   3114: ldc_w 266
    //   3117: aload 5
    //   3119: invokevirtual 361	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3122: aload_1
    //   3123: ldc_w 260
    //   3126: iload 6
    //   3128: invokevirtual 355	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3131: aload_1
    //   3132: ldc_w 786
    //   3135: iconst_1
    //   3136: invokevirtual 355	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3139: aload_0
    //   3140: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3143: invokevirtual 448	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   3146: astore 5
    //   3148: aload_0
    //   3149: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3152: invokevirtual 279	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   3155: astore 13
    //   3157: aload 13
    //   3159: ifnull +17 -> 3176
    //   3162: aload 5
    //   3164: ifnull +12 -> 3176
    //   3167: aload 13
    //   3169: aconst_null
    //   3170: aconst_null
    //   3171: aload_1
    //   3172: iconst_m1
    //   3173: invokestatic 791	com/tencent/mobileqq/richstatus/SignTextEditFragment:a	(Landroid/app/Activity;Lcom/tencent/mobileqq/richstatus/RichStatus;Ljava/lang/String;Landroid/os/Bundle;I)V
    //   3176: aload_0
    //   3177: aload 16
    //   3179: iconst_1
    //   3180: anewarray 173	java/lang/String
    //   3183: dup
    //   3184: iconst_0
    //   3185: ldc 214
    //   3187: aastore
    //   3188: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3191: goto +87 -> 3278
    //   3194: aload_0
    //   3195: aload 16
    //   3197: iconst_1
    //   3198: anewarray 173	java/lang/String
    //   3201: dup
    //   3202: iconst_0
    //   3203: ldc 198
    //   3205: aastore
    //   3206: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3209: goto +69 -> 3278
    //   3212: astore_1
    //   3213: goto -2538 -> 675
    //   3216: astore_1
    //   3217: goto -1348 -> 1869
    //   3220: astore_1
    //   3221: iconst_1
    //   3222: istore 7
    //   3224: goto -1439 -> 1785
    //   3227: astore_1
    //   3228: iconst_1
    //   3229: istore 7
    //   3231: goto -1579 -> 1652
    //   3234: astore_1
    //   3235: goto -1739 -> 1496
    //   3238: astore 5
    //   3240: aload_1
    //   3241: astore 13
    //   3243: aload 5
    //   3245: astore_1
    //   3246: aload 14
    //   3248: astore 5
    //   3250: goto -1528 -> 1722
    //   3253: astore 14
    //   3255: aload_1
    //   3256: astore 13
    //   3258: aload 14
    //   3260: astore_1
    //   3261: goto -1539 -> 1722
    //   3264: astore 14
    //   3266: goto -1696 -> 1570
    //   3269: astore 14
    //   3271: aload 5
    //   3273: astore 15
    //   3275: goto -1705 -> 1570
    //   3278: iconst_1
    //   3279: ireturn
    //   3280: iconst_0
    //   3281: istore 6
    //   3283: goto -905 -> 2378
    //   3286: iconst_1
    //   3287: istore 6
    //   3289: goto -911 -> 2378
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3292	0	this	SignJsPlugin
    //   0	3292	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	3292	2	paramString1	String
    //   0	3292	3	paramString2	String
    //   0	3292	4	paramString3	String
    //   0	3292	5	paramVarArgs	String[]
    //   214	3074	6	i	int
    //   1414	1816	7	j	int
    //   1064	1102	8	k	int
    //   1055	1113	9	m	int
    //   1058	1114	10	n	int
    //   1061	869	11	i1	int
    //   1162	1541	12	bool	boolean
    //   232	3025	13	localObject1	Object
    //   241	870	14	str1	String
    //   1565	1682	14	localIOException1	java.io.IOException
    //   3253	6	14	localObject2	Object
    //   3264	1	14	localIOException2	java.io.IOException
    //   3269	1	14	localIOException3	java.io.IOException
    //   250	3024	15	localObject3	Object
    //   135	3061	16	str2	String
    //   1104	464	17	localObject4	Object
    //   1107	112	18	localObject5	Object
    //   967	937	19	str3	String
    //   1099	151	20	arrayOfByte	byte[]
    //   1133	25	21	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   137	154	670	java/lang/Throwable
    //   156	192	670	java/lang/Throwable
    //   192	207	670	java/lang/Throwable
    //   209	328	670	java/lang/Throwable
    //   333	405	670	java/lang/Throwable
    //   405	413	670	java/lang/Throwable
    //   417	438	670	java/lang/Throwable
    //   438	463	670	java/lang/Throwable
    //   466	518	670	java/lang/Throwable
    //   521	576	670	java/lang/Throwable
    //   576	608	670	java/lang/Throwable
    //   608	642	670	java/lang/Throwable
    //   642	667	670	java/lang/Throwable
    //   761	803	670	java/lang/Throwable
    //   806	858	670	java/lang/Throwable
    //   860	937	670	java/lang/Throwable
    //   940	976	670	java/lang/Throwable
    //   986	994	670	java/lang/Throwable
    //   999	1041	670	java/lang/Throwable
    //   1041	1051	670	java/lang/Throwable
    //   1443	1467	670	java/lang/Throwable
    //   1467	1477	670	java/lang/Throwable
    //   1528	1552	670	java/lang/Throwable
    //   1552	1562	670	java/lang/Throwable
    //   1684	1708	670	java/lang/Throwable
    //   1708	1718	670	java/lang/Throwable
    //   1817	1841	670	java/lang/Throwable
    //   1841	1851	670	java/lang/Throwable
    //   1879	1903	670	java/lang/Throwable
    //   1903	1913	670	java/lang/Throwable
    //   1913	1915	670	java/lang/Throwable
    //   1989	2025	670	java/lang/Throwable
    //   2028	2054	670	java/lang/Throwable
    //   2054	2074	670	java/lang/Throwable
    //   2077	2176	670	java/lang/Throwable
    //   2176	2191	670	java/lang/Throwable
    //   2194	2237	670	java/lang/Throwable
    //   2240	2332	670	java/lang/Throwable
    //   2332	2375	670	java/lang/Throwable
    //   2378	2471	670	java/lang/Throwable
    //   2474	2487	670	java/lang/Throwable
    //   2490	2497	670	java/lang/Throwable
    //   2500	2537	670	java/lang/Throwable
    //   2540	2579	670	java/lang/Throwable
    //   2582	2623	670	java/lang/Throwable
    //   2623	2659	670	java/lang/Throwable
    //   2662	2707	670	java/lang/Throwable
    //   2710	2810	670	java/lang/Throwable
    //   2813	2850	670	java/lang/Throwable
    //   2853	2915	670	java/lang/Throwable
    //   2918	2934	670	java/lang/Throwable
    //   2937	2999	670	java/lang/Throwable
    //   2999	3025	670	java/lang/Throwable
    //   3028	3092	670	java/lang/Throwable
    //   3092	3100	670	java/lang/Throwable
    //   3105	3157	670	java/lang/Throwable
    //   3167	3176	670	java/lang/Throwable
    //   3176	3191	670	java/lang/Throwable
    //   3194	3209	670	java/lang/Throwable
    //   1268	1273	1480	java/io/IOException
    //   1281	1285	1480	java/io/IOException
    //   1289	1295	1480	java/io/IOException
    //   1299	1309	1480	java/io/IOException
    //   1070	1076	1492	java/lang/IllegalArgumentException
    //   1080	1089	1492	java/lang/IllegalArgumentException
    //   1093	1101	1492	java/lang/IllegalArgumentException
    //   1268	1273	1492	java/lang/IllegalArgumentException
    //   1281	1285	1492	java/lang/IllegalArgumentException
    //   1289	1295	1492	java/lang/IllegalArgumentException
    //   1299	1309	1492	java/lang/IllegalArgumentException
    //   1313	1323	1492	java/lang/IllegalArgumentException
    //   1327	1337	1492	java/lang/IllegalArgumentException
    //   1341	1349	1492	java/lang/IllegalArgumentException
    //   1353	1362	1492	java/lang/IllegalArgumentException
    //   1366	1372	1492	java/lang/IllegalArgumentException
    //   1376	1410	1492	java/lang/IllegalArgumentException
    //   1485	1489	1492	java/lang/IllegalArgumentException
    //   1591	1596	1492	java/lang/IllegalArgumentException
    //   1604	1608	1492	java/lang/IllegalArgumentException
    //   1612	1618	1492	java/lang/IllegalArgumentException
    //   1622	1632	1492	java/lang/IllegalArgumentException
    //   1640	1644	1492	java/lang/IllegalArgumentException
    //   1731	1736	1492	java/lang/IllegalArgumentException
    //   1745	1750	1492	java/lang/IllegalArgumentException
    //   1754	1760	1492	java/lang/IllegalArgumentException
    //   1764	1774	1492	java/lang/IllegalArgumentException
    //   1778	1780	1492	java/lang/IllegalArgumentException
    //   1860	1865	1492	java/lang/IllegalArgumentException
    //   1923	1929	1492	java/lang/IllegalArgumentException
    //   1933	1982	1492	java/lang/IllegalArgumentException
    //   1122	1135	1565	java/io/IOException
    //   1142	1150	1565	java/io/IOException
    //   1157	1164	1565	java/io/IOException
    //   1171	1177	1565	java/io/IOException
    //   1184	1218	1565	java/io/IOException
    //   1225	1237	1565	java/io/IOException
    //   1591	1596	1635	java/io/IOException
    //   1604	1608	1635	java/io/IOException
    //   1612	1618	1635	java/io/IOException
    //   1622	1632	1635	java/io/IOException
    //   1070	1076	1647	java/lang/Exception
    //   1080	1089	1647	java/lang/Exception
    //   1093	1101	1647	java/lang/Exception
    //   1268	1273	1647	java/lang/Exception
    //   1281	1285	1647	java/lang/Exception
    //   1289	1295	1647	java/lang/Exception
    //   1299	1309	1647	java/lang/Exception
    //   1313	1323	1647	java/lang/Exception
    //   1327	1337	1647	java/lang/Exception
    //   1341	1349	1647	java/lang/Exception
    //   1353	1362	1647	java/lang/Exception
    //   1366	1372	1647	java/lang/Exception
    //   1376	1410	1647	java/lang/Exception
    //   1485	1489	1647	java/lang/Exception
    //   1591	1596	1647	java/lang/Exception
    //   1604	1608	1647	java/lang/Exception
    //   1612	1618	1647	java/lang/Exception
    //   1622	1632	1647	java/lang/Exception
    //   1640	1644	1647	java/lang/Exception
    //   1731	1736	1647	java/lang/Exception
    //   1745	1750	1647	java/lang/Exception
    //   1754	1760	1647	java/lang/Exception
    //   1764	1774	1647	java/lang/Exception
    //   1778	1780	1647	java/lang/Exception
    //   1860	1865	1647	java/lang/Exception
    //   1923	1929	1647	java/lang/Exception
    //   1933	1982	1647	java/lang/Exception
    //   1122	1135	1721	finally
    //   1142	1150	1721	finally
    //   1157	1164	1721	finally
    //   1171	1177	1721	finally
    //   1184	1218	1721	finally
    //   1225	1237	1721	finally
    //   1577	1582	1721	finally
    //   1070	1076	1780	java/lang/OutOfMemoryError
    //   1080	1089	1780	java/lang/OutOfMemoryError
    //   1093	1101	1780	java/lang/OutOfMemoryError
    //   1268	1273	1780	java/lang/OutOfMemoryError
    //   1281	1285	1780	java/lang/OutOfMemoryError
    //   1289	1295	1780	java/lang/OutOfMemoryError
    //   1299	1309	1780	java/lang/OutOfMemoryError
    //   1313	1323	1780	java/lang/OutOfMemoryError
    //   1327	1337	1780	java/lang/OutOfMemoryError
    //   1341	1349	1780	java/lang/OutOfMemoryError
    //   1353	1362	1780	java/lang/OutOfMemoryError
    //   1366	1372	1780	java/lang/OutOfMemoryError
    //   1376	1410	1780	java/lang/OutOfMemoryError
    //   1485	1489	1780	java/lang/OutOfMemoryError
    //   1591	1596	1780	java/lang/OutOfMemoryError
    //   1604	1608	1780	java/lang/OutOfMemoryError
    //   1612	1618	1780	java/lang/OutOfMemoryError
    //   1622	1632	1780	java/lang/OutOfMemoryError
    //   1640	1644	1780	java/lang/OutOfMemoryError
    //   1731	1736	1780	java/lang/OutOfMemoryError
    //   1745	1750	1780	java/lang/OutOfMemoryError
    //   1754	1760	1780	java/lang/OutOfMemoryError
    //   1764	1774	1780	java/lang/OutOfMemoryError
    //   1778	1780	1780	java/lang/OutOfMemoryError
    //   1860	1865	1780	java/lang/OutOfMemoryError
    //   1923	1929	1780	java/lang/OutOfMemoryError
    //   1933	1982	1780	java/lang/OutOfMemoryError
    //   1731	1736	1854	java/io/IOException
    //   1745	1750	1854	java/io/IOException
    //   1754	1760	1854	java/io/IOException
    //   1764	1774	1854	java/io/IOException
    //   1070	1076	1868	finally
    //   1080	1089	1868	finally
    //   1093	1101	1868	finally
    //   1268	1273	1868	finally
    //   1281	1285	1868	finally
    //   1289	1295	1868	finally
    //   1299	1309	1868	finally
    //   1313	1323	1868	finally
    //   1327	1337	1868	finally
    //   1341	1349	1868	finally
    //   1353	1362	1868	finally
    //   1366	1372	1868	finally
    //   1376	1410	1868	finally
    //   1485	1489	1868	finally
    //   1591	1596	1868	finally
    //   1604	1608	1868	finally
    //   1612	1618	1868	finally
    //   1622	1632	1868	finally
    //   1640	1644	1868	finally
    //   1656	1666	1868	finally
    //   1670	1674	1868	finally
    //   1731	1736	1868	finally
    //   1745	1750	1868	finally
    //   1754	1760	1868	finally
    //   1764	1774	1868	finally
    //   1778	1780	1868	finally
    //   1789	1799	1868	finally
    //   1803	1807	1868	finally
    //   1860	1865	1868	finally
    //   1923	1929	1868	finally
    //   1933	1982	1868	finally
    //   82	87	3212	java/lang/Throwable
    //   93	128	3212	java/lang/Throwable
    //   128	137	3212	java/lang/Throwable
    //   1416	1430	3216	finally
    //   1500	1510	3216	finally
    //   1514	1518	3216	finally
    //   1416	1430	3220	java/lang/OutOfMemoryError
    //   1416	1430	3227	java/lang/Exception
    //   1416	1430	3234	java/lang/IllegalArgumentException
    //   1237	1247	3238	finally
    //   1247	1259	3253	finally
    //   1237	1247	3264	java/io/IOException
    //   1247	1259	3269	java/io/IOException
  }
  
  /* Error */
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iload_2
    //   3: iload_3
    //   4: invokespecial 797	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:onActivityResult	(Landroid/content/Intent;BI)V
    //   7: aconst_null
    //   8: astore 9
    //   10: aload_1
    //   11: ifnonnull +13 -> 24
    //   14: ldc 34
    //   16: iconst_1
    //   17: ldc_w 799
    //   20: invokestatic 328	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: return
    //   24: aload 9
    //   26: astore 8
    //   28: aload_1
    //   29: invokevirtual 803	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   32: ifnonnull +51 -> 83
    //   35: aload 9
    //   37: astore 8
    //   39: ldc 34
    //   41: iconst_1
    //   42: ldc_w 805
    //   45: invokestatic 328	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: return
    //   49: astore_1
    //   50: ldc 34
    //   52: iconst_1
    //   53: ldc_w 807
    //   56: invokestatic 328	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: aload 8
    //   61: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   64: ifne -41 -> 23
    //   67: aload_0
    //   68: aload 8
    //   70: iconst_1
    //   71: anewarray 173	java/lang/String
    //   74: dup
    //   75: iconst_0
    //   76: ldc 198
    //   78: aastore
    //   79: invokevirtual 701	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   82: return
    //   83: aload 9
    //   85: astore 8
    //   87: new 103	org/json/JSONObject
    //   90: dup
    //   91: invokespecial 104	org/json/JSONObject:<init>	()V
    //   94: astore 12
    //   96: iload_2
    //   97: bipush 100
    //   99: if_icmpne +277 -> 376
    //   102: aload 9
    //   104: astore 8
    //   106: aload_0
    //   107: getfield 443	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mLocationCallback	Ljava/lang/String;
    //   110: astore 9
    //   112: aload 9
    //   114: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   117: ifeq +13 -> 130
    //   120: ldc 34
    //   122: iconst_1
    //   123: ldc_w 809
    //   126: invokestatic 328	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: return
    //   130: aload_1
    //   131: ldc_w 811
    //   134: invokevirtual 815	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   137: checkcast 817	cooperation/qzone/LbsDataV2$PoiInfo
    //   140: astore_1
    //   141: aload_1
    //   142: ifnonnull +116 -> 258
    //   145: ldc 34
    //   147: iconst_1
    //   148: ldc_w 819
    //   151: invokestatic 328	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: aload 12
    //   156: ldc 106
    //   158: bipush 101
    //   160: invokevirtual 116	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   163: pop
    //   164: aload_0
    //   165: aload 9
    //   167: iconst_1
    //   168: anewarray 173	java/lang/String
    //   171: dup
    //   172: iconst_0
    //   173: aload 12
    //   175: invokevirtual 174	org/json/JSONObject:toString	()Ljava/lang/String;
    //   178: aastore
    //   179: invokevirtual 701	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   182: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   185: ifeq -162 -> 23
    //   188: ldc 34
    //   190: iconst_2
    //   191: new 60	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   198: ldc_w 821
    //   201: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload 12
    //   206: invokevirtual 174	org/json/JSONObject:toString	()Ljava/lang/String;
    //   209: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: return
    //   219: astore_1
    //   220: aload 9
    //   222: astore 8
    //   224: ldc 34
    //   226: iconst_1
    //   227: ldc_w 823
    //   230: aload_1
    //   231: invokestatic 196	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   234: aload 8
    //   236: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   239: ifne -216 -> 23
    //   242: aload_0
    //   243: aload 8
    //   245: iconst_1
    //   246: anewarray 173	java/lang/String
    //   249: dup
    //   250: iconst_0
    //   251: ldc 198
    //   253: aastore
    //   254: invokevirtual 701	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   257: return
    //   258: aload_0
    //   259: aload_1
    //   260: getfield 826	cooperation/qzone/LbsDataV2$PoiInfo:poiId	Ljava/lang/String;
    //   263: putfield 445	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mCachePoiId	Ljava/lang/String;
    //   266: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq +32 -> 301
    //   272: ldc 34
    //   274: iconst_2
    //   275: new 60	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   282: ldc_w 464
    //   285: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload_0
    //   289: getfield 445	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mCachePoiId	Ljava/lang/String;
    //   292: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   301: aload 12
    //   303: ldc 106
    //   305: iconst_0
    //   306: invokevirtual 116	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   309: pop
    //   310: new 103	org/json/JSONObject
    //   313: dup
    //   314: invokespecial 104	org/json/JSONObject:<init>	()V
    //   317: astore 8
    //   319: aload_1
    //   320: getfield 829	cooperation/qzone/LbsDataV2$PoiInfo:poiName	Ljava/lang/String;
    //   323: ldc_w 830
    //   326: invokestatic 599	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   329: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   332: ifne +29 -> 361
    //   335: aload 8
    //   337: ldc_w 342
    //   340: aload_1
    //   341: getfield 829	cooperation/qzone/LbsDataV2$PoiInfo:poiName	Ljava/lang/String;
    //   344: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   347: pop
    //   348: aload 12
    //   350: ldc 165
    //   352: aload 8
    //   354: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   357: pop
    //   358: goto -194 -> 164
    //   361: aload 8
    //   363: ldc_w 342
    //   366: ldc_w 457
    //   369: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   372: pop
    //   373: goto -25 -> 348
    //   376: iload_2
    //   377: bipush 101
    //   379: if_icmpne -356 -> 23
    //   382: aload 9
    //   384: astore 8
    //   386: aload_0
    //   387: getfield 495	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mActionCallback	Ljava/lang/String;
    //   390: astore 9
    //   392: aload 9
    //   394: astore 8
    //   396: aload 9
    //   398: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   401: ifeq +17 -> 418
    //   404: aload 9
    //   406: astore 8
    //   408: ldc 34
    //   410: iconst_1
    //   411: ldc_w 832
    //   414: invokestatic 328	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: return
    //   418: aload 9
    //   420: astore 8
    //   422: aload_1
    //   423: ldc 17
    //   425: lconst_0
    //   426: invokevirtual 836	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   429: lstore 4
    //   431: aload 9
    //   433: astore 8
    //   435: aload_1
    //   436: ldc 20
    //   438: invokevirtual 839	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   441: astore 10
    //   443: aload 10
    //   445: ifnonnull +340 -> 785
    //   448: ldc_w 457
    //   451: astore 10
    //   453: aload 9
    //   455: astore 8
    //   457: aload_1
    //   458: ldc 23
    //   460: lconst_0
    //   461: invokevirtual 836	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   464: lstore 6
    //   466: aload 9
    //   468: astore 8
    //   470: aload_1
    //   471: ldc 26
    //   473: invokevirtual 839	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   476: astore 11
    //   478: aload 11
    //   480: astore_1
    //   481: aload 11
    //   483: ifnonnull +7 -> 490
    //   486: ldc_w 457
    //   489: astore_1
    //   490: lload 4
    //   492: lconst_0
    //   493: lcmp
    //   494: ifne +84 -> 578
    //   497: aload 9
    //   499: astore 8
    //   501: aload 12
    //   503: ldc 106
    //   505: bipush 101
    //   507: invokevirtual 116	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   510: pop
    //   511: aload 9
    //   513: astore 8
    //   515: aload_0
    //   516: aload 9
    //   518: iconst_1
    //   519: anewarray 173	java/lang/String
    //   522: dup
    //   523: iconst_0
    //   524: aload 12
    //   526: invokevirtual 174	org/json/JSONObject:toString	()Ljava/lang/String;
    //   529: aastore
    //   530: invokevirtual 701	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   533: aload 9
    //   535: astore 8
    //   537: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   540: ifeq -517 -> 23
    //   543: aload 9
    //   545: astore 8
    //   547: ldc 34
    //   549: iconst_2
    //   550: new 60	java/lang/StringBuilder
    //   553: dup
    //   554: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   557: ldc_w 841
    //   560: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: aload 12
    //   565: invokevirtual 174	org/json/JSONObject:toString	()Ljava/lang/String;
    //   568: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   577: return
    //   578: aload 9
    //   580: astore 8
    //   582: new 103	org/json/JSONObject
    //   585: dup
    //   586: invokespecial 104	org/json/JSONObject:<init>	()V
    //   589: astore 11
    //   591: aload 9
    //   593: astore 8
    //   595: new 103	org/json/JSONObject
    //   598: dup
    //   599: invokespecial 104	org/json/JSONObject:<init>	()V
    //   602: astore 13
    //   604: aload 9
    //   606: astore 8
    //   608: aload 13
    //   610: ldc_w 370
    //   613: lload 4
    //   615: invokestatic 846	java/lang/Long:toString	(J)Ljava/lang/String;
    //   618: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   621: pop
    //   622: aload 9
    //   624: astore 8
    //   626: aload 13
    //   628: ldc_w 374
    //   631: aload 10
    //   633: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   636: pop
    //   637: aload 9
    //   639: astore 8
    //   641: aload 13
    //   643: ldc_w 378
    //   646: lload 6
    //   648: invokestatic 846	java/lang/Long:toString	(J)Ljava/lang/String;
    //   651: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   654: pop
    //   655: aload 9
    //   657: astore 8
    //   659: aload 13
    //   661: ldc_w 382
    //   664: aload_1
    //   665: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   668: pop
    //   669: aload 9
    //   671: astore 8
    //   673: aload 11
    //   675: ldc_w 363
    //   678: aload 13
    //   680: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   683: pop
    //   684: aload 9
    //   686: astore 8
    //   688: aload 12
    //   690: ldc 106
    //   692: iconst_0
    //   693: invokevirtual 116	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   696: pop
    //   697: aload 9
    //   699: astore 8
    //   701: aload 12
    //   703: ldc 165
    //   705: aload 11
    //   707: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   710: pop
    //   711: aload 9
    //   713: astore 8
    //   715: aload_0
    //   716: aload 9
    //   718: iconst_1
    //   719: anewarray 173	java/lang/String
    //   722: dup
    //   723: iconst_0
    //   724: aload 12
    //   726: invokevirtual 174	org/json/JSONObject:toString	()Ljava/lang/String;
    //   729: aastore
    //   730: invokevirtual 701	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   733: aload 9
    //   735: astore 8
    //   737: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   740: ifeq -717 -> 23
    //   743: aload 9
    //   745: astore 8
    //   747: ldc 34
    //   749: iconst_2
    //   750: new 60	java/lang/StringBuilder
    //   753: dup
    //   754: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   757: ldc_w 841
    //   760: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: aload 12
    //   765: invokevirtual 174	org/json/JSONObject:toString	()Ljava/lang/String;
    //   768: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   774: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   777: return
    //   778: astore_1
    //   779: aconst_null
    //   780: astore 8
    //   782: goto -558 -> 224
    //   785: goto -332 -> 453
    //   788: astore_1
    //   789: aload 9
    //   791: astore 8
    //   793: goto -743 -> 50
    //   796: astore_1
    //   797: aload 9
    //   799: astore 8
    //   801: goto -577 -> 224
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	804	0	this	SignJsPlugin
    //   0	804	1	paramIntent	Intent
    //   0	804	2	paramByte	byte
    //   0	804	3	paramInt	int
    //   429	185	4	l1	long
    //   464	183	6	l2	long
    //   26	774	8	localObject1	Object
    //   8	790	9	str1	String
    //   441	191	10	str2	String
    //   476	230	11	localObject2	Object
    //   94	670	12	localJSONObject1	JSONObject
    //   602	77	13	localJSONObject2	JSONObject
    // Exception table:
    //   from	to	target	type
    //   28	35	49	java/lang/OutOfMemoryError
    //   39	48	49	java/lang/OutOfMemoryError
    //   87	96	49	java/lang/OutOfMemoryError
    //   106	112	49	java/lang/OutOfMemoryError
    //   386	392	49	java/lang/OutOfMemoryError
    //   396	404	49	java/lang/OutOfMemoryError
    //   408	417	49	java/lang/OutOfMemoryError
    //   422	431	49	java/lang/OutOfMemoryError
    //   435	443	49	java/lang/OutOfMemoryError
    //   457	466	49	java/lang/OutOfMemoryError
    //   470	478	49	java/lang/OutOfMemoryError
    //   501	511	49	java/lang/OutOfMemoryError
    //   515	533	49	java/lang/OutOfMemoryError
    //   537	543	49	java/lang/OutOfMemoryError
    //   547	577	49	java/lang/OutOfMemoryError
    //   582	591	49	java/lang/OutOfMemoryError
    //   595	604	49	java/lang/OutOfMemoryError
    //   608	622	49	java/lang/OutOfMemoryError
    //   626	637	49	java/lang/OutOfMemoryError
    //   641	655	49	java/lang/OutOfMemoryError
    //   659	669	49	java/lang/OutOfMemoryError
    //   673	684	49	java/lang/OutOfMemoryError
    //   688	697	49	java/lang/OutOfMemoryError
    //   701	711	49	java/lang/OutOfMemoryError
    //   715	733	49	java/lang/OutOfMemoryError
    //   737	743	49	java/lang/OutOfMemoryError
    //   747	777	49	java/lang/OutOfMemoryError
    //   112	129	219	org/json/JSONException
    //   130	141	219	org/json/JSONException
    //   145	164	219	org/json/JSONException
    //   164	218	219	org/json/JSONException
    //   258	301	219	org/json/JSONException
    //   301	348	219	org/json/JSONException
    //   348	358	219	org/json/JSONException
    //   361	373	219	org/json/JSONException
    //   28	35	778	org/json/JSONException
    //   39	48	778	org/json/JSONException
    //   87	96	778	org/json/JSONException
    //   106	112	778	org/json/JSONException
    //   386	392	778	org/json/JSONException
    //   112	129	788	java/lang/OutOfMemoryError
    //   130	141	788	java/lang/OutOfMemoryError
    //   145	164	788	java/lang/OutOfMemoryError
    //   164	218	788	java/lang/OutOfMemoryError
    //   258	301	788	java/lang/OutOfMemoryError
    //   301	348	788	java/lang/OutOfMemoryError
    //   348	358	788	java/lang/OutOfMemoryError
    //   361	373	788	java/lang/OutOfMemoryError
    //   396	404	796	org/json/JSONException
    //   408	417	796	org/json/JSONException
    //   422	431	796	org/json/JSONException
    //   435	443	796	org/json/JSONException
    //   457	466	796	org/json/JSONException
    //   470	478	796	org/json/JSONException
    //   501	511	796	org/json/JSONException
    //   515	533	796	org/json/JSONException
    //   537	543	796	org/json/JSONException
    //   547	577	796	org/json/JSONException
    //   582	591	796	org/json/JSONException
    //   595	604	796	org/json/JSONException
    //   608	622	796	org/json/JSONException
    //   626	637	796	org/json/JSONException
    //   641	655	796	org/json/JSONException
    //   659	669	796	org/json/JSONException
    //   673	684	796	org/json/JSONException
    //   688	697	796	org/json/JSONException
    //   701	711	796	org/json/JSONException
    //   715	733	796	org/json/JSONException
    //   737	743	796	org/json/JSONException
    //   747	777	796	org/json/JSONException
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.mReqBundle = new Bundle();
    AppInterface localAppInterface = this.mRuntime.a();
    if ((localAppInterface instanceof BrowserAppInterface)) {
      this.browserApp = ((BrowserAppInterface)localAppInterface);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("SignJsPlugin", 2, "ERROR!!! ChatFont market is not running in web process!");
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    String str2;
    String str1;
    JSONObject localJSONObject;
    do
    {
      do
      {
        return;
      } while (paramBundle.getInt("respkey", 0) != this.mOnRemoteResp.key);
      str2 = paramBundle.getString("cmd");
      str1 = paramBundle.getString("callbackid");
      try
      {
        paramBundle = paramBundle.getBundle("response");
        if (paramBundle == null)
        {
          QLog.e("SignJsPlugin", 1, "onResponse error no bundle");
          super.callJs(str1, new String[] { "{\"result\": -1}" });
          return;
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e("SignJsPlugin", 1, "onResponse error: ", paramBundle);
        super.callJs(str1, new String[] { "{\"result\": -1}" });
        return;
      }
      localJSONObject = new JSONObject();
      if ("ipc_signature_setordelete".equals(str2))
      {
        handleChangeStatusCallback(paramBundle, str1);
        return;
      }
      if ("ipc_signature_setlike".equals(str2))
      {
        localJSONObject.put("result", paramBundle.getInt("result"));
        super.callJs(str1, new String[] { localJSONObject.toString() });
        return;
      }
    } while (!"ipc_signature_get_sync_tag".equals(str2));
    this.isSync = paramBundle.getBoolean("isSync");
    localJSONObject.put("result", this.isSync);
    if (QLog.isColorLevel()) {
      QLog.d("SigImg2Zone", 4, "isSync from onResponse: " + this.isSync);
    }
    super.callJs(str1, new String[] { localJSONObject.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.SignJsPlugin
 * JD-Core Version:    0.7.0.1
 */