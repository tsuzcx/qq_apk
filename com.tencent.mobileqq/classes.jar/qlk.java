import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;

class qlk
  implements TVK_IMediaPlayer.OnCompletionListener
{
  qlk(qlj paramqlj) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(qlj.a(), 2, "播放器状态回调 onCompletion");
    }
    if (qlj.a(this.a) != null) {
      qlj.a(this.a).a(1, null, qlj.a(this.a), System.currentTimeMillis() - qlj.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qlk
 * JD-Core Version:    0.7.0.1
 */