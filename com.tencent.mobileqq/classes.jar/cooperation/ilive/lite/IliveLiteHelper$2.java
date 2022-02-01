package cooperation.ilive.lite;

import com.tencent.mobileqq.litelivesdk.api.login.IBizLoginObserver;
import com.tencent.mobileqq.litelivesdk.api.login.ILiveLoginTicketListener;
import com.tencent.mobileqq.litelivesdk.api.login.LoginResult;
import com.tencent.qphone.base.util.QLog;

class IliveLiteHelper$2
  implements ILiveLoginTicketListener
{
  IliveLiteHelper$2(IliveLiteHelper paramIliveLiteHelper) {}
  
  public void a(int paramInt, IBizLoginObserver paramIBizLoginObserver)
  {
    QLog.e("IliveLiteHelper", 1, "Ilive refresh Token ");
    if (IliveLiteHelper.d(this.a) == 2)
    {
      if (paramInt == 1)
      {
        long l1 = System.currentTimeMillis();
        long l2 = IliveLiteHelper.b(this.a);
        paramIBizLoginObserver = new StringBuilder();
        paramIBizLoginObserver.append("login cost ");
        paramIBizLoginObserver.append(l1 - l2);
        paramIBizLoginObserver.append(" start time ");
        paramIBizLoginObserver.append(IliveLiteHelper.b(this.a));
        QLog.e("IliveLiteHelper", 1, paramIBizLoginObserver.toString());
        IliveLiteMonitorUtil.a("lite_process_bind", IliveLiteHelper.b(this.a));
        IliveLiteMonitorUtil.c("lite_process_bind");
      }
      IliveLiteHelper.e(this.a);
      return;
    }
    IliveLiteHelper.a(this.a, paramIBizLoginObserver);
    IliveLiteHelper.a(this.a, 3);
    IliveLiteHelper.e(this.a);
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(LoginResult paramLoginResult)
  {
    if (IliveLiteHelper.b(this.a) != -1L)
    {
      long l1 = System.currentTimeMillis();
      long l2 = IliveLiteHelper.b(this.a);
      paramLoginResult = new StringBuilder();
      paramLoginResult.append("login cost ");
      paramLoginResult.append(l1 - l2);
      paramLoginResult.append(" start time ");
      paramLoginResult.append(IliveLiteHelper.b(this.a));
      QLog.e("IliveLiteHelper", 1, paramLoginResult.toString());
      IliveLiteMonitorUtil.a("lite_onlogin", IliveLiteHelper.b(this.a));
      IliveLiteMonitorUtil.c("lite_onlogin");
      IliveLiteHelper.a(this.a, -1L);
    }
    IliveLiteHelper.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.IliveLiteHelper.2
 * JD-Core Version:    0.7.0.1
 */