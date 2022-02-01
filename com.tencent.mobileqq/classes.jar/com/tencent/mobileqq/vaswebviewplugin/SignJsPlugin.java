package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
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
  private final String SIGNATURE_SYNC_IMG_TEMP_FILE;
  private final String SIGNATURE_SYNC_IMG_TEMP_PATH;
  private BrowserAppInterface browserApp;
  private EIPCResultCallback getSignatureCallback;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_SIGNATURE_TEMPLATE_ROOT);
    localStringBuilder.append("temp/");
    this.SIGNATURE_SYNC_IMG_TEMP_PATH = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.SIGNATURE_SYNC_IMG_TEMP_PATH);
    localStringBuilder.append("temp.png");
    this.SIGNATURE_SYNC_IMG_TEMP_FILE = localStringBuilder.toString();
    this.getSignatureCallback = new SignJsPlugin.1(this);
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
      } else {
        localJSONObject1.put("result", i);
      }
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
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("handleChangeStatusCallback Result = ");
        paramBundle.append(localJSONObject1.toString());
        QLog.d("SignJsPlugin", 2, paramBundle.toString());
        return;
      }
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
        if ((paramString instanceof Bundle)) {
          handleChangeStatusCallback((Bundle)paramString, this.mPublishCallback);
        } else {
          super.callJs(this.mPublishCallback, new String[] { "{\"result\": -1}" });
        }
        this.mPublishCallback = null;
        return false;
      }
    }
    else if (paramLong == 8589934618L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SignJsPlugin", 2, "change status callback");
      }
      if (!TextUtils.isEmpty(this.mContentChangeCallback))
      {
        super.callJs(this.mContentChangeCallback, new String[] { "{\"result\": 0}" });
        return false;
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
    return false;
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 8589934619L;
  }
  
  /* Error */
  protected boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +3226 -> 3230
    //   7: ldc 14
    //   9: aload_3
    //   10: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13: ifeq +3217 -> 3230
    //   16: aload 4
    //   18: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifeq +6 -> 27
    //   24: goto +3206 -> 3230
    //   27: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +64 -> 94
    //   33: new 60	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   40: astore_1
    //   41: aload_1
    //   42: ldc_w 307
    //   45: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_1
    //   50: aload_2
    //   51: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_1
    //   56: ldc_w 309
    //   59: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload_1
    //   64: aload_3
    //   65: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_1
    //   70: ldc_w 311
    //   73: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_1
    //   78: aload 4
    //   80: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: ldc 34
    //   86: iconst_2
    //   87: aload_1
    //   88: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: aload_2
    //   95: invokestatic 317	com/tencent/mobileqq/webview/swift/WebViewPlugin:getJsonFromJSBridge	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   98: astore_1
    //   99: aload_1
    //   100: ifnonnull +5 -> 105
    //   103: iconst_1
    //   104: ireturn
    //   105: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   108: istore 11
    //   110: iload 11
    //   112: ifeq +52 -> 164
    //   115: new 60	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   122: astore 5
    //   124: aload 5
    //   126: ldc_w 319
    //   129: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 5
    //   135: aload_1
    //   136: invokevirtual 174	org/json/JSONObject:toString	()Ljava/lang/String;
    //   139: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: ldc 34
    //   145: iconst_2
    //   146: aload 5
    //   148: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: goto +10 -> 164
    //   157: astore_1
    //   158: aconst_null
    //   159: astore 5
    //   161: goto +2954 -> 3115
    //   164: aload_1
    //   165: ldc_w 321
    //   168: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   171: astore 15
    //   173: aload 15
    //   175: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   178: ifeq +14 -> 192
    //   181: ldc 34
    //   183: iconst_1
    //   184: ldc_w 326
    //   187: invokestatic 328	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: iconst_1
    //   191: ireturn
    //   192: ldc_w 330
    //   195: aload 4
    //   197: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   200: istore 11
    //   202: iload 11
    //   204: ifeq +305 -> 509
    //   207: aload_1
    //   208: ldc_w 332
    //   211: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   214: astore 5
    //   216: aload 5
    //   218: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   221: ifne +271 -> 492
    //   224: aload 5
    //   226: invokestatic 335	android/text/TextUtils:isDigitsOnly	(Ljava/lang/CharSequence;)Z
    //   229: ifne +6 -> 235
    //   232: goto +260 -> 492
    //   235: aload 5
    //   237: invokestatic 338	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   240: istore 6
    //   242: aload_1
    //   243: ldc_w 340
    //   246: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   249: astore 5
    //   251: aload_1
    //   252: ldc_w 342
    //   255: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   258: astore 12
    //   260: aload_1
    //   261: ldc_w 344
    //   264: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   267: astore 13
    //   269: aload_1
    //   270: ldc_w 346
    //   273: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   276: astore 14
    //   278: aload_0
    //   279: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   282: invokevirtual 351	android/os/Bundle:clear	()V
    //   285: aload_0
    //   286: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   289: ldc_w 332
    //   292: iload 6
    //   294: invokevirtual 355	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   297: aload_0
    //   298: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   301: ldc_w 357
    //   304: aload 5
    //   306: invokevirtual 361	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   309: aload_0
    //   310: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   313: ldc_w 342
    //   316: aload 12
    //   318: invokevirtual 361	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   321: aload_0
    //   322: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   325: ldc_w 344
    //   328: aload 13
    //   330: invokevirtual 361	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   333: aload_0
    //   334: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   337: ldc_w 346
    //   340: aload 14
    //   342: invokevirtual 361	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   345: aload_1
    //   346: ldc_w 363
    //   349: invokevirtual 366	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   352: astore 5
    //   354: aload 5
    //   356: ifnull +75 -> 431
    //   359: aload_0
    //   360: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   363: ldc_w 368
    //   366: aload 5
    //   368: ldc_w 370
    //   371: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   374: invokevirtual 361	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   377: aload_0
    //   378: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   381: ldc_w 372
    //   384: aload 5
    //   386: ldc_w 374
    //   389: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   392: invokevirtual 361	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   395: aload_0
    //   396: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   399: ldc_w 376
    //   402: aload 5
    //   404: ldc_w 378
    //   407: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   410: invokevirtual 361	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   413: aload_0
    //   414: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   417: ldc_w 380
    //   420: aload 5
    //   422: ldc_w 382
    //   425: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   428: invokevirtual 361	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   431: aload_1
    //   432: ldc_w 384
    //   435: invokevirtual 388	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   438: astore_1
    //   439: aload_1
    //   440: ifnull +24 -> 464
    //   443: aload_1
    //   444: invokevirtual 394	org/json/JSONArray:length	()I
    //   447: ifle +17 -> 464
    //   450: aload_0
    //   451: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   454: ldc_w 396
    //   457: aload_1
    //   458: invokevirtual 397	org/json/JSONArray:toString	()Ljava/lang/String;
    //   461: invokevirtual 361	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   464: aload_0
    //   465: ldc_w 399
    //   468: aload 15
    //   470: aload_0
    //   471: getfield 403	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/OnRemoteRespObserver;
    //   474: getfield 408	com/tencent/mobileqq/emosm/OnRemoteRespObserver:key	I
    //   477: aload_0
    //   478: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   481: invokestatic 413	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   484: iconst_0
    //   485: iconst_1
    //   486: invokespecial 417	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:sendRemoteReq	(Landroid/os/Bundle;ZZ)V
    //   489: goto +2739 -> 3228
    //   492: aload_0
    //   493: aload 15
    //   495: iconst_1
    //   496: anewarray 173	java/lang/String
    //   499: dup
    //   500: iconst_0
    //   501: ldc 198
    //   503: aastore
    //   504: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   507: iconst_1
    //   508: ireturn
    //   509: ldc_w 419
    //   512: aload 4
    //   514: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   517: ifeq +218 -> 735
    //   520: invokestatic 425	cooperation/qzone/QZoneHelper$UserInfo:getInstance	()Lcooperation/qzone/QZoneHelper$UserInfo;
    //   523: astore 12
    //   525: aload 12
    //   527: aload_0
    //   528: getfield 427	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:browserApp	Lcom/tencent/mobileqq/app/BrowserAppInterface;
    //   531: invokevirtual 432	com/tencent/mobileqq/app/BrowserAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   534: putfield 435	cooperation/qzone/QZoneHelper$UserInfo:qzone_uin	Ljava/lang/String;
    //   537: aload 12
    //   539: aload_0
    //   540: getfield 427	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:browserApp	Lcom/tencent/mobileqq/app/BrowserAppInterface;
    //   543: invokevirtual 438	com/tencent/mobileqq/app/BrowserAppInterface:getCurrentNickname	()Ljava/lang/String;
    //   546: putfield 441	cooperation/qzone/QZoneHelper$UserInfo:nickname	Ljava/lang/String;
    //   549: aload_0
    //   550: aload 15
    //   552: putfield 443	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mLocationCallback	Ljava/lang/String;
    //   555: aload_0
    //   556: getfield 445	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mCachePoiId	Ljava/lang/String;
    //   559: astore 5
    //   561: aload 5
    //   563: astore_1
    //   564: aload 5
    //   566: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   569: ifeq +62 -> 631
    //   572: aload_0
    //   573: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   576: invokevirtual 448	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   579: invokevirtual 454	com/tencent/common/app/AppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   582: astore_1
    //   583: new 60	java/lang/StringBuilder
    //   586: dup
    //   587: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   590: astore 5
    //   592: aload 5
    //   594: ldc 11
    //   596: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: pop
    //   600: aload 5
    //   602: aload_0
    //   603: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   606: invokevirtual 448	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   609: invokevirtual 455	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   612: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: pop
    //   616: aload_1
    //   617: aload 5
    //   619: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   622: ldc_w 457
    //   625: invokeinterface 462 3 0
    //   630: astore_1
    //   631: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   634: ifeq +39 -> 673
    //   637: new 60	java/lang/StringBuilder
    //   640: dup
    //   641: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   644: astore 5
    //   646: aload 5
    //   648: ldc_w 464
    //   651: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: pop
    //   655: aload 5
    //   657: aload_1
    //   658: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: pop
    //   662: ldc 34
    //   664: iconst_2
    //   665: aload 5
    //   667: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   670: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   673: new 108	android/os/Bundle
    //   676: dup
    //   677: invokespecial 465	android/os/Bundle:<init>	()V
    //   680: astore 5
    //   682: aload_1
    //   683: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   686: ifne +21 -> 707
    //   689: aload 5
    //   691: ldc_w 467
    //   694: iconst_1
    //   695: invokevirtual 355	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   698: aload 5
    //   700: ldc_w 469
    //   703: aload_1
    //   704: invokevirtual 361	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   707: aload_0
    //   708: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   711: invokevirtual 279	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   714: aload 12
    //   716: ldc 14
    //   718: invokestatic 473	com/tencent/mobileqq/webview/swift/WebViewUtil:a	(Ljava/lang/String;)I
    //   721: bipush 8
    //   723: ishl
    //   724: bipush 100
    //   726: iadd
    //   727: aload 5
    //   729: invokestatic 479	cooperation/qzone/QZoneHelper:forwardToMoodSelectLocation	(Landroid/app/Activity;Lcooperation/qzone/QZoneHelper$UserInfo;ILandroid/os/Bundle;)V
    //   732: goto +2496 -> 3228
    //   735: ldc_w 481
    //   738: aload 4
    //   740: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   743: ifeq +37 -> 780
    //   746: new 236	android/content/Intent
    //   749: dup
    //   750: aload_0
    //   751: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   754: invokevirtual 279	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   757: ldc_w 483
    //   760: invokespecial 486	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   763: astore_1
    //   764: aload_0
    //   765: aload 15
    //   767: putfield 488	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mActionCallback	Ljava/lang/String;
    //   770: aload_0
    //   771: aload_1
    //   772: bipush 101
    //   774: invokespecial 492	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   777: goto +2451 -> 3228
    //   780: ldc_w 494
    //   783: aload 4
    //   785: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   788: ifeq +126 -> 914
    //   791: aload_1
    //   792: ldc_w 496
    //   795: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   798: astore 5
    //   800: aload_1
    //   801: ldc_w 498
    //   804: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   807: astore 12
    //   809: aload 5
    //   811: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   814: ifeq +20 -> 834
    //   817: aload_0
    //   818: aload 15
    //   820: iconst_1
    //   821: anewarray 173	java/lang/String
    //   824: dup
    //   825: iconst_0
    //   826: ldc 198
    //   828: aastore
    //   829: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   832: iconst_1
    //   833: ireturn
    //   834: aload_1
    //   835: ldc_w 500
    //   838: invokevirtual 503	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   841: istore 6
    //   843: aload_0
    //   844: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   847: invokevirtual 351	android/os/Bundle:clear	()V
    //   850: aload_0
    //   851: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   854: ldc_w 496
    //   857: aload 5
    //   859: invokevirtual 361	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   862: aload_0
    //   863: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   866: ldc_w 498
    //   869: aload 12
    //   871: invokevirtual 361	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   874: aload_0
    //   875: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   878: ldc_w 500
    //   881: iload 6
    //   883: invokevirtual 355	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   886: aload_0
    //   887: ldc_w 505
    //   890: aload 15
    //   892: aload_0
    //   893: getfield 403	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/OnRemoteRespObserver;
    //   896: getfield 408	com/tencent/mobileqq/emosm/OnRemoteRespObserver:key	I
    //   899: aload_0
    //   900: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   903: invokestatic 413	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   906: iconst_0
    //   907: iconst_1
    //   908: invokespecial 417	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:sendRemoteReq	(Landroid/os/Bundle;ZZ)V
    //   911: goto +2317 -> 3228
    //   914: ldc_w 507
    //   917: aload 4
    //   919: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   922: ifeq +947 -> 1869
    //   925: aload_1
    //   926: ldc_w 509
    //   929: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   932: astore 5
    //   934: aload_1
    //   935: ldc_w 357
    //   938: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   941: astore 16
    //   943: aload_0
    //   944: getfield 511	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:isSync	Z
    //   947: istore 11
    //   949: iload 11
    //   951: ifeq +2277 -> 3228
    //   954: aload 5
    //   956: ifnull +847 -> 1803
    //   959: aload 5
    //   961: ifnull +18 -> 979
    //   964: aload 5
    //   966: invokevirtual 513	java/lang/String:isEmpty	()Z
    //   969: istore 11
    //   971: iload 11
    //   973: ifeq +6 -> 979
    //   976: goto +827 -> 1803
    //   979: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   982: ifeq +12 -> 994
    //   985: ldc_w 515
    //   988: iconst_4
    //   989: aload 5
    //   991: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   994: aload 5
    //   996: iconst_2
    //   997: invokestatic 521	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   1000: astore 14
    //   1002: new 523	java/io/File
    //   1005: dup
    //   1006: aload_0
    //   1007: getfield 78	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:SIGNATURE_SYNC_IMG_TEMP_PATH	Ljava/lang/String;
    //   1010: invokespecial 526	java/io/File:<init>	(Ljava/lang/String;)V
    //   1013: astore_1
    //   1014: aload_1
    //   1015: invokevirtual 529	java/io/File:exists	()Z
    //   1018: ifne +57 -> 1075
    //   1021: aload_1
    //   1022: invokevirtual 532	java/io/File:mkdirs	()Z
    //   1025: istore 11
    //   1027: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1030: ifeq +45 -> 1075
    //   1033: new 60	java/lang/StringBuilder
    //   1036: dup
    //   1037: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1040: astore_1
    //   1041: aload_1
    //   1042: ldc_w 534
    //   1045: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: pop
    //   1049: aload_1
    //   1050: iload 11
    //   1052: invokevirtual 537	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1055: pop
    //   1056: aload_1
    //   1057: ldc_w 539
    //   1060: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1063: pop
    //   1064: ldc_w 515
    //   1067: iconst_2
    //   1068: aload_1
    //   1069: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1072: invokestatic 258	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1075: new 541	java/io/FileOutputStream
    //   1078: dup
    //   1079: aload_0
    //   1080: getfield 82	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:SIGNATURE_SYNC_IMG_TEMP_FILE	Ljava/lang/String;
    //   1083: invokespecial 542	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   1086: astore_1
    //   1087: new 544	java/io/BufferedOutputStream
    //   1090: dup
    //   1091: aload_1
    //   1092: invokespecial 547	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1095: astore 13
    //   1097: aload_1
    //   1098: astore 5
    //   1100: aload 13
    //   1102: astore 12
    //   1104: aload 13
    //   1106: aload 14
    //   1108: invokevirtual 551	java/io/BufferedOutputStream:write	([B)V
    //   1111: aload_1
    //   1112: astore 5
    //   1114: aload 13
    //   1116: astore 12
    //   1118: aload 13
    //   1120: invokevirtual 554	java/io/BufferedOutputStream:flush	()V
    //   1123: aload 13
    //   1125: invokevirtual 557	java/io/BufferedOutputStream:close	()V
    //   1128: aload_1
    //   1129: invokevirtual 558	java/io/FileOutputStream:close	()V
    //   1132: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1135: ifeq +112 -> 1247
    //   1138: ldc_w 515
    //   1141: iconst_2
    //   1142: ldc_w 560
    //   1145: invokestatic 258	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1148: goto +99 -> 1247
    //   1151: astore_1
    //   1152: aload_1
    //   1153: invokevirtual 563	java/io/IOException:printStackTrace	()V
    //   1156: goto +91 -> 1247
    //   1159: astore 14
    //   1161: goto +37 -> 1198
    //   1164: astore 5
    //   1166: goto +12 -> 1178
    //   1169: astore 5
    //   1171: goto +20 -> 1191
    //   1174: astore 5
    //   1176: aconst_null
    //   1177: astore_1
    //   1178: aconst_null
    //   1179: astore 13
    //   1181: aload_1
    //   1182: astore 12
    //   1184: goto +328 -> 1512
    //   1187: astore 5
    //   1189: aconst_null
    //   1190: astore_1
    //   1191: aconst_null
    //   1192: astore 13
    //   1194: aload 5
    //   1196: astore 14
    //   1198: aload_1
    //   1199: astore 5
    //   1201: aload 13
    //   1203: astore 12
    //   1205: aload 14
    //   1207: invokevirtual 563	java/io/IOException:printStackTrace	()V
    //   1210: aload 13
    //   1212: ifnull +11 -> 1223
    //   1215: aload 13
    //   1217: invokevirtual 557	java/io/BufferedOutputStream:close	()V
    //   1220: goto +3 -> 1223
    //   1223: aload_1
    //   1224: ifnull +7 -> 1231
    //   1227: aload_1
    //   1228: invokevirtual 558	java/io/FileOutputStream:close	()V
    //   1231: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1234: ifeq +13 -> 1247
    //   1237: ldc_w 515
    //   1240: iconst_2
    //   1241: ldc_w 560
    //   1244: invokestatic 258	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1247: aload_0
    //   1248: getfield 82	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:SIGNATURE_SYNC_IMG_TEMP_FILE	Ljava/lang/String;
    //   1251: invokestatic 568	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   1254: ifeq +128 -> 1382
    //   1257: aload_0
    //   1258: getfield 82	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:SIGNATURE_SYNC_IMG_TEMP_FILE	Ljava/lang/String;
    //   1261: invokestatic 571	com/tencent/mobileqq/utils/FileUtils:isPicFile	(Ljava/lang/String;)Z
    //   1264: ifeq +118 -> 1382
    //   1267: new 573	java/util/ArrayList
    //   1270: dup
    //   1271: invokespecial 574	java/util/ArrayList:<init>	()V
    //   1274: astore_1
    //   1275: aload_1
    //   1276: aload_0
    //   1277: getfield 82	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:SIGNATURE_SYNC_IMG_TEMP_FILE	Ljava/lang/String;
    //   1280: invokevirtual 577	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1283: pop
    //   1284: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1287: ifeq +47 -> 1334
    //   1290: new 60	java/lang/StringBuilder
    //   1293: dup
    //   1294: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1297: astore 5
    //   1299: aload 5
    //   1301: ldc_w 579
    //   1304: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1307: pop
    //   1308: aload 5
    //   1310: aload_1
    //   1311: iconst_0
    //   1312: invokevirtual 582	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1315: checkcast 173	java/lang/String
    //   1318: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1321: pop
    //   1322: ldc_w 515
    //   1325: iconst_2
    //   1326: aload 5
    //   1328: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1331: invokestatic 258	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1334: ldc_w 583
    //   1337: invokestatic 588	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1340: aload_1
    //   1341: ldc_w 590
    //   1344: iconst_3
    //   1345: invokestatic 594	cooperation/qzone/QZoneHelper:publishPictureMoodSilently	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;I)V
    //   1348: iconst_1
    //   1349: istore 6
    //   1351: goto +99 -> 1450
    //   1354: astore_1
    //   1355: iconst_1
    //   1356: istore 6
    //   1358: goto +399 -> 1757
    //   1361: astore_1
    //   1362: iconst_1
    //   1363: istore 7
    //   1365: goto +207 -> 1572
    //   1368: astore_1
    //   1369: iconst_1
    //   1370: istore 7
    //   1372: goto +263 -> 1635
    //   1375: astore_1
    //   1376: iconst_1
    //   1377: istore 7
    //   1379: goto +319 -> 1698
    //   1382: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1385: ifeq +62 -> 1447
    //   1388: new 60	java/lang/StringBuilder
    //   1391: dup
    //   1392: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1395: astore_1
    //   1396: aload_1
    //   1397: ldc_w 596
    //   1400: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1403: pop
    //   1404: aload_1
    //   1405: aload_0
    //   1406: getfield 82	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:SIGNATURE_SYNC_IMG_TEMP_FILE	Ljava/lang/String;
    //   1409: invokestatic 568	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   1412: invokevirtual 537	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1415: pop
    //   1416: aload_1
    //   1417: ldc_w 598
    //   1420: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1423: pop
    //   1424: aload_1
    //   1425: aload_0
    //   1426: getfield 82	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:SIGNATURE_SYNC_IMG_TEMP_FILE	Ljava/lang/String;
    //   1429: invokestatic 571	com/tencent/mobileqq/utils/FileUtils:isPicFile	(Ljava/lang/String;)Z
    //   1432: invokevirtual 537	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1435: pop
    //   1436: ldc_w 515
    //   1439: iconst_2
    //   1440: aload_1
    //   1441: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1444: invokestatic 258	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1447: iconst_0
    //   1448: istore 6
    //   1450: iload 6
    //   1452: ifne +1776 -> 3228
    //   1455: aload 16
    //   1457: ifnull +1771 -> 3228
    //   1460: aload 16
    //   1462: invokevirtual 513	java/lang/String:isEmpty	()Z
    //   1465: ifne +1763 -> 3228
    //   1468: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1471: ifeq +1765 -> 3236
    //   1474: ldc_w 515
    //   1477: iconst_4
    //   1478: ldc_w 600
    //   1481: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1484: goto +1752 -> 3236
    //   1487: aload 16
    //   1489: aconst_null
    //   1490: ldc_w 590
    //   1493: iconst_3
    //   1494: invokestatic 594	cooperation/qzone/QZoneHelper:publishPictureMoodSilently	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;I)V
    //   1497: goto +1731 -> 3228
    //   1500: astore_1
    //   1501: aload 12
    //   1503: astore 13
    //   1505: aload 5
    //   1507: astore 12
    //   1509: aload_1
    //   1510: astore 5
    //   1512: aload 13
    //   1514: ifnull +11 -> 1525
    //   1517: aload 13
    //   1519: invokevirtual 557	java/io/BufferedOutputStream:close	()V
    //   1522: goto +3 -> 1525
    //   1525: aload 12
    //   1527: ifnull +8 -> 1535
    //   1530: aload 12
    //   1532: invokevirtual 558	java/io/FileOutputStream:close	()V
    //   1535: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1538: ifeq +20 -> 1558
    //   1541: ldc_w 515
    //   1544: iconst_2
    //   1545: ldc_w 560
    //   1548: invokestatic 258	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1551: goto +7 -> 1558
    //   1554: aload_1
    //   1555: invokevirtual 563	java/io/IOException:printStackTrace	()V
    //   1558: aload 5
    //   1560: athrow
    //   1561: astore_1
    //   1562: iconst_0
    //   1563: istore 6
    //   1565: goto +192 -> 1757
    //   1568: astore_1
    //   1569: iconst_0
    //   1570: istore 7
    //   1572: iload 7
    //   1574: istore 6
    //   1576: ldc_w 515
    //   1579: iconst_2
    //   1580: ldc_w 602
    //   1583: invokestatic 328	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1586: iload 7
    //   1588: istore 6
    //   1590: aload_1
    //   1591: invokevirtual 603	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1594: iload 7
    //   1596: ifne +1632 -> 3228
    //   1599: aload 16
    //   1601: ifnull +1627 -> 3228
    //   1604: aload 16
    //   1606: invokevirtual 513	java/lang/String:isEmpty	()Z
    //   1609: ifne +1619 -> 3228
    //   1612: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1615: ifeq +13 -> 1628
    //   1618: ldc_w 515
    //   1621: iconst_4
    //   1622: ldc_w 600
    //   1625: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1628: goto -141 -> 1487
    //   1631: astore_1
    //   1632: iconst_0
    //   1633: istore 7
    //   1635: iload 7
    //   1637: istore 6
    //   1639: ldc_w 515
    //   1642: iconst_2
    //   1643: ldc_w 605
    //   1646: invokestatic 328	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1649: iload 7
    //   1651: istore 6
    //   1653: aload_1
    //   1654: invokevirtual 606	java/lang/Exception:printStackTrace	()V
    //   1657: iload 7
    //   1659: ifne +1569 -> 3228
    //   1662: aload 16
    //   1664: ifnull +1564 -> 3228
    //   1667: aload 16
    //   1669: invokevirtual 513	java/lang/String:isEmpty	()Z
    //   1672: ifne +1556 -> 3228
    //   1675: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1678: ifeq +13 -> 1691
    //   1681: ldc_w 515
    //   1684: iconst_4
    //   1685: ldc_w 600
    //   1688: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1691: goto -204 -> 1487
    //   1694: astore_1
    //   1695: iconst_0
    //   1696: istore 7
    //   1698: iload 7
    //   1700: istore 6
    //   1702: ldc_w 515
    //   1705: iconst_2
    //   1706: ldc_w 608
    //   1709: invokestatic 328	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1712: iload 7
    //   1714: istore 6
    //   1716: aload_1
    //   1717: invokevirtual 609	java/lang/IllegalArgumentException:printStackTrace	()V
    //   1720: iload 7
    //   1722: ifne +1506 -> 3228
    //   1725: aload 16
    //   1727: ifnull +1501 -> 3228
    //   1730: aload 16
    //   1732: invokevirtual 513	java/lang/String:isEmpty	()Z
    //   1735: ifne +1493 -> 3228
    //   1738: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1741: ifeq +1502 -> 3243
    //   1744: ldc_w 515
    //   1747: iconst_4
    //   1748: ldc_w 600
    //   1751: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1754: goto +1489 -> 3243
    //   1757: iload 6
    //   1759: ifne +42 -> 1801
    //   1762: aload 16
    //   1764: ifnull +37 -> 1801
    //   1767: aload 16
    //   1769: invokevirtual 513	java/lang/String:isEmpty	()Z
    //   1772: ifne +29 -> 1801
    //   1775: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1778: ifeq +13 -> 1791
    //   1781: ldc_w 515
    //   1784: iconst_4
    //   1785: ldc_w 600
    //   1788: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1791: aload 16
    //   1793: aconst_null
    //   1794: ldc_w 590
    //   1797: iconst_3
    //   1798: invokestatic 594	cooperation/qzone/QZoneHelper:publishPictureMoodSilently	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;I)V
    //   1801: aload_1
    //   1802: athrow
    //   1803: aload 16
    //   1805: ifnull +1423 -> 3228
    //   1808: aload 16
    //   1810: invokevirtual 513	java/lang/String:isEmpty	()Z
    //   1813: ifne +1415 -> 3228
    //   1816: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1819: ifeq +37 -> 1856
    //   1822: new 60	java/lang/StringBuilder
    //   1825: dup
    //   1826: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1829: astore_1
    //   1830: aload_1
    //   1831: ldc_w 611
    //   1834: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1837: pop
    //   1838: aload_1
    //   1839: aload 16
    //   1841: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1844: pop
    //   1845: ldc_w 515
    //   1848: iconst_4
    //   1849: aload_1
    //   1850: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1853: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1856: aload 16
    //   1858: aconst_null
    //   1859: ldc_w 590
    //   1862: iconst_3
    //   1863: invokestatic 594	cooperation/qzone/QZoneHelper:publishPictureMoodSilently	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;I)V
    //   1866: goto +1362 -> 3228
    //   1869: ldc_w 613
    //   1872: aload 4
    //   1874: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1877: ifeq +31 -> 1908
    //   1880: aload_0
    //   1881: ldc_w 615
    //   1884: aload 15
    //   1886: aload_0
    //   1887: getfield 403	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/OnRemoteRespObserver;
    //   1890: getfield 408	com/tencent/mobileqq/emosm/OnRemoteRespObserver:key	I
    //   1893: aload_0
    //   1894: getfield 348	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mReqBundle	Landroid/os/Bundle;
    //   1897: invokestatic 413	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   1900: iconst_0
    //   1901: iconst_1
    //   1902: invokespecial 417	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:sendRemoteReq	(Landroid/os/Bundle;ZZ)V
    //   1905: goto +1323 -> 3228
    //   1908: ldc_w 617
    //   1911: aload 4
    //   1913: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1916: istore 11
    //   1918: iload 11
    //   1920: ifeq +41 -> 1961
    //   1923: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1926: ifeq +12 -> 1938
    //   1929: ldc 34
    //   1931: iconst_2
    //   1932: ldc_w 617
    //   1935: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1938: aload_0
    //   1939: aconst_null
    //   1940: putfield 445	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mCachePoiId	Ljava/lang/String;
    //   1943: aload_0
    //   1944: aload 15
    //   1946: iconst_1
    //   1947: anewarray 173	java/lang/String
    //   1950: dup
    //   1951: iconst_0
    //   1952: ldc 214
    //   1954: aastore
    //   1955: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1958: goto +1270 -> 3228
    //   1961: ldc_w 619
    //   1964: aload 4
    //   1966: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1969: istore 11
    //   1971: iload 11
    //   1973: ifeq +109 -> 2082
    //   1976: aload_1
    //   1977: ldc_w 621
    //   1980: invokevirtual 503	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1983: istore 6
    //   1985: aload_1
    //   1986: ldc_w 623
    //   1989: invokevirtual 503	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1992: istore 7
    //   1994: aload_1
    //   1995: ldc_w 625
    //   1998: invokevirtual 503	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2001: istore 8
    //   2003: aload_1
    //   2004: ldc_w 370
    //   2007: invokevirtual 503	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2010: istore 9
    //   2012: aload_1
    //   2013: ldc_w 374
    //   2016: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2019: astore 5
    //   2021: aload_1
    //   2022: ldc_w 627
    //   2025: invokevirtual 503	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2028: istore 10
    //   2030: aload_0
    //   2031: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2034: invokevirtual 630	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/mobileqq/webview/swift/WebViewProvider;
    //   2037: astore_1
    //   2038: aload_1
    //   2039: instanceof 632
    //   2042: ifeq +22 -> 2064
    //   2045: aload_1
    //   2046: checkcast 632	com/tencent/mobileqq/richstatus/SignatureEditFragment
    //   2049: iload 6
    //   2051: iload 7
    //   2053: iload 8
    //   2055: iload 9
    //   2057: aload 5
    //   2059: iload 10
    //   2061: invokevirtual 635	com/tencent/mobileqq/richstatus/SignatureEditFragment:a	(IIIILjava/lang/String;I)V
    //   2064: aload_0
    //   2065: aload 15
    //   2067: iconst_1
    //   2068: anewarray 173	java/lang/String
    //   2071: dup
    //   2072: iconst_0
    //   2073: ldc 214
    //   2075: aastore
    //   2076: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2079: goto +1149 -> 3228
    //   2082: ldc_w 637
    //   2085: aload 4
    //   2087: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2090: ifeq +301 -> 2391
    //   2093: aload_0
    //   2094: aload 15
    //   2096: putfield 97	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mGetSigInfoCallback	Ljava/lang/String;
    //   2099: invokestatic 642	com/tencent/mobileqq/richstatus/SignatureManagerForTool:a	()Lcom/tencent/mobileqq/richstatus/SignatureManagerForTool;
    //   2102: getfield 645	com/tencent/mobileqq/richstatus/SignatureManagerForTool:a	Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   2105: ifnonnull +23 -> 2128
    //   2108: invokestatic 650	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   2111: ldc_w 652
    //   2114: getstatic 656	com/etrump/mixlayout/VasFontIPCModule:e	Ljava/lang/String;
    //   2117: aconst_null
    //   2118: aload_0
    //   2119: getfield 89	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:getSignatureCallback	Leipc/EIPCResultCallback;
    //   2122: invokevirtual 660	com/tencent/mobileqq/qipc/QIPCClientHelper:callServer	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Leipc/EIPCResultCallback;)V
    //   2125: goto +1103 -> 3228
    //   2128: invokestatic 642	com/tencent/mobileqq/richstatus/SignatureManagerForTool:a	()Lcom/tencent/mobileqq/richstatus/SignatureManagerForTool;
    //   2131: getfield 645	com/tencent/mobileqq/richstatus/SignatureManagerForTool:a	Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   2134: astore 5
    //   2136: new 103	org/json/JSONObject
    //   2139: dup
    //   2140: invokespecial 104	org/json/JSONObject:<init>	()V
    //   2143: astore_1
    //   2144: aload_1
    //   2145: ldc_w 621
    //   2148: aload 5
    //   2150: getfield 665	com/tencent/mobileqq/richstatus/RichStatus:tplId	I
    //   2153: invokevirtual 116	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2156: pop
    //   2157: aload_1
    //   2158: ldc_w 623
    //   2161: aload 5
    //   2163: getfield 667	com/tencent/mobileqq/richstatus/RichStatus:fontId	I
    //   2166: invokevirtual 116	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2169: pop
    //   2170: aload_1
    //   2171: ldc_w 625
    //   2174: aload 5
    //   2176: getfield 669	com/tencent/mobileqq/richstatus/RichStatus:fontType	I
    //   2179: invokevirtual 116	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2182: pop
    //   2183: aload_1
    //   2184: ldc_w 370
    //   2187: aload 5
    //   2189: getfield 671	com/tencent/mobileqq/richstatus/RichStatus:actionId	I
    //   2192: invokevirtual 116	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2195: pop
    //   2196: aload 5
    //   2198: getfield 673	com/tencent/mobileqq/richstatus/RichStatus:actionText	Ljava/lang/String;
    //   2201: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2204: ifne +19 -> 2223
    //   2207: aload_1
    //   2208: ldc_w 675
    //   2211: aload 5
    //   2213: getfield 673	com/tencent/mobileqq/richstatus/RichStatus:actionText	Ljava/lang/String;
    //   2216: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2219: pop
    //   2220: goto +16 -> 2236
    //   2223: aload_1
    //   2224: ldc_w 675
    //   2227: aload 5
    //   2229: invokevirtual 678	com/tencent/mobileqq/richstatus/RichStatus:getPlainText	()Ljava/lang/String;
    //   2232: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2235: pop
    //   2236: invokestatic 642	com/tencent/mobileqq/richstatus/SignatureManagerForTool:a	()Lcom/tencent/mobileqq/richstatus/SignatureManagerForTool;
    //   2239: aload 5
    //   2241: getfield 665	com/tencent/mobileqq/richstatus/RichStatus:tplId	I
    //   2244: invokevirtual 681	com/tencent/mobileqq/richstatus/SignatureManagerForTool:a	(I)Lcom/tencent/mobileqq/vas/SignatureTemplateInfo;
    //   2247: astore 12
    //   2249: aload 12
    //   2251: getfield 686	com/tencent/mobileqq/vas/SignatureTemplateInfo:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   2254: invokevirtual 690	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   2257: ifeq +25 -> 2282
    //   2260: aload 5
    //   2262: getfield 694	com/tencent/mobileqq/richstatus/RichStatus:mStickerInfos	Ljava/util/ArrayList;
    //   2265: ifnull +991 -> 3256
    //   2268: aload 5
    //   2270: getfield 694	com/tencent/mobileqq/richstatus/RichStatus:mStickerInfos	Ljava/util/ArrayList;
    //   2273: invokevirtual 695	java/util/ArrayList:isEmpty	()Z
    //   2276: ifeq +974 -> 3250
    //   2279: goto +977 -> 3256
    //   2282: aload 12
    //   2284: getfield 698	com/tencent/mobileqq/vas/SignatureTemplateInfo:g	I
    //   2287: istore 6
    //   2289: aload_1
    //   2290: ldc_w 700
    //   2293: iload 6
    //   2295: invokevirtual 116	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2298: pop
    //   2299: new 103	org/json/JSONObject
    //   2302: dup
    //   2303: invokespecial 104	org/json/JSONObject:<init>	()V
    //   2306: astore 5
    //   2308: aload 5
    //   2310: ldc 106
    //   2312: iconst_0
    //   2313: invokevirtual 116	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2316: pop
    //   2317: aload 5
    //   2319: ldc 165
    //   2321: aload_1
    //   2322: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2325: pop
    //   2326: aload_0
    //   2327: aload_0
    //   2328: getfield 97	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mGetSigInfoCallback	Ljava/lang/String;
    //   2331: iconst_1
    //   2332: anewarray 173	java/lang/String
    //   2335: dup
    //   2336: iconst_0
    //   2337: aload 5
    //   2339: invokevirtual 174	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2342: aastore
    //   2343: invokevirtual 701	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2346: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2349: ifeq +879 -> 3228
    //   2352: new 60	java/lang/StringBuilder
    //   2355: dup
    //   2356: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   2359: astore_1
    //   2360: aload_1
    //   2361: ldc_w 703
    //   2364: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2367: pop
    //   2368: aload_1
    //   2369: aload 5
    //   2371: invokevirtual 174	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2374: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2377: pop
    //   2378: ldc 34
    //   2380: iconst_2
    //   2381: aload_1
    //   2382: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2385: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2388: goto +840 -> 3228
    //   2391: ldc_w 705
    //   2394: aload 4
    //   2396: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2399: ifeq +32 -> 2431
    //   2402: aload_0
    //   2403: aload_1
    //   2404: ldc_w 707
    //   2407: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2410: putfield 206	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mOpenFontCallback	Ljava/lang/String;
    //   2413: aload_0
    //   2414: aload 15
    //   2416: iconst_1
    //   2417: anewarray 173	java/lang/String
    //   2420: dup
    //   2421: iconst_0
    //   2422: ldc 214
    //   2424: aastore
    //   2425: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2428: goto +800 -> 3228
    //   2431: ldc_w 709
    //   2434: aload 4
    //   2436: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2439: ifeq +34 -> 2473
    //   2442: aload_0
    //   2443: aload 15
    //   2445: putfield 220	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mPublishCallback	Ljava/lang/String;
    //   2448: aload_0
    //   2449: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2452: invokevirtual 630	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/mobileqq/webview/swift/WebViewProvider;
    //   2455: astore_1
    //   2456: aload_1
    //   2457: instanceof 632
    //   2460: ifeq +768 -> 3228
    //   2463: aload_1
    //   2464: checkcast 632	com/tencent/mobileqq/richstatus/SignatureEditFragment
    //   2467: invokevirtual 711	com/tencent/mobileqq/richstatus/SignatureEditFragment:a	()V
    //   2470: goto +758 -> 3228
    //   2473: ldc_w 713
    //   2476: aload 4
    //   2478: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2481: ifeq +72 -> 2553
    //   2484: aload_0
    //   2485: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2488: invokevirtual 630	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/mobileqq/webview/swift/WebViewProvider;
    //   2491: astore_1
    //   2492: aload_1
    //   2493: instanceof 632
    //   2496: ifeq +18 -> 2514
    //   2499: aload_1
    //   2500: checkcast 632	com/tencent/mobileqq/richstatus/SignatureEditFragment
    //   2503: astore_1
    //   2504: invokestatic 642	com/tencent/mobileqq/richstatus/SignatureManagerForTool:a	()Lcom/tencent/mobileqq/richstatus/SignatureManagerForTool;
    //   2507: aload_1
    //   2508: getfield 714	com/tencent/mobileqq/richstatus/SignatureEditFragment:a	Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   2511: invokevirtual 718	com/tencent/mobileqq/richstatus/SignatureManagerForTool:b	(Lcom/tencent/mobileqq/richstatus/RichStatus;)V
    //   2514: aload_0
    //   2515: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2518: invokevirtual 279	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2521: aload_0
    //   2522: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2525: invokevirtual 448	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   2528: iconst_1
    //   2529: ldc_w 457
    //   2532: invokestatic 723	com/tencent/mobileqq/vas/signature/SignatureEditManager:a	(Landroid/app/Activity;Lcom/tencent/common/app/AppInterface;ILjava/lang/String;)V
    //   2535: aload_0
    //   2536: aload 15
    //   2538: iconst_1
    //   2539: anewarray 173	java/lang/String
    //   2542: dup
    //   2543: iconst_0
    //   2544: ldc 214
    //   2546: aastore
    //   2547: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2550: goto +678 -> 3228
    //   2553: ldc_w 725
    //   2556: aload 4
    //   2558: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2561: ifeq +40 -> 2601
    //   2564: aload_1
    //   2565: ldc_w 727
    //   2568: iconst_0
    //   2569: invokevirtual 730	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   2572: istore 11
    //   2574: aload_0
    //   2575: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2578: invokevirtual 630	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/mobileqq/webview/swift/WebViewProvider;
    //   2581: astore_1
    //   2582: aload_1
    //   2583: instanceof 632
    //   2586: ifeq +642 -> 3228
    //   2589: aload_1
    //   2590: checkcast 632	com/tencent/mobileqq/richstatus/SignatureEditFragment
    //   2593: iload 11
    //   2595: invokevirtual 733	com/tencent/mobileqq/richstatus/SignatureEditFragment:a	(Z)V
    //   2598: goto +630 -> 3228
    //   2601: ldc_w 735
    //   2604: aload 4
    //   2606: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2609: ifeq +95 -> 2704
    //   2612: aload_1
    //   2613: ldc_w 737
    //   2616: iconst_m1
    //   2617: invokevirtual 740	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2620: istore 6
    //   2622: aload_1
    //   2623: ldc_w 623
    //   2626: iconst_m1
    //   2627: invokevirtual 740	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2630: istore 7
    //   2632: new 108	android/os/Bundle
    //   2635: dup
    //   2636: invokespecial 465	android/os/Bundle:<init>	()V
    //   2639: astore 5
    //   2641: aload 5
    //   2643: ldc_w 742
    //   2646: aload_1
    //   2647: ldc 159
    //   2649: ldc_w 744
    //   2652: invokevirtual 746	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2655: invokevirtual 361	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2658: aload_0
    //   2659: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2662: invokevirtual 279	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2665: aload_0
    //   2666: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2669: invokevirtual 448	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   2672: iconst_0
    //   2673: ldc_w 748
    //   2676: iconst_m1
    //   2677: iload 6
    //   2679: iload 7
    //   2681: aload 5
    //   2683: invokestatic 751	com/tencent/mobileqq/vas/signature/SignatureEditManager:a	(Landroid/app/Activity;Lcom/tencent/common/app/AppInterface;ILjava/lang/String;IIILandroid/os/Bundle;)V
    //   2686: aload_0
    //   2687: aload 15
    //   2689: iconst_1
    //   2690: anewarray 173	java/lang/String
    //   2693: dup
    //   2694: iconst_0
    //   2695: ldc 214
    //   2697: aastore
    //   2698: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2701: goto +527 -> 3228
    //   2704: ldc_w 753
    //   2707: aload 4
    //   2709: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2712: ifeq +32 -> 2744
    //   2715: aload_0
    //   2716: aload_1
    //   2717: ldc_w 755
    //   2720: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2723: putfield 232	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mContentChangeCallback	Ljava/lang/String;
    //   2726: aload_0
    //   2727: aload 15
    //   2729: iconst_1
    //   2730: anewarray 173	java/lang/String
    //   2733: dup
    //   2734: iconst_0
    //   2735: ldc 214
    //   2737: aastore
    //   2738: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2741: goto +487 -> 3228
    //   2744: ldc_w 757
    //   2747: aload 4
    //   2749: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2752: ifeq +76 -> 2828
    //   2755: aload_0
    //   2756: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2759: invokevirtual 630	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/mobileqq/webview/swift/WebViewProvider;
    //   2762: astore_1
    //   2763: aload_1
    //   2764: instanceof 632
    //   2767: ifeq +42 -> 2809
    //   2770: aload_0
    //   2771: aload 15
    //   2773: iconst_1
    //   2774: anewarray 173	java/lang/String
    //   2777: dup
    //   2778: iconst_0
    //   2779: ldc_w 759
    //   2782: iconst_1
    //   2783: anewarray 245	java/lang/Object
    //   2786: dup
    //   2787: iconst_0
    //   2788: aload_1
    //   2789: checkcast 632	com/tencent/mobileqq/richstatus/SignatureEditFragment
    //   2792: invokevirtual 761	com/tencent/mobileqq/richstatus/SignatureEditFragment:a	()I
    //   2795: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2798: aastore
    //   2799: invokestatic 255	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2802: aastore
    //   2803: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2806: goto +422 -> 3228
    //   2809: aload_0
    //   2810: aload 15
    //   2812: iconst_1
    //   2813: anewarray 173	java/lang/String
    //   2816: dup
    //   2817: iconst_0
    //   2818: ldc_w 763
    //   2821: aastore
    //   2822: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2825: goto +403 -> 3228
    //   2828: ldc_w 765
    //   2831: aload 4
    //   2833: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2836: ifeq +83 -> 2919
    //   2839: aload_1
    //   2840: ldc_w 767
    //   2843: invokevirtual 503	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2846: istore 6
    //   2848: aload_1
    //   2849: ldc_w 769
    //   2852: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2855: astore_1
    //   2856: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2859: ifeq +31 -> 2890
    //   2862: ldc 34
    //   2864: iconst_2
    //   2865: ldc_w 771
    //   2868: iconst_2
    //   2869: anewarray 245	java/lang/Object
    //   2872: dup
    //   2873: iconst_0
    //   2874: iload 6
    //   2876: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2879: aastore
    //   2880: dup
    //   2881: iconst_1
    //   2882: aload_1
    //   2883: aastore
    //   2884: invokestatic 255	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2887: invokestatic 258	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2890: aload_0
    //   2891: iload 6
    //   2893: putfield 239	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mSelectTagId	I
    //   2896: aload_0
    //   2897: aload_1
    //   2898: putfield 241	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mSelectTagText	Ljava/lang/String;
    //   2901: aload_0
    //   2902: aload 15
    //   2904: iconst_1
    //   2905: anewarray 173	java/lang/String
    //   2908: dup
    //   2909: iconst_0
    //   2910: ldc 214
    //   2912: aastore
    //   2913: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2916: goto +312 -> 3228
    //   2919: ldc_w 773
    //   2922: aload 4
    //   2924: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2927: ifeq +301 -> 3228
    //   2930: aload_1
    //   2931: ldc_w 767
    //   2934: invokevirtual 503	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2937: istore 6
    //   2939: aload_1
    //   2940: ldc_w 769
    //   2943: invokevirtual 324	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2946: astore 5
    //   2948: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2951: ifeq +32 -> 2983
    //   2954: ldc 34
    //   2956: iconst_2
    //   2957: ldc_w 775
    //   2960: iconst_2
    //   2961: anewarray 245	java/lang/Object
    //   2964: dup
    //   2965: iconst_0
    //   2966: iload 6
    //   2968: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2971: aastore
    //   2972: dup
    //   2973: iconst_1
    //   2974: aload 5
    //   2976: aastore
    //   2977: invokestatic 255	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2980: invokestatic 258	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2983: aload 5
    //   2985: invokestatic 779	com/tencent/mobileqq/richstatus/topic/TopicUtil:a	(Ljava/lang/String;)Z
    //   2988: ifeq +97 -> 3085
    //   2991: iload 6
    //   2993: iflt +92 -> 3085
    //   2996: new 108	android/os/Bundle
    //   2999: dup
    //   3000: invokespecial 465	android/os/Bundle:<init>	()V
    //   3003: astore_1
    //   3004: aload_1
    //   3005: ldc_w 266
    //   3008: aload 5
    //   3010: invokevirtual 361	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3013: aload_1
    //   3014: ldc_w 260
    //   3017: iload 6
    //   3019: invokevirtual 355	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3022: aload_1
    //   3023: ldc_w 781
    //   3026: iconst_1
    //   3027: invokevirtual 355	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3030: aload_0
    //   3031: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3034: invokevirtual 448	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   3037: astore 5
    //   3039: aload_0
    //   3040: getfield 273	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3043: invokevirtual 279	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   3046: astore 12
    //   3048: aload 12
    //   3050: ifnull +17 -> 3067
    //   3053: aload 5
    //   3055: ifnull +12 -> 3067
    //   3058: aload 12
    //   3060: aconst_null
    //   3061: aconst_null
    //   3062: aload_1
    //   3063: iconst_m1
    //   3064: invokestatic 786	com/tencent/mobileqq/richstatus/SignTextEditFragment:a	(Landroid/app/Activity;Lcom/tencent/mobileqq/richstatus/RichStatus;Ljava/lang/String;Landroid/os/Bundle;I)V
    //   3067: aload_0
    //   3068: aload 15
    //   3070: iconst_1
    //   3071: anewarray 173	java/lang/String
    //   3074: dup
    //   3075: iconst_0
    //   3076: ldc 214
    //   3078: aastore
    //   3079: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3082: goto +146 -> 3228
    //   3085: aload_0
    //   3086: aload 15
    //   3088: iconst_1
    //   3089: anewarray 173	java/lang/String
    //   3092: dup
    //   3093: iconst_0
    //   3094: ldc 198
    //   3096: aastore
    //   3097: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3100: goto +128 -> 3228
    //   3103: astore_1
    //   3104: aload 15
    //   3106: astore 5
    //   3108: goto +7 -> 3115
    //   3111: astore_1
    //   3112: aconst_null
    //   3113: astore 5
    //   3115: new 60	java/lang/StringBuilder
    //   3118: dup
    //   3119: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   3122: astore 12
    //   3124: aload 12
    //   3126: ldc_w 788
    //   3129: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3132: pop
    //   3133: aload 12
    //   3135: aload_2
    //   3136: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3139: pop
    //   3140: aload 12
    //   3142: ldc_w 309
    //   3145: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3148: pop
    //   3149: aload 12
    //   3151: aload_3
    //   3152: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3155: pop
    //   3156: aload 12
    //   3158: ldc_w 311
    //   3161: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3164: pop
    //   3165: aload 12
    //   3167: aload 4
    //   3169: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3172: pop
    //   3173: aload 12
    //   3175: ldc_w 790
    //   3178: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3181: pop
    //   3182: aload 12
    //   3184: aload_1
    //   3185: invokevirtual 793	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   3188: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3191: pop
    //   3192: ldc 34
    //   3194: iconst_2
    //   3195: aload 12
    //   3197: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3200: invokestatic 328	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3203: aload 5
    //   3205: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3208: ifne +20 -> 3228
    //   3211: aload_0
    //   3212: aload 5
    //   3214: iconst_1
    //   3215: anewarray 173	java/lang/String
    //   3218: dup
    //   3219: iconst_0
    //   3220: ldc 198
    //   3222: aastore
    //   3223: invokespecial 178	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3226: iconst_1
    //   3227: ireturn
    //   3228: iconst_1
    //   3229: ireturn
    //   3230: iconst_0
    //   3231: ireturn
    //   3232: astore_1
    //   3233: goto -2081 -> 1152
    //   3236: goto -1749 -> 1487
    //   3239: astore_1
    //   3240: goto -1686 -> 1554
    //   3243: goto -1756 -> 1487
    //   3246: astore_1
    //   3247: goto -1490 -> 1757
    //   3250: iconst_1
    //   3251: istore 6
    //   3253: goto -964 -> 2289
    //   3256: iconst_0
    //   3257: istore 6
    //   3259: goto -970 -> 2289
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3262	0	this	SignJsPlugin
    //   0	3262	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	3262	2	paramString1	String
    //   0	3262	3	paramString2	String
    //   0	3262	4	paramString3	String
    //   0	3262	5	paramVarArgs	String[]
    //   240	3018	6	i	int
    //   1363	1317	7	j	int
    //   2001	53	8	k	int
    //   2010	46	9	m	int
    //   2028	32	10	n	int
    //   108	2486	11	bool	boolean
    //   258	2938	12	localObject1	Object
    //   267	1251	13	localObject2	Object
    //   276	831	14	localObject3	Object
    //   1159	1	14	localIOException	java.io.IOException
    //   1196	10	14	arrayOfString	String[]
    //   171	2934	15	str1	String
    //   941	916	16	str2	String
    // Exception table:
    //   from	to	target	type
    //   115	154	157	java/lang/Throwable
    //   1123	1148	1151	java/io/IOException
    //   1104	1111	1159	java/io/IOException
    //   1118	1123	1159	java/io/IOException
    //   1087	1097	1164	finally
    //   1087	1097	1169	java/io/IOException
    //   1002	1075	1174	finally
    //   1075	1087	1174	finally
    //   1002	1075	1187	java/io/IOException
    //   1075	1087	1187	java/io/IOException
    //   1334	1348	1354	finally
    //   1334	1348	1361	java/lang/OutOfMemoryError
    //   1334	1348	1368	java/lang/Exception
    //   1334	1348	1375	java/lang/IllegalArgumentException
    //   1104	1111	1500	finally
    //   1118	1123	1500	finally
    //   1205	1210	1500	finally
    //   979	994	1561	finally
    //   994	1002	1561	finally
    //   1123	1148	1561	finally
    //   1152	1156	1561	finally
    //   1215	1220	1561	finally
    //   1227	1231	1561	finally
    //   1231	1247	1561	finally
    //   1247	1334	1561	finally
    //   1382	1447	1561	finally
    //   1517	1522	1561	finally
    //   1530	1535	1561	finally
    //   1535	1551	1561	finally
    //   1554	1558	1561	finally
    //   1558	1561	1561	finally
    //   979	994	1568	java/lang/OutOfMemoryError
    //   994	1002	1568	java/lang/OutOfMemoryError
    //   1123	1148	1568	java/lang/OutOfMemoryError
    //   1152	1156	1568	java/lang/OutOfMemoryError
    //   1215	1220	1568	java/lang/OutOfMemoryError
    //   1227	1231	1568	java/lang/OutOfMemoryError
    //   1231	1247	1568	java/lang/OutOfMemoryError
    //   1247	1334	1568	java/lang/OutOfMemoryError
    //   1382	1447	1568	java/lang/OutOfMemoryError
    //   1517	1522	1568	java/lang/OutOfMemoryError
    //   1530	1535	1568	java/lang/OutOfMemoryError
    //   1535	1551	1568	java/lang/OutOfMemoryError
    //   1554	1558	1568	java/lang/OutOfMemoryError
    //   1558	1561	1568	java/lang/OutOfMemoryError
    //   979	994	1631	java/lang/Exception
    //   994	1002	1631	java/lang/Exception
    //   1123	1148	1631	java/lang/Exception
    //   1152	1156	1631	java/lang/Exception
    //   1215	1220	1631	java/lang/Exception
    //   1227	1231	1631	java/lang/Exception
    //   1231	1247	1631	java/lang/Exception
    //   1247	1334	1631	java/lang/Exception
    //   1382	1447	1631	java/lang/Exception
    //   1517	1522	1631	java/lang/Exception
    //   1530	1535	1631	java/lang/Exception
    //   1535	1551	1631	java/lang/Exception
    //   1554	1558	1631	java/lang/Exception
    //   1558	1561	1631	java/lang/Exception
    //   979	994	1694	java/lang/IllegalArgumentException
    //   994	1002	1694	java/lang/IllegalArgumentException
    //   1123	1148	1694	java/lang/IllegalArgumentException
    //   1152	1156	1694	java/lang/IllegalArgumentException
    //   1215	1220	1694	java/lang/IllegalArgumentException
    //   1227	1231	1694	java/lang/IllegalArgumentException
    //   1231	1247	1694	java/lang/IllegalArgumentException
    //   1247	1334	1694	java/lang/IllegalArgumentException
    //   1382	1447	1694	java/lang/IllegalArgumentException
    //   1517	1522	1694	java/lang/IllegalArgumentException
    //   1530	1535	1694	java/lang/IllegalArgumentException
    //   1535	1551	1694	java/lang/IllegalArgumentException
    //   1554	1558	1694	java/lang/IllegalArgumentException
    //   1558	1561	1694	java/lang/IllegalArgumentException
    //   173	190	3103	java/lang/Throwable
    //   192	202	3103	java/lang/Throwable
    //   207	232	3103	java/lang/Throwable
    //   235	354	3103	java/lang/Throwable
    //   359	431	3103	java/lang/Throwable
    //   431	439	3103	java/lang/Throwable
    //   443	464	3103	java/lang/Throwable
    //   464	489	3103	java/lang/Throwable
    //   492	507	3103	java/lang/Throwable
    //   509	561	3103	java/lang/Throwable
    //   564	631	3103	java/lang/Throwable
    //   631	673	3103	java/lang/Throwable
    //   673	707	3103	java/lang/Throwable
    //   707	732	3103	java/lang/Throwable
    //   735	777	3103	java/lang/Throwable
    //   780	832	3103	java/lang/Throwable
    //   834	911	3103	java/lang/Throwable
    //   914	949	3103	java/lang/Throwable
    //   964	971	3103	java/lang/Throwable
    //   1460	1484	3103	java/lang/Throwable
    //   1487	1497	3103	java/lang/Throwable
    //   1604	1628	3103	java/lang/Throwable
    //   1667	1691	3103	java/lang/Throwable
    //   1730	1754	3103	java/lang/Throwable
    //   1767	1791	3103	java/lang/Throwable
    //   1791	1801	3103	java/lang/Throwable
    //   1801	1803	3103	java/lang/Throwable
    //   1808	1856	3103	java/lang/Throwable
    //   1856	1866	3103	java/lang/Throwable
    //   1869	1905	3103	java/lang/Throwable
    //   1908	1918	3103	java/lang/Throwable
    //   1923	1938	3103	java/lang/Throwable
    //   1938	1958	3103	java/lang/Throwable
    //   1961	1971	3103	java/lang/Throwable
    //   1976	2064	3103	java/lang/Throwable
    //   2064	2079	3103	java/lang/Throwable
    //   2082	2125	3103	java/lang/Throwable
    //   2128	2220	3103	java/lang/Throwable
    //   2223	2236	3103	java/lang/Throwable
    //   2236	2279	3103	java/lang/Throwable
    //   2282	2289	3103	java/lang/Throwable
    //   2289	2388	3103	java/lang/Throwable
    //   2391	2428	3103	java/lang/Throwable
    //   2431	2470	3103	java/lang/Throwable
    //   2473	2514	3103	java/lang/Throwable
    //   2514	2550	3103	java/lang/Throwable
    //   2553	2598	3103	java/lang/Throwable
    //   2601	2701	3103	java/lang/Throwable
    //   2704	2741	3103	java/lang/Throwable
    //   2744	2806	3103	java/lang/Throwable
    //   2809	2825	3103	java/lang/Throwable
    //   2828	2890	3103	java/lang/Throwable
    //   2890	2916	3103	java/lang/Throwable
    //   2919	2983	3103	java/lang/Throwable
    //   2983	2991	3103	java/lang/Throwable
    //   2996	3048	3103	java/lang/Throwable
    //   3058	3067	3103	java/lang/Throwable
    //   3067	3082	3103	java/lang/Throwable
    //   3085	3100	3103	java/lang/Throwable
    //   94	99	3111	java/lang/Throwable
    //   105	110	3111	java/lang/Throwable
    //   164	173	3111	java/lang/Throwable
    //   1215	1220	3232	java/io/IOException
    //   1227	1231	3232	java/io/IOException
    //   1231	1247	3232	java/io/IOException
    //   1517	1522	3239	java/io/IOException
    //   1530	1535	3239	java/io/IOException
    //   1535	1551	3239	java/io/IOException
    //   1576	1586	3246	finally
    //   1590	1594	3246	finally
    //   1639	1649	3246	finally
    //   1653	1657	3246	finally
    //   1702	1712	3246	finally
    //   1716	1720	3246	finally
  }
  
  /* Error */
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iload_2
    //   3: iload_3
    //   4: invokespecial 799	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:onActivityResult	(Landroid/content/Intent;BI)V
    //   7: aload_1
    //   8: ifnonnull +13 -> 21
    //   11: ldc 34
    //   13: iconst_1
    //   14: ldc_w 801
    //   17: invokestatic 328	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   20: return
    //   21: aconst_null
    //   22: astore 12
    //   24: aconst_null
    //   25: astore 9
    //   27: aload 9
    //   29: astore 10
    //   31: aload 12
    //   33: astore 11
    //   35: aload_1
    //   36: invokevirtual 805	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   39: ifnonnull +21 -> 60
    //   42: aload 9
    //   44: astore 10
    //   46: aload 12
    //   48: astore 11
    //   50: ldc 34
    //   52: iconst_1
    //   53: ldc_w 807
    //   56: invokestatic 328	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: return
    //   60: aload 9
    //   62: astore 10
    //   64: aload 12
    //   66: astore 11
    //   68: new 103	org/json/JSONObject
    //   71: dup
    //   72: invokespecial 104	org/json/JSONObject:<init>	()V
    //   75: astore 13
    //   77: iload_2
    //   78: bipush 100
    //   80: if_icmpne +446 -> 526
    //   83: aload 9
    //   85: astore 10
    //   87: aload 12
    //   89: astore 11
    //   91: aload_0
    //   92: getfield 443	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mLocationCallback	Ljava/lang/String;
    //   95: astore 9
    //   97: aload 9
    //   99: astore 10
    //   101: aload 9
    //   103: astore 11
    //   105: aload 9
    //   107: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   110: ifeq +21 -> 131
    //   113: aload 9
    //   115: astore 10
    //   117: aload 9
    //   119: astore 11
    //   121: ldc 34
    //   123: iconst_1
    //   124: ldc_w 809
    //   127: invokestatic 328	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: return
    //   131: aload 9
    //   133: astore 10
    //   135: aload 9
    //   137: astore 11
    //   139: aload_1
    //   140: ldc_w 811
    //   143: invokevirtual 815	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   146: checkcast 817	cooperation/qzone/LbsDataV2$PoiInfo
    //   149: astore_1
    //   150: aload_1
    //   151: ifnonnull +41 -> 192
    //   154: aload 9
    //   156: astore 10
    //   158: aload 9
    //   160: astore 11
    //   162: ldc 34
    //   164: iconst_1
    //   165: ldc_w 819
    //   168: invokestatic 328	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: aload 9
    //   173: astore 10
    //   175: aload 9
    //   177: astore 11
    //   179: aload 13
    //   181: ldc 106
    //   183: bipush 101
    //   185: invokevirtual 116	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   188: pop
    //   189: goto +228 -> 417
    //   192: aload 9
    //   194: astore 10
    //   196: aload 9
    //   198: astore 11
    //   200: aload_0
    //   201: aload_1
    //   202: getfield 822	cooperation/qzone/LbsDataV2$PoiInfo:poiId	Ljava/lang/String;
    //   205: putfield 445	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mCachePoiId	Ljava/lang/String;
    //   208: aload 9
    //   210: astore 10
    //   212: aload 9
    //   214: astore 11
    //   216: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   219: ifeq +74 -> 293
    //   222: aload 9
    //   224: astore 10
    //   226: aload 9
    //   228: astore 11
    //   230: new 60	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   237: astore 12
    //   239: aload 9
    //   241: astore 10
    //   243: aload 9
    //   245: astore 11
    //   247: aload 12
    //   249: ldc_w 464
    //   252: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload 9
    //   258: astore 10
    //   260: aload 9
    //   262: astore 11
    //   264: aload 12
    //   266: aload_0
    //   267: getfield 445	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mCachePoiId	Ljava/lang/String;
    //   270: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload 9
    //   276: astore 10
    //   278: aload 9
    //   280: astore 11
    //   282: ldc 34
    //   284: iconst_2
    //   285: aload 12
    //   287: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: aload 9
    //   295: astore 10
    //   297: aload 9
    //   299: astore 11
    //   301: aload 13
    //   303: ldc 106
    //   305: iconst_0
    //   306: invokevirtual 116	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   309: pop
    //   310: aload 9
    //   312: astore 10
    //   314: aload 9
    //   316: astore 11
    //   318: new 103	org/json/JSONObject
    //   321: dup
    //   322: invokespecial 104	org/json/JSONObject:<init>	()V
    //   325: astore 12
    //   327: aload 9
    //   329: astore 10
    //   331: aload 9
    //   333: astore 11
    //   335: aload_1
    //   336: getfield 825	cooperation/qzone/LbsDataV2$PoiInfo:poiName	Ljava/lang/String;
    //   339: ldc_w 826
    //   342: invokestatic 588	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   345: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   348: istore 4
    //   350: iload 4
    //   352: ifne +27 -> 379
    //   355: aload 9
    //   357: astore 10
    //   359: aload 9
    //   361: astore 11
    //   363: aload 12
    //   365: ldc_w 342
    //   368: aload_1
    //   369: getfield 825	cooperation/qzone/LbsDataV2$PoiInfo:poiName	Ljava/lang/String;
    //   372: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   375: pop
    //   376: goto +23 -> 399
    //   379: aload 9
    //   381: astore 10
    //   383: aload 9
    //   385: astore 11
    //   387: aload 12
    //   389: ldc_w 342
    //   392: ldc_w 457
    //   395: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   398: pop
    //   399: aload 9
    //   401: astore 10
    //   403: aload 9
    //   405: astore 11
    //   407: aload 13
    //   409: ldc 165
    //   411: aload 12
    //   413: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   416: pop
    //   417: aload 9
    //   419: astore 10
    //   421: aload 9
    //   423: astore 11
    //   425: aload_0
    //   426: aload 9
    //   428: iconst_1
    //   429: anewarray 173	java/lang/String
    //   432: dup
    //   433: iconst_0
    //   434: aload 13
    //   436: invokevirtual 174	org/json/JSONObject:toString	()Ljava/lang/String;
    //   439: aastore
    //   440: invokevirtual 701	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   443: aload 9
    //   445: astore 10
    //   447: aload 9
    //   449: astore 11
    //   451: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   454: ifeq +508 -> 962
    //   457: aload 9
    //   459: astore 10
    //   461: aload 9
    //   463: astore 11
    //   465: new 60	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   472: astore_1
    //   473: aload 9
    //   475: astore 10
    //   477: aload 9
    //   479: astore 11
    //   481: aload_1
    //   482: ldc_w 828
    //   485: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: pop
    //   489: aload 9
    //   491: astore 10
    //   493: aload 9
    //   495: astore 11
    //   497: aload_1
    //   498: aload 13
    //   500: invokevirtual 174	org/json/JSONObject:toString	()Ljava/lang/String;
    //   503: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: pop
    //   507: aload 9
    //   509: astore 10
    //   511: aload 9
    //   513: astore 11
    //   515: ldc 34
    //   517: iconst_2
    //   518: aload_1
    //   519: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   522: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   525: return
    //   526: iload_2
    //   527: bipush 101
    //   529: if_icmpne +433 -> 962
    //   532: aload 9
    //   534: astore 10
    //   536: aload 12
    //   538: astore 11
    //   540: aload_0
    //   541: getfield 488	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:mActionCallback	Ljava/lang/String;
    //   544: astore 9
    //   546: aload 9
    //   548: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   551: istore 4
    //   553: iload 4
    //   555: ifeq +21 -> 576
    //   558: aload 9
    //   560: astore 10
    //   562: aload 9
    //   564: astore 11
    //   566: ldc 34
    //   568: iconst_1
    //   569: ldc_w 830
    //   572: invokestatic 328	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   575: return
    //   576: aload_1
    //   577: ldc 17
    //   579: lconst_0
    //   580: invokevirtual 834	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   583: lstore 5
    //   585: aload_1
    //   586: ldc 20
    //   588: invokevirtual 837	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   591: astore 11
    //   593: aload 11
    //   595: astore 10
    //   597: aload 11
    //   599: ifnonnull +8 -> 607
    //   602: ldc_w 457
    //   605: astore 10
    //   607: aload_1
    //   608: ldc 23
    //   610: lconst_0
    //   611: invokevirtual 834	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   614: lstore 7
    //   616: aload_1
    //   617: ldc 26
    //   619: invokevirtual 837	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   622: astore 11
    //   624: aload 11
    //   626: astore_1
    //   627: aload 11
    //   629: ifnonnull +7 -> 636
    //   632: ldc_w 457
    //   635: astore_1
    //   636: lload 5
    //   638: lconst_0
    //   639: lcmp
    //   640: ifne +74 -> 714
    //   643: aload 13
    //   645: ldc 106
    //   647: bipush 101
    //   649: invokevirtual 116	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   652: pop
    //   653: aload_0
    //   654: aload 9
    //   656: iconst_1
    //   657: anewarray 173	java/lang/String
    //   660: dup
    //   661: iconst_0
    //   662: aload 13
    //   664: invokevirtual 174	org/json/JSONObject:toString	()Ljava/lang/String;
    //   667: aastore
    //   668: invokevirtual 701	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   671: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   674: ifeq +309 -> 983
    //   677: new 60	java/lang/StringBuilder
    //   680: dup
    //   681: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   684: astore_1
    //   685: aload_1
    //   686: ldc_w 839
    //   689: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: pop
    //   693: aload_1
    //   694: aload 13
    //   696: invokevirtual 174	org/json/JSONObject:toString	()Ljava/lang/String;
    //   699: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: pop
    //   703: ldc 34
    //   705: iconst_2
    //   706: aload_1
    //   707: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   710: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   713: return
    //   714: new 103	org/json/JSONObject
    //   717: dup
    //   718: invokespecial 104	org/json/JSONObject:<init>	()V
    //   721: astore 11
    //   723: new 103	org/json/JSONObject
    //   726: dup
    //   727: invokespecial 104	org/json/JSONObject:<init>	()V
    //   730: astore 12
    //   732: aload 12
    //   734: ldc_w 370
    //   737: lload 5
    //   739: invokestatic 844	java/lang/Long:toString	(J)Ljava/lang/String;
    //   742: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   745: pop
    //   746: aload 12
    //   748: ldc_w 374
    //   751: aload 10
    //   753: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   756: pop
    //   757: aload 12
    //   759: ldc_w 378
    //   762: lload 7
    //   764: invokestatic 844	java/lang/Long:toString	(J)Ljava/lang/String;
    //   767: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   770: pop
    //   771: aload 12
    //   773: ldc_w 382
    //   776: aload_1
    //   777: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   780: pop
    //   781: aload 11
    //   783: ldc_w 363
    //   786: aload 12
    //   788: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   791: pop
    //   792: aload 13
    //   794: ldc 106
    //   796: iconst_0
    //   797: invokevirtual 116	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   800: pop
    //   801: aload 13
    //   803: ldc 165
    //   805: aload 11
    //   807: invokevirtual 137	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   810: pop
    //   811: aload 13
    //   813: invokevirtual 174	org/json/JSONObject:toString	()Ljava/lang/String;
    //   816: astore_1
    //   817: aload_0
    //   818: aload 9
    //   820: iconst_1
    //   821: anewarray 173	java/lang/String
    //   824: dup
    //   825: iconst_0
    //   826: aload_1
    //   827: aastore
    //   828: invokevirtual 701	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   831: invokestatic 184	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   834: ifeq +128 -> 962
    //   837: new 60	java/lang/StringBuilder
    //   840: dup
    //   841: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   844: astore_1
    //   845: aload_1
    //   846: ldc_w 839
    //   849: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: pop
    //   853: aload_1
    //   854: aload 13
    //   856: invokevirtual 174	org/json/JSONObject:toString	()Ljava/lang/String;
    //   859: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: pop
    //   863: ldc 34
    //   865: iconst_2
    //   866: aload_1
    //   867: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   870: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   873: return
    //   874: goto +56 -> 930
    //   877: astore_1
    //   878: goto +18 -> 896
    //   881: goto +49 -> 930
    //   884: astore_1
    //   885: goto +11 -> 896
    //   888: goto +42 -> 930
    //   891: astore_1
    //   892: aload 10
    //   894: astore 9
    //   896: ldc 34
    //   898: iconst_1
    //   899: ldc_w 846
    //   902: aload_1
    //   903: invokestatic 196	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   906: aload 9
    //   908: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   911: ifne +51 -> 962
    //   914: aload_0
    //   915: aload 9
    //   917: iconst_1
    //   918: anewarray 173	java/lang/String
    //   921: dup
    //   922: iconst_0
    //   923: ldc 198
    //   925: aastore
    //   926: invokevirtual 701	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   929: return
    //   930: ldc 34
    //   932: iconst_1
    //   933: ldc_w 848
    //   936: invokestatic 328	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   939: aload 9
    //   941: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   944: ifne +18 -> 962
    //   947: aload_0
    //   948: aload 9
    //   950: iconst_1
    //   951: anewarray 173	java/lang/String
    //   954: dup
    //   955: iconst_0
    //   956: ldc 198
    //   958: aastore
    //   959: invokevirtual 701	com/tencent/mobileqq/vaswebviewplugin/SignJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   962: return
    //   963: astore_1
    //   964: aload 11
    //   966: astore 9
    //   968: goto -38 -> 930
    //   971: astore_1
    //   972: goto -84 -> 888
    //   975: astore_1
    //   976: goto -95 -> 881
    //   979: astore_1
    //   980: goto -106 -> 874
    //   983: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	984	0	this	SignJsPlugin
    //   0	984	1	paramIntent	Intent
    //   0	984	2	paramByte	byte
    //   0	984	3	paramInt	int
    //   348	206	4	bool	boolean
    //   583	155	5	l1	long
    //   614	149	7	l2	long
    //   25	942	9	localObject1	Object
    //   29	864	10	localObject2	Object
    //   33	932	11	localObject3	Object
    //   22	765	12	localObject4	Object
    //   75	780	13	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   576	593	877	org/json/JSONException
    //   607	624	877	org/json/JSONException
    //   643	713	877	org/json/JSONException
    //   714	792	877	org/json/JSONException
    //   792	817	877	org/json/JSONException
    //   817	873	877	org/json/JSONException
    //   546	553	884	org/json/JSONException
    //   35	42	891	org/json/JSONException
    //   50	59	891	org/json/JSONException
    //   68	77	891	org/json/JSONException
    //   91	97	891	org/json/JSONException
    //   105	113	891	org/json/JSONException
    //   121	130	891	org/json/JSONException
    //   139	150	891	org/json/JSONException
    //   162	171	891	org/json/JSONException
    //   179	189	891	org/json/JSONException
    //   200	208	891	org/json/JSONException
    //   216	222	891	org/json/JSONException
    //   230	239	891	org/json/JSONException
    //   247	256	891	org/json/JSONException
    //   264	274	891	org/json/JSONException
    //   282	293	891	org/json/JSONException
    //   301	310	891	org/json/JSONException
    //   318	327	891	org/json/JSONException
    //   335	350	891	org/json/JSONException
    //   363	376	891	org/json/JSONException
    //   387	399	891	org/json/JSONException
    //   407	417	891	org/json/JSONException
    //   425	443	891	org/json/JSONException
    //   451	457	891	org/json/JSONException
    //   465	473	891	org/json/JSONException
    //   481	489	891	org/json/JSONException
    //   497	507	891	org/json/JSONException
    //   515	525	891	org/json/JSONException
    //   540	546	891	org/json/JSONException
    //   566	575	891	org/json/JSONException
    //   35	42	963	java/lang/OutOfMemoryError
    //   50	59	963	java/lang/OutOfMemoryError
    //   68	77	963	java/lang/OutOfMemoryError
    //   91	97	963	java/lang/OutOfMemoryError
    //   105	113	963	java/lang/OutOfMemoryError
    //   121	130	963	java/lang/OutOfMemoryError
    //   139	150	963	java/lang/OutOfMemoryError
    //   162	171	963	java/lang/OutOfMemoryError
    //   179	189	963	java/lang/OutOfMemoryError
    //   200	208	963	java/lang/OutOfMemoryError
    //   216	222	963	java/lang/OutOfMemoryError
    //   230	239	963	java/lang/OutOfMemoryError
    //   247	256	963	java/lang/OutOfMemoryError
    //   264	274	963	java/lang/OutOfMemoryError
    //   282	293	963	java/lang/OutOfMemoryError
    //   301	310	963	java/lang/OutOfMemoryError
    //   318	327	963	java/lang/OutOfMemoryError
    //   335	350	963	java/lang/OutOfMemoryError
    //   363	376	963	java/lang/OutOfMemoryError
    //   387	399	963	java/lang/OutOfMemoryError
    //   407	417	963	java/lang/OutOfMemoryError
    //   425	443	963	java/lang/OutOfMemoryError
    //   451	457	963	java/lang/OutOfMemoryError
    //   465	473	963	java/lang/OutOfMemoryError
    //   481	489	963	java/lang/OutOfMemoryError
    //   497	507	963	java/lang/OutOfMemoryError
    //   515	525	963	java/lang/OutOfMemoryError
    //   540	546	963	java/lang/OutOfMemoryError
    //   566	575	963	java/lang/OutOfMemoryError
    //   546	553	971	java/lang/OutOfMemoryError
    //   576	593	975	java/lang/OutOfMemoryError
    //   607	624	975	java/lang/OutOfMemoryError
    //   643	713	975	java/lang/OutOfMemoryError
    //   714	792	975	java/lang/OutOfMemoryError
    //   817	873	975	java/lang/OutOfMemoryError
    //   792	817	979	java/lang/OutOfMemoryError
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.mReqBundle = new Bundle();
    AppInterface localAppInterface = this.mRuntime.a();
    if ((localAppInterface instanceof BrowserAppInterface))
    {
      this.browserApp = ((BrowserAppInterface)localAppInterface);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("SignJsPlugin", 2, "ERROR!!! ChatFont market is not running in web process!");
    }
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    if (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key)
    {
      Object localObject = paramBundle.getString("cmd");
      String str = paramBundle.getString("callbackid");
      try
      {
        Bundle localBundle = paramBundle.getBundle("response");
        if (localBundle == null)
        {
          QLog.e("SignJsPlugin", 1, "onResponse error no bundle");
          super.callJs(str, new String[] { "{\"result\": -1}" });
          return;
        }
        paramBundle = new JSONObject();
        if ("ipc_signature_setordelete".equals(localObject))
        {
          handleChangeStatusCallback(localBundle, str);
          return;
        }
        boolean bool = "ipc_signature_setlike".equals(localObject);
        if (bool)
        {
          paramBundle.put("result", localBundle.getInt("result"));
          super.callJs(str, new String[] { paramBundle.toString() });
          return;
        }
        if ("ipc_signature_get_sync_tag".equals(localObject))
        {
          this.isSync = localBundle.getBoolean("isSync");
          paramBundle.put("result", this.isSync);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("isSync from onResponse: ");
            ((StringBuilder)localObject).append(this.isSync);
            QLog.d("SigImg2Zone", 4, ((StringBuilder)localObject).toString());
          }
          super.callJs(str, new String[] { paramBundle.toString() });
          return;
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e("SignJsPlugin", 1, "onResponse error: ", paramBundle);
        super.callJs(str, new String[] { "{\"result\": -1}" });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.SignJsPlugin
 * JD-Core Version:    0.7.0.1
 */