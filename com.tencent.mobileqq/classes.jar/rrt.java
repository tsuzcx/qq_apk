import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class rrt
  implements rrm
{
  rrt(rrr paramrrr) {}
  
  public void a()
  {
    rrr.a(this.a, NetConnInfoCenter.getServerTimeMillis());
  }
  
  public void a(float paramFloat)
  {
    rrr.a(this.a, paramFloat);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      rrr.a(this.a, 4);
      if (QLog.isColorLevel()) {
        QLog.d("VideoDeliverController", 2, "mVideoTransProcessorHandler mVideoMd5=" + paramString2 + ", mVideoUuid=" + paramString3 + ", mVideoUrl=" + paramString1);
      }
      rrr.b(this.a, NetConnInfoCenter.getServerTimeMillis());
      odq.a(rrr.a(this.a), "", "0X8008181", "0X8008181", 0, 0, String.valueOf(rrr.a(this.a)), String.valueOf(rrr.b(this.a)), String.valueOf(rrr.c(this.a) - rrr.d(this.a)), String.valueOf(rrr.e(this.a) - rrr.f(this.a)));
      rrr.a(this.a, 0, rrr.a(this.a), rrr.b(this.a), paramString1, paramString2, paramString3);
      paramString1 = rri.a().a(rrr.a(this.a)).b(rrr.b(this.a)).d(paramString2).c(paramString1).e(paramString3).a(rrr.b(this.a)).b(rrr.g(this.a)).a();
      rrr.a(this.a, paramString1);
      return;
    case 1001: 
      rrr.b(this.a, 6);
      return;
    case 1002: 
      rrr.b(this.a, 5);
      return;
    case 1003: 
      rrr.b(this.a, 7);
      return;
    case 1004: 
      rrr.b(this.a, 7);
      rrr.c(this.a, 1004);
      odq.a(rrr.a(this.a), "", "0X8008181", "0X8008181", 0, 1, String.valueOf(rrr.a(this.a)), String.valueOf(rrr.b(this.a)), String.valueOf(rrr.c(this.a) - rrr.d(this.a)), String.valueOf(rrr.e(this.a) - rrr.f(this.a)));
      return;
    }
    rrr.b(this.a, 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rrt
 * JD-Core Version:    0.7.0.1
 */