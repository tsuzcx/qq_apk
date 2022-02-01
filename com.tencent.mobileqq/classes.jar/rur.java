import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;

class rur
  implements TVK_IMediaPlayer.OnInfoListener
{
  rur(run paramrun) {}
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(run.a(), 2, "播放器状态回调 onInfo what = " + paramInt + ", extra = " + paramObject);
    }
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return false;
      } while (run.a(this.a) == null);
      localrut = run.a(this.a);
      if ((paramObject instanceof String)) {}
      for (paramTVK_IMediaPlayer = (String)paramObject;; paramTVK_IMediaPlayer = null)
      {
        localrut.a(2, paramTVK_IMediaPlayer, null, 0L);
        break;
      }
    } while (run.a(this.a) == null);
    rut localrut = run.a(this.a);
    if ((paramObject instanceof String)) {}
    for (paramTVK_IMediaPlayer = (String)paramObject;; paramTVK_IMediaPlayer = null)
    {
      localrut.a(5, paramTVK_IMediaPlayer, null, 0L);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rur
 * JD-Core Version:    0.7.0.1
 */