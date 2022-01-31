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

public final class qmv
{
  private final qmu a;
  
  public qmv(VideoInfo paramVideoInfo)
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
      this.a = new qmu(localObject2, str1, paramVideoInfo, (String)localObject1);
      return;
      paramVideoInfo = null;
      str1 = null;
      localObject2 = null;
    }
  }
  
  public qmv(String paramString)
  {
    this.a = new qmu(paramString);
  }
  
  public qmv(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a = new qmu(paramString1, paramString2, paramString3, paramString4);
  }
  
  public qmv(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2)
  {
    this.a = new qmu(paramString1, paramString2, paramString3, paramString4);
    a(paramLong1).c(paramLong2);
  }
  
  public qmv(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = new qmu(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == 1004) {
      return 2;
    }
    if (bgmq.i()) {
      return 0;
    }
    return 1;
  }
  
  public qmv A(int paramInt)
  {
    this.a.a("actual_width", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv B(int paramInt)
  {
    this.a.a("actual_height", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv C(int paramInt)
  {
    this.a.a("issued_width", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv D(int paramInt)
  {
    this.a.a("issued_height", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv E(int paramInt)
  {
    if (paramInt != -1) {
      this.a.a("replay", Integer.valueOf(paramInt));
    }
    return this;
  }
  
  public qmv F(int paramInt)
  {
    this.a.a("first_video_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv G(int paramInt)
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
  
  public qmv H(int paramInt)
  {
    qmu localqmu = this.a;
    if (paramInt == 0) {}
    for (String str = "MP4";; str = "HLS")
    {
      localqmu.a("video_format", str);
      return this;
    }
  }
  
  public qmv I(int paramInt)
  {
    this.a.a("video_chat_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv J(int paramInt)
  {
    this.a.a("video_kandian_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv K(int paramInt)
  {
    this.a.a("req_times", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv L(int paramInt)
  {
    this.a.a("first_video_channel_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv M(int paramInt)
  {
    this.a.a("first_video_short_video_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv N(int paramInt)
  {
    this.a.a("video_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv O(int paramInt)
  {
    this.a.a("entrance", Integer.valueOf(a(paramInt)));
    return this;
  }
  
  public qmv P(int paramInt)
  {
    this.a.a("count", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv Q(int paramInt)
  {
    this.a.a("style", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv R(int paramInt)
  {
    this.a.a("click_area", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv S(int paramInt)
  {
    this.a.a("show_video_logo", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv T(int paramInt)
  {
    this.a.a("trigger_src", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv U(int paramInt)
  {
    this.a.a("diandianfeeds_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv V(int paramInt)
  {
    this.a.a("entrance_show_jump_icon", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv W(int paramInt)
  {
    this.a.a("feeds_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv X(int paramInt)
  {
    this.a.a("from_feedstype", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv Y(int paramInt)
  {
    this.a.a("cardbottom_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv Z(int paramInt)
  {
    this.a.a("topguide_bar", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmu a()
  {
    return this.a;
  }
  
  public qmv a(int paramInt)
  {
    this.a.a("channel_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv a(long paramLong)
  {
    this.a.a("current_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public qmv a(BaseArticleInfo paramBaseArticleInfo)
  {
    qmu localqmu = this.a;
    if (paramBaseArticleInfo.isShowGif) {}
    for (int i = 1;; i = 0)
    {
      localqmu.a("gif", Integer.valueOf(i));
      return this;
    }
  }
  
  public qmv a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
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
  
  public qmv a(VideoColumnInfo paramVideoColumnInfo)
  {
    qmv localqmv = this;
    if (paramVideoColumnInfo != null) {
      localqmv = aa(paramVideoColumnInfo.jdField_a_of_type_Int);
    }
    return localqmv;
  }
  
  public qmv a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue()) {
      this.a.a("is_ugc_as_pgc", Integer.valueOf(1));
    }
    return this;
  }
  
  public qmv a(String paramString)
  {
    qmu localqmu = this.a;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localqmu.a("video_report_info", str);
    return this;
  }
  
  public qmv a(String paramString, Object paramObject)
  {
    this.a.a(paramString, paramObject);
    return this;
  }
  
  public qmv a(ArrayList<DislikeInfo> paramArrayList)
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
  
  public qmv a(qik paramqik)
  {
    qmv localqmv = this;
    if (paramqik != null) {
      localqmv = d(paramqik.a());
    }
    return localqmv;
  }
  
  public qmv a(qik paramqik, long paramLong)
  {
    qmv localqmv = this;
    if (paramqik != null) {
      localqmv = b(paramqik.a(paramLong));
    }
    return localqmv;
  }
  
  public qmv a(boolean paramBoolean)
  {
    qmu localqmu = this.a;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localqmu.a("download", Integer.valueOf(i));
      return this;
    }
  }
  
  public qmv aa(int paramInt)
  {
    this.a.a("column_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv ab(int paramInt)
  {
    this.a.a("double_videocard_pos", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv ac(int paramInt)
  {
    this.a.a("video_autoplay", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv b(int paramInt)
  {
    this.a.a("card_jump_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv b(long paramLong)
  {
    this.a.a("stay_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public qmv b(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo != null) && (!TextUtils.isEmpty(paramBaseArticleInfo.mVideoLogoUrl)) && (qcn.c()))
    {
      this.a.a("show_video_logo", Integer.valueOf(1));
      return this;
    }
    this.a.a("show_video_logo", Integer.valueOf(0));
    return this;
  }
  
  public qmv b(String paramString)
  {
    this.a.a("session_id", paramString);
    return this;
  }
  
  public qmv b(boolean paramBoolean)
  {
    this.a.a("video_inserted", Boolean.valueOf(paramBoolean));
    return this;
  }
  
  public qmv c(int paramInt)
  {
    this.a.a("strategy_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv c(long paramLong)
  {
    this.a.a("video_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public qmv c(BaseArticleInfo paramBaseArticleInfo)
  {
    qmv localqmv = this;
    if (paramBaseArticleInfo != null)
    {
      localqmv = this;
      if (paramBaseArticleInfo.mChannelID == 56L)
      {
        localqmv = this;
        if (paramBaseArticleInfo.mVideoColumnInfo != null) {
          localqmv = a(paramBaseArticleInfo.mVideoColumnInfo);
        }
      }
    }
    return localqmv;
  }
  
  public qmv c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.a("video_session_id", paramString);
    }
    return this;
  }
  
  public qmv c(boolean paramBoolean)
  {
    qmu localqmu = this.a;
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      localqmu.a("fans", str);
      return this;
    }
  }
  
  public qmv d(int paramInt)
  {
    this.a.a("video_strategyid", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv d(long paramLong)
  {
    this.a.a("watch_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public qmv d(BaseArticleInfo paramBaseArticleInfo)
  {
    int j = 1;
    int i = j;
    if (paramBaseArticleInfo != null)
    {
      i = j;
      if (paramBaseArticleInfo.mChannelID == 56L)
      {
        i = j;
        if (bgmq.d())
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
  
  public qmv d(String paramString)
  {
    this.a.a("puin", paramString);
    return this;
  }
  
  public qmv d(boolean paramBoolean)
  {
    qmu localqmu = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localqmu.a("is_ads", Integer.valueOf(i));
      return this;
    }
  }
  
  public qmv e(int paramInt)
  {
    this.a.a("play_index", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv e(long paramLong)
  {
    this.a.a("algorithm_id", Long.valueOf(paramLong));
    return this;
  }
  
  public qmv e(BaseArticleInfo paramBaseArticleInfo)
  {
    this.a.a("account_expose_card", Integer.valueOf(obz.c(paramBaseArticleInfo)));
    return this;
  }
  
  public qmv e(String paramString)
  {
    this.a.a("vid", paramString);
    return this;
  }
  
  public qmv e(boolean paramBoolean)
  {
    qmu localqmu = this.a;
    if (paramBoolean) {}
    for (String str = "H265";; str = "H264")
    {
      localqmu.a("video_code_format", str);
      return this;
    }
  }
  
  public qmv f(int paramInt)
  {
    this.a.a("video_play_length", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv f(long paramLong)
  {
    this.a.a("video_play_duration", Long.valueOf(paramLong));
    return this;
  }
  
  public qmv f(BaseArticleInfo paramBaseArticleInfo)
  {
    if (poi.a().a(paramBaseArticleInfo, false, poi.jdField_a_of_type_Int)) {
      this.a.a("jump_src", Integer.valueOf(pol.a(paramBaseArticleInfo)));
    }
    return this;
  }
  
  public qmv f(String paramString)
  {
    this.a.a("aid", paramString);
    return this;
  }
  
  public qmv f(boolean paramBoolean)
  {
    JSONObject localJSONObject = qmu.a(this.a);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      new.a(localJSONObject, i);
      return this;
    }
  }
  
  public qmv g(int paramInt)
  {
    this.a.a("from", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv g(long paramLong)
  {
    this.a.a("first_frame_time", Long.valueOf(paramLong));
    return this;
  }
  
  public qmv g(String paramString)
  {
    this.a.a("first_video_rowkey", paramString);
    return this;
  }
  
  public qmv g(boolean paramBoolean)
  {
    qmu localqmu = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localqmu.a("action_type", Integer.valueOf(i));
      return this;
    }
  }
  
  public qmv h(int paramInt)
  {
    this.a.a("jump_to_channel", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv h(long paramLong)
  {
    this.a.a("first_video_algorithm_id", Long.valueOf(paramLong));
    return this;
  }
  
  public qmv h(String paramString)
  {
    this.a.a("rowkey", paramString);
    return this;
  }
  
  public qmv h(boolean paramBoolean)
  {
    qmu localqmu = this.a;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localqmu.a("outcome", Integer.valueOf(i));
      return this;
    }
  }
  
  public qmv i(int paramInt)
  {
    this.a.a("oper_time", Long.valueOf(System.currentTimeMillis()));
    this.a.a("company_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv i(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.a("error_code", paramString);
    }
    return this;
  }
  
  public qmv i(boolean paramBoolean)
  {
    qmu localqmu = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localqmu.a("loophole", Integer.valueOf(i));
      return this;
    }
  }
  
  public qmv j(int paramInt)
  {
    this.a.a("ads_jump", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv j(String paramString)
  {
    this.a.a("video_to_uin", paramString);
    return this;
  }
  
  public qmv j(boolean paramBoolean)
  {
    qmu localqmu = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localqmu.a("is_insertion", Integer.valueOf(i));
      return this;
    }
  }
  
  public qmv k(int paramInt)
  {
    this.a.a("ads_source", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv k(String paramString)
  {
    this.a.a("neg_reason", paramString);
    return this;
  }
  
  public qmv k(boolean paramBoolean)
  {
    qmu localqmu = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localqmu.a("ad_guide_area", Integer.valueOf(i));
      return this;
    }
  }
  
  public qmv l(int paramInt)
  {
    this.a.a("video_index", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv l(String paramString)
  {
    this.a.a("uin", paramString);
    return this;
  }
  
  public qmv m(int paramInt)
  {
    this.a.a("transverse_index", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv m(String paramString)
  {
    this.a.a("trigger_rowkey", paramString);
    return this;
  }
  
  public qmv n(int paramInt)
  {
    this.a.a("content_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv n(String paramString)
  {
    this.a.a("from_rk", paramString);
    return this;
  }
  
  public qmv o(int paramInt)
  {
    this.a.a("slide_exit", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv o(String paramString)
  {
    this.a.a("cardbottom_video_report_info", paramString);
    return this;
  }
  
  public qmv p(int paramInt)
  {
    this.a.a("kandian_mode_new", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv p(String paramString)
  {
    this.a.a("topguide_bar_video_report_info", paramString);
    return this;
  }
  
  public qmv q(int paramInt)
  {
    this.a.a("kandian_mode", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv q(String paramString)
  {
    this.a.a("ad_guide_area_video_report_info", paramString);
    return this;
  }
  
  public qmv r(int paramInt)
  {
    this.a.a("item_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv r(String paramString)
  {
    this.a.a("jump_report_info", paramString);
    return this;
  }
  
  public qmv s(int paramInt)
  {
    this.a.a("play_num", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv s(String paramString)
  {
    this.a.a("double_videocard_jump_page", paramString);
    return this;
  }
  
  public qmv t(int paramInt)
  {
    this.a.a("topic_id", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv t(String paramString)
  {
    this.a.a("double_videocard_jump_src", paramString);
    return this;
  }
  
  public qmv u(int paramInt)
  {
    this.a.a("jump_to", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv u(String paramString)
  {
    this.a.a("subscript", paramString);
    return this;
  }
  
  public qmv v(int paramInt)
  {
    this.a.a("video_from_type", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv w(int paramInt)
  {
    if (paramInt != -1) {
      this.a.a("source", Integer.valueOf(paramInt));
    }
    return this;
  }
  
  public qmv x(int paramInt)
  {
    this.a.a("card_pos", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv y(int paramInt)
  {
    this.a.a("is_loop", Integer.valueOf(paramInt));
    return this;
  }
  
  public qmv z(int paramInt)
  {
    this.a.a("loop_times", Integer.valueOf(paramInt));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qmv
 * JD-Core Version:    0.7.0.1
 */