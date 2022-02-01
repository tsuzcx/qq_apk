package cooperation.qwallet;

import mqq.app.AppRuntime;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;

public class QwalletBlUtils
{
  public static String a(AppRuntime paramAppRuntime)
  {
    MobileQQ localMobileQQ = paramAppRuntime.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Constants.PropertiesKey.nickName.toString());
    localStringBuilder.append(paramAppRuntime.getCurrentUin());
    return localMobileQQ.getProperty(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qwallet.QwalletBlUtils
 * JD-Core Version:    0.7.0.1
 */