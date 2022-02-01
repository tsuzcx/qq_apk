import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.KandianDailyReportUtils.1;
import com.tencent.biz.pubaccount.readinjoy.common.KandianDailyReportUtils.3;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo.DailyFloatingWindowData;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
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

public class pin
{
  private static volatile int jdField_a_of_type_Int;
  public static long a;
  public static String a;
  private static ArrayList<ReportInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public static Map<Long, Pair<Long, Long>> a;
  private static boolean jdField_a_of_type_Boolean;
  private static Map<String, String> b = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_JavaUtilMap = new HashMap();
    b();
  }
  
  public static int a()
  {
    Object localObject1 = algs.a().a;
    if (localObject1 == null) {
      return 2147483647;
    }
    localObject1 = new ArrayList((Collection)localObject1);
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      RecentUserBaseData localRecentUserBaseData = (RecentUserBaseData)((Iterator)localObject2).next();
      if ((localRecentUserBaseData != null) && (localRecentUserBaseData.mUser != null) && (localRecentUserBaseData.mUser.getType() == 1008) && (uot.b((QQAppInterface)pkh.a(), localRecentUserBaseData.mUser.uin))) {
        ((Iterator)localObject2).remove();
      }
    }
    int i = 0;
    if (i < ((List)localObject1).size())
    {
      localObject2 = (RecentUserBaseData)((List)localObject1).get(i);
      if (localObject2 == null) {}
      while ((((RecentUserBaseData)localObject2).mUser == null) || (((RecentUserBaseData)localObject2).mUser.getType() != 1008) || (!TextUtils.equals(((RecentUserBaseData)localObject2).mUser.uin, AppConstants.KANDIAN_DAILY_UIN)))
      {
        i += 1;
        break;
      }
      return i;
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
    if (b != null) {}
    for (String str1 = (String)b.get("folder_status");; str1 = "1")
    {
      String str2;
      if (str1 != null)
      {
        str2 = str1;
        if (!TextUtils.isEmpty(str1)) {}
      }
      else
      {
        str2 = "1";
      }
      return str2;
    }
  }
  
  public static Map<String, String> a()
  {
    return b;
  }
  
  public static void a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)pkh.a();
    if (localQQAppInterface == null) {}
    MessageRecord localMessageRecord;
    do
    {
      return;
      localMessageRecord = localQQAppInterface.getMessageFacade().getLastMsgForMsgTab(AppConstants.KANDIAN_DAILY_UIN, 1008);
    } while ((localMessageRecord == null) || (localMessageRecord.isread) || (localMessageRecord.extLong != 1));
    ThreadManager.post(new KandianDailyReportUtils.1(localMessageRecord, localQQAppInterface), 8, null, false);
    a(1, "0X8009867", localMessageRecord);
    b();
  }
  
  public static void a(int paramInt)
  {
    jdField_a_of_type_Int |= paramInt;
    if (plm.b(plm.b())) {
      pwb.e(1);
    }
    QLog.d("KandianDailyReportUtils", 2, "set operation flag : " + paramInt);
  }
  
  private static void a(int paramInt, String paramString, MessageRecord paramMessageRecord)
  {
    String str4 = uuc.a(AppConstants.KANDIAN_DAILY_UIN) + "";
    Object localObject3 = null;
    String str1 = null;
    KandianRedDotInfo localKandianRedDotInfo = KandianRedDotInfo.createRedDotFromMessageRecord(paramMessageRecord, "kandian_daily_red_pnt");
    String str3;
    String str2;
    if (localKandianRedDotInfo != null) {
      if ((localKandianRedDotInfo.articleIDList != null) && (!localKandianRedDotInfo.articleIDList.isEmpty()))
      {
        localObject1 = localKandianRedDotInfo.articleIDList.get(0) + "";
        str1 = localKandianRedDotInfo.strategyID + "";
        str3 = localKandianRedDotInfo.forderStatus;
        str2 = localKandianRedDotInfo.algorithmID + "";
        localObject3 = localObject1;
      }
    }
    label599:
    label609:
    Object localObject2;
    for (Object localObject1 = str3;; localObject2 = null)
    {
      if ((paramInt == 0) && (paramMessageRecord.isread)) {
        localObject1 = "1";
      }
      int i;
      for (;;)
      {
        if (uuc.b(AppConstants.KANDIAN_DAILY_UIN) > 0) {}
        for (i = 1;; i = 0)
        {
          str3 = KandianDailyManager.jdField_a_of_type_JavaLangString;
          if ((paramMessageRecord instanceof MessageForStructing)) {
            str3 = KandianDailyManager.a((MessageForStructing)paramMessageRecord);
          }
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("folder_status", localObject1);
            localJSONObject.put("message_status", i);
            localJSONObject.put("algorithm_id", str2);
            localJSONObject.put("name", str3);
            localJSONObject.put("time", NetConnInfoCenter.getServerTimeMillis());
            localJSONObject.put("version", omx.jdField_a_of_type_JavaLangString);
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
            for (;;)
            {
              localException2.printStackTrace();
              continue;
              if (paramInt == 0)
              {
                i = 21;
                continue;
                l = Long.valueOf("").longValue();
              }
            }
          }
          olh.a(null, "CliOper", "", "", paramString, paramString, 0, 0, str4, localObject3, str1, localJSONObject.toString(), false);
          if (!paramMessageRecord.isread)
          {
            paramString = new ArrayList();
            paramMessageRecord = new ReportInfo();
            i = 20;
            if (paramInt != 1) {
              break label599;
            }
            i = 20;
            paramMessageRecord.mOperation = i;
            paramMessageRecord.mOpSource = 16;
            paramMessageRecord.mUin = pkh.a();
          }
          try
          {
            paramMessageRecord.mSourceArticleId = Long.valueOf(localObject3).longValue();
            paramMessageRecord.mAlgorithmId = Integer.valueOf(str2).intValue();
            paramMessageRecord.mStrategyId = Integer.valueOf(str1).intValue();
            if (!TextUtils.isEmpty("")) {
              break label609;
            }
            l = -1L;
            paramMessageRecord.mPuin = l;
            paramMessageRecord.mFolderStatus = Integer.valueOf((String)localObject1).intValue();
            if ((localKandianRedDotInfo != null) && (!TextUtils.isEmpty(localKandianRedDotInfo.rowkey))) {
              paramMessageRecord.mInnerId = localKandianRedDotInfo.rowkey;
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              long l;
              localException1.printStackTrace();
            }
          }
          paramString.add(paramMessageRecord);
          new qia(null, null, qxn.a(), null).a(paramString);
          return;
          localObject1 = null;
          break;
        }
      }
      str2 = null;
    }
  }
  
  public static void a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    int i;
    do
    {
      do
      {
        return;
        i = paramIntent.getIntExtra("launch_from", 5);
      } while ((i != 6) && (i != 9));
      a((KandianRedDotInfo)paramIntent.getSerializableExtra("kandian_feeds_red_pnt_info"));
    } while (i != 6);
    prq.a((KandianRedDotInfo)paramIntent.getSerializableExtra("daily_lock_screen_report_red_info"));
  }
  
  public static void a(KandianRedDotInfo paramKandianRedDotInfo)
  {
    if (paramKandianRedDotInfo == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("folder_status", paramKandianRedDotInfo.forderStatus);
    localHashMap.put("algorithm_id", paramKandianRedDotInfo.algorithmID + "");
    localHashMap.put("strategy_id", paramKandianRedDotInfo.strategyID + "");
    b = localHashMap;
  }
  
  public static void a(ReportInfo paramReportInfo)
  {
    ThreadManager.executeOnSubThread(new KandianDailyReportUtils.3(paramReportInfo));
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    a(0, "0X8009868", paramMessageRecord);
  }
  
  public static void a(List<ArticleInfo> paramList, List<Long> paramList1, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList1 == null)) {}
    StringBuilder localStringBuilder;
    do
    {
      return;
      Collections.sort(paramList, new pio());
      localStringBuilder = new StringBuilder(1024);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ArticleInfo localArticleInfo = (ArticleInfo)paramList.next();
        if ((pqw.a(localArticleInfo) > 0) && (paramList1.contains(Long.valueOf(localArticleInfo.mRecommendSeq))))
        {
          Map localMap = jdField_a_of_type_JavaUtilMap;
          long l2 = localArticleInfo.mArticleID;
          long l3 = jdField_a_of_type_Long;
          jdField_a_of_type_Long = l3 + 1L;
          if (paramBoolean) {}
          for (long l1 = 1L;; l1 = 0L)
          {
            localMap.put(Long.valueOf(l2), new Pair(Long.valueOf(l3), Long.valueOf(l1)));
            localStringBuilder.append("articleID : " + localArticleInfo.mArticleID + ", pos : " + (jdField_a_of_type_Long - 1L) + "\n");
            break;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("KandianDailyReportUtils", 2, localStringBuilder.toString());
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    long l1 = 0L;
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_JavaUtilMap.clear();
    if (paramAppRuntime == null) {}
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      jdField_a_of_type_JavaLangString = l1 + "_" + l2;
      return;
      l1 = paramAppRuntime.getLongAccountUin();
    }
  }
  
  public static int b()
  {
    return jdField_a_of_type_Int;
  }
  
  public static String b()
  {
    return "" + bmhv.a("readinjoy_daily_mode_channel_id", Integer.valueOf(41505));
  }
  
  private static Map<String, String> b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("folder_status", "1");
    localHashMap.put("algorithm_id", "0");
    localHashMap.put("strategy_id", "0");
    Object localObject = (QQAppInterface)pkh.a();
    if (localObject == null) {
      return localHashMap;
    }
    localObject = ((QQAppInterface)localObject).getMessageFacade().getLastMsgForMsgTab(AppConstants.KANDIAN_DAILY_UIN, 1008);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pin
 * JD-Core Version:    0.7.0.1
 */