import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVideoManager;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVideoManager.UUIDToUrlCallback;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper.MediaPlayListenerAdapter;
import com.tencent.qphone.base.util.QLog;

class mds
  implements ThirdVideoManager.UUIDToUrlCallback
{
  mds(mdr parammdr, ThirdVideoManager paramThirdVideoManager) {}
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "UUIDToUrlCallback Callback vid:" + paramString2 + ", url:" + paramString1 + "，urlType：" + paramInt);
    }
    if ((this.jdField_a_of_type_Mdr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) && (VideoPlayManager.a(this.jdField_a_of_type_Mdr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager) == this.jdField_a_of_type_Mdr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper) && (paramString2.equals(this.jdField_a_of_type_Mdr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_JavaLangString))) {
      if (TextUtils.isEmpty(paramString1)) {
        if (VideoPlayManager.a(this.jdField_a_of_type_Mdr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager) != null) {
          VideoPlayManager.a(this.jdField_a_of_type_Mdr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager).a(this.jdField_a_of_type_Mdr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, 123, 107, 0, "UUIDToUrlCallback vid2url ERROR ", null);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      this.jdField_a_of_type_Mdr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.f = paramString1;
      this.jdField_a_of_type_Mdr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVideoManager.a.longValue();
      this.jdField_a_of_type_Mdr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.d = paramBoolean;
      if (paramInt == 1)
      {
        this.jdField_a_of_type_Mdr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(paramString2, paramString1, 1, this.jdField_a_of_type_Mdr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.b, this.jdField_a_of_type_Mdr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.c, this.jdField_a_of_type_Mdr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Int, paramBoolean);
        return;
      }
      this.jdField_a_of_type_Mdr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(paramString2, paramString1, 2, this.jdField_a_of_type_Mdr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.b, this.jdField_a_of_type_Mdr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.c, this.jdField_a_of_type_Mdr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Int, paramBoolean);
      return;
    }
    QLog.w("Q.readinjoy.video", 2, "vid2url换回来后，当前视频已经不再播放，vid:" + paramString2 + " url:" + paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mds
 * JD-Core Version:    0.7.0.1
 */