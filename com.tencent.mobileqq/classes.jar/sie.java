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

public final class sie
{
  private final sid a;
  
  public sie(VideoInfo paramVideoInfo)
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
      this.a = new sid(localObject2, str1, paramVideoInfo, (String)localObject1);
      return;
      paramVideoInfo = null;
      str1 = null;
      localObject2 = null;
    }
  }
  
  public sie(String paramString)
  {
    this.a = new sid(paramString);
  }
  
  public sie(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a = new sid(paramString1, paramString2, paramString3, paramString4);
  }
  
  public sie(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2)
  {
    this.a = new sid(paramString1, paramString2, paramString3, paramString4);
    a(paramLong1).c(paramLong2);
  }
  
  public sie(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = new sid(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == 1004) {
      return 2;
    }
    if (bkwm.i()) {
      return 0;
    }
    return 1;
  }
  
  public sie A(int paramInt)
  {
    this.a.a("actual_height", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie B(int paramInt)
  {
    this.a.a("issued_width", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie C(int paramInt)
  {
    this.a.a("issued_height", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie D(int paramInt)
  {
    if (paramInt != -1) {
      this.a.a("replay", Integer.valueOf(paramInt));
    }
    return this;
  }
  
  public sie E(int paramInt)
  {
    this.a.a("first_video_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie F(int paramInt)
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
  
  public sie G(int paramInt)
  {
    sid localsid = this.a;
    if (paramInt == 0) {}
    for (String str = "MP4";; str = "HLS")
    {
      localsid.a("video_format", str);
      return this;
    }
  }
  
  public sie H(int paramInt)
  {
    this.a.a("video_chat_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie I(int paramInt)
  {
    this.a.a("video_kandian_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie J(int paramInt)
  {
    this.a.a("req_times", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie K(int paramInt)
  {
    this.a.a("first_video_channel_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie L(int paramInt)
  {
    this.a.a("first_video_short_video_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie M(int paramInt)
  {
    this.a.a("video_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie N(int paramInt)
  {
    this.a.a("entrance", Integer.valueOf(a(paramInt)));
    return this;
  }
  
  public sie O(int paramInt)
  {
    this.a.a("count", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie P(int paramInt)
  {
    this.a.a("style", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie Q(int paramInt)
  {
    this.a.a("click_area", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie R(int paramInt)
  {
    this.a.a("show_video_logo", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie S(int paramInt)
  {
    this.a.a("trigger_src", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie T(int paramInt)
  {
    this.a.a("diandianfeeds_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie U(int paramInt)
  {
    this.a.a("entrance_show_jump_icon", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie V(int paramInt)
  {
    this.a.a("feeds_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie W(int paramInt)
  {
    this.a.a("from_feedstype", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie X(int paramInt)
  {
    this.a.a("column_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie Y(int paramInt)
  {
    this.a.a("double_card_pos", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie Z(int paramInt)
  {
    this.a.a("video_autoplay", Integer.valueOf(paramInt));
    return this;
  }
  
  public sid a()
  {
    return this.a;
  }
  
  public sie a()
  {
    sid localsid = this.a;
    int i;
    if (pay.d()) {
      i = 2;
    }
    for (;;)
    {
      localsid.a("app_type", Integer.valueOf(i));
      return this;
      if (pay.x()) {
        i = 1;
      } else {
        i = 3;
      }
    }
  }
  
  public sie a(float paramFloat)
  {
    this.a.a("video_speed", Float.valueOf(paramFloat));
    return this;
  }
  
  public sie a(int paramInt)
  {
    this.a.a("channel_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie a(int paramInt, String paramString)
  {
    if (bkwm.g(paramInt)) {
      this.a.a("column_play_session_id", paramString);
    }
    return this;
  }
  
  public sie a(long paramLong)
  {
    this.a.a("current_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public sie a(VideoInfo.SoftAdDownloadBarInfo paramSoftAdDownloadBarInfo)
  {
    sid localsid = this.a;
    if ((paramSoftAdDownloadBarInfo != null) && (paramSoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null)) {}
    for (paramSoftAdDownloadBarInfo = paramSoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;; paramSoftAdDownloadBarInfo = "")
    {
      localsid.a("ad_guide_area_video_report_info", paramSoftAdDownloadBarInfo);
      return this;
    }
  }
  
  public sie a(VideoInfo paramVideoInfo)
  {
    sid localsid = this.a;
    if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) {}
    for (int i = 1;; i = 0)
    {
      localsid.a("ad_guide_area", Integer.valueOf(i));
      return this;
    }
  }
  
  public sie a(BaseArticleInfo paramBaseArticleInfo)
  {
    sid localsid = this.a;
    if (paramBaseArticleInfo.isShowGif) {}
    for (int i = 1;; i = 0)
    {
      localsid.a("gif", Integer.valueOf(i));
      return this;
    }
  }
  
  public sie a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
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
  
  public sie a(VideoColumnInfo paramVideoColumnInfo)
  {
    int i = 1;
    if (paramVideoColumnInfo != null)
    {
      this.a.a("is_column", Integer.valueOf(1));
      this.a.a("column_id", Integer.valueOf(paramVideoColumnInfo.jdField_a_of_type_Int));
      sid localsid = this.a;
      if (paramVideoColumnInfo.jdField_a_of_type_Boolean) {}
      for (;;)
      {
        localsid.a("subscribe_flag", Integer.valueOf(i));
        return this;
        i = 0;
      }
    }
    this.a.a("is_column", Integer.valueOf(0));
    return this;
  }
  
  public sie a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue()) {
      this.a.a("is_ugc_as_pgc", Integer.valueOf(1));
    }
    return this;
  }
  
  public sie a(String paramString)
  {
    sid localsid = this.a;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localsid.a("video_report_info", str);
    return this;
  }
  
  public sie a(String paramString, Object paramObject)
  {
    this.a.a(paramString, paramObject);
    return this;
  }
  
  public sie a(ArrayList<DislikeInfo> paramArrayList)
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
  
  public sie a(sdv paramsdv)
  {
    sie localsie = this;
    if (paramsdv != null) {
      localsie = d(paramsdv.a());
    }
    return localsie;
  }
  
  public sie a(sdv paramsdv, long paramLong)
  {
    sie localsie = this;
    if (paramsdv != null) {
      localsie = c(paramsdv.a(paramLong));
    }
    return localsie;
  }
  
  public sie a(boolean paramBoolean)
  {
    sid localsid = this.a;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localsid.a("download", Integer.valueOf(i));
      return this;
    }
  }
  
  public sie aa(int paramInt)
  {
    this.a.a("subscribe_page", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie ab(int paramInt)
  {
    this.a.a("return_sence", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie ac(int paramInt)
  {
    this.a.a("topic_from_page", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie ad(int paramInt)
  {
    this.a.a("follow_way", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie ae(int paramInt)
  {
    this.a.a("behavior_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie b(int paramInt)
  {
    this.a.a("card_jump_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie b(long paramLong)
  {
    this.a.a("stay_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public sie b(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo != null) && (!TextUtils.isEmpty(paramBaseArticleInfo.mVideoLogoUrl)) && (rwv.e()))
    {
      this.a.a("show_video_logo", Integer.valueOf(1));
      return this;
    }
    this.a.a("show_video_logo", Integer.valueOf(0));
    return this;
  }
  
  public sie b(VideoColumnInfo paramVideoColumnInfo)
  {
    sie localsie = this;
    if (paramVideoColumnInfo != null) {
      localsie = X(paramVideoColumnInfo.jdField_a_of_type_Int);
    }
    return localsie;
  }
  
  public sie b(String paramString)
  {
    this.a.a("session_id", paramString);
    return this;
  }
  
  public sie b(boolean paramBoolean)
  {
    sid localsid = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localsid.a("interact_button_style", Integer.valueOf(i));
      return this;
    }
  }
  
  public sie c(int paramInt)
  {
    this.a.a("strategy_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie c(long paramLong)
  {
    this.a.a("video_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public sie c(BaseArticleInfo paramBaseArticleInfo)
  {
    sie localsie = this;
    if (paramBaseArticleInfo != null)
    {
      localsie = this;
      if (paramBaseArticleInfo.mChannelID == 56L)
      {
        localsie = this;
        if (paramBaseArticleInfo.mVideoColumnInfo != null) {
          localsie = b(paramBaseArticleInfo.mVideoColumnInfo);
        }
      }
    }
    return localsie;
  }
  
  public sie c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.a("video_session_id", paramString);
    }
    return this;
  }
  
  public sie c(boolean paramBoolean)
  {
    this.a.a("video_inserted", Boolean.valueOf(paramBoolean));
    return this;
  }
  
  public sie d(int paramInt)
  {
    this.a.a("video_strategyid", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie d(long paramLong)
  {
    this.a.a("watch_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public sie d(BaseArticleInfo paramBaseArticleInfo)
  {
    int j = 1;
    int i = j;
    if (paramBaseArticleInfo != null)
    {
      i = j;
      if (paramBaseArticleInfo.mChannelID == 56L)
      {
        i = j;
        if (bkwm.e())
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
  
  public sie d(String paramString)
  {
    this.a.a("puin", paramString);
    return this;
  }
  
  public sie d(boolean paramBoolean)
  {
    sid localsid = this.a;
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      localsid.a("fans", str);
      return this;
    }
  }
  
  public sie e(int paramInt)
  {
    this.a.a("play_index", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie e(long paramLong)
  {
    this.a.a("algorithm_id", Long.valueOf(paramLong));
    return this;
  }
  
  public sie e(BaseArticleInfo paramBaseArticleInfo)
  {
    this.a.a("account_expose_card", Integer.valueOf(pay.c(paramBaseArticleInfo)));
    return this;
  }
  
  public sie e(String paramString)
  {
    this.a.a("vid", paramString);
    return this;
  }
  
  public sie e(boolean paramBoolean)
  {
    sid localsid = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localsid.a("is_ads", Integer.valueOf(i));
      return this;
    }
  }
  
  public sie f(int paramInt)
  {
    this.a.a("video_play_length", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie f(long paramLong)
  {
    this.a.a("video_play_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public sie f(BaseArticleInfo paramBaseArticleInfo)
  {
    if (rbp.a().a(paramBaseArticleInfo, false, rbp.jdField_a_of_type_Int)) {
      this.a.a("jump_src", Integer.valueOf(rbt.a(paramBaseArticleInfo)));
    }
    return this;
  }
  
  public sie f(String paramString)
  {
    this.a.a("aid", paramString);
    return this;
  }
  
  public sie f(boolean paramBoolean)
  {
    sid localsid = this.a;
    if (paramBoolean) {}
    for (String str = "H265";; str = "H264")
    {
      localsid.a("video_code_format", str);
      return this;
    }
  }
  
  public sie g(int paramInt)
  {
    this.a.a("from", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie g(long paramLong)
  {
    this.a.a("first_frame_time", Long.valueOf(paramLong));
    return this;
  }
  
  public sie g(String paramString)
  {
    this.a.a("topic_id", paramString);
    return this;
  }
  
  public sie g(boolean paramBoolean)
  {
    sid localsid = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localsid.a("action_type", Integer.valueOf(i));
      return this;
    }
  }
  
  public sie h(int paramInt)
  {
    this.a.a("jump_to_channel", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie h(long paramLong)
  {
    this.a.a("first_video_algorithm_id", Long.valueOf(paramLong));
    return this;
  }
  
  public sie h(String paramString)
  {
    this.a.a("first_video_rowkey", paramString);
    return this;
  }
  
  public sie h(boolean paramBoolean)
  {
    sid localsid = this.a;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localsid.a("outcome", Integer.valueOf(i));
      return this;
    }
  }
  
  public sie i(int paramInt)
  {
    this.a.a("oper_time", Long.valueOf(System.currentTimeMillis()));
    this.a.a("company_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie i(long paramLong)
  {
    this.a.a("duration", Long.valueOf(paramLong));
    return this;
  }
  
  public sie i(String paramString)
  {
    this.a.a("rowkey", paramString);
    return this;
  }
  
  public sie i(boolean paramBoolean)
  {
    sid localsid = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localsid.a("loophole", Integer.valueOf(i));
      return this;
    }
  }
  
  public sie j(int paramInt)
  {
    this.a.a("ads_jump", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie j(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.a("error_code", paramString);
    }
    return this;
  }
  
  public sie j(boolean paramBoolean)
  {
    sid localsid = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localsid.a("is_insertion", Integer.valueOf(i));
      return this;
    }
  }
  
  public sie k(int paramInt)
  {
    this.a.a("ads_source", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie k(String paramString)
  {
    this.a.a("video_to_uin", paramString);
    return this;
  }
  
  public sie k(boolean paramBoolean)
  {
    sid localsid = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localsid.a("video_speed_icon", Integer.valueOf(i));
      return this;
    }
  }
  
  public sie l(int paramInt)
  {
    this.a.a("video_index", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie l(String paramString)
  {
    this.a.a("neg_reason", paramString);
    return this;
  }
  
  public sie l(boolean paramBoolean)
  {
    sid localsid = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localsid.a("is_play", Integer.valueOf(i));
      return this;
    }
  }
  
  public sie m(int paramInt)
  {
    this.a.a("transverse_index", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie m(String paramString)
  {
    this.a.a("uin", paramString);
    return this;
  }
  
  public sie m(boolean paramBoolean)
  {
    sid localsid = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localsid.a("UG", Integer.valueOf(i));
      return this;
    }
  }
  
  public sie n(int paramInt)
  {
    this.a.a("content_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie n(String paramString)
  {
    this.a.a("trigger_rowkey", paramString);
    return this;
  }
  
  public sie o(int paramInt)
  {
    this.a.a("add_way", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie o(String paramString)
  {
    this.a.a("from_rk", paramString);
    return this;
  }
  
  public sie p(int paramInt)
  {
    this.a.a("slide_exit", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie p(String paramString)
  {
    this.a.a("jump_report_info", paramString);
    return this;
  }
  
  public sie q(int paramInt)
  {
    this.a.a("kandian_mode_new", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie q(String paramString)
  {
    this.a.a("double_videocard_jump_page", paramString);
    return this;
  }
  
  public sie r(int paramInt)
  {
    this.a.a("kandian_mode", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie r(String paramString)
  {
    this.a.a("double_videocard_jump_src", paramString);
    return this;
  }
  
  public sie s(int paramInt)
  {
    this.a.a("item_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie s(String paramString)
  {
    this.a.a("subscript", paramString);
    return this;
  }
  
  public sie t(int paramInt)
  {
    this.a.a("play_num", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie u(int paramInt)
  {
    this.a.a("video_from_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie v(int paramInt)
  {
    if (paramInt != -1) {
      this.a.a("source", Integer.valueOf(paramInt));
    }
    return this;
  }
  
  public sie w(int paramInt)
  {
    this.a.a("card_pos", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie x(int paramInt)
  {
    this.a.a("is_loop", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie y(int paramInt)
  {
    this.a.a("loop_times", Integer.valueOf(paramInt));
    return this;
  }
  
  public sie z(int paramInt)
  {
    this.a.a("actual_width", Integer.valueOf(paramInt));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sie
 * JD-Core Version:    0.7.0.1
 */