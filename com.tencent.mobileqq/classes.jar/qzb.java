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

public final class qzb
{
  private final qza a;
  
  public qzb(VideoInfo paramVideoInfo)
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
      this.a = new qza(localObject2, str1, paramVideoInfo, (String)localObject1);
      return;
      paramVideoInfo = null;
      str1 = null;
      localObject2 = null;
    }
  }
  
  public qzb(String paramString)
  {
    this.a = new qza(paramString);
  }
  
  public qzb(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a = new qza(paramString1, paramString2, paramString3, paramString4);
  }
  
  public qzb(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2)
  {
    this.a = new qza(paramString1, paramString2, paramString3, paramString4);
    a(paramLong1).c(paramLong2);
  }
  
  public qzb(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = new qza(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == 1004) {
      return 2;
    }
    if (bhvy.i()) {
      return 0;
    }
    return 1;
  }
  
  public qzb A(int paramInt)
  {
    this.a.a("loop_times", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb B(int paramInt)
  {
    this.a.a("actual_width", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb C(int paramInt)
  {
    this.a.a("actual_height", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb D(int paramInt)
  {
    this.a.a("issued_width", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb E(int paramInt)
  {
    this.a.a("issued_height", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb F(int paramInt)
  {
    if (paramInt != -1) {
      this.a.a("replay", Integer.valueOf(paramInt));
    }
    return this;
  }
  
  public qzb G(int paramInt)
  {
    this.a.a("first_video_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb H(int paramInt)
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
  
  public qzb I(int paramInt)
  {
    qza localqza = this.a;
    if (paramInt == 0) {}
    for (String str = "MP4";; str = "HLS")
    {
      localqza.a("video_format", str);
      return this;
    }
  }
  
  public qzb J(int paramInt)
  {
    this.a.a("video_chat_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb K(int paramInt)
  {
    this.a.a("video_kandian_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb L(int paramInt)
  {
    this.a.a("req_times", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb M(int paramInt)
  {
    this.a.a("first_video_channel_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb N(int paramInt)
  {
    this.a.a("first_video_short_video_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb O(int paramInt)
  {
    this.a.a("video_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb P(int paramInt)
  {
    this.a.a("entrance", Integer.valueOf(a(paramInt)));
    return this;
  }
  
  public qzb Q(int paramInt)
  {
    this.a.a("count", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb R(int paramInt)
  {
    this.a.a("style", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb S(int paramInt)
  {
    this.a.a("click_area", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb T(int paramInt)
  {
    this.a.a("show_video_logo", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb U(int paramInt)
  {
    this.a.a("trigger_src", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb V(int paramInt)
  {
    this.a.a("diandianfeeds_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb W(int paramInt)
  {
    this.a.a("entrance_show_jump_icon", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb X(int paramInt)
  {
    this.a.a("feeds_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb Y(int paramInt)
  {
    this.a.a("from_feedstype", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb Z(int paramInt)
  {
    this.a.a("cardbottom_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qza a()
  {
    return this.a;
  }
  
  public qzb a(int paramInt)
  {
    this.a.a("channel_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb a(long paramLong)
  {
    this.a.a("current_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public qzb a(BaseArticleInfo paramBaseArticleInfo)
  {
    qza localqza = this.a;
    if (paramBaseArticleInfo.isShowGif) {}
    for (int i = 1;; i = 0)
    {
      localqza.a("gif", Integer.valueOf(i));
      return this;
    }
  }
  
  public qzb a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
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
  
  public qzb a(VideoColumnInfo paramVideoColumnInfo)
  {
    qzb localqzb = this;
    if (paramVideoColumnInfo != null) {
      localqzb = ab(paramVideoColumnInfo.jdField_a_of_type_Int);
    }
    return localqzb;
  }
  
  public qzb a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue()) {
      this.a.a("is_ugc_as_pgc", Integer.valueOf(1));
    }
    return this;
  }
  
  public qzb a(String paramString)
  {
    qza localqza = this.a;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localqza.a("video_report_info", str);
    return this;
  }
  
  public qzb a(String paramString, Object paramObject)
  {
    this.a.a(paramString, paramObject);
    return this;
  }
  
  public qzb a(ArrayList<DislikeInfo> paramArrayList)
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
  
  public qzb a(qum paramqum)
  {
    qzb localqzb = this;
    if (paramqum != null) {
      localqzb = e(paramqum.a());
    }
    return localqzb;
  }
  
  public qzb a(qum paramqum, long paramLong)
  {
    qzb localqzb = this;
    if (paramqum != null) {
      localqzb = b(paramqum.a(paramLong));
    }
    return localqzb;
  }
  
  public qzb a(boolean paramBoolean)
  {
    qza localqza = this.a;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localqza.a("download", Integer.valueOf(i));
      return this;
    }
  }
  
  public qzb aa(int paramInt)
  {
    this.a.a("topguide_bar", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb ab(int paramInt)
  {
    this.a.a("column_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb ac(int paramInt)
  {
    this.a.a("double_videocard_pos", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb ad(int paramInt)
  {
    this.a.a("video_autoplay", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb b(int paramInt)
  {
    this.a.a("card_jump_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb b(long paramLong)
  {
    this.a.a("stay_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public qzb b(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo != null) && (!TextUtils.isEmpty(paramBaseArticleInfo.mVideoLogoUrl)) && (qoi.d()))
    {
      this.a.a("show_video_logo", Integer.valueOf(1));
      return this;
    }
    this.a.a("show_video_logo", Integer.valueOf(0));
    return this;
  }
  
  public qzb b(String paramString)
  {
    this.a.a("session_id", paramString);
    return this;
  }
  
  public qzb b(boolean paramBoolean)
  {
    this.a.a("video_inserted", Boolean.valueOf(paramBoolean));
    return this;
  }
  
  public qzb c(int paramInt)
  {
    this.a.a("interact_button_style", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb c(long paramLong)
  {
    this.a.a("video_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public qzb c(BaseArticleInfo paramBaseArticleInfo)
  {
    qzb localqzb = this;
    if (paramBaseArticleInfo != null)
    {
      localqzb = this;
      if (paramBaseArticleInfo.mChannelID == 56L)
      {
        localqzb = this;
        if (paramBaseArticleInfo.mVideoColumnInfo != null) {
          localqzb = a(paramBaseArticleInfo.mVideoColumnInfo);
        }
      }
    }
    return localqzb;
  }
  
  public qzb c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.a("video_session_id", paramString);
    }
    return this;
  }
  
  public qzb c(boolean paramBoolean)
  {
    qza localqza = this.a;
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      localqza.a("fans", str);
      return this;
    }
  }
  
  public qzb d(int paramInt)
  {
    this.a.a("strategy_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb d(long paramLong)
  {
    this.a.a("watch_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public qzb d(BaseArticleInfo paramBaseArticleInfo)
  {
    int j = 1;
    int i = j;
    if (paramBaseArticleInfo != null)
    {
      i = j;
      if (paramBaseArticleInfo.mChannelID == 56L)
      {
        i = j;
        if (bhvy.d())
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
  
  public qzb d(String paramString)
  {
    this.a.a("puin", paramString);
    return this;
  }
  
  public qzb d(boolean paramBoolean)
  {
    qza localqza = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localqza.a("is_ads", Integer.valueOf(i));
      return this;
    }
  }
  
  public qzb e(int paramInt)
  {
    this.a.a("video_strategyid", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb e(long paramLong)
  {
    this.a.a("algorithm_id", Long.valueOf(paramLong));
    return this;
  }
  
  public qzb e(BaseArticleInfo paramBaseArticleInfo)
  {
    this.a.a("account_expose_card", Integer.valueOf(onh.c(paramBaseArticleInfo)));
    return this;
  }
  
  public qzb e(String paramString)
  {
    this.a.a("vid", paramString);
    return this;
  }
  
  public qzb e(boolean paramBoolean)
  {
    qza localqza = this.a;
    if (paramBoolean) {}
    for (String str = "H265";; str = "H264")
    {
      localqza.a("video_code_format", str);
      return this;
    }
  }
  
  public qzb f(int paramInt)
  {
    this.a.a("play_index", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb f(long paramLong)
  {
    this.a.a("video_play_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public qzb f(BaseArticleInfo paramBaseArticleInfo)
  {
    if (qaa.a().a(paramBaseArticleInfo, false, qaa.jdField_a_of_type_Int)) {
      this.a.a("jump_src", Integer.valueOf(qae.a(paramBaseArticleInfo)));
    }
    return this;
  }
  
  public qzb f(String paramString)
  {
    this.a.a("aid", paramString);
    return this;
  }
  
  public qzb f(boolean paramBoolean)
  {
    JSONObject localJSONObject = qza.a(this.a);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      npu.a(localJSONObject, i);
      return this;
    }
  }
  
  public qzb g(int paramInt)
  {
    this.a.a("video_play_length", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb g(long paramLong)
  {
    this.a.a("first_frame_time", Long.valueOf(paramLong));
    return this;
  }
  
  public qzb g(String paramString)
  {
    this.a.a("first_video_rowkey", paramString);
    return this;
  }
  
  public qzb g(boolean paramBoolean)
  {
    qza localqza = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localqza.a("action_type", Integer.valueOf(i));
      return this;
    }
  }
  
  public qzb h(int paramInt)
  {
    this.a.a("from", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb h(long paramLong)
  {
    this.a.a("first_video_algorithm_id", Long.valueOf(paramLong));
    return this;
  }
  
  public qzb h(String paramString)
  {
    this.a.a("rowkey", paramString);
    return this;
  }
  
  public qzb h(boolean paramBoolean)
  {
    qza localqza = this.a;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localqza.a("outcome", Integer.valueOf(i));
      return this;
    }
  }
  
  public qzb i(int paramInt)
  {
    this.a.a("jump_to_channel", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb i(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.a("error_code", paramString);
    }
    return this;
  }
  
  public qzb i(boolean paramBoolean)
  {
    qza localqza = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localqza.a("loophole", Integer.valueOf(i));
      return this;
    }
  }
  
  public qzb j(int paramInt)
  {
    this.a.a("oper_time", Long.valueOf(System.currentTimeMillis()));
    this.a.a("company_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb j(String paramString)
  {
    this.a.a("video_to_uin", paramString);
    return this;
  }
  
  public qzb j(boolean paramBoolean)
  {
    qza localqza = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localqza.a("is_insertion", Integer.valueOf(i));
      return this;
    }
  }
  
  public qzb k(int paramInt)
  {
    this.a.a("ads_jump", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb k(String paramString)
  {
    this.a.a("neg_reason", paramString);
    return this;
  }
  
  public qzb k(boolean paramBoolean)
  {
    qza localqza = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localqza.a("ad_guide_area", Integer.valueOf(i));
      return this;
    }
  }
  
  public qzb l(int paramInt)
  {
    this.a.a("ads_source", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb l(String paramString)
  {
    this.a.a("uin", paramString);
    return this;
  }
  
  public qzb m(int paramInt)
  {
    this.a.a("video_index", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb m(String paramString)
  {
    this.a.a("trigger_rowkey", paramString);
    return this;
  }
  
  public qzb n(int paramInt)
  {
    this.a.a("transverse_index", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb n(String paramString)
  {
    this.a.a("from_rk", paramString);
    return this;
  }
  
  public qzb o(int paramInt)
  {
    this.a.a("content_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb o(String paramString)
  {
    this.a.a("cardbottom_video_report_info", paramString);
    return this;
  }
  
  public qzb p(int paramInt)
  {
    this.a.a("slide_exit", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb p(String paramString)
  {
    this.a.a("topguide_bar_video_report_info", paramString);
    return this;
  }
  
  public qzb q(int paramInt)
  {
    this.a.a("kandian_mode_new", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb q(String paramString)
  {
    this.a.a("ad_guide_area_video_report_info", paramString);
    return this;
  }
  
  public qzb r(int paramInt)
  {
    this.a.a("kandian_mode", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb r(String paramString)
  {
    this.a.a("jump_report_info", paramString);
    return this;
  }
  
  public qzb s(int paramInt)
  {
    this.a.a("item_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb s(String paramString)
  {
    this.a.a("double_videocard_jump_page", paramString);
    return this;
  }
  
  public qzb t(int paramInt)
  {
    this.a.a("play_num", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb t(String paramString)
  {
    this.a.a("double_videocard_jump_src", paramString);
    return this;
  }
  
  public qzb u(int paramInt)
  {
    this.a.a("topic_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb u(String paramString)
  {
    this.a.a("subscript", paramString);
    return this;
  }
  
  public qzb v(int paramInt)
  {
    this.a.a("jump_to", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb w(int paramInt)
  {
    this.a.a("video_from_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb x(int paramInt)
  {
    if (paramInt != -1) {
      this.a.a("source", Integer.valueOf(paramInt));
    }
    return this;
  }
  
  public qzb y(int paramInt)
  {
    this.a.a("card_pos", Integer.valueOf(paramInt));
    return this;
  }
  
  public qzb z(int paramInt)
  {
    this.a.a("is_loop", Integer.valueOf(paramInt));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qzb
 * JD-Core Version:    0.7.0.1
 */