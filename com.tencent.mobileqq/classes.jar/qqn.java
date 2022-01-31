import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.PlayStartVideoRunnable;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;

public class qqn
  implements ooa
{
  public qqn(VideoFeedsPlayManager.PlayStartVideoRunnable paramPlayStartVideoRunnable, long paramLong, onx paramonx) {}
  
  public void a(ood paramood)
  {
    if (paramood == null) {
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
              QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "UUIDToUrlCallback Callback vid=" + paramood.jdField_b_of_type_JavaLangString + ", url=" + paramood.jdField_a_of_type_JavaLangString + ", isH265=" + paramood.jdField_a_of_type_Boolean + ", isHWCodec=" + paramood.jdField_b_of_type_Boolean + ", fileBitRate=" + paramood.c + ", hwBackupUrl=" + paramood.f);
            }
          } while ((!VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable)) && (!VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0, VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable))));
          if ((VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable) == null) || (!paramood.jdField_b_of_type_JavaLangString.equals(VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString))) {
            break label746;
          }
          if (!TextUtils.isEmpty(paramood.jdField_a_of_type_JavaLangString)) {
            break;
          }
        } while (VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0) == null);
        VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0).a(null, 123, 107, 0, "UUIDToUrlCallback vid2url ERROR ", null);
        return;
        localObject = VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0);
        if (localObject != null)
        {
          VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_b_of_type_Boolean = ((VideoPreDownloadMgr)localObject).a(paramood.jdField_a_of_type_JavaLangString, paramood.jdField_b_of_type_JavaLangString);
          ((VideoPreDownloadMgr)localObject).a(VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_b_of_type_Boolean);
        }
        if (paramood.jdField_a_of_type_Int != 1) {
          break;
        }
        VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).a(paramood.jdField_b_of_type_JavaLangString, paramood.jdField_a_of_type_JavaLangString, 1, this.jdField_a_of_type_Long, 0L, VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int, paramood.jdField_b_of_type_Boolean, true, VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Boolean);
        localObject = VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable);
        if (!paramood.jdField_a_of_type_Boolean) {
          break label720;
        }
        i = 1;
        ((qub)localObject).jdField_a_of_type_Int = i;
      } while (VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qbx == null);
      VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qbx.jdField_i_of_type_Long = this.jdField_a_of_type_Onx.a.longValue();
      VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qbx.jdField_d_of_type_Int = paramood.jdField_d_of_type_Int;
      VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qbx.jdField_d_of_type_Boolean = paramood.jdField_a_of_type_Boolean;
      VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qbx.jdField_e_of_type_JavaLangString = paramood.c;
      VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qbx.jdField_e_of_type_Boolean = paramood.jdField_b_of_type_Boolean;
      VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qbx.f = false;
      VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qbx.g = "";
      VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qbx.k = paramood.jdField_d_of_type_JavaLangString;
      VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qbx.l = paramood.jdField_e_of_type_JavaLangString;
      Object localObject = VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qbx;
      boolean bool;
      if (!TextUtils.isEmpty(paramood.f))
      {
        bool = true;
        ((qbx)localObject).h = bool;
      }
      for (;;)
      {
        try
        {
          localObject = new URL(paramood.jdField_a_of_type_JavaLangString).getHost();
          paramood = ayxe.a().a((String)localObject, 1006);
          qbx localqbx = VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qbx;
          if (paramood != null) {
            break label730;
          }
          i = 0;
          localqbx.q = i;
          localqbx = VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qbx;
          if (paramood != null) {
            break label738;
          }
          paramood = "";
          localqbx.j = paramood;
          VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qbx.jdField_i_of_type_JavaLangString = ((String)localObject);
          return;
        }
        catch (Exception paramood)
        {
          return;
        }
        VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).a(paramood.jdField_b_of_type_JavaLangString, paramood.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Long, 0L, VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int, paramood.jdField_b_of_type_Boolean, true, VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Boolean, paramood.f);
        break;
        i = 0;
        break label363;
        bool = false;
        break label560;
        i = paramood.size();
        continue;
        paramood = paramood.toString();
      }
    } while (!QLog.isColorLevel());
    label560:
    label720:
    label730:
    label738:
    label746:
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "vid2url换回来后，当前视频已经不再播放，vid:" + paramood.jdField_b_of_type_JavaLangString + " url:" + paramood.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qqn
 * JD-Core Version:    0.7.0.1
 */