import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

public class pcw
{
  public static final AtomicLong a = new AtomicLong(0L);
  
  public static long a(pow parampow)
  {
    if (!a())
    {
      QLog.d("FeedsPreloadHelper", 1, "updateRequestVersionAndGet = -1, preloadSwitch is off.");
      return -1L;
    }
    if (parampow == null)
    {
      QLog.d("FeedsPreloadHelper", 1, "updateRequestVersionAndGet = -1, params is null.");
      return -1L;
    }
    QLog.d("FeedsPreloadHelper", 1, new Object[] { "updateRequestVersionAndGet, channelID = ", Integer.valueOf(parampow.b), ", beginSeq = ", Long.valueOf(parampow.a) });
    if ((parampow.b == 0) && (parampow.a == -1L))
    {
      QLog.d("FeedsPreloadHelper", 1, new Object[] { "feedsRequestVersion = ", Long.valueOf(a.incrementAndGet()) });
      return a.get();
    }
    QLog.d("FeedsPreloadHelper", 1, "not recommend feeds or pull down request, return -1");
    return -1L;
  }
  
  public static void a()
  {
    long l = System.currentTimeMillis();
    QLog.d("FeedsPreloadHelper", 1, new Object[] { "enterKDTab, time = ", Long.valueOf(l) });
    bhvy.a("sp_key_readinjoy_feeds_preload_last_enter_kd_millisecond", Long.valueOf(l));
  }
  
  public static void a(long paramLong, boolean paramBoolean) {}
  
  public static boolean a()
  {
    if (!bhvy.i())
    {
      QLog.d("FeedsPreloadHelper", 1, "isPreloadSwitchOn: NO, not independent kd tab.");
      return false;
    }
    if (!((Boolean)bhvy.a("sp_key_readinjoy_feeds_preload_switch", Boolean.valueOf(false))).booleanValue())
    {
      QLog.d("FeedsPreloadHelper", 1, "isPreloadSwitchOn: NO, switch is off.");
      return false;
    }
    QLog.d("FeedsPreloadHelper", 1, "isPreloadSwitchOn: YES.");
    return true;
  }
  
  public static boolean a(ToServiceMsg paramToServiceMsg)
  {
    if ((paramToServiceMsg != null) && (paramToServiceMsg.getAttributes() != null))
    {
      paramToServiceMsg = (Boolean)paramToServiceMsg.getAttributes().get("isFeedsPreload");
      if (paramToServiceMsg != null)
      {
        QLog.d("FeedsPreloadHelper", 1, new Object[] { "isFeedsPreloadRequest, isFeedsPreload = ", paramToServiceMsg });
        return paramToServiceMsg.booleanValue();
      }
    }
    QLog.d("FeedsPreloadHelper", 1, "isFeedsPreloadRequest, isFeedsPreload = false.");
    return false;
  }
  
  public static boolean a(pow parampow)
  {
    if ((parampow != null) && (a()) && (parampow.b == 0) && (parampow.a == -1L))
    {
      QLog.d("FeedsPreloadHelper", 1, "isAvailableToHitCache: YES");
      return true;
    }
    QLog.d("FeedsPreloadHelper", 1, "isAvailableToHitCache: NO");
    return false;
  }
  
