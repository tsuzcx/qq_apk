import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import java.util.Iterator;
import java.util.List;

public class ryx
  extends qtz
{
  private ryx(VideoPlayManager paramVideoPlayManager) {}
  
  public void a(TVK_NetVideoInfo paramTVK_NetVideoInfo, qty paramqty)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "onTencentVideoDefnInfo(TVK_NetVideoInfo videoInfo, VideoPlayerWrapper videoPLayer) ");
    }
  }
  
  public void a(qty paramqty)
  {
    rza localrza = VideoPlayManager.a(this.a);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("播放状态回调 onCompletion() vid=");
      if (localrza == null) {
        break label93;
      }
    }
    label93:
    for (paramqty = localrza.a.a;; paramqty = "param null")
    {
      QLog.d("Viola.VideoPlayManager", 2, paramqty);
      paramqty = VideoPlayManager.a(this.a).iterator();
      while (paramqty.hasNext()) {
        ((rzb)paramqty.next()).h(localrza);
      }
    }
  }
  
  public void a(qty paramqty, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "onVideoPrepared(VideoPlayerWrapper player, Object tag) ");
    }
    paramqty = VideoPlayManager.a(this.a);
    if ((paramqty != null) && (QLog.isColorLevel())) {
      QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onVideoPrepared() vid=" + paramqty.a.a + ", mIsOpenedVideo = " + VideoPlayManager.a(this.a));
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
      ((rzb)paramObject.next()).c(paramqty);
    }
    if (VideoPlayManager.b(this.a))
    {
      this.a.a();
      return;
    }
    VideoPlayManager.b(this.a, true);
  }
  
  public void a(qty paramqty, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "onConnectQualityCallback json= " + paramString);
    }
  }
  
  public boolean a(qty paramqty, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    paramString = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null)
    {
      paramqty = paramObject.toString();
      paramqty = paramqty;
      paramString = VideoPlayManager.a(this.a);
      if ((paramString != null) && (paramString.a != null) && (QLog.isColorLevel())) {
        QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onError() " + paramqty + ", vid=" + paramString.a.a);
      }
      ajya.a(2131716349);
      if (paramInt1 != 123) {
        break label290;
      }
      if (paramInt2 != 103) {
        break label250;
      }
      paramqty = ajya.a(2131716329) + paramInt1 + "-" + paramInt2 + ")";
    }
    for (;;)
    {
      paramObject = VideoPlayManager.a(this.a).iterator();
      while (paramObject.hasNext()) {
        ((rzb)paramObject.next()).a(paramString, paramInt1, paramInt2, paramqty);
      }
      paramqty = "";
      break;
      label250:
      paramqty = ajya.a(2131716325) + paramInt1 + "-" + paramInt2 + ")";
      continue;
      label290:
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
    return false;
  }
  
  public boolean a(qty paramqty, int paramInt, Object paramObject)
  {
    paramqty = VideoPlayManager.a(this.a);
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
        ((rzb)paramObject.next()).f(paramqty);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_ENDOF_BUFFERING");
      }
      paramObject = VideoPlayManager.a(this.a).iterator();
      while (paramObject.hasNext()) {
        ((rzb)paramObject.next()).g(paramqty);
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
 * Qualified Name:     ryx
 * JD-Core Version:    0.7.0.1
 */