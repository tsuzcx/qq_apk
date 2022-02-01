import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;

class ruo
  implements TVK_IMediaPlayer.OnCompletionListener
{
  ruo(run paramrun) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(run.a(), 2, "播放器状态回调 onCompletion");
    }
    if (run.a(this.a) != null) {
      run.a(this.a).a(1, null, run.a(this.a), System.currentTimeMillis() - run.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ruo
 * JD-Core Version:    0.7.0.1
 */