package cooperation.qzone;

import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class QZoneHelper$UserInfo
{
  private static UserInfo userInfo;
  public String nickname;
  public String qzone_uin;
  
  public static UserInfo getInstance()
  {
    if (userInfo == null) {
      userInfo = new UserInfo();
    }
    userInfo.qzone_uin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    userInfo.nickname = null;
    return userInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper.UserInfo
 * JD-Core Version:    0.7.0.1
 */