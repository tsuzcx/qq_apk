import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import org.json.JSONObject;

class mej
  implements Runnable
{
  mej(mei parammei, VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, Activity paramActivity, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam == null) || (this.jdField_a_of_type_AndroidAppActivity == null)) {
      return;
    }
    String str6 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.j;
    String str7 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;
    String str1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g;
    String str2;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
    {
      str2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
      if (this.jdField_a_of_type_AndroidAppActivity.getIntent() == null) {
        break label711;
      }
    }
    label660:
    label711:
    for (int i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);; i = 0)
    {
      JSONObject localJSONObject = new JSONObject();
      for (;;)
      {
        try
        {
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_Int != 0)
          {
            localJSONObject.put("algorithm_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.d);
            localJSONObject.put("strategy_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.k);
          }
          if (VideoFeedsAdapter.a(this.jdField_a_of_type_Mei.a) != null) {
            localJSONObject.put("dynamic_recommend_strategyid", VideoFeedsAdapter.a(this.jdField_a_of_type_Mei.a).a());
          }
          localJSONObject.put("session_id", VideoFeedsAdapter.a(this.jdField_a_of_type_Mei.a));
          localJSONObject.put("video_session_id", VideoFeedsAdapter.b(this.jdField_a_of_type_Mei.a));
          localJSONObject.put("from", i);
          localJSONObject.put("channel_id", "409409");
          localJSONObject.put("video_index", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_Int);
          if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b) {
            continue;
          }
          j = 1;
          localJSONObject.put("is_ugc_as_pgc", j);
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.q == null) {
            continue;
          }
          str3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.q;
          localJSONObject.put("video_report_info", str3);
          if ((i == 4) || (i == 5) || (i == 2) || (i == 1)) {
            VideoFeedsAdapter.b(this.jdField_a_of_type_Mei.a, 5);
          }
          localJSONObject.put("kandian_mode_new", VideoFeedsAdapter.b(this.jdField_a_of_type_Mei.a));
          localJSONObject.put("kandian_mode", VideoFeedsAdapter.c(this.jdField_a_of_type_Mei.a));
        }
        catch (Exception localException)
        {
          int j;
          String str3;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.readinjoy.video", 2, "ERROR Exception=" + localException.getMessage());
          continue;
          str4 = "0";
          continue;
          String str5 = "0";
          continue;
          str4 = "0";
          continue;
        }
        if (!VideoFeedsAdapter.a(this.jdField_a_of_type_Mei.a).c()) {
          continue;
        }
        str3 = "1";
        if (this.jdField_a_of_type_Boolean)
        {
          if (TextUtils.isEmpty(str1)) {
            continue;
          }
          str5 = str1;
          PublicAccountReportUtils.b(null, str6, "0X8007412", "0X8007412", 0, 0, String.valueOf(i), str3, str5, VideoReporter.a(str2, str6, str7, str1, localJSONObject), false);
        }
        if (!VideoFeedsAdapter.b(this.jdField_a_of_type_Mei.a).contains(str7))
        {
          VideoFeedsAdapter.b(this.jdField_a_of_type_Mei.a).add(str7);
          if (!VideoFeedsAdapter.e(this.jdField_a_of_type_Mei.a)) {
            break label660;
          }
          if (TextUtils.isEmpty(str1)) {
            continue;
          }
          str3 = str1;
          PublicAccountReportUtils.b(null, str6, "0X8009298", "0X8009298", 0, 0, "0", "", str3, VideoReporter.a(str2, str6, str7, str1, localJSONObject), false);
        }
        VideoFeedsAdapter.a(this.jdField_a_of_type_Mei.a, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
        return;
        str2 = null;
        break;
        j = 0;
        continue;
        str3 = "";
      }
      if (!TextUtils.isEmpty(str1)) {}
      for (String str4 = str1;; str4 = "0")
      {
        PublicAccountReportUtils.b(null, str6, "0X8007801", "0X8007801", 0, 0, "0", "", str4, VideoReporter.a(str2, str6, str7, str1, localJSONObject), false);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mej
 * JD-Core Version:    0.7.0.1
 */