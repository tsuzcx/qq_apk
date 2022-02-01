package com.tencent.mobileqq.kandian.glue.msf;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.ktx.PBFieldUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.DynamicChannelConfig;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.ReadInJoyDynamicChannelBaseFragment;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.Utils;
import com.tencent.mobileqq.kandian.biz.notecard.ReadInJoyNoteCardUtil;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.pts.StyleConfigHelper;
import com.tencent.mobileqq.kandian.glue.report.task.ProteusJsHelper;
import com.tencent.mobileqq.kandian.glue.utils.RIJPreParseData;
import com.tencent.mobileqq.kandian.repo.common.InterestLabelInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.AwesomeCommentInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.DislikeResult;
import com.tencent.mobileqq.kandian.repo.db.struct.SubscriptInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo.RedPoint;
import com.tencent.mobileqq.kandian.repo.handler.TagInfo;
import com.tencent.mobileqq.kandian.repo.handler.TopicInfo;
import com.tencent.mobileqq.kandian.repo.handler.TopicInfo.Builder;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;
import tencent.im.oidb.articlesummary.articlesummary.AwesomeCommentInfo;
import tencent.im.oidb.articlesummary.articlesummary.SubscriptInfo;
import tencent.im.oidb.channel_button.channel_button.Channel;
import tencent.im.oidb.channel_button.channel_button.RedPoint;
import tencent.im.oidb.cmd0x46f.oidb_cmd0x46f.DislikeResult;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspChannelArticle;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspGetFollowTabFeeds;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.ChannelInfo;
import tencent.im.oidb.cmd0x6e5.oidb_cmd0x6e5.InterestLabelInfo;
import tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.TagInfo;
import tencent.im.oidb.cmd0xbde.oidb_cmd0xbde.TopicInfo;
import tencent.im.oidb.cmd0xbe6.oidb_cmd0xbe6.MsgChannelInfo;

public class ReadInJoyMSFHandlerUtils
{
  private static String[] a;
  private static Integer[] b;
  private static Boolean[] c;
  
