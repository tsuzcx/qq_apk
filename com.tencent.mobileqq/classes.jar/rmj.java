import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import java.util.Iterator;
import java.util.List;

public class rmj
  extends qhx
{
  private rmj(VideoPlayManager paramVideoPlayManager) {}
  
  public void a(TVK_NetVideoInfo paramTVK_NetVideoInfo, qhw paramqhw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "onTencentVideoDefnInfo(TVK_NetVideoInfo videoInfo, VideoPlayerWrapper videoPLayer) ");
    }
  }
  
  public void a(qhw paramqhw)
  {
    rmm localrmm = VideoPlayManager.a(this.a);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("播放状态回调 onCompletion() vid=");
      if (localrmm == null) {
        break label93;
      }
    }
    label93:
    for (paramqhw = localrmm.a.a;; paramqhw = "param null")
    {
      QLog.d("Viola.VideoPlayManager", 2, paramqhw);
      paramqhw = VideoPlayManager.a(this.a).iterator();
      while (paramqhw.hasNext()) {
        ((rmn)paramqhw.next()).h(localrmm);
      }
    }
  }
  
  public void a(qhw paramqhw, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "onVideoPrepared(VideoPlayerWrapper player, Object tag) ");
    }
    paramqhw = VideoPlayManager.a(this.a);
    if ((paramqhw != null) && (QLog.isColorLevel())) {
      QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onVideoPrepared() vid=" + paramqhw.a.a + ", mIsOpenedVideo = " + VideoPlayManager.a(this.a));
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
      ((rmn)paramObject.next()).c(paramqhw);
    }
    if (VideoPlayManager.b(this.a))
    {
      this.a.a();
      return;
    }
    VideoPlayManager.b(this.a, true);
  }
  
  public void a(qhw paramqhw, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "onConnectQualityCallback json= " + paramString);
    }
  }
  
  public boolean a(qhw paramqhw, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    paramString = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null)
    {
      paramqhw = paramObject.toString();
      paramqhw = paramqhw;
      paramString = VideoPlayManager.a(this.a);
      if ((paramString != null) && (paramString.a != null) && (QLog.isColorLevel())) {
        QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onError() " + paramqhw + ", vid=" + paramString.a.a);
      }
      ajjy.a(2131650547);
      if (paramInt1 != 123) {
        break label290;
      }
      if (paramInt2 != 103) {
        break label250;
      }
      paramqhw = ajjy.a(2131650527) + paramInt1 + "-" + paramInt2 + ")";
    }
    for (;;)
    {
      paramObject = VideoPlayManager.a(this.a).iterator();
      while (paramObject.hasNext()) {
        ((rmn)paramObject.next()).a(paramString, paramInt1, paramInt2, paramqhw);
      }
      paramqhw = "";
      break;
      label250:
      paramqhw = ajjy.a(2131650523) + paramInt1 + "-" + paramInt2 + ")";
      continue;
      label290:
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
    return false;
  }
  
  public boolean a(qhw paramqhw, int paramInt, Object paramObject)
  {
    paramqhw = VideoPlayManager.a(this.a);
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
        ((rmn)paramObject.next()).f(paramqhw);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_ENDOF_BUFFERING");
      }
      paramObject = VideoPlayManager.a(this.a).iterator();
      while (paramObject.hasNext()) {
        ((rmn)paramObject.next()).g(paramqhw);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rmj
 * JD-Core Version:    0.7.0.1
 */