import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;

class shd
  implements TVK_IMediaPlayer.OnCompletionListener
{
  shd(shc paramshc) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(shc.a(), 2, "播放器状态回调 onCompletion");
    }
    if (shc.a(this.a) != null) {
      shc.a(this.a).a(1, null, shc.a(this.a), System.currentTimeMillis() - shc.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     shd
 * JD-Core Version:    0.7.0.1
 */