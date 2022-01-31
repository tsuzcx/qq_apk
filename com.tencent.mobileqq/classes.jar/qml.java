import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import java.util.Iterator;
import java.util.List;

class qml
  extends qhx
{
  private qml(qmk paramqmk) {}
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(qmk.a(this.a), 2, "onPreloadFinished()");
    }
    qmk.a(this.a).k();
    Iterator localIterator = qmk.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((qmo)localIterator.next()).j();
    }
  }
  
  public void a(TVK_NetVideoInfo paramTVK_NetVideoInfo, qhw paramqhw)
  {
    if (QLog.isColorLevel()) {
      QLog.d(qmk.a(this.a), 2, "onTencentVideoDefnInfo(TVK_NetVideoInfo videoInfo, VideoPlayerWrapper videoPLayer) ");
    }
  }
  
  public void a(qhw paramqhw)
  {
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = qmk.a(this.a);
      localStringBuilder = new StringBuilder().append("播放状态回调 onCompletion() vid=");
      if (qmk.a(this.a) == null) {
        break label100;
      }
    }
    label100:
    for (paramqhw = qmk.a(this.a).a;; paramqhw = "param null")
    {
      QLog.d(str, 2, paramqhw);
      paramqhw = qmk.a(this.a).iterator();
      while (paramqhw.hasNext()) {
        ((qmo)paramqhw.next()).i();
      }
    }
    paramqhw = qmk.b(this.a).iterator();
    while (paramqhw.hasNext()) {
      ((qmj)paramqhw.next()).a();
    }
  }
  
  public void a(qhw paramqhw, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(qmk.a(this.a), 2, "onVideoPrepared(VideoPlayerWrapper player, Object tag) ");
    }
    if ((qmk.a(this.a) != null) && (QLog.isColorLevel())) {
      QLog.d(qmk.a(this.a), 2, "播放状态回调 onVideoPrepared() vid=" + qmk.a(this.a).a + ", mIsOpenedVideo = " + qmk.b(this.a) + ", preload=" + qmk.a(this.a) + ", mActivityOnResume=" + qmk.c(this.a));
    }
    if (qmk.a(this.a)) {
      a();
    }
    do
    {
      return;
      if (qmk.b(this.a)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(qmk.a(this.a), 2, "onVideoPrepared  return isOpenedVideo false");
    return;
    qmk.b(this.a, false);
    qmk.a(this.a).removeMessages(0);
    qmk.a(this.a).sendEmptyMessage(0);
    paramqhw = qmk.a(this.a).iterator();
    while (paramqhw.hasNext()) {
      ((qmo)paramqhw.next()).a();
    }
    paramqhw = qmk.b(this.a).iterator();
    while (paramqhw.hasNext()) {
      ((qmj)paramqhw.next()).c(qmk.a(this.a));
    }
    qmk.b(this.a);
  }
  
  public void a(qhw paramqhw, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(qmk.a(this.a), 2, "onConnectQualityCallback json= " + paramString);
    }
    paramqhw = qmk.b(this.a).iterator();
    while (paramqhw.hasNext()) {
      ((qmj)paramqhw.next()).a(paramString);
    }
  }
  
  public boolean a(qhw paramqhw, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    paramString = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null)
    {
      paramqhw = paramObject.toString();
      paramqhw = paramqhw;
      if (QLog.isColorLevel())
      {
        paramString = qmk.a(this.a);
        paramObject = new StringBuilder().append("播放状态回调 onError() ").append(paramqhw).append(", vid=");
        if (qmk.a(this.a) == null) {
          break label280;
        }
        paramqhw = qmk.a(this.a).a;
        label132:
        QLog.d(paramString, 2, paramqhw);
      }
      if (qmk.a(this.a))
      {
        qmk.a(this.a, qmk.a(this.a));
        qmk.a(this.a, false);
      }
      if (paramInt1 != 123) {
        break label325;
      }
      if (paramInt2 != 103) {
        break label285;
      }
      paramqhw = ajjy.a(2131650527) + paramInt1 + "-" + paramInt2 + ")";
    }
    for (;;)
    {
      paramString = qmk.a(this.a).iterator();
      while (paramString.hasNext()) {
        ((qmo)paramString.next()).a(paramInt1, paramInt2, paramqhw);
      }
      paramqhw = "";
      break;
      label280:
      paramqhw = null;
      break label132;
      label285:
      paramqhw = ajjy.a(2131650523) + paramInt1 + "-" + paramInt2 + ")";
      continue;
      label325:
      if (paramInt1 == 122)
      {
        if (paramInt2 == 204) {
          paramqhw = ajjy.a(2131650543) + paramInt1 + "-" + paramInt2 + ")";
        } else if (paramInt2 == 202) {
          paramqhw = ajjy.a(2131650540) + paramInt1 + "-" + paramInt2 + ")";
        } else {
          paramqhw = ajjy.a(2131650551) + paramInt1 + "-" + paramInt2 + ")";
        }
      }
      else if (paramInt1 == 101)
      {
        if (paramInt2 == 80) {
          paramqhw = ajjy.a(2131650533) + paramInt1 + "-" + paramInt2 + ")";
        } else {
          paramqhw = ajjy.a(2131650524) + paramInt1 + "-" + paramInt2 + ")";
        }
      }
      else {
        paramqhw = ajjy.a(2131650548) + paramInt1 + "-" + paramInt2 + ")";
      }
    }
    paramString = qmk.b(this.a).iterator();
    while (paramString.hasNext()) {
      ((qmj)paramString.next()).a(paramInt1, paramInt2, paramqhw);
    }
    return false;
  }
  
  public boolean a(qhw paramqhw, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramqhw = qmk.b(this.a).iterator();
      while (paramqhw.hasNext()) {
        ((qmj)paramqhw.next()).a(paramInt, paramObject);
      }
      if (QLog.isColorLevel()) {
        QLog.d(qmk.a(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_START_BUFFERING");
      }
      paramqhw = qmk.a(this.a).iterator();
      while (paramqhw.hasNext()) {
        ((qmo)paramqhw.next()).f();
      }
      if (QLog.isColorLevel()) {
        QLog.d(qmk.a(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_ENDOF_BUFFERING");
      }
      paramqhw = qmk.a(this.a).iterator();
      while (paramqhw.hasNext()) {
        ((qmo)paramqhw.next()).h();
      }
      if (QLog.isColorLevel())
      {
        QLog.d(qmk.a(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_DECODER_BLOCK");
        continue;
        if (QLog.isColorLevel()) {
          QLog.d(qmk.a(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_HW_DECODE_FAILED");
        }
      }
    }
    return false;
  }
  
  public void b(qhw paramqhw)
  {
    if (QLog.isColorLevel()) {
      QLog.d(qmk.a(this.a), 2, "onDownloadFinish: mPreload=" + qmk.a(this.a));
    }
    if (qmk.a(this.a))
    {
      paramqhw = qmk.a(this.a).iterator();
      while (paramqhw.hasNext()) {
        ((qmo)paramqhw.next()).k();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qml
 * JD-Core Version:    0.7.0.1
 */