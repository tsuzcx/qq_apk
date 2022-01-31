import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyVideoSubChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.weaknet.WeakNetHelper.1;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class sag
{
  static long a()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(152);
    int i;
    if (localAladdinConfig != null)
    {
      i = localAladdinConfig.getIntegerFromString("toast_delay_time", 5000);
      QLog.d("WeakNetHelper", 1, new Object[] { "getToastDelayTime, toastDelayTime = ", Integer.valueOf(i) });
      if (i < 3000) {
        QLog.d("WeakNetHelper", 1, new Object[] { "getToastDelayTime, toast config time is unreasonable, don't use it, toastDelayTime = ", Integer.valueOf(i) });
      }
    }
    else
    {
      QLog.d("WeakNetHelper", 1, new Object[] { "getToastDelayTime, default time = ", Integer.valueOf(5000) });
      return 5000L;
    }
    return i;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    ThreadManager.getSubThreadHandler().post(new WeakNetHelper.1(paramString1, paramString2));
  }
  
  public static boolean a()
  {
    Object localObject = BaseActivity.sTopActivity;
    if ((localObject instanceof SplashActivity))
    {
      boolean bool = ReadinjoyTabFrame.c_();
      if (bool) {}
      for (localObject = "YES";; localObject = "NO")
      {
        QLog.d("WeakNetHelper", 1, new Object[] { "isAbleToShowToast: ", localObject, ", tab." });
        return bool;
      }
    }
    if ((localObject instanceof ReadInJoyNewFeedsActivity))
    {
      QLog.d("WeakNetHelper", 1, "isAbleToShowToast: YES");
      return true;
    }
    if (((localObject instanceof ReadInJoyVideoSubChannelActivity)) || ((localObject instanceof ReadInJoyChannelActivity)))
    {
      QLog.d("WeakNetHelper", 1, "isAbleToShowToast: YES, sub channel.");
      return true;
    }
    QLog.d("WeakNetHelper", 1, "isAbleToShowToast: NO, not SplashActivity or ReadInJoyNewFeedsActivity, not sub channel activity.");
    return false;
  }
  
  static boolean a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      Boolean localBoolean = (Boolean)paramToServiceMsg.getAttribute("isFeedsPreload");
      if ((localBoolean != null) && (localBoolean.booleanValue()))
      {
        QLog.d("WeakNetHelper", 1, "isNeedToShowToast: NO, feeds preload request.");
        return false;
      }
      paramToServiceMsg = (Long)paramToServiceMsg.getAttribute(pbe.d);
      if ((paramToServiceMsg != null) && (paramToServiceMsg.longValue() == -1L))
      {
        QLog.d("WeakNetHelper", 1, "isNeedToShowToast: YES.");
        return true;
      }
    }
    QLog.d("WeakNetHelper", 1, "isNeedToShowToast: NO.");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sag
 * JD-Core Version:    0.7.0.1
 */