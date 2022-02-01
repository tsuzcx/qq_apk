import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ooi
  extends QIPCModule
{
  private static volatile ooi a;
  
  public ooi(String paramString)
  {
    super(paramString);
  }
  
  private int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = paramQQAppInterface.getProxyManager().a();
    int i = uuc.b(paramQQAppInterface, paramString);
    localObject = (RecentUser)((aoxz)localObject).findRecentUser(paramString, i);
    paramQQAppInterface = (QQAppInterface)localObject;
    if (localObject == null)
    {
      QLog.d("EcshopIPCModule", 1, "isPublicAccoutMsgTabSetTop pUin = " + paramString + " userType = " + i + " not in the msglist");
      paramQQAppInterface = new RecentUser(paramString, i);
    }
    if (paramQQAppInterface.showUpTime != 0L) {
      return 1;
    }
    return 0;
  }
  
  public static ooi a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ooi("EcshopIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  private int b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EcshopIPCModule", 1, "ActionSheet setOrCancelSetTop");
    }
    int i = uuc.b(paramQQAppInterface, paramString);
    if (i == 1024) {
      QLog.d("EcshopIPCModule", 1, "setOrCancelTop pUin = " + paramString + " userType = " + i + " is UIN_TYPE_BUSINESS_CMR_TMP");
    }
    aoxz localaoxz = paramQQAppInterface.getProxyManager().a();
    RecentUser localRecentUser2 = (RecentUser)localaoxz.findRecentUser(paramString, i);
    RecentUser localRecentUser1 = localRecentUser2;
    if (localRecentUser2 == null)
    {
      QLog.d("EcshopIPCModule", 1, "setOrCancelTop pUin = " + paramString + " userType = " + i + " not in the msglist");
      localRecentUser1 = new RecentUser(paramString, i);
    }
    if (a(paramQQAppInterface, paramString) == 1) {}
    for (localRecentUser1.showUpTime = 0L;; localRecentUser1.showUpTime = (System.currentTimeMillis() / 1000L))
    {
      localaoxz.saveRecentUser(localRecentUser1);
      paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.sendEmptyMessage(1009);
      }
      return 0;
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    try
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
      if (!(localAppRuntime instanceof QQAppInterface)) {
        return null;
      }
      if ("reportToBeacon".equals(paramString))
      {
        opk.a(paramBundle.getString("key_report_event"), (HashMap)paramBundle.getSerializable("key_report_params"));
      }
      else if ("setPublicAccountTop".equals(paramString))
      {
        paramString = (QQAppInterface)localAppRuntime;
        paramInt = paramBundle.getInt("isTop");
        int i = a(paramString, "3046055438");
        opk.a(null, "gouwu.top.click", paramInt + "", NetConnInfoCenter.getServerTimeMillis() + "", "");
        if (paramInt == 1)
        {
          if (i == 0) {
            return EIPCResult.createResult(b((QQAppInterface)localAppRuntime, "3046055438"), null);
          }
          return EIPCResult.createResult(0, null);
        }
        if (paramInt == 0)
        {
          if (i == 0) {
            return EIPCResult.createResult(0, null);
          }
          return EIPCResult.createResult(b((QQAppInterface)localAppRuntime, "3046055438"), null);
        }
      }
      else if ("queryPublicAccountTop".equals(paramString))
      {
        paramString = EIPCResult.createResult(a((QQAppInterface)localAppRuntime, "3046055438"), null);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("EcshopIPCModule", 1, paramString, new Object[0]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ooi
 * JD-Core Version:    0.7.0.1
 */