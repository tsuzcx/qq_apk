import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class qxy
  implements qxr
{
  qxy(qxw paramqxw) {}
  
  public void a()
  {
    qxw.a(this.a, NetConnInfoCenter.getServerTimeMillis());
  }
  
  public void a(float paramFloat)
  {
    qxw.a(this.a, paramFloat);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      qxw.a(this.a, 4);
      if (QLog.isColorLevel()) {
        QLog.d("VideoDeliverController", 2, "mVideoTransProcessorHandler mVideoMd5=" + paramString2 + ", mVideoUuid=" + paramString3 + ", mVideoUrl=" + paramString1);
      }
      qxw.b(this.a, NetConnInfoCenter.getServerTimeMillis());
      nrt.a(qxw.a(this.a), "", "0X8008181", "0X8008181", 0, 0, String.valueOf(qxw.a(this.a)), String.valueOf(qxw.b(this.a)), String.valueOf(qxw.c(this.a) - qxw.d(this.a)), String.valueOf(qxw.e(this.a) - qxw.f(this.a)));
      qxw.a(this.a, 0, qxw.a(this.a), qxw.b(this.a), paramString1, paramString2, paramString3);
      paramString1 = qxn.a().a(qxw.a(this.a)).b(qxw.b(this.a)).d(paramString2).c(paramString1).e(paramString3).a(qxw.b(this.a)).b(qxw.g(this.a)).a();
      qxw.a(this.a, paramString1);
      return;
    case 1001: 
      qxw.b(this.a, 6);
      return;
    case 1002: 
      qxw.b(this.a, 5);
      return;
    case 1003: 
      qxw.b(this.a, 7);
      return;
    case 1004: 
      qxw.b(this.a, 7);
      qxw.c(this.a, 1004);
      nrt.a(qxw.a(this.a), "", "0X8008181", "0X8008181", 0, 1, String.valueOf(qxw.a(this.a)), String.valueOf(qxw.b(this.a)), String.valueOf(qxw.c(this.a) - qxw.d(this.a)), String.valueOf(qxw.e(this.a) - qxw.f(this.a)));
      return;
    }
    qxw.b(this.a, 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qxy
 * JD-Core Version:    0.7.0.1
 */