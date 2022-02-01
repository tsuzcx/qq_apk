package com.tencent.mobileqq.qcircle.api.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import qqcircle.QQCircleCounter.CountInfoRsp;
import qqcircle.QQCircleCounter.OutLayerPointInfo;
import qqcircle.QQCircleCounter.RedPointInfo;

public class EeveeRedpointUtil
{
  public static final String LOG_TAG_PREFIX = "QCircleEeveeRedPoint_";
  public static final String MAP_KEY_CIRCLE_FOLLOW_TAB_CLEAR_RED_DOT_DELAY_SECOND = "follow_page_delay_second";
  public static final String MAP_KEY_CIRCLE_RECOMMEND_RED_DOT = "allpush_reddot";
  private static final String TAG = "QCircleEeveeRedPoint_Util";
  
  /* Error */
  public static int getFolderMessageNoticeBubbleLastExposeNum()
  {
    // Byte code:
    //   0: ldc 28
    //   2: invokestatic 32	com/tencent/mobileqq/qcircle/api/utils/EeveeRedpointUtil:getSharedPreferencesKey	(Ljava/lang/String;)Ljava/lang/String;
    //   5: astore_2
    //   6: invokestatic 36	com/tencent/mobileqq/qcircle/api/utils/EeveeRedpointUtil:getSharedPreferences	()Landroid/content/SharedPreferences;
    //   9: aload_2
    //   10: iconst_0
    //   11: invokeinterface 42 3 0
    //   16: istore_0
    //   17: getstatic 48	com/tencent/biz/richframework/delegate/impl/RFLog:CLR	I
    //   20: istore_1
    //   21: new 50	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   28: astore_3
    //   29: aload_3
    //   30: ldc 53
    //   32: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_3
    //   37: aload_2
    //   38: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_3
    //   43: ldc 59
    //   45: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_3
    //   50: iload_0
    //   51: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: ldc 17
    //   57: iload_1
    //   58: aload_3
    //   59: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 70	com/tencent/biz/richframework/delegate/impl/RFLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: iload_0
    //   66: ireturn
    //   67: astore_2
    //   68: goto +6 -> 74
    //   71: astore_2
    //   72: iconst_0
    //   73: istore_0
    //   74: ldc 17
    //   76: getstatic 48	com/tencent/biz/richframework/delegate/impl/RFLog:CLR	I
    //   79: iconst_2
    //   80: anewarray 4	java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: ldc 72
    //   87: aastore
    //   88: dup
    //   89: iconst_1
    //   90: aload_2
    //   91: aastore
    //   92: invokestatic 76	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   95: iload_0
    //   96: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   16	80	0	i	int
    //   20	38	1	j	int
    //   5	33	2	str	String
    //   67	1	2	localThrowable1	Throwable
    //   71	20	2	localThrowable2	Throwable
    //   28	31	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   17	65	67	java/lang/Throwable
    //   0	17	71	java/lang/Throwable
  }
  
