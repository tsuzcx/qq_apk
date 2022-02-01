import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;

class rwr
  implements TVK_IMediaPlayer.OnErrorListener
{
  rwr(rwp paramrwp) {}
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(rwp.a(), 2, "播放器状态回调 onError model = " + paramInt1 + ", what = " + paramInt2 + ", detailInfo = " + paramString);
    }
    if (rwp.a(this.a) != null) {
      rwp.a(this.a).a(3, paramInt1 + "-" + paramInt2, null, 0L);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rwr
 * JD-Core Version:    0.7.0.1
 */