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
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
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
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.PttUtils;
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
  private static OpenApiManager sInstance;
  private String mLastGetPayCodePermission;
  private String mLastGetPayCodePkgName;
  private QQAppInterface mLoginSucApp;
  private MessageObserver mMsgObserver = new OpenApiManager.3(this);
  private final Queue<QQResult.QQStringResult> mPayMsgRspQueue = new LinkedList();
  private View mPttHolderView = null;
  private Callback mPttTransferCallback = null;
  private ConcurrentHashMap<Long, String> mSendingMsgMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ThirdPartyApp> mThirdAppMap = new ConcurrentHashMap();
  private int msgTypeFilterOfApps = 0;
  private int uinTypeFilterOfApps = 0;
  
  private void checkDownloadPtt(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForPtt)))
    {
      MessageForPtt localMessageForPtt = (MessageForPtt)paramMessageRecord;
      int i = PttItemBuilder.a(paramQQAppInterface, localMessageForPtt);
      if (i == -1)
      {
        ChatActivityFacade.a(paramQQAppInterface, paramMessageRecord.frienduin, localMessageForPtt, true, 3, 0, true);
        return;
      }
      if ((paramBoolean) && ((i == 2005) || (i == 2004))) {
        ChatActivityFacade.a(paramQQAppInterface, paramMessageRecord.frienduin, localMessageForPtt, true, 2, 0, false);
      }
    }
  }
  
  private void checkDownloadPtt(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong)
  {
    checkDownloadPtt(paramQQAppInterface, paramQQAppInterface.getMessageFacade().b(paramString, paramInt, paramLong), false);
  }
  
  private boolean checkNeedPayAuth(QQResult.QQStringResult paramQQStringResult)
  {
    if (paramQQStringResult != null) {
      if (paramQQStringResult.jdField_a_of_type_Int != 3) {
        return false;
      }
    }
    try
    {
      int i = new JSONObject(paramQQStringResult.jdField_a_of_type_JavaLangString).optInt("retcode");
      if (i != 10001) {
        return false;
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
      }
      catch (Exception paramQQStringResult)
      {
        if (QLog.isDevelopLevel()) {
          paramQQStringResult.printStackTrace();
        }
      }
      return true;
    }
    catch (JSONException paramQQStringResult) {}
    return false;
    return false;
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
    Object localObject = this.mThirdAppMap.values().iterator();
    int j = 0;
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      ThirdPartyApp localThirdPartyApp = (ThirdPartyApp)((Iterator)localObject).next();
      j |= localThirdPartyApp.a();
      i |= localThirdPartyApp.b();
    }
    this.msgTypeFilterOfApps = j;
    this.uinTypeFilterOfApps = i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("resetFilters | ");
      ((StringBuilder)localObject).append(this.msgTypeFilterOfApps);
      ((StringBuilder)localObject).append(" | ");
      ((StringBuilder)localObject).append(this.uinTypeFilterOfApps);
      QLog.d("OpenApi.Manager", 2, ((StringBuilder)localObject).toString());
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
    //   1: getfield 75	com/tencent/mobileqq/openapi/OpenApiManager:mLoginSucApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: astore 14
    //   6: iconst_0
    //   7: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10: astore 13
    //   12: aload 14
    //   14: ifnonnull +17 -> 31
    //   17: new 341	android/util/Pair
    //   20: dup
    //   21: iconst_m1
    //   22: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   25: aload 13
    //   27: invokespecial 344	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   30: areturn
    //   31: aload_0
    //   32: getfield 49	com/tencent/mobileqq/openapi/OpenApiManager:mThirdAppMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   35: aload_1
    //   36: invokevirtual 348	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   39: checkcast 279	com/tencent/mobileqq/openapi/entity/ThirdPartyApp
    //   42: astore_1
    //   43: aload_1
    //   44: ifnonnull +18 -> 62
    //   47: new 341	android/util/Pair
    //   50: dup
    //   51: bipush 254
    //   53: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   56: aload 13
    //   58: invokespecial 344	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   61: areturn
    //   62: aload_1
    //   63: getfield 350	com/tencent/mobileqq/openapi/entity/ThirdPartyApp:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   66: aload_2
    //   67: invokevirtual 356	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   70: ifne +18 -> 88
    //   73: new 341	android/util/Pair
    //   76: dup
    //   77: bipush 249
    //   79: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   82: aload 13
    //   84: invokespecial 344	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   87: areturn
    //   88: aload_1
    //   89: sipush 256
    //   92: invokevirtual 359	com/tencent/mobileqq/openapi/entity/ThirdPartyApp:a	(I)Z
    //   95: ifne +18 -> 113
    //   98: new 341	android/util/Pair
    //   101: dup
    //   102: bipush 252
    //   104: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: aload 13
    //   109: invokespecial 344	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   112: areturn
    //   113: aload_1
    //   114: aload_3
    //   115: invokevirtual 362	com/tencent/mobileqq/openapi/entity/ThirdPartyApp:b	(Ljava/lang/String;)Ljava/lang/String;
    //   118: astore_2
    //   119: aload_1
    //   120: aload 5
    //   122: invokevirtual 362	com/tencent/mobileqq/openapi/entity/ThirdPartyApp:b	(Ljava/lang/String;)Ljava/lang/String;
    //   125: astore_1
    //   126: aload_1
    //   127: invokestatic 368	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   130: lstore 11
    //   132: goto +23 -> 155
    //   135: astore_3
    //   136: invokestatic 287	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   139: ifeq +13 -> 152
    //   142: ldc 16
    //   144: iconst_2
    //   145: ldc_w 370
    //   148: aload_3
    //   149: invokestatic 373	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   152: lconst_0
    //   153: lstore 11
    //   155: aload_2
    //   156: invokestatic 379	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   159: ifne +579 -> 738
    //   162: aload_1
    //   163: invokestatic 379	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   166: ifne +572 -> 738
    //   169: lload 11
    //   171: lconst_0
    //   172: lcmp
    //   173: ifne +6 -> 179
    //   176: goto +562 -> 738
    //   179: iload 4
    //   181: iconst_1
    //   182: if_icmpne +541 -> 723
    //   185: aload 6
    //   187: getstatic 384	com/tencent/mobileqq/app/AppConstants:SDCARD_ROOT	Ljava/lang/String;
    //   190: invokevirtual 388	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   193: ifne +29 -> 222
    //   196: aload 7
    //   198: getstatic 384	com/tencent/mobileqq/app/AppConstants:SDCARD_ROOT	Ljava/lang/String;
    //   201: invokevirtual 388	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   204: ifne +18 -> 222
    //   207: new 341	android/util/Pair
    //   210: dup
    //   211: bipush 240
    //   213: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   216: aload 13
    //   218: invokespecial 344	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   221: areturn
    //   222: aload 6
    //   224: invokestatic 393	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   227: ifne +18 -> 245
    //   230: new 341	android/util/Pair
    //   233: dup
    //   234: bipush 246
    //   236: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   239: aload 13
    //   241: invokespecial 344	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   244: areturn
    //   245: aconst_null
    //   246: astore 5
    //   248: new 395	java/io/FileInputStream
    //   251: dup
    //   252: aload 6
    //   254: invokespecial 396	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   257: astore_1
    //   258: aload_1
    //   259: invokestatic 401	com/tencent/mobileqq/qqaudio/QQAudioUtils:a	(Ljava/io/InputStream;)B
    //   262: istore 8
    //   264: iload 8
    //   266: ifge +24 -> 290
    //   269: new 341	android/util/Pair
    //   272: dup
    //   273: bipush 251
    //   275: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   278: aload 13
    //   280: invokespecial 344	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   283: astore_2
    //   284: aload_1
    //   285: invokevirtual 404	java/io/FileInputStream:close	()V
    //   288: aload_2
    //   289: areturn
    //   290: aload 7
    //   292: invokestatic 408	com/tencent/mobileqq/utils/FileUtils:createFile	(Ljava/lang/String;)Ljava/io/File;
    //   295: pop
    //   296: new 410	java/io/FileOutputStream
    //   299: dup
    //   300: aload 7
    //   302: invokespecial 411	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   305: astore_3
    //   306: iload 8
    //   308: invokestatic 414	com/tencent/mobileqq/qqaudio/QQAudioUtils:a	(B)I
    //   311: istore 4
    //   313: iload 4
    //   315: invokestatic 417	com/tencent/mobileqq/qqaudio/QQAudioUtils:a	(I)I
    //   318: istore 9
    //   320: iload 9
    //   322: newarray byte
    //   324: astore_2
    //   325: iload 9
    //   327: newarray byte
    //   329: astore 5
    //   331: new 419	com/tencent/mobileqq/utils/SilkCodecWrapper
    //   334: dup
    //   335: aload 14
    //   337: invokevirtual 423	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   340: iconst_0
    //   341: invokespecial 426	com/tencent/mobileqq/utils/SilkCodecWrapper:<init>	(Landroid/content/Context;Z)V
    //   344: astore 6
    //   346: aload 6
    //   348: iload 4
    //   350: iconst_0
    //   351: iconst_1
    //   352: invokevirtual 429	com/tencent/mobileqq/utils/SilkCodecWrapper:a	(III)V
    //   355: iconst_2
    //   356: newarray byte
    //   358: astore 7
    //   360: aload_1
    //   361: aload 7
    //   363: invokevirtual 433	java/io/FileInputStream:read	([B)I
    //   366: istore 10
    //   368: iload 10
    //   370: iconst_m1
    //   371: if_icmpne +31 -> 402
    //   374: aload_1
    //   375: invokevirtual 404	java/io/FileInputStream:close	()V
    //   378: aload_3
    //   379: invokevirtual 434	java/io/FileOutputStream:close	()V
    //   382: aload 6
    //   384: invokevirtual 436	com/tencent/mobileqq/utils/SilkCodecWrapper:a	()V
    //   387: new 341	android/util/Pair
    //   390: dup
    //   391: aload 13
    //   393: iload 4
    //   395: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   398: invokespecial 344	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   401: areturn
    //   402: aload 7
    //   404: invokestatic 438	com/tencent/mobileqq/qqaudio/QQAudioUtils:a	([B)I
    //   407: istore 10
    //   409: iload 10
    //   411: ifgt +33 -> 444
    //   414: new 341	android/util/Pair
    //   417: dup
    //   418: bipush 241
    //   420: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   423: aload 13
    //   425: invokespecial 344	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   428: astore_2
    //   429: aload_1
    //   430: invokevirtual 404	java/io/FileInputStream:close	()V
    //   433: aload_3
    //   434: invokevirtual 434	java/io/FileOutputStream:close	()V
    //   437: aload 6
    //   439: invokevirtual 436	com/tencent/mobileqq/utils/SilkCodecWrapper:a	()V
    //   442: aload_2
    //   443: areturn
    //   444: aload_1
    //   445: aload_2
    //   446: iconst_0
    //   447: iload 10
    //   449: invokevirtual 441	java/io/FileInputStream:read	([BII)I
    //   452: ifne +33 -> 485
    //   455: new 341	android/util/Pair
    //   458: dup
    //   459: bipush 241
    //   461: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   464: aload 13
    //   466: invokespecial 344	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   469: astore_2
    //   470: aload_1
    //   471: invokevirtual 404	java/io/FileInputStream:close	()V
    //   474: aload_3
    //   475: invokevirtual 434	java/io/FileOutputStream:close	()V
    //   478: aload 6
    //   480: invokevirtual 436	com/tencent/mobileqq/utils/SilkCodecWrapper:a	()V
    //   483: aload_2
    //   484: areturn
    //   485: aload 6
    //   487: aload_2
    //   488: aload 5
    //   490: iload 10
    //   492: iload 9
    //   494: invokevirtual 444	com/tencent/mobileqq/utils/SilkCodecWrapper:a	([B[BII)I
    //   497: ifne +33 -> 530
    //   500: new 341	android/util/Pair
    //   503: dup
    //   504: bipush 239
    //   506: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   509: aload 13
    //   511: invokespecial 344	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   514: astore_2
    //   515: aload_1
    //   516: invokevirtual 404	java/io/FileInputStream:close	()V
    //   519: aload_3
    //   520: invokevirtual 434	java/io/FileOutputStream:close	()V
    //   523: aload 6
    //   525: invokevirtual 436	com/tencent/mobileqq/utils/SilkCodecWrapper:a	()V
    //   528: aload_2
    //   529: areturn
    //   530: aload_3
    //   531: aload 5
    //   533: invokevirtual 448	java/io/FileOutputStream:write	([B)V
    //   536: goto -176 -> 360
    //   539: astore_2
    //   540: aload_1
    //   541: astore 5
    //   543: aload 6
    //   545: astore_1
    //   546: goto +149 -> 695
    //   549: astore 5
    //   551: aload 6
    //   553: astore_2
    //   554: goto +7 -> 561
    //   557: astore 5
    //   559: aconst_null
    //   560: astore_2
    //   561: aload 5
    //   563: astore 6
    //   565: aload_1
    //   566: astore 5
    //   568: aload_2
    //   569: astore_1
    //   570: goto +61 -> 631
    //   573: astore_2
    //   574: aconst_null
    //   575: astore 6
    //   577: aload_1
    //   578: astore 5
    //   580: aload 6
    //   582: astore_1
    //   583: goto +112 -> 695
    //   586: astore_2
    //   587: goto +10 -> 597
    //   590: astore_2
    //   591: goto +15 -> 606
    //   594: astore_2
    //   595: aconst_null
    //   596: astore_3
    //   597: aload_1
    //   598: astore 5
    //   600: goto +23 -> 623
    //   603: astore_2
    //   604: aconst_null
    //   605: astore_1
    //   606: aconst_null
    //   607: astore_3
    //   608: aconst_null
    //   609: astore 6
    //   611: aload_1
    //   612: astore 5
    //   614: aload 6
    //   616: astore_1
    //   617: goto +78 -> 695
    //   620: astore_2
    //   621: aconst_null
    //   622: astore_3
    //   623: aconst_null
    //   624: astore_1
    //   625: iconst_0
    //   626: istore 4
    //   628: aload_2
    //   629: astore 6
    //   631: invokestatic 287	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   634: ifeq +14 -> 648
    //   637: ldc 16
    //   639: iconst_2
    //   640: ldc_w 450
    //   643: aload 6
    //   645: invokestatic 373	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   648: new 341	android/util/Pair
    //   651: dup
    //   652: bipush 244
    //   654: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   657: iload 4
    //   659: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   662: invokespecial 344	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   665: astore_2
    //   666: aload 5
    //   668: ifnull +8 -> 676
    //   671: aload 5
    //   673: invokevirtual 404	java/io/FileInputStream:close	()V
    //   676: aload_3
    //   677: ifnull +7 -> 684
    //   680: aload_3
    //   681: invokevirtual 434	java/io/FileOutputStream:close	()V
    //   684: aload_1
    //   685: ifnull +7 -> 692
    //   688: aload_1
    //   689: invokevirtual 436	com/tencent/mobileqq/utils/SilkCodecWrapper:a	()V
    //   692: aload_2
    //   693: areturn
    //   694: astore_2
    //   695: aload 5
    //   697: ifnull +8 -> 705
    //   700: aload 5
    //   702: invokevirtual 404	java/io/FileInputStream:close	()V
    //   705: aload_3
    //   706: ifnull +7 -> 713
    //   709: aload_3
    //   710: invokevirtual 434	java/io/FileOutputStream:close	()V
    //   713: aload_1
    //   714: ifnull +7 -> 721
    //   717: aload_1
    //   718: invokevirtual 436	com/tencent/mobileqq/utils/SilkCodecWrapper:a	()V
    //   721: aload_2
    //   722: athrow
    //   723: new 341	android/util/Pair
    //   726: dup
    //   727: bipush 251
    //   729: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   732: aload 13
    //   734: invokespecial 344	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   737: areturn
    //   738: new 341	android/util/Pair
    //   741: dup
    //   742: bipush 250
    //   744: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   747: aload 13
    //   749: invokespecial 344	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   752: areturn
    //   753: astore_1
    //   754: aload_2
    //   755: areturn
    //   756: astore_1
    //   757: goto -379 -> 378
    //   760: astore_1
    //   761: goto -379 -> 382
    //   764: astore_1
    //   765: goto -378 -> 387
    //   768: astore_1
    //   769: goto -336 -> 433
    //   772: astore_1
    //   773: goto -336 -> 437
    //   776: astore_1
    //   777: aload_2
    //   778: areturn
    //   779: astore_1
    //   780: goto -306 -> 474
    //   783: astore_1
    //   784: goto -306 -> 478
    //   787: astore_1
    //   788: aload_2
    //   789: areturn
    //   790: astore_1
    //   791: goto -272 -> 519
    //   794: astore_1
    //   795: goto -272 -> 523
    //   798: astore_1
    //   799: aload_2
    //   800: areturn
    //   801: astore 5
    //   803: goto -127 -> 676
    //   806: astore_3
    //   807: goto -123 -> 684
    //   810: astore_1
    //   811: aload_2
    //   812: areturn
    //   813: astore 5
    //   815: goto -110 -> 705
    //   818: astore_3
    //   819: goto -106 -> 713
    //   822: astore_1
    //   823: goto -102 -> 721
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	826	0	this	OpenApiManager
    //   0	826	1	paramString1	String
    //   0	826	2	paramString2	String
    //   0	826	3	paramString3	String
    //   0	826	4	paramInt	int
    //   0	826	5	paramString4	String
    //   0	826	6	paramString5	String
    //   0	826	7	paramString6	String
    //   262	45	8	b	byte
    //   318	175	9	i	int
    //   366	125	10	j	int
    //   130	40	11	l	long
    //   10	738	13	localInteger	Integer
    //   4	332	14	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   126	132	135	java/lang/Exception
    //   346	360	539	finally
    //   360	368	539	finally
    //   402	409	539	finally
    //   414	429	539	finally
    //   444	470	539	finally
    //   485	515	539	finally
    //   530	536	539	finally
    //   346	360	549	java/lang/Throwable
    //   360	368	549	java/lang/Throwable
    //   402	409	549	java/lang/Throwable
    //   414	429	549	java/lang/Throwable
    //   444	470	549	java/lang/Throwable
    //   485	515	549	java/lang/Throwable
    //   530	536	549	java/lang/Throwable
    //   313	346	557	java/lang/Throwable
    //   306	313	573	finally
    //   313	346	573	finally
    //   306	313	586	java/lang/Throwable
    //   258	264	590	finally
    //   269	284	590	finally
    //   290	306	590	finally
    //   258	264	594	java/lang/Throwable
    //   269	284	594	java/lang/Throwable
    //   290	306	594	java/lang/Throwable
    //   248	258	603	finally
    //   248	258	620	java/lang/Throwable
    //   631	648	694	finally
    //   648	666	694	finally
    //   284	288	753	java/lang/Exception
    //   374	378	756	java/lang/Exception
    //   378	382	760	java/lang/Exception
    //   382	387	764	java/lang/Throwable
    //   429	433	768	java/lang/Exception
    //   433	437	772	java/lang/Exception
    //   437	442	776	java/lang/Throwable
    //   470	474	779	java/lang/Exception
    //   474	478	783	java/lang/Exception
    //   478	483	787	java/lang/Throwable
    //   515	519	790	java/lang/Exception
    //   519	523	794	java/lang/Exception
    //   523	528	798	java/lang/Throwable
    //   671	676	801	java/lang/Exception
    //   680	684	806	java/lang/Exception
    //   688	692	810	java/lang/Throwable
    //   700	705	813	java/lang/Exception
    //   709	713	818	java/lang/Exception
    //   717	721	822	java/lang/Throwable
  }
  
  public Pair<Integer, Integer> downloadMedia(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    QQAppInterface localQQAppInterface = this.mLoginSucApp;
    Integer localInteger = Integer.valueOf(0);
    if (localQQAppInterface == null) {
      return new Pair(Integer.valueOf(-1), localInteger);
    }
    paramString1 = (ThirdPartyApp)this.mThirdAppMap.get(paramString1);
    if (paramString1 == null) {
      return new Pair(Integer.valueOf(-2), localInteger);
    }
    if (!paramString1.jdField_b_of_type_JavaLangString.equals(paramString2)) {
      return new Pair(Integer.valueOf(-7), localInteger);
    }
    if (!paramString1.a(512)) {
      return new Pair(Integer.valueOf(-4), localInteger);
    }
    paramString2 = paramString1.b(paramString3);
    paramString1 = paramString1.b(paramString4);
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1))) {
      try
      {
        long l = Long.parseLong(paramString1);
        if (paramInt == 1)
        {
          paramString1 = ((FriendsManager)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString2);
          if ((paramString1 == null) || (!paramString1.isFriend())) {
            return new Pair(Integer.valueOf(-11), localInteger);
          }
        }
        if ((paramInt != 2) && (paramInt != 1) && (paramInt != 4)) {
          return new Pair(Integer.valueOf(-5), localInteger);
        }
        paramString1 = localQQAppInterface.getMessageFacade().b(paramString2, ApiUtilsInner.c(paramInt), l);
        if ((paramString1 != null) && (!paramString1.isSendFromLocal()))
        {
          checkDownloadPtt(localQQAppInterface, paramString1, true);
          return new Pair(localInteger, Integer.valueOf(ApiUtilsInner.a(localQQAppInterface, (MessageForPtt)paramString1)));
        }
        return new Pair(Integer.valueOf(-14), localInteger);
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("OpenApi.Manager", 2, "downMedia", paramString1);
        }
        return new Pair(Integer.valueOf(-6), localInteger);
      }
    }
    return new Pair(Integer.valueOf(-6), localInteger);
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
    while (i < paramArrayOfString.length)
    {
      paramString2[i] = new QQResult.QQStringResult(0, null);
      try
      {
        paramString2[i].jdField_a_of_type_JavaLangString = paramString1.a(paramString1.c(paramArrayOfString[i]));
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("OpenApi.Manager", 2, "", localException);
        }
      }
      Object localObject = paramString2[i];
      int j;
      if (TextUtils.isEmpty(paramString2[i].jdField_a_of_type_JavaLangString)) {
        j = -6;
      } else {
        j = 0;
      }
      localObject.b = j;
      i += 1;
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
    int i = 4;
    if (!paramString1.a(4)) {
      return new QQResult.QQStringResult(-4, null);
    }
    paramString1 = paramString1.b(paramString3);
    if (TextUtils.isEmpty(paramString1)) {
      return new QQResult.QQStringResult(-6, null);
    }
    if (paramInt == 2) {
      paramInt = 101;
    } else if (paramInt == 4) {
      paramInt = i;
    } else {
      paramInt = 1;
    }
    return new QQResult.QQStringResult(0, localQQAppInterface.getCustomFaceFilePath(paramInt, paramString1, 0));
  }
  
  public int getLastMessages(List<MessageItem> paramList, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this;
    QQAppInterface localQQAppInterface = ((OpenApiManager)localObject).mLoginSucApp;
    if (localQQAppInterface == null) {
      return -1;
    }
    if (!ApiUtilsExt.a(paramInt1)) {
      return -5;
    }
    ThirdPartyApp localThirdPartyApp = (ThirdPartyApp)((OpenApiManager)localObject).mThirdAppMap.get(paramString1);
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
    paramString2 = localQQAppInterface.getMessageFacade().a(paramString1, ApiUtilsInner.c(paramInt1), paramInt2);
    MsgProxyUtils.a(paramString1, ApiUtilsInner.c(paramInt1), paramString2, localQQAppInterface.getMsgCache());
    int i = 0;
    while (i < paramString2.size())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramString2.get(i);
      while ((paramBoolean2) && (localMessageRecord.isread)) {}
      if ((localMessageRecord instanceof ChatMessage)) {
        ((ChatMessage)localMessageRecord).parse();
      }
      paramInt2 = ApiUtilsInner.a(localMessageRecord.msgtype);
      String str2 = localThirdPartyApp.a(String.valueOf(localMessageRecord.uniseq));
      if ((paramInt2 == 1) && (localThirdPartyApp.a(paramInt1, 1))) {
        paramString1 = new QQText(localMessageRecord.msg, 3).toPlainText();
      }
      int j;
      for (;;)
      {
        localObject = null;
        j = 1007;
        break label497;
        if ((paramInt2 == 2) && ((localMessageRecord instanceof MessageForPtt)) && (localThirdPartyApp.a(paramInt1, 2)))
        {
          checkDownloadPtt(localQQAppInterface, localMessageRecord, false);
          paramString1 = (MessageForPtt)localMessageRecord;
          localObject = paramString1.getLocalFilePath();
          j = ApiUtilsInner.a(localQQAppInterface, paramString1);
          paramString1 = null;
          break label497;
        }
        if ((paramInt2 == 4) && (localThirdPartyApp.a(paramInt1, 4)))
        {
          paramString1 = new QQText(localMessageRecord.msg, 3).toPlainText();
        }
        else if ((paramInt2 == 8) && (localThirdPartyApp.a(paramInt1, 8)))
        {
          paramString1 = MessageItem.jdField_b_of_type_JavaLangString;
        }
        else if ((paramInt2 == 16) && (localThirdPartyApp.a(paramInt1, 16)))
        {
          paramString1 = MessageItem.c;
        }
        else if ((paramInt2 == 32) && (localThirdPartyApp.a(paramInt1, 32)))
        {
          paramString1 = MessageItem.d;
        }
        else if ((paramInt2 == 64) && (localThirdPartyApp.a(paramInt1, 64)))
        {
          paramString1 = MessageItem.e;
        }
        else
        {
          if (!localThirdPartyApp.a(paramInt1, 1073741824)) {
            break;
          }
          paramString1 = MessageItem.f;
          paramInt2 = 1073741824;
        }
      }
      label497:
      String str1;
      if (paramInt1 == 1) {
        str1 = "";
      } else {
        str1 = localThirdPartyApp.a(localMessageRecord.senderuin);
      }
      paramList.add(new MessageItem(paramString3, paramInt1, str1, paramInt2, str2, localMessageRecord.time, localMessageRecord.isSend(), paramString1, (String)localObject, j));
      i += 1;
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
    if ((!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
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
      paramString3 = new Bundle();
      paramString3.putInt("PayInvokerId", 15);
      HashMap localHashMap = new HashMap();
      localHashMap.put("pkgName", paramString1.jdField_b_of_type_JavaLangString);
      localHashMap.put("businessType", String.valueOf(paramInt));
      localHashMap.put("reqData", paramString4);
      paramString2 = localQQAppInterface.getCurrentAccountUin();
      paramString1 = (TicketManager)localQQAppInterface.getManager(2);
      if (paramString1 != null) {
        paramString1 = paramString1.getSkey(paramString2);
      } else {
        paramString1 = "";
      }
      paramString3.putString("uin", paramString2);
      paramString3.putString("skey", paramString1);
      paramString3.putString("skey_type", "2");
      paramString3.putSerializable("map", localHashMap);
      QWalletPayBridge.launchBackground(BaseApplicationImpl.sApplication, paramString3);
      paramString1 = localQQAppInterface.getApp();
      if (Build.VERSION.SDK_INT > 10) {
        paramInt = 4;
      } else {
        paramInt = 0;
      }
      paramString1 = paramString1.getSharedPreferences("qwallet_multi", paramInt);
      if (paramString1 != null)
      {
        paramString1 = paramString1.edit();
        paramString3 = new StringBuilder();
        paramString3.append("tenwatch_req_time_prefix_");
        paramString3.append(paramString2);
        paramString1.putLong(paramString3.toString(), NetConnInfoCenter.getServerTimeMillis() / 1000L).commit();
      }
      return handlePayMsgRsp(null);
    }
    return handlePayMsgRsp(new QQResult.QQStringResult(paramInt, -6, paramString4));
  }
  
  public List<QQResult.QQStringResult> handlePayMsgRsp(QQResult.QQStringResult paramQQStringResult)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.mPayMsgRspQueue)
    {
      while (!this.mPayMsgRspQueue.isEmpty()) {
        localArrayList.add(this.mPayMsgRspQueue.poll());
      }
      this.mPayMsgRspQueue.clear();
      if (paramQQStringResult != null) {
        localArrayList.add(paramQQStringResult);
      }
      return localArrayList;
    }
    for (;;)
    {
      throw paramQQStringResult;
    }
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
    if (paramFileMsg.fileType != 2) {
      return;
    }
    if ((paramInt1 != 2002) && (paramInt1 != 1002))
    {
      if (paramInt1 == 2001) {
        return;
      }
      if (this.mThirdAppMap.size() != 0)
      {
        if (!isSDKEnable()) {
          return;
        }
        boolean bool2 = this.mSendingMsgMap.contains(Long.valueOf(paramFileMsg.uniseq));
        boolean bool1 = false;
        Object localObject1;
        Object localObject2;
        if ((bool2) && ((paramInt1 == 1004) || (paramInt1 == 1005) || (paramInt1 == 1003)))
        {
          localObject1 = (String)this.mSendingMsgMap.remove(Long.valueOf(paramFileMsg.uniseq));
          localObject1 = (ThirdPartyApp)this.mThirdAppMap.get(localObject1);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("onPttStateChange, thirdApp = ");
            ((StringBuilder)localObject2).append(localObject1);
            ((StringBuilder)localObject2).append(", status = ");
            ((StringBuilder)localObject2).append(paramInt1);
            QLog.d("OpenApi.Manager", 2, ((StringBuilder)localObject2).toString());
          }
          if (localObject1 != null)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("com.tencent.mobileqq.openapi.ACTION_MSG_SENDED.");
            ((StringBuilder)localObject2).append(((ThirdPartyApp)localObject1).jdField_b_of_type_JavaLangString);
            localObject2 = new Intent(((StringBuilder)localObject2).toString());
            ((Intent)localObject2).putExtra("msgid", ((ThirdPartyApp)localObject1).a(String.valueOf(paramFileMsg.uniseq)));
            if (paramInt1 == 1003) {
              paramInt2 = 0;
            } else {
              paramInt2 = -9;
            }
            ((Intent)localObject2).putExtra("rs_code", paramInt2);
            BaseApplicationImpl.sApplication.sendBroadcast((Intent)localObject2, ((ThirdPartyApp)localObject1).c);
          }
        }
        if (paramFileMsg.uinType == 0) {}
        for (int i = 1;; i = 0)
        {
          paramInt2 = 0;
          break;
          if (paramFileMsg.uinType == 2)
          {
            i = 2;
            paramInt2 = 3000;
            break;
          }
          if (paramFileMsg.uinType == 1)
          {
            i = 4;
            paramInt2 = 1;
            break;
          }
        }
        if (((this.msgTypeFilterOfApps & 0x2) > 0) && ((this.uinTypeFilterOfApps & i) > 0))
        {
          String str = paramFileMsg.friendUin;
          localObject1 = this.mLoginSucApp;
          if (paramFileMsg.actionType == 0) {
            bool1 = true;
          }
          paramInt1 = ApiUtilsInner.a((QQAppInterface)localObject1, paramInt1, bool1);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("onPttStateChange, uin = ");
            ((StringBuilder)localObject1).append(str);
            ((StringBuilder)localObject1).append(", extStatus = ");
            ((StringBuilder)localObject1).append(paramInt1);
            QLog.d("OpenApi.Manager", 2, ((StringBuilder)localObject1).toString());
          }
          localObject2 = null;
          Iterator localIterator = this.mThirdAppMap.values().iterator();
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
            if (paramInt1 == 1003)
            {
              localObject2 = this.mLoginSucApp;
              if (localObject2 != null)
              {
                localObject2 = ((QQAppInterface)localObject2).getMessageFacade();
                if (localObject2 != null)
                {
                  localObject2 = ((QQMessageFacade)localObject2).b(str, paramInt2, paramFileMsg.uniseq);
                  if (localObject2 != null) {
                    ((Intent)localObject1).putExtra("media_path", ((MessageForPtt)localObject2).getLocalFilePath());
                  }
                }
              }
            }
            localObject2 = localObject1;
            if (localThirdPartyApp.b(i, 2))
            {
              ((Intent)localObject1).putExtra("msgid", localThirdPartyApp.a(String.valueOf(paramFileMsg.uniseq)));
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("com.tencent.mobileqq.openapi.ACTION_MSG_STATUS_UPDATE.");
              ((StringBuilder)localObject2).append(localThirdPartyApp.jdField_b_of_type_JavaLangString);
              ((Intent)localObject1).setAction(((StringBuilder)localObject2).toString());
              BaseApplicationImpl.sApplication.sendBroadcast((Intent)localObject1, localThirdPartyApp.c);
              localObject2 = localObject1;
            }
          }
        }
      }
    }
  }
  
  public void onMessageReaded(String paramString, int paramInt, boolean paramBoolean, long paramLong)
  {
    if ((this.mThirdAppMap.size() != 0) && (this.mLoginSucApp != null))
    {
      if (!isSDKEnable()) {
        return;
      }
      if ((paramInt == 0) || (paramInt == 3000) || (paramInt == 1))
      {
        paramInt = ApiUtilsInner.b(paramInt);
        if ((this.uinTypeFilterOfApps & paramInt) > 0)
        {
          Object localObject2 = null;
          Iterator localIterator = this.mThirdAppMap.values().iterator();
          while (localIterator.hasNext())
          {
            ThirdPartyApp localThirdPartyApp = (ThirdPartyApp)localIterator.next();
            Object localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("uin_type", paramInt);
              ((Intent)localObject1).putExtra("is_all", paramBoolean);
              ((Intent)localObject1).putExtra("msgTime", paramLong);
            }
            localObject2 = localObject1;
            if (localThirdPartyApp.c(paramInt))
            {
              ((Intent)localObject1).putExtra("uin", localThirdPartyApp.a(paramString));
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("com.tencent.mobileqq.openapi.ACTION_MSG_READED.");
              ((StringBuilder)localObject2).append(localThirdPartyApp.jdField_b_of_type_JavaLangString);
              ((Intent)localObject1).setAction(((StringBuilder)localObject2).toString());
              BaseApplicationImpl.sApplication.sendBroadcast((Intent)localObject1, localThirdPartyApp.c);
              localObject2 = localObject1;
            }
          }
        }
      }
    }
  }
  
  public final void onPayMsgRsp(QQResult.QQStringResult paramQQStringResult)
  {
    if (checkNeedPayAuth(paramQQStringResult)) {
      return;
    }
    synchronized (this.mPayMsgRspQueue)
    {
      int i = this.mPayMsgRspQueue.size();
      if (i > 200)
      {
        this.mPayMsgRspQueue.clear();
      }
      else if ((i > 50) && (QLog.isDevelopLevel()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Pay rsp queue size:");
        localStringBuilder.append(i);
        QLog.i("OpenApi.Manager", 4, localStringBuilder.toString());
      }
      this.mPayMsgRspQueue.add(paramQQStringResult);
      if (this.mLoginSucApp != null)
      {
        if (!isSDKEnable()) {
          return;
        }
        paramQQStringResult = new Intent();
        ??? = new StringBuilder();
        ((StringBuilder)???).append("com.tencent.mobileqq.openapi.ACTION_PAYMSG_RCV.");
        ((StringBuilder)???).append(this.mLastGetPayCodePkgName);
        paramQQStringResult.setAction(((StringBuilder)???).toString());
        BaseApplicationImpl.sApplication.sendBroadcast(paramQQStringResult, this.mLastGetPayCodePermission);
      }
      return;
    }
  }
  
  public void onReceiveNewMsg(Message paramMessage)
  {
    QQAppInterface localQQAppInterface = this.mLoginSucApp;
    if ((this.mThirdAppMap.size() != 0) && (localQQAppInterface != null))
    {
      if (!isSDKEnable()) {
        return;
      }
      if ((paramMessage.istroop == 0) || (paramMessage.istroop == 3000) || (paramMessage.istroop == 1))
      {
        int k = ApiUtilsInner.a(paramMessage.msgtype);
        int m = ApiUtilsInner.b(paramMessage.istroop);
        int i = this.msgTypeFilterOfApps;
        if ((((i & k) > 0) || ((i & 0x40000000) > 0)) && ((this.uinTypeFilterOfApps & m) > 0))
        {
          String str1 = paramMessage.frienduin;
          String str2 = paramMessage.senderuin;
          int n = localQQAppInterface.getConversationFacade().a(paramMessage.frienduin, paramMessage.istroop);
          Object localObject1;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("new msg, uin = ");
            ((StringBuilder)localObject1).append(StringUtil.e(str1));
            QLog.d("OpenApi.Manager", 2, ((StringBuilder)localObject1).toString());
          }
          Object localObject2 = null;
          Iterator localIterator = this.mThirdAppMap.values().iterator();
          i = 0;
          while (localIterator.hasNext())
          {
            ThirdPartyApp localThirdPartyApp = (ThirdPartyApp)localIterator.next();
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("uin_type", m);
              ((Intent)localObject1).putExtra("unreadCount", n);
            }
            boolean bool = localThirdPartyApp.b(m, k);
            if ((!bool) && (!localThirdPartyApp.b(m))) {}
            for (;;)
            {
              break;
              int j;
              if (bool) {
                j = k;
              } else {
                j = 0;
              }
              ((Intent)localObject1).putExtra("msg_type", j);
              ((Intent)localObject1).putExtra("uin", localThirdPartyApp.a(str1));
              ((Intent)localObject1).putExtra("senderUin", localThirdPartyApp.a(str2));
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("com.tencent.mobileqq.openapi.ACTION_NEW_MSG.");
              ((StringBuilder)localObject2).append(localThirdPartyApp.jdField_b_of_type_JavaLangString);
              ((Intent)localObject1).setAction(((StringBuilder)localObject2).toString());
              BaseApplicationImpl.sApplication.sendBroadcast((Intent)localObject1, localThirdPartyApp.c);
              if ((paramMessage.msgtype == -2002) && (i == 0))
              {
                checkDownloadPtt(localQQAppInterface, paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
                i = 1;
              }
            }
            localObject2 = localObject1;
          }
        }
      }
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
      if ((paramString2 != null) && (paramString2.isFriend()))
      {
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
      return -11;
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
    }
    else
    {
      if (!((ThirdPartyApp)localObject).jdField_b_of_type_JavaLangString.equals(paramString2)) {
        return new QQResult.QQRegResult(-7, 0L, null);
      }
      paramString2 = (String)localObject;
    }
    if (paramLong != paramString2.a)
    {
      this.mThirdAppMap.remove(paramString1);
      resetFilters();
      return new QQResult.QQRegResult(-18, paramString2.a, null);
    }
    paramString2.a(paramInt1, paramInt2);
    resetFilters();
    return new QQResult.QQRegResult(0, 0L, paramString2.a(localQQAppInterface.getCurrentAccountUin()));
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
      if ((paramString2 != null) && (paramString2.isFriend()))
      {
        paramString2 = new SessionInfo();
        paramString2.jdField_a_of_type_JavaLangString = paramString3;
        paramString2.jdField_a_of_type_Int = 0;
        paramString2.d = ContactUtils.f(localQQAppInterface, paramString3);
        long l1;
        if (paramInt2 == 1)
        {
          if (TextUtils.isEmpty(paramString4)) {
            return new QQResult.QQStringResult(-6, null);
          }
          paramString2 = ChatActivityFacade.a(localQQAppInterface, localQQAppInterface.getApp(), paramString2, paramString4, null, new ChatActivityFacade.SendMsgParams());
          if ((paramString2 != null) && (paramString2.length != 0)) {
            l1 = paramString2[(paramString2.length - 1)];
          }
        }
        for (;;)
        {
          break;
          return new QQResult.QQStringResult(-9, null);
          l1 = l2;
          if (paramInt2 == 2)
          {
            if (TextUtils.isEmpty(paramString5)) {
              return new QQResult.QQStringResult(-6, null);
            }
            paramString3 = new File(paramString5);
            if ((paramString3.exists()) && (paramString3.length() >= 700L) && (paramString3.length() <= 42000L))
            {
              if (!PttUtils.a(paramString5, ApiConstants.VoiceMsg.a)) {
                return new QQResult.QQStringResult(-13, null);
              }
              paramString3 = MessageForPtt.getLocalFilePath(2, TransFileUtil.getTransferFilePath(localQQAppInterface.getCurrentAccountUin(), null, 2, null));
              FileUtils.copyFile(paramString5, paramString3);
              paramString4 = ChatActivityFacade.a(localQQAppInterface, paramString3, paramString2, -3, 0);
              l1 = l2;
              if (paramString4 != null)
              {
                ((MessageForPtt)paramString4).c2cViaOffline = true;
                l1 = paramString4.uniseq;
                l2 = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).getFilePlayTime(paramString3);
                paramString5 = new Bundle();
                paramString5.putInt("DiyTextId", paramString4.vipBubbleDiyTextId);
                ChatActivityFacade.a(localQQAppInterface, paramString2.jdField_a_of_type_Int, paramString2.jdField_a_of_type_JavaLangString, paramString3, l1, true, (int)(l2 * 1000L), 0, true, 0, 0, true, paramString4.vipSubBubbleId, paramString5);
              }
            }
            else
            {
              return new QQResult.QQStringResult(-6, null);
            }
          }
        }
        this.mSendingMsgMap.put(Long.valueOf(l1), paramString1);
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("send message: ");
          paramString1.append(l1);
          QLog.d("OpenApi.Manager", 2, paramString1.toString());
        }
        return new QQResult.QQStringResult(0, localThirdPartyApp.a(String.valueOf(l1)));
      }
      return new QQResult.QQStringResult(-11, null);
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
    long l;
    try
    {
      l = Long.parseLong(paramString2);
    }
    catch (Exception paramString3)
    {
      if (QLog.isColorLevel())
      {
        paramString4 = new StringBuilder();
        paramString4.append("setMsgReaded, id = ");
        paramString4.append(paramString2);
        QLog.d("OpenApi.Manager", 2, paramString4.toString(), paramString3);
      }
      l = 0L;
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (l != 0L))
    {
      if (paramInt == 1)
      {
        paramString2 = localQQAppInterface.getMessageFacade();
        paramString3 = paramString2.b(paramString1, 0, l);
        if (paramString3 == null) {
          return -14;
        }
        paramString2.a(paramString1, 0, paramString3.time);
        return 0;
      }
      return -5;
    }
    return -6;
  }
  
  public int unregisterThirdApp(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unregister, appid = ");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("OpenApi.Manager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (ThirdPartyApp)this.mThirdAppMap.get(paramString1);
    if ((localObject != null) && (!((ThirdPartyApp)localObject).jdField_b_of_type_JavaLangString.equals(paramString2))) {
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("verifyPackage ");
        localStringBuilder.append(paramString);
        QLog.e("OpenApi.Manager", 2, localStringBuilder.toString(), paramContentProvider);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.openapi.OpenApiManager
 * JD-Core Version:    0.7.0.1
 */