  /* Error */
  public static long getFollowTabClearRedDotDelayInSecond()
  {
    // Byte code:
    //   0: ldc 80
    //   2: invokestatic 86	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   5: checkcast 80	com/tencent/mobileqq/qcircle/api/IQCircleConfigApi
    //   8: invokeinterface 89 1 0
    //   13: lstore 5
    //   15: ldc 91
    //   17: invokestatic 32	com/tencent/mobileqq/qcircle/api/utils/EeveeRedpointUtil:getSharedPreferencesKey	(Ljava/lang/String;)Ljava/lang/String;
    //   20: astore 7
    //   22: invokestatic 36	com/tencent/mobileqq/qcircle/api/utils/EeveeRedpointUtil:getSharedPreferences	()Landroid/content/SharedPreferences;
    //   25: aload 7
    //   27: lload 5
    //   29: invokeinterface 95 4 0
    //   34: lstore_1
    //   35: getstatic 48	com/tencent/biz/richframework/delegate/impl/RFLog:CLR	I
    //   38: istore_0
    //   39: new 50	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   46: astore 8
    //   48: aload 8
    //   50: ldc 97
    //   52: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload 8
    //   58: aload 7
    //   60: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload 8
    //   66: ldc 59
    //   68: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 8
    //   74: lload_1
    //   75: invokevirtual 100	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 8
    //   81: ldc 102
    //   83: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 8
    //   89: lload 5
    //   91: invokevirtual 100	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: ldc 17
    //   97: iload_0
    //   98: aload 8
    //   100: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 70	com/tencent/biz/richframework/delegate/impl/RFLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   106: lload_1
    //   107: lstore_3
    //   108: lload_1
    //   109: lconst_0
    //   110: lcmp
    //   111: ifgt +39 -> 150
    //   114: lload 5
    //   116: lreturn
    //   117: astore 7
    //   119: goto +7 -> 126
    //   122: astore 7
    //   124: lconst_0
    //   125: lstore_1
    //   126: ldc 17
    //   128: getstatic 48	com/tencent/biz/richframework/delegate/impl/RFLog:CLR	I
    //   131: iconst_2
    //   132: anewarray 4	java/lang/Object
    //   135: dup
    //   136: iconst_0
    //   137: ldc 104
    //   139: aastore
    //   140: dup
    //   141: iconst_1
    //   142: aload 7
    //   144: aastore
    //   145: invokestatic 76	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   148: lload_1
    //   149: lstore_3
    //   150: lload_3
    //   151: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   38	60	0	i	int
    //   34	115	1	l1	long
    //   107	44	3	l2	long
    //   13	102	5	l3	long
    //   20	39	7	str	String
    //   117	1	7	localThrowable1	Throwable
    //   122	21	7	localThrowable2	Throwable
    //   46	53	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   35	106	117	java/lang/Throwable
    //   15	35	122	java/lang/Throwable
  }
  
  public static long getFollowTabFeedListLastPreRspTimestamp()
  {
    long l2 = 0L;
    long l1 = l2;
    try
    {
      String str = getSharedPreferencesKey("follow_tab_feed_list_last_pre_rsp_timestamp");
      l1 = l2;
      l2 = getSharedPreferences().getLong(str, -1L);
      l1 = l2;
      int i = RFLog.CLR;
      l1 = l2;
      StringBuilder localStringBuilder = new StringBuilder();
      l1 = l2;
      localStringBuilder.append("getFollowTabFeedListLastPreRspTimestamp key: ");
      l1 = l2;
      localStringBuilder.append(str);
      l1 = l2;
      localStringBuilder.append(", result: ");
      l1 = l2;
      localStringBuilder.append(l2);
      l1 = l2;
      RFLog.d("QCircleEeveeRedPoint_Util", i, localStringBuilder.toString());
      return l2;
    }
    catch (Throwable localThrowable)
    {
      RFLog.e("QCircleEeveeRedPoint_Util", RFLog.CLR, new Object[] { "getFollowTabFeedListLastPreRspTimestamp error!", localThrowable });
    }
    return l1;
  }
  
  public static long getFollowTabFeedListLastRspTimestamp()
  {
    long l2 = 0L;
    long l1 = l2;
    try
    {
      String str = getSharedPreferencesKey("follow_tab_feed_list_last_rsp_timestamp");
      l1 = l2;
      l2 = getSharedPreferences().getLong(str, -1L);
      l1 = l2;
      int i = RFLog.CLR;
      l1 = l2;
      StringBuilder localStringBuilder = new StringBuilder();
      l1 = l2;
      localStringBuilder.append("getFollowTabFeedListLastRspTimestamp key: ");
      l1 = l2;
      localStringBuilder.append(str);
      l1 = l2;
      localStringBuilder.append(", result: ");
      l1 = l2;
      localStringBuilder.append(l2);
      l1 = l2;
      RFLog.d("QCircleEeveeRedPoint_Util", i, localStringBuilder.toString());
      return l2;
    }
    catch (Throwable localThrowable)
    {
      RFLog.e("QCircleEeveeRedPoint_Util", RFLog.CLR, new Object[] { "getFollowTabFeedListLastRspTimestamp error!", localThrowable });
    }
    return l1;
  }
  
