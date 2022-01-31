import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import java.util.Iterator;
import java.util.List;

class qyq
  extends quc
{
  private qyq(qyp paramqyp) {}
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(qyp.a(this.a), 2, "onPreloadFinished()");
    }
    qyp.a(this.a).k();
    Iterator localIterator = qyp.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((qyt)localIterator.next()).j();
    }
  }
  
  public void a(TVK_NetVideoInfo paramTVK_NetVideoInfo, qub paramqub)
  {
    if (QLog.isColorLevel()) {
      QLog.d(qyp.a(this.a), 2, "onTencentVideoDefnInfo(TVK_NetVideoInfo videoInfo, VideoPlayerWrapper videoPLayer) ");
    }
  }
  
  public void a(qub paramqub)
  {
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = qyp.a(this.a);
      localStringBuilder = new StringBuilder().append("播放状态回调 onCompletion() vid=");
      if (qyp.a(this.a) == null) {
        break label100;
      }
    }
    label100:
    for (paramqub = qyp.a(this.a).a;; paramqub = "param null")
    {
      QLog.d(str, 2, paramqub);
      paramqub = qyp.a(this.a).iterator();
      while (paramqub.hasNext()) {
        ((qyt)paramqub.next()).i();
      }
    }
    paramqub = qyp.b(this.a).iterator();
    while (paramqub.hasNext()) {
      ((qyo)paramqub.next()).a();
    }
  }
  
  public void a(qub paramqub, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(qyp.a(this.a), 2, "onVideoPrepared(VideoPlayerWrapper player, Object tag) ");
    }
    if ((qyp.a(this.a) != null) && (QLog.isColorLevel())) {
      QLog.d(qyp.a(this.a), 2, "播放状态回调 onVideoPrepared() vid=" + qyp.a(this.a).a + ", mIsOpenedVideo = " + qyp.b(this.a) + ", preload=" + qyp.a(this.a) + ", mActivityOnResume=" + qyp.c(this.a));
    }
    if (qyp.a(this.a)) {
      a();
    }
    do
    {
      return;
      if (qyp.b(this.a)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(qyp.a(this.a), 2, "onVideoPrepared  return isOpenedVideo false");
    return;
    qyp.b(this.a, false);
    qyp.a(this.a).removeMessages(0);
    qyp.a(this.a).sendEmptyMessage(0);
    paramqub = qyp.a(this.a).iterator();
    while (paramqub.hasNext()) {
      ((qyt)paramqub.next()).a();
    }
    paramqub = qyp.b(this.a).iterator();
    while (paramqub.hasNext()) {
      ((qyo)paramqub.next()).c(qyp.a(this.a));
    }
    qyp.b(this.a);
  }
  
  public void a(qub paramqub, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(qyp.a(this.a), 2, "onConnectQualityCallback json= " + paramString);
    }
    paramqub = qyp.b(this.a).iterator();
    while (paramqub.hasNext()) {
      ((qyo)paramqub.next()).a(paramString);
    }
  }
  
  public boolean a(qub paramqub, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    paramString = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null)
    {
      paramqub = paramObject.toString();
      paramqub = paramqub;
      if (QLog.isColorLevel())
      {
        paramString = qyp.a(this.a);
        paramObject = new StringBuilder().append("播放状态回调 onError() ").append(paramqub).append(", vid=");
        if (qyp.a(this.a) == null) {
          break label280;
        }
        paramqub = qyp.a(this.a).a;
        label132:
        QLog.d(paramString, 2, paramqub);
      }
      if (qyp.a(this.a))
      {
        qyp.a(this.a, qyp.a(this.a));
        qyp.a(this.a, false);
      }
      if (paramInt1 != 123) {
        break label325;
      }
      if (paramInt2 != 103) {
        break label285;
      }
      paramqub = ajyc.a(2131716318) + paramInt1 + "-" + paramInt2 + ")";
    }
    for (;;)
    {
      paramString = qyp.a(this.a).iterator();
      while (paramString.hasNext()) {
        ((qyt)paramString.next()).a(paramInt1, paramInt2, paramqub);
      }
      paramqub = "";
      break;
      label280:
      paramqub = null;
      break label132;
      label285:
      paramqub = ajyc.a(2131716314) + paramInt1 + "-" + paramInt2 + ")";
      continue;
      label325:
      if (paramInt1 == 122)
      {
        if (paramInt2 == 204) {
          paramqub = ajyc.a(2131716334) + paramInt1 + "-" + paramInt2 + ")";
        } else if (paramInt2 == 202) {
          paramqub = ajyc.a(2131716331) + paramInt1 + "-" + paramInt2 + ")";
        } else {
          paramqub = ajyc.a(2131716342) + paramInt1 + "-" + paramInt2 + ")";
        }
      }
      else if (paramInt1 == 101)
      {
        if (paramInt2 == 80) {
          paramqub = ajyc.a(2131716324) + paramInt1 + "-" + paramInt2 + ")";
        } else {
          paramqub = ajyc.a(2131716315) + paramInt1 + "-" + paramInt2 + ")";
        }
      }
      else {
        paramqub = ajyc.a(2131716339) + paramInt1 + "-" + paramInt2 + ")";
      }
    }
    paramString = qyp.b(this.a).iterator();
    while (paramString.hasNext()) {
      ((qyo)paramString.next()).a(paramInt1, paramInt2, paramqub);
    }
    return false;
  }
  
  public boolean a(qub paramqub, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramqub = qyp.b(this.a).iterator();
      while (paramqub.hasNext()) {
        ((qyo)paramqub.next()).a(paramInt, paramObject);
      }
      if (QLog.isColorLevel()) {
        QLog.d(qyp.a(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_START_BUFFERING");
      }
      paramqub = qyp.a(this.a).iterator();
      while (paramqub.hasNext()) {
        ((qyt)paramqub.next()).f();
      }
      if (QLog.isColorLevel()) {
        QLog.d(qyp.a(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_ENDOF_BUFFERING");
      }
      paramqub = qyp.a(this.a).iterator();
      while (paramqub.hasNext()) {
        ((qyt)paramqub.next()).h();
      }
      if (QLog.isColorLevel())
      {
        QLog.d(qyp.a(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_DECODER_BLOCK");
        continue;
        if (QLog.isColorLevel()) {
          QLog.d(qyp.a(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_HW_DECODE_FAILED");
        }
      }
    }
    return false;
  }
  
  public void b(qub paramqub)
  {
    if (QLog.isColorLevel()) {
      QLog.d(qyp.a(this.a), 2, "onDownloadFinish: mPreload=" + qyp.a(this.a));
    }
    if (qyp.a(this.a))
    {
      paramqub = qyp.a(this.a).iterator();
      while (paramqub.hasNext()) {
        ((qyt)paramqub.next()).k();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qyq
 * JD-Core Version:    0.7.0.1
 */