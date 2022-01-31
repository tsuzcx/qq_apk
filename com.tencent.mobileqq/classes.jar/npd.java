import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnBufferingUpdateListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnCompletionListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnErrorListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnInfoListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnPreparedListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnSeekCompleteListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnVideoSizeChangedListener;

public class npd
  extends Handler
{
  private npd(MediaPlayer paramMediaPlayer) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 4: 
    case 2: 
    case 5: 
      do
      {
        do
        {
          do
          {
            return;
            Log.d("Story-MediaPlayer", "onPrepared");
          } while (this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnPreparedListener == null);
          this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnPreparedListener.a_(this.a);
          return;
          Log.d("Story-MediaPlayer", "onSeekComplete");
        } while (this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnSeekCompleteListener == null);
        this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnSeekCompleteListener.a(this.a);
        return;
        Log.d("Story-MediaPlayer", "onPlaybackComplete");
        if (this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnCompletionListener != null) {
          this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnCompletionListener.a(this.a);
        }
        this.a.c(false);
        return;
        Log.d("Story-MediaPlayer", "onVideoSizeChanged");
      } while (this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnVideoSizeChangedListener == null);
      this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnVideoSizeChangedListener.a(this.a, paramMessage.arg1, paramMessage.arg2);
      return;
    case 100: 
      Log.e("Story-MediaPlayer", "Error (" + paramMessage.arg1 + "," + paramMessage.arg2 + ")");
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnErrorListener == null) {
        break;
      }
    }
    for (boolean bool = this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnErrorListener.a(this.a, paramMessage.arg1, paramMessage.arg2);; bool = false)
    {
      if ((this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnCompletionListener != null) && (!bool)) {
        this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnCompletionListener.a(this.a);
      }
      this.a.c(false);
      return;
      Log.d("Story-MediaPlayer", "onInfo");
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnInfoListener == null) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnInfoListener.a_(this.a, paramMessage.arg1, paramMessage.arg2);
      return;
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnBufferingUpdateListener != null) {
        this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnBufferingUpdateListener.a(this.a, paramMessage.arg1);
      }
      this.a.e = paramMessage.arg1;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     npd
 * JD-Core Version:    0.7.0.1
 */