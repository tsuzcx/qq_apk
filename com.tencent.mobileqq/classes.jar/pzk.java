import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;

class pzk
  implements TVK_IMediaPlayer.OnCompletionListener
{
  pzk(pzj parampzj) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(pzj.a(), 2, "播放器状态回调 onCompletion");
    }
    if (pzj.a(this.a) != null) {
      pzj.a(this.a).a(1, null, pzj.a(this.a), System.currentTimeMillis() - pzj.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pzk
 * JD-Core Version:    0.7.0.1
 */