import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnBufferingUpdateListener;

public class npg
  implements IMediaPlayer.OnBufferingUpdateListener
{
  public npg(TextureVideoView paramTextureVideoView) {}
  
  public void a(IMediaPlayer paramIMediaPlayer, int paramInt)
  {
    this.a.f = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     npg
 * JD-Core Version:    0.7.0.1
 */