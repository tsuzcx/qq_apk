import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class sgo
  extends rst
{
  sgo(sgn paramsgn) {}
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(sgn.a(this.a), 2, "onPreloadFinished()");
    }
    this.a.a.j();
  }
  
  public void a(sdj paramsdj, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(sgn.a(this.a), 2, "onVideoPrepared(VideoPlayerWrapper player, Object tag) ");
    }
    if ((sgn.a(this.a) != null) && (QLog.isColorLevel())) {
      QLog.d(sgn.a(this.a), 2, "播放状态回调 onVideoPrepared() vid=" + sgn.a(this.a).a + ", mIsOpenedVideo = " + sgn.b(this.a) + ", preload=" + sgn.a(this.a) + ", mActivityOnResume=" + sgn.c(this.a));
    }
    if (sgn.a(this.a)) {
      a();
    }
    do
    {
      return;
      if (sgn.b(this.a)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(sgn.a(this.a), 2, "onVideoPrepared  return isOpenedVideo false");
    return;
    sgn.b(this.a, false);
    sgn.a(this.a).removeMessages(0);
    sgn.a(this.a).sendEmptyMessage(0);
    paramsdj = sgn.a(this.a).iterator();
    while (paramsdj.hasNext()) {
      ((sgr)paramsdj.next()).onVideoPrepared();
    }
    paramsdj = sgn.b(this.a).iterator();
    while (paramsdj.hasNext()) {
      ((sgm)paramsdj.next()).b(this.a.a);
    }
    sgn.b(this.a);
  }
  
  public void a(sdj paramsdj, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(sgn.a(this.a), 2, "onConnectQualityCallback json= " + paramString);
    }
    if (sgn.a(this.a) != null) {
      sfl.a().a(paramsdj, sgn.a(this.a).b, paramsdj.d());
    }
    paramsdj = sgn.b(this.a).iterator();
    while (paramsdj.hasNext()) {
      ((sgm)paramsdj.next()).a(paramString);
    }
  }
  
  public boolean a(sdj paramsdj, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    paramString = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null)
    {
      paramsdj = paramObject.toString();
      paramsdj = paramsdj;
      if (QLog.isColorLevel())
      {
        paramString = sgn.a(this.a);
        paramObject = new StringBuilder().append("播放状态回调 onError() ").append(paramsdj).append(", vid=");
        if (sgn.a(this.a) == null) {
          break label239;
        }
      }
    }
    label239:
    for (paramsdj = sgn.a(this.a).a;; paramsdj = null)
    {
      QLog.d(paramString, 2, paramsdj);
      if (sgn.a(this.a))
      {
        sgn.a(this.a, this.a.a);
        sgn.a(this.a, false);
      }
      paramsdj = sgl.a(paramInt1, paramInt2, paramInt3);
      paramString = sgn.a(this.a).iterator();
      while (paramString.hasNext()) {
        ((sgr)paramString.next()).onVideoError(paramInt1, paramInt2, paramsdj);
      }
      paramsdj = "";
      break;
    }
    paramString = sgn.b(this.a).iterator();
    while (paramString.hasNext()) {
      ((sgm)paramString.next()).a(paramInt1, paramInt2, paramsdj);
    }
    return false;
  }
  
  public boolean a(sdj paramsdj, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramsdj = sgn.b(this.a).iterator();
      while (paramsdj.hasNext()) {
        ((sgm)paramsdj.next()).a(paramInt, paramObject);
      }
      if (QLog.isColorLevel()) {
        QLog.d(sgn.a(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_START_BUFFERING");
      }
      paramsdj = sgn.a(this.a).iterator();
      while (paramsdj.hasNext()) {
        ((sgr)paramsdj.next()).onBufferStart();
      }
      if (QLog.isColorLevel()) {
        QLog.d(sgn.a(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_ENDOF_BUFFERING");
      }
      paramsdj = sgn.a(this.a).iterator();
      while (paramsdj.hasNext()) {
        ((sgr)paramsdj.next()).onBufferEnd();
      }
      if (QLog.isColorLevel()) {
        QLog.d(sgn.a(this.a), 2, "onInfo: PLAYER_INFO_FIRST_VIDEO_FRAME_REDNERED");
      }
      paramsdj = sgn.a(this.a).iterator();
      while (paramsdj.hasNext()) {
        ((sgr)paramsdj.next()).onFirstFrameRendered();
      }
    }
    return false;
  }
  
  public void b(sdj paramsdj)
  {
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = sgn.a(this.a);
      localStringBuilder = new StringBuilder().append("播放状态回调 onCompletion() vid=");
      if (sgn.a(this.a) == null) {
        break label111;
      }
    }
    label111:
    for (paramsdj = sgn.a(this.a).a;; paramsdj = "param null")
    {
      QLog.d(str, 2, paramsdj);
      this.a.a.a(null);
      paramsdj = sgn.a(this.a).iterator();
      while (paramsdj.hasNext()) {
        ((sgr)paramsdj.next()).onCompletion();
      }
    }
    paramsdj = sgn.b(this.a).iterator();
    while (paramsdj.hasNext()) {
      ((sgm)paramsdj.next()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sgo
 * JD-Core Version:    0.7.0.1
 */