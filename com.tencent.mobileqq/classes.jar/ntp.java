import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnVideoSizeChangedListener;

public class ntp
  implements IMediaPlayer.OnVideoSizeChangedListener
{
  public ntp(TextureVideoView paramTextureVideoView) {}
  
  @TargetApi(15)
  public void a(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    this.a.d = paramIMediaPlayer.c();
    this.a.e = paramIMediaPlayer.d();
    if ((this.a.d != 0) && (this.a.e != 0))
    {
      if (Build.VERSION.SDK_INT >= 15) {
        this.a.getSurfaceTexture().setDefaultBufferSize(this.a.d, this.a.e);
      }
      this.a.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ntp
 * JD-Core Version:    0.7.0.1
 */