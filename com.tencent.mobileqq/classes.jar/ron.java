import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public final class ron
{
  private final rom a;
  
  public ron(VideoInfo paramVideoInfo)
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
      this.a = new rom(localObject2, str1, paramVideoInfo, (String)localObject1);
      return;
      paramVideoInfo = null;
      str1 = null;
      localObject2 = null;
    }
  }
  
  public ron(String paramString)
  {
    this.a = new rom(paramString);
  }
  
  public ron(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a = new rom(paramString1, paramString2, paramString3, paramString4);
  }
  
  public ron(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2)
  {
    this.a = new rom(paramString1, paramString2, paramString3, paramString4);
    a(paramLong1).c(paramLong2);
  }
  
  public ron(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = new rom(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == 1004) {
      return 2;
    }
    if (bjxj.i()) {
      return 0;
    }
    return 1;
  }
  
  public ron A(int paramInt)
  {
    this.a.a("actual_width", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron B(int paramInt)
  {
    this.a.a("actual_height", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron C(int paramInt)
  {
    this.a.a("issued_width", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron D(int paramInt)
  {
    this.a.a("issued_height", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron E(int paramInt)
  {
    if (paramInt != -1) {
      this.a.a("replay", Integer.valueOf(paramInt));
    }
    return this;
  }
  
  public ron F(int paramInt)
  {
    this.a.a("first_video_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron G(int paramInt)
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
  
  public ron H(int paramInt)
  {
    rom localrom = this.a;
    if (paramInt == 0) {}
    for (String str = "MP4";; str = "HLS")
    {
      localrom.a("video_format", str);
      return this;
    }
  }
  
  public ron I(int paramInt)
  {
    this.a.a("video_chat_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron J(int paramInt)
  {
    this.a.a("video_kandian_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron K(int paramInt)
  {
    this.a.a("req_times", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron L(int paramInt)
  {
    this.a.a("first_video_channel_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron M(int paramInt)
  {
    this.a.a("first_video_short_video_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron N(int paramInt)
  {
    this.a.a("video_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron O(int paramInt)
  {
    this.a.a("entrance", Integer.valueOf(a(paramInt)));
    return this;
  }
  
  public ron P(int paramInt)
  {
    this.a.a("count", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron Q(int paramInt)
  {
    this.a.a("style", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron R(int paramInt)
  {
    this.a.a("click_area", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron S(int paramInt)
  {
    this.a.a("show_video_logo", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron T(int paramInt)
  {
    this.a.a("trigger_src", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron U(int paramInt)
  {
    this.a.a("diandianfeeds_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron V(int paramInt)
  {
    this.a.a("entrance_show_jump_icon", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron W(int paramInt)
  {
    this.a.a("feeds_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron X(int paramInt)
  {
    this.a.a("from_feedstype", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron Y(int paramInt)
  {
    this.a.a("cardbottom_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron Z(int paramInt)
  {
    this.a.a("topguide_bar", Integer.valueOf(paramInt));
    return this;
  }
  
  public rom a()
  {
    return this.a;
  }
  
  public ron a(int paramInt)
  {
    this.a.a("channel_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron a(long paramLong)
  {
    this.a.a("current_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public ron a(VideoInfo paramVideoInfo)
  {
    int j = 1;
    rom localrom = this.a;
    if (paramVideoInfo.jdField_n_of_type_Boolean)
    {
      i = 1;
      localrom.a("is_redpack", Integer.valueOf(i));
      this.a.a("redpack_style", Integer.valueOf(paramVideoInfo.jdField_n_of_type_Int));
      localrom = this.a;
      if (!paramVideoInfo.m) {
        break label77;
      }
    }
    label77:
    for (int i = j;; i = 0)
    {
      localrom.a("is_tips", Integer.valueOf(i));
      return this;
      i = 0;
      break;
    }
  }
  
  public ron a(BaseArticleInfo paramBaseArticleInfo)
  {
    rom localrom = this.a;
    if (paramBaseArticleInfo.isShowGif) {}
    for (int i = 1;; i = 0)
    {
      localrom.a("gif", Integer.valueOf(i));
      return this;
    }
  }
  
  public ron a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
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
      r(paramBaseArticleInfo);
      return this;
      paramBaseArticleInfo = paramBaseArticleInfo.mVideoColumnInfo.c;
      break;
    }
  }
  
  public ron a(VideoColumnInfo paramVideoColumnInfo)
  {
    int i = 1;
    if ((paramVideoColumnInfo != null) && (paramVideoColumnInfo.e == 1))
    {
      this.a.a("is_column", Integer.valueOf(1));
      this.a.a("column_id", Integer.valueOf(paramVideoColumnInfo.jdField_a_of_type_Int));
      rom localrom = this.a;
      if (paramVideoColumnInfo.jdField_a_of_type_Boolean) {}
      for (;;)
      {
        localrom.a("subscribe_flag", Integer.valueOf(i));
        return this;
        i = 0;
      }
    }
    this.a.a("is_column", Integer.valueOf(0));
    return this;
  }
  
  public ron a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue()) {
      this.a.a("is_ugc_as_pgc", Integer.valueOf(1));
    }
    return this;
  }
  
  public ron a(String paramString)
  {
    rom localrom = this.a;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localrom.a("video_report_info", str);
    return this;
  }
  
  public ron a(String paramString, Object paramObject)
  {
    this.a.a(paramString, paramObject);
    return this;
  }
  
  public ron a(ArrayList<DislikeInfo> paramArrayList)
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
    return k(localStringBuilder.toString());
  }
  
  public ron a(rkb paramrkb)
  {
    ron localron = this;
    if (paramrkb != null) {
      localron = d(paramrkb.a());
    }
    return localron;
  }
  
  public ron a(rkb paramrkb, long paramLong)
  {
    ron localron = this;
    if (paramrkb != null) {
      localron = c(paramrkb.a(paramLong));
    }
    return localron;
  }
  
  public ron a(boolean paramBoolean)
  {
    rom localrom = this.a;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localrom.a("download", Integer.valueOf(i));
      return this;
    }
  }
  
  public ron aa(int paramInt)
  {
    this.a.a("column_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron ab(int paramInt)
  {
    this.a.a("double_videocard_pos", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron ac(int paramInt)
  {
    this.a.a("video_autoplay", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron ad(int paramInt)
  {
    this.a.a("return_sence", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron b(int paramInt)
  {
    this.a.a("card_jump_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron b(long paramLong)
  {
    this.a.a("stay_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public ron b(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo != null) && (!TextUtils.isEmpty(paramBaseArticleInfo.mVideoLogoUrl)) && (rdm.d()))
    {
      this.a.a("show_video_logo", Integer.valueOf(1));
      return this;
    }
    this.a.a("show_video_logo", Integer.valueOf(0));
    return this;
  }
  
  public ron b(VideoColumnInfo paramVideoColumnInfo)
  {
    ron localron = this;
    if (paramVideoColumnInfo != null) {
      localron = aa(paramVideoColumnInfo.jdField_a_of_type_Int);
    }
    return localron;
  }
  
  public ron b(String paramString)
  {
    this.a.a("session_id", paramString);
    return this;
  }
  
  public ron b(boolean paramBoolean)
  {
    rom localrom = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localrom.a("interact_button_style", Integer.valueOf(i));
      return this;
    }
  }
  
  public ron c(int paramInt)
  {
    this.a.a("strategy_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron c(long paramLong)
  {
    this.a.a("video_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public ron c(BaseArticleInfo paramBaseArticleInfo)
  {
    ron localron = this;
    if (paramBaseArticleInfo != null)
    {
      localron = this;
      if (paramBaseArticleInfo.mChannelID == 56L)
      {
        localron = this;
        if (paramBaseArticleInfo.mVideoColumnInfo != null) {
          localron = b(paramBaseArticleInfo.mVideoColumnInfo);
        }
      }
    }
    return localron;
  }
  
  public ron c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.a("video_session_id", paramString);
    }
    return this;
  }
  
  public ron c(boolean paramBoolean)
  {
    this.a.a("video_inserted", Boolean.valueOf(paramBoolean));
    return this;
  }
  
  public ron d(int paramInt)
  {
    this.a.a("video_strategyid", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron d(long paramLong)
  {
    this.a.a("watch_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public ron d(BaseArticleInfo paramBaseArticleInfo)
  {
    int j = 1;
    int i = j;
    if (paramBaseArticleInfo != null)
    {
      i = j;
      if (paramBaseArticleInfo.mChannelID == 56L)
      {
        i = j;
        if (bjxj.d())
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
  
  public ron d(String paramString)
  {
    this.a.a("puin", paramString);
    return this;
  }
  
  public ron d(boolean paramBoolean)
  {
    rom localrom = this.a;
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      localrom.a("fans", str);
      return this;
    }
  }
  
  public ron e(int paramInt)
  {
    this.a.a("play_index", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron e(long paramLong)
  {
    this.a.a("algorithm_id", Long.valueOf(paramLong));
    return this;
  }
  
  public ron e(BaseArticleInfo paramBaseArticleInfo)
  {
    this.a.a("account_expose_card", Integer.valueOf(ors.c(paramBaseArticleInfo)));
    return this;
  }
  
  public ron e(String paramString)
  {
    this.a.a("vid", paramString);
    return this;
  }
  
  public ron e(boolean paramBoolean)
  {
    rom localrom = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localrom.a("is_ads", Integer.valueOf(i));
      return this;
    }
  }
  
  public ron f(int paramInt)
  {
    this.a.a("video_play_length", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron f(long paramLong)
  {
    this.a.a("video_play_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public ron f(BaseArticleInfo paramBaseArticleInfo)
  {
    if (qjv.a().a(paramBaseArticleInfo, false, qjv.jdField_a_of_type_Int)) {
      this.a.a("jump_src", Integer.valueOf(qjz.a(paramBaseArticleInfo)));
    }
    return this;
  }
  
  public ron f(String paramString)
  {
    this.a.a("aid", paramString);
    return this;
  }
  
  public ron f(boolean paramBoolean)
  {
    rom localrom = this.a;
    if (paramBoolean) {}
    for (String str = "H265";; str = "H264")
    {
      localrom.a("video_code_format", str);
      return this;
    }
  }
  
  public ron g(int paramInt)
  {
    this.a.a("from", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron g(long paramLong)
  {
    this.a.a("first_frame_time", Long.valueOf(paramLong));
    return this;
  }
  
  public ron g(String paramString)
  {
    this.a.a("first_video_rowkey", paramString);
    return this;
  }
  
  public ron g(boolean paramBoolean)
  {
    JSONObject localJSONObject = rom.a(this.a);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ntd.a(localJSONObject, i);
      return this;
    }
  }
  
  public ron h(int paramInt)
  {
    this.a.a("jump_to_channel", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron h(long paramLong)
  {
    this.a.a("first_video_algorithm_id", Long.valueOf(paramLong));
    return this;
  }
  
  public ron h(String paramString)
  {
    this.a.a("rowkey", paramString);
    return this;
  }
  
  public ron h(boolean paramBoolean)
  {
    rom localrom = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localrom.a("action_type", Integer.valueOf(i));
      return this;
    }
  }
  
  public ron i(int paramInt)
  {
    this.a.a("oper_time", Long.valueOf(System.currentTimeMillis()));
    this.a.a("company_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron i(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.a("error_code", paramString);
    }
    return this;
  }
  
  public ron i(boolean paramBoolean)
  {
    rom localrom = this.a;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localrom.a("outcome", Integer.valueOf(i));
      return this;
    }
  }
  
  public ron j(int paramInt)
  {
    this.a.a("ads_jump", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron j(String paramString)
  {
    this.a.a("video_to_uin", paramString);
    return this;
  }
  
  public ron j(boolean paramBoolean)
  {
    rom localrom = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localrom.a("loophole", Integer.valueOf(i));
      return this;
    }
  }
  
  public ron k(int paramInt)
  {
    this.a.a("ads_source", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron k(String paramString)
  {
    this.a.a("neg_reason", paramString);
    return this;
  }
  
  public ron k(boolean paramBoolean)
  {
    rom localrom = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localrom.a("is_insertion", Integer.valueOf(i));
      return this;
    }
  }
  
  public ron l(int paramInt)
  {
    this.a.a("video_index", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron l(String paramString)
  {
    this.a.a("uin", paramString);
    return this;
  }
  
  public ron l(boolean paramBoolean)
  {
    rom localrom = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localrom.a("ad_guide_area", Integer.valueOf(i));
      return this;
    }
  }
  
  public ron m(int paramInt)
  {
    this.a.a("transverse_index", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron m(String paramString)
  {
    this.a.a("trigger_rowkey", paramString);
    return this;
  }
  
  public ron n(int paramInt)
  {
    this.a.a("content_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron n(String paramString)
  {
    this.a.a("from_rk", paramString);
    return this;
  }
  
  public ron o(int paramInt)
  {
    this.a.a("slide_exit", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron o(String paramString)
  {
    this.a.a("cardbottom_video_report_info", paramString);
    return this;
  }
  
  public ron p(int paramInt)
  {
    this.a.a("kandian_mode_new", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron p(String paramString)
  {
    this.a.a("topguide_bar_video_report_info", paramString);
    return this;
  }
  
  public ron q(int paramInt)
  {
    this.a.a("kandian_mode", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron q(String paramString)
  {
    this.a.a("ad_guide_area_video_report_info", paramString);
    return this;
  }
  
  public ron r(int paramInt)
  {
    this.a.a("item_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron r(String paramString)
  {
    this.a.a("jump_report_info", paramString);
    return this;
  }
  
  public ron s(int paramInt)
  {
    this.a.a("play_num", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron s(String paramString)
  {
    this.a.a("double_videocard_jump_page", paramString);
    return this;
  }
  
  public ron t(int paramInt)
  {
    this.a.a("topic_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron t(String paramString)
  {
    this.a.a("double_videocard_jump_src", paramString);
    return this;
  }
  
  public ron u(int paramInt)
  {
    this.a.a("jump_to", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron u(String paramString)
  {
    this.a.a("subscript", paramString);
    return this;
  }
  
  public ron v(int paramInt)
  {
    this.a.a("video_from_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron w(int paramInt)
  {
    if (paramInt != -1) {
      this.a.a("source", Integer.valueOf(paramInt));
    }
    return this;
  }
  
  public ron x(int paramInt)
  {
    this.a.a("card_pos", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron y(int paramInt)
  {
    this.a.a("is_loop", Integer.valueOf(paramInt));
    return this;
  }
  
  public ron z(int paramInt)
  {
    this.a.a("loop_times", Integer.valueOf(paramInt));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ron
 * JD-Core Version:    0.7.0.1
 */