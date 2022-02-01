import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;

class rwt
  implements TVK_IMediaPlayer.OnInfoListener
{
  rwt(rwp paramrwp) {}
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(rwp.a(), 2, "播放器状态回调 onInfo what = " + paramInt + ", extra = " + paramObject);
    }
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return false;
      } while (rwp.a(this.a) == null);
      localrwv = rwp.a(this.a);
      if ((paramObject instanceof String)) {}
      for (paramTVK_IMediaPlayer = (String)paramObject;; paramTVK_IMediaPlayer = null)
      {
        localrwv.a(2, paramTVK_IMediaPlayer, null, 0L);
        break;
      }
    } while (rwp.a(this.a) == null);
    rwv localrwv = rwp.a(this.a);
    if ((paramObject instanceof String)) {}
    for (paramTVK_IMediaPlayer = (String)paramObject;; paramTVK_IMediaPlayer = null)
    {
      localrwv.a(5, paramTVK_IMediaPlayer, null, 0L);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rwt
 * JD-Core Version:    0.7.0.1
 */