import com.tencent.biz.pubaccount.readinjoy.biu.ReadInjoyFriendsBiuComponentFragment.ViewHolder.2.1;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInjoyFriendsBiuComponentFragment.ViewHolder.2.2;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ouz
  implements pyb
{
  ouz(oux paramoux) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.equals(paramString1))) {
      ThreadManager.getUIHandler().post(new ReadInjoyFriendsBiuComponentFragment.ViewHolder.2.2(this));
    }
    QLog.d("ReadInjoyFriendsBiuComponentFragment", 1, "setNickName infoFailed. uin:" + paramString1 + " errMsg:" + paramString2);
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if ((paramString != null) && (paramString.equals(paramString)) && (paramReadInJoyUserInfo != null)) {
      ThreadManager.getUIHandler().post(new ReadInjoyFriendsBiuComponentFragment.ViewHolder.2.1(this, paramReadInJoyUserInfo));
    }
    if (paramReadInJoyUserInfo != null) {}
    for (paramReadInJoyUserInfo = paramReadInJoyUserInfo.nick;; paramReadInJoyUserInfo = "null")
    {
      QLog.d("ReadInjoyFriendsBiuComponentFragment", 1, new Object[] { "setNickName infoSuccess nick = ", paramReadInJoyUserInfo, "  uin:" + paramString });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ouz
 * JD-Core Version:    0.7.0.1
 */