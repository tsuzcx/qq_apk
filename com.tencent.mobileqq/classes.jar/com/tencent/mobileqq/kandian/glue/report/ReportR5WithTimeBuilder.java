package com.tencent.mobileqq.kandian.glue.report;

import android.text.TextUtils;
import com.google.gson.JsonArray;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.notecard.ReadInJoyNoteCardUtil;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentPGCShortContentBig;
import com.tencent.mobileqq.kandian.biz.pts.data.PTSLiteDataFactory;
import com.tencent.mobileqq.kandian.biz.pts.data.PTSLiteDataFactory.Companion;
import com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper.RecycleViewAdapterHelper;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.ad.SmallMiniGameInfo;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.ChannelCoverInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.HotWordInfo;
import com.tencent.mobileqq.kandian.repo.feeds.PolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.ScripCmsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.SelectPositionModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AnswerDetailInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ArticleBasicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.LongContentInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.OutsideLinkInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PositionData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.WendaInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.kandian.repo.ugc.srtutils.ReadInJoySrtHandler;
import com.tencent.mobileqq.kandian.repo.ugc.srtutils.UGRuleManager;
import com.tencent.mobileqq.kandian.repo.video.entity.PGCVideoInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
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

public class ReportR5WithTimeBuilder
{
  JSONObject a = new JSONObject();
  
