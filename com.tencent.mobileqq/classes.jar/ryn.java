import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.PlayStartVideoRunnable;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;

public class ryn
  implements sjr
{
  public ryn(VideoFeedsPlayManager.PlayStartVideoRunnable paramPlayStartVideoRunnable, long paramLong, sjo paramsjo) {}
  
  public void a(sjt paramsjt)
  {
    ryo localryo = (ryo)VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).get();
    Object localObject1 = (sdj)VideoFeedsPlayManager.PlayStartVideoRunnable.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).get();
    if (paramsjt == null) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "UUIDToUrlCallback videoUrlInfo == null RETURN");
    }
    label406:
    label536:
    label667:
    label677:
    label685:
    label693:
    do
    {
      Object localObject2;
      int i;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (QLog.isColorLevel()) {
                QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "UUIDToUrlCallback Callback code=" + paramsjt.jdField_d_of_type_Int + ", vid=" + paramsjt.jdField_b_of_type_JavaLangString + ", url=" + paramsjt.jdField_a_of_type_JavaLangString + ", isH265=" + paramsjt.jdField_a_of_type_Boolean + ", isHWCodec=" + paramsjt.jdField_b_of_type_Boolean + ", fileBitRate=" + paramsjt.c + ", hwBackupUrl=" + paramsjt.jdField_e_of_type_JavaLangString);
              }
            } while (((!VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable)) && (!VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0, (sdj)localObject1))) || (localObject1 == null));
            if ((localryo == null) || (!paramsjt.jdField_b_of_type_JavaLangString.equals(localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString))) {
              break label693;
            }
            if (paramsjt.jdField_d_of_type_Int != 2) {
              break;
            }
          } while (VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0) == null);
          VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0).a((sdj)localObject1, 202, 108, 0, "vid2url failed, video deleted", null);
          return;
          if (!TextUtils.isEmpty(paramsjt.jdField_a_of_type_JavaLangString)) {
            break;
          }
        } while (VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0) == null);
        VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0).a((sdj)localObject1, 202, 107, 0, "vid2url failed, get null", null);
        return;
        localObject2 = VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0);
        if (localObject2 != null)
        {
          ((sdj)localObject1).jdField_b_of_type_Boolean = ((VideoPreDownloadMgr)localObject2).a(paramsjt.jdField_a_of_type_JavaLangString, paramsjt.jdField_b_of_type_JavaLangString);
          ((VideoPreDownloadMgr)localObject2).a(localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, ((sdj)localObject1).jdField_b_of_type_Boolean);
        }
        if (paramsjt.jdField_a_of_type_Int != 1) {
          break;
        }
        ((sdj)localObject1).a(paramsjt.jdField_b_of_type_JavaLangString, paramsjt.jdField_a_of_type_JavaLangString, 104, this.jdField_a_of_type_Long, 0L, localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int, paramsjt.jdField_b_of_type_Boolean, true, localryo.jdField_a_of_type_Boolean);
        if (!paramsjt.jdField_a_of_type_Boolean) {
          break label667;
        }
        i = 1;
        ((sdj)localObject1).jdField_b_of_type_Int = i;
      } while (localryo.jdField_a_of_type_Rdt == null);
      localryo.jdField_a_of_type_Rdt.jdField_j_of_type_Long = this.jdField_a_of_type_Sjo.a.longValue();
      localryo.jdField_a_of_type_Rdt.jdField_e_of_type_Int = paramsjt.jdField_d_of_type_Int;
      localryo.jdField_a_of_type_Rdt.d = paramsjt.jdField_a_of_type_Boolean;
      localryo.jdField_a_of_type_Rdt.jdField_e_of_type_JavaLangString = paramsjt.c;
      localryo.jdField_a_of_type_Rdt.jdField_e_of_type_Boolean = paramsjt.jdField_b_of_type_Boolean;
      localryo.jdField_a_of_type_Rdt.jdField_f_of_type_Boolean = false;
      localryo.jdField_a_of_type_Rdt.jdField_f_of_type_JavaLangString = "";
      localryo.jdField_a_of_type_Rdt.jdField_j_of_type_JavaLangString = paramsjt.jdField_d_of_type_JavaLangString;
      localObject1 = localryo.jdField_a_of_type_Rdt;
      boolean bool;
      if (!TextUtils.isEmpty(paramsjt.jdField_e_of_type_JavaLangString))
      {
        bool = true;
        ((rdt)localObject1).jdField_h_of_type_Boolean = bool;
      }
      for (;;)
      {
        try
        {
          localObject1 = new URL(paramsjt.jdField_a_of_type_JavaLangString).getHost();
          paramsjt = InnerDns.getInstance().reqDnsForIpList((String)localObject1, 1006);
          localObject2 = localryo.jdField_a_of_type_Rdt;
          if (paramsjt != null) {
            break label677;
          }
          i = 0;
          ((rdt)localObject2).r = i;
          localObject2 = localryo.jdField_a_of_type_Rdt;
          if (paramsjt != null) {
            break label685;
          }
          paramsjt = "";
          ((rdt)localObject2).i = paramsjt;
          localryo.jdField_a_of_type_Rdt.jdField_h_of_type_JavaLangString = ((String)localObject1);
          return;
        }
        catch (Exception paramsjt)
        {
          return;
        }
        ((sdj)localObject1).a(paramsjt.jdField_b_of_type_JavaLangString, paramsjt.jdField_a_of_type_JavaLangString, 101, this.jdField_a_of_type_Long, 0L, localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int, paramsjt.jdField_b_of_type_Boolean, true, localryo.jdField_a_of_type_Boolean, paramsjt.jdField_e_of_type_JavaLangString);
        break;
        i = 0;
        break label406;
        bool = false;
        break label536;
        i = paramsjt.size();
        continue;
        paramsjt = paramsjt.toString();
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "vid2url换回来后，当前视频已经不再播放，vid:" + paramsjt.jdField_b_of_type_JavaLangString + " url:" + paramsjt.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ryn
 * JD-Core Version:    0.7.0.1
 */