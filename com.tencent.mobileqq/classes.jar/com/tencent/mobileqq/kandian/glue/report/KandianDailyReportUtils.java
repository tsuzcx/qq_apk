package com.tencent.mobileqq.kandian.glue.report;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.push.RIJLockScreenPushReport;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianDailyManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.kandian.repo.account.api.IUserOperationModule;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.DailyFloatingWindowData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.KandianRedDotInfo;
import com.tencent.mobileqq.kandian.repo.reddot.RIJKanDianRedDotUtils;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class KandianDailyReportUtils
{
  private static volatile int jdField_a_of_type_Int;
  public static long a;
  public static String a;
  private static ArrayList<ReportInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public static Map<Long, Pair<Long, Long>> a;
  private static boolean jdField_a_of_type_Boolean = false;
  private static Map<String, String> b = new HashMap();
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_JavaUtilMap = new HashMap();
    b();
  }
  
  public static int a()
  {
    Object localObject1 = RecentDataListManager.a().a;
    if (localObject1 == null) {
      return 2147483647;
    }
    localObject1 = new ArrayList((Collection)localObject1);
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      RecentUserBaseData localRecentUserBaseData = (RecentUserBaseData)((Iterator)localObject2).next();
      if ((localRecentUserBaseData != null) && (localRecentUserBaseData.mUser != null) && (localRecentUserBaseData.mUser.getType() == 1008) && (ServiceAccountFolderManager.b((QQAppInterface)ReadInJoyUtils.a(), localRecentUserBaseData.mUser.uin))) {
        ((Iterator)localObject2).remove();
      }
    }
    int i = 0;
    while (i < ((List)localObject1).size())
    {
      localObject2 = (RecentUserBaseData)((List)localObject1).get(i);
      if ((localObject2 != null) && (((RecentUserBaseData)localObject2).mUser != null) && (((RecentUserBaseData)localObject2).mUser.getType() == 1008) && (TextUtils.equals(((RecentUserBaseData)localObject2).mUser.uin, AppConstants.KANDIAN_DAILY_UIN))) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static Pair<Long, Long> a(long paramLong)
  {
    if (jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong))) {
      return (Pair)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    }
    return null;
  }
  
  public static String a()
  {
    Object localObject1 = b;
    if (localObject1 != null) {
      localObject1 = (String)((Map)localObject1).get("folder_status");
    } else {
      localObject1 = "1";
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
    else
    {
      localObject2 = "1";
    }
    return localObject2;
  }
  
  public static Map<String, String> a()
  {
    return b;
  }
  
  public static void a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
    if (localQQAppInterface == null) {
      return;
    }
    MessageRecord localMessageRecord = localQQAppInterface.getMessageFacade().b(AppConstants.KANDIAN_DAILY_UIN, 1008);
    if ((localMessageRecord != null) && (!localMessageRecord.isread))
    {
      if (localMessageRecord.extLong != 1) {
        return;
      }
      ThreadManager.post(new KandianDailyReportUtils.1(localMessageRecord, localQQAppInterface), 8, null, false);
      a(1, "0X8009867", localMessageRecord);
      b();
    }
  }
  
  public static void a(int paramInt)
  {
    jdField_a_of_type_Int |= paramInt;
    if (DailyModeConfigHandler.b(DailyModeConfigHandler.b())) {
      ReadinjoySPEventReport.e(1);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set operation flag : ");
    localStringBuilder.append(paramInt);
    QLog.d("KandianDailyReportUtils", 2, localStringBuilder.toString());
  }
  
  private static void a(int paramInt, String paramString, MessageRecord paramMessageRecord)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getPubAccountRecentUserPosInMessageList(AppConstants.KANDIAN_DAILY_UIN));
    ((StringBuilder)localObject1).append("");
    String str2 = ((StringBuilder)localObject1).toString();
    KandianRedDotInfo localKandianRedDotInfo = RIJKanDianRedDotUtils.a(paramMessageRecord, "kandian_daily_red_pnt");
    int i = 0;
    String str1 = null;
    Object localObject2 = null;
    Object localObject4;
    Object localObject3;
    if (localKandianRedDotInfo != null)
    {
      localObject1 = localObject2;
      if (localKandianRedDotInfo.articleIDList != null)
      {
        localObject1 = localObject2;
        if (!localKandianRedDotInfo.articleIDList.isEmpty())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(localKandianRedDotInfo.articleIDList.get(0));
          ((StringBuilder)localObject1).append("");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localKandianRedDotInfo.strategyID);
      ((StringBuilder)localObject2).append("");
      localObject4 = ((StringBuilder)localObject2).toString();
      localObject2 = localKandianRedDotInfo.forderStatus;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(localKandianRedDotInfo.algorithmID);
      ((StringBuilder)localObject3).append("");
      str1 = ((StringBuilder)localObject3).toString();
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = str1;
    }
    else
    {
      localObject2 = null;
      localObject1 = localObject2;
      localObject4 = localObject1;
      localObject3 = localObject1;
      localObject1 = str1;
    }
    if ((paramInt == 0) && (paramMessageRecord.isread)) {
      localObject1 = "1";
    }
    if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).caculateMsgTabRedPntExcludeSelf(AppConstants.KANDIAN_DAILY_UIN) > 0) {
      i = 1;
    }
    str1 = KandianDailyManager.jdField_a_of_type_JavaLangString;
    if ((paramMessageRecord instanceof MessageForStructing)) {
      str1 = KandianDailyManager.a((MessageForStructing)paramMessageRecord);
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("folder_status", localObject1);
      localJSONObject.put("message_status", i);
      localJSONObject.put("algorithm_id", localObject2);
      localJSONObject.put("name", str1);
      localJSONObject.put("time", NetConnInfoCenter.getServerTimeMillis());
      localJSONObject.put("version", VideoReporter.jdField_a_of_type_JavaLangString);
      localJSONObject.put("os", "1");
      localJSONObject.put("channel_id", b());
      if (localKandianRedDotInfo != null)
      {
        if (!TextUtils.isEmpty(localKandianRedDotInfo.rowkey)) {
          localJSONObject.put("push_rowkey", localKandianRedDotInfo.rowkey);
        }
        localJSONObject.put("push_type", localKandianRedDotInfo.floatingWinData.type);
        if (!TextUtils.isEmpty(localKandianRedDotInfo.floatingWinData.topicID)) {
          localJSONObject.put("push_topic", localKandianRedDotInfo.floatingWinData.topicID);
        }
      }
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", paramString, paramString, 0, 0, str2, (String)localObject3, (String)localObject4, localJSONObject.toString(), false);
    if (!paramMessageRecord.isread)
    {
      paramString = new ArrayList();
      paramMessageRecord = new ReportInfo();
      i = 20;
      if ((paramInt != 1) && (paramInt == 0)) {
        i = 21;
      }
      paramMessageRecord.mOperation = i;
      paramMessageRecord.mOpSource = 16;
      paramMessageRecord.mUin = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin();
      try
      {
        paramMessageRecord.mSourceArticleId = Long.valueOf((String)localObject3).longValue();
        paramMessageRecord.mAlgorithmId = Integer.valueOf((String)localObject2).intValue();
        paramMessageRecord.mStrategyId = Integer.valueOf((String)localObject4).intValue();
        long l;
        if (TextUtils.isEmpty("")) {
          l = -1L;
        } else {
          l = Long.valueOf("").longValue();
        }
        paramMessageRecord.mPuin = l;
        paramMessageRecord.mFolderStatus = Integer.valueOf((String)localObject1).intValue();
        if ((localKandianRedDotInfo != null) && (!TextUtils.isEmpty(localKandianRedDotInfo.rowkey))) {
          paramMessageRecord.mInnerId = localKandianRedDotInfo.rowkey;
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
      paramString.add(paramMessageRecord);
      ((IUserOperationModule)QRoute.api(IUserOperationModule.class)).request0x64eUserOperationReport(paramString);
    }
  }
  
  public static void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    int i = paramIntent.getIntExtra("launch_from", 5);
    if ((i == 6) || (i == 9))
    {
      a((KandianRedDotInfo)paramIntent.getSerializableExtra("kandian_feeds_red_pnt_info"));
      if (i == 6) {
        RIJLockScreenPushReport.a((KandianRedDotInfo)paramIntent.getSerializableExtra("daily_lock_screen_report_red_info"));
      }
    }
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    a(0, "0X8009868", paramMessageRecord);
  }
  
  public static void a(KandianRedDotInfo paramKandianRedDotInfo)
  {
    if (paramKandianRedDotInfo == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("folder_status", paramKandianRedDotInfo.forderStatus);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramKandianRedDotInfo.algorithmID);
    localStringBuilder.append("");
    localHashMap.put("algorithm_id", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramKandianRedDotInfo.strategyID);
    localStringBuilder.append("");
    localHashMap.put("strategy_id", localStringBuilder.toString());
    b = localHashMap;
  }
  
  public static void a(ReportInfo paramReportInfo)
  {
    ThreadManager.executeOnSubThread(new KandianDailyReportUtils.3(paramReportInfo));
  }
  
  public static void a(List<AbsBaseArticleInfo> paramList, List<Long> paramList1, boolean paramBoolean)
  {
    if (paramList != null)
    {
      if (paramList1 == null) {
        return;
      }
      Collections.sort(paramList, new KandianDailyReportUtils.2());
      StringBuilder localStringBuilder = new StringBuilder(1024);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramList.next();
        if ((RIJFeedsType.a(localAbsBaseArticleInfo) > 0) && (paramList1.contains(Long.valueOf(localAbsBaseArticleInfo.mRecommendSeq))))
        {
          Object localObject = jdField_a_of_type_JavaUtilMap;
          long l2 = localAbsBaseArticleInfo.mArticleID;
          long l3 = jdField_a_of_type_Long;
          jdField_a_of_type_Long = l3 + 1L;
          long l1;
          if (paramBoolean) {
            l1 = 1L;
          } else {
            l1 = 0L;
          }
          ((Map)localObject).put(Long.valueOf(l2), new Pair(Long.valueOf(l3), Long.valueOf(l1)));
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("articleID : ");
          ((StringBuilder)localObject).append(localAbsBaseArticleInfo.mArticleID);
          ((StringBuilder)localObject).append(", pos : ");
          ((StringBuilder)localObject).append(jdField_a_of_type_Long - 1L);
          ((StringBuilder)localObject).append("\n");
          localStringBuilder.append(((StringBuilder)localObject).toString());
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("KandianDailyReportUtils", 2, localStringBuilder.toString());
      }
    }
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    long l1 = 0L;
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_JavaUtilMap.clear();
    if (paramAppRuntime != null) {
      l1 = paramAppRuntime.getLongAccountUin();
    }
    long l2 = System.currentTimeMillis();
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append(l1);
    paramAppRuntime.append("_");
    paramAppRuntime.append(l2);
    jdField_a_of_type_JavaLangString = paramAppRuntime.toString();
  }
  
  public static int b()
  {
    return jdField_a_of_type_Int;
  }
  
  public static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(RIJSPUtils.a("readinjoy_daily_mode_channel_id", Integer.valueOf(41505)));
    return localStringBuilder.toString();
  }
  
  private static Map<String, String> b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("folder_status", "1");
    localHashMap.put("algorithm_id", "0");
    localHashMap.put("strategy_id", "0");
    Object localObject = (QQAppInterface)ReadInJoyUtils.a();
    if (localObject == null) {
      return localHashMap;
    }
    localObject = ((QQAppInterface)localObject).getMessageFacade().b(AppConstants.KANDIAN_DAILY_UIN, 1008);
    if (localObject == null) {
      return localHashMap;
    }
    if (((MessageRecord)localObject).isread) {
      return localHashMap;
    }
    if ((localObject instanceof MessageForStructing))
    {
      localObject = (MessageForStructing)localObject;
      if (!((MessageForStructing)localObject).mIsParsed) {
        ((MessageForStructing)localObject).parse();
      }
      if (((MessageForStructing)localObject).structingMsg == null) {
        return localHashMap;
      }
      localHashMap.put("folder_status", ((MessageForStructing)localObject).structingMsg.reportEventFolderStatusValue);
      localHashMap.put("algorithm_id", ((MessageForStructing)localObject).structingMsg.mAlgorithmIds);
      localHashMap.put("strategy_id", ((MessageForStructing)localObject).structingMsg.mStrategyIds);
    }
    return localHashMap;
  }
  
  public static void b()
  {
    Map localMap = b();
    if (localMap != null) {
      b = localMap;
    }
  }
  
  public static void c()
  {
    jdField_a_of_type_Int = 0;
    QLog.d("KandianDailyReportUtils", 2, "reset operation flag : ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.KandianDailyReportUtils
 * JD-Core Version:    0.7.0.1
 */