  static
  {
    String str = HardCodeUtil.a(2131910333);
    Boolean localBoolean = Boolean.valueOf(false);
    a = new String[] { str, HardCodeUtil.a(2131910617), HardCodeUtil.a(2131910320), HardCodeUtil.a(2131910365), HardCodeUtil.a(2131910326), HardCodeUtil.a(2131910624), HardCodeUtil.a(2131910496), HardCodeUtil.a(2131910562), HardCodeUtil.a(2131910446), HardCodeUtil.a(2131910278) };
    b = new Integer[] { Integer.valueOf(4779), Integer.valueOf(1166), Integer.valueOf(5293), Integer.valueOf(501), Integer.valueOf(73), Integer.valueOf(5729), Integer.valueOf(1314), Integer.valueOf(3817), Integer.valueOf(3689), Integer.valueOf(3076) };
    c = new Boolean[] { localBoolean, localBoolean, localBoolean, localBoolean, localBoolean, localBoolean, localBoolean, localBoolean, localBoolean, localBoolean, localBoolean, localBoolean };
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      int i = paramInt1 % 5;
      if (i != 0)
      {
        if (i == 1) {
          return paramInt1;
        }
        paramInt1 += 1;
      }
      else
      {
        return paramInt1;
      }
    }
    return 0;
  }
  
  public static AbsBaseArticleInfo a(articlesummary.ArticleSummary paramArticleSummary, int paramInt1, int paramInt2, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramArticleSummary == null) {
      return null;
    }
    Object localObject1 = paramAbsBaseArticleInfo;
    if (paramAbsBaseArticleInfo == null) {
      localObject1 = new BaseArticleInfo();
    }
    ((AbsBaseArticleInfo)localObject1).mChannelID = paramInt1;
    paramAbsBaseArticleInfo = new RIJMsfHandlerHelper();
    paramAbsBaseArticleInfo.a(paramArticleSummary, paramInt1, paramInt2, (AbsBaseArticleInfo)localObject1);
    if (((AbsBaseArticleInfo)localObject1).scripCmsInfo != null)
    {
      localObject2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      ReadInJoyNoteCardUtil.a(BaseApplicationImpl.getApplication(), (String)localObject2, ReadInJoyNoteCardUtil.a(BaseApplicationImpl.getApplication(), (String)localObject2) + 1);
    }
    Object localObject2 = (articlesummary.AwesomeCommentInfo)PBFieldUtils.a(paramArticleSummary.awesome_comment_icon, null);
    if (localObject2 != null)
    {
      ((AbsBaseArticleInfo)localObject1).hasAwesome = true;
      AwesomeCommentInfo.a((AbsBaseArticleInfo)localObject1, (articlesummary.AwesomeCommentInfo)localObject2);
    }
    localObject2 = (articlesummary.SubscriptInfo)PBFieldUtils.a(paramArticleSummary.msg_subscript_20, null);
    if (localObject2 != null) {
      SubscriptInfo.a((AbsBaseArticleInfo)localObject1, (articlesummary.SubscriptInfo)localObject2);
    }
    RIJPreParseData.b((AbsBaseArticleInfo)localObject1);
    paramAbsBaseArticleInfo.l(paramArticleSummary, (AbsBaseArticleInfo)localObject1);
    return localObject1;
  }
  
  public static ChannelCoverInfo a(oidb_cmd0x69f.ChannelInfo paramChannelInfo, int paramInt)
  {
    ChannelCoverInfo localChannelCoverInfo1 = new ChannelCoverInfo();
    new RIJMsfHandlerHelper().a(paramChannelInfo, paramInt, localChannelCoverInfo1);
    paramChannelInfo = ReadInJoyLogicEngine.a().c(paramInt);
    if (paramChannelInfo != null)
    {
      if (paramChannelInfo.size() == 0) {
        return localChannelCoverInfo1;
      }
      paramChannelInfo = paramChannelInfo.iterator();
      while (paramChannelInfo.hasNext())
      {
        ChannelCoverInfo localChannelCoverInfo2 = (ChannelCoverInfo)paramChannelInfo.next();
        if (localChannelCoverInfo2.mChannelCoverId == localChannelCoverInfo1.mChannelCoverId) {
          localChannelCoverInfo1.mPreUpdateTime = localChannelCoverInfo2.mPreUpdateTime;
        }
      }
    }
    return localChannelCoverInfo1;
  }
  
  public static ChannelCoverInfo a(oidb_cmd0xbe6.MsgChannelInfo paramMsgChannelInfo, int paramInt)
  {
    ChannelCoverInfo localChannelCoverInfo = new ChannelCoverInfo();
    if (paramMsgChannelInfo.string_name.has()) {
      localChannelCoverInfo.mChannelCoverName = paramMsgChannelInfo.string_name.get();
    }
    if (paramMsgChannelInfo.uint32_channel_id.has()) {
      localChannelCoverInfo.mChannelCoverId = paramMsgChannelInfo.uint32_channel_id.get();
    }
    if (paramMsgChannelInfo.uint32_channel_type.has()) {
      localChannelCoverInfo.mChannelType = paramMsgChannelInfo.uint32_channel_type.get();
    }
    localChannelCoverInfo.mChannelId = paramInt;
    return localChannelCoverInfo;
  }
  
  public static ChannelInfo a(oidb_cmd0x69f.ChannelInfo paramChannelInfo)
  {
    ChannelInfo localChannelInfo = new ChannelInfo();
    localChannelInfo.mChannelID = PBFieldUtils.a(paramChannelInfo.uint32_channel_id);
    localChannelInfo.mChannelName = PBFieldUtils.a(paramChannelInfo.bytes_channel_name, "");
    localChannelInfo.mChannelType = PBFieldUtils.a(paramChannelInfo.uint32_channel_type);
    if (localChannelInfo.mChannelType == 1)
    {
      boolean bool;
      if (PBFieldUtils.a(paramChannelInfo.uint32_is_first_req) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      localChannelInfo.mIsFirstReq = bool;
    }
    localChannelInfo.mFrameColor = PBFieldUtils.a(paramChannelInfo.uint32_frame_color);
    localChannelInfo.mFontColor = PBFieldUtils.a(paramChannelInfo.uint32_fonts_color);
    try
    {
      localChannelInfo.mJumpUrl = new String(PBFieldUtils.b(paramChannelInfo.bytes_channel_jump_url), "utf-8");
      return localChannelInfo;
    }
    catch (Exception paramChannelInfo)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resolve search channel jump url failed ");
      localStringBuilder.append(paramChannelInfo.toString());
      QLog.d("ChannelInfoModule", 1, localStringBuilder.toString());
    }
    return localChannelInfo;
  }
  
  public static TabChannelCoverInfo a(channel_button.Channel paramChannel)
  {
    TabChannelCoverInfo localTabChannelCoverInfo = new TabChannelCoverInfo();
    localTabChannelCoverInfo.mChannelCoverId = ((int)PBFieldUtils.a(paramChannel.uint64_channel_id));
    localTabChannelCoverInfo.mChannelCoverName = PBFieldUtils.a(paramChannel.str_channel_name);
    if ((paramChannel.msg_red_point.has()) && (paramChannel.msg_red_point.uint64_start_time.has()) && (paramChannel.msg_red_point.uint64_end_time.has()))
    {
      localTabChannelCoverInfo.redPoint = new TabChannelCoverInfo.RedPoint();
      localTabChannelCoverInfo.redPoint.a = PBFieldUtils.a(paramChannel.msg_red_point.bool_red_point);
      localTabChannelCoverInfo.redPoint.b = paramChannel.msg_red_point.uint64_start_time.get();
      localTabChannelCoverInfo.redPoint.c = paramChannel.msg_red_point.uint64_end_time.get();
      localTabChannelCoverInfo.redPoint.e = paramChannel.msg_red_point.uint32_type.get();
      localTabChannelCoverInfo.redPoint.f = PBFieldUtils.a(paramChannel.msg_red_point.str_title_text);
      localTabChannelCoverInfo.redPoint.g = paramChannel.msg_red_point.uint32_title_color.get();
      localTabChannelCoverInfo.redPoint.h = paramChannel.msg_red_point.uint32_bg_color.get();
    }
    localTabChannelCoverInfo.mChannelCoverPicUrl = PBFieldUtils.a(paramChannel.str_cover_url);
    localTabChannelCoverInfo.mIconUrl = PBFieldUtils.a(paramChannel.str_icon_url);
    if ((paramChannel.str_web_url.has()) && (!TextUtils.isEmpty(paramChannel.str_web_url.get())))
    {
      localTabChannelCoverInfo.mChannelJumpUrl = paramChannel.str_web_url.get();
      localTabChannelCoverInfo.mColumnType = 1;
    }
    else
    {
      localTabChannelCoverInfo.mColumnType = 0;
    }
    localTabChannelCoverInfo.startTimestamp = PBFieldUtils.a(paramChannel.uint64_start_time);
    localTabChannelCoverInfo.endTimestamp = PBFieldUtils.a(paramChannel.uint64_end_time);
    localTabChannelCoverInfo.boldFont = PBFieldUtils.a(paramChannel.uint32_bold_font);
    localTabChannelCoverInfo.fontsColor = PBFieldUtils.a(paramChannel.uint32_fonts_color);
    localTabChannelCoverInfo.frameColor = PBFieldUtils.a(paramChannel.uint32_frame_color);
    localTabChannelCoverInfo.showCover = PBFieldUtils.a(paramChannel.uint32_show_cover);
    localTabChannelCoverInfo.showCover = PBFieldUtils.a(paramChannel.uint32_show_cover);
    localTabChannelCoverInfo.proxy = PBFieldUtils.a(paramChannel.str_proxy);
    localTabChannelCoverInfo.showIcon = PBFieldUtils.a(paramChannel.uint32_show_icon);
    localTabChannelCoverInfo.reason = PBFieldUtils.a(paramChannel.enum_reason);
    localTabChannelCoverInfo.onlyCover = PBFieldUtils.a(paramChannel.uint32_only_cover);
    localTabChannelCoverInfo.mChannelType = PBFieldUtils.a(paramChannel.uint32_channel_type);
    localTabChannelCoverInfo.sectionId = PBFieldUtils.a(paramChannel.uint64_section_id);
    localTabChannelCoverInfo.bid = PBFieldUtils.a(paramChannel.uint64_bid);
    b(localTabChannelCoverInfo);
    localTabChannelCoverInfo.dynamicSort = PBFieldUtils.a(paramChannel.uint32_dynamic_sort);
    localTabChannelCoverInfo.mChannelCoverIcon = PBFieldUtils.a(paramChannel.str_square_icon_url);
    localTabChannelCoverInfo.mChannelVersion = PBFieldUtils.a(paramChannel.str_channel_version);
    return localTabChannelCoverInfo;
  }
  
  public static ArrayList<AbsBaseArticleInfo> a(oidb_cmd0x68b.RspChannelArticle paramRspChannelArticle, List<oidb_cmd0x68b.RspGetFollowTabFeeds> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_cmd0x68b.RspGetFollowTabFeeds localRspGetFollowTabFeeds = (oidb_cmd0x68b.RspGetFollowTabFeeds)paramList.next();
      if ((localRspGetFollowTabFeeds.msg_article_summary.has()) && (localRspGetFollowTabFeeds.uint32_feeds_type.has()))
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = a((articlesummary.ArticleSummary)localRspGetFollowTabFeeds.msg_article_summary.get(), 70, 0, null);
        if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.mArticleID != -1L) && (localAbsBaseArticleInfo.mRecommendSeq != -1L))
        {
          if (localRspGetFollowTabFeeds.uint64_follow_recommend_id.has()) {
            localAbsBaseArticleInfo.mRecommendFollowId = localRspGetFollowTabFeeds.uint64_follow_recommend_id.get();
          }
          localAbsBaseArticleInfo.mFeedType = localRspGetFollowTabFeeds.uint32_feeds_type.get();
          a(paramRspChannelArticle, localAbsBaseArticleInfo);
          localArrayList.add(localAbsBaseArticleInfo);
        }
      }
    }
    return localArrayList;
  }
  
  public static List<ChannelInfo> a(List<oidb_cmd0x69f.ChannelInfo> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(a((oidb_cmd0x69f.ChannelInfo)paramList.next()));
      }
      return localArrayList;
    }
    return null;
  }
  
  public static List<InterestLabelInfo> a(List<oidb_cmd0x6e5.InterestLabelInfo> paramList, List<Integer> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    int j = 0;
    int i = k;
    if (paramList != null) {
      if (paramList.size() == 0)
      {
        i = k;
      }
      else
      {
        k = paramList.size();
        paramList = paramList.iterator();
        i = j;
        while (paramList.hasNext())
        {
          oidb_cmd0x6e5.InterestLabelInfo localInterestLabelInfo = (oidb_cmd0x6e5.InterestLabelInfo)paramList.next();
          InterestLabelInfo localInterestLabelInfo1 = new InterestLabelInfo();
          if (localInterestLabelInfo.uint32_interest_label_id.has()) {
            localInterestLabelInfo1.mInterestLabelID = localInterestLabelInfo.uint32_interest_label_id.get();
          }
          if ((localInterestLabelInfo.bytes_interest_label_name.has()) && (localInterestLabelInfo.bytes_interest_label_name.get() != null)) {
            localInterestLabelInfo1.mInterestLabelNme = localInterestLabelInfo.bytes_interest_label_name.get().toStringUtf8();
          }
          if ((paramList1 != null) && (!paramList1.isEmpty())) {
            localInterestLabelInfo1.mIsDefault = paramList1.contains(Integer.valueOf(localInterestLabelInfo1.mInterestLabelID));
          }
          if ((localInterestLabelInfo1.mInterestLabelNme != null) && (localInterestLabelInfo1.mInterestLabelNme.length() > 3))
          {
            i = a(i, k);
            localArrayList.add(i, localInterestLabelInfo1);
          }
          else
          {
            localArrayList.add(localInterestLabelInfo1);
          }
        }
        return localArrayList;
      }
    }
    while (i < a.length)
    {
      paramList = new InterestLabelInfo();
      paramList.mInterestLabelNme = a[i];
      paramList.mInterestLabelID = b[i].intValue();
      paramList.mIsDefault = c[i].booleanValue();
      localArrayList.add(paramList);
      i += 1;
    }
    return localArrayList;
  }
  
  public static List<AbsBaseArticleInfo> a(oidb_cmd0x68b.RspChannelArticle paramRspChannelArticle, List<articlesummary.ArticleSummary> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return null;
      }
      ArrayList localArrayList = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = a((articlesummary.ArticleSummary)paramList.next(), paramInt1, paramInt2, null);
        if (localAbsBaseArticleInfo != null) {
          localAbsBaseArticleInfo.recommendedFlag = paramInt3;
        }
        a(paramRspChannelArticle, localAbsBaseArticleInfo);
        localArrayList.add(localAbsBaseArticleInfo);
      }
      return localArrayList;
    }
    return null;
  }
  
  public static void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if ((paramTabChannelCoverInfo != null) && (paramTabChannelCoverInfo.mChannelCoverId == 70) && (!TextUtils.isEmpty(paramTabChannelCoverInfo.mChannelJumpUrl))) {
      RIJSPUtils.a("readinjoy_channel_follow_viola_url", paramTabChannelCoverInfo.mChannelJumpUrl);
    }
  }
  
  public static void a(oidb_cmd0x68b.RspChannelArticle paramRspChannelArticle, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramRspChannelArticle != null)
    {
      if (paramAbsBaseArticleInfo == null) {
        return;
      }
      paramRspChannelArticle = RIJPBFieldUtils.a(paramRspChannelArticle.bytes_req_query_id, "");
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("query_id", paramRspChannelArticle);
        localJSONObject.put("content_type", paramAbsBaseArticleInfo.dtReportContentType);
        localJSONObject.put("algo_id", paramAbsBaseArticleInfo.mAlgorithmID);
        localJSONObject.put("stragery_id", paramAbsBaseArticleInfo.mStrategyId);
        localJSONObject.put("recom_reason", paramAbsBaseArticleInfo.mRecommentdReason);
        paramAbsBaseArticleInfo.dtReportBackendInfo = localJSONObject.toString();
        return;
      }
      catch (JSONException paramRspChannelArticle)
      {
        QLog.e("ReadInJoyMSFHandlerUtils", 2, paramRspChannelArticle, new Object[0]);
      }
    }
  }
  
  public static List<TabChannelCoverInfo> b(List<channel_button.Channel> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TabChannelCoverInfo localTabChannelCoverInfo = a((channel_button.Channel)paramList.next());
        boolean bool = c(localTabChannelCoverInfo);
        QLog.d("ReadInJoyMSFHandlerUtils", 2, new Object[] { "channelID = ", Integer.valueOf(localTabChannelCoverInfo.mChannelCoverId), ", name = ", localTabChannelCoverInfo.mChannelCoverName, ", bid = ", Long.valueOf(localTabChannelCoverInfo.bid), ", isAvailable = ", Boolean.valueOf(bool) });
        if ((bool) && (localTabChannelCoverInfo.mChannelCoverId != 41449)) {
          localArrayList.add(localTabChannelCoverInfo);
        }
        a(localTabChannelCoverInfo);
      }
    }
    return localArrayList;
  }
  
  private static void b(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (paramTabChannelCoverInfo != null)
    {
      if (paramTabChannelCoverInfo.bid <= 0L) {
        return;
      }
      QLog.d("ReadInJoyMSFHandlerUtils", 2, new Object[] { "preDownloadDynamicChannel, channelCoverInfo = ", paramTabChannelCoverInfo });
      if (paramTabChannelCoverInfo.bid > 0L)
      {
        String str = ReadInJoyDynamicChannelBaseFragment.d(paramTabChannelCoverInfo.mChannelCoverId);
        StyleConfigHelper.a(str, String.valueOf(paramTabChannelCoverInfo.bid));
        StyleConfigHelper.d(str);
        try
        {
          ReadInJoyDynamicChannelBaseFragment.a(str);
          return;
        }
        catch (Exception paramTabChannelCoverInfo)
        {
          QLog.d("ReadInJoyMSFHandlerUtils", 2, "preDownloadDynamicChannel, e = ", paramTabChannelCoverInfo);
        }
      }
    }
  }
  
  public static List<DislikeResult> c(List<oidb_cmd0x46f.DislikeResult> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return localArrayList;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        oidb_cmd0x46f.DislikeResult localDislikeResult = (oidb_cmd0x46f.DislikeResult)paramList.next();
        DislikeResult localDislikeResult1 = new DislikeResult();
        if (localDislikeResult.uint64_articleid.has()) {
          localDislikeResult1.a = localDislikeResult.uint64_articleid.get();
        }
        if (localDislikeResult.uint32_result.has()) {
          localDislikeResult1.b = localDislikeResult.uint32_result.get();
        }
        if (localDislikeResult.str_message.has()) {
          localDislikeResult1.c = localDislikeResult.str_message.get();
        }
        localArrayList.add(localDislikeResult1);
      }
    }
    return localArrayList;
  }
  
  private static boolean c(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (paramTabChannelCoverInfo.bid <= 0L) {
      return true;
    }
    if (paramTabChannelCoverInfo.bid > 0L)
    {
      if (!Utils.a()) {
        return false;
      }
      try
      {
        paramTabChannelCoverInfo = ReadInJoyDynamicChannelBaseFragment.a(ReadInJoyDynamicChannelBaseFragment.d(paramTabChannelCoverInfo.mChannelCoverId));
        if (paramTabChannelCoverInfo != null)
        {
          paramTabChannelCoverInfo = paramTabChannelCoverInfo.f();
          if (paramTabChannelCoverInfo != null)
          {
            paramTabChannelCoverInfo = paramTabChannelCoverInfo.b("cgi");
            QLog.d("ReadInJoyMSFHandlerUtils", 2, new Object[] { "isDynamicChannelAvailable, cgi = ", paramTabChannelCoverInfo });
            if (TextUtils.isEmpty(paramTabChannelCoverInfo)) {
              return true;
            }
            boolean bool = ProteusJsHelper.b();
            return bool;
          }
        }
      }
      catch (Exception paramTabChannelCoverInfo)
      {
        QLog.d("ReadInJoyMSFHandlerUtils", 2, "isDynamicChannelAvailable, e = ", paramTabChannelCoverInfo);
      }
    }
    return false;
  }
  
  public static void d(List<AbsBaseArticleInfo> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        RIJPreParseData.b((AbsBaseArticleInfo)paramList.next());
      }
    }
  }
  
  public static List<TagInfo> e(List<oidb_cmd0xb83.TagInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        oidb_cmd0xb83.TagInfo localTagInfo = (oidb_cmd0xb83.TagInfo)paramList.next();
        localArrayList.add(new TagInfo(localTagInfo.uint64_tag_id.get(), localTagInfo.bytes_tag_name.get().toStringUtf8(), localTagInfo.double_tag_score.get(), localTagInfo.uint64_channel.get()));
      }
    }
    return localArrayList;
  }
  
  public static List<TopicInfo> f(List<oidb_cmd0xbde.TopicInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        oidb_cmd0xbde.TopicInfo localTopicInfo = (oidb_cmd0xbde.TopicInfo)paramList.next();
        localArrayList.add(TopicInfo.g().a(localTopicInfo.uint64_topic_id.get()).a(localTopicInfo.bytes_topic_name.get().toStringUtf8()).b(localTopicInfo.bytes_topic_summary.get().toStringUtf8()).c(localTopicInfo.bytes_topic_cover_url.get().toStringUtf8()).d(localTopicInfo.bytes_topic_url.get().toStringUtf8()).c(localTopicInfo.uint64_discuss_num.get()).b(localTopicInfo.uint64_read_num.get()).a());
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.msf.ReadInJoyMSFHandlerUtils
 * JD-Core Version:    0.7.0.1
 */