import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import java.util.Iterator;
import java.util.List;

public class sqe
  extends rjo
{
  private sqe(VideoPlayManager paramVideoPlayManager) {}
  
  public void a(TVK_NetVideoInfo paramTVK_NetVideoInfo, rjn paramrjn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "onTencentVideoDefnInfo(TVK_NetVideoInfo videoInfo, VideoPlayerWrapper videoPLayer) ");
    }
  }
  
  public void a(rjn paramrjn)
  {
    sqh localsqh = VideoPlayManager.a(this.a);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("播放状态回调 onCompletion() vid=");
      if (localsqh == null) {
        break label93;
      }
    }
    label93:
    for (paramrjn = localsqh.a.a;; paramrjn = "param null")
    {
      QLog.d("Viola.VideoPlayManager", 2, paramrjn);
      paramrjn = VideoPlayManager.a(this.a).iterator();
      while (paramrjn.hasNext()) {
        ((sqi)paramrjn.next()).h(localsqh);
      }
    }
  }
  
  public void a(rjn paramrjn, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "onVideoPrepared(VideoPlayerWrapper player, Object tag) ");
    }
    paramrjn = VideoPlayManager.a(this.a);
    if ((paramrjn != null) && (QLog.isColorLevel())) {
      QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onVideoPrepared() vid=" + paramrjn.a.a + ", mIsOpenedVideo = " + VideoPlayManager.a(this.a));
    }
    if (!VideoPlayManager.a(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "onVideoPrepared  return isOpenedVideo false");
      }
      return;
    }
    VideoPlayManager.a(this.a, false);
    VideoPlayManager.a(this.a).removeMessages(0);
    VideoPlayManager.a(this.a).sendEmptyMessage(0);
    paramObject = VideoPlayManager.a(this.a).iterator();
    while (paramObject.hasNext()) {
      ((sqi)paramObject.next()).c(paramrjn);
    }
    if (VideoPlayManager.b(this.a))
    {
      this.a.a();
      return;
    }
    VideoPlayManager.b(this.a, true);
  }
  
  public void a(rjn paramrjn, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "onConnectQualityCallback json= " + paramString);
    }
    if (VideoPlayManager.a(this.a) != null) {
      rmc.a().a(paramrjn, VideoPlayManager.a(this.a).a.d, paramrjn.d());
    }
  }
  
  public boolean a(rjn paramrjn, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    paramString = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null)
    {
      paramrjn = paramObject.toString();
      paramrjn = paramrjn;
      paramString = VideoPlayManager.a(this.a);
      if ((paramString != null) && (paramString.a != null) && (QLog.isColorLevel())) {
        QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onError() " + paramrjn + ", vid=" + paramString.a.a);
      }
      alpo.a(2131716721);
      if (paramInt1 != 123) {
        break label290;
      }
      if (paramInt2 != 103) {
        break label250;
      }
      paramrjn = alpo.a(2131716701) + paramInt1 + "-" + paramInt2 + ")";
    }
    for (;;)
    {
      paramObject = VideoPlayManager.a(this.a).iterator();
      while (paramObject.hasNext()) {
        ((sqi)paramObject.next()).a(paramString, paramInt1, paramInt2, paramrjn);
      }
      paramrjn = "";
      break;
      label250:
      paramrjn = alpo.a(2131716697) + paramInt1 + "-" + paramInt2 + ")";
      continue;
      label290:
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
    return false;
  }
  
  public boolean a(rjn paramrjn, int paramInt, Object paramObject)
  {
    paramrjn = VideoPlayManager.a(this.a);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_START_BUFFERING");
      }
      paramObject = VideoPlayManager.a(this.a).iterator();
      while (paramObject.hasNext()) {
        ((sqi)paramObject.next()).f(paramrjn);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_ENDOF_BUFFERING");
      }
      paramObject = VideoPlayManager.a(this.a).iterator();
      while (paramObject.hasNext()) {
        ((sqi)paramObject.next()).g(paramrjn);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_DECODER_BLOCK");
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_HW_DECODE_FAILED");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sqe
 * JD-Core Version:    0.7.0.1
 */