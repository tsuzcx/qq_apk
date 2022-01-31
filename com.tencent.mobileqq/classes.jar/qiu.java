import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class qiu
  implements qin
{
  qiu(qis paramqis) {}
  
  public void a()
  {
    qis.a(this.a, NetConnInfoCenter.getServerTimeMillis());
  }
  
  public void a(float paramFloat)
  {
    qis.a(this.a, paramFloat);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      qis.a(this.a, 4);
      if (QLog.isColorLevel()) {
        QLog.d("VideoDeliverController", 2, "mVideoTransProcessorHandler mVideoMd5=" + paramString2 + ", mVideoUuid=" + paramString3 + ", mVideoUrl=" + paramString1);
      }
      qis.b(this.a, NetConnInfoCenter.getServerTimeMillis());
      noo.a(qis.a(this.a), "", "0X8008181", "0X8008181", 0, 0, String.valueOf(qis.a(this.a)), String.valueOf(qis.b(this.a)), String.valueOf(qis.c(this.a) - qis.d(this.a)), String.valueOf(qis.e(this.a) - qis.f(this.a)));
      qis.a(this.a, 0, qis.a(this.a), qis.b(this.a), paramString1, paramString2, paramString3);
      paramString1 = qij.a().a(qis.a(this.a)).b(qis.b(this.a)).d(paramString2).c(paramString1).e(paramString3).a(qis.b(this.a)).b(qis.g(this.a)).a();
      qis.a(this.a, paramString1);
      return;
    case 1001: 
      qis.b(this.a, 6);
      return;
    case 1002: 
      qis.b(this.a, 5);
      return;
    case 1003: 
      qis.b(this.a, 7);
      return;
    case 1004: 
      qis.b(this.a, 7);
      qis.c(this.a, 1004);
      noo.a(qis.a(this.a), "", "0X8008181", "0X8008181", 0, 1, String.valueOf(qis.a(this.a)), String.valueOf(qis.b(this.a)), String.valueOf(qis.c(this.a) - qis.d(this.a)), String.valueOf(qis.e(this.a) - qis.f(this.a)));
      return;
    }
    qis.b(this.a, 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qiu
 * JD-Core Version:    0.7.0.1
 */