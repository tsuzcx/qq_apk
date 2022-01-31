import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;

public class pce
  implements TVK_IMediaPlayer.OnErrorListener
{
  public pce(VideoView paramVideoView) {}
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    QLog.e("gifvideo.VideoView", 1, "TVK_IMediaPlayer.OnErrorListener model = " + paramInt1 + " what = " + paramInt2 + " position = " + paramInt3 + " extra = " + paramString);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pce
 * JD-Core Version:    0.7.0.1
 */