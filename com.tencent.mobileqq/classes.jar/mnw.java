import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;

public class mnw
  extends ajfb
{
  public mnw(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null)
    {
      notifyUI(1001, false, null);
      return;
    }
    int i = ((Bundle)paramObject).getInt("result");
    paramToServiceMsg = (BmqqUserSimpleInfo)((Bundle)paramObject).getParcelable("info");
    boolean bool1 = bool2;
    if (i == 0)
    {
      bool1 = bool2;
      if (paramToServiceMsg != null)
      {
        ((bcpn)this.mApp.getManager(165)).a(paramToServiceMsg);
        bool1 = true;
      }
    }
    notifyUI(1001, bool1, paramToServiceMsg);
  }
  
  public void a(String paramString)
  {
    if (!mnz.a(this.app.getApplication(), paramString)) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("hrtxformqq.service", this.app.getCurrentAccountUin(), "hrtxformqq.getUsrSimpleInfo");
    HashMap localHashMap = new HashMap();
    localHashMap.put("uin", Long.valueOf(paramString));
    localToServiceMsg.setAttributes(localHashMap);
    send(localToServiceMsg);
  }
  
  protected Class<? extends ajfe> observerClass()
  {
    return mnx.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("hrtxformqq.getUsrSimpleInfo".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mnw
 * JD-Core Version:    0.7.0.1
 */