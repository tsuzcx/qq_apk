package cooperation.ilive.lite;

import com.tencent.mobileqq.litelivesdk.api.login.IBizLoginObserver;
import com.tencent.mobileqq.litelivesdk.api.login.ILiveLoginTicketListener;
import com.tencent.mobileqq.litelivesdk.api.login.LoginResult;
import com.tencent.mobileqq.vas.VasStatisticCollector;
import com.tencent.qphone.base.util.QLog;

class IliveLiteHelper$2
  implements ILiveLoginTicketListener
{
  IliveLiteHelper$2(IliveLiteHelper paramIliveLiteHelper) {}
  
  public void a(int paramInt, IBizLoginObserver paramIBizLoginObserver)
  {
    QLog.e("IliveLiteHelper", 1, "Ilive refresh Token ");
    if (IliveLiteHelper.a(this.a) == 2)
    {
      if (paramInt == 1)
      {
        long l = System.currentTimeMillis() - IliveLiteHelper.a(this.a);
        QLog.e("IliveLiteHelper", 1, "login cost " + l + " start time " + IliveLiteHelper.a(this.a));
        VasStatisticCollector.a("lite_process_bind", null, l);
      }
      IliveLiteHelper.c(this.a);
      return;
    }
    IliveLiteHelper.a(this.a, paramIBizLoginObserver);
    IliveLiteHelper.a(this.a, 3);
    IliveLiteHelper.c(this.a);
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(LoginResult paramLoginResult)
  {
    if (IliveLiteHelper.a(this.a) != -1L)
    {
      long l = System.currentTimeMillis() - IliveLiteHelper.a(this.a);
      QLog.e("IliveLiteHelper", 1, "login cost " + l + " start time " + IliveLiteHelper.a(this.a));
      IliveLiteHelper.a(this.a, -1L);
      VasStatisticCollector.a("lite_onlogin", null, l);
    }
    IliveLiteHelper.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.lite.IliveLiteHelper.2
 * JD-Core Version:    0.7.0.1
 */