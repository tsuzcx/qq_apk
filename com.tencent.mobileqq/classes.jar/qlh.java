import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;

class qlh
  implements TVK_IMediaPlayer.OnCompletionListener
{
  qlh(qlg paramqlg) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(qlg.a(), 2, "播放器状态回调 onCompletion");
    }
    if (qlg.a(this.a) != null) {
      qlg.a(this.a).a(1, null, qlg.a(this.a), System.currentTimeMillis() - qlg.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qlh
 * JD-Core Version:    0.7.0.1
 */