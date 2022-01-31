import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.widget.MediaController;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnPreparedListener;

public class ntq
  implements IMediaPlayer.OnPreparedListener
{
  public ntq(TextureVideoView paramTextureVideoView) {}
  
  @TargetApi(15)
  public void a_(IMediaPlayer paramIMediaPlayer)
  {
    this.a.jdField_a_of_type_Int = 2;
    TextureVideoView localTextureVideoView1 = this.a;
    TextureVideoView localTextureVideoView2 = this.a;
    this.a.jdField_d_of_type_Boolean = true;
    localTextureVideoView2.c = true;
    localTextureVideoView1.jdField_b_of_type_Boolean = true;
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnPreparedListener != null) {
      this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnPreparedListener.a_(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer);
    }
    if (this.a.jdField_a_of_type_AndroidWidgetMediaController != null) {
      this.a.jdField_a_of_type_AndroidWidgetMediaController.setEnabled(true);
    }
    this.a.jdField_d_of_type_Int = paramIMediaPlayer.c();
    this.a.e = paramIMediaPlayer.d();
    int i = this.a.g;
    if (i != 0) {
      this.a.seekTo(i);
    }
    if ((this.a.jdField_d_of_type_Int != 0) && (this.a.e != 0))
    {
      if (Build.VERSION.SDK_INT >= 15) {
        this.a.getSurfaceTexture().setDefaultBufferSize(this.a.jdField_d_of_type_Int, this.a.e);
      }
      if (this.a.jdField_b_of_type_Int == 3)
      {
        this.a.start();
        if (this.a.jdField_a_of_type_AndroidWidgetMediaController != null) {
          this.a.jdField_a_of_type_AndroidWidgetMediaController.show();
        }
      }
    }
    while (this.a.jdField_b_of_type_Int != 3)
    {
      do
      {
        return;
      } while ((this.a.isPlaying()) || ((i == 0) && (this.a.getCurrentPosition() <= 0)) || (this.a.jdField_a_of_type_AndroidWidgetMediaController == null));
      this.a.jdField_a_of_type_AndroidWidgetMediaController.show(0);
      return;
    }
    this.a.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ntq
 * JD-Core Version:    0.7.0.1
 */