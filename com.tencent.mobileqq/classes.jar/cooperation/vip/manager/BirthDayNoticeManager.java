package cooperation.vip.manager;

import GIFT_MALL_PROTOCOL.DouFuInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.mutualmark.MutualMarkDataCenter;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.servlet.BirthDayNoticeServlet;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Set;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class BirthDayNoticeManager
{
  private static BirthDayNoticeManager.BirthDayNoticeObserver a = new BirthDayNoticeManager.BirthDayNoticeObserver();
  
  private static JSONObject a(DouFuInfo paramDouFuInfo)
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
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("error convert to json ");
      ((StringBuilder)localObject).append(paramDouFuInfo);
      QLog.e("BirthDayNoticeManager", 1, ((StringBuilder)localObject).toString());
      localObject = MonitorManager.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("convert to json error ");
      localStringBuilder.append(paramDouFuInfo);
      ((MonitorManager)localObject).a(19, 4, localStringBuilder.toString(), false);
    }
    return localJSONObject;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    String str = paramSessionInfo.b;
    Object localObject = paramQQAppInterface.getMsgCache().i();
    if ((localObject != null) && (((Set)localObject).contains(str)) && (a(paramQQAppInterface, paramSessionInfo.b)))
    {
      long l1 = paramQQAppInterface.getMsgCache().j();
      long l3 = System.currentTimeMillis() / 1000L;
      if (l3 - l1 >= 86400L)
      {
        QLog.i("BirthDayNoticeManager", 2, "requestBirthDayNotice ");
        paramSessionInfo = new NewIntent(BaseApplicationImpl.getApplication(), BirthDayNoticeServlet.class);
        l1 = 0L;
        try
        {
          long l2 = Long.parseLong(paramQQAppInterface.getCurrentAccountUin());
          l1 = l2;
        }
        catch (Exception localException)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("get uin error ");
          ((StringBuilder)localObject).append(localException);
          QLog.e("BirthDayNoticeManager", 1, ((StringBuilder)localObject).toString());
        }
        paramSessionInfo.putExtra("selfuin", l1);
        a.a = new WeakReference(paramQQAppInterface);
        paramQQAppInterface.registObserver(a);
        paramQQAppInterface.startServlet(paramSessionInfo);
        paramQQAppInterface.getMsgCache().e(l3);
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (MutualMarkDataCenter.a(paramQQAppInterface, paramString, 5L, false) != null) {
      return true;
    }
    if (MutualMarkDataCenter.a(paramQQAppInterface, paramString, 12L, false) != null) {
      return true;
    }
    return MutualMarkDataCenter.a(paramQQAppInterface, paramString, false) != null;
  }
  
  private static void b(QQAppInterface paramQQAppInterface, DouFuInfo paramDouFuInfo)
  {
    JSONObject localJSONObject = a(paramDouFuInfo);
    long l = FeedsManager.getToken(String.valueOf(paramDouFuInfo.uin));
    ThreadManager.getSubThreadHandler().post(new BirthDayNoticeManager.1(paramDouFuInfo, paramQQAppInterface, localJSONObject, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.manager.BirthDayNoticeManager
 * JD-Core Version:    0.7.0.1
 */