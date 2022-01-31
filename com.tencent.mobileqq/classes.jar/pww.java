import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class pww
  implements pwp
{
  pww(pwu parampwu) {}
  
  public void a()
  {
    pwu.a(this.a, NetConnInfoCenter.getServerTimeMillis());
  }
  
  public void a(float paramFloat)
  {
    pwu.a(this.a, paramFloat);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      pwu.a(this.a, 4);
      if (QLog.isColorLevel()) {
        QLog.d("VideoDeliverController", 2, "mVideoTransProcessorHandler mVideoMd5=" + paramString2 + ", mVideoUuid=" + paramString3 + ", mVideoUrl=" + paramString1);
      }
      pwu.b(this.a, NetConnInfoCenter.getServerTimeMillis());
      ndn.a(pwu.a(this.a), "", "0X8008181", "0X8008181", 0, 0, String.valueOf(pwu.a(this.a)), String.valueOf(pwu.b(this.a)), String.valueOf(pwu.c(this.a) - pwu.d(this.a)), String.valueOf(pwu.e(this.a) - pwu.f(this.a)));
      pwu.a(this.a, 0, pwu.a(this.a), pwu.b(this.a), paramString1, paramString2, paramString3);
      paramString1 = pwl.a().a(pwu.a(this.a)).b(pwu.b(this.a)).d(paramString2).c(paramString1).e(paramString3).a(pwu.b(this.a)).b(pwu.g(this.a)).a();
      pwu.a(this.a, paramString1);
      return;
    case 1001: 
      pwu.b(this.a, 6);
      return;
    case 1002: 
      pwu.b(this.a, 5);
      return;
    case 1003: 
      pwu.b(this.a, 7);
      return;
    case 1004: 
      pwu.b(this.a, 7);
      pwu.c(this.a, 1004);
      ndn.a(pwu.a(this.a), "", "0X8008181", "0X8008181", 0, 1, String.valueOf(pwu.a(this.a)), String.valueOf(pwu.b(this.a)), String.valueOf(pwu.c(this.a) - pwu.d(this.a)), String.valueOf(pwu.e(this.a) - pwu.f(this.a)));
      return;
    }
    pwu.b(this.a, 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pww
 * JD-Core Version:    0.7.0.1
 */