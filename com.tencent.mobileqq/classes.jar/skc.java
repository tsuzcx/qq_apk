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
import org.json.JSONObject;

public final class skc
{
  private final skb a;
  
  public skc(VideoInfo paramVideoInfo)
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
      this.a = new skb(localObject2, str1, paramVideoInfo, (String)localObject1);
      return;
      paramVideoInfo = null;
      str1 = null;
      localObject2 = null;
    }
  }
  
  public skc(String paramString)
  {
    this.a = new skb(paramString);
  }
  
  public skc(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a = new skb(paramString1, paramString2, paramString3, paramString4);
  }
  
  public skc(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2)
  {
    this.a = new skb(paramString1, paramString2, paramString3, paramString4);
    a(paramLong1).c(paramLong2);
  }
  
  public skc(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = new skb(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == 1004) {
      return 2;
    }
    if (bmqa.h()) {
      return 0;
    }
    return 1;
  }
  
  public skc A(int paramInt)
  {
    this.a.a("actual_width", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc B(int paramInt)
  {
    this.a.a("actual_height", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc C(int paramInt)
  {
    this.a.a("issued_width", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc D(int paramInt)
  {
    this.a.a("issued_height", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc E(int paramInt)
  {
    if (paramInt != -1) {
      this.a.a("replay", Integer.valueOf(paramInt));
    }
    return this;
  }
  
  public skc F(int paramInt)
  {
    this.a.a("first_video_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc G(int paramInt)
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
  
  public skc H(int paramInt)
  {
    skb localskb = this.a;
    if (paramInt == 0) {}
    for (String str = "MP4";; str = "HLS")
    {
      localskb.a("video_format", str);
      return this;
    }
  }
  
  public skc I(int paramInt)
  {
    this.a.a("video_chat_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc J(int paramInt)
  {
    this.a.a("video_kandian_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc K(int paramInt)
  {
    this.a.a("req_times", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc L(int paramInt)
  {
    this.a.a("first_video_channel_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc M(int paramInt)
  {
    this.a.a("first_video_short_video_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc N(int paramInt)
  {
    this.a.a("video_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc O(int paramInt)
  {
    this.a.a("entrance", Integer.valueOf(a(paramInt)));
    return this;
  }
  
  public skc P(int paramInt)
  {
    this.a.a("count", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc Q(int paramInt)
  {
    this.a.a("style", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc R(int paramInt)
  {
    this.a.a("click_area", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc S(int paramInt)
  {
    this.a.a("show_video_logo", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc T(int paramInt)
  {
    this.a.a("trigger_src", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc U(int paramInt)
  {
    this.a.a("diandianfeeds_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc V(int paramInt)
  {
    this.a.a("entrance_show_jump_icon", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc W(int paramInt)
  {
    this.a.a("feeds_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc X(int paramInt)
  {
    this.a.a("from_feedstype", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc Y(int paramInt)
  {
    this.a.a("column_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc Z(int paramInt)
  {
    this.a.a("double_videocard_pos", Integer.valueOf(paramInt));
    return this;
  }
  
  public skb a()
  {
    return this.a;
  }
  
  public skc a()
  {
    skb localskb = this.a;
    int i;
    if (pha.d()) {
      i = 2;
    }
    for (;;)
    {
      localskb.a("app_type", Integer.valueOf(i));
      return this;
      if (pha.x()) {
        i = 1;
      } else {
        i = 3;
      }
    }
  }
  
  public skc a(float paramFloat)
  {
    this.a.a("video_speed", Float.valueOf(paramFloat));
    return this;
  }
  
  public skc a(int paramInt)
  {
    this.a.a("channel_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc a(int paramInt, String paramString)
  {
    if (paramInt == 124) {
      this.a.a("column_play_session_id", paramString);
    }
    return this;
  }
  
  public skc a(long paramLong)
  {
    this.a.a("current_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public skc a(VideoInfo.SoftAdDownloadBarInfo paramSoftAdDownloadBarInfo)
  {
    skb localskb = this.a;
    if ((paramSoftAdDownloadBarInfo != null) && (paramSoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null)) {}
    for (paramSoftAdDownloadBarInfo = paramSoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;; paramSoftAdDownloadBarInfo = "")
    {
      localskb.a("ad_guide_area_video_report_info", paramSoftAdDownloadBarInfo);
      return this;
    }
  }
  
  public skc a(VideoInfo paramVideoInfo)
  {
    skb localskb = this.a;
    if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) {}
    for (int i = 1;; i = 0)
    {
      localskb.a("ad_guide_area", Integer.valueOf(i));
      return this;
    }
  }
  
  public skc a(BaseArticleInfo paramBaseArticleInfo)
  {
    skb localskb = this.a;
    if (paramBaseArticleInfo.isShowGif) {}
    for (int i = 1;; i = 0)
    {
      localskb.a("gif", Integer.valueOf(i));
      return this;
    }
  }
  
  public skc a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
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
      o(paramBaseArticleInfo);
      return this;
      paramBaseArticleInfo = paramBaseArticleInfo.mVideoColumnInfo.c;
      break;
    }
  }
  
  public skc a(VideoColumnInfo paramVideoColumnInfo)
  {
    int i = 1;
    if (paramVideoColumnInfo != null)
    {
      this.a.a("is_column", Integer.valueOf(1));
      this.a.a("column_id", Integer.valueOf(paramVideoColumnInfo.jdField_a_of_type_Int));
      skb localskb = this.a;
      if (paramVideoColumnInfo.jdField_a_of_type_Boolean) {}
      for (;;)
      {
        localskb.a("subscribe_flag", Integer.valueOf(i));
        return this;
        i = 0;
      }
    }
    this.a.a("is_column", Integer.valueOf(0));
    return this;
  }
  
  public skc a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue()) {
      this.a.a("is_ugc_as_pgc", Integer.valueOf(1));
    }
    return this;
  }
  
  public skc a(String paramString)
  {
    skb localskb = this.a;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localskb.a("video_report_info", str);
    return this;
  }
  
  public skc a(String paramString, Object paramObject)
  {
    this.a.a(paramString, paramObject);
    return this;
  }
  
  public skc a(ArrayList<DislikeInfo> paramArrayList)
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
  
  public skc a(sfn paramsfn)
  {
    skc localskc = this;
    if (paramsfn != null) {
      localskc = d(paramsfn.a());
    }
    return localskc;
  }
  
  public skc a(sfn paramsfn, long paramLong)
  {
    skc localskc = this;
    if (paramsfn != null) {
      localskc = c(paramsfn.a(paramLong));
    }
    return localskc;
  }
  
  public skc a(boolean paramBoolean)
  {
    skb localskb = this.a;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localskb.a("download", Integer.valueOf(i));
      return this;
    }
  }
  
  public skc aa(int paramInt)
  {
    this.a.a("video_autoplay", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc ab(int paramInt)
  {
    this.a.a("subscribe_page", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc ac(int paramInt)
  {
    this.a.a("return_sence", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc b(int paramInt)
  {
    this.a.a("card_jump_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc b(long paramLong)
  {
    this.a.a("stay_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public skc b(VideoInfo paramVideoInfo)
  {
    int j = 1;
    skb localskb = this.a;
    if (paramVideoInfo.n)
    {
      i = 1;
      localskb.a("is_redpack", Integer.valueOf(i));
      this.a.a("redpack_style", Integer.valueOf(paramVideoInfo.o));
      localskb = this.a;
      if (!paramVideoInfo.m) {
        break label80;
      }
    }
    label80:
    for (int i = j;; i = 0)
    {
      localskb.a("is_tips", Integer.valueOf(i));
      return this;
      i = 0;
      break;
    }
  }
  
  public skc b(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo != null) && (!TextUtils.isEmpty(paramBaseArticleInfo.mVideoLogoUrl)) && (ryx.d()))
    {
      this.a.a("show_video_logo", Integer.valueOf(1));
      return this;
    }
    this.a.a("show_video_logo", Integer.valueOf(0));
    return this;
  }
  
  public skc b(VideoColumnInfo paramVideoColumnInfo)
  {
    skc localskc = this;
    if (paramVideoColumnInfo != null) {
      localskc = Y(paramVideoColumnInfo.jdField_a_of_type_Int);
    }
    return localskc;
  }
  
  public skc b(String paramString)
  {
    this.a.a("session_id", paramString);
    return this;
  }
  
  public skc b(boolean paramBoolean)
  {
    skb localskb = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localskb.a("interact_button_style", Integer.valueOf(i));
      return this;
    }
  }
  
  public skc c(int paramInt)
  {
    this.a.a("strategy_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc c(long paramLong)
  {
    this.a.a("video_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public skc c(BaseArticleInfo paramBaseArticleInfo)
  {
    skc localskc = this;
    if (paramBaseArticleInfo != null)
    {
      localskc = this;
      if (paramBaseArticleInfo.mChannelID == 56L)
      {
        localskc = this;
        if (paramBaseArticleInfo.mVideoColumnInfo != null) {
          localskc = b(paramBaseArticleInfo.mVideoColumnInfo);
        }
      }
    }
    return localskc;
  }
  
  public skc c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.a("video_session_id", paramString);
    }
    return this;
  }
  
  public skc c(boolean paramBoolean)
  {
    this.a.a("video_inserted", Boolean.valueOf(paramBoolean));
    return this;
  }
  
  public skc d(int paramInt)
  {
    this.a.a("video_strategyid", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc d(long paramLong)
  {
    this.a.a("watch_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public skc d(BaseArticleInfo paramBaseArticleInfo)
  {
    int j = 1;
    int i = j;
    if (paramBaseArticleInfo != null)
    {
      i = j;
      if (paramBaseArticleInfo.mChannelID == 56L)
      {
        i = j;
        if (bmqa.e())
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
  
  public skc d(String paramString)
  {
    this.a.a("puin", paramString);
    return this;
  }
  
  public skc d(boolean paramBoolean)
  {
    skb localskb = this.a;
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      localskb.a("fans", str);
      return this;
    }
  }
  
  public skc e(int paramInt)
  {
    this.a.a("play_index", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc e(long paramLong)
  {
    this.a.a("algorithm_id", Long.valueOf(paramLong));
    return this;
  }
  
  public skc e(BaseArticleInfo paramBaseArticleInfo)
  {
    this.a.a("account_expose_card", Integer.valueOf(pha.c(paramBaseArticleInfo)));
    return this;
  }
  
  public skc e(String paramString)
  {
    this.a.a("vid", paramString);
    return this;
  }
  
  public skc e(boolean paramBoolean)
  {
    skb localskb = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localskb.a("is_ads", Integer.valueOf(i));
      return this;
    }
  }
  
  public skc f(int paramInt)
  {
    this.a.a("video_play_length", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc f(long paramLong)
  {
    this.a.a("video_play_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public skc f(BaseArticleInfo paramBaseArticleInfo)
  {
    if (rdy.a().a(paramBaseArticleInfo, false, rdy.jdField_a_of_type_Int)) {
      this.a.a("jump_src", Integer.valueOf(rec.a(paramBaseArticleInfo)));
    }
    return this;
  }
  
  public skc f(String paramString)
  {
    this.a.a("aid", paramString);
    return this;
  }
  
  public skc f(boolean paramBoolean)
  {
    skb localskb = this.a;
    if (paramBoolean) {}
    for (String str = "H265";; str = "H264")
    {
      localskb.a("video_code_format", str);
      return this;
    }
  }
  
  public skc g(int paramInt)
  {
    this.a.a("from", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc g(long paramLong)
  {
    this.a.a("first_frame_time", Long.valueOf(paramLong));
    return this;
  }
  
  public skc g(String paramString)
  {
    this.a.a("first_video_rowkey", paramString);
    return this;
  }
  
  public skc g(boolean paramBoolean)
  {
    JSONObject localJSONObject = skb.a(this.a);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      och.a(localJSONObject, i);
      return this;
    }
  }
  
  public skc h(int paramInt)
  {
    this.a.a("jump_to_channel", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc h(long paramLong)
  {
    this.a.a("first_video_algorithm_id", Long.valueOf(paramLong));
    return this;
  }
  
  public skc h(String paramString)
  {
    this.a.a("rowkey", paramString);
    return this;
  }
  
  public skc h(boolean paramBoolean)
  {
    skb localskb = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localskb.a("action_type", Integer.valueOf(i));
      return this;
    }
  }
  
  public skc i(int paramInt)
  {
    this.a.a("oper_time", Long.valueOf(System.currentTimeMillis()));
    this.a.a("company_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc i(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.a("error_code", paramString);
    }
    return this;
  }
  
  public skc i(boolean paramBoolean)
  {
    skb localskb = this.a;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localskb.a("outcome", Integer.valueOf(i));
      return this;
    }
  }
  
  public skc j(int paramInt)
  {
    this.a.a("ads_jump", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc j(String paramString)
  {
    this.a.a("video_to_uin", paramString);
    return this;
  }
  
  public skc j(boolean paramBoolean)
  {
    skb localskb = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localskb.a("loophole", Integer.valueOf(i));
      return this;
    }
  }
  
  public skc k(int paramInt)
  {
    this.a.a("ads_source", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc k(String paramString)
  {
    this.a.a("neg_reason", paramString);
    return this;
  }
  
  public skc k(boolean paramBoolean)
  {
    skb localskb = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localskb.a("is_insertion", Integer.valueOf(i));
      return this;
    }
  }
  
  public skc l(int paramInt)
  {
    this.a.a("video_index", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc l(String paramString)
  {
    this.a.a("uin", paramString);
    return this;
  }
  
  public skc l(boolean paramBoolean)
  {
    skb localskb = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localskb.a("video_speed_icon", Integer.valueOf(i));
      return this;
    }
  }
  
  public skc m(int paramInt)
  {
    this.a.a("transverse_index", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc m(String paramString)
  {
    this.a.a("trigger_rowkey", paramString);
    return this;
  }
  
  public skc n(int paramInt)
  {
    this.a.a("content_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc n(String paramString)
  {
    this.a.a("from_rk", paramString);
    return this;
  }
  
  public skc o(int paramInt)
  {
    this.a.a("slide_exit", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc o(String paramString)
  {
    this.a.a("jump_report_info", paramString);
    return this;
  }
  
  public skc p(int paramInt)
  {
    this.a.a("kandian_mode_new", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc p(String paramString)
  {
    this.a.a("double_videocard_jump_page", paramString);
    return this;
  }
  
  public skc q(int paramInt)
  {
    this.a.a("kandian_mode", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc q(String paramString)
  {
    this.a.a("double_videocard_jump_src", paramString);
    return this;
  }
  
  public skc r(int paramInt)
  {
    this.a.a("item_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc r(String paramString)
  {
    this.a.a("subscript", paramString);
    return this;
  }
  
  public skc s(int paramInt)
  {
    this.a.a("play_num", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc t(int paramInt)
  {
    this.a.a("topic_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc u(int paramInt)
  {
    this.a.a("jump_to", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc v(int paramInt)
  {
    this.a.a("video_from_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc w(int paramInt)
  {
    if (paramInt != -1) {
      this.a.a("source", Integer.valueOf(paramInt));
    }
    return this;
  }
  
  public skc x(int paramInt)
  {
    this.a.a("card_pos", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc y(int paramInt)
  {
    this.a.a("is_loop", Integer.valueOf(paramInt));
    return this;
  }
  
  public skc z(int paramInt)
  {
    this.a.a("loop_times", Integer.valueOf(paramInt));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     skc
 * JD-Core Version:    0.7.0.1
 */