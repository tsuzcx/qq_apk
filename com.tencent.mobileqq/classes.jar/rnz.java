import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import java.util.Iterator;
import java.util.List;

class rnz
  extends rjo
{
  private rnz(rny paramrny) {}
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(rny.a(this.a), 2, "onPreloadFinished()");
    }
    rny.a(this.a).k();
    Iterator localIterator = rny.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((roc)localIterator.next()).l();
    }
  }
  
  public void a(TVK_NetVideoInfo paramTVK_NetVideoInfo, rjn paramrjn)
  {
    if (QLog.isColorLevel()) {
      QLog.d(rny.a(this.a), 2, "onTencentVideoDefnInfo(TVK_NetVideoInfo videoInfo, VideoPlayerWrapper videoPLayer) ");
    }
  }
  
  public void a(rjn paramrjn)
  {
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = rny.a(this.a);
      localStringBuilder = new StringBuilder().append("播放状态回调 onCompletion() vid=");
      if (rny.a(this.a) == null) {
        break label111;
      }
    }
    label111:
    for (paramrjn = rny.a(this.a).a;; paramrjn = "param null")
    {
      QLog.d(str, 2, paramrjn);
      rny.a(this.a).a(null);
      paramrjn = rny.a(this.a).iterator();
      while (paramrjn.hasNext()) {
        ((roc)paramrjn.next()).k();
      }
    }
    paramrjn = rny.b(this.a).iterator();
    while (paramrjn.hasNext()) {
      ((rnx)paramrjn.next()).a();
    }
  }
  
  public void a(rjn paramrjn, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(rny.a(this.a), 2, "onVideoPrepared(VideoPlayerWrapper player, Object tag) ");
    }
    if ((rny.a(this.a) != null) && (QLog.isColorLevel())) {
      QLog.d(rny.a(this.a), 2, "播放状态回调 onVideoPrepared() vid=" + rny.a(this.a).a + ", mIsOpenedVideo = " + rny.b(this.a) + ", preload=" + rny.a(this.a) + ", mActivityOnResume=" + rny.c(this.a));
    }
    if (rny.a(this.a)) {
      a();
    }
    do
    {
      return;
      if (rny.b(this.a)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(rny.a(this.a), 2, "onVideoPrepared  return isOpenedVideo false");
    return;
    rny.b(this.a, false);
    rny.a(this.a).removeMessages(0);
    rny.a(this.a).sendEmptyMessage(0);
    paramrjn = rny.a(this.a).iterator();
    while (paramrjn.hasNext()) {
      ((roc)paramrjn.next()).d();
    }
    paramrjn = rny.b(this.a).iterator();
    while (paramrjn.hasNext()) {
      ((rnx)paramrjn.next()).c(rny.a(this.a));
    }
    rny.b(this.a);
  }
  
  public void a(rjn paramrjn, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(rny.a(this.a), 2, "onConnectQualityCallback json= " + paramString);
    }
    if (rny.a(this.a) != null) {
      rmc.a().a(paramrjn, rny.a(this.a).b, paramrjn.d());
    }
    paramrjn = rny.b(this.a).iterator();
    while (paramrjn.hasNext()) {
      ((rnx)paramrjn.next()).a(paramString);
    }
  }
  
  public boolean a(rjn paramrjn, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    paramString = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null)
    {
      paramrjn = paramObject.toString();
      paramrjn = paramrjn;
      if (QLog.isColorLevel())
      {
        paramString = rny.a(this.a);
        paramObject = new StringBuilder().append("播放状态回调 onError() ").append(paramrjn).append(", vid=");
        if (rny.a(this.a) == null) {
          break label280;
        }
        paramrjn = rny.a(this.a).a;
        label132:
        QLog.d(paramString, 2, paramrjn);
      }
      if (rny.a(this.a))
      {
        rny.a(this.a, rny.a(this.a));
        rny.a(this.a, false);
      }
      if (paramInt1 != 123) {
        break label325;
      }
      if (paramInt2 != 103) {
        break label285;
      }
      paramrjn = alpo.a(2131716701) + paramInt1 + "-" + paramInt2 + ")";
    }
    for (;;)
    {
      paramString = rny.a(this.a).iterator();
      while (paramString.hasNext()) {
        ((roc)paramString.next()).a(paramInt1, paramInt2, paramrjn);
      }
      paramrjn = "";
      break;
      label280:
      paramrjn = null;
      break label132;
      label285:
      paramrjn = alpo.a(2131716697) + paramInt1 + "-" + paramInt2 + ")";
      continue;
      label325:
      if (paramInt1 == 122)
      {
        if (paramInt2 == 204) {
          paramrjn = alpo.a(2131716717) + paramInt1 + "-" + paramInt2 + ")";
        } else if (paramInt2 == 202) {
          paramrjn = alpo.a(2131716714) + paramInt1 + "-" + paramInt2 + ")";
        } else {
          paramrjn = alpo.a(2131716725) + paramInt1 + "-" + paramInt2 + ")";
        }
      }
      else if (paramInt1 == 101)
      {
        if (paramInt2 == 80) {
          paramrjn = alpo.a(2131716707) + paramInt1 + "-" + paramInt2 + ")";
        } else {
          paramrjn = alpo.a(2131716698) + paramInt1 + "-" + paramInt2 + ")";
        }
      }
      else {
        paramrjn = alpo.a(2131716722) + paramInt1 + "-" + paramInt2 + ")";
      }
    }
    paramString = rny.b(this.a).iterator();
    while (paramString.hasNext()) {
      ((rnx)paramString.next()).a(paramInt1, paramInt2, paramrjn);
    }
    return false;
  }
  
  public boolean a(rjn paramrjn, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramrjn = rny.b(this.a).iterator();
      while (paramrjn.hasNext()) {
        ((rnx)paramrjn.next()).a(paramInt, paramObject);
      }
      if (QLog.isColorLevel()) {
        QLog.d(rny.a(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_START_BUFFERING");
      }
      paramrjn = rny.a(this.a).iterator();
      while (paramrjn.hasNext()) {
        ((roc)paramrjn.next()).i();
      }
      if (QLog.isColorLevel()) {
        QLog.d(rny.a(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_ENDOF_BUFFERING");
      }
      paramrjn = rny.a(this.a).iterator();
      while (paramrjn.hasNext()) {
        ((roc)paramrjn.next()).j();
      }
      if (QLog.isColorLevel())
      {
        QLog.d(rny.a(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_DECODER_BLOCK");
        continue;
        if (QLog.isColorLevel()) {
          QLog.d(rny.a(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_HW_DECODE_FAILED");
        }
      }
    }
    return false;
  }
  
  public void b(rjn paramrjn)
  {
    if (QLog.isColorLevel()) {
      QLog.d(rny.a(this.a), 2, "onDownloadFinish: mPreload=" + rny.a(this.a));
    }
    if (rny.a(this.a))
    {
      paramrjn = rny.a(this.a).iterator();
      while (paramrjn.hasNext()) {
        ((roc)paramrjn.next()).m();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rnz
 * JD-Core Version:    0.7.0.1
 */