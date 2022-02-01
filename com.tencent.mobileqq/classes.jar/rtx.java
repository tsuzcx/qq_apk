import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class rtx
  implements rtq
{
  rtx(rtv paramrtv) {}
  
  public void a()
  {
    rtv.a(this.a, NetConnInfoCenter.getServerTimeMillis());
  }
  
  public void a(float paramFloat)
  {
    rtv.a(this.a, paramFloat);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      rtv.a(this.a, 4);
      if (QLog.isColorLevel()) {
        QLog.d("VideoDeliverController", 2, "mVideoTransProcessorHandler mVideoMd5=" + paramString2 + ", mVideoUuid=" + paramString3 + ", mVideoUrl=" + paramString1);
      }
      rtv.b(this.a, NetConnInfoCenter.getServerTimeMillis());
      oat.a(rtv.a(this.a), "", "0X8008181", "0X8008181", 0, 0, String.valueOf(rtv.a(this.a)), String.valueOf(rtv.b(this.a)), String.valueOf(rtv.c(this.a) - rtv.d(this.a)), String.valueOf(rtv.e(this.a) - rtv.f(this.a)));
      rtv.a(this.a, 0, rtv.a(this.a), rtv.b(this.a), paramString1, paramString2, paramString3);
      paramString1 = rtm.a().a(rtv.a(this.a)).b(rtv.b(this.a)).d(paramString2).c(paramString1).e(paramString3).a(rtv.b(this.a)).b(rtv.g(this.a)).a();
      rtv.a(this.a, paramString1);
      return;
    case 1001: 
      rtv.b(this.a, 6);
      return;
    case 1002: 
      rtv.b(this.a, 5);
      return;
    case 1003: 
      rtv.b(this.a, 7);
      return;
    case 1004: 
      rtv.b(this.a, 7);
      rtv.c(this.a, 1004);
      oat.a(rtv.a(this.a), "", "0X8008181", "0X8008181", 0, 1, String.valueOf(rtv.a(this.a)), String.valueOf(rtv.b(this.a)), String.valueOf(rtv.c(this.a) - rtv.d(this.a)), String.valueOf(rtv.e(this.a) - rtv.f(this.a)));
      return;
    }
    rtv.b(this.a, 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rtx
 * JD-Core Version:    0.7.0.1
 */