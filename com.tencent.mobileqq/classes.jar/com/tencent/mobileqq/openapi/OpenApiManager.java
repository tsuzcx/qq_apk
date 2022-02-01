package com.tencent.mobileqq.openapi;

import acvy;
import acwh;
import adrm;
import adrt;
import afur;
import afyj;
import afyl;
import ahen;
import android.content.ContentProvider;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import anmw;
import anqd;
import ayug;
import ayuh;
import ayui;
import ayuj;
import ayuk;
import ayun;
import ayuo;
import ayup;
import ayur;
import ayus;
import ayut;
import bdnt;
import bdtd;
import bduk;
import bglf;
import bgmg;
import bgog;
import bgsp;
import bjft;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPayBridge;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import nmp;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenApiManager
{
  public static final int AUTO_CLEAR_BUFFER_SIZE = 200;
  private static final boolean DEBUG_MSG = true;
  public static final int NOTICE_BUFFER_SZIE = 50;
  private static final String TAG = "OpenApi.Manager";
  private static OpenApiManager sInstance;
  private String mLastGetPayCodePermission;
  private String mLastGetPayCodePkgName;
  private QQAppInterface mLoginSucApp;
  private anqd mMsgObserver = new ayug(this);
  private final Queue<ayus> mPayMsgRspQueue = new LinkedList();
  private View mPttHolderView;
  private afyl mPttTransferCallback;
  private ConcurrentHashMap<Long, String> mSendingMsgMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ayuk> mThirdAppMap = new ConcurrentHashMap();
  private int msgTypeFilterOfApps = 0;
  private int uinTypeFilterOfApps = 0;
  
  private void checkDownloadPtt(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    MessageForPtt localMessageForPtt;
    int i;
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForPtt)))
    {
      localMessageForPtt = (MessageForPtt)paramMessageRecord;
      i = ahen.a(paramQQAppInterface, localMessageForPtt);
      if (i != -1) {
        break label46;
      }
      adrm.a(paramQQAppInterface, paramMessageRecord.frienduin, localMessageForPtt, true, 3, 0, true);
    }
    label46:
    while ((!paramBoolean) || ((i != 2005) && (i != 2004))) {
      return;
    }
    adrm.a(paramQQAppInterface, paramMessageRecord.frienduin, localMessageForPtt, true, 2, 0, false);
  }
  
  private void checkDownloadPtt(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong)
  {
    checkDownloadPtt(paramQQAppInterface, paramQQAppInterface.a().b(paramString, paramInt, paramLong), false);
  }
  
  private boolean checkNeedPayAuth(ayus paramayus)
  {
    if ((paramayus == null) || (paramayus.jdField_a_of_type_Int != 3)) {}
    for (;;)
    {
      return false;
      try
      {
        int i = new JSONObject(paramayus.jdField_a_of_type_JavaLangString).optInt("retcode");
        if (i != 10001) {
          continue;
        }
        try
        {
          paramayus = this.mLoginSucApp;
          Object localObject = new JSONObject();
          ((JSONObject)localObject).put("userId", paramayus.getCurrentAccountUin());
          ((JSONObject)localObject).put("viewTag", "showWearPayAuthor");
          ((JSONObject)localObject).put("app_info", "appInfo");
          ((JSONObject)localObject).put("come_from", 2);
          ((JSONObject)localObject).put("extra_data", "{}");
          Bundle localBundle = new Bundle();
          localBundle.putString("json", ((JSONObject)localObject).toString());
          localBundle.putString("callbackSn", "0");
          localObject = new Intent(paramayus.getApplication(), PayBridgeActivity.class);
          ((Intent)localObject).putExtras(localBundle);
          ((Intent)localObject).addFlags(268435456);
          ((Intent)localObject).putExtra("pay_requestcode", 5);
          paramayus.getApplication().startActivity((Intent)localObject);
          return true;
        }
        catch (Exception paramayus)
        {
          for (;;)
          {
            if (QLog.isDevelopLevel()) {
              paramayus.printStackTrace();
            }
          }
        }
        return false;
      }
      catch (JSONException paramayus) {}
    }
  }
  
  @Deprecated
  private void cleanupPttCallback()
  {
    this.mPttHolderView = null;
    this.mPttTransferCallback = null;
  }
  
  private ayup copyMsgFromMessageRecord(MessageRecord paramMessageRecord, String paramString, int paramInt)
  {
    return null;
  }
  
  public static OpenApiManager getInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new OpenApiManager();
      }
      OpenApiManager localOpenApiManager = sInstance;
      return localOpenApiManager;
    }
    finally {}
  }
  
  private void onRuntimeDisactive(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().post(new OpenApiManager.2(this, paramQQAppInterface, paramBoolean));
  }
  
  private void resetFilters()
  {
    Iterator localIterator = this.mThirdAppMap.values().iterator();
    int i = 0;
    int j = 0;
    while (localIterator.hasNext())
    {
      ayuk localayuk = (ayuk)localIterator.next();
      j |= localayuk.a();
      i = localayuk.b() | i;
    }
    this.msgTypeFilterOfApps = j;
    this.uinTypeFilterOfApps = i;
    if (QLog.isColorLevel()) {
      QLog.d("OpenApi.Manager", 2, "resetFilters | " + this.msgTypeFilterOfApps + " | " + this.uinTypeFilterOfApps);
    }
  }
  
  @Deprecated
  private void setupPttTransferCallback()
  {
    if (this.mPttHolderView != null) {
      return;
    }
    this.mPttHolderView = new View(BaseApplicationImpl.sApplication);
    this.mPttTransferCallback = new ayuh(this);
    afyj.a(this.mLoginSucApp).a(this.mPttHolderView, this.mPttTransferCallback);
  }
  
  /* Error */
  public Pair<Integer, Integer> decodePtt(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 70	com/tencent/mobileqq/openapi/OpenApiManager:mLoginSucApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: astore 17
    //   6: aload 17
    //   8: ifnonnull +21 -> 29
    //   11: new 333	android/util/Pair
    //   14: dup
    //   15: iconst_m1
    //   16: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   19: iconst_0
    //   20: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   23: invokespecial 342	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   26: astore_1
    //   27: aload_1
    //   28: areturn
    //   29: aload_0
    //   30: getfield 47	com/tencent/mobileqq/openapi/OpenApiManager:mThirdAppMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   33: aload_1
    //   34: invokevirtual 346	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   37: checkcast 277	ayuk
    //   40: astore_1
    //   41: aload_1
    //   42: ifnonnull +20 -> 62
    //   45: new 333	android/util/Pair
    //   48: dup
    //   49: bipush 254
    //   51: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   54: iconst_0
    //   55: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   58: invokespecial 342	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   61: areturn
    //   62: aload_1
    //   63: getfield 348	ayuk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   66: aload_2
    //   67: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   70: ifne +20 -> 90
    //   73: new 333	android/util/Pair
    //   76: dup
    //   77: bipush 249
    //   79: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   82: iconst_0
    //   83: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   86: invokespecial 342	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   89: areturn
    //   90: aload_1
    //   91: sipush 256
    //   94: invokevirtual 357	ayuk:a	(I)Z
    //   97: ifne +20 -> 117
    //   100: new 333	android/util/Pair
    //   103: dup
    //   104: bipush 252
    //   106: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   109: iconst_0
    //   110: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   113: invokespecial 342	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   116: areturn
    //   117: aload_1
    //   118: aload_3
    //   119: invokevirtual 360	ayuk:b	(Ljava/lang/String;)Ljava/lang/String;
    //   122: astore_2
    //   123: aload_1
    //   124: aload 5
    //   126: invokevirtual 360	ayuk:b	(Ljava/lang/String;)Ljava/lang/String;
    //   129: astore_3
    //   130: lconst_0
    //   131: lstore 13
    //   133: aload_3
    //   134: invokestatic 366	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   137: lstore 11
    //   139: aload_2
    //   140: invokestatic 372	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   143: ifne +17 -> 160
    //   146: aload_3
    //   147: invokestatic 372	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   150: ifne +10 -> 160
    //   153: lload 11
    //   155: lconst_0
    //   156: lcmp
    //   157: ifne +48 -> 205
    //   160: new 333	android/util/Pair
    //   163: dup
    //   164: bipush 250
    //   166: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   169: iconst_0
    //   170: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   173: invokespecial 342	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   176: areturn
    //   177: astore_1
    //   178: lload 13
    //   180: lstore 11
    //   182: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   185: ifeq -46 -> 139
    //   188: ldc 16
    //   190: iconst_2
    //   191: ldc_w 374
    //   194: aload_1
    //   195: invokestatic 377	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   198: lload 13
    //   200: lstore 11
    //   202: goto -63 -> 139
    //   205: iload 4
    //   207: iconst_1
    //   208: if_icmpne +598 -> 806
    //   211: aload 6
    //   213: getstatic 382	anhk:aZ	Ljava/lang/String;
    //   216: invokevirtual 386	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   219: ifne +31 -> 250
    //   222: aload 7
    //   224: getstatic 382	anhk:aZ	Ljava/lang/String;
    //   227: invokevirtual 386	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   230: ifne +20 -> 250
    //   233: new 333	android/util/Pair
    //   236: dup
    //   237: bipush 240
    //   239: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   242: iconst_0
    //   243: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   246: invokespecial 342	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   249: areturn
    //   250: aload 6
    //   252: invokestatic 390	bgmg:a	(Ljava/lang/String;)Z
    //   255: ifne +20 -> 275
    //   258: new 333	android/util/Pair
    //   261: dup
    //   262: bipush 246
    //   264: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   267: iconst_0
    //   268: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   271: invokespecial 342	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   274: areturn
    //   275: aconst_null
    //   276: astore 16
    //   278: aconst_null
    //   279: astore_2
    //   280: iconst_0
    //   281: istore 9
    //   283: aconst_null
    //   284: astore 15
    //   286: aconst_null
    //   287: astore 5
    //   289: new 392	java/io/FileInputStream
    //   292: dup
    //   293: aload 6
    //   295: invokespecial 393	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   298: astore_1
    //   299: aload_1
    //   300: invokestatic 398	bgrn:a	(Ljava/io/InputStream;)B
    //   303: istore 8
    //   305: iload 8
    //   307: ifge +57 -> 364
    //   310: new 333	android/util/Pair
    //   313: dup
    //   314: bipush 251
    //   316: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   319: iconst_0
    //   320: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   323: invokespecial 342	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   326: astore_3
    //   327: aload_1
    //   328: ifnull +7 -> 335
    //   331: aload_1
    //   332: invokevirtual 401	java/io/FileInputStream:close	()V
    //   335: iconst_0
    //   336: ifeq +11 -> 347
    //   339: new 403	java/lang/NullPointerException
    //   342: dup
    //   343: invokespecial 404	java/lang/NullPointerException:<init>	()V
    //   346: athrow
    //   347: aload_3
    //   348: astore_1
    //   349: iconst_0
    //   350: ifeq -323 -> 27
    //   353: new 403	java/lang/NullPointerException
    //   356: dup
    //   357: invokespecial 404	java/lang/NullPointerException:<init>	()V
    //   360: athrow
    //   361: astore_1
    //   362: aload_3
    //   363: areturn
    //   364: aload 7
    //   366: invokestatic 407	bgmg:a	(Ljava/lang/String;)Ljava/io/File;
    //   369: pop
    //   370: new 409	java/io/FileOutputStream
    //   373: dup
    //   374: aload 7
    //   376: invokespecial 410	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   379: astore_3
    //   380: iload 8
    //   382: invokestatic 413	bgrn:a	(B)I
    //   385: istore 4
    //   387: iload 4
    //   389: invokestatic 416	bgrn:a	(I)I
    //   392: istore 9
    //   394: iload 9
    //   396: newarray byte
    //   398: astore 7
    //   400: iload 9
    //   402: newarray byte
    //   404: astore 6
    //   406: new 418	com/tencent/mobileqq/utils/SilkCodecWrapper
    //   409: dup
    //   410: aload 17
    //   412: invokevirtual 422	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   415: iconst_0
    //   416: invokespecial 425	com/tencent/mobileqq/utils/SilkCodecWrapper:<init>	(Landroid/content/Context;Z)V
    //   419: astore_2
    //   420: aload_2
    //   421: iload 4
    //   423: iconst_0
    //   424: iconst_1
    //   425: invokevirtual 428	com/tencent/mobileqq/utils/SilkCodecWrapper:a	(III)V
    //   428: iconst_2
    //   429: newarray byte
    //   431: astore 5
    //   433: aload_1
    //   434: aload 5
    //   436: invokevirtual 432	java/io/FileInputStream:read	([B)I
    //   439: istore 10
    //   441: iload 10
    //   443: iconst_m1
    //   444: if_icmpne +44 -> 488
    //   447: aload_1
    //   448: ifnull +7 -> 455
    //   451: aload_1
    //   452: invokevirtual 401	java/io/FileInputStream:close	()V
    //   455: aload_3
    //   456: ifnull +7 -> 463
    //   459: aload_3
    //   460: invokevirtual 433	java/io/FileOutputStream:close	()V
    //   463: aload_2
    //   464: ifnull +7 -> 471
    //   467: aload_2
    //   468: invokevirtual 435	com/tencent/mobileqq/utils/SilkCodecWrapper:b	()V
    //   471: new 333	android/util/Pair
    //   474: dup
    //   475: iconst_0
    //   476: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   479: iload 4
    //   481: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   484: invokespecial 342	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   487: areturn
    //   488: aload 5
    //   490: invokestatic 437	bgrn:a	([B)I
    //   493: istore 10
    //   495: iload 10
    //   497: ifgt +55 -> 552
    //   500: new 333	android/util/Pair
    //   503: dup
    //   504: bipush 241
    //   506: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   509: iconst_0
    //   510: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   513: invokespecial 342	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   516: astore 5
    //   518: aload_1
    //   519: ifnull +7 -> 526
    //   522: aload_1
    //   523: invokevirtual 401	java/io/FileInputStream:close	()V
    //   526: aload_3
    //   527: ifnull +7 -> 534
    //   530: aload_3
    //   531: invokevirtual 433	java/io/FileOutputStream:close	()V
    //   534: aload 5
    //   536: astore_1
    //   537: aload_2
    //   538: ifnull -511 -> 27
    //   541: aload_2
    //   542: invokevirtual 435	com/tencent/mobileqq/utils/SilkCodecWrapper:b	()V
    //   545: aload 5
    //   547: areturn
    //   548: astore_1
    //   549: aload 5
    //   551: areturn
    //   552: aload_1
    //   553: aload 7
    //   555: iconst_0
    //   556: iload 10
    //   558: invokevirtual 440	java/io/FileInputStream:read	([BII)I
    //   561: ifne +55 -> 616
    //   564: new 333	android/util/Pair
    //   567: dup
    //   568: bipush 241
    //   570: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   573: iconst_0
    //   574: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   577: invokespecial 342	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   580: astore 5
    //   582: aload_1
    //   583: ifnull +7 -> 590
    //   586: aload_1
    //   587: invokevirtual 401	java/io/FileInputStream:close	()V
    //   590: aload_3
    //   591: ifnull +7 -> 598
    //   594: aload_3
    //   595: invokevirtual 433	java/io/FileOutputStream:close	()V
    //   598: aload 5
    //   600: astore_1
    //   601: aload_2
    //   602: ifnull -575 -> 27
    //   605: aload_2
    //   606: invokevirtual 435	com/tencent/mobileqq/utils/SilkCodecWrapper:b	()V
    //   609: aload 5
    //   611: areturn
    //   612: astore_1
    //   613: aload 5
    //   615: areturn
    //   616: aload_2
    //   617: aload 7
    //   619: aload 6
    //   621: iload 10
    //   623: iload 9
    //   625: invokevirtual 443	com/tencent/mobileqq/utils/SilkCodecWrapper:a	([B[BII)I
    //   628: ifne +55 -> 683
    //   631: new 333	android/util/Pair
    //   634: dup
    //   635: bipush 239
    //   637: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   640: iconst_0
    //   641: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   644: invokespecial 342	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   647: astore 5
    //   649: aload_1
    //   650: ifnull +7 -> 657
    //   653: aload_1
    //   654: invokevirtual 401	java/io/FileInputStream:close	()V
    //   657: aload_3
    //   658: ifnull +7 -> 665
    //   661: aload_3
    //   662: invokevirtual 433	java/io/FileOutputStream:close	()V
    //   665: aload 5
    //   667: astore_1
    //   668: aload_2
    //   669: ifnull -642 -> 27
    //   672: aload_2
    //   673: invokevirtual 435	com/tencent/mobileqq/utils/SilkCodecWrapper:b	()V
    //   676: aload 5
    //   678: areturn
    //   679: astore_1
    //   680: aload 5
    //   682: areturn
    //   683: aload_3
    //   684: aload 6
    //   686: invokevirtual 447	java/io/FileOutputStream:write	([B)V
    //   689: goto -256 -> 433
    //   692: astore 6
    //   694: aload_2
    //   695: astore 5
    //   697: aload_3
    //   698: astore_2
    //   699: aload 6
    //   701: astore_3
    //   702: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   705: ifeq +13 -> 718
    //   708: ldc 16
    //   710: iconst_2
    //   711: ldc_w 449
    //   714: aload_3
    //   715: invokestatic 377	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   718: new 333	android/util/Pair
    //   721: dup
    //   722: bipush 244
    //   724: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   727: iload 4
    //   729: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   732: invokespecial 342	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   735: astore_3
    //   736: aload_1
    //   737: ifnull +7 -> 744
    //   740: aload_1
    //   741: invokevirtual 401	java/io/FileInputStream:close	()V
    //   744: aload_2
    //   745: ifnull +7 -> 752
    //   748: aload_2
    //   749: invokevirtual 433	java/io/FileOutputStream:close	()V
    //   752: aload_3
    //   753: astore_1
    //   754: aload 5
    //   756: ifnull -729 -> 27
    //   759: aload 5
    //   761: invokevirtual 435	com/tencent/mobileqq/utils/SilkCodecWrapper:b	()V
    //   764: aload_3
    //   765: areturn
    //   766: astore_1
    //   767: aload_3
    //   768: areturn
    //   769: astore_2
    //   770: aconst_null
    //   771: astore_1
    //   772: aconst_null
    //   773: astore_3
    //   774: aload 15
    //   776: astore 5
    //   778: aload_1
    //   779: ifnull +7 -> 786
    //   782: aload_1
    //   783: invokevirtual 401	java/io/FileInputStream:close	()V
    //   786: aload_3
    //   787: ifnull +7 -> 794
    //   790: aload_3
    //   791: invokevirtual 433	java/io/FileOutputStream:close	()V
    //   794: aload 5
    //   796: ifnull +8 -> 804
    //   799: aload 5
    //   801: invokevirtual 435	com/tencent/mobileqq/utils/SilkCodecWrapper:b	()V
    //   804: aload_2
    //   805: athrow
    //   806: new 333	android/util/Pair
    //   809: dup
    //   810: bipush 251
    //   812: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   815: iconst_0
    //   816: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   819: invokespecial 342	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   822: areturn
    //   823: astore_1
    //   824: goto -489 -> 335
    //   827: astore_1
    //   828: goto -481 -> 347
    //   831: astore_1
    //   832: goto -306 -> 526
    //   835: astore_1
    //   836: goto -302 -> 534
    //   839: astore_1
    //   840: goto -250 -> 590
    //   843: astore_1
    //   844: goto -246 -> 598
    //   847: astore_1
    //   848: goto -191 -> 657
    //   851: astore_1
    //   852: goto -187 -> 665
    //   855: astore_1
    //   856: goto -401 -> 455
    //   859: astore_1
    //   860: goto -397 -> 463
    //   863: astore_1
    //   864: goto -393 -> 471
    //   867: astore_1
    //   868: goto -124 -> 744
    //   871: astore_1
    //   872: goto -120 -> 752
    //   875: astore_1
    //   876: goto -90 -> 786
    //   879: astore_1
    //   880: goto -86 -> 794
    //   883: astore_1
    //   884: goto -80 -> 804
    //   887: astore_2
    //   888: aconst_null
    //   889: astore_3
    //   890: aload 15
    //   892: astore 5
    //   894: goto -116 -> 778
    //   897: astore_2
    //   898: aload 15
    //   900: astore 5
    //   902: goto -124 -> 778
    //   905: astore 6
    //   907: aload_2
    //   908: astore 5
    //   910: aload 6
    //   912: astore_2
    //   913: goto -135 -> 778
    //   916: astore 6
    //   918: aload_2
    //   919: astore_3
    //   920: aload 6
    //   922: astore_2
    //   923: goto -145 -> 778
    //   926: astore_3
    //   927: iload 9
    //   929: istore 4
    //   931: aload 16
    //   933: astore_1
    //   934: goto -232 -> 702
    //   937: astore_3
    //   938: iload 9
    //   940: istore 4
    //   942: goto -240 -> 702
    //   945: astore 6
    //   947: aload_3
    //   948: astore_2
    //   949: aload 6
    //   951: astore_3
    //   952: iload 9
    //   954: istore 4
    //   956: goto -254 -> 702
    //   959: astore 6
    //   961: aload_3
    //   962: astore_2
    //   963: aload 6
    //   965: astore_3
    //   966: goto -264 -> 702
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	969	0	this	OpenApiManager
    //   0	969	1	paramString1	String
    //   0	969	2	paramString2	String
    //   0	969	3	paramString3	String
    //   0	969	4	paramInt	int
    //   0	969	5	paramString4	String
    //   0	969	6	paramString5	String
    //   0	969	7	paramString6	String
    //   303	78	8	b	byte
    //   281	672	9	i	int
    //   439	183	10	j	int
    //   137	64	11	l1	long
    //   131	68	13	l2	long
    //   284	615	15	localObject1	Object
    //   276	656	16	localObject2	Object
    //   4	407	17	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   133	139	177	java/lang/Exception
    //   353	361	361	java/lang/Throwable
    //   541	545	548	java/lang/Throwable
    //   605	609	612	java/lang/Throwable
    //   672	676	679	java/lang/Throwable
    //   420	433	692	java/lang/Throwable
    //   433	441	692	java/lang/Throwable
    //   488	495	692	java/lang/Throwable
    //   500	518	692	java/lang/Throwable
    //   552	582	692	java/lang/Throwable
    //   616	649	692	java/lang/Throwable
    //   683	689	692	java/lang/Throwable
    //   759	764	766	java/lang/Throwable
    //   289	299	769	finally
    //   331	335	823	java/lang/Exception
    //   339	347	827	java/lang/Exception
    //   522	526	831	java/lang/Exception
    //   530	534	835	java/lang/Exception
    //   586	590	839	java/lang/Exception
    //   594	598	843	java/lang/Exception
    //   653	657	847	java/lang/Exception
    //   661	665	851	java/lang/Exception
    //   451	455	855	java/lang/Exception
    //   459	463	859	java/lang/Exception
    //   467	471	863	java/lang/Throwable
    //   740	744	867	java/lang/Exception
    //   748	752	871	java/lang/Exception
    //   782	786	875	java/lang/Exception
    //   790	794	879	java/lang/Exception
    //   799	804	883	java/lang/Throwable
    //   299	305	887	finally
    //   310	327	887	finally
    //   364	380	887	finally
    //   380	387	897	finally
    //   387	420	897	finally
    //   420	433	905	finally
    //   433	441	905	finally
    //   488	495	905	finally
    //   500	518	905	finally
    //   552	582	905	finally
    //   616	649	905	finally
    //   683	689	905	finally
    //   702	718	916	finally
    //   718	736	916	finally
    //   289	299	926	java/lang/Throwable
    //   299	305	937	java/lang/Throwable
    //   310	327	937	java/lang/Throwable
    //   364	380	937	java/lang/Throwable
    //   380	387	945	java/lang/Throwable
    //   387	420	959	java/lang/Throwable
  }
  
  public Pair<Integer, Integer> downloadMedia(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    QQAppInterface localQQAppInterface = this.mLoginSucApp;
    if (localQQAppInterface == null) {
      return new Pair(Integer.valueOf(-1), Integer.valueOf(0));
    }
    paramString1 = (ayuk)this.mThirdAppMap.get(paramString1);
    if (paramString1 == null) {
      return new Pair(Integer.valueOf(-2), Integer.valueOf(0));
    }
    if (!paramString1.jdField_b_of_type_JavaLangString.equals(paramString2)) {
      return new Pair(Integer.valueOf(-7), Integer.valueOf(0));
    }
    if (!paramString1.a(512)) {
      return new Pair(Integer.valueOf(-4), Integer.valueOf(0));
    }
    paramString2 = paramString1.b(paramString3);
    paramString1 = paramString1.b(paramString4);
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {
      return new Pair(Integer.valueOf(-6), Integer.valueOf(0));
    }
    long l;
    try
    {
      l = Long.parseLong(paramString1);
      if (paramInt == 1)
      {
        paramString1 = ((anmw)localQQAppInterface.getManager(51)).e(paramString2);
        if ((paramString1 == null) || (!paramString1.isFriend())) {
          return new Pair(Integer.valueOf(-11), Integer.valueOf(0));
        }
      }
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OpenApi.Manager", 2, "downMedia", paramString1);
      }
      return new Pair(Integer.valueOf(-6), Integer.valueOf(0));
    }
    if ((paramInt == 2) || (paramInt == 1) || (paramInt == 4))
    {
      paramString1 = localQQAppInterface.a().b(paramString2, ayut.c(paramInt), l);
      if ((paramString1 == null) || (paramString1.isSendFromLocal())) {
        return new Pair(Integer.valueOf(-14), Integer.valueOf(0));
      }
      checkDownloadPtt(localQQAppInterface, paramString1, true);
      return new Pair(Integer.valueOf(0), Integer.valueOf(ayut.a(localQQAppInterface, (MessageForPtt)paramString1)));
    }
    return new Pair(Integer.valueOf(-5), Integer.valueOf(0));
  }
  
  public ayus[] exchangeUins(String paramString1, String paramString2, long paramLong1, long paramLong2, String[] paramArrayOfString)
  {
    paramString2 = new ayus[1];
    paramString2[0] = new ayus(0, null);
    paramString1 = ayui.a(BaseApplicationImpl.sApplication, paramString1);
    if (paramString1.d != paramLong2)
    {
      paramString2[0].jdField_b_of_type_Int = -20;
      return paramString2;
    }
    if (paramString1.jdField_b_of_type_Long != paramLong1)
    {
      paramString2[0].jdField_b_of_type_Int = -19;
      return paramString2;
    }
    paramString1 = new ayuk(paramString1);
    if (!paramString1.a(4))
    {
      paramString2[0].jdField_b_of_type_Int = -4;
      return paramString2;
    }
    paramString2 = new ayus[paramArrayOfString.length];
    int i = 0;
    for (;;)
    {
      if (i < paramArrayOfString.length)
      {
        paramString2[i] = new ayus(0, null);
        try
        {
          paramString2[i].jdField_a_of_type_JavaLangString = paramString1.a(paramString1.c(paramArrayOfString[i]));
          Object localObject = paramString2[i];
          if (TextUtils.isEmpty(paramString2[i].jdField_a_of_type_JavaLangString))
          {
            j = -6;
            localObject.jdField_b_of_type_Int = j;
            i += 1;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int j;
            if (QLog.isColorLevel())
            {
              QLog.d("OpenApi.Manager", 2, "", localException);
              continue;
              j = 0;
            }
          }
        }
      }
    }
    return paramString2;
  }
  
  public ayus getAvatarPath(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    QQAppInterface localQQAppInterface = this.mLoginSucApp;
    if (localQQAppInterface == null) {
      return new ayus(-1, null);
    }
    paramString1 = (ayuk)this.mThirdAppMap.get(paramString1);
    if (paramString1 == null) {
      return new ayus(-2, null);
    }
    if (!paramString1.jdField_b_of_type_JavaLangString.equals(paramString2)) {
      return new ayus(-7, null);
    }
    if (!paramString1.a(4)) {
      return new ayus(-4, null);
    }
    paramString1 = paramString1.b(paramString3);
    if (TextUtils.isEmpty(paramString1)) {
      return new ayus(-6, null);
    }
    int i = 1;
    if (paramInt == 2) {
      i = 101;
    }
    for (;;)
    {
      return new ayus(0, localQQAppInterface.a(i, paramString1, 0));
      if (paramInt == 4) {
        i = 4;
      }
    }
  }
  
  public int getLastMessages(List<ayup> paramList, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    QQAppInterface localQQAppInterface = this.mLoginSucApp;
    if (localQQAppInterface == null) {
      return -1;
    }
    if (!ayuo.a(paramInt1)) {
      return -5;
    }
    ayuk localayuk = (ayuk)this.mThirdAppMap.get(paramString1);
    if (localayuk == null) {
      return -2;
    }
    if (!localayuk.jdField_b_of_type_JavaLangString.equals(paramString2)) {
      return -7;
    }
    paramString1 = localayuk.b(paramString3);
    if (TextUtils.isEmpty(paramString1)) {
      return -6;
    }
    if (!localayuk.a(2)) {
      return -4;
    }
    List localList = localQQAppInterface.a().a(paramString1, ayut.c(paramInt1), paramInt2);
    acwh.a(paramString1, ayut.c(paramInt1), localList, localQQAppInterface);
    paramInt2 = 0;
    if (paramInt2 < localList.size())
    {
      MessageRecord localMessageRecord = (MessageRecord)localList.get(paramInt2);
      if ((paramBoolean1) && (localMessageRecord.isSend())) {}
      while ((paramBoolean2) && (localMessageRecord.isread))
      {
        paramInt2 += 1;
        break;
      }
      if ((localMessageRecord instanceof ChatMessage)) {
        ((ChatMessage)localMessageRecord).parse();
      }
      int i = ayut.a(localMessageRecord.msgtype);
      String str2 = localayuk.a(String.valueOf(localMessageRecord.uniseq));
      paramString1 = null;
      paramString2 = null;
      int j = 1007;
      if ((i == 1) && (localayuk.a(paramInt1, 1)))
      {
        paramString1 = new bdnt(localMessageRecord.msg, 3).a();
        label269:
        if (paramInt1 != 1) {
          break label545;
        }
      }
      label545:
      for (String str1 = "";; str1 = localayuk.a(localMessageRecord.senderuin))
      {
        paramList.add(new ayup(paramString3, paramInt1, str1, i, str2, localMessageRecord.time, localMessageRecord.isSend(), paramString1, paramString2, j));
        break;
        if ((i == 2) && ((localMessageRecord instanceof MessageForPtt)) && (localayuk.a(paramInt1, 2)))
        {
          checkDownloadPtt(localQQAppInterface, localMessageRecord, false);
          paramString2 = ((MessageForPtt)localMessageRecord).getLocalFilePath();
          j = ayut.a(localQQAppInterface, (MessageForPtt)localMessageRecord);
          break label269;
        }
        if ((i == 4) && (localayuk.a(paramInt1, 4)))
        {
          paramString1 = new bdnt(localMessageRecord.msg, 3).a();
          break label269;
        }
        if ((i == 8) && (localayuk.a(paramInt1, 8)))
        {
          paramString1 = ayup.jdField_b_of_type_JavaLangString;
          break label269;
        }
        if ((i == 16) && (localayuk.a(paramInt1, 16)))
        {
          paramString1 = ayup.c;
          break label269;
        }
        if ((i == 32) && (localayuk.a(paramInt1, 32)))
        {
          paramString1 = ayup.d;
          break label269;
        }
        if ((i == 64) && (localayuk.a(paramInt1, 64)))
        {
          paramString1 = ayup.e;
          break label269;
        }
        if (!localayuk.a(paramInt1, 1073741824)) {
          break;
        }
        i = 1073741824;
        paramString1 = ayup.f;
        break label269;
      }
    }
    return 0;
  }
  
  public ayus getNickName(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (this.mLoginSucApp == null) {
      return new ayus(-1, null);
    }
    paramString1 = (ayuk)this.mThirdAppMap.get(paramString1);
    if (paramString1 == null) {
      return new ayus(-2, null);
    }
    if (!paramString1.jdField_b_of_type_JavaLangString.equals(paramString2)) {
      return new ayus(-7, null);
    }
    if (!paramString1.a(8)) {
      return new ayus(-4, null);
    }
    if (!ayuo.a(paramInt)) {
      return new ayus(-5, null);
    }
    paramString1 = paramString1.b(paramString3);
    if (TextUtils.isEmpty(paramString1)) {
      return new ayus(-6, null);
    }
    paramInt = ayut.c(paramInt);
    return new ayus(0, bglf.a(this.mLoginSucApp, paramString1, paramInt));
  }
  
  public List<ayus> handlePayMsgReq(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    QQAppInterface localQQAppInterface = this.mLoginSucApp;
    if (localQQAppInterface == null) {
      return handlePayMsgRsp(new ayus(paramInt, -1, paramString4));
    }
    if ((TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return handlePayMsgRsp(new ayus(paramInt, -6, paramString4));
    }
    paramString1 = ayui.a(BaseApplicationImpl.sApplication, paramString1);
    if (paramString1 == null) {
      return handlePayMsgRsp(new ayus(paramInt, -8, paramString4));
    }
    if (!paramString1.jdField_b_of_type_JavaLangString.equals(paramString2)) {
      return handlePayMsgRsp(new ayus(paramInt, -7, paramString4));
    }
    if (!ayui.a(BaseApplicationImpl.sApplication, paramString2, paramString1.c)) {
      return handlePayMsgRsp(new ayus(paramInt, -7, paramString4));
    }
    this.mLastGetPayCodePkgName = paramString2;
    this.mLastGetPayCodePermission = paramString3;
    paramString2 = new Bundle();
    paramString2.putInt("PayInvokerId", 15);
    paramString3 = new HashMap();
    paramString3.put("pkgName", paramString1.jdField_b_of_type_JavaLangString);
    paramString3.put("businessType", String.valueOf(paramInt));
    paramString3.put("reqData", paramString4);
    paramString4 = localQQAppInterface.getCurrentAccountUin();
    paramString1 = (TicketManager)localQQAppInterface.getManager(2);
    if (paramString1 != null) {}
    for (paramString1 = paramString1.getSkey(paramString4);; paramString1 = "")
    {
      paramString2.putString("uin", paramString4);
      paramString2.putString("skey", paramString1);
      paramString2.putString("skey_type", "2");
      paramString2.putSerializable("map", paramString3);
      QWalletPayBridge.launchBackground(BaseApplicationImpl.sApplication, localQQAppInterface, paramString2);
      paramString1 = localQQAppInterface.getApp();
      if (Build.VERSION.SDK_INT > 10) {}
      for (paramInt = 4;; paramInt = 0)
      {
        paramString1 = paramString1.getSharedPreferences("qwallet_multi", paramInt);
        if (paramString1 != null) {
          paramString1.edit().putLong("tenwatch_req_time_prefix_" + paramString4, NetConnInfoCenter.getServerTimeMillis() / 1000L).commit();
        }
        return handlePayMsgRsp(null);
      }
    }
  }
  
  public List<ayus> handlePayMsgRsp(ayus paramayus)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.mPayMsgRspQueue)
    {
      if (!this.mPayMsgRspQueue.isEmpty()) {
        localArrayList.add(this.mPayMsgRspQueue.poll());
      }
    }
    this.mPayMsgRspQueue.clear();
    if (paramayus != null) {
      localArrayList.add(paramayus);
    }
    return localArrayList;
  }
  
  public boolean isSDKEnable()
  {
    String str2 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.openapi_switch.name(), null);
    if (str2 != null)
    {
      String str1 = str2;
      if (str2.length() > 1) {
        str1 = str2.substring(0, 1);
      }
      return str1.equals("0");
    }
    return true;
  }
  
  public void onFileTransStatusChanged(bduk parambduk, int paramInt1, int paramInt2)
  {
    if (parambduk.jdField_b_of_type_Int != 2) {}
    label641:
    label647:
    for (;;)
    {
      return;
      if ((paramInt1 != 2002) && (paramInt1 != 1002) && (paramInt1 != 2001) && (this.mThirdAppMap.size() != 0) && (isSDKEnable()))
      {
        Object localObject1;
        Object localObject2;
        if ((this.mSendingMsgMap.contains(Long.valueOf(parambduk.jdField_b_of_type_Long))) && ((paramInt1 == 1004) || (paramInt1 == 1005) || (paramInt1 == 1003)))
        {
          localObject1 = (String)this.mSendingMsgMap.remove(Long.valueOf(parambduk.jdField_b_of_type_Long));
          localObject1 = (ayuk)this.mThirdAppMap.get(localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("OpenApi.Manager", 2, "onPttStateChange, thirdApp = " + localObject1 + ", status = " + paramInt1);
          }
          if (localObject1 != null)
          {
            localObject2 = new Intent("com.tencent.mobileqq.openapi.ACTION_MSG_SENDED." + ((ayuk)localObject1).jdField_b_of_type_JavaLangString);
            ((Intent)localObject2).putExtra("msgid", ((ayuk)localObject1).a(String.valueOf(parambduk.jdField_b_of_type_Long)));
            if (paramInt1 != 1003) {
              break label595;
            }
            paramInt2 = 0;
            label229:
            ((Intent)localObject2).putExtra("rs_code", paramInt2);
            BaseApplicationImpl.sApplication.sendBroadcast((Intent)localObject2, ((ayuk)localObject1).c);
          }
        }
        int i;
        if (parambduk.h == 0)
        {
          paramInt2 = 0;
          i = 1;
        }
        for (;;)
        {
          label264:
          if (((this.msgTypeFilterOfApps & 0x2) <= 0) || ((this.uinTypeFilterOfApps & i) <= 0)) {
            break label647;
          }
          String str = parambduk.q;
          localObject1 = this.mLoginSucApp;
          if (parambduk.jdField_a_of_type_Int == 0) {}
          for (boolean bool = true;; bool = false)
          {
            paramInt1 = ayut.a((QQAppInterface)localObject1, paramInt1, bool);
            if (QLog.isColorLevel()) {
              QLog.d("OpenApi.Manager", 2, "onPttStateChange, uin = " + str + ", extStatus = " + paramInt1);
            }
            Iterator localIterator = this.mThirdAppMap.values().iterator();
            localObject2 = null;
            while (localIterator.hasNext())
            {
              ayuk localayuk = (ayuk)localIterator.next();
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject1 = new Intent();
                ((Intent)localObject1).putExtra("uin_type", i);
                ((Intent)localObject1).putExtra("msg_type", 2);
                ((Intent)localObject1).putExtra("mediaStatus", paramInt1);
              }
              if ((paramInt1 == 1003) && (this.mLoginSucApp != null))
              {
                localObject2 = this.mLoginSucApp.a();
                if (localObject2 != null)
                {
                  localObject2 = ((QQMessageFacade)localObject2).b(str, paramInt2, parambduk.jdField_b_of_type_Long);
                  if (localObject2 != null) {
                    ((Intent)localObject1).putExtra("media_path", ((MessageForPtt)localObject2).getLocalFilePath());
                  }
                }
              }
              localObject2 = localObject1;
              if (localayuk.b(i, 2))
              {
                ((Intent)localObject1).putExtra("msgid", localayuk.a(String.valueOf(parambduk.jdField_b_of_type_Long)));
                ((Intent)localObject1).setAction("com.tencent.mobileqq.openapi.ACTION_MSG_STATUS_UPDATE." + localayuk.jdField_b_of_type_JavaLangString);
                BaseApplicationImpl.sApplication.sendBroadcast((Intent)localObject1, localayuk.c);
                localObject2 = localObject1;
              }
            }
            break;
            label595:
            paramInt2 = -9;
            break label229;
            if (parambduk.h == 2)
            {
              paramInt2 = 3000;
              i = 2;
              break label264;
            }
            if (parambduk.h != 1) {
              break label641;
            }
            paramInt2 = 1;
            i = 4;
            break label264;
          }
          paramInt2 = 0;
          i = 0;
        }
      }
    }
  }
  
  public void onMessageReaded(String paramString, int paramInt, boolean paramBoolean, long paramLong)
  {
    if ((this.mThirdAppMap.size() == 0) || (this.mLoginSucApp == null) || (!isSDKEnable())) {
      break label24;
    }
    for (;;)
    {
      label24:
      return;
      if ((paramInt == 0) || (paramInt == 3000) || (paramInt == 1))
      {
        paramInt = ayut.b(paramInt);
        if ((this.uinTypeFilterOfApps & paramInt) <= 0) {
          break;
        }
        Object localObject1 = null;
        Iterator localIterator = this.mThirdAppMap.values().iterator();
        while (localIterator.hasNext())
        {
          ayuk localayuk = (ayuk)localIterator.next();
          Object localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("uin_type", paramInt);
            ((Intent)localObject2).putExtra("is_all", paramBoolean);
            ((Intent)localObject2).putExtra("msgTime", paramLong);
          }
          localObject1 = localObject2;
          if (localayuk.c(paramInt))
          {
            ((Intent)localObject2).putExtra("uin", localayuk.a(paramString));
            ((Intent)localObject2).setAction("com.tencent.mobileqq.openapi.ACTION_MSG_READED." + localayuk.jdField_b_of_type_JavaLangString);
            BaseApplicationImpl.sApplication.sendBroadcast((Intent)localObject2, localayuk.c);
            localObject1 = localObject2;
          }
        }
      }
    }
  }
  
  public final void onPayMsgRsp(ayus paramayus)
  {
    if (checkNeedPayAuth(paramayus)) {}
    for (;;)
    {
      return;
      synchronized (this.mPayMsgRspQueue)
      {
        int i = this.mPayMsgRspQueue.size();
        if (i > 200) {
          this.mPayMsgRspQueue.clear();
        }
        while ((i <= 50) || (!QLog.isDevelopLevel()))
        {
          this.mPayMsgRspQueue.add(paramayus);
          if ((this.mLoginSucApp == null) || (!isSDKEnable())) {
            break;
          }
          paramayus = new Intent();
          paramayus.setAction("com.tencent.mobileqq.openapi.ACTION_PAYMSG_RCV." + this.mLastGetPayCodePkgName);
          BaseApplicationImpl.sApplication.sendBroadcast(paramayus, this.mLastGetPayCodePermission);
          return;
        }
        QLog.i("OpenApi.Manager", 4, "Pay rsp queue size:" + i);
      }
    }
  }
  
  public void onReceiveNewMsg(QQMessageFacade.Message paramMessage)
  {
    int i = 0;
    QQAppInterface localQQAppInterface = this.mLoginSucApp;
    if ((this.mThirdAppMap.size() == 0) || (localQQAppInterface == null) || (!isSDKEnable())) {}
    int k;
    int m;
    do
    {
      do
      {
        return;
      } while ((paramMessage.istroop != 0) && (paramMessage.istroop != 3000) && (paramMessage.istroop != 1));
      k = ayut.a(paramMessage.msgtype);
      m = ayut.b(paramMessage.istroop);
    } while ((((this.msgTypeFilterOfApps & k) <= 0) && ((this.msgTypeFilterOfApps & 0x40000000) <= 0)) || ((this.uinTypeFilterOfApps & m) <= 0));
    String str1 = paramMessage.frienduin;
    String str2 = paramMessage.senderuin;
    int n = localQQAppInterface.a().a(paramMessage.frienduin, paramMessage.istroop);
    if (QLog.isColorLevel()) {
      QLog.d("OpenApi.Manager", 2, "new msg, uin = " + bgsp.e(str1));
    }
    Object localObject1 = null;
    Iterator localIterator = this.mThirdAppMap.values().iterator();
    label188:
    Object localObject2;
    int j;
    if (localIterator.hasNext())
    {
      ayuk localayuk = (ayuk)localIterator.next();
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("uin_type", m);
        ((Intent)localObject2).putExtra("unreadCount", n);
      }
      boolean bool = localayuk.b(m, k);
      if ((!bool) && (!localayuk.b(m))) {
        break label415;
      }
      if (!bool) {
        break label410;
      }
      j = k;
      label284:
      ((Intent)localObject2).putExtra("msg_type", j);
      ((Intent)localObject2).putExtra("uin", localayuk.a(str1));
      ((Intent)localObject2).putExtra("senderUin", localayuk.a(str2));
      ((Intent)localObject2).setAction("com.tencent.mobileqq.openapi.ACTION_NEW_MSG." + localayuk.jdField_b_of_type_JavaLangString);
      BaseApplicationImpl.sApplication.sendBroadcast((Intent)localObject2, localayuk.c);
      if ((paramMessage.msgtype != -2002) || (i != 0)) {
        break label415;
      }
      checkDownloadPtt(localQQAppInterface, paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
      i = 1;
    }
    label410:
    label415:
    for (;;)
    {
      localObject1 = localObject2;
      break label188;
      break;
      j = 0;
      break label284;
    }
  }
  
  public void onRuntimeActive(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.getSubThreadHandler().post(new OpenApiManager.1(this, paramQQAppInterface));
  }
  
  public void onRuntimeDestroy(QQAppInterface paramQQAppInterface)
  {
    onRuntimeDisactive(paramQQAppInterface, false);
  }
  
  public void onUserLogout(QQAppInterface paramQQAppInterface)
  {
    onRuntimeDisactive(paramQQAppInterface, true);
  }
  
  public int openAIO(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    QQAppInterface localQQAppInterface = this.mLoginSucApp;
    if (localQQAppInterface == null) {
      return -1;
    }
    paramString1 = (ayuk)this.mThirdAppMap.get(paramString1);
    if (paramString1 == null) {
      return -2;
    }
    if (!paramString1.jdField_b_of_type_JavaLangString.equals(paramString2)) {
      return -7;
    }
    if (!paramString1.a(64)) {
      return -4;
    }
    paramString1 = paramString1.b(paramString3);
    if (TextUtils.isEmpty(paramString1)) {
      return -6;
    }
    if (paramInt == 1)
    {
      paramString2 = ((anmw)localQQAppInterface.getManager(51)).e(paramString1);
      if ((paramString2 == null) || (!paramString2.isFriend())) {
        return -11;
      }
      paramString3 = afur.a(new Intent(BaseApplicationImpl.sApplication, SplashActivity.class), new int[] { 2 });
      paramString3.addFlags(268435456);
      paramString3.putExtra("uin", paramString1);
      paramString3.putExtra("cSpecialFlag", paramString2.cSpecialFlag);
      paramString3.putExtra("uinname", bglf.a(paramString2));
      if ((nmp.a(paramString2.cSpecialFlag)) || (bjft.b(paramString2.cSpecialFlag)))
      {
        paramString3.setClass(BaseApplicationImpl.sApplication, SplashActivity.class);
        paramString3.putExtra("chat_subType", 1);
      }
      paramString3.putExtra("entrance", 0);
      paramString3.putExtra("uintype", 0);
      BaseApplicationImpl.sApplication.startActivity(paramString3);
      return 0;
    }
    return -5;
  }
  
  public ayur registerThirdApp(String paramString1, String paramString2, long paramLong, int paramInt1, int paramInt2, String paramString3)
  {
    QQAppInterface localQQAppInterface = this.mLoginSucApp;
    if (localQQAppInterface == null) {
      return new ayur(-1, 0L, null);
    }
    Object localObject = (ayuk)this.mThirdAppMap.get(paramString1);
    if (localObject == null)
    {
      localObject = ayui.a(BaseApplicationImpl.sApplication, paramString1);
      if (localObject == null) {
        return new ayur(-8, 0L, null);
      }
      if (!((ayuj)localObject).jdField_b_of_type_JavaLangString.equals(paramString2)) {
        return new ayur(-7, 0L, null);
      }
      if (!ayui.a(BaseApplicationImpl.sApplication, paramString2, ((ayuj)localObject).c)) {
        return new ayur(-7, 0L, null);
      }
      if ((((ayuj)localObject).jdField_b_of_type_Boolean) && (paramLong != ((ayuj)localObject).d)) {
        return new ayur(-18, ((ayuj)localObject).d, null);
      }
      if ((!((ayuj)localObject).jdField_b_of_type_Boolean) && (paramLong != ((ayuj)localObject).jdField_b_of_type_Long)) {
        return new ayur(-18, ((ayuj)localObject).jdField_b_of_type_Long, null);
      }
      if (((ayuj)localObject).jdField_b_of_type_Boolean) {
        ayui.a(BaseApplicationImpl.sApplication, (ayuj)localObject);
      }
      paramString2 = new ayuk((ayuj)localObject);
      paramString2.c = paramString3;
      this.mThirdAppMap.put(paramString1, paramString2);
      paramString3 = paramString2;
    }
    while (paramLong != paramString3.a)
    {
      this.mThirdAppMap.remove(paramString1);
      resetFilters();
      return new ayur(-18, paramString3.a, null);
      paramString3 = (String)localObject;
      if (!((ayuk)localObject).jdField_b_of_type_JavaLangString.equals(paramString2)) {
        return new ayur(-7, 0L, null);
      }
    }
    paramString3.a(paramInt1, paramInt2);
    resetFilters();
    return new ayur(0, 0L, paramString3.a(localQQAppInterface.getCurrentAccountUin()));
  }
  
  public ayus sendMessage(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5)
  {
    QQAppInterface localQQAppInterface = this.mLoginSucApp;
    if (localQQAppInterface == null) {
      return new ayus(-1, null);
    }
    ayuk localayuk = (ayuk)this.mThirdAppMap.get(paramString1);
    if (localayuk == null) {
      return new ayus(-2, null);
    }
    if (!localayuk.jdField_b_of_type_JavaLangString.equals(paramString2)) {
      return new ayus(-7, null);
    }
    if (!localayuk.a(8)) {
      return new ayus(-4, null);
    }
    paramString3 = localayuk.b(paramString3);
    if (TextUtils.isEmpty(paramString3)) {
      return new ayus(-6, null);
    }
    long l1 = 0L;
    if (paramInt1 == 1)
    {
      paramString2 = ((anmw)localQQAppInterface.getManager(51)).e(paramString3);
      if ((paramString2 == null) || (!paramString2.isFriend())) {
        return new ayus(-11, null);
      }
      paramString2 = new SessionInfo();
      paramString2.jdField_a_of_type_JavaLangString = paramString3;
      paramString2.jdField_a_of_type_Int = 0;
      paramString2.d = bglf.m(localQQAppInterface, paramString3);
      if (paramInt2 == 1)
      {
        if (TextUtils.isEmpty(paramString4)) {
          return new ayus(-6, null);
        }
        paramString2 = adrm.a(localQQAppInterface, localQQAppInterface.getApp(), paramString2, paramString4, null, new adrt());
        if ((paramString2 == null) || (paramString2.length == 0)) {
          return new ayus(-9, null);
        }
        l1 = paramString2[(paramString2.length - 1)];
      }
      for (;;)
      {
        this.mSendingMsgMap.put(Long.valueOf(l1), paramString1);
        if (QLog.isColorLevel()) {
          QLog.d("OpenApi.Manager", 2, "send message: " + l1);
        }
        return new ayus(0, localayuk.a(String.valueOf(l1)));
        if (paramInt2 == 2)
        {
          if (TextUtils.isEmpty(paramString5)) {
            return new ayus(-6, null);
          }
          paramString3 = new File(paramString5);
          if ((!paramString3.exists()) || (paramString3.length() < 700L) || (paramString3.length() > 42000L)) {
            return new ayus(-6, null);
          }
          if (!bgog.a(paramString5, ayun.a)) {
            return new ayus(-13, null);
          }
          paramString3 = MessageForPtt.getLocalFilePath(2, bdtd.a(localQQAppInterface.getCurrentAccountUin(), null, 2, null));
          bgmg.d(paramString5, paramString3);
          paramString4 = adrm.a(localQQAppInterface, paramString3, paramString2, -3, 0);
          ((MessageForPtt)paramString4).c2cViaOffline = true;
          l1 = paramString4.uniseq;
          long l2 = QQRecorder.a(paramString3);
          paramString5 = new Bundle();
          paramString5.putInt("DiyTextId", paramString4.vipBubbleDiyTextId);
          adrm.a(localQQAppInterface, paramString2.jdField_a_of_type_Int, paramString2.jdField_a_of_type_JavaLangString, paramString3, l1, true, (int)(1000L * l2), 0, true, 0, 0, true, paramString4.vipSubBubbleId, paramString5);
        }
      }
    }
    return new ayus(-5, null);
  }
  
  public int setMessageReaded(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    QQAppInterface localQQAppInterface = this.mLoginSucApp;
    if (localQQAppInterface == null) {
      return -1;
    }
    ayuk localayuk = (ayuk)this.mThirdAppMap.get(paramString1);
    if (localayuk == null) {
      return -2;
    }
    if (!localayuk.jdField_b_of_type_JavaLangString.equals(paramString2)) {
      return -7;
    }
    if (!localayuk.a(16)) {
      return -4;
    }
    paramString1 = localayuk.b(paramString3);
    paramString2 = localayuk.b(paramString4);
    long l2 = 0L;
    try
    {
      l1 = Long.parseLong(paramString2);
      if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (l1 == 0L)) {
        return -6;
      }
    }
    catch (Exception paramString3)
    {
      long l1;
      for (;;)
      {
        l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d("OpenApi.Manager", 2, "setMsgReaded, id = " + paramString2, paramString3);
          l1 = l2;
        }
      }
      if (paramInt == 1)
      {
        paramString2 = localQQAppInterface.a();
        paramString3 = paramString2.b(paramString1, 0, l1);
        if (paramString3 == null) {
          return -14;
        }
        paramString2.a(paramString1, 0, paramString3.time);
        return 0;
      }
    }
    return -5;
  }
  
  public int unregisterThirdApp(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenApi.Manager", 2, "unregister, appid = " + paramString1);
    }
    ayuk localayuk = (ayuk)this.mThirdAppMap.get(paramString1);
    if ((localayuk != null) && (!localayuk.jdField_b_of_type_JavaLangString.equals(paramString2))) {
      return -7;
    }
    this.mThirdAppMap.remove(paramString1);
    return 0;
  }
  
  public boolean verifyCallingPackage(ContentProvider paramContentProvider, String paramString)
  {
    try
    {
      int i = Binder.getCallingUid();
      if (i == 0) {
        return false;
      }
      paramContentProvider = BaseApplicationImpl.sApplication.getPackageManager().getPackagesForUid(i);
      int j = paramContentProvider.length;
      i = 0;
      while (i < j)
      {
        boolean bool = paramContentProvider[i].equals(paramString);
        if (bool) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception paramContentProvider)
    {
      if (QLog.isColorLevel()) {
        QLog.e("OpenApi.Manager", 2, "verifyPackage " + paramString, paramContentProvider);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.openapi.OpenApiManager
 * JD-Core Version:    0.7.0.1
 */