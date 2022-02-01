import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class sig
  extends rux
{
  sig(sif paramsif) {}
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(sif.a(this.a), 2, "onPreloadFinished()");
    }
    this.a.a.j();
  }
  
  public void a(sfb paramsfb)
  {
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = sif.a(this.a);
      localStringBuilder = new StringBuilder().append("播放状态回调 onCompletion() vid=");
      if (sif.a(this.a) == null) {
        break label111;
      }
    }
    label111:
    for (paramsfb = sif.a(this.a).a;; paramsfb = "param null")
    {
      QLog.d(str, 2, paramsfb);
      this.a.a.a(null);
      paramsfb = sif.a(this.a).iterator();
      while (paramsfb.hasNext()) {
        ((sij)paramsfb.next()).onCompletion();
      }
    }
    paramsfb = sif.b(this.a).iterator();
    while (paramsfb.hasNext()) {
      ((sie)paramsfb.next()).a();
    }
  }
  
  public void a(sfb paramsfb, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(sif.a(this.a), 2, "onVideoPrepared(VideoPlayerWrapper player, Object tag) ");
    }
    if ((sif.a(this.a) != null) && (QLog.isColorLevel())) {
      QLog.d(sif.a(this.a), 2, "播放状态回调 onVideoPrepared() vid=" + sif.a(this.a).a + ", mIsOpenedVideo = " + sif.b(this.a) + ", preload=" + sif.a(this.a) + ", mActivityOnResume=" + sif.c(this.a));
    }
    if (sif.a(this.a)) {
      a();
    }
    do
    {
      return;
      if (sif.b(this.a)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(sif.a(this.a), 2, "onVideoPrepared  return isOpenedVideo false");
    return;
    sif.b(this.a, false);
    sif.a(this.a).removeMessages(0);
    sif.a(this.a).sendEmptyMessage(0);
    paramsfb = sif.a(this.a).iterator();
    while (paramsfb.hasNext()) {
      ((sij)paramsfb.next()).onVideoPrepared();
    }
    paramsfb = sif.b(this.a).iterator();
    while (paramsfb.hasNext()) {
      ((sie)paramsfb.next()).b(this.a.a);
    }
    sif.b(this.a);
  }
  
  public void a(sfb paramsfb, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(sif.a(this.a), 2, "onConnectQualityCallback json= " + paramString);
    }
    if (sif.a(this.a) != null) {
      shd.a().a(paramsfb, sif.a(this.a).b, paramsfb.d());
    }
    paramsfb = sif.b(this.a).iterator();
    while (paramsfb.hasNext()) {
      ((sie)paramsfb.next()).a(paramString);
    }
  }
  
  public boolean a(sfb paramsfb, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    paramString = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null)
    {
      paramsfb = paramObject.toString();
      paramsfb = paramsfb;
      if (QLog.isColorLevel())
      {
        paramString = sif.a(this.a);
        paramObject = new StringBuilder().append("播放状态回调 onError() ").append(paramsfb).append(", vid=");
        if (sif.a(this.a) == null) {
          break label239;
        }
      }
    }
    label239:
    for (paramsfb = sif.a(this.a).a;; paramsfb = null)
    {
      QLog.d(paramString, 2, paramsfb);
      if (sif.a(this.a))
      {
        sif.a(this.a, this.a.a);
        sif.a(this.a, false);
      }
      paramsfb = sid.a(paramInt1, paramInt2, paramInt3);
      paramString = sif.a(this.a).iterator();
      while (paramString.hasNext()) {
        ((sij)paramString.next()).onVideoError(paramInt1, paramInt2, paramsfb);
      }
      paramsfb = "";
      break;
    }
    paramString = sif.b(this.a).iterator();
    while (paramString.hasNext()) {
      ((sie)paramString.next()).a(paramInt1, paramInt2, paramsfb);
    }
    return false;
  }
  
  public boolean a(sfb paramsfb, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramsfb = sif.b(this.a).iterator();
      while (paramsfb.hasNext()) {
        ((sie)paramsfb.next()).a(paramInt, paramObject);
      }
      if (QLog.isColorLevel()) {
        QLog.d(sif.a(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_START_BUFFERING");
      }
      paramsfb = sif.a(this.a).iterator();
      while (paramsfb.hasNext()) {
        ((sij)paramsfb.next()).onBufferStart();
      }
      if (QLog.isColorLevel()) {
        QLog.d(sif.a(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_ENDOF_BUFFERING");
      }
      paramsfb = sif.a(this.a).iterator();
      while (paramsfb.hasNext()) {
        ((sij)paramsfb.next()).onBufferEnd();
      }
      if (QLog.isColorLevel())
      {
        QLog.d(sif.a(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_DECODER_BLOCK");
        continue;
        if (QLog.isColorLevel())
        {
          QLog.d(sif.a(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_HW_DECODE_FAILED");
          continue;
          if (QLog.isColorLevel()) {
            QLog.d(sif.a(this.a), 2, "onInfo: PLAYER_INFO_FIRST_VIDEO_FRAME_REDNERED");
          }
          paramsfb = sif.a(this.a).iterator();
          while (paramsfb.hasNext()) {
            ((sij)paramsfb.next()).onFirstFrameRendered();
          }
        }
      }
    }
    return false;
  }
  
  public void d(sfb paramsfb)
  {
    if (QLog.isColorLevel()) {
      QLog.d(sif.a(this.a), 2, "onDownloadFinish: mPreload=" + sif.a(this.a));
    }
    if (sif.a(this.a))
    {
      paramsfb = sif.a(this.a).iterator();
      while (paramsfb.hasNext()) {
        ((sij)paramsfb.next()).onDownloadFinished();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sig
 * JD-Core Version:    0.7.0.1
 */