import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper.MediaPlayListenerAdapter;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.Properties;

public class mdu
  implements Runnable
{
  public mdu(VideoPlayerWrapper paramVideoPlayerWrapper, TVK_IMediaPlayer paramTVK_IMediaPlayer) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getStreamDumpInfo();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ReadInJoyUtils.a((String)localObject);
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a = Long.valueOf(((Properties)localObject).getProperty("VideoBitRate")).longValue();
        if (VideoPlayerWrapper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper) != null) {
          VideoPlayerWrapper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mdu
 * JD-Core Version:    0.7.0.1
 */