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

public class mdt
  implements Runnable
{
  public mdt(VideoPlayManager paramVideoPlayManager, VideoPlayManager.VideoPlayParam paramVideoPlayParam, JSONObject paramJSONObject, VideoRecommendManager paramVideoRecommendManager) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam == null) {
      return;
    }
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
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.j)) {
        break label232;
      }
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localObject instanceof QQAppInterface)) {
        break label800;
      }
      localObject = (QQAppInterface)localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject;
        label232:
        long l;
        int i;
        boolean bool;
        String str2;
        label739:
        if (QLog.isColorLevel())
        {
          QLog.d("Q.readinjoy.video", 2, "report JSON fail");
          continue;
          i = 2;
          continue;
          bool = false;
          continue;
          String str1 = "2";
          continue;
          str2 = "0";
          continue;
          l = 0L;
          continue;
          str1 = null;
        }
      }
    }
    if (localObject != null) {
      if (!((PublicAccountDataManager)((AppInterface)localObject).getManager(55)).a(Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.j))) {
        break label739;
      }
    }
    for (localObject = "1";; localObject = "0")
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("fans", localObject);
      this.jdField_a_of_type_OrgJsonJSONObject.put("from", VideoReporter.jdField_a_of_type_Int);
      this.jdField_a_of_type_OrgJsonJSONObject.put("play_index", VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager));
      if (!TextUtils.isEmpty(VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager))) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("video_session_id", VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager));
      }
      if ((VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager) == null) || (VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager).getIntent() == null)) {
        break label795;
      }
      l = VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager).getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      localObject = new ReportInfo.VideoExtraRepoerData();
      ((ReportInfo.VideoExtraRepoerData)localObject).d = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.b);
      ((ReportInfo.VideoExtraRepoerData)localObject).e = (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Int * 1000);
      if (l != 0L) {
        break label768;
      }
      i = 1;
      ((ReportInfo.VideoExtraRepoerData)localObject).c = i;
      if (VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager) != null)
      {
        ((ReportInfo.VideoExtraRepoerData)localObject).b = true;
        if (VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager).a()) {
          break label773;
        }
        bool = true;
        ((ReportInfo.VideoExtraRepoerData)localObject).a = bool;
      }
      VideoReporter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.i, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.e, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.f, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.g, 12, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long, (ReportInfo.VideoExtraRepoerData)localObject);
      String str3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.j;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Long != l) {
        break label779;
      }
      localObject = "1";
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.i)) {
        break label787;
      }
      str2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.i;
      PublicAccountReportUtils.b(null, str3, "0X8007408", "0X8007408", 0, 0, (String)localObject, "", str2, VideoReporter.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.j, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.i, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.b, this.jdField_a_of_type_OrgJsonJSONObject), false);
      PublicAccountReportUtils.a("0X8007408", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.j, "", "", "", VideoReporter.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.j, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.i, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.b, this.jdField_a_of_type_OrgJsonJSONObject));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long = 0L;
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localObject == null) || (((BaseArticleInfo)localObject).mChannelID != 56L) || (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject))) {
        break;
      }
      NativeAdUtils.a(null, VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager), NativeAdUtils.f, NativeAdUtils.j, (AdvertisementInfo)localObject, null, 0, NativeAdUtils.a(ReadInJoyBaseAdapter.h, (int)(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.b / 1000L), ReadInJoyBaseAdapter.i, 0, ReadInJoyBaseAdapter.f, ReadInJoyBaseAdapter.g, ((BaseArticleInfo)localObject).mVideoDuration, NativeAdUtils.m));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mdt
 * JD-Core Version:    0.7.0.1
 */