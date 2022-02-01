import android.text.TextUtils;
import com.google.gson.JsonArray;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPGCShortContentBig;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.TopicEntranceInfo;

public class phn
{
  JSONObject a = new JSONObject();
  
  public static long a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return 0L;
    }
    if ((snh.i(paramArticleInfo)) || (snh.n(paramArticleInfo)) || (snh.j(paramArticleInfo))) {
      return b(paramArticleInfo);
    }
    if ((pha.i(paramArticleInfo)) && ((paramArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 7) || (paramArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 8))) {
      return paramArticleInfo.mPolymericInfo.f;
    }
    return paramArticleInfo.businessId;
  }
  
  static long b(ArticleInfo paramArticleInfo)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramArticleInfo.mTopicRecommendFeedsInfo != null)
    {
      l1 = l2;
      if (paramArticleInfo.mTopicRecommendFeedsInfo.a != null)
      {
        l1 = l2;
        if (paramArticleInfo.mTopicRecommendFeedsInfo.a.size() > 0)
        {
          l1 = l2;
          if (paramArticleInfo.mTopicRecommendFeedsInfo.a.get(0) != null) {
            l1 = ((rik)paramArticleInfo.mTopicRecommendFeedsInfo.a.get(0)).jdField_a_of_type_Int;
          }
        }
      }
    }
    return l1;
  }
  
  phn A(int paramInt)
  {
    this.a.put("is_push", paramInt);
    return this;
  }
  
  phn A(String paramString)
  {
    this.a.put("jump_report_info", paramString);
    return this;
  }
  
  phn B(int paramInt)
  {
    this.a.put("istopic", paramInt);
    return this;
  }
  
  phn B(String paramString)
  {
    this.a.put("report_common_data", paramString);
    return this;
  }
  
  phn C(int paramInt)
  {
    this.a.put("is_redpack", paramInt);
    return this;
  }
  
  phn C(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.put("rowkey1", paramString);
    }
    return this;
  }
  
  phn D(int paramInt)
  {
    this.a.put("is_show_followed", paramInt);
    return this;
  }
  
  phn D(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.put("url", paramString);
    }
    return this;
  }
  
  public phn E(int paramInt)
  {
    if (paramInt != 41695) {}
    Object localObject;
    do
    {
      do
      {
        return this;
        localObject = pmh.a().a();
      } while (localObject == null);
      localObject = ((SelectPositionModule)localObject).a();
    } while (localObject == null);
    y(((SelectPositionModule.PositionData)localObject).city);
    return this;
  }
  
  phn E(String paramString)
  {
    this.a.put("is_column", paramString);
    return this;
  }
  
  public phn F(int paramInt)
  {
    if (pil.c(paramInt)) {
      r(bmqa.h());
    }
    return this;
  }
  
  phn F(String paramString)
  {
    this.a.put("gamelist", paramString);
    return this;
  }
  
  public phn G(int paramInt)
  {
    if (paramInt == 0) {
      a(pwb.b());
    }
    return this;
  }
  
  public phn H(int paramInt)
  {
    if ((paramInt == 0) || (pil.c(paramInt))) {
      if (paramInt != 0) {
        break label27;
      }
    }
    label27:
    for (String str = ube.jdField_a_of_type_JavaLangString;; str = pfk.jdField_a_of_type_JavaLangString)
    {
      f(str);
      return this;
    }
  }
  
  int a(ArticleInfo paramArticleInfo)
  {
    int j = 1;
    if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy.jdField_a_of_type_JavaUtilList != null))
    {
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy.jdField_a_of_type_JavaUtilList.size() > 1) {
        i = 2;
      }
      do
      {
        do
        {
          return i;
          i = j;
        } while (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy.jdField_a_of_type_JavaUtilList.size() == 1);
        i = j;
      } while (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaLangString));
    }
    while (TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaLangString))
    {
      int i;
      return 0;
    }
    return 1;
  }
  
  JsonArray a(long paramLong)
  {
    Object localObject = qmi.a(paramLong);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      JsonArray localJsonArray = new JsonArray();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ArticleInfo localArticleInfo = (ArticleInfo)((Iterator)localObject).next();
        if ((localArticleInfo != null) && (localArticleInfo.mProteusTemplateBean.getData() != null)) {
          localJsonArray.add(localArticleInfo.mProteusTemplateBean.getData().optString("rowkey"));
        }
      }
      return localJsonArray;
    }
    return null;
  }
  
  public JSONObject a()
  {
    return this.a;
  }
  
  phn a()
  {
    this.a.put("time", System.currentTimeMillis());
    return this;
  }
  
  phn a(int paramInt)
  {
    this.a.put("feeds_type", paramInt);
    return this;
  }
  
  phn a(int paramInt1, int paramInt2)
  {
    this.a.put("column_id", paramInt1);
    this.a.put("subscribe_flag", paramInt2);
    return this;
  }
  
  phn a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.put("feeds_type", 1036);
    this.a.put("feeds_size", paramInt1);
    this.a.put("feeds_head", paramInt2);
    this.a.put("column_id", paramInt3);
    return this;
  }
  
  phn a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.a.put("number", paramInt1);
    this.a.put("words", paramInt2);
    this.a.put("likes", paramInt3);
    this.a.put("comment", paramInt4);
    this.a.put("biu", paramInt5);
    return this;
  }
  
  public phn a(int paramInt, ArticleInfo paramArticleInfo)
  {
    if ((paramInt == 0) && (paramArticleInfo != null) && (!TextUtils.isEmpty(paramArticleInfo.adReportCommonData))) {
      x(paramArticleInfo.adReportCommonData);
    }
    return this;
  }
  
  phn a(long paramLong)
  {
    this.a.put("algorithm_id", paramLong);
    return this;
  }
  
  public phn a(long paramLong, String paramString, ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mFeedType == 26))
    {
      o(paramArticleInfo.mSubscribeID);
      c(paramLong);
      if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhw != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhw.a != null)) {
        k(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhw.a.jdField_a_of_type_Int);
      }
      p(paramString);
      if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhw != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhw.a != null) && (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhw.a.jdField_a_of_type_JavaLangString))) {
        g(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhw.a.jdField_a_of_type_JavaLangString);
      }
    }
    return this;
  }
  
  phn a(JsonArray paramJsonArray)
  {
    this.a.put("all_rowkey", paramJsonArray);
    return this;
  }
  
  public phn a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo.mFeedType == 38) || (paramArticleInfo.mFeedType == 39))
    {
      if (paramArticleInfo.mSmallMiniGameInfo != null) {
        F(paramArticleInfo.mSmallMiniGameInfo.a());
      }
      a(oqj.a(paramArticleInfo));
    }
    return this;
  }
  
  public phn a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mArticleID > 0L)) {
      A(paramInt);
    }
    return this;
  }
  
  public phn a(ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mChannelID == 0L) && (paramBoolean)) {
      if ((paramArticleInfo.mCommentCount <= 100L) && (paramArticleInfo.mVideoCommentCount <= 100)) {
        break label47;
      }
    }
    label47:
    for (int i = 1;; i = 2)
    {
      m(i);
      return this;
    }
  }
  
  public phn a(ArticleInfo paramArticleInfo, boolean paramBoolean, int paramInt)
  {
    if ((!a("jump_src")) && (rdy.a().a(paramArticleInfo, false, rdy.jdField_a_of_type_Int))) {
      v(rec.a(paramArticleInfo));
    }
    while ((paramArticleInfo == null) || (!paramBoolean)) {
      return this;
    }
    v(paramInt);
    return this;
  }
  
  phn a(Long paramLong)
  {
    this.a.put("ori_feeds_id", paramLong);
    return this;
  }
  
  phn a(Long paramLong1, Long paramLong2)
  {
    this.a.put("r_session_position", paramLong1);
    this.a.put("r_session_ispush", paramLong2);
    return this;
  }
  
  phn a(String paramString)
  {
    this.a.put("folder_status", paramString);
    return this;
  }
  
  phn a(String paramString1, String paramString2)
  {
    this.a.put("jump_page", paramString1);
    this.a.put("jump_src", paramString2);
    return this;
  }
  
  phn a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3)
  {
    this.a.put("uin", paramString1);
    this.a.put("fromuin", paramString2);
    this.a.put("rowkey", paramString3);
    this.a.put("zhitiao_num_daily", paramInt1);
    this.a.put("zhitiao_sum", paramInt2);
    this.a.put("tag", paramString4);
    this.a.put("zhitiao_show", paramInt3);
    return this;
  }
  
  phn a(@NotNull Map<String, Object> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      this.a.put(str, "" + localObject);
    }
    return this;
  }
  
  phn a(boolean paramBoolean)
  {
    this.a.put("preload_flag", paramBoolean);
    return this;
  }
  
  boolean a(String paramString)
  {
    return this.a.has(paramString);
  }
  
  phn b()
  {
    och.a(this.a);
    return this;
  }
  
  phn b(int paramInt)
  {
    this.a.put("channel_id", paramInt);
    return this;
  }
  
  public phn b(int paramInt, ArticleInfo paramArticleInfo)
  {
    if (((paramInt != 0) && (!pil.c(paramInt))) || (paramArticleInfo == null)) {}
    for (;;)
    {
      return this;
      if (paramInt == 0) {}
      for (paramArticleInfo = ube.a(paramArticleInfo.mArticleID); paramArticleInfo != null; paramArticleInfo = pfk.a(paramArticleInfo.mArticleID))
      {
        a((Long)paramArticleInfo.first, (Long)paramArticleInfo.second);
        return this;
      }
    }
  }
  
  phn b(long paramLong)
  {
    this.a.put("topicid", paramLong);
    return this;
  }
  
  phn b(JsonArray paramJsonArray)
  {
    this.a.put("rowkey", paramJsonArray);
    return this;
  }
  
  public phn b(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo != null) {
      D(paramArticleInfo.showMyFollowText);
    }
    return this;
  }
  
  public phn b(ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    int i = 0;
    if ((paramBoolean) || (snh.g(paramArticleInfo)) || (snh.i(paramArticleInfo)) || (snh.n(paramArticleInfo)) || (snh.j(paramArticleInfo)) || (snh.k(paramArticleInfo)))
    {
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList != null) {
        i = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList.size();
      }
      a(i + 1, a(paramArticleInfo), paramArticleInfo.mSocialFeedInfo.b, paramArticleInfo.mSocialFeedInfo.d, paramArticleInfo.mSocialFeedInfo.f);
      return this;
    }
    a(0, 0, 0, 0, 0);
    return this;
  }
  
  phn b(String paramString)
  {
    this.a.put("feeds_source", paramString);
    return this;
  }
  
  phn b(String paramString1, String paramString2)
  {
    this.a.put("column_id", paramString1);
    this.a.put("subscribe_flag", paramString2);
    return this;
  }
  
  public phn c()
  {
    Object localObject = bmqa.a("kd_topic_recommend_card_jump_switch");
    if ((localObject instanceof Boolean)) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      if (bool) {}
      for (localObject = "2";; localObject = "1")
      {
        j((String)localObject);
        return this;
      }
    }
  }
  
  phn c(int paramInt)
  {
    this.a.put("network_type", paramInt);
    return this;
  }
  
  phn c(long paramLong)
  {
    this.a.put("uin", paramLong);
    return this;
  }
  
  public phn c(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$TopicEntranceInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$TopicEntranceInfo.uint32_is_topic.has()))
    {
      B(1);
      return this;
    }
    B(0);
    return this;
  }
  
  phn c(String paramString)
  {
    this.a.put("imei", paramString);
    return this;
  }
  
  phn c(String paramString1, String paramString2)
  {
    this.a.put(paramString1, paramString2);
    return this;
  }
  
  phn d(int paramInt)
  {
    this.a.put("reddot_style", paramInt);
    return this;
  }
  
  phn d(long paramLong)
  {
    this.a.put("main_text_read_time", paramLong);
    return this;
  }
  
  public phn d(ArticleInfo paramArticleInfo)
  {
    int i;
    if ((paramArticleInfo != null) && (paramArticleInfo.columnEntrances != null) && (paramArticleInfo.columnEntrances.size() > 0))
    {
      paramArticleInfo = (VideoColumnInfo)paramArticleInfo.columnEntrances.get(0);
      if (paramArticleInfo.jdField_a_of_type_Int == 0) {
        break label87;
      }
      E("1");
      i = paramArticleInfo.jdField_a_of_type_Int;
      if (!paramArticleInfo.jdField_a_of_type_Boolean) {
        break label80;
      }
    }
    label80:
    for (paramArticleInfo = "1";; paramArticleInfo = "2")
    {
      b(String.valueOf(i), paramArticleInfo);
      return this;
    }
    label87:
    E("0");
    return this;
  }
  
  phn d(String paramString)
  {
    this.a.put("imsi", paramString);
    return this;
  }
  
  phn e(int paramInt)
  {
    this.a.put("kandian_mode", paramInt);
    return this;
  }
  
  public phn e(ArticleInfo paramArticleInfo)
  {
    String str4 = "";
    try
    {
      if (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhg.jdField_a_of_type_Rgw.jdField_a_of_type_JavaLangString)) {}
      for (str1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhg.jdField_a_of_type_Rgw.jdField_a_of_type_JavaLangString;; str1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhg.jdField_a_of_type_Rhp.f)
      {
        str2 = str4;
        str3 = str1;
        try
        {
          if (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhg.jdField_a_of_type_Rhm.b))
          {
            str2 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhg.jdField_a_of_type_Rhm.b;
            str3 = str1;
          }
          C(str3);
          D(str2);
          return this;
        }
        catch (NullPointerException paramArticleInfo)
        {
          break;
          str1 = "";
        }
        if (TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhg.jdField_a_of_type_Rhp.f)) {
          break label179;
        }
      }
    }
    catch (NullPointerException paramArticleInfo)
    {
      String str1;
      label179:
      for (;;)
      {
        str1 = "";
        QLog.e("ReportR5WithTimeBuilder", 2, "addOutSideLinkUrl NullPointerException e: " + paramArticleInfo.getMessage());
        String str2 = str4;
        String str3 = str1;
      }
    }
  }
  
  phn e(String paramString)
  {
    this.a.put("session_id", paramString);
    return this;
  }
  
  phn f(int paramInt)
  {
    this.a.put("kandian_mode_new", paramInt);
    return this;
  }
  
  public phn f(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mNewPolymericInfo != null) && (paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 15))
    {
      a(paramArticleInfo.mNewPolymericInfo.c, paramArticleInfo.mNewPolymericInfo.b, paramArticleInfo.mNewPolymericInfo.d);
      if (paramArticleInfo.mNewPolymericInfo.b == 3) {
        a(paramArticleInfo.mNewPolymericInfo.d, paramArticleInfo.mNewPolymericInfo.e);
      }
      B(paramArticleInfo.mReportCommonData);
      paramArticleInfo = a(paramArticleInfo.mArticleID);
      if (paramArticleInfo != null) {
        b(paramArticleInfo);
      }
    }
    return this;
  }
  
  phn f(String paramString)
  {
    this.a.put("r_session_id", paramString);
    return this;
  }
  
  phn g(int paramInt)
  {
    this.a.put("tab_source", paramInt);
    return this;
  }
  
  public phn g(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mFeedType == 35) && (paramArticleInfo.multiVideoColumnInfo != null))
    {
      rfu localrfu = paramArticleInfo.multiVideoColumnInfo;
      x(localrfu.jdField_a_of_type_Int);
      if (localrfu.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        JsonArray localJsonArray = new JsonArray();
        Iterator localIterator = localrfu.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          localJsonArray.add(((rhx)localIterator.next()).jdField_a_of_type_JavaLangString);
        }
        a(localJsonArray);
      }
      int i = 0;
      if (localrfu.jdField_a_of_type_Boolean) {
        i = 1;
      }
      y(i);
      paramArticleInfo = a(paramArticleInfo.mArticleID);
      if (paramArticleInfo != null) {
        b(paramArticleInfo);
      }
      if (!TextUtils.isEmpty(localrfu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e)) {
        A(localrfu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e);
      }
    }
    return this;
  }
  
  phn g(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.put("rowkey", paramString);
    }
    return this;
  }
  
  phn h(int paramInt)
  {
    this.a.put("jump_to_channel", paramInt);
    return this;
  }
  
  public phn h(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mFeedType == 34) && (paramArticleInfo.scripCmsInfo != null))
    {
      rgj localrgj = paramArticleInfo.scripCmsInfo;
      String str2 = "";
      String str1 = str2;
      if (BaseApplicationImpl.getApplication() != null)
      {
        str1 = str2;
        if (BaseApplicationImpl.getApplication().getRuntime() != null) {
          str1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        }
      }
      a(str1, "" + localrgj.a, paramArticleInfo.innerUniqueID, pzo.a(BaseApplicationImpl.getApplication(), str1), rgj.c, localrgj.j, localrgj.b);
    }
    return this;
  }
  
  phn h(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.put("account_type", paramString);
    }
    return this;
  }
  
  phn i(int paramInt)
  {
    this.a.put("card_pos", paramInt);
    return this;
  }
  
  public phn i(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo != null)
    {
      if ((pwl.a() != -1) && (pwl.a() != 0))
      {
        w(pwl.a());
        z(pwl.a());
      }
    }
    else {
      return this;
    }
    w(0);
    return this;
  }
  
  phn i(String paramString)
  {
    this.a.put("proteus_bid", paramString);
    return this;
  }
  
  phn j(int paramInt)
  {
    this.a.put("hemera_switch", paramInt);
    return this;
  }
  
  public phn j(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.isPGCShortContent())) {
      u(Aladdin.getConfig(192).getIntegerFromString("picture_click_jumptype", 0));
    }
    return this;
  }
  
  phn j(String paramString)
  {
    this.a.put("jump_mode", paramString);
    return this;
  }
  
  phn k(int paramInt)
  {
    this.a.put("likes", paramInt);
    return this;
  }
  
  public phn k(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo != null) {}
    for (paramArticleInfo = paramArticleInfo.getProteusItemData();; paramArticleInfo = null)
    {
      if (paramArticleInfo != null) {
        a(paramArticleInfo.optString("jump_page_fg_button"), paramArticleInfo.optString("jump_src_fg_button"));
      }
      return this;
    }
  }
  
  phn k(String paramString)
  {
    this.a.put("star_logo", paramString);
    return this;
  }
  
  phn l(int paramInt)
  {
    this.a.put("hotword_card_num", paramInt);
    return this;
  }
  
  public phn l(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && ((paramArticleInfo.isPGCShortContent()) || (paramArticleInfo.isAccountShown)))
    {
      q(paramArticleInfo.clickArea);
      paramArticleInfo.clickArea = 0;
      v(paramArticleInfo.clickJumpTarget);
      paramArticleInfo.clickJumpTarget = "-1";
      w(ComponentPGCShortContentBig.jdField_a_of_type_JavaLangString);
      if (paramArticleInfo.isShowGif)
      {
        r(1);
        s(ComponentPGCShortContentBig.jdField_a_of_type_Int);
      }
    }
    else
    {
      return this;
    }
    r(0);
    return this;
  }
  
  phn l(String paramString)
  {
    this.a.put("msg_back", paramString);
    return this;
  }
  
  phn m(int paramInt)
  {
    this.a.put("comment_exposure", paramInt);
    return this;
  }
  
  public phn m(ArticleInfo paramArticleInfo)
  {
    boolean bool;
    int i;
    if (paramArticleInfo != null)
    {
      bool = paramArticleInfo.isPGCShortContent();
      if ((!TextUtils.isEmpty(paramArticleInfo.proteusItemsData)) && (paramArticleInfo.proteusItemsData.contains("article_main_body_text")))
      {
        i = 1;
        if ((!bool) && (i == 0)) {
          break label123;
        }
        Map localMap = ube.a(paramArticleInfo.mChannelID);
        if ((localMap == null) || (localMap.get(Long.valueOf(paramArticleInfo.mArticleID)) == null)) {
          break label117;
        }
        d(((ubj)localMap.get(Long.valueOf(paramArticleInfo.mArticleID))).a);
      }
    }
    for (;;)
    {
      label98:
      if (bool) {}
      for (i = 1;; i = 0)
      {
        p(i);
        return this;
        i = 0;
        break;
        label117:
        d(0L);
        label123:
        break label98;
      }
      bool = false;
    }
  }
  
  phn m(String paramString)
  {
    this.a.put("version", paramString);
    return this;
  }
  
  phn n(int paramInt)
  {
    if (paramInt >= 0) {
      this.a.put("entry_path", paramInt);
    }
    return this;
  }
  
  public phn n(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mProteusTemplateBean != null))
    {
      paramArticleInfo = paramArticleInfo.mProteusTemplateBean.getDataAttribute(null);
      if (paramArticleInfo != null) {
        a(paramArticleInfo);
      }
    }
    return this;
  }
  
  phn n(String paramString)
  {
    this.a.put("os", paramString);
    return this;
  }
  
  phn o(int paramInt)
  {
    this.a.put("interact_bar", paramInt);
    return this;
  }
  
  public phn o(ArticleInfo paramArticleInfo)
  {
    if (snh.f(paramArticleInfo))
    {
      paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy;
      if (paramArticleInfo != null) {
        a(paramArticleInfo.jdField_a_of_type_JavaLangLong);
      }
    }
    return this;
  }
  
  phn o(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.put("touin", paramString);
    }
    return this;
  }
  
  phn p(int paramInt)
  {
    this.a.put("short_content_rsc", paramInt);
    return this;
  }
  
  public phn p(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.hotWordInfo != null) && (paramArticleInfo.mFeedType == 28)) {
      if (paramArticleInfo.hotWordInfo.jdField_a_of_type_JavaUtilList == null) {
        break label51;
      }
    }
    label51:
    for (int i = paramArticleInfo.hotWordInfo.jdField_a_of_type_JavaUtilList.size();; i = 0)
    {
      l(i);
      return this;
    }
  }
  
  phn p(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.put("ans_rowkey", paramString);
    }
    return this;
  }
  
  phn q(int paramInt)
  {
    this.a.put("click_area", paramInt);
    return this;
  }
  
  public phn q(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return this;
    }
    if ((paramArticleInfo.recommentFlag & 0x1000) != 0)
    {
      l("1");
      return this;
    }
    l("0");
    return this;
  }
  
  phn q(String paramString)
  {
    this.a.put("simCardType", paramString);
    return this;
  }
  
  phn r(int paramInt)
  {
    this.a.put("short_content_gif", paramInt);
    return this;
  }
  
  public phn r(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.feedsFirstExposurePos != -1)) {
      i(paramArticleInfo.feedsFirstExposurePos);
    }
    return this;
  }
  
  phn r(String paramString)
  {
    this.a.put("cmd", paramString);
    return this;
  }
  
  phn s(int paramInt)
  {
    this.a.put("gif_playmode", paramInt);
    return this;
  }
  
  phn s(String paramString)
  {
    this.a.put("keep_top", paramString);
    return this;
  }
  
  phn t(int paramInt)
  {
    this.a.put("account_expose_card", paramInt);
    return this;
  }
  
  phn t(String paramString)
  {
    this.a.put("device_brand", paramString);
    return this;
  }
  
  phn u(int paramInt)
  {
    this.a.put("picture_click_jumptype", paramInt);
    return this;
  }
  
  phn u(String paramString)
  {
    this.a.put("device_type", paramString);
    return this;
  }
  
  phn v(int paramInt)
  {
    this.a.put("jump_src", paramInt);
    return this;
  }
  
  phn v(String paramString)
  {
    this.a.put("target", paramString);
    return this;
  }
  
  phn w(int paramInt)
  {
    this.a.put("mainfeeds_showcase", paramInt);
    return this;
  }
  
  phn w(String paramString)
  {
    this.a.put("short_content_size", paramString);
    return this;
  }
  
  phn x(int paramInt)
  {
    this.a.put("column_id", paramInt);
    return this;
  }
  
  phn x(String paramString)
  {
    this.a.put("bytes_ad_report_common_data", paramString);
    return this;
  }
  
  phn y(int paramInt)
  {
    this.a.put("subscribe", paramInt);
    return this;
  }
  
  phn y(String paramString)
  {
    this.a.put("channel_city", paramString);
    return this;
  }
  
  phn z(int paramInt)
  {
    this.a.put("from_aio", paramInt);
    return this;
  }
  
  phn z(String paramString)
  {
    this.a.put("configchannel_name", paramString);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     phn
 * JD-Core Version:    0.7.0.1
 */