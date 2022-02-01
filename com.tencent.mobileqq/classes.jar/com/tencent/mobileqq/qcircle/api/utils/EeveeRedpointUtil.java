package com.tencent.mobileqq.qcircle.api.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.IQCircleConfigApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
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
  
  public static int getFolderMessageNoticeBubbleLastExposeNum()
  {
    int j = 0;
    int i = j;
    try
    {
      String str = getSharedPreferencesKey("folder_message_notice_bubble_last_expose_num");
      i = j;
      j = getSharedPreferences().getInt(str, 0);
      i = j;
      StringBuilder localStringBuilder = new StringBuilder();
      i = j;
      localStringBuilder.append("getFolderMessageNoticeBubbleLastExposeNum key: ");
      i = j;
      localStringBuilder.append(str);
      i = j;
      localStringBuilder.append(", result: ");
      i = j;
      localStringBuilder.append(j);
      i = j;
      QLog.d("QCircleEeveeRedPoint_Util", 2, localStringBuilder.toString());
      return j;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QCircleEeveeRedPoint_Util", 2, "getFolderMessageNoticeBubbleLastExposeNum error!", localThrowable);
    }
    return i;
  }
  
  public static long getFollowTabClearRedDotDelayInSecond()
  {
    long l3 = ((IQCircleConfigApi)QRoute.api(IQCircleConfigApi.class)).getQQCircleFollowTabUpdateNotificationShowInterval();
    long l1;
    try
    {
      String str = getSharedPreferencesKey("follow_tab_update_notification_show_interval");
      l1 = getSharedPreferences().getLong(str, l3);
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getFollowTabUpdateNotificationShowInterval key: ");
        localStringBuilder.append(str);
        localStringBuilder.append(", result: ");
        localStringBuilder.append(l1);
        localStringBuilder.append(", defaultValue: ");
        localStringBuilder.append(l3);
        QLog.d("QCircleEeveeRedPoint_Util", 2, localStringBuilder.toString());
        l2 = l1;
        if (l1 > 0L) {
          return l2;
        }
        return l3;
      }
      catch (Throwable localThrowable1) {}
      QLog.e("QCircleEeveeRedPoint_Util", 2, "getFollowTabUpdateNotificationShowInterval error!", localThrowable2);
    }
    catch (Throwable localThrowable2)
    {
      l1 = 0L;
    }
    long l2 = l1;
    return l2;
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
      QLog.d("QCircleEeveeRedPoint_Util", 2, localStringBuilder.toString());
      return l2;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QCircleEeveeRedPoint_Util", 2, "getFollowTabFeedListLastPreRspTimestamp error!", localThrowable);
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
      QLog.d("QCircleEeveeRedPoint_Util", 2, localStringBuilder.toString());
      return l2;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QCircleEeveeRedPoint_Util", 2, "getFollowTabFeedListLastRspTimestamp error!", localThrowable);
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
      QLog.d("QCircleEeveeRedPoint_Util", 2, localStringBuilder.toString());
      return l2;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QCircleEeveeRedPoint_Util", 2, "getLastOuterEntranceRedPointClearRspTimestamp error!", localThrowable);
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
      QLog.d("QCircleEeveeRedPoint_Util", 2, localStringBuilder.toString());
      return l2;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QCircleEeveeRedPoint_Util", 2, "getLastReadedNumRedPointTimestamp error!", localThrowable);
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
      QLog.d("QCircleEeveeRedPoint_Util", 2, localStringBuilder.toString());
      return l2;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QCircleEeveeRedPoint_Util", 2, "getLastReadedOuterEntranceRedPointTimestamp error!", localThrowable);
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
      QLog.d("QCircleEeveeRedPoint_Util", 2, localStringBuilder.toString());
      return l2;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QCircleEeveeRedPoint_Util", 2, "getLastReadedSmallRedPointTimestamp error!", localThrowable);
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
      QLog.d("QCircleEeveeRedPoint_Util", 2, localStringBuilder.toString());
      return l2;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QCircleEeveeRedPoint_Util", 2, "getNoticeFeedListLastRspTimestamp error!", localThrowable);
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
      QLog.d("QCircleEeveeRedPoint_Util", 1, "[filterInvalidRedPointInfo] reddot has been filtered! appid is empty!");
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
            QLog.d("QCircleEeveeRedPoint_Util", 1, new Object[] { paramString });
            break label533;
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
          QLog.d("QCircleEeveeRedPoint_Util", 1, new Object[] { paramString });
          break label533;
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
        QLog.d("QCircleEeveeRedPoint_Util", 1, new Object[] { paramString });
        break label533;
      }
    }
    boolean bool = true;
    label533:
    if (!bool) {
      QLog.d("QCircleEeveeRedPoint_Util", 1, "[filterInvalidRedPointInfo] reddot has been filtered! ");
    }
    return bool;
  }
  
  public static void saveFolderMessageNoticeBubbleLastExposeNum(int paramInt)
  {
    try
    {
      String str = getSharedPreferencesKey("folder_message_notice_bubble_last_expose_num");
      getSharedPreferences().edit().putInt(str, paramInt).apply();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveFolderMessageNoticeBubbleLastExposeNum key: ");
      localStringBuilder.append(str);
      localStringBuilder.append(", value: ");
      localStringBuilder.append(paramInt);
      QLog.d("QCircleEeveeRedPoint_Util", 2, localStringBuilder.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QCircleEeveeRedPoint_Util", 2, "saveFolderMessageNoticeBubbleLastExposeNum error!", localThrowable);
    }
  }
  
  public static void saveFollowTabClearRedDotDelayInSecond(long paramLong)
  {
    try
    {
      String str = getSharedPreferencesKey("follow_tab_update_notification_show_interval");
      getSharedPreferences().edit().putLong(str, paramLong).apply();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveFollowTabUpdateNotificationShowInterval key: ");
      localStringBuilder.append(str);
      localStringBuilder.append(", value: ");
      localStringBuilder.append(paramLong);
      QLog.d("QCircleEeveeRedPoint_Util", 2, localStringBuilder.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QCircleEeveeRedPoint_Util", 2, "saveFollowTabUpdateNotificationShowInterval error!", localThrowable);
    }
  }
  
  public static void saveFollowTabFeedListLastPreRspTimestamp(long paramLong)
  {
    try
    {
      String str = getSharedPreferencesKey("follow_tab_feed_list_last_pre_rsp_timestamp");
      getSharedPreferences().edit().putLong(str, paramLong).apply();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveFollowTabFeedListLastPreRspTimestamp key: ");
      localStringBuilder.append(str);
      localStringBuilder.append(", value: ");
      localStringBuilder.append(paramLong);
      QLog.d("QCircleEeveeRedPoint_Util", 2, localStringBuilder.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QCircleEeveeRedPoint_Util", 2, "saveFollowTabFeedListLastPreRspTimestamp error!", localThrowable);
    }
  }
  
  public static void saveFollowTabFeedListLastRspTimestamp(long paramLong)
  {
    try
    {
      String str = getSharedPreferencesKey("follow_tab_feed_list_last_rsp_timestamp");
      getSharedPreferences().edit().putLong(str, paramLong).apply();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveFollowTabFeedListLastRspTimestamp key: ");
      localStringBuilder.append(str);
      localStringBuilder.append(", value: ");
      localStringBuilder.append(paramLong);
      QLog.d("QCircleEeveeRedPoint_Util", 2, localStringBuilder.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QCircleEeveeRedPoint_Util", 2, "saveFollowTabFeedListLastRspTimestamp error!", localThrowable);
    }
  }
  
  public static void saveLastOuterEntranceRedPointClearRspTimestamp(long paramLong)
  {
    try
    {
      String str = getSharedPreferencesKey("last_outer_entrance_red_point_clear_rsp_timestamp");
      getSharedPreferences().edit().putLong(str, paramLong).apply();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveLastOuterEntranceRedPointClearRspTimestamp key: ");
      localStringBuilder.append(str);
      localStringBuilder.append(", value: ");
      localStringBuilder.append(paramLong);
      QLog.d("QCircleEeveeRedPoint_Util", 2, localStringBuilder.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QCircleEeveeRedPoint_Util", 2, "saveLastOuterEntranceRedPointClearRspTimestamp error!", localThrowable);
    }
  }
  
  public static void saveLastReadedNumRedPointTimestamp(long paramLong)
  {
    try
    {
      String str = getSharedPreferencesKey("last_readed_num_red_point_timestamp");
      getSharedPreferences().edit().putLong(str, paramLong).apply();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveLastReadedNumRedPointTimestamp key: ");
      localStringBuilder.append(str);
      localStringBuilder.append(", value: ");
      localStringBuilder.append(paramLong);
      QLog.d("QCircleEeveeRedPoint_Util", 2, localStringBuilder.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QCircleEeveeRedPoint_Util", 2, "saveLastReadedNumRedPointTimestamp error!", localThrowable);
    }
  }
  
  public static void saveLastReadedOuterEntranceRedPointTimestamp(long paramLong)
  {
    try
    {
      String str = getSharedPreferencesKey("last_readed_outer_entrance_red_point_timestamp");
      getSharedPreferences().edit().putLong(str, paramLong).apply();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveLastReadedOuterEntranceRedPointTimestamp key: ");
      localStringBuilder.append(str);
      localStringBuilder.append(", value: ");
      localStringBuilder.append(paramLong);
      QLog.d("QCircleEeveeRedPoint_Util", 2, localStringBuilder.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QCircleEeveeRedPoint_Util", 2, "saveLastReadedOuterEntranceRedPointTimestamp error!", localThrowable);
    }
  }
  
  public static void saveLastReadedSmallRedPointTimestamp(long paramLong)
  {
    try
    {
      String str = getSharedPreferencesKey("last_readed_small_red_point_timestamp");
      getSharedPreferences().edit().putLong(str, paramLong).apply();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveLastReadedSmallRedPointTimestamp key: ");
      localStringBuilder.append(str);
      localStringBuilder.append(", value: ");
      localStringBuilder.append(paramLong);
      QLog.d("QCircleEeveeRedPoint_Util", 2, localStringBuilder.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QCircleEeveeRedPoint_Util", 2, "saveLastReadedSmallRedPointTimestamp error!", localThrowable);
    }
  }
  
  public static void saveNoticeFeedListLastRspTimestamp(long paramLong)
  {
    try
    {
      String str = getSharedPreferencesKey("notice_feed_list_last_rsp_timestamp");
      getSharedPreferences().edit().putLong(str, paramLong).apply();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveNoticeFeedListLastRspTimestamp key: ");
      localStringBuilder.append(str);
      localStringBuilder.append(", value: ");
      localStringBuilder.append(paramLong);
      QLog.d("QCircleEeveeRedPoint_Util", 2, localStringBuilder.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QCircleEeveeRedPoint_Util", 2, "saveNoticeFeedListLastRspTimestamp error!", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil
 * JD-Core Version:    0.7.0.1
 */