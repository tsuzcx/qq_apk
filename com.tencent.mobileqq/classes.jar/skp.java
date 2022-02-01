import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.PlayStartVideoRunnable;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class skp
  implements sxa
{
  public skp(VideoFeedsPlayManager.PlayStartVideoRunnable paramPlayStartVideoRunnable, long paramLong, swx paramswx) {}
  
  public void a(sxc paramsxc)
  {
    skq localskq = (skq)VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).get();
    spn localspn = (spn)VideoFeedsPlayManager.PlayStartVideoRunnable.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).get();
    if (paramsxc == null) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "UUIDToUrlCallback videoUrlInfo == null RETURN");
    }
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "UUIDToUrlCallback Callback code=" + paramsxc.d + ", vid=" + paramsxc.jdField_b_of_type_JavaLangString + ", url=" + paramsxc.jdField_a_of_type_JavaLangString + ", isH265=" + paramsxc.jdField_a_of_type_Boolean + ", isHWCodec=" + paramsxc.jdField_b_of_type_Boolean + ", fileBitRate=" + paramsxc.c + ", hwBackupUrl=" + paramsxc.e);
          }
          if (VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable, localskq, localspn)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "sendUUIDToUrlRequest: checkVideoStatus error return");
        return;
        if (!paramsxc.jdField_b_of_type_JavaLangString.equals(localskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString)) {
          break;
        }
      } while (!VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable, paramsxc, localspn));
      VideoPreDownloadMgr localVideoPreDownloadMgr = VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0);
      if (localVideoPreDownloadMgr != null)
      {
        localspn.jdField_b_of_type_Boolean = localVideoPreDownloadMgr.a(paramsxc.jdField_a_of_type_JavaLangString, paramsxc.jdField_b_of_type_JavaLangString);
        localVideoPreDownloadMgr.a(localskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, localspn.jdField_b_of_type_Boolean);
      }
      if (paramsxc.jdField_a_of_type_Int == 1) {
        localspn.a(paramsxc.jdField_b_of_type_JavaLangString, paramsxc.jdField_a_of_type_JavaLangString, 104, this.jdField_a_of_type_Long, 0L, localskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.d, paramsxc.jdField_b_of_type_Boolean, true, localskq.jdField_a_of_type_Boolean);
      }
      for (;;)
      {
        VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable, localskq, localspn, paramsxc, this.jdField_a_of_type_Swx);
        return;
        localspn.a(paramsxc.jdField_b_of_type_JavaLangString, paramsxc.jdField_a_of_type_JavaLangString, 101, this.jdField_a_of_type_Long, 0L, localskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.d, paramsxc.jdField_b_of_type_Boolean, true, localskq.jdField_a_of_type_Boolean, paramsxc.e);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "vid2url换回来后，当前视频已经不再播放，vid:" + paramsxc.jdField_b_of_type_JavaLangString + " url:" + paramsxc.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     skp
 * JD-Core Version:    0.7.0.1
 */