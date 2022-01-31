import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.PublicAccountArticleHandler;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.InterruptedWeishiAd;
import com.tencent.biz.pubaccount.VideoInfo.TopBarInfo;
import com.tencent.biz.pubaccount.VideoPlayCountHandler;
import com.tencent.biz.pubaccount.VideoPlayRecommendObserver;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsCustomRelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsInterruptedAdManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsListView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class mgk
  extends VideoPlayRecommendObserver
{
  public mgk(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "VideoPlayRecommendObserver() 推荐视频拉取回调 isSuccess = " + paramBoolean);
    }
    VideoFeedsPlayActivity.a(this.a, false);
    VideoFeedsPlayActivity.b(this.a, paramBundle.getBoolean("VALUE_USER_IN_BLACK", false));
    Object localObject1 = this.a;
    if ((VideoFeedsPlayActivity.a(this.a)) || (VideoFeedsPlayActivity.b(this.a)))
    {
      bool = true;
      VideoFeedsPlayActivity.c((VideoFeedsPlayActivity)localObject1, bool);
      if (paramBoolean) {
        break label216;
      }
      paramBundle = VideoFeedsPlayActivity.a(this.a);
      if (!VideoFeedsPlayActivity.b(this.a)) {
        break label211;
      }
    }
    label211:
    for (int i = 3;; i = 2)
    {
      paramBundle.a(i);
      if (VideoFeedsPlayActivity.c(this.a)) {
        VideoFeedsPlayActivity.a(this.a).b(false);
      }
      VideoFeedsPlayActivity.a(this.a).a();
      if ((!VideoFeedsPlayActivity.a(this.a)) && (!VideoFeedsPlayActivity.b(this.a)))
      {
        VideoFeedsPlayActivity.a(this.a).setScrollable(true);
        VideoFeedsPlayActivity.a(this.a).setScrollable(true);
      }
      VideoFeedsPlayActivity.a(this.a).notifyDataSetChanged();
      return;
      bool = false;
      break;
    }
    label216:
    i = VideoFeedsPlayActivity.a(this.a).size();
    ArrayList localArrayList1 = paramBundle.getParcelableArrayList("VIDEO_RECOMMEND_LIST");
    String str = paramBundle.getString("VALUE_REQUEST_VIDEO_ARTICLE_ID");
    ArrayList localArrayList2 = paramBundle.getStringArrayList("VALUE_RECOMMAND_BARRAGE");
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "VideoPlayRecommendObserver() reqArticleID = " + str + ", mLastRequestArticleID = " + VideoFeedsPlayActivity.a(this.a));
    }
    localObject1 = paramBundle.getString("VALUE_REQUEST_VIDEO_INFO");
    if (VideoFeedsPlayActivity.c(this.a))
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).jdField_c_of_type_JavaLangString = ((String)localObject1);
      }
      VideoFeedsPlayActivity.a(this.a).b(false);
      VideoFeedsPlayActivity.a(this.a).a();
    }
    localObject1 = paramBundle.getParcelableArrayList("VIDEO_DISLIKEINFO_LIST");
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      if (((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).jdField_b_of_type_JavaUtilArrayList == null) {
        ((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      }
      ((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).jdField_b_of_type_JavaUtilArrayList.addAll((Collection)localObject1);
    }
    long l = paramBundle.getLong("VALUE_REQUEST_VIDEO_XG_FILE_SIZE", 0L);
    if ((((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).jdField_b_of_type_Long == 0L) && (l != 0L))
    {
      ((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).jdField_b_of_type_Long = l;
      VideoFeedsPlayActivity.a(this.a).b();
    }
    paramBoolean = paramBundle.getBoolean("VALUE_IS_LIKE", false);
    if (((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).jdField_h_of_type_Boolean != paramBoolean)
    {
      ((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).jdField_h_of_type_Boolean = paramBoolean;
      VideoFeedsPlayActivity.a(this.a).a(((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).jdField_g_of_type_JavaLangString, Boolean.valueOf(false));
    }
    int j = paramBundle.getInt("VALUE_COMMENT_COUNT", 0);
    if ((((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).e == 0) && (j != 0))
    {
      ((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).e = j;
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "VideoPlayRecommendObserver(), 首个视频的 commentCount :" + j);
      }
    }
    j = paramBundle.getInt("VALUE_DIANZAN_COUNT", 0);
    if ((((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).jdField_o_of_type_Int == 0) && (j != 0))
    {
      ((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).jdField_o_of_type_Int = j;
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "VideoPlayRecommendObserver(), 首个视频的 dianZanCount :" + j);
      }
    }
    localObject1 = paramBundle.getString("VALUE_VIDEO_REPORT_INFO");
    if (TextUtils.isEmpty(((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).q))
    {
      ((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).q = ((String)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "VideoPlayRecommendObserver(), 首个视频的 videoReportInfo :" + (String)localObject1);
      }
    }
    j = paramBundle.getInt("VALUE_BIU_COUNT", 0);
    if ((((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).jdField_f_of_type_Int == 0) && (j != 0))
    {
      ((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).jdField_f_of_type_Int = j;
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "onGetRecommend: " + j);
      }
    }
    paramBoolean = paramBundle.getBoolean("VALUE_IS_UGC", false);
    boolean bool = paramBundle.getBoolean("VALUE_IS_UGC_FOLLOW", false);
    if ((paramBoolean) && (((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).jdField_g_of_type_Boolean != bool))
    {
      ((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).jdField_g_of_type_Boolean = bool;
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "VideoPlayRecommendObserver(), 首个视频的 isUGCFollow :" + bool);
      }
      VideoFeedsPlayActivity.a(this.a).c(((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).jdField_j_of_type_JavaLangString);
    }
    VideoFeedsPlayActivity.a(this.a, paramBundle.getString("VALUE_COOKIE", null));
    localObject1 = paramBundle.getString("VALUE_SUBS_TEXT");
    Object localObject2 = paramBundle.getString("VALUE_SUBS_COLOR");
    if (TextUtils.isEmpty(((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).jdField_o_of_type_JavaLangString)) {
      ((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).jdField_o_of_type_JavaLangString = ((String)localObject1);
    }
    if (TextUtils.isEmpty(((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).p)) {
      ((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).p = ((String)localObject2);
    }
    VideoFeedsPlayActivity.a(this.a).d();
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "VideoPlayRecommendObserver(), 首个视频的 subscribeText :" + (String)localObject1 + " subscribeColor:" + (String)localObject2);
    }
    paramBoolean = paramBundle.getBoolean("VALUE_IS_VERIFIED", false);
    ((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).jdField_a_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "VideoPlayRecommendObserver(), 首个视频的大V状态 isVerified :" + paramBoolean);
    }
    localObject1 = paramBundle.getParcelableArrayList("VALUE_TIPIC_INFO_LIST");
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0) && (((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).jdField_a_of_type_JavaUtilArrayList == null))
    {
      ((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      ((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject1);
      VideoFeedsPlayActivity.a(this.a).e();
    }
    ((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).i = paramBundle.getInt("VALUE_ADS_GUIDE_TIME", 0);
    ((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).jdField_f_of_type_Boolean = paramBundle.getBoolean("VALUE_IS_WEISHI", false);
    ((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).jdField_j_of_type_Int = paramBundle.getInt("VALUE_ADS_JUMP_TYPE", 0);
    ((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).jdField_a_of_type_ComTencentBizPubaccountVideoInfo$TopBarInfo = ((VideoInfo.TopBarInfo)paramBundle.getParcelable("VALUE_TOPBAR_INFO"));
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "VideoPlayRecommendObserver(), 首个视频的微视APP引流字段 appJumpTipsDisplayTimePosition = " + ((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).i + ", isWeishi = " + ((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).jdField_f_of_type_Boolean + ", adsJumpType = " + ((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).jdField_j_of_type_Int);
    }
    ((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd = ((VideoInfo.InterruptedWeishiAd)paramBundle.getParcelable("VALUE_INTERRUPTED_WEISHI_AD"));
    if (VideoFeedsPlayActivity.a(this.a) != null) {
      VideoFeedsPlayActivity.a(this.a).a(((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd);
    }
    if (i == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "VideoPlayRecommendObserver() 首次请求回包，更新第一个视频的信息 VideoInfo=" + ((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).b());
      }
      if ((((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).jdField_f_of_type_Boolean) && (VideoFeedsPlayActivity.a(this.a).getVisibility() != 0))
      {
        VideoFeedsPlayActivity.a(this.a).setVisibility(0);
        VideoFeedsPlayActivity.a(this.a).setVisibility(8);
        j = this.a.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        localObject2 = new JSONObject();
      }
    }
    else
    {
      try
      {
        if (((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).q == null) {
          break label1965;
        }
        localObject1 = ((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).q;
        label1821:
        ((JSONObject)localObject2).put("video_report_info", localObject1);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          label1874:
          localJSONException.printStackTrace();
          continue;
          PublicAccountReportUtils.b(null, "", "0X800924D", "0X800924D", 0, 0, String.valueOf(j), "", "", VideoReporter.a((JSONObject)localObject2), false);
        }
      }
      if (VideoFeedsPlayActivity.d(this.a))
      {
        PublicAccountReportUtils.b(null, "", "0X800930D", "0X800930D", 0, 0, String.valueOf(j), "", "", VideoReporter.a((JSONObject)localObject2), false);
        localObject1 = new ArrayList();
        if (localArrayList1 != null) {
          break label2042;
        }
        if (!QLog.isColorLevel()) {
          break label2751;
        }
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "VideoPlayRecommendObserver() 正常拉取逻辑 articleList为空");
        paramBoolean = false;
      }
    }
    for (;;)
    {
      VideoFeedsPlayActivity.a(this.a).a(3);
      if ((!VideoFeedsPlayActivity.a(this.a)) && (i == 1) && (VideoFeedsPlayActivity.e(this.a)) && (paramBoolean)) {
        VideoFeedsPlayActivity.a(this.a);
      }
      VideoFeedsPlayActivity.b(this.a, str);
      break;
      label1965:
      localObject1 = "";
      break label1821;
      VideoFeedsPlayActivity.a(this.a, (VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0));
      break label1874;
      label2042:
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "VideoPlayRecommendObserver() 正常拉取逻辑 data.size()=: " + paramBundle.size());
      }
      paramBundle = localArrayList1.iterator();
      bool = false;
      if (paramBundle.hasNext())
      {
        localObject2 = (VideoInfo)paramBundle.next();
        if (((VideoInfo)localObject2).jdField_c_of_type_Boolean)
        {
          VideoFeedsPlayActivity.a(this.a).add(localObject2);
          if (!QLog.isColorLevel()) {
            break label2471;
          }
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "VideoPlayRecommendObserver() 正常拉取逻辑 info.adType=" + ((VideoInfo)localObject2).jdField_h_of_type_Int + ", info.title=" + ((VideoInfo)localObject2).jdField_c_of_type_JavaLangString + ", adInfo.aid=" + ((VideoInfo)localObject2).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.e + ", adInfo.traceid=" + ((VideoInfo)localObject2).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.h + " add to videoDataList");
        }
        label2471:
        for (paramBoolean = true;; paramBoolean = true)
        {
          bool = paramBoolean;
          break;
          if (this.a.a.contains(((VideoInfo)localObject2).jdField_a_of_type_JavaLangString))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "VideoPlayRecommendObserver() 正常拉取逻辑 info.vid=" + ((VideoInfo)localObject2).jdField_a_of_type_JavaLangString + ", info.title=" + ((VideoInfo)localObject2).jdField_c_of_type_JavaLangString + ", info.articleID=" + ((VideoInfo)localObject2).jdField_g_of_type_JavaLangString + " has exist");
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "VideoPlayRecommendObserver() 正常拉取逻辑 info.vid=" + ((VideoInfo)localObject2).jdField_a_of_type_JavaLangString + ", info.title=" + ((VideoInfo)localObject2).jdField_c_of_type_JavaLangString + ", info.articleID=" + ((VideoInfo)localObject2).jdField_g_of_type_JavaLangString + " add to videoDataList");
          }
          if ((((VideoInfo)localObject2).jdField_b_of_type_Boolean) && (TextUtils.isEmpty(((VideoInfo)localObject2).k))) {
            ((VideoInfo)localObject2).k = ContactUtils.b(VideoFeedsPlayActivity.a(this.a), ((VideoInfo)localObject2).jdField_j_of_type_JavaLangString, true);
          }
          VideoFeedsHelper.a((VideoInfo)localObject2);
          localJSONException.add(((VideoInfo)localObject2).jdField_g_of_type_JavaLangString);
          VideoFeedsPlayActivity.a(this.a).add(localObject2);
          this.a.a.add(((VideoInfo)localObject2).jdField_a_of_type_JavaLangString);
        }
      }
      ReadInJoyAtlasManager.a().a(localJSONException, VideoFeedsPlayActivity.a(this.a));
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "VideoPlayRecommendObserver() 正常拉取逻辑 hasNewVideo = " + bool);
      }
      paramBoolean = bool;
      if (1 == VideoFeedsPlayActivity.a(this.a).size() - localArrayList1.size())
      {
        paramBoolean = bool;
        if (bool)
        {
          VideoFeedsPlayActivity.a(this.a).a(0);
          if (VideoFeedsPlayActivity.a(this.a).get(0) != null) {
            ((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).jdField_c_of_type_JavaUtilArrayList = localArrayList2;
          }
          paramBoolean = bool;
          if (VideoFeedsPlayActivity.a(this.a).get(1) != null)
          {
            paramBundle = (VideoInfo)VideoFeedsPlayActivity.a(this.a).get(1);
            if (paramBundle.jdField_a_of_type_Int != 0)
            {
              if ((!TextUtils.isEmpty(paramBundle.jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramBundle.jdField_g_of_type_JavaLangString))) {
                VideoFeedsPlayActivity.a(this.a).a(paramBundle.jdField_a_of_type_JavaLangString, paramBundle.jdField_g_of_type_JavaLangString);
              }
              if (!TextUtils.isEmpty(paramBundle.jdField_j_of_type_JavaLangString)) {
                VideoFeedsPlayActivity.b(this.a, paramBundle);
              }
            }
            paramBoolean = bool;
            if (!VideoFeedsHelper.a(paramBundle))
            {
              paramBoolean = bool;
              if (!TextUtils.isEmpty(paramBundle.a()))
              {
                VideoFeedsPlayActivity.a(this.a).e(paramBundle.a());
                VideoFeedsPlayActivity.a(this.a).c(paramBundle.a());
                paramBoolean = bool;
                continue;
                label2751:
                paramBoolean = false;
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mgk
 * JD-Core Version:    0.7.0.1
 */