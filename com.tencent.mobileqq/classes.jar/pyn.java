import com.tencent.biz.pubaccount.readinjoy.preload.util.FeedsPreloadDataReport.1;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;

public class pyn
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
      Long localLong = (Long)paramToServiceMsg.getAttribute(pwd.d);
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
        localObject = pay.a();
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
        ((pbg)localObject).a("is_reddot", paramToServiceMsg);
        if (!bool1) {
          continue;
        }
        paramToServiceMsg = "1";
        ((pbg)localObject).a("hit_preload", paramToServiceMsg);
        ((pbg)localObject).a("refresh_cost", String.valueOf(l));
        ((pbg)localObject).a("refresh_num", String.valueOf(paramInt));
      }
      catch (JSONException paramToServiceMsg)
      {
        label268:
        label273:
        label278:
        QLog.d("FeedsPreloadDataReport", 1, "reportFeedsRefreshCost, e = ", paramToServiceMsg);
        continue;
      }
      a("0X8009C16", ((pbg)localObject).a());
      pyp.a(l, bool1);
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
    pyl.a().a(new FeedsPreloadDataReport.1(paramString1, paramString2));
  }
  
  public static void a(boolean paramBoolean, int paramInt)
  {
    pbg localpbg = pay.a();
    String str;
    if (paramBoolean) {
      str = "1";
    }
    try
    {
      for (;;)
      {
        localpbg.a("preload_reddot", str);
        localpbg.a("preload_num", String.valueOf(paramInt));
        a("0X8009C15", localpbg.a());
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
    pbg localpbg = pay.a();
    String str;
    if (paramBoolean) {
      str = "1";
    }
    for (;;)
    {
      try
      {
        localpbg.a("preload_reddot", str);
        localpbg.a("preload_num", String.valueOf(paramInt));
        localpbg.a("package_size", String.valueOf(paramLong));
        if (paramLong <= 20000L) {
          continue;
        }
        str = "1";
        localpbg.a("is_too_large", str);
      }
      catch (JSONException localJSONException)
      {
        QLog.d("FeedsPreloadDataReport", 1, "reportReceiveFeedsPreload, e = ", localJSONException);
        continue;
      }
      a("0X8009C14", localpbg.a());
      return;
      str = "0";
      continue;
      str = "0";
    }
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    pbg localpbg = pay.a();
    String str;
    if (paramBoolean1) {
      str = "1";
    }
    for (;;)
    {
      try
      {
        localpbg.a("preload_reddot", str);
        if (!paramBoolean2) {
          continue;
        }
        str = "1";
        localpbg.a("has_exception", str);
      }
      catch (JSONException localJSONException)
      {
        QLog.d("FeedsPreloadDataReport", 1, "reportTriggerFeedsPreload, e = ", localJSONException);
        continue;
      }
      a("0X8009C13", localpbg.a());
      return;
      str = "0";
      continue;
      str = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pyn
 * JD-Core Version:    0.7.0.1
 */