  public static long r(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return 0L;
    }
    if ((!RIJItemViewTypeUtils.t(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.u(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.n(paramAbsBaseArticleInfo)))
    {
      if ((RIJFeedsType.F(paramAbsBaseArticleInfo)) && ((paramAbsBaseArticleInfo.mPolymericInfo.e == 7) || (paramAbsBaseArticleInfo.mPolymericInfo.e == 8))) {
        return paramAbsBaseArticleInfo.mPolymericInfo.m;
      }
      return paramAbsBaseArticleInfo.businessId;
    }
    return s(paramAbsBaseArticleInfo);
  }
  
  static long s(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo != null) && (paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.g != null) && (paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.g.size() > 0) && (paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.g.get(0) != null)) {
      return ((TopicRecommendFeedsInfo.TopicRecommendInfo)paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.g.get(0)).a;
    }
    return 0L;
  }
  
  public ReportR5WithTimeBuilder A(int paramInt)
  {
    this.a.put("is_push", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder A(String paramString)
  {
    this.a.put("jump_report_info", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder B(int paramInt)
  {
    this.a.put("istopic", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder B(String paramString)
  {
    this.a.put("report_common_data", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder C(int paramInt)
  {
    this.a.put("is_redpack", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder C(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.put("rowkey1", paramString);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder D(int paramInt)
  {
    this.a.put("is_show_followed", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder D(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.put("url", paramString);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder E(int paramInt)
  {
    this.a.put("corner_mark", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder E(String paramString)
  {
    this.a.put("is_column", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder F(int paramInt)
  {
    if (paramInt != 41695) {
      return this;
    }
    Object localObject = ReadInJoyLogicEngine.a().j();
    if (localObject == null) {
      return this;
    }
    localObject = ((SelectPositionModule)localObject).b();
    if (localObject == null) {
      return this;
    }
    y(((PositionData)localObject).city);
    return this;
  }
  
  public ReportR5WithTimeBuilder F(String paramString)
  {
    this.a.put("gamelist", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder G(int paramInt)
  {
    if (DailyModeConfigHandler.c(paramInt)) {
      r(ReadInJoyHelper.O());
    }
    return this;
  }
  
  boolean G(String paramString)
  {
    return this.a.has(paramString);
  }
  
  public ReportR5WithTimeBuilder H(int paramInt)
  {
    if (paramInt == 0) {
      a(ArticleInfoModule.a());
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder I(int paramInt)
  {
    if ((paramInt == 0) || (DailyModeConfigHandler.c(paramInt)))
    {
      String str;
      if (paramInt == 0) {
        str = ReadinjoyReportUtils.i;
      } else {
        str = KandianDailyReportUtils.b;
      }
      f(str);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder a()
  {
    this.a.put("time", System.currentTimeMillis());
    return this;
  }
  
  public ReportR5WithTimeBuilder a(int paramInt)
  {
    this.a.put("feeds_type", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder a(int paramInt1, int paramInt2)
  {
    this.a.put("column_id", paramInt1);
    this.a.put("subscribe_flag", paramInt2);
    return this;
  }
  
  public ReportR5WithTimeBuilder a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.put("feeds_type", 1036);
    this.a.put("feeds_size", paramInt1);
    this.a.put("feeds_head", paramInt2);
    this.a.put("column_id", paramInt3);
    return this;
  }
  
  public ReportR5WithTimeBuilder a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.a.put("number", paramInt1);
    this.a.put("words", paramInt2);
    this.a.put("likes", paramInt3);
    this.a.put("comment", paramInt4);
    this.a.put("biu", paramInt5);
    return this;
  }
  
  public ReportR5WithTimeBuilder a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramInt == 0) && (paramAbsBaseArticleInfo != null) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.adReportCommonData))) {
      x(paramAbsBaseArticleInfo.adReportCommonData);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder a(long paramLong)
  {
    this.a.put("algorithm_id", paramLong);
    return this;
  }
  
  public ReportR5WithTimeBuilder a(long paramLong, String paramString, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mFeedType == 26))
    {
      o(paramAbsBaseArticleInfo.mSubscribeID);
      c(paramLong);
      if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.x != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.x.v != null)) {
        k(paramAbsBaseArticleInfo.mSocialFeedInfo.x.v.d);
      }
      p(paramString);
      if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.x != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.x.v != null) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSocialFeedInfo.x.v.a))) {
        g(paramAbsBaseArticleInfo.mSocialFeedInfo.x.v.a);
      }
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder a(JsonArray paramJsonArray)
  {
    this.a.put("all_rowkey", paramJsonArray);
    return this;
  }
  
  public ReportR5WithTimeBuilder a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo.mFeedType == 38) || (paramAbsBaseArticleInfo.mFeedType == 39))
    {
      if (paramAbsBaseArticleInfo.mSmallMiniGameInfo != null) {
        F(paramAbsBaseArticleInfo.mSmallMiniGameInfo.b());
      }
      a(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getSmallGameReportType(paramAbsBaseArticleInfo));
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mArticleID > 0L)) {
      A(paramInt);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder a(AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mChannelID == 0L) && (paramBoolean))
    {
      int i;
      if ((paramAbsBaseArticleInfo.mCommentCount <= 100L) && (paramAbsBaseArticleInfo.mVideoCommentCount <= 100)) {
        i = 2;
      } else {
        i = 1;
      }
      m(i);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder a(AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean, int paramInt)
  {
    if ((!G("jump_src")) && (ReadInJoySrtHandler.a().a(paramAbsBaseArticleInfo, false, ReadInJoySrtHandler.a)))
    {
      v(UGRuleManager.g(paramAbsBaseArticleInfo));
      return this;
    }
    if ((paramAbsBaseArticleInfo != null) && (paramBoolean)) {
      v(paramInt);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder a(Long paramLong)
  {
    this.a.put("ori_feeds_id", paramLong);
    return this;
  }
  
  public ReportR5WithTimeBuilder a(Long paramLong1, Long paramLong2)
  {
    this.a.put("r_session_position", paramLong1);
    this.a.put("r_session_ispush", paramLong2);
    return this;
  }
  
  public ReportR5WithTimeBuilder a(String paramString)
  {
    this.a.put("folder_status", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder a(String paramString1, String paramString2)
  {
    this.a.put("jump_page", paramString1);
    this.a.put("jump_src", paramString2);
    return this;
  }
  
  public ReportR5WithTimeBuilder a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3)
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
  
  public ReportR5WithTimeBuilder a(@NotNull Map<String, Object> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      JSONObject localJSONObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(localObject);
      localJSONObject.put(str, localStringBuilder.toString());
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder a(boolean paramBoolean)
  {
    this.a.put("preload_flag", paramBoolean);
    return this;
  }
  
  public ReportR5WithTimeBuilder b()
  {
    VideoReporter.a(this.a);
    return this;
  }
  
  public ReportR5WithTimeBuilder b(int paramInt)
  {
    this.a.put("channel_id", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder b(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramInt == 0) || (DailyModeConfigHandler.c(paramInt)))
    {
      if (paramAbsBaseArticleInfo == null) {
        return this;
      }
      if (paramInt == 0) {
        paramAbsBaseArticleInfo = ReadinjoyReportUtils.a(paramAbsBaseArticleInfo.mArticleID);
      } else {
        paramAbsBaseArticleInfo = KandianDailyReportUtils.a(paramAbsBaseArticleInfo.mArticleID);
      }
      if (paramAbsBaseArticleInfo == null) {
        return this;
      }
      a((Long)paramAbsBaseArticleInfo.first, (Long)paramAbsBaseArticleInfo.second);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder b(long paramLong)
  {
    this.a.put("topicid", paramLong);
    return this;
  }
  
  public ReportR5WithTimeBuilder b(JsonArray paramJsonArray)
  {
    this.a.put("rowkey", paramJsonArray);
    return this;
  }
  
  public ReportR5WithTimeBuilder b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo != null) {
      D(paramAbsBaseArticleInfo.showMyFollowText);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder b(AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean)
  {
    if ((!paramBoolean) && (!RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.u(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.n(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.p(paramAbsBaseArticleInfo)))
    {
      a(0, 0, 0, 0, 0);
      return this;
    }
    if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
    {
      int i;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.d != null) {
        i = paramAbsBaseArticleInfo.mSocialFeedInfo.d.size();
      } else {
        i = 0;
      }
      a(i + 1, v(paramAbsBaseArticleInfo), paramAbsBaseArticleInfo.mSocialFeedInfo.h, paramAbsBaseArticleInfo.mSocialFeedInfo.j, paramAbsBaseArticleInfo.mSocialFeedInfo.l);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder b(String paramString)
  {
    this.a.put("feeds_source", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder b(String paramString1, String paramString2)
  {
    this.a.put("column_id", paramString1);
    this.a.put("subscribe_flag", paramString2);
    return this;
  }
  
  public ReportR5WithTimeBuilder c(int paramInt)
  {
    this.a.put("network_type", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder c(long paramLong)
  {
    this.a.put("uin", paramLong);
    return this;
  }
  
  public ReportR5WithTimeBuilder c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.subscriptWording))) {
      E(paramAbsBaseArticleInfo.subscriptType);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder c(String paramString)
  {
    this.a.put("imei", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder c(String paramString1, String paramString2)
  {
    this.a.put(paramString1, paramString2);
    return this;
  }
  
  public JSONObject c()
  {
    return this.a;
  }
  
  public ReportR5WithTimeBuilder d()
  {
    String str;
    if (((Boolean)RIJSPUtils.b("kd_topic_recommend_card_jump_switch", Boolean.valueOf(false))).booleanValue()) {
      str = "2";
    } else {
      str = "1";
    }
    j(str);
    return this;
  }
  
  public ReportR5WithTimeBuilder d(int paramInt)
  {
    this.a.put("reddot_style", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder d(long paramLong)
  {
    this.a.put("main_text_read_time", paramLong);
    return this;
  }
  
  public ReportR5WithTimeBuilder d(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.N != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.N.uint32_is_topic.has()))
    {
      B(1);
      return this;
    }
    B(0);
    return this;
  }
  
  public ReportR5WithTimeBuilder d(String paramString)
  {
    this.a.put("imsi", paramString);
    return this;
  }
  
  JsonArray e(long paramLong)
  {
    Object localObject = RecycleViewAdapterHelper.a(paramLong);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      JsonArray localJsonArray = new JsonArray();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)((Iterator)localObject).next();
        if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.mProteusTemplateBean.getData() != null)) {
          localJsonArray.add(localAbsBaseArticleInfo.mProteusTemplateBean.getData().optString("rowkey"));
        }
      }
      return localJsonArray;
    }
    return null;
  }
  
  public ReportR5WithTimeBuilder e(int paramInt)
  {
    this.a.put("kandian_mode", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder e(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.columnEntrances != null) && (paramAbsBaseArticleInfo.columnEntrances.size() > 0))
    {
      VideoColumnInfo localVideoColumnInfo = (VideoColumnInfo)paramAbsBaseArticleInfo.columnEntrances.get(0);
      if (localVideoColumnInfo.b != 0)
      {
        paramAbsBaseArticleInfo = "1";
        E("1");
        int i = localVideoColumnInfo.b;
        if (!localVideoColumnInfo.h) {
          paramAbsBaseArticleInfo = "2";
        }
        b(String.valueOf(i), paramAbsBaseArticleInfo);
        return this;
      }
      E("0");
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder e(String paramString)
  {
    this.a.put("session_id", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder f(int paramInt)
  {
    this.a.put("kandian_mode_new", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder f(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    String str3 = "";
    String str1;
    try
    {
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSocialFeedInfo.L.b.a)) {
        str1 = paramAbsBaseArticleInfo.mSocialFeedInfo.L.b.a;
      } else if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSocialFeedInfo.L.c.j)) {
        str1 = paramAbsBaseArticleInfo.mSocialFeedInfo.L.c.j;
      } else {
        str1 = "";
      }
      localObject = str3;
      str2 = str1;
      try
      {
        if (TextUtils.isEmpty(paramAbsBaseArticleInfo.mSocialFeedInfo.L.d.b)) {
          break label177;
        }
        localObject = paramAbsBaseArticleInfo.mSocialFeedInfo.L.d.b;
        str2 = str1;
      }
      catch (NullPointerException paramAbsBaseArticleInfo) {}
      localObject = new StringBuilder();
    }
    catch (NullPointerException paramAbsBaseArticleInfo)
    {
      str1 = "";
    }
    ((StringBuilder)localObject).append("addOutSideLinkUrl NullPointerException e: ");
    ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.getMessage());
    QLog.e("ReportR5WithTimeBuilder", 2, ((StringBuilder)localObject).toString());
    String str2 = str1;
    Object localObject = str3;
    label177:
    C(str2);
    D((String)localObject);
    return this;
  }
  
  public ReportR5WithTimeBuilder f(String paramString)
  {
    this.a.put("r_session_id", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder g(int paramInt)
  {
    this.a.put("tab_source", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder g(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mNewPolymericInfo != null) && (paramAbsBaseArticleInfo.mNewPolymericInfo.d == 15))
    {
      a(paramAbsBaseArticleInfo.mNewPolymericInfo.k, paramAbsBaseArticleInfo.mNewPolymericInfo.j, paramAbsBaseArticleInfo.mNewPolymericInfo.n);
      if (paramAbsBaseArticleInfo.mNewPolymericInfo.j == 3) {
        a(paramAbsBaseArticleInfo.mNewPolymericInfo.n, paramAbsBaseArticleInfo.mNewPolymericInfo.o);
      }
      B(paramAbsBaseArticleInfo.mReportCommonData);
      paramAbsBaseArticleInfo = e(paramAbsBaseArticleInfo.mArticleID);
      if (paramAbsBaseArticleInfo != null) {
        b(paramAbsBaseArticleInfo);
      }
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder g(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.put("rowkey", paramString);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder h(int paramInt)
  {
    this.a.put("jump_to_channel", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder h(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public ReportR5WithTimeBuilder h(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.put("account_type", paramString);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder i(int paramInt)
  {
    this.a.put("card_pos", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder i(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mFeedType == 34) && (paramAbsBaseArticleInfo.scripCmsInfo != null))
    {
      ScripCmsInfo localScripCmsInfo = paramAbsBaseArticleInfo.scripCmsInfo;
      String str;
      if ((BaseApplicationImpl.getApplication() != null) && (BaseApplicationImpl.getApplication().getRuntime() != null)) {
        str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      } else {
        str = "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(localScripCmsInfo.k);
      a(str, localStringBuilder.toString(), paramAbsBaseArticleInfo.innerUniqueID, ReadInJoyNoteCardUtil.a(BaseApplicationImpl.getApplication(), str), ScripCmsInfo.n, localScripCmsInfo.l, localScripCmsInfo.m);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder i(String paramString)
  {
    this.a.put("proteus_bid", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder j(int paramInt)
  {
    this.a.put("hemera_switch", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder j(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if ((ChannelCoverInfoModule.g() != -1) && (ChannelCoverInfoModule.g() != 0))
      {
        w(ChannelCoverInfoModule.g());
        z(ChannelCoverInfoModule.h());
        return this;
      }
      w(0);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder j(String paramString)
  {
    this.a.put("jump_mode", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder k(int paramInt)
  {
    this.a.put("likes", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder k(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.isPGCShortContent())) {
      u(Aladdin.getConfig(192).getIntegerFromString("picture_click_jumptype", 0));
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder k(String paramString)
  {
    this.a.put("star_logo", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder l(int paramInt)
  {
    this.a.put("hotword_card_num", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder l(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo != null) {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.getProteusItemData();
    } else {
      paramAbsBaseArticleInfo = null;
    }
    if (paramAbsBaseArticleInfo != null) {
      a(paramAbsBaseArticleInfo.optString("jump_page_fg_button"), paramAbsBaseArticleInfo.optString("jump_src_fg_button"));
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder l(String paramString)
  {
    this.a.put("msg_back", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder m(int paramInt)
  {
    this.a.put("comment_exposure", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder m(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && ((paramAbsBaseArticleInfo.isPGCShortContent()) || (paramAbsBaseArticleInfo.isAccountShown)))
    {
      q(paramAbsBaseArticleInfo.clickArea);
      paramAbsBaseArticleInfo.clickArea = 0;
      v(paramAbsBaseArticleInfo.clickJumpTarget);
      paramAbsBaseArticleInfo.clickJumpTarget = "-1";
      w(ComponentPGCShortContentBig.g);
      if (paramAbsBaseArticleInfo.isShowGif)
      {
        r(1);
        s(ComponentPGCShortContentBig.f);
        return this;
      }
      r(0);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder m(String paramString)
  {
    this.a.put("version", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder n(int paramInt)
  {
    if (paramInt >= 0) {
      this.a.put("entry_path", paramInt);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder n(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    int j = 1;
    int i;
    boolean bool1;
    if (paramAbsBaseArticleInfo != null)
    {
      boolean bool2 = paramAbsBaseArticleInfo.isPGCShortContent();
      if ((!TextUtils.isEmpty(paramAbsBaseArticleInfo.proteusItemsData)) && (paramAbsBaseArticleInfo.proteusItemsData.contains("article_main_body_text"))) {
        i = 1;
      } else {
        i = 0;
      }
      if (!bool2)
      {
        bool1 = bool2;
        if (i == 0) {}
      }
      else
      {
        Map localMap = ReadinjoyReportUtils.b(paramAbsBaseArticleInfo.mChannelID);
        if ((localMap != null) && (localMap.get(Long.valueOf(paramAbsBaseArticleInfo.mArticleID)) != null))
        {
          d(((ReadinjoyReportUtils.ExposureReportItem)localMap.get(Long.valueOf(paramAbsBaseArticleInfo.mArticleID))).b);
          bool1 = bool2;
        }
        else
        {
          d(0L);
          bool1 = bool2;
        }
      }
    }
    else
    {
      bool1 = false;
    }
    if (bool1) {
      i = j;
    } else {
      i = 0;
    }
    p(i);
    return this;
  }
  
  public ReportR5WithTimeBuilder n(String paramString)
  {
    this.a.put("os", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder o(int paramInt)
  {
    this.a.put("interact_bar", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder o(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mProteusTemplateBean != null))
    {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mProteusTemplateBean.getDataAttribute(null);
      if (paramAbsBaseArticleInfo != null) {
        a(paramAbsBaseArticleInfo);
      }
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder o(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.put("touin", paramString);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder p(int paramInt)
  {
    this.a.put("short_content_rsc", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder p(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (RIJItemViewTypeUtils.e(paramAbsBaseArticleInfo))
    {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSocialFeedInfo.n;
      if (paramAbsBaseArticleInfo != null) {
        a(paramAbsBaseArticleInfo.b);
      }
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder p(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.put("ans_rowkey", paramString);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder q(int paramInt)
  {
    this.a.put("click_area", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder q(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.hotWordInfo != null) && (paramAbsBaseArticleInfo.mFeedType == 28))
    {
      int i;
      if (paramAbsBaseArticleInfo.hotWordInfo.a != null) {
        i = paramAbsBaseArticleInfo.hotWordInfo.a.size();
      } else {
        i = 0;
      }
      l(i);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder q(String paramString)
  {
    this.a.put("simCardType", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder r(int paramInt)
  {
    this.a.put("short_content_gif", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder r(String paramString)
  {
    this.a.put("cmd", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder s(int paramInt)
  {
    this.a.put("gif_playmode", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder s(String paramString)
  {
    this.a.put("keep_top", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder t(int paramInt)
  {
    this.a.put("account_expose_card", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder t(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return this;
    }
    if ((paramAbsBaseArticleInfo.recommendedFlag & 0x1000) != 0)
    {
      l("1");
      return this;
    }
    l("0");
    return this;
  }
  
  public ReportR5WithTimeBuilder t(String paramString)
  {
    this.a.put("device_brand", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder u(int paramInt)
  {
    this.a.put("picture_click_jumptype", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder u(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.feedsFirstExposurePos != -1)) {
      i(paramAbsBaseArticleInfo.feedsFirstExposurePos);
    }
    return this;
  }
  
  public ReportR5WithTimeBuilder u(String paramString)
  {
    this.a.put("device_type", paramString);
    return this;
  }
  
  int v(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo.n != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.n.a != null))
    {
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.n.a.size() > 1) {
        return 2;
      }
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.n.a.size() == 1) {
        return 1;
      }
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSocialFeedInfo.e)) {
        return 1;
      }
    }
    else if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSocialFeedInfo.e))
    {
      return 1;
    }
    return 0;
  }
  
  public ReportR5WithTimeBuilder v(int paramInt)
  {
    this.a.put("jump_src", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder v(String paramString)
  {
    this.a.put("target", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder w(int paramInt)
  {
    this.a.put("mainfeeds_showcase", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder w(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return this;
    }
    PTSLiteDataFactory.a.a(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ReportR5WithTimeBuilder w(String paramString)
  {
    this.a.put("short_content_size", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder x(int paramInt)
  {
    this.a.put("column_id", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder x(String paramString)
  {
    this.a.put("bytes_ad_report_common_data", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder y(int paramInt)
  {
    this.a.put("subscribe", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder y(String paramString)
  {
    this.a.put("channel_city", paramString);
    return this;
  }
  
  public ReportR5WithTimeBuilder z(int paramInt)
  {
    this.a.put("from_aio", paramInt);
    return this;
  }
  
  public ReportR5WithTimeBuilder z(String paramString)
  {
    this.a.put("configchannel_name", paramString);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.ReportR5WithTimeBuilder
 * JD-Core Version:    0.7.0.1
 */