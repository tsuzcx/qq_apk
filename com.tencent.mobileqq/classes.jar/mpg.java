import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager.VideoPlayParam;
import com.tencent.qphone.base.util.QLog;

public class mpg
  implements Runnable
{
  public mpg(FastWebVideoFeedsPlayManager paramFastWebVideoFeedsPlayManager, boolean paramBoolean, FastWebVideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager.a(1);
      if (FastWebVideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager).a()) {
        break label76;
      }
      FastWebVideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager).a();
    }
    label76:
    VideoPlayerWrapper localVideoPlayerWrapper;
    do
    {
      return;
      FastWebVideoFeedsPlayManager.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager, true);
      if (FastWebVideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager) == null) {
        break;
      }
      FastWebVideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager).sendEmptyMessageDelayed(-1, 1200L);
      break;
      localVideoPlayerWrapper = FastWebVideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager);
      FastWebVideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager, FastWebVideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam));
      if (FastWebVideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager) != null) {
        break label128;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "playVideo() ERROR, mUIHandler==null");
    return;
    label128:
    FastWebVideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager).post(new mph(this, localVideoPlayerWrapper));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mpg
 * JD-Core Version:    0.7.0.1
 */