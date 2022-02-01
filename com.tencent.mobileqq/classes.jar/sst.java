import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class sst
  extends sfi
{
  sst(sss paramsss) {}
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(sss.a(this.a), 2, "onPreloadFinished()");
    }
    this.a.a.j();
  }
  
  public void a(spn paramspn, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(sss.a(this.a), 2, "onVideoPrepared(VideoPlayerWrapper player, Object tag) ");
    }
    if ((sss.a(this.a) != null) && (QLog.isColorLevel())) {
      QLog.d(sss.a(this.a), 2, "播放状态回调 onVideoPrepared() vid=" + sss.a(this.a).a + ", mIsOpenedVideo = " + sss.b(this.a) + ", preload=" + sss.a(this.a) + ", mActivityOnResume=" + sss.c(this.a));
    }
    if (sss.a(this.a)) {
      a();
    }
    do
    {
      return;
      if (sss.b(this.a)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(sss.a(this.a), 2, "onVideoPrepared  return isOpenedVideo false");
    return;
    sss.b(this.a, false);
    sss.a(this.a).removeMessages(0);
    sss.a(this.a).sendEmptyMessage(0);
    paramspn = sss.a(this.a).iterator();
    while (paramspn.hasNext()) {
      ((ssw)paramspn.next()).onVideoPrepared();
    }
    paramspn = sss.b(this.a).iterator();
    while (paramspn.hasNext()) {
      ((ssr)paramspn.next()).b(this.a.a);
    }
    sss.b(this.a);
  }
  
  public void a(spn paramspn, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(sss.a(this.a), 2, "onConnectQualityCallback json= " + paramString);
    }
    if (sss.a(this.a) != null) {
      srq.a().a(paramspn, sss.a(this.a).b, paramspn.d());
    }
    paramspn = sss.b(this.a).iterator();
    while (paramspn.hasNext()) {
      ((ssr)paramspn.next()).a(paramString);
    }
  }
  
  public boolean a(spn paramspn, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    paramString = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null)
    {
      paramspn = paramObject.toString();
      paramspn = paramspn;
      if (QLog.isColorLevel())
      {
        paramString = sss.a(this.a);
        paramObject = new StringBuilder().append("播放状态回调 onError() ").append(paramspn).append(", vid=");
        if (sss.a(this.a) == null) {
          break label239;
        }
      }
    }
    label239:
    for (paramspn = sss.a(this.a).a;; paramspn = null)
    {
      QLog.d(paramString, 2, paramspn);
      if (sss.a(this.a))
      {
        sss.a(this.a, this.a.a);
        sss.a(this.a, false);
      }
      paramspn = ssq.a(paramInt1, paramInt2, paramInt3);
      paramString = sss.a(this.a).iterator();
      while (paramString.hasNext()) {
        ((ssw)paramString.next()).onVideoError(paramInt1, paramInt2, paramspn);
      }
      paramspn = "";
      break;
    }
    paramString = sss.b(this.a).iterator();
    while (paramString.hasNext()) {
      ((ssr)paramString.next()).a(paramInt1, paramInt2, paramspn);
    }
    return false;
  }
  
  public boolean a(spn paramspn, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramspn = sss.b(this.a).iterator();
      while (paramspn.hasNext()) {
        ((ssr)paramspn.next()).a(paramInt, paramObject);
      }
      if (QLog.isColorLevel()) {
        QLog.d(sss.a(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_START_BUFFERING");
      }
      paramspn = sss.a(this.a).iterator();
      while (paramspn.hasNext()) {
        ((ssw)paramspn.next()).onBufferStart();
      }
      if (QLog.isColorLevel()) {
        QLog.d(sss.a(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_ENDOF_BUFFERING");
      }
      paramspn = sss.a(this.a).iterator();
      while (paramspn.hasNext()) {
        ((ssw)paramspn.next()).onBufferEnd();
      }
      if (QLog.isColorLevel()) {
        QLog.d(sss.a(this.a), 2, "onInfo: PLAYER_INFO_FIRST_VIDEO_FRAME_REDNERED");
      }
      paramspn = sss.a(this.a).iterator();
      while (paramspn.hasNext()) {
        ((ssw)paramspn.next()).onFirstFrameRendered();
      }
    }
    return false;
  }
  
  public void b(spn paramspn)
  {
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = sss.a(this.a);
      localStringBuilder = new StringBuilder().append("播放状态回调 onCompletion() vid=");
      if (sss.a(this.a) == null) {
        break label111;
      }
    }
    label111:
    for (paramspn = sss.a(this.a).a;; paramspn = "param null")
    {
      QLog.d(str, 2, paramspn);
      this.a.a.a(null);
      paramspn = sss.a(this.a).iterator();
      while (paramspn.hasNext()) {
        ((ssw)paramspn.next()).onCompletion();
      }
    }
    paramspn = sss.b(this.a).iterator();
    while (paramspn.hasNext()) {
      ((ssr)paramspn.next()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sst
 * JD-Core Version:    0.7.0.1
 */