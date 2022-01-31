import com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnErrorListener;
import com.tencent.qphone.base.util.QLog;

public class npj
  implements IMediaPlayer.OnErrorListener
{
  public npj(TrimTextureVideoView paramTrimTextureVideoView) {}
  
  public boolean a(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e(this.a.a, 2, "TrimTextureVideoView MediaPlayer onError==>what:" + paramInt1 + "|extra:" + paramInt2);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     npj
 * JD-Core Version:    0.7.0.1
 */