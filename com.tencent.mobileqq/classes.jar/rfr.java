import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.PlayStartVideoRunnable;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;

public class rfr
  implements osi
{
  public rfr(VideoFeedsPlayManager.PlayStartVideoRunnable paramPlayStartVideoRunnable, long paramLong, osf paramosf) {}
  
  public void a(osl paramosl)
  {
    if (paramosl == null) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "UUIDToUrlCallback videoUrlInfo == null RETURN");
    }
    label363:
    do
    {
      int i;
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "UUIDToUrlCallback Callback vid=" + paramosl.jdField_b_of_type_JavaLangString + ", url=" + paramosl.jdField_a_of_type_JavaLangString + ", isH265=" + paramosl.jdField_a_of_type_Boolean + ", isHWCodec=" + paramosl.jdField_b_of_type_Boolean + ", fileBitRate=" + paramosl.c + ", hwBackupUrl=" + paramosl.f);
            }
          } while ((!VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable)) && (!VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0, VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable))));
          if ((VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable) == null) || (!paramosl.jdField_b_of_type_JavaLangString.equals(VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString))) {
            break label746;
          }
          if (!TextUtils.isEmpty(paramosl.jdField_a_of_type_JavaLangString)) {
            break;
          }
        } while (VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0) == null);
        VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0).a(null, 123, 107, 0, "UUIDToUrlCallback vid2url ERROR ", null);
        return;
        localObject = VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0);
        if (localObject != null)
        {
          VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_b_of_type_Boolean = ((VideoPreDownloadMgr)localObject).a(paramosl.jdField_a_of_type_JavaLangString, paramosl.jdField_b_of_type_JavaLangString);
          ((VideoPreDownloadMgr)localObject).a(VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_b_of_type_Boolean);
        }
        if (paramosl.jdField_a_of_type_Int != 1) {
          break;
        }
        VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).a(paramosl.jdField_b_of_type_JavaLangString, paramosl.jdField_a_of_type_JavaLangString, 1, this.jdField_a_of_type_Long, 0L, VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int, paramosl.jdField_b_of_type_Boolean, true, VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Boolean);
        localObject = VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable);
        if (!paramosl.jdField_a_of_type_Boolean) {
          break label720;
        }
        i = 1;
        ((rjn)localObject).jdField_b_of_type_Int = i;
      } while (VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qlq == null);
      VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qlq.jdField_i_of_type_Long = this.jdField_a_of_type_Osf.a.longValue();
      VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qlq.jdField_d_of_type_Int = paramosl.jdField_d_of_type_Int;
      VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qlq.jdField_d_of_type_Boolean = paramosl.jdField_a_of_type_Boolean;
      VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qlq.jdField_e_of_type_JavaLangString = paramosl.c;
      VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qlq.jdField_e_of_type_Boolean = paramosl.jdField_b_of_type_Boolean;
      VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qlq.f = false;
      VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qlq.g = "";
      VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qlq.k = paramosl.jdField_d_of_type_JavaLangString;
      VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qlq.l = paramosl.jdField_e_of_type_JavaLangString;
      Object localObject = VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qlq;
      boolean bool;
      if (!TextUtils.isEmpty(paramosl.f))
      {
        bool = true;
        ((qlq)localObject).h = bool;
      }
      for (;;)
      {
        try
        {
          localObject = new URL(paramosl.jdField_a_of_type_JavaLangString).getHost();
          paramosl = bavf.a().a((String)localObject, 1006);
          qlq localqlq = VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qlq;
          if (paramosl != null) {
            break label730;
          }
          i = 0;
          localqlq.q = i;
          localqlq = VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qlq;
          if (paramosl != null) {
            break label738;
          }
          paramosl = "";
          localqlq.j = paramosl;
          VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qlq.jdField_i_of_type_JavaLangString = ((String)localObject);
          return;
        }
        catch (Exception paramosl)
        {
          return;
        }
        VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).a(paramosl.jdField_b_of_type_JavaLangString, paramosl.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Long, 0L, VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int, paramosl.jdField_b_of_type_Boolean, true, VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Boolean, paramosl.f);
        break;
        i = 0;
        break label363;
        bool = false;
        break label560;
        i = paramosl.size();
        continue;
        paramosl = paramosl.toString();
      }
    } while (!QLog.isColorLevel());
    label560:
    label720:
    label730:
    label738:
    label746:
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "vid2url换回来后，当前视频已经不再播放，vid:" + paramosl.jdField_b_of_type_JavaLangString + " url:" + paramosl.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rfr
 * JD-Core Version:    0.7.0.1
 */