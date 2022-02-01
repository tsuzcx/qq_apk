import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/feedsinsert/RIJFeedsInsertUtil;", "", "()V", "DAILY_QUOTA_DEFAULT", "", "FEEDS_INSERT_DATE_SP_KEY", "", "FEEDS_INSERT_TIMESTAMP_SP_KEY", "TAG", "TIME_INTERVAL_DEFAULT", "TODAY_INSERT_TIMES_SP_KEY", "dailyQuota", "lastClickChannelId", "", "getLastClickChannelId", "()J", "setLastClickChannelId", "(J)V", "reqParamsMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/biz/pubaccount/readinjoy/feedsinsert/RIJFeedsInsertModule$ReqParams;", "timeInterval", "clearReqParams", "", "channelId", "deleteArticleInfo", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "getLogString", "getReqParams", "getTodayInsertTime", "date", "isAbleToRequest", "", "isChannelAbleToInsert", "requestRecommendArticleInfoList", "updateInsertFeedsInfo", "updateLastClickArticleInfo", "updateReqParams", "updateTimes", "reqRecommendFlag", "followPuin", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class pgo
{
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  private static final ConcurrentHashMap<Long, pgn> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  public static final pgo a;
  private static int b;
  
  static
  {
    int i = 0;
    jdField_a_of_type_Pgo = new pgo();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    b = 30;
    AladdinConfig localAladdinConfig = Aladdin.getConfig(361);
    if (localAladdinConfig != null) {
      i = localAladdinConfig.getIntegerFromString("DailyQuota", 0);
    }
    jdField_a_of_type_Int = i;
    if (localAladdinConfig != null) {}
    for (i = localAladdinConfig.getIntegerFromString("TimeInterval", 30);; i = 30)
    {
      b = i;
      QLog.i("RIJFeedsInsertUtil", 1, "[init] feedsInsertConfig = { dailyQuota = " + jdField_a_of_type_Int + ", timeInterval = " + b + " }");
      return;
    }
  }
  
  private final int a(String paramString)
  {
    if (TextUtils.equals((CharSequence)paramString, (CharSequence)bnrf.a("readinjoy_sp_key_insert_date", "")))
    {
      paramString = bnrf.a("readinjoy_sp_key_daily_quota", Integer.valueOf(0));
      Intrinsics.checkExpressionValueIsNotNull(paramString, "ReadInJoyHelper.getReadI…Y_INSERT_TIMES_SP_KEY, 0)");
      return ((Number)paramString).intValue();
    }
    return 0;
  }
  
  private final pgn a(long paramLong)
  {
    pgn localpgn2 = (pgn)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    pgn localpgn1 = localpgn2;
    if (localpgn2 == null) {
      localpgn1 = new pgn();
    }
    return localpgn1;
  }
  
  public final long a()
  {
    return jdField_a_of_type_Long;
  }
  
  @NotNull
  public final String a(@NotNull BaseArticleInfo paramBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseArticleInfo, "articleInfo");
    return "{ title = " + paramBaseArticleInfo.mTitle + ", rowKey = " + paramBaseArticleInfo.innerUniqueID + ", feedsType = " + paramBaseArticleInfo.mFeedType + ", subscribeName = " + paramBaseArticleInfo.mSubscribeName + ", subscribeId = " + paramBaseArticleInfo.mSubscribeID + " }";
  }
  
  public final void a()
  {
    String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    long l = System.currentTimeMillis();
    Intrinsics.checkExpressionValueIsNotNull(str, "date");
    int i = a(str) + 1;
    bnrf.a("readinjoy_sp_key_insert_date", str);
    bnrf.a("readinjoy_sp_key_daily_quota", Integer.valueOf(i));
    bnrf.a("readinjoy_sp_key_time_interval", Long.valueOf(l));
    QLog.i("RIJFeedsInsertUtil", 1, "[updateInsertFeedsInfo], date = " + str + ", todayInsertTimes = " + i + ", insertTimeStamp = " + l);
  }
  
  public final void a(long paramLong)
  {
    Object localObject = ozs.a();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    }
    localObject = (pfg)((QQAppInterface)localObject).getManager(163);
    if (localObject != null)
    {
      localObject = ((pfg)localObject).a();
      if (localObject != null)
      {
        localObject = ((pfa)localObject).a();
        if (localObject != null) {
          ((pgl)localObject).a(a(paramLong));
        }
      }
    }
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2)
  {
    pgn localpgn = a(paramLong);
    localpgn.a(paramLong);
    localpgn.a(paramInt1);
    localpgn.b(paramInt2);
    ((Map)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).put(Long.valueOf(paramLong), localpgn);
    QLog.i("RIJFeedsInsertUtil", 1, "[updateReqParams] channelId = " + paramLong + ", updateTimes = " + paramInt1 + ", reqRecommendFlag = " + paramInt2 + ", reqParams = {" + localpgn + '}');
  }
  
  public final void a(long paramLong, @NotNull BaseArticleInfo paramBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseArticleInfo, "articleInfo");
    Object localObject = ozs.a();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    }
    localObject = (pfg)((QQAppInterface)localObject).getManager(163);
    if (localObject != null)
    {
      localObject = ((pfg)localObject).a();
      if (localObject != null)
      {
        localObject = ((pfa)localObject).a();
        if (localObject != null) {
          ((pgl)localObject).a(paramLong, paramBaseArticleInfo);
        }
      }
    }
  }
  
  public final void a(long paramLong, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "followPuin");
    pgn localpgn = a(paramLong);
    localpgn.a(paramLong);
    localpgn.a(paramString);
    ((Map)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).put(Long.valueOf(paramLong), localpgn);
    QLog.i("RIJFeedsInsertUtil", 1, "[updateReqParams] channelId = " + paramLong + ", followPuin = " + paramString + ", reqParams = {" + localpgn + '}');
  }
  
  public final boolean a()
  {
    String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    Intrinsics.checkExpressionValueIsNotNull(str, "date");
    int i = a(str);
    if (i >= jdField_a_of_type_Int)
    {
      QLog.i("RIJFeedsInsertUtil", 1, "[isAbleToRequest] = false, date = " + str + ", todayInsertTime = " + i + ", dailyQuota = " + jdField_a_of_type_Int);
      return false;
    }
    long l = System.currentTimeMillis();
    Object localObject = bnrf.a("readinjoy_sp_key_time_interval", Long.valueOf(0L));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyHelper.getReadI…ERT_TIMESTAMP_SP_KEY, 0L)");
    l -= ((Number)localObject).longValue();
    if (l <= b * 60 * 1000)
    {
      QLog.i("RIJFeedsInsertUtil", 1, "[isAbleToRequest] = false, date = " + str + ", todayInsertTime = " + i + ", requestTimeInterval = " + l + " ms, timeInterval = " + b * 60 * 1000 + " ms ");
      return false;
    }
    QLog.i("RIJFeedsInsertUtil", 1, "[isAbleToRequest] = true");
    return true;
  }
  
  public final boolean a(int paramInt)
  {
    return paramInt == 0;
  }
  
  public final void b(long paramLong, @NotNull BaseArticleInfo paramBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseArticleInfo, "articleInfo");
    jdField_a_of_type_Long = paramLong;
    pgn localpgn = a(paramLong);
    localpgn.a(paramLong);
    localpgn.a(paramBaseArticleInfo);
    ((Map)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).put(Long.valueOf(paramLong), localpgn);
    QLog.i("RIJFeedsInsertUtil", 1, "[updateLastClickArticleInfo] channelId = " + paramLong + ", reqParams = {" + localpgn + '}');
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pgo
 * JD-Core Version:    0.7.0.1
 */