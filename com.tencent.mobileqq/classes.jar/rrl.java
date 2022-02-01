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

public class rrl
  implements sct
{
  public rrl(VideoFeedsPlayManager.PlayStartVideoRunnable paramPlayStartVideoRunnable, long paramLong, scq paramscq) {}
  
  public void a(scv paramscv)
  {
    rrm localrrm = (rrm)VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).get();
    Object localObject1 = (rwf)VideoFeedsPlayManager.PlayStartVideoRunnable.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable).get();
    if (paramscv == null) {
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
                QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "UUIDToUrlCallback Callback code=" + paramscv.jdField_d_of_type_Int + ", vid=" + paramscv.jdField_b_of_type_JavaLangString + ", url=" + paramscv.jdField_a_of_type_JavaLangString + ", isH265=" + paramscv.jdField_a_of_type_Boolean + ", isHWCodec=" + paramscv.jdField_b_of_type_Boolean + ", fileBitRate=" + paramscv.c + ", hwBackupUrl=" + paramscv.jdField_e_of_type_JavaLangString);
              }
            } while (((!VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable)) && (!VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0, (rwf)localObject1))) || (localObject1 == null));
            if ((localrrm == null) || (!paramscv.jdField_b_of_type_JavaLangString.equals(localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString))) {
              break label693;
            }
            if (paramscv.jdField_d_of_type_Int != 2) {
              break;
            }
          } while (VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0) == null);
          VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0).a((rwf)localObject1, 202, 108, 0, "vid2url failed, video deleted", null);
          return;
          if (!TextUtils.isEmpty(paramscv.jdField_a_of_type_JavaLangString)) {
            break;
          }
        } while (VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0) == null);
        VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0).a((rwf)localObject1, 202, 107, 0, "vid2url failed, get null", null);
        return;
        localObject2 = VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$PlayStartVideoRunnable.this$0);
        if (localObject2 != null)
        {
          ((rwf)localObject1).jdField_b_of_type_Boolean = ((VideoPreDownloadMgr)localObject2).a(paramscv.jdField_a_of_type_JavaLangString, paramscv.jdField_b_of_type_JavaLangString);
          ((VideoPreDownloadMgr)localObject2).a(localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, ((rwf)localObject1).jdField_b_of_type_Boolean);
        }
        if (paramscv.jdField_a_of_type_Int != 1) {
          break;
        }
        ((rwf)localObject1).a(paramscv.jdField_b_of_type_JavaLangString, paramscv.jdField_a_of_type_JavaLangString, 104, this.jdField_a_of_type_Long, 0L, localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int, paramscv.jdField_b_of_type_Boolean, true, localrrm.jdField_a_of_type_Boolean);
        if (!paramscv.jdField_a_of_type_Boolean) {
          break label667;
        }
        i = 1;
        ((rwf)localObject1).jdField_b_of_type_Int = i;
      } while (localrrm.jdField_a_of_type_Qwv == null);
      localrrm.jdField_a_of_type_Qwv.jdField_j_of_type_Long = this.jdField_a_of_type_Scq.a.longValue();
      localrrm.jdField_a_of_type_Qwv.jdField_e_of_type_Int = paramscv.jdField_d_of_type_Int;
      localrrm.jdField_a_of_type_Qwv.d = paramscv.jdField_a_of_type_Boolean;
      localrrm.jdField_a_of_type_Qwv.jdField_e_of_type_JavaLangString = paramscv.c;
      localrrm.jdField_a_of_type_Qwv.jdField_e_of_type_Boolean = paramscv.jdField_b_of_type_Boolean;
      localrrm.jdField_a_of_type_Qwv.jdField_f_of_type_Boolean = false;
      localrrm.jdField_a_of_type_Qwv.jdField_f_of_type_JavaLangString = "";
      localrrm.jdField_a_of_type_Qwv.jdField_j_of_type_JavaLangString = paramscv.jdField_d_of_type_JavaLangString;
      localObject1 = localrrm.jdField_a_of_type_Qwv;
      boolean bool;
      if (!TextUtils.isEmpty(paramscv.jdField_e_of_type_JavaLangString))
      {
        bool = true;
        ((qwv)localObject1).jdField_h_of_type_Boolean = bool;
      }
      for (;;)
      {
        try
        {
          localObject1 = new URL(paramscv.jdField_a_of_type_JavaLangString).getHost();
          paramscv = InnerDns.getInstance().reqDnsForIpList((String)localObject1, 1006);
          localObject2 = localrrm.jdField_a_of_type_Qwv;
          if (paramscv != null) {
            break label677;
          }
          i = 0;
          ((qwv)localObject2).r = i;
          localObject2 = localrrm.jdField_a_of_type_Qwv;
          if (paramscv != null) {
            break label685;
          }
          paramscv = "";
          ((qwv)localObject2).i = paramscv;
          localrrm.jdField_a_of_type_Qwv.jdField_h_of_type_JavaLangString = ((String)localObject1);
          return;
        }
        catch (Exception paramscv)
        {
          return;
        }
        ((rwf)localObject1).a(paramscv.jdField_b_of_type_JavaLangString, paramscv.jdField_a_of_type_JavaLangString, 101, this.jdField_a_of_type_Long, 0L, localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int, paramscv.jdField_b_of_type_Boolean, true, localrrm.jdField_a_of_type_Boolean, paramscv.jdField_e_of_type_JavaLangString);
        break;
        i = 0;
        break label406;
        bool = false;
        break label536;
        i = paramscv.size();
        continue;
        paramscv = paramscv.toString();
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "vid2url换回来后，当前视频已经不再播放，vid:" + paramscv.jdField_b_of_type_JavaLangString + " url:" + paramscv.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rrl
 * JD-Core Version:    0.7.0.1
 */