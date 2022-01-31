import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import java.util.Iterator;
import java.util.List;

class qyn
  extends qtz
{
  private qyn(qym paramqym) {}
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(qym.a(this.a), 2, "onPreloadFinished()");
    }
    qym.a(this.a).k();
    Iterator localIterator = qym.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((qyq)localIterator.next()).j();
    }
  }
  
  public void a(TVK_NetVideoInfo paramTVK_NetVideoInfo, qty paramqty)
  {
    if (QLog.isColorLevel()) {
      QLog.d(qym.a(this.a), 2, "onTencentVideoDefnInfo(TVK_NetVideoInfo videoInfo, VideoPlayerWrapper videoPLayer) ");
    }
  }
  
  public void a(qty paramqty)
  {
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = qym.a(this.a);
      localStringBuilder = new StringBuilder().append("播放状态回调 onCompletion() vid=");
      if (qym.a(this.a) == null) {
        break label100;
      }
    }
    label100:
    for (paramqty = qym.a(this.a).a;; paramqty = "param null")
    {
      QLog.d(str, 2, paramqty);
      paramqty = qym.a(this.a).iterator();
      while (paramqty.hasNext()) {
        ((qyq)paramqty.next()).i();
      }
    }
    paramqty = qym.b(this.a).iterator();
    while (paramqty.hasNext()) {
      ((qyl)paramqty.next()).a();
    }
  }
  
  public void a(qty paramqty, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(qym.a(this.a), 2, "onVideoPrepared(VideoPlayerWrapper player, Object tag) ");
    }
    if ((qym.a(this.a) != null) && (QLog.isColorLevel())) {
      QLog.d(qym.a(this.a), 2, "播放状态回调 onVideoPrepared() vid=" + qym.a(this.a).a + ", mIsOpenedVideo = " + qym.b(this.a) + ", preload=" + qym.a(this.a) + ", mActivityOnResume=" + qym.c(this.a));
    }
    if (qym.a(this.a)) {
      a();
    }
    do
    {
      return;
      if (qym.b(this.a)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(qym.a(this.a), 2, "onVideoPrepared  return isOpenedVideo false");
    return;
    qym.b(this.a, false);
    qym.a(this.a).removeMessages(0);
    qym.a(this.a).sendEmptyMessage(0);
    paramqty = qym.a(this.a).iterator();
    while (paramqty.hasNext()) {
      ((qyq)paramqty.next()).a();
    }
    paramqty = qym.b(this.a).iterator();
    while (paramqty.hasNext()) {
      ((qyl)paramqty.next()).c(qym.a(this.a));
    }
    qym.b(this.a);
  }
  
  public void a(qty paramqty, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(qym.a(this.a), 2, "onConnectQualityCallback json= " + paramString);
    }
    paramqty = qym.b(this.a).iterator();
    while (paramqty.hasNext()) {
      ((qyl)paramqty.next()).a(paramString);
    }
  }
  
  public boolean a(qty paramqty, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    paramString = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null)
    {
      paramqty = paramObject.toString();
      paramqty = paramqty;
      if (QLog.isColorLevel())
      {
        paramString = qym.a(this.a);
        paramObject = new StringBuilder().append("播放状态回调 onError() ").append(paramqty).append(", vid=");
        if (qym.a(this.a) == null) {
          break label280;
        }
        paramqty = qym.a(this.a).a;
        label132:
        QLog.d(paramString, 2, paramqty);
      }
      if (qym.a(this.a))
      {
        qym.a(this.a, qym.a(this.a));
        qym.a(this.a, false);
      }
      if (paramInt1 != 123) {
        break label325;
      }
      if (paramInt2 != 103) {
        break label285;
      }
      paramqty = ajya.a(2131716329) + paramInt1 + "-" + paramInt2 + ")";
    }
    for (;;)
    {
      paramString = qym.a(this.a).iterator();
      while (paramString.hasNext()) {
        ((qyq)paramString.next()).a(paramInt1, paramInt2, paramqty);
      }
      paramqty = "";
      break;
      label280:
      paramqty = null;
      break label132;
      label285:
      paramqty = ajya.a(2131716325) + paramInt1 + "-" + paramInt2 + ")";
      continue;
      label325:
      if (paramInt1 == 122)
      {
        if (paramInt2 == 204) {
          paramqty = ajya.a(2131716345) + paramInt1 + "-" + paramInt2 + ")";
        } else if (paramInt2 == 202) {
          paramqty = ajya.a(2131716342) + paramInt1 + "-" + paramInt2 + ")";
        } else {
          paramqty = ajya.a(2131716353) + paramInt1 + "-" + paramInt2 + ")";
        }
      }
      else if (paramInt1 == 101)
      {
        if (paramInt2 == 80) {
          paramqty = ajya.a(2131716335) + paramInt1 + "-" + paramInt2 + ")";
        } else {
          paramqty = ajya.a(2131716326) + paramInt1 + "-" + paramInt2 + ")";
        }
      }
      else {
        paramqty = ajya.a(2131716350) + paramInt1 + "-" + paramInt2 + ")";
      }
    }
    paramString = qym.b(this.a).iterator();
    while (paramString.hasNext()) {
      ((qyl)paramString.next()).a(paramInt1, paramInt2, paramqty);
    }
    return false;
  }
  
  public boolean a(qty paramqty, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramqty = qym.b(this.a).iterator();
      while (paramqty.hasNext()) {
        ((qyl)paramqty.next()).a(paramInt, paramObject);
      }
      if (QLog.isColorLevel()) {
        QLog.d(qym.a(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_START_BUFFERING");
      }
      paramqty = qym.a(this.a).iterator();
      while (paramqty.hasNext()) {
        ((qyq)paramqty.next()).f();
      }
      if (QLog.isColorLevel()) {
        QLog.d(qym.a(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_ENDOF_BUFFERING");
      }
      paramqty = qym.a(this.a).iterator();
      while (paramqty.hasNext()) {
        ((qyq)paramqty.next()).h();
      }
      if (QLog.isColorLevel())
      {
        QLog.d(qym.a(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_DECODER_BLOCK");
        continue;
        if (QLog.isColorLevel()) {
          QLog.d(qym.a(this.a), 2, "播放状态回调 onInfo() PLAYER_INFO_HW_DECODE_FAILED");
        }
      }
    }
    return false;
  }
  
  public void b(qty paramqty)
  {
    if (QLog.isColorLevel()) {
      QLog.d(qym.a(this.a), 2, "onDownloadFinish: mPreload=" + qym.a(this.a));
    }
    if (qym.a(this.a))
    {
      paramqty = qym.a(this.a).iterator();
      while (paramqty.hasNext()) {
        ((qyq)paramqty.next()).k();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qyn
 * JD-Core Version:    0.7.0.1
 */