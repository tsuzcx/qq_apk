import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.SoftAdDownloadBarInfo;
import com.tencent.biz.pubaccount.VideoInfo.SubscriptInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import java.util.ArrayList;
import java.util.Iterator;

public final class suu
{
  private final sut a;
  
  public suu(VideoInfo paramVideoInfo)
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
      this.a = new sut(localObject2, str1, paramVideoInfo, (String)localObject1);
      return;
      paramVideoInfo = null;
      str1 = null;
      localObject2 = null;
    }
  }
  
  public suu(String paramString)
  {
    this.a = new sut(paramString);
  }
  
  public suu(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a = new sut(paramString1, paramString2, paramString3, paramString4);
  }
  
  public suu(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2)
  {
    this.a = new sut(paramString1, paramString2, paramString3, paramString4);
    a(paramLong1).c(paramLong2);
  }
  
  public suu(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = new sut(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == 1004) {
      return 2;
    }
    if (bmhv.l()) {
      return 0;
    }
    return 1;
  }
  
  public suu A(int paramInt)
  {
    this.a.a("actual_height", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu B(int paramInt)
  {
    this.a.a("issued_width", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu C(int paramInt)
  {
    this.a.a("issued_height", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu D(int paramInt)
  {
    if (paramInt != -1) {
      this.a.a("replay", Integer.valueOf(paramInt));
    }
    return this;
  }
  
  public suu E(int paramInt)
  {
    this.a.a("first_video_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu F(int paramInt)
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
  
  public suu G(int paramInt)
  {
    sut localsut = this.a;
    if (paramInt == 0) {}
    for (String str = "MP4";; str = "HLS")
    {
      localsut.a("video_format", str);
      return this;
    }
  }
  
  public suu H(int paramInt)
  {
    this.a.a("video_chat_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu I(int paramInt)
  {
    this.a.a("video_kandian_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu J(int paramInt)
  {
    this.a.a("req_times", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu K(int paramInt)
  {
    this.a.a("first_video_channel_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu L(int paramInt)
  {
    this.a.a("first_video_short_video_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu M(int paramInt)
  {
    this.a.a("video_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu N(int paramInt)
  {
    this.a.a("entrance", Integer.valueOf(a(paramInt)));
    return this;
  }
  
  public suu O(int paramInt)
  {
    this.a.a("count", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu P(int paramInt)
  {
    this.a.a("style", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu Q(int paramInt)
  {
    this.a.a("click_area", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu R(int paramInt)
  {
    this.a.a("show_video_logo", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu S(int paramInt)
  {
    this.a.a("trigger_src", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu T(int paramInt)
  {
    this.a.a("diandianfeeds_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu U(int paramInt)
  {
    this.a.a("entrance_show_jump_icon", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu V(int paramInt)
  {
    this.a.a("feeds_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu W(int paramInt)
  {
    this.a.a("from_feedstype", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu X(int paramInt)
  {
    this.a.a("column_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu Y(int paramInt)
  {
    this.a.a("double_card_pos", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu Z(int paramInt)
  {
    this.a.a("video_autoplay", Integer.valueOf(paramInt));
    return this;
  }
  
  public sut a()
  {
    return this.a;
  }
  
  public suu a()
  {
    sut localsut = this.a;
    int i;
    if (pqu.c()) {
      i = 2;
    }
    for (;;)
    {
      localsut.a("app_type", Integer.valueOf(i));
      return this;
      if (prs.c()) {
        i = 1;
      } else {
        i = 3;
      }
    }
  }
  
  public suu a(int paramInt)
  {
    this.a.a("channel_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu a(int paramInt, String paramString)
  {
    if (bmhv.g(paramInt)) {
      this.a.a("column_play_session_id", paramString);
    }
    return this;
  }
  
  public suu a(long paramLong)
  {
    this.a.a("current_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public suu a(VideoInfo.SoftAdDownloadBarInfo paramSoftAdDownloadBarInfo)
  {
    sut localsut = this.a;
    if ((paramSoftAdDownloadBarInfo != null) && (paramSoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null)) {}
    for (paramSoftAdDownloadBarInfo = paramSoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;; paramSoftAdDownloadBarInfo = "")
    {
      localsut.a("ad_guide_area_video_report_info", paramSoftAdDownloadBarInfo);
      return this;
    }
  }
  
  public suu a(VideoInfo paramVideoInfo)
  {
    sut localsut = this.a;
    if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) {}
    for (int i = 1;; i = 0)
    {
      localsut.a("ad_guide_area", Integer.valueOf(i));
      return this;
    }
  }
  
  public suu a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SubscriptInfo != null)) {
      this.a.a("corner_mark", Integer.valueOf(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SubscriptInfo.c));
    }
    return this;
  }
  
  public suu a(BaseArticleInfo paramBaseArticleInfo)
  {
    sut localsut = this.a;
    if (paramBaseArticleInfo.isShowGif) {}
    for (int i = 1;; i = 0)
    {
      localsut.a("gif", Integer.valueOf(i));
      return this;
    }
  }
  
  public suu a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
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
  
  public suu a(VideoColumnInfo paramVideoColumnInfo)
  {
    int i = 1;
    if (paramVideoColumnInfo != null)
    {
      this.a.a("is_column", Integer.valueOf(1));
      this.a.a("column_id", Integer.valueOf(paramVideoColumnInfo.jdField_a_of_type_Int));
      sut localsut = this.a;
      if (paramVideoColumnInfo.jdField_a_of_type_Boolean) {}
      for (;;)
      {
        localsut.a("subscribe_flag", Integer.valueOf(i));
        return this;
        i = 0;
      }
    }
    this.a.a("is_column", Integer.valueOf(0));
    return this;
  }
  
  public suu a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue()) {
      this.a.a("is_ugc_as_pgc", Integer.valueOf(1));
    }
    return this;
  }
  
  public suu a(String paramString)
  {
    sut localsut = this.a;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localsut.a("video_report_info", str);
    return this;
  }
  
  public suu a(String paramString, Object paramObject)
  {
    this.a.a(paramString, paramObject);
    return this;
  }
  
  public suu a(ArrayList<DislikeInfo> paramArrayList)
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
  
  public suu a(spz paramspz)
  {
    suu localsuu = this;
    if (paramspz != null) {
      localsuu = d(paramspz.a());
    }
    return localsuu;
  }
  
  public suu a(spz paramspz, long paramLong)
  {
    suu localsuu = this;
    if (paramspz != null) {
      localsuu = c(paramspz.a(paramLong));
    }
    return localsuu;
  }
  
  public suu a(boolean paramBoolean)
  {
    sut localsut = this.a;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localsut.a("download", Integer.valueOf(i));
      return this;
    }
  }
  
  public suu aa(int paramInt)
  {
    this.a.a("subscribe_page", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu ab(int paramInt)
  {
    this.a.a("return_sence", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu ac(int paramInt)
  {
    this.a.a("video_speed", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu ad(int paramInt)
  {
    this.a.a("topic_from_page", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu ae(int paramInt)
  {
    this.a.a("follow_way", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu af(int paramInt)
  {
    this.a.a("behavior_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu b(int paramInt)
  {
    this.a.a("card_jump_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu b(long paramLong)
  {
    this.a.a("stay_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public suu b(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo != null) && (!TextUtils.isEmpty(paramBaseArticleInfo.mVideoLogoUrl)) && (six.e()))
    {
      this.a.a("show_video_logo", Integer.valueOf(1));
      return this;
    }
    this.a.a("show_video_logo", Integer.valueOf(0));
    return this;
  }
  
  public suu b(VideoColumnInfo paramVideoColumnInfo)
  {
    suu localsuu = this;
    if (paramVideoColumnInfo != null) {
      localsuu = X(paramVideoColumnInfo.jdField_a_of_type_Int);
    }
    return localsuu;
  }
  
  public suu b(String paramString)
  {
    this.a.a("session_id", paramString);
    return this;
  }
  
  public suu b(boolean paramBoolean)
  {
    sut localsut = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localsut.a("interact_button_style", Integer.valueOf(i));
      return this;
    }
  }
  
  public suu c(int paramInt)
  {
    this.a.a("strategy_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu c(long paramLong)
  {
    this.a.a("video_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public suu c(BaseArticleInfo paramBaseArticleInfo)
  {
    suu localsuu = this;
    if (paramBaseArticleInfo != null)
    {
      localsuu = this;
      if (paramBaseArticleInfo.mChannelID == 56L)
      {
        localsuu = this;
        if (paramBaseArticleInfo.mVideoColumnInfo != null) {
          localsuu = b(paramBaseArticleInfo.mVideoColumnInfo);
        }
      }
    }
    return localsuu;
  }
  
  public suu c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.a("video_session_id", paramString);
    }
    return this;
  }
  
  public suu c(boolean paramBoolean)
  {
    this.a.a("video_inserted", Boolean.valueOf(paramBoolean));
    return this;
  }
  
  public suu d(int paramInt)
  {
    this.a.a("video_strategyid", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu d(long paramLong)
  {
    this.a.a("watch_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public suu d(BaseArticleInfo paramBaseArticleInfo)
  {
    int j = 1;
    int i = j;
    if (paramBaseArticleInfo != null)
    {
      i = j;
      if (paramBaseArticleInfo.mChannelID == 56L)
      {
        i = j;
        if (bmhv.e())
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
  
  public suu d(String paramString)
  {
    this.a.a("puin", paramString);
    return this;
  }
  
  public suu d(boolean paramBoolean)
  {
    sut localsut = this.a;
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      localsut.a("fans", str);
      return this;
    }
  }
  
  public suu e(int paramInt)
  {
    this.a.a("play_index", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu e(long paramLong)
  {
    this.a.a("algorithm_id", Long.valueOf(paramLong));
    return this;
  }
  
  public suu e(BaseArticleInfo paramBaseArticleInfo)
  {
    this.a.a("account_expose_card", Integer.valueOf(pqf.a(paramBaseArticleInfo)));
    return this;
  }
  
  public suu e(String paramString)
  {
    this.a.a("vid", paramString);
    return this;
  }
  
  public suu e(boolean paramBoolean)
  {
    sut localsut = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localsut.a("is_ads", Integer.valueOf(i));
      return this;
    }
  }
  
  public suu f(int paramInt)
  {
    this.a.a("video_play_length", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu f(long paramLong)
  {
    this.a.a("video_play_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public suu f(BaseArticleInfo paramBaseArticleInfo)
  {
    if (rnv.a().a(paramBaseArticleInfo, false, rnv.jdField_a_of_type_Int)) {
      this.a.a("jump_src", Integer.valueOf(rnz.a(paramBaseArticleInfo)));
    }
    return this;
  }
  
  public suu f(String paramString)
  {
    this.a.a("aid", paramString);
    return this;
  }
  
  public suu f(boolean paramBoolean)
  {
    sut localsut = this.a;
    if (paramBoolean) {}
    for (String str = "H265";; str = "H264")
    {
      localsut.a("video_code_format", str);
      return this;
    }
  }
  
  public suu g(int paramInt)
  {
    this.a.a("from", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu g(long paramLong)
  {
    this.a.a("first_frame_time", Long.valueOf(paramLong));
    return this;
  }
  
  public suu g(String paramString)
  {
    this.a.a("topic_id", paramString);
    return this;
  }
  
  public suu g(boolean paramBoolean)
  {
    sut localsut = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localsut.a("action_type", Integer.valueOf(i));
      return this;
    }
  }
  
  public suu h(int paramInt)
  {
    this.a.a("jump_to_channel", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu h(long paramLong)
  {
    this.a.a("first_video_algorithm_id", Long.valueOf(paramLong));
    return this;
  }
  
  public suu h(String paramString)
  {
    this.a.a("first_video_rowkey", paramString);
    return this;
  }
  
  public suu h(boolean paramBoolean)
  {
    sut localsut = this.a;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localsut.a("outcome", Integer.valueOf(i));
      return this;
    }
  }
  
  public suu i(int paramInt)
  {
    this.a.a("oper_time", Long.valueOf(System.currentTimeMillis()));
    this.a.a("company_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu i(long paramLong)
  {
    this.a.a("duration", Long.valueOf(paramLong));
    return this;
  }
  
  public suu i(String paramString)
  {
    this.a.a("rowkey", paramString);
    return this;
  }
  
  public suu i(boolean paramBoolean)
  {
    sut localsut = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localsut.a("loophole", Integer.valueOf(i));
      return this;
    }
  }
  
  public suu j(int paramInt)
  {
    this.a.a("ads_jump", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu j(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.a("error_code", paramString);
    }
    return this;
  }
  
  public suu j(boolean paramBoolean)
  {
    sut localsut = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localsut.a("is_insertion", Integer.valueOf(i));
      return this;
    }
  }
  
  public suu k(int paramInt)
  {
    this.a.a("ads_source", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu k(String paramString)
  {
    this.a.a("video_to_uin", paramString);
    return this;
  }
  
  public suu k(boolean paramBoolean)
  {
    sut localsut = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localsut.a("video_speed_icon", Integer.valueOf(i));
      return this;
    }
  }
  
  public suu l(int paramInt)
  {
    this.a.a("video_index", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu l(String paramString)
  {
    this.a.a("neg_reason", paramString);
    return this;
  }
  
  public suu l(boolean paramBoolean)
  {
    sut localsut = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localsut.a("is_play", Integer.valueOf(i));
      return this;
    }
  }
  
  public suu m(int paramInt)
  {
    this.a.a("transverse_index", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu m(String paramString)
  {
    this.a.a("uin", paramString);
    return this;
  }
  
  public suu m(boolean paramBoolean)
  {
    sut localsut = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localsut.a("UG", Integer.valueOf(i));
      return this;
    }
  }
  
  public suu n(int paramInt)
  {
    this.a.a("content_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu n(String paramString)
  {
    this.a.a("trigger_rowkey", paramString);
    return this;
  }
  
  public suu o(int paramInt)
  {
    this.a.a("add_way", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu o(String paramString)
  {
    this.a.a("from_rk", paramString);
    return this;
  }
  
  public suu p(int paramInt)
  {
    this.a.a("slide_exit", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu p(String paramString)
  {
    this.a.a("jump_report_info", paramString);
    return this;
  }
  
  public suu q(int paramInt)
  {
    this.a.a("kandian_mode_new", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu q(String paramString)
  {
    this.a.a("double_videocard_jump_page", paramString);
    return this;
  }
  
  public suu r(int paramInt)
  {
    this.a.a("kandian_mode", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu r(String paramString)
  {
    this.a.a("double_videocard_jump_src", paramString);
    return this;
  }
  
  public suu s(int paramInt)
  {
    this.a.a("item_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu s(String paramString)
  {
    this.a.a("subscript", paramString);
    return this;
  }
  
  public suu t(int paramInt)
  {
    this.a.a("play_num", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu u(int paramInt)
  {
    this.a.a("video_from_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu v(int paramInt)
  {
    if (paramInt != -1) {
      this.a.a("source", Integer.valueOf(paramInt));
    }
    return this;
  }
  
  public suu w(int paramInt)
  {
    this.a.a("card_pos", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu x(int paramInt)
  {
    this.a.a("is_loop", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu y(int paramInt)
  {
    this.a.a("loop_times", Integer.valueOf(paramInt));
    return this;
  }
  
  public suu z(int paramInt)
  {
    this.a.a("actual_width", Integer.valueOf(paramInt));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     suu
 * JD-Core Version:    0.7.0.1
 */