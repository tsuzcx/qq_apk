import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class rzk
  extends rlt
{
  rzk(rzj paramrzj) {}
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(rzj.a(this.a), 2, "onPreloadFinished()");
    }
    this.a.a.j();
  }
  
  public void a(rwf paramrwf, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(rzj.a(this.a), 2, "onVideoPrepared(VideoPlayerWrapper player, Object tag) ");
    }
    if ((rzj.a(this.a) != null) && (QLog.isColorLevel())) {
      QLog.d(rzj.a(this.a), 2, "播放状态回调 onVideoPrepared() vid=" + rzj.a(this.a).a + ", mIsOpenedVideo = " + rzj.b(this.a) + ", preload=" + rzj.a(this.a) + ", mActivityOnResume=" + rzj.c(this.a));
    }
    if (rzj.a(this.a)) {
      a();
    }
    do
    {
      return;
      if (rzj.b(this.a)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(rzj.a(this.a), 2, "onVideoPrepared  return isOpenedVideo false");
    return;
    rzj.b(this.a, false);
    rzj.a(this.a).removeMessages(0);
    rzj.a(this.a).sendEmptyMessage(0);
    paramrwf = rzj.a(this.a).iterator();
    while (paramrwf.hasNext()) {
      ((rzn)paramrwf.next()).onVideoPrepared();
    }
    paramrwf = rzj.b(this.a).iterator();
    while (paramrwf.hasNext()) {
      ((rzi)paramrwf.next()).b(this.a.a);
    }
    rzj.b(this.a);
  }
  
  public void a(rwf paramrwf, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(rzj.a(this.a), 2, "onConnectQualityCallback json= " + paramString);
    }
    if (rzj.a(this.a) != null) {
      ryh.a().a(paramrwf, rzj.a(this.a).b, paramrwf.d());
    }
    paramrwf = rzj.b(this.a).iterator();
    while (paramrwf.hasNext()) {
      ((rzi)paramrwf.next()).a(paramString);
    }
  }
  
  public boolean a(rwf paramrwf, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    paramString = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null)
    {
      paramrwf = paramObject.toString();
      paramrwf = paramrwf;
      if (QLog.isColorLevel())
      {
        paramString = rzj.a(this.a);
        paramObject = new StringBuilder().append("播放状态回调 onError() ").append(paramrwf).append(", vid=");
        if (rzj.a(this.a) == null) {
          break label239;
        }
      }
    }
    label239:
    for (paramrwf = rzj.a(this.a).a;; paramrwf = null)
    {
      QLog.d(paramString, 2, paramrwf);
      if (rzj.a(this.a))
      {
        rzj.a(this.a, this.a.a);
        rzj.a(this.a, false);
      }
      paramrwf = rzh.a(paramInt1, paramInt2, paramInt3);
      paramString = rzj.a(this.a).iterator();
      while (paramString.hasNext()) {
        ((rzn)paramString.next()).onVideoError(paramInt1, paramInt2, paramrwf);
      }
      paramrwf = "";
      break;
    }
    paramString = rzj.b(this.a).iterator();
    while (paramString.hasNext()) {
      ((rzi)paramString.next()).a(paramInt1, paramInt2, paramrwf);
    }
    return false;
  }
  
  public boolean a(rwf paramrwf, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramrwf = rzj.b(this.a).iterator();
      while (paramrwf.hasNext()) {
        ((rzi)paramrwf.next()).a(paramInt, paramObject);
      }
      if (QLog.isColorLevel()) {
        QLog.d(rzj.a(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_START_BUFFERING");
      }
      paramrwf = rzj.a(this.a).iterator();
      while (paramrwf.hasNext()) {
        ((rzn)paramrwf.next()).onBufferStart();
      }
      if (QLog.isColorLevel()) {
        QLog.d(rzj.a(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_ENDOF_BUFFERING");
      }
      paramrwf = rzj.a(this.a).iterator();
      while (paramrwf.hasNext()) {
        ((rzn)paramrwf.next()).onBufferEnd();
      }
      if (QLog.isColorLevel())
      {
        QLog.d(rzj.a(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_DECODER_BLOCK");
        continue;
        if (QLog.isColorLevel())
        {
          QLog.d(rzj.a(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_HW_DECODE_FAILED");
          continue;
          if (QLog.isColorLevel()) {
            QLog.d(rzj.a(this.a), 2, "onInfo: PLAYER_INFO_FIRST_VIDEO_FRAME_REDNERED");
          }
          paramrwf = rzj.a(this.a).iterator();
          while (paramrwf.hasNext()) {
            ((rzn)paramrwf.next()).onFirstFrameRendered();
          }
        }
      }
    }
    return false;
  }
  
  public void b(rwf paramrwf)
  {
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = rzj.a(this.a);
      localStringBuilder = new StringBuilder().append("播放状态回调 onCompletion() vid=");
      if (rzj.a(this.a) == null) {
        break label111;
      }
    }
    label111:
    for (paramrwf = rzj.a(this.a).a;; paramrwf = "param null")
    {
      QLog.d(str, 2, paramrwf);
      this.a.a.a(null);
      paramrwf = rzj.a(this.a).iterator();
      while (paramrwf.hasNext()) {
        ((rzn)paramrwf.next()).onCompletion();
      }
    }
    paramrwf = rzj.b(this.a).iterator();
    while (paramrwf.hasNext()) {
      ((rzi)paramrwf.next()).a();
    }
  }
  
  public void d(rwf paramrwf)
  {
    if (QLog.isColorLevel()) {
      QLog.d(rzj.a(this.a), 2, "onDownloadFinish: mPreload=" + rzj.a(this.a));
    }
    if (rzj.a(this.a))
    {
      paramrwf = rzj.a(this.a).iterator();
      while (paramrwf.hasNext()) {
        ((rzn)paramrwf.next()).onDownloadFinished();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rzk
 * JD-Core Version:    0.7.0.1
 */