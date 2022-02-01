package com.tencent.mobileqq.kandian.biz.common;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyDataProvider;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.feeds.ReadInJoyFeedsMsgRecord;
import com.tencent.mobileqq.kandian.biz.reddot.ReadInJoyNotifyRedTouchInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class ReadInJoyManager
  extends Observable
  implements Manager
{
  public static String a = "ReadInJoyManager";
  private QQAppInterface b;
  private ReadInJoyManager.NotifyReceiver c;
  private SharedPreferences d;
  private HashMap<Integer, Integer> e = new HashMap();
  private ExecutorService f = Executors.newSingleThreadExecutor();
  private BusinessInfoCheckUpdate.RedTypeInfo g = null;
  private BusinessInfoCheckUpdate.AppInfo h = null;
  private CopyOnWriteArrayList<ReadInJoyNotifyRedTouchInfo> i = new CopyOnWriteArrayList();
  private int j;
  
  public ReadInJoyManager(QQAppInterface paramQQAppInterface)
  {
    int k = 14;
    this.j = 14;
    this.b = paramQQAppInterface;
    this.c = new ReadInJoyManager.NotifyReceiver(this);
    this.d = ReadInJoyHelper.a((QQAppInterface)RIJQQAppInterfaceUtil.e(), 1);
    if (((WindowManager)this.b.getApplication().getApplicationContext().getSystemService("window")).getDefaultDisplay().getWidth() > 720) {
      k = 24;
    }
    this.j = k;
    this.i.add(0, g());
    paramQQAppInterface = new IntentFilter();
    paramQQAppInterface.addAction("notify_main_feeds_msg_newfeeds_read");
    paramQQAppInterface.addAction("notify_main_feeds_msg_newcomment_read");
    paramQQAppInterface.addAction("notify_main_feeds_msg_publish_fail");
    paramQQAppInterface.addAction("notify_main_feeds_msg_republish");
    paramQQAppInterface.addAction("notify_main_new_channel_clear");
    paramQQAppInterface.addAction("notify_main_guide_clear");
    paramQQAppInterface.addAction("config_local_channel_flag");
    paramQQAppInterface.addAction("config_follow_uin");
    paramQQAppInterface.addAction("config_update_app_setting");
    paramQQAppInterface.addAction("readInJoy_video_play_real_time_report");
    paramQQAppInterface.addAction("notify_main_share_friend_video");
    paramQQAppInterface.addAction("READINJOY_VIDEO_DATA_REPORT_WITH_FANS_INFO");
    this.b.getApp().registerReceiver(this.c, paramQQAppInterface);
  }
  
  /* Error */
  @android.annotation.TargetApi(11)
  private Bundle a(Uri paramUri, int[] paramArrayOfInt, long paramLong, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 171	android/os/Bundle
    //   3: dup
    //   4: invokespecial 172	android/os/Bundle:<init>	()V
    //   7: astore 16
    //   9: getstatic 177	android/os/Build$VERSION:SDK_INT	I
    //   12: bipush 11
    //   14: if_icmpge +6 -> 20
    //   17: aload 16
    //   19: areturn
    //   20: aconst_null
    //   21: astore 15
    //   23: aconst_null
    //   24: astore 14
    //   26: iconst_0
    //   27: istore 7
    //   29: ldc 179
    //   31: astore 12
    //   33: iconst_0
    //   34: istore 6
    //   36: aload 14
    //   38: astore 11
    //   40: aload 15
    //   42: astore 10
    //   44: iload 6
    //   46: aload_2
    //   47: arraylength
    //   48: if_icmpge +151 -> 199
    //   51: aload 12
    //   53: astore 13
    //   55: iload 6
    //   57: ifle +67 -> 124
    //   60: aload 14
    //   62: astore 11
    //   64: aload 15
    //   66: astore 10
    //   68: new 181	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   75: astore 13
    //   77: aload 14
    //   79: astore 11
    //   81: aload 15
    //   83: astore 10
    //   85: aload 13
    //   87: aload 12
    //   89: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 14
    //   95: astore 11
    //   97: aload 15
    //   99: astore 10
    //   101: aload 13
    //   103: ldc 188
    //   105: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload 14
    //   111: astore 11
    //   113: aload 15
    //   115: astore 10
    //   117: aload 13
    //   119: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: astore 13
    //   124: aload 14
    //   126: astore 11
    //   128: aload 15
    //   130: astore 10
    //   132: new 181	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   139: astore 12
    //   141: aload 14
    //   143: astore 11
    //   145: aload 15
    //   147: astore 10
    //   149: aload 12
    //   151: aload 13
    //   153: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload 14
    //   159: astore 11
    //   161: aload 15
    //   163: astore 10
    //   165: aload 12
    //   167: aload_2
    //   168: iload 6
    //   170: iaload
    //   171: invokevirtual 195	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload 14
    //   177: astore 11
    //   179: aload 15
    //   181: astore 10
    //   183: aload 12
    //   185: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: astore 12
    //   190: iload 6
    //   192: iconst_1
    //   193: iadd
    //   194: istore 6
    //   196: goto -160 -> 36
    //   199: aload 14
    //   201: astore 11
    //   203: aload 15
    //   205: astore 10
    //   207: new 181	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   214: astore_2
    //   215: aload 14
    //   217: astore 11
    //   219: aload 15
    //   221: astore 10
    //   223: aload_2
    //   224: ldc 197
    //   226: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload 14
    //   232: astore 11
    //   234: aload 15
    //   236: astore 10
    //   238: aload_2
    //   239: lload_3
    //   240: invokestatic 202	java/lang/Long:toString	(J)Ljava/lang/String;
    //   243: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload 14
    //   249: astore 11
    //   251: aload 15
    //   253: astore 10
    //   255: aload_2
    //   256: ldc 204
    //   258: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload 14
    //   264: astore 11
    //   266: aload 15
    //   268: astore 10
    //   270: aload_2
    //   271: ldc 206
    //   273: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload 14
    //   279: astore 11
    //   281: aload 15
    //   283: astore 10
    //   285: aload_2
    //   286: ldc 208
    //   288: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload 14
    //   294: astore 11
    //   296: aload 15
    //   298: astore 10
    //   300: aload_2
    //   301: aload 12
    //   303: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 14
    //   309: astore 11
    //   311: aload 15
    //   313: astore 10
    //   315: aload_2
    //   316: ldc 210
    //   318: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload 14
    //   324: astore 11
    //   326: aload 15
    //   328: astore 10
    //   330: aload_2
    //   331: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: astore_2
    //   335: aload 14
    //   337: astore 11
    //   339: aload 15
    //   341: astore 10
    //   343: aload_0
    //   344: getfield 63	com/tencent/mobileqq/kandian/biz/common/ReadInJoyManager:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   347: invokevirtual 156	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   350: invokevirtual 214	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   353: aload_1
    //   354: aconst_null
    //   355: aload_2
    //   356: aconst_null
    //   357: ldc 216
    //   359: invokevirtual 222	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   362: astore_1
    //   363: aload_1
    //   364: astore 11
    //   366: aload_1
    //   367: astore 10
    //   369: aload_1
    //   370: invokeinterface 228 1 0
    //   375: ifeq +125 -> 500
    //   378: aload_1
    //   379: astore 11
    //   381: aload_1
    //   382: astore 10
    //   384: aload 5
    //   386: arraylength
    //   387: istore 8
    //   389: iload 7
    //   391: istore 6
    //   393: iload 6
    //   395: iload 8
    //   397: if_icmpge +103 -> 500
    //   400: aload 5
    //   402: iload 6
    //   404: aaload
    //   405: astore_2
    //   406: aload_1
    //   407: astore 11
    //   409: aload_1
    //   410: astore 10
    //   412: aload_1
    //   413: aload_2
    //   414: invokeinterface 232 2 0
    //   419: istore 7
    //   421: iload 7
    //   423: iflt +154 -> 577
    //   426: aload_1
    //   427: astore 11
    //   429: aload_1
    //   430: astore 10
    //   432: aload_1
    //   433: iload 7
    //   435: invokeinterface 236 2 0
    //   440: istore 9
    //   442: iload 9
    //   444: iconst_1
    //   445: if_icmpne +26 -> 471
    //   448: aload_1
    //   449: astore 11
    //   451: aload_1
    //   452: astore 10
    //   454: aload 16
    //   456: aload_2
    //   457: aload_1
    //   458: iload 7
    //   460: invokeinterface 240 2 0
    //   465: invokevirtual 244	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   468: goto +109 -> 577
    //   471: iload 9
    //   473: iconst_3
    //   474: if_icmpne +103 -> 577
    //   477: aload_1
    //   478: astore 11
    //   480: aload_1
    //   481: astore 10
    //   483: aload 16
    //   485: aload_2
    //   486: aload_1
    //   487: iload 7
    //   489: invokeinterface 248 2 0
    //   494: invokevirtual 252	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   497: goto +80 -> 577
    //   500: aload_1
    //   501: astore 11
    //   503: aload_1
    //   504: astore 10
    //   506: aload 16
    //   508: ldc 254
    //   510: aload_1
    //   511: invokeinterface 257 1 0
    //   516: i2l
    //   517: invokevirtual 244	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   520: aload_1
    //   521: ifnull +33 -> 554
    //   524: goto +24 -> 548
    //   527: astore_1
    //   528: goto +29 -> 557
    //   531: astore_1
    //   532: aload 10
    //   534: astore 11
    //   536: aload_1
    //   537: invokevirtual 260	java/lang/Exception:printStackTrace	()V
    //   540: aload 10
    //   542: ifnull +12 -> 554
    //   545: aload 10
    //   547: astore_1
    //   548: aload_1
    //   549: invokeinterface 263 1 0
    //   554: aload 16
    //   556: areturn
    //   557: aload 11
    //   559: ifnull +10 -> 569
    //   562: aload 11
    //   564: invokeinterface 263 1 0
    //   569: goto +5 -> 574
    //   572: aload_1
    //   573: athrow
    //   574: goto -2 -> 572
    //   577: iload 6
    //   579: iconst_1
    //   580: iadd
    //   581: istore 6
    //   583: goto -190 -> 393
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	586	0	this	ReadInJoyManager
    //   0	586	1	paramUri	Uri
    //   0	586	2	paramArrayOfInt	int[]
    //   0	586	3	paramLong	long
    //   0	586	5	paramArrayOfString	String[]
    //   34	548	6	k	int
    //   27	461	7	m	int
    //   387	11	8	n	int
    //   440	35	9	i1	int
    //   42	504	10	localObject1	Object
    //   38	525	11	localObject2	Object
    //   31	271	12	localObject3	Object
    //   53	99	13	localObject4	Object
    //   24	312	14	localObject5	Object
    //   21	319	15	localObject6	Object
    //   7	548	16	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   44	51	527	finally
    //   68	77	527	finally
    //   85	93	527	finally
    //   101	109	527	finally
    //   117	124	527	finally
    //   132	141	527	finally
    //   149	157	527	finally
    //   165	175	527	finally
    //   183	190	527	finally
    //   207	215	527	finally
    //   223	230	527	finally
    //   238	247	527	finally
    //   255	262	527	finally
    //   270	277	527	finally
    //   285	292	527	finally
    //   300	307	527	finally
    //   315	322	527	finally
    //   330	335	527	finally
    //   343	363	527	finally
    //   369	378	527	finally
    //   384	389	527	finally
    //   412	421	527	finally
    //   432	442	527	finally
    //   454	468	527	finally
    //   483	497	527	finally
    //   506	520	527	finally
    //   536	540	527	finally
    //   44	51	531	java/lang/Exception
    //   68	77	531	java/lang/Exception
    //   85	93	531	java/lang/Exception
    //   101	109	531	java/lang/Exception
    //   117	124	531	java/lang/Exception
    //   132	141	531	java/lang/Exception
    //   149	157	531	java/lang/Exception
    //   165	175	531	java/lang/Exception
    //   183	190	531	java/lang/Exception
    //   207	215	531	java/lang/Exception
    //   223	230	531	java/lang/Exception
    //   238	247	531	java/lang/Exception
    //   255	262	531	java/lang/Exception
    //   270	277	531	java/lang/Exception
    //   285	292	531	java/lang/Exception
    //   300	307	531	java/lang/Exception
    //   315	322	531	java/lang/Exception
    //   330	335	531	java/lang/Exception
    //   343	363	531	java/lang/Exception
    //   369	378	531	java/lang/Exception
    //   384	389	531	java/lang/Exception
    //   412	421	531	java/lang/Exception
    //   432	442	531	java/lang/Exception
    //   454	468	531	java/lang/Exception
    //   483	497	531	java/lang/Exception
    //   506	520	531	java/lang/Exception
  }
  
  private boolean a(Uri paramUri, ReadInJoyFeedsMsgRecord paramReadInJoyFeedsMsgRecord, long paramLong)
  {
    Object localObject = new ContentValues();
    ((ContentValues)localObject).put("pushTime", Integer.valueOf(paramReadInJoyFeedsMsgRecord.a));
    ((ContentValues)localObject).put("notifyType", Integer.valueOf(paramReadInJoyFeedsMsgRecord.c));
    ((ContentValues)localObject).put("feedsOwner", Long.valueOf(paramReadInJoyFeedsMsgRecord.d));
    ((ContentValues)localObject).put("feedsID", Long.valueOf(paramReadInJoyFeedsMsgRecord.e));
    ((ContentValues)localObject).put("feedsSubject", paramReadInJoyFeedsMsgRecord.f);
    ((ContentValues)localObject).put("deleteUin", Long.valueOf(paramReadInJoyFeedsMsgRecord.m));
    ((ContentValues)localObject).put("publishFail", Integer.valueOf(paramReadInJoyFeedsMsgRecord.n));
    ((ContentValues)localObject).put("likeUin", Long.valueOf(paramReadInJoyFeedsMsgRecord.l));
    ((ContentValues)localObject).put("commentUin", Long.valueOf(paramReadInJoyFeedsMsgRecord.g));
    ((ContentValues)localObject).put("commentID", paramReadInJoyFeedsMsgRecord.h);
    ((ContentValues)localObject).put("replyUin", Long.valueOf(paramReadInJoyFeedsMsgRecord.i));
    ((ContentValues)localObject).put("replyID", paramReadInJoyFeedsMsgRecord.j);
    ((ContentValues)localObject).put("commentInfo", paramReadInJoyFeedsMsgRecord.k);
    ((ContentValues)localObject).put("receiveTime", Long.valueOf(paramReadInJoyFeedsMsgRecord.o));
    ((ContentValues)localObject).put("processSeq", Long.valueOf(paramLong));
    if (this.b.getApp().getContentResolver().insert(paramUri, (ContentValues)localObject) == null)
    {
      if (QLog.isColorLevel())
      {
        paramUri = a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handlePushedFeedsMsgRecords, insertMsgRecordToFeedsTable failed, feedID=");
        ((StringBuilder)localObject).append(paramReadInJoyFeedsMsgRecord.e);
        ((StringBuilder)localObject).append(", commentID=");
        ((StringBuilder)localObject).append(paramReadInJoyFeedsMsgRecord.h);
        QLog.d(paramUri, 2, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    return true;
  }
  
  private long d()
  {
    Object localObject = this.d;
    if (localObject == null) {
      return 0L;
    }
    long l = ((SharedPreferences)localObject).getLong("config_feeds_process_seq", 0L) + 1L;
    localObject = this.d.edit();
    ((SharedPreferences.Editor)localObject).putLong("config_feeds_process_seq", l);
    RIJSPUtils.a((SharedPreferences.Editor)localObject, true);
    return l;
  }
  
  private void e()
  {
    Object localObject1 = this.d;
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((SharedPreferences)localObject1).edit();
    Object localObject2 = ReadInJoyDataProvider.c.buildUpon();
    ((Uri.Builder)localObject2).appendQueryParameter("uin", this.b.getAccount());
    localObject2 = ((Uri.Builder)localObject2).build();
    long l1 = this.d.getLong("config_feeds_newfeeds_leba_read_id", 0L);
    Bundle localBundle = a((Uri)localObject2, new int[] { 10 }, l1, new String[] { "_id", "feedsOwner" });
    long l2 = localBundle.getLong("unread");
    if (l2 > 0L)
    {
      l3 = localBundle.getLong("_id");
      l1 = localBundle.getLong("feedsOwner");
      ((SharedPreferences.Editor)localObject1).putLong("config_feeds_newfeeds_leba_max_id", l3);
    }
    else
    {
      l1 = 0L;
    }
    ((SharedPreferences.Editor)localObject1).putLong("config_feeds_newfeeds_leba_unread_count", l2);
    ((SharedPreferences.Editor)localObject1).putLong("config_feeds_newfeeds_leba_latest_owner", l1);
    ((SharedPreferences.Editor)localObject1).putLong("config_feeds_newfeeds_leba_updated_time", NetConnInfoCenter.getServerTime());
    l1 = this.d.getLong("config_feeds_newcomment_leba_read_id", 0L);
    localBundle = a((Uri)localObject2, new int[] { 12, 11 }, l1, new String[] { "_id", "likeUin", "commentUin" });
    long l3 = localBundle.getLong("unread");
    if (l3 > 0L)
    {
      long l4 = localBundle.getLong("_id");
      l1 = localBundle.getLong("likeUin");
      l2 = localBundle.getLong("commentUin");
      ((SharedPreferences.Editor)localObject1).putLong("config_feeds_newcomment_leba_max_id", l4);
    }
    else
    {
      l2 = 0L;
      l1 = l2;
    }
    if (l1 > 0L) {
      l2 = l1;
    }
    ((SharedPreferences.Editor)localObject1).putLong("config_feeds_newcomment_leba_latest_uin", l2);
    ((SharedPreferences.Editor)localObject1).putLong("config_feeds_newcomment_leba_unread_count", l3);
    l1 = this.d.getLong("config_feeds_publishfail_leba_read_id", 0L);
    localObject2 = a((Uri)localObject2, new int[] { 999999 }, l1, new String[] { "_id" });
    l1 = ((Bundle)localObject2).getLong("unread");
    if (l1 > 0L) {
      ((SharedPreferences.Editor)localObject1).putLong("config_feeds_publishfail_leba_max_id", ((Bundle)localObject2).getLong("_id"));
    }
    ((SharedPreferences.Editor)localObject1).putLong("config_feeds_publishfail_leba_unread_count", l1);
    RIJSPUtils.a((SharedPreferences.Editor)localObject1, true);
    f();
  }
  
  private void f()
  {
    ReadInJoyNotifyRedTouchInfo localReadInJoyNotifyRedTouchInfo = g();
    int k = localReadInJoyNotifyRedTouchInfo.a(c());
    if (k != 0)
    {
      this.i.set(0, localReadInJoyNotifyRedTouchInfo);
      ((ReadInJoyHandler)this.b.getBusinessHandler(BusinessHandlerFactory.READINJOY_HANDLER)).a(true, true, k);
    }
  }
  
  private ReadInJoyNotifyRedTouchInfo g()
  {
    ReadInJoyNotifyRedTouchInfo localReadInJoyNotifyRedTouchInfo = new ReadInJoyNotifyRedTouchInfo();
    localReadInJoyNotifyRedTouchInfo.b = 0;
    Object localObject = this.d;
    if (localObject == null) {
      return localReadInJoyNotifyRedTouchInfo;
    }
    if (!((SharedPreferences)localObject).getBoolean("share_to_news", false)) {
      return localReadInJoyNotifyRedTouchInfo;
    }
    long l3 = this.d.getLong("config_feeds_newfeeds_leba_latest_owner", 0L);
    int k;
    if (l3 > 0L) {
      k = 1;
    } else {
      k = 0;
    }
    long l1 = this.d.getLong("config_feeds_newcomment_leba_unread_count", 0L);
    long l2 = this.d.getLong("config_feeds_publishfail_leba_unread_count", 0L);
    boolean bool = TextUtils.isEmpty(this.d.getString("config_new_channel_id_list", null));
    int m = this.d.getInt("config_new_channel_notify_flag", 0);
    if (((bool ^ true)) && (m != -1)) {
      m = 1;
    } else {
      m = 0;
    }
    localObject = this.d.getString("config_notify_guide_wording", null);
    int n = this.d.getInt("config_notify_guide_flag", 0);
    if ((localObject != null) && (n != -1)) {
      n = 1;
    } else {
      n = 0;
    }
    int i1;
    if (this.d.getInt("readinjoy_push_channel_article_flag", 0) != -1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (l1 > 0L)
    {
      localReadInJoyNotifyRedTouchInfo.b = 1;
      localReadInJoyNotifyRedTouchInfo.d = ((int)l1);
      localReadInJoyNotifyRedTouchInfo.f = 3;
    }
    else if (m != 0)
    {
      localReadInJoyNotifyRedTouchInfo.b = 4;
      localReadInJoyNotifyRedTouchInfo.c = HardCodeUtil.a(2131910247);
    }
    else if ((n == 0) && (k == 0) && (i1 == 0))
    {
      if (l2 > 0L)
      {
        localReadInJoyNotifyRedTouchInfo.b = 3;
        localReadInJoyNotifyRedTouchInfo.e = 2130846657;
        localReadInJoyNotifyRedTouchInfo.f = 4;
      }
    }
    else
    {
      l1 = this.d.getLong("config_notify_guide_updated_time", 0L);
      l2 = this.d.getLong("config_feeds_newfeeds_leba_updated_time", 0L);
      long l4 = this.d.getLong("readinjoy_push_channel_article_updated_time", 0L);
      HashMap localHashMap = new HashMap();
      if (n != 0) {
        localHashMap.put(Integer.valueOf(1), Long.valueOf(l1));
      }
      if (k != 0) {
        localHashMap.put(Integer.valueOf(2), Long.valueOf(l2));
      }
      if (i1 != 0) {
        localHashMap.put(Integer.valueOf(5), Long.valueOf(l4));
      }
      Iterator localIterator = localHashMap.keySet().iterator();
      l1 = 0L;
      k = 0;
      while (localIterator.hasNext())
      {
        m = ((Integer)localIterator.next()).intValue();
        l2 = ((Long)localHashMap.get(Integer.valueOf(m))).longValue();
        if (l2 > l1)
        {
          k = m;
          l1 = l2;
        }
      }
      if (k != 1)
      {
        if (k != 2)
        {
          if (k == 5)
          {
            localReadInJoyNotifyRedTouchInfo.b = 2;
            localReadInJoyNotifyRedTouchInfo.c = this.d.getString("readinjoy_push_channel_article_content_wording", "");
            localReadInJoyNotifyRedTouchInfo.f = k;
          }
        }
        else
        {
          localReadInJoyNotifyRedTouchInfo.b = 2;
          localReadInJoyNotifyRedTouchInfo.c = ContactUtils.d(this.b, Long.toString(l3));
          localReadInJoyNotifyRedTouchInfo.f = k;
        }
      }
      else
      {
        localReadInJoyNotifyRedTouchInfo.b = 2;
        localReadInJoyNotifyRedTouchInfo.c = ((String)localObject);
        localReadInJoyNotifyRedTouchInfo.f = k;
      }
    }
    if (!TextUtils.isEmpty(localReadInJoyNotifyRedTouchInfo.c))
    {
      n = localReadInJoyNotifyRedTouchInfo.c.length();
      if (n * 2 > this.j)
      {
        m = 0;
        k = 0;
        while (m < n)
        {
          if (localReadInJoyNotifyRedTouchInfo.c.charAt(m) < 'ÿ') {
            k += 1;
          } else {
            k += 2;
          }
          if ((k > this.j) && (m > 0))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(localReadInJoyNotifyRedTouchInfo.c.substring(0, m));
            ((StringBuilder)localObject).append("...");
            localReadInJoyNotifyRedTouchInfo.c = ((StringBuilder)localObject).toString();
            return localReadInJoyNotifyRedTouchInfo;
          }
          m += 1;
        }
      }
    }
    return localReadInJoyNotifyRedTouchInfo;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo a()
  {
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = this.g;
    if (localRedTypeInfo == null) {
      this.g = new BusinessInfoCheckUpdate.RedTypeInfo();
    } else {
      localRedTypeInfo.clear();
    }
    return this.g;
  }
  
  public void a(long paramLong, String paramString1, String paramString2, List<Long> paramList)
  {
    this.f.execute(new ReadInJoyManager.4(this, paramLong, paramString1, paramString2, paramList));
  }
  
  public void a(Intent paramIntent)
  {
    if (this.d == null) {
      return;
    }
    int k = c().f;
    if ((k != 2) && (k != 3) && (k != 4))
    {
      if (k != 5) {
        return;
      }
      long l = this.d.getLong("readinjoy_push_channel_article_content_channel_id", 0L);
      String str = this.d.getString("readinjoy_push_channel_article_content_channel_name", "推荐");
      Object localObject = this.d.getString("readinjoy_push_channel_article_content_article_id_list", "");
      ArrayList localArrayList = new ArrayList(((String)localObject).length());
      localObject = StringUtil.split((String)localObject, ',');
      int m = localObject.length;
      k = 0;
      while (k < m)
      {
        CharSequence localCharSequence = localObject[k];
        if (!TextUtils.isEmpty(localCharSequence)) {
          localArrayList.add(Long.valueOf(Long.parseLong(localCharSequence)));
        }
        k += 1;
      }
      paramIntent.putExtra("channel_id", (int)l);
      paramIntent.putExtra("channel_name", str);
      paramIntent.putExtra("subscription_all_article_id", localArrayList);
      return;
    }
    paramIntent.putExtra("channel_id", 9999);
  }
  
  public void a(List<ReadInJoyFeedsMsgRecord> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      this.f.execute(new ReadInJoyManager.1(this, paramList));
    }
  }
  
  public BusinessInfoCheckUpdate.AppInfo b()
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = this.h;
    if (localAppInfo == null) {
      this.h = new BusinessInfoCheckUpdate.AppInfo();
    } else {
      localAppInfo.clear();
    }
    return this.h;
  }
  
  public ReadInJoyNotifyRedTouchInfo c()
  {
    return (ReadInJoyNotifyRedTouchInfo)this.i.get(0);
  }
  
  public void onDestroy()
  {
    this.b.getApp().unregisterReceiver(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyManager
 * JD-Core Version:    0.7.0.1
 */