import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;

class pzn
  implements TVK_IMediaPlayer.OnInfoListener
{
  pzn(pzj parampzj) {}
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(pzj.a(), 2, "播放器状态回调 onInfo what = " + paramInt + ", extra = " + paramObject);
    }
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return false;
      } while (pzj.a(this.a) == null);
      localpzp = pzj.a(this.a);
      if ((paramObject instanceof String)) {}
      for (paramTVK_IMediaPlayer = (String)paramObject;; paramTVK_IMediaPlayer = null)
      {
        localpzp.a(2, paramTVK_IMediaPlayer, null, 0L);
        break;
      }
    } while (pzj.a(this.a) == null);
    pzp localpzp = pzj.a(this.a);
    if ((paramObject instanceof String)) {}
    for (paramTVK_IMediaPlayer = (String)paramObject;; paramTVK_IMediaPlayer = null)
    {
      localpzp.a(5, paramTVK_IMediaPlayer, null, 0L);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pzn
 * JD-Core Version:    0.7.0.1
 */