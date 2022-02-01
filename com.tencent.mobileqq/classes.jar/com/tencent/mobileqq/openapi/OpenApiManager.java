package com.tencent.mobileqq.openapi;

import adab;
import adak;
import aean;
import aeau;
import agej;
import agid;
import agif;
import ahnz;
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
import anyw;
import aocj;
import azmt;
import azmu;
import azmv;
import azmw;
import azmx;
import azna;
import aznb;
import aznc;
import azne;
import aznf;
import azng;
import begp;
import berv;
import bete;
import bhlg;
import bhmi;
import bhoi;
import bhsr;
import bkgt;
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
import nok;
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
  private aocj mMsgObserver = new azmt(this);
  private final Queue<aznf> mPayMsgRspQueue = new LinkedList();
  private View mPttHolderView;
  private agif mPttTransferCallback;
  private ConcurrentHashMap<Long, String> mSendingMsgMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, azmx> mThirdAppMap = new ConcurrentHashMap();
  private int msgTypeFilterOfApps = 0;
  private int uinTypeFilterOfApps = 0;
  
  private void checkDownloadPtt(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    MessageForPtt localMessageForPtt;
    int i;
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForPtt)))
    {
      localMessageForPtt = (MessageForPtt)paramMessageRecord;
      i = ahnz.a(paramQQAppInterface, localMessageForPtt);
      if (i != -1) {
        break label46;
      }
      aean.a(paramQQAppInterface, paramMessageRecord.frienduin, localMessageForPtt, true, 3, 0, true);
    }
    label46:
    while ((!paramBoolean) || ((i != 2005) && (i != 2004))) {
      return;
    }
    aean.a(paramQQAppInterface, paramMessageRecord.frienduin, localMessageForPtt, true, 2, 0, false);
  }
  
  private void checkDownloadPtt(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong)
  {
    checkDownloadPtt(paramQQAppInterface, paramQQAppInterface.a().b(paramString, paramInt, paramLong), false);
  }
  
  private boolean checkNeedPayAuth(aznf paramaznf)
  {
    if ((paramaznf == null) || (paramaznf.jdField_a_of_type_Int != 3)) {}
    for (;;)
    {
      return false;
      try
      {
        int i = new JSONObject(paramaznf.jdField_a_of_type_JavaLangString).optInt("retcode");
        if (i != 10001) {
          continue;
        }
        try
        {
          paramaznf = this.mLoginSucApp;
          Object localObject = new JSONObject();
          ((JSONObject)localObject).put("userId", paramaznf.getCurrentAccountUin());
          ((JSONObject)localObject).put("viewTag", "showWearPayAuthor");
          ((JSONObject)localObject).put("app_info", "appInfo");
          ((JSONObject)localObject).put("come_from", 2);
          ((JSONObject)localObject).put("extra_data", "{}");
          Bundle localBundle = new Bundle();
          localBundle.putString("json", ((JSONObject)localObject).toString());
          localBundle.putString("callbackSn", "0");
          localObject = new Intent(paramaznf.getApplication(), PayBridgeActivity.class);
          ((Intent)localObject).putExtras(localBundle);
          ((Intent)localObject).addFlags(268435456);
          ((Intent)localObject).putExtra("pay_requestcode", 5);
          paramaznf.getApplication().startActivity((Intent)localObject);
          return true;
        }
        catch (Exception paramaznf)
        {
          for (;;)
          {
            if (QLog.isDevelopLevel()) {
              paramaznf.printStackTrace();
            }
          }
        }
        return false;
      }
      catch (JSONException paramaznf) {}
    }
  }
  
  @Deprecated
  private void cleanupPttCallback()
  {
    this.mPttHolderView = null;
    this.mPttTransferCallback = null;
  }
  
  private aznc copyMsgFromMessageRecord(MessageRecord paramMessageRecord, String paramString, int paramInt)
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
      azmx localazmx = (azmx)localIterator.next();
      j |= localazmx.a();
      i = localazmx.b() | i;
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
    this.mPttTransferCallback = new azmu(this);
    agid.a(this.mLoginSucApp).a(this.mPttHolderView, this.mPttTransferCallback);
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
    //   37: checkcast 277	azmx
    //   40: astore 15
    //   42: aload 15
    //   44: ifnonnull +20 -> 64
    //   47: new 333	android/util/Pair
    //   50: dup
    //   51: bipush 254
    //   53: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   56: iconst_0
    //   57: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: invokespecial 342	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   63: areturn
    //   64: aload 15
    //   66: getfield 348	azmx:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   69: aload_2
    //   70: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   73: ifne +20 -> 93
    //   76: new 333	android/util/Pair
    //   79: dup
    //   80: bipush 249
    //   82: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   85: iconst_0
    //   86: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   89: invokespecial 342	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   92: areturn
    //   93: aload 15
    //   95: sipush 256
    //   98: invokevirtual 357	azmx:a	(I)Z
    //   101: ifne +20 -> 121
    //   104: new 333	android/util/Pair
    //   107: dup
    //   108: bipush 252
    //   110: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   113: iconst_0
    //   114: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   117: invokespecial 342	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   120: areturn
    //   121: aload 15
    //   123: aload_3
    //   124: invokevirtual 360	azmx:b	(Ljava/lang/String;)Ljava/lang/String;
    //   127: astore_1
    //   128: aload 15
    //   130: aload 5
    //   132: invokevirtual 360	azmx:b	(Ljava/lang/String;)Ljava/lang/String;
    //   135: astore_2
    //   136: lconst_0
    //   137: lstore 13
    //   139: aload_2
    //   140: invokestatic 366	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   143: lstore 11
    //   145: aload_1
    //   146: invokestatic 372	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   149: ifne +17 -> 166
    //   152: aload_2
    //   153: invokestatic 372	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   156: ifne +10 -> 166
    //   159: lload 11
    //   161: lconst_0
    //   162: lcmp
    //   163: ifne +48 -> 211
    //   166: new 333	android/util/Pair
    //   169: dup
    //   170: bipush 250
    //   172: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   175: iconst_0
    //   176: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   179: invokespecial 342	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   182: areturn
    //   183: astore_3
    //   184: lload 13
    //   186: lstore 11
    //   188: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   191: ifeq -46 -> 145
    //   194: ldc 16
    //   196: iconst_2
    //   197: ldc_w 374
    //   200: aload_3
    //   201: invokestatic 377	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   204: lload 13
    //   206: lstore 11
    //   208: goto -63 -> 145
    //   211: iload 4
    //   213: iconst_1
    //   214: if_icmpne +598 -> 812
    //   217: aload 6
    //   219: getstatic 382	antf:aZ	Ljava/lang/String;
    //   222: invokevirtual 386	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   225: ifne +31 -> 256
    //   228: aload 7
    //   230: getstatic 382	antf:aZ	Ljava/lang/String;
    //   233: invokevirtual 386	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   236: ifne +20 -> 256
    //   239: new 333	android/util/Pair
    //   242: dup
    //   243: bipush 240
    //   245: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   248: iconst_0
    //   249: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   252: invokespecial 342	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   255: areturn
    //   256: aload 6
    //   258: invokestatic 390	bhmi:a	(Ljava/lang/String;)Z
    //   261: ifne +20 -> 281
    //   264: new 333	android/util/Pair
    //   267: dup
    //   268: bipush 246
    //   270: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   273: iconst_0
    //   274: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   277: invokespecial 342	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   280: areturn
    //   281: aconst_null
    //   282: astore 16
    //   284: aconst_null
    //   285: astore_2
    //   286: iconst_0
    //   287: istore 9
    //   289: aconst_null
    //   290: astore 15
    //   292: aconst_null
    //   293: astore 5
    //   295: new 392	java/io/FileInputStream
    //   298: dup
    //   299: aload 6
    //   301: invokespecial 393	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   304: astore_1
    //   305: aload_1
    //   306: invokestatic 398	bhrp:a	(Ljava/io/InputStream;)B
    //   309: istore 8
    //   311: iload 8
    //   313: ifge +57 -> 370
    //   316: new 333	android/util/Pair
    //   319: dup
    //   320: bipush 251
    //   322: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   325: iconst_0
    //   326: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   329: invokespecial 342	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   332: astore_3
    //   333: aload_1
    //   334: ifnull +7 -> 341
    //   337: aload_1
    //   338: invokevirtual 401	java/io/FileInputStream:close	()V
    //   341: iconst_0
    //   342: ifeq +11 -> 353
    //   345: new 403	java/lang/NullPointerException
    //   348: dup
    //   349: invokespecial 404	java/lang/NullPointerException:<init>	()V
    //   352: athrow
    //   353: aload_3
    //   354: astore_1
    //   355: iconst_0
    //   356: ifeq -329 -> 27
    //   359: new 403	java/lang/NullPointerException
    //   362: dup
    //   363: invokespecial 404	java/lang/NullPointerException:<init>	()V
    //   366: athrow
    //   367: astore_1
    //   368: aload_3
    //   369: areturn
    //   370: aload 7
    //   372: invokestatic 407	bhmi:a	(Ljava/lang/String;)Ljava/io/File;
    //   375: pop
    //   376: new 409	java/io/FileOutputStream
    //   379: dup
    //   380: aload 7
    //   382: invokespecial 410	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   385: astore_3
    //   386: iload 8
    //   388: invokestatic 413	bhrp:a	(B)I
    //   391: istore 4
    //   393: iload 4
    //   395: invokestatic 416	bhrp:a	(I)I
    //   398: istore 9
    //   400: iload 9
    //   402: newarray byte
    //   404: astore 7
    //   406: iload 9
    //   408: newarray byte
    //   410: astore 6
    //   412: new 418	com/tencent/mobileqq/utils/SilkCodecWrapper
    //   415: dup
    //   416: aload 17
    //   418: invokevirtual 422	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   421: iconst_0
    //   422: invokespecial 425	com/tencent/mobileqq/utils/SilkCodecWrapper:<init>	(Landroid/content/Context;Z)V
    //   425: astore_2
    //   426: aload_2
    //   427: iload 4
    //   429: iconst_0
    //   430: iconst_1
    //   431: invokevirtual 428	com/tencent/mobileqq/utils/SilkCodecWrapper:a	(III)V
    //   434: iconst_2
    //   435: newarray byte
    //   437: astore 5
    //   439: aload_1
    //   440: aload 5
    //   442: invokevirtual 432	java/io/FileInputStream:read	([B)I
    //   445: istore 10
    //   447: iload 10
    //   449: iconst_m1
    //   450: if_icmpne +44 -> 494
    //   453: aload_1
    //   454: ifnull +7 -> 461
    //   457: aload_1
    //   458: invokevirtual 401	java/io/FileInputStream:close	()V
    //   461: aload_3
    //   462: ifnull +7 -> 469
    //   465: aload_3
    //   466: invokevirtual 433	java/io/FileOutputStream:close	()V
    //   469: aload_2
    //   470: ifnull +7 -> 477
    //   473: aload_2
    //   474: invokevirtual 435	com/tencent/mobileqq/utils/SilkCodecWrapper:b	()V
    //   477: new 333	android/util/Pair
    //   480: dup
    //   481: iconst_0
    //   482: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   485: iload 4
    //   487: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   490: invokespecial 342	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   493: areturn
    //   494: aload 5
    //   496: invokestatic 437	bhrp:a	([B)I
    //   499: istore 10
    //   501: iload 10
    //   503: ifgt +55 -> 558
    //   506: new 333	android/util/Pair
    //   509: dup
    //   510: bipush 241
    //   512: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   515: iconst_0
    //   516: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   519: invokespecial 342	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   522: astore 5
    //   524: aload_1
    //   525: ifnull +7 -> 532
    //   528: aload_1
    //   529: invokevirtual 401	java/io/FileInputStream:close	()V
    //   532: aload_3
    //   533: ifnull +7 -> 540
    //   536: aload_3
    //   537: invokevirtual 433	java/io/FileOutputStream:close	()V
    //   540: aload 5
    //   542: astore_1
    //   543: aload_2
    //   544: ifnull -517 -> 27
    //   547: aload_2
    //   548: invokevirtual 435	com/tencent/mobileqq/utils/SilkCodecWrapper:b	()V
    //   551: aload 5
    //   553: areturn
    //   554: astore_1
    //   555: aload 5
    //   557: areturn
    //   558: aload_1
    //   559: aload 7
    //   561: iconst_0
    //   562: iload 10
    //   564: invokevirtual 440	java/io/FileInputStream:read	([BII)I
    //   567: ifne +55 -> 622
    //   570: new 333	android/util/Pair
    //   573: dup
    //   574: bipush 241
    //   576: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   579: iconst_0
    //   580: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   583: invokespecial 342	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   586: astore 5
    //   588: aload_1
    //   589: ifnull +7 -> 596
    //   592: aload_1
    //   593: invokevirtual 401	java/io/FileInputStream:close	()V
    //   596: aload_3
    //   597: ifnull +7 -> 604
    //   600: aload_3
    //   601: invokevirtual 433	java/io/FileOutputStream:close	()V
    //   604: aload 5
    //   606: astore_1
    //   607: aload_2
    //   608: ifnull -581 -> 27
    //   611: aload_2
    //   612: invokevirtual 435	com/tencent/mobileqq/utils/SilkCodecWrapper:b	()V
    //   615: aload 5
    //   617: areturn
    //   618: astore_1
    //   619: aload 5
    //   621: areturn
    //   622: aload_2
    //   623: aload 7
    //   625: aload 6
    //   627: iload 10
    //   629: iload 9
    //   631: invokevirtual 443	com/tencent/mobileqq/utils/SilkCodecWrapper:a	([B[BII)I
    //   634: ifne +55 -> 689
    //   637: new 333	android/util/Pair
    //   640: dup
    //   641: bipush 239
    //   643: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   646: iconst_0
    //   647: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   650: invokespecial 342	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   653: astore 5
    //   655: aload_1
    //   656: ifnull +7 -> 663
    //   659: aload_1
    //   660: invokevirtual 401	java/io/FileInputStream:close	()V
    //   663: aload_3
    //   664: ifnull +7 -> 671
    //   667: aload_3
    //   668: invokevirtual 433	java/io/FileOutputStream:close	()V
    //   671: aload 5
    //   673: astore_1
    //   674: aload_2
    //   675: ifnull -648 -> 27
    //   678: aload_2
    //   679: invokevirtual 435	com/tencent/mobileqq/utils/SilkCodecWrapper:b	()V
    //   682: aload 5
    //   684: areturn
    //   685: astore_1
    //   686: aload 5
    //   688: areturn
    //   689: aload_3
    //   690: aload 6
    //   692: invokevirtual 447	java/io/FileOutputStream:write	([B)V
    //   695: goto -256 -> 439
    //   698: astore 6
    //   700: aload_2
    //   701: astore 5
    //   703: aload_3
    //   704: astore_2
    //   705: aload 6
    //   707: astore_3
    //   708: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   711: ifeq +13 -> 724
    //   714: ldc 16
    //   716: iconst_2
    //   717: ldc_w 449
    //   720: aload_3
    //   721: invokestatic 377	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   724: new 333	android/util/Pair
    //   727: dup
    //   728: bipush 244
    //   730: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   733: iload 4
    //   735: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   738: invokespecial 342	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   741: astore_3
    //   742: aload_1
    //   743: ifnull +7 -> 750
    //   746: aload_1
    //   747: invokevirtual 401	java/io/FileInputStream:close	()V
    //   750: aload_2
    //   751: ifnull +7 -> 758
    //   754: aload_2
    //   755: invokevirtual 433	java/io/FileOutputStream:close	()V
    //   758: aload_3
    //   759: astore_1
    //   760: aload 5
    //   762: ifnull -735 -> 27
    //   765: aload 5
    //   767: invokevirtual 435	com/tencent/mobileqq/utils/SilkCodecWrapper:b	()V
    //   770: aload_3
    //   771: areturn
    //   772: astore_1
    //   773: aload_3
    //   774: areturn
    //   775: astore_2
    //   776: aconst_null
    //   777: astore_1
    //   778: aconst_null
    //   779: astore_3
    //   780: aload 15
    //   782: astore 5
    //   784: aload_1
    //   785: ifnull +7 -> 792
    //   788: aload_1
    //   789: invokevirtual 401	java/io/FileInputStream:close	()V
    //   792: aload_3
    //   793: ifnull +7 -> 800
    //   796: aload_3
    //   797: invokevirtual 433	java/io/FileOutputStream:close	()V
    //   800: aload 5
    //   802: ifnull +8 -> 810
    //   805: aload 5
    //   807: invokevirtual 435	com/tencent/mobileqq/utils/SilkCodecWrapper:b	()V
    //   810: aload_2
    //   811: athrow
    //   812: new 333	android/util/Pair
    //   815: dup
    //   816: bipush 251
    //   818: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   821: iconst_0
    //   822: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   825: invokespecial 342	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   828: areturn
    //   829: astore_1
    //   830: goto -489 -> 341
    //   833: astore_1
    //   834: goto -481 -> 353
    //   837: astore_1
    //   838: goto -306 -> 532
    //   841: astore_1
    //   842: goto -302 -> 540
    //   845: astore_1
    //   846: goto -250 -> 596
    //   849: astore_1
    //   850: goto -246 -> 604
    //   853: astore_1
    //   854: goto -191 -> 663
    //   857: astore_1
    //   858: goto -187 -> 671
    //   861: astore_1
    //   862: goto -401 -> 461
    //   865: astore_1
    //   866: goto -397 -> 469
    //   869: astore_1
    //   870: goto -393 -> 477
    //   873: astore_1
    //   874: goto -124 -> 750
    //   877: astore_1
    //   878: goto -120 -> 758
    //   881: astore_1
    //   882: goto -90 -> 792
    //   885: astore_1
    //   886: goto -86 -> 800
    //   889: astore_1
    //   890: goto -80 -> 810
    //   893: astore_2
    //   894: aconst_null
    //   895: astore_3
    //   896: aload 15
    //   898: astore 5
    //   900: goto -116 -> 784
    //   903: astore_2
    //   904: aload 15
    //   906: astore 5
    //   908: goto -124 -> 784
    //   911: astore 6
    //   913: aload_2
    //   914: astore 5
    //   916: aload 6
    //   918: astore_2
    //   919: goto -135 -> 784
    //   922: astore 6
    //   924: aload_2
    //   925: astore_3
    //   926: aload 6
    //   928: astore_2
    //   929: goto -145 -> 784
    //   932: astore_3
    //   933: iload 9
    //   935: istore 4
    //   937: aload 16
    //   939: astore_1
    //   940: goto -232 -> 708
    //   943: astore_3
    //   944: iload 9
    //   946: istore 4
    //   948: goto -240 -> 708
    //   951: astore 6
    //   953: aload_3
    //   954: astore_2
    //   955: aload 6
    //   957: astore_3
    //   958: iload 9
    //   960: istore 4
    //   962: goto -254 -> 708
    //   965: astore 6
    //   967: aload_3
    //   968: astore_2
    //   969: aload 6
    //   971: astore_3
    //   972: goto -264 -> 708
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	975	0	this	OpenApiManager
    //   0	975	1	paramString1	String
    //   0	975	2	paramString2	String
    //   0	975	3	paramString3	String
    //   0	975	4	paramInt	int
    //   0	975	5	paramString4	String
    //   0	975	6	paramString5	String
    //   0	975	7	paramString6	String
    //   309	78	8	b	byte
    //   287	672	9	i	int
    //   445	183	10	j	int
    //   143	64	11	l1	long
    //   137	68	13	l2	long
    //   40	865	15	localazmx	azmx
    //   282	656	16	localObject	Object
    //   4	413	17	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   139	145	183	java/lang/Exception
    //   359	367	367	java/lang/Throwable
    //   547	551	554	java/lang/Throwable
    //   611	615	618	java/lang/Throwable
    //   678	682	685	java/lang/Throwable
    //   426	439	698	java/lang/Throwable
    //   439	447	698	java/lang/Throwable
    //   494	501	698	java/lang/Throwable
    //   506	524	698	java/lang/Throwable
    //   558	588	698	java/lang/Throwable
    //   622	655	698	java/lang/Throwable
    //   689	695	698	java/lang/Throwable
    //   765	770	772	java/lang/Throwable
    //   295	305	775	finally
    //   337	341	829	java/lang/Exception
    //   345	353	833	java/lang/Exception
    //   528	532	837	java/lang/Exception
    //   536	540	841	java/lang/Exception
    //   592	596	845	java/lang/Exception
    //   600	604	849	java/lang/Exception
    //   659	663	853	java/lang/Exception
    //   667	671	857	java/lang/Exception
    //   457	461	861	java/lang/Exception
    //   465	469	865	java/lang/Exception
    //   473	477	869	java/lang/Throwable
    //   746	750	873	java/lang/Exception
    //   754	758	877	java/lang/Exception
    //   788	792	881	java/lang/Exception
    //   796	800	885	java/lang/Exception
    //   805	810	889	java/lang/Throwable
    //   305	311	893	finally
    //   316	333	893	finally
    //   370	386	893	finally
    //   386	393	903	finally
    //   393	426	903	finally
    //   426	439	911	finally
    //   439	447	911	finally
    //   494	501	911	finally
    //   506	524	911	finally
    //   558	588	911	finally
    //   622	655	911	finally
    //   689	695	911	finally
    //   708	724	922	finally
    //   724	742	922	finally
    //   295	305	932	java/lang/Throwable
    //   305	311	943	java/lang/Throwable
    //   316	333	943	java/lang/Throwable
    //   370	386	943	java/lang/Throwable
    //   386	393	951	java/lang/Throwable
    //   393	426	965	java/lang/Throwable
  }
  
  public Pair<Integer, Integer> downloadMedia(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    QQAppInterface localQQAppInterface = this.mLoginSucApp;
    if (localQQAppInterface == null) {
      return new Pair(Integer.valueOf(-1), Integer.valueOf(0));
    }
    paramString1 = (azmx)this.mThirdAppMap.get(paramString1);
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
        paramString1 = ((anyw)localQQAppInterface.getManager(51)).e(paramString2);
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
      paramString1 = localQQAppInterface.a().b(paramString2, azng.c(paramInt), l);
      if ((paramString1 == null) || (paramString1.isSendFromLocal())) {
        return new Pair(Integer.valueOf(-14), Integer.valueOf(0));
      }
      checkDownloadPtt(localQQAppInterface, paramString1, true);
      return new Pair(Integer.valueOf(0), Integer.valueOf(azng.a(localQQAppInterface, (MessageForPtt)paramString1)));
    }
    return new Pair(Integer.valueOf(-5), Integer.valueOf(0));
  }
  
  public aznf[] exchangeUins(String paramString1, String paramString2, long paramLong1, long paramLong2, String[] paramArrayOfString)
  {
    paramString2 = new aznf[1];
    paramString2[0] = new aznf(0, null);
    paramString1 = azmv.a(BaseApplicationImpl.sApplication, paramString1);
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
    paramString1 = new azmx(paramString1);
    if (!paramString1.a(4))
    {
      paramString2[0].jdField_b_of_type_Int = -4;
      return paramString2;
    }
    paramString2 = new aznf[paramArrayOfString.length];
    int i = 0;
    for (;;)
    {
      if (i < paramArrayOfString.length)
      {
        paramString2[i] = new aznf(0, null);
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
  
  public aznf getAvatarPath(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    QQAppInterface localQQAppInterface = this.mLoginSucApp;
    if (localQQAppInterface == null) {
      return new aznf(-1, null);
    }
    paramString1 = (azmx)this.mThirdAppMap.get(paramString1);
    if (paramString1 == null) {
      return new aznf(-2, null);
    }
    if (!paramString1.jdField_b_of_type_JavaLangString.equals(paramString2)) {
      return new aznf(-7, null);
    }
    if (!paramString1.a(4)) {
      return new aznf(-4, null);
    }
    paramString1 = paramString1.b(paramString3);
    if (TextUtils.isEmpty(paramString1)) {
      return new aznf(-6, null);
    }
    int i = 1;
    if (paramInt == 2) {
      i = 101;
    }
    for (;;)
    {
      return new aznf(0, localQQAppInterface.a(i, paramString1, 0));
      if (paramInt == 4) {
        i = 4;
      }
    }
  }
  
  public int getLastMessages(List<aznc> paramList, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    QQAppInterface localQQAppInterface = this.mLoginSucApp;
    if (localQQAppInterface == null) {
      return -1;
    }
    if (!aznb.a(paramInt1)) {
      return -5;
    }
    azmx localazmx = (azmx)this.mThirdAppMap.get(paramString1);
    if (localazmx == null) {
      return -2;
    }
    if (!localazmx.jdField_b_of_type_JavaLangString.equals(paramString2)) {
      return -7;
    }
    paramString1 = localazmx.b(paramString3);
    if (TextUtils.isEmpty(paramString1)) {
      return -6;
    }
    if (!localazmx.a(2)) {
      return -4;
    }
    List localList = localQQAppInterface.a().a(paramString1, azng.c(paramInt1), paramInt2);
    adak.a(paramString1, azng.c(paramInt1), localList, localQQAppInterface);
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
      int i = azng.a(localMessageRecord.msgtype);
      String str2 = localazmx.a(String.valueOf(localMessageRecord.uniseq));
      paramString1 = null;
      paramString2 = null;
      int j = 1007;
      if ((i == 1) && (localazmx.a(paramInt1, 1)))
      {
        paramString1 = new begp(localMessageRecord.msg, 3).a();
        label269:
        if (paramInt1 != 1) {
          break label545;
        }
      }
      label545:
      for (String str1 = "";; str1 = localazmx.a(localMessageRecord.senderuin))
      {
        paramList.add(new aznc(paramString3, paramInt1, str1, i, str2, localMessageRecord.time, localMessageRecord.isSend(), paramString1, paramString2, j));
        break;
        if ((i == 2) && ((localMessageRecord instanceof MessageForPtt)) && (localazmx.a(paramInt1, 2)))
        {
          checkDownloadPtt(localQQAppInterface, localMessageRecord, false);
          paramString2 = ((MessageForPtt)localMessageRecord).getLocalFilePath();
          j = azng.a(localQQAppInterface, (MessageForPtt)localMessageRecord);
          break label269;
        }
        if ((i == 4) && (localazmx.a(paramInt1, 4)))
        {
          paramString1 = new begp(localMessageRecord.msg, 3).a();
          break label269;
        }
        if ((i == 8) && (localazmx.a(paramInt1, 8)))
        {
          paramString1 = aznc.jdField_b_of_type_JavaLangString;
          break label269;
        }
        if ((i == 16) && (localazmx.a(paramInt1, 16)))
        {
          paramString1 = aznc.c;
          break label269;
        }
        if ((i == 32) && (localazmx.a(paramInt1, 32)))
        {
          paramString1 = aznc.d;
          break label269;
        }
        if ((i == 64) && (localazmx.a(paramInt1, 64)))
        {
          paramString1 = aznc.e;
          break label269;
        }
        if (!localazmx.a(paramInt1, 1073741824)) {
          break;
        }
        i = 1073741824;
        paramString1 = aznc.f;
        break label269;
      }
    }
    return 0;
  }
  
  public aznf getNickName(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (this.mLoginSucApp == null) {
      return new aznf(-1, null);
    }
    paramString1 = (azmx)this.mThirdAppMap.get(paramString1);
    if (paramString1 == null) {
      return new aznf(-2, null);
    }
    if (!paramString1.jdField_b_of_type_JavaLangString.equals(paramString2)) {
      return new aznf(-7, null);
    }
    if (!paramString1.a(8)) {
      return new aznf(-4, null);
    }
    if (!aznb.a(paramInt)) {
      return new aznf(-5, null);
    }
    paramString1 = paramString1.b(paramString3);
    if (TextUtils.isEmpty(paramString1)) {
      return new aznf(-6, null);
    }
    paramInt = azng.c(paramInt);
    return new aznf(0, bhlg.a(this.mLoginSucApp, paramString1, paramInt));
  }
  
  public List<aznf> handlePayMsgReq(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    QQAppInterface localQQAppInterface = this.mLoginSucApp;
    if (localQQAppInterface == null) {
      return handlePayMsgRsp(new aznf(paramInt, -1, paramString4));
    }
    if ((TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return handlePayMsgRsp(new aznf(paramInt, -6, paramString4));
    }
    paramString1 = azmv.a(BaseApplicationImpl.sApplication, paramString1);
    if (paramString1 == null) {
      return handlePayMsgRsp(new aznf(paramInt, -8, paramString4));
    }
    if (!paramString1.jdField_b_of_type_JavaLangString.equals(paramString2)) {
      return handlePayMsgRsp(new aznf(paramInt, -7, paramString4));
    }
    if (!azmv.a(BaseApplicationImpl.sApplication, paramString2, paramString1.c)) {
      return handlePayMsgRsp(new aznf(paramInt, -7, paramString4));
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
  
  public List<aznf> handlePayMsgRsp(aznf paramaznf)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.mPayMsgRspQueue)
    {
      if (!this.mPayMsgRspQueue.isEmpty()) {
        localArrayList.add(this.mPayMsgRspQueue.poll());
      }
    }
    this.mPayMsgRspQueue.clear();
    if (paramaznf != null) {
      localArrayList.add(paramaznf);
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
  
  public void onFileTransStatusChanged(bete parambete, int paramInt1, int paramInt2)
  {
    if (parambete.jdField_b_of_type_Int != 2) {}
    label641:
    label647:
    for (;;)
    {
      return;
      if ((paramInt1 != 2002) && (paramInt1 != 1002) && (paramInt1 != 2001) && (this.mThirdAppMap.size() != 0) && (isSDKEnable()))
      {
        Object localObject1;
        Object localObject2;
        if ((this.mSendingMsgMap.contains(Long.valueOf(parambete.jdField_b_of_type_Long))) && ((paramInt1 == 1004) || (paramInt1 == 1005) || (paramInt1 == 1003)))
        {
          localObject1 = (String)this.mSendingMsgMap.remove(Long.valueOf(parambete.jdField_b_of_type_Long));
          localObject1 = (azmx)this.mThirdAppMap.get(localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("OpenApi.Manager", 2, "onPttStateChange, thirdApp = " + localObject1 + ", status = " + paramInt1);
          }
          if (localObject1 != null)
          {
            localObject2 = new Intent("com.tencent.mobileqq.openapi.ACTION_MSG_SENDED." + ((azmx)localObject1).jdField_b_of_type_JavaLangString);
            ((Intent)localObject2).putExtra("msgid", ((azmx)localObject1).a(String.valueOf(parambete.jdField_b_of_type_Long)));
            if (paramInt1 != 1003) {
              break label595;
            }
            paramInt2 = 0;
            label229:
            ((Intent)localObject2).putExtra("rs_code", paramInt2);
            BaseApplicationImpl.sApplication.sendBroadcast((Intent)localObject2, ((azmx)localObject1).c);
          }
        }
        int i;
        if (parambete.h == 0)
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
          String str = parambete.q;
          localObject1 = this.mLoginSucApp;
          if (parambete.jdField_a_of_type_Int == 0) {}
          for (boolean bool = true;; bool = false)
          {
            paramInt1 = azng.a((QQAppInterface)localObject1, paramInt1, bool);
            if (QLog.isColorLevel()) {
              QLog.d("OpenApi.Manager", 2, "onPttStateChange, uin = " + str + ", extStatus = " + paramInt1);
            }
            Iterator localIterator = this.mThirdAppMap.values().iterator();
            localObject2 = null;
            while (localIterator.hasNext())
            {
              azmx localazmx = (azmx)localIterator.next();
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
                  localObject2 = ((QQMessageFacade)localObject2).b(str, paramInt2, parambete.jdField_b_of_type_Long);
                  if (localObject2 != null) {
                    ((Intent)localObject1).putExtra("media_path", ((MessageForPtt)localObject2).getLocalFilePath());
                  }
                }
              }
              localObject2 = localObject1;
              if (localazmx.b(i, 2))
              {
                ((Intent)localObject1).putExtra("msgid", localazmx.a(String.valueOf(parambete.jdField_b_of_type_Long)));
                ((Intent)localObject1).setAction("com.tencent.mobileqq.openapi.ACTION_MSG_STATUS_UPDATE." + localazmx.jdField_b_of_type_JavaLangString);
                BaseApplicationImpl.sApplication.sendBroadcast((Intent)localObject1, localazmx.c);
                localObject2 = localObject1;
              }
            }
            break;
            label595:
            paramInt2 = -9;
            break label229;
            if (parambete.h == 2)
            {
              paramInt2 = 3000;
              i = 2;
              break label264;
            }
            if (parambete.h != 1) {
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
        paramInt = azng.b(paramInt);
        if ((this.uinTypeFilterOfApps & paramInt) <= 0) {
          break;
        }
        Object localObject1 = null;
        Iterator localIterator = this.mThirdAppMap.values().iterator();
        while (localIterator.hasNext())
        {
          azmx localazmx = (azmx)localIterator.next();
          Object localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("uin_type", paramInt);
            ((Intent)localObject2).putExtra("is_all", paramBoolean);
            ((Intent)localObject2).putExtra("msgTime", paramLong);
          }
          localObject1 = localObject2;
          if (localazmx.c(paramInt))
          {
            ((Intent)localObject2).putExtra("uin", localazmx.a(paramString));
            ((Intent)localObject2).setAction("com.tencent.mobileqq.openapi.ACTION_MSG_READED." + localazmx.jdField_b_of_type_JavaLangString);
            BaseApplicationImpl.sApplication.sendBroadcast((Intent)localObject2, localazmx.c);
            localObject1 = localObject2;
          }
        }
      }
    }
  }
  
  public final void onPayMsgRsp(aznf paramaznf)
  {
    if (checkNeedPayAuth(paramaznf)) {}
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
          this.mPayMsgRspQueue.add(paramaznf);
          if ((this.mLoginSucApp == null) || (!isSDKEnable())) {
            break;
          }
          paramaznf = new Intent();
          paramaznf.setAction("com.tencent.mobileqq.openapi.ACTION_PAYMSG_RCV." + this.mLastGetPayCodePkgName);
          BaseApplicationImpl.sApplication.sendBroadcast(paramaznf, this.mLastGetPayCodePermission);
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
      k = azng.a(paramMessage.msgtype);
      m = azng.b(paramMessage.istroop);
    } while ((((this.msgTypeFilterOfApps & k) <= 0) && ((this.msgTypeFilterOfApps & 0x40000000) <= 0)) || ((this.uinTypeFilterOfApps & m) <= 0));
    String str1 = paramMessage.frienduin;
    String str2 = paramMessage.senderuin;
    int n = localQQAppInterface.a().a(paramMessage.frienduin, paramMessage.istroop);
    if (QLog.isColorLevel()) {
      QLog.d("OpenApi.Manager", 2, "new msg, uin = " + bhsr.e(str1));
    }
    Object localObject1 = null;
    Iterator localIterator = this.mThirdAppMap.values().iterator();
    label188:
    Object localObject2;
    int j;
    if (localIterator.hasNext())
    {
      azmx localazmx = (azmx)localIterator.next();
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("uin_type", m);
        ((Intent)localObject2).putExtra("unreadCount", n);
      }
      boolean bool = localazmx.b(m, k);
      if ((!bool) && (!localazmx.b(m))) {
        break label415;
      }
      if (!bool) {
        break label410;
      }
      j = k;
      label284:
      ((Intent)localObject2).putExtra("msg_type", j);
      ((Intent)localObject2).putExtra("uin", localazmx.a(str1));
      ((Intent)localObject2).putExtra("senderUin", localazmx.a(str2));
      ((Intent)localObject2).setAction("com.tencent.mobileqq.openapi.ACTION_NEW_MSG." + localazmx.jdField_b_of_type_JavaLangString);
      BaseApplicationImpl.sApplication.sendBroadcast((Intent)localObject2, localazmx.c);
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
    paramString1 = (azmx)this.mThirdAppMap.get(paramString1);
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
      paramString2 = ((anyw)localQQAppInterface.getManager(51)).e(paramString1);
      if ((paramString2 == null) || (!paramString2.isFriend())) {
        return -11;
      }
      paramString3 = agej.a(new Intent(BaseApplicationImpl.sApplication, SplashActivity.class), new int[] { 2 });
      paramString3.addFlags(268435456);
      paramString3.putExtra("uin", paramString1);
      paramString3.putExtra("cSpecialFlag", paramString2.cSpecialFlag);
      paramString3.putExtra("uinname", bhlg.a(paramString2));
      if ((nok.a(paramString2.cSpecialFlag)) || (bkgt.b(paramString2.cSpecialFlag)))
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
  
  public azne registerThirdApp(String paramString1, String paramString2, long paramLong, int paramInt1, int paramInt2, String paramString3)
  {
    QQAppInterface localQQAppInterface = this.mLoginSucApp;
    if (localQQAppInterface == null) {
      return new azne(-1, 0L, null);
    }
    Object localObject = (azmx)this.mThirdAppMap.get(paramString1);
    if (localObject == null)
    {
      localObject = azmv.a(BaseApplicationImpl.sApplication, paramString1);
      if (localObject == null) {
        return new azne(-8, 0L, null);
      }
      if (!((azmw)localObject).jdField_b_of_type_JavaLangString.equals(paramString2)) {
        return new azne(-7, 0L, null);
      }
      if (!azmv.a(BaseApplicationImpl.sApplication, paramString2, ((azmw)localObject).c)) {
        return new azne(-7, 0L, null);
      }
      if ((((azmw)localObject).jdField_b_of_type_Boolean) && (paramLong != ((azmw)localObject).d)) {
        return new azne(-18, ((azmw)localObject).d, null);
      }
      if ((!((azmw)localObject).jdField_b_of_type_Boolean) && (paramLong != ((azmw)localObject).jdField_b_of_type_Long)) {
        return new azne(-18, ((azmw)localObject).jdField_b_of_type_Long, null);
      }
      if (((azmw)localObject).jdField_b_of_type_Boolean) {
        azmv.a(BaseApplicationImpl.sApplication, (azmw)localObject);
      }
      paramString2 = new azmx((azmw)localObject);
      paramString2.c = paramString3;
      this.mThirdAppMap.put(paramString1, paramString2);
      paramString3 = paramString2;
    }
    while (paramLong != paramString3.a)
    {
      this.mThirdAppMap.remove(paramString1);
      resetFilters();
      return new azne(-18, paramString3.a, null);
      paramString3 = (String)localObject;
      if (!((azmx)localObject).jdField_b_of_type_JavaLangString.equals(paramString2)) {
        return new azne(-7, 0L, null);
      }
    }
    paramString3.a(paramInt1, paramInt2);
    resetFilters();
    return new azne(0, 0L, paramString3.a(localQQAppInterface.getCurrentAccountUin()));
  }
  
  public aznf sendMessage(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5)
  {
    QQAppInterface localQQAppInterface = this.mLoginSucApp;
    if (localQQAppInterface == null) {
      return new aznf(-1, null);
    }
    azmx localazmx = (azmx)this.mThirdAppMap.get(paramString1);
    if (localazmx == null) {
      return new aznf(-2, null);
    }
    if (!localazmx.jdField_b_of_type_JavaLangString.equals(paramString2)) {
      return new aznf(-7, null);
    }
    if (!localazmx.a(8)) {
      return new aznf(-4, null);
    }
    paramString3 = localazmx.b(paramString3);
    if (TextUtils.isEmpty(paramString3)) {
      return new aznf(-6, null);
    }
    long l1 = 0L;
    if (paramInt1 == 1)
    {
      paramString2 = ((anyw)localQQAppInterface.getManager(51)).e(paramString3);
      if ((paramString2 == null) || (!paramString2.isFriend())) {
        return new aznf(-11, null);
      }
      paramString2 = new SessionInfo();
      paramString2.jdField_a_of_type_JavaLangString = paramString3;
      paramString2.jdField_a_of_type_Int = 0;
      paramString2.d = bhlg.m(localQQAppInterface, paramString3);
      if (paramInt2 == 1)
      {
        if (TextUtils.isEmpty(paramString4)) {
          return new aznf(-6, null);
        }
        paramString2 = aean.a(localQQAppInterface, localQQAppInterface.getApp(), paramString2, paramString4, null, new aeau());
        if ((paramString2 == null) || (paramString2.length == 0)) {
          return new aznf(-9, null);
        }
        l1 = paramString2[(paramString2.length - 1)];
      }
      for (;;)
      {
        this.mSendingMsgMap.put(Long.valueOf(l1), paramString1);
        if (QLog.isColorLevel()) {
          QLog.d("OpenApi.Manager", 2, "send message: " + l1);
        }
        return new aznf(0, localazmx.a(String.valueOf(l1)));
        if (paramInt2 == 2)
        {
          if (TextUtils.isEmpty(paramString5)) {
            return new aznf(-6, null);
          }
          paramString3 = new File(paramString5);
          if ((!paramString3.exists()) || (paramString3.length() < 700L) || (paramString3.length() > 42000L)) {
            return new aznf(-6, null);
          }
          if (!bhoi.a(paramString5, azna.a)) {
            return new aznf(-13, null);
          }
          paramString3 = MessageForPtt.getLocalFilePath(2, berv.a(localQQAppInterface.getCurrentAccountUin(), null, 2, null));
          bhmi.d(paramString5, paramString3);
          paramString4 = aean.a(localQQAppInterface, paramString3, paramString2, -3, 0);
          ((MessageForPtt)paramString4).c2cViaOffline = true;
          l1 = paramString4.uniseq;
          long l2 = QQRecorder.a(paramString3);
          paramString5 = new Bundle();
          paramString5.putInt("DiyTextId", paramString4.vipBubbleDiyTextId);
          aean.a(localQQAppInterface, paramString2.jdField_a_of_type_Int, paramString2.jdField_a_of_type_JavaLangString, paramString3, l1, true, (int)(1000L * l2), 0, true, 0, 0, true, paramString4.vipSubBubbleId, paramString5);
        }
      }
    }
    return new aznf(-5, null);
  }
  
  public int setMessageReaded(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    QQAppInterface localQQAppInterface = this.mLoginSucApp;
    if (localQQAppInterface == null) {
      return -1;
    }
    azmx localazmx = (azmx)this.mThirdAppMap.get(paramString1);
    if (localazmx == null) {
      return -2;
    }
    if (!localazmx.jdField_b_of_type_JavaLangString.equals(paramString2)) {
      return -7;
    }
    if (!localazmx.a(16)) {
      return -4;
    }
    paramString1 = localazmx.b(paramString3);
    paramString2 = localazmx.b(paramString4);
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
    azmx localazmx = (azmx)this.mThirdAppMap.get(paramString1);
    if ((localazmx != null) && (!localazmx.jdField_b_of_type_JavaLangString.equals(paramString2))) {
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