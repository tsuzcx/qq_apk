import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class rkt
  implements rkm
{
  rkt(rkr paramrkr) {}
  
  public void a()
  {
    rkr.a(this.a, NetConnInfoCenter.getServerTimeMillis());
  }
  
  public void a(float paramFloat)
  {
    rkr.a(this.a, paramFloat);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      rkr.a(this.a, 4);
      if (QLog.isColorLevel()) {
        QLog.d("VideoDeliverController", 2, "mVideoTransProcessorHandler mVideoMd5=" + paramString2 + ", mVideoUuid=" + paramString3 + ", mVideoUrl=" + paramString1);
      }
      rkr.b(this.a, NetConnInfoCenter.getServerTimeMillis());
      ocd.a(rkr.a(this.a), "", "0X8008181", "0X8008181", 0, 0, String.valueOf(rkr.a(this.a)), String.valueOf(rkr.b(this.a)), String.valueOf(rkr.c(this.a) - rkr.d(this.a)), String.valueOf(rkr.e(this.a) - rkr.f(this.a)));
      rkr.a(this.a, 0, rkr.a(this.a), rkr.b(this.a), paramString1, paramString2, paramString3);
      paramString1 = rki.a().a(rkr.a(this.a)).b(rkr.b(this.a)).d(paramString2).c(paramString1).e(paramString3).a(rkr.b(this.a)).b(rkr.g(this.a)).a();
      rkr.a(this.a, paramString1);
      return;
    case 1001: 
      rkr.b(this.a, 6);
      return;
    case 1002: 
      rkr.b(this.a, 5);
      return;
    case 1003: 
      rkr.b(this.a, 7);
      return;
    case 1004: 
      rkr.b(this.a, 7);
      rkr.c(this.a, 1004);
      ocd.a(rkr.a(this.a), "", "0X8008181", "0X8008181", 0, 1, String.valueOf(rkr.a(this.a)), String.valueOf(rkr.b(this.a)), String.valueOf(rkr.c(this.a) - rkr.d(this.a)), String.valueOf(rkr.e(this.a) - rkr.f(this.a)));
      return;
    }
    rkr.b(this.a, 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rkt
 * JD-Core Version:    0.7.0.1
 */