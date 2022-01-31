import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.PlayStartVideoRunnable;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;

public class qqk
  implements onx
{
  public qqk(VideoFeedsPlayManager.PlayStartVideoRunnable paramPlayStartVideoRunnable, long paramLong, onu paramonu) {}
  
  public void a(ooa paramooa)
  {
    if (paramooa == null) {
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
              QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "UUIDToUrlCallback Callback vid=" + paramooa.jdField_b_of_type_JavaLangString + ", url=" + paramooa.jdField_a_of_type_JavaLangString + ", isH265=" + paramooa.jdField_a_of_type_Boolean + ", isHWCodec=" + paramooa.jdField_b_of_type_Boolean + ", fileBitRate=" + paramooa.c + ", hwBackupUrl=" + paramooa.f);
            }
          } while ((!VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable)) && (!VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0, VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable))));
          if ((VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable) == null) || (!paramooa.jdField_b_of_type_JavaLangString.equals(VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString))) {
            break label746;
          }
          if (!TextUtils.isEmpty(paramooa.jdField_a_of_type_JavaLangString)) {
            break;
          }
        } while (VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0) == null);
        VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0).a(null, 123, 107, 0, "UUIDToUrlCallback vid2url ERROR ", null);
        return;
        localObject = VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0);
        if (localObject != null)
        {
          VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_b_of_type_Boolean = ((VideoPreDownloadMgr)localObject).a(paramooa.jdField_a_of_type_JavaLangString, paramooa.jdField_b_of_type_JavaLangString);
          ((VideoPreDownloadMgr)localObject).a(VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_b_of_type_Boolean);
        }
        if (paramooa.jdField_a_of_type_Int != 1) {
          break;
        }
        VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).a(paramooa.jdField_b_of_type_JavaLangString, paramooa.jdField_a_of_type_JavaLangString, 1, this.jdField_a_of_type_Long, 0L, VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int, paramooa.jdField_b_of_type_Boolean, true, VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Boolean);
        localObject = VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable);
        if (!paramooa.jdField_a_of_type_Boolean) {
          break label720;
        }
        i = 1;
        ((qty)localObject).jdField_a_of_type_Int = i;
      } while (VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qbu == null);
      VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qbu.jdField_i_of_type_Long = this.jdField_a_of_type_Onu.a.longValue();
      VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qbu.jdField_d_of_type_Int = paramooa.jdField_d_of_type_Int;
      VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qbu.jdField_d_of_type_Boolean = paramooa.jdField_a_of_type_Boolean;
      VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qbu.jdField_e_of_type_JavaLangString = paramooa.c;
      VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qbu.jdField_e_of_type_Boolean = paramooa.jdField_b_of_type_Boolean;
      VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qbu.f = false;
      VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qbu.g = "";
      VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qbu.k = paramooa.jdField_d_of_type_JavaLangString;
      VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qbu.l = paramooa.jdField_e_of_type_JavaLangString;
      Object localObject = VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qbu;
      boolean bool;
      if (!TextUtils.isEmpty(paramooa.f))
      {
        bool = true;
        ((qbu)localObject).h = bool;
      }
      for (;;)
      {
        try
        {
          localObject = new URL(paramooa.jdField_a_of_type_JavaLangString).getHost();
          paramooa = ayxg.a().a((String)localObject, 1006);
          qbu localqbu = VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qbu;
          if (paramooa != null) {
            break label730;
          }
          i = 0;
          localqbu.q = i;
          localqbu = VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qbu;
          if (paramooa != null) {
            break label738;
          }
          paramooa = "";
          localqbu.j = paramooa;
          VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Qbu.jdField_i_of_type_JavaLangString = ((String)localObject);
          return;
        }
        catch (Exception paramooa)
        {
          return;
        }
        VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).a(paramooa.jdField_b_of_type_JavaLangString, paramooa.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Long, 0L, VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int, paramooa.jdField_b_of_type_Boolean, true, VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).jdField_a_of_type_Boolean, paramooa.f);
        break;
        i = 0;
        break label363;
        bool = false;
        break label560;
        i = paramooa.size();
        continue;
        paramooa = paramooa.toString();
      }
    } while (!QLog.isColorLevel());
    label560:
    label720:
    label730:
    label738:
    label746:
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "vid2url换回来后，当前视频已经不再播放，vid:" + paramooa.jdField_b_of_type_JavaLangString + " url:" + paramooa.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qqk
 * JD-Core Version:    0.7.0.1
 */