import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.SoftAdDownloadBarInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import java.util.ArrayList;
import java.util.Iterator;

public final class sbg
{
  private final sbf a;
  
  public sbg(VideoInfo paramVideoInfo)
  {
    String str1;
    if (paramVideoInfo != null)
    {
      str1 = paramVideoInfo.j;
      String str3 = paramVideoInfo.jdField_a_of_type_JavaLangString;
      String str2 = paramVideoInfo.g;
      localObject1 = localObject2;
      if (paramVideoInfo.jdField_a_of_type_Int == 0)
      {
        localObject1 = localObject2;
        if (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) {
          localObject1 = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
        }
      }
      paramVideoInfo = str3;
      localObject2 = localObject1;
      localObject1 = str2;
    }
    for (;;)
    {
      this.a = new sbf(localObject2, str1, paramVideoInfo, (String)localObject1);
      return;
      paramVideoInfo = null;
      str1 = null;
      localObject2 = null;
    }
  }
  
  public sbg(String paramString)
  {
    this.a = new sbf(paramString);
  }
  
  public sbg(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a = new sbf(paramString1, paramString2, paramString3, paramString4);
  }
  
  public sbg(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2)
  {
    this.a = new sbf(paramString1, paramString2, paramString3, paramString4);
    a(paramLong1).c(paramLong2);
  }
  
  public sbg(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = new sbf(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == 1004) {
      return 2;
    }
    if (bnrf.h()) {
      return 0;
    }
    return 1;
  }
  
