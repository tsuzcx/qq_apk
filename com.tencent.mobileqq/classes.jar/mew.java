import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVideoManager;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoBehaviorsReporter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper.MediaPlayListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.qphone.base.util.QLog;

public class mew
  implements Runnable
{
  public mew(VideoPlayManager paramVideoPlayManager, VideoPlayManager.VideoPlayParam paramVideoPlayParam, VideoPlayerWrapper paramVideoPlayerWrapper) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "executed On SubThread, busitype:" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.e + " vid:" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_JavaLangString);
    }
    if ((VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager) == null) || (VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager) != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper)) {}
    do
    {
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_JavaLangString)) {
        break;
      }
    } while (VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager) == null);
    VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, 101, 61, 0, "VID ERROR ", null);
    return;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.e == 2) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.e == 6))
    {
      ThirdVideoManager localThirdVideoManager = ThirdVideoManager.a();
      localThirdVideoManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_JavaLangString, "PubAccountArticleCenter.GetUrlByVid", new mex(this, localThirdVideoManager));
    }
    for (;;)
    {
      if (VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager) != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b = VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_JavaLangString);
        VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b);
      }
      PublicAccountUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.i, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_JavaLangString, 0, 0);
      if (VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager) != null) {
        VideoBehaviorsReporter.a().b(VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager).a());
      }
      VideoBehaviorsReporter.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_f_of_type_Int);
      return;
      if ((AdvertisementInfo.isAdvertisementInfo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoVid)) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoVid.startsWith("http://")) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoVid.startsWith("https://")))) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a("", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoVid, 2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.b, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.c, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Int);
      } else {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mew
 * JD-Core Version:    0.7.0.1
 */