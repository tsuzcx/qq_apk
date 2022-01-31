import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.video.VideoBehaviorsReporter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall;
import com.tencent.qphone.base.util.QLog;

public class mcx
  implements Runnable
{
  public mcx(VideoFeedsPlayManager paramVideoFeedsPlayManager, boolean paramBoolean, VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam) {}
  
  public void run()
  {
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b(1);
      localObject = VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      if ((localObject == null) || (((VideoPluginInstall)localObject).a())) {
        break label76;
      }
      ((VideoPluginInstall)localObject).a();
    }
    label76:
    do
    {
      do
      {
        return;
        VideoFeedsPlayManager.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, true);
        if (VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager) == null) {
          break;
        }
        VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager).sendEmptyMessageDelayed(-1, 1200L);
        break;
        localObject = VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam));
        if (VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager) != null) {
          break label128;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "playVideo() ERROR, mUIHandler==null");
      return;
      VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager).post(new mcy(this, (VideoPlayerWrapper)localObject));
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam == null);
    label128:
    VideoBehaviorsReporter.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mcx
 * JD-Core Version:    0.7.0.1
 */