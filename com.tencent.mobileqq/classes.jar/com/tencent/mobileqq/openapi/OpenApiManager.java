package com.tencent.mobileqq.openapi;

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
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.openapi.entity.ThirdPartyApp;
import com.tencent.mobileqq.openapi.sdk.ApiConstants.VoiceMsg;
import com.tencent.mobileqq.openapi.sdk.ApiUtilsExt;
import com.tencent.mobileqq.openapi.sdk.MessageItem;
import com.tencent.mobileqq.openapi.sdk.QQResult.QQRegResult;
import com.tencent.mobileqq.openapi.sdk.QQResult.QQStringResult;
import com.tencent.mobileqq.openapi.utils.ApiUtilsInner;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.PttUtils;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qidian.QidianManager;
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
import org.json.JSONException;
import org.json.JSONObject;

public class OpenApiManager
{
  public static final int AUTO_CLEAR_BUFFER_SIZE = 200;
  private static final boolean DEBUG_MSG = true;
  public static final int NOTICE_BUFFER_SZIE = 50;
  private static final String TAG = "OpenApi.Manager";
  private static OpenApiManager sInstance = null;
  private String mLastGetPayCodePermission;
  private String mLastGetPayCodePkgName;
  private QQAppInterface mLoginSucApp;
  private MessageObserver mMsgObserver = new OpenApiManager.3(this);
  private final Queue<QQResult.QQStringResult> mPayMsgRspQueue = new LinkedList();
  private View mPttHolderView = null;
  private FileTransferManager.Callback mPttTransferCallback = null;
  private ConcurrentHashMap<Long, String> mSendingMsgMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ThirdPartyApp> mThirdAppMap = new ConcurrentHashMap();
  private int msgTypeFilterOfApps = 0;
  private int uinTypeFilterOfApps = 0;
  
