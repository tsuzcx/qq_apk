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

public final class qze
{
  private final qzd a;
  
  public qze(VideoInfo paramVideoInfo)
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
      this.a = new qzd(localObject2, str1, paramVideoInfo, (String)localObject1);
      return;
      paramVideoInfo = null;
      str1 = null;
      localObject2 = null;
    }
  }
  
  public qze(String paramString)
  {
    this.a = new qzd(paramString);
  }
  
  public qze(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a = new qzd(paramString1, paramString2, paramString3, paramString4);
  }
  
  public qze(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2)
  {
    this.a = new qzd(paramString1, paramString2, paramString3, paramString4);
    a(paramLong1).c(paramLong2);
  }
  
  public qze(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = new qzd(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == 1004) {
      return 2;
    }
    if (bhvh.i()) {
      return 0;
    }
    return 1;
  }
  
  public qze A(int paramInt)
  {
    this.a.a("loop_times", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze B(int paramInt)
  {
    this.a.a("actual_width", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze C(int paramInt)
  {
    this.a.a("actual_height", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze D(int paramInt)
  {
    this.a.a("issued_width", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze E(int paramInt)
  {
    this.a.a("issued_height", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze F(int paramInt)
  {
    if (paramInt != -1) {
      this.a.a("replay", Integer.valueOf(paramInt));
    }
    return this;
  }
  
  public qze G(int paramInt)
  {
    this.a.a("first_video_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze H(int paramInt)
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
  
  public qze I(int paramInt)
  {
    qzd localqzd = this.a;
    if (paramInt == 0) {}
    for (String str = "MP4";; str = "HLS")
    {
      localqzd.a("video_format", str);
      return this;
    }
  }
  
  public qze J(int paramInt)
  {
    this.a.a("video_chat_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze K(int paramInt)
  {
    this.a.a("video_kandian_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze L(int paramInt)
  {
    this.a.a("req_times", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze M(int paramInt)
  {
    this.a.a("first_video_channel_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze N(int paramInt)
  {
    this.a.a("first_video_short_video_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze O(int paramInt)
  {
    this.a.a("video_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze P(int paramInt)
  {
    this.a.a("entrance", Integer.valueOf(a(paramInt)));
    return this;
  }
  
  public qze Q(int paramInt)
  {
    this.a.a("count", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze R(int paramInt)
  {
    this.a.a("style", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze S(int paramInt)
  {
    this.a.a("click_area", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze T(int paramInt)
  {
    this.a.a("show_video_logo", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze U(int paramInt)
  {
    this.a.a("trigger_src", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze V(int paramInt)
  {
    this.a.a("diandianfeeds_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze W(int paramInt)
  {
    this.a.a("entrance_show_jump_icon", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze X(int paramInt)
  {
    this.a.a("feeds_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze Y(int paramInt)
  {
    this.a.a("from_feedstype", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze Z(int paramInt)
  {
    this.a.a("cardbottom_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzd a()
  {
    return this.a;
  }
  
  public qze a(int paramInt)
  {
    this.a.a("channel_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze a(long paramLong)
  {
    this.a.a("current_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public qze a(BaseArticleInfo paramBaseArticleInfo)
  {
    qzd localqzd = this.a;
    if (paramBaseArticleInfo.isShowGif) {}
    for (int i = 1;; i = 0)
    {
      localqzd.a("gif", Integer.valueOf(i));
      return this;
    }
  }
  
  public qze a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
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
  
  public qze a(VideoColumnInfo paramVideoColumnInfo)
  {
    qze localqze = this;
    if (paramVideoColumnInfo != null) {
      localqze = ab(paramVideoColumnInfo.jdField_a_of_type_Int);
    }
    return localqze;
  }
  
  public qze a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue()) {
      this.a.a("is_ugc_as_pgc", Integer.valueOf(1));
    }
    return this;
  }
  
  public qze a(String paramString)
  {
    qzd localqzd = this.a;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localqzd.a("video_report_info", str);
    return this;
  }
  
  public qze a(String paramString, Object paramObject)
  {
    this.a.a(paramString, paramObject);
    return this;
  }
  
  public qze a(ArrayList<DislikeInfo> paramArrayList)
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
  
  public qze a(qup paramqup)
  {
    qze localqze = this;
    if (paramqup != null) {
      localqze = e(paramqup.a());
    }
    return localqze;
  }
  
  public qze a(qup paramqup, long paramLong)
  {
    qze localqze = this;
    if (paramqup != null) {
      localqze = b(paramqup.a(paramLong));
    }
    return localqze;
  }
  
  public qze a(boolean paramBoolean)
  {
    qzd localqzd = this.a;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localqzd.a("download", Integer.valueOf(i));
      return this;
    }
  }
  
  public qze aa(int paramInt)
  {
    this.a.a("topguide_bar", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze ab(int paramInt)
  {
    this.a.a("column_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze ac(int paramInt)
  {
    this.a.a("double_videocard_pos", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze ad(int paramInt)
  {
    this.a.a("video_autoplay", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze b(int paramInt)
  {
    this.a.a("card_jump_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze b(long paramLong)
  {
    this.a.a("stay_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public qze b(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo != null) && (!TextUtils.isEmpty(paramBaseArticleInfo.mVideoLogoUrl)) && (qol.d()))
    {
      this.a.a("show_video_logo", Integer.valueOf(1));
      return this;
    }
    this.a.a("show_video_logo", Integer.valueOf(0));
    return this;
  }
  
  public qze b(String paramString)
  {
    this.a.a("session_id", paramString);
    return this;
  }
  
  public qze b(boolean paramBoolean)
  {
    this.a.a("video_inserted", Boolean.valueOf(paramBoolean));
    return this;
  }
  
  public qze c(int paramInt)
  {
    this.a.a("interact_button_style", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze c(long paramLong)
  {
    this.a.a("video_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public qze c(BaseArticleInfo paramBaseArticleInfo)
  {
    qze localqze = this;
    if (paramBaseArticleInfo != null)
    {
      localqze = this;
      if (paramBaseArticleInfo.mChannelID == 56L)
      {
        localqze = this;
        if (paramBaseArticleInfo.mVideoColumnInfo != null) {
          localqze = a(paramBaseArticleInfo.mVideoColumnInfo);
        }
      }
    }
    return localqze;
  }
  
  public qze c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.a("video_session_id", paramString);
    }
    return this;
  }
  
  public qze c(boolean paramBoolean)
  {
    qzd localqzd = this.a;
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      localqzd.a("fans", str);
      return this;
    }
  }
  
  public qze d(int paramInt)
  {
    this.a.a("strategy_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze d(long paramLong)
  {
    this.a.a("watch_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public qze d(BaseArticleInfo paramBaseArticleInfo)
  {
    int j = 1;
    int i = j;
    if (paramBaseArticleInfo != null)
    {
      i = j;
      if (paramBaseArticleInfo.mChannelID == 56L)
      {
        i = j;
        if (bhvh.d())
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
  
  public qze d(String paramString)
  {
    this.a.a("puin", paramString);
    return this;
  }
  
  public qze d(boolean paramBoolean)
  {
    qzd localqzd = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localqzd.a("is_ads", Integer.valueOf(i));
      return this;
    }
  }
  
  public qze e(int paramInt)
  {
    this.a.a("video_strategyid", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze e(long paramLong)
  {
    this.a.a("algorithm_id", Long.valueOf(paramLong));
    return this;
  }
  
  public qze e(BaseArticleInfo paramBaseArticleInfo)
  {
    this.a.a("account_expose_card", Integer.valueOf(onk.c(paramBaseArticleInfo)));
    return this;
  }
  
  public qze e(String paramString)
  {
    this.a.a("vid", paramString);
    return this;
  }
  
  public qze e(boolean paramBoolean)
  {
    qzd localqzd = this.a;
    if (paramBoolean) {}
    for (String str = "H265";; str = "H264")
    {
      localqzd.a("video_code_format", str);
      return this;
    }
  }
  
  public qze f(int paramInt)
  {
    this.a.a("play_index", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze f(long paramLong)
  {
    this.a.a("video_play_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public qze f(BaseArticleInfo paramBaseArticleInfo)
  {
    if (qad.a().a(paramBaseArticleInfo, false, qad.jdField_a_of_type_Int)) {
      this.a.a("jump_src", Integer.valueOf(qah.a(paramBaseArticleInfo)));
    }
    return this;
  }
  
  public qze f(String paramString)
  {
    this.a.a("aid", paramString);
    return this;
  }
  
  public qze f(boolean paramBoolean)
  {
    JSONObject localJSONObject = qzd.a(this.a);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      npx.a(localJSONObject, i);
      return this;
    }
  }
  
  public qze g(int paramInt)
  {
    this.a.a("video_play_length", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze g(long paramLong)
  {
    this.a.a("first_frame_time", Long.valueOf(paramLong));
    return this;
  }
  
  public qze g(String paramString)
  {
    this.a.a("first_video_rowkey", paramString);
    return this;
  }
  
  public qze g(boolean paramBoolean)
  {
    qzd localqzd = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localqzd.a("action_type", Integer.valueOf(i));
      return this;
    }
  }
  
  public qze h(int paramInt)
  {
    this.a.a("from", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze h(long paramLong)
  {
    this.a.a("first_video_algorithm_id", Long.valueOf(paramLong));
    return this;
  }
  
  public qze h(String paramString)
  {
    this.a.a("rowkey", paramString);
    return this;
  }
  
  public qze h(boolean paramBoolean)
  {
    qzd localqzd = this.a;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localqzd.a("outcome", Integer.valueOf(i));
      return this;
    }
  }
  
  public qze i(int paramInt)
  {
    this.a.a("jump_to_channel", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze i(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.a("error_code", paramString);
    }
    return this;
  }
  
  public qze i(boolean paramBoolean)
  {
    qzd localqzd = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localqzd.a("loophole", Integer.valueOf(i));
      return this;
    }
  }
  
  public qze j(int paramInt)
  {
    this.a.a("oper_time", Long.valueOf(System.currentTimeMillis()));
    this.a.a("company_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze j(String paramString)
  {
    this.a.a("video_to_uin", paramString);
    return this;
  }
  
  public qze j(boolean paramBoolean)
  {
    qzd localqzd = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localqzd.a("is_insertion", Integer.valueOf(i));
      return this;
    }
  }
  
  public qze k(int paramInt)
  {
    this.a.a("ads_jump", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze k(String paramString)
  {
    this.a.a("neg_reason", paramString);
    return this;
  }
  
  public qze k(boolean paramBoolean)
  {
    qzd localqzd = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localqzd.a("ad_guide_area", Integer.valueOf(i));
      return this;
    }
  }
  
  public qze l(int paramInt)
  {
    this.a.a("ads_source", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze l(String paramString)
  {
    this.a.a("uin", paramString);
    return this;
  }
  
  public qze m(int paramInt)
  {
    this.a.a("video_index", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze m(String paramString)
  {
    this.a.a("trigger_rowkey", paramString);
    return this;
  }
  
  public qze n(int paramInt)
  {
    this.a.a("transverse_index", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze n(String paramString)
  {
    this.a.a("from_rk", paramString);
    return this;
  }
  
  public qze o(int paramInt)
  {
    this.a.a("content_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze o(String paramString)
  {
    this.a.a("cardbottom_video_report_info", paramString);
    return this;
  }
  
  public qze p(int paramInt)
  {
    this.a.a("slide_exit", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze p(String paramString)
  {
    this.a.a("topguide_bar_video_report_info", paramString);
    return this;
  }
  
  public qze q(int paramInt)
  {
    this.a.a("kandian_mode_new", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze q(String paramString)
  {
    this.a.a("ad_guide_area_video_report_info", paramString);
    return this;
  }
  
  public qze r(int paramInt)
  {
    this.a.a("kandian_mode", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze r(String paramString)
  {
    this.a.a("jump_report_info", paramString);
    return this;
  }
  
  public qze s(int paramInt)
  {
    this.a.a("item_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze s(String paramString)
  {
    this.a.a("double_videocard_jump_page", paramString);
    return this;
  }
  
  public qze t(int paramInt)
  {
    this.a.a("play_num", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze t(String paramString)
  {
    this.a.a("double_videocard_jump_src", paramString);
    return this;
  }
  
  public qze u(int paramInt)
  {
    this.a.a("topic_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze u(String paramString)
  {
    this.a.a("subscript", paramString);
    return this;
  }
  
  public qze v(int paramInt)
  {
    this.a.a("jump_to", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze w(int paramInt)
  {
    this.a.a("video_from_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze x(int paramInt)
  {
    if (paramInt != -1) {
      this.a.a("source", Integer.valueOf(paramInt));
    }
    return this;
  }
  
  public qze y(int paramInt)
  {
    this.a.a("card_pos", Integer.valueOf(paramInt));
    return this;
  }
  
  public qze z(int paramInt)
  {
    this.a.a("is_loop", Integer.valueOf(paramInt));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qze
 * JD-Core Version:    0.7.0.1
 */