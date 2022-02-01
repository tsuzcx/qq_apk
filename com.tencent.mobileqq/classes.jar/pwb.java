import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.1;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.10;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.11;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.13;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.14;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.15;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.16;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.17;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.18;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.19;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.2;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.20;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.21;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.23;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.24;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.25;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.26;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.27;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.28;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.29;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.30;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.31;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.32;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.33;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.34;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.35;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.36;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.37;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.38;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.39;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.40;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.41;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.42;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.43;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.44;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.45;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.46;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.47;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.48;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.49;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.5;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.50;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.51;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.52;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.53;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.54;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.55;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.6;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.7;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.8;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.9;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleExposureInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelTopCookie;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.LebaKDCellInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.JumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVoiceInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VisibleSetParam;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ResultRecord;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.feeds_info.AccountProfile;
import tencent.im.oidb.articlesummary.feeds_info.BiuMultiLevel;
import tencent.im.oidb.articlesummary.feeds_info.BiuOneLevelItem;
import tencent.im.oidb.articlesummary.feeds_info.FeedsInfo;
import tencent.im.oidb.articlesummary.feeds_info.JumpInfo;
import tencent.im.oidb.articlesummary.feeds_info.LocationInfo;
import tencent.im.oidb.articlesummary.feeds_info.NowLiveInfo;
import tencent.im.oidb.articlesummary.feeds_info.PGCFeedsInfo;
import tencent.im.oidb.articlesummary.feeds_info.PGCPicInfo;
import tencent.im.oidb.articlesummary.feeds_info.PGCVideoInfo;
import tencent.im.oidb.articlesummary.feeds_info.ShareWebPageInfo;
import tencent.im.oidb.articlesummary.feeds_info.SocializeFeedsInfo;
import tencent.im.oidb.articlesummary.feeds_info.SocializeFeedsInfoUser;
import tencent.im.oidb.articlesummary.feeds_info.TagInfo;
import tencent.im.oidb.articlesummary.feeds_info.TopicRecommendFeedsInfo;
import tencent.im.oidb.articlesummary.feeds_info.TopicRecommendFeedsTitle;
import tencent.im.oidb.articlesummary.feeds_info.TopicRecommendInfo;
import tencent.im.oidb.articlesummary.feeds_info.UGCFeedsInfo;
import tencent.im.oidb.articlesummary.feeds_info.UGCPicInfo;
import tencent.im.oidb.articlesummary.feeds_info.UGCVideoInfo;
import tencent.im.oidb.articlesummary.feeds_info.UGCVoiceInfo;
import tencent.im.oidb.articlesummary.feeds_info.VisibleInfo;
import tencent.im.oidb.articlesummary.feeds_info.VisibleSetParam;
import tencent.im.oidb.cmd0x46f.oidb_cmd0x46f.DislikeParam;
import tencent.im.oidb.cmd0x46f.oidb_cmd0x46f.ReqBody;
import tencent.im.oidb.cmd0x46f.oidb_cmd0x46f.RspBody;
import tencent.im.oidb.cmd0x46f.oidb_cmd0x46f.UserDisLike;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ChannelLocationInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ExposeArticleInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ExposeTopic;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.InnerMsg;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.PkgInstallInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RefreshHistory;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqAdvertisePara;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqBody;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqChannelPara;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqGetFollowTabPara;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspBody;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspChannelArticle;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspGetFollowTabData;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.SubscribeMsg;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.UserExposeArticle;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.UserReadArticle;
import tencent.im.oidb.cmd0x75e.oidb_cmd0x75e.ArticleInfo;
import tencent.im.oidb.cmd0x75e.oidb_cmd0x75e.ReqBody;
import tencent.im.oidb.cmd0x75e.oidb_cmd0x75e.ReqPara;
import tencent.im.oidb.cmd0x75e.oidb_cmd0x75e.RspArticle;
import tencent.im.oidb.cmd0x75e.oidb_cmd0x75e.RspBody;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.FeedsInfo;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.ReqBody;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.RspBody;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.SocializeFeedsInfo;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.RspBody;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.SocializeFeedsInfo;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.TopicRecommendFeedsInfo;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.TopicRecommendInfo;
import tencent.im.oidb.cmd0xa6e.oidb_cmd0xa6e.RspBody;
import tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.ReqBody;
import tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.ReqRecommendTagInfo;
import tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.ReqSearchTagInfo;
import tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.RspBody;
import tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.RspRecommendTagInfo;
import tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.RspSearchTagInfo;
import tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.SearchInfo;
import tencent.im.oidb.cmd0xbbd.oidb_cmd0xbbd.ReqBody;
import tencent.im.oidb.cmd0xbbd.oidb_cmd0xbbd.ReqFeedsInfo;
import tencent.im.oidb.cmd0xbbd.oidb_cmd0xbbd.ReqPara;
import tencent.im.oidb.cmd0xbbd.oidb_cmd0xbbd.RspBody;
import tencent.im.oidb.cmd0xbbd.oidb_cmd0xbbd.RspFeedsData;
import tencent.im.oidb.cmd0xbbd.oidb_cmd0xbbd.RspFeedsInfo;
import tencent.im.oidb.cmd0xbd4.oidb_cmd0xbd4.InviteReq;
import tencent.im.oidb.cmd0xbd4.oidb_cmd0xbd4.Invitee;
import tencent.im.oidb.cmd0xbd4.oidb_cmd0xbd4.ReqBody;
import tencent.im.oidb.cmd0xbd4.oidb_cmd0xbd4.RspBody;
import tencent.im.oidb.cmd0xbd6.oidb_cmd0xbd6.RspBody;
import tencent.im.oidb.cmd0xbde.oidb_cmd0xbde.ReqBody;
import tencent.im.oidb.cmd0xbde.oidb_cmd0xbde.ReqSearchTopicInfo;
import tencent.im.oidb.cmd0xbde.oidb_cmd0xbde.RspBody;
import tencent.im.oidb.cmd0xbde.oidb_cmd0xbde.RspSearchTopicResult;
import tencent.im.oidb.cmd0xbde.oidb_cmd0xbde.SearchInfo;
import tencent.im.oidb.cmd0xc16.oidb_cmd0xc16.ReqBody;
import tencent.im.oidb.cmd0xc16.oidb_cmd0xc16.RspBody;
import tencent.im.oidb.cmd0xc32.oidb_cmd0xc32.GetVisibleListReqBody;
import tencent.im.oidb.cmd0xc32.oidb_cmd0xc32.GetVisibleListRspBody;
import tencent.im.oidb.cmd0xc32.oidb_cmd0xc32.ReqBody;
import tencent.im.oidb.cmd0xc32.oidb_cmd0xc32.RspBody;
import tencent.im.oidb.cmd0xc5b.cmd0xc5b.ReqBody;
import tencent.im.oidb.cmd0xc5b.cmd0xc5b.RspBody;
import tencent.im.oidb.cmd0xc6d.oidb_cmd0xc6d.ReqBody;
import tencent.im.oidb.cmd0xc6d.oidb_cmd0xc6d.RspBody;

