import com.tencent.biz.qqstory.playvideo.player.IVideoView.OnInfoListener;
import com.tencent.biz.qqstory.playvideo.player.VideoViewTextureImpl;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnInfoListener;

public class nop
  implements IMediaPlayer.OnInfoListener
{
  public nop(VideoViewTextureImpl paramVideoViewTextureImpl, IVideoView.OnInfoListener paramOnInfoListener) {}
  
  public boolean a_(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 == 3) {
      i = 1;
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView$OnInfoListener.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTextureImpl, i, Integer.valueOf(paramInt2));
      if (paramInt1 == 701)
      {
        i = 2;
      }
      else
      {
        i = paramInt1;
        if (paramInt1 == 702) {
          i = 3;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nop
 * JD-Core Version:    0.7.0.1
 */