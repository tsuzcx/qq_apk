import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;

class qlk
  implements TVK_IMediaPlayer.OnInfoListener
{
  qlk(qlg paramqlg) {}
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(qlg.a(), 2, "播放器状态回调 onInfo what = " + paramInt + ", extra = " + paramObject);
    }
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return false;
      } while (qlg.a(this.a) == null);
      localqlm = qlg.a(this.a);
      if ((paramObject instanceof String)) {}
      for (paramTVK_IMediaPlayer = (String)paramObject;; paramTVK_IMediaPlayer = null)
      {
        localqlm.a(2, paramTVK_IMediaPlayer, null, 0L);
        break;
      }
    } while (qlg.a(this.a) == null);
    qlm localqlm = qlg.a(this.a);
    if ((paramObject instanceof String)) {}
    for (paramTVK_IMediaPlayer = (String)paramObject;; paramTVK_IMediaPlayer = null)
    {
      localqlm.a(5, paramTVK_IMediaPlayer, null, 0L);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qlk
 * JD-Core Version:    0.7.0.1
 */