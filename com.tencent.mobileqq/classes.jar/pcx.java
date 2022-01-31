import com.tencent.biz.pubaccount.readinjoy.preload.util.FeedsPreloadDataReport.1;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;

public class pcx
{
  public static void a(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    Object localObject;
    boolean bool1;
    boolean bool2;
    label130:
    long l;
    if (paramToServiceMsg != null)
    {
      localObject = (Long)paramToServiceMsg.getAttribute("feedsRequestBeginTime");
      Integer localInteger = (Integer)paramToServiceMsg.getAttribute("channelID");
      Long localLong = (Long)paramToServiceMsg.getAttribute(pbh.d);
      Boolean localBoolean = (Boolean)paramToServiceMsg.getAttribute("hitFeedsPreloadCache");
      if (localBoolean == null) {
        break label268;
      }
      bool1 = localBoolean.booleanValue();
      if ((localInteger != null) && (localInteger.intValue() == 0) && (localLong != null) && (localLong.longValue() == -1L))
      {
        if ((localObject == null) || (((Long)localObject).longValue() <= 0L)) {
          break label303;
        }
        paramToServiceMsg = (List)paramToServiceMsg.getAttribute("SubscriptionArticles");
        if ((paramToServiceMsg == null) || (paramToServiceMsg.size() <= 0)) {
          break label273;
        }
        bool2 = true;
        l = System.currentTimeMillis() - ((Long)localObject).longValue();
        QLog.d("FeedsPreloadDataReport", 1, new Object[] { "refreshTime = ", Long.valueOf(l), ", hitFeedsPreloadCache = ", Boolean.valueOf(bool1), ", isRedPoint = ", Boolean.valueOf(bool2) });
        localObject = onk.a();
        if (!bool2) {
          break label278;
        }
        paramToServiceMsg = "1";
      }
    }
    for (;;)
    {
      try
      {
        ((onr)localObject).a("is_reddot", paramToServiceMsg);
        if (!bool1) {
          continue;
        }
        paramToServiceMsg = "1";
        ((onr)localObject).a("hit_preload", paramToServiceMsg);
        ((onr)localObject).a("refresh_cost", String.valueOf(l));
        ((onr)localObject).a("refresh_num", String.valueOf(paramInt));
      }
      catch (JSONException paramToServiceMsg)
      {
        label268:
        label273:
        label278:
        QLog.d("FeedsPreloadDataReport", 1, "reportFeedsRefreshCost, e = ", paramToServiceMsg);
        continue;
      }
      a("0X8009C16", ((onr)localObject).a());
      pcz.a(l, bool1);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label130;
      paramToServiceMsg = "0";
      continue;
      paramToServiceMsg = "0";
    }
    label303:
    QLog.d("FeedsPreloadDataReport", 1, "beginTime is null, no need to report.");
  }
  
  private static void a(String paramString1, String paramString2)
  {
    pcv.a().a(new FeedsPreloadDataReport.1(paramString1, paramString2));
  }
  
  public static void a(boolean paramBoolean, int paramInt)
  {
    onr localonr = onk.a();
    String str;
    if (paramBoolean) {
      str = "1";
    }
    try
    {
      for (;;)
      {
        localonr.a("preload_reddot", str);
        localonr.a("preload_num", String.valueOf(paramInt));
        a("0X8009C15", localonr.a());
        return;
        str = "0";
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.d("FeedsPreloadDataReport", 1, "reportHitFeedsPreloadCache, e = ", localJSONException);
      }
    }
  }
  
  public static void a(boolean paramBoolean, int paramInt, long paramLong)
  {
    onr localonr = onk.a();
    String str;
    if (paramBoolean) {
      str = "1";
    }
    for (;;)
    {
      try
      {
        localonr.a("preload_reddot", str);
        localonr.a("preload_num", String.valueOf(paramInt));
        localonr.a("package_size", String.valueOf(paramLong));
        if (paramLong <= 20000L) {
          continue;
        }
        str = "1";
        localonr.a("is_too_large", str);
      }
      catch (JSONException localJSONException)
      {
        QLog.d("FeedsPreloadDataReport", 1, "reportReceiveFeedsPreload, e = ", localJSONException);
        continue;
      }
      a("0X8009C14", localonr.a());
      return;
      str = "0";
      continue;
      str = "0";
    }
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    onr localonr = onk.a();
    String str;
    if (paramBoolean1) {
      str = "1";
    }
    for (;;)
    {
      try
      {
        localonr.a("preload_reddot", str);
        if (!paramBoolean2) {
          continue;
        }
        str = "1";
        localonr.a("has_exception", str);
      }
      catch (JSONException localJSONException)
      {
        QLog.d("FeedsPreloadDataReport", 1, "reportTriggerFeedsPreload, e = ", localJSONException);
        continue;
      }
      a("0X8009C13", localonr.a());
      return;
      str = "0";
      continue;
      str = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pcx
 * JD-Core Version:    0.7.0.1
 */