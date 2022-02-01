package com.tencent.mobileqq.imaxad;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.aelight.camera.qqstory.api.IShortVideoGuideUtil;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentOptPopBar;
import com.tencent.mobileqq.activity.recent.data.RecentItemImaxADData;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountADFolderData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import tencent.im.c2s.imax.IMaxService.ExposureMsg;
import tencent.im.c2s.imax.IMaxService.IgnoreADMsg;
import tencent.im.c2s.imax.IMaxService.ReqBody;

public class ImaxAdPresenter
  implements Handler.Callback
{
  private static final ImaxAdPresenter a = new ImaxAdPresenter();
  private Handler b = new Handler(ThreadManager.getSubThreadLooper(), this);
  
  public static ImaxAdPresenter a()
  {
    return a;
  }
  
  /* Error */
  private void a(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_2
    //   1: astore 7
    //   3: ldc 38
    //   5: astore 8
    //   7: aload_2
    //   8: invokestatic 44	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +4 -> 15
    //   14: return
    //   15: aload 7
    //   17: astore_2
    //   18: iload_1
    //   19: iconst_1
    //   20: if_icmpne +101 -> 121
    //   23: aload 7
    //   25: astore_2
    //   26: aload 7
    //   28: ldc 46
    //   30: invokevirtual 51	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   33: ifeq +13 -> 46
    //   36: aload 7
    //   38: ldc 46
    //   40: ldc 53
    //   42: invokevirtual 57	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   45: astore_2
    //   46: aload_2
    //   47: astore 7
    //   49: aload_2
    //   50: ldc 59
    //   52: invokevirtual 51	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   55: ifeq +40 -> 95
    //   58: invokestatic 64	com/tencent/mobileqq/utils/DeviceInfoUtil:b	()Ljava/lang/String;
    //   61: astore 7
    //   63: aload 7
    //   65: invokestatic 44	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   68: ifne +13 -> 81
    //   71: aload 7
    //   73: invokestatic 70	com/tencent/open/base/MD5Utils:encodeHexStr	(Ljava/lang/String;)Ljava/lang/String;
    //   76: astore 7
    //   78: goto +7 -> 85
    //   81: ldc 72
    //   83: astore 7
    //   85: aload_2
    //   86: ldc 59
    //   88: aload 7
    //   90: invokevirtual 57	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   93: astore 7
    //   95: aload 7
    //   97: astore_2
    //   98: aload 7
    //   100: ldc 74
    //   102: invokevirtual 51	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   105: ifeq +16 -> 121
    //   108: aload 7
    //   110: ldc 74
    //   112: ldc 76
    //   114: invokestatic 70	com/tencent/open/base/MD5Utils:encodeHexStr	(Ljava/lang/String;)Ljava/lang/String;
    //   117: invokevirtual 57	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   120: astore_2
    //   121: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   124: ifeq +56 -> 180
    //   127: new 84	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   134: astore 7
    //   136: aload 7
    //   138: ldc 87
    //   140: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload 7
    //   146: iload_1
    //   147: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload 7
    //   153: ldc 96
    //   155: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload 7
    //   161: aload_2
    //   162: invokevirtual 99	java/lang/String:toString	()Ljava/lang/String;
    //   165: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: ldc 101
    //   171: iconst_2
    //   172: aload 7
    //   174: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   180: iconst_m1
    //   181: istore_3
    //   182: new 108	java/net/URL
    //   185: dup
    //   186: aload_2
    //   187: invokespecial 111	java/net/URL:<init>	(Ljava/lang/String;)V
    //   190: invokevirtual 115	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   193: checkcast 117	java/net/HttpURLConnection
    //   196: astore 7
    //   198: aload 7
    //   200: ldc 119
    //   202: invokevirtual 122	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   205: aload 7
    //   207: sipush 30000
    //   210: invokevirtual 126	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   213: aload 7
    //   215: sipush 30000
    //   218: invokevirtual 129	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   221: aload 7
    //   223: iconst_0
    //   224: invokevirtual 133	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   227: aload 7
    //   229: invokevirtual 136	java/net/HttpURLConnection:connect	()V
    //   232: aload 7
    //   234: invokevirtual 140	java/net/HttpURLConnection:getResponseCode	()I
    //   237: istore 4
    //   239: iload 4
    //   241: sipush 200
    //   244: if_icmpne +11 -> 255
    //   247: iconst_0
    //   248: istore_3
    //   249: iconst_1
    //   250: istore 5
    //   252: goto +9 -> 261
    //   255: iload 4
    //   257: istore_3
    //   258: iconst_0
    //   259: istore 5
    //   261: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   264: istore 6
    //   266: iload 6
    //   268: ifeq +66 -> 334
    //   271: new 84	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   278: astore 7
    //   280: aload 7
    //   282: ldc 142
    //   284: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload 7
    //   290: iload_3
    //   291: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload 7
    //   297: ldc 144
    //   299: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload 7
    //   305: iload 5
    //   307: invokevirtual 147	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: ldc 101
    //   313: iconst_1
    //   314: aload 7
    //   316: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: invokestatic 150	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   322: goto +12 -> 334
    //   325: astore 7
    //   327: ldc 72
    //   329: astore 8
    //   331: goto +255 -> 586
    //   334: new 152	java/util/HashMap
    //   337: dup
    //   338: invokespecial 153	java/util/HashMap:<init>	()V
    //   341: astore 7
    //   343: new 84	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   350: astore 9
    //   352: aload 9
    //   354: iload_3
    //   355: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: aload 9
    //   361: ldc 72
    //   363: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: aload 7
    //   369: ldc 155
    //   371: aload 9
    //   373: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokevirtual 159	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   379: pop
    //   380: aload 7
    //   382: ldc 161
    //   384: ldc 72
    //   386: invokevirtual 159	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   389: pop
    //   390: aload 7
    //   392: ldc 163
    //   394: aload_2
    //   395: invokevirtual 159	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   398: pop
    //   399: iload_1
    //   400: iconst_1
    //   401: if_icmpne +9 -> 410
    //   404: aload 8
    //   406: astore_2
    //   407: goto +6 -> 413
    //   410: ldc 165
    //   412: astore_2
    //   413: invokestatic 171	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   416: invokestatic 177	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   419: astore 8
    //   421: goto +138 -> 559
    //   424: astore 7
    //   426: goto +156 -> 582
    //   429: astore 7
    //   431: goto +20 -> 451
    //   434: astore 7
    //   436: ldc 72
    //   438: astore 8
    //   440: iconst_0
    //   441: istore 5
    //   443: goto +143 -> 586
    //   446: astore 7
    //   448: iconst_0
    //   449: istore 5
    //   451: aload 7
    //   453: invokevirtual 178	java/lang/Throwable:toString	()Ljava/lang/String;
    //   456: astore 8
    //   458: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   461: ifeq +11 -> 472
    //   464: ldc 101
    //   466: iconst_2
    //   467: aload 8
    //   469: invokestatic 181	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   472: new 152	java/util/HashMap
    //   475: dup
    //   476: invokespecial 153	java/util/HashMap:<init>	()V
    //   479: astore 7
    //   481: new 84	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   488: astore 9
    //   490: aload 9
    //   492: iload_3
    //   493: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: aload 9
    //   499: ldc 72
    //   501: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: pop
    //   505: aload 7
    //   507: ldc 155
    //   509: aload 9
    //   511: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   514: invokevirtual 159	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   517: pop
    //   518: aload 7
    //   520: ldc 161
    //   522: aload 8
    //   524: invokevirtual 159	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   527: pop
    //   528: aload 7
    //   530: ldc 163
    //   532: aload_2
    //   533: invokevirtual 159	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   536: pop
    //   537: iload_1
    //   538: iconst_1
    //   539: if_icmpne +9 -> 548
    //   542: ldc 38
    //   544: astore_2
    //   545: goto +6 -> 551
    //   548: ldc 165
    //   550: astore_2
    //   551: invokestatic 171	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   554: invokestatic 177	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   557: astore 8
    //   559: aload 8
    //   561: aconst_null
    //   562: aload_2
    //   563: iload 5
    //   565: lconst_0
    //   566: lconst_0
    //   567: aload 7
    //   569: ldc 72
    //   571: invokevirtual 185	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   574: return
    //   575: astore 7
    //   577: goto +9 -> 586
    //   580: astore 7
    //   582: ldc 72
    //   584: astore 8
    //   586: new 152	java/util/HashMap
    //   589: dup
    //   590: invokespecial 153	java/util/HashMap:<init>	()V
    //   593: astore 9
    //   595: new 84	java/lang/StringBuilder
    //   598: dup
    //   599: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   602: astore 10
    //   604: aload 10
    //   606: iload_3
    //   607: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   610: pop
    //   611: aload 10
    //   613: ldc 72
    //   615: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: pop
    //   619: aload 9
    //   621: ldc 155
    //   623: aload 10
    //   625: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   628: invokevirtual 159	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   631: pop
    //   632: aload 9
    //   634: ldc 161
    //   636: aload 8
    //   638: invokevirtual 159	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   641: pop
    //   642: aload 9
    //   644: ldc 163
    //   646: aload_2
    //   647: invokevirtual 159	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   650: pop
    //   651: iload_1
    //   652: iconst_1
    //   653: if_icmpne +9 -> 662
    //   656: ldc 38
    //   658: astore_2
    //   659: goto +6 -> 665
    //   662: ldc 165
    //   664: astore_2
    //   665: invokestatic 171	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   668: invokestatic 177	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   671: aconst_null
    //   672: aload_2
    //   673: iload 5
    //   675: lconst_0
    //   676: lconst_0
    //   677: aload 9
    //   679: ldc 72
    //   681: invokevirtual 185	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   684: aload 7
    //   686: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	687	0	this	ImaxAdPresenter
    //   0	687	1	paramInt	int
    //   0	687	2	paramString	String
    //   181	426	3	i	int
    //   237	19	4	j	int
    //   250	424	5	bool1	boolean
    //   264	3	6	bool2	boolean
    //   1	314	7	localObject1	Object
    //   325	1	7	localObject2	Object
    //   341	50	7	localHashMap1	HashMap
    //   424	1	7	localObject3	Object
    //   429	1	7	localThrowable1	java.lang.Throwable
    //   434	1	7	localObject4	Object
    //   446	6	7	localThrowable2	java.lang.Throwable
    //   479	89	7	localHashMap2	HashMap
    //   575	1	7	localObject5	Object
    //   580	105	7	localObject6	Object
    //   5	632	8	localObject7	Object
    //   350	328	9	localObject8	Object
    //   602	22	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   271	322	325	finally
    //   261	266	424	finally
    //   261	266	429	java/lang/Throwable
    //   271	322	429	java/lang/Throwable
    //   182	239	434	finally
    //   182	239	446	java/lang/Throwable
    //   458	472	575	finally
    //   451	458	580	finally
  }
  
  public void a(Message paramMessage)
  {
    paramMessage.setTarget(this.b);
    this.b.sendMessageDelayed(paramMessage, 1000L);
  }
  
  public void a(AdvertisementItem paramAdvertisementItem)
  {
    if (paramAdvertisementItem != null)
    {
      if (paramAdvertisementItem.g == null) {
        return;
      }
      Message localMessage = Message.obtain();
      localMessage.what = 3;
      localMessage.obj = paramAdvertisementItem.g.e;
      this.b.sendMessage(localMessage);
    }
  }
  
  public void a(AdvertisementItem paramAdvertisementItem, Activity paramActivity, AppInterface paramAppInterface)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    int i = 1;
    if ((paramActivity != null) && (paramAdvertisementItem != null))
    {
      int j = paramAdvertisementItem.g.n;
      if (j != 3) {
        if (j != 4) {
          if (j == 5) {
            break label90;
          }
        }
      }
      for (;;)
      {
        break;
        ReportController.b(null, "dc00898", "", paramAdvertisementItem.g.a, "0X8009101", "0X8009101", 0, 0, paramAdvertisementItem.g.c, "", PublicAccountAdUtil.c(), paramAdvertisementItem.g.b);
        label90:
        ReportController.b(null, "dc00898", "", paramAdvertisementItem.g.a, "0X8009100", "0X8009100", 0, 0, paramAdvertisementItem.g.c, "", PublicAccountAdUtil.c(), paramAdvertisementItem.g.b);
        if (paramAppInterface == null)
        {
          if (QLog.isColorLevel())
          {
            paramAdvertisementItem = new StringBuilder();
            paramAdvertisementItem.append("app is null : ");
            if (paramAppInterface == null) {
              bool1 = true;
            }
            paramAdvertisementItem.append(bool1);
            QLog.e("ImaxAdNetPresenter", 2, paramAdvertisementItem.toString());
          }
          return;
        }
        b(paramAdvertisementItem, paramActivity, paramAppInterface);
        break label254;
        if ((paramActivity instanceof BaseActivity))
        {
          ReportController.b(null, "dc00898", "", paramAdvertisementItem.g.a, "0X80090FE", "0X80090FE", 0, 0, paramAdvertisementItem.g.c, "", PublicAccountAdUtil.c(), paramAdvertisementItem.g.b);
          a((BaseActivity)paramActivity);
          break label254;
        }
      }
      i = 0;
      label254:
      if ((i != 0) && ((paramActivity instanceof PublicAccountAdvertisementActivity))) {
        ((PublicAccountAdvertisementActivity)paramActivity).d();
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("activity is null : ");
      if (paramActivity == null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramAppInterface.append(bool1);
      paramAppInterface.append(", item is null : ");
      bool1 = bool2;
      if (paramAdvertisementItem == null) {
        bool1 = true;
      }
      paramAppInterface.append(bool1);
      QLog.e("ImaxAdNetPresenter", 2, paramAppInterface.toString());
    }
  }
  
  public void a(AdvertisementItem paramAdvertisementItem, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    if ((paramAdvertisementItem != null) && (paramAdvertisementItem.g != null))
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if (localAppRuntime == null) {
        return;
      }
      IMaxService.ReqBody localReqBody = new IMaxService.ReqBody();
      Object localObject = paramAdvertisementItem.g.c;
      long l = Long.parseLong(localAppRuntime.getAccount());
      if (paramInt2 == 2)
      {
        paramAdvertisementItem = new IMaxService.IgnoreADMsg();
        paramAdvertisementItem.uint64_uin.set(l);
        paramAdvertisementItem.str_ad_id.set((String)localObject);
        localReqBody.msg_ignoreAD.set(paramAdvertisementItem);
        localReqBody.int32_type.set(2);
        paramAdvertisementItem = new NewIntent(BaseApplicationImpl.getApplication(), ProtoServlet.class);
        paramQQAppInterface = new ImaxAdPresenter.IMaxServiceObserver(this, paramInt1);
        paramQQAppInterface.mType = 2;
        paramAdvertisementItem.putExtra("cmd", "iMaxServiceSvc.IgnoreADMsg");
        paramAdvertisementItem.putExtra("data", localReqBody.toByteArray());
        paramAdvertisementItem.putExtra("isResend", false);
        paramAdvertisementItem.setObserver(paramQQAppInterface);
        localAppRuntime.startServlet(paramAdvertisementItem);
        return;
      }
      if (paramInt2 == 1)
      {
        IMaxService.ExposureMsg localExposureMsg = new IMaxService.ExposureMsg();
        localExposureMsg.str_ad_id.set((String)localObject);
        localExposureMsg.uint64_uin.set(l);
        localExposureMsg.uint32_action_type.set(1);
        localReqBody.msg_exposure.set(localExposureMsg);
        localReqBody.int32_type.set(1);
        localObject = new NewIntent(BaseApplicationImpl.getApplication(), ProtoServlet.class);
        paramAdvertisementItem = new ImaxAdPresenter.IMaxServiceObserver(this, paramAdvertisementItem, paramQQAppInterface);
        paramAdvertisementItem.mType = 2;
        ((NewIntent)localObject).putExtra("cmd", "iMaxServiceSvc.ExposureADMsg");
        ((NewIntent)localObject).putExtra("data", localReqBody.toByteArray());
        ((NewIntent)localObject).putExtra("isResend", false);
        ((NewIntent)localObject).setObserver(paramAdvertisementItem);
        localAppRuntime.startServlet((NewIntent)localObject);
      }
      return;
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("doIMaxServiceRequest error ");
    paramQQAppInterface.append(paramAdvertisementItem);
    QLog.e("ImaxAdNetPresenter", 1, paramQQAppInterface.toString());
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    RecentOptPopBar.a(paramBaseActivity, 0L, 4096L, 1);
  }
  
  public void a(QQAppInterface paramQQAppInterface, AdvertisementItem paramAdvertisementItem)
  {
    if (paramAdvertisementItem != null)
    {
      ReportController.a(paramQQAppInterface, "dc00898", "", paramAdvertisementItem.g.a, "0X8009102", "0X8009102", 0, 0, paramAdvertisementItem.g.c, "", PublicAccountAdUtil.c(), paramAdvertisementItem.g.b);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ImaxAdNetPresenter", 2, "do doDel Report fail");
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, RecentAdapter paramRecentAdapter, AbsListView paramAbsListView, String paramString)
  {
    if ((paramAbsListView != null) && (paramRecentAdapter != null) && (paramQQAppInterface != null))
    {
      int j = paramAbsListView.getFirstVisiblePosition();
      int i = j;
      if (j > 0) {
        i = j - 1;
      }
      int k = paramAbsListView.getLastVisiblePosition();
      j = i;
      while (j < k + 1)
      {
        Object localObject = paramRecentAdapter.getItem(j);
        View localView = paramAbsListView.getChildAt(j - i);
        if ((localView != null) && (localObject != null) && ((localObject instanceof RecentItemImaxADData)))
        {
          localObject = (RecentItemImaxADData)localObject;
          localView.setTag(Integer.valueOf(j));
          b(paramQQAppInterface, ((RecentItemImaxADData)localObject).mUser.uin, ((RecentItemImaxADData)localObject).mUser.getType(), localView, paramString);
        }
        j += 1;
      }
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, View paramView, String paramString2)
  {
    AdvertisementRecentUserManager localAdvertisementRecentUserManager = AdvertisementRecentUserManager.a();
    AdvertisementItem localAdvertisementItem = localAdvertisementRecentUserManager.b(paramString1);
    if ((localAdvertisementItem != null) && (ImaxAdUtil.a(paramView)) && (paramString2.equals(localAdvertisementItem.d)))
    {
      paramString2 = paramQQAppInterface.getMessageFacade();
      if (paramString2 != null)
      {
        paramString1 = paramString2.h(paramString1, paramInt);
        if ((paramString1 != null) && (paramString1.size() > 0))
        {
          paramString1 = (MessageRecord)paramString1.get(paramString1.size() - 1);
          if ("false".equals(paramString1.getExtInfoFromExtStr("recent_list_advertisement_message_first_report")))
          {
            paramString1.saveExtInfoToExtStr("recent_list_advertisement_message_first_report", "true");
            ThreadManager.post(new ImaxAdPresenter.1(this, paramQQAppInterface, paramString1), 5, null, false);
            if ((localAdvertisementItem != null) && (localAdvertisementItem.g != null))
            {
              ReportController.a(paramQQAppInterface, "dc00898", "", localAdvertisementItem.g.a, "0X8008F5D", "0X8008F5D", 0, 0, localAdvertisementItem.g.c, String.valueOf(((Integer)paramView.getTag()).intValue() + 1), PublicAccountAdUtil.c(), localAdvertisementItem.g.b);
              ReportController.a(paramQQAppInterface, "dc00898", "", localAdvertisementItem.g.a, "0X8008F5C", "0X8008F5C", 0, 0, localAdvertisementItem.g.c, "", PublicAccountAdUtil.c(), localAdvertisementItem.g.b);
            }
          }
        }
      }
      if ((localAdvertisementItem != null) && (!localAdvertisementItem.f))
      {
        localAdvertisementItem.f = true;
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementRecentUserManager", 2, "do exposure Report");
        }
        a(localAdvertisementItem);
        localAdvertisementRecentUserManager.a(paramQQAppInterface, 1, localAdvertisementItem);
        if ((localAdvertisementItem != null) && (localAdvertisementItem.g != null)) {
          ReportController.a(paramQQAppInterface, "dc00898", "", localAdvertisementItem.g.a, "0X8008F5F", "0X8008F5F", 0, 0, localAdvertisementItem.g.c, "", "", localAdvertisementItem.g.b);
        }
      }
    }
  }
  
  public void b(AdvertisementItem paramAdvertisementItem)
  {
    if (paramAdvertisementItem != null)
    {
      if (paramAdvertisementItem.g == null) {
        return;
      }
      Message localMessage = Message.obtain();
      localMessage.what = 4;
      localMessage.obj = paramAdvertisementItem.g.G;
      this.b.sendMessage(localMessage);
    }
  }
  
  public void b(AdvertisementItem paramAdvertisementItem, Activity paramActivity, AppInterface paramAppInterface)
  {
    if ((!TextUtils.isEmpty(paramAdvertisementItem.g.z)) && (paramAdvertisementItem.g.y != -1))
    {
      paramAppInterface = (IShortVideoGuideUtil)QRoute.api(IShortVideoGuideUtil.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramAdvertisementItem.g.y);
      paramAppInterface.startPTVActivity(paramActivity, "1", "1", "1", "1", "1", "1", localStringBuilder.toString(), "1", 108);
    }
  }
  
  void b(QQAppInterface paramQQAppInterface, RecentAdapter paramRecentAdapter, AbsListView paramAbsListView, String paramString)
  {
    if ((paramAbsListView != null) && (paramRecentAdapter != null) && (paramQQAppInterface != null))
    {
      int j = paramAbsListView.getFirstVisiblePosition();
      int i = j;
      if (j > 0) {
        i = j - 1;
      }
      int k = paramAbsListView.getLastVisiblePosition();
      j = i;
      while (j < k + 1)
      {
        Object localObject = paramRecentAdapter.getItem(j);
        if ((localObject != null) && ((localObject instanceof RecentItemPublicAccountADFolderData)))
        {
          localObject = (RecentItemPublicAccountADFolderData)localObject;
          View localView = paramAbsListView.getChildAt(j - i);
          if (ImaxAdUtil.a(localView)) {
            a(paramQQAppInterface, ((RecentItemPublicAccountADFolderData)localObject).mUser.uin, ((RecentItemPublicAccountADFolderData)localObject).mUser.getType(), localView, paramString);
          }
        }
        j += 1;
      }
    }
  }
  
  void b(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, View paramView, String paramString2)
  {
    AdvertisementItem localAdvertisementItem = ImaxAdRecentUserManager.a().b(paramString1);
    Object localObject = localAdvertisementItem;
    if (localAdvertisementItem == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isShowImaxAdItem item recreated ");
        ((StringBuilder)localObject).append(paramString1);
        QLog.d("ImaxAdNetPresenter", 2, ((StringBuilder)localObject).toString());
      }
      localObject = AdvertisementItem.a(ImaxAdUtil.d(paramQQAppInterface.getCurrentUin(), paramString1));
      if (localObject == null)
      {
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("isShowImaxAdItem item false ");
          paramQQAppInterface.append(paramString1);
          QLog.d("ImaxAdNetPresenter", 2, paramQQAppInterface.toString());
        }
        return;
      }
      ImaxAdRecentUserManager.a().a((AdvertisementItem)localObject);
    }
    if ((localObject != null) && (ImaxAdUtil.a(paramView)) && (paramString2.equals(((AdvertisementItem)localObject).d)))
    {
      paramString2 = paramQQAppInterface.getMessageFacade();
      if (paramString2 != null)
      {
        paramString1 = paramString2.h(paramString1, paramInt);
        if ((paramString1 != null) && (paramString1.size() > 0))
        {
          paramString1 = (MessageRecord)paramString1.get(paramString1.size() - 1);
          if ("false".equals(paramString1.getExtInfoFromExtStr("recent_list_advertisement_message_first_report")))
          {
            paramString1.saveExtInfoToExtStr("recent_list_advertisement_message_first_report", "true");
            ThreadManager.post(new ImaxAdPresenter.2(this, paramQQAppInterface, paramString1), 5, null, false);
            if ((localObject != null) && (((AdvertisementItem)localObject).g != null)) {
              ReportController.a(paramQQAppInterface, "dc00898", "", ((AdvertisementItem)localObject).g.a, "0X8008F5D", "0X8008F5D", 0, 0, ((AdvertisementItem)localObject).g.c, String.valueOf(((Integer)paramView.getTag()).intValue() + 1), PublicAccountAdUtil.c(), ((AdvertisementItem)localObject).g.b);
            }
          }
        }
      }
      if ((localObject != null) && (!((AdvertisementItem)localObject).f) && (((AdvertisementItem)localObject).g != null))
      {
        if (((AdvertisementItem)localObject).a())
        {
          a((AdvertisementItem)localObject, paramQQAppInterface, -1, 1);
          ImaxAdUtil.b(paramQQAppInterface.getCurrentUin(), ((AdvertisementItem)localObject).a, ((AdvertisementItem)localObject).c());
        }
        ReportController.a(paramQQAppInterface, "dc00898", "", ((AdvertisementItem)localObject).g.a, "0X8008F5F", "0X8008F5F", 0, 0, ((AdvertisementItem)localObject).g.c, "", "", ((AdvertisementItem)localObject).g.b);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    Object localObject;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return true;
          }
          paramMessage = (String)paramMessage.obj;
          if (!TextUtils.isEmpty(paramMessage))
          {
            a(2, paramMessage);
            return true;
          }
        }
        else
        {
          paramMessage = (String)paramMessage.obj;
          if (!TextUtils.isEmpty(paramMessage))
          {
            a(1, paramMessage);
            return true;
          }
        }
      }
      else
      {
        localObject = paramMessage.getData();
        if (localObject != null)
        {
          localObject = ((Bundle)localObject).getString("key_ad_id");
          paramMessage = (HashMap)paramMessage.obj;
          a((QQAppInterface)((WeakReference)paramMessage.get("key_app")).get(), (RecentAdapter)((WeakReference)paramMessage.get("key_adapter")).get(), (AbsListView)((WeakReference)paramMessage.get("key_listview")).get(), (String)localObject);
          return true;
        }
      }
    }
    else
    {
      localObject = paramMessage.getData();
      if (localObject != null)
      {
        localObject = ((Bundle)localObject).getString("key_ad_id");
        paramMessage = (HashMap)paramMessage.obj;
        b((QQAppInterface)((WeakReference)paramMessage.get("key_app")).get(), (RecentAdapter)((WeakReference)paramMessage.get("key_adapter")).get(), (AbsListView)((WeakReference)paramMessage.get("key_listview")).get(), (String)localObject);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdPresenter
 * JD-Core Version:    0.7.0.1
 */