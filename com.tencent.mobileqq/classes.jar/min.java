import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class min
  implements Runnable
{
  public min(VideoPlayerWrapper paramVideoPlayerWrapper, TVK_IMediaPlayer paramTVK_IMediaPlayer) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     min
 * JD-Core Version:    0.7.0.1
 */