  private void checkDownloadPtt(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    MessageForPtt localMessageForPtt;
    int i;
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForPtt)))
    {
      localMessageForPtt = (MessageForPtt)paramMessageRecord;
      i = PttItemBuilder.a(paramQQAppInterface, localMessageForPtt);
      if (i != -1) {
        break label46;
      }
      ChatActivityFacade.a(paramQQAppInterface, paramMessageRecord.frienduin, localMessageForPtt, true, 3, 0, true);
    }
    label46:
    while ((!paramBoolean) || ((i != 2005) && (i != 2004))) {
      return;
    }
    ChatActivityFacade.a(paramQQAppInterface, paramMessageRecord.frienduin, localMessageForPtt, true, 2, 0, false);
  }
  
  private void checkDownloadPtt(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong)
  {
    checkDownloadPtt(paramQQAppInterface, paramQQAppInterface.getMessageFacade().b(paramString, paramInt, paramLong), false);
  }
  
  private boolean checkNeedPayAuth(QQResult.QQStringResult paramQQStringResult)
  {
    if ((paramQQStringResult == null) || (paramQQStringResult.jdField_a_of_type_Int != 3)) {}
    for (;;)
    {
      return false;
      try
      {
        int i = new JSONObject(paramQQStringResult.jdField_a_of_type_JavaLangString).optInt("retcode");
        if (i != 10001) {
          continue;
        }
        try
        {
          paramQQStringResult = this.mLoginSucApp;
          Object localObject = new JSONObject();
          ((JSONObject)localObject).put("userId", paramQQStringResult.getCurrentAccountUin());
          ((JSONObject)localObject).put("viewTag", "showWearPayAuthor");
          ((JSONObject)localObject).put("app_info", "appInfo");
          ((JSONObject)localObject).put("come_from", 2);
          ((JSONObject)localObject).put("extra_data", "{}");
          Bundle localBundle = new Bundle();
          localBundle.putString("json", ((JSONObject)localObject).toString());
          localBundle.putString("callbackSn", "0");
          localObject = new Intent(paramQQStringResult.getApplication(), PayBridgeActivity.class);
          ((Intent)localObject).putExtras(localBundle);
          ((Intent)localObject).addFlags(268435456);
          ((Intent)localObject).putExtra("pay_requestcode", 5);
          paramQQStringResult.getApplication().startActivity((Intent)localObject);
          return true;
        }
        catch (Exception paramQQStringResult)
        {
          for (;;)
          {
            if (QLog.isDevelopLevel()) {
              paramQQStringResult.printStackTrace();
            }
          }
        }
        return false;
      }
      catch (JSONException paramQQStringResult) {}
    }
  }
  
  @Deprecated
  private void cleanupPttCallback()
  {
    this.mPttHolderView = null;
    this.mPttTransferCallback = null;
  }
  
  private MessageItem copyMsgFromMessageRecord(MessageRecord paramMessageRecord, String paramString, int paramInt)
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
      ThirdPartyApp localThirdPartyApp = (ThirdPartyApp)localIterator.next();
      j |= localThirdPartyApp.a();
      i = localThirdPartyApp.b() | i;
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
    this.mPttTransferCallback = new OpenApiManager.4(this);
    FileTransferManager.a(this.mLoginSucApp).a(this.mPttHolderView, this.mPttTransferCallback);
  }
  
  /* Error */
  public Pair<Integer, Integer> decodePtt(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 77	com/tencent/mobileqq/openapi/OpenApiManager:mLoginSucApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: astore 17
    //   6: aload 17
    //   8: ifnonnull +21 -> 29
    //   11: new 335	android/util/Pair
    //   14: dup
    //   15: iconst_m1
    //   16: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   19: iconst_0
    //   20: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   23: invokespecial 344	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   26: astore_1
    //   27: aload_1
    //   28: areturn
    //   29: aload_0
    //   30: getfield 51	com/tencent/mobileqq/openapi/OpenApiManager:mThirdAppMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   33: aload_1
    //   34: invokevirtual 348	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   37: checkcast 279	com/tencent/mobileqq/openapi/entity/ThirdPartyApp
    //   40: astore 15
    //   42: aload 15
    //   44: ifnonnull +20 -> 64
    //   47: new 335	android/util/Pair
    //   50: dup
    //   51: bipush 254
    //   53: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   56: iconst_0
    //   57: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: invokespecial 344	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   63: areturn
    //   64: aload 15
    //   66: getfield 350	com/tencent/mobileqq/openapi/entity/ThirdPartyApp:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   69: aload_2
    //   70: invokevirtual 356	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   73: ifne +20 -> 93
    //   76: new 335	android/util/Pair
    //   79: dup
    //   80: bipush 249
    //   82: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   85: iconst_0
    //   86: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   89: invokespecial 344	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   92: areturn
    //   93: aload 15
    //   95: sipush 256
    //   98: invokevirtual 359	com/tencent/mobileqq/openapi/entity/ThirdPartyApp:a	(I)Z
    //   101: ifne +20 -> 121
    //   104: new 335	android/util/Pair
    //   107: dup
    //   108: bipush 252
    //   110: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   113: iconst_0
    //   114: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   117: invokespecial 344	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   120: areturn
    //   121: aload 15
    //   123: aload_3
    //   124: invokevirtual 362	com/tencent/mobileqq/openapi/entity/ThirdPartyApp:b	(Ljava/lang/String;)Ljava/lang/String;
    //   127: astore_1
    //   128: aload 15
    //   130: aload 5
    //   132: invokevirtual 362	com/tencent/mobileqq/openapi/entity/ThirdPartyApp:b	(Ljava/lang/String;)Ljava/lang/String;
    //   135: astore_3
    //   136: lconst_0
    //   137: lstore 13
    //   139: aload_3
    //   140: invokestatic 368	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   143: lstore 11
    //   145: aload_1
    //   146: invokestatic 374	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   149: ifne +17 -> 166
    //   152: aload_3
    //   153: invokestatic 374	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   156: ifne +10 -> 166
    //   159: lload 11
    //   161: lconst_0
    //   162: lcmp
    //   163: ifne +48 -> 211
    //   166: new 335	android/util/Pair
    //   169: dup
    //   170: bipush 250
    //   172: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   175: iconst_0
    //   176: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   179: invokespecial 344	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   182: areturn
    //   183: astore_2
    //   184: lload 13
    //   186: lstore 11
    //   188: invokestatic 287	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   191: ifeq -46 -> 145
    //   194: ldc 16
    //   196: iconst_2
    //   197: ldc_w 376
    //   200: aload_2
    //   201: invokestatic 379	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   204: lload 13
    //   206: lstore 11
    //   208: goto -63 -> 145
    //   211: iload 4
    //   213: iconst_1
    //   214: if_icmpne +598 -> 812
    //   217: aload 6
    //   219: getstatic 384	com/tencent/mobileqq/app/AppConstants:SDCARD_ROOT	Ljava/lang/String;
    //   222: invokevirtual 388	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   225: ifne +31 -> 256
    //   228: aload 7
    //   230: getstatic 384	com/tencent/mobileqq/app/AppConstants:SDCARD_ROOT	Ljava/lang/String;
    //   233: invokevirtual 388	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   236: ifne +20 -> 256
    //   239: new 335	android/util/Pair
    //   242: dup
    //   243: bipush 240
    //   245: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   248: iconst_0
    //   249: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   252: invokespecial 344	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   255: areturn
    //   256: aload 6
    //   258: invokestatic 392	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   261: ifne +20 -> 281
    //   264: new 335	android/util/Pair
    //   267: dup
    //   268: bipush 246
    //   270: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   273: iconst_0
    //   274: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   277: invokespecial 344	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
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
    //   295: new 394	java/io/FileInputStream
    //   298: dup
    //   299: aload 6
    //   301: invokespecial 395	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   304: astore_1
    //   305: aload_1
    //   306: invokestatic 400	com/tencent/mobileqq/qqaudio/QQAudioUtils:a	(Ljava/io/InputStream;)B
    //   309: istore 8
    //   311: iload 8
    //   313: ifge +57 -> 370
    //   316: new 335	android/util/Pair
    //   319: dup
    //   320: bipush 251
    //   322: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   325: iconst_0
    //   326: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   329: invokespecial 344	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   332: astore_3
    //   333: aload_1
    //   334: ifnull +7 -> 341
    //   337: aload_1
    //   338: invokevirtual 403	java/io/FileInputStream:close	()V
    //   341: iconst_0
    //   342: ifeq +11 -> 353
    //   345: new 405	java/lang/NullPointerException
    //   348: dup
    //   349: invokespecial 406	java/lang/NullPointerException:<init>	()V
    //   352: athrow
    //   353: aload_3
    //   354: astore_1
    //   355: iconst_0
    //   356: ifeq -329 -> 27
    //   359: new 405	java/lang/NullPointerException
    //   362: dup
    //   363: invokespecial 406	java/lang/NullPointerException:<init>	()V
    //   366: athrow
    //   367: astore_1
    //   368: aload_3
    //   369: areturn
    //   370: aload 7
    //   372: invokestatic 409	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Ljava/io/File;
    //   375: pop
    //   376: new 411	java/io/FileOutputStream
    //   379: dup
    //   380: aload 7
    //   382: invokespecial 412	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   385: astore_3
    //   386: iload 8
    //   388: invokestatic 415	com/tencent/mobileqq/qqaudio/QQAudioUtils:a	(B)I
    //   391: istore 4
    //   393: iload 4
    //   395: invokestatic 418	com/tencent/mobileqq/qqaudio/QQAudioUtils:a	(I)I
    //   398: istore 9
    //   400: iload 9
    //   402: newarray byte
    //   404: astore 6
    //   406: iload 9
    //   408: newarray byte
    //   410: astore 7
    //   412: new 420	com/tencent/mobileqq/utils/SilkCodecWrapper
    //   415: dup
    //   416: aload 17
    //   418: invokevirtual 424	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   421: iconst_0
    //   422: invokespecial 427	com/tencent/mobileqq/utils/SilkCodecWrapper:<init>	(Landroid/content/Context;Z)V
    //   425: astore_2
    //   426: aload_2
    //   427: iload 4
    //   429: iconst_0
    //   430: iconst_1
    //   431: invokevirtual 430	com/tencent/mobileqq/utils/SilkCodecWrapper:a	(III)V
    //   434: iconst_2
    //   435: newarray byte
    //   437: astore 5
    //   439: aload_1
    //   440: aload 5
    //   442: invokevirtual 434	java/io/FileInputStream:read	([B)I
    //   445: istore 10
    //   447: iload 10
    //   449: iconst_m1
    //   450: if_icmpne +44 -> 494
    //   453: aload_1
    //   454: ifnull +7 -> 461
    //   457: aload_1
    //   458: invokevirtual 403	java/io/FileInputStream:close	()V
    //   461: aload_3
    //   462: ifnull +7 -> 469
    //   465: aload_3
    //   466: invokevirtual 435	java/io/FileOutputStream:close	()V
    //   469: aload_2
    //   470: ifnull +7 -> 477
    //   473: aload_2
    //   474: invokevirtual 437	com/tencent/mobileqq/utils/SilkCodecWrapper:a	()V
    //   477: new 335	android/util/Pair
    //   480: dup
    //   481: iconst_0
    //   482: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   485: iload 4
    //   487: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   490: invokespecial 344	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   493: areturn
    //   494: aload 5
    //   496: invokestatic 439	com/tencent/mobileqq/qqaudio/QQAudioUtils:a	([B)I
    //   499: istore 10
    //   501: iload 10
    //   503: ifgt +55 -> 558
    //   506: new 335	android/util/Pair
    //   509: dup
    //   510: bipush 241
    //   512: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   515: iconst_0
    //   516: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   519: invokespecial 344	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   522: astore 5
    //   524: aload_1
    //   525: ifnull +7 -> 532
    //   528: aload_1
    //   529: invokevirtual 403	java/io/FileInputStream:close	()V
    //   532: aload_3
    //   533: ifnull +7 -> 540
    //   536: aload_3
    //   537: invokevirtual 435	java/io/FileOutputStream:close	()V
    //   540: aload 5
    //   542: astore_1
    //   543: aload_2
    //   544: ifnull -517 -> 27
    //   547: aload_2
    //   548: invokevirtual 437	com/tencent/mobileqq/utils/SilkCodecWrapper:a	()V
    //   551: aload 5
    //   553: areturn
    //   554: astore_1
    //   555: aload 5
    //   557: areturn
    //   558: aload_1
    //   559: aload 6
    //   561: iconst_0
    //   562: iload 10
    //   564: invokevirtual 442	java/io/FileInputStream:read	([BII)I
    //   567: ifne +55 -> 622
    //   570: new 335	android/util/Pair
    //   573: dup
    //   574: bipush 241
    //   576: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   579: iconst_0
    //   580: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   583: invokespecial 344	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   586: astore 5
    //   588: aload_1
    //   589: ifnull +7 -> 596
    //   592: aload_1
    //   593: invokevirtual 403	java/io/FileInputStream:close	()V
    //   596: aload_3
    //   597: ifnull +7 -> 604
    //   600: aload_3
    //   601: invokevirtual 435	java/io/FileOutputStream:close	()V
    //   604: aload 5
    //   606: astore_1
    //   607: aload_2
    //   608: ifnull -581 -> 27
    //   611: aload_2
    //   612: invokevirtual 437	com/tencent/mobileqq/utils/SilkCodecWrapper:a	()V
    //   615: aload 5
    //   617: areturn
    //   618: astore_1
    //   619: aload 5
    //   621: areturn
    //   622: aload_2
    //   623: aload 6
    //   625: aload 7
    //   627: iload 10
    //   629: iload 9
    //   631: invokevirtual 445	com/tencent/mobileqq/utils/SilkCodecWrapper:a	([B[BII)I
    //   634: ifne +55 -> 689
    //   637: new 335	android/util/Pair
    //   640: dup
    //   641: bipush 239
    //   643: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   646: iconst_0
    //   647: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   650: invokespecial 344	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   653: astore 5
    //   655: aload_1
    //   656: ifnull +7 -> 663
    //   659: aload_1
    //   660: invokevirtual 403	java/io/FileInputStream:close	()V
    //   663: aload_3
    //   664: ifnull +7 -> 671
    //   667: aload_3
    //   668: invokevirtual 435	java/io/FileOutputStream:close	()V
    //   671: aload 5
    //   673: astore_1
    //   674: aload_2
    //   675: ifnull -648 -> 27
    //   678: aload_2
    //   679: invokevirtual 437	com/tencent/mobileqq/utils/SilkCodecWrapper:a	()V
    //   682: aload 5
    //   684: areturn
    //   685: astore_1
    //   686: aload 5
    //   688: areturn
    //   689: aload_3
    //   690: aload 7
    //   692: invokevirtual 449	java/io/FileOutputStream:write	([B)V
    //   695: goto -256 -> 439
    //   698: astore 6
    //   700: aload_2
    //   701: astore 5
    //   703: aload_3
    //   704: astore_2
    //   705: aload 6
    //   707: astore_3
    //   708: invokestatic 287	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   711: ifeq +13 -> 724
    //   714: ldc 16
    //   716: iconst_2
    //   717: ldc_w 451
    //   720: aload_3
    //   721: invokestatic 379	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   724: new 335	android/util/Pair
    //   727: dup
    //   728: bipush 244
    //   730: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   733: iload 4
    //   735: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   738: invokespecial 344	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   741: astore_3
    //   742: aload_1
    //   743: ifnull +7 -> 750
    //   746: aload_1
    //   747: invokevirtual 403	java/io/FileInputStream:close	()V
    //   750: aload_2
    //   751: ifnull +7 -> 758
    //   754: aload_2
    //   755: invokevirtual 435	java/io/FileOutputStream:close	()V
    //   758: aload_3
    //   759: astore_1
    //   760: aload 5
    //   762: ifnull -735 -> 27
    //   765: aload 5
    //   767: invokevirtual 437	com/tencent/mobileqq/utils/SilkCodecWrapper:a	()V
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
    //   789: invokevirtual 403	java/io/FileInputStream:close	()V
    //   792: aload_3
    //   793: ifnull +7 -> 800
    //   796: aload_3
    //   797: invokevirtual 435	java/io/FileOutputStream:close	()V
    //   800: aload 5
    //   802: ifnull +8 -> 810
    //   805: aload 5
    //   807: invokevirtual 437	com/tencent/mobileqq/utils/SilkCodecWrapper:a	()V
    //   810: aload_2
    //   811: athrow
    //   812: new 335	android/util/Pair
    //   815: dup
    //   816: bipush 251
    //   818: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   821: iconst_0
    //   822: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   825: invokespecial 344	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
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
    //   40	865	15	localThirdPartyApp	ThirdPartyApp
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
    paramString1 = (ThirdPartyApp)this.mThirdAppMap.get(paramString1);
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
        paramString1 = ((FriendsManager)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString2);
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
      paramString1 = localQQAppInterface.getMessageFacade().b(paramString2, ApiUtilsInner.c(paramInt), l);
      if ((paramString1 == null) || (paramString1.isSendFromLocal())) {
        return new Pair(Integer.valueOf(-14), Integer.valueOf(0));
      }
      checkDownloadPtt(localQQAppInterface, paramString1, true);
      return new Pair(Integer.valueOf(0), Integer.valueOf(ApiUtilsInner.a(localQQAppInterface, (MessageForPtt)paramString1)));
    }
    return new Pair(Integer.valueOf(-5), Integer.valueOf(0));
  }
  
  public QQResult.QQStringResult[] exchangeUins(String paramString1, String paramString2, long paramLong1, long paramLong2, String[] paramArrayOfString)
  {
    paramString2 = new QQResult.QQStringResult[1];
    paramString2[0] = new QQResult.QQStringResult(0, null);
    paramString1 = ThirdAppConfigHelper.a(BaseApplicationImpl.sApplication, paramString1);
    if (paramString1 == null) {
      return paramString2;
    }
    if (paramString1.d != paramLong2)
    {
      paramString2[0].b = -20;
      return paramString2;
    }
    if (paramString1.jdField_b_of_type_Long != paramLong1)
    {
      paramString2[0].b = -19;
      return paramString2;
    }
    paramString1 = new ThirdPartyApp(paramString1);
    if (!paramString1.a(4))
    {
      paramString2[0].b = -4;
      return paramString2;
    }
    paramString2 = new QQResult.QQStringResult[paramArrayOfString.length];
    int i = 0;
    for (;;)
    {
      if (i < paramArrayOfString.length)
      {
        paramString2[i] = new QQResult.QQStringResult(0, null);
        try
        {
          paramString2[i].jdField_a_of_type_JavaLangString = paramString1.a(paramString1.c(paramArrayOfString[i]));
          Object localObject = paramString2[i];
          if (TextUtils.isEmpty(paramString2[i].jdField_a_of_type_JavaLangString))
          {
            j = -6;
            localObject.b = j;
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
  
  public QQResult.QQStringResult getAvatarPath(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    QQAppInterface localQQAppInterface = this.mLoginSucApp;
    if (localQQAppInterface == null) {
      return new QQResult.QQStringResult(-1, null);
    }
    paramString1 = (ThirdPartyApp)this.mThirdAppMap.get(paramString1);
    if (paramString1 == null) {
      return new QQResult.QQStringResult(-2, null);
    }
    if (!paramString1.jdField_b_of_type_JavaLangString.equals(paramString2)) {
      return new QQResult.QQStringResult(-7, null);
    }
    if (!paramString1.a(4)) {
      return new QQResult.QQStringResult(-4, null);
    }
    paramString1 = paramString1.b(paramString3);
    if (TextUtils.isEmpty(paramString1)) {
      return new QQResult.QQStringResult(-6, null);
    }
    int i = 1;
    if (paramInt == 2) {
      i = 101;
    }
    for (;;)
    {
      return new QQResult.QQStringResult(0, localQQAppInterface.getCustomFaceFilePath(i, paramString1, 0));
      if (paramInt == 4) {
        i = 4;
      }
    }
  }
  
  public int getLastMessages(List<MessageItem> paramList, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    QQAppInterface localQQAppInterface = this.mLoginSucApp;
    if (localQQAppInterface == null) {
      return -1;
    }
    if (!ApiUtilsExt.a(paramInt1)) {
      return -5;
    }
    ThirdPartyApp localThirdPartyApp = (ThirdPartyApp)this.mThirdAppMap.get(paramString1);
    if (localThirdPartyApp == null) {
      return -2;
    }
    if (!localThirdPartyApp.jdField_b_of_type_JavaLangString.equals(paramString2)) {
      return -7;
    }
    paramString1 = localThirdPartyApp.b(paramString3);
    if (TextUtils.isEmpty(paramString1)) {
      return -6;
    }
    if (!localThirdPartyApp.a(2)) {
      return -4;
    }
    List localList = localQQAppInterface.getMessageFacade().a(paramString1, ApiUtilsInner.c(paramInt1), paramInt2);
    MsgProxyUtils.a(paramString1, ApiUtilsInner.c(paramInt1), localList, localQQAppInterface.getMsgCache());
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
      int i = ApiUtilsInner.a(localMessageRecord.msgtype);
      String str2 = localThirdPartyApp.a(String.valueOf(localMessageRecord.uniseq));
      paramString1 = null;
      paramString2 = null;
      int j = 1007;
      if ((i == 1) && (localThirdPartyApp.a(paramInt1, 1)))
      {
        paramString1 = new QQText(localMessageRecord.msg, 3).toPlainText();
        label272:
        if (paramInt1 != 1) {
          break label548;
        }
      }
      label548:
      for (String str1 = "";; str1 = localThirdPartyApp.a(localMessageRecord.senderuin))
      {
        paramList.add(new MessageItem(paramString3, paramInt1, str1, i, str2, localMessageRecord.time, localMessageRecord.isSend(), paramString1, paramString2, j));
        break;
        if ((i == 2) && ((localMessageRecord instanceof MessageForPtt)) && (localThirdPartyApp.a(paramInt1, 2)))
        {
          checkDownloadPtt(localQQAppInterface, localMessageRecord, false);
          paramString2 = ((MessageForPtt)localMessageRecord).getLocalFilePath();
          j = ApiUtilsInner.a(localQQAppInterface, (MessageForPtt)localMessageRecord);
          break label272;
        }
        if ((i == 4) && (localThirdPartyApp.a(paramInt1, 4)))
        {
          paramString1 = new QQText(localMessageRecord.msg, 3).toPlainText();
          break label272;
        }
        if ((i == 8) && (localThirdPartyApp.a(paramInt1, 8)))
        {
          paramString1 = MessageItem.jdField_b_of_type_JavaLangString;
          break label272;
        }
        if ((i == 16) && (localThirdPartyApp.a(paramInt1, 16)))
        {
          paramString1 = MessageItem.c;
          break label272;
        }
        if ((i == 32) && (localThirdPartyApp.a(paramInt1, 32)))
        {
          paramString1 = MessageItem.d;
          break label272;
        }
        if ((i == 64) && (localThirdPartyApp.a(paramInt1, 64)))
        {
          paramString1 = MessageItem.e;
          break label272;
        }
        if (!localThirdPartyApp.a(paramInt1, 1073741824)) {
          break;
        }
        i = 1073741824;
        paramString1 = MessageItem.f;
        break label272;
      }
    }
    return 0;
  }
  
  public QQResult.QQStringResult getNickName(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (this.mLoginSucApp == null) {
      return new QQResult.QQStringResult(-1, null);
    }
    paramString1 = (ThirdPartyApp)this.mThirdAppMap.get(paramString1);
    if (paramString1 == null) {
      return new QQResult.QQStringResult(-2, null);
    }
    if (!paramString1.jdField_b_of_type_JavaLangString.equals(paramString2)) {
      return new QQResult.QQStringResult(-7, null);
    }
    if (!paramString1.a(8)) {
      return new QQResult.QQStringResult(-4, null);
    }
    if (!ApiUtilsExt.a(paramInt)) {
      return new QQResult.QQStringResult(-5, null);
    }
    paramString1 = paramString1.b(paramString3);
    if (TextUtils.isEmpty(paramString1)) {
      return new QQResult.QQStringResult(-6, null);
    }
    paramInt = ApiUtilsInner.c(paramInt);
    return new QQResult.QQStringResult(0, ContactUtils.a(this.mLoginSucApp, paramString1, paramInt));
  }
  
  public List<QQResult.QQStringResult> handlePayMsgReq(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    QQAppInterface localQQAppInterface = this.mLoginSucApp;
    if (localQQAppInterface == null) {
      return handlePayMsgRsp(new QQResult.QQStringResult(paramInt, -1, paramString4));
    }
    if ((TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return handlePayMsgRsp(new QQResult.QQStringResult(paramInt, -6, paramString4));
    }
    paramString1 = ThirdAppConfigHelper.a(BaseApplicationImpl.sApplication, paramString1);
    if (paramString1 == null) {
      return handlePayMsgRsp(new QQResult.QQStringResult(paramInt, -8, paramString4));
    }
    if (!paramString1.jdField_b_of_type_JavaLangString.equals(paramString2)) {
      return handlePayMsgRsp(new QQResult.QQStringResult(paramInt, -7, paramString4));
    }
    if (!ThirdAppConfigHelper.a(BaseApplicationImpl.sApplication, paramString2, paramString1.c)) {
      return handlePayMsgRsp(new QQResult.QQStringResult(paramInt, -7, paramString4));
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
  
  public List<QQResult.QQStringResult> handlePayMsgRsp(QQResult.QQStringResult paramQQStringResult)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.mPayMsgRspQueue)
    {
      if (!this.mPayMsgRspQueue.isEmpty()) {
        localArrayList.add(this.mPayMsgRspQueue.poll());
      }
    }
    this.mPayMsgRspQueue.clear();
    if (paramQQStringResult != null) {
      localArrayList.add(paramQQStringResult);
    }
    return localArrayList;
  }
  
  public boolean isSDKEnable()
  {
    String str2 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.openapi_switch.name(), null);
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
  
  public void onFileTransStatusChanged(FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if (paramFileMsg.fileType != 2) {}
    label641:
    label647:
    for (;;)
    {
      return;
      if ((paramInt1 != 2002) && (paramInt1 != 1002) && (paramInt1 != 2001) && (this.mThirdAppMap.size() != 0) && (isSDKEnable()))
      {
        Object localObject1;
        Object localObject2;
        if ((this.mSendingMsgMap.contains(Long.valueOf(paramFileMsg.uniseq))) && ((paramInt1 == 1004) || (paramInt1 == 1005) || (paramInt1 == 1003)))
        {
          localObject1 = (String)this.mSendingMsgMap.remove(Long.valueOf(paramFileMsg.uniseq));
          localObject1 = (ThirdPartyApp)this.mThirdAppMap.get(localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("OpenApi.Manager", 2, "onPttStateChange, thirdApp = " + localObject1 + ", status = " + paramInt1);
          }
          if (localObject1 != null)
          {
            localObject2 = new Intent("com.tencent.mobileqq.openapi.ACTION_MSG_SENDED." + ((ThirdPartyApp)localObject1).jdField_b_of_type_JavaLangString);
            ((Intent)localObject2).putExtra("msgid", ((ThirdPartyApp)localObject1).a(String.valueOf(paramFileMsg.uniseq)));
            if (paramInt1 != 1003) {
              break label595;
            }
            paramInt2 = 0;
            label229:
            ((Intent)localObject2).putExtra("rs_code", paramInt2);
            BaseApplicationImpl.sApplication.sendBroadcast((Intent)localObject2, ((ThirdPartyApp)localObject1).c);
          }
        }
        int i;
        if (paramFileMsg.uinType == 0)
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
          String str = paramFileMsg.friendUin;
          localObject1 = this.mLoginSucApp;
          if (paramFileMsg.actionType == 0) {}
          for (boolean bool = true;; bool = false)
          {
            paramInt1 = ApiUtilsInner.a((QQAppInterface)localObject1, paramInt1, bool);
            if (QLog.isColorLevel()) {
              QLog.d("OpenApi.Manager", 2, "onPttStateChange, uin = " + str + ", extStatus = " + paramInt1);
            }
            Iterator localIterator = this.mThirdAppMap.values().iterator();
            localObject2 = null;
            while (localIterator.hasNext())
            {
              ThirdPartyApp localThirdPartyApp = (ThirdPartyApp)localIterator.next();
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
                localObject2 = this.mLoginSucApp.getMessageFacade();
                if (localObject2 != null)
                {
                  localObject2 = ((QQMessageFacade)localObject2).b(str, paramInt2, paramFileMsg.uniseq);
                  if (localObject2 != null) {
                    ((Intent)localObject1).putExtra("media_path", ((MessageForPtt)localObject2).getLocalFilePath());
                  }
                }
              }
              localObject2 = localObject1;
              if (localThirdPartyApp.b(i, 2))
              {
                ((Intent)localObject1).putExtra("msgid", localThirdPartyApp.a(String.valueOf(paramFileMsg.uniseq)));
                ((Intent)localObject1).setAction("com.tencent.mobileqq.openapi.ACTION_MSG_STATUS_UPDATE." + localThirdPartyApp.jdField_b_of_type_JavaLangString);
                BaseApplicationImpl.sApplication.sendBroadcast((Intent)localObject1, localThirdPartyApp.c);
                localObject2 = localObject1;
              }
            }
            break;
            label595:
            paramInt2 = -9;
            break label229;
            if (paramFileMsg.uinType == 2)
            {
              paramInt2 = 3000;
              i = 2;
              break label264;
            }
            if (paramFileMsg.uinType != 1) {
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
        paramInt = ApiUtilsInner.b(paramInt);
        if ((this.uinTypeFilterOfApps & paramInt) <= 0) {
          break;
        }
        Object localObject1 = null;
        Iterator localIterator = this.mThirdAppMap.values().iterator();
        while (localIterator.hasNext())
        {
          ThirdPartyApp localThirdPartyApp = (ThirdPartyApp)localIterator.next();
          Object localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("uin_type", paramInt);
            ((Intent)localObject2).putExtra("is_all", paramBoolean);
            ((Intent)localObject2).putExtra("msgTime", paramLong);
          }
          localObject1 = localObject2;
          if (localThirdPartyApp.c(paramInt))
          {
            ((Intent)localObject2).putExtra("uin", localThirdPartyApp.a(paramString));
            ((Intent)localObject2).setAction("com.tencent.mobileqq.openapi.ACTION_MSG_READED." + localThirdPartyApp.jdField_b_of_type_JavaLangString);
            BaseApplicationImpl.sApplication.sendBroadcast((Intent)localObject2, localThirdPartyApp.c);
            localObject1 = localObject2;
          }
        }
      }
    }
  }
  
  public final void onPayMsgRsp(QQResult.QQStringResult paramQQStringResult)
  {
    if (checkNeedPayAuth(paramQQStringResult)) {}
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
          this.mPayMsgRspQueue.add(paramQQStringResult);
          if ((this.mLoginSucApp == null) || (!isSDKEnable())) {
            break;
          }
          paramQQStringResult = new Intent();
          paramQQStringResult.setAction("com.tencent.mobileqq.openapi.ACTION_PAYMSG_RCV." + this.mLastGetPayCodePkgName);
          BaseApplicationImpl.sApplication.sendBroadcast(paramQQStringResult, this.mLastGetPayCodePermission);
          return;
        }
        QLog.i("OpenApi.Manager", 4, "Pay rsp queue size:" + i);
      }
    }
  }
  
  public void onReceiveNewMsg(Message paramMessage)
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
      k = ApiUtilsInner.a(paramMessage.msgtype);
      m = ApiUtilsInner.b(paramMessage.istroop);
    } while ((((this.msgTypeFilterOfApps & k) <= 0) && ((this.msgTypeFilterOfApps & 0x40000000) <= 0)) || ((this.uinTypeFilterOfApps & m) <= 0));
    String str1 = paramMessage.frienduin;
    String str2 = paramMessage.senderuin;
    int n = localQQAppInterface.getConversationFacade().a(paramMessage.frienduin, paramMessage.istroop);
    if (QLog.isColorLevel()) {
      QLog.d("OpenApi.Manager", 2, "new msg, uin = " + StringUtil.e(str1));
    }
    Object localObject1 = null;
    Iterator localIterator = this.mThirdAppMap.values().iterator();
    label188:
    Object localObject2;
    int j;
    if (localIterator.hasNext())
    {
      ThirdPartyApp localThirdPartyApp = (ThirdPartyApp)localIterator.next();
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("uin_type", m);
        ((Intent)localObject2).putExtra("unreadCount", n);
      }
      boolean bool = localThirdPartyApp.b(m, k);
      if ((!bool) && (!localThirdPartyApp.b(m))) {
        break label415;
      }
      if (!bool) {
        break label410;
      }
      j = k;
      label284:
      ((Intent)localObject2).putExtra("msg_type", j);
      ((Intent)localObject2).putExtra("uin", localThirdPartyApp.a(str1));
      ((Intent)localObject2).putExtra("senderUin", localThirdPartyApp.a(str2));
      ((Intent)localObject2).setAction("com.tencent.mobileqq.openapi.ACTION_NEW_MSG." + localThirdPartyApp.jdField_b_of_type_JavaLangString);
      BaseApplicationImpl.sApplication.sendBroadcast((Intent)localObject2, localThirdPartyApp.c);
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
    paramString1 = (ThirdPartyApp)this.mThirdAppMap.get(paramString1);
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
      paramString2 = ((FriendsManager)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString1);
      if ((paramString2 == null) || (!paramString2.isFriend())) {
        return -11;
      }
      paramString3 = AIOUtils.a(new Intent(BaseApplicationImpl.sApplication, SplashActivity.class), new int[] { 2 });
      paramString3.addFlags(268435456);
      paramString3.putExtra("uin", paramString1);
      paramString3.putExtra("cSpecialFlag", paramString2.cSpecialFlag);
      paramString3.putExtra("uinname", ContactUtils.a(paramString2));
      if ((CrmUtils.a(paramString2.cSpecialFlag)) || (QidianManager.b(paramString2.cSpecialFlag)))
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
  
  public QQResult.QQRegResult registerThirdApp(String paramString1, String paramString2, long paramLong, int paramInt1, int paramInt2, String paramString3)
  {
    QQAppInterface localQQAppInterface = this.mLoginSucApp;
    if (localQQAppInterface == null) {
      return new QQResult.QQRegResult(-1, 0L, null);
    }
    Object localObject = (ThirdPartyApp)this.mThirdAppMap.get(paramString1);
    if (localObject == null)
    {
      localObject = ThirdAppConfigHelper.a(BaseApplicationImpl.sApplication, paramString1);
      if (localObject == null) {
        return new QQResult.QQRegResult(-8, 0L, null);
      }
      if (!((ThirdAppConfigHelper.ThirdAppConfig)localObject).jdField_b_of_type_JavaLangString.equals(paramString2)) {
        return new QQResult.QQRegResult(-7, 0L, null);
      }
      if (!ThirdAppConfigHelper.a(BaseApplicationImpl.sApplication, paramString2, ((ThirdAppConfigHelper.ThirdAppConfig)localObject).c)) {
        return new QQResult.QQRegResult(-7, 0L, null);
      }
      if ((((ThirdAppConfigHelper.ThirdAppConfig)localObject).jdField_b_of_type_Boolean) && (paramLong != ((ThirdAppConfigHelper.ThirdAppConfig)localObject).d)) {
        return new QQResult.QQRegResult(-18, ((ThirdAppConfigHelper.ThirdAppConfig)localObject).d, null);
      }
      if ((!((ThirdAppConfigHelper.ThirdAppConfig)localObject).jdField_b_of_type_Boolean) && (paramLong != ((ThirdAppConfigHelper.ThirdAppConfig)localObject).jdField_b_of_type_Long)) {
        return new QQResult.QQRegResult(-18, ((ThirdAppConfigHelper.ThirdAppConfig)localObject).jdField_b_of_type_Long, null);
      }
      if (((ThirdAppConfigHelper.ThirdAppConfig)localObject).jdField_b_of_type_Boolean) {
        ThirdAppConfigHelper.a(BaseApplicationImpl.sApplication, (ThirdAppConfigHelper.ThirdAppConfig)localObject);
      }
      paramString2 = new ThirdPartyApp((ThirdAppConfigHelper.ThirdAppConfig)localObject);
      paramString2.c = paramString3;
      this.mThirdAppMap.put(paramString1, paramString2);
      paramString3 = paramString2;
    }
    while (paramLong != paramString3.a)
    {
      this.mThirdAppMap.remove(paramString1);
      resetFilters();
      return new QQResult.QQRegResult(-18, paramString3.a, null);
      paramString3 = (String)localObject;
      if (!((ThirdPartyApp)localObject).jdField_b_of_type_JavaLangString.equals(paramString2)) {
        return new QQResult.QQRegResult(-7, 0L, null);
      }
    }
    paramString3.a(paramInt1, paramInt2);
    resetFilters();
    return new QQResult.QQRegResult(0, 0L, paramString3.a(localQQAppInterface.getCurrentAccountUin()));
  }
  
  public QQResult.QQStringResult sendMessage(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5)
  {
    QQAppInterface localQQAppInterface = this.mLoginSucApp;
    if (localQQAppInterface == null) {
      return new QQResult.QQStringResult(-1, null);
    }
    ThirdPartyApp localThirdPartyApp = (ThirdPartyApp)this.mThirdAppMap.get(paramString1);
    if (localThirdPartyApp == null) {
      return new QQResult.QQStringResult(-2, null);
    }
    if (!localThirdPartyApp.jdField_b_of_type_JavaLangString.equals(paramString2)) {
      return new QQResult.QQStringResult(-7, null);
    }
    if (!localThirdPartyApp.a(8)) {
      return new QQResult.QQStringResult(-4, null);
    }
    paramString3 = localThirdPartyApp.b(paramString3);
    if (TextUtils.isEmpty(paramString3)) {
      return new QQResult.QQStringResult(-6, null);
    }
    long l2 = 0L;
    if (paramInt1 == 1)
    {
      paramString2 = ((FriendsManager)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString3);
      if ((paramString2 == null) || (!paramString2.isFriend())) {
        return new QQResult.QQStringResult(-11, null);
      }
      paramString2 = new SessionInfo();
      paramString2.jdField_a_of_type_JavaLangString = paramString3;
      paramString2.jdField_a_of_type_Int = 0;
      paramString2.d = ContactUtils.m(localQQAppInterface, paramString3);
      long l1;
      if (paramInt2 == 1)
      {
        if (TextUtils.isEmpty(paramString4)) {
          return new QQResult.QQStringResult(-6, null);
        }
        paramString2 = ChatActivityFacade.a(localQQAppInterface, localQQAppInterface.getApp(), paramString2, paramString4, null, new ChatActivityFacade.SendMsgParams());
        if ((paramString2 == null) || (paramString2.length == 0)) {
          return new QQResult.QQStringResult(-9, null);
        }
        l1 = paramString2[(paramString2.length - 1)];
      }
      for (;;)
      {
        this.mSendingMsgMap.put(Long.valueOf(l1), paramString1);
        if (QLog.isColorLevel()) {
          QLog.d("OpenApi.Manager", 2, "send message: " + l1);
        }
        return new QQResult.QQStringResult(0, localThirdPartyApp.a(String.valueOf(l1)));
        l1 = l2;
        if (paramInt2 == 2)
        {
          if (TextUtils.isEmpty(paramString5)) {
            return new QQResult.QQStringResult(-6, null);
          }
          paramString3 = new File(paramString5);
          if ((!paramString3.exists()) || (paramString3.length() < 700L) || (paramString3.length() > 42000L)) {
            return new QQResult.QQStringResult(-6, null);
          }
          if (!PttUtils.a(paramString5, ApiConstants.VoiceMsg.a)) {
            return new QQResult.QQStringResult(-13, null);
          }
          paramString3 = MessageForPtt.getLocalFilePath(2, BuddyTransfileProcessor.getTransferFilePath(localQQAppInterface.getCurrentAccountUin(), null, 2, null));
          FileUtils.d(paramString5, paramString3);
          paramString4 = ChatActivityFacade.a(localQQAppInterface, paramString3, paramString2, -3, 0);
          l1 = l2;
          if (paramString4 != null)
          {
            ((MessageForPtt)paramString4).c2cViaOffline = true;
            l1 = paramString4.uniseq;
            l2 = QQRecorder.a(paramString3);
            paramString5 = new Bundle();
            paramString5.putInt("DiyTextId", paramString4.vipBubbleDiyTextId);
            ChatActivityFacade.a(localQQAppInterface, paramString2.jdField_a_of_type_Int, paramString2.jdField_a_of_type_JavaLangString, paramString3, l1, true, (int)(1000L * l2), 0, true, 0, 0, true, paramString4.vipSubBubbleId, paramString5);
          }
        }
      }
    }
    return new QQResult.QQStringResult(-5, null);
  }
  
  public int setMessageReaded(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    QQAppInterface localQQAppInterface = this.mLoginSucApp;
    if (localQQAppInterface == null) {
      return -1;
    }
    ThirdPartyApp localThirdPartyApp = (ThirdPartyApp)this.mThirdAppMap.get(paramString1);
    if (localThirdPartyApp == null) {
      return -2;
    }
    if (!localThirdPartyApp.jdField_b_of_type_JavaLangString.equals(paramString2)) {
      return -7;
    }
    if (!localThirdPartyApp.a(16)) {
      return -4;
    }
    paramString1 = localThirdPartyApp.b(paramString3);
    paramString2 = localThirdPartyApp.b(paramString4);
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
        paramString2 = localQQAppInterface.getMessageFacade();
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
    ThirdPartyApp localThirdPartyApp = (ThirdPartyApp)this.mThirdAppMap.get(paramString1);
    if ((localThirdPartyApp != null) && (!localThirdPartyApp.jdField_b_of_type_JavaLangString.equals(paramString2))) {
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