  public static long getLastOuterEntranceRedPointClearRspTimestamp()
  {
    long l2 = 0L;
    long l1 = l2;
    try
    {
      String str = getSharedPreferencesKey("last_outer_entrance_red_point_clear_rsp_timestamp");
      l1 = l2;
      l2 = getSharedPreferences().getLong(str, -1L);
      l1 = l2;
      int i = RFLog.CLR;
      l1 = l2;
      StringBuilder localStringBuilder = new StringBuilder();
      l1 = l2;
      localStringBuilder.append("getLastOuterEntranceRedPointClearRspTimestamp key: ");
      l1 = l2;
      localStringBuilder.append(str);
      l1 = l2;
      localStringBuilder.append(", result: ");
      l1 = l2;
      localStringBuilder.append(l2);
      l1 = l2;
      RFLog.d("QCircleEeveeRedPoint_Util", i, localStringBuilder.toString());
      return l2;
    }
    catch (Throwable localThrowable)
    {
      RFLog.e("QCircleEeveeRedPoint_Util", RFLog.CLR, new Object[] { "getLastOuterEntranceRedPointClearRspTimestamp error!", localThrowable });
    }
    return l1;
  }
  
  public static long getLastReadedNumRedPointTimestamp()
  {
    long l2 = 0L;
    long l1 = l2;
    try
    {
      String str = getSharedPreferencesKey("last_readed_num_red_point_timestamp");
      l1 = l2;
      l2 = getSharedPreferences().getLong(str, -1L);
      l1 = l2;
      int i = RFLog.CLR;
      l1 = l2;
      StringBuilder localStringBuilder = new StringBuilder();
      l1 = l2;
      localStringBuilder.append("getLastReadedNumRedPointTimestamp key: ");
      l1 = l2;
      localStringBuilder.append(str);
      l1 = l2;
      localStringBuilder.append(", result: ");
      l1 = l2;
      localStringBuilder.append(l2);
      l1 = l2;
      RFLog.d("QCircleEeveeRedPoint_Util", i, localStringBuilder.toString());
      return l2;
    }
    catch (Throwable localThrowable)
    {
      RFLog.e("QCircleEeveeRedPoint_Util", RFLog.CLR, new Object[] { "getLastReadedNumRedPointTimestamp error!", localThrowable });
    }
    return l1;
  }
  
  public static long getLastReadedOuterEntranceRedPointTimestamp()
  {
    long l2 = 0L;
    long l1 = l2;
    try
    {
      String str = getSharedPreferencesKey("last_readed_outer_entrance_red_point_timestamp");
      l1 = l2;
      l2 = getSharedPreferences().getLong(str, -1L);
      l1 = l2;
      int i = RFLog.CLR;
      l1 = l2;
      StringBuilder localStringBuilder = new StringBuilder();
      l1 = l2;
      localStringBuilder.append("getLastReadedOuterEntranceRedPointTimestamp key: ");
      l1 = l2;
      localStringBuilder.append(str);
      l1 = l2;
      localStringBuilder.append(", result: ");
      l1 = l2;
      localStringBuilder.append(l2);
      l1 = l2;
      RFLog.d("QCircleEeveeRedPoint_Util", i, localStringBuilder.toString());
      return l2;
    }
    catch (Throwable localThrowable)
    {
      RFLog.e("QCircleEeveeRedPoint_Util", RFLog.CLR, new Object[] { "getLastReadedOuterEntranceRedPointTimestamp error!", localThrowable });
    }
    return l1;
  }
  
  public static long getLastReadedSmallRedPointTimestamp()
  {
    long l2 = 0L;
    long l1 = l2;
    try
    {
      String str = getSharedPreferencesKey("last_readed_small_red_point_timestamp");
      l1 = l2;
      l2 = getSharedPreferences().getLong(str, -1L);
      l1 = l2;
      int i = RFLog.CLR;
      l1 = l2;
      StringBuilder localStringBuilder = new StringBuilder();
      l1 = l2;
      localStringBuilder.append("getLastReadedSmallRedPointTimestamp key: ");
      l1 = l2;
      localStringBuilder.append(str);
      l1 = l2;
      localStringBuilder.append(", result: ");
      l1 = l2;
      localStringBuilder.append(l2);
      l1 = l2;
      RFLog.d("QCircleEeveeRedPoint_Util", i, localStringBuilder.toString());
      return l2;
    }
    catch (Throwable localThrowable)
    {
      RFLog.e("QCircleEeveeRedPoint_Util", RFLog.CLR, new Object[] { "getLastReadedSmallRedPointTimestamp error!", localThrowable });
    }
    return l1;
  }
  
