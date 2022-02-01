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
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.microapp.sdk.MiniAppLauncher;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IRedPacketProxy;
import com.tencent.mobileqq.utils.JumpQqPimSecureUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qwallet.pluginshare.ITenCookie;
import eipc.EIPCClient;
import eipc.EIPCResult;
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
  private String mCallback = null;
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
    if (this.mRuntime == null) {
      return;
    }
    Object localObject1 = this.mRuntime.d();
    if ((localObject1 != null) && (!TextUtils.isEmpty(paramString))) {
      try
      {
        Object localObject2 = new JSONObject(paramString);
        paramString = ((JSONObject)localObject2).optString("title", HardCodeUtil.a(2131909029));
        boolean bool2 = true;
        int i = ((JSONObject)localObject2).optInt("type", 1);
        this.mCallback = ((JSONObject)localObject2).optString("callback");
        boolean bool1;
        if ((i & 0x1) == 0) {
          bool1 = false;
        } else {
          bool1 = true;
        }
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
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        dochooseQQFriendsForTransferResult(null);
        return;
      }
    }
    dochooseQQFriendsForTransferResult(null);
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
    //   0: aload_0
    //   1: getfield 206	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:mContext	Landroid/content/Context;
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore_2
    //   11: aconst_null
    //   12: astore_1
    //   13: aconst_null
    //   14: astore 8
    //   16: aconst_null
    //   17: astore 6
    //   19: aconst_null
    //   20: astore_3
    //   21: aload 4
    //   23: ifnonnull +5 -> 28
    //   26: aconst_null
    //   27: areturn
    //   28: new 240	org/json/JSONObject
    //   31: dup
    //   32: invokespecial 348	org/json/JSONObject:<init>	()V
    //   35: astore 9
    //   37: new 350	org/json/JSONArray
    //   40: dup
    //   41: invokespecial 351	org/json/JSONArray:<init>	()V
    //   44: astore 10
    //   46: getstatic 357	android/provider/ContactsContract$Contacts:CONTENT_URI	Landroid/net/Uri;
    //   49: astore 4
    //   51: aload_0
    //   52: getfield 206	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:mContext	Landroid/content/Context;
    //   55: invokevirtual 363	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   58: aload 4
    //   60: aconst_null
    //   61: aconst_null
    //   62: aconst_null
    //   63: aconst_null
    //   64: invokevirtual 369	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   67: astore 5
    //   69: aload 7
    //   71: astore 4
    //   73: aload 5
    //   75: ifnull +438 -> 513
    //   78: aload 7
    //   80: astore 4
    //   82: aload 8
    //   84: astore_1
    //   85: aload 6
    //   87: astore_2
    //   88: aload 5
    //   90: invokeinterface 375 1 0
    //   95: ifeq +418 -> 513
    //   98: aload_3
    //   99: astore 4
    //   101: aload 4
    //   103: astore_1
    //   104: aload 4
    //   106: astore_2
    //   107: aload 5
    //   109: aload 5
    //   111: ldc_w 377
    //   114: invokeinterface 381 2 0
    //   119: invokeinterface 384 2 0
    //   124: astore_3
    //   125: aload 4
    //   127: astore_1
    //   128: aload 4
    //   130: astore_2
    //   131: aload_3
    //   132: invokestatic 238	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   135: ifeq +9 -> 144
    //   138: aload 4
    //   140: astore_3
    //   141: goto +341 -> 482
    //   144: aload 4
    //   146: astore_1
    //   147: aload 4
    //   149: astore_2
    //   150: aload_0
    //   151: aload_3
    //   152: invokevirtual 387	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:trimPhoneName	(Ljava/lang/String;)Ljava/lang/String;
    //   155: astore 6
    //   157: aload 4
    //   159: astore_3
    //   160: aload 4
    //   162: astore_1
    //   163: aload 4
    //   165: astore_2
    //   166: aload 5
    //   168: aload 5
    //   170: ldc_w 389
    //   173: invokeinterface 381 2 0
    //   178: invokeinterface 393 2 0
    //   183: ifle +299 -> 482
    //   186: aload 4
    //   188: astore_1
    //   189: aload 4
    //   191: astore_2
    //   192: aload 5
    //   194: aload 5
    //   196: ldc_w 395
    //   199: invokeinterface 381 2 0
    //   204: invokeinterface 384 2 0
    //   209: astore_3
    //   210: aload 4
    //   212: astore_1
    //   213: aload 4
    //   215: astore_2
    //   216: aload_0
    //   217: getfield 206	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:mContext	Landroid/content/Context;
    //   220: invokevirtual 363	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   223: astore 7
    //   225: aload 4
    //   227: astore_1
    //   228: aload 4
    //   230: astore_2
    //   231: getstatic 398	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   234: astore 8
    //   236: aload 4
    //   238: astore_1
    //   239: aload 4
    //   241: astore_2
    //   242: new 400	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 401	java/lang/StringBuilder:<init>	()V
    //   249: astore 11
    //   251: aload 4
    //   253: astore_1
    //   254: aload 4
    //   256: astore_2
    //   257: aload 11
    //   259: ldc_w 403
    //   262: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload 4
    //   268: astore_1
    //   269: aload 4
    //   271: astore_2
    //   272: aload 11
    //   274: aload_3
    //   275: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload 4
    //   281: astore_1
    //   282: aload 4
    //   284: astore_2
    //   285: aload 7
    //   287: aload 8
    //   289: aconst_null
    //   290: aload 11
    //   292: invokevirtual 411	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: aconst_null
    //   296: aconst_null
    //   297: invokevirtual 369	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   300: astore 4
    //   302: aload 4
    //   304: ifnull +154 -> 458
    //   307: aload 4
    //   309: astore_1
    //   310: aload 4
    //   312: astore_2
    //   313: aload 4
    //   315: invokeinterface 375 1 0
    //   320: ifeq +138 -> 458
    //   323: aload 4
    //   325: astore_1
    //   326: aload 4
    //   328: astore_2
    //   329: aload 4
    //   331: aload 4
    //   333: ldc_w 413
    //   336: invokeinterface 381 2 0
    //   341: invokeinterface 384 2 0
    //   346: astore_3
    //   347: aload 4
    //   349: astore_1
    //   350: aload 4
    //   352: astore_2
    //   353: aload_3
    //   354: invokestatic 238	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   357: ifeq +6 -> 363
    //   360: goto +77 -> 437
    //   363: aload 4
    //   365: astore_1
    //   366: aload 4
    //   368: astore_2
    //   369: aload_0
    //   370: aload_3
    //   371: invokevirtual 416	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:trimPhoneNumPre	(Ljava/lang/String;)Ljava/lang/String;
    //   374: astore_3
    //   375: aload 4
    //   377: astore_1
    //   378: aload 4
    //   380: astore_2
    //   381: new 240	org/json/JSONObject
    //   384: dup
    //   385: invokespecial 348	org/json/JSONObject:<init>	()V
    //   388: astore 7
    //   390: aload 4
    //   392: astore_1
    //   393: aload 4
    //   395: astore_2
    //   396: aload 7
    //   398: ldc_w 418
    //   401: aload 6
    //   403: invokevirtual 422	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   406: pop
    //   407: aload 4
    //   409: astore_1
    //   410: aload 4
    //   412: astore_2
    //   413: aload 7
    //   415: ldc_w 424
    //   418: aload_3
    //   419: invokevirtual 422	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   422: pop
    //   423: aload 4
    //   425: astore_1
    //   426: aload 4
    //   428: astore_2
    //   429: aload 10
    //   431: aload 7
    //   433: invokevirtual 427	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   436: pop
    //   437: aload 4
    //   439: ifnull +19 -> 458
    //   442: aload 4
    //   444: astore_1
    //   445: aload 4
    //   447: astore_2
    //   448: aload 4
    //   450: invokeinterface 430 1 0
    //   455: ifne -132 -> 323
    //   458: aload 4
    //   460: astore_3
    //   461: aload 4
    //   463: ifnull +19 -> 482
    //   466: aload 4
    //   468: astore_1
    //   469: aload 4
    //   471: astore_2
    //   472: aload 4
    //   474: invokeinterface 433 1 0
    //   479: aload 4
    //   481: astore_3
    //   482: aload_3
    //   483: astore 4
    //   485: aload 5
    //   487: ifnull +26 -> 513
    //   490: aload_3
    //   491: astore 4
    //   493: aload_3
    //   494: astore_1
    //   495: aload_3
    //   496: astore_2
    //   497: aload 5
    //   499: invokeinterface 430 1 0
    //   504: ifne -403 -> 101
    //   507: aload_3
    //   508: astore 4
    //   510: goto +3 -> 513
    //   513: aload 4
    //   515: astore_1
    //   516: aload 4
    //   518: astore_2
    //   519: aload 9
    //   521: ldc_w 435
    //   524: aload 10
    //   526: invokevirtual 422	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   529: pop
    //   530: aload 4
    //   532: astore_1
    //   533: aload 4
    //   535: astore_2
    //   536: aload 9
    //   538: ldc_w 437
    //   541: iconst_0
    //   542: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   545: pop
    //   546: aload 5
    //   548: ifnull +18 -> 566
    //   551: aload 5
    //   553: invokeinterface 433 1 0
    //   558: goto +8 -> 566
    //   561: astore_1
    //   562: aload_1
    //   563: invokevirtual 441	java/lang/Exception:printStackTrace	()V
    //   566: aload 4
    //   568: ifnull +91 -> 659
    //   571: aload 4
    //   573: invokeinterface 433 1 0
    //   578: aload 9
    //   580: areturn
    //   581: astore_2
    //   582: aconst_null
    //   583: astore_3
    //   584: goto +85 -> 669
    //   587: astore_3
    //   588: aconst_null
    //   589: astore_1
    //   590: aload_3
    //   591: invokevirtual 441	java/lang/Exception:printStackTrace	()V
    //   594: aload 9
    //   596: ldc_w 435
    //   599: aload 10
    //   601: invokevirtual 422	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   604: pop
    //   605: aload 9
    //   607: ldc_w 437
    //   610: iconst_m1
    //   611: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   614: pop
    //   615: goto +8 -> 623
    //   618: astore_3
    //   619: aload_3
    //   620: invokevirtual 336	org/json/JSONException:printStackTrace	()V
    //   623: aload_2
    //   624: ifnull +17 -> 641
    //   627: aload_2
    //   628: invokeinterface 433 1 0
    //   633: goto +8 -> 641
    //   636: astore_2
    //   637: aload_2
    //   638: invokevirtual 441	java/lang/Exception:printStackTrace	()V
    //   641: aload_1
    //   642: ifnull +17 -> 659
    //   645: aload_1
    //   646: invokeinterface 433 1 0
    //   651: aload 9
    //   653: areturn
    //   654: astore_1
    //   655: aload_1
    //   656: invokevirtual 441	java/lang/Exception:printStackTrace	()V
    //   659: aload 9
    //   661: areturn
    //   662: astore 4
    //   664: aload_2
    //   665: astore_3
    //   666: aload 4
    //   668: astore_2
    //   669: aload_3
    //   670: ifnull +17 -> 687
    //   673: aload_3
    //   674: invokeinterface 433 1 0
    //   679: goto +8 -> 687
    //   682: astore_3
    //   683: aload_3
    //   684: invokevirtual 441	java/lang/Exception:printStackTrace	()V
    //   687: aload_1
    //   688: ifnull +17 -> 705
    //   691: aload_1
    //   692: invokeinterface 433 1 0
    //   697: goto +8 -> 705
    //   700: astore_1
    //   701: aload_1
    //   702: invokevirtual 441	java/lang/Exception:printStackTrace	()V
    //   705: goto +5 -> 710
    //   708: aload_2
    //   709: athrow
    //   710: goto -2 -> 708
    //   713: astore_2
    //   714: aload 5
    //   716: astore_3
    //   717: goto -48 -> 669
    //   720: astore_3
    //   721: aload_2
    //   722: astore_1
    //   723: aload 5
    //   725: astore_2
    //   726: goto -136 -> 590
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	729	0	this	QWalletCommonJsPlugin
    //   12	521	1	localObject1	Object
    //   561	2	1	localException1	Exception
    //   589	57	1	localObject2	Object
    //   654	38	1	localException2	Exception
    //   700	2	1	localException3	Exception
    //   722	1	1	localObject3	Object
    //   10	526	2	localObject4	Object
    //   581	47	2	localObject5	Object
    //   636	29	2	localException4	Exception
    //   668	41	2	localObject6	Object
    //   713	9	2	localObject7	Object
    //   725	1	2	localObject8	Object
    //   20	564	3	localObject9	Object
    //   587	4	3	localException5	Exception
    //   618	2	3	localJSONException	JSONException
    //   665	9	3	localException6	Exception
    //   682	2	3	localException7	Exception
    //   716	1	3	localObject10	Object
    //   720	1	3	localException8	Exception
    //   4	568	4	localObject11	Object
    //   662	5	4	localObject12	Object
    //   67	657	5	localCursor	android.database.Cursor
    //   17	385	6	str	String
    //   7	425	7	localObject13	Object
    //   14	274	8	localUri	Uri
    //   35	625	9	localJSONObject	JSONObject
    //   44	556	10	localJSONArray	org.json.JSONArray
    //   249	42	11	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   551	558	561	java/lang/Exception
    //   46	69	581	finally
    //   46	69	587	java/lang/Exception
    //   594	615	618	org/json/JSONException
    //   627	633	636	java/lang/Exception
    //   571	578	654	java/lang/Exception
    //   645	651	654	java/lang/Exception
    //   590	594	662	finally
    //   594	615	662	finally
    //   619	623	662	finally
    //   673	679	682	java/lang/Exception
    //   691	697	700	java/lang/Exception
    //   88	98	713	finally
    //   107	125	713	finally
    //   131	138	713	finally
    //   150	157	713	finally
    //   166	186	713	finally
    //   192	210	713	finally
    //   216	225	713	finally
    //   231	236	713	finally
    //   242	251	713	finally
    //   257	266	713	finally
    //   272	279	713	finally
    //   285	302	713	finally
    //   313	323	713	finally
    //   329	347	713	finally
    //   353	360	713	finally
    //   369	375	713	finally
    //   381	390	713	finally
    //   396	407	713	finally
    //   413	423	713	finally
    //   429	437	713	finally
    //   448	458	713	finally
    //   472	479	713	finally
    //   497	507	713	finally
    //   519	530	713	finally
    //   536	546	713	finally
    //   88	98	720	java/lang/Exception
    //   107	125	720	java/lang/Exception
    //   131	138	720	java/lang/Exception
    //   150	157	720	java/lang/Exception
    //   166	186	720	java/lang/Exception
    //   192	210	720	java/lang/Exception
    //   216	225	720	java/lang/Exception
    //   231	236	720	java/lang/Exception
    //   242	251	720	java/lang/Exception
    //   257	266	720	java/lang/Exception
    //   272	279	720	java/lang/Exception
    //   285	302	720	java/lang/Exception
    //   313	323	720	java/lang/Exception
    //   329	347	720	java/lang/Exception
    //   353	360	720	java/lang/Exception
    //   369	375	720	java/lang/Exception
    //   381	390	720	java/lang/Exception
    //   396	407	720	java/lang/Exception
    //   413	423	720	java/lang/Exception
    //   429	437	720	java/lang/Exception
    //   448	458	720	java/lang/Exception
    //   472	479	720	java/lang/Exception
    //   497	507	720	java/lang/Exception
    //   519	530	720	java/lang/Exception
    //   536	546	720	java/lang/Exception
  }
  
  private void getAppAuthCode(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.mLastAuthCodeReqTime;
    if ((l1 > l2) && (l1 - l2 < 200L)) {
      return;
    }
    this.mLastAuthCodeReqTime = l1;
    this.mReqAuthCodeStartTime = l1;
    try
    {
      paramString = new JSONObject(paramString).optString("appid");
      if (!TextUtils.isEmpty(paramString))
      {
        this.mAuthCodeAppId = Long.valueOf(paramString).longValue();
        StringBuilder localStringBuilder = null;
        paramString = localStringBuilder;
        if (this.mRuntime != null)
        {
          paramString = localStringBuilder;
          if (this.mRuntime.b() != null) {
            paramString = this.mRuntime.b().getCurrentAccountUin();
          }
        }
        if (TextUtils.isEmpty(paramString))
        {
          sendAuthCodeReq();
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.mRuntime.d().getFilesDir());
        localStringBuilder.append("/QWallet/cache_ac_");
        localStringBuilder.append(paramString);
        paramString = localStringBuilder.toString();
        if (!new File(paramString).exists())
        {
          sendAuthCodeReq();
          return;
        }
        if ((this.executorService == null) || (this.executorService.isShutdown())) {
          this.executorService = Executors.newFixedThreadPool(1);
        }
        this.executorService.execute(new QWalletCommonJsPlugin.2(this, paramString));
        return;
      }
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void getHbDetail(AppInterface paramAppInterface, String paramString, QWalletCommonJsPlugin.MyResultRecevicer paramMyResultRecevicer)
  {
    if (paramAppInterface == null) {
      return;
    }
    try
    {
      paramAppInterface = new Bundle();
      paramAppInterface.putString("extra_data", paramString.toString());
      paramAppInterface.putString("callbackSn", "0");
      paramString = new Bundle();
      paramString.putInt("PayInvokerId", 22);
      Parcel localParcel = Parcel.obtain();
      paramMyResultRecevicer.writeToParcel(localParcel, 0);
      localParcel.setDataPosition(0);
      paramMyResultRecevicer = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(localParcel);
      localParcel.recycle();
      paramString.putParcelable("_qwallet_payresult_receiver", paramMyResultRecevicer);
      paramString.putBundle("_qwallet_payparams_data", paramAppInterface);
      paramString.putString("_qwallet_payparams_tag", "redgiftDetail");
      QWalletPayBridge.launchBackground(BaseApplicationImpl.sApplication, paramString);
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
    //   0: new 240	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 348	org/json/JSONObject:<init>	()V
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 4
    //   12: aconst_null
    //   13: astore_3
    //   14: aconst_null
    //   15: astore 6
    //   17: getstatic 357	android/provider/ContactsContract$Contacts:CONTENT_URI	Landroid/net/Uri;
    //   20: astore_2
    //   21: aload_0
    //   22: getfield 206	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:mContext	Landroid/content/Context;
    //   25: invokevirtual 363	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   28: aload_2
    //   29: aconst_null
    //   30: ldc_w 574
    //   33: iconst_1
    //   34: anewarray 341	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: aload_1
    //   40: aastore
    //   41: aconst_null
    //   42: invokevirtual 369	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   45: astore_2
    //   46: aload_2
    //   47: invokeinterface 375 1 0
    //   52: ifeq +436 -> 488
    //   55: aload_0
    //   56: aload_2
    //   57: aload_2
    //   58: ldc_w 377
    //   61: invokeinterface 381 2 0
    //   66: invokeinterface 384 2 0
    //   71: invokevirtual 387	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:trimPhoneName	(Ljava/lang/String;)Ljava/lang/String;
    //   74: astore 8
    //   76: aload_2
    //   77: aload_2
    //   78: ldc_w 389
    //   81: invokeinterface 381 2 0
    //   86: invokeinterface 393 2 0
    //   91: ifle +388 -> 479
    //   94: aload_0
    //   95: getfield 206	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:mContext	Landroid/content/Context;
    //   98: invokevirtual 363	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   101: astore 4
    //   103: getstatic 398	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   106: astore 5
    //   108: new 400	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 401	java/lang/StringBuilder:<init>	()V
    //   115: astore 7
    //   117: aload 7
    //   119: ldc_w 403
    //   122: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload 7
    //   128: aload_1
    //   129: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 4
    //   135: aload 5
    //   137: aconst_null
    //   138: aload 7
    //   140: invokevirtual 411	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: aconst_null
    //   144: aconst_null
    //   145: invokevirtual 369	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   148: astore 4
    //   150: aload 8
    //   152: astore 7
    //   154: aload 4
    //   156: astore_1
    //   157: aload 4
    //   159: astore_3
    //   160: aload 4
    //   162: astore 5
    //   164: aload 4
    //   166: invokeinterface 375 1 0
    //   171: ifeq +43 -> 214
    //   174: aload 4
    //   176: astore_3
    //   177: aload 4
    //   179: astore 5
    //   181: aload_0
    //   182: aload 4
    //   184: aload 4
    //   186: ldc_w 413
    //   189: invokeinterface 381 2 0
    //   194: invokeinterface 384 2 0
    //   199: invokevirtual 416	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin:trimPhoneNumPre	(Ljava/lang/String;)Ljava/lang/String;
    //   202: astore 6
    //   204: aload 8
    //   206: astore 7
    //   208: aload 4
    //   210: astore_1
    //   211: goto +3 -> 214
    //   214: aload_1
    //   215: astore_3
    //   216: aload_1
    //   217: astore 5
    //   219: aload 6
    //   221: invokestatic 238	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   224: ifne +63 -> 287
    //   227: aload_1
    //   228: astore_3
    //   229: aload_1
    //   230: astore 5
    //   232: aload 7
    //   234: invokestatic 238	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   237: ifne +50 -> 287
    //   240: aload_1
    //   241: astore_3
    //   242: aload_1
    //   243: astore 5
    //   245: aload 9
    //   247: ldc_w 437
    //   250: iconst_0
    //   251: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   254: pop
    //   255: aload_1
    //   256: astore_3
    //   257: aload_1
    //   258: astore 5
    //   260: aload 9
    //   262: ldc_w 418
    //   265: aload 7
    //   267: invokevirtual 422	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   270: pop
    //   271: aload_1
    //   272: astore_3
    //   273: aload_1
    //   274: astore 5
    //   276: aload 9
    //   278: ldc_w 424
    //   281: aload 6
    //   283: invokevirtual 422	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   286: pop
    //   287: aload_2
    //   288: ifnull +17 -> 305
    //   291: aload_2
    //   292: invokeinterface 433 1 0
    //   297: goto +8 -> 305
    //   300: astore_2
    //   301: aload_2
    //   302: invokevirtual 441	java/lang/Exception:printStackTrace	()V
    //   305: aload_1
    //   306: ifnull +125 -> 431
    //   309: aload_1
    //   310: invokeinterface 433 1 0
    //   315: aload 9
    //   317: areturn
    //   318: astore_1
    //   319: goto +122 -> 441
    //   322: astore_3
    //   323: aload 5
    //   325: astore_1
    //   326: goto +10 -> 336
    //   329: astore_1
    //   330: goto +111 -> 441
    //   333: astore_3
    //   334: aconst_null
    //   335: astore_1
    //   336: goto +15 -> 351
    //   339: astore_1
    //   340: aconst_null
    //   341: astore_2
    //   342: goto +99 -> 441
    //   345: astore_3
    //   346: aconst_null
    //   347: astore_1
    //   348: aload 4
    //   350: astore_2
    //   351: aload_3
    //   352: invokevirtual 441	java/lang/Exception:printStackTrace	()V
    //   355: aload 9
    //   357: ldc_w 437
    //   360: iconst_m1
    //   361: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   364: pop
    //   365: aload 9
    //   367: ldc_w 418
    //   370: ldc 31
    //   372: invokevirtual 422	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   375: pop
    //   376: aload 9
    //   378: ldc_w 424
    //   381: ldc 31
    //   383: invokevirtual 422	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   386: pop
    //   387: goto +8 -> 395
    //   390: astore_3
    //   391: aload_3
    //   392: invokevirtual 336	org/json/JSONException:printStackTrace	()V
    //   395: aload_2
    //   396: ifnull +17 -> 413
    //   399: aload_2
    //   400: invokeinterface 433 1 0
    //   405: goto +8 -> 413
    //   408: astore_2
    //   409: aload_2
    //   410: invokevirtual 441	java/lang/Exception:printStackTrace	()V
    //   413: aload_1
    //   414: ifnull +17 -> 431
    //   417: aload_1
    //   418: invokeinterface 433 1 0
    //   423: aload 9
    //   425: areturn
    //   426: astore_1
    //   427: aload_1
    //   428: invokevirtual 441	java/lang/Exception:printStackTrace	()V
    //   431: aload 9
    //   433: areturn
    //   434: astore 4
    //   436: aload_1
    //   437: astore_3
    //   438: aload 4
    //   440: astore_1
    //   441: aload_2
    //   442: ifnull +17 -> 459
    //   445: aload_2
    //   446: invokeinterface 433 1 0
    //   451: goto +8 -> 459
    //   454: astore_2
    //   455: aload_2
    //   456: invokevirtual 441	java/lang/Exception:printStackTrace	()V
    //   459: aload_3
    //   460: ifnull +17 -> 477
    //   463: aload_3
    //   464: invokeinterface 433 1 0
    //   469: goto +8 -> 477
    //   472: astore_2
    //   473: aload_2
    //   474: invokevirtual 441	java/lang/Exception:printStackTrace	()V
    //   477: aload_1
    //   478: athrow
    //   479: aconst_null
    //   480: astore_1
    //   481: aload 8
    //   483: astore 7
    //   485: goto -271 -> 214
    //   488: aconst_null
    //   489: astore 7
    //   491: aload 7
    //   493: astore_1
    //   494: goto -280 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	497	0	this	QWalletCommonJsPlugin
    //   0	497	1	paramString	String
    //   20	272	2	localObject1	Object
    //   300	2	2	localException1	Exception
    //   341	59	2	localObject2	Object
    //   408	38	2	localException2	Exception
    //   454	2	2	localException3	Exception
    //   472	2	2	localException4	Exception
    //   13	260	3	localObject3	Object
    //   322	1	3	localException5	Exception
    //   333	1	3	localException6	Exception
    //   345	7	3	localException7	Exception
    //   390	2	3	localJSONException	JSONException
    //   437	27	3	str1	String
    //   10	339	4	localObject4	Object
    //   434	5	4	localObject5	Object
    //   106	218	5	localObject6	Object
    //   15	267	6	str2	String
    //   115	377	7	localObject7	Object
    //   74	408	8	str3	String
    //   7	425	9	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   291	297	300	java/lang/Exception
    //   164	174	318	finally
    //   181	204	318	finally
    //   219	227	318	finally
    //   232	240	318	finally
    //   245	255	318	finally
    //   260	271	318	finally
    //   276	287	318	finally
    //   164	174	322	java/lang/Exception
    //   181	204	322	java/lang/Exception
    //   219	227	322	java/lang/Exception
    //   232	240	322	java/lang/Exception
    //   245	255	322	java/lang/Exception
    //   260	271	322	java/lang/Exception
    //   276	287	322	java/lang/Exception
    //   46	150	329	finally
    //   46	150	333	java/lang/Exception
    //   17	46	339	finally
    //   17	46	345	java/lang/Exception
    //   355	387	390	org/json/JSONException
    //   399	405	408	java/lang/Exception
    //   309	315	426	java/lang/Exception
    //   417	423	426	java/lang/Exception
    //   351	355	434	finally
    //   355	387	434	finally
    //   391	395	434	finally
    //   445	451	454	java/lang/Exception
    //   463	469	472	java/lang/Exception
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
          } else {
            localJSONObject.put("result_code", 1);
          }
          doCallback(localJSONObject.toString());
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    try
    {
      paramString = new JSONObject();
      paramString.put("result_code", 1);
      doCallback(paramString.toString());
      return;
    }
    catch (Throwable paramString) {}
  }
  
  private boolean handleOpenContact()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      Object localObject = this.mRuntime.d();
      if ((localObject instanceof AppActivity))
      {
        localObject = (AppActivity)localObject;
        if (((AppActivity)localObject).checkSelfPermission("android.permission.READ_CONTACTS") != 0)
        {
          ((AppActivity)localObject).requestPermissions(this.mOpenContactCallBack, 1, new String[] { "android.permission.READ_CONTACTS" });
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
  
  private void handleQQShop(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("QWalletCommonJsPlugin", 1, "-->handleQQShop extstr is null");
      return;
    }
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("extstr:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("QWalletCommonJsPlugin", 1, ((StringBuilder)localObject).toString());
      }
      localObject = new JSONObject(paramString);
      String str = ((JSONObject)localObject).optString("action");
      boolean bool = "isTop".equals(str);
      if (bool)
      {
        paramString = QIPCClientHelper.getInstance().getClient().callServer("EcshopIPCModule", "queryPublicAccountTop", null);
        if (paramString != null)
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("retcode", 0);
          ((JSONObject)localObject).put("retmsg", "success");
          ((JSONObject)localObject).put("isTop", paramString.code);
          doCallback(((JSONObject)localObject).toString());
        }
      }
      else if ("setTop".equals(str))
      {
        int i = ((JSONObject)localObject).optInt("isTop", -1);
        localObject = new JSONObject();
        if ((i != 1) && (i != 0))
        {
          ((JSONObject)localObject).put("retcode", 1);
          ((JSONObject)localObject).put("retmsg", "isTop error");
          doCallback(((JSONObject)localObject).toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("notifyViewUpdate -->handleQQShop error,extstr:");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("QWalletCommonJsPlugin", 1, ((StringBuilder)localObject).toString());
          return;
        }
        paramString = new Bundle();
        paramString.putInt("isTop", i);
        if (QIPCClientHelper.getInstance().getClient().callServer("EcshopIPCModule", "setPublicAccountTop", paramString) != null)
        {
          ((JSONObject)localObject).put("retcode", 0);
          ((JSONObject)localObject).put("retmsg", "success");
          doCallback(((JSONObject)localObject).toString());
        }
      }
      else if ("openShopAccount".equals(str))
      {
        paramString = new Bundle();
        paramString.putInt("shouldOpenCard", ((JSONObject)localObject).optInt("shouldOpenCard"));
        localObject = ((JSONObject)localObject).optJSONObject("qggExt");
        if (localObject != null) {
          paramString.putString("qggExt", ((JSONObject)localObject).toString());
        }
        if (QIPCClientHelper.getInstance().getClient().callServer("EcshopIPCModule", "startQQShopPublicAccount", paramString) != null)
        {
          paramString = new JSONObject();
          paramString.put("retcode", 0);
          paramString.put("retmsg", "success");
          doCallback(paramString.toString());
          return;
        }
      }
    }
    catch (Throwable paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notifyViewUpdate -->handleQQShop error:");
      ((StringBuilder)localObject).append(paramString.getMessage());
      QLog.d("QWalletCommonJsPlugin", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private void handleRedPackSkin(String paramString, int paramInt)
  {
    if (paramInt == 1) {
      try
      {
        if (new JSONObject(paramString).optInt("action") == 1)
        {
          ((IRedPacketProxy)QRoute.api(IRedPacketProxy.class)).requestRedPacketSkinList();
          return;
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private void handleSkin(String paramString, int paramInt1, int paramInt2) {}
  
  private boolean isSecurityPayOpen()
  {
    Context localContext = this.mContext;
    if (localContext == null) {
      return false;
    }
    return JumpQqPimSecureUtil.f(localContext);
  }
  
  private void notifyViewUpdate(String paramString1, String paramString2)
  {
    int i;
    int j;
    label718:
    label733:
    do
    {
      do
      {
        try
        {
          paramString1 = new JSONObject(paramString1);
          i = paramString1.optInt("bid");
          j = paramString1.optInt("viewid");
          Object localObject1 = paramString1.optString("extstr");
          if (i != 2)
          {
            if (i != 4) {
              continue;
            }
            break label718;
            if (i == 5)
            {
              handleRedPackSkin((String)localObject1, j);
              return;
            }
            Object localObject2;
            Object localObject3;
            if (i == 10)
            {
              paramString2 = "";
              paramString1 = paramString2;
              try
              {
                if (!TextUtils.isEmpty((CharSequence)localObject1))
                {
                  localObject1 = new JSONObject((String)localObject1);
                  paramString1 = ((JSONObject)localObject1).optString("listid");
                  localObject1 = ((JSONObject)localObject1).optString("feedsid");
                  localObject2 = ((ITenCookie)QRoute.api(ITenCookie.class)).getTempArgs(paramString1);
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
                paramString1.printStackTrace();
                paramString1 = paramString2;
              }
              doCallback(paramString1);
              return;
            }
            if ((i == 17) && (j == 1)) {
              try
              {
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  break label733;
                }
                localObject3 = new JSONObject((String)localObject1);
                paramString1 = ((JSONObject)localObject3).optString("listid");
                paramString2 = ((JSONObject)localObject3).optString("uin");
                localObject2 = ((JSONObject)localObject3).optString("offset");
                localObject3 = ((JSONObject)localObject3).optString("limit");
                boolean bool = TextUtils.isEmpty(paramString2);
                if ((!bool) && (paramString2.equals(this.app.getCurrentAccountUin())) && (!TextUtils.isEmpty(paramString1)))
                {
                  mListid = paramString1;
                  mParamForGarpHb = ((ITenCookie)QRoute.api(ITenCookie.class)).getTempArgs(paramString1);
                  if (QLog.isColorLevel())
                  {
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append("paramForGarpHb paramForGarpHb:");
                    ((StringBuilder)localObject1).append(mParamForGarpHb);
                    QLog.d("QWalletCommonJsPlugin", 2, ((StringBuilder)localObject1).toString());
                  }
                  if (!TextUtils.isEmpty(mParamForGarpHb))
                  {
                    localObject1 = new JSONObject(mParamForGarpHb);
                    JSONObject localJSONObject = new JSONObject();
                    localJSONObject.put("listid", paramString1);
                    localJSONObject.put("uin", paramString2);
                    localJSONObject.put("offset", localObject2);
                    localJSONObject.put("limit", localObject3);
                    localJSONObject.put("authkey", ((JSONObject)localObject1).optString("authkey"));
                    localJSONObject.put("grouptype", ((JSONObject)localObject1).optString("grouptype"));
                    localJSONObject.put("groupid", ((JSONObject)localObject1).optString("groupid"));
                    localJSONObject.put("viewTag", "redgiftDetail");
                    getHbDetail(this.app, localJSONObject.toString(), this.mRecevicer);
                    return;
                  }
                  if (!QLog.isColorLevel()) {
                    break label733;
                  }
                  QLog.d("QWalletCommonJsPlugin", 2, "paramForGarpHb is null");
                  return;
                }
                if (!QLog.isColorLevel()) {
                  break label733;
                }
                paramString1 = new StringBuilder();
                paramString1.append("notifyViewUpdate extstr = ");
                paramString1.append((String)localObject1);
                QLog.d("QWalletCommonJsPlugin", 2, paramString1.toString());
                return;
              }
              catch (Throwable paramString1)
              {
                paramString1.printStackTrace();
                return;
              }
            }
            if ((i != 20) || (j != 1)) {
              break;
            }
            handleMiniApp((String)localObject1, i, j);
            return;
            if ((i == 25) && (j == 2))
            {
              handleQQShop((String)localObject1);
              return;
            }
            if ((i == 22) && (j == 1))
            {
              sendUIRefreshBroadcast(i, j, (String)localObject1);
              return;
            }
            if ((i != 25) || (j != 1)) {
              break label733;
            }
            sendUIRefreshBroadcast(i, j, (String)localObject1);
            return;
          }
          handleSkin((String)localObject1, i, j);
          return;
        }
        catch (Exception paramString1)
        {
          paramString1.printStackTrace();
        }
        return;
      } while ((i != 3) || (j != 1));
      return;
    } while ((i != 21) || (j != 1));
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
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.toLowerCase().indexOf("callback") < 0) {
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
    localBundle = DataFactory.a("qwallet_getAuthCode", this.mCallback, this.mOnRemoteResp.key, localBundle);
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(localBundle);
  }
  
  private void sendUIRefreshBroadcast(int paramInt1, int paramInt2, String paramString)
  {
    Intent localIntent = new Intent("action_notify_view_update");
    localIntent.putExtra("businessId", paramInt1);
    localIntent.putExtra("viewId", paramInt2);
    localIntent.putExtra("extstr", paramString);
    this.mContext.sendBroadcast(localIntent);
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
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 2L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("handleEvent, type=");
      localStringBuilder1.append(paramLong);
      QLog.i("QWalletCommonJsPlugin", 2, localStringBuilder1.toString());
    }
    if ((paramLong != 8589934610L) && (paramLong != 8589934601L))
    {
      if (paramLong != 8589934611L) {
        if (paramLong == 8589934597L)
        {
          this.mVideoJsPlugin.resumeOrPause(false, false);
        }
        else if (paramLong == 2L)
        {
          this.mVideoJsPlugin.resumeOrPause(true, false);
        }
        else
        {
          if (paramLong == 8589934619L)
          {
            paramString = new JSONObject();
            if (paramMap != null)
            {
              try
              {
                paramString.put("action", (Integer)paramMap.get("action"));
              }
              catch (JSONException paramMap) {}catch (ClassCastException localClassCastException)
              {
                break label178;
              }
              paramMap.printStackTrace();
              break label234;
              label178:
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder2 = new StringBuilder();
                localStringBuilder2.append("action, ");
                localStringBuilder2.append(paramMap.get("action"));
                QLog.d("QWalletCommonJsPlugin", 2, localStringBuilder2.toString());
              }
              localClassCastException.printStackTrace();
            }
            label234:
            dispatchJsEvent("walletFeedsEvent", paramString, null);
            return true;
          }
          if (paramLong == 8589934620L)
          {
            paramString = new JSONObject();
            if (paramMap != null)
            {
              try
              {
                paramString.put("action", (Integer)paramMap.get("action"));
                paramString.put("height", (Integer)paramMap.get("height"));
                paramString.put("sHeight", (Integer)paramMap.get("sHeight"));
              }
              catch (JSONException paramMap) {}catch (ClassCastException paramMap)
              {
                break label359;
              }
              paramMap.printStackTrace();
              break label364;
              label359:
              paramMap.printStackTrace();
            }
            label364:
            dispatchJsEvent("walletFeedsEvent", paramString, null);
            return true;
          }
        }
      }
    }
    else
    {
      QWalletCommonJsPlugin.QWVideoJsPlugin localQWVideoJsPlugin = this.mVideoJsPlugin;
      if (QWalletCommonJsPlugin.QWVideoJsPlugin.access$900(localQWVideoJsPlugin, QWalletCommonJsPlugin.QWVideoJsPlugin.access$800(localQWVideoJsPlugin)))
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("handleEvent_Back,stopVideo:");
          paramString.append(QWalletCommonJsPlugin.QWVideoJsPlugin.access$800(this.mVideoJsPlugin));
          QLog.i("QWalletCommonJsPlugin", 2, paramString.toString());
        }
        return true;
      }
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      if (this.mContext == null) {
        return false;
      }
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append(paramString2);
      paramJsBridgeListener.append("_");
      paramJsBridgeListener.append(paramString3);
      paramJsBridgeListener = paramJsBridgeListener.toString();
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
          paramJsBridgeListener = this.mRuntime.d();
          if ((paramJsBridgeListener instanceof AppActivity))
          {
            paramJsBridgeListener = (AppActivity)paramJsBridgeListener;
            if (paramJsBridgeListener.checkSelfPermission("android.permission.READ_CONTACTS") != 0)
            {
              paramJsBridgeListener.requestPermissions(this.mGetAllContactCallBack, 3, new String[] { "android.permission.READ_CONTACTS" });
              return true;
            }
            new QWalletCommonJsPlugin.GetAllContactTask(this).execute(new Void[0]);
            return true;
          }
          callJs(this.mCallback, new String[] { "false", "no record activity" });
          return true;
        }
        new QWalletCommonJsPlugin.GetAllContactTask(this).execute(new Void[0]);
        return true;
      }
      if ("qw_charge_gotoQWalletHome".equals(paramJsBridgeListener))
      {
        if ((this.mRuntime != null) && (this.mRuntime.d() != null)) {
          ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).gotoQWalletHome(this.mRuntime.d());
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
      if ("qw_charge_emojiPayResultOk".equals(paramJsBridgeListener))
      {
        if ((this.mRuntime != null) && (this.mRuntime.d() != null))
        {
          this.mRuntime.d().setResult(8213);
          this.mRuntime.d().finish();
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
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    Object localObject;
    if (paramByte == 16)
    {
      if ((paramInt == -1) && (paramIntent != null) && (paramIntent.getData() != null))
      {
        paramIntent = paramIntent.getData().getLastPathSegment();
        if ((paramIntent != null) && (paramIntent.length() > 0))
        {
          this.mContactId = paramIntent;
          if (Build.VERSION.SDK_INT >= 23)
          {
            localObject = this.mRuntime.d();
            if ((localObject instanceof AppActivity))
            {
              localObject = (AppActivity)localObject;
              if (((AppActivity)localObject).checkSelfPermission("android.permission.READ_CONTACTS") != 0)
              {
                ((AppActivity)localObject).requestPermissions(this.mGetSelectContactCallBack, 2, new String[] { "android.permission.READ_CONTACTS" });
                return;
              }
              new QWalletCommonJsPlugin.SelectContactTask(this).execute(new String[] { paramIntent });
              return;
            }
            callJs(this.mCallback, new String[] { "false", "no record activity" });
            return;
          }
          new QWalletCommonJsPlugin.SelectContactTask(this).execute(new String[] { paramIntent });
        }
      }
      return;
    }
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
    JSONObject localJSONObject1;
    if (paramByte == 17)
    {
      localObject = paramIntent;
      if (paramIntent == null) {
        localObject = new Intent();
      }
      localJSONObject1 = new JSONObject();
    }
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
        if (paramIntent == null) {
          paramIntent = "0";
        }
        localJSONObject2.put("card_status", paramIntent);
        if (str == null) {
          break label399;
        }
        paramIntent = str;
        localJSONObject2.put("available_amount", paramIntent);
        if (localObject == null) {
          break label406;
        }
        paramIntent = (Intent)localObject;
        localJSONObject2.put("overdue_amount", paramIntent);
        localJSONObject1.put("data", localJSONObject2);
        doCallback(localJSONObject1.toString());
        return;
      }
      catch (JSONException paramIntent)
      {
        paramIntent.printStackTrace();
        doCallback("{'retCode':-1,data:{}}");
      }
      return;
      label399:
      paramIntent = "0";
      continue;
      label406:
      paramIntent = "0";
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    if (this.mRuntime != null)
    {
      Activity localActivity = this.mRuntime.d();
      if (localActivity != null)
      {
        this.app = this.mRuntime.b();
        this.mContext = localActivity.getApplicationContext();
        this.mVideoJsPlugin = new QWalletCommonJsPlugin.QWVideoJsPlugin(this, this.mContext, this, this.mRuntime.b());
        IntentFilter localIntentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
        localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
        localIntentFilter.addAction("android.intent.action.USER_PRESENT");
        localActivity.registerReceiver(this.mScreenReceiver, localIntentFilter);
        this.mRecevicer = new QWalletCommonJsPlugin.MyResultRecevicer(this, new Handler());
      }
    }
  }
  
  protected void onDestroy()
  {
    if (this.mRuntime != null)
    {
      Activity localActivity = this.mRuntime.d();
      if (localActivity != null) {
        localActivity.unregisterReceiver(this.mScreenReceiver);
      }
    }
    super.onDestroy();
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    Object localObject1;
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onResponse i:");
      ((StringBuilder)localObject1).append(toString());
      QLog.i("QWalletCommonJsPlugin", 4, ((StringBuilder)localObject1).toString());
    }
    if (this.mRuntime != null)
    {
      if (paramBundle == null) {
        return;
      }
      if (paramBundle.getInt("respkey", -1) != this.mOnRemoteResp.key) {
        return;
      }
      String str = paramBundle.getString("callbackid");
      localObject1 = paramBundle.getString("cmd");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return;
      }
      if (((String)localObject1).compareTo("qwallet_getAuthCode") != 0) {
        return;
      }
      paramBundle = paramBundle.getBundle("response");
      if (paramBundle == null) {
        return;
      }
      int i = paramBundle.getInt("qwallet.type");
      boolean bool = paramBundle.getBoolean("qwallet.isSuccess");
      Object localObject2 = paramBundle.getSerializable("qwallet.data");
      if ((i == 4) && (this.mAuthCodeAppId != 0L))
      {
        localObject1 = null;
        paramBundle = (Bundle)localObject1;
        if (bool)
        {
          paramBundle = (Bundle)localObject1;
          if (localObject2 != null)
          {
            paramBundle = (Bundle)localObject1;
            if ((localObject2 instanceof AuthCodeRsp))
            {
              localObject2 = (AuthCodeRsp)localObject2;
              paramBundle = (Bundle)localObject1;
              if (((AuthCodeRsp)localObject2).items != null)
              {
                paramBundle = (Bundle)localObject1;
                if (((AuthCodeRsp)localObject2).items.size() > 0) {
                  paramBundle = (AuthCodeItem)((AuthCodeRsp)localObject2).items.get(0);
                }
              }
            }
          }
        }
        doAuthCodeCallback(str, paramBundle);
      }
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
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    localIntent.putExtra("extra_data", localJSONObject.toString());
    localIntent.putExtra("app_info", "appid#20000001|bargainor_id#1000026901|channel#wallet");
    localIntent.putExtra("isJumpToH5", false);
    if (this.mRuntime != null) {
      paramString1 = this.mRuntime.d();
    } else {
      paramString1 = null;
    }
    paramString2 = paramString1;
    if (paramString1 == null) {
      paramString2 = this.mContext;
    }
    RouteUtils.a(paramString2, localIntent, "/qwallet/transaction", REQUESTCODE_TRANSFER);
  }
  
  public String trimPhoneName(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.equals("")) {
        return "";
      }
      int j = 0;
      String str1 = "";
      int i = 0;
      while (j < paramString.length())
      {
        if (i >= 10)
        {
          paramString = new StringBuilder();
          paramString.append(str1);
          paramString.append("...");
          return paramString.toString();
        }
        int k = j + 1;
        String str2 = paramString.substring(j, k);
        if (str2.matches("[Α-￥]")) {
          i += 2;
        } else {
          i += 1;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str1);
        localStringBuilder.append(str2);
        str1 = localStringBuilder.toString();
        j = k;
      }
      return str1;
    }
    return "";
  }
  
  public String trimPhoneNumPre(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.equals("")) {
        return "";
      }
      String str = paramString;
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
      if (str.length() > 11) {
        paramString = str.subSequence(str.length() - 11, str.length()).toString();
      }
      return paramString;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin
 * JD-Core Version:    0.7.0.1
 */