public class pwb
  extends pxz
{
  private static long jdField_a_of_type_Long = 1800000L;
  private static volatile com.tencent.util.Pair<List<Long>, oidb_cmd0x68b.RspBody> jdField_a_of_type_ComTencentUtilPair;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static volatile List<Long> jdField_b_of_type_JavaUtilList = new ArrayList();
  private static boolean jdField_b_of_type_Boolean;
  private static volatile int jdField_c_of_type_Int = -1;
  private static volatile boolean jdField_c_of_type_Boolean;
  public int a;
  private HashMap<Long, AtomicBoolean> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private LinkedHashMap<Integer, ConcurrentHashMap<Long, ArticleInfo>> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  public List<rfc> a;
  private Map<Integer, ChannelTopCookie> jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  private pwe jdField_a_of_type_Pwe;
  private pwf jdField_a_of_type_Pwf;
  pxn jdField_a_of_type_Pxn = new pxn(this);
  private boolean jdField_a_of_type_Boolean;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = { "com.tencent.weishi", "com.tencent.reading", "com.tencent.mtt", "com.tencent.qqlive", "com.tencent.news" };
  private final int jdField_b_of_type_Int = 30;
  private LinkedHashMap<Integer, ConcurrentHashMap<Long, Boolean>> jdField_b_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private Map<Integer, CopyOnWriteArrayList<ArticleInfo>> jdField_b_of_type_JavaUtilMap = new HashMap();
  private LinkedHashMap<Integer, ConcurrentHashMap<String, ArticleExposureInfo>> jdField_c_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private LinkedHashMap<Integer, ConcurrentHashMap<String, ArticleInfo>> d;
  
  public pwb(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, qnd paramqnd, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramqnd, paramHandler);
    this.jdField_d_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  }
  
  public static int a()
  {
    return jdField_c_of_type_Int;
  }
  
  private int a(FromServiceMsg paramFromServiceMsg, Object paramObject, MessageMicro paramMessageMicro)
  {
    int j = qnf.a(paramFromServiceMsg, paramObject, paramMessageMicro);
    QLog.d("ArticleInfoModule", 1, "parse0x83eRspResultCode result code :" + j);
    int i = j;
    if (j == 84) {
      i = 0;
    }
    return i;
  }
  
  private int a(ToServiceMsg paramToServiceMsg)
  {
    try
    {
      paramToServiceMsg = paramToServiceMsg.getAttribute("recommendFlag");
      if (paramToServiceMsg == null) {
        return 0;
      }
      QLog.d("ArticleInfoModule", 1, " " + paramToServiceMsg);
      int i = ((Integer)paramToServiceMsg).intValue();
      return i;
    }
    catch (Exception paramToServiceMsg) {}
    return 0;
  }
  
  private int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1;
    }
    return 0;
  }
  
  private static ArticleInfo a(ArticleInfo paramArticleInfo)
  {
    ArticleInfo localArticleInfo = paramArticleInfo;
    if (pfa.a(paramArticleInfo))
    {
      QLog.d("ArticleInfoModule", 1, "过滤卡片: " + paramArticleInfo + "  social : " + paramArticleInfo.mSocialFeedInfo);
      localArticleInfo = null;
    }
    return localArticleInfo;
  }
  
  private ToServiceMsg a(qni paramqni)
  {
    if (paramqni == null) {}
    while (paramqni.jdField_b_of_type_Int == -1) {
      return null;
    }
    paramqni.jdField_a_of_type_Int = 5;
    paramqni.jdField_a_of_type_Boolean = true;
    oidb_cmd0x68b.ReqBody localReqBody = new oidb_cmd0x68b.ReqBody();
    long l1 = pgs.a();
    long l2 = Long.valueOf(pha.a()).longValue();
    localReqBody.uint64_uin.set(l2);
    localReqBody.uint32_network_type.set(b());
    oidb_cmd0x68b.ReqChannelPara localReqChannelPara = new oidb_cmd0x68b.ReqChannelPara();
    localReqChannelPara.uint64_channel_id.set(paramqni.jdField_b_of_type_Int);
    localReqChannelPara.uint32_req_channel_list.set(1);
    b(localReqChannelPara);
    rec.a(localReqChannelPara, String.valueOf(paramqni.jdField_b_of_type_Int));
    localReqChannelPara.uint32_residence_time.set((int)rec.a(paramqni.jdField_b_of_type_Int));
    if (paramqni.jdField_a_of_type_Long != -1L) {
      localReqChannelPara.uint64_begin_recommend_seq.set(paramqni.jdField_a_of_type_Long);
    }
    if (paramqni.jdField_b_of_type_Long != -1L) {
      localReqChannelPara.uint64_end_recommend_seq.set(paramqni.jdField_b_of_type_Long);
    }
    localReqChannelPara.uint32_req_article_list.set(a(paramqni.jdField_a_of_type_Boolean), paramqni.jdField_a_of_type_Boolean);
    localReqChannelPara.uint32_req_deleted_article_list.set(a(paramqni.jdField_b_of_type_Boolean), paramqni.jdField_b_of_type_Boolean);
    if (paramqni.jdField_a_of_type_JavaUtilList != null) {
      localReqChannelPara.rpt_curr_article_list.set(paramqni.jdField_a_of_type_JavaUtilList);
    }
    if (bdch.a())
    {
      paramqni.jdField_i_of_type_Int |= 0x2000;
      QLog.d("ArticleInfoModule", 1, "is study mode! channelID=" + paramqni.jdField_b_of_type_Int);
    }
    localReqChannelPara.uint32_req_recommend_flag.set(paramqni.jdField_i_of_type_Int);
    localReqChannelPara.bytes_req_recommend_json.set(ByteStringMicro.copyFromUtf8(pha.k()));
    localReqChannelPara.bytes_req_ug_interface_data.set(ByteStringMicro.copyFromUtf8(pha.b()));
    localReqChannelPara.uint32_req_video_list.set(a(paramqni.jdField_d_of_type_Boolean));
    localReqChannelPara.uint32_req_picture_list.set(a(paramqni.jdField_e_of_type_Boolean));
    localReqChannelPara.uint32_need_force_set_top.set(a(paramqni.jdField_f_of_type_Boolean));
    if (paramqni.jdField_a_of_type_ArrayOfByte != null) {
      localReqChannelPara.bytes_set_top_cookie.set(ByteStringMicro.copyFrom(paramqni.jdField_a_of_type_ArrayOfByte));
    }
    if (paramqni.jdField_b_of_type_ArrayOfByte != null) {
      localReqChannelPara.bytes_device_id.set(ByteStringMicro.copyFrom(paramqni.jdField_b_of_type_ArrayOfByte));
    }
    localReqChannelPara.uint32_update_times.set(paramqni.jdField_c_of_type_Int);
    localReqChannelPara.uint32_req_media_specs.set(1);
    if (!bmqa.a(paramqni.jdField_d_of_type_Int)) {
      localReqChannelPara.uint32_is_support_video_with_small_picture.set(1);
    }
    localReqChannelPara.uint32_is_support_packinfo.set(1);
    localReqChannelPara.uint32_privacy_status.set(uaq.b());
    Object localObject;
    if (!TextUtils.isEmpty(Build.BRAND))
    {
      localObject = Build.BRAND;
      localReqChannelPara.bytes_manufacturer.set(ByteStringMicro.copyFromUtf8((String)localObject));
      if (TextUtils.isEmpty(Build.MODEL)) {
        break label950;
      }
    }
    label950:
    for (String str = Build.MODEL;; str = "")
    {
      localReqChannelPara.bytes_device_brand_and_model.set(ByteStringMicro.copyFromUtf8(str));
      if (paramqni.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData != null)
      {
        oidb_cmd0x68b.ChannelLocationInfo localChannelLocationInfo = new oidb_cmd0x68b.ChannelLocationInfo();
        localChannelLocationInfo.city.set(ByteStringMicro.copyFromUtf8(paramqni.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.city));
        localChannelLocationInfo.province.set(ByteStringMicro.copyFromUtf8(paramqni.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.province));
        localChannelLocationInfo.nation.set(ByteStringMicro.copyFromUtf8(paramqni.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.country));
        localChannelLocationInfo.city_code.set(ByteStringMicro.copyFromUtf8(paramqni.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.cityCode));
        localReqChannelPara.msg_channel_location_info.set(localChannelLocationInfo);
        if (QLog.isColorLevel()) {
          QLog.i("ArticleInfoModule", 1, "0x68b request positionInfo = " + paramqni.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData);
        }
      }
      QLog.i("ArticleInfoModule", 1, "0x68b request brand = " + (String)localObject + ", model = " + str);
      localObject = a(paramqni, localReqChannelPara);
      ptu.a(paramqni, (List)localObject);
      if (paramqni.jdField_b_of_type_JavaUtilList != null) {
        localReqChannelPara.rpt_subscription_article_list.set(paramqni.jdField_b_of_type_JavaUtilList);
      }
      a(paramqni, localReqChannelPara);
      a(localReqChannelPara);
      localReqChannelPara.rpt_inner_msg_list.set((List)localObject);
      localReqChannelPara.uint32_req_is_disp_timestamp.set(1);
      localReqChannelPara.uint32_is_support_gallery.set(1);
      localReqChannelPara.uint32_req_picture_number.set(1);
      c(paramqni, localReqChannelPara);
      b(paramqni, localReqChannelPara);
      int i = ((Integer)bmqa.a("key_sp_is_readinjoy_youngster", Integer.valueOf(0))).intValue();
      localReqChannelPara.uint32_youngster_status.set(i);
      localReqBody.reqChannelPara.set(localReqChannelPara);
      localReqBody.reqChannelPara.setHasFlag(true);
      localReqBody.uint32_req_dislike_type.set(paramqni.jdField_e_of_type_Int);
      a(paramqni, localReqBody);
      if (pgs.b(l1)) {
        pgs.a(paramqni);
      }
      localReqBody.uint64_client_swithes.set(paramqni.jdField_f_of_type_Int);
      localReqBody.enum_refresh_type.set(paramqni.jdField_g_of_type_Int);
      b(paramqni, localReqBody);
      c(paramqni, localReqBody);
      localReqBody.uint32_req_sim_type.set(bmqa.b());
      d(paramqni, localReqBody);
      return a(paramqni, localReqBody, l1);
      localObject = "";
      break;
    }
  }
  
  @NotNull
  private ToServiceMsg a(qni paramqni, oidb_cmd0x68b.ReqBody paramReqBody, long paramLong)
  {
    boolean bool2 = true;
    Object localObject;
    if (paramqni.jdField_b_of_type_Int == 41403)
    {
      localObject = qnf.a("OidbSvc.0xbf7", 3063, paramqni.j, paramReqBody.toByteArray());
      QLog.d("ArticleInfoModule", 1, new Object[] { "make 0xbf7 OIDB Pkg, beginSeq = ", Long.valueOf(paramqni.jdField_a_of_type_Long), ", endSeq = ", Long.valueOf(paramqni.jdField_b_of_type_Long) });
      ((ToServiceMsg)localObject).getAttributes().put(jdField_c_of_type_JavaLangString, Integer.valueOf(paramqni.jdField_a_of_type_Int));
      ((ToServiceMsg)localObject).getAttributes().put(jdField_d_of_type_JavaLangString, Long.valueOf(paramqni.jdField_a_of_type_Long));
      ((ToServiceMsg)localObject).getAttributes().put(jdField_e_of_type_JavaLangString, Long.valueOf(paramqni.jdField_b_of_type_Long));
      ((ToServiceMsg)localObject).getAttributes().put(jdField_f_of_type_JavaLangString, Integer.valueOf(1));
      ((ToServiceMsg)localObject).getAttributes().put(jdField_b_of_type_JavaLangString, Integer.valueOf(paramqni.jdField_g_of_type_Int));
      ((ToServiceMsg)localObject).getAttributes().put("recommendFlag", Integer.valueOf(paramqni.jdField_i_of_type_Int));
      if (paramqni.jdField_b_of_type_JavaUtilList != null) {
        ((ToServiceMsg)localObject).getAttributes().put("SubscriptionArticles", paramqni.jdField_b_of_type_JavaUtilList);
      }
      a(paramReqBody, (ToServiceMsg)localObject, paramLong);
      pgs.a((ToServiceMsg)localObject, paramLong);
      ((ToServiceMsg)localObject).getAttributes().put("channelID", new Integer(paramqni.jdField_b_of_type_Int));
      ((ToServiceMsg)localObject).getAttributes().put("isSingleHighLight", Boolean.valueOf(paramqni.jdField_g_of_type_Boolean));
      ((ToServiceMsg)localObject).getAttributes().put("clientSwithes", Integer.valueOf(paramqni.jdField_f_of_type_Int));
      paramReqBody = ((ToServiceMsg)localObject).getAttributes();
      if ((paramqni.jdField_b_of_type_JavaUtilList == null) || (paramqni.jdField_b_of_type_JavaUtilList.isEmpty())) {
        break label530;
      }
      bool1 = true;
      label310:
      paramReqBody.put("isRedRefreshReq", Boolean.valueOf(bool1));
      paramReqBody = ((ToServiceMsg)localObject).getAttributes();
      if ((paramqni.jdField_i_of_type_Int & 0x100) == 0) {
        break label536;
      }
    }
    label530:
    label536:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramReqBody.put("isFeedsPreload", Boolean.valueOf(bool1));
      return localObject;
      if ((pil.c(paramqni.jdField_b_of_type_Int)) || (bmqa.a(paramqni.jdField_b_of_type_Int)))
      {
        paramReqBody.bytes_style_version.set(ByteStringMicro.copyFromUtf8(tet.a("default_feeds")));
        if (bmqa.w())
        {
          localObject = pxs.a(paramqni.jdField_b_of_type_Int);
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramReqBody.bytes_nearby_cookie.set(ByteStringMicro.copyFromUtf8((String)localObject));
          }
          localObject = qnf.a("OidbSvc.0xcba", 3258, 0, paramReqBody.toByteArray());
          ((ToServiceMsg)localObject).getAttributes().put("realTimeServiceKey", "default_feeds");
          QLog.d("ArticleInfoModule", 1, new Object[] { "make 0xcba OIDB Pkg, beginSeq = ", Long.valueOf(paramqni.jdField_a_of_type_Long), ", endSeq = ", Long.valueOf(paramqni.jdField_b_of_type_Long) });
          break;
        }
      }
      localObject = qnf.a("OidbSvc.0x68b", 1675, paramqni.j, paramReqBody.toByteArray());
      break;
      bool1 = false;
      break label310;
    }
  }
  
  public static String a(List<Long> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Long localLong = (Long)paramList.next();
      localStringBuilder.append(localLong + " ");
    }
    return localStringBuilder.toString();
  }
  
  private List<Long> a(List<ArticleInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(Long.valueOf(((ArticleInfo)paramList.next()).mRecommendSeq));
    }
    return localArrayList;
  }
  
  @NotNull
  private List<oidb_cmd0x68b.InnerMsg> a(qni paramqni, oidb_cmd0x68b.ReqChannelPara paramReqChannelPara)
  {
    ArrayList localArrayList = new ArrayList();
    d(paramqni, localArrayList);
    if (!TextUtils.isEmpty(paramqni.jdField_a_of_type_JavaLangString)) {
      c(paramqni, localArrayList);
    }
    for (;;)
    {
      b(paramqni, localArrayList);
      a(paramqni, localArrayList);
      return localArrayList;
      if (paramqni.jdField_c_of_type_Long != -1L) {
        a(paramqni, paramReqChannelPara, localArrayList);
      }
    }
  }
  
  private feeds_info.BiuMultiLevel a(rgy paramrgy, ByteStringMicro paramByteStringMicro)
  {
    paramByteStringMicro = new feeds_info.BiuMultiLevel();
    if (paramrgy.jdField_a_of_type_JavaLangLong != null) {
      paramByteStringMicro.uint64_origin_feeds_id.set(paramrgy.jdField_a_of_type_JavaLangLong.longValue());
    }
    if (paramrgy.jdField_b_of_type_JavaLangLong != null) {
      paramByteStringMicro.uint64_origin_feeds_type.set(paramrgy.jdField_b_of_type_JavaLangLong.longValue());
    }
    paramrgy = paramrgy.jdField_a_of_type_JavaUtilList.iterator();
    while (paramrgy.hasNext())
    {
      SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)paramrgy.next();
      feeds_info.BiuOneLevelItem localBiuOneLevelItem = new feeds_info.BiuOneLevelItem();
      ByteStringMicro localByteStringMicro = ByteStringMicro.copyFromUtf8(localBiuCommentInfo.jdField_a_of_type_JavaLangString);
      localBiuOneLevelItem.bytes_biu_comments.set(localByteStringMicro);
      localBiuOneLevelItem.uint32_biu_time.set(localBiuCommentInfo.jdField_a_of_type_Int);
      localBiuOneLevelItem.uint64_feeds_id.set(localBiuCommentInfo.jdField_b_of_type_JavaLangLong.longValue());
      localBiuOneLevelItem.uint64_uin.set(localBiuCommentInfo.jdField_a_of_type_JavaLangLong.longValue());
      localBiuOneLevelItem.feeds_type.set(localBiuCommentInfo.jdField_b_of_type_Int);
      localBiuOneLevelItem.op_type.set(localBiuCommentInfo.jdField_c_of_type_Int);
      if (localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo != null)
      {
        localBiuOneLevelItem.msg_jump_info.set(new feeds_info.JumpInfo());
        localBiuOneLevelItem.msg_jump_info.uint64_id.set(localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo.a());
        localBiuOneLevelItem.msg_jump_info.bytes_wording.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo.a()));
        localBiuOneLevelItem.msg_jump_info.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo.b()));
      }
      if (localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo != null)
      {
        localBiuOneLevelItem.msg_voice_info.set(new feeds_info.UGCVoiceInfo());
        localBiuOneLevelItem.msg_voice_info.bytes_voice_url.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo.jdField_a_of_type_JavaLangString));
        localBiuOneLevelItem.msg_voice_info.uint32_duration.set(localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo.jdField_a_of_type_Int);
        localBiuOneLevelItem.msg_voice_info.uint32_file_size.set(localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo.jdField_b_of_type_Int);
      }
      paramByteStringMicro.rpt_biu_mutli_level.add(localBiuOneLevelItem);
    }
    return paramByteStringMicro;
  }
  
  private oidb_cmd0x46f.DislikeParam a(rfb paramrfb)
  {
    oidb_cmd0x46f.DislikeParam localDislikeParam = new oidb_cmd0x46f.DislikeParam();
    localDislikeParam.uint64_articleid.set(paramrfb.jdField_a_of_type_Long);
    localDislikeParam.uint32_reasonid.set(paramrfb.jdField_a_of_type_Int);
    localDislikeParam.uint64_feeds_id.set(paramrfb.jdField_b_of_type_Long);
    localDislikeParam.uint64_biu_uin.set(paramrfb.jdField_c_of_type_Long);
    localDislikeParam.uint64_topic_id.set(paramrfb.jdField_d_of_type_Long);
    if ((paramrfb.jdField_a_of_type_JavaLangString != null) && (paramrfb.jdField_a_of_type_JavaLangString.length() > 0)) {
      localDislikeParam.bytes_rowkey.set(ByteStringMicro.copyFromUtf8(paramrfb.jdField_a_of_type_JavaLangString));
    }
    Object localObject1;
    Object localObject2;
    if ((paramrfb.jdField_a_of_type_JavaUtilList != null) && (paramrfb.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      localObject1 = paramrfb.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Long)((Iterator)localObject1).next();
        localDislikeParam.rpt_uint64_tagid.add(localObject2);
      }
    }
    if ((paramrfb.jdField_a_of_type_JavaUtilArrayList != null) && (paramrfb.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      paramrfb = paramrfb.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramrfb.hasNext())
      {
        localObject1 = (DislikeInfo)paramrfb.next();
        localObject2 = new oidb_cmd0x46f.UserDisLike();
        ((oidb_cmd0x46f.UserDisLike)localObject2).bytes_dislike_account_id.set(ByteStringMicro.copyFromUtf8(((DislikeInfo)localObject1).jdField_b_of_type_JavaLangString));
        ((oidb_cmd0x46f.UserDisLike)localObject2).type.set(((DislikeInfo)localObject1).jdField_c_of_type_Int);
        ((oidb_cmd0x46f.UserDisLike)localObject2).uint64_dislike_tagid.set(((DislikeInfo)localObject1).jdField_a_of_type_Long);
        ((oidb_cmd0x46f.UserDisLike)localObject2).bytes_dislike_tag_name.set(ByteStringMicro.copyFromUtf8(((DislikeInfo)localObject1).jdField_a_of_type_JavaLangString));
        localDislikeParam.rpt_user_dislike_list.add((MessageMicro)localObject2);
      }
    }
    return localDislikeParam;
  }
  
  private oidb_cmd0x83e.FeedsInfo a(ArticleInfo paramArticleInfo, int paramInt, oidb_cmd0x83e.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    oidb_cmd0x83e.FeedsInfo localFeedsInfo = new oidb_cmd0x83e.FeedsInfo();
    localFeedsInfo.feeds_type.set(paramInt);
    if ((pha.b(paramArticleInfo)) || (pha.c(paramArticleInfo)) || (pha.e(paramArticleInfo)) || (pha.f(paramArticleInfo))) {
      if ((paramArticleInfo.mTopicRecommendFeedsInfo != null) && (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        localFeedsInfo.uint32_business_id.set(((rik)paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int);
      }
    }
    for (;;)
    {
      localFeedsInfo.msg_social_feeds_info.set(paramSocializeFeedsInfo);
      if (!TextUtils.isEmpty(paramArticleInfo.businessName)) {
        localFeedsInfo.bytes_business_name.set(ByteStringMicro.copyFromUtf8(paramArticleInfo.businessName));
      }
      if (!TextUtils.isEmpty(paramArticleInfo.businessUrl)) {
        localFeedsInfo.bytes_business_url.set(ByteStringMicro.copyFromUtf8(paramArticleInfo.businessUrl));
      }
      if (!TextUtils.isEmpty(paramArticleInfo.businessNamePrefix)) {
        localFeedsInfo.bytes_business_name_prefix.set(ByteStringMicro.copyFromUtf8(paramArticleInfo.businessNamePrefix));
      }
      return localFeedsInfo;
      localFeedsInfo.uint32_business_id.set((int)paramArticleInfo.businessId);
    }
  }
  
  private void a(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    do
    {
      return;
      long l = NetConnInfoCenter.getServerTime();
      paramList = a(Integer.valueOf(paramInt), (Long)paramList.get(0));
      Object localObject;
      if ((paramInt == 0) && (paramList != null) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)))
      {
        localObject = tzo.b((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramList);
        String str = tzo.a(paramList);
        tzo.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, str, String.valueOf(l), (String)localObject, paramBoolean);
      }
      if ((paramInt == 40677) && (paramList != null) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)))
      {
        localObject = (pnp)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(274);
        if (localObject != null) {
          ((pnp)localObject).a(tzo.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramList), l);
        }
      }
      if ((paramInt == 70) && (paramList != null) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)))
      {
        localObject = (KandianSubscribeManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(280);
        if (localObject != null) {
          ((KandianSubscribeManager)localObject).a(paramList, l);
        }
      }
    } while ((!pil.c(paramInt)) || (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) || (paramList == null));
    ((KandianDailyManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(296)).a(paramList);
  }
  
  private void a(long paramLong, int paramInt, oidb_cmd0x8c8.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    Iterator localIterator = ((ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt))).values().iterator();
    while (localIterator.hasNext())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)localIterator.next();
      if ((localArticleInfo != null) && (localArticleInfo.mFeedId == paramLong) && (localArticleInfo.mTopicRecommendFeedsInfo != null) && (localArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null))
      {
        rii localrii = localArticleInfo.mTopicRecommendFeedsInfo;
        if ((paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.has()) && (localrii != null) && (localrii.jdField_a_of_type_JavaUtilArrayList != null))
        {
          Object localObject = (oidb_cmd0x8c8.TopicRecommendFeedsInfo)paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.get();
          if (((oidb_cmd0x8c8.TopicRecommendFeedsInfo)localObject).msg_topic_recommend_info.has())
          {
            localObject = ((oidb_cmd0x8c8.TopicRecommendFeedsInfo)localObject).msg_topic_recommend_info.get();
            paramInt = 0;
            while ((paramInt < ((List)localObject).size()) && (paramInt < localrii.jdField_a_of_type_JavaUtilArrayList.size()))
            {
              oidb_cmd0x8c8.TopicRecommendInfo localTopicRecommendInfo = (oidb_cmd0x8c8.TopicRecommendInfo)((List)localObject).get(paramInt);
              rik localrik = (rik)localrii.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
              if (localTopicRecommendInfo.uint32_number_of_participants.has()) {
                localrik.jdField_b_of_type_Int = localTopicRecommendInfo.uint32_number_of_participants.get();
              }
              paramInt += 1;
            }
          }
        }
        localArticleInfo.invalidateProteusTemplateBean();
      }
    }
  }
  
  private void a(ArticleInfo paramArticleInfo1, ArticleInfo paramArticleInfo2)
  {
    if ((paramArticleInfo2.mFeedId != paramArticleInfo1.mFeedId) && (paramArticleInfo2.mSocialFeedInfo != null))
    {
      int j = 0;
      int i = j;
      if (paramArticleInfo2.mSocialFeedInfo.jdField_h_of_type_Int != 2)
      {
        i = j;
        if (paramArticleInfo1.mSocialFeedInfo.jdField_h_of_type_Int == 2) {
          i = 1;
        }
      }
      paramArticleInfo2.mSocialFeedInfo.jdField_h_of_type_Int = paramArticleInfo1.mSocialFeedInfo.jdField_h_of_type_Int;
      a(paramArticleInfo2);
      paramArticleInfo1 = a(paramArticleInfo2, (int)paramArticleInfo2.mChannelID);
      if ((i != 0) && (paramArticleInfo1 != null)) {
        paramArticleInfo1.isNeedShowBtnWhenFollowed = true;
      }
    }
  }
  
  private void a(@NotNull ArticleInfo paramArticleInfo, @NotNull oidb_cmd0x83e.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhh != null)) {
      paramSocializeFeedsInfo.now_live_info.set(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhh.a());
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, oidb_cmd0x8c8.SocializeFeedsInfo paramSocializeFeedsInfo, int paramInt)
  {
    if (paramArticleInfo == null) {}
    int i;
    do
    {
      do
      {
        return;
        if (((paramArticleInfo.mFeedType == 11) || (paramArticleInfo.mFeedType == 14)) && (paramArticleInfo.mTopicRecommendFeedsInfo != null) && (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          a(paramArticleInfo.mFeedId, paramInt, paramSocializeFeedsInfo);
          a(paramArticleInfo);
          return;
        }
      } while (paramArticleInfo.mSocialFeedInfo == null);
      i = paramArticleInfo.mSocialFeedInfo.jdField_h_of_type_Int;
      paramArticleInfo.mSocialFeedInfo.a(paramSocializeFeedsInfo);
      a(paramArticleInfo);
      paramSocializeFeedsInfo = a(paramArticleInfo, paramInt);
    } while (paramSocializeFeedsInfo == null);
    if ((i != 2) && (paramArticleInfo.mSocialFeedInfo.jdField_h_of_type_Int == 2)) {
      paramSocializeFeedsInfo.isNeedShowBtnWhenFollowed = true;
    }
    paramSocializeFeedsInfo.invalidateProteusTemplateBean();
  }
  
  private void a(ToServiceMsg paramToServiceMsg, Object paramObject, int paramInt, Integer paramInteger)
  {
    HashMap localHashMap;
    try
    {
      i = ((byte[])paramObject).length;
      l1 = i;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        int j;
        Integer localInteger2;
        Boolean localBoolean2;
        Integer localInteger1;
        Object localObject;
        long l3;
        Long localLong2;
        String str1;
        Long localLong1;
        String str3;
        String str2;
        Boolean localBoolean1;
        long l1 = 0L;
        continue;
        long l2 = -1L;
        continue;
        int i = 0;
        continue;
        l2 = 0L;
        continue;
        paramObject = "0";
        continue;
        paramObject = "0";
        continue;
        paramObject = "1";
        continue;
        paramObject = "";
        continue;
        paramObject = "0";
        continue;
        paramObject = "0";
        continue;
        paramObject = "";
        continue;
        paramObject = "";
      }
      QLog.d("ArticleInfoModule", 1, new Object[] { "0x68b reportFields \n", paramObject.toString() });
      paramObject = pha.a();
      if (paramInt != 0) {
        break label825;
      }
    }
    j = nmd.a(BaseApplicationImpl.context);
    boolean bool = bgnt.g(BaseApplicationImpl.context);
    paramObject = (Long)paramToServiceMsg.getAttribute(jdField_d_of_type_JavaLangString);
    if (paramObject != null)
    {
      l2 = paramObject.longValue();
      if (l2 != -1L) {
        break label700;
      }
      i = 1;
      paramObject = (Long)paramToServiceMsg.getAttribute("sendPackageSize");
      localInteger2 = (Integer)paramToServiceMsg.getAttribute("sendNetType");
      localBoolean2 = (Boolean)paramToServiceMsg.getAttribute("sendIsNetConnected");
      localInteger1 = (Integer)paramToServiceMsg.getAttribute("retryIndex");
      localObject = (Long)paramToServiceMsg.getAttribute("firstSendTimestamps");
      l3 = System.currentTimeMillis();
      if (localObject == null) {
        break label706;
      }
      l2 = ((Long)localObject).longValue();
      localLong2 = (Long)paramToServiceMsg.getAttribute("optimizeID");
      str1 = (String)paramToServiceMsg.getAttribute("unCompressSucceed");
      localLong1 = (Long)paramToServiceMsg.getAttribute("unCompressTimeCost");
      str3 = (String)paramToServiceMsg.getAttribute("finalParseSucceed");
      localObject = (String)paramToServiceMsg.getAttribute("compressRatio");
      str2 = pha.a();
      localBoolean1 = (Boolean)paramToServiceMsg.getAttribute("isFeedsPreload");
      localHashMap = new HashMap();
      localHashMap.put("retCode", String.valueOf(paramInt));
      localHashMap.put("channelID", String.valueOf(paramInteger));
      localHashMap.put("sendPackageSize", String.valueOf(paramObject));
      localHashMap.put("sendNetType", String.valueOf(localInteger2));
      if (!localBoolean2.booleanValue()) {
        break label712;
      }
      paramObject = "1";
      localHashMap.put("sendIsNetConnected", paramObject);
      localHashMap.put("recPackageSize", String.valueOf(l1));
      localHashMap.put("recNetType", String.valueOf(j));
      if (!bool) {
        break label719;
      }
      paramObject = "1";
      localHashMap.put("recIsNetConnected", paramObject);
      if (i == 0) {
        break label726;
      }
      paramObject = "0";
      localHashMap.put("refreshType", paramObject);
      localHashMap.put("retryIndex", String.valueOf(localInteger1));
      localHashMap.put("totalTimeCost", String.valueOf(l3 - l2));
      localHashMap.put("optimizeID", String.valueOf(localLong2));
      if (str3 == null) {
        break label733;
      }
      paramObject = str3;
      localHashMap.put("finalParseSucceed", paramObject);
      if (str2 == null) {
        break label740;
      }
      paramObject = str2;
      localHashMap.put("uin", paramObject);
      if ((localBoolean1 == null) || (!localBoolean1.booleanValue())) {
        break label747;
      }
      paramObject = "1";
      localHashMap.put("isFeedsPreload", paramObject);
      if (pgs.b(localLong2.longValue()))
      {
        if (str1 == null) {
          break label754;
        }
        paramObject = str1;
        localHashMap.put("unCompressSucceed", paramObject);
        localHashMap.put("unCompressTimeCost", String.valueOf(localLong1));
        if (localObject == null) {
          break label761;
        }
        paramObject = localObject;
        localHashMap.put("compressRatio", paramObject);
      }
      localHashMap.put("reqConsumeTime", "" + (System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey")));
      paramToServiceMsg.getAttributes().put("recPackageSize", Long.valueOf(l1));
      paramObject = new StringBuilder();
      paramInteger = localHashMap.entrySet().iterator();
      while (paramInteger.hasNext())
      {
        localObject = (Map.Entry)paramInteger.next();
        if (localObject != null) {
          paramObject.append((String)((Map.Entry)localObject).getKey()).append(" = ").append((String)((Map.Entry)localObject).getValue()).append("\n");
        }
      }
    }
    label700:
    label706:
    label712:
    label719:
    label726:
    label733:
    label740:
    label747:
    label754:
    label761:
    for (bool = true;; bool = false)
    {
      pha.a(paramObject, bool, System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey"), localHashMap);
      return;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, List<ArticleInfo> paramList1, int paramInt1, int paramInt2, List<ArticleInfo> paramList2, boolean paramBoolean1, boolean paramBoolean2, byte[] paramArrayOfByte)
  {
    switch (((Integer)paramToServiceMsg.getAttribute(jdField_c_of_type_JavaLangString)).intValue())
    {
    default: 
      return;
    case 5: 
      long l1 = ((Long)paramToServiceMsg.getAttribute(jdField_d_of_type_JavaLangString)).longValue();
      long l2 = ((Long)paramToServiceMsg.getAttribute(jdField_e_of_type_JavaLangString)).longValue();
      int j = ((Integer)paramToServiceMsg.getAttribute(jdField_f_of_type_JavaLangString)).intValue();
      int k = ((Integer)paramToServiceMsg.getAttribute(jdField_b_of_type_JavaLangString)).intValue();
      if (QLog.isColorLevel()) {
        if (paramList1 != null) {
          break label406;
        }
      }
      label406:
      for (int i = 0;; i = paramList1.size())
      {
        QLog.d("ArticleInfoModule", 2, "handle0x68bGetSubscribeArticalList result=" + paramInt2 + " channelID=" + paramInt1 + " beginSeq=" + l1 + " endSeq=" + l2 + " articlecount=" + i + " reqType=" + k);
        i = -1;
        if ((paramToServiceMsg.getAttribute("auto_refresh_src") instanceof Integer)) {
          i = ((Integer)paramToServiceMsg.getAttribute("auto_refresh_src")).intValue();
        }
        QLog.d("ArticleInfoModule", 2, "notifyAfterProcessRsp | refreshSrc : " + i);
        if ((i == 14) && (paramList1 != null) && (paramList1.size() > 0) && (paramList1.get(0) != null))
        {
          ((ArticleInfo)paramList1.get(0)).showBreathAnimation = true;
          QLog.d("ArticleInfoModule", 1, "notifyAfterProcessRsp | biu autoRefresh showBreathAnimation ");
        }
        if ((paramInt2 != 154) || (j != 1)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ArticleInfoModule", 2, "handle0x68bGetSubscribeArticalList re-request" + paramInt2 + " channelID=" + paramInt1 + " beginSeq=" + l1 + " endSeq=" + l2);
        }
        paramToServiceMsg.getAttributes().put(jdField_f_of_type_JavaLangString, Integer.valueOf(2));
        a(paramToServiceMsg);
        return;
      }
      if (paramInt2 == 2901)
      {
        i = 0;
        if (paramToServiceMsg.getAttribute("retryIndex") != null) {
          i = ((Integer)paramToServiceMsg.getAttribute("retryIndex")).intValue();
        }
        if (i < 3)
        {
          QLog.d("ArticleInfoModule", 1, new Object[] { "Retry req, handle0x68b, result = ", Integer.valueOf(paramInt2), ", fastResendRetryIndex = ", Integer.valueOf(i) });
          paramToServiceMsg.getAttributes().put("retryIndex", Integer.valueOf(i + 1));
          a(paramToServiceMsg);
          return;
        }
        QLog.d("ArticleInfoModule", 1, new Object[] { "Do not retry, result = ", Integer.valueOf(paramInt2), ", fastResendRetryIndex = ", Integer.valueOf(i) });
        a(paramBoolean1, paramInt1, paramBoolean2, paramList1, l1, l2, paramList2, paramArrayOfByte, paramToServiceMsg);
        return;
      }
      a(paramBoolean1, paramInt1, paramBoolean2, paramList1, l1, l2, paramList2, paramArrayOfByte, paramToServiceMsg);
      return;
    }
    a(paramBoolean1, paramInt1, paramList2);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, oidb_cmd0x68b.RspBody paramRspBody, int paramInt)
  {
    Object localObject1 = (Integer)paramToServiceMsg.getAttributes().get("channelID");
    List localList = null;
    Object localObject2 = paramToServiceMsg.getAttribute("request_extra_data_key");
    int i = 0;
    if ((localObject2 instanceof Bundle)) {
      i = ((Bundle)localObject2).getInt("FeedsRefreshType");
    }
    jdField_c_of_type_Boolean = false;
    Object localObject3;
    boolean bool1;
    label304:
    Object localObject4;
    label477:
    boolean bool2;
    if (paramInt == 0)
    {
      long l = qnb.a(paramRspBody.uint64_client_swithes, 0L);
      if (pvy.a.a(l, paramRspBody))
      {
        localObject3 = (oidb_cmd0x68b.RspGetFollowTabData)paramRspBody.msg_rsp_get_follow_tab_data.get();
        localObject2 = qnb.a(((oidb_cmd0x68b.RspGetFollowTabData)localObject3).bytes_set_top_cookie);
        QLog.d("ArticleInfoModule", 1, "follow request back cookie is " + qnb.a(((oidb_cmd0x68b.RspGetFollowTabData)localObject3).bytes_set_top_cookie, ""));
        oidb_cmd0x68b.RspChannelArticle localRspChannelArticle;
        if (qnb.a(((oidb_cmd0x68b.RspGetFollowTabData)localObject3).uint32_is_no_more_data, 0) == 1)
        {
          bool1 = true;
          localList = pwa.a.a(this, ((oidb_cmd0x68b.RspGetFollowTabData)localObject3).rpt_article_list);
          pwa.a.a(((oidb_cmd0x68b.RspGetFollowTabData)localObject3).uint32_has_followed_topic);
          pwa.a.b(((oidb_cmd0x68b.RspGetFollowTabData)localObject3).uint32_topic_reddot_update_num);
          pwa.a.a(((oidb_cmd0x68b.RspGetFollowTabData)localObject3).uint32_refresh_topic_update_info, ((oidb_cmd0x68b.RspGetFollowTabData)localObject3).topic_update_info);
          pwa.a.a(((oidb_cmd0x68b.RspGetFollowTabData)localObject3).uint32_hint_index, localList);
          pwa.a.a(((oidb_cmd0x68b.RspGetFollowTabData)localObject3).bytes_refresh_cookie);
          localObject3 = paramToServiceMsg.getAttributes().get("realTimeServiceKey");
          pvy.a.a(localObject3, paramRspBody.bytes_new_style_params);
          if (!pvy.a.b(l, paramRspBody)) {
            break label728;
          }
          localRspChannelArticle = (oidb_cmd0x68b.RspChannelArticle)paramRspBody.rspChannelArticle.get();
          if (!localRspChannelArticle.uint64_channel_id.has()) {
            break label721;
          }
          localObject3 = Integer.valueOf((int)localRspChannelArticle.uint64_channel_id.get());
          if (qnb.a(localRspChannelArticle.uint32_is_no_more_data, 0) != 1) {
            break label519;
          }
        }
        label512:
        label519:
        for (bool1 = true;; bool1 = false)
        {
          int j = a(paramToServiceMsg);
          localList = pvz.a.a(paramToServiceMsg, ((Integer)localObject3).intValue(), i, j, localRspChannelArticle.rpt_article_list);
          localObject4 = qnc.a(localRspChannelArticle.rpt_deleted_article_list.get(), ((Integer)localObject3).intValue(), i, j);
          localObject2 = qnb.a(localRspChannelArticle.bytes_set_top_cookie);
          localObject1 = (pmm)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(163);
          oqh.a("AdDataLink", "handleAdvertisementResp in article request");
          ((pmm)localObject1).a().a(paramToServiceMsg, localRspChannelArticle);
          pvz.a.a(localRspChannelArticle.bytes_nearby_cookie);
          localObject1 = qnb.a(localRspChannelArticle.bytes_pre_load_req_info);
          QLog.d("ArticleInfoModule", 1, new Object[] { "feedsPreload, req info = ", localObject1 });
          pvz.a.a(localList, localRspChannelArticle.rpt_back_off_group_info, ((Integer)localObject3).intValue());
          if (!pvy.a.a(l)) {
            break label525;
          }
          paramToServiceMsg = (List)paramToServiceMsg.getAttribute("SubscriptionArticles");
          a(true, ((Integer)localObject3).intValue(), paramToServiceMsg, localList);
          return;
          bool1 = false;
          break;
        }
        label525:
        pvy.a.a(paramRspBody.msg_rsp_trace);
        boolean bool3 = true;
        paramRspBody = (oidb_cmd0x68b.RspBody)localObject3;
        localObject3 = localObject2;
        bool2 = bool1;
        bool1 = bool3;
      }
    }
    for (localObject2 = localObject4;; localObject2 = null)
    {
      if (qak.a(paramToServiceMsg))
      {
        QLog.d("ArticleInfoModule", 1, new Object[] { "feedsPreload, channelID = ", paramRspBody, ", result = ", Integer.valueOf(paramInt), ", success = ", Boolean.valueOf(bool1) });
        if (paramInt != 0) {
          break label512;
        }
        localObject4 = new qaf();
        paramToServiceMsg = ((qaf)localObject4).a(paramToServiceMsg).a(paramRspBody.intValue()).b(paramInt).a(localList).b((List)localObject2).a(bool1).b(bool2).a((byte[])localObject3);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
        for (;;)
        {
          paramToServiceMsg.a((String)localObject1);
          qag.a().a((qaf)localObject4);
          return;
          localObject1 = "";
        }
      }
      a(paramToServiceMsg, localList, paramRspBody.intValue(), paramInt, (List)localObject2, bool1, bool2, (byte[])localObject3);
      return;
      label721:
      localObject3 = localObject1;
      break label304;
      label728:
      localObject4 = null;
      localObject3 = localObject1;
      localObject1 = null;
      break label477;
      localList = null;
      localObject2 = null;
      bool1 = false;
      break;
      paramRspBody = (oidb_cmd0x68b.RspBody)localObject1;
      localObject1 = null;
      bool1 = false;
      localObject3 = null;
      bool2 = false;
    }
  }
  
  private void a(Integer paramInteger)
  {
    paramInteger = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramInteger);
    ArrayList localArrayList = new ArrayList(paramInteger.keySet());
    Collections.sort(localArrayList);
    int j = localArrayList.size();
    int i = 0;
    while (i < j - 30)
    {
      paramInteger.remove(localArrayList.get(i));
      i += 1;
    }
  }
  
  private void a(Integer paramInteger, ArticleInfo paramArticleInfo)
  {
    paramInteger = (CopyOnWriteArrayList)this.jdField_b_of_type_JavaUtilMap.get(paramInteger);
    if (paramInteger != null) {
      paramInteger.remove(paramArticleInfo);
    }
  }
  
  private void a(ArrayList<ArticleInfo> paramArrayList, rfd paramrfd)
  {
    paramrfd = paramrfd.jdField_a_of_type_JavaUtilArrayList;
    paramArrayList = paramArrayList.iterator();
    for (;;)
    {
      if (!paramArrayList.hasNext()) {
        return;
      }
      ArticleInfo localArticleInfo = (ArticleInfo)paramArrayList.next();
      Iterator localIterator = paramrfd.iterator();
      if (localIterator.hasNext())
      {
        rfe localrfe = (rfe)localIterator.next();
        if (localArticleInfo.mFeedId != localrfe.jdField_a_of_type_Long) {
          break;
        }
        localArticleInfo.mRecommendSeq = localrfe.jdField_c_of_type_Long;
        localArticleInfo.mFeedType = localrfe.jdField_a_of_type_Int;
        localArticleInfo.mAlgorithmID = localrfe.jdField_b_of_type_Long;
        localArticleInfo.mStrategyId = localrfe.jdField_b_of_type_Int;
      }
    }
  }
  
  private void a(List<Long> paramList, oidb_cmd0x68b.RspBody paramRspBody, long paramLong)
  {
    if (paramList == null)
    {
      QLog.d("ArticleInfoModule", 2, "savePreloadRedPntPushArticle2Cache :  articleIDList is null");
      return;
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (paramList.equals(jdField_b_of_type_JavaUtilList))
        {
          jdField_a_of_type_ComTencentUtilPair = new com.tencent.util.Pair(paramList, paramRspBody);
          QLog.d("ArticleInfoModule", 2, "savePreloadRedPntPushArticle2Cache :  [red_pnt_push preload resp cached] , article list [ " + a(paramList) + " ]");
          i = 1;
          paramList = "";
        }
        try
        {
          paramRspBody = new JSONObject();
          paramRspBody.put("preload_red_pnt_push_articleID", paramLong);
          paramRspBody.put("preload_resp_result_code", 0);
          if (i == 0) {
            break;
          }
          i = 1;
        }
        catch (JSONException paramList)
        {
          String str;
          paramList.printStackTrace();
          continue;
          i = 0;
          continue;
        }
        paramRspBody.put("preload_resp_valid_flag", i);
        paramRspBody.put("preload_resp_invalid_reason", paramList);
        oat.a(null, "", "0X8009483", "0X8009483", 0, 0, paramRspBody.toString(), "", "", "", false);
        return;
      }
      str = "new_red_pnt_push";
      paramRspBody = str;
      if (jdField_b_of_type_JavaUtilList != null)
      {
        paramRspBody = str;
        if (jdField_b_of_type_JavaUtilList.size() == 0) {
          paramRspBody = "user_quick_click";
        }
      }
      QLog.d("ArticleInfoModule", 2, "savePreloadRedPntPushArticle2Cache :  [red_pnt_push preload resp outdated] , article list [" + a(paramList) + " ]");
      i = 0;
      paramList = paramRspBody;
    }
  }
  
  private void a(ConcurrentHashMap<Long, ArticleInfo> paramConcurrentHashMap, long paramLong, int paramInt, List<Long> paramList)
  {
    ArticleInfo localArticleInfo;
    if (paramConcurrentHashMap != null)
    {
      Iterator localIterator = paramConcurrentHashMap.values().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localArticleInfo = (ArticleInfo)localIterator.next();
      } while ((localArticleInfo.mFeedId != paramLong) || (localArticleInfo.mFeedType != paramInt));
    }
    for (;;)
    {
      if (localArticleInfo != null)
      {
        paramConcurrentHashMap.remove(Long.valueOf(localArticleInfo.mRecommendSeq));
        a(Integer.valueOf(0), localArticleInfo);
        paramList.add(Long.valueOf(localArticleInfo.mRecommendSeq));
      }
      return;
      localArticleInfo = null;
    }
  }
  
  private void a(qni paramqni, List<oidb_cmd0x68b.InnerMsg> paramList)
  {
    if ((paramqni.jdField_c_of_type_JavaUtilList != null) && (!paramqni.jdField_c_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = paramqni.jdField_c_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        plx localplx = (plx)localIterator.next();
        QLog.d("ArticleInfoModule", 2, "InsertArticleInfo :" + localplx);
        oidb_cmd0x68b.InnerMsg localInnerMsg = new oidb_cmd0x68b.InnerMsg();
        localInnerMsg.uint32_jump_src_type.set(qni.a(localplx));
        localInnerMsg.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(String.valueOf(localplx.jdField_a_of_type_Long)));
        if (!TextUtils.isEmpty(paramqni.jdField_c_of_type_JavaLangString)) {
          localInnerMsg.bytes_push_context.set(ByteStringMicro.copyFromUtf8(paramqni.jdField_c_of_type_JavaLangString));
        }
        localInnerMsg.uint64_algorithm_id.set(paramqni.jdField_d_of_type_Long);
        localInnerMsg.uint32_strategy_id.set((int)paramqni.jdField_e_of_type_Long);
        paramList.add(0, localInnerMsg);
        if (paramqni.jdField_b_of_type_JavaUtilList == null) {
          paramqni.jdField_b_of_type_JavaUtilList = new ArrayList();
        }
        paramqni.jdField_b_of_type_JavaUtilList.add(0, Long.valueOf(localplx.jdField_a_of_type_Long));
      }
    }
  }
  
  private void a(qni paramqni, oidb_cmd0x68b.ReqBody paramReqBody) {}
  
  private void a(qni paramqni, oidb_cmd0x68b.ReqChannelPara paramReqChannelPara)
  {
    if (paramqni.jdField_a_of_type_Qqp != null)
    {
      oidb_cmd0x68b.UserReadArticle localUserReadArticle = new oidb_cmd0x68b.UserReadArticle();
      localUserReadArticle.uint64_source.set(1L);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramqni.jdField_a_of_type_Qqp.a.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(ByteStringMicro.copyFromUtf8((String)localIterator.next()));
      }
      localUserReadArticle.bytes_read_rowkeys.set(localArrayList);
      localArrayList = new ArrayList();
      paramqni = paramqni.jdField_a_of_type_Qqp.b.iterator();
      while (paramqni.hasNext()) {
        localArrayList.add(ByteStringMicro.copyFromUtf8((String)paramqni.next()));
      }
      localUserReadArticle.bytes_unread_rowkeys.set(localArrayList);
      paramReqChannelPara.user_read_article.set(localUserReadArticle);
    }
  }
  
  private void a(qni paramqni, oidb_cmd0x68b.ReqChannelPara paramReqChannelPara, List<oidb_cmd0x68b.InnerMsg> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    oidb_cmd0x68b.SubscribeMsg localSubscribeMsg = new oidb_cmd0x68b.SubscribeMsg();
    localSubscribeMsg.uint64_source_article_id.set(paramqni.jdField_c_of_type_Long);
    if (!TextUtils.isEmpty(paramqni.jdField_b_of_type_JavaLangString)) {
      localSubscribeMsg.bytes_title.set(ByteStringMicro.copyFromUtf8(paramqni.jdField_b_of_type_JavaLangString));
    }
    localArrayList.add(localSubscribeMsg);
    paramReqChannelPara.rpt_subscribe_msg_list.set(localArrayList);
    paramReqChannelPara = new oidb_cmd0x68b.InnerMsg();
    paramReqChannelPara.uint32_jump_src_type.set(2);
    paramReqChannelPara.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(String.valueOf(paramqni.jdField_c_of_type_Long)));
    if (!TextUtils.isEmpty(paramqni.jdField_b_of_type_JavaLangString)) {
      paramReqChannelPara.bytes_title.set(ByteStringMicro.copyFromUtf8(paramqni.jdField_b_of_type_JavaLangString));
    }
    paramList.add(paramReqChannelPara);
  }
  
  private void a(oidb_cmd0x68b.ReqBody paramReqBody, ToServiceMsg paramToServiceMsg, long paramLong)
  {
    long l = 0L;
    try
    {
      i = paramReqBody.toByteArray().length;
      l = i;
    }
    catch (Exception paramReqBody)
    {
      for (;;)
      {
        int i;
        boolean bool;
        QLog.d("ArticleInfoModule", 1, "get packageSize exception.");
      }
    }
    i = nmd.a(BaseApplicationImpl.context);
    bool = bgnt.g(BaseApplicationImpl.context);
    paramToServiceMsg.getAttributes().put("sendPackageSize", Long.valueOf(l));
    paramToServiceMsg.getAttributes().put("sendNetType", Integer.valueOf(i));
    paramToServiceMsg.getAttributes().put("sendIsNetConnected", Boolean.valueOf(bool));
    paramToServiceMsg.getAttributes().put("retryIndex", Integer.valueOf(0));
    paramToServiceMsg.getAttributes().put("firstSendTimestamps", Long.valueOf(System.currentTimeMillis()));
    paramToServiceMsg.getAttributes().put("optimizeID", Long.valueOf(paramLong));
    paramToServiceMsg.getAttributes().put("compressFlag", Boolean.valueOf(pgs.b(paramLong)));
  }
  
  private void a(oidb_cmd0x68b.ReqChannelPara paramReqChannelPara)
  {
    String str = aoor.b();
    if (!TextUtils.isEmpty(str)) {
      paramReqChannelPara.bytes_lbs_data.set(ByteStringMicro.copyFrom(str.getBytes()));
    }
  }
  
  private void a(oidb_cmd0x8c8.RspBody paramRspBody, ConcurrentHashMap<String, ArticleInfo> paramConcurrentHashMap, boolean paramBoolean)
  {
    if ((!paramRspBody.rpt_social_feeds_info.has()) || (paramRspBody.rpt_social_feeds_info.get() == null)) {
      return;
    }
    paramRspBody = paramRspBody.rpt_social_feeds_info.get();
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ArticleInfoModule.39(this, paramRspBody, paramConcurrentHashMap, paramBoolean));
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_b_of_type_Boolean = paramBoolean;
  }
  
  private void a(boolean paramBoolean, int paramInt, List<ArticleInfo> paramList)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ArticleInfoModule.9(this, paramBoolean, paramInt, paramList));
  }
  
  private void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, List<ArticleInfo> paramList, long paramLong1, long paramLong2)
  {
    List localList1 = null;
    if (!paramBoolean1)
    {
      pmk.a().b(false, paramInt, null, false);
      return;
    }
    if (paramList == null)
    {
      pmk.a().b(true, paramInt, null, true);
      return;
    }
    List localList2 = c(Integer.valueOf(paramInt));
    if (this.jdField_a_of_type_Pwe != null) {
      localList1 = this.jdField_a_of_type_Pwe.a(paramInt, localList2, paramList);
    }
    if ((localList1 != null) && (!localList1.isEmpty())) {
      a(Integer.valueOf(paramInt), localList1, true);
    }
    a(Integer.valueOf(paramInt), paramList, true);
    paramBoolean1 = paramList.isEmpty();
    if (paramInt == 70) {
      if ((paramBoolean1) || (paramBoolean2)) {
        paramBoolean1 = true;
      }
    }
    for (;;)
    {
      localList1 = a(Integer.valueOf(paramInt));
      if ((paramInt == 70) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (paramBoolean1)) {
        ((KandianMergeManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(162)).a(localList1.size());
      }
      if (paramInt == 0) {
        ube.a(paramList, localList1, false);
      }
      for (;;)
      {
        pmk.a().b(true, paramInt, localList1, paramBoolean1);
        return;
        paramBoolean1 = false;
        break;
        if (pil.c(paramInt)) {
          pfk.a(paramList, localList1, false);
        }
      }
    }
  }
  
  private void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, List<ArticleInfo> paramList1, long paramLong1, long paramLong2, List<ArticleInfo> paramList2, ToServiceMsg paramToServiceMsg)
  {
    Object localObject;
    if (paramBoolean1)
    {
      d(paramList1);
      if ((paramList1 != null) && (paramList1.size() > 0))
      {
        localObject = new CopyOnWriteArrayList(paramList1);
        this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localObject);
      }
      if (paramList1 != null)
      {
        paramLong1 = System.currentTimeMillis();
        localObject = paramList1.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((ArticleInfo)((Iterator)localObject).next()).mRefreshTime = (paramLong1 + "");
        }
      }
      this.jdField_a_of_type_Boolean = true;
      if ((paramInt == 70) || (paramInt == 41403) || (pil.a(paramInt)) || (bmqa.a(paramInt))) {
        break label463;
      }
      if ((paramBoolean2) && (!pha.c(paramInt)))
      {
        a(Integer.valueOf(paramInt), paramList1, true);
        a(paramInt, paramList2);
      }
    }
    else
    {
      paramList2 = a(Integer.valueOf(paramInt));
      if ((paramInt == 70) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && ((paramBoolean2) || ((paramList1 == null) && (paramBoolean1))) && (paramList2 != null)) {
        ((KandianMergeManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(162)).a(paramList2.size());
      }
      localObject = paramToServiceMsg.getAttribute("isRedRefreshReq");
      if ((localObject == null) || (!(localObject instanceof Boolean))) {
        break label560;
      }
    }
    label296:
    label554:
    label560:
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      if (paramInt == 0)
      {
        ube.a(paramList1, paramList2, bool);
        ube.a(paramList1);
        localObject = (List)paramToServiceMsg.getAttributes().get("SubscriptionArticles");
        if ((localObject != null) && (((List)localObject).size() > 0)) {
          pmk.a().a(paramBoolean1, (List)localObject, paramList1);
        }
        pmk.a().a(paramBoolean1, paramInt, paramList2, paramBoolean2);
        qnm.a().a(paramInt, paramList2, paramBoolean1, paramBoolean2, paramToServiceMsg);
        if (paramBoolean1) {
          if (paramList1 == null) {
            break label554;
          }
        }
      }
      for (int i = paramList1.size();; i = 0)
      {
        qai.a(paramToServiceMsg, i);
        a(paramInt, paramList2, paramBoolean1);
        return;
        if (QLog.isColorLevel()) {
          QLog.e("ArticleInfoModule", 2, "handleRefreshChannel clearChannelArticleInfo channelId=" + paramInt);
        }
        if ((paramList1 == null) || (paramList1.size() <= 0)) {
          break;
        }
        b(paramInt);
        a(Integer.valueOf(paramInt), paramList1, true);
        break;
        label463:
        if ((paramList1 != null) && (paramList1.size() > 0))
        {
          b(paramInt);
          a(Integer.valueOf(paramInt), paramList1, true);
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e("ArticleInfoModule", 2, "articleInfoList is wrong");
        }
        a(Integer.valueOf(paramInt), paramList1, true);
        a(paramInt, paramList2);
        break;
        if (!pil.c(paramInt)) {
          break label296;
        }
        pfk.a(paramList1, paramList2, bool);
        break label296;
      }
    }
  }
  
  private void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, List<ArticleInfo> paramList1, long paramLong1, long paramLong2, List<ArticleInfo> paramList2, byte[] paramArrayOfByte, ToServiceMsg paramToServiceMsg)
  {
    qof.a(paramList1);
    this.jdField_a_of_type_AndroidOsHandler.post(new ArticleInfoModule.8(this, paramLong1, paramInt, paramArrayOfByte, paramBoolean1, paramList1, paramBoolean2, paramLong2, paramList2, paramToServiceMsg));
  }
  
  public static boolean a()
  {
    return jdField_c_of_type_Boolean;
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return false;
    }
    boolean bool;
    try
    {
      paramToServiceMsg = paramToServiceMsg.getAttribute("recommendFlag");
      if (paramToServiceMsg == null)
      {
        QLog.d("ArticleInfoModule", 2, "isPreloadRedPntPushArticleResp : req RECOMMEND_FLAG is null ");
        return false;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.d("ArticleInfoModule", 2, "isPreloadRedPntPushArticleResp : req convert Object to Integer exception ", paramToServiceMsg);
      bool = false;
    }
    for (;;)
    {
      return bool;
      int i = ((Integer)paramToServiceMsg).intValue();
      if ((i & 0x40) != 0) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  private boolean a(Integer paramInteger, ArticleInfo paramArticleInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramArticleInfo == null) {
      return false;
    }
    if (!pjp.a(paramArticleInfo)) {
      return false;
    }
    ConcurrentHashMap localConcurrentHashMap1 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramInteger);
    if (localConcurrentHashMap1 == null)
    {
      localConcurrentHashMap1 = new ConcurrentHashMap();
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramInteger, localConcurrentHashMap1);
    }
    for (;;)
    {
      boolean bool1 = false;
      boolean bool2 = false;
      if (localConcurrentHashMap1.get(Long.valueOf(paramArticleInfo.mRecommendSeq)) != null)
      {
        bool1 = bool2;
        if (paramArticleInfo.mAbandonRepeatFlag == 0) {
          bool1 = true;
        }
        QLog.e("ArticleInfoModule", 1, "saveArticleInfo, article duplicated, article been channelID=" + paramInteger + ", articleID=" + paramArticleInfo.mArticleID + "，seq=" + paramArticleInfo.mRecommendSeq + ", toDb=" + paramBoolean1 + "，isDupArticle =" + bool1 + "，title = " + paramArticleInfo.mTitle);
      }
      ConcurrentHashMap localConcurrentHashMap2;
      if ((paramInteger.intValue() != 70) && (paramInteger.intValue() != 0) && (paramInteger.intValue() != 9999) && (!TextUtils.isEmpty(paramArticleInfo.mVideoVid)))
      {
        localConcurrentHashMap2 = (ConcurrentHashMap)this.jdField_d_of_type_JavaUtilLinkedHashMap.get(paramInteger);
        if (localConcurrentHashMap2 != null) {
          break label560;
        }
        localConcurrentHashMap2 = new ConcurrentHashMap();
        this.jdField_d_of_type_JavaUtilLinkedHashMap.put(paramInteger, localConcurrentHashMap2);
      }
      label545:
      label560:
      for (;;)
      {
        if (localConcurrentHashMap2.get(paramArticleInfo.mVideoVid) != null)
        {
          ArticleInfo localArticleInfo = (ArticleInfo)localConcurrentHashMap2.get(paramArticleInfo.mVideoVid);
          if (localArticleInfo.mArticleID != paramArticleInfo.mArticleID)
          {
            a(paramInteger.intValue(), localArticleInfo.mRecommendSeq);
            if (QLog.isColorLevel()) {
              QLog.e("ArticleInfoModule", 2, "saveArticleInfo, find article vid duplicated! old article: channelID=" + paramInteger + ", id=" + localArticleInfo.mArticleID + "，seq: " + localArticleInfo.mRecommendSeq + ", title: " + pha.d(localArticleInfo.mTitle) + "，vid =" + localArticleInfo.mVideoVid + "\n new article  id : " + paramArticleInfo.mArticleID + " seq : " + paramArticleInfo.mRecommendSeq + " title : " + pha.d(paramArticleInfo.mTitle) + "，vid =" + paramArticleInfo.mVideoVid);
            }
          }
        }
        localConcurrentHashMap2.put(paramArticleInfo.mVideoVid, paramArticleInfo);
        if ((!bool1) || (paramBoolean2))
        {
          localConcurrentHashMap1.put(Long.valueOf(paramArticleInfo.mRecommendSeq), paramArticleInfo);
          if (paramArticleInfo.isWormhole()) {
            return false;
          }
          if (paramBoolean1)
          {
            if ((this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown()) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isTerminated())) {
              break label545;
            }
            this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ArticleInfoModule.20(this, paramArticleInfo));
          }
        }
        for (;;)
        {
          return true;
          ThreadManager.executeOnSubThread(new ArticleInfoModule.21(this, paramArticleInfo));
        }
      }
    }
  }
  
  private boolean a(String paramString)
  {
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
  
  private boolean a(qni paramqni, long paramLong)
  {
    if ((qak.a(paramqni)) && (!qak.b(paramqni)))
    {
      paramqni = qag.a().a(paramqni);
      if (paramqni != null)
      {
        long l1 = System.currentTimeMillis();
        long l2 = ((Long)bmqa.a("sp_key_readinjoy_feeds_preload_loading_time", Long.valueOf(50L))).longValue();
        ThreadManager.getUIHandler().postDelayed(new ArticleInfoModule.2(this, l2, l1, paramqni, paramLong), l2);
        return true;
      }
    }
    return false;
  }
  
  public static byte[] a()
  {
    String str2 = pha.h();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1.getBytes();
  }
  
  public static int b()
  {
    switch (bgnt.a(BaseApplication.getContext()))
    {
    case 0: 
    default: 
      return 0;
    case 2: 
      return 1;
    case 3: 
      return 2;
    case 4: 
      return 3;
    }
    return 4;
  }
  
  private List<Long> b(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    Object localObject = a(paramInt1, paramInt2, paramLong, paramBoolean);
    if (((List)localObject).isEmpty()) {
      return null;
    }
    qqk.a().a((List)localObject);
    a(Integer.valueOf(paramInt1), (List)localObject, false);
    ArrayList localArrayList = new ArrayList(((List)localObject).size());
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)((Iterator)localObject).next();
      if (!localHashSet1.add(Long.valueOf(localArticleInfo.mArticleID))) {
        QLog.d("ArticleInfoModule", 2, "loadChannelArticleSeqList articleID duplicated, channelID = " + paramInt1 + ", seq = " + localArticleInfo.mRecommendSeq + "articleID = " + localArticleInfo.mArticleID);
      } else if (!localHashSet2.add(Long.valueOf(localArticleInfo.mRecommendSeq))) {
        QLog.d("ArticleInfoModule", 2, "loadChannelArticleSeqList articleRecommendSeq duplicated, channelID = " + paramInt1 + ", seq = " + localArticleInfo.mRecommendSeq + "articleID = " + localArticleInfo.mArticleID);
      } else {
        localArrayList.add(Long.valueOf(localArticleInfo.mRecommendSeq));
      }
    }
    this.jdField_a_of_type_Pxn.a(Integer.valueOf(paramInt1), localArrayList);
    return localArrayList;
  }
  
  private void b(@NotNull ArticleInfo paramArticleInfo, @NotNull oidb_cmd0x83e.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhr != null))
    {
      feeds_info.ShareWebPageInfo localShareWebPageInfo = new feeds_info.ShareWebPageInfo();
      paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhr;
      qnb.a(localShareWebPageInfo.bytes_source, paramArticleInfo.jdField_d_of_type_JavaLangString);
      qnb.a(localShareWebPageInfo.bytes_title, paramArticleInfo.jdField_b_of_type_JavaLangString);
      qnb.a(localShareWebPageInfo.bytes_pic_url, paramArticleInfo.jdField_c_of_type_JavaLangString);
      qnb.a(localShareWebPageInfo.bytes_web_url, paramArticleInfo.jdField_a_of_type_JavaLangString);
      paramSocializeFeedsInfo.share_web_page_info.set(localShareWebPageInfo);
    }
  }
  
  private void b(Integer paramInteger, ArticleInfo paramArticleInfo)
  {
    paramInteger = (CopyOnWriteArrayList)this.jdField_b_of_type_JavaUtilMap.get(paramInteger);
    if (paramInteger == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramInteger.iterator();
      while (localIterator.hasNext())
      {
        ArticleInfo localArticleInfo = (ArticleInfo)localIterator.next();
        if (localArticleInfo.mArticleID == paramArticleInfo.mArticleID) {
          paramInteger.set(paramInteger.indexOf(localArticleInfo), paramArticleInfo);
        }
      }
    }
  }
  
  private void b(List<ArticleInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (ArticleInfo)paramList.next();
        if ((((ArticleInfo)localObject).mSocialFeedInfo != null) && (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Rhn != null) && (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Rhn.jdField_a_of_type_JavaUtilArrayList != null) && (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Rhn.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          localObject = ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Rhn.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            rhp localrhp = ((rho)((Iterator)localObject).next()).jdField_a_of_type_Rhp;
            if ((localrhp != null) && (!TextUtils.isEmpty(localrhp.jdField_e_of_type_JavaLangString)))
            {
              slr localslr = slm.a(localrhp.jdField_e_of_type_JavaLangString);
              if ((localslr == null) || (!localslr.a(System.currentTimeMillis() / 1000L, 3600L))) {
                localArrayList.add(localrhp.jdField_e_of_type_JavaLangString);
              }
            }
          }
        }
      }
    }
    if (localArrayList.size() > 0) {
      ptn.a().a((String[])localArrayList.toArray(new String[localArrayList.size()]), null);
    }
  }
  
  private void b(ConcurrentHashMap<Long, ArticleInfo> paramConcurrentHashMap, long paramLong, int paramInt, List<Long> paramList)
  {
    ArticleInfo localArticleInfo;
    if (paramConcurrentHashMap != null)
    {
      Iterator localIterator = paramConcurrentHashMap.values().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localArticleInfo = (ArticleInfo)localIterator.next();
      } while ((localArticleInfo.mFeedId != paramLong) || (localArticleInfo.mFeedType != paramInt));
    }
    for (;;)
    {
      if (localArticleInfo != null)
      {
        paramConcurrentHashMap.remove(Long.valueOf(localArticleInfo.mRecommendSeq));
        a(Integer.valueOf(70), localArticleInfo);
        paramList.add(Long.valueOf(localArticleInfo.mRecommendSeq));
      }
      return;
      localArticleInfo = null;
    }
  }
  
  private void b(oul paramoul)
  {
    if (paramoul == null) {
      QLog.d("ArticleInfoModule", 2, "transformNormalToNewBiuCard | biuInfo is null!");
    }
    ArticleInfo localArticleInfo;
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        return;
        if (paramoul.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
        {
          QLog.d("ArticleInfoModule", 2, "transformNormalToNewBiuCard | originArticleInfo is null!");
          return;
        }
        long l1 = paramoul.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId;
        long l2 = paramoul.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType;
        localArticleInfo = paramoul.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        localArticleInfo.mCardJumpUrl = paramoul.jdField_e_of_type_JavaLangString;
        localArticleInfo.commentBtnJumpUrl = paramoul.jdField_c_of_type_JavaLangString;
        localArticleInfo.commentShareUrl = paramoul.jdField_d_of_type_JavaLangString;
        localArticleInfo.isCardJumpUrlAvailable = paramoul.jdField_b_of_type_Int;
        localArticleInfo.mProteusTemplateBean = null;
        localArticleInfo.mAbandonRepeatFlag = 1;
        localArticleInfo.mFeedType = 36;
        localObject1 = localArticleInfo.mSocialFeedInfo;
        localArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
        if (localObject1 != null)
        {
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rha.jdField_a_of_type_Int = ((SocializeFeedsInfo)localObject1).jdField_a_of_type_Rha.jdField_a_of_type_Int;
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn = ((SocializeFeedsInfo)localObject1).jdField_a_of_type_Rhn;
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs = ((SocializeFeedsInfo)localObject1).jdField_a_of_type_Rhs;
        }
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rha.jdField_a_of_type_Long = pha.a();
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rha.jdField_c_of_type_Int = 1;
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy = new rgy();
        localArticleInfo.mFeedId = paramoul.jdField_a_of_type_Long;
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long = paramoul.jdField_a_of_type_Long;
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy.jdField_b_of_type_JavaLangLong = Long.valueOf(l2);
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy.jdField_a_of_type_JavaLangLong = Long.valueOf(l1);
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy.jdField_a_of_type_JavaUtilList = new ArrayList();
        localObject1 = new SocializeFeedsInfo.BiuCommentInfo();
        localObject2 = new String(bgku.decode(paramoul.jdField_a_of_type_JavaLangString, 0));
        ((SocializeFeedsInfo.BiuCommentInfo)localObject1).jdField_a_of_type_JavaLangString = bbzj.b((String)localObject2);
        ((SocializeFeedsInfo.BiuCommentInfo)localObject1).jdField_a_of_type_JavaLangLong = Long.valueOf(pha.a());
        ((SocializeFeedsInfo.BiuCommentInfo)localObject1).jdField_b_of_type_JavaLangLong = Long.valueOf(paramoul.jdField_a_of_type_Long);
        ((SocializeFeedsInfo.BiuCommentInfo)localObject1).jdField_a_of_type_Int = 0;
        ((SocializeFeedsInfo.BiuCommentInfo)localObject1).jdField_b_of_type_JavaLangString = ((String)localObject2);
        ((SocializeFeedsInfo.BiuCommentInfo)localObject1).jdField_b_of_type_Int = 36;
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy.jdField_a_of_type_JavaUtilList.add(localObject1);
        localArticleInfo.articleViewModel = tkt.a(localArticleInfo);
        QLog.d("ArticleInfoModule", 2, "transformNormalToNewBiuCard | newArticleInfo:" + localArticleInfo);
      } while (this.jdField_a_of_type_JavaUtilLinkedHashMap == null);
      paramoul = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(0));
      localObject1 = new ArrayList();
    } while (paramoul == null);
    if (paramoul.containsKey(Long.valueOf(localArticleInfo.mRecommendSeq)))
    {
      paramoul.put(Long.valueOf(localArticleInfo.mRecommendSeq), localArticleInfo);
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(0), paramoul);
    }
    for (int i = 1;; i = 0)
    {
      localObject2 = paramoul.values().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add((ArticleInfo)((Iterator)localObject2).next());
      }
      if (i == 0) {
        break;
      }
      a(Integer.valueOf(0), (List)localObject1, true);
      localObject1 = a(Integer.valueOf(0));
      pmk.a().b(0, (List)localObject1);
      QLog.d("ArticleInfoModule", 2, "transformNormalToNewBiuCard | update DB , cached biuCardArticleInfo: " + paramoul.get(Long.valueOf(localArticleInfo.mRecommendSeq)));
      return;
    }
  }
  
  private void b(qni paramqni, List<oidb_cmd0x68b.InnerMsg> paramList)
  {
    Object localObject;
    if ((paramqni.jdField_b_of_type_JavaUtilList != null) && (paramqni.jdField_b_of_type_JavaUtilList.size() > 0))
    {
      localObject = paramqni.jdField_b_of_type_JavaUtilList.iterator();
      if (((Iterator)localObject).hasNext())
      {
        Long localLong = (Long)((Iterator)localObject).next();
        oidb_cmd0x68b.InnerMsg localInnerMsg = new oidb_cmd0x68b.InnerMsg();
        if (paramqni.jdField_h_of_type_Int > 0) {
          localInnerMsg.uint32_jump_src_type.set(paramqni.jdField_h_of_type_Int);
        }
        for (;;)
        {
          localInnerMsg.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(String.valueOf(localLong)));
          if (!TextUtils.isEmpty(paramqni.jdField_c_of_type_JavaLangString))
          {
            localInnerMsg.bytes_push_context.set(ByteStringMicro.copyFromUtf8(paramqni.jdField_c_of_type_JavaLangString));
            if (QLog.isColorLevel()) {
              QLog.d("ArticleInfoModule", 2, "add push contenxt:" + paramqni.jdField_c_of_type_JavaLangString);
            }
          }
          localInnerMsg.uint64_algorithm_id.set(paramqni.jdField_d_of_type_Long);
          localInnerMsg.uint32_strategy_id.set((int)paramqni.jdField_e_of_type_Long);
          paramList.add(localInnerMsg);
          break;
          localInnerMsg.uint32_jump_src_type.set(1);
        }
      }
    }
    else if (paramqni.jdField_b_of_type_Int == 40830)
    {
      localObject = new oidb_cmd0x68b.InnerMsg();
      if (paramqni.jdField_h_of_type_Int <= 0) {
        break label306;
      }
      ((oidb_cmd0x68b.InnerMsg)localObject).uint32_jump_src_type.set(paramqni.jdField_h_of_type_Int);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramqni.jdField_c_of_type_JavaLangString))
      {
        ((oidb_cmd0x68b.InnerMsg)localObject).bytes_push_context.set(ByteStringMicro.copyFromUtf8(paramqni.jdField_c_of_type_JavaLangString));
        if (QLog.isColorLevel()) {
          QLog.d("ArticleInfoModule", 2, "troop subscribe add push contenxt:" + paramqni.jdField_c_of_type_JavaLangString);
        }
      }
      paramList.add(localObject);
      return;
      label306:
      ((oidb_cmd0x68b.InnerMsg)localObject).uint32_jump_src_type.set(1);
    }
  }
  
  private void b(qni paramqni, oidb_cmd0x68b.ReqBody paramReqBody)
  {
    if ((paramqni.jdField_b_of_type_Int == 0) && (pha.a()))
    {
      paramqni = new oidb_cmd0x68b.RefreshHistory();
      paramqni.bytes_session_id.set(ByteStringMicro.copyFromUtf8(pha.l()));
      paramqni.rpt_refresh_history.set(pha.a());
      if (QLog.isColorLevel()) {
        QLog.d("ArticleInfoModule", 2, "session_id = " + pha.l() + ", history = " + pha.a().toString());
      }
      paramReqBody.msg_refresh_history.set(paramqni);
    }
  }
  
  private void b(qni paramqni, oidb_cmd0x68b.ReqChannelPara paramReqChannelPara)
  {
    if (pha.s())
    {
      paramqni = a(paramqni.jdField_b_of_type_Int);
      if ((paramqni != null) && (paramqni.size() > 0))
      {
        oidb_cmd0x68b.UserExposeArticle localUserExposeArticle = new oidb_cmd0x68b.UserExposeArticle();
        localUserExposeArticle.rpt_article.set(paramqni);
        paramReqChannelPara.user_expose_article.set(localUserExposeArticle);
      }
    }
  }
  
  private void b(oidb_cmd0x68b.ReqChannelPara paramReqChannelPara)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = null;
    Object localObject3 = Aladdin.getConfig(225);
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((AladdinConfig)localObject3).getString("report_app_package_list", "");
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject1 = ((String)localObject3).split("\\|");
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.jdField_a_of_type_ArrayOfJavaLangString;
    }
    int k = localObject2.length;
    int i = 0;
    if (i < k)
    {
      localObject1 = localObject2[i];
      localObject3 = new oidb_cmd0x68b.PkgInstallInfo();
      ((oidb_cmd0x68b.PkgInstallInfo)localObject3).bytes_pkg_name.set(ByteStringMicro.copyFromUtf8((String)localObject1));
      PBUInt32Field localPBUInt32Field = ((oidb_cmd0x68b.PkgInstallInfo)localObject3).uint32_is_installed;
      if (bgnw.a(BaseApplicationImpl.getContext(), (String)localObject1)) {}
      for (int j = 1;; j = 0)
      {
        localPBUInt32Field.set(j);
        ((oidb_cmd0x68b.PkgInstallInfo)localObject3).uint32_platform_type.set(1);
        ((oidb_cmd0x68b.PkgInstallInfo)localObject3).bytes_version.set(ByteStringMicro.copyFromUtf8(bgnw.a(BaseApplicationImpl.getContext(), (String)localObject1)));
        localArrayList.add(localObject3);
        i += 1;
        break;
      }
    }
    paramReqChannelPara.rpt_pkg_install_info.set(localArrayList);
  }
  
  private void b(oidb_cmd0x8c8.RspBody paramRspBody, ConcurrentHashMap<String, ArticleInfo> paramConcurrentHashMap, boolean paramBoolean)
  {
    paramRspBody = paramRspBody.rpt_del_feeds_info_list.get();
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ArticleInfoModule.40(this, paramRspBody, paramConcurrentHashMap));
  }
  
  public static boolean b()
  {
    return jdField_b_of_type_Boolean;
  }
  
  private boolean b(ArticleInfo paramArticleInfo)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramArticleInfo.publishUin != 0L)
    {
      localObject = "publishUin = " + paramArticleInfo.publishUin;
      localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(ArticleInfo.class, true, (String)localObject, null, null, null, "mRecommendSeq desc", null);
      if (localObject == null)
      {
        QLog.d("ArticleInfoModule", 1, "no soical feeds to update article.publishUin:" + paramArticleInfo.publishUin);
        bool1 = false;
      }
    }
    else
    {
      return bool1;
    }
    Object localObject = ((List)localObject).iterator();
    for (;;)
    {
      bool1 = bool2;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      a(paramArticleInfo, (ArticleInfo)((Iterator)localObject).next());
    }
  }
  
  private void c(int paramInt, List<rfc> paramList)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ArticleInfoModule.10(this, paramInt, paramList));
  }
  
  private void c(@NotNull ArticleInfo paramArticleInfo, @NotNull oidb_cmd0x83e.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs != null) && (snh.g(paramArticleInfo)))
    {
      Object localObject1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs;
      paramArticleInfo = new feeds_info.UGCFeedsInfo();
      qnb.a(paramArticleInfo.bytes_ugc_comments, ((rhs)localObject1).jdField_a_of_type_JavaLangString);
      paramArticleInfo.enum_ugc_feeds_card_type.set(((rhs)localObject1).jdField_a_of_type_Int);
      paramArticleInfo.uint64_cuin.set(((rhs)localObject1).jdField_a_of_type_Long);
      Object localObject2 = ((rhs)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
      Object localObject3;
      Object localObject4;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (rht)((Iterator)localObject2).next();
        localObject4 = new feeds_info.UGCPicInfo();
        ((feeds_info.UGCPicInfo)localObject4).is_animation.set(((rht)localObject3).jdField_c_of_type_Int);
        ((feeds_info.UGCPicInfo)localObject4).uint32_pic_height.set(((rht)localObject3).jdField_b_of_type_Int);
        ((feeds_info.UGCPicInfo)localObject4).uint32_pic_width.set(((rht)localObject3).jdField_a_of_type_Int);
        qnb.a(((feeds_info.UGCPicInfo)localObject4).bytes_pic_md5, ((rht)localObject3).jdField_a_of_type_JavaLangString);
        qnb.a(((feeds_info.UGCPicInfo)localObject4).bytes_pic_url, ((rht)localObject3).jdField_b_of_type_JavaLangString);
        qnb.a(((feeds_info.UGCPicInfo)localObject4).bytes_thumbnail_url, ((rht)localObject3).jdField_c_of_type_JavaLangString);
        paramArticleInfo.msg_ugc_pic_info_list.add((MessageMicro)localObject4);
      }
      localObject2 = ((rhs)localObject1).c.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (SocializeFeedsInfo.UGCVoiceInfo)((Iterator)localObject2).next();
        localObject4 = new feeds_info.UGCVoiceInfo();
        qnb.a(((feeds_info.UGCVoiceInfo)localObject4).bytes_voice_url, ((SocializeFeedsInfo.UGCVoiceInfo)localObject3).jdField_a_of_type_JavaLangString);
        ((feeds_info.UGCVoiceInfo)localObject4).uint32_duration.set(((SocializeFeedsInfo.UGCVoiceInfo)localObject3).jdField_a_of_type_Int);
        ((feeds_info.UGCVoiceInfo)localObject4).uint32_file_size.set(((SocializeFeedsInfo.UGCVoiceInfo)localObject3).jdField_b_of_type_Int);
        paramArticleInfo.msg_ugc_voice_info_list.add((MessageMicro)localObject4);
      }
      localObject1 = ((rhs)localObject1).b.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (rhu)((Iterator)localObject1).next();
        localObject3 = new feeds_info.UGCVideoInfo();
        ((feeds_info.UGCVideoInfo)localObject3).uint32_pic_height.set(((rhu)localObject2).jdField_d_of_type_Int);
        ((feeds_info.UGCVideoInfo)localObject3).uint32_pic_width.set(((rhu)localObject2).jdField_c_of_type_Int);
        ((feeds_info.UGCVideoInfo)localObject3).uint32_video_height.set(((rhu)localObject2).jdField_b_of_type_Int);
        ((feeds_info.UGCVideoInfo)localObject3).uint32_video_width.set(((rhu)localObject2).jdField_a_of_type_Int);
        ((feeds_info.UGCVideoInfo)localObject3).uint64_duration.set(((rhu)localObject2).jdField_a_of_type_Long);
        ((feeds_info.UGCVideoInfo)localObject3).uint32_create_time.set(((rhu)localObject2).jdField_e_of_type_Int);
        ((feeds_info.UGCVideoInfo)localObject3).uint32_busi_type.set(((rhu)localObject2).jdField_f_of_type_Int);
        qnb.a(((feeds_info.UGCVideoInfo)localObject3).bytes_pic_md5, ((rhu)localObject2).jdField_c_of_type_JavaLangString);
        qnb.a(((feeds_info.UGCVideoInfo)localObject3).bytes_pic_url, ((rhu)localObject2).jdField_d_of_type_JavaLangString);
        qnb.a(((feeds_info.UGCVideoInfo)localObject3).bytes_video_md5, ((rhu)localObject2).jdField_a_of_type_JavaLangString);
        qnb.a(((feeds_info.UGCVideoInfo)localObject3).bytes_video_url, ((rhu)localObject2).jdField_b_of_type_JavaLangString);
        qnb.a(((feeds_info.UGCVideoInfo)localObject3).bytes_title, ((rhu)localObject2).jdField_e_of_type_JavaLangString);
        qnb.a(((feeds_info.UGCVideoInfo)localObject3).bytes_uuid, ((rhu)localObject2).jdField_f_of_type_JavaLangString);
        qnb.a(((feeds_info.UGCVideoInfo)localObject3).bytes_vid, ((rhu)localObject2).i);
        qnb.a(((feeds_info.UGCVideoInfo)localObject3).bytes_share_url, ((rhu)localObject2).h);
        qnb.a(((feeds_info.UGCVideoInfo)localObject3).bytes_uniq_id, ((rhu)localObject2).g);
        paramArticleInfo.msg_ugc_video_info_list.add((MessageMicro)localObject3);
      }
      paramSocializeFeedsInfo.msg_ugc_topic_feeds_info.set(paramArticleInfo);
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg)
  {
    int i = ((Integer)paramToServiceMsg.getAttribute("0x8c8_retry_times")).intValue();
    if (i < 0)
    {
      paramToServiceMsg.addAttribute("0x8c8_retry_times", Integer.valueOf(i + 1));
      a(paramToServiceMsg);
      return;
    }
    QLog.d("ArticleInfoModule", 1, "retry times:" + i + " exceeds");
  }
  
  private static void c(List<ArticleInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.listIterator();
    label12:
    ArticleInfo localArticleInfo1;
    ArticleInfo localArticleInfo2;
    for (;;)
    {
      if (paramList.hasNext())
      {
        localArticleInfo1 = (ArticleInfo)paramList.next();
        localArticleInfo2 = a(localArticleInfo1);
        if (localArticleInfo2 == null)
        {
          paramList.remove();
        }
        else
        {
          if (localArticleInfo2 != localArticleInfo1) {
            paramList.set(localArticleInfo2);
          }
          pxn.a(localArticleInfo2);
          if (pfr.a(snh.c(localArticleInfo2)))
          {
            if (Looper.getMainLooper() != Looper.myLooper()) {
              break label110;
            }
            ThreadManager.getSubThreadHandler().post(new ArticleInfoModule.46(localArticleInfo2));
          }
        }
      }
    }
    for (;;)
    {
      localArticleInfo1.articleViewModel = tkt.a(localArticleInfo1);
      break label12;
      break;
      label110:
      pfr.a(localArticleInfo2);
    }
  }
  
  private void c(qni paramqni, List<oidb_cmd0x68b.InnerMsg> paramList)
  {
    oidb_cmd0x68b.InnerMsg localInnerMsg = new oidb_cmd0x68b.InnerMsg();
    if (paramqni.jdField_h_of_type_Int == 5)
    {
      localInnerMsg.uint32_jump_src_type.set(5);
      localInnerMsg.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(paramqni.jdField_a_of_type_JavaLangString));
      if (!TextUtils.isEmpty(paramqni.jdField_b_of_type_JavaLangString)) {
        localInnerMsg.bytes_title.set(ByteStringMicro.copyFromUtf8(paramqni.jdField_b_of_type_JavaLangString));
      }
      if (!TextUtils.isEmpty(paramqni.jdField_c_of_type_JavaLangString))
      {
        localInnerMsg.bytes_push_context.set(ByteStringMicro.copyFromUtf8(paramqni.jdField_c_of_type_JavaLangString));
        if (QLog.isColorLevel()) {
          QLog.d("ArticleInfoModule", 2, "add push contenxt:" + paramqni.jdField_c_of_type_JavaLangString);
        }
      }
    }
    for (;;)
    {
      paramList.add(localInnerMsg);
      return;
      localInnerMsg.uint32_jump_src_type.set(3);
      localInnerMsg.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(paramqni.jdField_a_of_type_JavaLangString));
      if (!TextUtils.isEmpty(paramqni.jdField_b_of_type_JavaLangString)) {
        localInnerMsg.bytes_title.set(ByteStringMicro.copyFromUtf8(paramqni.jdField_b_of_type_JavaLangString));
      }
    }
  }
  
  private void c(qni paramqni, oidb_cmd0x68b.ReqBody paramReqBody)
  {
    int k = 1;
    pmm localpmm;
    int j;
    int i;
    if (paramqni.jdField_h_of_type_Boolean)
    {
      localpmm = (pmm)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(163);
      if (localpmm != null)
      {
        if (paramqni.jdField_a_of_type_Long != -1L) {
          break label280;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ArticleInfoModule", 2, "AdvertisementInfoModule reqAdvertisementList params.beginRecommendSeq = " + paramqni.jdField_a_of_type_Long);
        }
        j = 30;
        pmh.a().a(paramqni.jdField_b_of_type_Int, true);
        i = 0;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArticleInfoModule", 2, "AdvertisementInfoModule reqAdvertisementList  adStartPos = " + i + " adEndPos" + j);
      }
      if (pmh.a().a(paramqni.jdField_b_of_type_Int))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArticleInfoModule", 2, "AdvertisementInfoModule reqAdvertisementList needRequestAdvertisement channelID= " + paramqni.jdField_b_of_type_Int);
        }
        if ((paramqni.jdField_g_of_type_Int == 2) || (paramqni.jdField_g_of_type_Int == 4)) {
          k = 2;
        }
        localObject = localpmm.a().a(paramqni, paramqni.jdField_b_of_type_Int, k, i, j);
        localpmm.a().a(paramqni.jdField_b_of_type_Int, i, j);
        if (localObject != null)
        {
          paramReqBody.req_advertise_para.set((MessageMicro)localObject);
          oat.a(null, "", "0X8007BA7", "0X8007BA7", 0, 0, "", "", "", "");
        }
      }
      return;
      label280:
      Object localObject = pmh.a().a(paramqni.jdField_b_of_type_Int);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArticleInfoModule", 2, "AdvertisementInfoModule reqAdvertisementList posRange first = " + ((android.util.Pair)localObject).first + " sencond = " + ((android.util.Pair)localObject).second);
        }
        i = ((Integer)((android.util.Pair)localObject).second).intValue();
        j = i + pvu.jdField_b_of_type_Int;
      }
      else
      {
        localObject = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramqni.jdField_b_of_type_Int));
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ArticleInfoModule", 2, "AdvertisementInfoModule reqAdvertisementList channelArticleMap = " + ((ConcurrentHashMap)localObject).size());
          }
          i = ((ConcurrentHashMap)localObject).size();
          j = i + pvu.jdField_b_of_type_Int;
        }
        else
        {
          j = 0;
          i = 0;
        }
      }
    }
  }
  
  private void c(qni paramqni, oidb_cmd0x68b.ReqChannelPara paramReqChannelPara)
  {
    if ((paramqni.jdField_d_of_type_JavaUtilList != null) && (paramqni.jdField_d_of_type_JavaUtilList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramqni = paramqni.jdField_d_of_type_JavaUtilList.iterator();
      while (paramqni.hasNext()) {
        localArrayList.add(((qnh)paramqni.next()).a());
      }
      paramReqChannelPara.rpt_pkg_install_info.set(localArrayList);
    }
  }
  
  private void d(@NotNull ArticleInfo paramArticleInfo, @NotNull oidb_cmd0x83e.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn != null) && (snh.a(paramArticleInfo)))
    {
      paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn;
      feeds_info.PGCFeedsInfo localPGCFeedsInfo = new feeds_info.PGCFeedsInfo();
      Iterator localIterator = paramArticleInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      Object localObject1;
      Object localObject2;
      while (localIterator.hasNext())
      {
        localObject1 = (rho)localIterator.next();
        localObject2 = new feeds_info.PGCPicInfo();
        qnb.a(((feeds_info.PGCPicInfo)localObject2).bytes_pic_md5, ((rho)localObject1).jdField_a_of_type_JavaLangString);
        qnb.a(((feeds_info.PGCPicInfo)localObject2).bytes_pic_url, ((rho)localObject1).jdField_b_of_type_JavaLangString);
        qnb.a(((feeds_info.PGCPicInfo)localObject2).bytes_thumbnail_url, ((rho)localObject1).jdField_c_of_type_JavaLangString);
        ((feeds_info.PGCPicInfo)localObject2).is_animation.set(((rho)localObject1).jdField_c_of_type_Int);
        ((feeds_info.PGCPicInfo)localObject2).uint32_pic_height.set(((rho)localObject1).jdField_b_of_type_Int);
        ((feeds_info.PGCPicInfo)localObject2).uint32_pic_width.set(((rho)localObject1).jdField_a_of_type_Int);
        localPGCFeedsInfo.msg_pgc_pic_info_list.add((MessageMicro)localObject2);
      }
      localIterator = paramArticleInfo.b.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (rhp)localIterator.next();
        localObject2 = new feeds_info.PGCVideoInfo();
        qnb.a(((feeds_info.PGCVideoInfo)localObject2).bytes_pic_md5, ((rhp)localObject1).jdField_c_of_type_JavaLangString);
        qnb.a(((feeds_info.PGCVideoInfo)localObject2).bytes_pic_url, ((rhp)localObject1).jdField_d_of_type_JavaLangString);
        qnb.a(((feeds_info.PGCVideoInfo)localObject2).bytes_video_md5, ((rhp)localObject1).jdField_a_of_type_JavaLangString);
        qnb.a(((feeds_info.PGCVideoInfo)localObject2).bytes_video_url, ((rhp)localObject1).jdField_b_of_type_JavaLangString);
        localPGCFeedsInfo.msg_pgc_video_info_list.add((MessageMicro)localObject2);
      }
      qnb.a(localPGCFeedsInfo.bytes_pgc_comments, paramArticleInfo.jdField_a_of_type_JavaLangString);
      paramSocializeFeedsInfo.msg_pgc_topic_feeds_info.set(localPGCFeedsInfo);
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 5;
    boolean bool = true;
    int k = qnf.a(paramFromServiceMsg, paramObject, new oidb_cmd0xb83.RspBody());
    int i;
    if (paramToServiceMsg.getAttribute("biu_deliver", Integer.valueOf(0)).equals(Integer.valueOf(1))) {
      i = 4;
    }
    for (;;)
    {
      if (i == 4) {
        ube.a(k, paramToServiceMsg, 1, null);
      }
      if (i == 0) {
        ube.a(k, paramToServiceMsg, 3, null);
      }
      paramFromServiceMsg = pha.a();
      if (k == 0) {}
      for (;;)
      {
        pha.a(paramFromServiceMsg, bool, System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey"), k, i);
        return;
        if (paramToServiceMsg.getAttribute("biu_deliver", Integer.valueOf(0)).equals(Integer.valueOf(2)))
        {
          i = 4;
          break;
        }
        i = j;
        if (paramToServiceMsg.getAttribute("ugc_deliver", Integer.valueOf(0)).equals(Integer.valueOf(1))) {
          break;
        }
        i = j;
        if (paramToServiceMsg.getAttribute("up_master_deliver", Integer.valueOf(0)).equals(Integer.valueOf(1))) {
          break;
        }
        if (paramToServiceMsg.getAttribute("submit_comment", Integer.valueOf(0)).equals(Integer.valueOf(1)))
        {
          i = 0;
          break;
        }
        if (paramToServiceMsg.getAttributes().get("0x83e_upvote_operation_type") == null) {
          break label249;
        }
        i = ((Integer)paramToServiceMsg.getAttributes().get("0x83e_upvote_operation_type")).intValue();
        break;
        bool = false;
      }
      label249:
      i = -1;
    }
  }
  
  private void d(List<ArticleInfo> paramList)
  {
    if (paramList == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        ArticleInfo localArticleInfo = (ArticleInfo)localIterator.next();
        if ((localArticleInfo != null) && (!pjp.a(localArticleInfo))) {
          localArrayList.add(localArticleInfo);
        }
      }
    } while (localArrayList.isEmpty());
    paramList.removeAll(localArrayList);
  }
  
  private void d(qni paramqni, List<oidb_cmd0x68b.InnerMsg> paramList)
  {
    if ((paramqni.jdField_i_of_type_Boolean) && (paramqni.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo != null))
    {
      oidb_cmd0x68b.InnerMsg localInnerMsg = new oidb_cmd0x68b.InnerMsg();
      localInnerMsg.uint32_jump_src_type.set(4);
      localInnerMsg.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(String.valueOf(paramqni.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo.articleID)));
      localInnerMsg.template_id.set(paramqni.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo.templateID);
      localInnerMsg.bytes_push_context.set(ByteStringMicro.copyFromUtf8(paramqni.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo.extraInfo));
      paramList.add(localInnerMsg);
    }
  }
  
  private void d(qni paramqni, oidb_cmd0x68b.ReqBody paramReqBody)
  {
    if (paramqni.jdField_b_of_type_Int == 41403)
    {
      Object localObject = aoor.a("nearby_readinjoy");
      if ((localObject != null) && (((SosoInterface.SosoLbsInfo)localObject).a != null))
      {
        localObject = ((SosoInterface.SosoLbsInfo)localObject).a;
        int i = (int)(((SosoInterface.SosoLocation)localObject).a * 1000000.0D);
        int j = (int)(((SosoInterface.SosoLocation)localObject).b * 1000000.0D);
        localObject = new feeds_info.LocationInfo();
        ((feeds_info.LocationInfo)localObject).uint32_latitude.set(i);
        ((feeds_info.LocationInfo)localObject).uint32_longitude.set(j);
        paramReqBody.location_info.set((MessageMicro)localObject);
      }
      if (paramqni.jdField_a_of_type_Long != -1L)
      {
        paramqni = (String)bmqa.a("readinjoy_nearby_people_last_refresh_cookie_sp_key", "");
        QLog.d("ArticleInfoModule", 1, new Object[] { "load more article, nearby cookie = ", paramqni });
        if (!TextUtils.isEmpty(paramqni)) {
          paramReqBody.bytes_nearby_cookie.set(ByteStringMicro.copyFromUtf8(paramqni));
        }
      }
    }
  }
  
  private void e(@NotNull ArticleInfo paramArticleInfo, @NotNull oidb_cmd0x83e.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rii != null) && (snh.h(paramArticleInfo)))
    {
      feeds_info.TopicRecommendFeedsInfo localTopicRecommendFeedsInfo = new feeds_info.TopicRecommendFeedsInfo();
      localTopicRecommendFeedsInfo.uint32_feeds_style.set(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rii.jdField_a_of_type_Int);
      localTopicRecommendFeedsInfo.uint64_feeds_id.set(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rii.jdField_a_of_type_Long);
      Object localObject = new ArrayList();
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rii.jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rii.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          rik localrik = (rik)localIterator.next();
          feeds_info.TopicRecommendInfo localTopicRecommendInfo = new feeds_info.TopicRecommendInfo();
          localTopicRecommendInfo.uint32_number_of_participants.set(localrik.jdField_b_of_type_Int);
          qnb.a(localTopicRecommendInfo.bytes_business_name, localrik.jdField_a_of_type_JavaLangString);
          qnb.a(localTopicRecommendInfo.bytes_business_name_prefix, localrik.jdField_c_of_type_JavaLangString);
          qnb.a(localTopicRecommendInfo.bytes_business_url, localrik.jdField_b_of_type_JavaLangString);
          qnb.a(localTopicRecommendInfo.bytes_pic_url, localrik.jdField_d_of_type_JavaLangString);
          localTopicRecommendInfo.uint32_business_id.set(localrik.jdField_a_of_type_Int);
          ((List)localObject).add(localTopicRecommendInfo);
        }
      }
      localTopicRecommendFeedsInfo.msg_topic_recommend_info.set((List)localObject);
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rii.jdField_a_of_type_Rij != null)
      {
        localObject = new feeds_info.TopicRecommendFeedsTitle();
        qnb.a(((feeds_info.TopicRecommendFeedsTitle)localObject).bytes_url, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rii.jdField_a_of_type_Rij.jdField_b_of_type_JavaLangString);
        qnb.a(((feeds_info.TopicRecommendFeedsTitle)localObject).bytes_title_content, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rii.jdField_a_of_type_Rij.jdField_a_of_type_JavaLangString);
        localTopicRecommendFeedsInfo.msg_left_title.set((MessageMicro)localObject);
      }
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rii.jdField_b_of_type_Rij != null)
      {
        localObject = new feeds_info.TopicRecommendFeedsTitle();
        qnb.a(((feeds_info.TopicRecommendFeedsTitle)localObject).bytes_url, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rii.jdField_b_of_type_Rij.jdField_b_of_type_JavaLangString);
        qnb.a(((feeds_info.TopicRecommendFeedsTitle)localObject).bytes_title_content, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rii.jdField_b_of_type_Rij.jdField_a_of_type_JavaLangString);
        localTopicRecommendFeedsInfo.msg_right_title.set((MessageMicro)localObject);
      }
      qnb.a(localTopicRecommendFeedsInfo.bytes_subscribe_id, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rii.jdField_a_of_type_JavaLangString);
      localTopicRecommendFeedsInfo.uint64_uin.set(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rii.jdField_b_of_type_Long);
      qnb.a(localTopicRecommendFeedsInfo.bytes_comments, paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rii.jdField_b_of_type_JavaLangString);
      paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.set(localTopicRecommendFeedsInfo);
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = new oidb_cmd0xbbd.RspBody();
    int i = qnf.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
    if (i == 0)
    {
      if (((oidb_cmd0xbbd.RspBody)localObject1).msg_rsp_feeds_data.rpt_feeds_info_list.has())
      {
        paramObject = ((oidb_cmd0xbbd.RspBody)localObject1).msg_rsp_feeds_data.rpt_feeds_info_list.get();
        paramFromServiceMsg = new ArrayList();
        paramObject = paramObject.iterator();
        while (paramObject.hasNext())
        {
          localObject1 = (oidb_cmd0xbbd.RspFeedsInfo)paramObject.next();
          if ((((oidb_cmd0xbbd.RspFeedsInfo)localObject1).msg_article_summary.has()) && (((oidb_cmd0xbbd.RspFeedsInfo)localObject1).uint32_feeds_type.has()))
          {
            localObject2 = qnc.a((articlesummary.ArticleSummary)((oidb_cmd0xbbd.RspFeedsInfo)localObject1).msg_article_summary.get(), 70, 0, null);
            if ((localObject2 != null) && (((ArticleInfo)localObject2).mArticleID != -1L))
            {
              ((ArticleInfo)localObject2).mFeedType = ((oidb_cmd0xbbd.RspFeedsInfo)localObject1).uint32_feeds_type.get();
              paramFromServiceMsg.add(localObject2);
            }
          }
        }
        paramObject = (ArticleInfo)paramToServiceMsg.getAttribute("ArticleInfo");
        a(paramFromServiceMsg, paramObject.mExtraBiuBriefInfo);
        localObject1 = (Integer)paramToServiceMsg.getAttribute("channelID");
        Object localObject2 = (Long)paramToServiceMsg.getAttribute(jdField_d_of_type_JavaLangString);
        paramObject.isExtraBiuExpanded = true;
        a((Integer)localObject1, paramObject, true, false);
        a(true, ((Integer)localObject1).intValue(), false, paramFromServiceMsg, ((Long)localObject2).longValue(), -1L, null, null, paramToServiceMsg);
      }
      return;
    }
    QLog.e("ArticleInfoModule", 1, "handle0xbbdGetMoreBiuList result ==" + i);
  }
  
  private void f(int paramInt)
  {
    if (this.jdField_a_of_type_Pwf != null) {
      this.jdField_a_of_type_Pwf.a(paramInt);
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0x68b.RspBody localRspBody = new oidb_cmd0x68b.RspBody();
    Object localObject = (Boolean)paramToServiceMsg.getAttribute("compressFlag");
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      QLog.d("ArticleInfoModule", 1, new Object[] { "handle0x68bGetArticleList isCompressEnable = ", Boolean.valueOf(bool) });
      int i = pgs.a(paramToServiceMsg, paramFromServiceMsg, paramObject, localRspBody, bool);
      QLog.d("ArticleInfoModule", 1, new Object[] { "handle0x68bGetArticleList resp result code ", Integer.valueOf(i) });
      paramFromServiceMsg = (Integer)paramToServiceMsg.getAttributes().get("channelID");
      bool = a(paramToServiceMsg);
      localObject = (List)paramToServiceMsg.getAttributes().get("SubscriptionArticles");
      a(paramToServiceMsg, paramObject, i, paramFromServiceMsg);
      long l1;
      if (bool)
      {
        long l2 = -1L;
        l1 = l2;
        if (localObject != null)
        {
          l1 = l2;
          if (((List)localObject).size() >= 1) {
            l1 = ((Long)((List)localObject).get(0)).longValue();
          }
        }
        if (i == 0)
        {
          a((List)localObject, localRspBody, l1);
          QLog.d("ArticleInfoModule", 2, "handle0x68bGetArticleList  : [red_pnt_push preload resp back] , article list [ " + a((List)localObject) + " ]");
          return;
        }
      }
      try
      {
        paramFromServiceMsg = new JSONObject();
        paramFromServiceMsg.put("preload_red_pnt_push_articleID", l1);
        paramFromServiceMsg.put("preload_resp_result_code", i);
        oat.a(null, "", "0X8009483", "0X8009483", 0, 0, paramFromServiceMsg.toString(), "", "", "", false);
        tth.a().b(paramToServiceMsg);
        a(paramToServiceMsg, localRspBody, i);
        return;
      }
      catch (JSONException paramFromServiceMsg)
      {
        for (;;)
        {
          paramFromServiceMsg.printStackTrace();
        }
      }
    }
  }
  
  private void g(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ArticleInfoModule.29(this, paramInt));
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = qnf.a(paramFromServiceMsg, paramObject, new cmd0xc5b.RspBody());
    paramToServiceMsg = BaseApplication.getContext().getString(2131694666);
    this.jdField_a_of_type_AndroidOsHandler.post(new ArticleInfoModule.6(this, i, paramToServiceMsg));
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0x46f.RspBody();
    int j = 0;
    int i = 0;
    if (qnf.a(paramFromServiceMsg, paramObject, paramToServiceMsg) == 0)
    {
      if (paramToServiceMsg.uint32_fail_count.has()) {
        i = paramToServiceMsg.uint32_fail_count.get();
      }
      j = i;
      if (!paramToServiceMsg.rpt_result_list.has()) {}
    }
    for (paramToServiceMsg = qnc.c(paramToServiceMsg.rpt_result_list.get());; paramToServiceMsg = null)
    {
      c(i, paramToServiceMsg);
      return;
      i = j;
    }
  }
  
  public static void i()
  {
    jdField_c_of_type_Int = -1;
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0x75e.RspBody();
    int i = qnf.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i == 0) {
      if ((paramToServiceMsg.msg_rsp_article.has()) && (paramToServiceMsg.msg_rsp_article.get() != null))
      {
        paramToServiceMsg = (oidb_cmd0x75e.RspArticle)paramToServiceMsg.msg_rsp_article.get();
        if ((paramToServiceMsg.rpt_article_info.has()) && (paramToServiceMsg.rpt_article_info.get() != null))
        {
          paramToServiceMsg = paramToServiceMsg.rpt_article_info.get();
          if ((paramToServiceMsg.size() > 0) && (((oidb_cmd0x75e.ArticleInfo)paramToServiceMsg.get(0)).bytes_article_xml.has()) && (((oidb_cmd0x75e.ArticleInfo)paramToServiceMsg.get(0)).bytes_article_xml.get() != null))
          {
            paramToServiceMsg = ((oidb_cmd0x75e.ArticleInfo)paramToServiceMsg.get(0)).bytes_article_xml.get().toStringUtf8();
            ((KandianMergeManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(162)).a(paramToServiceMsg);
          }
        }
      }
    }
    for (;;)
    {
      bmqa.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      return;
      if (QLog.isColorLevel()) {
        QLog.w("ArticleInfoModule", 2, "handle0x75eIndividualArticleList error = " + i);
      }
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0x83e.RspBody localRspBody = new oidb_cmd0x83e.RspBody();
    int i = a(paramFromServiceMsg, paramObject, localRspBody);
    QLog.d("ArticleInfoModule", 2, "handle0x83eSubmitComment | resp result code ： " + i);
    paramFromServiceMsg = BaseApplication.getContext().getString(2131716940);
    if (localRspBody.bytes_result_desc.has())
    {
      paramFromServiceMsg = localRspBody.bytes_result_desc.get().toStringUtf8();
      QLog.d("ArticleInfoModule", 2, "handle0x83eSubmitComment | resp errorMsg ： " + paramFromServiceMsg);
    }
    paramObject = (ArticleInfo)paramToServiceMsg.getAttribute("article_info");
    paramToServiceMsg = (String)paramToServiceMsg.getAttribute("comment_json_string");
    this.jdField_a_of_type_AndroidOsHandler.post(new ArticleInfoModule.30(this, i, paramObject, paramToServiceMsg, paramFromServiceMsg));
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xc16.RspBody localRspBody = new oidb_cmd0xc16.RspBody();
    int i = qnf.a(paramFromServiceMsg, paramObject, localRspBody);
    long l = 0L;
    paramToServiceMsg = "";
    if (localRspBody.uint64_topic_id.has()) {
      l = localRspBody.uint64_topic_id.get();
    }
    if (localRspBody.bytes_topic_url.has()) {
      paramToServiceMsg = localRspBody.bytes_topic_url.get().toStringUtf8();
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ArticleInfoModule.31(this, i, l, paramToServiceMsg));
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0x83e.RspBody localRspBody = new oidb_cmd0x83e.RspBody();
    if (a(paramFromServiceMsg, paramObject, localRspBody) == 0)
    {
      QLog.d("ArticleInfoModule", 1, "handle0x83eUpvoteAction result OK");
      if (QLog.isColorLevel())
      {
        if (localRspBody.uint64_feeds_id.has()) {
          QLog.d("ArticleInfoModule", 2, "upvote feeds id:" + localRspBody.uint64_feeds_id.get());
        }
        if (localRspBody.uint32_operation.has())
        {
          paramFromServiceMsg = new StringBuilder().append("upvote status:");
          if (localRspBody.uint32_operation.get() != 2) {
            break label164;
          }
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ArticleInfoModule", 2, bool);
      try
      {
        paramToServiceMsg = (ArticleInfo)paramToServiceMsg.getAttribute("0x83e_article");
        this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ArticleInfoModule.32(this, paramToServiceMsg));
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        label164:
        QLog.d("ArticleInfoModule", 1, "failed to update article ", paramToServiceMsg);
      }
    }
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0x83e.RspBody localRspBody = new oidb_cmd0x83e.RspBody();
    int i = a(paramFromServiceMsg, paramObject, localRspBody);
    if (QLog.isColorLevel()) {
      QLog.d("ArticleInfoModule", 1, "handle0x83eBiuAtlasDeliverAction result:" + i);
    }
    paramToServiceMsg = BaseApplication.getContext().getString(2131716975);
    if (localRspBody.bytes_result_desc.has())
    {
      paramToServiceMsg = localRspBody.bytes_result_desc.get().toStringUtf8();
      QLog.d("ArticleInfoModule", 2, "handle0x83eBiuAtlasDeliverAction | resp errorMsg ： " + paramToServiceMsg);
    }
    long l = localRspBody.uint64_feeds_id.get();
    this.jdField_a_of_type_AndroidOsHandler.post(new ArticleInfoModule.33(this, l, i, paramToServiceMsg));
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0x83e.RspBody localRspBody = new oidb_cmd0x83e.RspBody();
    int i = a(paramFromServiceMsg, paramObject, localRspBody);
    long l = localRspBody.uint64_feeds_id.get();
    paramFromServiceMsg = localRspBody.bytes_rowkey.get().toStringUtf8();
    int j = localRspBody.uint32_ugc_status.get();
    paramObject = localRspBody.bytes_default_comments.get().toStringUtf8();
    if (QLog.isColorLevel()) {
      QLog.d("ArticleInfoModule", 1, "handle0x83eDeliverUGCAction result=" + i + ", feedsId=" + l + ", rowkey=" + paramFromServiceMsg + ", status=" + j + ", comment=" + paramObject);
    }
    paramToServiceMsg = BaseApplication.getContext().getString(2131716990);
    if (localRspBody.bytes_result_desc.has())
    {
      paramToServiceMsg = localRspBody.bytes_result_desc.get().toStringUtf8();
      QLog.d("ArticleInfoModule", 2, "handle0x83eDeliverUGCAction | resp errorMsg ： " + paramToServiceMsg);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ArticleInfoModule.34(this, i, l, paramFromServiceMsg, j, paramObject, paramToServiceMsg));
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0x83e.RspBody localRspBody = new oidb_cmd0x83e.RspBody();
    int i = a(paramFromServiceMsg, paramObject, localRspBody);
    long l = localRspBody.uint64_feeds_id.get();
    paramObject = localRspBody.bytes_rowkey.get().toStringUtf8();
    int j = localRspBody.uint32_ugc_status.get();
    String str = localRspBody.bytes_default_comments.get().toStringUtf8();
    if (QLog.isColorLevel()) {
      QLog.d("ArticleInfoModule", 1, "handle0x83eDeliverUpMasterAction result=" + i + ", feedsId=" + l + ", rowkey=" + paramObject + ", status=" + j + ", comment=" + str);
    }
    paramFromServiceMsg = BaseApplication.getContext().getString(2131716990);
    if (localRspBody.bytes_result_desc.has())
    {
      paramFromServiceMsg = localRspBody.bytes_result_desc.get().toStringUtf8();
      QLog.d("ArticleInfoModule", 2, "handle0x83eDeliverUpMasterAction | resp errorMsg ： " + paramFromServiceMsg);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ArticleInfoModule.35(this, paramToServiceMsg, i, l, paramObject, j, str, paramFromServiceMsg));
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0x83e.RspBody localRspBody = new oidb_cmd0x83e.RspBody();
    int i = a(paramFromServiceMsg, paramObject, localRspBody);
    if (QLog.isColorLevel()) {
      QLog.d("ArticleInfoModule", 1, "handle0x83eBiuDeliverAction result:" + i);
    }
    long l;
    if (i == 0)
    {
      l = ((Long)paramToServiceMsg.getAttribute("BaseArticleSeq")).longValue();
      paramToServiceMsg = a(Integer.valueOf(0), Long.valueOf(l));
      if ((paramToServiceMsg != null) && (paramToServiceMsg.mSocialFeedInfo != null))
      {
        QLog.d("ArticleInfoModule", 2, new Object[] { "handle0x83eBiuDeliverAction, channel_id = ", Integer.valueOf(0), " articleId = ", Long.valueOf(paramToServiceMsg.mArticleID), " before biu count = ", Integer.valueOf(paramToServiceMsg.mSocialFeedInfo.jdField_f_of_type_Int) });
        paramFromServiceMsg = paramToServiceMsg.mSocialFeedInfo;
        paramFromServiceMsg.jdField_f_of_type_Int += 1;
        paramToServiceMsg.invalidateProteusTemplateBean();
        a(paramToServiceMsg);
      }
      paramToServiceMsg = a(Integer.valueOf(70), Long.valueOf(l));
      if ((paramToServiceMsg != null) && (paramToServiceMsg.mSocialFeedInfo != null))
      {
        QLog.d("ArticleInfoModule", 2, new Object[] { "handle0x83eBiuDeliverAction, channel_id = ", Integer.valueOf(70), " articleId = ", Long.valueOf(paramToServiceMsg.mArticleID), " before biu count = ", Integer.valueOf(paramToServiceMsg.mSocialFeedInfo.jdField_f_of_type_Int) });
        paramFromServiceMsg = paramToServiceMsg.mSocialFeedInfo;
        paramFromServiceMsg.jdField_f_of_type_Int += 1;
        paramToServiceMsg.invalidateProteusTemplateBean();
        a(paramToServiceMsg);
      }
    }
    for (;;)
    {
      paramToServiceMsg = BaseApplication.getContext().getString(2131716975);
      if (localRspBody.bytes_result_desc.has())
      {
        paramToServiceMsg = localRspBody.bytes_result_desc.get().toStringUtf8();
        QLog.d("ArticleInfoModule", 2, "handle0x83eBiuDeliverAction | resp errorMsg ： " + paramToServiceMsg);
      }
      l = localRspBody.uint64_feeds_id.get();
      this.jdField_a_of_type_AndroidOsHandler.post(new ArticleInfoModule.36(this, l, i, paramToServiceMsg));
      return;
      if (i != 33) {}
    }
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0x8c8.RspBody localRspBody = new oidb_cmd0x8c8.RspBody();
    int i = qnf.a(paramFromServiceMsg, paramObject, localRspBody);
    try
    {
      paramFromServiceMsg = (ConcurrentHashMap)paramToServiceMsg.getAttribute("0x8c8_articleMap");
      boolean bool = ((Boolean)paramToServiceMsg.getAttribute("isUpdateByAccount")).booleanValue();
      if (i == 0)
      {
        QLog.d("ArticleInfoModule", 1, "handle0x8c8UpvoteAction result OK");
        a(localRspBody, paramFromServiceMsg, bool);
        if ((localRspBody.rpt_del_feeds_info_list.has()) && (localRspBody.rpt_del_feeds_info_list.get() != null)) {
          b(localRspBody, paramFromServiceMsg, bool);
        }
      }
      else
      {
        c(paramToServiceMsg);
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.d("ArticleInfoModule", 1, "handle0x8c8UpdateUpvoteAndComment error! msg=" + paramToServiceMsg);
    }
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xa6e.RspBody localRspBody = new oidb_cmd0xa6e.RspBody();
    if (qnf.a(paramFromServiceMsg, paramObject, localRspBody) == 0)
    {
      paramFromServiceMsg = localRspBody.rpt_topicinfo.get();
      int i = ((Integer)paramToServiceMsg.getAttribute("channelId")).intValue();
      paramToServiceMsg = (Set)paramToServiceMsg.getAttribute("0xa6e_articleSeqSet");
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ArticleInfoModule.48(this, i, paramToServiceMsg, paramFromServiceMsg));
    }
  }
  
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xc6d.RspBody();
    int j = qnf.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    int i = 0;
    if (j == 0)
    {
      paramFromServiceMsg = paramToServiceMsg.rpt_card_json.get();
      paramToServiceMsg = new ArrayList();
      paramFromServiceMsg = paramFromServiceMsg.iterator();
      while (paramFromServiceMsg.hasNext()) {
        paramToServiceMsg.add(((ByteStringMicro)paramFromServiceMsg.next()).toStringUtf8());
      }
      i = paramToServiceMsg.size();
      this.jdField_a_of_type_AndroidOsHandler.post(new ArticleInfoModule.49(this, paramToServiceMsg));
    }
    QLog.d("ArticleInfoModule", 1, "handle0xc6dInteractiveCards,result=" + j + " size=" + i);
  }
  
  private void t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = qnf.a(paramFromServiceMsg, paramObject, new oidb_cmd0xbd4.RspBody());
    paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
    this.jdField_a_of_type_AndroidOsHandler.post(new ArticleInfoModule.50(this, paramToServiceMsg, i));
  }
  
  private void u(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xbd6.RspBody localRspBody = new oidb_cmd0xbd6.RspBody();
    int i = qnf.a(paramFromServiceMsg, paramObject, localRspBody);
    paramFromServiceMsg = paramFromServiceMsg.getServiceCmd();
    paramToServiceMsg = (String)paramToServiceMsg.getAttribute("rowKey");
    this.jdField_a_of_type_AndroidOsHandler.post(new ArticleInfoModule.51(this, paramFromServiceMsg, i, localRspBody, paramToServiceMsg));
  }
  
  private void v(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xb83.RspBody();
    int i = qnf.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    paramFromServiceMsg = new ArrayList();
    if (i == 0)
    {
      QLog.d("ArticleInfoModule", 1, "handle0xb83GetKeywordList result OK");
      paramObject = qnc.d(paramToServiceMsg.msg_rsp_search_tag_info.rpt_msg_tag_info_list.get());
      paramToServiceMsg = qnc.d(paramToServiceMsg.msg_rsp_recommend_tag_info.rpt_msg_tag_info_list.get());
      paramFromServiceMsg.addAll(paramObject);
      paramFromServiceMsg.addAll(paramToServiceMsg);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new ArticleInfoModule.52(this, paramFromServiceMsg));
      return;
      QLog.d("ArticleInfoModule", 2, "handle0xb83GetKeywordList: failed, result: " + i);
    }
  }
  
  private void w(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xbde.RspBody();
    int i = qnf.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    paramFromServiceMsg = new ArrayList();
    paramObject = new ArrayList();
    if (i == 0)
    {
      QLog.d("ArticleInfoModule", 2, "handle0xbdeGetTopicList: result OK");
      Iterator localIterator = paramToServiceMsg.msg_rsp_search_tag_info.rpt_msg_search_info_list.get().iterator();
      while (localIterator.hasNext()) {
        paramObject.add(((oidb_cmd0xbde.SearchInfo)localIterator.next()).bytes_key.get().toStringUtf8());
      }
      paramFromServiceMsg.addAll(qnc.e(paramToServiceMsg.msg_rsp_search_tag_info.rpt_msg_tag_info_list.get()));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new ArticleInfoModule.53(this, paramObject, paramFromServiceMsg));
      return;
      QLog.d("ArticleInfoModule", 2, "handle0xbdeGetTopicList: failed, result: " + i);
    }
  }
  
  public int a(Integer paramInteger)
  {
    paramInteger = (List)this.jdField_b_of_type_JavaUtilMap.get(paramInteger);
    if (paramInteger == null) {
      return 0;
    }
    return paramInteger.size();
  }
  
  public long a(Integer paramInteger)
  {
    long l1 = -1L;
    paramInteger = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramInteger);
    long l2;
    if (paramInteger == null) {
      l2 = l1;
    }
    do
    {
      return l2;
      paramInteger = paramInteger.keySet().iterator();
      l2 = l1;
    } while (!paramInteger.hasNext());
    Long localLong = (Long)paramInteger.next();
    if (localLong.longValue() > l1) {
      l1 = localLong.longValue();
    }
    for (;;)
    {
      break;
    }
  }
  
  public ArticleInfo a(ArticleInfo paramArticleInfo, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    Object localObject3;
    if (paramInt == 0)
    {
      localObject3 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(0));
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject2 = ((ConcurrentHashMap)localObject3).values().iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = (ArticleInfo)((Iterator)localObject2).next();
        } while ((((ArticleInfo)localObject1).mRecommendSeq != paramArticleInfo.mRecommendSeq) || (((ArticleInfo)localObject1).mArticleID != paramArticleInfo.mArticleID));
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ((ArticleInfo)localObject1).mSocialFeedInfoByte = paramArticleInfo.mSocialFeedInfoByte;
        if (QLog.isColorLevel()) {
          QLog.d("ArticleInfoModule", 2, "mArticleID = " + ((ArticleInfo)localObject1).mArticleID + ", old data = " + ((ArticleInfo)localObject1).mSocialFeedInfo + ", new data = " + paramArticleInfo.mSocialFeedInfo);
        }
        ((ArticleInfo)localObject1).mSocialFeedInfo = paramArticleInfo.mSocialFeedInfo;
        localObject2 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt));
        localObject3 = localObject1;
        if (localObject2 != null)
        {
          localObject3 = ((ConcurrentHashMap)localObject2).values().iterator();
          do
          {
            localObject2 = localObject1;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject2 = (ArticleInfo)((Iterator)localObject3).next();
          } while ((((ArticleInfo)localObject2).mFeedId == 0L) || (((ArticleInfo)localObject2).mFeedId != paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long) || (((ArticleInfo)localObject2).mFeedType != paramArticleInfo.mFeedType));
          if ((localObject2 == null) || (((ArticleInfo)localObject2).mFeedId != paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long) || (((ArticleInfo)localObject2).mFeedType != paramArticleInfo.mFeedType)) {
            break label443;
          }
          ((ArticleInfo)localObject2).mSocialFeedInfoByte = paramArticleInfo.mSocialFeedInfoByte;
          if (QLog.isColorLevel()) {
            QLog.d("ArticleInfoModule", 2, "mArticleID = " + ((ArticleInfo)localObject2).mArticleID + ", old data = " + ((ArticleInfo)localObject2).mSocialFeedInfo + ", new data = " + paramArticleInfo.mSocialFeedInfo);
          }
          ((ArticleInfo)localObject2).mSocialFeedInfo = paramArticleInfo.mSocialFeedInfo;
          localObject3 = localObject2;
        }
      }
      label443:
      do
      {
        return localObject3;
        if (QLog.isColorLevel()) {
          QLog.d("ArticleInfoModule", 2, "cannot update no-cached article id:" + paramArticleInfo.mArticleID + " title:" + paramArticleInfo.mTitle);
        }
        break;
        localObject3 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.d("ArticleInfoModule", 2, "cannot update no-cached article id:" + paramArticleInfo.mArticleID + " title:" + paramArticleInfo.mTitle);
      return localObject2;
      localObject1 = null;
    }
  }
  
  public ArticleInfo a(Integer paramInteger)
  {
    if (pha.c(paramInteger.intValue()))
    {
      paramInteger = null;
      return paramInteger;
    }
    List localList = (List)this.jdField_b_of_type_JavaUtilMap.get(paramInteger);
    if ((localList != null) && (!localList.isEmpty()))
    {
      if (paramInteger.intValue() == 70)
      {
        int i = 0;
        for (;;)
        {
          if (i >= localList.size()) {
            break label114;
          }
          ArticleInfo localArticleInfo = (ArticleInfo)localList.get(i);
          paramInteger = localArticleInfo;
          if (localArticleInfo.hintFlag) {
            break;
          }
          i += 1;
        }
      }
      return (ArticleInfo)localList.get(localList.size() - 1);
    }
    label114:
    return null;
  }
  
  public ArticleInfo a(Integer paramInteger, Long paramLong)
  {
    paramInteger = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramInteger);
    if (paramInteger == null) {
      return null;
    }
    return (ArticleInfo)paramInteger.get(paramLong);
  }
  
  public List<oidb_cmd0x68b.ExposeArticleInfo> a(int paramInt)
  {
    if (!pha.s()) {
      return null;
    }
    Object localObject = (ConcurrentHashMap)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt));
    if ((localObject == null) || (((ConcurrentHashMap)localObject).isEmpty())) {
      return null;
    }
    localObject = new ArrayList(((ConcurrentHashMap)localObject).values());
    Collections.sort((List)localObject);
    if (((List)localObject).size() > 100) {
      localObject = ((List)localObject).subList(0, 100);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArticleInfoModule", 2, "add exposure data to 68b, channelID : " + paramInt + ", infos : " + localObject);
      }
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ArticleExposureInfo localArticleExposureInfo = (ArticleExposureInfo)((Iterator)localObject).next();
        if (!TextUtils.isEmpty(localArticleExposureInfo.rowkey))
        {
          oidb_cmd0x68b.ExposeArticleInfo localExposeArticleInfo = new oidb_cmd0x68b.ExposeArticleInfo();
          localExposeArticleInfo.bytes_rowkeys.set(ByteStringMicro.copyFromUtf8(localArticleExposureInfo.rowkey));
          localExposeArticleInfo.uint32_feeds_type.set(localArticleExposureInfo.feedsType);
          localExposeArticleInfo.uint64_algorithm_id.set(localArticleExposureInfo.algorithmID);
          localArrayList.add(localExposeArticleInfo);
        }
      }
      return localArrayList;
    }
  }
  
  List<ArticleInfo> a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = "mChannelID = ? and mRecommendSeq < ?";; localObject = "mChannelID = ? and mRecommendSeq > ?")
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArticleInfoModule", 2, "loadChannelArticleSeqList with selection=" + (String)localObject + "channelId=" + paramInt1 + "recommendSeq=" + paramLong + "count=" + paramInt2);
      }
      ArrayList localArrayList = new ArrayList();
      localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(ArticleInfo.class, true, (String)localObject, new String[] { String.valueOf(paramInt1), String.valueOf(paramLong) }, null, null, "mRecommendSeq desc", String.valueOf(paramInt2));
      if (localObject != null)
      {
        qnc.a((List)localObject);
        localArrayList.addAll((Collection)localObject);
      }
      if ((localArrayList.isEmpty()) && (QLog.isColorLevel())) {
        QLog.e("ArticleInfoModule", 2, "loadChannelArticleSeqList mEntityManager.query return empty");
      }
      e(paramInt1);
      return localArrayList;
    }
  }
  
  public List<Long> a(Integer paramInteger)
  {
    Object localObject = c(paramInteger);
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(((List)localObject).size());
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)((Iterator)localObject).next();
      if ((paramInteger.intValue() != 70) && (paramInteger.intValue() != 41403) && (!localHashSet1.add(Long.valueOf(localArticleInfo.mArticleID))))
      {
        QLog.d("ArticleInfoModule", 2, "getChannelArticleSeqList 有重复文章， channelID = " + paramInteger + ", seq = " + localArticleInfo.mRecommendSeq + "，articleID = " + localArticleInfo.mArticleID);
        a(paramInteger, localArticleInfo);
      }
      else if ((paramInteger.intValue() == 41403) && (!localHashSet2.add(Long.valueOf(localArticleInfo.mFeedId))))
      {
        QLog.d("ArticleInfoModule", 1, new Object[] { "getChannelArticleSeqList 有重复feeds, channelID = ", paramInteger, ", seq = ", Long.valueOf(localArticleInfo.mRecommendSeq), ", feedsId = ", Long.valueOf(localArticleInfo.mFeedId) });
        a(paramInteger, localArticleInfo);
      }
      else
      {
        localArrayList.add(Long.valueOf(localArticleInfo.mRecommendSeq));
      }
    }
    this.jdField_a_of_type_Pxn.a(paramInteger, localArrayList);
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_b_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
    if (this.jdField_d_of_type_JavaUtilLinkedHashMap != null) {
      this.jdField_d_of_type_JavaUtilLinkedHashMap.clear();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = (ArrayList)d(paramInt1);
    if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArticleInfoModule", 2, "no recommend topic feeds");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    qnc.a((List)localObject1);
    localArrayList.addAll((Collection)localObject1);
    int i = 0;
    int j;
    if (i < localArrayList.size())
    {
      j = (int)((ArticleInfo)localArrayList.get(i)).mChannelID;
      localObject1 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(j));
      if (localObject1 != null) {
        break label672;
      }
      localObject1 = new ConcurrentHashMap();
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(j), localObject1);
    }
    label672:
    for (;;)
    {
      for (;;)
      {
        if ((((ArticleInfo)localArrayList.get(i)).mTopicRecommendFeedsInfo != null) && (((ArticleInfo)localArrayList.get(i)).mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
          ((rik)((ArticleInfo)localArrayList.get(i)).mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Int = paramInt2;
        }
        int k;
        Object localObject2;
        if (((ArticleInfo)localArrayList.get(i)).mPolymericInfo != null)
        {
          k = paramInt2 + 1;
          ((ArticleInfo)localArrayList.get(i)).mPolymericInfo.jdField_e_of_type_Int = k;
          localObject2 = new articlesummary.PackInfo();
        }
        try
        {
          ((articlesummary.PackInfo)localObject2).mergeFrom(((ArticleInfo)localArrayList.get(i)).mPackInfoBytes);
          ((articlesummary.PackInfo)localObject2).uint32_follow_status.set(k, true);
          ((ArticleInfo)localArrayList.get(i)).mPackInfoBytes = ((articlesummary.PackInfo)localObject2).toByteArray();
          localObject2 = ((ArticleInfo)localArrayList.get(i)).clone();
          if (((ConcurrentHashMap)localObject1).get(Long.valueOf(((ArticleInfo)localObject2).mRecommendSeq)) != null)
          {
            a(Integer.valueOf(j), (ArticleInfo)localObject2);
            if (QLog.isColorLevel()) {
              QLog.e("ArticleInfoModule", 2, "recordArticleInfo, article duplicated, article been channelID=" + j + ", articleID=" + ((ArticleInfo)localObject2).mArticleID + "，seq=" + ((ArticleInfo)localObject2).mRecommendSeq);
            }
          }
          localObject1 = (ArticleInfo)((ConcurrentHashMap)localObject1).get(Long.valueOf(((ArticleInfo)localObject2).mRecommendSeq));
          if (localObject1 != null)
          {
            if ((((ArticleInfo)localObject1).mTopicRecommendFeedsInfo != null) && (((ArticleInfo)localObject1).mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null) && (((ArticleInfo)localObject1).mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
              ((rik)((ArticleInfo)localObject1).mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Int = paramInt2;
            }
            if (((ArticleInfo)localObject1).mPolymericInfo != null)
            {
              j = paramInt2 + 1;
              ((ArticleInfo)localObject1).mPolymericInfo.jdField_e_of_type_Int = j;
              localPackInfo = new articlesummary.PackInfo();
            }
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
        {
          try
          {
            articlesummary.PackInfo localPackInfo;
            localPackInfo.mergeFrom(((ArticleInfo)localObject1).mPackInfoBytes);
            localPackInfo.uint32_follow_status.set(j, true);
            ((ArticleInfo)localObject1).mPackInfoBytes = localPackInfo.toByteArray();
            ((ArticleInfo)localObject1).invalidateProteusTemplateBean();
            this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ArticleInfoModule.44(this, (ArticleInfo)localObject2));
            i += 1;
            break;
            localInvalidProtocolBufferMicroException1 = localInvalidProtocolBufferMicroException1;
            QLog.e("ArticleInfoModule", 1, "first setSmallVideoTopicFollowTypeIntoDB article.mPackInfoBytes convert error article.topicID:" + paramInt1 + " e = " + localInvalidProtocolBufferMicroException1);
            localInvalidProtocolBufferMicroException1.printStackTrace();
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
          {
            for (;;)
            {
              QLog.e("ArticleInfoModule", 1, "first setSmallVideoTopicFollowTypeIntoDB article.mPackInfoBytes convert error article.topicID:" + paramInt1 + " e = " + localInvalidProtocolBufferMicroException2);
              localInvalidProtocolBufferMicroException2.printStackTrace();
            }
          }
        }
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new ArticleInfoModule.45(this, paramInt1, paramInt2));
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown())) {
      return;
    }
    List localList1 = a(Integer.valueOf(paramInt1));
    List localList2 = pmh.a().a(Integer.valueOf(paramInt1), localList1);
    if ((localList1 != null) && (localList1.size() > 0))
    {
      qqk.a().a(paramInt1, localList1);
      qof.a(localList2);
      if ((Looper.myLooper() == Looper.getMainLooper()) && (pha.n()))
      {
        pmk.a().a(paramInt1, localList1);
        return;
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.post(new ArticleInfoModule.14(this, paramInt1, localList1));
        return;
      }
    }
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ArticleInfoModule.15(this, paramInt1, localList1, paramInt2, paramLong, paramBoolean));
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      QLog.d("ArticleInfoModule", 1, "loadChannelArticle Exception.");
      localRejectedExecutionException.printStackTrace();
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown()))
    {
      QLog.i("ArticleInfoModule", 1, "[loadFeedsFromDB], mExecutorService is null or shutDown.");
      return;
    }
    List localList = a(Integer.valueOf(paramInt1));
    if ((localList != null) && (localList.size() > 0))
    {
      qqk.a().a(paramInt1, localList);
      if ((Looper.myLooper() == Looper.getMainLooper()) && (pha.n()))
      {
        qnm.a().a(paramInt1, localList, paramLong2);
        return;
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.post(new ArticleInfoModule.17(this, paramInt1, localList, paramLong2));
        return;
      }
    }
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ArticleInfoModule.18(this, paramInt1, localList, paramInt2, paramLong1, paramBoolean, paramLong2));
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      QLog.e("ArticleInfoModule", 1, "[loadFeedsFromDB], e = " + localRejectedExecutionException);
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ArticleInfoModule", 2, "deleteChannelArticle channelId=" + paramInt + "recommendSeq=" + paramLong);
    }
    if ((paramLong == -2L) || (paramLong == -3L)) {
      if (QLog.isColorLevel()) {
        QLog.e("ArticleInfoModule", 2, "deleteChannelArticle recommendSeq is TOPIC/SUBSCRIBE recommendSeq");
      }
    }
    ConcurrentHashMap localConcurrentHashMap;
    ArticleInfo localArticleInfo;
    do
    {
      do
      {
        return;
        localConcurrentHashMap = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt));
      } while (localConcurrentHashMap == null);
      localArticleInfo = (ArticleInfo)localConcurrentHashMap.get(Long.valueOf(paramLong));
      if (localArticleInfo != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ArticleInfoModule", 2, "deleteChannelArticle connot find channelId=" + paramInt + "ArticleInfo with recommendSeq=" + paramLong);
    return;
    a(Integer.valueOf(paramInt), localArticleInfo);
    localConcurrentHashMap.remove(Long.valueOf(paramLong));
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ArticleInfoModule.25(this, localArticleInfo));
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2)
  {
    Object localObject2 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1));
    if (localObject2 == null) {
      return;
    }
    Object localObject1 = new ArrayList(((ConcurrentHashMap)localObject2).size());
    Iterator localIterator = ((ConcurrentHashMap)localObject2).values().iterator();
    ArticleInfo localArticleInfo;
    while (localIterator.hasNext())
    {
      localArticleInfo = (ArticleInfo)localIterator.next();
      if (localArticleInfo.mRecommendTime < paramLong) {
        ((ArrayList)localObject1).add(localArticleInfo);
      }
    }
    int j = ((ConcurrentHashMap)localObject2).size() - ((ArrayList)localObject1).size();
    if (j < paramInt2)
    {
      Collections.sort((List)localObject1, new pwc(this));
      int i = 0;
      for (;;)
      {
        if (i >= paramInt2 - j) {
          break label161;
        }
        if (((ArrayList)localObject1).size() <= 0) {
          break;
        }
        ((ArrayList)localObject1).remove(0);
        i += 1;
      }
    }
    label161:
    localIterator = ((ArrayList)localObject1).iterator();
    while (localIterator.hasNext())
    {
      localArticleInfo = (ArticleInfo)localIterator.next();
      ((ConcurrentHashMap)localObject2).remove(Long.valueOf(localArticleInfo.mRecommendSeq));
      a(Integer.valueOf(paramInt1), localArticleInfo);
    }
    localObject2 = a(Integer.valueOf(paramInt1));
    this.jdField_a_of_type_AndroidOsHandler.post(new ArticleInfoModule.13(this, paramInt1, (List)localObject2));
    localObject1 = new StringBuilder().append("delete outdated article cache , cnt ").append(((ArrayList)localObject1).size()).append(", reservedCnt : ");
    if (j < paramInt2) {}
    for (;;)
    {
      QLog.d("ArticleInfoModule", 2, paramInt2);
      return;
      paramInt2 = j;
    }
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt));
    if (localConcurrentHashMap == null)
    {
      localConcurrentHashMap = new ConcurrentHashMap();
      this.jdField_c_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(paramInt), localConcurrentHashMap);
    }
    for (;;)
    {
      ArticleExposureInfo localArticleExposureInfo2;
      if ((paramBaseArticleInfo != null) && (!TextUtils.isEmpty(paramBaseArticleInfo.innerUniqueID)))
      {
        if (!localConcurrentHashMap.containsKey(paramBaseArticleInfo.innerUniqueID)) {
          break label133;
        }
        localArticleExposureInfo2 = (ArticleExposureInfo)localConcurrentHashMap.get(paramBaseArticleInfo.innerUniqueID);
        localArticleExposureInfo1 = localArticleExposureInfo2;
        if (localArticleExposureInfo2 != null) {
          localArticleExposureInfo2.exposureTime = NetConnInfoCenter.getServerTimeMillis();
        }
      }
      label133:
      for (ArticleExposureInfo localArticleExposureInfo1 = localArticleExposureInfo2;; localArticleExposureInfo1 = ArticleExposureInfo.createExposureInfoFromArticle(paramBaseArticleInfo))
      {
        if (localArticleExposureInfo1 != null)
        {
          localConcurrentHashMap.put(paramBaseArticleInfo.innerUniqueID, localArticleExposureInfo1);
          ThreadManager.getSubThreadHandler().post(new ArticleInfoModule.54(this, localArticleExposureInfo1));
        }
        return;
      }
    }
  }
  
  public void a(int paramInt, List<ArticleInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    Object localObject1;
    do
    {
      return;
      if (QLog.isColorLevel())
      {
        QLog.d("ArticleInfoModule", 2, "deleteChannelArticleList channelID = " + paramInt + " articleList");
        localObject1 = paramList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ArticleInfo)((Iterator)localObject1).next();
          QLog.d("ArticleInfoModule", 2, "articleInfo.mArticleID = " + ((ArticleInfo)localObject2).mArticleID);
        }
      }
      localObject1 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt));
    } while (localObject1 == null);
    Object localObject2 = new StringBuilder();
    Iterator localIterator1 = paramList.iterator();
    label148:
    ArticleInfo localArticleInfo;
    if (localIterator1.hasNext())
    {
      localArticleInfo = (ArticleInfo)localIterator1.next();
      Iterator localIterator2 = ((ConcurrentHashMap)localObject1).entrySet().iterator();
      paramList = null;
      for (;;)
      {
        if (localIterator2.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator2.next();
          if (((ArticleInfo)localEntry.getValue()).mNewPolymericInfo != null)
          {
            Iterator localIterator3 = ((ArticleInfo)localEntry.getValue()).mNewPolymericInfo.jdField_a_of_type_JavaUtilList.iterator();
            rfw localrfw;
            do
            {
              if (!localIterator3.hasNext()) {
                break;
              }
              localrfw = (rfw)localIterator3.next();
            } while (localrfw.jdField_a_of_type_Long != localArticleInfo.mArticleID);
            paramList = (ArticleInfo)localEntry.getValue();
            paramList.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.remove(localrfw);
          }
          else
          {
            label306:
            if (((ArticleInfo)localEntry.getValue()).mArticleID == localArticleInfo.mArticleID) {
              paramList = (ArticleInfo)localEntry.getValue();
            }
          }
        }
      }
    }
    for (;;)
    {
      if (paramList == null)
      {
        if (!QLog.isColorLevel()) {
          break label148;
        }
        ((StringBuilder)localObject2).append("deleteChannelArticleList connot find channelId=" + paramInt + " ArticleInfo with recommendSeq=" + localArticleInfo.mRecommendSeq + " with articleID=" + localArticleInfo.mArticleID + '\n');
        break label148;
      }
      if ((paramList.mNewPolymericInfo != null) && (((pha.m(paramList)) && (paramList.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.size() >= 3)) || ((!pha.m(paramList)) && (paramList.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.size() >= 2))))
      {
        paramList.mNewPackInfoBytes = paramList.mNewPolymericInfo.a();
        b(Integer.valueOf(paramInt), paramList);
        ((ConcurrentHashMap)localObject1).put(Long.valueOf(paramList.mRecommendSeq), paramList);
        this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ArticleInfoModule.23(this, paramList));
        break label148;
      }
      a(Integer.valueOf(paramInt), paramList);
      ((ConcurrentHashMap)localObject1).remove(Long.valueOf(paramList.mRecommendSeq));
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ArticleInfoModule.24(this, paramList));
      break label148;
      if (((StringBuilder)localObject2).length() <= 0) {
        break;
      }
      QLog.e("ArticleInfoModule", 2, ((StringBuilder)localObject2).toString());
      return;
      break label306;
    }
  }
  
  public void a(long paramLong)
  {
    oidb_cmd0xb83.ReqRecommendTagInfo localReqRecommendTagInfo = new oidb_cmd0xb83.ReqRecommendTagInfo();
    localReqRecommendTagInfo.uint64_topic_id.set(paramLong);
    oidb_cmd0xb83.ReqBody localReqBody = new oidb_cmd0xb83.ReqBody();
    localReqBody.msg_req_recommend_tag_info.set(localReqRecommendTagInfo);
    a(qnf.a("OidbSvc.0xb83", 2947, 0, localReqBody.toByteArray()));
  }
  
  public void a(long paramLong, int paramInt)
  {
    oidb_cmd0x75e.ReqBody localReqBody = new oidb_cmd0x75e.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    localReqBody.uint32_network_type.set(b());
    oidb_cmd0x75e.ReqPara localReqPara = new oidb_cmd0x75e.ReqPara();
    localReqPara.enum_op_type.set(paramInt);
    localReqBody.msg_req_para.set(localReqPara);
    a(qnf.a("OidbSvc.0x75e", 1886, 0, localReqBody.toByteArray()));
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    QLog.d("ArticleInfoModule", 1, " request0xc32GetPrivacyList | feedsid " + paramLong + " | startIndex " + paramInt1);
    oidb_cmd0xc32.ReqBody localReqBody = new oidb_cmd0xc32.ReqBody();
    localReqBody.enum_op.set(2);
    oidb_cmd0xc32.GetVisibleListReqBody localGetVisibleListReqBody = new oidb_cmd0xc32.GetVisibleListReqBody();
    localGetVisibleListReqBody.uint64_feeds_id.set(paramLong);
    localGetVisibleListReqBody.uint32_start_ix.set(paramInt1);
    localGetVisibleListReqBody.uint32_want_num.set(paramInt2);
    localReqBody.msg_get_req_body.set(localGetVisibleListReqBody);
    a(qnf.a("OidbSvc.0xc32", 3122, 2, localReqBody.toByteArray()));
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, HashMap<Long, Long> paramHashMap, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    oidb_cmd0x68b.ReqBody localReqBody = new oidb_cmd0x68b.ReqBody();
    long l1 = Long.valueOf(pha.a()).longValue();
    localReqBody.uint64_uin.set(l1);
    localReqBody.uint32_network_type.set(b());
    long l2 = pgs.a();
    l1 = 768L;
    if (pgs.b(l2))
    {
      l1 = 0x300 | 0x4000;
      QLog.d("ArticleInfoModule", 1, new Object[] { "request0x68bFollowList addCompressFlag, optimizeID = ", Long.valueOf(l2) });
    }
    localReqBody.uint64_client_swithes.set(l1);
    oidb_cmd0x68b.ReqGetFollowTabPara localReqGetFollowTabPara = new oidb_cmd0x68b.ReqGetFollowTabPara();
    localReqGetFollowTabPara.uint64_channel_id.set(70L);
    localReqGetFollowTabPara.uint64_begin_recommend_seq.set(paramLong1);
    localReqGetFollowTabPara.uint64_end_recommend_seq.set(paramLong2);
    if (paramHashMap != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("topic update exp time ");
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramHashMap.next();
        oidb_cmd0x68b.ExposeTopic localExposeTopic = new oidb_cmd0x68b.ExposeTopic();
        localExposeTopic.uint32_business_id.set(((Long)localEntry.getKey()).intValue());
        localExposeTopic.uint32_expose_time.set((int)(((Long)localEntry.getValue()).longValue() / 1000L));
        localReqGetFollowTabPara.rpt_expose_topic_list.add(localExposeTopic);
        if (QLog.isColorLevel())
        {
          localStringBuilder.append(((Long)localEntry.getKey()).intValue());
          localStringBuilder.append(" ");
          localStringBuilder.append(((Long)localEntry.getValue()).longValue() / 1000L);
          localStringBuilder.append(" ");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ArticleInfoModule", 2, localStringBuilder.toString());
      }
    }
    localReqBody.msg_get_follow_tab_feeds_para.set(localReqGetFollowTabPara);
    paramHashMap = a(Integer.valueOf(70));
    if ((paramHashMap != null) && (paramLong1 != 0L))
    {
      localReqBody.msg_get_follow_tab_feeds_para.bytes_set_top_cookie.set(ByteStringMicro.copyFrom(paramHashMap));
      if (QLog.isColorLevel()) {
        QLog.d("ArticleInfoModule", 1, "request0x68bFollowList: cookie: " + new String(paramHashMap));
      }
    }
    if (!TextUtils.isEmpty(paramString1)) {
      localReqBody.msg_get_follow_tab_feeds_para.bytes_red_dot_cookie.set(ByteStringMicro.copyFromUtf8(paramString1));
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localReqBody.msg_get_follow_tab_feeds_para.bytes_refresh_cookie.set(ByteStringMicro.copyFrom(bgku.decode(paramString2, 0)));
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localReqBody.msg_get_follow_tab_feeds_para.bytes_last_feed_cookie.set(ByteStringMicro.copyFromUtf8(paramString3));
    }
    localReqBody.msg_get_follow_tab_feeds_para.uint32_update_times.set(paramInt1);
    localReqBody.msg_get_follow_tab_feeds_para.uint32_enter_topic_reddot_time.set(paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d("ArticleInfoModule", 1, "request0x68bFollowList: beginRecommendSeq : " + paramLong1 + ", endRecommendSeq : " + paramLong2 + ", upDate_times : " + paramInt1 + ", reddotCookie : " + paramString1 + ", lastRefreshCookie : " + paramString2 + ", lastFeedsCookie : " + paramString3);
    }
    paramHashMap = qnf.a("OidbSvc.0x68b", 1675, 0, localReqBody.toByteArray());
    paramHashMap.getAttributes().put(jdField_c_of_type_JavaLangString, Integer.valueOf(5));
    l1 = paramLong1;
    if (paramLong1 == 0L) {
      l1 = -1L;
    }
    paramLong1 = paramLong2;
    if (paramLong2 == 0L) {
      paramLong1 = -1L;
    }
    paramHashMap.getAttributes().put(jdField_d_of_type_JavaLangString, Long.valueOf(l1));
    paramHashMap.getAttributes().put(jdField_e_of_type_JavaLangString, Long.valueOf(paramLong1));
    paramHashMap.getAttributes().put("isSingleHighLight", Boolean.valueOf(false));
    paramHashMap.getAttributes().put(jdField_f_of_type_JavaLangString, Integer.valueOf(1));
    paramHashMap.getAttributes().put(jdField_b_of_type_JavaLangString, Integer.valueOf(0));
    paramHashMap.getAttributes().put("channelID", Integer.valueOf(70));
    a(localReqBody, paramHashMap, l2);
    pgs.a(paramHashMap, l2);
    a(paramHashMap);
    jdField_c_of_type_Boolean = true;
    tth.a().a(paramHashMap);
  }
  
  public void a(long paramLong1, long paramLong2, rgy paramrgy, long paramLong3, String paramString1, long paramLong4, long paramLong5, int paramInt1, String paramString2, int paramInt2, ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    QLog.d("ArticleInfoModule", 1, "start request0x83eDeliverAction");
    oidb_cmd0x83e.ReqBody localReqBody = new oidb_cmd0x83e.ReqBody();
    localReqBody.uint64_uin.set(paramLong1);
    localReqBody.uint64_feeds_id.set(paramLong2);
    localReqBody.uint32_operation.set(4);
    oidb_cmd0x83e.SocializeFeedsInfo localSocializeFeedsInfo = new oidb_cmd0x83e.SocializeFeedsInfo();
    localSocializeFeedsInfo.uint64_feeds_id.set(paramLong2);
    localSocializeFeedsInfo.uint64_article_id.set(paramLong4);
    feeds_info.SocializeFeedsInfoUser localSocializeFeedsInfoUser = new feeds_info.SocializeFeedsInfoUser();
    localSocializeFeedsInfoUser.uint64_uin.set(paramLong3);
    Object localObject = ByteStringMicro.copyFromUtf8(paramString1);
    localSocializeFeedsInfo.bytes_comments.set((ByteStringMicro)localObject);
    b(paramArticleInfo, localSocializeFeedsInfo);
    a(paramArticleInfo, localSocializeFeedsInfo);
    localObject = a(paramrgy, (ByteStringMicro)localObject);
    localSocializeFeedsInfo.msg_biu_mutli_level.set((MessageMicro)localObject);
    localSocializeFeedsInfo.msg_master_uin.set(localSocializeFeedsInfoUser);
    QLog.d("ArticleInfoModule", 1, "request0x83eDeliver feedID=" + paramLong2 + ", feeds_type=" + paramInt2 + ", articleId=" + paramLong4 + ", masterUin=" + paramLong3 + ", comment=" + paramString1 + ",mOriFeedId=" + paramrgy.jdField_a_of_type_JavaLangLong + ",mOriFeedType" + paramrgy.jdField_b_of_type_JavaLangLong + ",bussinessId = " + paramArticleInfo.businessId);
    if (paramArticleInfo.mSocialFeedInfo != null)
    {
      c(paramArticleInfo, localSocializeFeedsInfo);
      d(paramArticleInfo, localSocializeFeedsInfo);
      e(paramArticleInfo, localSocializeFeedsInfo);
    }
    paramrgy = a(paramArticleInfo, paramInt2, localSocializeFeedsInfo);
    QLog.d("ArticleInfoModule", 1, "request0x83eDeliver enum_biu_src=" + paramInt1);
    localReqBody.enum_biu_src.set(paramInt1);
    if (((paramInt1 == 17) || (paramInt1 == 2)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = ByteStringMicro.copyFromUtf8(paramString2);
      localReqBody.bytes_inner_uniq_id.set(paramString1);
      QLog.d("ArticleInfoModule", 1, "request0x83eDeliver innerUniqueIDc=" + paramString2);
    }
    localReqBody.msg_feeds_info.set(paramrgy);
    paramrgy = localReqBody.uint32_is_one_touch_biu;
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramrgy.set(paramInt1);
      paramrgy = String.valueOf(pha.a()) + System.currentTimeMillis();
      localReqBody.bytes_req_seq.set(ByteStringMicro.copyFromUtf8(paramrgy));
      paramrgy = qnf.a("OidbSvc.0x83e", 2110, 0, localReqBody.toByteArray());
      paramrgy.addAttribute("biu_deliver", Integer.valueOf(1));
      paramrgy.addAttribute("BaseArticleSeq", Long.valueOf(paramLong5));
      b(paramrgy);
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2, rgy paramrgy, String paramString)
  {
    cmd0xc5b.ReqBody localReqBody = new cmd0xc5b.ReqBody();
    localReqBody.uint64_feeds_id.set(paramLong2);
    feeds_info.BiuMultiLevel localBiuMultiLevel = new feeds_info.BiuMultiLevel();
    if (paramrgy.jdField_a_of_type_JavaLangLong != null) {
      localBiuMultiLevel.uint64_origin_feeds_id.set(paramrgy.jdField_a_of_type_JavaLangLong.longValue());
    }
    if (paramrgy.jdField_b_of_type_JavaLangLong != null) {
      localBiuMultiLevel.uint64_origin_feeds_type.set(paramrgy.jdField_b_of_type_JavaLangLong.longValue());
    }
    paramrgy = paramrgy.jdField_a_of_type_JavaUtilList.iterator();
    while (paramrgy.hasNext())
    {
      SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)paramrgy.next();
      feeds_info.BiuOneLevelItem localBiuOneLevelItem = new feeds_info.BiuOneLevelItem();
      ByteStringMicro localByteStringMicro = ByteStringMicro.copyFromUtf8(localBiuCommentInfo.jdField_a_of_type_JavaLangString);
      localBiuOneLevelItem.bytes_biu_comments.set(localByteStringMicro);
      localBiuOneLevelItem.uint32_biu_time.set(localBiuCommentInfo.jdField_a_of_type_Int);
      localBiuOneLevelItem.uint64_feeds_id.set(localBiuCommentInfo.jdField_b_of_type_JavaLangLong.longValue());
      localBiuOneLevelItem.uint64_uin.set(localBiuCommentInfo.jdField_a_of_type_JavaLangLong.longValue());
      localBiuOneLevelItem.feeds_type.set(localBiuCommentInfo.jdField_b_of_type_Int);
      localBiuOneLevelItem.op_type.set(localBiuCommentInfo.jdField_c_of_type_Int);
      if (localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo != null)
      {
        localBiuOneLevelItem.msg_jump_info.set(new feeds_info.JumpInfo());
        localBiuOneLevelItem.msg_jump_info.uint64_id.set(localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo.a());
        localBiuOneLevelItem.msg_jump_info.bytes_wording.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo.a()));
        localBiuOneLevelItem.msg_jump_info.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo.b()));
      }
      if (localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo != null)
      {
        localBiuOneLevelItem.msg_voice_info.set(new feeds_info.UGCVoiceInfo());
        localBiuOneLevelItem.msg_voice_info.bytes_voice_url.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo.jdField_a_of_type_JavaLangString));
        localBiuOneLevelItem.msg_voice_info.uint32_duration.set(localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo.jdField_a_of_type_Int);
        localBiuOneLevelItem.msg_voice_info.uint32_file_size.set(localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo.jdField_b_of_type_Int);
      }
      localBiuMultiLevel.rpt_biu_mutli_level.add(localBiuOneLevelItem);
    }
    paramrgy = new feeds_info.BiuOneLevelItem();
    paramrgy.bytes_biu_comments.set(ByteStringMicro.copyFromUtf8(paramString));
    paramrgy.op_type.set(0);
    paramrgy.feeds_type.set(1);
    paramrgy.uint64_feeds_id.set(paramLong2);
    paramrgy.uint64_uin.set(paramLong1);
    localBiuMultiLevel.rpt_biu_mutli_level.add(paramrgy);
    paramrgy = new feeds_info.FeedsInfo();
    paramString = new feeds_info.SocializeFeedsInfo();
    paramString.msg_biu_mutli_level.set(localBiuMultiLevel);
    paramString.msg_biu_mutli_level.set(localBiuMultiLevel);
    paramrgy.msg_social_feeds_info.set(paramString);
    localReqBody.msg_feeds_info.set(paramrgy);
    b(qnf.a("OidbSvc.0xc5b_2", 3163, 2, localReqBody.toByteArray()));
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean, ArticleInfo paramArticleInfo)
  {
    Object localObject1 = new oidb_cmd0x83e.ReqBody();
    if (paramBoolean) {}
    for (int i = 2;; i = 3)
    {
      if (paramLong1 != -1L) {
        ((oidb_cmd0x83e.ReqBody)localObject1).uint64_uin.set(paramLong1);
      }
      if (paramLong2 != -1L) {
        ((oidb_cmd0x83e.ReqBody)localObject1).uint64_feeds_id.set(paramLong2);
      }
      ((oidb_cmd0x83e.ReqBody)localObject1).uint32_operation.set(i);
      Object localObject2 = new oidb_cmd0x83e.FeedsInfo();
      ((oidb_cmd0x83e.FeedsInfo)localObject2).feeds_type.set(paramArticleInfo.busiType);
      ((oidb_cmd0x83e.FeedsInfo)localObject2).uint32_business_id.set((int)paramArticleInfo.businessId);
      ((oidb_cmd0x83e.ReqBody)localObject1).msg_feeds_info.set((MessageMicro)localObject2);
      localObject2 = String.valueOf(pha.a()) + System.currentTimeMillis();
      ((oidb_cmd0x83e.ReqBody)localObject1).bytes_req_seq.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      localObject1 = qnf.a("OidbSvc.0x83e", 2110, 0, ((oidb_cmd0x83e.ReqBody)localObject1).toByteArray());
      ((ToServiceMsg)localObject1).addAttribute("0x83e_article", paramArticleInfo);
      ((ToServiceMsg)localObject1).addAttribute("0x83e_upvote_operation_type", Integer.valueOf(i));
      b((ToServiceMsg)localObject1);
      return;
    }
  }
  
  public void a(long paramLong, String paramString1, int paramInt, String paramString2, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean)
  {
    QLog.d("ArticleInfoModule", 1, "start request0x83eDeliverAtlasAction");
    oidb_cmd0x83e.ReqBody localReqBody = new oidb_cmd0x83e.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    localReqBody.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(paramString1));
    localReqBody.enum_biu_src.set(paramInt);
    localReqBody.uint32_operation.set(4);
    localReqBody.bytes_comment.set(ByteStringMicro.copyFromUtf8(""));
    oidb_cmd0x83e.FeedsInfo localFeedsInfo = new oidb_cmd0x83e.FeedsInfo();
    oidb_cmd0x83e.SocializeFeedsInfo localSocializeFeedsInfo = new oidb_cmd0x83e.SocializeFeedsInfo();
    paramString1 = new feeds_info.SocializeFeedsInfoUser();
    paramString1.uint64_uin.set(paramLong);
    localSocializeFeedsInfo.msg_master_uin.set(paramString1);
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = "";
    }
    paramString1 = ByteStringMicro.copyFromUtf8(paramString1);
    localSocializeFeedsInfo.bytes_comments.set(paramString1);
    if (paramArrayList != null)
    {
      paramString2 = new rgy();
      paramInt = paramArrayList.size() - 1;
      while (paramInt > 0)
      {
        paramString2.jdField_a_of_type_JavaUtilList.add(paramArrayList.get(paramInt));
        paramInt -= 1;
      }
      paramString1 = new feeds_info.BiuMultiLevel();
      paramString2 = paramString2.jdField_a_of_type_JavaUtilList.iterator();
      while (paramString2.hasNext())
      {
        paramArrayList = (SocializeFeedsInfo.BiuCommentInfo)paramString2.next();
        feeds_info.BiuOneLevelItem localBiuOneLevelItem = new feeds_info.BiuOneLevelItem();
        ByteStringMicro localByteStringMicro = ByteStringMicro.copyFromUtf8(paramArrayList.jdField_a_of_type_JavaLangString);
        localBiuOneLevelItem.bytes_biu_comments.set(localByteStringMicro);
        localBiuOneLevelItem.uint32_biu_time.set(paramArrayList.jdField_a_of_type_Int);
        localBiuOneLevelItem.uint64_feeds_id.set(paramArrayList.jdField_b_of_type_JavaLangLong.longValue());
        localBiuOneLevelItem.uint64_uin.set(paramArrayList.jdField_a_of_type_JavaLangLong.longValue());
        localBiuOneLevelItem.feeds_type.set(paramArrayList.jdField_b_of_type_Int);
        localBiuOneLevelItem.op_type.set(paramArrayList.jdField_c_of_type_Int);
        if (paramArrayList.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo != null)
        {
          localBiuOneLevelItem.msg_jump_info.set(new feeds_info.JumpInfo());
          localBiuOneLevelItem.msg_jump_info.uint64_id.set(paramArrayList.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo.a());
          localBiuOneLevelItem.msg_jump_info.bytes_wording.set(ByteStringMicro.copyFromUtf8(paramArrayList.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo.a()));
          localBiuOneLevelItem.msg_jump_info.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(paramArrayList.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo.b()));
        }
        if (paramArrayList.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo != null)
        {
          localBiuOneLevelItem.msg_voice_info.set(new feeds_info.UGCVoiceInfo());
          localBiuOneLevelItem.msg_voice_info.bytes_voice_url.set(ByteStringMicro.copyFromUtf8(paramArrayList.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo.jdField_a_of_type_JavaLangString));
          localBiuOneLevelItem.msg_voice_info.uint32_duration.set(paramArrayList.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo.jdField_a_of_type_Int);
          localBiuOneLevelItem.msg_voice_info.uint32_file_size.set(paramArrayList.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo.jdField_b_of_type_Int);
        }
        paramString1.rpt_biu_mutli_level.add(localBiuOneLevelItem);
      }
      localSocializeFeedsInfo.msg_biu_mutli_level.set(paramString1);
    }
    localFeedsInfo.msg_social_feeds_info.set(localSocializeFeedsInfo);
    localReqBody.msg_feeds_info.set(localFeedsInfo);
    paramString1 = localReqBody.uint32_is_one_touch_biu;
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramString1.set(paramInt);
      paramString1 = qnf.a("OidbSvc.0x83e", 2110, 0, localReqBody.toByteArray());
      paramString1.addAttribute("biu_deliver", Integer.valueOf(2));
      a(paramString1);
      return;
    }
  }
  
  public void a(long paramLong, List<rfb> paramList)
  {
    oidb_cmd0x46f.ReqBody localReqBody = new oidb_cmd0x46f.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_cmd0x46f.DislikeParam localDislikeParam = a((rfb)paramList.next());
      localReqBody.rpt_param_list.add(localDislikeParam);
    }
    a(qnf.a("OidbSvc.0x46f", 1135, 0, localReqBody.toByteArray()));
  }
  
  public void a(long paramLong, boolean paramBoolean, FastWebArticleInfo paramFastWebArticleInfo)
  {
    oidb_cmd0x83e.ReqBody localReqBody = new oidb_cmd0x83e.ReqBody();
    int i;
    int j;
    label40:
    PBBytesField localPBBytesField;
    if (paramBoolean)
    {
      i = 12;
      localReqBody.uint64_uin.set(paramLong);
      localObject = localReqBody.uint32_operation;
      if (!paramBoolean) {
        break label145;
      }
      j = 2;
      ((PBUInt32Field)localObject).set(j);
      localPBBytesField = localReqBody.bytes_inner_uniq_id;
      if (paramFastWebArticleInfo == null) {
        break label151;
      }
    }
    label145:
    label151:
    for (Object localObject = paramFastWebArticleInfo.j;; localObject = "")
    {
      localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localObject = qnf.a("OidbSvc.0x83e", 2110, 0, localReqBody.toByteArray());
      ((ToServiceMsg)localObject).addAttribute("0x83e_fast_web_article_info", paramFastWebArticleInfo);
      ((ToServiceMsg)localObject).addAttribute("0x83e_upvote_fast_web_article", Integer.valueOf(1));
      ((ToServiceMsg)localObject).addAttribute("0x83e_upvote_operation_type", Integer.valueOf(i));
      a((ToServiceMsg)localObject);
      return;
      i = 13;
      break;
      j = 3;
      break label40;
    }
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (!paramArticleInfo.showBreathAnimation))
    {
      return;
      break label11;
      break label11;
      break label117;
    }
    label11:
    label222:
    for (;;)
    {
      if (this.jdField_a_of_type_JavaUtilLinkedHashMap != null)
      {
        Object localObject = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(0));
        if (localObject == null) {
          break;
        }
        if (((ConcurrentHashMap)localObject).containsKey(Long.valueOf(paramArticleInfo.mRecommendSeq)))
        {
          ((ArticleInfo)((ConcurrentHashMap)localObject).get(Long.valueOf(paramArticleInfo.mRecommendSeq))).showBreathAnimation = false;
          a(Integer.valueOf(0), paramArticleInfo, true, a(Long.valueOf(paramArticleInfo.mArticleID)));
          QLog.d("ArticleInfoModule", 2, "resetBiuBreathAnimationFlag | reset breathAnim for fastweb type");
        }
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label222;
          }
          localObject = ((ConcurrentHashMap)localObject).values().iterator();
          label117:
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          ArticleInfo localArticleInfo = (ArticleInfo)((Iterator)localObject).next();
          if ((localArticleInfo == null) || ((localArticleInfo.mArticleID != paramArticleInfo.mArticleID) && ((TextUtils.isEmpty(localArticleInfo.innerUniqueID)) || (!localArticleInfo.innerUniqueID.equalsIgnoreCase(paramArticleInfo.innerUniqueID))))) {
            break;
          }
          localArticleInfo.showBreathAnimation = false;
          a(Integer.valueOf(0), paramArticleInfo, true, a(Long.valueOf(paramArticleInfo.mArticleID)));
          QLog.d("ArticleInfoModule", 2, "resetBiuBreathAnimationFlag |  reset breathAnim for video or shortContent type");
          return;
        }
      }
    }
  }
  
  public void a(ArticleInfo paramArticleInfo, String paramString)
  {
    if ((paramArticleInfo == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.d("ArticleInfoModule", 2, "requestSubmitComment | commentJsonStr or articleinfo is null ");
      return;
    }
    Object localObject1 = "";
    try
    {
      str = new JSONObject(paramString).getString("comment");
    }
    catch (JSONException localJSONException2)
    {
      Object localObject3;
      label92:
      long l;
      break label92;
    }
    try
    {
      localObject3 = new String(bgku.decode(str, 0));
      localObject1 = localObject3;
      QLog.d("ArticleInfoModule", 2, "requestSubmitComment | commentVal " + (String)localObject3);
      localObject1 = localObject3;
    }
    catch (JSONException localJSONException1)
    {
      Object localObject2 = str;
      break label92;
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      QLog.d("ArticleInfoModule", 2, "requestSubmitComment | commentVal is empty");
      return;
    }
    localObject3 = new oidb_cmd0x83e.ReqBody();
    l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    ((oidb_cmd0x83e.ReqBody)localObject3).uint64_uin.set(l);
    ((oidb_cmd0x83e.ReqBody)localObject3).uint32_operation.set(0);
    ((oidb_cmd0x83e.ReqBody)localObject3).bytes_comment.set(ByteStringMicro.copyFromUtf8((String)localObject1));
    ((oidb_cmd0x83e.ReqBody)localObject3).uint32_op_new_comment_system.set(1);
    ((oidb_cmd0x83e.ReqBody)localObject3).uint64_feeds_id.set(paramArticleInfo.mFeedId);
    ((oidb_cmd0x83e.ReqBody)localObject3).bool_is_master.set(true);
    str = String.valueOf(pha.a()) + System.currentTimeMillis();
    ((oidb_cmd0x83e.ReqBody)localObject3).bytes_req_seq.set(ByteStringMicro.copyFromUtf8(str));
    QLog.d("ArticleInfoModule", 2, "requestSubmitComment | reqSeq is " + str + " | comment_content : " + (String)localObject1);
    localObject1 = qnf.a("OidbSvc.0x83e", 2110, 0, ((oidb_cmd0x83e.ReqBody)localObject3).toByteArray());
    ((ToServiceMsg)localObject1).addAttribute("submit_comment", Integer.valueOf(1));
    ((ToServiceMsg)localObject1).addAttribute("article_info", paramArticleInfo);
    ((ToServiceMsg)localObject1).addAttribute("comment_json_string", paramString);
    b((ToServiceMsg)localObject1);
  }
  
  public void a(ChannelTopCookie paramChannelTopCookie)
  {
    if (paramChannelTopCookie.mChannelID == 70)
    {
      if ((paramChannelTopCookie.mSetTopCookie == null) || (paramChannelTopCookie.mSetTopCookie.length <= 0)) {
        break label85;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ArticleInfoModule", 2, "save follow cookie is " + new String(paramChannelTopCookie.mSetTopCookie));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramChannelTopCookie.mChannelID), paramChannelTopCookie);
      return;
      label85:
      if (QLog.isColorLevel()) {
        QLog.d("ArticleInfoModule", 2, "save follow cookie is null");
      }
    }
  }
  
  public void a(TopicInfo paramTopicInfo)
  {
    oidb_cmd0xc16.ReqBody localReqBody = new oidb_cmd0xc16.ReqBody();
    Object localObject1 = "";
    if (paramTopicInfo != null)
    {
      long l = paramTopicInfo.b();
      localReqBody.uint64_uin.set(l);
      Object localObject2 = paramTopicInfo.a();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      Object localObject3 = paramTopicInfo.b();
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      String str = paramTopicInfo.d();
      localObject3 = str;
      if (str == null) {
        localObject3 = "";
      }
      str = paramTopicInfo.c();
      paramTopicInfo = str;
      if (str == null) {
        paramTopicInfo = "";
      }
      localReqBody.bytes_topic_title.set(ByteStringMicro.copyFromUtf8((String)localObject1));
      localReqBody.bytes_topic_desc.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      localReqBody.bytes_topic_pic_url.set(ByteStringMicro.copyFromUtf8((String)localObject3));
      localReqBody.bytes_topic_cover_pic_url.set(ByteStringMicro.copyFromUtf8(paramTopicInfo));
      localObject1 = "uin:" + l + "  title:" + (String)localObject1 + "  des:" + (String)localObject2 + " headUrl:" + (String)localObject3 + " coerUrl:" + paramTopicInfo;
    }
    QLog.d("ArticleInfoModule", 1, " request0xc16CreateTopic, " + (String)localObject1);
    a(qnf.a("OidbSvc.0xc16", 3094, 0, localReqBody.toByteArray()));
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x68b")) {
      f(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      do
      {
        return;
        if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x46f"))
        {
          h(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
      } while (paramFromServiceMsg.getServiceCmd().equals("PubAccountArticleCenter.ArticleLike"));
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x75e"))
      {
        i(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x83e"))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        if (paramToServiceMsg.getAttribute("biu_deliver", Integer.valueOf(0)).equals(Integer.valueOf(1)))
        {
          p(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (paramToServiceMsg.getAttribute("biu_deliver", Integer.valueOf(0)).equals(Integer.valueOf(2)))
        {
          m(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (paramToServiceMsg.getAttribute("ugc_deliver", Integer.valueOf(0)).equals(Integer.valueOf(1)))
        {
          n(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (paramToServiceMsg.getAttribute("up_master_deliver", Integer.valueOf(0)).equals(Integer.valueOf(1)))
        {
          o(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (paramToServiceMsg.getAttribute("submit_comment", Integer.valueOf(0)).equals(Integer.valueOf(1)))
        {
          j(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (paramToServiceMsg.getAttribute("0x83e_upvote_fast_web_article", Integer.valueOf(0)).equals(Integer.valueOf(1)))
        {
          c(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        l(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x8c8"))
      {
        q(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xb83"))
      {
        v(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbbd"))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbd4_1"))
      {
        t(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbde"))
      {
        w(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbd6_1"))
      {
        u(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbf7"))
      {
        QLog.d("ArticleInfoModule", 1, "onReceive 0xbf7");
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xc16"))
      {
        k(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xc32"))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xa6e"))
      {
        r(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xc6d"))
      {
        s(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xcba"))
      {
        QLog.d("ArticleInfoModule", 1, "onReceive 0xcba");
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xc5b_2"));
    g(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(Integer paramInteger, byte[] paramArrayOfByte)
  {
    ChannelTopCookie localChannelTopCookie2 = (ChannelTopCookie)this.jdField_a_of_type_JavaUtilMap.get(paramInteger);
    ChannelTopCookie localChannelTopCookie1;
    if (localChannelTopCookie2 == null)
    {
      localChannelTopCookie2 = new ChannelTopCookie();
      localChannelTopCookie2.mChannelID = paramInteger.intValue();
      localChannelTopCookie1 = localChannelTopCookie2;
      if (paramInteger.intValue() == 70)
      {
        localChannelTopCookie1 = localChannelTopCookie2;
        if (paramArrayOfByte != null)
        {
          localChannelTopCookie2.mSetTopCookie = paramArrayOfByte;
          localChannelTopCookie1 = localChannelTopCookie2;
        }
      }
    }
    for (;;)
    {
      a(localChannelTopCookie1);
      try
      {
        this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ArticleInfoModule.28(this, localChannelTopCookie1));
        return;
      }
      catch (Exception paramInteger)
      {
        paramInteger.printStackTrace();
      }
      localChannelTopCookie1 = localChannelTopCookie2;
      if (paramInteger.intValue() == 70)
      {
        localChannelTopCookie1 = localChannelTopCookie2;
        if (paramArrayOfByte != null)
        {
          localChannelTopCookie2.mSetTopCookie = paramArrayOfByte;
          localChannelTopCookie1 = localChannelTopCookie2;
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    oidb_cmd0xc6d.ReqBody localReqBody = new oidb_cmd0xc6d.ReqBody();
    if (!TextUtils.isEmpty(paramString)) {
      localReqBody.bytes_row_key.set(ByteStringMicro.copyFromUtf8(paramString));
    }
    for (;;)
    {
      b(qnf.a("OidbSvc.0xc6d", 3181, 1, localReqBody.toByteArray()));
      QLog.d("ArticleInfoModule", 1, "request0xc6dInteractiveAreaCards,rowKey=" + paramString);
      return;
      localReqBody.bytes_row_key.set(ByteStringMicro.copyFromUtf8(""));
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1, paramInt2, false);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isTerminated()) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown())) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ArticleInfoModule.37(this, paramString, paramInt1, paramInt2, paramBoolean));
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, TroopBarPOI paramTroopBarPOI, VisibleSetParam paramVisibleSetParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArticleInfoModule", 2, "requestDeliverUpMasterVideo uin=" + paramString1 + ", comment=" + paramString2 + ", bundle=" + paramBundle.toString());
    }
    oidb_cmd0x83e.ReqBody localReqBody = new oidb_cmd0x83e.ReqBody();
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString1);
      l1 = l2;
    }
    catch (Exception paramString1)
    {
      label77:
      oidb_cmd0x83e.FeedsInfo localFeedsInfo;
      int i;
      oidb_cmd0x83e.SocializeFeedsInfo localSocializeFeedsInfo;
      Object localObject;
      break label77;
    }
    localReqBody.uint64_uin.set(l1);
    localReqBody.uint32_operation.set(5);
    if (!TextUtils.isEmpty(paramString2))
    {
      localReqBody.bytes_comment.set(ByteStringMicro.copyFromUtf8(paramString2));
      localReqBody.bool_is_master.set(true);
      localFeedsInfo = new oidb_cmd0x83e.FeedsInfo();
      i = paramBundle.getInt("arg_ad_tag");
      if (i != 12) {
        break label460;
      }
      localFeedsInfo.feeds_type.set(4);
      label158:
      paramString1 = paramBundle.getString("arg_ugc_edit_cookie");
      if (TextUtils.isEmpty(paramString1)) {
        break label479;
      }
      localReqBody.bytes_extra_json_params.set(ByteStringMicro.copyFromUtf8(paramString1));
      label185:
      if (paramBoolean2) {
        localReqBody.enum_ugc_src.set(1);
      }
      localSocializeFeedsInfo = new oidb_cmd0x83e.SocializeFeedsInfo();
      paramString1 = new feeds_info.SocializeFeedsInfoUser();
      paramString1.uint64_uin.set(l1);
      paramString1.enum_uin_type.set(0);
      localSocializeFeedsInfo.msg_master_uin.set(paramString1);
      if (TextUtils.isEmpty(paramString2)) {
        break label496;
      }
      localSocializeFeedsInfo.bytes_comments.set(ByteStringMicro.copyFromUtf8(paramString2));
    }
    for (;;)
    {
      if (paramVisibleSetParam != null)
      {
        paramString1 = new feeds_info.VisibleSetParam();
        paramString1.uint32_visible_type.set(paramVisibleSetParam.a());
        paramString1.rpt_uint64_uin.addAll(paramVisibleSetParam.a());
        paramString2 = new feeds_info.VisibleInfo();
        paramString2.visible_param.set(paramString1);
        localSocializeFeedsInfo.visible_info.set(paramString2);
      }
      paramVisibleSetParam = new feeds_info.UGCFeedsInfo();
      paramString1 = paramBundle.getParcelableArrayList("arg_ugc_tag_list");
      if (paramString1 == null) {
        break label513;
      }
      paramString1 = paramString1.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (TagInfo)paramString1.next();
        localObject = new feeds_info.TagInfo();
        ((feeds_info.TagInfo)localObject).uint64_tag_id.set(paramString2.a());
        ((feeds_info.TagInfo)localObject).bytes_tag_name.set(ByteStringMicro.copyFromUtf8(paramString2.a()));
        ((feeds_info.TagInfo)localObject).double_tag_score.set(paramString2.a());
        ((feeds_info.TagInfo)localObject).uint64_channel.set(paramString2.b());
        paramVisibleSetParam.rpt_msg_tag_info_list.add((MessageMicro)localObject);
      }
      localReqBody.bytes_comment.set(ByteStringMicro.copyFromUtf8(""));
      break;
      label460:
      if (i != 13) {
        break label158;
      }
      localFeedsInfo.feeds_type.set(5);
      break label158;
      label479:
      localReqBody.bytes_extra_json_params.set(ByteStringMicro.copyFromUtf8(""));
      break label185;
      label496:
      localSocializeFeedsInfo.bytes_comments.set(ByteStringMicro.copyFromUtf8(""));
    }
    label513:
    if (paramArrayList != null)
    {
      paramString1 = new feeds_info.BiuMultiLevel();
      i = paramArrayList.size() - 1;
      for (;;)
      {
        if (i >= 0)
        {
          paramString2 = (SocializeFeedsInfo.BiuCommentInfo)paramArrayList.get(i);
          localObject = new feeds_info.BiuOneLevelItem();
          try
          {
            ((feeds_info.BiuOneLevelItem)localObject).uint64_uin.set(Long.valueOf(paramString2.jdField_a_of_type_JavaLangLong.longValue()).longValue());
            ((feeds_info.BiuOneLevelItem)localObject).bytes_biu_comments.set(ByteStringMicro.copyFromUtf8(paramString2.jdField_a_of_type_JavaLangString));
            ((feeds_info.BiuOneLevelItem)localObject).op_type.set(paramString2.jdField_c_of_type_Int);
            if (paramString2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo != null)
            {
              ((feeds_info.BiuOneLevelItem)localObject).msg_jump_info.set(new feeds_info.JumpInfo());
              ((feeds_info.BiuOneLevelItem)localObject).msg_jump_info.uint64_id.set(paramString2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo.a());
              ((feeds_info.BiuOneLevelItem)localObject).msg_jump_info.bytes_wording.set(ByteStringMicro.copyFromUtf8(paramString2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo.a()));
              ((feeds_info.BiuOneLevelItem)localObject).msg_jump_info.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(paramString2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo.b()));
            }
            if (paramString2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo != null)
            {
              ((feeds_info.BiuOneLevelItem)localObject).msg_voice_info.set(new feeds_info.UGCVoiceInfo());
              ((feeds_info.BiuOneLevelItem)localObject).msg_voice_info.bytes_voice_url.set(ByteStringMicro.copyFromUtf8(paramString2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo.jdField_a_of_type_JavaLangString));
              ((feeds_info.BiuOneLevelItem)localObject).msg_voice_info.uint32_duration.set(paramString2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo.jdField_a_of_type_Int);
              ((feeds_info.BiuOneLevelItem)localObject).msg_voice_info.uint32_file_size.set(paramString2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo.jdField_b_of_type_Int);
            }
            paramString1.rpt_biu_mutli_level.add((MessageMicro)localObject);
            i -= 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ((feeds_info.BiuOneLevelItem)localObject).uint64_uin.set(0L);
            }
          }
        }
      }
      paramVisibleSetParam.msg_at_multi_level.set(paramString1);
    }
    if (paramBoolean1) {
      paramVisibleSetParam.enum_ugc_feeds_src.set(1);
    }
    for (;;)
    {
      paramArrayList = new feeds_info.UGCVideoInfo();
      paramArrayList.bytes_pic_url.set(ByteStringMicro.copyFromUtf8(paramBundle.getString("arg_video_cover_url", "")));
      paramArrayList.bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(paramBundle.getString("arg_video_cover_md5", "")));
      paramArrayList.bytes_video_url.set(ByteStringMicro.copyFromUtf8(paramBundle.getString("arg_video_url", "")));
      paramString2 = paramBundle.getString("arg_video_md5", "");
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2))
      {
        paramString2 = paramBundle.getString("arg_video_url", "");
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = "12345";
        }
      }
      paramArrayList.bytes_video_md5.set(ByteStringMicro.copyFromUtf8(paramString1));
      paramArrayList.bytes_title.set(ByteStringMicro.copyFromUtf8(paramBundle.getString("arg_video_title", "")));
      paramArrayList.bytes_uuid.set(ByteStringMicro.copyFromUtf8(paramBundle.getString("arg_video_uuid", "")));
      paramArrayList.uint64_duration.set(paramBundle.getLong("arg_video_duration"));
      paramArrayList.uint32_pic_width.set(paramBundle.getInt("arg_video_cover_width"));
      paramArrayList.uint32_pic_height.set(paramBundle.getInt("arg_video_cover_height"));
      paramArrayList.uint32_video_width.set(paramBundle.getInt("arg_video_width"));
      paramArrayList.uint32_video_height.set(paramBundle.getInt("arg_video_height"));
      paramArrayList.bytes_video_format.set(ByteStringMicro.copyFromUtf8("mp4"));
      paramString1 = new ArrayList();
      paramString1.add(paramArrayList);
      paramVisibleSetParam.msg_ugc_video_info_list.set(paramString1);
      localSocializeFeedsInfo.msg_ugc_topic_feeds_info.set(paramVisibleSetParam);
      if (paramTroopBarPOI != null)
      {
        paramString1 = new feeds_info.LocationInfo();
        paramString1.bytes_name.set(ByteStringMicro.copyFromUtf8(paramTroopBarPOI.jdField_c_of_type_JavaLangString));
        paramString1.uint32_longitude.set(paramTroopBarPOI.jdField_a_of_type_Int);
        paramString1.uint32_latitude.set(paramTroopBarPOI.jdField_b_of_type_Int);
        localSocializeFeedsInfo.location_info.set(paramString1);
      }
      localFeedsInfo.msg_social_feeds_info.set(localSocializeFeedsInfo);
      localReqBody.msg_feeds_info.set(localFeedsInfo);
      paramString1 = String.valueOf(pha.a()) + System.currentTimeMillis();
      localReqBody.bytes_req_seq.set(ByteStringMicro.copyFromUtf8(paramString1));
      paramString1 = qnf.a("OidbSvc.0x83e", 2110, 0, localReqBody.toByteArray());
      paramString1.addAttribute("up_master_deliver", Integer.valueOf(1));
      paramString1.addAttribute("up_master_deliver_uuid", paramBundle.getString("up_master_deliver_uuid"));
      b(paramString1);
      return;
      paramVisibleSetParam.enum_ugc_feeds_src.set(0);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, List<Integer> paramList, String paramString4, String paramString5, String[] paramArrayOfString1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String[] paramArrayOfString2, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean, int paramInt1, int paramInt2, rgv paramrgv, TroopBarPOI paramTroopBarPOI, VisibleSetParam paramVisibleSetParam, int paramInt3)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("requestDeliverUGC uin=").append(paramString1).append(", topicId=").append(paramString2).append(", adtag=").append(paramInt1).append(", type=").append(paramList).append(", comment=").append(paramString4).append(", pic=, width=").append(paramArrayOfInt1).append(", height=").append(paramArrayOfInt2).append(", md5=").append(paramArrayOfString2).append(", isGif=is from dian dian = ").append(paramBoolean).append("location = ");
      if (paramTroopBarPOI == null) {
        break label734;
      }
      paramString2 = String.format("(name:%s,lat:%s,long:%s)", new Object[] { paramTroopBarPOI.jdField_c_of_type_JavaLangString, Integer.valueOf(paramTroopBarPOI.jdField_b_of_type_Int), Integer.valueOf(paramTroopBarPOI.jdField_a_of_type_Int) });
    }
    for (;;)
    {
      QLog.d("ArticleInfoModule", 2, paramString2 + "visibleSetParam: " + paramVisibleSetParam);
      paramString2 = new oidb_cmd0x83e.ReqBody();
      long l1 = 0L;
      try
      {
        long l2 = Long.parseLong(paramString1);
        l1 = l2;
      }
      catch (Exception paramString1)
      {
        label211:
        label248:
        int i;
        label266:
        label297:
        label475:
        feeds_info.BiuOneLevelItem localBiuOneLevelItem;
        label734:
        label757:
        int j;
        label773:
        label810:
        break label211;
      }
      paramString2.uint64_uin.set(l1);
      paramString2.uint32_operation.set(5);
      if (!TextUtils.isEmpty(paramString4))
      {
        paramString2.bytes_comment.set(ByteStringMicro.copyFromUtf8(paramString4));
        if (TextUtils.isEmpty(paramString3)) {
          break label757;
        }
        paramString2.bytes_extra_json_params.set(ByteStringMicro.copyFromUtf8(paramString3));
        paramString2.bool_is_master.set(true);
        paramString1 = new oidb_cmd0x83e.FeedsInfo();
        if (paramInt1 != 12) {
          break label773;
        }
        paramString1.feeds_type.set(4);
        if (paramBoolean) {
          paramString2.enum_ugc_src.set(1);
        }
        paramString3 = new oidb_cmd0x83e.SocializeFeedsInfo();
        localObject = new feeds_info.SocializeFeedsInfoUser();
        ((feeds_info.SocializeFeedsInfoUser)localObject).uint64_uin.set(l1);
        ((feeds_info.SocializeFeedsInfoUser)localObject).enum_uin_type.set(0);
        paramString3.msg_master_uin.set((MessageMicro)localObject);
        if (TextUtils.isEmpty(paramString4)) {
          break label810;
        }
        paramString3.bytes_comments.set(ByteStringMicro.copyFromUtf8(paramString4));
        if (paramVisibleSetParam != null)
        {
          paramString4 = new feeds_info.VisibleSetParam();
          paramString4.uint32_visible_type.set(paramVisibleSetParam.a());
          paramString4.rpt_uint64_uin.addAll(paramVisibleSetParam.a());
          paramVisibleSetParam = new feeds_info.VisibleInfo();
          paramVisibleSetParam.visible_param.set(paramString4);
          paramString3.visible_info.set(paramVisibleSetParam);
        }
        paramString4 = new feeds_info.UGCFeedsInfo();
        if (paramArrayList == null) {
          break label850;
        }
        paramVisibleSetParam = new feeds_info.BiuMultiLevel();
        i = paramArrayList.size() - 1;
        if (i < 0) {
          break label840;
        }
        localObject = (SocializeFeedsInfo.BiuCommentInfo)paramArrayList.get(i);
        localBiuOneLevelItem = new feeds_info.BiuOneLevelItem();
      }
      try
      {
        localBiuOneLevelItem.uint64_uin.set(((SocializeFeedsInfo.BiuCommentInfo)localObject).jdField_a_of_type_JavaLangLong.longValue());
        localBiuOneLevelItem.bytes_biu_comments.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.BiuCommentInfo)localObject).jdField_a_of_type_JavaLangString));
        localBiuOneLevelItem.op_type.set(((SocializeFeedsInfo.BiuCommentInfo)localObject).jdField_c_of_type_Int);
        if (((SocializeFeedsInfo.BiuCommentInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo != null)
        {
          localBiuOneLevelItem.msg_jump_info.set(new feeds_info.JumpInfo());
          localBiuOneLevelItem.msg_jump_info.uint64_id.set(((SocializeFeedsInfo.BiuCommentInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo.a());
          localBiuOneLevelItem.msg_jump_info.bytes_wording.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.BiuCommentInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo.a()));
          localBiuOneLevelItem.msg_jump_info.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.BiuCommentInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo.b()));
        }
        if (((SocializeFeedsInfo.BiuCommentInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo != null)
        {
          localBiuOneLevelItem.msg_voice_info.set(new feeds_info.UGCVoiceInfo());
          localBiuOneLevelItem.msg_voice_info.bytes_voice_url.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.BiuCommentInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo.jdField_a_of_type_JavaLangString));
          localBiuOneLevelItem.msg_voice_info.uint32_duration.set(((SocializeFeedsInfo.BiuCommentInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo.jdField_a_of_type_Int);
          localBiuOneLevelItem.msg_voice_info.uint32_file_size.set(((SocializeFeedsInfo.BiuCommentInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo.jdField_b_of_type_Int);
        }
        paramVisibleSetParam.rpt_biu_mutli_level.add(localBiuOneLevelItem);
        i -= 1;
        break label475;
        paramString2 = "null";
        continue;
        paramString2.bytes_comment.set(ByteStringMicro.copyFromUtf8(""));
        break label248;
        paramString2.bytes_extra_json_params.set(ByteStringMicro.copyFromUtf8(""));
        break label266;
        if (paramInt1 == 13)
        {
          paramString1.feeds_type.set(5);
          break label297;
        }
        if (paramInt1 != 21) {
          break label297;
        }
        paramString1.feeds_type.set(25);
        break label297;
        paramString3.bytes_comments.set(ByteStringMicro.copyFromUtf8(""));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localBiuOneLevelItem.uint64_uin.set(0L);
        }
      }
    }
    label840:
    paramString4.msg_at_multi_level.set(paramVisibleSetParam);
    label850:
    if (paramInt2 > 0)
    {
      paramArrayList = new ArrayList();
      i = 0;
      if (i < paramInt2)
      {
        paramVisibleSetParam = new feeds_info.UGCPicInfo();
        paramVisibleSetParam.uint32_pic_width.set(paramArrayOfInt1[i]);
        paramVisibleSetParam.uint32_pic_height.set(paramArrayOfInt2[i]);
        paramVisibleSetParam.bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(paramArrayOfString2[i]));
        paramVisibleSetParam.bytes_pic_url.set(ByteStringMicro.copyFromUtf8(paramArrayOfString1[i]));
        if (((Integer)paramList.get(i)).intValue() == 2) {
          paramVisibleSetParam.bytes_thumbnail_url.set(ByteStringMicro.copyFromUtf8(paramArrayOfString1[i]));
        }
        localObject = paramVisibleSetParam.is_animation;
        if (((Integer)paramList.get(i)).intValue() == 2)
        {
          j = 1;
          label1005:
          ((PBUInt32Field)localObject).set(j);
          localObject = paramVisibleSetParam.uint32_pic_type;
          if (((Integer)paramList.get(i)).intValue() != 2) {
            break label1084;
          }
        }
        for (j = 2;; j = 1)
        {
          ((PBUInt32Field)localObject).set(j);
          paramVisibleSetParam.bytes_pic_desc.set(ByteStringMicro.copyFromUtf8(paramString5));
          paramArrayList.add(paramVisibleSetParam);
          i += 1;
          break;
          j = 0;
          break label1005;
        }
      }
      paramString4.msg_ugc_pic_info_list.set(paramArrayList);
    }
    label1084:
    paramString4.uint32_ugc_feeds_type.set(paramInt3);
    if ((paramInt1 == 21) && (paramrgv != null))
    {
      paramList = new feeds_info.AccountProfile();
      paramList.bytes_desc.set(ByteStringMicro.copyFromUtf8(paramrgv.jdField_c_of_type_JavaLangString));
      paramList.bytes_nick.set(ByteStringMicro.copyFromUtf8(paramrgv.jdField_a_of_type_JavaLangString));
      paramList.bytes_profile_photo_url.set(ByteStringMicro.copyFromUtf8(paramrgv.jdField_b_of_type_JavaLangString));
      paramList.uint64_uin.set(paramrgv.jdField_a_of_type_Long);
      paramList.uint32_account_type.set(paramrgv.jdField_a_of_type_Int);
      paramString4.account_profile.set(paramList);
      paramString4.enum_ugc_feeds_src.set(6);
    }
    paramString3.msg_ugc_topic_feeds_info.set(paramString4);
    if (paramTroopBarPOI != null)
    {
      paramList = new feeds_info.LocationInfo();
      paramList.bytes_name.set(ByteStringMicro.copyFromUtf8(paramTroopBarPOI.jdField_c_of_type_JavaLangString));
      paramList.uint32_longitude.set(paramTroopBarPOI.jdField_a_of_type_Int);
      paramList.uint32_latitude.set(paramTroopBarPOI.jdField_b_of_type_Int);
      paramString3.location_info.set(paramList);
    }
    paramString1.msg_social_feeds_info.set(paramString3);
    paramString2.msg_feeds_info.set(paramString1);
    paramString1 = String.valueOf(pha.a()) + System.currentTimeMillis();
    paramString2.bytes_req_seq.set(ByteStringMicro.copyFromUtf8(paramString1));
    paramString1 = qnf.a("OidbSvc.0x83e", 2110, 0, paramString2.toByteArray());
    paramString1.addAttribute("ugc_deliver", Integer.valueOf(1));
    b(paramString1);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, List<Integer> paramList, String paramString4, String[] paramArrayOfString1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String[] paramArrayOfString2, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean, int paramInt1, int paramInt2, rgv paramrgv, int paramInt3)
  {
    a(paramString1, paramString2, paramString3, paramList, paramString4, "", paramArrayOfString1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfString2, paramArrayList, paramBoolean, paramInt1, paramInt2, paramrgv, null, VisibleSetParam.a, paramInt3);
  }
  
  public void a(ArrayList<ResultRecord> paramArrayList, int paramInt, long paramLong, String paramString)
  {
    if ((paramInt == 1) && (paramArrayList != null) && (paramString != null))
    {
      oidb_cmd0xbd4.ReqBody localReqBody = new oidb_cmd0xbd4.ReqBody();
      oidb_cmd0xbd4.InviteReq localInviteReq = new oidb_cmd0xbd4.InviteReq();
      localInviteReq.str_rowkey.set(paramString);
      try
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          paramString = (ResultRecord)paramArrayList.next();
          if (a(paramString.a()))
          {
            oidb_cmd0xbd4.Invitee localInvitee = new oidb_cmd0xbd4.Invitee();
            localInvitee.uint64_uin.set(Long.parseLong(paramString.a()));
            localInvitee.uint32_from.set(paramString.a());
            localInviteReq.rpt_msg_invitee.add(localInvitee);
          }
        }
        return;
      }
      catch (NumberFormatException paramArrayList)
      {
        QLog.e("ArticleInfoModule", 1, " e = " + paramArrayList);
        paramArrayList.printStackTrace();
        localReqBody.msg_invite_req.set(localInviteReq);
        a(qnf.a("OidbSvc.0xbd4_1", 3028, 1, localReqBody.toByteArray()));
      }
    }
  }
  
  public void a(List<ChannelTopCookie> paramList)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ArticleInfoModule.27(this, paramList));
  }
  
  /* Error */
  public void a(List<ArticleInfo> paramList, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 2249	pwb:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   4: invokevirtual 4071	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   7: invokevirtual 4076	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   10: aload_1
    //   11: invokeinterface 663 1 0
    //   16: astore_1
    //   17: aload_1
    //   18: invokeinterface 668 1 0
    //   23: ifeq +160 -> 183
    //   26: aload_1
    //   27: invokeinterface 671 1 0
    //   32: checkcast 161	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   35: astore_3
    //   36: aload_3
    //   37: getfield 2737	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mExtraBiuBriefInfo	Lrfd;
    //   40: ifnull -23 -> 17
    //   43: aload_3
    //   44: getfield 2737	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mExtraBiuBriefInfo	Lrfd;
    //   47: getfield 1486	rfd:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   50: ifnull -33 -> 17
    //   53: aload_3
    //   54: getfield 2737	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mExtraBiuBriefInfo	Lrfd;
    //   57: getfield 1486	rfd:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   60: invokevirtual 850	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   63: astore_3
    //   64: aload_3
    //   65: invokeinterface 668 1 0
    //   70: ifeq -53 -> 17
    //   73: aload_3
    //   74: invokeinterface 671 1 0
    //   79: checkcast 1488	rfe
    //   82: astore 4
    //   84: aload_0
    //   85: getfield 2249	pwb:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   88: ldc 161
    //   90: ldc_w 4078
    //   93: iconst_2
    //   94: anewarray 79	java/lang/String
    //   97: dup
    //   98: iconst_0
    //   99: iload_2
    //   100: invokestatic 233	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   103: aastore
    //   104: dup
    //   105: iconst_1
    //   106: aload 4
    //   108: getfield 1489	rfe:jdField_a_of_type_Long	J
    //   111: invokestatic 959	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   114: aastore
    //   115: invokevirtual 4082	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   118: astore 4
    //   120: aload 4
    //   122: ifnull -58 -> 64
    //   125: aload_0
    //   126: getfield 2249	pwb:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   129: aload 4
    //   131: invokevirtual 4084	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   134: pop
    //   135: goto -71 -> 64
    //   138: astore_1
    //   139: aload_1
    //   140: invokevirtual 3793	java/lang/Exception:printStackTrace	()V
    //   143: ldc 106
    //   145: iconst_2
    //   146: new 108	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   153: ldc_w 4086
    //   156: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_1
    //   160: invokevirtual 4089	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   163: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 2835	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aload_0
    //   173: getfield 2249	pwb:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   176: invokevirtual 4071	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   179: invokevirtual 4092	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   182: return
    //   183: aload_0
    //   184: getfield 2249	pwb:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   187: invokevirtual 4071	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   190: invokevirtual 4095	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   193: aload_0
    //   194: getfield 2249	pwb:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   197: invokevirtual 4071	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   200: invokevirtual 4092	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   203: return
    //   204: astore_1
    //   205: aload_0
    //   206: getfield 2249	pwb:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   209: invokevirtual 4071	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   212: invokevirtual 4092	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   215: aload_1
    //   216: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	pwb
    //   0	217	1	paramList	List<ArticleInfo>
    //   0	217	2	paramInt	int
    //   35	39	3	localObject1	Object
    //   82	48	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	17	138	java/lang/Exception
    //   17	64	138	java/lang/Exception
    //   64	120	138	java/lang/Exception
    //   125	135	138	java/lang/Exception
    //   183	193	138	java/lang/Exception
    //   0	17	204	finally
    //   17	64	204	finally
    //   64	120	204	finally
    //   125	135	204	finally
    //   139	172	204	finally
    //   183	193	204	finally
  }
  
  public void a(oul paramoul)
  {
    if (paramoul == null)
    {
      QLog.d("ArticleInfoModule", 2, "transformNewBiuCard | biuInfo is null!");
      return;
    }
    if (paramoul.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
    {
      QLog.d("ArticleInfoModule", 2, "transformNewBiuCard | originArticleInfo is null!");
      return;
    }
    boolean bool = paramoul.jdField_a_of_type_Boolean;
    if ((!paramoul.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilLinkedHashMap != null))
    {
      Object localObject = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(0));
      if (localObject != null)
      {
        if (((ConcurrentHashMap)localObject).containsKey(Long.valueOf(paramoul.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendSeq))) {
          bool = true;
        }
        if (!bool)
        {
          localObject = ((ConcurrentHashMap)localObject).values().iterator();
          while (((Iterator)localObject).hasNext())
          {
            ArticleInfo localArticleInfo = (ArticleInfo)((Iterator)localObject).next();
            if ((localArticleInfo != null) && ((localArticleInfo.mArticleID == paramoul.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID) || ((!TextUtils.isEmpty(localArticleInfo.innerUniqueID)) && (localArticleInfo.innerUniqueID.equalsIgnoreCase(paramoul.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID)))))
            {
              paramoul.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = localArticleInfo;
              bool = true;
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((paramoul != null) && (paramoul.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null))
      {
        paramoul.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.invalidateProteusTemplateBean();
        paramoul.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.showBreathAnimation = true;
      }
      QLog.d("ArticleInfoModule", 2, "transformNewBiuCard | fromRecommendFeeds:" + bool);
      if (bool) {
        if ((paramoul != null) && (ouj.a(paramoul.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
        {
          paramoul.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.commentSrc = paramoul.jdField_a_of_type_Int;
          b(paramoul);
        }
      }
      for (;;)
      {
        ouj.a().c();
        QLog.d("ArticleInfoModule", 2, "transformNewBiuCard | clearBiuInfo");
        return;
        QLog.d("ArticleInfoModule", 2, "transformNormalToNewBiuCard | invalid card type");
        continue;
        pmh.a().a(paramoul.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID, paramoul.jdField_a_of_type_Long, paramoul.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      }
    }
  }
  
  public void a(pwe parampwe)
  {
    this.jdField_a_of_type_Pwe = parampwe;
  }
  
  public void a(pwf parampwf)
  {
    this.jdField_a_of_type_Pwf = parampwf;
  }
  
  public void a(qni paramqni)
  {
    if (paramqni == null) {
      QLog.d("ArticleInfoModule", 2, "request0x68bChannelArticleList Request0x68bParams is null!");
    }
    long l1;
    do
    {
      return;
      l1 = System.currentTimeMillis();
    } while (a(paramqni, l1));
    if ((this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown()))
    {
      QLog.d("ArticleInfoModule", 2, "request0x68bChannelArticleList executorService has error !");
      return;
    }
    long l2 = qak.a(paramqni);
    jdField_c_of_type_Boolean = true;
    jdField_c_of_type_Int = paramqni.jdField_g_of_type_Int;
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ArticleInfoModule.1(this, paramqni, l1, l2));
  }
  
  public void a(rfd paramrfd, ArticleInfo paramArticleInfo)
  {
    Object localObject = new oidb_cmd0xbbd.ReqBody();
    long l = Long.valueOf(pha.a()).longValue();
    ((oidb_cmd0xbbd.ReqBody)localObject).uint64_uin.set(l);
    ((oidb_cmd0xbbd.ReqBody)localObject).uint32_network_type.set(b());
    oidb_cmd0xbbd.ReqPara localReqPara = new oidb_cmd0xbbd.ReqPara();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramrfd.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      rfe localrfe = (rfe)localIterator.next();
      oidb_cmd0xbbd.ReqFeedsInfo localReqFeedsInfo = new oidb_cmd0xbbd.ReqFeedsInfo();
      localReqFeedsInfo.uint64_feeds_id.set(localrfe.jdField_a_of_type_Long);
      localReqFeedsInfo.uint32_feeds_type.set(localrfe.jdField_a_of_type_Int);
      localArrayList.add(localReqFeedsInfo);
    }
    localReqPara.rpt_req_feeds_info.set(localArrayList);
    ((oidb_cmd0xbbd.ReqBody)localObject).msg_req_para.set(localReqPara);
    localObject = qnf.a("OidbSvc.0xbbd", 3005, 0, ((oidb_cmd0xbbd.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).getAttributes().put(jdField_c_of_type_JavaLangString, Integer.valueOf(15));
    ((ToServiceMsg)localObject).getAttributes().put("channelID", Integer.valueOf(70));
    ((ToServiceMsg)localObject).getAttributes().put(jdField_d_of_type_JavaLangString, Long.valueOf(((rfe)paramrfd.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Long));
    ((ToServiceMsg)localObject).getAttributes().put(jdField_e_of_type_JavaLangString, Integer.valueOf(-1));
    ((ToServiceMsg)localObject).getAttributes().put("ArticleInfo", paramArticleInfo);
    a((ToServiceMsg)localObject);
  }
  
  public void a(boolean paramBoolean, int paramInt, List<Long> paramList, List<ArticleInfo> paramList1)
  {
    a(paramBoolean, paramInt, paramList, paramList1, true);
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, List<ArticleInfo> paramList1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ArticleInfoModule.7(this, paramBoolean1, paramList, paramList1, paramInt, paramBoolean2));
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArticleInfoModule", 2, "setRecommendTopicFollowTypeIntoDB topicID = " + paramInt1 + "，followType=" + paramInt2);
    }
    Object localObject = (ArrayList)c(paramInt1);
    if ((localObject == null) || (((ArrayList)localObject).size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArticleInfoModule", 2, "no recommend topic feeds in db");
      }
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    qnc.a((List)localObject);
    localArrayList.addAll((Collection)localObject);
    paramInt1 = 0;
    int i;
    if (paramInt1 < localArrayList.size())
    {
      i = (int)((ArticleInfo)localArrayList.get(paramInt1)).mChannelID;
      localObject = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(i));
      if (localObject != null) {
        break label459;
      }
      localObject = new ConcurrentHashMap();
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(i), localObject);
    }
    label459:
    for (;;)
    {
      if ((((ArticleInfo)localArrayList.get(paramInt1)).mTopicRecommendFeedsInfo != null) && (((ArticleInfo)localArrayList.get(paramInt1)).mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        ((rik)((ArticleInfo)localArrayList.get(paramInt1)).mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Int = paramInt2;
      }
      ArticleInfo localArticleInfo = ((ArticleInfo)localArrayList.get(paramInt1)).clone();
      if (((ConcurrentHashMap)localObject).get(Long.valueOf(localArticleInfo.mRecommendSeq)) != null) {
        a(Integer.valueOf(i), localArticleInfo);
      }
      localObject = (ArticleInfo)((ConcurrentHashMap)localObject).get(Long.valueOf(localArticleInfo.mRecommendSeq));
      if (localObject != null)
      {
        if ((((ArticleInfo)localObject).mTopicRecommendFeedsInfo != null) && (((ArticleInfo)localObject).mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null) && (((ArticleInfo)localObject).mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
          ((rik)((ArticleInfo)localObject).mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Int = paramInt2;
        }
        ((ArticleInfo)localObject).invalidateProteusTemplateBean();
        if (QLog.isColorLevel()) {
          QLog.d("ArticleInfoModule", 2, "update memory articleInfo articleID = " + ((ArticleInfo)localObject).mArticleID + ", mRecommendSeq =" + ((ArticleInfo)localObject).mRecommendSeq + "，followType=" + paramInt2);
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ArticleInfoModule.42(this, localArticleInfo));
      paramInt1 += 1;
      break;
      this.jdField_a_of_type_AndroidOsHandler.post(new ArticleInfoModule.43(this));
      return true;
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (paramBoolean) {}
    for (String str = "mChannelID = ? and mRecommendSeq < ?";; str = "mChannelID = ? and mRecommendSeq > ?")
    {
      QLog.i("ArticleInfoModule", 1, "loadMoreChannelArticleList with selection=" + str + "channelId=" + paramInt1 + "recommendSeq=" + paramLong + "count=" + paramInt2);
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ArticleInfoModule.19(this, str, paramInt1, paramLong, paramInt2, paramInt3, paramInt4, paramInt6, paramInt7, paramBoolean, paramInt5));
      return true;
    }
  }
  
  public boolean a(ArticleInfo paramArticleInfo)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (paramArticleInfo != null)
    {
      bool1 = bool3;
      if (this.jdField_a_of_type_JavaUtilLinkedHashMap != null)
      {
        Object localObject = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(0));
        bool1 = bool3;
        if (localObject != null)
        {
          if (((ConcurrentHashMap)localObject).containsKey(Long.valueOf(paramArticleInfo.mRecommendSeq))) {
            bool2 = true;
          }
          bool1 = bool2;
          if (!bool2)
          {
            localObject = ((ConcurrentHashMap)localObject).values().iterator();
            ArticleInfo localArticleInfo;
            do
            {
              bool1 = bool2;
              if (!((Iterator)localObject).hasNext()) {
                break;
              }
              localArticleInfo = (ArticleInfo)((Iterator)localObject).next();
            } while ((localArticleInfo == null) || ((localArticleInfo.mArticleID != paramArticleInfo.mArticleID) && ((TextUtils.isEmpty(localArticleInfo.innerUniqueID)) || (!localArticleInfo.innerUniqueID.equalsIgnoreCase(paramArticleInfo.innerUniqueID)))));
            bool1 = true;
          }
        }
      }
    }
    for (;;)
    {
      QLog.d("ArticleInfoModule", 2, "isArticleFromRecommendFeeds : " + bool1);
      return bool1;
    }
  }
  
  public boolean a(Integer paramInteger, List<ArticleInfo> paramList, boolean paramBoolean)
  {
    c(paramList);
    if ((paramInteger.intValue() == -1) || (paramList == null) || (paramList.size() == 0))
    {
      this.jdField_b_of_type_JavaUtilMap.remove(paramInteger);
      return false;
    }
    this.jdField_a_of_type_Pxn.a(paramInteger, paramList, paramBoolean);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)paramList.next();
      a(paramInteger, localArticleInfo, paramBoolean, a(Long.valueOf(localArticleInfo.mArticleID)));
    }
    if ((paramInteger.intValue() == 0) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = false;
      if (((ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramInteger)).size() > 30) {
        a(paramInteger);
      }
    }
    return true;
  }
  
  public boolean a(Long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_JavaUtilHashMap.size() != 0)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_JavaUtilHashMap.get(paramLong) != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public byte[] a(Integer paramInteger)
  {
    paramInteger = (ChannelTopCookie)this.jdField_a_of_type_JavaUtilMap.get(paramInteger);
    if (paramInteger == null) {
      return null;
    }
    return paramInteger.mSetTopCookie;
  }
  
  public long b(Integer paramInteger)
  {
    long l1 = 9223372036854775807L;
    paramInteger = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramInteger);
    long l2;
    if (paramInteger == null) {
      l2 = -1L;
    }
    do
    {
      return l2;
      paramInteger = paramInteger.keySet().iterator();
      l2 = l1;
    } while (!paramInteger.hasNext());
    Long localLong = (Long)paramInteger.next();
    if (localLong.longValue() < l1) {
      l1 = localLong.longValue();
    }
    for (;;)
    {
      break;
    }
  }
  
  public List<Long> b(Integer paramInteger)
  {
    Object localObject1 = c(paramInteger);
    if ((localObject1 == null) || (((List)localObject1).size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (ArticleInfo)((Iterator)localObject1).next();
      if ((localArrayList.contains(Long.valueOf(((ArticleInfo)localObject2).mArticleID))) || (((ArticleInfo)localObject2).mRecommendSeq == -2L) || (((ArticleInfo)localObject2).mRecommendSeq == -3L))
      {
        QLog.d("ArticleInfoModule", 2, "getChannelArticleSeqList 有重复文章， channelID = " + paramInteger + ", seq = " + ((ArticleInfo)localObject2).mRecommendSeq + "articleID = " + ((ArticleInfo)localObject2).mArticleID + ", title =" + ((ArticleInfo)localObject2).mTitle);
        a(paramInteger, (ArticleInfo)localObject2);
      }
      else if (((ArticleInfo)localObject2).mNewPolymericInfo != null)
      {
        localObject2 = ((ArticleInfo)localObject2).mNewPolymericInfo.jdField_a_of_type_JavaUtilList;
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            localArrayList.add(Long.valueOf(((rfw)((Iterator)localObject2).next()).jdField_a_of_type_Long));
          }
        }
      }
      else
      {
        localArrayList.add(Long.valueOf(((ArticleInfo)localObject2).mArticleID));
      }
    }
    return localArrayList;
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(Integer.valueOf(paramInt));
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ArticleInfoModule.11(this, paramInt));
  }
  
  public void b(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown())) {
      QLog.i("ArticleInfoModule", 1, "[loadFeedsFromDB], mExecutorService is null or shutDown.");
    }
    List localList;
    do
    {
      return;
      localList = a(Integer.valueOf(paramInt1));
    } while ((localList == null) || (localList.isEmpty()));
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ArticleInfoModule.16(this, paramInt1, paramInt2, paramLong, paramBoolean));
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      QLog.e("ArticleInfoModule", 1, "[preloadFeedsFromDB], e = " + localRejectedExecutionException);
    }
  }
  
  public void b(int paramInt, List<ArticleInfo> paramList)
  {
    if (!pha.s()) {}
    ArrayList localArrayList;
    do
    {
      Map localMap;
      do
      {
        do
        {
          return;
        } while ((paramList == null) || (paramList.isEmpty()) || ((paramInt != 0) && (!pil.c(paramInt))));
        localMap = (Map)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt));
      } while (localMap == null);
      localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        ArticleInfo localArticleInfo = (ArticleInfo)localIterator.next();
        if ((!TextUtils.isEmpty(localArticleInfo.innerUniqueID)) && (localMap.containsKey(localArticleInfo.innerUniqueID))) {
          if ((!localArticleInfo.isNeeaRealExposureFilter) || (localArticleInfo.mAbandonRepeatFlag == 1))
          {
            QLog.d("ArticleInfoModule", 1, "[filterRealExposureArticle] isReplaceFlag is true or isNeedRealExposureFilter flag is false, articleID : " + localArticleInfo.mArticleID);
          }
          else
          {
            localArrayList.add(localArticleInfo);
            QLog.d("ArticleInfoModule", 1, "[filterRealExposureArticle] 文章已真实曝光，需去重: " + localArticleInfo + ", exposureInfo : " + localMap.get(localArticleInfo.innerUniqueID));
          }
        }
      }
    } while (localArrayList.size() <= 0);
    paramList.removeAll(localArrayList);
  }
  
  public void b(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo != null) {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ArticleInfoModule.38(this, paramArticleInfo));
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = 0L;
    paramToServiceMsg = null;
    int i = -1;
    int k = 0;
    oidb_cmd0xc32.RspBody localRspBody = new oidb_cmd0xc32.RspBody();
    int m = qnf.a(paramFromServiceMsg, paramObject, localRspBody);
    QLog.d("ArticleInfoModule", 1, "handle0x32GetPrivacyList | retCode " + m);
    int j;
    boolean bool;
    if ((m == 0) && (localRspBody.msg_get_rsp_body.has()))
    {
      paramFromServiceMsg = (oidb_cmd0xc32.GetVisibleListRspBody)localRspBody.msg_get_rsp_body.get();
      if (paramFromServiceMsg.rpt_uint64_visible_uins.has()) {
        paramToServiceMsg = paramFromServiceMsg.rpt_uint64_visible_uins.get();
      }
      if (paramFromServiceMsg.uint64_feeds_id.has()) {
        l = paramFromServiceMsg.uint64_feeds_id.get();
      }
      if (paramFromServiceMsg.uint32_next_ix.has()) {
        i = paramFromServiceMsg.uint32_next_ix.get();
      }
      if (paramFromServiceMsg.uint32_total_count.has())
      {
        j = paramFromServiceMsg.uint32_total_count.get();
        if ((!paramFromServiceMsg.uint32_is_end.has()) || (paramFromServiceMsg.uint32_is_end.get() != 0)) {
          break label301;
        }
        bool = true;
        label182:
        paramFromServiceMsg = new StringBuilder().append("handle0x32GetPrivacyList | feedsId ").append(l).append("| totalCnt ").append(j).append(" | nextPageStartIndex ").append(i).append(" | hasNextPage ").append(bool).append("| uinList size ");
        if (paramToServiceMsg != null) {
          k = paramToServiceMsg.size();
        }
        QLog.d("ArticleInfoModule", 1, k);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new ArticleInfoModule.5(this, m, l, paramToServiceMsg, i, j, bool));
      return;
      j = 0;
      break;
      label301:
      bool = false;
      break label182;
      bool = false;
      j = 0;
      paramToServiceMsg = null;
      i = -1;
    }
  }
  
  public void b(String paramString)
  {
    oidb_cmd0xb83.ReqBody localReqBody = new oidb_cmd0xb83.ReqBody();
    if (!TextUtils.isEmpty(paramString))
    {
      oidb_cmd0xb83.SearchInfo localSearchInfo = new oidb_cmd0xb83.SearchInfo();
      localSearchInfo.bytes_key.set(ByteStringMicro.copyFromUtf8(paramString));
      paramString = new oidb_cmd0xb83.ReqSearchTagInfo();
      paramString.rpt_msg_search_info_list.add(localSearchInfo);
      localReqBody.msg_req_search_tag_info.set(paramString);
    }
    for (;;)
    {
      a(qnf.a("OidbSvc.0xb83", 2947, 0, localReqBody.toByteArray()));
      return;
      paramString = new oidb_cmd0xb83.ReqRecommendTagInfo();
      localReqBody.msg_req_recommend_tag_info.set(paramString);
    }
  }
  
  public boolean b(Long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_JavaUtilHashMap.size() != 0)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_JavaUtilHashMap.get(paramLong) != null) {
          bool1 = ((AtomicBoolean)this.jdField_a_of_type_JavaUtilHashMap.get(paramLong)).get();
        }
      }
    }
    return bool1;
  }
  
  public List<ArticleInfo> c(Integer paramInteger)
  {
    paramInteger = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramInteger);
    if ((paramInteger == null) || (paramInteger.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramInteger.size());
    Iterator localIterator = paramInteger.keySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((ArticleInfo)paramInteger.get((Long)localIterator.next()));
    }
    Collections.sort(localArrayList, new pwd(this));
    return localArrayList;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {}
    while (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
      return;
    }
  }
  
  public void c(int paramInt)
  {
    ConcurrentHashMap localConcurrentHashMap1 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt));
    ConcurrentHashMap localConcurrentHashMap2 = (ConcurrentHashMap)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt));
    if ((localConcurrentHashMap1 == null) || (localConcurrentHashMap2 == null) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isTerminated()) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown())) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ArticleInfoModule.47(this, localConcurrentHashMap2, localConcurrentHashMap1, paramInt));
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = true;
    paramToServiceMsg = new oidb_cmd0x83e.RspBody();
    int i = qnf.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i == 0)
    {
      QLog.d("ArticleInfoModule", 1, "handle0x83eUpvoteFastWebArticleAction result OK");
      if (paramToServiceMsg.uint32_operation.has())
      {
        paramFromServiceMsg = new StringBuilder().append("handle0x83eUpvoteFastWebArticleAction | upvote status :");
        if (paramToServiceMsg.uint32_operation.get() != 2) {
          break label84;
        }
      }
      for (;;)
      {
        QLog.d("ArticleInfoModule", 2, bool);
        return;
        label84:
        bool = false;
      }
    }
    QLog.d("ArticleInfoModule", 1, "handle0x83eUpvoteFastWebArticleAction failed result " + i);
  }
  
  public void c(String paramString)
  {
    oidb_cmd0xbde.ReqBody localReqBody = new oidb_cmd0xbde.ReqBody();
    if (!TextUtils.isEmpty(paramString))
    {
      oidb_cmd0xbde.SearchInfo localSearchInfo = new oidb_cmd0xbde.SearchInfo();
      localSearchInfo.bytes_key.set(ByteStringMicro.copyFromUtf8(paramString));
      paramString = new oidb_cmd0xbde.ReqSearchTopicInfo();
      paramString.rpt_msg_search_info_list.add(localSearchInfo);
      localReqBody.uint32_query_mode.set(1);
      localReqBody.msg_req_search_tag_info.set(paramString);
    }
    a(qnf.a("OidbSvc.0xbde", 3038, 0, localReqBody.toByteArray()));
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {}
    while (((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) || (!QLog.isColorLevel())) {
      return;
    }
    QLog.d("ArticleInfoModule", 2, "mApp isn't instanceof QQAppInterface init model failed!");
  }
  
  public void d(int paramInt)
  {
    if (paramInt != 0)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(Integer.valueOf(paramInt));
      this.jdField_b_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt));
    }
  }
  
  public void e() {}
  
  public void e(int paramInt)
  {
    if (!pha.s()) {}
    while ((paramInt != 0) && (!pil.c(paramInt))) {
      return;
    }
    if ((ConcurrentHashMap)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt)) != null)
    {
      QLog.d("ArticleInfoModule", 1, "loadArticleExposureInfoFromDB has loaded!");
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ArticleInfoModule.55(this, paramInt));
  }
  
  public void f()
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ArticleInfoModule.26(this));
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      return;
    }
    g(((KandianMergeManager)((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getManager(162)).a(0));
  }
  
  public void h()
  {
    ThreadManager.getUIHandler().post(new ArticleInfoModule.41(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pwb
 * JD-Core Version:    0.7.0.1
 */