  public sbg A(int paramInt)
  {
    this.a.a("actual_height", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg B(int paramInt)
  {
    this.a.a("issued_width", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg C(int paramInt)
  {
    this.a.a("issued_height", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg D(int paramInt)
  {
    if (paramInt != -1) {
      this.a.a("replay", Integer.valueOf(paramInt));
    }
    return this;
  }
  
  public sbg E(int paramInt)
  {
    this.a.a("first_video_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg F(int paramInt)
  {
    if (paramInt == 0) {
      paramInt = 302;
    }
    for (;;)
    {
      this.a.a("source", Integer.valueOf(paramInt));
      return this;
      if ((paramInt == 1) || (paramInt == 3)) {
        paramInt = 300;
      } else if ((paramInt == 2) || (paramInt == 6)) {
        paramInt = 301;
      } else {
        paramInt = 310;
      }
    }
  }
  
  public sbg G(int paramInt)
  {
    sbf localsbf = this.a;
    if (paramInt == 0) {}
    for (String str = "MP4";; str = "HLS")
    {
      localsbf.a("video_format", str);
      return this;
    }
  }
  
  public sbg H(int paramInt)
  {
    this.a.a("video_chat_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg I(int paramInt)
  {
    this.a.a("video_kandian_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg J(int paramInt)
  {
    this.a.a("req_times", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg K(int paramInt)
  {
    this.a.a("first_video_channel_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg L(int paramInt)
  {
    this.a.a("first_video_short_video_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg M(int paramInt)
  {
    this.a.a("video_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg N(int paramInt)
  {
    this.a.a("entrance", Integer.valueOf(a(paramInt)));
    return this;
  }
  
  public sbg O(int paramInt)
  {
    this.a.a("count", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg P(int paramInt)
  {
    this.a.a("style", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg Q(int paramInt)
  {
    this.a.a("click_area", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg R(int paramInt)
  {
    this.a.a("show_video_logo", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg S(int paramInt)
  {
    this.a.a("trigger_src", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg T(int paramInt)
  {
    this.a.a("diandianfeeds_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg U(int paramInt)
  {
    this.a.a("entrance_show_jump_icon", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg V(int paramInt)
  {
    this.a.a("feeds_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg W(int paramInt)
  {
    this.a.a("from_feedstype", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg X(int paramInt)
  {
    this.a.a("column_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg Y(int paramInt)
  {
    this.a.a("double_videocard_pos", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg Z(int paramInt)
  {
    this.a.a("video_autoplay", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbf a()
  {
    return this.a;
  }
  
  public sbg a()
  {
    sbf localsbf = this.a;
    int i;
    if (ozs.d()) {
      i = 2;
    }
    for (;;)
    {
      localsbf.a("app_type", Integer.valueOf(i));
      return this;
      if (ozs.x()) {
        i = 1;
      } else {
        i = 3;
      }
    }
  }
  
  public sbg a(float paramFloat)
  {
    this.a.a("video_speed", Float.valueOf(paramFloat));
    return this;
  }
  
  public sbg a(int paramInt)
  {
    this.a.a("channel_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg a(int paramInt, String paramString)
  {
    if (bnrf.g(paramInt)) {
      this.a.a("column_play_session_id", paramString);
    }
    return this;
  }
  
  public sbg a(long paramLong)
  {
    this.a.a("current_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public sbg a(VideoInfo.SoftAdDownloadBarInfo paramSoftAdDownloadBarInfo)
  {
    sbf localsbf = this.a;
    if ((paramSoftAdDownloadBarInfo != null) && (paramSoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null)) {}
    for (paramSoftAdDownloadBarInfo = paramSoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;; paramSoftAdDownloadBarInfo = "")
    {
      localsbf.a("ad_guide_area_video_report_info", paramSoftAdDownloadBarInfo);
      return this;
    }
  }
  
  public sbg a(VideoInfo paramVideoInfo)
  {
    sbf localsbf = this.a;
    if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) {}
    for (int i = 1;; i = 0)
    {
      localsbf.a("ad_guide_area", Integer.valueOf(i));
      return this;
    }
  }
  
  public sbg a(BaseArticleInfo paramBaseArticleInfo)
  {
    sbf localsbf = this.a;
    if (paramBaseArticleInfo.isShowGif) {}
    for (int i = 1;; i = 0)
    {
      localsbf.a("gif", Integer.valueOf(i));
      return this;
    }
  }
  
  public sbg a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mVideoColumnInfo != null) && (paramBaseArticleInfo.mChannelID == 56L))
    {
      if (!paramBoolean) {
        break label58;
      }
      paramBaseArticleInfo = paramBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo;
      if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.e == null)) {
        break label69;
      }
    }
    label58:
    label69:
    for (paramBaseArticleInfo = paramBaseArticleInfo.e;; paramBaseArticleInfo = "")
    {
      p(paramBaseArticleInfo);
      return this;
      paramBaseArticleInfo = paramBaseArticleInfo.mVideoColumnInfo.c;
      break;
    }
  }
  
  public sbg a(VideoColumnInfo paramVideoColumnInfo)
  {
    int i = 1;
    if (paramVideoColumnInfo != null)
    {
      this.a.a("is_column", Integer.valueOf(1));
      this.a.a("column_id", Integer.valueOf(paramVideoColumnInfo.jdField_a_of_type_Int));
      sbf localsbf = this.a;
      if (paramVideoColumnInfo.jdField_a_of_type_Boolean) {}
      for (;;)
      {
        localsbf.a("subscribe_flag", Integer.valueOf(i));
        return this;
        i = 0;
      }
    }
    this.a.a("is_column", Integer.valueOf(0));
    return this;
  }
  
  public sbg a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue()) {
      this.a.a("is_ugc_as_pgc", Integer.valueOf(1));
    }
    return this;
  }
  
  public sbg a(String paramString)
  {
    sbf localsbf = this.a;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localsbf.a("video_report_info", str);
    return this;
  }
  
  public sbg a(String paramString, Object paramObject)
  {
    this.a.a(paramString, paramObject);
    return this;
  }
  
  public sbg a(ArrayList<DislikeInfo> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      int j;
      for (int i = 1; paramArrayList.hasNext(); i = j)
      {
        DislikeInfo localDislikeInfo = (DislikeInfo)paramArrayList.next();
        j = i;
        if (localDislikeInfo != null)
        {
          if (i == 0) {
            localStringBuilder.append("|");
          }
          j = 0;
          localStringBuilder.append(localDislikeInfo.jdField_a_of_type_JavaLangString);
        }
      }
    }
    return l(localStringBuilder.toString());
  }
  
  public sbg a(rwr paramrwr)
  {
    sbg localsbg = this;
    if (paramrwr != null) {
      localsbg = d(paramrwr.a());
    }
    return localsbg;
  }
  
  public sbg a(rwr paramrwr, long paramLong)
  {
    sbg localsbg = this;
    if (paramrwr != null) {
      localsbg = c(paramrwr.a(paramLong));
    }
    return localsbg;
  }
  
  public sbg a(boolean paramBoolean)
  {
    sbf localsbf = this.a;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localsbf.a("download", Integer.valueOf(i));
      return this;
    }
  }
  
  public sbg aa(int paramInt)
  {
    this.a.a("subscribe_page", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg ab(int paramInt)
  {
    this.a.a("return_sence", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg ac(int paramInt)
  {
    this.a.a("topic_from_page", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg ad(int paramInt)
  {
    this.a.a("follow_way", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg b(int paramInt)
  {
    this.a.a("card_jump_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg b(long paramLong)
  {
    this.a.a("stay_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public sbg b(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo != null) && (!TextUtils.isEmpty(paramBaseArticleInfo.mVideoLogoUrl)) && (rpt.e()))
    {
      this.a.a("show_video_logo", Integer.valueOf(1));
      return this;
    }
    this.a.a("show_video_logo", Integer.valueOf(0));
    return this;
  }
  
  public sbg b(VideoColumnInfo paramVideoColumnInfo)
  {
    sbg localsbg = this;
    if (paramVideoColumnInfo != null) {
      localsbg = X(paramVideoColumnInfo.jdField_a_of_type_Int);
    }
    return localsbg;
  }
  
  public sbg b(String paramString)
  {
    this.a.a("session_id", paramString);
    return this;
  }
  
  public sbg b(boolean paramBoolean)
  {
    sbf localsbf = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localsbf.a("interact_button_style", Integer.valueOf(i));
      return this;
    }
  }
  
  public sbg c(int paramInt)
  {
    this.a.a("strategy_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg c(long paramLong)
  {
    this.a.a("video_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public sbg c(BaseArticleInfo paramBaseArticleInfo)
  {
    sbg localsbg = this;
    if (paramBaseArticleInfo != null)
    {
      localsbg = this;
      if (paramBaseArticleInfo.mChannelID == 56L)
      {
        localsbg = this;
        if (paramBaseArticleInfo.mVideoColumnInfo != null) {
          localsbg = b(paramBaseArticleInfo.mVideoColumnInfo);
        }
      }
    }
    return localsbg;
  }
  
  public sbg c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.a("video_session_id", paramString);
    }
    return this;
  }
  
  public sbg c(boolean paramBoolean)
  {
    this.a.a("video_inserted", Boolean.valueOf(paramBoolean));
    return this;
  }
  
  public sbg d(int paramInt)
  {
    this.a.a("video_strategyid", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg d(long paramLong)
  {
    this.a.a("watch_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public sbg d(BaseArticleInfo paramBaseArticleInfo)
  {
    int j = 1;
    int i = j;
    if (paramBaseArticleInfo != null)
    {
      i = j;
      if (paramBaseArticleInfo.mChannelID == 56L)
      {
        i = j;
        if (bnrf.e())
        {
          i = j;
          if (paramBaseArticleInfo.mVideoColumnInfo != null) {
            i = 2;
          }
        }
      }
    }
    this.a.a("video_feeds_type", Integer.valueOf(i));
    return this;
  }
  
  public sbg d(String paramString)
  {
    this.a.a("puin", paramString);
    return this;
  }
  
  public sbg d(boolean paramBoolean)
  {
    sbf localsbf = this.a;
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      localsbf.a("fans", str);
      return this;
    }
  }
  
  public sbg e(int paramInt)
  {
    this.a.a("play_index", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg e(long paramLong)
  {
    this.a.a("algorithm_id", Long.valueOf(paramLong));
    return this;
  }
  
  public sbg e(BaseArticleInfo paramBaseArticleInfo)
  {
    this.a.a("account_expose_card", Integer.valueOf(ozs.c(paramBaseArticleInfo)));
    return this;
  }
  
  public sbg e(String paramString)
  {
    this.a.a("vid", paramString);
    return this;
  }
  
  public sbg e(boolean paramBoolean)
  {
    sbf localsbf = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localsbf.a("is_ads", Integer.valueOf(i));
      return this;
    }
  }
  
  public sbg f(int paramInt)
  {
    this.a.a("video_play_length", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg f(long paramLong)
  {
    this.a.a("video_play_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public sbg f(BaseArticleInfo paramBaseArticleInfo)
  {
    if (qur.a().a(paramBaseArticleInfo, false, qur.jdField_a_of_type_Int)) {
      this.a.a("jump_src", Integer.valueOf(quv.a(paramBaseArticleInfo)));
    }
    return this;
  }
  
  public sbg f(String paramString)
  {
    this.a.a("aid", paramString);
    return this;
  }
  
  public sbg f(boolean paramBoolean)
  {
    sbf localsbf = this.a;
    if (paramBoolean) {}
    for (String str = "H265";; str = "H264")
    {
      localsbf.a("video_code_format", str);
      return this;
    }
  }
  
  public sbg g(int paramInt)
  {
    this.a.a("from", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg g(long paramLong)
  {
    this.a.a("first_frame_time", Long.valueOf(paramLong));
    return this;
  }
  
  public sbg g(String paramString)
  {
    this.a.a("topic_id", paramString);
    return this;
  }
  
  public sbg g(boolean paramBoolean)
  {
    sbf localsbf = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localsbf.a("action_type", Integer.valueOf(i));
      return this;
    }
  }
  
  public sbg h(int paramInt)
  {
    this.a.a("jump_to_channel", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg h(long paramLong)
  {
    this.a.a("first_video_algorithm_id", Long.valueOf(paramLong));
    return this;
  }
  
  public sbg h(String paramString)
  {
    this.a.a("first_video_rowkey", paramString);
    return this;
  }
  
  public sbg h(boolean paramBoolean)
  {
    sbf localsbf = this.a;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localsbf.a("outcome", Integer.valueOf(i));
      return this;
    }
  }
  
  public sbg i(int paramInt)
  {
    this.a.a("oper_time", Long.valueOf(System.currentTimeMillis()));
    this.a.a("company_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg i(long paramLong)
  {
    this.a.a("duration", Long.valueOf(paramLong));
    return this;
  }
  
  public sbg i(String paramString)
  {
    this.a.a("rowkey", paramString);
    return this;
  }
  
  public sbg i(boolean paramBoolean)
  {
    sbf localsbf = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localsbf.a("loophole", Integer.valueOf(i));
      return this;
    }
  }
  
  public sbg j(int paramInt)
  {
    this.a.a("ads_jump", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg j(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.a("error_code", paramString);
    }
    return this;
  }
  
  public sbg j(boolean paramBoolean)
  {
    sbf localsbf = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localsbf.a("is_insertion", Integer.valueOf(i));
      return this;
    }
  }
  
  public sbg k(int paramInt)
  {
    this.a.a("ads_source", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg k(String paramString)
  {
    this.a.a("video_to_uin", paramString);
    return this;
  }
  
  public sbg k(boolean paramBoolean)
  {
    sbf localsbf = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localsbf.a("video_speed_icon", Integer.valueOf(i));
      return this;
    }
  }
  
  public sbg l(int paramInt)
  {
    this.a.a("video_index", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg l(String paramString)
  {
    this.a.a("neg_reason", paramString);
    return this;
  }
  
  public sbg m(int paramInt)
  {
    this.a.a("transverse_index", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg m(String paramString)
  {
    this.a.a("uin", paramString);
    return this;
  }
  
  public sbg n(int paramInt)
  {
    this.a.a("content_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg n(String paramString)
  {
    this.a.a("trigger_rowkey", paramString);
    return this;
  }
  
  public sbg o(int paramInt)
  {
    this.a.a("add_way", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg o(String paramString)
  {
    this.a.a("from_rk", paramString);
    return this;
  }
  
  public sbg p(int paramInt)
  {
    this.a.a("slide_exit", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg p(String paramString)
  {
    this.a.a("jump_report_info", paramString);
    return this;
  }
  
  public sbg q(int paramInt)
  {
    this.a.a("kandian_mode_new", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg q(String paramString)
  {
    this.a.a("double_videocard_jump_page", paramString);
    return this;
  }
  
  public sbg r(int paramInt)
  {
    this.a.a("kandian_mode", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg r(String paramString)
  {
    this.a.a("double_videocard_jump_src", paramString);
    return this;
  }
  
  public sbg s(int paramInt)
  {
    this.a.a("item_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg s(String paramString)
  {
    this.a.a("subscript", paramString);
    return this;
  }
  
  public sbg t(int paramInt)
  {
    this.a.a("play_num", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg u(int paramInt)
  {
    this.a.a("video_from_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg v(int paramInt)
  {
    if (paramInt != -1) {
      this.a.a("source", Integer.valueOf(paramInt));
    }
    return this;
  }
  
  public sbg w(int paramInt)
  {
    this.a.a("card_pos", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg x(int paramInt)
  {
    this.a.a("is_loop", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg y(int paramInt)
  {
    this.a.a("loop_times", Integer.valueOf(paramInt));
    return this;
  }
  
  public sbg z(int paramInt)
  {
    this.a.a("actual_width", Integer.valueOf(paramInt));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sbg
 * JD-Core Version:    0.7.0.1
 */