  public static long getNoticeFeedListLastRspTimestamp()
  {
    long l2 = 0L;
    long l1 = l2;
    try
    {
      String str = getSharedPreferencesKey("notice_feed_list_last_rsp_timestamp");
      l1 = l2;
      l2 = getSharedPreferences().getLong(str, -1L);
      l1 = l2;
      int i = RFLog.CLR;
      l1 = l2;
      StringBuilder localStringBuilder = new StringBuilder();
      l1 = l2;
      localStringBuilder.append("getNoticeFeedListLastRspTimestamp key: ");
      l1 = l2;
      localStringBuilder.append(str);
      l1 = l2;
      localStringBuilder.append(", result: ");
      l1 = l2;
      localStringBuilder.append(l2);
      l1 = l2;
      RFLog.d("QCircleEeveeRedPoint_Util", i, localStringBuilder.toString());
      return l2;
    }
    catch (Throwable localThrowable)
    {
      RFLog.e("QCircleEeveeRedPoint_Util", RFLog.CLR, new Object[] { "getNoticeFeedListLastRspTimestamp error!", localThrowable });
    }
    return l1;
  }
  
  public static QQCircleCounter.RedPointInfo getRedPointInfoByAppid(String paramString, QQCircleCounter.CountInfoRsp paramCountInfoRsp)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramCountInfoRsp == null) {
        return null;
      }
      paramCountInfoRsp = paramCountInfoRsp.rptRedPoint.get();
      if ((paramCountInfoRsp != null) && (paramCountInfoRsp.size() > 0))
      {
        paramCountInfoRsp = paramCountInfoRsp.iterator();
        while (paramCountInfoRsp.hasNext())
        {
          QQCircleCounter.RedPointInfo localRedPointInfo = (QQCircleCounter.RedPointInfo)paramCountInfoRsp.next();
          if ((localRedPointInfo != null) && (TextUtils.equals(paramString, localRedPointInfo.appid.get()))) {
            return localRedPointInfo;
          }
        }
      }
      return null;
    }
    return null;
  }
  
  private static SharedPreferences getSharedPreferences()
  {
    return MobileQQ.sMobileQQ.getSharedPreferences("mobileQQ", 4);
  }
  
  private static String getSharedPreferencesKey(String paramString)
  {
    String str = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static boolean isValidRedPointInfo(String paramString, QQCircleCounter.RedPointInfo paramRedPointInfo)
  {
    if (TextUtils.isEmpty(paramString))
    {
      RFLog.d("QCircleEeveeRedPoint_Util", RFLog.USR, "[filterInvalidRedPointInfo] reddot has been filtered! appid is empty!");
      return false;
    }
    if ((paramRedPointInfo != null) && ("circle_entrance".equals(paramString)))
    {
      int i = paramRedPointInfo.redType.get();
      long l1;
      long l2;
      long l3;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 71)
          {
            l1 = paramRedPointInfo.lastVisitTime.get();
            l2 = getLastOuterEntranceRedPointClearRspTimestamp();
            l3 = getFollowTabFeedListLastRspTimestamp();
            long l4 = getLastReadedOuterEntranceRedPointTimestamp();
            if ((l1 >= l2) && (l1 >= l3) && (l1 >= l4)) {
              bool = true;
            } else {
              bool = false;
            }
            paramString = new StringBuilder();
            paramString.append("[filterInvalidRedPointInfo] OutLayerRedPoint");
            paramString.append(", redDotLastVisitTime: ");
            paramString.append(l1);
            paramString.append(", lastOuterEntranceRedPointClearRspTimestamp: ");
            paramString.append(l2);
            paramString.append(", followTabFeedListLastRspTimestamp: ");
            paramString.append(l3);
            paramString.append(", lastReadedOuterEntranceRedPointTimestamp: ");
            paramString.append(l4);
            paramString.append(", combineRedTypes : ");
            paramString.append(paramRedPointInfo.outLayerInfo.combineRedTypes.get());
            paramString.append(", reportInfo: ");
            paramString.append(paramRedPointInfo.extend.get());
            RFLog.d("QCircleEeveeRedPoint_Util", RFLog.USR, new Object[] { paramString });
            break label541;
          }
        }
        else
        {
          l1 = paramRedPointInfo.lastVisitTime.get();
          l2 = getNoticeFeedListLastRspTimestamp();
          l3 = getLastReadedNumRedPointTimestamp();
          if ((l1 >= l2) && (l1 >= l3)) {
            bool = true;
          } else {
            bool = false;
          }
          paramString = new StringBuilder();
          paramString.append("[filterInvalidRedPointInfo] NumRedPoint");
          paramString.append(", redDotLastVisitTime: ");
          paramString.append(l1);
          paramString.append(", noticeFeedListLastRspTimestamp: ");
          paramString.append(l2);
          paramString.append(", lastReadedNumRedPointTimestamp: ");
          paramString.append(l3);
          paramString.append(", reportInfo: ");
          paramString.append(paramRedPointInfo.extend.get());
          RFLog.d("QCircleEeveeRedPoint_Util", RFLog.USR, new Object[] { paramString });
          break label541;
        }
      }
      else
      {
        l1 = paramRedPointInfo.lastVisitTime.get();
        l2 = getFollowTabFeedListLastRspTimestamp();
        l3 = getLastReadedSmallRedPointTimestamp();
        if ((l1 >= l2) && (l1 >= l3)) {
          bool = true;
        } else {
          bool = false;
        }
        paramString = new StringBuilder();
        paramString.append("[filterInvalidRedPointInfo] SmallRedPoint");
        paramString.append(", redDotLastVisitTime: ");
        paramString.append(l1);
        paramString.append(", followTabFeedListLastRspTimestamp: ");
        paramString.append(l2);
        paramString.append(", lastReadedSmallRedPointTimestamp: ");
        paramString.append(l3);
        paramString.append(", reportInfo: ");
        paramString.append(paramRedPointInfo.extend.get());
        RFLog.d("QCircleEeveeRedPoint_Util", RFLog.USR, new Object[] { paramString });
        break label541;
      }
    }
    boolean bool = true;
    label541:
    if (!bool) {
      RFLog.d("QCircleEeveeRedPoint_Util", RFLog.USR, "[filterInvalidRedPointInfo] reddot has been filtered! ");
    }
    return bool;
  }
  
  public static void saveFolderMessageNoticeBubbleLastExposeNum(int paramInt)
  {
    try
    {
      String str = getSharedPreferencesKey("folder_message_notice_bubble_last_expose_num");
      getSharedPreferences().edit().putInt(str, paramInt).apply();
      int i = RFLog.CLR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveFolderMessageNoticeBubbleLastExposeNum key: ");
      localStringBuilder.append(str);
      localStringBuilder.append(", value: ");
      localStringBuilder.append(paramInt);
      RFLog.d("QCircleEeveeRedPoint_Util", i, localStringBuilder.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      RFLog.e("QCircleEeveeRedPoint_Util", RFLog.CLR, new Object[] { "saveFolderMessageNoticeBubbleLastExposeNum error!", localThrowable });
    }
  }
  
  public static void saveFollowTabClearRedDotDelayInSecond(long paramLong)
  {
    try
    {
      String str = getSharedPreferencesKey("follow_tab_update_notification_show_interval");
      getSharedPreferences().edit().putLong(str, paramLong).apply();
      int i = RFLog.CLR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveFollowTabUpdateNotificationShowInterval key: ");
      localStringBuilder.append(str);
      localStringBuilder.append(", value: ");
      localStringBuilder.append(paramLong);
      RFLog.d("QCircleEeveeRedPoint_Util", i, localStringBuilder.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      RFLog.e("QCircleEeveeRedPoint_Util", RFLog.CLR, new Object[] { "saveFollowTabUpdateNotificationShowInterval error!", localThrowable });
    }
  }
  
  public static void saveFollowTabFeedListLastPreRspTimestamp(long paramLong)
  {
    try
    {
      String str = getSharedPreferencesKey("follow_tab_feed_list_last_pre_rsp_timestamp");
      getSharedPreferences().edit().putLong(str, paramLong).apply();
      int i = RFLog.CLR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveFollowTabFeedListLastPreRspTimestamp key: ");
      localStringBuilder.append(str);
      localStringBuilder.append(", value: ");
      localStringBuilder.append(paramLong);
      RFLog.d("QCircleEeveeRedPoint_Util", i, localStringBuilder.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      RFLog.e("QCircleEeveeRedPoint_Util", RFLog.CLR, new Object[] { "saveFollowTabFeedListLastPreRspTimestamp error!", localThrowable });
    }
  }
  
  public static void saveFollowTabFeedListLastRspTimestamp(long paramLong)
  {
    try
    {
      String str = getSharedPreferencesKey("follow_tab_feed_list_last_rsp_timestamp");
      getSharedPreferences().edit().putLong(str, paramLong).apply();
      int i = RFLog.CLR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveFollowTabFeedListLastRspTimestamp key: ");
      localStringBuilder.append(str);
      localStringBuilder.append(", value: ");
      localStringBuilder.append(paramLong);
      RFLog.d("QCircleEeveeRedPoint_Util", i, localStringBuilder.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      RFLog.e("QCircleEeveeRedPoint_Util", RFLog.CLR, new Object[] { "saveFollowTabFeedListLastRspTimestamp error!", localThrowable });
    }
  }
  
  public static void saveLastOuterEntranceRedPointClearRspTimestamp(long paramLong)
  {
    try
    {
      String str = getSharedPreferencesKey("last_outer_entrance_red_point_clear_rsp_timestamp");
      getSharedPreferences().edit().putLong(str, paramLong).apply();
      int i = RFLog.CLR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveLastOuterEntranceRedPointClearRspTimestamp key: ");
      localStringBuilder.append(str);
      localStringBuilder.append(", value: ");
      localStringBuilder.append(paramLong);
      RFLog.d("QCircleEeveeRedPoint_Util", i, localStringBuilder.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      RFLog.e("QCircleEeveeRedPoint_Util", RFLog.CLR, new Object[] { "saveLastOuterEntranceRedPointClearRspTimestamp error!", localThrowable });
    }
  }
  
  public static void saveLastReadedNumRedPointTimestamp(long paramLong)
  {
    try
    {
      String str = getSharedPreferencesKey("last_readed_num_red_point_timestamp");
      getSharedPreferences().edit().putLong(str, paramLong).apply();
      int i = RFLog.CLR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveLastReadedNumRedPointTimestamp key: ");
      localStringBuilder.append(str);
      localStringBuilder.append(", value: ");
      localStringBuilder.append(paramLong);
      RFLog.d("QCircleEeveeRedPoint_Util", i, localStringBuilder.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      RFLog.e("QCircleEeveeRedPoint_Util", RFLog.CLR, new Object[] { "saveLastReadedNumRedPointTimestamp error!", localThrowable });
    }
  }
  
  public static void saveLastReadedOuterEntranceRedPointTimestamp(long paramLong)
  {
    try
    {
      String str = getSharedPreferencesKey("last_readed_outer_entrance_red_point_timestamp");
      getSharedPreferences().edit().putLong(str, paramLong).apply();
      int i = RFLog.CLR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveLastReadedOuterEntranceRedPointTimestamp key: ");
      localStringBuilder.append(str);
      localStringBuilder.append(", value: ");
      localStringBuilder.append(paramLong);
      RFLog.d("QCircleEeveeRedPoint_Util", i, localStringBuilder.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      RFLog.e("QCircleEeveeRedPoint_Util", RFLog.CLR, new Object[] { "saveLastReadedOuterEntranceRedPointTimestamp error!", localThrowable });
    }
  }
  
  public static void saveLastReadedSmallRedPointTimestamp(long paramLong)
  {
    try
    {
      String str = getSharedPreferencesKey("last_readed_small_red_point_timestamp");
      getSharedPreferences().edit().putLong(str, paramLong).apply();
      int i = RFLog.CLR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveLastReadedSmallRedPointTimestamp key: ");
      localStringBuilder.append(str);
      localStringBuilder.append(", value: ");
      localStringBuilder.append(paramLong);
      RFLog.d("QCircleEeveeRedPoint_Util", i, localStringBuilder.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      RFLog.e("QCircleEeveeRedPoint_Util", RFLog.CLR, new Object[] { "saveLastReadedSmallRedPointTimestamp error!", localThrowable });
    }
  }
  
  public static void saveNoticeFeedListLastRspTimestamp(long paramLong)
  {
    try
    {
      String str = getSharedPreferencesKey("notice_feed_list_last_rsp_timestamp");
      getSharedPreferences().edit().putLong(str, paramLong).apply();
      int i = RFLog.CLR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveNoticeFeedListLastRspTimestamp key: ");
      localStringBuilder.append(str);
      localStringBuilder.append(", value: ");
      localStringBuilder.append(paramLong);
      RFLog.d("QCircleEeveeRedPoint_Util", i, localStringBuilder.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      RFLog.e("QCircleEeveeRedPoint_Util", RFLog.CLR, new Object[] { "saveNoticeFeedListLastRspTimestamp error!", localThrowable });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil
 * JD-Core Version:    0.7.0.1
 */