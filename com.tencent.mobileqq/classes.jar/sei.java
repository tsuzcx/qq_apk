import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class sei
  implements seb
{
  sei(seg paramseg) {}
  
  public void a()
  {
    seg.a(this.a, NetConnInfoCenter.getServerTimeMillis());
  }
  
  public void a(float paramFloat)
  {
    seg.a(this.a, paramFloat);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      seg.a(this.a, 4);
      if (QLog.isColorLevel()) {
        QLog.d("VideoDeliverController", 2, "mVideoTransProcessorHandler mVideoMd5=" + paramString2 + ", mVideoUuid=" + paramString3 + ", mVideoUrl=" + paramString1);
      }
      seg.b(this.a, NetConnInfoCenter.getServerTimeMillis());
      olh.a(seg.a(this.a), "", "0X8008181", "0X8008181", 0, 0, String.valueOf(seg.a(this.a)), String.valueOf(seg.b(this.a)), String.valueOf(seg.c(this.a) - seg.d(this.a)), String.valueOf(seg.e(this.a) - seg.f(this.a)));
      seg.a(this.a, 0, seg.a(this.a), seg.b(this.a), paramString1, paramString2, paramString3);
      paramString1 = sdx.a().a(seg.a(this.a)).b(seg.b(this.a)).d(paramString2).c(paramString1).e(paramString3).a(seg.b(this.a)).b(seg.g(this.a)).a();
      seg.a(this.a, paramString1);
      return;
    case 1001: 
      seg.b(this.a, 6);
      return;
    case 1002: 
      seg.b(this.a, 5);
      return;
    case 1003: 
      seg.b(this.a, 7);
      return;
    case 1004: 
      seg.b(this.a, 7);
      seg.c(this.a, 1004);
      olh.a(seg.a(this.a), "", "0X8008181", "0X8008181", 0, 1, String.valueOf(seg.a(this.a)), String.valueOf(seg.b(this.a)), String.valueOf(seg.c(this.a) - seg.d(this.a)), String.valueOf(seg.e(this.a) - seg.f(this.a)));
      return;
    }
    seg.b(this.a, 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sei
 * JD-Core Version:    0.7.0.1
 */