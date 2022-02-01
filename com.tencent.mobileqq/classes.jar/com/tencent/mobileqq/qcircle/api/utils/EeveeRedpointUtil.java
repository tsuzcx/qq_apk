package com.tencent.mobileqq.qcircle.api.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.IQCircleConfigApi;
import com.tencent.mobileqq.qroute.QRoute;
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
    //   5: astore_1
    //   6: invokestatic 36	com/tencent/mobileqq/qcircle/api/utils/EeveeRedpointUtil:getSharedPreferences	()Landroid/content/SharedPreferences;
    //   9: aload_1
    //   10: iconst_0
    //   11: invokeinterface 42 3 0
    //   16: istore_0
    //   17: ldc 17
    //   19: getstatic 48	com/tencent/biz/richframework/delegate/impl/RFLog:CLR	I
    //   22: new 50	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   29: ldc 53
    //   31: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_1
    //   35: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc 59
    //   40: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_0
    //   44: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 70	com/tencent/biz/richframework/delegate/impl/RFLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: iload_0
    //   54: ireturn
    //   55: astore_1
    //   56: iconst_0
    //   57: istore_0
    //   58: ldc 17
    //   60: getstatic 48	com/tencent/biz/richframework/delegate/impl/RFLog:CLR	I
    //   63: iconst_2
    //   64: anewarray 4	java/lang/Object
    //   67: dup
    //   68: iconst_0
    //   69: ldc 72
    //   71: aastore
    //   72: dup
    //   73: iconst_1
    //   74: aload_1
    //   75: aastore
    //   76: invokestatic 76	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   79: iload_0
    //   80: ireturn
    //   81: astore_1
    //   82: goto -24 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   16	64	0	i	int
    //   5	30	1	str	String
    //   55	20	1	localThrowable1	Throwable
    //   81	1	1	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	17	55	java/lang/Throwable
    //   17	53	81	java/lang/Throwable
  }
  
  public static long getFollowTabClearRedDotDelayInSecond()
  {
    long l2 = ((IQCircleConfigApi)QRoute.api(IQCircleConfigApi.class)).getQQCircleFollowTabUpdateNotificationShowInterval();
    try
    {
      String str = getSharedPreferencesKey("follow_tab_update_notification_show_interval");
      long l1 = getSharedPreferences().getLong(str, l2);
      label91:
      return l1;
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        RFLog.d("QCircleEeveeRedPoint_Util", RFLog.CLR, "getFollowTabUpdateNotificationShowInterval key: " + str + ", result: " + l1 + ", defaultValue: " + l2);
        if (l1 > 0L) {
          return l1;
        }
        return l2;
      }
      catch (Throwable localThrowable2)
      {
        break label91;
      }
      localThrowable1 = localThrowable1;
      l1 = 0L;
      RFLog.e("QCircleEeveeRedPoint_Util", RFLog.CLR, new Object[] { "getFollowTabUpdateNotificationShowInterval error!", localThrowable1 });
      return l1;
    }
  }
  
  /* Error */
  public static long getFollowTabFeedListLastPreRspTimestamp()
  {
    // Byte code:
    //   0: ldc 107
    //   2: invokestatic 32	com/tencent/mobileqq/qcircle/api/utils/EeveeRedpointUtil:getSharedPreferencesKey	(Ljava/lang/String;)Ljava/lang/String;
    //   5: astore_2
    //   6: invokestatic 36	com/tencent/mobileqq/qcircle/api/utils/EeveeRedpointUtil:getSharedPreferences	()Landroid/content/SharedPreferences;
    //   9: aload_2
    //   10: ldc2_w 108
    //   13: invokeinterface 95 4 0
    //   18: lstore_0
    //   19: ldc 17
    //   21: getstatic 48	com/tencent/biz/richframework/delegate/impl/RFLog:CLR	I
    //   24: new 50	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   31: ldc 111
    //   33: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_2
    //   37: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc 59
    //   42: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: lload_0
    //   46: invokevirtual 100	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   49: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 70	com/tencent/biz/richframework/delegate/impl/RFLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: lload_0
    //   56: lreturn
    //   57: astore_2
    //   58: lconst_0
    //   59: lstore_0
    //   60: ldc 17
    //   62: getstatic 48	com/tencent/biz/richframework/delegate/impl/RFLog:CLR	I
    //   65: iconst_2
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: ldc 113
    //   73: aastore
    //   74: dup
    //   75: iconst_1
    //   76: aload_2
    //   77: aastore
    //   78: invokestatic 76	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   81: lload_0
    //   82: lreturn
    //   83: astore_2
    //   84: goto -24 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	64	0	l	long
    //   5	32	2	str	String
    //   57	20	2	localThrowable1	Throwable
    //   83	1	2	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	19	57	java/lang/Throwable
    //   19	55	83	java/lang/Throwable
  }
  
  /* Error */
  public static long getFollowTabFeedListLastRspTimestamp()
  {
    // Byte code:
    //   0: ldc 116
    //   2: invokestatic 32	com/tencent/mobileqq/qcircle/api/utils/EeveeRedpointUtil:getSharedPreferencesKey	(Ljava/lang/String;)Ljava/lang/String;
    //   5: astore_2
    //   6: invokestatic 36	com/tencent/mobileqq/qcircle/api/utils/EeveeRedpointUtil:getSharedPreferences	()Landroid/content/SharedPreferences;
    //   9: aload_2
    //   10: ldc2_w 108
    //   13: invokeinterface 95 4 0
    //   18: lstore_0
    //   19: ldc 17
    //   21: getstatic 48	com/tencent/biz/richframework/delegate/impl/RFLog:CLR	I
    //   24: new 50	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   31: ldc 118
    //   33: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_2
    //   37: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc 59
    //   42: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: lload_0
    //   46: invokevirtual 100	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   49: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 70	com/tencent/biz/richframework/delegate/impl/RFLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: lload_0
    //   56: lreturn
    //   57: astore_2
    //   58: lconst_0
    //   59: lstore_0
    //   60: ldc 17
    //   62: getstatic 48	com/tencent/biz/richframework/delegate/impl/RFLog:CLR	I
    //   65: iconst_2
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: ldc 120
    //   73: aastore
    //   74: dup
    //   75: iconst_1
    //   76: aload_2
    //   77: aastore
    //   78: invokestatic 76	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   81: lload_0
    //   82: lreturn
    //   83: astore_2
    //   84: goto -24 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	64	0	l	long
    //   5	32	2	str	String
    //   57	20	2	localThrowable1	Throwable
    //   83	1	2	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	19	57	java/lang/Throwable
    //   19	55	83	java/lang/Throwable
  }
  
  /* Error */
  public static long getLastOuterEntranceRedPointClearRspTimestamp()
  {
    // Byte code:
    //   0: ldc 123
    //   2: invokestatic 32	com/tencent/mobileqq/qcircle/api/utils/EeveeRedpointUtil:getSharedPreferencesKey	(Ljava/lang/String;)Ljava/lang/String;
    //   5: astore_2
    //   6: invokestatic 36	com/tencent/mobileqq/qcircle/api/utils/EeveeRedpointUtil:getSharedPreferences	()Landroid/content/SharedPreferences;
    //   9: aload_2
    //   10: ldc2_w 108
    //   13: invokeinterface 95 4 0
    //   18: lstore_0
    //   19: ldc 17
    //   21: getstatic 48	com/tencent/biz/richframework/delegate/impl/RFLog:CLR	I
    //   24: new 50	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   31: ldc 125
    //   33: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_2
    //   37: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc 59
    //   42: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: lload_0
    //   46: invokevirtual 100	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   49: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 70	com/tencent/biz/richframework/delegate/impl/RFLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: lload_0
    //   56: lreturn
    //   57: astore_2
    //   58: lconst_0
    //   59: lstore_0
    //   60: ldc 17
    //   62: getstatic 48	com/tencent/biz/richframework/delegate/impl/RFLog:CLR	I
    //   65: iconst_2
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: ldc 127
    //   73: aastore
    //   74: dup
    //   75: iconst_1
    //   76: aload_2
    //   77: aastore
    //   78: invokestatic 76	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   81: lload_0
    //   82: lreturn
    //   83: astore_2
    //   84: goto -24 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	64	0	l	long
    //   5	32	2	str	String
    //   57	20	2	localThrowable1	Throwable
    //   83	1	2	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	19	57	java/lang/Throwable
    //   19	55	83	java/lang/Throwable
  }
  
  /* Error */
  public static long getLastReadedNumRedPointTimestamp()
  {
    // Byte code:
    //   0: ldc 130
    //   2: invokestatic 32	com/tencent/mobileqq/qcircle/api/utils/EeveeRedpointUtil:getSharedPreferencesKey	(Ljava/lang/String;)Ljava/lang/String;
    //   5: astore_2
    //   6: invokestatic 36	com/tencent/mobileqq/qcircle/api/utils/EeveeRedpointUtil:getSharedPreferences	()Landroid/content/SharedPreferences;
    //   9: aload_2
    //   10: ldc2_w 108
    //   13: invokeinterface 95 4 0
    //   18: lstore_0
    //   19: ldc 17
    //   21: getstatic 48	com/tencent/biz/richframework/delegate/impl/RFLog:CLR	I
    //   24: new 50	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   31: ldc 132
    //   33: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_2
    //   37: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc 59
    //   42: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: lload_0
    //   46: invokevirtual 100	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   49: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 70	com/tencent/biz/richframework/delegate/impl/RFLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: lload_0
    //   56: lreturn
    //   57: astore_2
    //   58: lconst_0
    //   59: lstore_0
    //   60: ldc 17
    //   62: getstatic 48	com/tencent/biz/richframework/delegate/impl/RFLog:CLR	I
    //   65: iconst_2
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: ldc 134
    //   73: aastore
    //   74: dup
    //   75: iconst_1
    //   76: aload_2
    //   77: aastore
    //   78: invokestatic 76	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   81: lload_0
    //   82: lreturn
    //   83: astore_2
    //   84: goto -24 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	64	0	l	long
    //   5	32	2	str	String
    //   57	20	2	localThrowable1	Throwable
    //   83	1	2	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	19	57	java/lang/Throwable
    //   19	55	83	java/lang/Throwable
  }
  
  /* Error */
  public static long getLastReadedOuterEntranceRedPointTimestamp()
  {
    // Byte code:
    //   0: ldc 137
    //   2: invokestatic 32	com/tencent/mobileqq/qcircle/api/utils/EeveeRedpointUtil:getSharedPreferencesKey	(Ljava/lang/String;)Ljava/lang/String;
    //   5: astore_2
    //   6: invokestatic 36	com/tencent/mobileqq/qcircle/api/utils/EeveeRedpointUtil:getSharedPreferences	()Landroid/content/SharedPreferences;
    //   9: aload_2
    //   10: ldc2_w 108
    //   13: invokeinterface 95 4 0
    //   18: lstore_0
    //   19: ldc 17
    //   21: getstatic 48	com/tencent/biz/richframework/delegate/impl/RFLog:CLR	I
    //   24: new 50	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   31: ldc 139
    //   33: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_2
    //   37: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc 59
    //   42: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: lload_0
    //   46: invokevirtual 100	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   49: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 70	com/tencent/biz/richframework/delegate/impl/RFLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: lload_0
    //   56: lreturn
    //   57: astore_2
    //   58: lconst_0
    //   59: lstore_0
    //   60: ldc 17
    //   62: getstatic 48	com/tencent/biz/richframework/delegate/impl/RFLog:CLR	I
    //   65: iconst_2
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: ldc 141
    //   73: aastore
    //   74: dup
    //   75: iconst_1
    //   76: aload_2
    //   77: aastore
    //   78: invokestatic 76	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   81: lload_0
    //   82: lreturn
    //   83: astore_2
    //   84: goto -24 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	64	0	l	long
    //   5	32	2	str	String
    //   57	20	2	localThrowable1	Throwable
    //   83	1	2	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	19	57	java/lang/Throwable
    //   19	55	83	java/lang/Throwable
  }
  
  /* Error */
  public static long getLastReadedSmallRedPointTimestamp()
  {
    // Byte code:
    //   0: ldc 144
    //   2: invokestatic 32	com/tencent/mobileqq/qcircle/api/utils/EeveeRedpointUtil:getSharedPreferencesKey	(Ljava/lang/String;)Ljava/lang/String;
    //   5: astore_2
    //   6: invokestatic 36	com/tencent/mobileqq/qcircle/api/utils/EeveeRedpointUtil:getSharedPreferences	()Landroid/content/SharedPreferences;
    //   9: aload_2
    //   10: ldc2_w 108
    //   13: invokeinterface 95 4 0
    //   18: lstore_0
    //   19: ldc 17
    //   21: getstatic 48	com/tencent/biz/richframework/delegate/impl/RFLog:CLR	I
    //   24: new 50	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   31: ldc 146
    //   33: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_2
    //   37: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc 59
    //   42: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: lload_0
    //   46: invokevirtual 100	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   49: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 70	com/tencent/biz/richframework/delegate/impl/RFLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: lload_0
    //   56: lreturn
    //   57: astore_2
    //   58: lconst_0
    //   59: lstore_0
    //   60: ldc 17
    //   62: getstatic 48	com/tencent/biz/richframework/delegate/impl/RFLog:CLR	I
    //   65: iconst_2
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: ldc 148
    //   73: aastore
    //   74: dup
    //   75: iconst_1
    //   76: aload_2
    //   77: aastore
    //   78: invokestatic 76	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   81: lload_0
    //   82: lreturn
    //   83: astore_2
    //   84: goto -24 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	64	0	l	long
    //   5	32	2	str	String
    //   57	20	2	localThrowable1	Throwable
    //   83	1	2	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	19	57	java/lang/Throwable
    //   19	55	83	java/lang/Throwable
  }
  
  /* Error */
  public static long getNoticeFeedListLastRspTimestamp()
  {
    // Byte code:
    //   0: ldc 151
    //   2: invokestatic 32	com/tencent/mobileqq/qcircle/api/utils/EeveeRedpointUtil:getSharedPreferencesKey	(Ljava/lang/String;)Ljava/lang/String;
    //   5: astore_2
    //   6: invokestatic 36	com/tencent/mobileqq/qcircle/api/utils/EeveeRedpointUtil:getSharedPreferences	()Landroid/content/SharedPreferences;
    //   9: aload_2
    //   10: ldc2_w 108
    //   13: invokeinterface 95 4 0
    //   18: lstore_0
    //   19: ldc 17
    //   21: getstatic 48	com/tencent/biz/richframework/delegate/impl/RFLog:CLR	I
    //   24: new 50	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   31: ldc 153
    //   33: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_2
    //   37: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc 59
    //   42: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: lload_0
    //   46: invokevirtual 100	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   49: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 70	com/tencent/biz/richframework/delegate/impl/RFLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: lload_0
    //   56: lreturn
    //   57: astore_2
    //   58: lconst_0
    //   59: lstore_0
    //   60: ldc 17
    //   62: getstatic 48	com/tencent/biz/richframework/delegate/impl/RFLog:CLR	I
    //   65: iconst_2
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: ldc 155
    //   73: aastore
    //   74: dup
    //   75: iconst_1
    //   76: aload_2
    //   77: aastore
    //   78: invokestatic 76	com/tencent/biz/richframework/delegate/impl/RFLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   81: lload_0
    //   82: lreturn
    //   83: astore_2
    //   84: goto -24 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	64	0	l	long
    //   5	32	2	str	String
    //   57	20	2	localThrowable1	Throwable
    //   83	1	2	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	19	57	java/lang/Throwable
    //   19	55	83	java/lang/Throwable
  }
  
  public static QQCircleCounter.RedPointInfo getRedPointInfoByAppid(String paramString, QQCircleCounter.CountInfoRsp paramCountInfoRsp)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramCountInfoRsp == null)) {
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
  
  private static SharedPreferences getSharedPreferences()
  {
    return MobileQQ.sMobileQQ.getSharedPreferences("mobileQQ", 4);
  }
  
  private static String getSharedPreferencesKey(String paramString)
  {
    String str = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
    return str + paramString;
  }
  
  public static boolean isValidRedPointInfo(String paramString, QQCircleCounter.RedPointInfo paramRedPointInfo)
  {
    boolean bool2 = false;
    if (TextUtils.isEmpty(paramString)) {
      RFLog.d("QCircleEeveeRedPoint_Util", RFLog.USR, "[filterInvalidRedPointInfo] reddot has been filtered! appid is empty!");
    }
    do
    {
      return bool2;
      if ((paramRedPointInfo != null) && ("circle_entrance".equals(paramString))) {}
      switch (paramRedPointInfo.redType.get())
      {
      default: 
        bool1 = true;
        bool2 = bool1;
      }
    } while (bool1);
    RFLog.d("QCircleEeveeRedPoint_Util", RFLog.USR, "[filterInvalidRedPointInfo] reddot has been filtered! ");
    return bool1;
    long l1 = paramRedPointInfo.lastVisitTime.get();
    long l2 = getFollowTabFeedListLastRspTimestamp();
    long l3 = getLastReadedSmallRedPointTimestamp();
    if ((l1 < l2) || (l1 < l3)) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      paramString = new StringBuilder();
      paramString.append("[filterInvalidRedPointInfo] SmallRedPoint").append(", redDotLastVisitTime: ").append(l1).append(", followTabFeedListLastRspTimestamp: ").append(l2).append(", lastReadedSmallRedPointTimestamp: ").append(l3).append(", reportInfo: ").append(paramRedPointInfo.extend.get());
      RFLog.d("QCircleEeveeRedPoint_Util", RFLog.USR, new Object[] { paramString });
      break;
      l1 = paramRedPointInfo.lastVisitTime.get();
      l2 = getNoticeFeedListLastRspTimestamp();
      l3 = getLastReadedNumRedPointTimestamp();
      if ((l1 < l2) || (l1 < l3)) {}
      for (bool1 = false;; bool1 = true)
      {
        paramString = new StringBuilder();
        paramString.append("[filterInvalidRedPointInfo] NumRedPoint").append(", redDotLastVisitTime: ").append(l1).append(", noticeFeedListLastRspTimestamp: ").append(l2).append(", lastReadedNumRedPointTimestamp: ").append(l3).append(", reportInfo: ").append(paramRedPointInfo.extend.get());
        RFLog.d("QCircleEeveeRedPoint_Util", RFLog.USR, new Object[] { paramString });
        break;
        l1 = paramRedPointInfo.lastVisitTime.get();
        l2 = getLastOuterEntranceRedPointClearRspTimestamp();
        l3 = getFollowTabFeedListLastRspTimestamp();
        long l4 = getLastReadedOuterEntranceRedPointTimestamp();
        if ((l1 < l2) || (l1 < l3) || (l1 < l4)) {}
        for (bool1 = false;; bool1 = true)
        {
          paramString = new StringBuilder();
          paramString.append("[filterInvalidRedPointInfo] OutLayerRedPoint").append(", redDotLastVisitTime: ").append(l1).append(", lastOuterEntranceRedPointClearRspTimestamp: ").append(l2).append(", followTabFeedListLastRspTimestamp: ").append(l3).append(", lastReadedOuterEntranceRedPointTimestamp: ").append(l4).append(", combineRedTypes : ").append(paramRedPointInfo.outLayerInfo.combineRedTypes.get()).append(", reportInfo: ").append(paramRedPointInfo.extend.get());
          RFLog.d("QCircleEeveeRedPoint_Util", RFLog.USR, new Object[] { paramString });
          break;
        }
      }
    }
  }
  
  public static void saveFolderMessageNoticeBubbleLastExposeNum(int paramInt)
  {
    try
    {
      String str = getSharedPreferencesKey("folder_message_notice_bubble_last_expose_num");
      getSharedPreferences().edit().putInt(str, paramInt).apply();
      RFLog.d("QCircleEeveeRedPoint_Util", RFLog.CLR, "saveFolderMessageNoticeBubbleLastExposeNum key: " + str + ", value: " + paramInt);
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
      RFLog.d("QCircleEeveeRedPoint_Util", RFLog.CLR, "saveFollowTabUpdateNotificationShowInterval key: " + str + ", value: " + paramLong);
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
      RFLog.d("QCircleEeveeRedPoint_Util", RFLog.CLR, "saveFollowTabFeedListLastPreRspTimestamp key: " + str + ", value: " + paramLong);
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
      RFLog.d("QCircleEeveeRedPoint_Util", RFLog.CLR, "saveFollowTabFeedListLastRspTimestamp key: " + str + ", value: " + paramLong);
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
      RFLog.d("QCircleEeveeRedPoint_Util", RFLog.CLR, "saveLastOuterEntranceRedPointClearRspTimestamp key: " + str + ", value: " + paramLong);
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
      RFLog.d("QCircleEeveeRedPoint_Util", RFLog.CLR, "saveLastReadedNumRedPointTimestamp key: " + str + ", value: " + paramLong);
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
      RFLog.d("QCircleEeveeRedPoint_Util", RFLog.CLR, "saveLastReadedOuterEntranceRedPointTimestamp key: " + str + ", value: " + paramLong);
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
      RFLog.d("QCircleEeveeRedPoint_Util", RFLog.CLR, "saveLastReadedSmallRedPointTimestamp key: " + str + ", value: " + paramLong);
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
      RFLog.d("QCircleEeveeRedPoint_Util", RFLog.CLR, "saveNoticeFeedListLastRspTimestamp key: " + str + ", value: " + paramLong);
      return;
    }
    catch (Throwable localThrowable)
    {
      RFLog.e("QCircleEeveeRedPoint_Util", RFLog.CLR, new Object[] { "saveNoticeFeedListLastRspTimestamp error!", localThrowable });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil
 * JD-Core Version:    0.7.0.1
 */