  public static boolean a(boolean paramBoolean)
  {
    if (!bhvy.i())
    {
      QLog.d("FeedsPreloadHelper", 1, "isAbleToPreload : NO, not independent kd tab.");
      return false;
    }
    if (!((Boolean)bhvy.a("sp_key_readinjoy_feeds_preload_switch", Boolean.valueOf(false))).booleanValue())
    {
      QLog.d("FeedsPreloadHelper", 1, "isAbleToPreload: NO, switch is off.");
      return false;
    }
    long l1 = ((Long)bhvy.a("sp_key_readinjoy_feeds_preload_last_enter_kd_millisecond", Long.valueOf(-1L))).longValue();
    if (l1 == -1L)
    {
      QLog.d("FeedsPreloadHelper", 1, "isAbleToPreload: NO, have not entered kd yet.");
      return false;
    }
    long l2 = System.currentTimeMillis();
    long l3 = ((Long)bhvy.a("sp_key_readinjoy_feeds_preload_last_enter_kd_day", Long.valueOf(90L))).longValue();
    long l4 = (l2 - l1) / 1000L / 60L / 60L / 24L;
    QLog.d("FeedsPreloadHelper", 1, new Object[] { "have left kd for ", Long.valueOf((l2 - l1) / 1000L / 60L), " minute(s), ", Long.valueOf(l4), " day(s), config days = ", Long.valueOf(l3) });
    if (l4 > l3)
    {
      QLog.d("FeedsPreloadHelper", 1, new Object[] { "isAbleToPreload: NO, have left kd for more than ", Long.valueOf(l3), " day(s)." });
      return false;
    }
    if (paramBoolean)
    {
      QLog.d("FeedsPreloadHelper", 1, "isAbleToPreload: YES, red point preload.");
      return true;
    }
    l2 = ((Long)bhvy.a("sp_key_readinjoy_feeds_preload_last_preload_millisecond", Long.valueOf(-1L))).longValue();
    if (l2 != -1L)
    {
      l3 = System.currentTimeMillis();
      l1 = ((Long)bhvy.a("sp_key_readinjoy_feeds_preload_interval", Long.valueOf(30L))).longValue();
      l2 = (l3 - l2) / 1000L / 60L;
      QLog.d("FeedsPreloadHelper", 1, new Object[] { "it has been ", Long.valueOf(l2), " minute(s) since last feeds preload, config minutes = ", Long.valueOf(l1) });
      if (l2 < l1)
      {
        QLog.d("FeedsPreloadHelper", 1, new Object[] { "isAbleToPreload: NO, it has been less than ", Long.valueOf(l1), " minute(s) since last feeds preload." });
        return false;
      }
    }
    QLog.d("FeedsPreloadHelper", 1, "isAbleToPreload: YES.");
    return true;
  }
  
  public static void b()
  {
    long l = System.currentTimeMillis();
    QLog.d("FeedsPreloadHelper", 1, new Object[] { "preload succeed, time = ", Long.valueOf(l) });
    bhvy.a("sp_key_readinjoy_feeds_preload_last_preload_millisecond", Long.valueOf(l));
  }
  
  public static boolean b()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (!(localBaseActivity instanceof SplashActivity)) {
      QLog.d("FeedsPreloadHelper", 1, "isFromLockScreenPush = false, is not splashActivity.");
    }
    for (;;)
    {
      return false;
      try
      {
        int i = localBaseActivity.getIntent().getIntExtra("launch_from", 5);
        QLog.d("FeedsPreloadHelper", 1, new Object[] { "isFromLockScreenPush, launchFrom = ", Integer.valueOf(i) });
        if ((i == 6) || (i == 9)) {
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.d("FeedsPreloadHelper", 1, "isFromLockScreenPush, t = ", localThrowable);
        QLog.d("FeedsPreloadHelper", 1, "isFromLockScreenPush = false");
      }
    }
    return false;
  }
  
  public static boolean b(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg = (Long)paramToServiceMsg.getAttribute("feedsRequestVersion");
      if (paramToServiceMsg != null)
      {
        QLog.d("FeedsPreloadHelper", 1, new Object[] { "isLatestRequestVersion, reqVersion = ", Long.valueOf(paramToServiceMsg.longValue()), ", latestVersion = ", Long.valueOf(a.get()) });
        return paramToServiceMsg.longValue() == a.get();
      }
    }
    QLog.d("FeedsPreloadHelper", 1, "is not latest request version.");
    return false;
  }
  
  public static boolean b(pow parampow)
  {
    if (parampow != null)
    {
      if ((parampow.i & 0x100) != 0) {}
      for (boolean bool = true;; bool = false)
      {
        QLog.d("FeedsPreloadHelper", 1, new Object[] { "isFeedsPreloadRequest, isFeedsPreload = ", Boolean.valueOf(bool) });
        return bool;
      }
    }
    QLog.d("FeedsPreloadHelper", 1, "isFeedsPreloadRequest, isFeedsPreload = false.");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pcw
 * JD-Core Version:    0.7.0.1
 */