import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.VideoExtraRepoerData;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoRecommendManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class mes
  implements Runnable
{
  mes(meq parammeq, VideoPlayManager.VideoPlayParam paramVideoPlayParam, JSONObject paramJSONObject, VideoRecommendManager paramVideoRecommendManager) {}
  
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
        break label718;
      }
      localObject = (QQAppInterface)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        label232:
        long l;
        int i;
        boolean bool;
        String str2;
        label641:
        if (QLog.isColorLevel())
        {
          QLog.d("Q.readinjoy.video", 2, "ERROR Exception = " + localException.getMessage());
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
        break label641;
      }
    }
    for (localObject = "1";; localObject = "0")
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("fans", localObject);
      this.jdField_a_of_type_OrgJsonJSONObject.put("play_index", VideoPlayManager.a(this.jdField_a_of_type_Meq.a));
      this.jdField_a_of_type_OrgJsonJSONObject.put("from", VideoReporter.jdField_a_of_type_Int);
      if (!TextUtils.isEmpty(VideoPlayManager.a(this.jdField_a_of_type_Meq.a))) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("video_session_id", VideoPlayManager.a(this.jdField_a_of_type_Meq.a));
      }
      if ((VideoPlayManager.a(this.jdField_a_of_type_Meq.a) == null) || (VideoPlayManager.a(this.jdField_a_of_type_Meq.a).getIntent() == null)) {
        break label713;
      }
      l = VideoPlayManager.a(this.jdField_a_of_type_Meq.a).getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      localObject = new ReportInfo.VideoExtraRepoerData();
      ((ReportInfo.VideoExtraRepoerData)localObject).d = (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Int * 1000);
      ((ReportInfo.VideoExtraRepoerData)localObject).e = (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Int * 1000);
      if (l != 0L) {
        break;
      }
      i = 1;
      ((ReportInfo.VideoExtraRepoerData)localObject).c = i;
      if (VideoPlayManager.a(this.jdField_a_of_type_Meq.a) != null)
      {
        ((ReportInfo.VideoExtraRepoerData)localObject).b = true;
        if (VideoPlayManager.a(this.jdField_a_of_type_Meq.a).a()) {
          break label693;
        }
        bool = true;
        ((ReportInfo.VideoExtraRepoerData)localObject).a = bool;
      }
      VideoReporter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.i, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.e, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.f, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.g, 12, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long, (ReportInfo.VideoExtraRepoerData)localObject);
      localObject = VideoReporter.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.j, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.i, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Int * 1000, this.jdField_a_of_type_OrgJsonJSONObject);
      String str3 = VideoReporter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (String)localObject);
      String str4 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.j;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Long != l) {
        break label699;
      }
      localObject = "1";
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.i)) {
        break label706;
      }
      str2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.i;
      PublicAccountReportUtils.b(null, str4, "0X8007408", "0X8007408", 0, 0, (String)localObject, "", str2, str3, false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long = 0L;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mes
 * JD-Core Version:    0.7.0.1
 */