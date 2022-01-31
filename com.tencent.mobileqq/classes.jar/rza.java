import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import java.util.Iterator;
import java.util.List;

public class rza
  extends quc
{
  private rza(VideoPlayManager paramVideoPlayManager) {}
  
  public void a(TVK_NetVideoInfo paramTVK_NetVideoInfo, qub paramqub)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "onTencentVideoDefnInfo(TVK_NetVideoInfo videoInfo, VideoPlayerWrapper videoPLayer) ");
    }
  }
  
  public void a(qub paramqub)
  {
    rzd localrzd = VideoPlayManager.a(this.a);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("播放状态回调 onCompletion() vid=");
      if (localrzd == null) {
        break label93;
      }
    }
    label93:
    for (paramqub = localrzd.a.a;; paramqub = "param null")
    {
      QLog.d("Viola.VideoPlayManager", 2, paramqub);
      paramqub = VideoPlayManager.a(this.a).iterator();
      while (paramqub.hasNext()) {
        ((rze)paramqub.next()).h(localrzd);
      }
    }
  }
  
  public void a(qub paramqub, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "onVideoPrepared(VideoPlayerWrapper player, Object tag) ");
    }
    paramqub = VideoPlayManager.a(this.a);
    if ((paramqub != null) && (QLog.isColorLevel())) {
      QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onVideoPrepared() vid=" + paramqub.a.a + ", mIsOpenedVideo = " + VideoPlayManager.a(this.a));
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
      ((rze)paramObject.next()).c(paramqub);
    }
    if (VideoPlayManager.b(this.a))
    {
      this.a.a();
      return;
    }
    VideoPlayManager.b(this.a, true);
  }
  
  public void a(qub paramqub, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "onConnectQualityCallback json= " + paramString);
    }
  }
  
  public boolean a(qub paramqub, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    paramString = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null)
    {
      paramqub = paramObject.toString();
      paramqub = paramqub;
      paramString = VideoPlayManager.a(this.a);
      if ((paramString != null) && (paramString.a != null) && (QLog.isColorLevel())) {
        QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onError() " + paramqub + ", vid=" + paramString.a.a);
      }
      ajyc.a(2131716338);
      if (paramInt1 != 123) {
        break label290;
      }
      if (paramInt2 != 103) {
        break label250;
      }
      paramqub = ajyc.a(2131716318) + paramInt1 + "-" + paramInt2 + ")";
    }
    for (;;)
    {
      paramObject = VideoPlayManager.a(this.a).iterator();
      while (paramObject.hasNext()) {
        ((rze)paramObject.next()).a(paramString, paramInt1, paramInt2, paramqub);
      }
      paramqub = "";
      break;
      label250:
      paramqub = ajyc.a(2131716314) + paramInt1 + "-" + paramInt2 + ")";
      continue;
      label290:
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
    return false;
  }
  
  public boolean a(qub paramqub, int paramInt, Object paramObject)
  {
    paramqub = VideoPlayManager.a(this.a);
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
        ((rze)paramObject.next()).f(paramqub);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_ENDOF_BUFFERING");
      }
      paramObject = VideoPlayManager.a(this.a).iterator();
      while (paramObject.hasNext()) {
        ((rze)paramObject.next()).g(paramqub);
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
 * Qualified Name:     rza
 * JD-Core Version:    0.7.0.1
 */