package com.tencent.mobileqq.kandian.biz.pts.view.polymeric;

import com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoPlayListener;
import com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper.ProteusPagerSnapHelper;
import com.tencent.qphone.base.util.QLog;

class RvPolymericContainer$3$1
  implements VideoPlayListener
{
  RvPolymericContainer$3$1(RvPolymericContainer.3 param3) {}
  
  public void a()
  {
    QLog.d("RvPolymericContainer", 2, "stopScroll as videoplayer start");
    RvPolymericContainer.b(this.a.a);
  }
  
  public void b()
  {
    QLog.d("RvPolymericContainer", 2, "startScroll as videoplayer stop");
    if (RvPolymericContainer.a(this.a.a) != null) {
      RvPolymericContainer.a(this.a.a, RvPolymericContainer.a(this.a.a).a());
    }
  }
  
  public void c()
  {
    QLog.d("RvPolymericContainer", 2, "startScroll as videoplayer complete");
    RvPolymericContainer.a(this.a.a, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.polymeric.RvPolymericContainer.3.1
 * JD-Core Version:    0.7.0.1
 */