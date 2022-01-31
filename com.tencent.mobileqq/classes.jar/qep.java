import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.PlayStartVideoRunnable;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;

public class qep
  implements ocp
{
  public qep(VideoFeedsPlayManager.PlayStartVideoRunnable paramPlayStartVideoRunnable, long paramLong, ocm paramocm) {}
  
  public void a(ocs paramocs)
  {
    if (paramocs == null) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "UUIDToUrlCallback videoUrlInfo == null RETURN");
    }
    label345:
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "UUIDToUrlCallback Callback vid=" + paramocs.jdField_b_of_type_JavaLangString + ", url=" + paramocs.jdField_a_of_type_JavaLangString + ", isH265=" + paramocs.jdField_a_of_type_Boolean + ", isHWCodec=" + paramocs.jdField_b_of_type_Boolean + ", fileBitRate=" + paramocs.c + ", hwBackupUrl=" + paramocs.f);
          }
        } while ((!VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable)) && (!VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0, VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable))));
        if ((VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable) == null) || (!paramocs.jdField_b_of_type_JavaLangString.equals(VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString))) {
          break label717;
        }
        if (!TextUtils.isEmpty(paramocs.jdField_a_of_type_JavaLangString)) {
          break;
        }
      } while (VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0) == null);
      VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0).a(null, 123, 107, 0, "UUIDToUrlCallback vid2url ERROR ", null);
      return;
      Object localObject = VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0);
      if (localObject != null)
      {
        VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_b_of_type_Boolean = ((VideoPreDownloadMgr)localObject).a(paramocs.jdField_a_of_type_JavaLangString, paramocs.jdField_b_of_type_JavaLangString);
        ((VideoPreDownloadMgr)localObject).a(VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_b_of_type_Boolean);
      }
      boolean bool;
      if (paramocs.jdField_a_of_type_Int == 1)
      {
        VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).a(paramocs.jdField_b_of_type_JavaLangString, paramocs.jdField_a_of_type_JavaLangString, 1, this.jdField_a_of_type_Long, 0L, VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int, paramocs.jdField_b_of_type_Boolean, true, VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Boolean);
        if (VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Pqb == null) {
          break label694;
        }
        VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Pqb.jdField_i_of_type_Long = this.jdField_a_of_type_Ocm.a.longValue();
        VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Pqb.jdField_d_of_type_Int = paramocs.jdField_d_of_type_Int;
        VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Pqb.jdField_d_of_type_Boolean = paramocs.jdField_a_of_type_Boolean;
        VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Pqb.jdField_e_of_type_JavaLangString = paramocs.c;
        VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Pqb.jdField_e_of_type_Boolean = paramocs.jdField_b_of_type_Boolean;
        VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Pqb.f = false;
        VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Pqb.g = "";
        VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Pqb.k = paramocs.jdField_d_of_type_JavaLangString;
        VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Pqb.l = paramocs.jdField_e_of_type_JavaLangString;
        localObject = VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Pqb;
        if (TextUtils.isEmpty(paramocs.f)) {
          break label696;
        }
        bool = true;
        ((pqb)localObject).h = bool;
      }
      for (;;)
      {
        try
        {
          localObject = new URL(paramocs.jdField_a_of_type_JavaLangString).getHost();
          paramocs = axwx.a().a((String)localObject, 1006);
          pqb localpqb = VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Pqb;
          if (paramocs != null) {
            break label701;
          }
          i = 0;
          localpqb.q = i;
          localpqb = VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Pqb;
          if (paramocs != null) {
            break label709;
          }
          paramocs = "";
          localpqb.j = paramocs;
          VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Pqb.jdField_i_of_type_JavaLangString = ((String)localObject);
          return;
        }
        catch (Exception paramocs)
        {
          return;
        }
        VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).a(paramocs.jdField_b_of_type_JavaLangString, paramocs.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Long, 0L, VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int, paramocs.jdField_b_of_type_Boolean, true, VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Boolean, paramocs.f);
        break label345;
        break;
        bool = false;
        break label536;
        int i = paramocs.size();
        continue;
        paramocs = paramocs.toString();
      }
    } while (!QLog.isColorLevel());
    label536:
    label694:
    label696:
    label701:
    label709:
    label717:
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "vid2url换回来后，当前视频已经不再播放，vid:" + paramocs.jdField_b_of_type_JavaLangString + " url:" + paramocs.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qep
 * JD-Core Version:    0.7.0.1
 */