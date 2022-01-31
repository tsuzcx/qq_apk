import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class qir
  implements qik
{
  qir(qip paramqip) {}
  
  public void a()
  {
    qip.a(this.a, NetConnInfoCenter.getServerTimeMillis());
  }
  
  public void a(float paramFloat)
  {
    qip.a(this.a, paramFloat);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      qip.a(this.a, 4);
      if (QLog.isColorLevel()) {
        QLog.d("VideoDeliverController", 2, "mVideoTransProcessorHandler mVideoMd5=" + paramString2 + ", mVideoUuid=" + paramString3 + ", mVideoUrl=" + paramString1);
      }
      qip.b(this.a, NetConnInfoCenter.getServerTimeMillis());
      nol.a(qip.a(this.a), "", "0X8008181", "0X8008181", 0, 0, String.valueOf(qip.a(this.a)), String.valueOf(qip.b(this.a)), String.valueOf(qip.c(this.a) - qip.d(this.a)), String.valueOf(qip.e(this.a) - qip.f(this.a)));
      qip.a(this.a, 0, qip.a(this.a), qip.b(this.a), paramString1, paramString2, paramString3);
      paramString1 = qig.a().a(qip.a(this.a)).b(qip.b(this.a)).d(paramString2).c(paramString1).e(paramString3).a(qip.b(this.a)).b(qip.g(this.a)).a();
      qip.a(this.a, paramString1);
      return;
    case 1001: 
      qip.b(this.a, 6);
      return;
    case 1002: 
      qip.b(this.a, 5);
      return;
    case 1003: 
      qip.b(this.a, 7);
      return;
    case 1004: 
      qip.b(this.a, 7);
      qip.c(this.a, 1004);
      nol.a(qip.a(this.a), "", "0X8008181", "0X8008181", 0, 1, String.valueOf(qip.a(this.a)), String.valueOf(qip.b(this.a)), String.valueOf(qip.c(this.a) - qip.d(this.a)), String.valueOf(qip.e(this.a) - qip.f(this.a)));
      return;
    }
    qip.b(this.a, 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qir
 * JD-Core Version:    0.7.0.1
 */