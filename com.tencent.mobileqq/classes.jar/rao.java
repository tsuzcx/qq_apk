import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;

class rao
  implements TVK_IMediaPlayer.OnCompletionListener
{
  rao(ran paramran) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ran.a(), 2, "播放器状态回调 onCompletion");
    }
    if (ran.a(this.a) != null) {
      ran.a(this.a).a(1, null, ran.a(this.a), System.currentTimeMillis() - ran.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rao
 * JD-Core Version:    0.7.0.1
 */