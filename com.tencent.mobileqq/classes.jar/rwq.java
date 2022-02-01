import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;

class rwq
  implements TVK_IMediaPlayer.OnCompletionListener
{
  rwq(rwp paramrwp) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(rwp.a(), 2, "播放器状态回调 onCompletion");
    }
    if (rwp.a(this.a) != null) {
      rwp.a(this.a).a(1, null, rwp.a(this.a), System.currentTimeMillis() - rwp.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rwq
 * JD-Core Version:    0.7.0.1
 */