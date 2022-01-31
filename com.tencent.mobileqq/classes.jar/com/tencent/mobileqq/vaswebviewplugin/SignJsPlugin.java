package com.tencent.mobileqq.vaswebviewplugin;

import ajsf;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import anql;
import bcdb;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
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
  private final String SIGNATURE_SYNC_IMG_TEMP_PATH = ajsf.bV + "temp/";
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
  
  /* Error */
  public boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +20 -> 24
    //   7: ldc 14
    //   9: aload_3
    //   10: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   42: ldc_w 303
    //   45: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_2
    //   49: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc_w 305
    //   55: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_3
    //   59: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc_w 307
    //   65: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload 4
    //   70: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   79: aconst_null
    //   80: astore 5
    //   82: aload_2
    //   83: invokestatic 313	com/tencent/mobileqq/webview/swift/WebViewPlugin:getJsonFromJSBridge	(Ljava/lang/String;)Lorg/json/JSONObject;
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
    //   109: ldc_w 315
    //   112: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload_1
    //   116: invokevirtual 174	org/json/JSONObject:toString	()Ljava/lang/String;
    //   119: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: aload_1
    //   129: ldc_w 317
    //   132: invokevirtual 320	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   135: astore 16
    //   137: aload 16
    //   139: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   142: ifeq +14 -> 156
    //   145: ldc 34
    //   147: iconst_1
    //   148: ldc_w 322
    //   151: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: iconst_1
    //   155: ireturn
    //   156: ldc_w 326
    //   159: aload 4
    //   161: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   164: ifeq +302 -> 466
    //   167: aload_1
    //   168: ldc_w 328
    //   171: invokevirtual 320	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   174: astore 5
    //   176: aload 5
    //   178: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   181: ifne +11 -> 192
    //   184: aload 5
    //   186: invokestatic 331	android/text/TextUtils:isDigitsOnly	(Ljava/lang/CharSequence;)Z
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
    //   211: invokestatic 334	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   214: istore 6
    //   216: aload_1
    //   217: ldc_w 336
    //   220: invokevirtual 320	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   223: astore 5
    //   225: aload_1
    //   226: ldc_w 338
    //   229: invokevirtual 320	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   232: astore 13
    //   234: aload_1
    //   235: ldc_w 340
    //   238: invokevirtual 320	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   241: astore 14
    //   243: aload_1
    //   244: ldc_w 342
    //   247: invokevirtual 320	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   250: astore 15
    //   252: aload_0
    //   253: getfield 344	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   256: invokevirtual 347	android/os/Bundle:clear	()V
    //   259: aload_0
    //   260: getfield 344	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   263: ldc_w 328
    //   266: iload 6
    //   268: invokevirtual 351	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   271: aload_0
    //   272: getfield 344	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   275: ldc_w 353
    //   278: aload 5
    //   280: invokevirtual 357	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: aload_0
    //   284: getfield 344	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   287: ldc_w 338
    //   290: aload 13
    //   292: invokevirtual 357	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: aload_0
    //   296: getfield 344	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   299: ldc_w 340
    //   302: aload 14
    //   304: invokevirtual 357	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   307: aload_0
    //   308: getfield 344	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   311: ldc_w 342
    //   314: aload 15
    //   316: invokevirtual 357	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   319: aload_1
    //   320: ldc_w 359
    //   323: invokevirtual 362	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   326: astore 5
    //   328: aload 5
    //   330: ifnull +75 -> 405
    //   333: aload_0
    //   334: getfield 344	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   337: ldc_w 364
    //   340: aload 5
    //   342: ldc_w 366
    //   345: invokevirtual 320	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   348: invokevirtual 357	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   351: aload_0
    //   352: getfield 344	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   355: ldc_w 368
    //   358: aload 5
    //   360: ldc_w 370
    //   363: invokevirtual 320	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   366: invokevirtual 357	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   369: aload_0
    //   370: getfield 344	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   373: ldc_w 372
    //   376: aload 5
    //   378: ldc_w 374
    //   381: invokevirtual 320	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   384: invokevirtual 357	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   387: aload_0
    //   388: getfield 344	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   391: ldc_w 376
    //   394: aload 5
    //   396: ldc_w 378
    //   399: invokevirtual 320	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   402: invokevirtual 357	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   405: aload_1
    //   406: ldc_w 380
    //   409: invokevirtual 384	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   412: astore_1
    //   413: aload_1
    //   414: ifnull +24 -> 438
    //   417: aload_1
    //   418: invokevirtual 390	org/json/JSONArray:length	()I
    //   421: ifle +17 -> 438
    //   424: aload_0
    //   425: getfield 344	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   428: ldc_w 392
    //   431: aload_1
    //   432: invokevirtual 393	org/json/JSONArray:toString	()Ljava/lang/String;
    //   435: invokevirtual 357	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   438: aload_0
    //   439: ldc_w 395
    //   442: aload 16
    //   444: aload_0
    //   445: getfield 399	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mOnRemoteResp	Lanql;
    //   448: getfield 404	anql:key	I
    //   451: aload_0
    //   452: getfield 344	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   455: invokestatic 409	anqp:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   458: iconst_0
    //   459: iconst_1
    //   460: invokespecial 413	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:sendRemoteReq	(Landroid/os/Bundle;ZZ)V
    //   463: goto +2807 -> 3270
    //   466: ldc_w 415
    //   469: aload 4
    //   471: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   474: ifeq +279 -> 753
    //   477: invokestatic 420	bgyf:a	()Lbgyf;
    //   480: astore 13
    //   482: aload 13
    //   484: aload_0
    //   485: getfield 422	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:browserApp	Lcom/tencent/mobileqq/app/BrowserAppInterface;
    //   488: invokevirtual 427	com/tencent/mobileqq/app/BrowserAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   491: putfield 429	bgyf:a	Ljava/lang/String;
    //   494: aload 13
    //   496: aload_0
    //   497: getfield 422	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:browserApp	Lcom/tencent/mobileqq/app/BrowserAppInterface;
    //   500: invokevirtual 432	com/tencent/mobileqq/app/BrowserAppInterface:getCurrentNickname	()Ljava/lang/String;
    //   503: putfield 435	bgyf:b	Ljava/lang/String;
    //   506: aload_0
    //   507: aload 16
    //   509: putfield 437	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mLocationCallback	Ljava/lang/String;
    //   512: aload_0
    //   513: getfield 439	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mCachePoiId	Ljava/lang/String;
    //   516: astore 5
    //   518: aload 5
    //   520: astore_1
    //   521: aload 5
    //   523: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   526: ifeq +50 -> 576
    //   529: aload_0
    //   530: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lbcdb;
    //   533: invokevirtual 442	bcdb:a	()Lcom/tencent/common/app/AppInterface;
    //   536: invokevirtual 448	com/tencent/common/app/AppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   539: new 60	java/lang/StringBuilder
    //   542: dup
    //   543: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   546: ldc 11
    //   548: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: aload_0
    //   552: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lbcdb;
    //   555: invokevirtual 442	bcdb:a	()Lcom/tencent/common/app/AppInterface;
    //   558: invokevirtual 449	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   561: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   567: ldc_w 451
    //   570: invokeinterface 456 3 0
    //   575: astore_1
    //   576: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   579: ifeq +29 -> 608
    //   582: ldc 34
    //   584: iconst_2
    //   585: new 60	java/lang/StringBuilder
    //   588: dup
    //   589: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   592: ldc_w 458
    //   595: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: aload_1
    //   599: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   605: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   608: new 108	android/os/Bundle
    //   611: dup
    //   612: invokespecial 459	android/os/Bundle:<init>	()V
    //   615: astore 5
    //   617: aload_1
    //   618: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   621: ifne +21 -> 642
    //   624: aload 5
    //   626: ldc_w 461
    //   629: iconst_1
    //   630: invokevirtual 351	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   633: aload 5
    //   635: ldc_w 463
    //   638: aload_1
    //   639: invokevirtual 357	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   642: aload_0
    //   643: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lbcdb;
    //   646: invokevirtual 279	bcdb:a	()Landroid/app/Activity;
    //   649: aload 13
    //   651: ldc_w 464
    //   654: aload 5
    //   656: invokestatic 469	bgxy:a	(Landroid/app/Activity;Lbgyf;ILandroid/os/Bundle;)V
    //   659: goto +2611 -> 3270
    //   662: astore_1
    //   663: aload 16
    //   665: astore 5
    //   667: ldc 34
    //   669: iconst_2
    //   670: new 60	java/lang/StringBuilder
    //   673: dup
    //   674: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   677: ldc_w 471
    //   680: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: aload_2
    //   684: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: ldc_w 305
    //   690: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: aload_3
    //   694: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: ldc_w 307
    //   700: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   703: aload 4
    //   705: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: ldc_w 473
    //   711: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: aload_1
    //   715: invokevirtual 476	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   718: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   724: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   727: aload 5
    //   729: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   732: ifne +2538 -> 3270
    //   735: aload_0
    //   736: aload 5
    //   738: iconst_1
    //   739: anewarray 173	java/lang/String
    //   742: dup
    //   743: iconst_0
    //   744: ldc 198
    //   746: aastore
    //   747: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   750: goto +2520 -> 3270
    //   753: ldc_w 478
    //   756: aload 4
    //   758: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   761: ifeq +37 -> 798
    //   764: new 236	android/content/Intent
    //   767: dup
    //   768: aload_0
    //   769: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lbcdb;
    //   772: invokevirtual 279	bcdb:a	()Landroid/app/Activity;
    //   775: ldc_w 480
    //   778: invokespecial 483	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   781: astore_1
    //   782: aload_0
    //   783: aload 16
    //   785: putfield 485	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mActionCallback	Ljava/lang/String;
    //   788: aload_0
    //   789: aload_1
    //   790: bipush 101
    //   792: invokespecial 489	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   795: goto +2475 -> 3270
    //   798: ldc_w 491
    //   801: aload 4
    //   803: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   806: ifeq +126 -> 932
    //   809: aload_1
    //   810: ldc_w 493
    //   813: invokevirtual 320	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   816: astore 5
    //   818: aload_1
    //   819: ldc_w 495
    //   822: invokevirtual 320	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   825: astore 13
    //   827: aload 5
    //   829: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   832: ifeq +20 -> 852
    //   835: aload_0
    //   836: aload 16
    //   838: iconst_1
    //   839: anewarray 173	java/lang/String
    //   842: dup
    //   843: iconst_0
    //   844: ldc 198
    //   846: aastore
    //   847: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   850: iconst_1
    //   851: ireturn
    //   852: aload_1
    //   853: ldc_w 497
    //   856: invokevirtual 500	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   859: istore 6
    //   861: aload_0
    //   862: getfield 344	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   865: invokevirtual 347	android/os/Bundle:clear	()V
    //   868: aload_0
    //   869: getfield 344	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   872: ldc_w 493
    //   875: aload 5
    //   877: invokevirtual 357	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   880: aload_0
    //   881: getfield 344	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   884: ldc_w 495
    //   887: aload 13
    //   889: invokevirtual 357	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   892: aload_0
    //   893: getfield 344	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   896: ldc_w 497
    //   899: iload 6
    //   901: invokevirtual 351	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   904: aload_0
    //   905: ldc_w 502
    //   908: aload 16
    //   910: aload_0
    //   911: getfield 399	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mOnRemoteResp	Lanql;
    //   914: getfield 404	anql:key	I
    //   917: aload_0
    //   918: getfield 344	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   921: invokestatic 409	anqp:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   924: iconst_0
    //   925: iconst_1
    //   926: invokespecial 413	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:sendRemoteReq	(Landroid/os/Bundle;ZZ)V
    //   929: goto +2341 -> 3270
    //   932: ldc_w 504
    //   935: aload 4
    //   937: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   940: ifeq +1041 -> 1981
    //   943: aload_1
    //   944: ldc_w 506
    //   947: invokevirtual 320	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   950: astore 5
    //   952: aload_1
    //   953: ldc_w 353
    //   956: invokevirtual 320	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   959: astore 19
    //   961: aload_0
    //   962: getfield 508	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:isSync	Z
    //   965: ifeq +2305 -> 3270
    //   968: aload 5
    //   970: ifnull +16 -> 986
    //   973: aload 5
    //   975: ifnull +71 -> 1046
    //   978: aload 5
    //   980: invokevirtual 510	java/lang/String:isEmpty	()Z
    //   983: ifeq +63 -> 1046
    //   986: aload 19
    //   988: ifnull +2282 -> 3270
    //   991: aload 19
    //   993: invokevirtual 510	java/lang/String:isEmpty	()Z
    //   996: ifne +2274 -> 3270
    //   999: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1002: ifeq +31 -> 1033
    //   1005: ldc_w 512
    //   1008: iconst_4
    //   1009: new 60	java/lang/StringBuilder
    //   1012: dup
    //   1013: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1016: ldc_w 514
    //   1019: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1022: aload 19
    //   1024: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1027: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1030: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1033: aload 19
    //   1035: aconst_null
    //   1036: ldc_w 516
    //   1039: iconst_3
    //   1040: invokestatic 519	bgxy:a	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;I)V
    //   1043: goto +2227 -> 3270
    //   1046: iconst_0
    //   1047: istore 9
    //   1049: iconst_0
    //   1050: istore 10
    //   1052: iconst_0
    //   1053: istore 11
    //   1055: iconst_0
    //   1056: istore 8
    //   1058: iload 11
    //   1060: istore 6
    //   1062: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1065: ifeq +16 -> 1081
    //   1068: iload 11
    //   1070: istore 6
    //   1072: ldc_w 512
    //   1075: iconst_4
    //   1076: aload 5
    //   1078: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1081: iload 11
    //   1083: istore 6
    //   1085: aload 5
    //   1087: iconst_2
    //   1088: invokestatic 525	bbca:decode	(Ljava/lang/String;I)[B
    //   1091: astore 20
    //   1093: aconst_null
    //   1094: astore_1
    //   1095: aconst_null
    //   1096: astore 17
    //   1098: aconst_null
    //   1099: astore 18
    //   1101: aconst_null
    //   1102: astore 14
    //   1104: aconst_null
    //   1105: astore 15
    //   1107: aload 18
    //   1109: astore 5
    //   1111: aload_1
    //   1112: astore 13
    //   1114: new 527	java/io/File
    //   1117: dup
    //   1118: aload_0
    //   1119: getfield 78	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:SIGNATURE_SYNC_IMG_TEMP_PATH	Ljava/lang/String;
    //   1122: invokespecial 530	java/io/File:<init>	(Ljava/lang/String;)V
    //   1125: astore 21
    //   1127: aload 18
    //   1129: astore 5
    //   1131: aload_1
    //   1132: astore 13
    //   1134: aload 21
    //   1136: invokevirtual 533	java/io/File:exists	()Z
    //   1139: ifne +71 -> 1210
    //   1142: aload 18
    //   1144: astore 5
    //   1146: aload_1
    //   1147: astore 13
    //   1149: aload 21
    //   1151: invokevirtual 536	java/io/File:mkdirs	()Z
    //   1154: istore 12
    //   1156: aload 18
    //   1158: astore 5
    //   1160: aload_1
    //   1161: astore 13
    //   1163: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1166: ifeq +44 -> 1210
    //   1169: aload 18
    //   1171: astore 5
    //   1173: aload_1
    //   1174: astore 13
    //   1176: ldc_w 512
    //   1179: iconst_2
    //   1180: new 60	java/lang/StringBuilder
    //   1183: dup
    //   1184: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1187: ldc_w 538
    //   1190: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1193: iload 12
    //   1195: invokevirtual 541	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1198: ldc_w 543
    //   1201: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1204: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1207: invokestatic 258	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1210: aload 18
    //   1212: astore 5
    //   1214: aload_1
    //   1215: astore 13
    //   1217: new 545	java/io/FileOutputStream
    //   1220: dup
    //   1221: aload_0
    //   1222: getfield 82	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:SIGNATURE_SYNC_IMG_TEMP_FILE	Ljava/lang/String;
    //   1225: invokespecial 546	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   1228: astore_1
    //   1229: new 548	java/io/BufferedOutputStream
    //   1232: dup
    //   1233: aload_1
    //   1234: invokespecial 551	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1237: astore 5
    //   1239: aload 5
    //   1241: aload 20
    //   1243: invokevirtual 555	java/io/BufferedOutputStream:write	([B)V
    //   1246: aload 5
    //   1248: invokevirtual 558	java/io/BufferedOutputStream:flush	()V
    //   1251: aload 5
    //   1253: ifnull +12 -> 1265
    //   1256: iload 11
    //   1258: istore 6
    //   1260: aload 5
    //   1262: invokevirtual 561	java/io/BufferedOutputStream:close	()V
    //   1265: aload_1
    //   1266: ifnull +11 -> 1277
    //   1269: iload 11
    //   1271: istore 6
    //   1273: aload_1
    //   1274: invokevirtual 562	java/io/FileOutputStream:close	()V
    //   1277: iload 11
    //   1279: istore 6
    //   1281: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1284: ifeq +17 -> 1301
    //   1287: iload 11
    //   1289: istore 6
    //   1291: ldc_w 512
    //   1294: iconst_2
    //   1295: ldc_w 564
    //   1298: invokestatic 258	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1301: iload 11
    //   1303: istore 6
    //   1305: aload_0
    //   1306: getfield 82	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:SIGNATURE_SYNC_IMG_TEMP_FILE	Ljava/lang/String;
    //   1309: invokestatic 568	bbdj:a	(Ljava/lang/String;)Z
    //   1312: ifeq +595 -> 1907
    //   1315: iload 11
    //   1317: istore 6
    //   1319: aload_0
    //   1320: getfield 82	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:SIGNATURE_SYNC_IMG_TEMP_FILE	Ljava/lang/String;
    //   1323: invokestatic 571	bbdj:f	(Ljava/lang/String;)Z
    //   1326: ifeq +581 -> 1907
    //   1329: iload 11
    //   1331: istore 6
    //   1333: new 573	java/util/ArrayList
    //   1336: dup
    //   1337: invokespecial 574	java/util/ArrayList:<init>	()V
    //   1340: astore_1
    //   1341: iload 11
    //   1343: istore 6
    //   1345: aload_1
    //   1346: aload_0
    //   1347: getfield 82	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:SIGNATURE_SYNC_IMG_TEMP_FILE	Ljava/lang/String;
    //   1350: invokevirtual 577	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1353: pop
    //   1354: iload 11
    //   1356: istore 6
    //   1358: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1361: ifeq +41 -> 1402
    //   1364: iload 11
    //   1366: istore 6
    //   1368: ldc_w 512
    //   1371: iconst_2
    //   1372: new 60	java/lang/StringBuilder
    //   1375: dup
    //   1376: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1379: ldc_w 579
    //   1382: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1385: aload_1
    //   1386: iconst_0
    //   1387: invokevirtual 582	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1390: checkcast 173	java/lang/String
    //   1393: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1396: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1399: invokestatic 258	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1402: iconst_1
    //   1403: istore 6
    //   1405: iconst_1
    //   1406: istore 7
    //   1408: ldc_w 583
    //   1411: invokestatic 588	ajyc:a	(I)Ljava/lang/String;
    //   1414: aload_1
    //   1415: ldc_w 516
    //   1418: iconst_3
    //   1419: invokestatic 519	bgxy:a	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;I)V
    //   1422: iconst_1
    //   1423: istore 7
    //   1425: iload 7
    //   1427: ifne +1843 -> 3270
    //   1430: aload 19
    //   1432: ifnull +1838 -> 3270
    //   1435: aload 19
    //   1437: invokevirtual 510	java/lang/String:isEmpty	()Z
    //   1440: ifne +1830 -> 3270
    //   1443: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1446: ifeq +13 -> 1459
    //   1449: ldc_w 512
    //   1452: iconst_4
    //   1453: ldc_w 590
    //   1456: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1459: aload 19
    //   1461: aconst_null
    //   1462: ldc_w 516
    //   1465: iconst_3
    //   1466: invokestatic 519	bgxy:a	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;I)V
    //   1469: goto +1801 -> 3270
    //   1472: astore_1
    //   1473: iload 11
    //   1475: istore 6
    //   1477: aload_1
    //   1478: invokevirtual 593	java/io/IOException:printStackTrace	()V
    //   1481: goto -180 -> 1301
    //   1484: astore_1
    //   1485: iconst_0
    //   1486: istore 7
    //   1488: iload 7
    //   1490: istore 6
    //   1492: ldc_w 512
    //   1495: iconst_2
    //   1496: ldc_w 595
    //   1499: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1502: iload 7
    //   1504: istore 6
    //   1506: aload_1
    //   1507: invokevirtual 596	java/lang/IllegalArgumentException:printStackTrace	()V
    //   1510: iload 7
    //   1512: ifne +1758 -> 3270
    //   1515: aload 19
    //   1517: ifnull +1753 -> 3270
    //   1520: aload 19
    //   1522: invokevirtual 510	java/lang/String:isEmpty	()Z
    //   1525: ifne +1745 -> 3270
    //   1528: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1531: ifeq +13 -> 1544
    //   1534: ldc_w 512
    //   1537: iconst_4
    //   1538: ldc_w 590
    //   1541: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1544: aload 19
    //   1546: aconst_null
    //   1547: ldc_w 516
    //   1550: iconst_3
    //   1551: invokestatic 519	bgxy:a	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;I)V
    //   1554: goto +1716 -> 3270
    //   1557: astore 14
    //   1559: aload 17
    //   1561: astore_1
    //   1562: aload 15
    //   1564: astore 5
    //   1566: aload_1
    //   1567: astore 13
    //   1569: aload 14
    //   1571: invokevirtual 593	java/io/IOException:printStackTrace	()V
    //   1574: aload 15
    //   1576: ifnull +12 -> 1588
    //   1579: iload 11
    //   1581: istore 6
    //   1583: aload 15
    //   1585: invokevirtual 561	java/io/BufferedOutputStream:close	()V
    //   1588: aload_1
    //   1589: ifnull +11 -> 1600
    //   1592: iload 11
    //   1594: istore 6
    //   1596: aload_1
    //   1597: invokevirtual 562	java/io/FileOutputStream:close	()V
    //   1600: iload 11
    //   1602: istore 6
    //   1604: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1607: ifeq -306 -> 1301
    //   1610: iload 11
    //   1612: istore 6
    //   1614: ldc_w 512
    //   1617: iconst_2
    //   1618: ldc_w 564
    //   1621: invokestatic 258	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1624: goto -323 -> 1301
    //   1627: astore_1
    //   1628: iload 11
    //   1630: istore 6
    //   1632: aload_1
    //   1633: invokevirtual 593	java/io/IOException:printStackTrace	()V
    //   1636: goto -335 -> 1301
    //   1639: astore_1
    //   1640: iload 9
    //   1642: istore 7
    //   1644: iload 7
    //   1646: istore 6
    //   1648: ldc_w 512
    //   1651: iconst_2
    //   1652: ldc_w 598
    //   1655: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1658: iload 7
    //   1660: istore 6
    //   1662: aload_1
    //   1663: invokevirtual 599	java/lang/Exception:printStackTrace	()V
    //   1666: iload 7
    //   1668: ifne +1602 -> 3270
    //   1671: aload 19
    //   1673: ifnull +1597 -> 3270
    //   1676: aload 19
    //   1678: invokevirtual 510	java/lang/String:isEmpty	()Z
    //   1681: ifne +1589 -> 3270
    //   1684: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1687: ifeq +13 -> 1700
    //   1690: ldc_w 512
    //   1693: iconst_4
    //   1694: ldc_w 590
    //   1697: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1700: aload 19
    //   1702: aconst_null
    //   1703: ldc_w 516
    //   1706: iconst_3
    //   1707: invokestatic 519	bgxy:a	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;I)V
    //   1710: goto +1560 -> 3270
    //   1713: astore_1
    //   1714: aload 5
    //   1716: ifnull +12 -> 1728
    //   1719: iload 11
    //   1721: istore 6
    //   1723: aload 5
    //   1725: invokevirtual 561	java/io/BufferedOutputStream:close	()V
    //   1728: aload 13
    //   1730: ifnull +12 -> 1742
    //   1733: iload 11
    //   1735: istore 6
    //   1737: aload 13
    //   1739: invokevirtual 562	java/io/FileOutputStream:close	()V
    //   1742: iload 11
    //   1744: istore 6
    //   1746: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1749: ifeq +17 -> 1766
    //   1752: iload 11
    //   1754: istore 6
    //   1756: ldc_w 512
    //   1759: iconst_2
    //   1760: ldc_w 564
    //   1763: invokestatic 258	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1766: iload 11
    //   1768: istore 6
    //   1770: aload_1
    //   1771: athrow
    //   1772: astore_1
    //   1773: iload 10
    //   1775: istore 7
    //   1777: iload 7
    //   1779: istore 6
    //   1781: ldc_w 512
    //   1784: iconst_2
    //   1785: ldc_w 601
    //   1788: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1791: iload 7
    //   1793: istore 6
    //   1795: aload_1
    //   1796: invokevirtual 602	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1799: iload 7
    //   1801: ifne +1469 -> 3270
    //   1804: aload 19
    //   1806: ifnull +1464 -> 3270
    //   1809: aload 19
    //   1811: invokevirtual 510	java/lang/String:isEmpty	()Z
    //   1814: ifne +1456 -> 3270
    //   1817: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1820: ifeq +13 -> 1833
    //   1823: ldc_w 512
    //   1826: iconst_4
    //   1827: ldc_w 590
    //   1830: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1833: aload 19
    //   1835: aconst_null
    //   1836: ldc_w 516
    //   1839: iconst_3
    //   1840: invokestatic 519	bgxy:a	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;I)V
    //   1843: goto +1427 -> 3270
    //   1846: astore 5
    //   1848: iload 11
    //   1850: istore 6
    //   1852: aload 5
    //   1854: invokevirtual 593	java/io/IOException:printStackTrace	()V
    //   1857: goto -91 -> 1766
    //   1860: astore_1
    //   1861: iload 6
    //   1863: ifne +42 -> 1905
    //   1866: aload 19
    //   1868: ifnull +37 -> 1905
    //   1871: aload 19
    //   1873: invokevirtual 510	java/lang/String:isEmpty	()Z
    //   1876: ifne +29 -> 1905
    //   1879: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1882: ifeq +13 -> 1895
    //   1885: ldc_w 512
    //   1888: iconst_4
    //   1889: ldc_w 590
    //   1892: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1895: aload 19
    //   1897: aconst_null
    //   1898: ldc_w 516
    //   1901: iconst_3
    //   1902: invokestatic 519	bgxy:a	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;I)V
    //   1905: aload_1
    //   1906: athrow
    //   1907: iload 8
    //   1909: istore 7
    //   1911: iload 11
    //   1913: istore 6
    //   1915: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1918: ifeq -493 -> 1425
    //   1921: iload 11
    //   1923: istore 6
    //   1925: ldc_w 512
    //   1928: iconst_2
    //   1929: new 60	java/lang/StringBuilder
    //   1932: dup
    //   1933: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1936: ldc_w 604
    //   1939: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1942: aload_0
    //   1943: getfield 82	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:SIGNATURE_SYNC_IMG_TEMP_FILE	Ljava/lang/String;
    //   1946: invokestatic 568	bbdj:a	(Ljava/lang/String;)Z
    //   1949: invokevirtual 541	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1952: ldc_w 606
    //   1955: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1958: aload_0
    //   1959: getfield 82	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:SIGNATURE_SYNC_IMG_TEMP_FILE	Ljava/lang/String;
    //   1962: invokestatic 571	bbdj:f	(Ljava/lang/String;)Z
    //   1965: invokevirtual 541	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1968: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1971: invokestatic 258	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1974: iload 8
    //   1976: istore 7
    //   1978: goto -553 -> 1425
    //   1981: ldc_w 608
    //   1984: aload 4
    //   1986: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1989: ifeq +31 -> 2020
    //   1992: aload_0
    //   1993: ldc_w 610
    //   1996: aload 16
    //   1998: aload_0
    //   1999: getfield 399	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mOnRemoteResp	Lanql;
    //   2002: getfield 404	anql:key	I
    //   2005: aload_0
    //   2006: getfield 344	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   2009: invokestatic 409	anqp:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   2012: iconst_0
    //   2013: iconst_1
    //   2014: invokespecial 413	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:sendRemoteReq	(Landroid/os/Bundle;ZZ)V
    //   2017: goto +1253 -> 3270
    //   2020: ldc_w 612
    //   2023: aload 4
    //   2025: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2028: ifeq +41 -> 2069
    //   2031: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2034: ifeq +12 -> 2046
    //   2037: ldc 34
    //   2039: iconst_2
    //   2040: ldc_w 612
    //   2043: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2046: aload_0
    //   2047: aconst_null
    //   2048: putfield 439	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mCachePoiId	Ljava/lang/String;
    //   2051: aload_0
    //   2052: aload 16
    //   2054: iconst_1
    //   2055: anewarray 173	java/lang/String
    //   2058: dup
    //   2059: iconst_0
    //   2060: ldc 214
    //   2062: aastore
    //   2063: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2066: goto +1204 -> 3270
    //   2069: ldc_w 614
    //   2072: aload 4
    //   2074: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2077: ifeq +109 -> 2186
    //   2080: aload_1
    //   2081: ldc_w 616
    //   2084: invokevirtual 500	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2087: istore 6
    //   2089: aload_1
    //   2090: ldc_w 618
    //   2093: invokevirtual 500	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2096: istore 7
    //   2098: aload_1
    //   2099: ldc_w 620
    //   2102: invokevirtual 500	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2105: istore 8
    //   2107: aload_1
    //   2108: ldc_w 366
    //   2111: invokevirtual 500	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2114: istore 9
    //   2116: aload_1
    //   2117: ldc_w 370
    //   2120: invokevirtual 320	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2123: astore 5
    //   2125: aload_1
    //   2126: ldc_w 622
    //   2129: invokevirtual 500	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2132: istore 10
    //   2134: aload_0
    //   2135: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lbcdb;
    //   2138: invokevirtual 625	bcdb:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   2141: astore_1
    //   2142: aload_1
    //   2143: instanceof 627
    //   2146: ifeq +22 -> 2168
    //   2149: aload_1
    //   2150: checkcast 627	com/tencent/mobileqq/richstatus/SignatureEditFragment
    //   2153: iload 6
    //   2155: iload 7
    //   2157: iload 8
    //   2159: iload 9
    //   2161: aload 5
    //   2163: iload 10
    //   2165: invokevirtual 630	com/tencent/mobileqq/richstatus/SignatureEditFragment:a	(IIIILjava/lang/String;I)V
    //   2168: aload_0
    //   2169: aload 16
    //   2171: iconst_1
    //   2172: anewarray 173	java/lang/String
    //   2175: dup
    //   2176: iconst_0
    //   2177: ldc 214
    //   2179: aastore
    //   2180: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2183: goto +1087 -> 3270
    //   2186: ldc_w 632
    //   2189: aload 4
    //   2191: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2194: ifeq +298 -> 2492
    //   2197: aload_0
    //   2198: aload 16
    //   2200: putfield 97	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mGetSigInfoCallback	Ljava/lang/String;
    //   2203: invokestatic 637	awei:a	()Lawei;
    //   2206: getfield 640	awei:a	Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   2209: ifnonnull +23 -> 2232
    //   2212: invokestatic 646	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   2215: ldc_w 648
    //   2218: getstatic 652	hy:e	Ljava/lang/String;
    //   2221: aconst_null
    //   2222: aload_0
    //   2223: getfield 89	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:getSignatureCallback	Leipc/EIPCResultCallback;
    //   2226: invokevirtual 656	com/tencent/mobileqq/qipc/QIPCClientHelper:callServer	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Leipc/EIPCResultCallback;)V
    //   2229: goto +1041 -> 3270
    //   2232: invokestatic 637	awei:a	()Lawei;
    //   2235: getfield 640	awei:a	Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   2238: astore 5
    //   2240: new 103	org/json/JSONObject
    //   2243: dup
    //   2244: invokespecial 104	org/json/JSONObject:<init>	()V
    //   2247: astore_1
    //   2248: aload_1
    //   2249: ldc_w 616
    //   2252: aload 5
    //   2254: getfield 661	com/tencent/mobileqq/richstatus/RichStatus:tplId	I
    //   2257: invokevirtual 116	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2260: pop
    //   2261: aload_1
    //   2262: ldc_w 618
    //   2265: aload 5
    //   2267: getfield 663	com/tencent/mobileqq/richstatus/RichStatus:fontId	I
    //   2270: invokevirtual 116	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2273: pop
    //   2274: aload_1
    //   2275: ldc_w 620
    //   2278: aload 5
    //   2280: getfield 665	com/tencent/mobileqq/richstatus/RichStatus:fontType	I
    //   2283: invokevirtual 116	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2286: pop
    //   2287: aload_1
    //   2288: ldc_w 366
    //   2291: aload 5
    //   2293: getfield 667	com/tencent/mobileqq/richstatus/RichStatus:actionId	I
    //   2296: invokevirtual 116	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2299: pop
    //   2300: aload 5
    //   2302: getfield 669	com/tencent/mobileqq/richstatus/RichStatus:actionText	Ljava/lang/String;
    //   2305: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2308: ifne +158 -> 2466
    //   2311: aload_1
    //   2312: ldc_w 671
    //   2315: aload 5
    //   2317: getfield 669	com/tencent/mobileqq/richstatus/RichStatus:actionText	Ljava/lang/String;
    //   2320: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2323: pop
    //   2324: invokestatic 637	awei:a	()Lawei;
    //   2327: aload 5
    //   2329: getfield 661	com/tencent/mobileqq/richstatus/RichStatus:tplId	I
    //   2332: invokevirtual 674	awei:a	(I)Lbbqe;
    //   2335: astore 13
    //   2337: aload 13
    //   2339: getfield 679	bbqe:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   2342: invokevirtual 683	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   2345: ifeq +137 -> 2482
    //   2348: aload 5
    //   2350: getfield 687	com/tencent/mobileqq/richstatus/RichStatus:mStickerInfos	Ljava/util/ArrayList;
    //   2353: ifnull +919 -> 3272
    //   2356: aload 5
    //   2358: getfield 687	com/tencent/mobileqq/richstatus/RichStatus:mStickerInfos	Ljava/util/ArrayList;
    //   2361: invokevirtual 688	java/util/ArrayList:isEmpty	()Z
    //   2364: ifeq +914 -> 3278
    //   2367: goto +905 -> 3272
    //   2370: aload_1
    //   2371: ldc_w 690
    //   2374: iload 6
    //   2376: invokevirtual 116	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2379: pop
    //   2380: new 103	org/json/JSONObject
    //   2383: dup
    //   2384: invokespecial 104	org/json/JSONObject:<init>	()V
    //   2387: astore 5
    //   2389: aload 5
    //   2391: ldc 106
    //   2393: iconst_0
    //   2394: invokevirtual 116	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2397: pop
    //   2398: aload 5
    //   2400: ldc 165
    //   2402: aload_1
    //   2403: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2406: pop
    //   2407: aload_0
    //   2408: aload_0
    //   2409: getfield 97	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mGetSigInfoCallback	Ljava/lang/String;
    //   2412: iconst_1
    //   2413: anewarray 173	java/lang/String
    //   2416: dup
    //   2417: iconst_0
    //   2418: aload 5
    //   2420: invokevirtual 174	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2423: aastore
    //   2424: invokevirtual 691	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2427: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2430: ifeq +840 -> 3270
    //   2433: ldc 34
    //   2435: iconst_2
    //   2436: new 60	java/lang/StringBuilder
    //   2439: dup
    //   2440: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   2443: ldc_w 693
    //   2446: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2449: aload 5
    //   2451: invokevirtual 174	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2454: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2457: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2460: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2463: goto +807 -> 3270
    //   2466: aload_1
    //   2467: ldc_w 671
    //   2470: aload 5
    //   2472: invokevirtual 696	com/tencent/mobileqq/richstatus/RichStatus:getPlainText	()Ljava/lang/String;
    //   2475: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2478: pop
    //   2479: goto -155 -> 2324
    //   2482: aload 13
    //   2484: getfield 699	bbqe:g	I
    //   2487: istore 6
    //   2489: goto -119 -> 2370
    //   2492: ldc_w 701
    //   2495: aload 4
    //   2497: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2500: ifeq +32 -> 2532
    //   2503: aload_0
    //   2504: aload_1
    //   2505: ldc_w 703
    //   2508: invokevirtual 320	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2511: putfield 206	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mOpenFontCallback	Ljava/lang/String;
    //   2514: aload_0
    //   2515: aload 16
    //   2517: iconst_1
    //   2518: anewarray 173	java/lang/String
    //   2521: dup
    //   2522: iconst_0
    //   2523: ldc 214
    //   2525: aastore
    //   2526: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2529: goto +741 -> 3270
    //   2532: ldc_w 705
    //   2535: aload 4
    //   2537: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2540: ifeq +34 -> 2574
    //   2543: aload_0
    //   2544: aload 16
    //   2546: putfield 220	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mPublishCallback	Ljava/lang/String;
    //   2549: aload_0
    //   2550: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lbcdb;
    //   2553: invokevirtual 625	bcdb:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   2556: astore_1
    //   2557: aload_1
    //   2558: instanceof 627
    //   2561: ifeq +709 -> 3270
    //   2564: aload_1
    //   2565: checkcast 627	com/tencent/mobileqq/richstatus/SignatureEditFragment
    //   2568: invokevirtual 708	com/tencent/mobileqq/richstatus/SignatureEditFragment:aM_	()V
    //   2571: goto +699 -> 3270
    //   2574: ldc_w 710
    //   2577: aload 4
    //   2579: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2582: ifeq +72 -> 2654
    //   2585: aload_0
    //   2586: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lbcdb;
    //   2589: invokevirtual 625	bcdb:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   2592: astore_1
    //   2593: aload_1
    //   2594: instanceof 627
    //   2597: ifeq +18 -> 2615
    //   2600: aload_1
    //   2601: checkcast 627	com/tencent/mobileqq/richstatus/SignatureEditFragment
    //   2604: astore_1
    //   2605: invokestatic 637	awei:a	()Lawei;
    //   2608: aload_1
    //   2609: getfield 711	com/tencent/mobileqq/richstatus/SignatureEditFragment:a	Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   2612: invokevirtual 714	awei:b	(Lcom/tencent/mobileqq/richstatus/RichStatus;)V
    //   2615: aload_0
    //   2616: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lbcdb;
    //   2619: invokevirtual 279	bcdb:a	()Landroid/app/Activity;
    //   2622: aload_0
    //   2623: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lbcdb;
    //   2626: invokevirtual 442	bcdb:a	()Lcom/tencent/common/app/AppInterface;
    //   2629: iconst_1
    //   2630: ldc_w 451
    //   2633: invokestatic 719	bbkv:a	(Landroid/app/Activity;Lcom/tencent/common/app/AppInterface;ILjava/lang/String;)V
    //   2636: aload_0
    //   2637: aload 16
    //   2639: iconst_1
    //   2640: anewarray 173	java/lang/String
    //   2643: dup
    //   2644: iconst_0
    //   2645: ldc 214
    //   2647: aastore
    //   2648: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2651: goto +619 -> 3270
    //   2654: ldc_w 721
    //   2657: aload 4
    //   2659: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2662: ifeq +40 -> 2702
    //   2665: aload_1
    //   2666: ldc_w 723
    //   2669: iconst_0
    //   2670: invokevirtual 726	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   2673: istore 12
    //   2675: aload_0
    //   2676: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lbcdb;
    //   2679: invokevirtual 625	bcdb:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   2682: astore_1
    //   2683: aload_1
    //   2684: instanceof 627
    //   2687: ifeq +583 -> 3270
    //   2690: aload_1
    //   2691: checkcast 627	com/tencent/mobileqq/richstatus/SignatureEditFragment
    //   2694: iload 12
    //   2696: invokevirtual 730	com/tencent/mobileqq/richstatus/SignatureEditFragment:c	(Z)V
    //   2699: goto +571 -> 3270
    //   2702: ldc_w 732
    //   2705: aload 4
    //   2707: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2710: ifeq +95 -> 2805
    //   2713: aload_1
    //   2714: ldc_w 734
    //   2717: iconst_m1
    //   2718: invokevirtual 737	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2721: istore 6
    //   2723: aload_1
    //   2724: ldc_w 618
    //   2727: iconst_m1
    //   2728: invokevirtual 737	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2731: istore 7
    //   2733: new 108	android/os/Bundle
    //   2736: dup
    //   2737: invokespecial 459	android/os/Bundle:<init>	()V
    //   2740: astore 5
    //   2742: aload 5
    //   2744: ldc_w 739
    //   2747: aload_1
    //   2748: ldc 159
    //   2750: ldc_w 741
    //   2753: invokevirtual 743	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2756: invokevirtual 357	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2759: aload_0
    //   2760: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lbcdb;
    //   2763: invokevirtual 279	bcdb:a	()Landroid/app/Activity;
    //   2766: aload_0
    //   2767: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lbcdb;
    //   2770: invokevirtual 442	bcdb:a	()Lcom/tencent/common/app/AppInterface;
    //   2773: iconst_0
    //   2774: ldc_w 745
    //   2777: iconst_m1
    //   2778: iload 6
    //   2780: iload 7
    //   2782: aload 5
    //   2784: invokestatic 748	bbkv:a	(Landroid/app/Activity;Lcom/tencent/common/app/AppInterface;ILjava/lang/String;IIILandroid/os/Bundle;)V
    //   2787: aload_0
    //   2788: aload 16
    //   2790: iconst_1
    //   2791: anewarray 173	java/lang/String
    //   2794: dup
    //   2795: iconst_0
    //   2796: ldc 214
    //   2798: aastore
    //   2799: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2802: goto +468 -> 3270
    //   2805: ldc_w 750
    //   2808: aload 4
    //   2810: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2813: ifeq +32 -> 2845
    //   2816: aload_0
    //   2817: aload_1
    //   2818: ldc_w 752
    //   2821: invokevirtual 320	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2824: putfield 232	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mContentChangeCallback	Ljava/lang/String;
    //   2827: aload_0
    //   2828: aload 16
    //   2830: iconst_1
    //   2831: anewarray 173	java/lang/String
    //   2834: dup
    //   2835: iconst_0
    //   2836: ldc 214
    //   2838: aastore
    //   2839: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2842: goto +428 -> 3270
    //   2845: ldc_w 754
    //   2848: aload 4
    //   2850: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2853: ifeq +76 -> 2929
    //   2856: aload_0
    //   2857: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lbcdb;
    //   2860: invokevirtual 625	bcdb:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   2863: astore_1
    //   2864: aload_1
    //   2865: instanceof 627
    //   2868: ifeq +42 -> 2910
    //   2871: aload_0
    //   2872: aload 16
    //   2874: iconst_1
    //   2875: anewarray 173	java/lang/String
    //   2878: dup
    //   2879: iconst_0
    //   2880: ldc_w 756
    //   2883: iconst_1
    //   2884: anewarray 245	java/lang/Object
    //   2887: dup
    //   2888: iconst_0
    //   2889: aload_1
    //   2890: checkcast 627	com/tencent/mobileqq/richstatus/SignatureEditFragment
    //   2893: invokevirtual 758	com/tencent/mobileqq/richstatus/SignatureEditFragment:a	()I
    //   2896: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2899: aastore
    //   2900: invokestatic 255	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2903: aastore
    //   2904: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2907: goto +363 -> 3270
    //   2910: aload_0
    //   2911: aload 16
    //   2913: iconst_1
    //   2914: anewarray 173	java/lang/String
    //   2917: dup
    //   2918: iconst_0
    //   2919: ldc_w 760
    //   2922: aastore
    //   2923: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2926: goto +344 -> 3270
    //   2929: ldc_w 762
    //   2932: aload 4
    //   2934: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2937: ifeq +83 -> 3020
    //   2940: aload_1
    //   2941: ldc_w 764
    //   2944: invokevirtual 500	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2947: istore 6
    //   2949: aload_1
    //   2950: ldc_w 766
    //   2953: invokevirtual 320	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2956: astore_1
    //   2957: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2960: ifeq +31 -> 2991
    //   2963: ldc 34
    //   2965: iconst_2
    //   2966: ldc_w 768
    //   2969: iconst_2
    //   2970: anewarray 245	java/lang/Object
    //   2973: dup
    //   2974: iconst_0
    //   2975: iload 6
    //   2977: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2980: aastore
    //   2981: dup
    //   2982: iconst_1
    //   2983: aload_1
    //   2984: aastore
    //   2985: invokestatic 255	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2988: invokestatic 258	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2991: aload_0
    //   2992: iload 6
    //   2994: putfield 239	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mSelectTagId	I
    //   2997: aload_0
    //   2998: aload_1
    //   2999: putfield 241	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mSelectTagText	Ljava/lang/String;
    //   3002: aload_0
    //   3003: aload 16
    //   3005: iconst_1
    //   3006: anewarray 173	java/lang/String
    //   3009: dup
    //   3010: iconst_0
    //   3011: ldc 214
    //   3013: aastore
    //   3014: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3017: goto +253 -> 3270
    //   3020: ldc_w 770
    //   3023: aload 4
    //   3025: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3028: ifeq +242 -> 3270
    //   3031: aload_1
    //   3032: ldc_w 764
    //   3035: invokevirtual 500	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   3038: istore 6
    //   3040: aload_1
    //   3041: ldc_w 766
    //   3044: invokevirtual 320	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3047: astore 5
    //   3049: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3052: ifeq +32 -> 3084
    //   3055: ldc 34
    //   3057: iconst_2
    //   3058: ldc_w 772
    //   3061: iconst_2
    //   3062: anewarray 245	java/lang/Object
    //   3065: dup
    //   3066: iconst_0
    //   3067: iload 6
    //   3069: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3072: aastore
    //   3073: dup
    //   3074: iconst_1
    //   3075: aload 5
    //   3077: aastore
    //   3078: invokestatic 255	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3081: invokestatic 258	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3084: aload 5
    //   3086: invokestatic 775	awfy:a	(Ljava/lang/String;)Z
    //   3089: ifeq +97 -> 3186
    //   3092: iload 6
    //   3094: iflt +92 -> 3186
    //   3097: new 108	android/os/Bundle
    //   3100: dup
    //   3101: invokespecial 459	android/os/Bundle:<init>	()V
    //   3104: astore_1
    //   3105: aload_1
    //   3106: ldc_w 266
    //   3109: aload 5
    //   3111: invokevirtual 357	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3114: aload_1
    //   3115: ldc_w 260
    //   3118: iload 6
    //   3120: invokevirtual 351	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3123: aload_1
    //   3124: ldc_w 777
    //   3127: iconst_1
    //   3128: invokevirtual 351	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3131: aload_0
    //   3132: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lbcdb;
    //   3135: invokevirtual 442	bcdb:a	()Lcom/tencent/common/app/AppInterface;
    //   3138: astore 5
    //   3140: aload_0
    //   3141: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lbcdb;
    //   3144: invokevirtual 279	bcdb:a	()Landroid/app/Activity;
    //   3147: astore 13
    //   3149: aload 13
    //   3151: ifnull +17 -> 3168
    //   3154: aload 5
    //   3156: ifnull +12 -> 3168
    //   3159: aload 13
    //   3161: aconst_null
    //   3162: aconst_null
    //   3163: aload_1
    //   3164: iconst_m1
    //   3165: invokestatic 782	com/tencent/mobileqq/richstatus/SignTextEditFragment:a	(Landroid/app/Activity;Lcom/tencent/mobileqq/richstatus/RichStatus;Ljava/lang/String;Landroid/os/Bundle;I)V
    //   3168: aload_0
    //   3169: aload 16
    //   3171: iconst_1
    //   3172: anewarray 173	java/lang/String
    //   3175: dup
    //   3176: iconst_0
    //   3177: ldc 214
    //   3179: aastore
    //   3180: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3183: goto +87 -> 3270
    //   3186: aload_0
    //   3187: aload 16
    //   3189: iconst_1
    //   3190: anewarray 173	java/lang/String
    //   3193: dup
    //   3194: iconst_0
    //   3195: ldc 198
    //   3197: aastore
    //   3198: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3201: goto +69 -> 3270
    //   3204: astore_1
    //   3205: goto -2538 -> 667
    //   3208: astore_1
    //   3209: goto -1348 -> 1861
    //   3212: astore_1
    //   3213: iconst_1
    //   3214: istore 7
    //   3216: goto -1439 -> 1777
    //   3219: astore_1
    //   3220: iconst_1
    //   3221: istore 7
    //   3223: goto -1579 -> 1644
    //   3226: astore_1
    //   3227: goto -1739 -> 1488
    //   3230: astore 5
    //   3232: aload_1
    //   3233: astore 13
    //   3235: aload 5
    //   3237: astore_1
    //   3238: aload 14
    //   3240: astore 5
    //   3242: goto -1528 -> 1714
    //   3245: astore 14
    //   3247: aload_1
    //   3248: astore 13
    //   3250: aload 14
    //   3252: astore_1
    //   3253: goto -1539 -> 1714
    //   3256: astore 14
    //   3258: goto -1696 -> 1562
    //   3261: astore 14
    //   3263: aload 5
    //   3265: astore 15
    //   3267: goto -1705 -> 1562
    //   3270: iconst_1
    //   3271: ireturn
    //   3272: iconst_0
    //   3273: istore 6
    //   3275: goto -905 -> 2370
    //   3278: iconst_1
    //   3279: istore 6
    //   3281: goto -911 -> 2370
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3284	0	this	SignJsPlugin
    //   0	3284	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	3284	2	paramString1	String
    //   0	3284	3	paramString2	String
    //   0	3284	4	paramString3	String
    //   0	3284	5	paramVarArgs	String[]
    //   214	3066	6	i	int
    //   1406	1816	7	j	int
    //   1056	1102	8	k	int
    //   1047	1113	9	m	int
    //   1050	1114	10	n	int
    //   1053	869	11	i1	int
    //   1154	1541	12	bool	boolean
    //   232	3017	13	localObject1	Object
    //   241	862	14	str1	String
    //   1557	1682	14	localIOException1	java.io.IOException
    //   3245	6	14	localObject2	Object
    //   3256	1	14	localIOException2	java.io.IOException
    //   3261	1	14	localIOException3	java.io.IOException
    //   250	3016	15	localObject3	Object
    //   135	3053	16	str2	String
    //   1096	464	17	localObject4	Object
    //   1099	112	18	localObject5	Object
    //   959	937	19	str3	String
    //   1091	151	20	arrayOfByte	byte[]
    //   1125	25	21	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   137	154	662	java/lang/Throwable
    //   156	192	662	java/lang/Throwable
    //   192	207	662	java/lang/Throwable
    //   209	328	662	java/lang/Throwable
    //   333	405	662	java/lang/Throwable
    //   405	413	662	java/lang/Throwable
    //   417	438	662	java/lang/Throwable
    //   438	463	662	java/lang/Throwable
    //   466	518	662	java/lang/Throwable
    //   521	576	662	java/lang/Throwable
    //   576	608	662	java/lang/Throwable
    //   608	642	662	java/lang/Throwable
    //   642	659	662	java/lang/Throwable
    //   753	795	662	java/lang/Throwable
    //   798	850	662	java/lang/Throwable
    //   852	929	662	java/lang/Throwable
    //   932	968	662	java/lang/Throwable
    //   978	986	662	java/lang/Throwable
    //   991	1033	662	java/lang/Throwable
    //   1033	1043	662	java/lang/Throwable
    //   1435	1459	662	java/lang/Throwable
    //   1459	1469	662	java/lang/Throwable
    //   1520	1544	662	java/lang/Throwable
    //   1544	1554	662	java/lang/Throwable
    //   1676	1700	662	java/lang/Throwable
    //   1700	1710	662	java/lang/Throwable
    //   1809	1833	662	java/lang/Throwable
    //   1833	1843	662	java/lang/Throwable
    //   1871	1895	662	java/lang/Throwable
    //   1895	1905	662	java/lang/Throwable
    //   1905	1907	662	java/lang/Throwable
    //   1981	2017	662	java/lang/Throwable
    //   2020	2046	662	java/lang/Throwable
    //   2046	2066	662	java/lang/Throwable
    //   2069	2168	662	java/lang/Throwable
    //   2168	2183	662	java/lang/Throwable
    //   2186	2229	662	java/lang/Throwable
    //   2232	2324	662	java/lang/Throwable
    //   2324	2367	662	java/lang/Throwable
    //   2370	2463	662	java/lang/Throwable
    //   2466	2479	662	java/lang/Throwable
    //   2482	2489	662	java/lang/Throwable
    //   2492	2529	662	java/lang/Throwable
    //   2532	2571	662	java/lang/Throwable
    //   2574	2615	662	java/lang/Throwable
    //   2615	2651	662	java/lang/Throwable
    //   2654	2699	662	java/lang/Throwable
    //   2702	2802	662	java/lang/Throwable
    //   2805	2842	662	java/lang/Throwable
    //   2845	2907	662	java/lang/Throwable
    //   2910	2926	662	java/lang/Throwable
    //   2929	2991	662	java/lang/Throwable
    //   2991	3017	662	java/lang/Throwable
    //   3020	3084	662	java/lang/Throwable
    //   3084	3092	662	java/lang/Throwable
    //   3097	3149	662	java/lang/Throwable
    //   3159	3168	662	java/lang/Throwable
    //   3168	3183	662	java/lang/Throwable
    //   3186	3201	662	java/lang/Throwable
    //   1260	1265	1472	java/io/IOException
    //   1273	1277	1472	java/io/IOException
    //   1281	1287	1472	java/io/IOException
    //   1291	1301	1472	java/io/IOException
    //   1062	1068	1484	java/lang/IllegalArgumentException
    //   1072	1081	1484	java/lang/IllegalArgumentException
    //   1085	1093	1484	java/lang/IllegalArgumentException
    //   1260	1265	1484	java/lang/IllegalArgumentException
    //   1273	1277	1484	java/lang/IllegalArgumentException
    //   1281	1287	1484	java/lang/IllegalArgumentException
    //   1291	1301	1484	java/lang/IllegalArgumentException
    //   1305	1315	1484	java/lang/IllegalArgumentException
    //   1319	1329	1484	java/lang/IllegalArgumentException
    //   1333	1341	1484	java/lang/IllegalArgumentException
    //   1345	1354	1484	java/lang/IllegalArgumentException
    //   1358	1364	1484	java/lang/IllegalArgumentException
    //   1368	1402	1484	java/lang/IllegalArgumentException
    //   1477	1481	1484	java/lang/IllegalArgumentException
    //   1583	1588	1484	java/lang/IllegalArgumentException
    //   1596	1600	1484	java/lang/IllegalArgumentException
    //   1604	1610	1484	java/lang/IllegalArgumentException
    //   1614	1624	1484	java/lang/IllegalArgumentException
    //   1632	1636	1484	java/lang/IllegalArgumentException
    //   1723	1728	1484	java/lang/IllegalArgumentException
    //   1737	1742	1484	java/lang/IllegalArgumentException
    //   1746	1752	1484	java/lang/IllegalArgumentException
    //   1756	1766	1484	java/lang/IllegalArgumentException
    //   1770	1772	1484	java/lang/IllegalArgumentException
    //   1852	1857	1484	java/lang/IllegalArgumentException
    //   1915	1921	1484	java/lang/IllegalArgumentException
    //   1925	1974	1484	java/lang/IllegalArgumentException
    //   1114	1127	1557	java/io/IOException
    //   1134	1142	1557	java/io/IOException
    //   1149	1156	1557	java/io/IOException
    //   1163	1169	1557	java/io/IOException
    //   1176	1210	1557	java/io/IOException
    //   1217	1229	1557	java/io/IOException
    //   1583	1588	1627	java/io/IOException
    //   1596	1600	1627	java/io/IOException
    //   1604	1610	1627	java/io/IOException
    //   1614	1624	1627	java/io/IOException
    //   1062	1068	1639	java/lang/Exception
    //   1072	1081	1639	java/lang/Exception
    //   1085	1093	1639	java/lang/Exception
    //   1260	1265	1639	java/lang/Exception
    //   1273	1277	1639	java/lang/Exception
    //   1281	1287	1639	java/lang/Exception
    //   1291	1301	1639	java/lang/Exception
    //   1305	1315	1639	java/lang/Exception
    //   1319	1329	1639	java/lang/Exception
    //   1333	1341	1639	java/lang/Exception
    //   1345	1354	1639	java/lang/Exception
    //   1358	1364	1639	java/lang/Exception
    //   1368	1402	1639	java/lang/Exception
    //   1477	1481	1639	java/lang/Exception
    //   1583	1588	1639	java/lang/Exception
    //   1596	1600	1639	java/lang/Exception
    //   1604	1610	1639	java/lang/Exception
    //   1614	1624	1639	java/lang/Exception
    //   1632	1636	1639	java/lang/Exception
    //   1723	1728	1639	java/lang/Exception
    //   1737	1742	1639	java/lang/Exception
    //   1746	1752	1639	java/lang/Exception
    //   1756	1766	1639	java/lang/Exception
    //   1770	1772	1639	java/lang/Exception
    //   1852	1857	1639	java/lang/Exception
    //   1915	1921	1639	java/lang/Exception
    //   1925	1974	1639	java/lang/Exception
    //   1114	1127	1713	finally
    //   1134	1142	1713	finally
    //   1149	1156	1713	finally
    //   1163	1169	1713	finally
    //   1176	1210	1713	finally
    //   1217	1229	1713	finally
    //   1569	1574	1713	finally
    //   1062	1068	1772	java/lang/OutOfMemoryError
    //   1072	1081	1772	java/lang/OutOfMemoryError
    //   1085	1093	1772	java/lang/OutOfMemoryError
    //   1260	1265	1772	java/lang/OutOfMemoryError
    //   1273	1277	1772	java/lang/OutOfMemoryError
    //   1281	1287	1772	java/lang/OutOfMemoryError
    //   1291	1301	1772	java/lang/OutOfMemoryError
    //   1305	1315	1772	java/lang/OutOfMemoryError
    //   1319	1329	1772	java/lang/OutOfMemoryError
    //   1333	1341	1772	java/lang/OutOfMemoryError
    //   1345	1354	1772	java/lang/OutOfMemoryError
    //   1358	1364	1772	java/lang/OutOfMemoryError
    //   1368	1402	1772	java/lang/OutOfMemoryError
    //   1477	1481	1772	java/lang/OutOfMemoryError
    //   1583	1588	1772	java/lang/OutOfMemoryError
    //   1596	1600	1772	java/lang/OutOfMemoryError
    //   1604	1610	1772	java/lang/OutOfMemoryError
    //   1614	1624	1772	java/lang/OutOfMemoryError
    //   1632	1636	1772	java/lang/OutOfMemoryError
    //   1723	1728	1772	java/lang/OutOfMemoryError
    //   1737	1742	1772	java/lang/OutOfMemoryError
    //   1746	1752	1772	java/lang/OutOfMemoryError
    //   1756	1766	1772	java/lang/OutOfMemoryError
    //   1770	1772	1772	java/lang/OutOfMemoryError
    //   1852	1857	1772	java/lang/OutOfMemoryError
    //   1915	1921	1772	java/lang/OutOfMemoryError
    //   1925	1974	1772	java/lang/OutOfMemoryError
    //   1723	1728	1846	java/io/IOException
    //   1737	1742	1846	java/io/IOException
    //   1746	1752	1846	java/io/IOException
    //   1756	1766	1846	java/io/IOException
    //   1062	1068	1860	finally
    //   1072	1081	1860	finally
    //   1085	1093	1860	finally
    //   1260	1265	1860	finally
    //   1273	1277	1860	finally
    //   1281	1287	1860	finally
    //   1291	1301	1860	finally
    //   1305	1315	1860	finally
    //   1319	1329	1860	finally
    //   1333	1341	1860	finally
    //   1345	1354	1860	finally
    //   1358	1364	1860	finally
    //   1368	1402	1860	finally
    //   1477	1481	1860	finally
    //   1583	1588	1860	finally
    //   1596	1600	1860	finally
    //   1604	1610	1860	finally
    //   1614	1624	1860	finally
    //   1632	1636	1860	finally
    //   1648	1658	1860	finally
    //   1662	1666	1860	finally
    //   1723	1728	1860	finally
    //   1737	1742	1860	finally
    //   1746	1752	1860	finally
    //   1756	1766	1860	finally
    //   1770	1772	1860	finally
    //   1781	1791	1860	finally
    //   1795	1799	1860	finally
    //   1852	1857	1860	finally
    //   1915	1921	1860	finally
    //   1925	1974	1860	finally
    //   82	87	3204	java/lang/Throwable
    //   93	128	3204	java/lang/Throwable
    //   128	137	3204	java/lang/Throwable
    //   1408	1422	3208	finally
    //   1492	1502	3208	finally
    //   1506	1510	3208	finally
    //   1408	1422	3212	java/lang/OutOfMemoryError
    //   1408	1422	3219	java/lang/Exception
    //   1408	1422	3226	java/lang/IllegalArgumentException
    //   1229	1239	3230	finally
    //   1239	1251	3245	finally
    //   1229	1239	3256	java/io/IOException
    //   1239	1251	3261	java/io/IOException
  }
  
  /* Error */
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iload_2
    //   3: iload_3
    //   4: invokespecial 788	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:onActivityResult	(Landroid/content/Intent;BI)V
    //   7: aconst_null
    //   8: astore 9
    //   10: aload_1
    //   11: ifnonnull +13 -> 24
    //   14: ldc 34
    //   16: iconst_1
    //   17: ldc_w 790
    //   20: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: return
    //   24: aload 9
    //   26: astore 8
    //   28: aload_1
    //   29: invokevirtual 794	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   32: ifnonnull +51 -> 83
    //   35: aload 9
    //   37: astore 8
    //   39: ldc 34
    //   41: iconst_1
    //   42: ldc_w 796
    //   45: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: return
    //   49: astore_1
    //   50: ldc 34
    //   52: iconst_1
    //   53: ldc_w 798
    //   56: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   79: invokevirtual 691	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
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
    //   107: getfield 437	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mLocationCallback	Ljava/lang/String;
    //   110: astore 9
    //   112: aload 9
    //   114: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   117: ifeq +13 -> 130
    //   120: ldc 34
    //   122: iconst_1
    //   123: ldc_w 800
    //   126: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: return
    //   130: aload_1
    //   131: ldc_w 802
    //   134: invokevirtual 806	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   137: checkcast 808	cooperation/qzone/LbsDataV2$PoiInfo
    //   140: astore_1
    //   141: aload_1
    //   142: ifnonnull +116 -> 258
    //   145: ldc 34
    //   147: iconst_1
    //   148: ldc_w 810
    //   151: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   179: invokevirtual 691	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   182: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   185: ifeq -162 -> 23
    //   188: ldc 34
    //   190: iconst_2
    //   191: new 60	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   198: ldc_w 812
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
    //   227: ldc_w 814
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
    //   254: invokevirtual 691	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   257: return
    //   258: aload_0
    //   259: aload_1
    //   260: getfield 817	cooperation/qzone/LbsDataV2$PoiInfo:poiId	Ljava/lang/String;
    //   263: putfield 439	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mCachePoiId	Ljava/lang/String;
    //   266: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq +32 -> 301
    //   272: ldc 34
    //   274: iconst_2
    //   275: new 60	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   282: ldc_w 458
    //   285: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload_0
    //   289: getfield 439	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mCachePoiId	Ljava/lang/String;
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
    //   320: getfield 820	cooperation/qzone/LbsDataV2$PoiInfo:poiName	Ljava/lang/String;
    //   323: ldc_w 821
    //   326: invokestatic 588	ajyc:a	(I)Ljava/lang/String;
    //   329: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   332: ifne +29 -> 361
    //   335: aload 8
    //   337: ldc_w 338
    //   340: aload_1
    //   341: getfield 820	cooperation/qzone/LbsDataV2$PoiInfo:poiName	Ljava/lang/String;
    //   344: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   347: pop
    //   348: aload 12
    //   350: ldc 165
    //   352: aload 8
    //   354: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   357: pop
    //   358: goto -194 -> 164
    //   361: aload 8
    //   363: ldc_w 338
    //   366: ldc_w 451
    //   369: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   372: pop
    //   373: goto -25 -> 348
    //   376: iload_2
    //   377: bipush 101
    //   379: if_icmpne -356 -> 23
    //   382: aload 9
    //   384: astore 8
    //   386: aload_0
    //   387: getfield 485	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mActionCallback	Ljava/lang/String;
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
    //   411: ldc_w 823
    //   414: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: return
    //   418: aload 9
    //   420: astore 8
    //   422: aload_1
    //   423: ldc 17
    //   425: lconst_0
    //   426: invokevirtual 827	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   429: lstore 4
    //   431: aload 9
    //   433: astore 8
    //   435: aload_1
    //   436: ldc 20
    //   438: invokevirtual 830	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   441: astore 10
    //   443: aload 10
    //   445: ifnonnull +340 -> 785
    //   448: ldc_w 451
    //   451: astore 10
    //   453: aload 9
    //   455: astore 8
    //   457: aload_1
    //   458: ldc 23
    //   460: lconst_0
    //   461: invokevirtual 827	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   464: lstore 6
    //   466: aload 9
    //   468: astore 8
    //   470: aload_1
    //   471: ldc 26
    //   473: invokevirtual 830	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   476: astore 11
    //   478: aload 11
    //   480: astore_1
    //   481: aload 11
    //   483: ifnonnull +7 -> 490
    //   486: ldc_w 451
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
    //   530: invokevirtual 691	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
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
    //   557: ldc_w 832
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
    //   610: ldc_w 366
    //   613: lload 4
    //   615: invokestatic 837	java/lang/Long:toString	(J)Ljava/lang/String;
    //   618: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   621: pop
    //   622: aload 9
    //   624: astore 8
    //   626: aload 13
    //   628: ldc_w 370
    //   631: aload 10
    //   633: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   636: pop
    //   637: aload 9
    //   639: astore 8
    //   641: aload 13
    //   643: ldc_w 374
    //   646: lload 6
    //   648: invokestatic 837	java/lang/Long:toString	(J)Ljava/lang/String;
    //   651: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   654: pop
    //   655: aload 9
    //   657: astore 8
    //   659: aload 13
    //   661: ldc_w 378
    //   664: aload_1
    //   665: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   668: pop
    //   669: aload 9
    //   671: astore 8
    //   673: aload 11
    //   675: ldc_w 359
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
    //   730: invokevirtual 691	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
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
    //   757: ldc_w 832
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.SignJsPlugin
 * JD-Core Version:    0.7.0.1
 */