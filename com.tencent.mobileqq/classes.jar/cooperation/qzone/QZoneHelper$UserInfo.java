package cooperation.qzone;

import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QZoneHelper$UserInfo
{
  private static UserInfo userInfo;
  public String nickname = null;
  public String qzone_uin = null;
  
  public static UserInfo getInstance()
  {
    if (userInfo == null) {
      userInfo = new UserInfo();
    }
    userInfo.qzone_uin = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
    UserInfo localUserInfo = userInfo;
    localUserInfo.nickname = null;
    return localUserInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper.UserInfo
 * JD-Core Version:    0.7.0.1
 */