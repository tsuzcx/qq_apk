package com.tencent.mobileqq.kandian.glue.pts;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyChannelActivity;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyVideoSubChannelActivity;
import com.tencent.mobileqq.kandian.biz.xtab.api.impl.RIJXTabFrameUtils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class WeakNetHelper
{
  public static void a(String paramString1, String paramString2)
  {
    ThreadManager.getSubThreadHandler().post(new WeakNetHelper.1(paramString1, paramString2));
  }
  
  public static boolean a()
  {
    Object localObject = BaseActivity.sTopActivity;
    if ((localObject instanceof SplashActivity))
    {
      boolean bool = RIJXTabFrameUtils.INSTANCE.isNowInKanDianTab();
      if (bool) {
        localObject = "YES";
      } else {
        localObject = "NO";
      }
      QLog.d("WeakNetHelper", 1, new Object[] { "isAbleToShowToast: ", localObject, ", tab." });
      return bool;
    }
    if ((localObject instanceof ReadInJoyNewFeedsActivity))
    {
      QLog.d("WeakNetHelper", 1, "isAbleToShowToast: YES");
      return true;
    }
    if ((!(localObject instanceof ReadInJoyVideoSubChannelActivity)) && (!(localObject instanceof ReadInJoyChannelActivity)))
    {
      QLog.d("WeakNetHelper", 1, "isAbleToShowToast: NO, not SplashActivity or ReadInJoyNewFeedsActivity, not sub channel activity.");
      return false;
    }
    QLog.d("WeakNetHelper", 1, "isAbleToShowToast: YES, sub channel.");
    return true;
  }
  
  public static boolean a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      Boolean localBoolean = (Boolean)paramToServiceMsg.getAttribute("isFeedsPreload");
      if ((localBoolean != null) && (localBoolean.booleanValue()))
      {
        QLog.d("WeakNetHelper", 1, "isNeedToShowToast: NO, feeds preload request.");
        return false;
      }
      paramToServiceMsg = (Long)paramToServiceMsg.getAttribute("BeginSeq");
      if ((paramToServiceMsg != null) && (paramToServiceMsg.longValue() == -1L))
      {
        QLog.d("WeakNetHelper", 1, "isNeedToShowToast: YES.");
        return true;
      }
    }
    QLog.d("WeakNetHelper", 1, "isNeedToShowToast: NO.");
    return false;
  }
  
  public static long b()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(152);
    if (localAladdinConfig != null)
    {
      int i = localAladdinConfig.getIntegerFromString("toast_delay_time", 5000);
      QLog.d("WeakNetHelper", 1, new Object[] { "getToastDelayTime, toastDelayTime = ", Integer.valueOf(i) });
      if (i < 3000) {
        QLog.d("WeakNetHelper", 1, new Object[] { "getToastDelayTime, toast config time is unreasonable, don't use it, toastDelayTime = ", Integer.valueOf(i) });
      } else {
        return i;
      }
    }
    QLog.d("WeakNetHelper", 1, new Object[] { "getToastDelayTime, default time = ", Integer.valueOf(5000) });
    return 5000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.pts.WeakNetHelper
 * JD-Core Version:    0.7.0.1
 */