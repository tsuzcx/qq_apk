import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;

class rnp
  implements TVK_IMediaPlayer.OnInfoListener
{
  rnp(rnl paramrnl) {}
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(rnl.a(), 2, "播放器状态回调 onInfo what = " + paramInt + ", extra = " + paramObject);
    }
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return false;
      } while (rnl.a(this.a) == null);
      localrnr = rnl.a(this.a);
      if ((paramObject instanceof String)) {}
      for (paramTVK_IMediaPlayer = (String)paramObject;; paramTVK_IMediaPlayer = null)
      {
        localrnr.a(2, paramTVK_IMediaPlayer, null, 0L);
        break;
      }
    } while (rnl.a(this.a) == null);
    rnr localrnr = rnl.a(this.a);
    if ((paramObject instanceof String)) {}
    for (paramTVK_IMediaPlayer = (String)paramObject;; paramTVK_IMediaPlayer = null)
    {
      localrnr.a(5, paramTVK_IMediaPlayer, null, 0L);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rnp
 * JD-Core Version:    0.7.0.1
 */