import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.basic.ReadInJoyDynamicChannelBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.ProteusJsHelper;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.InterestLabelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.common.app.BaseApplicationImpl;
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

public class qxm
{
  private static Boolean[] jdField_a_of_type_ArrayOfJavaLangBoolean = { Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false) };
  private static Integer[] jdField_a_of_type_ArrayOfJavaLangInteger;
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { anvx.a(2131712272), anvx.a(2131712586), anvx.a(2131712258), anvx.a(2131712305), anvx.a(2131712265), anvx.a(2131712593), anvx.a(2131712447), anvx.a(2131712522), anvx.a(2131712392), anvx.a(2131712215) };
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangInteger = new Integer[] { Integer.valueOf(4779), Integer.valueOf(1166), Integer.valueOf(5293), Integer.valueOf(501), Integer.valueOf(73), Integer.valueOf(5729), Integer.valueOf(1314), Integer.valueOf(3817), Integer.valueOf(3689), Integer.valueOf(3076) };
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      if ((paramInt1 % 5 == 0) || (paramInt1 % 5 == 1)) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return 0;
  }
  
  public static ArticleInfo a(articlesummary.ArticleSummary paramArticleSummary, int paramInt1, int paramInt2, ArticleInfo paramArticleInfo)
  {
    if (paramArticleSummary == null) {
      return null;
    }
    ArticleInfo localArticleInfo = paramArticleInfo;
    if (paramArticleInfo == null) {
      localArticleInfo = new ArticleInfo();
    }
    localArticleInfo.mChannelID = paramInt1;
    paramArticleInfo = new qxk();
    paramArticleInfo.a(paramArticleSummary, paramInt1, paramInt2, localArticleInfo);
    if (localArticleInfo.scripCmsInfo != null)
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      qjw.a(BaseApplicationImpl.getApplication(), (String)localObject, qjw.a(BaseApplicationImpl.getApplication(), (String)localObject) + 1);
    }
    Object localObject = (articlesummary.AwesomeCommentInfo)qdv.a(paramArticleSummary.awesome_comment_icon, null);
    if (localObject != null)
    {
      localArticleInfo.hasAwesome = true;
      roq.a(localArticleInfo, (articlesummary.AwesomeCommentInfo)localObject);
    }
    localObject = (articlesummary.SubscriptInfo)qdv.a(paramArticleSummary.msg_subscript_20, null);
    if (localObject != null) {
      rrw.a(localArticleInfo, (articlesummary.SubscriptInfo)localObject);
    }
    pqa.b(localArticleInfo);
    paramArticleInfo.k(paramArticleSummary, localArticleInfo);
    return localArticleInfo;
  }
  
  public static ChannelCoverInfo a(oidb_cmd0x69f.ChannelInfo paramChannelInfo, int paramInt)
  {
    ChannelCoverInfo localChannelCoverInfo1 = new ChannelCoverInfo();
    new qxk().a(paramChannelInfo, paramInt, localChannelCoverInfo1);
    paramChannelInfo = pvj.a().a(paramInt);
    if ((paramChannelInfo == null) || (paramChannelInfo.size() == 0)) {
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
    localChannelInfo.mChannelID = qdv.a(paramChannelInfo.uint32_channel_id);
    localChannelInfo.mChannelName = qdv.a(paramChannelInfo.bytes_channel_name, "");
    localChannelInfo.mChannelType = qdv.a(paramChannelInfo.uint32_channel_type);
    if (localChannelInfo.mChannelType == 1) {
      if (qdv.a(paramChannelInfo.uint32_is_first_req) == 0) {
        break label113;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      localChannelInfo.mIsFirstReq = bool;
      localChannelInfo.mFrameColor = qdv.a(paramChannelInfo.uint32_frame_color);
      localChannelInfo.mFontColor = qdv.a(paramChannelInfo.uint32_fonts_color);
      try
      {
        localChannelInfo.mJumpUrl = new String(qdv.a(paramChannelInfo.bytes_channel_jump_url), "utf-8");
        return localChannelInfo;
      }
      catch (Exception paramChannelInfo)
      {
        label113:
        QLog.d("ChannelInfoModule", 1, "resolve search channel jump url failed " + paramChannelInfo.toString());
      }
    }
    return localChannelInfo;
  }
  
  public static TabChannelCoverInfo a(channel_button.Channel paramChannel)
  {
    TabChannelCoverInfo localTabChannelCoverInfo = new TabChannelCoverInfo();
    localTabChannelCoverInfo.mChannelCoverId = ((int)qdv.a(paramChannel.uint64_channel_id));
    localTabChannelCoverInfo.mChannelCoverName = qdv.a(paramChannel.str_channel_name);
    if ((paramChannel.msg_red_point.has()) && (paramChannel.msg_red_point.uint64_start_time.has()) && (paramChannel.msg_red_point.uint64_end_time.has()))
    {
      localTabChannelCoverInfo.redPoint = new rrx();
      localTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean = qdv.a(paramChannel.msg_red_point.bool_red_point);
      localTabChannelCoverInfo.redPoint.jdField_a_of_type_Long = paramChannel.msg_red_point.uint64_start_time.get();
      localTabChannelCoverInfo.redPoint.jdField_b_of_type_Long = paramChannel.msg_red_point.uint64_end_time.get();
      localTabChannelCoverInfo.redPoint.jdField_a_of_type_Int = paramChannel.msg_red_point.uint32_type.get();
      localTabChannelCoverInfo.redPoint.jdField_a_of_type_JavaLangString = qdv.a(paramChannel.msg_red_point.str_title_text);
      localTabChannelCoverInfo.redPoint.jdField_b_of_type_Int = paramChannel.msg_red_point.uint32_title_color.get();
      localTabChannelCoverInfo.redPoint.c = paramChannel.msg_red_point.uint32_bg_color.get();
    }
    localTabChannelCoverInfo.mChannelCoverPicUrl = qdv.a(paramChannel.str_cover_url);
    localTabChannelCoverInfo.mIconUrl = qdv.a(paramChannel.str_icon_url);
    if ((paramChannel.str_web_url.has()) && (!TextUtils.isEmpty(paramChannel.str_web_url.get()))) {
      localTabChannelCoverInfo.mChannelJumpUrl = paramChannel.str_web_url.get();
    }
    for (localTabChannelCoverInfo.mColumnType = 1;; localTabChannelCoverInfo.mColumnType = 0)
    {
      localTabChannelCoverInfo.startTimestamp = qdv.a(paramChannel.uint64_start_time);
      localTabChannelCoverInfo.endTimestamp = qdv.a(paramChannel.uint64_end_time);
      localTabChannelCoverInfo.boldFont = qdv.a(paramChannel.uint32_bold_font);
      localTabChannelCoverInfo.fontsColor = qdv.a(paramChannel.uint32_fonts_color);
      localTabChannelCoverInfo.frameColor = qdv.a(paramChannel.uint32_frame_color);
      localTabChannelCoverInfo.showCover = qdv.a(paramChannel.uint32_show_cover);
      localTabChannelCoverInfo.showCover = qdv.a(paramChannel.uint32_show_cover);
      localTabChannelCoverInfo.proxy = qdv.a(paramChannel.str_proxy);
      localTabChannelCoverInfo.showIcon = qdv.a(paramChannel.uint32_show_icon);
      localTabChannelCoverInfo.reason = qdv.a(paramChannel.enum_reason);
      localTabChannelCoverInfo.onlyCover = qdv.a(paramChannel.uint32_only_cover);
      localTabChannelCoverInfo.mChannelType = qdv.a(paramChannel.uint32_channel_type);
      localTabChannelCoverInfo.sectionId = qdv.a(paramChannel.uint64_section_id);
      localTabChannelCoverInfo.bid = qdv.a(paramChannel.uint64_bid);
      a(localTabChannelCoverInfo);
      localTabChannelCoverInfo.dynamicSort = qdv.a(paramChannel.uint32_dynamic_sort);
      localTabChannelCoverInfo.mChannelCoverIcon = qdv.a(paramChannel.str_square_icon_url);
      localTabChannelCoverInfo.mChannelVersion = qdv.a(paramChannel.str_channel_version);
      return localTabChannelCoverInfo;
    }
  }
  
  public static ArrayList<ArticleInfo> a(oidb_cmd0x68b.RspChannelArticle paramRspChannelArticle, List<oidb_cmd0x68b.RspGetFollowTabFeeds> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_cmd0x68b.RspGetFollowTabFeeds localRspGetFollowTabFeeds = (oidb_cmd0x68b.RspGetFollowTabFeeds)paramList.next();
      if ((localRspGetFollowTabFeeds.msg_article_summary.has()) && (localRspGetFollowTabFeeds.uint32_feeds_type.has()))
      {
        ArticleInfo localArticleInfo = a((articlesummary.ArticleSummary)localRspGetFollowTabFeeds.msg_article_summary.get(), 70, 0, null);
        if ((localArticleInfo != null) && (localArticleInfo.mArticleID != -1L) && (localArticleInfo.mRecommendSeq != -1L))
        {
          if (localRspGetFollowTabFeeds.uint64_follow_recommend_id.has()) {
            localArticleInfo.mRecommendFollowId = localRspGetFollowTabFeeds.uint64_follow_recommend_id.get();
          }
          localArticleInfo.mFeedType = localRspGetFollowTabFeeds.uint32_feeds_type.get();
          a(paramRspChannelArticle, localArticleInfo);
          localArrayList.add(localArticleInfo);
        }
      }
    }
    return localArrayList;
  }
  
  public static List<ChannelInfo> a(List<oidb_cmd0x69f.ChannelInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((oidb_cmd0x69f.ChannelInfo)paramList.next()));
    }
    return localArrayList;
  }
  
  public static List<InterestLabelInfo> a(List<oidb_cmd0x6e5.InterestLabelInfo> paramList, List<Integer> paramList1)
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    int i = j;
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        i = j;
      }
    }
    else
    {
      while (i < jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        paramList = new InterestLabelInfo();
        paramList.mInterestLabelNme = jdField_a_of_type_ArrayOfJavaLangString[i];
        paramList.mInterestLabelID = jdField_a_of_type_ArrayOfJavaLangInteger[i].intValue();
        paramList.mIsDefault = jdField_a_of_type_ArrayOfJavaLangBoolean[i].booleanValue();
        localArrayList.add(paramList);
        i += 1;
      }
      return localArrayList;
    }
    j = paramList.size();
    paramList = paramList.iterator();
    i = 0;
    if (paramList.hasNext())
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
        i = a(i, j);
        localArrayList.add(i, localInterestLabelInfo1);
      }
      for (;;)
      {
        break;
        localArrayList.add(localInterestLabelInfo1);
      }
    }
    return localArrayList;
  }
  
  public static List<ArticleInfo> a(oidb_cmd0x68b.RspChannelArticle paramRspChannelArticle, List<articlesummary.ArticleSummary> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ArticleInfo localArticleInfo = a((articlesummary.ArticleSummary)paramList.next(), paramInt1, paramInt2, null);
      if (localArticleInfo != null) {
        localArticleInfo.recommentFlag = paramInt3;
      }
      a(paramRspChannelArticle, localArticleInfo);
      localArrayList.add(localArticleInfo);
    }
    return localArrayList;
  }
  
  private static void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if ((paramTabChannelCoverInfo == null) || (paramTabChannelCoverInfo.bid <= 0L)) {}
    do
    {
      return;
      QLog.d("ReadInJoyMSFHandlerUtils", 2, new Object[] { "preDownloadDynamicChannel, channelCoverInfo = ", paramTabChannelCoverInfo });
    } while (paramTabChannelCoverInfo.bid <= 0L);
    String str = ReadInJoyDynamicChannelBaseFragment.a(paramTabChannelCoverInfo.mChannelCoverId);
    tmk.a(str, String.valueOf(paramTabChannelCoverInfo.bid));
    tmk.b(str);
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
  
  public static void a(List<ArticleInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        pqa.b((ArticleInfo)paramList.next());
      }
    }
  }
  
  public static void a(oidb_cmd0x68b.RspChannelArticle paramRspChannelArticle, BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramRspChannelArticle == null) || (paramBaseArticleInfo == null)) {
      return;
    }
    paramRspChannelArticle = qxl.a(paramRspChannelArticle.bytes_req_query_id, "");
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("query_id", paramRspChannelArticle);
      localJSONObject.put("content_type", paramBaseArticleInfo.dtReportContentType);
      localJSONObject.put("algo_id", paramBaseArticleInfo.mAlgorithmID);
      localJSONObject.put("stragery_id", paramBaseArticleInfo.mStrategyId);
      localJSONObject.put("recom_reason", paramBaseArticleInfo.mRecommentdReason);
      paramBaseArticleInfo.dtReportBackendInfo = localJSONObject.toString();
      return;
    }
    catch (JSONException paramRspChannelArticle)
    {
      QLog.e("ReadInJoyMSFHandlerUtils", 2, paramRspChannelArticle, new Object[0]);
    }
  }
  
  private static boolean a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (paramTabChannelCoverInfo.bid <= 0L) {}
    for (;;)
    {
      return true;
      if (paramTabChannelCoverInfo.bid > 0L)
      {
        if (!ptv.a()) {
          return false;
        }
        try
        {
          paramTabChannelCoverInfo = ReadInJoyDynamicChannelBaseFragment.a(ReadInJoyDynamicChannelBaseFragment.a(paramTabChannelCoverInfo.mChannelCoverId));
          if (paramTabChannelCoverInfo != null)
          {
            paramTabChannelCoverInfo = paramTabChannelCoverInfo.a();
            if (paramTabChannelCoverInfo != null)
            {
              paramTabChannelCoverInfo = paramTabChannelCoverInfo.b("cgi");
              QLog.d("ReadInJoyMSFHandlerUtils", 2, new Object[] { "isDynamicChannelAvailable, cgi = ", paramTabChannelCoverInfo });
              if (TextUtils.isEmpty(paramTabChannelCoverInfo)) {
                continue;
              }
              boolean bool = ProteusJsHelper.preLoadSo();
              return bool;
            }
          }
        }
        catch (Exception paramTabChannelCoverInfo)
        {
          QLog.d("ReadInJoyMSFHandlerUtils", 2, "isDynamicChannelAvailable, e = ", paramTabChannelCoverInfo);
        }
      }
    }
    return false;
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
        boolean bool = a(localTabChannelCoverInfo);
        QLog.d("ReadInJoyMSFHandlerUtils", 2, new Object[] { "channelID = ", Integer.valueOf(localTabChannelCoverInfo.mChannelCoverId), ", name = ", localTabChannelCoverInfo.mChannelCoverName, ", bid = ", Long.valueOf(localTabChannelCoverInfo.bid), ", isAvailable = ", Boolean.valueOf(bool) });
        if ((bool) && (localTabChannelCoverInfo.mChannelCoverId != 41449)) {
          localArrayList.add(localTabChannelCoverInfo);
        }
      }
    }
    return localArrayList;
  }
  
  public static List<rpa> c(List<oidb_cmd0x46f.DislikeResult> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() == 0)) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_cmd0x46f.DislikeResult localDislikeResult = (oidb_cmd0x46f.DislikeResult)paramList.next();
      rpa localrpa = new rpa();
      if (localDislikeResult.uint64_articleid.has()) {
        localrpa.jdField_a_of_type_Long = localDislikeResult.uint64_articleid.get();
      }
      if (localDislikeResult.uint32_result.has()) {
        localrpa.jdField_a_of_type_Int = localDislikeResult.uint32_result.get();
      }
      if (localDislikeResult.str_message.has()) {
        localrpa.jdField_a_of_type_JavaLangString = localDislikeResult.str_message.get();
      }
      localArrayList.add(localrpa);
    }
    return localArrayList;
  }
  
  public static List<TagInfo> d(List<oidb_cmd0xb83.TagInfo> paramList)
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
  
  public static List<TopicInfo> e(List<oidb_cmd0xbde.TopicInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        oidb_cmd0xbde.TopicInfo localTopicInfo = (oidb_cmd0xbde.TopicInfo)paramList.next();
        localArrayList.add(TopicInfo.a().a(localTopicInfo.uint64_topic_id.get()).a(localTopicInfo.bytes_topic_name.get().toStringUtf8()).b(localTopicInfo.bytes_topic_summary.get().toStringUtf8()).c(localTopicInfo.bytes_topic_cover_url.get().toStringUtf8()).d(localTopicInfo.bytes_topic_url.get().toStringUtf8()).a());
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qxm
 * JD-Core Version:    0.7.0.1
 */