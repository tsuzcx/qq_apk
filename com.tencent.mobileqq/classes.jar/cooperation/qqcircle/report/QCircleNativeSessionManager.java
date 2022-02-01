package cooperation.qqcircle.report;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.QCircleHostStubUtil;
import java.util.Random;
import mqq.app.MobileQQ;

public class QCircleNativeSessionManager
  extends BaseMultiProcessSingleton
{
  private static final String KEY_XSJ_SESSION = "key_xsj_session";
  private static final String TAG = "QCircleNativeSessionManager";
  private static volatile QCircleNativeSessionManager sSingleton;
  
  private boolean checkNeedGenerateSession()
  {
    int i = QCircleReportHelper.getQQCirclePageStackNum();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkNeedGenerateSession   pageStackNum ");
    localStringBuilder.append(i);
    QLog.i("QCircleNativeSessionManager", 1, localStringBuilder.toString());
    return i == 0;
  }
  
  public static QCircleNativeSessionManager g()
  {
    if (sSingleton == null) {
      try
      {
        if (sSingleton == null) {
          sSingleton = new QCircleNativeSessionManager();
        }
      }
      finally {}
    }
    return sSingleton;
  }
  
  private void generateNativeSession()
  {
    StringBuilder localStringBuilder = new StringBuilder("android_session_");
    localStringBuilder.append(QCircleHostStubUtil.getCurrentAccount());
    localStringBuilder.append("_");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("_");
    localStringBuilder.append(new Random().nextInt(100));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("generateNativeSession  session = ");
    ((StringBuilder)localObject).append(localStringBuilder.toString());
    QLog.i("QCircleNativeSessionManager", 1, ((StringBuilder)localObject).toString());
    localObject = new Bundle();
    ((Bundle)localObject).putString("key_xsj_session", localStringBuilder.toString());
    updateMultiProcessData((Bundle)localObject);
  }
  
  private boolean isMainProcess()
  {
    return MobileQQ.sProcessId == 1;
  }
  
  private void updateNativeSession()
  {
    if ((isMainProcess()) && (checkNeedGenerateSession())) {
      generateNativeSession();
    }
  }
  
  public String getSession()
  {
    updateNativeSession();
    Object localObject = getMultiProcessData("key_xsj_session", "");
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleNativeSessionManager
 * JD-Core Version:    0.7.0.1
 */