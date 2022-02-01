package com.tencent.mobileqq.vaswebviewplugin;

import Wallet.AuthCodeItem;
import Wallet.AuthCodeRsp;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.provider.ContactsContract.Contacts;
import android.text.TextUtils;
import anni;
import arpd;
import arph;
import arui;
import bgnh;
import bhod;
import blqx;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.microapp.sdk.MiniAppLauncher;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qwallet.plugin.QWalletPayBridge;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;
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
  public static final int VIEW_UPDATE_BID_QQSHOP_TAB = 25;
  public static final int VIEW_UPDATE_VID_QQSHOP_TAB = 1;
  static String mListid = "";
  static String mParamForGarpHb = "";
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
  private final int REQ_CODE_GETALLCONTACT = 3;
  private final int REQ_CODE_GETSELECTCONTACT = 2;
  private final int REQ_CODE_OPENCTCONTACT = 1;
  protected QWalletCommonJsPlugin.ChooseQQFriendForTransferReceiver aioChoFriReceiver;
  AppInterface app;
  private ExecutorService executorService;
  private long mAuthCodeAppId;
  private String mCallback;
  String mContactId;
  private Context mContext;
  protected QQPermissionCallback mGetAllContactCallBack = new QWalletCommonJsPlugin.7(this);
  protected QQPermissionCallback mGetSelectContactCallBack = new QWalletCommonJsPlugin.6(this);
  private long mLastAuthCodeReqTime;
  protected QQPermissionCallback mOpenContactCallBack = new QWalletCommonJsPlugin.5(this);
  protected QWalletCommonJsPlugin.MyResultRecevicer mRecevicer;
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
      paramString = ((JSONObject)localObject2).optString("title", anni.a(2131710199));
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
    //   16: getfield 215	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:mContext	Landroid/content/Context;
    //   19: ifnonnull +5 -> 24
    //   22: aconst_null
    //   23: areturn
    //   24: new 252	org/json/JSONObject
    //   27: dup
    //   28: invokespecial 354	org/json/JSONObject:<init>	()V
    //   31: astore 8
    //   33: new 356	org/json/JSONArray
    //   36: dup
    //   37: invokespecial 357	org/json/JSONArray:<init>	()V
    //   40: astore 9
    //   42: getstatic 363	android/provider/ContactsContract$Contacts:CONTENT_URI	Landroid/net/Uri;
    //   45: astore 5
    //   47: aload_0
    //   48: getfield 215	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:mContext	Landroid/content/Context;
    //   51: invokevirtual 369	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   54: aload 5
    //   56: aconst_null
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: invokevirtual 375	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
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
    //   83: invokeinterface 381 1 0
    //   88: ifeq +74 -> 162
    //   91: aload_3
    //   92: astore 4
    //   94: aload 4
    //   96: astore_1
    //   97: aload 4
    //   99: astore_2
    //   100: aload 5
    //   102: aload 5
    //   104: ldc_w 383
    //   107: invokeinterface 387 2 0
    //   112: invokeinterface 390 2 0
    //   117: astore_3
    //   118: aload 4
    //   120: astore_1
    //   121: aload 4
    //   123: astore_2
    //   124: aload_3
    //   125: invokestatic 247	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
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
    //   151: invokeinterface 393 1 0
    //   156: ifne -62 -> 94
    //   159: aload_3
    //   160: astore 4
    //   162: aload 4
    //   164: astore_1
    //   165: aload 4
    //   167: astore_2
    //   168: aload 8
    //   170: ldc_w 395
    //   173: aload 9
    //   175: invokevirtual 399	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   178: pop
    //   179: aload 4
    //   181: astore_1
    //   182: aload 4
    //   184: astore_2
    //   185: aload 8
    //   187: ldc_w 401
    //   190: iconst_0
    //   191: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   194: pop
    //   195: aload 5
    //   197: ifnull +10 -> 207
    //   200: aload 5
    //   202: invokeinterface 407 1 0
    //   207: aload 4
    //   209: ifnull +10 -> 219
    //   212: aload 4
    //   214: invokeinterface 407 1 0
    //   219: aload 8
    //   221: areturn
    //   222: aload 4
    //   224: astore_1
    //   225: aload 4
    //   227: astore_2
    //   228: aload_0
    //   229: aload_3
    //   230: invokevirtual 410	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:trimPhoneName	(Ljava/lang/String;)Ljava/lang/String;
    //   233: astore 6
    //   235: aload 4
    //   237: astore_3
    //   238: aload 4
    //   240: astore_1
    //   241: aload 4
    //   243: astore_2
    //   244: aload 5
    //   246: aload 5
    //   248: ldc_w 412
    //   251: invokeinterface 387 2 0
    //   256: invokeinterface 416 2 0
    //   261: ifle -127 -> 134
    //   264: aload 4
    //   266: astore_1
    //   267: aload 4
    //   269: astore_2
    //   270: aload 5
    //   272: aload 5
    //   274: ldc_w 418
    //   277: invokeinterface 387 2 0
    //   282: invokeinterface 390 2 0
    //   287: astore_3
    //   288: aload 4
    //   290: astore_1
    //   291: aload 4
    //   293: astore_2
    //   294: aload_0
    //   295: getfield 215	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:mContext	Landroid/content/Context;
    //   298: invokevirtual 369	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   301: getstatic 421	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   304: aconst_null
    //   305: new 423	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 424	java/lang/StringBuilder:<init>	()V
    //   312: ldc_w 426
    //   315: invokevirtual 430	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload_3
    //   319: invokevirtual 430	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 434	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: aconst_null
    //   326: aconst_null
    //   327: invokevirtual 375	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   330: astore 4
    //   332: aload 4
    //   334: ifnull +77 -> 411
    //   337: aload 4
    //   339: astore_1
    //   340: aload 4
    //   342: astore_2
    //   343: aload 4
    //   345: invokeinterface 381 1 0
    //   350: ifeq +61 -> 411
    //   353: aload 4
    //   355: astore_1
    //   356: aload 4
    //   358: astore_2
    //   359: aload 4
    //   361: aload 4
    //   363: ldc_w 436
    //   366: invokeinterface 387 2 0
    //   371: invokeinterface 390 2 0
    //   376: astore_3
    //   377: aload 4
    //   379: astore_1
    //   380: aload 4
    //   382: astore_2
    //   383: aload_3
    //   384: invokestatic 247	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   387: ifeq +111 -> 498
    //   390: aload 4
    //   392: ifnull +19 -> 411
    //   395: aload 4
    //   397: astore_1
    //   398: aload 4
    //   400: astore_2
    //   401: aload 4
    //   403: invokeinterface 393 1 0
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
    //   427: invokeinterface 407 1 0
    //   432: aload 4
    //   434: astore_3
    //   435: goto -301 -> 134
    //   438: astore_3
    //   439: aload 5
    //   441: astore_2
    //   442: aload_3
    //   443: invokevirtual 437	java/lang/Exception:printStackTrace	()V
    //   446: aload 8
    //   448: ldc_w 395
    //   451: aload 9
    //   453: invokevirtual 399	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   456: pop
    //   457: aload 8
    //   459: ldc_w 401
    //   462: iconst_m1
    //   463: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   466: pop
    //   467: aload_2
    //   468: ifnull +9 -> 477
    //   471: aload_2
    //   472: invokeinterface 407 1 0
    //   477: aload_1
    //   478: ifnull -259 -> 219
    //   481: aload_1
    //   482: invokeinterface 407 1 0
    //   487: goto -268 -> 219
    //   490: astore_1
    //   491: aload_1
    //   492: invokevirtual 437	java/lang/Exception:printStackTrace	()V
    //   495: goto -276 -> 219
    //   498: aload 4
    //   500: astore_1
    //   501: aload 4
    //   503: astore_2
    //   504: aload_0
    //   505: aload_3
    //   506: invokevirtual 440	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:trimPhoneNumPre	(Ljava/lang/String;)Ljava/lang/String;
    //   509: astore_3
    //   510: aload 4
    //   512: astore_1
    //   513: aload 4
    //   515: astore_2
    //   516: new 252	org/json/JSONObject
    //   519: dup
    //   520: invokespecial 354	org/json/JSONObject:<init>	()V
    //   523: astore 7
    //   525: aload 4
    //   527: astore_1
    //   528: aload 4
    //   530: astore_2
    //   531: aload 7
    //   533: ldc_w 442
    //   536: aload 6
    //   538: invokevirtual 399	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   541: pop
    //   542: aload 4
    //   544: astore_1
    //   545: aload 4
    //   547: astore_2
    //   548: aload 7
    //   550: ldc_w 444
    //   553: aload_3
    //   554: invokevirtual 399	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   557: pop
    //   558: aload 4
    //   560: astore_1
    //   561: aload 4
    //   563: astore_2
    //   564: aload 9
    //   566: aload 7
    //   568: invokevirtual 447	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
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
    //   587: invokeinterface 407 1 0
    //   592: aload_1
    //   593: ifnull +9 -> 602
    //   596: aload_1
    //   597: invokeinterface 407 1 0
    //   602: aload_2
    //   603: athrow
    //   604: astore_1
    //   605: aload_1
    //   606: invokevirtual 437	java/lang/Exception:printStackTrace	()V
    //   609: goto -402 -> 207
    //   612: astore_1
    //   613: aload_1
    //   614: invokevirtual 437	java/lang/Exception:printStackTrace	()V
    //   617: goto -398 -> 219
    //   620: astore_3
    //   621: aload_3
    //   622: invokevirtual 345	org/json/JSONException:printStackTrace	()V
    //   625: goto -158 -> 467
    //   628: astore_3
    //   629: aload_2
    //   630: astore 5
    //   632: aload_3
    //   633: astore_2
    //   634: goto -54 -> 580
    //   637: astore_2
    //   638: aload_2
    //   639: invokevirtual 437	java/lang/Exception:printStackTrace	()V
    //   642: goto -165 -> 477
    //   645: astore_3
    //   646: aload_3
    //   647: invokevirtual 437	java/lang/Exception:printStackTrace	()V
    //   650: goto -58 -> 592
    //   653: astore_1
    //   654: aload_1
    //   655: invokevirtual 437	java/lang/Exception:printStackTrace	()V
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
    this.executorService.execute(new QWalletCommonJsPlugin.2(this, paramString));
  }
  
  public static void getHbDetail(AppInterface paramAppInterface, String paramString, QWalletCommonJsPlugin.MyResultRecevicer paramMyResultRecevicer)
  {
    if (paramAppInterface == null) {
      return;
    }
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("extra_data", paramString.toString());
      localBundle.putString("callbackSn", "0");
      paramString = new Bundle();
      paramString.putInt("PayInvokerId", 22);
      Parcel localParcel = Parcel.obtain();
      paramMyResultRecevicer.writeToParcel(localParcel, 0);
      localParcel.setDataPosition(0);
      paramMyResultRecevicer = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(localParcel);
      localParcel.recycle();
      paramString.putParcelable("_qwallet_payresult_receiver", paramMyResultRecevicer);
      paramString.putBundle("_qwallet_payparams_data", localBundle);
      paramString.putString("_qwallet_payparams_tag", "redgiftDetail");
      QWalletPayBridge.launchBackground(BaseApplicationImpl.sApplication, paramAppInterface, paramString);
      return;
    }
    catch (Throwable paramAppInterface)
    {
      paramAppInterface.printStackTrace();
    }
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
    //   8: new 252	org/json/JSONObject
    //   11: dup
    //   12: invokespecial 354	org/json/JSONObject:<init>	()V
    //   15: astore 7
    //   17: getstatic 363	android/provider/ContactsContract$Contacts:CONTENT_URI	Landroid/net/Uri;
    //   20: astore_3
    //   21: aload_0
    //   22: getfield 215	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:mContext	Landroid/content/Context;
    //   25: invokevirtual 369	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   28: aload_3
    //   29: aconst_null
    //   30: ldc_w 579
    //   33: iconst_1
    //   34: anewarray 347	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: aload_1
    //   40: aastore
    //   41: aconst_null
    //   42: invokevirtual 375	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   45: astore_3
    //   46: aload_3
    //   47: astore_2
    //   48: aload_2
    //   49: invokeinterface 381 1 0
    //   54: ifeq +410 -> 464
    //   57: aload_0
    //   58: aload_2
    //   59: aload_2
    //   60: ldc_w 383
    //   63: invokeinterface 387 2 0
    //   68: invokeinterface 390 2 0
    //   73: invokevirtual 410	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:trimPhoneName	(Ljava/lang/String;)Ljava/lang/String;
    //   76: astore_3
    //   77: aload_2
    //   78: aload_2
    //   79: ldc_w 412
    //   82: invokeinterface 387 2 0
    //   87: invokeinterface 416 2 0
    //   92: ifle +367 -> 459
    //   95: aload_0
    //   96: getfield 215	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:mContext	Landroid/content/Context;
    //   99: invokevirtual 369	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   102: getstatic 421	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   105: aconst_null
    //   106: new 423	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 424	java/lang/StringBuilder:<init>	()V
    //   113: ldc_w 426
    //   116: invokevirtual 430	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_1
    //   120: invokevirtual 430	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 434	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: aconst_null
    //   127: aconst_null
    //   128: invokevirtual 375	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   131: astore_1
    //   132: aload_1
    //   133: astore 5
    //   135: aload_1
    //   136: astore 4
    //   138: aload_1
    //   139: invokeinterface 381 1 0
    //   144: ifeq +312 -> 456
    //   147: aload_1
    //   148: astore 5
    //   150: aload_1
    //   151: astore 4
    //   153: aload_0
    //   154: aload_1
    //   155: aload_1
    //   156: ldc_w 436
    //   159: invokeinterface 387 2 0
    //   164: invokeinterface 390 2 0
    //   169: invokevirtual 440	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:trimPhoneNumPre	(Ljava/lang/String;)Ljava/lang/String;
    //   172: astore 6
    //   174: aload_1
    //   175: astore 5
    //   177: aload_1
    //   178: astore 4
    //   180: aload 6
    //   182: invokestatic 247	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   185: ifne +65 -> 250
    //   188: aload_1
    //   189: astore 5
    //   191: aload_1
    //   192: astore 4
    //   194: aload_3
    //   195: invokestatic 247	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   198: ifne +52 -> 250
    //   201: aload_1
    //   202: astore 5
    //   204: aload_1
    //   205: astore 4
    //   207: aload 7
    //   209: ldc_w 401
    //   212: iconst_0
    //   213: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   216: pop
    //   217: aload_1
    //   218: astore 5
    //   220: aload_1
    //   221: astore 4
    //   223: aload 7
    //   225: ldc_w 442
    //   228: aload_3
    //   229: invokevirtual 399	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   232: pop
    //   233: aload_1
    //   234: astore 5
    //   236: aload_1
    //   237: astore 4
    //   239: aload 7
    //   241: ldc_w 444
    //   244: aload 6
    //   246: invokevirtual 399	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   249: pop
    //   250: aload_2
    //   251: ifnull +9 -> 260
    //   254: aload_2
    //   255: invokeinterface 407 1 0
    //   260: aload_1
    //   261: ifnull +9 -> 270
    //   264: aload_1
    //   265: invokeinterface 407 1 0
    //   270: aload 7
    //   272: areturn
    //   273: astore_2
    //   274: aload_2
    //   275: invokevirtual 437	java/lang/Exception:printStackTrace	()V
    //   278: goto -18 -> 260
    //   281: astore_1
    //   282: aload_1
    //   283: invokevirtual 437	java/lang/Exception:printStackTrace	()V
    //   286: aload 7
    //   288: areturn
    //   289: astore_3
    //   290: aconst_null
    //   291: astore_1
    //   292: aload_3
    //   293: invokevirtual 437	java/lang/Exception:printStackTrace	()V
    //   296: aload 7
    //   298: ldc_w 401
    //   301: iconst_m1
    //   302: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   305: pop
    //   306: aload 7
    //   308: ldc_w 442
    //   311: ldc 77
    //   313: invokevirtual 399	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   316: pop
    //   317: aload 7
    //   319: ldc_w 444
    //   322: ldc 77
    //   324: invokevirtual 399	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   327: pop
    //   328: aload_2
    //   329: ifnull +9 -> 338
    //   332: aload_2
    //   333: invokeinterface 407 1 0
    //   338: aload_1
    //   339: ifnull -69 -> 270
    //   342: aload_1
    //   343: invokeinterface 407 1 0
    //   348: aload 7
    //   350: areturn
    //   351: astore_1
    //   352: aload_1
    //   353: invokevirtual 437	java/lang/Exception:printStackTrace	()V
    //   356: aload 7
    //   358: areturn
    //   359: astore_3
    //   360: aload_3
    //   361: invokevirtual 345	org/json/JSONException:printStackTrace	()V
    //   364: goto -36 -> 328
    //   367: astore 4
    //   369: aload_1
    //   370: astore_3
    //   371: aload 4
    //   373: astore_1
    //   374: aload_2
    //   375: ifnull +9 -> 384
    //   378: aload_2
    //   379: invokeinterface 407 1 0
    //   384: aload_3
    //   385: ifnull +9 -> 394
    //   388: aload_3
    //   389: invokeinterface 407 1 0
    //   394: aload_1
    //   395: athrow
    //   396: astore_2
    //   397: aload_2
    //   398: invokevirtual 437	java/lang/Exception:printStackTrace	()V
    //   401: goto -63 -> 338
    //   404: astore_2
    //   405: aload_2
    //   406: invokevirtual 437	java/lang/Exception:printStackTrace	()V
    //   409: goto -25 -> 384
    //   412: astore_2
    //   413: aload_2
    //   414: invokevirtual 437	java/lang/Exception:printStackTrace	()V
    //   417: goto -23 -> 394
    //   420: astore_1
    //   421: aconst_null
    //   422: astore_2
    //   423: aload 4
    //   425: astore_3
    //   426: goto -52 -> 374
    //   429: astore_1
    //   430: aload 4
    //   432: astore_3
    //   433: goto -59 -> 374
    //   436: astore_1
    //   437: aload 5
    //   439: astore_3
    //   440: goto -66 -> 374
    //   443: astore_3
    //   444: aconst_null
    //   445: astore_1
    //   446: goto -154 -> 292
    //   449: astore_3
    //   450: aload 4
    //   452: astore_1
    //   453: goto -161 -> 292
    //   456: goto -282 -> 174
    //   459: aconst_null
    //   460: astore_1
    //   461: goto -287 -> 174
    //   464: aconst_null
    //   465: astore_3
    //   466: aconst_null
    //   467: astore_1
    //   468: goto -294 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	471	0	this	QWalletCommonJsPlugin
    //   0	471	1	paramString	String
    //   1	254	2	localObject1	Object
    //   273	106	2	localException1	Exception
    //   396	2	2	localException2	Exception
    //   404	2	2	localException3	Exception
    //   412	2	2	localException4	Exception
    //   422	1	2	localObject2	Object
    //   20	209	3	localObject3	Object
    //   289	4	3	localException5	Exception
    //   359	2	3	localJSONException	JSONException
    //   370	70	3	localObject4	Object
    //   443	1	3	localException6	Exception
    //   449	1	3	localException7	Exception
    //   465	1	3	localObject5	Object
    //   3	235	4	str1	String
    //   367	84	4	localObject6	Object
    //   133	305	5	str2	String
    //   6	239	6	str3	String
    //   15	342	7	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   254	260	273	java/lang/Exception
    //   264	270	281	java/lang/Exception
    //   17	46	289	java/lang/Exception
    //   342	348	351	java/lang/Exception
    //   296	328	359	org/json/JSONException
    //   292	296	367	finally
    //   296	328	367	finally
    //   360	364	367	finally
    //   332	338	396	java/lang/Exception
    //   378	384	404	java/lang/Exception
    //   388	394	412	java/lang/Exception
    //   17	46	420	finally
    //   48	132	429	finally
    //   138	147	436	finally
    //   153	174	436	finally
    //   180	188	436	finally
    //   194	201	436	finally
    //   207	217	436	finally
    //   223	233	436	finally
    //   239	250	436	finally
    //   48	132	443	java/lang/Exception
    //   138	147	449	java/lang/Exception
    //   153	174	449	java/lang/Exception
    //   180	188	449	java/lang/Exception
    //   194	201	449	java/lang/Exception
    //   207	217	449	java/lang/Exception
    //   223	233	449	java/lang/Exception
    //   239	250	449	java/lang/Exception
  }
  
  private void handleMiniApp(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 20) && (paramInt2 == 1)) {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.optInt("action") == 1)
        {
          paramString = paramString.optString("mini_appid");
          JSONObject localJSONObject = new JSONObject();
          if (MiniAppLauncher.launchMiniApp(this.mContext, paramString, 1201)) {
            localJSONObject.put("result_code", 0);
          }
          for (;;)
          {
            doCallback(localJSONObject.toString());
            return;
            localJSONObject.put("result_code", 1);
          }
        }
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        try
        {
          paramString = new JSONObject();
          paramString.put("result_code", 1);
          doCallback(paramString.toString());
          return;
        }
        catch (Throwable paramString) {}
      }
    }
  }
  
  private boolean handleOpenContact()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      Activity localActivity = this.mRuntime.a();
      if ((localActivity instanceof AppActivity))
      {
        if (((AppActivity)localActivity).checkSelfPermission("android.permission.READ_CONTACTS") != 0)
        {
          ((AppActivity)localActivity).requestPermissions(this.mOpenContactCallBack, 1, new String[] { "android.permission.READ_CONTACTS" });
          return true;
        }
        openContact();
        return true;
      }
      callJs(this.mCallback, new String[] { "false", "no record activity" });
      return true;
    }
    openContact();
    return true;
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
  
  private void handleSkin(String paramString, int paramInt1, int paramInt2) {}
  
  private boolean isSecurityPayOpen()
  {
    if (this.mContext == null) {
      return false;
    }
    return bgnh.f(this.mContext);
  }
  
  private void notifyViewUpdate(String paramString1, String paramString2)
  {
    for (;;)
    {
      int i;
      int j;
      String str;
      try
      {
        paramString1 = new JSONObject(paramString1);
        i = paramString1.optInt("bid");
        j = paramString1.optInt("viewid");
        str = paramString1.optString("extstr");
        if ((i != 2) && (i != 4)) {
          break label732;
        }
        handleSkin(str, i, j);
        paramString1 = new Intent("action_notify_view_update");
        paramString1.putExtra("businessId", i);
        paramString1.putExtra("viewId", j);
        paramString1.putExtra("extstr", str);
        this.mContext.sendBroadcast(paramString1);
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      if (i == 5)
      {
        handleRedPackSkin(str, j);
      }
      else
      {
        Object localObject1;
        Object localObject2;
        Object localObject3;
        if (i == 10)
        {
          paramString2 = "";
          paramString1 = paramString2;
          try
          {
            if (!TextUtils.isEmpty(str))
            {
              localObject1 = new JSONObject(str);
              paramString1 = ((JSONObject)localObject1).optString("listid");
              localObject1 = ((JSONObject)localObject1).optString("feedsid");
              localObject2 = blqx.a().b(paramString1);
              paramString1 = paramString2;
              if (!TextUtils.isEmpty((CharSequence)localObject1))
              {
                paramString1 = paramString2;
                if (!TextUtils.isEmpty((CharSequence)localObject2))
                {
                  localObject2 = new JSONObject((String)localObject2);
                  localObject3 = ((JSONObject)localObject2).optString("feedsid");
                  paramString1 = paramString2;
                  if (!TextUtils.isEmpty((CharSequence)localObject3))
                  {
                    paramString1 = paramString2;
                    if (((String)localObject1).equals(localObject3))
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
          continue;
        }
        if ((i == 17) && (j == 1))
        {
          try
          {
            if (TextUtils.isEmpty(str)) {
              continue;
            }
            localObject2 = new JSONObject(str);
            paramString1 = ((JSONObject)localObject2).optString("listid");
            paramString2 = ((JSONObject)localObject2).optString("uin");
            localObject1 = ((JSONObject)localObject2).optString("offset");
            localObject2 = ((JSONObject)localObject2).optString("limit");
            if ((TextUtils.isEmpty(paramString2)) || (!paramString2.equals(this.app.getCurrentAccountUin())) || (TextUtils.isEmpty(paramString1))) {
              break label633;
            }
            mListid = paramString1;
            mParamForGarpHb = blqx.a().b(paramString1);
            if (QLog.isColorLevel()) {
              QLog.d("QWalletCommonJsPlugin", 2, "paramForGarpHb paramForGarpHb:" + mParamForGarpHb);
            }
            if (TextUtils.isEmpty(mParamForGarpHb)) {
              break label615;
            }
            localObject3 = new JSONObject(mParamForGarpHb);
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("listid", paramString1);
            localJSONObject.put("uin", paramString2);
            localJSONObject.put("offset", localObject1);
            localJSONObject.put("limit", localObject2);
            localJSONObject.put("authkey", ((JSONObject)localObject3).optString("authkey"));
            localJSONObject.put("grouptype", ((JSONObject)localObject3).optString("grouptype"));
            localJSONObject.put("groupid", ((JSONObject)localObject3).optString("groupid"));
            localJSONObject.put("viewTag", "redgiftDetail");
            getHbDetail(this.app, localJSONObject.toString(), this.mRecevicer);
          }
          catch (Throwable paramString1)
          {
            paramString1.printStackTrace();
          }
          continue;
          label615:
          if (QLog.isColorLevel())
          {
            QLog.d("QWalletCommonJsPlugin", 2, "paramForGarpHb is null");
            continue;
            label633:
            if (QLog.isColorLevel()) {
              QLog.d("QWalletCommonJsPlugin", 2, "notifyViewUpdate extstr = " + str);
            }
          }
        }
        else if ((i == 20) && (j == 1))
        {
          handleMiniApp(str, i, j);
        }
        else if (((i != 21) || (j != 1)) && ((i != 22) || (j != 1)) && (i == 25) && (j == 1))
        {
          continue;
          label732:
          if (i == 3) {
            if (j == 1) {}
          }
        }
      }
    }
  }
  
  private void openContact()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.PICK");
    localIntent.setData(ContactsContract.Contacts.CONTENT_URI);
    super.startActivityForResult(localIntent, (byte)16);
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
    CustomWebView localCustomWebView = this.mRuntime.a();
    localCustomWebView.post(new QWalletCommonJsPlugin.4(this, paramLong2, localCustomWebView, paramString, paramLong1));
  }
  
  private void sendAuthCodeReq()
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("appId", this.mAuthCodeAppId);
    localBundle = arph.a("qwallet_getAuthCode", this.mCallback, this.mOnRemoteResp.key, localBundle);
    arui.a().a(localBundle);
  }
  
  protected void doAuthCodeCallback(String paramString, AuthCodeItem paramAuthCodeItem)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.mReqAuthCodeStartTime;
    CustomWebView localCustomWebView = this.mRuntime.a();
    localCustomWebView.post(new QWalletCommonJsPlugin.3(this, paramAuthCodeItem, localCustomWebView, paramString, l1 - l2));
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
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QWalletCommonJsPlugin", 2, "handleEvent, type=" + paramLong);
    }
    if ((paramLong == 8589934610L) || (paramLong == 8589934601L))
    {
      if (QWalletCommonJsPlugin.QWVideoJsPlugin.access$900(this.mVideoJsPlugin, QWalletCommonJsPlugin.QWVideoJsPlugin.access$800(this.mVideoJsPlugin)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QWalletCommonJsPlugin", 2, "handleEvent_Back,stopVideo:" + QWalletCommonJsPlugin.QWVideoJsPlugin.access$800(this.mVideoJsPlugin));
        }
        return true;
      }
    }
    else {
      if (paramLong != 8589934611L) {
        break label122;
      }
    }
    label122:
    do
    {
      for (;;)
      {
        return super.handleEvent(paramString, paramLong, paramMap);
        if (paramLong == 8589934597L)
        {
          this.mVideoJsPlugin.resumeOrPause(false, false);
        }
        else
        {
          if (paramLong != 2L) {
            break;
          }
          this.mVideoJsPlugin.resumeOrPause(true, false);
        }
      }
      if (paramLong == 8589934619L)
      {
        paramString = new JSONObject();
        if (paramMap != null) {}
        try
        {
          paramString.put("action", (Integer)paramMap.get("action"));
          dispatchJsEvent("walletFeedsEvent", paramString, null);
          return true;
        }
        catch (ClassCastException localClassCastException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QWalletCommonJsPlugin", 2, "action, " + paramMap.get("action"));
            }
            localClassCastException.printStackTrace();
          }
        }
        catch (JSONException paramMap)
        {
          for (;;)
          {
            paramMap.printStackTrace();
          }
        }
      }
    } while (paramLong != 8589934620L);
    paramString = new JSONObject();
    if (paramMap != null) {}
    try
    {
      paramString.put("action", (Integer)paramMap.get("action"));
      paramString.put("height", (Integer)paramMap.get("height"));
      paramString.put("sHeight", (Integer)paramMap.get("sHeight"));
      dispatchJsEvent("walletFeedsEvent", paramString, null);
      return true;
    }
    catch (ClassCastException paramMap)
    {
      for (;;)
      {
        paramMap.printStackTrace();
      }
    }
    catch (JSONException paramMap)
    {
      for (;;)
      {
        paramMap.printStackTrace();
      }
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (this.mContext == null)) {
      return false;
    }
    paramJsBridgeListener = paramString2 + "_" + paramString3;
    if (paramVarArgs.length > 0) {
      parseCallback(paramVarArgs[0]);
    }
    if ("qw_charge_getSelectContact".equals(paramJsBridgeListener))
    {
      handleOpenContact();
      return true;
    }
    if ("qw_charge_getAllContact".equals(paramJsBridgeListener))
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        paramJsBridgeListener = this.mRuntime.a();
        if ((paramJsBridgeListener instanceof AppActivity)) {
          if (((AppActivity)paramJsBridgeListener).checkSelfPermission("android.permission.READ_CONTACTS") != 0) {
            ((AppActivity)paramJsBridgeListener).requestPermissions(this.mGetAllContactCallBack, 3, new String[] { "android.permission.READ_CONTACTS" });
          }
        }
      }
      for (;;)
      {
        return true;
        new QWalletCommonJsPlugin.GetAllContactTask(this).execute(new Void[0]);
        continue;
        callJs(this.mCallback, new String[] { "false", "no record activity" });
        continue;
        new QWalletCommonJsPlugin.GetAllContactTask(this).execute(new Void[0]);
      }
    }
    if ("qw_charge_gotoQWalletHome".equals(paramJsBridgeListener))
    {
      if ((this.mRuntime != null) && (this.mRuntime.a() != null)) {
        QWalletHelper.gotoQWalletHome(this.mRuntime.a());
      }
      return true;
    }
    if ("qw_charge_qqpimsecure_safe_isopen_securitypay".equals(paramJsBridgeListener))
    {
      doCallback(getSecurityPayIsOpenJson().toString());
      return true;
    }
    if ("qw_charge_tenpayTransfer".equals(paramJsBridgeListener))
    {
      if (paramVarArgs.length <= 0) {
        chooseQQFriendsForTransfer(null);
      }
      for (;;)
      {
        return true;
        chooseQQFriendsForTransfer(paramVarArgs[0]);
      }
    }
    if ("qw_charge_checkPermission".equals(paramJsBridgeListener))
    {
      checkWebankPermission();
      return true;
    }
    if ("qw_charge_emojiPayResultOk".equals(paramJsBridgeListener))
    {
      if ((this.mRuntime != null) && (this.mRuntime.a() != null))
      {
        this.mRuntime.a().setResult(8213);
        this.mRuntime.a().finish();
      }
      return true;
    }
    if ("qw_charge_getAppAuthorizationCode".equals(paramJsBridgeListener))
    {
      if (paramVarArgs.length > 0) {
        getAppAuthCode(paramVarArgs[0]);
      }
      return true;
    }
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
        if ((paramIntent != null) && (paramIntent.length() > 0))
        {
          this.mContactId = paramIntent;
          if (Build.VERSION.SDK_INT < 23) {
            break label162;
          }
          localObject = this.mRuntime.a();
          if (!(localObject instanceof AppActivity)) {
            break label137;
          }
          if (((AppActivity)localObject).checkSelfPermission("android.permission.READ_CONTACTS") == 0) {
            break label116;
          }
          ((AppActivity)localObject).requestPermissions(this.mGetSelectContactCallBack, 2, new String[] { "android.permission.READ_CONTACTS" });
        }
      }
    }
    label116:
    do
    {
      return;
      new QWalletCommonJsPlugin.SelectContactTask(this).execute(new String[] { paramIntent });
      return;
      callJs(this.mCallback, new String[] { "false", "no record activity" });
      return;
      new QWalletCommonJsPlugin.SelectContactTask(this).execute(new String[] { paramIntent });
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
    label137:
    label162:
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
            break label399;
          }
          paramIntent = str;
          localJSONObject2.put("available_amount", paramIntent);
          if (localObject == null) {
            break label392;
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
      label392:
      paramIntent = "0";
      continue;
      label399:
      paramIntent = "0";
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (this.mRuntime != null)
    {
      Activity localActivity = this.mRuntime.a();
      if (localActivity != null)
      {
        this.app = this.mRuntime.a();
        this.mContext = localActivity.getApplicationContext();
        this.mVideoJsPlugin = new QWalletCommonJsPlugin.QWVideoJsPlugin(this, this.mContext, this, this.mRuntime.a());
        IntentFilter localIntentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
        localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
        localIntentFilter.addAction("android.intent.action.USER_PRESENT");
        localActivity.registerReceiver(this.mScreenReceiver, localIntentFilter);
        this.mRecevicer = new QWalletCommonJsPlugin.MyResultRecevicer(this, new Handler());
      }
    }
  }
  
  public void onDestroy()
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
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin
 * JD-Core Version:    0.7.0.1
 */