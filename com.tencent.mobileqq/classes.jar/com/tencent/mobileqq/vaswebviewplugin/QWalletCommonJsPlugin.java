package com.tencent.mobileqq.vaswebviewplugin;

import Wallet.AuthCodeItem;
import Wallet.AuthCodeRsp;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.provider.ContactsContract.Contacts;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.qwallet.QWalletSkinHandler;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.mobileqq.utils.JumpQqPimSecureUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qwallet.plugin.TenCookie;
import java.io.File;
import java.io.PrintStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class QWalletCommonJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String ACTION_NOTIFY_VIEW_UPDATE = "action_notify_view_update";
  private static final int ACTION_REDPACK_REFRESH_LIST = 1;
  public static final String PLUGIN_NAMESPACE = "qw_charge";
  private static byte REQUESTCODE_TRANSFER = 1;
  private static final int SKIN_ACTION_CLOSE = 0;
  private static final int SKIN_ACTION_GET = 2;
  private static final int SKIN_ACTION_SET = 1;
  private static final int SKIN_RESULT_FAIL = 1;
  private static final int SKIN_RESULT_SUCC = 0;
  private static final int SKIN_STATUS_CLOSE = 0;
  private static final int SKIN_STATUS_OPEN = 1;
  static final String TAG = "QWalletCommonJsPlugin";
  private final String EMOJI_USER_CHARGE_RESULT = "qw_charge_emojiPayResultOk";
  private final String QQPIMSECURE_SAFE_SECURITYPAY_ISOPEN = "qw_charge_qqpimsecure_safe_isopen_securitypay";
  private final String QWALLET_CHECK_WEBANK_PERMISSION = "qw_charge_checkPermission";
  private final String QWALLET_GET_APP_AUTHCODE = "qw_charge_getAppAuthorizationCode";
  private final String QWALLET_NOTIFY_VIEW_UPDATE = "qw_charge_notifyViewUpdate";
  private final byte QWALLET_REQUEST_CHECK_PERMISSION = 17;
  private final byte QWALLET_REQUEST_CONTACT = 16;
  private final String QWALLET_TOKEN_AIO_TRANSFER = "qw_charge_tenpayTransfer";
  private final String QWALLET_TOKEN_GET_ALL_CONTATC = "qw_charge_getAllContact";
  private final String QWALLET_TOKEN_GET_SELECT_CONTACT = "qw_charge_getSelectContact";
  private final String QWALLET_TOKEN_GOTO_QWALLET_HOME = "qw_charge_gotoQWalletHome";
  protected QWalletCommonJsPlugin.ChooseQQFriendForTransferReceiver aioChoFriReceiver;
  private ExecutorService executorService;
  private long mAuthCodeAppId;
  private String mCallback;
  private Context mContext;
  private long mLastAuthCodeReqTime;
  private long mReqAuthCodeStartTime;
  BroadcastReceiver mScreenReceiver = new QWalletCommonJsPlugin.1(this);
  QWalletCommonJsPlugin.QWVideoJsPlugin mVideoJsPlugin;
  
  public QWalletCommonJsPlugin()
  {
    this.mPluginNameSpace = "qw_charge";
  }
  
  private void checkWebankPermission()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("pay_requestcode", 13);
    Intent localIntent = new Intent(this.mContext, PayBridgeActivity.class);
    localIntent.putExtras(localBundle);
    startActivityForResult(localIntent, (byte)17);
  }
  
  private void chooseQQFriendsForTransfer(String paramString)
  {
    boolean bool2 = true;
    if (this.mRuntime == null) {
      return;
    }
    Object localObject1 = this.mRuntime.a();
    if ((localObject1 == null) || (TextUtils.isEmpty(paramString)))
    {
      dochooseQQFriendsForTransferResult(null);
      return;
    }
    try
    {
      Object localObject2 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject2).optString("title", "选择联系人");
      int i = ((JSONObject)localObject2).optInt("type", 1);
      this.mCallback = ((JSONObject)localObject2).optString("callback");
      if ((i & 0x1) == 0) {}
      for (boolean bool1 = false;; bool1 = true)
      {
        if ((i & 0x2) == 0) {
          bool2 = false;
        }
        if (this.aioChoFriReceiver == null) {
          this.aioChoFriReceiver = new QWalletCommonJsPlugin.ChooseQQFriendForTransferReceiver(this, new Handler());
        }
        Parcel localParcel = Parcel.obtain();
        this.aioChoFriReceiver.writeToParcel(localParcel, 0);
        localParcel.setDataPosition(0);
        localObject2 = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(localParcel);
        localParcel.recycle();
        localObject1 = new Intent((Context)localObject1, ForwardRecentActivity.class);
        ((Intent)localObject1).putExtra("forward_type", 15);
        ((Intent)localObject1).putExtra("choose_friend_title", paramString);
        ((Intent)localObject1).putExtra("choose_friend_is_qqfriends", bool1);
        ((Intent)localObject1).putExtra("choose_friend_is_contacts", bool2);
        ((Intent)localObject1).putExtra("choose_friend_callback", (Parcelable)localObject2);
        super.startActivityForResult((Intent)localObject1, REQUESTCODE_TRANSFER);
        return;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      dochooseQQFriendsForTransferResult(null);
    }
  }
  
  private void doCallback(String paramString)
  {
    doCallback(this.mCallback, paramString);
  }
  
  private void doCallback(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      callJs(paramString1, new String[] { paramString2 });
    }
  }
  
  /* Error */
  private JSONObject getAllContact()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore_1
    //   8: aconst_null
    //   9: astore_2
    //   10: aconst_null
    //   11: astore 4
    //   13: aconst_null
    //   14: astore_3
    //   15: aload_0
    //   16: getfield 156	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:mContext	Landroid/content/Context;
    //   19: ifnonnull +5 -> 24
    //   22: aconst_null
    //   23: areturn
    //   24: new 193	org/json/JSONObject
    //   27: dup
    //   28: invokespecial 294	org/json/JSONObject:<init>	()V
    //   31: astore 8
    //   33: new 296	org/json/JSONArray
    //   36: dup
    //   37: invokespecial 297	org/json/JSONArray:<init>	()V
    //   40: astore 9
    //   42: getstatic 303	android/provider/ContactsContract$Contacts:CONTENT_URI	Landroid/net/Uri;
    //   45: astore 5
    //   47: aload_0
    //   48: getfield 156	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:mContext	Landroid/content/Context;
    //   51: invokevirtual 309	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   54: aload 5
    //   56: aconst_null
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: invokevirtual 315	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   63: astore 5
    //   65: aload 6
    //   67: astore 4
    //   69: aload 5
    //   71: ifnull +91 -> 162
    //   74: aload 6
    //   76: astore 4
    //   78: aload 7
    //   80: astore_1
    //   81: aload 5
    //   83: invokeinterface 321 1 0
    //   88: ifeq +74 -> 162
    //   91: aload_3
    //   92: astore 4
    //   94: aload 4
    //   96: astore_1
    //   97: aload 4
    //   99: astore_2
    //   100: aload 5
    //   102: aload 5
    //   104: ldc_w 323
    //   107: invokeinterface 327 2 0
    //   112: invokeinterface 331 2 0
    //   117: astore_3
    //   118: aload 4
    //   120: astore_1
    //   121: aload 4
    //   123: astore_2
    //   124: aload_3
    //   125: invokestatic 188	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   128: ifeq +94 -> 222
    //   131: aload 4
    //   133: astore_3
    //   134: aload_3
    //   135: astore 4
    //   137: aload 5
    //   139: ifnull +23 -> 162
    //   142: aload_3
    //   143: astore 4
    //   145: aload_3
    //   146: astore_1
    //   147: aload_3
    //   148: astore_2
    //   149: aload 5
    //   151: invokeinterface 334 1 0
    //   156: ifne -62 -> 94
    //   159: aload_3
    //   160: astore 4
    //   162: aload 4
    //   164: astore_1
    //   165: aload 4
    //   167: astore_2
    //   168: aload 8
    //   170: ldc_w 336
    //   173: aload 9
    //   175: invokevirtual 340	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   178: pop
    //   179: aload 4
    //   181: astore_1
    //   182: aload 4
    //   184: astore_2
    //   185: aload 8
    //   187: ldc_w 342
    //   190: iconst_0
    //   191: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   194: pop
    //   195: aload 5
    //   197: ifnull +10 -> 207
    //   200: aload 5
    //   202: invokeinterface 348 1 0
    //   207: aload 4
    //   209: ifnull +10 -> 219
    //   212: aload 4
    //   214: invokeinterface 348 1 0
    //   219: aload 8
    //   221: areturn
    //   222: aload 4
    //   224: astore_1
    //   225: aload 4
    //   227: astore_2
    //   228: aload_0
    //   229: aload_3
    //   230: invokevirtual 351	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:trimPhoneName	(Ljava/lang/String;)Ljava/lang/String;
    //   233: astore 6
    //   235: aload 4
    //   237: astore_3
    //   238: aload 4
    //   240: astore_1
    //   241: aload 4
    //   243: astore_2
    //   244: aload 5
    //   246: aload 5
    //   248: ldc_w 353
    //   251: invokeinterface 327 2 0
    //   256: invokeinterface 357 2 0
    //   261: ifle -127 -> 134
    //   264: aload 4
    //   266: astore_1
    //   267: aload 4
    //   269: astore_2
    //   270: aload 5
    //   272: aload 5
    //   274: ldc_w 359
    //   277: invokeinterface 327 2 0
    //   282: invokeinterface 331 2 0
    //   287: astore_3
    //   288: aload 4
    //   290: astore_1
    //   291: aload 4
    //   293: astore_2
    //   294: aload_0
    //   295: getfield 156	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:mContext	Landroid/content/Context;
    //   298: invokevirtual 309	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   301: getstatic 362	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   304: aconst_null
    //   305: new 364	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 365	java/lang/StringBuilder:<init>	()V
    //   312: ldc_w 367
    //   315: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload_3
    //   319: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 375	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: aconst_null
    //   326: aconst_null
    //   327: invokevirtual 315	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   330: astore 4
    //   332: aload 4
    //   334: ifnull +77 -> 411
    //   337: aload 4
    //   339: astore_1
    //   340: aload 4
    //   342: astore_2
    //   343: aload 4
    //   345: invokeinterface 321 1 0
    //   350: ifeq +61 -> 411
    //   353: aload 4
    //   355: astore_1
    //   356: aload 4
    //   358: astore_2
    //   359: aload 4
    //   361: aload 4
    //   363: ldc_w 377
    //   366: invokeinterface 327 2 0
    //   371: invokeinterface 331 2 0
    //   376: astore_3
    //   377: aload 4
    //   379: astore_1
    //   380: aload 4
    //   382: astore_2
    //   383: aload_3
    //   384: invokestatic 188	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   387: ifeq +111 -> 498
    //   390: aload 4
    //   392: ifnull +19 -> 411
    //   395: aload 4
    //   397: astore_1
    //   398: aload 4
    //   400: astore_2
    //   401: aload 4
    //   403: invokeinterface 334 1 0
    //   408: ifne -55 -> 353
    //   411: aload 4
    //   413: astore_3
    //   414: aload 4
    //   416: ifnull -282 -> 134
    //   419: aload 4
    //   421: astore_1
    //   422: aload 4
    //   424: astore_2
    //   425: aload 4
    //   427: invokeinterface 348 1 0
    //   432: aload 4
    //   434: astore_3
    //   435: goto -301 -> 134
    //   438: astore_3
    //   439: aload 5
    //   441: astore_2
    //   442: aload_3
    //   443: invokevirtual 378	java/lang/Exception:printStackTrace	()V
    //   446: aload 8
    //   448: ldc_w 336
    //   451: aload 9
    //   453: invokevirtual 340	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   456: pop
    //   457: aload 8
    //   459: ldc_w 342
    //   462: iconst_m1
    //   463: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   466: pop
    //   467: aload_2
    //   468: ifnull +9 -> 477
    //   471: aload_2
    //   472: invokeinterface 348 1 0
    //   477: aload_1
    //   478: ifnull -259 -> 219
    //   481: aload_1
    //   482: invokeinterface 348 1 0
    //   487: goto -268 -> 219
    //   490: astore_1
    //   491: aload_1
    //   492: invokevirtual 378	java/lang/Exception:printStackTrace	()V
    //   495: goto -276 -> 219
    //   498: aload 4
    //   500: astore_1
    //   501: aload 4
    //   503: astore_2
    //   504: aload_0
    //   505: aload_3
    //   506: invokevirtual 381	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:trimPhoneNumPre	(Ljava/lang/String;)Ljava/lang/String;
    //   509: astore_3
    //   510: aload 4
    //   512: astore_1
    //   513: aload 4
    //   515: astore_2
    //   516: new 193	org/json/JSONObject
    //   519: dup
    //   520: invokespecial 294	org/json/JSONObject:<init>	()V
    //   523: astore 7
    //   525: aload 4
    //   527: astore_1
    //   528: aload 4
    //   530: astore_2
    //   531: aload 7
    //   533: ldc_w 383
    //   536: aload 6
    //   538: invokevirtual 340	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   541: pop
    //   542: aload 4
    //   544: astore_1
    //   545: aload 4
    //   547: astore_2
    //   548: aload 7
    //   550: ldc_w 385
    //   553: aload_3
    //   554: invokevirtual 340	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   557: pop
    //   558: aload 4
    //   560: astore_1
    //   561: aload 4
    //   563: astore_2
    //   564: aload 9
    //   566: aload 7
    //   568: invokevirtual 388	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   571: pop
    //   572: goto -182 -> 390
    //   575: astore_3
    //   576: aload_2
    //   577: astore_1
    //   578: aload_3
    //   579: astore_2
    //   580: aload 5
    //   582: ifnull +10 -> 592
    //   585: aload 5
    //   587: invokeinterface 348 1 0
    //   592: aload_1
    //   593: ifnull +9 -> 602
    //   596: aload_1
    //   597: invokeinterface 348 1 0
    //   602: aload_2
    //   603: athrow
    //   604: astore_1
    //   605: aload_1
    //   606: invokevirtual 378	java/lang/Exception:printStackTrace	()V
    //   609: goto -402 -> 207
    //   612: astore_1
    //   613: aload_1
    //   614: invokevirtual 378	java/lang/Exception:printStackTrace	()V
    //   617: goto -398 -> 219
    //   620: astore_3
    //   621: aload_3
    //   622: invokevirtual 282	org/json/JSONException:printStackTrace	()V
    //   625: goto -158 -> 467
    //   628: astore_3
    //   629: aload_2
    //   630: astore 5
    //   632: aload_3
    //   633: astore_2
    //   634: goto -54 -> 580
    //   637: astore_2
    //   638: aload_2
    //   639: invokevirtual 378	java/lang/Exception:printStackTrace	()V
    //   642: goto -165 -> 477
    //   645: astore_3
    //   646: aload_3
    //   647: invokevirtual 378	java/lang/Exception:printStackTrace	()V
    //   650: goto -58 -> 592
    //   653: astore_1
    //   654: aload_1
    //   655: invokevirtual 378	java/lang/Exception:printStackTrace	()V
    //   658: goto -56 -> 602
    //   661: astore_2
    //   662: aconst_null
    //   663: astore 5
    //   665: aload 4
    //   667: astore_1
    //   668: goto -88 -> 580
    //   671: astore_3
    //   672: aconst_null
    //   673: astore_2
    //   674: goto -232 -> 442
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	677	0	this	QWalletCommonJsPlugin
    //   7	475	1	localObject1	Object
    //   490	2	1	localException1	Exception
    //   500	97	1	localObject2	Object
    //   604	2	1	localException2	Exception
    //   612	2	1	localException3	Exception
    //   653	2	1	localException4	Exception
    //   667	1	1	localObject3	Object
    //   9	625	2	localObject4	Object
    //   637	2	2	localException5	Exception
    //   661	1	2	localObject5	Object
    //   673	1	2	localObject6	Object
    //   14	421	3	localObject7	Object
    //   438	68	3	localException6	Exception
    //   509	45	3	str1	String
    //   575	4	3	localObject8	Object
    //   620	2	3	localJSONException	JSONException
    //   628	5	3	localObject9	Object
    //   645	2	3	localException7	Exception
    //   671	1	3	localException8	Exception
    //   11	655	4	localObject10	Object
    //   45	619	5	localObject11	Object
    //   1	536	6	str2	String
    //   4	563	7	localJSONObject1	JSONObject
    //   31	427	8	localJSONObject2	JSONObject
    //   40	525	9	localJSONArray	org.json.JSONArray
    // Exception table:
    //   from	to	target	type
    //   81	91	438	java/lang/Exception
    //   100	118	438	java/lang/Exception
    //   124	131	438	java/lang/Exception
    //   149	159	438	java/lang/Exception
    //   168	179	438	java/lang/Exception
    //   185	195	438	java/lang/Exception
    //   228	235	438	java/lang/Exception
    //   244	264	438	java/lang/Exception
    //   270	288	438	java/lang/Exception
    //   294	332	438	java/lang/Exception
    //   343	353	438	java/lang/Exception
    //   359	377	438	java/lang/Exception
    //   383	390	438	java/lang/Exception
    //   401	411	438	java/lang/Exception
    //   425	432	438	java/lang/Exception
    //   504	510	438	java/lang/Exception
    //   516	525	438	java/lang/Exception
    //   531	542	438	java/lang/Exception
    //   548	558	438	java/lang/Exception
    //   564	572	438	java/lang/Exception
    //   481	487	490	java/lang/Exception
    //   81	91	575	finally
    //   100	118	575	finally
    //   124	131	575	finally
    //   149	159	575	finally
    //   168	179	575	finally
    //   185	195	575	finally
    //   228	235	575	finally
    //   244	264	575	finally
    //   270	288	575	finally
    //   294	332	575	finally
    //   343	353	575	finally
    //   359	377	575	finally
    //   383	390	575	finally
    //   401	411	575	finally
    //   425	432	575	finally
    //   504	510	575	finally
    //   516	525	575	finally
    //   531	542	575	finally
    //   548	558	575	finally
    //   564	572	575	finally
    //   200	207	604	java/lang/Exception
    //   212	219	612	java/lang/Exception
    //   446	467	620	org/json/JSONException
    //   442	446	628	finally
    //   446	467	628	finally
    //   621	625	628	finally
    //   471	477	637	java/lang/Exception
    //   585	592	645	java/lang/Exception
    //   596	602	653	java/lang/Exception
    //   42	65	661	finally
    //   42	65	671	java/lang/Exception
  }
  
  private void getAppAuthCode(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      long l = SystemClock.uptimeMillis();
      if ((l <= this.mLastAuthCodeReqTime) || (l - this.mLastAuthCodeReqTime >= 200L))
      {
        this.mLastAuthCodeReqTime = l;
        this.mReqAuthCodeStartTime = l;
        try
        {
          paramString = new JSONObject(paramString).optString("appid");
          if (!TextUtils.isEmpty(paramString))
          {
            this.mAuthCodeAppId = Long.valueOf(paramString).longValue();
            Object localObject = null;
            paramString = localObject;
            if (this.mRuntime != null)
            {
              paramString = localObject;
              if (this.mRuntime.a() != null) {
                paramString = this.mRuntime.a().getCurrentAccountUin();
              }
            }
            if (TextUtils.isEmpty(paramString))
            {
              sendAuthCodeReq();
              return;
            }
          }
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
          return;
          paramString = this.mRuntime.a().getFilesDir() + "/QWallet/cache_ac_" + paramString;
          if (!new File(paramString).exists())
          {
            sendAuthCodeReq();
            return;
          }
        }
        catch (NumberFormatException paramString)
        {
          paramString.printStackTrace();
          return;
        }
      }
    }
    if ((this.executorService == null) || (this.executorService.isShutdown())) {
      this.executorService = Executors.newFixedThreadPool(1);
    }
    this.executorService.execute(new QWalletCommonJsPlugin.4(this, paramString));
  }
  
  private JSONObject getSecurityPayIsOpenJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("isSecurityPayOpen", isSecurityPayOpen());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  /* Error */
  private JSONObject getSelectContact(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 6
    //   8: new 193	org/json/JSONObject
    //   11: dup
    //   12: invokespecial 294	org/json/JSONObject:<init>	()V
    //   15: astore 7
    //   17: getstatic 303	android/provider/ContactsContract$Contacts:CONTENT_URI	Landroid/net/Uri;
    //   20: astore_3
    //   21: aload_0
    //   22: getfield 156	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:mContext	Landroid/content/Context;
    //   25: invokevirtual 309	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   28: aload_3
    //   29: aconst_null
    //   30: ldc_w 472
    //   33: iconst_1
    //   34: anewarray 287	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: aload_1
    //   40: aastore
    //   41: aconst_null
    //   42: invokevirtual 315	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   45: astore_3
    //   46: aload_3
    //   47: astore_2
    //   48: aload_2
    //   49: invokeinterface 321 1 0
    //   54: ifeq +412 -> 466
    //   57: aload_0
    //   58: aload_2
    //   59: aload_2
    //   60: ldc_w 323
    //   63: invokeinterface 327 2 0
    //   68: invokeinterface 331 2 0
    //   73: invokevirtual 351	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:trimPhoneName	(Ljava/lang/String;)Ljava/lang/String;
    //   76: astore_3
    //   77: aload_2
    //   78: aload_2
    //   79: ldc_w 353
    //   82: invokeinterface 327 2 0
    //   87: invokeinterface 357 2 0
    //   92: ifle +369 -> 461
    //   95: aload_0
    //   96: getfield 156	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:mContext	Landroid/content/Context;
    //   99: invokevirtual 309	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   102: getstatic 362	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   105: aconst_null
    //   106: new 364	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 365	java/lang/StringBuilder:<init>	()V
    //   113: ldc_w 367
    //   116: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_1
    //   120: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 375	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: aconst_null
    //   127: aconst_null
    //   128: invokevirtual 315	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   131: astore_1
    //   132: aload_1
    //   133: astore 5
    //   135: aload_1
    //   136: astore 4
    //   138: aload_1
    //   139: invokeinterface 321 1 0
    //   144: ifeq +314 -> 458
    //   147: aload_1
    //   148: astore 5
    //   150: aload_1
    //   151: astore 4
    //   153: aload_0
    //   154: aload_1
    //   155: aload_1
    //   156: ldc_w 377
    //   159: invokeinterface 327 2 0
    //   164: invokeinterface 331 2 0
    //   169: invokevirtual 381	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:trimPhoneNumPre	(Ljava/lang/String;)Ljava/lang/String;
    //   172: astore 6
    //   174: aload_1
    //   175: astore 5
    //   177: aload_1
    //   178: astore 4
    //   180: aload 6
    //   182: invokestatic 188	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   185: ifne +65 -> 250
    //   188: aload_1
    //   189: astore 5
    //   191: aload_1
    //   192: astore 4
    //   194: aload_3
    //   195: invokestatic 188	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   198: ifne +52 -> 250
    //   201: aload_1
    //   202: astore 5
    //   204: aload_1
    //   205: astore 4
    //   207: aload 7
    //   209: ldc_w 342
    //   212: iconst_0
    //   213: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   216: pop
    //   217: aload_1
    //   218: astore 5
    //   220: aload_1
    //   221: astore 4
    //   223: aload 7
    //   225: ldc_w 383
    //   228: aload_3
    //   229: invokevirtual 340	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   232: pop
    //   233: aload_1
    //   234: astore 5
    //   236: aload_1
    //   237: astore 4
    //   239: aload 7
    //   241: ldc_w 385
    //   244: aload 6
    //   246: invokevirtual 340	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   249: pop
    //   250: aload_2
    //   251: ifnull +9 -> 260
    //   254: aload_2
    //   255: invokeinterface 348 1 0
    //   260: aload_1
    //   261: ifnull +9 -> 270
    //   264: aload_1
    //   265: invokeinterface 348 1 0
    //   270: aload 7
    //   272: areturn
    //   273: astore_2
    //   274: aload_2
    //   275: invokevirtual 378	java/lang/Exception:printStackTrace	()V
    //   278: goto -18 -> 260
    //   281: astore_1
    //   282: aload_1
    //   283: invokevirtual 378	java/lang/Exception:printStackTrace	()V
    //   286: aload 7
    //   288: areturn
    //   289: astore_3
    //   290: aconst_null
    //   291: astore_1
    //   292: aload_3
    //   293: invokevirtual 378	java/lang/Exception:printStackTrace	()V
    //   296: aload 7
    //   298: ldc_w 342
    //   301: iconst_m1
    //   302: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   305: pop
    //   306: aload 7
    //   308: ldc_w 383
    //   311: ldc_w 474
    //   314: invokevirtual 340	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   317: pop
    //   318: aload 7
    //   320: ldc_w 385
    //   323: ldc_w 474
    //   326: invokevirtual 340	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   329: pop
    //   330: aload_2
    //   331: ifnull +9 -> 340
    //   334: aload_2
    //   335: invokeinterface 348 1 0
    //   340: aload_1
    //   341: ifnull -71 -> 270
    //   344: aload_1
    //   345: invokeinterface 348 1 0
    //   350: aload 7
    //   352: areturn
    //   353: astore_1
    //   354: aload_1
    //   355: invokevirtual 378	java/lang/Exception:printStackTrace	()V
    //   358: aload 7
    //   360: areturn
    //   361: astore_3
    //   362: aload_3
    //   363: invokevirtual 282	org/json/JSONException:printStackTrace	()V
    //   366: goto -36 -> 330
    //   369: astore 4
    //   371: aload_1
    //   372: astore_3
    //   373: aload 4
    //   375: astore_1
    //   376: aload_2
    //   377: ifnull +9 -> 386
    //   380: aload_2
    //   381: invokeinterface 348 1 0
    //   386: aload_3
    //   387: ifnull +9 -> 396
    //   390: aload_3
    //   391: invokeinterface 348 1 0
    //   396: aload_1
    //   397: athrow
    //   398: astore_2
    //   399: aload_2
    //   400: invokevirtual 378	java/lang/Exception:printStackTrace	()V
    //   403: goto -63 -> 340
    //   406: astore_2
    //   407: aload_2
    //   408: invokevirtual 378	java/lang/Exception:printStackTrace	()V
    //   411: goto -25 -> 386
    //   414: astore_2
    //   415: aload_2
    //   416: invokevirtual 378	java/lang/Exception:printStackTrace	()V
    //   419: goto -23 -> 396
    //   422: astore_1
    //   423: aconst_null
    //   424: astore_2
    //   425: aload 4
    //   427: astore_3
    //   428: goto -52 -> 376
    //   431: astore_1
    //   432: aload 4
    //   434: astore_3
    //   435: goto -59 -> 376
    //   438: astore_1
    //   439: aload 5
    //   441: astore_3
    //   442: goto -66 -> 376
    //   445: astore_3
    //   446: aconst_null
    //   447: astore_1
    //   448: goto -156 -> 292
    //   451: astore_3
    //   452: aload 4
    //   454: astore_1
    //   455: goto -163 -> 292
    //   458: goto -284 -> 174
    //   461: aconst_null
    //   462: astore_1
    //   463: goto -289 -> 174
    //   466: aconst_null
    //   467: astore_3
    //   468: aconst_null
    //   469: astore_1
    //   470: goto -296 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	473	0	this	QWalletCommonJsPlugin
    //   0	473	1	paramString	String
    //   1	254	2	localObject1	Object
    //   273	108	2	localException1	Exception
    //   398	2	2	localException2	Exception
    //   406	2	2	localException3	Exception
    //   414	2	2	localException4	Exception
    //   424	1	2	localObject2	Object
    //   20	209	3	localObject3	Object
    //   289	4	3	localException5	Exception
    //   361	2	3	localJSONException	JSONException
    //   372	70	3	localObject4	Object
    //   445	1	3	localException6	Exception
    //   451	1	3	localException7	Exception
    //   467	1	3	localObject5	Object
    //   3	235	4	str1	String
    //   369	84	4	localObject6	Object
    //   133	307	5	str2	String
    //   6	239	6	str3	String
    //   15	344	7	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   254	260	273	java/lang/Exception
    //   264	270	281	java/lang/Exception
    //   17	46	289	java/lang/Exception
    //   344	350	353	java/lang/Exception
    //   296	330	361	org/json/JSONException
    //   292	296	369	finally
    //   296	330	369	finally
    //   362	366	369	finally
    //   334	340	398	java/lang/Exception
    //   380	386	406	java/lang/Exception
    //   390	396	414	java/lang/Exception
    //   17	46	422	finally
    //   48	132	431	finally
    //   138	147	438	finally
    //   153	174	438	finally
    //   180	188	438	finally
    //   194	201	438	finally
    //   207	217	438	finally
    //   223	233	438	finally
    //   239	250	438	finally
    //   48	132	445	java/lang/Exception
    //   138	147	451	java/lang/Exception
    //   153	174	451	java/lang/Exception
    //   180	188	451	java/lang/Exception
    //   194	201	451	java/lang/Exception
    //   207	217	451	java/lang/Exception
    //   223	233	451	java/lang/Exception
    //   239	250	451	java/lang/Exception
  }
  
  private void handleRedPackSkin(String paramString, int paramInt)
  {
    if (paramInt == 1) {}
    try
    {
      if (new JSONObject(paramString).optInt("action") == 1) {
        RedPacketManager.getInstance().requestRedPacketSkinList();
      }
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void handleSkin(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if ((TextUtils.isEmpty(paramString)) || ((paramInt1 == 2) && (paramInt2 == 2))) {}
    while (paramInt2 != 1) {
      try
      {
        if (new JSONObject(paramString).getInt("status") == 1)
        {
          QWalletSkinHandler.a().a(bool);
          System.out.println();
          paramString = new JSONObject();
          paramString.put("result_code", 0);
          doCallback(paramString.toString());
        }
        do
        {
          return;
          bool = false;
          break;
        } while (paramInt1 != 4);
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        switch (paramString.getInt("action"))
        {
        case 0: 
          localJSONObject.put("result_code", 1);
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      QWalletSkinHandler.a().a(new QWalletCommonJsPlugin.2(this, localJSONObject));
      return;
      paramInt1 = paramString.getInt("skin_id");
      QWalletSkinHandler.a().a(paramInt1, new QWalletCommonJsPlugin.3(this, localJSONObject));
      return;
      bool = QWalletSkinHandler.a().a(0, null);
      if (bool) {}
      for (;;)
      {
        try
        {
          localJSONObject.put("status", 1);
          localJSONObject.put("skin_id", QWalletSkinHandler.a().a());
          doCallback(localJSONObject.toString());
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          return;
        }
        localJSONObject.put("status", 0);
      }
    }
  }
  
  private boolean isSecurityPayOpen()
  {
    if (this.mContext == null) {
      return false;
    }
    return JumpQqPimSecureUtil.f(this.mContext);
  }
  
  private void notifyViewUpdate(String paramString1, String paramString2)
  {
    for (;;)
    {
      int i;
      int j;
      String str1;
      try
      {
        paramString1 = new JSONObject(paramString1);
        i = paramString1.optInt("bid");
        j = paramString1.optInt("viewid");
        str1 = paramString1.optString("extstr");
        if ((i == 2) || (i == 4))
        {
          handleSkin(str1, i, j);
          return;
        }
        if ((i == 3) && (j == 1))
        {
          updateGoldMsgEntry();
          paramString1 = new Intent("action_notify_view_update");
          paramString1.putExtra("businessId", i);
          paramString1.putExtra("viewId", j);
          paramString1.putExtra("extstr", str1);
          this.mContext.sendBroadcast(paramString1);
          return;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      if (i == 5)
      {
        handleRedPackSkin(str1, j);
      }
      else if (i == 10)
      {
        paramString2 = "";
        paramString1 = paramString2;
      }
      try
      {
        if (!TextUtils.isEmpty(str1))
        {
          Object localObject1 = new JSONObject(str1);
          paramString1 = ((JSONObject)localObject1).optString("listid");
          localObject1 = ((JSONObject)localObject1).optString("feedsid");
          Object localObject2 = TenCookie.getInstance().getTempArgs(paramString1);
          paramString1 = paramString2;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            paramString1 = paramString2;
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject2 = new JSONObject((String)localObject2);
              String str2 = ((JSONObject)localObject2).optString("feedsid");
              paramString1 = paramString2;
              if (!TextUtils.isEmpty(str2))
              {
                paramString1 = paramString2;
                if (((String)localObject1).equals(str2))
                {
                  paramString1 = new JSONObject();
                  paramString1.put("amount", ((JSONObject)localObject2).optString("amount"));
                  paramString1.put("wishing", ((JSONObject)localObject2).optString("wishing"));
                  paramString1 = paramString1.toString();
                }
              }
            }
          }
        }
      }
      catch (Throwable paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
          paramString1 = paramString2;
        }
      }
      doCallback(paramString1);
    }
  }
  
  private boolean openContact()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.PICK");
    localIntent.setData(ContactsContract.Contacts.CONTENT_URI);
    super.startActivityForResult(localIntent, (byte)16);
    return true;
  }
  
  private void parseCallback(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.toLowerCase().indexOf("callback") < 0)) {
      return;
    }
    try
    {
      this.mCallback = new JSONObject(paramString).optString("callback");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void reportAuthCode(String paramString, long paramLong1, long paramLong2)
  {
    str2 = "";
    try
    {
      localObject = this.mRuntime.a();
      str1 = "";
      if (localObject != null) {
        str1 = ((CustomWebView)localObject).getUrl();
      }
      localObject = str2;
      if (!TextUtils.isEmpty(str1)) {
        localObject = URLEncoder.encode(str1, "utf-8");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        int i;
        Object localObject = str2;
        if (QLog.isDevelopLevel())
        {
          localException.printStackTrace();
          localObject = str2;
        }
      }
    }
    i = 3;
    str1 = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      i = 4;
      str1 = "";
      paramLong2 = 0L;
    }
    DcReportUtil.a(null, "dc01021", "" + i + '|' + str1 + '|' + (String)localObject + '|' + "2|" + paramLong1 + "|||" + paramLong2, false);
  }
  
  private void sendAuthCodeReq()
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("appId", this.mAuthCodeAppId);
    localBundle = DataFactory.a("qwallet_getAuthCode", this.mCallback, this.mOnRemoteResp.key, localBundle);
    WebIPCOperator.a().a(localBundle);
  }
  
  private void updateGoldMsgEntry()
  {
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "request_gold_msg_entry", null, null);
  }
  
  protected void doAuthCodeCallback(String paramString, AuthCodeItem paramAuthCodeItem)
  {
    int j = 0;
    long l = SystemClock.uptimeMillis() - this.mReqAuthCodeStartTime;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if ((paramAuthCodeItem != null) && (this.mAuthCodeAppId == paramAuthCodeItem.appid))
        {
          if (TextUtils.isEmpty(paramAuthCodeItem.urlDomain)) {
            break label217;
          }
          String[] arrayOfString = (paramAuthCodeItem.urlDomain + "|#").split("\\|");
          String str = Uri.parse(this.mRuntime.a().getUrl()).getHost().toLowerCase();
          i = 0;
          if ((i < arrayOfString.length - 1) && (!str.contains(arrayOfString[i]))) {
            break label222;
          }
          if (i < arrayOfString.length - 1) {
            break label217;
          }
          i = j;
          if (i != 0)
          {
            localJSONObject.put("code", paramAuthCodeItem.authCode);
            doCallback(paramString, localJSONObject.toString());
            reportAuthCode(paramAuthCodeItem.authCode, this.mAuthCodeAppId, l);
            return;
          }
        }
        localJSONObject.put("code", "");
        doCallback(paramString, localJSONObject.toString());
        reportAuthCode(null, this.mAuthCodeAppId, l);
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      label217:
      int i = 1;
      continue;
      label222:
      i += 1;
    }
  }
  
  protected void dochooseQQFriendsForTransferResult(String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      str = "{\"resultCode\":-1}";
    }
    doCallback(str.toString());
  }
  
  protected long getPluginBusiness()
  {
    return 2415919104L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QWalletCommonJsPlugin", 2, "handleEvent, type=" + paramLong);
    }
    if ((paramLong == 8589934610L) || (paramLong == 8589934601L))
    {
      if (QWalletCommonJsPlugin.QWVideoJsPlugin.access$700(this.mVideoJsPlugin, QWalletCommonJsPlugin.QWVideoJsPlugin.access$600(this.mVideoJsPlugin)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QWalletCommonJsPlugin", 2, "handleEvent_Back,stopVideo:" + QWalletCommonJsPlugin.QWVideoJsPlugin.access$600(this.mVideoJsPlugin));
        }
        return true;
      }
    }
    else {
      if (paramLong != 8589934611L) {
        break label122;
      }
    }
    for (;;)
    {
      return super.handleEvent(paramString, paramLong, paramMap);
      label122:
      if (paramLong == 8589934597L) {
        this.mVideoJsPlugin.resumeOrPause(false, false);
      } else if (paramLong == 2L) {
        this.mVideoJsPlugin.resumeOrPause(true, false);
      }
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (this.mContext == null)) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              paramJsBridgeListener = paramString2 + "_" + paramString3;
              if (paramVarArgs.length > 0) {
                parseCallback(paramVarArgs[0]);
              }
              if ("qw_charge_getSelectContact".equals(paramJsBridgeListener))
              {
                openContact();
                return true;
              }
              if ("qw_charge_getAllContact".equals(paramJsBridgeListener))
              {
                new QWalletCommonJsPlugin.GetAllContactTask(this).execute(new Void[0]);
                return true;
              }
              if (!"qw_charge_gotoQWalletHome".equals(paramJsBridgeListener)) {
                break;
              }
              bool1 = bool2;
            } while (this.mRuntime == null);
            bool1 = bool2;
          } while (this.mRuntime.a() == null);
          QWalletHelper.gotoQWalletHome(this.mRuntime.a());
          return true;
          if ("qw_charge_qqpimsecure_safe_isopen_securitypay".equals(paramJsBridgeListener))
          {
            doCallback(getSecurityPayIsOpenJson().toString());
            return true;
          }
          if ("qw_charge_tenpayTransfer".equals(paramJsBridgeListener))
          {
            if (paramVarArgs.length <= 0)
            {
              chooseQQFriendsForTransfer(null);
              return true;
            }
            chooseQQFriendsForTransfer(paramVarArgs[0]);
            return true;
          }
          if ("qw_charge_checkPermission".equals(paramJsBridgeListener))
          {
            checkWebankPermission();
            return true;
          }
          if (!"qw_charge_emojiPayResultOk".equals(paramJsBridgeListener)) {
            break;
          }
          bool1 = bool2;
        } while (this.mRuntime == null);
        bool1 = bool2;
      } while (this.mRuntime.a() == null);
      this.mRuntime.a().setResult(8213);
      this.mRuntime.a().finish();
      return true;
      if (!"qw_charge_getAppAuthorizationCode".equals(paramJsBridgeListener)) {
        break;
      }
      bool1 = bool2;
    } while (paramVarArgs.length <= 0);
    getAppAuthCode(paramVarArgs[0]);
    return true;
    if ("qw_charge_notifyViewUpdate".equals(paramJsBridgeListener))
    {
      notifyViewUpdate(paramVarArgs[0], paramString1);
      return true;
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramByte == 16) {
      if ((paramInt == -1) && (paramIntent != null) && (paramIntent.getData() != null))
      {
        paramIntent = paramIntent.getData().getLastPathSegment();
        if ((paramIntent != null) && (paramIntent.length() > 0)) {
          new QWalletCommonJsPlugin.SelectContactTask(this).execute(new String[] { paramIntent });
        }
      }
    }
    do
    {
      return;
      if (paramByte == REQUESTCODE_TRANSFER)
      {
        if (paramIntent == null)
        {
          dochooseQQFriendsForTransferResult(null);
          return;
        }
        dochooseQQFriendsForTransferResult(paramIntent.getStringExtra("result"));
        return;
      }
    } while (paramByte != 17);
    Object localObject = paramIntent;
    if (paramIntent == null) {
      localObject = new Intent();
    }
    JSONObject localJSONObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        paramInt = ((Intent)localObject).getIntExtra("retCode", 0);
        paramIntent = ((Intent)localObject).getStringExtra("card_status");
        String str = ((Intent)localObject).getStringExtra("available_amount");
        localObject = ((Intent)localObject).getStringExtra("overdue_amount");
        localJSONObject1.put("retCode", paramInt);
        JSONObject localJSONObject2 = new JSONObject();
        if (paramIntent != null)
        {
          localJSONObject2.put("card_status", paramIntent);
          if (str == null) {
            break label285;
          }
          paramIntent = str;
          localJSONObject2.put("available_amount", paramIntent);
          if (localObject == null) {
            break label278;
          }
          paramIntent = (Intent)localObject;
          localJSONObject2.put("overdue_amount", paramIntent);
          localJSONObject1.put("data", localJSONObject2);
          doCallback(localJSONObject1.toString());
          return;
        }
      }
      catch (JSONException paramIntent)
      {
        paramIntent.printStackTrace();
        doCallback("{'retCode':-1,data:{}}");
        return;
      }
      paramIntent = "0";
      continue;
      label278:
      paramIntent = "0";
      continue;
      label285:
      paramIntent = "0";
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    if (this.mRuntime != null)
    {
      Activity localActivity = this.mRuntime.a();
      if (localActivity != null)
      {
        this.mContext = localActivity.getApplicationContext();
        this.mVideoJsPlugin = new QWalletCommonJsPlugin.QWVideoJsPlugin(this, this.mContext, this, this.mRuntime.a());
        IntentFilter localIntentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
        localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
        localIntentFilter.addAction("android.intent.action.USER_PRESENT");
        localActivity.registerReceiver(this.mScreenReceiver, localIntentFilter);
      }
    }
  }
  
  protected void onDestroy()
  {
    if (this.mRuntime != null)
    {
      Activity localActivity = this.mRuntime.a();
      if (localActivity != null) {
        localActivity.unregisterReceiver(this.mScreenReceiver);
      }
    }
    super.onDestroy();
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("QWalletCommonJsPlugin", 4, "onResponse i:" + toString());
    }
    if ((this.mRuntime == null) || (paramBundle == null)) {}
    label46:
    String str1;
    int i;
    boolean bool;
    do
    {
      do
      {
        String str2;
        do
        {
          break label46;
          do
          {
            return;
          } while (paramBundle.getInt("respkey", -1) != this.mOnRemoteResp.key);
          str1 = paramBundle.getString("callbackid");
          str2 = paramBundle.getString("cmd");
        } while ((TextUtils.isEmpty(str2)) || (str2.compareTo("qwallet_getAuthCode") != 0));
        paramBundle = paramBundle.getBundle("response");
      } while (paramBundle == null);
      i = paramBundle.getInt("qwallet.type");
      bool = paramBundle.getBoolean("qwallet.isSuccess");
      paramBundle = paramBundle.getSerializable("qwallet.data");
    } while ((i != 4) || (this.mAuthCodeAppId == 0L));
    if ((bool) && (paramBundle != null) && ((paramBundle instanceof AuthCodeRsp)))
    {
      paramBundle = (AuthCodeRsp)paramBundle;
      if ((paramBundle.items == null) || (paramBundle.items.size() <= 0)) {}
    }
    for (paramBundle = (AuthCodeItem)paramBundle.items.get(0);; paramBundle = null)
    {
      doAuthCodeCallback(str1, paramBundle);
      return;
    }
  }
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    this.mVideoJsPlugin.onWebViewCreated(this.mRuntime);
  }
  
  void startTransactionActivity(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("come_from", 2);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("targetUin", paramString1);
      localJSONObject.put("targetNickname", paramString2);
      localJSONObject.put("sign", "");
      localIntent.putExtra("extra_data", localJSONObject.toString());
      localIntent.putExtra("app_info", "appid#20000001|bargainor_id#1000026901|channel#wallet");
      localIntent.setClass(this.mContext, TransactionActivity.class);
      super.startActivityForResult(localIntent, REQUESTCODE_TRANSFER);
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public String trimPhoneName(String paramString)
  {
    int j = 0;
    if ((paramString == null) || (paramString.equals(""))) {
      localObject = "";
    }
    String str;
    int i;
    do
    {
      return localObject;
      str = "";
      i = 0;
      localObject = str;
    } while (j >= paramString.length());
    if (i >= 10) {
      return str + "...";
    }
    Object localObject = paramString.substring(j, j + 1);
    if (((String)localObject).matches("[Α-￥]")) {
      i += 2;
    }
    for (;;)
    {
      str = str + (String)localObject;
      j += 1;
      break;
      i += 1;
    }
  }
  
  public String trimPhoneNumPre(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      paramString = "";
    }
    String str;
    do
    {
      return paramString;
      str = paramString;
      if (paramString.contains("+86"))
      {
        if (paramString.length() == 3) {
          return "";
        }
        str = paramString;
        if (paramString.length() > 3)
        {
          str = paramString;
          if (paramString.startsWith("+86")) {
            str = paramString.substring(3);
          }
        }
      }
      str = Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim();
      paramString = str;
    } while (str.length() <= 11);
    return str.subSequence(str.length() - 11, str.length()).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin
 * JD-Core Version:    0.7.0.1
 */