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

public class saq
  implements slp
{
  public saq(VideoFeedsPlayManager.PlayStartVideoRunnable paramPlayStartVideoRunnable, long paramLong, slm paramslm) {}
  
  public void a(slr paramslr)
  {
    sar localsar = (sar)VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).get();
    Object localObject1 = (sfb)VideoFeedsPlayManager.PlayStartVideoRunnable.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).get();
    if (paramslr == null) {
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
                QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "UUIDToUrlCallback Callback code=" + paramslr.jdField_d_of_type_Int + ", vid=" + paramslr.jdField_b_of_type_JavaLangString + ", url=" + paramslr.jdField_a_of_type_JavaLangString + ", isH265=" + paramslr.jdField_a_of_type_Boolean + ", isHWCodec=" + paramslr.jdField_b_of_type_Boolean + ", fileBitRate=" + paramslr.c + ", hwBackupUrl=" + paramslr.jdField_e_of_type_JavaLangString);
              }
            } while (((!VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable)) && (!VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0, (sfb)localObject1))) || (localObject1 == null));
            if ((localsar == null) || (!paramslr.jdField_b_of_type_JavaLangString.equals(localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString))) {
              break label693;
            }
            if (paramslr.jdField_d_of_type_Int != 2) {
              break;
            }
          } while (VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0) == null);
          VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0).a((sfb)localObject1, 202, 108, 0, "vid2url failed, video deleted", null);
          return;
          if (!TextUtils.isEmpty(paramslr.jdField_a_of_type_JavaLangString)) {
            break;
          }
        } while (VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0) == null);
        VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0).a((sfb)localObject1, 202, 107, 0, "vid2url failed, get null", null);
        return;
        localObject2 = VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0);
        if (localObject2 != null)
        {
          ((sfb)localObject1).jdField_b_of_type_Boolean = ((VideoPreDownloadMgr)localObject2).a(paramslr.jdField_a_of_type_JavaLangString, paramslr.jdField_b_of_type_JavaLangString);
          ((VideoPreDownloadMgr)localObject2).a(localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, ((sfb)localObject1).jdField_b_of_type_Boolean);
        }
        if (paramslr.jdField_a_of_type_Int != 1) {
          break;
        }
        ((sfb)localObject1).a(paramslr.jdField_b_of_type_JavaLangString, paramslr.jdField_a_of_type_JavaLangString, 104, this.jdField_a_of_type_Long, 0L, localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int, paramslr.jdField_b_of_type_Boolean, true, localsar.jdField_a_of_type_Boolean);
        if (!paramslr.jdField_a_of_type_Boolean) {
          break label667;
        }
        i = 1;
        ((sfb)localObject1).jdField_b_of_type_Int = i;
      } while (localsar.jdField_a_of_type_Rgc == null);
      localsar.jdField_a_of_type_Rgc.jdField_j_of_type_Long = this.jdField_a_of_type_Slm.a.longValue();
      localsar.jdField_a_of_type_Rgc.jdField_e_of_type_Int = paramslr.jdField_d_of_type_Int;
      localsar.jdField_a_of_type_Rgc.d = paramslr.jdField_a_of_type_Boolean;
      localsar.jdField_a_of_type_Rgc.jdField_e_of_type_JavaLangString = paramslr.c;
      localsar.jdField_a_of_type_Rgc.jdField_e_of_type_Boolean = paramslr.jdField_b_of_type_Boolean;
      localsar.jdField_a_of_type_Rgc.jdField_f_of_type_Boolean = false;
      localsar.jdField_a_of_type_Rgc.jdField_f_of_type_JavaLangString = "";
      localsar.jdField_a_of_type_Rgc.jdField_j_of_type_JavaLangString = paramslr.jdField_d_of_type_JavaLangString;
      localObject1 = localsar.jdField_a_of_type_Rgc;
      boolean bool;
      if (!TextUtils.isEmpty(paramslr.jdField_e_of_type_JavaLangString))
      {
        bool = true;
        ((rgc)localObject1).jdField_h_of_type_Boolean = bool;
      }
      for (;;)
      {
        try
        {
          localObject1 = new URL(paramslr.jdField_a_of_type_JavaLangString).getHost();
          paramslr = InnerDns.getInstance().reqDnsForIpList((String)localObject1, 1006);
          localObject2 = localsar.jdField_a_of_type_Rgc;
          if (paramslr != null) {
            break label677;
          }
          i = 0;
          ((rgc)localObject2).r = i;
          localObject2 = localsar.jdField_a_of_type_Rgc;
          if (paramslr != null) {
            break label685;
          }
          paramslr = "";
          ((rgc)localObject2).i = paramslr;
          localsar.jdField_a_of_type_Rgc.jdField_h_of_type_JavaLangString = ((String)localObject1);
          return;
        }
        catch (Exception paramslr)
        {
          return;
        }
        ((sfb)localObject1).a(paramslr.jdField_b_of_type_JavaLangString, paramslr.jdField_a_of_type_JavaLangString, 101, this.jdField_a_of_type_Long, 0L, localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int, paramslr.jdField_b_of_type_Boolean, true, localsar.jdField_a_of_type_Boolean, paramslr.jdField_e_of_type_JavaLangString);
        break;
        i = 0;
        break label406;
        bool = false;
        break label536;
        i = paramslr.size();
        continue;
        paramslr = paramslr.toString();
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "vid2url换回来后，当前视频已经不再播放，vid:" + paramslr.jdField_b_of_type_JavaLangString + " url:" + paramslr.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     saq
 * JD-Core Version:    0.7.0.1
 */