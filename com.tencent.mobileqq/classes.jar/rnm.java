import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;

class rnm
  implements TVK_IMediaPlayer.OnCompletionListener
{
  rnm(rnl paramrnl) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(rnl.a(), 2, "播放器状态回调 onCompletion");
    }
    if (rnl.a(this.a) != null) {
      rnl.a(this.a).a(1, null, rnl.a(this.a), System.currentTimeMillis() - rnl.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rnm
 * JD-Core Version:    0.7.0.1
 */