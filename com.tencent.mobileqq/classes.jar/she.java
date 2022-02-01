import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;

class she
  implements TVK_IMediaPlayer.OnErrorListener
{
  she(shc paramshc) {}
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(shc.a(), 2, "播放器状态回调 onError model = " + paramInt1 + ", what = " + paramInt2 + ", detailInfo = " + paramString);
    }
    if (shc.a(this.a) != null) {
      shc.a(this.a).a(3, paramInt1 + "-" + paramInt2, null, 0L);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     she
 * JD-Core Version:    0.7.0.1
 */