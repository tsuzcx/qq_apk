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
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.feeds.ReadInJoyFeedsMsgRecord;
import com.tencent.mobileqq.kandian.biz.reddot.ReadInJoyNotifyRedTouchInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
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
  private int jdField_a_of_type_Int;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ReadInJoyManager.NotifyReceiver jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyManager$NotifyReceiver;
  private BusinessInfoCheckUpdate.AppInfo jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo = null;
  private BusinessInfoCheckUpdate.RedTypeInfo jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$RedTypeInfo = null;
  private HashMap<Integer, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private CopyOnWriteArrayList<ReadInJoyNotifyRedTouchInfo> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newSingleThreadExecutor();
  
  public ReadInJoyManager(QQAppInterface paramQQAppInterface)
  {
    int i = 14;
    this.jdField_a_of_type_Int = 14;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyManager$NotifyReceiver = new ReadInJoyManager.NotifyReceiver(this);
    this.jdField_a_of_type_AndroidContentSharedPreferences = ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getReadInJoySharedPreferences(1);
    if (((WindowManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getSystemService("window")).getDefaultDisplay().getWidth() > 720) {
      i = 24;
    }
    this.jdField_a_of_type_Int = i;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, b());
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyManager$NotifyReceiver, paramQQAppInterface);
  }
  
  private long a()
  {
    Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences;
    if (localObject == null) {
      return 0L;
    }
    long l = ((SharedPreferences)localObject).getLong("config_feeds_process_seq", 0L) + 1L;
    localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject).putLong("config_feeds_process_seq", l);
    ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).applySharedPreferences((SharedPreferences.Editor)localObject, true);
    return l;
  }
  
  /* Error */
  @android.annotation.TargetApi(11)
  private Bundle a(Uri paramUri, int[] paramArrayOfInt, long paramLong, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 191	android/os/Bundle
    //   3: dup
    //   4: invokespecial 192	android/os/Bundle:<init>	()V
    //   7: astore 16
    //   9: getstatic 197	android/os/Build$VERSION:SDK_INT	I
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
    //   29: ldc 199
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
    //   68: new 201	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   75: astore 13
    //   77: aload 14
    //   79: astore 11
    //   81: aload 15
    //   83: astore 10
    //   85: aload 13
    //   87: aload 12
    //   89: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 14
    //   95: astore 11
    //   97: aload 15
    //   99: astore 10
    //   101: aload 13
    //   103: ldc 208
    //   105: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload 14
    //   111: astore 11
    //   113: aload 15
    //   115: astore 10
    //   117: aload 13
    //   119: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: astore 13
    //   124: aload 14
    //   126: astore 11
    //   128: aload 15
    //   130: astore 10
    //   132: new 201	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   139: astore 12
    //   141: aload 14
    //   143: astore 11
    //   145: aload 15
    //   147: astore 10
    //   149: aload 12
    //   151: aload 13
    //   153: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload 14
    //   159: astore 11
    //   161: aload 15
    //   163: astore 10
    //   165: aload 12
    //   167: aload_2
    //   168: iload 6
    //   170: iaload
    //   171: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload 14
    //   177: astore 11
    //   179: aload 15
    //   181: astore 10
    //   183: aload 12
    //   185: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
    //   207: new 201	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   214: astore_2
    //   215: aload 14
    //   217: astore 11
    //   219: aload 15
    //   221: astore 10
    //   223: aload_2
    //   224: ldc 217
    //   226: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload 14
    //   232: astore 11
    //   234: aload 15
    //   236: astore 10
    //   238: aload_2
    //   239: lload_3
    //   240: invokestatic 222	java/lang/Long:toString	(J)Ljava/lang/String;
    //   243: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload 14
    //   249: astore 11
    //   251: aload 15
    //   253: astore 10
    //   255: aload_2
    //   256: ldc 224
    //   258: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload 14
    //   264: astore 11
    //   266: aload 15
    //   268: astore 10
    //   270: aload_2
    //   271: ldc 226
    //   273: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload 14
    //   279: astore 11
    //   281: aload 15
    //   283: astore 10
    //   285: aload_2
    //   286: ldc 228
    //   288: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload 14
    //   294: astore 11
    //   296: aload 15
    //   298: astore 10
    //   300: aload_2
    //   301: aload 12
    //   303: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 14
    //   309: astore 11
    //   311: aload 15
    //   313: astore 10
    //   315: aload_2
    //   316: ldc 230
    //   318: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload 14
    //   324: astore 11
    //   326: aload 15
    //   328: astore 10
    //   330: aload_2
    //   331: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: astore_2
    //   335: aload 14
    //   337: astore 11
    //   339: aload 15
    //   341: astore 10
    //   343: aload_0
    //   344: getfield 54	com/tencent/mobileqq/kandian/biz/common/ReadInJoyManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   347: invokevirtual 150	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   350: invokevirtual 234	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   353: aload_1
    //   354: aconst_null
    //   355: aload_2
    //   356: aconst_null
    //   357: ldc 236
    //   359: invokevirtual 242	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   362: astore_1
    //   363: aload_1
    //   364: astore 11
    //   366: aload_1
    //   367: astore 10
    //   369: aload_1
    //   370: invokeinterface 248 1 0
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
    //   414: invokeinterface 252 2 0
    //   419: istore 7
    //   421: iload 7
    //   423: iflt +155 -> 578
    //   426: aload_1
    //   427: astore 11
    //   429: aload_1
    //   430: astore 10
    //   432: aload_1
    //   433: iload 7
    //   435: invokeinterface 256 2 0
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
    //   460: invokeinterface 259 2 0
    //   465: invokevirtual 262	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   468: goto +110 -> 578
    //   471: iload 9
    //   473: iconst_3
    //   474: if_icmpne +104 -> 578
    //   477: aload_1
    //   478: astore 11
    //   480: aload_1
    //   481: astore 10
    //   483: aload 16
    //   485: aload_2
    //   486: aload_1
    //   487: iload 7
    //   489: invokeinterface 266 2 0
    //   494: invokevirtual 270	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   497: goto +81 -> 578
    //   500: aload_1
    //   501: astore 11
    //   503: aload_1
    //   504: astore 10
    //   506: aload 16
    //   508: ldc_w 272
    //   511: aload_1
    //   512: invokeinterface 275 1 0
    //   517: i2l
    //   518: invokevirtual 262	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   521: aload_1
    //   522: ifnull +33 -> 555
    //   525: goto +24 -> 549
    //   528: astore_1
    //   529: goto +29 -> 558
    //   532: astore_1
    //   533: aload 10
    //   535: astore 11
    //   537: aload_1
    //   538: invokevirtual 278	java/lang/Exception:printStackTrace	()V
    //   541: aload 10
    //   543: ifnull +12 -> 555
    //   546: aload 10
    //   548: astore_1
    //   549: aload_1
    //   550: invokeinterface 281 1 0
    //   555: aload 16
    //   557: areturn
    //   558: aload 11
    //   560: ifnull +10 -> 570
    //   563: aload 11
    //   565: invokeinterface 281 1 0
    //   570: goto +5 -> 575
    //   573: aload_1
    //   574: athrow
    //   575: goto -2 -> 573
    //   578: iload 6
    //   580: iconst_1
    //   581: iadd
    //   582: istore 6
    //   584: goto -191 -> 393
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	587	0	this	ReadInJoyManager
    //   0	587	1	paramUri	Uri
    //   0	587	2	paramArrayOfInt	int[]
    //   0	587	3	paramLong	long
    //   0	587	5	paramArrayOfString	String[]
    //   34	549	6	i	int
    //   27	461	7	j	int
    //   387	11	8	k	int
    //   440	35	9	m	int
    //   42	505	10	localObject1	Object
    //   38	526	11	localObject2	Object
    //   31	271	12	localObject3	Object
    //   53	99	13	localObject4	Object
    //   24	312	14	localObject5	Object
    //   21	319	15	localObject6	Object
    //   7	549	16	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   44	51	528	finally
    //   68	77	528	finally
    //   85	93	528	finally
    //   101	109	528	finally
    //   117	124	528	finally
    //   132	141	528	finally
    //   149	157	528	finally
    //   165	175	528	finally
    //   183	190	528	finally
    //   207	215	528	finally
    //   223	230	528	finally
    //   238	247	528	finally
    //   255	262	528	finally
    //   270	277	528	finally
    //   285	292	528	finally
    //   300	307	528	finally
    //   315	322	528	finally
    //   330	335	528	finally
    //   343	363	528	finally
    //   369	378	528	finally
    //   384	389	528	finally
    //   412	421	528	finally
    //   432	442	528	finally
    //   454	468	528	finally
    //   483	497	528	finally
    //   506	521	528	finally
    //   537	541	528	finally
    //   44	51	532	java/lang/Exception
    //   68	77	532	java/lang/Exception
    //   85	93	532	java/lang/Exception
    //   101	109	532	java/lang/Exception
    //   117	124	532	java/lang/Exception
    //   132	141	532	java/lang/Exception
    //   149	157	532	java/lang/Exception
    //   165	175	532	java/lang/Exception
    //   183	190	532	java/lang/Exception
    //   207	215	532	java/lang/Exception
    //   223	230	532	java/lang/Exception
    //   238	247	532	java/lang/Exception
    //   255	262	532	java/lang/Exception
    //   270	277	532	java/lang/Exception
    //   285	292	532	java/lang/Exception
    //   300	307	532	java/lang/Exception
    //   315	322	532	java/lang/Exception
    //   330	335	532	java/lang/Exception
    //   343	363	532	java/lang/Exception
    //   369	378	532	java/lang/Exception
    //   384	389	532	java/lang/Exception
    //   412	421	532	java/lang/Exception
    //   432	442	532	java/lang/Exception
    //   454	468	532	java/lang/Exception
    //   483	497	532	java/lang/Exception
    //   506	521	532	java/lang/Exception
  }
  
  private void a()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences;
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((SharedPreferences)localObject1).edit();
    Object localObject2 = ReadInJoyDataProvider.c.buildUpon();
    ((Uri.Builder)localObject2).appendQueryParameter("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    localObject2 = ((Uri.Builder)localObject2).build();
    long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("config_feeds_newfeeds_leba_read_id", 0L);
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
    l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("config_feeds_newcomment_leba_read_id", 0L);
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
    l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("config_feeds_publishfail_leba_read_id", 0L);
    localObject2 = a((Uri)localObject2, new int[] { 999999 }, l1, new String[] { "_id" });
    l1 = ((Bundle)localObject2).getLong("unread");
    if (l1 > 0L) {
      ((SharedPreferences.Editor)localObject1).putLong("config_feeds_publishfail_leba_max_id", ((Bundle)localObject2).getLong("_id"));
    }
    ((SharedPreferences.Editor)localObject1).putLong("config_feeds_publishfail_leba_unread_count", l1);
    ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).applySharedPreferences((SharedPreferences.Editor)localObject1, true);
    b();
  }
  
  private boolean a(Uri paramUri, ReadInJoyFeedsMsgRecord paramReadInJoyFeedsMsgRecord, long paramLong)
  {
    Object localObject = new ContentValues();
    ((ContentValues)localObject).put("pushTime", Integer.valueOf(paramReadInJoyFeedsMsgRecord.jdField_a_of_type_Int));
    ((ContentValues)localObject).put("notifyType", Integer.valueOf(paramReadInJoyFeedsMsgRecord.jdField_c_of_type_Int));
    ((ContentValues)localObject).put("feedsOwner", Long.valueOf(paramReadInJoyFeedsMsgRecord.jdField_a_of_type_Long));
    ((ContentValues)localObject).put("feedsID", Long.valueOf(paramReadInJoyFeedsMsgRecord.jdField_b_of_type_Long));
    ((ContentValues)localObject).put("feedsSubject", paramReadInJoyFeedsMsgRecord.jdField_a_of_type_JavaLangString);
    ((ContentValues)localObject).put("deleteUin", Long.valueOf(paramReadInJoyFeedsMsgRecord.f));
    ((ContentValues)localObject).put("publishFail", Integer.valueOf(paramReadInJoyFeedsMsgRecord.jdField_d_of_type_Int));
    ((ContentValues)localObject).put("likeUin", Long.valueOf(paramReadInJoyFeedsMsgRecord.e));
    ((ContentValues)localObject).put("commentUin", Long.valueOf(paramReadInJoyFeedsMsgRecord.jdField_c_of_type_Long));
    ((ContentValues)localObject).put("commentID", paramReadInJoyFeedsMsgRecord.jdField_b_of_type_JavaLangString);
    ((ContentValues)localObject).put("replyUin", Long.valueOf(paramReadInJoyFeedsMsgRecord.jdField_d_of_type_Long));
    ((ContentValues)localObject).put("replyID", paramReadInJoyFeedsMsgRecord.jdField_c_of_type_JavaLangString);
    ((ContentValues)localObject).put("commentInfo", paramReadInJoyFeedsMsgRecord.jdField_d_of_type_JavaLangString);
    ((ContentValues)localObject).put("receiveTime", Long.valueOf(paramReadInJoyFeedsMsgRecord.g));
    ((ContentValues)localObject).put("processSeq", Long.valueOf(paramLong));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getContentResolver().insert(paramUri, (ContentValues)localObject) == null)
    {
      if (QLog.isColorLevel())
      {
        paramUri = jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handlePushedFeedsMsgRecords, insertMsgRecordToFeedsTable failed, feedID=");
        ((StringBuilder)localObject).append(paramReadInJoyFeedsMsgRecord.jdField_b_of_type_Long);
        ((StringBuilder)localObject).append(", commentID=");
        ((StringBuilder)localObject).append(paramReadInJoyFeedsMsgRecord.jdField_b_of_type_JavaLangString);
        QLog.d(paramUri, 2, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    return true;
  }
  
  private ReadInJoyNotifyRedTouchInfo b()
  {
    ReadInJoyNotifyRedTouchInfo localReadInJoyNotifyRedTouchInfo = new ReadInJoyNotifyRedTouchInfo();
    localReadInJoyNotifyRedTouchInfo.jdField_a_of_type_Int = 0;
    Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences;
    if (localObject == null) {
      return localReadInJoyNotifyRedTouchInfo;
    }
    if (!((SharedPreferences)localObject).getBoolean("share_to_news", false)) {
      return localReadInJoyNotifyRedTouchInfo;
    }
    long l3 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("config_feeds_newfeeds_leba_latest_owner", 0L);
    int i;
    if (l3 > 0L) {
      i = 1;
    } else {
      i = 0;
    }
    long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("config_feeds_newcomment_leba_unread_count", 0L);
    long l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("config_feeds_publishfail_leba_unread_count", 0L);
    boolean bool = TextUtils.isEmpty(this.jdField_a_of_type_AndroidContentSharedPreferences.getString("config_new_channel_id_list", null));
    int j = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("config_new_channel_notify_flag", 0);
    if (((bool ^ true)) && (j != -1)) {
      j = 1;
    } else {
      j = 0;
    }
    localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("config_notify_guide_wording", null);
    int k = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("config_notify_guide_flag", 0);
    if ((localObject != null) && (k != -1)) {
      k = 1;
    } else {
      k = 0;
    }
    int m;
    if (this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("readinjoy_push_channel_article_flag", 0) != -1) {
      m = 1;
    } else {
      m = 0;
    }
    if (l1 > 0L)
    {
      localReadInJoyNotifyRedTouchInfo.jdField_a_of_type_Int = 1;
      localReadInJoyNotifyRedTouchInfo.jdField_b_of_type_Int = ((int)l1);
      localReadInJoyNotifyRedTouchInfo.jdField_d_of_type_Int = 3;
    }
    else if (j != 0)
    {
      localReadInJoyNotifyRedTouchInfo.jdField_a_of_type_Int = 4;
      localReadInJoyNotifyRedTouchInfo.jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131712669);
    }
    else if ((k == 0) && (i == 0) && (m == 0))
    {
      if (l2 > 0L)
      {
        localReadInJoyNotifyRedTouchInfo.jdField_a_of_type_Int = 3;
        localReadInJoyNotifyRedTouchInfo.jdField_c_of_type_Int = 2130845215;
        localReadInJoyNotifyRedTouchInfo.jdField_d_of_type_Int = 4;
      }
    }
    else
    {
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("config_notify_guide_updated_time", 0L);
      l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("config_feeds_newfeeds_leba_updated_time", 0L);
      long l4 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("readinjoy_push_channel_article_updated_time", 0L);
      HashMap localHashMap = new HashMap();
      if (k != 0) {
        localHashMap.put(Integer.valueOf(1), Long.valueOf(l1));
      }
      if (i != 0) {
        localHashMap.put(Integer.valueOf(2), Long.valueOf(l2));
      }
      if (m != 0) {
        localHashMap.put(Integer.valueOf(5), Long.valueOf(l4));
      }
      Iterator localIterator = localHashMap.keySet().iterator();
      l1 = 0L;
      i = 0;
      while (localIterator.hasNext())
      {
        j = ((Integer)localIterator.next()).intValue();
        l2 = ((Long)localHashMap.get(Integer.valueOf(j))).longValue();
        if (l2 > l1)
        {
          i = j;
          l1 = l2;
        }
      }
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 5)
          {
            localReadInJoyNotifyRedTouchInfo.jdField_a_of_type_Int = 2;
            localReadInJoyNotifyRedTouchInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("readinjoy_push_channel_article_content_wording", "");
            localReadInJoyNotifyRedTouchInfo.jdField_d_of_type_Int = i;
          }
        }
        else
        {
          localReadInJoyNotifyRedTouchInfo.jdField_a_of_type_Int = 2;
          localReadInJoyNotifyRedTouchInfo.jdField_b_of_type_JavaLangString = ContactUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.toString(l3));
          localReadInJoyNotifyRedTouchInfo.jdField_d_of_type_Int = i;
        }
      }
      else
      {
        localReadInJoyNotifyRedTouchInfo.jdField_a_of_type_Int = 2;
        localReadInJoyNotifyRedTouchInfo.jdField_b_of_type_JavaLangString = ((String)localObject);
        localReadInJoyNotifyRedTouchInfo.jdField_d_of_type_Int = i;
      }
    }
    if (!TextUtils.isEmpty(localReadInJoyNotifyRedTouchInfo.jdField_b_of_type_JavaLangString))
    {
      k = localReadInJoyNotifyRedTouchInfo.jdField_b_of_type_JavaLangString.length();
      if (k * 2 > this.jdField_a_of_type_Int)
      {
        j = 0;
        i = 0;
        while (j < k)
        {
          if (localReadInJoyNotifyRedTouchInfo.jdField_b_of_type_JavaLangString.charAt(j) < 'ÿ') {
            i += 1;
          } else {
            i += 2;
          }
          if ((i > this.jdField_a_of_type_Int) && (j > 0))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(localReadInJoyNotifyRedTouchInfo.jdField_b_of_type_JavaLangString.substring(0, j));
            ((StringBuilder)localObject).append("...");
            localReadInJoyNotifyRedTouchInfo.jdField_b_of_type_JavaLangString = ((StringBuilder)localObject).toString();
            return localReadInJoyNotifyRedTouchInfo;
          }
          j += 1;
        }
      }
    }
    return localReadInJoyNotifyRedTouchInfo;
  }
  
  private void b()
  {
    ReadInJoyNotifyRedTouchInfo localReadInJoyNotifyRedTouchInfo = b();
    int i = localReadInJoyNotifyRedTouchInfo.a(a());
    if (i != 0)
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.set(0, localReadInJoyNotifyRedTouchInfo);
      ((ReadInJoyHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.READINJOY_HANDLER)).a(true, true, i);
    }
  }
  
  public ReadInJoyNotifyRedTouchInfo a()
  {
    return (ReadInJoyNotifyRedTouchInfo)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(0);
  }
  
  public BusinessInfoCheckUpdate.AppInfo a()
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo;
    if (localAppInfo == null) {
      this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo = new BusinessInfoCheckUpdate.AppInfo();
    } else {
      localAppInfo.clear();
    }
    return this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo a()
  {
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$RedTypeInfo;
    if (localRedTypeInfo == null) {
      this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$RedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    } else {
      localRedTypeInfo.clear();
    }
    return this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$RedTypeInfo;
  }
  
  public void a(long paramLong, String paramString1, String paramString2, List<Long> paramList)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ReadInJoyManager.4(this, paramLong, paramString1, paramString2, paramList));
  }
  
  public void a(Intent paramIntent)
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      return;
    }
    int i = a().jdField_d_of_type_Int;
    if ((i != 2) && (i != 3) && (i != 4))
    {
      if (i != 5) {
        return;
      }
      long l = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("readinjoy_push_channel_article_content_channel_id", 0L);
      String str = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("readinjoy_push_channel_article_content_channel_name", "推荐");
      Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("readinjoy_push_channel_article_content_article_id_list", "");
      ArrayList localArrayList = new ArrayList(((String)localObject).length());
      localObject = StringUtil.a((String)localObject, ',');
      int j = localObject.length;
      i = 0;
      while (i < j)
      {
        CharSequence localCharSequence = localObject[i];
        if (!TextUtils.isEmpty(localCharSequence)) {
          localArrayList.add(Long.valueOf(Long.parseLong(localCharSequence)));
        }
        i += 1;
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
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ReadInJoyManager.1(this, paramList));
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyManager$NotifyReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyManager
 * JD-Core Version:    0.7.0.1
 */