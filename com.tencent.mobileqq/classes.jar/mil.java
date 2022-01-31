import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.VideoExtraRepoerData;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoRecommendManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class mil
  implements Runnable
{
  public mil(VideoPlayManager paramVideoPlayManager, VideoPlayManager.VideoPlayParam paramVideoPlayParam, JSONObject paramJSONObject, VideoRecommendManager paramVideoRecommendManager) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam == null) {
      return;
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_OrgJsonJSONObject.put("video_duration", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Int * 1000);
        this.jdField_a_of_type_OrgJsonJSONObject.put("watch_duration", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long);
        this.jdField_a_of_type_OrgJsonJSONObject.put("channel_id", (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.e);
        this.jdField_a_of_type_OrgJsonJSONObject.put("algorithm_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.f);
        this.jdField_a_of_type_OrgJsonJSONObject.put("strategy_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.g);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager != null)
        {
          this.jdField_a_of_type_OrgJsonJSONObject.put("video_inserted", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Long));
          this.jdField_a_of_type_OrgJsonJSONObject.put("video_strategyid", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager.a());
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.j))
        {
          ??? = BaseApplicationImpl.getApplication().getRuntime();
          if (!(??? instanceof QQAppInterface)) {
            break label821;
          }
          ??? = (QQAppInterface)???;
          if (??? != null)
          {
            if (!((PublicAccountDataManager)((AppInterface)???).getManager(55)).a(Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.j))) {
              continue;
            }
            ??? = "1";
            this.jdField_a_of_type_OrgJsonJSONObject.put("fans", ???);
          }
        }
        this.jdField_a_of_type_OrgJsonJSONObject.put("from", VideoReporter.jdField_a_of_type_Int);
        this.jdField_a_of_type_OrgJsonJSONObject.put("play_index", VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager));
        if (!TextUtils.isEmpty(VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager))) {
          this.jdField_a_of_type_OrgJsonJSONObject.put("video_session_id", VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager));
        }
      }
      catch (JSONException localJSONException)
      {
        synchronized (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager)
        {
          if ((VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager) == null) || (VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager).getIntent() == null)) {
            break label816;
          }
          l = VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager).getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
          ??? = new ReportInfo.VideoExtraRepoerData();
          ((ReportInfo.VideoExtraRepoerData)???).d = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.b);
          ((ReportInfo.VideoExtraRepoerData)???).e = (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Int * 1000);
          if (l == 0L)
          {
            i = 1;
            ((ReportInfo.VideoExtraRepoerData)???).c = i;
            if (VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager) != null)
            {
              ((ReportInfo.VideoExtraRepoerData)???).b = true;
              if (VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager).a()) {
                break label794;
              }
              bool = true;
              ((ReportInfo.VideoExtraRepoerData)???).a = bool;
            }
            VideoReporter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.i, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.e, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.f, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.g, 12, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long, (ReportInfo.VideoExtraRepoerData)???);
            ??? = VideoReporter.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.j, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.i, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.b, this.jdField_a_of_type_OrgJsonJSONObject);
            ??? = VideoReporter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (String)???);
            String str4 = VideoReporter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo, (String)???);
            String str5 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.j;
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Long != l) {
              break label800;
            }
            ??? = "1";
            if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.i)) {
              break label808;
            }
            String str2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.i;
            PublicAccountReportUtils.b(null, str5, "0X8007408", "0X8007408", 0, 0, (String)???, "", str2, str4, false);
            PublicAccountReportUtils.a("0X8007408", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.j, "", "", "", str4);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long = 0L;
            ??? = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
            if ((??? == null) || (((BaseArticleInfo)???).mChannelID != 56L) || (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)???))) {
              break;
            }
            NativeAdUtils.a(null, VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager), NativeAdUtils.f, NativeAdUtils.l, (AdvertisementInfo)???, null, 0L, NativeAdUtils.a(ReadInJoyBaseAdapter.h, (int)(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.b / 1000L), ReadInJoyBaseAdapter.i, 0, ReadInJoyBaseAdapter.f, ReadInJoyBaseAdapter.g, ((BaseArticleInfo)???).mVideoDuration, NativeAdUtils.t));
            return;
            ??? = "0";
            continue;
            localJSONException = localJSONException;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("Q.readinjoy.video", 2, "report JSON fail");
          }
        }
      }
      int i = 2;
      continue;
      label794:
      boolean bool = false;
      continue;
      label800:
      String str1 = "2";
      continue;
      label808:
      String str3 = "0";
      continue;
      label816:
      long l = 0L;
      continue;
      label821:
      str1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mil
 * JD-Core Version:    0.7.0.1
 */