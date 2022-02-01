package cooperation.qzone.birthdaynotice;

import GIFT_MALL_PROTOCOL.DouFuInfo;
import awfp;
import bbko;
import bbog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.manager.MonitorManager;
import java.lang.ref.WeakReference;
import java.util.Set;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class BirthDayNoticeManager
{
  private static final String TAG = "BirthDayNoticeManager";
  private static BirthDayNoticeManager.BirthDayNoticeObserver sBirthDayNoticeObserver = new BirthDayNoticeManager.BirthDayNoticeObserver();
  
  private static void addBirthDayFeedMessage(QQAppInterface paramQQAppInterface, DouFuInfo paramDouFuInfo)
  {
    JSONObject localJSONObject = convertToJson(paramDouFuInfo);
    long l = FeedsManager.getToken(String.valueOf(paramDouFuInfo.uin));
    ThreadManager.getSubThreadHandler().post(new BirthDayNoticeManager.1(paramDouFuInfo, paramQQAppInterface, localJSONObject, l));
  }
  
  private static JSONObject convertToJson(DouFuInfo paramDouFuInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("friendUin", paramDouFuInfo.uin);
      localJSONObject.put("background", paramDouFuInfo.background);
      localJSONObject.put("time", paramDouFuInfo.birthday);
      localJSONObject.put("blessing", paramDouFuInfo.blessing);
      localJSONObject.put("link", paramDouFuInfo.doufu_link);
      localJSONObject.put("icon", paramDouFuInfo.icon);
      return localJSONObject;
    }
    catch (Exception paramDouFuInfo)
    {
      QLog.e("BirthDayNoticeManager", 1, "error convert to json " + paramDouFuInfo);
      MonitorManager.a().a(19, 4, "convert to json error " + paramDouFuInfo, false);
    }
    return localJSONObject;
  }
  
  public static boolean isBirthDayNoticeEnable(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (awfp.a(paramQQAppInterface, paramString, 5L, false) != null) {}
    while ((awfp.a(paramQQAppInterface, paramString, 12L, false) != null) || (awfp.a(paramQQAppInterface, paramString, false) != null)) {
      return true;
    }
    return false;
  }
  
  public static void requestBirthDayNotice(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    String str = paramSessionInfo.curFriendUin;
    Set localSet = paramQQAppInterface.getMsgCache().a();
    long l1;
    long l3;
    if ((localSet != null) && (localSet.contains(str)) && (isBirthDayNoticeEnable(paramQQAppInterface, paramSessionInfo.curFriendUin)))
    {
      l1 = paramQQAppInterface.getMsgCache().b();
      l3 = System.currentTimeMillis() / 1000L;
      if (l3 - l1 >= 86400L)
      {
        QLog.i("BirthDayNoticeManager", 2, "requestBirthDayNotice ");
        paramSessionInfo = new NewIntent(BaseApplicationImpl.getApplication(), bbog.class);
        l1 = 0L;
      }
    }
    try
    {
      long l2 = Long.parseLong(paramQQAppInterface.getCurrentAccountUin());
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("BirthDayNoticeManager", 1, "get uin error " + localException);
      }
    }
    paramSessionInfo.putExtra("selfuin", l1);
    sBirthDayNoticeObserver.mAppRef = new WeakReference(paramQQAppInterface);
    paramQQAppInterface.registObserver(sBirthDayNoticeObserver);
    paramQQAppInterface.startServlet(paramSessionInfo);
    paramQQAppInterface.getMsgCache().c(l3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.birthdaynotice.BirthDayNoticeManager
 * JD-Core Version:    0.7.0.1
 */