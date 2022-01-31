import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.OnPlayStateListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class mev
  implements Runnable
{
  public mev(VideoPlayManager paramVideoPlayManager, VideoPlayManager.VideoPlayParam paramVideoPlayParam, VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void run()
  {
    if (VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager) != null)
    {
      Iterator localIterator = VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager).iterator();
      while (localIterator.hasNext())
      {
        VideoPlayManager.OnPlayStateListener localOnPlayStateListener = (VideoPlayManager.OnPlayStateListener)localIterator.next();
        if (localOnPlayStateListener != null) {
          localOnPlayStateListener.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mev
 * JD-Core Version:    0.7.0.1
 */