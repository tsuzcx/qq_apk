import com.tencent.biz.pubaccount.readinjoy.biu.ReadInjoyFriendsBiuComponentFragment.ViewHolder.1.1;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class nsu
  implements oqi
{
  nsu(nst paramnst) {}
  
  public void a(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if ((paramReadInJoyUserInfo != null) && (this.a.a != null)) {
      ThreadManager.getUIHandler().post(new ReadInjoyFriendsBiuComponentFragment.ViewHolder.1.1(this));
    }
    if (paramReadInJoyUserInfo != null) {}
    for (paramReadInJoyUserInfo = paramReadInJoyUserInfo.nick;; paramReadInJoyUserInfo = "null")
    {
      QLog.d("ReadInjoyFriendsBiuComponentFragment", 1, new Object[] { "setComments infoSuccess nick = ", paramReadInJoyUserInfo, "  uin:" + paramString, " mContents:" + this.a.a });
      return;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    QLog.d("ReadInjoyFriendsBiuComponentFragment", 1, "setComments infoFailed. uin:" + paramString1 + " errMsg:" + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nsu
 * JD-Core Version:    0.7.0.1
 */