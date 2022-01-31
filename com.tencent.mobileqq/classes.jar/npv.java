import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.AdTagInfo;
import com.tencent.biz.pubaccount.VideoInfo.ChannelInfo;
import com.tencent.biz.pubaccount.VideoInfo.DownloadBarInfo;
import com.tencent.biz.pubaccount.VideoInfo.ECommerceEntranceInfo;
import com.tencent.biz.pubaccount.VideoInfo.EntranceDownloadInfo;
import com.tencent.biz.pubaccount.VideoInfo.InterruptedWeishiAd;
import com.tencent.biz.pubaccount.VideoInfo.LikeActionDownloadBar;
import com.tencent.biz.pubaccount.VideoInfo.SoftAdDownloadBarInfo;
import com.tencent.biz.pubaccount.VideoInfo.TopBarInfo;
import com.tencent.biz.pubaccount.VideoPlayRecommendHandler.1;
import com.tencent.biz.pubaccount.VideoPlayRecommendHandler.2;
import com.tencent.biz.pubaccount.VideoPlayRecommendHandler.3;
import com.tencent.biz.pubaccount.VideoPlayRecommendHandler.4;
import com.tencent.biz.pubaccount.VideoPlayRecommendHandler.6;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FusionBiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.WeishiRedDotInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.AccountVInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.AdVideoPos;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.AppAdInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ArticleSummary;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.BackOffGroupInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ChannelInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.DisLikeInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.DownloadBarInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ECommerceEntranceInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.EntranceDownloadInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ExposeArticleInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.FeedsIdInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.FeedsInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.FusionBiuInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.InnerMsg;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.InterruptedWeishiAd;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.LikeDownloadBarInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.PhoneInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.PkgInstallInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.PosAdInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ReqAdvertisePara;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ReqBody;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.RspBody;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.SoftAdDownloadBarInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.TopBarInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.UGCFeedsInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.UGCVideoInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.UGDownloadBarInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.UrlJumpInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.UserExposeArticle;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.VideoColumnInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.VideoFloatInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.WeishiUGInfo;
import tencent.im.oidb.cmd0x885.oidb_0x885.AdReqInfo;
import tencent.im.oidb.cmd0x885.oidb_0x885.AdTagInfo;
import tencent.im.oidb.cmd0x885.oidb_0x885.GameComponentInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class npv
  extends ajtd
{
  private long jdField_a_of_type_Long;
  private SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = { "com.tencent.reading", "com.tencent.rijvideo", "com.tencent.weishi" };
  
  public npv(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public npv(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private int a()
  {
    switch (bbev.a(BaseApplicationImpl.getApplication().getApplicationContext()))
    {
    case 2: 
    default: 
      return 2;
    case 1: 
      return 0;
    }
    return 1;
  }
  
  private VideoInfo.ECommerceEntranceInfo a(oidb_0x6cf.InterruptedWeishiAd paramInterruptedWeishiAd, oidb_0x6cf.RspBody paramRspBody)
  {
    VideoInfo.ECommerceEntranceInfo localECommerceEntranceInfo2;
    if (paramInterruptedWeishiAd.msg_ecommerce_entrance_info.has())
    {
      localECommerceEntranceInfo2 = new VideoInfo.ECommerceEntranceInfo();
      localECommerceEntranceInfo2.jdField_a_of_type_JavaLangString = a(paramInterruptedWeishiAd.msg_ecommerce_entrance_info.bytes_title);
      localECommerceEntranceInfo2.jdField_b_of_type_JavaLangString = a(paramInterruptedWeishiAd.msg_ecommerce_entrance_info.bytes_subtitle);
      localECommerceEntranceInfo2.jdField_c_of_type_JavaLangString = a(paramInterruptedWeishiAd.msg_ecommerce_entrance_info.bytes_thumbnail_url);
      localECommerceEntranceInfo2.jdField_d_of_type_JavaLangString = a(paramInterruptedWeishiAd.msg_ecommerce_entrance_info.bytes_link_icon_url);
      if (paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_jump_type.has()) {
        localECommerceEntranceInfo2.jdField_a_of_type_Int = paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_jump_type.get();
      }
      if (paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_ecommerce_id.has()) {
        localECommerceEntranceInfo2.jdField_g_of_type_Int = paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_ecommerce_id.get();
      }
      if (paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_display_count_ver.has()) {
        localECommerceEntranceInfo2.jdField_d_of_type_Int = paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_display_count_ver.get();
      }
      if (paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_one_day_max_display_count.has()) {
        localECommerceEntranceInfo2.jdField_f_of_type_Int = paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_one_day_max_display_count.get();
      }
      if (paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_session_max_display_count.has()) {
        localECommerceEntranceInfo2.jdField_e_of_type_Int = paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_session_max_display_count.get();
      }
      localECommerceEntranceInfo2.jdField_e_of_type_JavaLangString = a(paramInterruptedWeishiAd.msg_ecommerce_entrance_info.bytes_jump_url);
      localECommerceEntranceInfo2.jdField_f_of_type_JavaLangString = a(paramInterruptedWeishiAd.msg_ecommerce_entrance_info.bytes_common_data);
      localECommerceEntranceInfo2.jdField_h_of_type_Int = paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_style.get();
      localECommerceEntranceInfo1 = localECommerceEntranceInfo2;
      if (paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.has())
      {
        localECommerceEntranceInfo2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = new UrlJumpInfo();
        localECommerceEntranceInfo2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_Int = ((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).uint32_jump_type.get();
        localECommerceEntranceInfo2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_b_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_jump_bundle);
        localECommerceEntranceInfo2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_c_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_jump_schema);
        localECommerceEntranceInfo2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_jump_url);
        localECommerceEntranceInfo2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_d_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_clipboard_info);
        localECommerceEntranceInfo2.jdField_h_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_app_open_wording);
        localECommerceEntranceInfo2.jdField_g_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_app_download_wording);
        localECommerceEntranceInfo2.jdField_b_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_app_desc);
        localECommerceEntranceInfo2.jdField_c_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_icon_url);
        localECommerceEntranceInfo2.jdField_a_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_name);
      }
    }
    for (VideoInfo.ECommerceEntranceInfo localECommerceEntranceInfo1 = localECommerceEntranceInfo2;; localECommerceEntranceInfo1 = null)
    {
      int i;
      if ((localECommerceEntranceInfo1 != null) && (paramRspBody.msg_ecommerce_entrance_config.has()) && (paramRspBody.msg_ecommerce_entrance_config.get() != null))
      {
        if (paramRspBody.msg_ecommerce_entrance_config.uint32_show_after_play_time.has()) {
          localECommerceEntranceInfo1.jdField_b_of_type_Int = paramRspBody.msg_ecommerce_entrance_config.uint32_show_after_play_time.get();
        }
        paramInterruptedWeishiAd = a(paramRspBody.msg_ecommerce_entrance_config.bytes_show_positon);
        if (!TextUtils.isEmpty(paramInterruptedWeishiAd))
        {
          paramInterruptedWeishiAd = paramInterruptedWeishiAd.split(",");
          if ((paramInterruptedWeishiAd != null) && (paramInterruptedWeishiAd.length > 0))
          {
            localECommerceEntranceInfo1.jdField_a_of_type_ArrayOfInt = new int[paramInterruptedWeishiAd.length];
            i = 0;
          }
        }
      }
      for (;;)
      {
        if (i < paramInterruptedWeishiAd.length) {}
        try
        {
          localECommerceEntranceInfo1.jdField_a_of_type_ArrayOfInt[i] = Integer.parseInt(paramInterruptedWeishiAd[i]);
          label685:
          i += 1;
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "get commerceEntranceInfo in config: " + localECommerceEntranceInfo1.toString());
          }
          return localECommerceEntranceInfo1;
        }
        catch (Exception paramRspBody)
        {
          break label685;
        }
      }
    }
  }
  
  private VideoInfo.EntranceDownloadInfo a(oidb_0x6cf.EntranceDownloadInfo paramEntranceDownloadInfo)
  {
    boolean bool = false;
    if (paramEntranceDownloadInfo == null) {
      return null;
    }
    VideoInfo.EntranceDownloadInfo localEntranceDownloadInfo = new VideoInfo.EntranceDownloadInfo();
    localEntranceDownloadInfo.jdField_a_of_type_JavaLangString = a(paramEntranceDownloadInfo.bytes_icon_url);
    localEntranceDownloadInfo.jdField_b_of_type_JavaLangString = a(paramEntranceDownloadInfo.bytes_small_icon_url);
    if (paramEntranceDownloadInfo.uint32_is_use_gif.has()) {}
    for (int i = paramEntranceDownloadInfo.uint32_is_use_gif.get();; i = 0)
    {
      if (i > 0) {
        bool = true;
      }
      localEntranceDownloadInfo.jdField_a_of_type_Boolean = bool;
      localEntranceDownloadInfo.jdField_c_of_type_JavaLangString = a(paramEntranceDownloadInfo.bytes_common_data);
      localEntranceDownloadInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = a(paramEntranceDownloadInfo.msg_url_jump_info);
      return localEntranceDownloadInfo;
    }
  }
  
  private VideoInfo a(oidb_0x6cf.ArticleSummary paramArticleSummary, oidb_0x6cf.RspBody paramRspBody)
  {
    boolean bool2 = true;
    int j = 0;
    VideoInfo localVideoInfo = b(paramArticleSummary, paramRspBody);
    boolean bool1;
    if (localVideoInfo != null)
    {
      if ((TextUtils.isEmpty(localVideoInfo.jdField_c_of_type_JavaLangString)) && (QLog.isColorLevel())) {
        QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "req_article_summary getRecommendList 获取原文章标题, NULL ERROR");
      }
      if ((paramArticleSummary.bytes_inner_id.has()) && (paramArticleSummary.bytes_inner_id.get() != null)) {
        localVideoInfo.jdField_g_of_type_JavaLangString = paramArticleSummary.bytes_inner_id.get().toStringUtf8();
      }
      if (paramArticleSummary.uint64_article_id.has()) {
        localVideoInfo.jdField_c_of_type_Long = paramArticleSummary.uint64_article_id.get();
      }
      if (paramRspBody.msg_interrupted_ad_weishi.has())
      {
        paramRspBody = (oidb_0x6cf.InterruptedWeishiAd)paramRspBody.msg_interrupted_ad_weishi.get();
        localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd = new VideoInfo.InterruptedWeishiAd();
        localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_a_of_type_JavaLangString = a(paramRspBody.bytes_ad_url);
        paramArticleSummary = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd;
        if (paramRspBody.uint32_is_show_in_play_end.has()) {
          if (paramRspBody.uint32_is_show_in_play_end.get() == 1) {
            bool1 = true;
          }
        }
      }
    }
    for (;;)
    {
      paramArticleSummary.jdField_b_of_type_Boolean = bool1;
      paramArticleSummary = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd;
      label218:
      int i;
      if (paramRspBody.uint32_is_show_in_switch.has()) {
        if (paramRspBody.uint32_is_show_in_switch.get() == 1)
        {
          bool1 = bool2;
          paramArticleSummary.jdField_a_of_type_Boolean = bool1;
          paramArticleSummary = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd;
          if (!paramRspBody.uint32_show_after_play_time.has()) {
            break label349;
          }
          i = paramRspBody.uint32_show_after_play_time.get();
          label248:
          paramArticleSummary.jdField_a_of_type_Int = i;
          paramArticleSummary = a(paramRspBody.bytes_show_positon);
          if (paramArticleSummary == null) {
            break label354;
          }
          paramArticleSummary = paramArticleSummary.split(",");
          label273:
          if ((paramArticleSummary == null) || (paramArticleSummary.length <= 0)) {
            break label359;
          }
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_a_of_type_ArrayOfInt = new int[paramArticleSummary.length];
          i = 0;
          label296:
          if (i >= paramArticleSummary.length) {
            break label359;
          }
        }
      }
      try
      {
        localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_a_of_type_ArrayOfInt[i] = Integer.parseInt(paramArticleSummary[i]);
        label318:
        i += 1;
        break label296;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        break label218;
        bool1 = false;
        break label218;
        label349:
        i = -1;
        break label248;
        label354:
        paramArticleSummary = null;
        break label273;
        label359:
        paramArticleSummary = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd;
        i = j;
        if (paramRspBody.uint32_interrupted_ad_type.has()) {
          i = paramRspBody.uint32_interrupted_ad_type.get();
        }
        paramArticleSummary.jdField_b_of_type_Int = i;
        if (paramRspBody.appInfo.has())
        {
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_d_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_app_download_wording);
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_e_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_app_open_wording);
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_b_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_name);
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_c_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_icon_url);
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = new UrlJumpInfo();
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_Int = ((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).uint32_jump_type.get();
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_b_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_jump_bundle);
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_c_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_jump_schema);
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_jump_url);
        }
        return localVideoInfo;
      }
      catch (Exception localException)
      {
        break label318;
      }
    }
  }
  
  private UrlJumpInfo a(oidb_0x6cf.UrlJumpInfo paramUrlJumpInfo)
  {
    if ((paramUrlJumpInfo != null) && (paramUrlJumpInfo.has()) && (paramUrlJumpInfo.get() != null))
    {
      UrlJumpInfo localUrlJumpInfo = new UrlJumpInfo();
      if (paramUrlJumpInfo.uint32_jump_type.has()) {}
      for (int i = paramUrlJumpInfo.uint32_jump_type.get();; i = 0)
      {
        localUrlJumpInfo.jdField_a_of_type_Int = i;
        localUrlJumpInfo.jdField_c_of_type_JavaLangString = a(paramUrlJumpInfo.bytes_jump_schema);
        localUrlJumpInfo.jdField_b_of_type_JavaLangString = a(paramUrlJumpInfo.bytes_jump_bundle);
        localUrlJumpInfo.jdField_a_of_type_JavaLangString = a(paramUrlJumpInfo.bytes_jump_url);
        localUrlJumpInfo.jdField_d_of_type_JavaLangString = a(paramUrlJumpInfo.bytes_clipboard_info);
        localUrlJumpInfo.jdField_e_of_type_JavaLangString = a(paramUrlJumpInfo.bytes_common_data);
        return localUrlJumpInfo;
      }
    }
    return null;
  }
  
  private String a(PBBytesField paramPBBytesField)
  {
    if ((paramPBBytesField.has()) && (paramPBBytesField.get() != null)) {
      return paramPBBytesField.get().toStringUtf8();
    }
    return null;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    Bundle localBundle;
    StringBuilder localStringBuilder;
    List localList;
    Object localObject2;
    Object localObject1;
    boolean bool3;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      localBundle = new Bundle();
      localStringBuilder = null;
      localList = null;
      localObject2 = null;
      localObject1 = null;
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "handleGetRecommendList onReceive :" + bool1);
      }
      bool3 = ((Boolean)paramToServiceMsg.getAttribute("VALUE_REQUEST_GAME_DATA", Boolean.valueOf(false))).booleanValue();
      if (!bool1) {
        break label1229;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        localObject1 = localObject2;
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        localObject1 = localObject2;
        if (!paramFromServiceMsg.uint32_result.has()) {
          continue;
        }
        localObject1 = localObject2;
        if (paramFromServiceMsg.uint32_result.get() != 83) {
          continue;
        }
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = localObject2;
          QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, 热门长视频黑名单");
        }
        localObject1 = localObject2;
        localBundle.putBoolean("VALUE_USER_IN_BLACK", true);
        localObject1 = localObject2;
        paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
        localObject1 = localObject2;
        localRspBody = new oidb_0x6cf.RspBody();
        localObject1 = localObject2;
        localRspBody.mergeFrom(paramFromServiceMsg);
        localObject1 = localObject2;
        if (localRspBody.uint64_pos_ad_time.has())
        {
          localObject1 = localObject2;
          this.jdField_a_of_type_Long = localRspBody.uint64_pos_ad_time.get();
        }
        localObject1 = localObject2;
        if (localRspBody.bytes_cookie.has())
        {
          localObject1 = localObject2;
          if (localRspBody.bytes_cookie.get() != null)
          {
            localObject1 = localObject2;
            localBundle.putString("VALUE_COOKIE", localRspBody.bytes_cookie.get().toStringUtf8());
          }
        }
        localObject1 = localObject2;
        if (!localRspBody.bytes_ads_context.has()) {
          continue;
        }
        localObject1 = localObject2;
        paramObject = localRspBody.bytes_ads_context.get().toStringUtf8();
        i = 1;
        localObject1 = localObject2;
        if (this.jdField_a_of_type_JavaTextSimpleDateFormat == null)
        {
          localObject1 = localObject2;
          this.jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        }
        if (bool3) {
          continue;
        }
        localObject1 = localObject2;
        if (!localRspBody.rpt_article_list.has()) {
          continue;
        }
        localObject1 = localObject2;
        if (localRspBody.rpt_article_list.get() == null) {
          continue;
        }
        localObject1 = localObject2;
        localList = localRspBody.rpt_article_list.get();
        paramFromServiceMsg = localStringBuilder;
        if (localList == null) {
          continue;
        }
        paramFromServiceMsg = localStringBuilder;
        localObject1 = localObject2;
        if (localList.isEmpty()) {
          continue;
        }
        localObject1 = localObject2;
        paramFromServiceMsg = new ArrayList(localList.size());
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "handleGetRecommendList, 解析推荐视频列表: article size=" + localList.size());
          }
          localObject1 = localList.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            continue;
          }
          localObject2 = (oidb_0x6cf.ArticleSummary)((Iterator)localObject1).next();
          try
          {
            localObject2 = b((oidb_0x6cf.ArticleSummary)localObject2, localRspBody);
            if (localObject2 == null) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "handleGetRecommendList，解析推荐视频列表：article = " + ((VideoInfo)localObject2).b());
            }
            paramFromServiceMsg.add(localObject2);
          }
          catch (Exception localException) {}
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, ERROR e=" + localException.getMessage());
          continue;
          paramFromServiceMsg = (FromServiceMsg)localObject1;
        }
        catch (Exception paramObject)
        {
          localObject1 = paramFromServiceMsg;
        }
      }
      catch (Exception paramObject)
      {
        oidb_0x6cf.RspBody localRspBody;
        int i;
        VideoInfo localVideoInfo;
        label1229:
        continue;
        continue;
        continue;
        paramObject = "null";
        continue;
        boolean bool2 = false;
        continue;
      }
      if (QLog.isColorLevel())
      {
        QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, ERROR e=" + paramObject.getMessage());
        paramFromServiceMsg = (FromServiceMsg)localObject1;
      }
      if (!bool3)
      {
        paramObject = paramToServiceMsg.getAttribute("is_from_first_recommend_video");
        if ((paramObject != null) && ((paramObject instanceof Boolean))) {
          localBundle.putBoolean("is_from_first_recommend_video", ((Boolean)paramObject).booleanValue());
        }
        localBundle.putString("VALUE_REQUEST_VIDEO_ARTICLE_ID", (String)paramToServiceMsg.getAttribute("VALUE_REQUEST_VIDEO_ARTICLE_ID"));
        nml.a(localBundle, paramFromServiceMsg);
        localBundle.putBoolean("VALUE_REQUEST_GAME_DATA", false);
        paramToServiceMsg = paramToServiceMsg.getAttribute("VALUE_OBSERVER_TAG");
        if ((paramToServiceMsg instanceof Integer)) {
          localBundle.putInt("VALUE_OBSERVER_TAG", ((Integer)paramToServiceMsg).intValue());
        }
        super.notifyUI(0, bool1, localBundle);
        return;
        bool1 = false;
        break;
        localObject1 = localException;
        localBundle.putBoolean("VALUE_USER_IN_BLACK", false);
        continue;
        if (paramFromServiceMsg != null)
        {
          localObject1 = paramFromServiceMsg;
          if (!paramFromServiceMsg.isEmpty()) {}
        }
        else
        {
          localObject1 = paramFromServiceMsg;
          if (QLog.isColorLevel())
          {
            localObject1 = paramFromServiceMsg;
            QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, 返回的rpt_article_list 中合法数据为空");
          }
        }
        localObject1 = paramFromServiceMsg;
        localBundle.putParcelableArrayList("VIDEO_RECOMMEND_LIST", paramFromServiceMsg);
        if (i != 0)
        {
          localObject1 = paramFromServiceMsg;
          nmf.a(paramObject);
        }
        localObject1 = paramFromServiceMsg;
        if (localRspBody.req_article_summary.has())
        {
          localObject1 = paramFromServiceMsg;
          if (localRspBody.req_article_summary.get() != null)
          {
            localObject1 = paramFromServiceMsg;
            localVideoInfo = a((oidb_0x6cf.ArticleSummary)localRspBody.req_article_summary.get(), localRspBody);
            localObject1 = paramFromServiceMsg;
            if (QLog.isColorLevel())
            {
              localObject1 = paramFromServiceMsg;
              localStringBuilder = new StringBuilder().append("handleGetRecommendList，解析第一个视频的详细信息：firstVideoInfo = ");
              if (localVideoInfo == null) {
                continue;
              }
              localObject1 = paramFromServiceMsg;
              paramObject = localVideoInfo.b();
              localObject1 = paramFromServiceMsg;
              QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, paramObject);
            }
            localObject1 = paramFromServiceMsg;
            localBundle.putParcelable("VALUE_REQUEST_VIDEO_DETAIL_INFO", localVideoInfo);
            localObject1 = paramFromServiceMsg;
            if (localRspBody.msg_ecommerce_entrance_config.has())
            {
              localObject1 = paramFromServiceMsg;
              if (localRspBody.msg_ecommerce_entrance_config.get() != null)
              {
                localObject1 = paramFromServiceMsg;
                localBundle.putParcelable("VALUE_ECOMMERCE_ENTRANCE_INFO", a((oidb_0x6cf.InterruptedWeishiAd)localRspBody.msg_ecommerce_entrance_config.get(), localRspBody));
              }
            }
            localObject1 = paramFromServiceMsg;
            if (localRspBody.uint32_is_end.has())
            {
              localObject1 = paramFromServiceMsg;
              if (localRspBody.uint32_is_end.get() != 0) {
                continue;
              }
              bool2 = true;
              localObject1 = paramFromServiceMsg;
              localBundle.putBoolean("VALUE_HAS_MORE_DATA", bool2);
            }
            localObject1 = paramFromServiceMsg;
            if (!localRspBody.msg_entrance_download_info.has()) {
              continue;
            }
            localObject1 = paramFromServiceMsg;
            if (localRspBody.msg_entrance_download_info.get() == null) {
              continue;
            }
            localObject1 = paramFromServiceMsg;
            localBundle.putParcelable("value_entrance_download_info", a((oidb_0x6cf.EntranceDownloadInfo)localRspBody.msg_entrance_download_info.get()));
            continue;
            paramFromServiceMsg = localList;
            localObject1 = localVideoInfo;
            if (!QLog.isColorLevel()) {
              continue;
            }
            localObject1 = localVideoInfo;
            QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, 返回的rpt_article_list null");
            paramFromServiceMsg = localList;
            continue;
          }
        }
        localObject1 = paramFromServiceMsg;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject1 = paramFromServiceMsg;
        QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "handleGetRecommendList: 返回的req_article_summary null");
        continue;
        localObject1 = localVideoInfo;
        nml.a(localRspBody, localBundle, this.jdField_a_of_type_Long);
        paramFromServiceMsg = null;
        continue;
        paramFromServiceMsg = (FromServiceMsg)localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, 返回的rpt_article_list null 或者直接出错了");
        paramFromServiceMsg = (FromServiceMsg)localObject1;
        continue;
      }
      localBundle.putBoolean("VALUE_REQUEST_GAME_DATA", true);
      continue;
      continue;
      i = 0;
      paramObject = null;
    }
  }
  
  private void a(Object paramObject, long paramLong1, VideoInfo paramVideoInfo, int paramInt1, ArrayList<VideoInfo> paramArrayList1, String paramString1, long paramLong2, boolean paramBoolean, int paramInt2, String paramString2, String paramString3, WeishiRedDotInfo paramWeishiRedDotInfo, int paramInt3, String paramString4, byte[] paramArrayOfByte, ArrayList<oidb_0x885.AdTagInfo> paramArrayList, int paramInt4, int paramInt5, int paramInt6, int paramInt7, ArrayList<VideoInfo> paramArrayList2)
  {
    if (paramVideoInfo == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 4, "getRecommendList()  videoInfo == null, RETURN");
      }
      return;
    }
    if (paramVideoInfo.jdField_g_of_type_JavaLangString == null) {
      paramVideoInfo.jdField_g_of_type_JavaLangString = "";
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 4, "getRecommendList()  articleId = " + paramVideoInfo.jdField_g_of_type_JavaLangString + ", secondVideoArticleID = " + paramString1 + ", type = " + paramInt1 + ",polymericTopicId = " + paramLong2);
    }
    oidb_0x6cf.ReqBody localReqBody = new oidb_0x6cf.ReqBody();
    Object localObject = ByteStringMicro.copyFromUtf8(paramVideoInfo.jdField_g_of_type_JavaLangString);
    localReqBody.bytes_inner_id.set((ByteStringMicro)localObject);
    localReqBody.uint64_uin.set(paramLong1);
    localReqBody.uint32_req_source.set(paramInt1);
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString1 = ByteStringMicro.copyFromUtf8(paramString1);
      localReqBody.rpt_bytes_redo_inner_id.add(paramString1);
    }
    if (paramLong2 != -1L) {
      localReqBody.uint32_req_topic_id.set((int)paramLong2);
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = ByteStringMicro.copyFromUtf8(paramString2);
      localReqBody.bytes_req_web.set(paramString1);
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString1 = ByteStringMicro.copyFromUtf8(paramString3);
      localReqBody.bytes_cookie.set(paramString1);
    }
    paramString2 = new oidb_0x6cf.ReqAdvertisePara();
    paramString2.msg_phone_info.set(oai.a());
    paramString2.uint64_last_time.set(this.jdField_a_of_type_Long);
    paramString1 = new oidb_0x6cf.VideoFloatInfo();
    paramString1.uint32_ad_support.set(1);
    if ((paramArrayList1 == null) || (paramArrayList1.size() <= 0)) {
      paramString1.uint32_info_num.set(0);
    }
    label402:
    boolean bool;
    for (;;)
    {
      paramString2.msg_video_float_info.set(paramString1);
      paramString3 = new oidb_0x885.AdReqInfo();
      paramString3.uint64_ad_channel_id.set(0L);
      paramString3.int32_revision_video.set(paramInt7);
      if ((paramVideoInfo != null) && (paramVideoInfo.jdField_c_of_type_Int != 0) && (paramVideoInfo.jdField_b_of_type_Int != 0))
      {
        if (paramVideoInfo.jdField_c_of_type_Int > paramVideoInfo.jdField_b_of_type_Int) {
          paramString3.int32_scene_id.set(2);
        }
      }
      else
      {
        if (paramArrayList != null) {
          break label1200;
        }
        paramString3.int32_req_type.set(0);
        bool = false;
        label419:
        paramString2.msg_ad_req_info.set(paramString3);
        localReqBody.req_advertise_para.set(paramString2);
        localReqBody.uint32_req_dislike_type.set(1);
        paramString2 = localReqBody.uint32_req_vertical_video;
        if (!paramBoolean) {
          break label1264;
        }
        paramInt1 = 1;
        label463:
        paramString2.set(paramInt1);
        paramString2 = localReqBody.uint32_is_ugc;
        if (!paramVideoInfo.jdField_b_of_type_Boolean) {
          break label1270;
        }
        paramInt1 = 1;
        label488:
        paramString2.set(paramInt1);
        if (!TextUtils.isEmpty(paramString4)) {
          localReqBody.bytes_req_range_cookie.set(ByteStringMicro.copyFromUtf8(paramString4));
        }
        if (paramVideoInfo.jdField_b_of_type_Boolean)
        {
          paramString2 = new oidb_0x6cf.FeedsIdInfo();
          paramString2.uint64_feeds_id.set(paramVideoInfo.jdField_d_of_type_Long);
          paramString2.uint32_feeds_type.set(paramVideoInfo.jdField_k_of_type_Int);
          localReqBody.ugc_feeds_info.set(paramString2);
        }
        if ((paramWeishiRedDotInfo != null) && (paramWeishiRedDotInfo.a() != null) && (paramWeishiRedDotInfo.a().size() > 0)) {
          paramString2 = new ArrayList();
        }
      }
      try
      {
        paramString3 = ByteStringMicro.copyFromUtf8(paramWeishiRedDotInfo.a());
        paramInt1 = Integer.parseInt(paramWeishiRedDotInfo.c());
        paramLong1 = Long.parseLong(paramWeishiRedDotInfo.b());
        paramString4 = ByteStringMicro.copyFromUtf8(paramWeishiRedDotInfo.d());
        paramWeishiRedDotInfo = paramWeishiRedDotInfo.a().iterator();
        while (paramWeishiRedDotInfo.hasNext())
        {
          paramArrayList = (String)paramWeishiRedDotInfo.next();
          localObject = new oidb_0x6cf.InnerMsg();
          ((oidb_0x6cf.InnerMsg)localObject).bytes_title.set(paramString3);
          ((oidb_0x6cf.InnerMsg)localObject).uint32_strategy_id.set(paramInt1);
          ((oidb_0x6cf.InnerMsg)localObject).uint64_algorithm_id.set(paramLong1);
          ((oidb_0x6cf.InnerMsg)localObject).bytes_push_context.set(paramString4);
          ((oidb_0x6cf.InnerMsg)localObject).article_content_type.set(2);
          ((oidb_0x6cf.InnerMsg)localObject).uint32_jump_src_type.set(10);
          ((oidb_0x6cf.InnerMsg)localObject).bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(paramArrayList));
          paramString2.add(localObject);
        }
      }
      catch (Exception paramString3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList: 解析redDotInfo失败" + paramString3);
        }
        if (!paramString2.isEmpty()) {
          localReqBody.rpt_inner_msg_list.set(paramString2);
        }
        for (;;)
        {
          if (!QLog.isColorLevel()) {
            break label1333;
          }
          paramString2 = new StringBuilder("getRecommendList AdvertiseParam:\n");
          paramString2.append("last_time=").append(this.jdField_a_of_type_Long).append(", info_num=").append(paramString1.uint32_info_num.get());
          if ((!paramString1.rpt_msg_ad_video_pos.has()) || (paramString1.rpt_msg_ad_video_pos.get() == null)) {
            break label1322;
          }
          paramString2.append(", adList=\n");
          paramString1 = paramString1.rpt_msg_ad_video_pos.get().iterator();
          while (paramString1.hasNext())
          {
            paramString3 = (oidb_0x6cf.AdVideoPos)paramString1.next();
            paramString2.append("[pos=").append(paramString3.int32_kd_pos.get()).append(", aid=").append(paramString3.uint64_aid.get()).append(", traceID=").append(paramString3.bytes_trace_id.get().toStringUtf8()).append("]\n");
          }
          paramString3 = new ArrayList();
          int i = 0;
          paramInt1 = 0;
          if (paramInt1 < paramArrayList1.size())
          {
            localObject = (VideoInfo)paramArrayList1.get(paramInt1);
            if (!((VideoInfo)localObject).jdField_c_of_type_Boolean) {
              i += 1;
            }
            for (;;)
            {
              paramInt1 += 1;
              break;
              oidb_0x6cf.AdVideoPos localAdVideoPos = new oidb_0x6cf.AdVideoPos();
              if (((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null)
              {
                if (!TextUtils.isEmpty(((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_h_of_type_JavaLangString)) {
                  localAdVideoPos.bytes_trace_id.set(ByteStringMicro.copyFromUtf8(((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_h_of_type_JavaLangString));
                }
                localAdVideoPos.uint64_aid.set(((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_e_of_type_Long);
              }
              localAdVideoPos.int32_kd_pos.set(paramInt1);
              paramString3.add(localAdVideoPos);
            }
          }
          paramString1.uint32_info_num.set(i);
          if (paramString3.size() <= 0) {
            break;
          }
          paramString1.rpt_msg_ad_video_pos.set(paramString3);
          break;
          paramString3.int32_scene_id.set(1);
          break label402;
          label1200:
          paramString3.int32_req_type.set(2);
          localObject = new oidb_0x885.GameComponentInfo();
          ((oidb_0x885.GameComponentInfo)localObject).uint32_day_display_count.set(paramInt5);
          ((oidb_0x885.GameComponentInfo)localObject).uint32_session_display_count.set(paramInt4);
          ((oidb_0x885.GameComponentInfo)localObject).rpt_tag_info.set(paramArrayList);
          paramString3.msg_game_component_info.set((MessageMicro)localObject);
          bool = true;
          break label419;
          label1264:
          paramInt1 = 0;
          break label463;
          label1270:
          paramInt1 = 0;
          break label488;
          if (!paramString2.isEmpty()) {
            localReqBody.rpt_inner_msg_list.set(paramString2);
          }
        }
      }
      finally
      {
        if (!paramString2.isEmpty()) {
          localReqBody.rpt_inner_msg_list.set(paramString2);
        }
      }
    }
    label1322:
    QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, paramString2.toString());
    label1333:
    if (paramArrayOfByte != null)
    {
      localReqBody.bytes_req_context_pb.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      if ((paramArrayList1 != null) && (!paramArrayList1.isEmpty()))
      {
        paramArrayList1 = (VideoInfo)paramArrayList1.get(paramArrayList1.size() - 1);
        if (!TextUtils.isEmpty(paramArrayList1.jdField_g_of_type_JavaLangString)) {
          localReqBody.bytes_end_rowkey.set(ByteStringMicro.copyFromUtf8(paramArrayList1.jdField_g_of_type_JavaLangString));
        }
        localReqBody.uint64_end_recommend_seq.set(paramArrayList1.jdField_e_of_type_Long);
      }
    }
    localReqBody.uint32_req_times.set(paramInt3);
    localReqBody.uint32_req_network.set(a());
    localReqBody.uint32_req_os.set(1);
    localReqBody.uint32_req_sim_type.set(bhvh.c());
    localReqBody.uint32_req_column_id.set(paramInt2);
    localReqBody.enum_req_video_show_mode.set(paramInt6);
    if ((paramArrayList2 != null) && (paramArrayList2.size() > 0))
    {
      paramArrayList1 = new oidb_0x6cf.UserExposeArticle();
      paramString1 = new ArrayList();
      paramString2 = paramArrayList2.iterator();
      while (paramString2.hasNext())
      {
        paramString3 = (VideoInfo)paramString2.next();
        if (!TextUtils.isEmpty(paramString3.jdField_g_of_type_JavaLangString))
        {
          paramWeishiRedDotInfo = new oidb_0x6cf.ExposeArticleInfo();
          paramWeishiRedDotInfo.bytes_rowkeys.set(ByteStringMicro.copyFromUtf8(paramString3.jdField_g_of_type_JavaLangString));
          paramWeishiRedDotInfo.uint64_algorithm_id.set(paramString3.jdField_f_of_type_Long);
          paramString1.add(paramWeishiRedDotInfo);
        }
      }
      paramArrayList1.rpt_article.set(paramString1);
      localReqBody.user_expose_article.set(paramArrayList1);
    }
    a(localReqBody);
    paramArrayList1 = super.makeOIDBPkg("OidbSvc.0x6cf", 1743, 0, localReqBody.toByteArray());
    paramArrayList1.addAttribute("VALUE_OBSERVER_TAG", Integer.valueOf(paramObject.hashCode()));
    paramArrayList1.addAttribute("VALUE_REQUEST_VIDEO_ARTICLE_ID", paramVideoInfo.jdField_g_of_type_JavaLangString);
    paramArrayList1.addAttribute("VALUE_REQUEST_GAME_DATA", Boolean.valueOf(bool));
    super.sendPbReq(paramArrayList1);
  }
  
  private void a(oidb_0x6cf.ReqBody paramReqBody)
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    int k = arrayOfString.length;
    int i = 0;
    if (i < k)
    {
      String str = arrayOfString[i];
      oidb_0x6cf.PkgInstallInfo localPkgInstallInfo = new oidb_0x6cf.PkgInstallInfo();
      localPkgInstallInfo.bytes_pkg_name.set(ByteStringMicro.copyFromUtf8(str));
      str = bbfd.a(BaseApplicationImpl.getContext(), str);
      PBUInt32Field localPBUInt32Field = localPkgInstallInfo.uint32_is_installed;
      if (!str.equals("0")) {}
      for (int j = 1;; j = 0)
      {
        localPBUInt32Field.set(j);
        localPkgInstallInfo.bytes_version.set(ByteStringMicro.copyFromUtf8(str));
        localPkgInstallInfo.uint32_platform_type.set(1);
        localArrayList.add(localPkgInstallInfo);
        i += 1;
        break;
      }
    }
    paramReqBody.rpt_pkg_install_info.set(localArrayList);
  }
  
  private boolean a(VideoInfo paramVideoInfo)
  {
    boolean bool = true;
    if ((paramVideoInfo == null) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo == null)) {
      bool = false;
    }
    do
    {
      return bool;
      if (paramVideoInfo.jdField_l_of_type_Int != 2) {
        break;
      }
    } while ((!TextUtils.isEmpty(paramVideoInfo.E)) && (!TextUtils.isEmpty(paramVideoInfo.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo.jdField_f_of_type_JavaLangString)));
    while ((paramVideoInfo.jdField_l_of_type_Int != 1) || (TextUtils.isEmpty(paramVideoInfo.E)) || (TextUtils.isEmpty(paramVideoInfo.jdField_k_of_type_JavaLangString)) || (TextUtils.isEmpty(paramVideoInfo.jdField_c_of_type_JavaLangString)) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramVideoInfo.jdField_f_of_type_JavaLangString))) {
      return false;
    }
    return true;
  }
  
  private VideoInfo b(oidb_0x6cf.ArticleSummary paramArticleSummary, oidb_0x6cf.RspBody paramRspBody)
  {
    Object localObject3 = null;
    VideoInfo localVideoInfo = new VideoInfo();
    if ((paramArticleSummary.bytes_article_title.has()) && (paramArticleSummary.bytes_article_title.get() != null)) {
      localVideoInfo.jdField_c_of_type_JavaLangString = paramArticleSummary.bytes_article_title.get().toStringUtf8();
    }
    Object localObject1;
    Object localObject5;
    Object localObject6;
    String str1;
    String str2;
    String str3;
    String str4;
    int i;
    int j;
    if (paramArticleSummary.msg_ug_top_download_bar_info != null)
    {
      localObject1 = a(paramArticleSummary.msg_ug_top_download_bar_info.bytes_icon_url);
      localObject5 = a(paramArticleSummary.msg_ug_top_download_bar_info.msg_url_jump_info.bytes_jump_url);
      localObject6 = a(paramArticleSummary.msg_ug_top_download_bar_info.msg_url_jump_info.bytes_jump_schema);
      str1 = a(paramArticleSummary.msg_ug_top_download_bar_info.weishiUGInfo.bytes_report_base_url);
      str2 = a(paramArticleSummary.msg_ug_top_download_bar_info.msg_url_jump_info.bytes_jump_bundle);
      str3 = a(paramArticleSummary.msg_ug_top_download_bar_info.weishiUGInfo.bytes_back_off_group);
      str4 = a(paramArticleSummary.msg_ug_top_download_bar_info.msg_url_jump_info.bytes_common_data);
      i = paramArticleSummary.msg_ug_top_download_bar_info.weishiUGInfo.uint32_use_ug.get();
      j = paramArticleSummary.msg_ug_top_download_bar_info.msg_url_jump_info.uint32_jump_type.get();
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && ((!TextUtils.isEmpty((CharSequence)localObject5)) || (!TextUtils.isEmpty((CharSequence)localObject6))))
      {
        localVideoInfo.jdField_m_of_type_JavaLangString = ((String)localObject1);
        localVideoInfo.jdField_n_of_type_JavaLangString = ((String)localObject5);
        localVideoInfo.o = ((String)localObject6);
        localVideoInfo.p = str1;
        localVideoInfo.jdField_q_of_type_JavaLangString = str4;
        localVideoInfo.jdField_g_of_type_Int = i;
        localVideoInfo.B = str2;
        localVideoInfo.C = str3;
        localVideoInfo.jdField_h_of_type_Int = j;
        j = paramRspBody.rpt_back_off_group_info.size();
        i = 0;
        if (i < j)
        {
          if ((TextUtils.isEmpty(str3)) || (!str3.equals(a(((oidb_0x6cf.BackOffGroupInfo)paramRspBody.rpt_back_off_group_info.get(i)).bytes_back_off_group)))) {
            break label1176;
          }
          localVideoInfo.jdField_j_of_type_Int = ((oidb_0x6cf.BackOffGroupInfo)paramRspBody.rpt_back_off_group_info.get(i)).uint32_max_evoke_count.get();
          localVideoInfo.i = ((oidb_0x6cf.BackOffGroupInfo)paramRspBody.rpt_back_off_group_info.get(i)).uint32_max_fresh_evoke_count.get();
        }
      }
    }
    if (paramArticleSummary.msg_ug_middle_download_bar_info != null)
    {
      localObject1 = a(paramArticleSummary.msg_ug_middle_download_bar_info.bytes_icon_url);
      localObject5 = a(paramArticleSummary.msg_ug_middle_download_bar_info.msg_url_jump_info.bytes_jump_url);
      localObject6 = a(paramArticleSummary.msg_ug_middle_download_bar_info.msg_url_jump_info.bytes_jump_schema);
      str1 = a(paramArticleSummary.msg_ug_middle_download_bar_info.weishiUGInfo.bytes_report_base_url);
      str2 = a(paramArticleSummary.msg_ug_middle_download_bar_info.msg_url_jump_info.bytes_jump_bundle);
      str3 = a(paramArticleSummary.msg_ug_middle_download_bar_info.weishiUGInfo.bytes_back_off_group);
      str4 = a(paramArticleSummary.msg_ug_middle_download_bar_info.msg_url_jump_info.bytes_common_data);
      i = paramArticleSummary.msg_ug_middle_download_bar_info.weishiUGInfo.uint32_use_ug.get();
      j = paramArticleSummary.msg_ug_middle_download_bar_info.msg_url_jump_info.uint32_jump_type.get();
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && ((!TextUtils.isEmpty((CharSequence)localObject5)) || (!TextUtils.isEmpty((CharSequence)localObject6))))
      {
        localVideoInfo.jdField_r_of_type_JavaLangString = ((String)localObject1);
        localVideoInfo.s = ((String)localObject5);
        localVideoInfo.t = ((String)localObject6);
        localVideoInfo.jdField_u_of_type_JavaLangString = str1;
        localVideoInfo.v = str4;
        localVideoInfo.jdField_g_of_type_Int = i;
        localVideoInfo.B = str2;
        localVideoInfo.C = str3;
        localVideoInfo.jdField_h_of_type_Int = j;
        j = paramRspBody.rpt_back_off_group_info.size();
        i = 0;
        label615:
        if (i < j)
        {
          if ((TextUtils.isEmpty(str3)) || (!str3.equals(a(((oidb_0x6cf.BackOffGroupInfo)paramRspBody.rpt_back_off_group_info.get(i)).bytes_back_off_group)))) {
            break label1183;
          }
          localVideoInfo.jdField_j_of_type_Int = ((oidb_0x6cf.BackOffGroupInfo)paramRspBody.rpt_back_off_group_info.get(i)).uint32_max_evoke_count.get();
          localVideoInfo.i = ((oidb_0x6cf.BackOffGroupInfo)paramRspBody.rpt_back_off_group_info.get(i)).uint32_max_fresh_evoke_count.get();
        }
      }
    }
    if (paramArticleSummary.msg_ug_bottom_download_bar_info != null)
    {
      localObject1 = a(paramArticleSummary.msg_ug_bottom_download_bar_info.bytes_icon_url);
      localObject5 = a(paramArticleSummary.msg_ug_bottom_download_bar_info.msg_url_jump_info.bytes_jump_url);
      localObject6 = a(paramArticleSummary.msg_ug_bottom_download_bar_info.msg_url_jump_info.bytes_jump_schema);
      str1 = a(paramArticleSummary.msg_ug_bottom_download_bar_info.weishiUGInfo.bytes_report_base_url);
      str2 = a(paramArticleSummary.msg_ug_bottom_download_bar_info.msg_url_jump_info.bytes_jump_bundle);
      str3 = a(paramArticleSummary.msg_ug_bottom_download_bar_info.weishiUGInfo.bytes_back_off_group);
      str4 = a(paramArticleSummary.msg_ug_bottom_download_bar_info.msg_url_jump_info.bytes_common_data);
      i = paramArticleSummary.msg_ug_bottom_download_bar_info.weishiUGInfo.uint32_use_ug.get();
      j = paramArticleSummary.msg_ug_bottom_download_bar_info.msg_url_jump_info.uint32_jump_type.get();
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && ((!TextUtils.isEmpty((CharSequence)localObject5)) || (!TextUtils.isEmpty((CharSequence)localObject6))))
      {
        localVideoInfo.w = ((String)localObject1);
        localVideoInfo.x = ((String)localObject5);
        localVideoInfo.y = ((String)localObject6);
        localVideoInfo.z = str1;
        localVideoInfo.A = str4;
        localVideoInfo.jdField_g_of_type_Int = i;
        localVideoInfo.B = str2;
        localVideoInfo.C = str3;
        localVideoInfo.jdField_h_of_type_Int = j;
        j = paramRspBody.rpt_back_off_group_info.size();
        i = 0;
        label941:
        if (i < j)
        {
          if ((TextUtils.isEmpty(str3)) || (!str3.equals(a(((oidb_0x6cf.BackOffGroupInfo)paramRspBody.rpt_back_off_group_info.get(i)).bytes_back_off_group)))) {
            break label1190;
          }
          localVideoInfo.jdField_j_of_type_Int = ((oidb_0x6cf.BackOffGroupInfo)paramRspBody.rpt_back_off_group_info.get(i)).uint32_max_evoke_count.get();
          localVideoInfo.i = ((oidb_0x6cf.BackOffGroupInfo)paramRspBody.rpt_back_off_group_info.get(i)).uint32_max_fresh_evoke_count.get();
        }
      }
    }
    if ((paramArticleSummary.bytes_article_summary.has()) && (paramArticleSummary.bytes_article_summary.get() != null)) {
      localVideoInfo.jdField_d_of_type_JavaLangString = paramArticleSummary.bytes_article_summary.get().toStringUtf8();
    }
    if ((paramArticleSummary.rpt_dislike_list.has()) && (paramArticleSummary.rpt_dislike_list.get() != null))
    {
      localObject1 = paramArticleSummary.rpt_dislike_list.get();
      label1176:
      label1183:
      label1190:
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        j = ((List)localObject1).size();
        localVideoInfo.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
        i = 0;
        label1127:
        if (i < j)
        {
          localObject5 = new DislikeInfo();
          ((DislikeInfo)localObject5).a((oidb_0x6cf.DisLikeInfo)((List)localObject1).get(i));
          if (TextUtils.isEmpty(((DislikeInfo)localObject5).jdField_a_of_type_JavaLangString)) {}
          for (;;)
          {
            i += 1;
            break label1127;
            i += 1;
            break;
            i += 1;
            break label615;
            i += 1;
            break label941;
            localVideoInfo.jdField_b_of_type_JavaUtilArrayList.add(localObject5);
          }
        }
      }
    }
    if ((paramArticleSummary.uint64_time.has()) && (paramArticleSummary.uint64_time.get() != 0L))
    {
      localVideoInfo.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(paramArticleSummary.uint64_time.get() * 1000L));
      localVideoInfo.jdField_a_of_type_Long = paramArticleSummary.uint64_time.get();
    }
    if ((paramArticleSummary.bytes_subscribe_id.has()) && (paramArticleSummary.bytes_subscribe_id.get() != null)) {
      localVideoInfo.jdField_j_of_type_JavaLangString = paramArticleSummary.bytes_subscribe_id.get().toStringUtf8();
    }
    if ((paramArticleSummary.bytes_subscribe_name.has()) && (paramArticleSummary.bytes_subscribe_name.get() != null)) {
      localVideoInfo.jdField_k_of_type_JavaLangString = paramArticleSummary.bytes_subscribe_name.get().toStringUtf8();
    }
    if ((paramArticleSummary.bytes_article_content_url.has()) && (paramArticleSummary.bytes_article_content_url.get() != null)) {
      localVideoInfo.jdField_f_of_type_JavaLangString = paramArticleSummary.bytes_article_content_url.get().toStringUtf8();
    }
    if (paramArticleSummary.uint32_strategy_id.has()) {
      localVideoInfo.jdField_r_of_type_Int = paramArticleSummary.uint32_strategy_id.get();
    }
    if (paramArticleSummary.uint64_algorithm_id.has()) {
      localVideoInfo.jdField_f_of_type_Long = paramArticleSummary.uint64_algorithm_id.get();
    }
    if ((paramArticleSummary.bytes_recommend_reason.has()) && (paramArticleSummary.bytes_recommend_reason.get() != null)) {
      localVideoInfo.jdField_h_of_type_JavaLangString = paramArticleSummary.bytes_recommend_reason.get().toStringUtf8();
    }
    if (paramArticleSummary.uint32_video_comment_count.has()) {
      localVideoInfo.jdField_e_of_type_Int = paramArticleSummary.uint32_video_comment_count.get();
    }
    if (paramArticleSummary.uint32_like_count.has()) {
      localVideoInfo.jdField_u_of_type_Int = paramArticleSummary.uint32_like_count.get();
    }
    if (paramArticleSummary.uint32_biu_count.has()) {
      localVideoInfo.jdField_f_of_type_Int = paramArticleSummary.uint32_biu_count.get();
    }
    if (paramArticleSummary.uint32_ads_guide_time.has()) {
      localVideoInfo.jdField_m_of_type_Int = paramArticleSummary.uint32_ads_guide_time.get();
    }
    if (paramArticleSummary.uint32_ads_jump_type.has()) {
      localVideoInfo.jdField_n_of_type_Int = paramArticleSummary.uint32_ads_jump_type.get();
    }
    if (paramArticleSummary.uint32_video_source_type.has())
    {
      if (paramArticleSummary.uint32_video_source_type.get() != 1) {
        break label3205;
      }
      bool = true;
    }
    label1690:
    label1721:
    label1862:
    long l;
    for (;;)
    {
      localVideoInfo.jdField_f_of_type_Boolean = bool;
      if ((paramArticleSummary.bytes_video_subscript_txt.has()) && (paramArticleSummary.bytes_video_subscript_txt.get() != null)) {
        localVideoInfo.L = paramArticleSummary.bytes_video_subscript_txt.get().toStringUtf8();
      }
      if ((paramArticleSummary.bytes_video_subscript_color.has()) && (paramArticleSummary.bytes_video_subscript_color.get() != null)) {
        localVideoInfo.M = paramArticleSummary.bytes_video_subscript_color.get().toStringUtf8();
      }
      if (paramArticleSummary.uint32_account_grade.has())
      {
        if (paramArticleSummary.uint32_account_grade.get() == 1)
        {
          bool = true;
          localVideoInfo.jdField_a_of_type_Boolean = bool;
        }
      }
      else
      {
        if (paramArticleSummary.uint32_myself_like_status.has())
        {
          if (paramArticleSummary.uint32_myself_like_status.get() != 1) {
            break label3217;
          }
          bool = true;
          localVideoInfo.jdField_l_of_type_Boolean = bool;
        }
        if (paramArticleSummary.bytes_video_report_info.has()) {
          localVideoInfo.N = a(paramArticleSummary.bytes_video_report_info);
        }
        if (paramArticleSummary.uint64_article_id.has()) {
          localVideoInfo.jdField_c_of_type_Long = paramArticleSummary.uint64_article_id.get();
        }
        if (paramArticleSummary.uint32_trigger_sec.has()) {
          localVideoInfo.jdField_q_of_type_Int = paramArticleSummary.uint32_trigger_sec.get();
        }
        if ((paramArticleSummary.msg_top_bar_info.has()) && (paramArticleSummary.msg_top_bar_info.get() != null))
        {
          localObject1 = paramArticleSummary.msg_top_bar_info;
          localObject5 = new VideoInfo.TopBarInfo();
          ((VideoInfo.TopBarInfo)localObject5).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = new UrlJumpInfo();
          if (!((oidb_0x6cf.TopBarInfo)localObject1).uint32_topbar_id.has()) {
            break label3223;
          }
          i = ((oidb_0x6cf.TopBarInfo)localObject1).uint32_topbar_id.get();
          ((VideoInfo.TopBarInfo)localObject5).jdField_a_of_type_Int = i;
          ((VideoInfo.TopBarInfo)localObject5).jdField_a_of_type_JavaLangString = a(((oidb_0x6cf.TopBarInfo)localObject1).bytes_icon_url);
          ((VideoInfo.TopBarInfo)localObject5).jdField_b_of_type_JavaLangString = a(((oidb_0x6cf.TopBarInfo)localObject1).bytes_title);
          ((VideoInfo.TopBarInfo)localObject5).jdField_d_of_type_JavaLangString = a(((oidb_0x6cf.TopBarInfo)localObject1).bytes_common_data);
          ((VideoInfo.TopBarInfo)localObject5).jdField_c_of_type_JavaLangString = a(((oidb_0x6cf.TopBarInfo)localObject1).bytes_background_url);
          ((VideoInfo.TopBarInfo)localObject5).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_JavaLangString = a(((oidb_0x6cf.TopBarInfo)localObject1).bytes_jump_url);
          localObject6 = ((VideoInfo.TopBarInfo)localObject5).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo;
          if (!((oidb_0x6cf.TopBarInfo)localObject1).uint32_jump_type.has()) {
            break label3228;
          }
          i = ((oidb_0x6cf.TopBarInfo)localObject1).uint32_jump_type.get();
          label1968:
          ((UrlJumpInfo)localObject6).jdField_a_of_type_Int = i;
          ((VideoInfo.TopBarInfo)localObject5).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_b_of_type_JavaLangString = a(((oidb_0x6cf.TopBarInfo)localObject1).bytes_ios_jump_bundle);
          ((VideoInfo.TopBarInfo)localObject5).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_c_of_type_JavaLangString = a(((oidb_0x6cf.TopBarInfo)localObject1).bytes_jump_schema);
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$TopBarInfo = ((VideoInfo.TopBarInfo)localObject5);
        }
        if ((paramArticleSummary.msg_download_bar_info.has()) && (paramArticleSummary.msg_download_bar_info.get() != null))
        {
          localObject1 = paramArticleSummary.msg_download_bar_info;
          localObject5 = new VideoInfo.DownloadBarInfo();
          ((VideoInfo.DownloadBarInfo)localObject5).jdField_a_of_type_JavaLangString = a(((oidb_0x6cf.DownloadBarInfo)localObject1).bytes_logo_url);
          if (!((oidb_0x6cf.DownloadBarInfo)localObject1).uint32_appear_time.has()) {
            break label3233;
          }
          i = ((oidb_0x6cf.DownloadBarInfo)localObject1).uint32_appear_time.get();
          label2084:
          ((VideoInfo.DownloadBarInfo)localObject5).jdField_a_of_type_Int = i;
          if (!((oidb_0x6cf.DownloadBarInfo)localObject1).uint32_button_bg_color.has()) {
            break label3238;
          }
          i = ((oidb_0x6cf.DownloadBarInfo)localObject1).uint32_button_bg_color.get();
          label2110:
          ((VideoInfo.DownloadBarInfo)localObject5).jdField_b_of_type_Int = i;
          ((VideoInfo.DownloadBarInfo)localObject5).jdField_b_of_type_JavaLangString = a(((oidb_0x6cf.DownloadBarInfo)localObject1).bytes_download_button_text);
          ((VideoInfo.DownloadBarInfo)localObject5).jdField_c_of_type_JavaLangString = a(((oidb_0x6cf.DownloadBarInfo)localObject1).bytes_open_button_text);
          ((VideoInfo.DownloadBarInfo)localObject5).jdField_d_of_type_JavaLangString = a(((oidb_0x6cf.DownloadBarInfo)localObject1).bytes_common_data);
          ((VideoInfo.DownloadBarInfo)localObject5).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = a(((oidb_0x6cf.DownloadBarInfo)localObject1).msg_url_jump_info);
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$DownloadBarInfo = ((VideoInfo.DownloadBarInfo)localObject5);
        }
        if ((!paramArticleSummary.json_video_list.has()) || (paramArticleSummary.json_video_list.get() == null)) {}
      }
      try
      {
        localVideoInfo.jdField_l_of_type_JavaLangString = paramArticleSummary.json_video_list.get().toStringUtf8();
        localObject1 = new JSONObject(paramArticleSummary.json_video_list.get().toStringUtf8()).getJSONArray("videos").optJSONObject(0);
        if (localObject1 != null)
        {
          localVideoInfo.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("vid");
          if (((JSONObject)localObject1).has("width")) {
            localVideoInfo.jdField_b_of_type_Int = ((JSONObject)localObject1).getInt("width");
          }
          if (((JSONObject)localObject1).has("height")) {
            localVideoInfo.jdField_c_of_type_Int = ((JSONObject)localObject1).getInt("height");
          }
          if (!((JSONObject)localObject1).has("duration")) {}
        }
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          label3205:
          label3217:
          label3223:
          label3228:
          label3233:
          label3238:
          do
          {
            localVideoInfo.jdField_d_of_type_Int = Integer.parseInt(((JSONObject)localObject1).optString("duration"));
            localVideoInfo.jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).optString("picture");
            if (((JSONObject)localObject1).has("innerUniqueID")) {
              localVideoInfo.jdField_g_of_type_JavaLangString = ((JSONObject)localObject1).optString("innerUniqueID");
            }
            localVideoInfo.jdField_a_of_type_Int = 1;
            if (((JSONObject)localObject1).has("busiType")) {
              localVideoInfo.jdField_a_of_type_Int = ((JSONObject)localObject1).getInt("busiType");
            }
            if (localVideoInfo.jdField_a_of_type_Int != 1)
            {
              localVideoInfo.D = ((JSONObject)localObject1).optString("thirdAction");
              localVideoInfo.E = ((JSONObject)localObject1).optString("thirdIcon");
              localVideoInfo.F = ((JSONObject)localObject1).optString("thirdUinName");
              if (!TextUtils.isEmpty(((JSONObject)localObject1).optString("thirdName"))) {
                localVideoInfo.jdField_k_of_type_JavaLangString = ((JSONObject)localObject1).optString("thirdName");
              }
              if (!TextUtils.isEmpty(((JSONObject)localObject1).optString("third_uin"))) {
                localVideoInfo.jdField_j_of_type_JavaLangString = ((JSONObject)localObject1).optString("third_uin");
              }
            }
            localObject1 = ((JSONObject)localObject1).optJSONArray("video_info");
            if (localObject1 != null)
            {
              i = 0;
              if (i < ((JSONArray)localObject1).length())
              {
                localObject3 = ((JSONArray)localObject1).optJSONObject(i);
                if (localObject3 == null) {
                  break label3281;
                }
                j = ((JSONObject)localObject3).optInt("network_type");
                l = ((JSONObject)localObject3).optLong("file_size");
                if (j != 2) {
                  break label3281;
                }
                localVideoInfo.jdField_b_of_type_Long = l;
              }
            }
            if ((paramArticleSummary.uint32_is_ugc.has()) && (paramArticleSummary.uint32_is_ugc.get() == 1))
            {
              localVideoInfo.jdField_b_of_type_Boolean = true;
              if ((paramArticleSummary.msg_ugc_feeds_info.has()) && (paramArticleSummary.msg_ugc_feeds_info.get() != null))
              {
                localObject1 = (oidb_0x6cf.UGCFeedsInfo)paramArticleSummary.msg_ugc_feeds_info.get();
                if ((((oidb_0x6cf.UGCFeedsInfo)localObject1).ugc_feeds_info.has()) && (((oidb_0x6cf.UGCFeedsInfo)localObject1).ugc_feeds_info.get() != null))
                {
                  localObject3 = (oidb_0x6cf.FeedsIdInfo)((oidb_0x6cf.UGCFeedsInfo)localObject1).ugc_feeds_info.get();
                  if (((oidb_0x6cf.FeedsIdInfo)localObject3).uint64_feeds_id.has()) {
                    localVideoInfo.jdField_d_of_type_Long = ((oidb_0x6cf.FeedsIdInfo)localObject3).uint64_feeds_id.get();
                  }
                  if (((oidb_0x6cf.FeedsIdInfo)localObject3).uint32_feeds_type.has()) {
                    localVideoInfo.jdField_k_of_type_Int = ((oidb_0x6cf.FeedsIdInfo)localObject3).uint32_feeds_type.get();
                  }
                }
                if (((oidb_0x6cf.UGCFeedsInfo)localObject1).uint32_follow_status.has())
                {
                  if (((oidb_0x6cf.UGCFeedsInfo)localObject1).uint32_follow_status.get() != 2) {
                    break label3288;
                  }
                  bool = true;
                  localVideoInfo.jdField_k_of_type_Boolean = bool;
                }
                if (((oidb_0x6cf.UGCFeedsInfo)localObject1).uint64_cuin.has()) {
                  localVideoInfo.jdField_j_of_type_JavaLangString = String.valueOf(((oidb_0x6cf.UGCFeedsInfo)localObject1).uint64_cuin.get());
                }
                if ((((oidb_0x6cf.UGCFeedsInfo)localObject1).msg_ugc_video_info_list.has()) && (((oidb_0x6cf.UGCFeedsInfo)localObject1).msg_ugc_video_info_list.get() != null))
                {
                  localObject1 = (oidb_0x6cf.UGCVideoInfo)((oidb_0x6cf.UGCFeedsInfo)localObject1).msg_ugc_video_info_list.get();
                  localVideoInfo.G = a(((oidb_0x6cf.UGCVideoInfo)localObject1).bytes_video_url);
                  localVideoInfo.jdField_b_of_type_JavaLangString = a(((oidb_0x6cf.UGCVideoInfo)localObject1).bytes_pic_url);
                  localVideoInfo.jdField_c_of_type_JavaLangString = a(((oidb_0x6cf.UGCVideoInfo)localObject1).bytes_title);
                  localVideoInfo.jdField_d_of_type_Int = ((int)(((oidb_0x6cf.UGCVideoInfo)localObject1).uint64_duration.get() / 1000L));
                  localVideoInfo.jdField_b_of_type_Int = ((oidb_0x6cf.UGCVideoInfo)localObject1).uint32_video_width.get();
                  localVideoInfo.jdField_c_of_type_Int = ((oidb_0x6cf.UGCVideoInfo)localObject1).uint32_video_height.get();
                  localVideoInfo.jdField_g_of_type_JavaLangString = a(((oidb_0x6cf.UGCVideoInfo)localObject1).bytes_uniq_id);
                  localVideoInfo.jdField_a_of_type_Long = ((oidb_0x6cf.UGCVideoInfo)localObject1).uint32_create_time.get();
                  localVideoInfo.jdField_f_of_type_JavaLangString = a(((oidb_0x6cf.UGCVideoInfo)localObject1).bytes_share_url);
                  localVideoInfo.jdField_a_of_type_Int = ((oidb_0x6cf.UGCVideoInfo)localObject1).uint32_busi_type.get();
                  localVideoInfo.jdField_a_of_type_JavaLangString = a(((oidb_0x6cf.UGCVideoInfo)localObject1).bytes_vid);
                }
              }
            }
            if ((!paramArticleSummary.rpt_label_list.has()) || (paramArticleSummary.rpt_label_list.get() == null)) {
              break label3312;
            }
            localObject3 = paramArticleSummary.rpt_label_list.get();
            if (((List)localObject3).size() > 0) {
              localVideoInfo.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
            }
            i = 0;
            for (;;)
            {
              if (i >= ((List)localObject3).size()) {
                break label3312;
              }
              localObject5 = (oidb_0x6cf.ChannelInfo)((List)localObject3).get(i);
              localObject6 = new VideoInfo.ChannelInfo();
              ((VideoInfo.ChannelInfo)localObject6).jdField_a_of_type_Int = ((oidb_0x6cf.ChannelInfo)localObject5).uint32_channel_id.get();
              ((VideoInfo.ChannelInfo)localObject6).jdField_b_of_type_Int = ((oidb_0x6cf.ChannelInfo)localObject5).uint32_channel_type.get();
              if (((oidb_0x6cf.ChannelInfo)localObject5).bytes_channel_name.get() == null) {
                break;
              }
              localObject1 = ((oidb_0x6cf.ChannelInfo)localObject5).bytes_channel_name.get().toStringUtf8();
              ((VideoInfo.ChannelInfo)localObject6).jdField_a_of_type_JavaLangString = ((String)localObject1);
              if (((oidb_0x6cf.ChannelInfo)localObject5).bytes_channel_display_name.get() == null) {
                break label3300;
              }
              localObject1 = ((oidb_0x6cf.ChannelInfo)localObject5).bytes_channel_display_name.get().toStringUtf8();
              ((VideoInfo.ChannelInfo)localObject6).jdField_b_of_type_JavaLangString = ((String)localObject1);
              if (((oidb_0x6cf.ChannelInfo)localObject5).bytes_channel_url.get() == null) {
                break label3306;
              }
              localObject1 = ((oidb_0x6cf.ChannelInfo)localObject5).bytes_channel_url.get().toStringUtf8();
              ((VideoInfo.ChannelInfo)localObject6).jdField_c_of_type_JavaLangString = ((String)localObject1);
              ((VideoInfo.ChannelInfo)localObject6).jdField_c_of_type_Int = ((oidb_0x6cf.ChannelInfo)localObject5).uint32_is_topic.get();
              localVideoInfo.jdField_a_of_type_JavaUtilArrayList.add(localObject6);
              i += 1;
            }
            bool = false;
            break;
            bool = false;
            break label1690;
            bool = false;
            break label1721;
            i = -1;
            break label1862;
            i = 0;
            break label1968;
            i = 0;
            break label2084;
            i = 0;
            break label2110;
            localJSONException1 = localJSONException1;
            localObject2 = localObject3;
          } while (!QLog.isColorLevel());
          QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, jsonVideoList 解析出错");
          localObject2 = localObject3;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          Object localObject2;
          for (;;)
          {
            localNumberFormatException.printStackTrace();
            continue;
            label3281:
            i += 1;
            continue;
            label3288:
            bool = false;
            continue;
            localObject2 = null;
            continue;
            label3300:
            localObject2 = null;
            continue;
            label3306:
            localObject2 = null;
          }
          label3312:
          Object localObject4;
          if ((paramArticleSummary.msg_feeds_info.has()) && (((oidb_0x6cf.FeedsInfo)paramArticleSummary.msg_feeds_info.get()).feeds_type.get() == 1))
          {
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo = new VideoAdInfo(this.jdField_a_of_type_Long, (oidb_0x6cf.PosAdInfo)((oidb_0x6cf.FeedsInfo)paramArticleSummary.msg_feeds_info.get()).msg_pos_ad_info.get());
            if (((oidb_0x6cf.FeedsInfo)paramArticleSummary.msg_feeds_info.get()).rpt_msg_neg_feedback.has()) {
              localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.a(((oidb_0x6cf.FeedsInfo)paramArticleSummary.msg_feeds_info.get()).rpt_msg_neg_feedback.get());
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList recv adInfo=" + localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.toString());
            }
            localVideoInfo.jdField_c_of_type_Boolean = true;
            i = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_g_of_type_Int;
            if (i == 65)
            {
              localVideoInfo.jdField_l_of_type_Int = 2;
              if (!a(localVideoInfo))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList isInvalidImageAd traceID=" + localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_h_of_type_JavaLangString);
                }
                return null;
              }
            }
            else if ((i == 185) || (i == 350) || (i == 450) || (i == 1122))
            {
              localVideoInfo.jdField_l_of_type_Int = 1;
              if (!a(localVideoInfo))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList isInvalidVideoAd traceID=" + localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_h_of_type_JavaLangString);
                }
                return null;
              }
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList isUnknownTypeAd traceID=" + localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_h_of_type_JavaLangString);
              }
              return null;
            }
            localObject2 = nmf.a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
            if (oat.a(null, localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)) {
              localObject4 = new JSONObject();
            }
          }
          try
          {
            ((JSONObject)localObject4).put("svrresp_result", 0);
            ((JSONObject)localObject4).put("svrresp_count", 1);
            nmf.a(new nyg().a(BaseApplication.getContext()).a(nmf.jdField_k_of_type_Int).b(nmf.T).a((AdvertisementInfo)localObject2).a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).b((JSONObject)localObject4).a());
            oau.a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
            if ((paramArticleSummary.bytes_recommend_barrage_text_list.has()) && (paramArticleSummary.bytes_recommend_barrage_text_list.get() != null))
            {
              localObject2 = paramArticleSummary.bytes_recommend_barrage_text_list.get().iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject4 = (ByteStringMicro)((Iterator)localObject2).next();
                localVideoInfo.jdField_c_of_type_JavaUtilArrayList.add(((ByteStringMicro)localObject4).toStringUtf8());
              }
            }
          }
          catch (JSONException localJSONException2)
          {
            for (;;)
            {
              localJSONException2.printStackTrace();
            }
            localVideoInfo.J = a(paramArticleSummary.bytes_video_logo_url);
            if (paramArticleSummary.msg_account_v_info.has()) {
              localVideoInfo.K = a(paramArticleSummary.msg_account_v_info.bytes_v_icon_url);
            }
            if (paramArticleSummary.msg_like_download_bar_info.has())
            {
              localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar = new VideoInfo.LikeActionDownloadBar();
              localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_b_of_type_JavaLangString = a(paramArticleSummary.msg_like_download_bar_info.bytes_bar_text);
              localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_a_of_type_JavaLangString = a(paramArticleSummary.msg_like_download_bar_info.bytes_icon_url);
              localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_c_of_type_JavaLangString = a(paramArticleSummary.msg_like_download_bar_info.bytes_common_data);
              localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = new UrlJumpInfo();
              localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_Int = ((oidb_0x6cf.UrlJumpInfo)paramArticleSummary.msg_like_download_bar_info.msg_url_jump_info.get()).uint32_jump_type.get();
              localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_b_of_type_JavaLangString = a(((oidb_0x6cf.UrlJumpInfo)paramArticleSummary.msg_like_download_bar_info.msg_url_jump_info.get()).bytes_jump_bundle);
              localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_c_of_type_JavaLangString = a(((oidb_0x6cf.UrlJumpInfo)paramArticleSummary.msg_like_download_bar_info.msg_url_jump_info.get()).bytes_jump_schema);
              localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_JavaLangString = a(((oidb_0x6cf.UrlJumpInfo)paramArticleSummary.msg_like_download_bar_info.msg_url_jump_info.get()).bytes_jump_url);
              localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_d_of_type_JavaLangString = a(((oidb_0x6cf.UrlJumpInfo)paramArticleSummary.msg_like_download_bar_info.msg_url_jump_info.get()).bytes_clipboard_info);
            }
            if (paramArticleSummary.msg_soft_ad_download_bar_info.has())
            {
              localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo = new VideoInfo.SoftAdDownloadBarInfo();
              localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_JavaLangString = a(paramArticleSummary.msg_soft_ad_download_bar_info.bytes_title);
              localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_b_of_type_JavaLangString = a(paramArticleSummary.msg_soft_ad_download_bar_info.bytes_sub_title);
              localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_c_of_type_JavaLangString = a(paramArticleSummary.msg_soft_ad_download_bar_info.bytes_small_icon_url);
              localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_d_of_type_JavaLangString = a(paramArticleSummary.msg_soft_ad_download_bar_info.bytes_big_icon_url);
              localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_Int = paramArticleSummary.msg_soft_ad_download_bar_info.uint32_change_bigger_position.get();
              localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = a(paramArticleSummary.msg_soft_ad_download_bar_info.msg_url_jump_info);
            }
            if ((localVideoInfo.jdField_c_of_type_Boolean) && (localVideoInfo.jdField_l_of_type_Int == 2)) {
              return null;
            }
            if (paramArticleSummary.msg_ecommerce_entrance_info.has())
            {
              localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo = new VideoInfo.ECommerceEntranceInfo();
              localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_JavaLangString = a(paramArticleSummary.msg_ecommerce_entrance_info.bytes_title);
              localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_b_of_type_JavaLangString = a(paramArticleSummary.msg_ecommerce_entrance_info.bytes_subtitle);
              localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_c_of_type_JavaLangString = a(paramArticleSummary.msg_ecommerce_entrance_info.bytes_thumbnail_url);
              localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_d_of_type_JavaLangString = a(paramArticleSummary.msg_ecommerce_entrance_info.bytes_link_icon_url);
              if (paramArticleSummary.msg_ecommerce_entrance_info.uint32_jump_type.has()) {
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_Int = paramArticleSummary.msg_ecommerce_entrance_info.uint32_jump_type.get();
              }
              if (paramArticleSummary.msg_ecommerce_entrance_info.uint32_ecommerce_id.has()) {
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_g_of_type_Int = paramArticleSummary.msg_ecommerce_entrance_info.uint32_ecommerce_id.get();
              }
              if (paramArticleSummary.msg_ecommerce_entrance_info.uint32_display_count_ver.has()) {
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_d_of_type_Int = paramArticleSummary.msg_ecommerce_entrance_info.uint32_display_count_ver.get();
              }
              if (paramArticleSummary.msg_ecommerce_entrance_info.uint32_one_day_max_display_count.has()) {
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_f_of_type_Int = paramArticleSummary.msg_ecommerce_entrance_info.uint32_one_day_max_display_count.get();
              }
              if (paramArticleSummary.msg_ecommerce_entrance_info.uint32_session_max_display_count.has()) {
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_e_of_type_Int = paramArticleSummary.msg_ecommerce_entrance_info.uint32_session_max_display_count.get();
              }
              localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_e_of_type_JavaLangString = a(paramArticleSummary.msg_ecommerce_entrance_info.bytes_jump_url);
              localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_f_of_type_JavaLangString = a(paramArticleSummary.msg_ecommerce_entrance_info.bytes_common_data);
              localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_c_of_type_Int = paramArticleSummary.msg_ecommerce_entrance_info.video_play_length.get();
              localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int = paramArticleSummary.msg_ecommerce_entrance_info.uint32_style.get();
              if (paramArticleSummary.msg_ecommerce_entrance_info.appInfo.has())
              {
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = new UrlJumpInfo();
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_Int = ((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).uint32_jump_type.get();
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_b_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_jump_bundle);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_c_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_jump_schema);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_jump_url);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_d_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_clipboard_info);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_app_open_wording);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_g_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_app_download_wording);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_b_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_app_desc);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_c_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_icon_url);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_name);
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "commerceEntranceInfo: " + localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.toString());
              }
            }
            if ((paramRspBody.msg_ecommerce_entrance_config.has()) && (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo != null) && (paramRspBody.msg_ecommerce_entrance_config.uint32_show_after_play_time.has())) {
              localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jdField_b_of_type_Int = paramRspBody.msg_ecommerce_entrance_config.uint32_show_after_play_time.get();
            }
            localVideoInfo.O = a(paramArticleSummary.bytes_avatar_jump_url);
            if (!paramArticleSummary.uint64_recommend_seq.has()) {
              break label5420;
            }
          }
          l = paramArticleSummary.uint64_recommend_seq.get();
        }
      }
    }
    localVideoInfo.jdField_e_of_type_Long = l;
    if (paramArticleSummary.uint32_is_first_page_use_gif.has())
    {
      if (paramArticleSummary.uint32_is_first_page_use_gif.get() == 1)
      {
        bool = true;
        label5093:
        localVideoInfo.jdField_g_of_type_Boolean = bool;
      }
    }
    else
    {
      localVideoInfo.H = a(paramArticleSummary.bytes_first_page_gif_url);
      if (paramArticleSummary.uint32_is_no_show_cover.has())
      {
        if (paramArticleSummary.uint32_is_no_show_cover.get() != 0) {
          break label5432;
        }
        bool = true;
        label5136:
        localVideoInfo.jdField_h_of_type_Boolean = bool;
      }
      qol.a(localVideoInfo);
      nml.a(paramArticleSummary, localVideoInfo);
      if (paramArticleSummary.video_column_info.has())
      {
        paramRspBody = new VideoColumnInfo();
        paramRspBody.jdField_a_of_type_Int = paramArticleSummary.video_column_info.uint32_column_id.get();
        paramRspBody.jdField_a_of_type_JavaLangString = a(paramArticleSummary.video_column_info.bytes_column_name);
        paramRspBody.jdField_b_of_type_JavaLangString = a(paramArticleSummary.video_column_info.bytes_column_icon_url);
        paramRspBody.jdField_c_of_type_Int = paramArticleSummary.video_column_info.uint32_subscribe_count.get();
        if (paramArticleSummary.video_column_info.uint32_is_subscribed.get() != 1) {
          break label5438;
        }
      }
    }
    label5420:
    label5432:
    label5438:
    for (boolean bool = true;; bool = false)
    {
      paramRspBody.jdField_a_of_type_Boolean = bool;
      paramRspBody.jdField_f_of_type_JavaLangString = a(paramArticleSummary.video_column_info.bytes_app_name);
      paramRspBody.jdField_g_of_type_JavaLangString = a(paramArticleSummary.video_column_info.bytes_app_icon_url);
      paramRspBody.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = a(paramArticleSummary.video_column_info.subscribe_jump_info);
      paramRspBody.d = a(paramArticleSummary.video_column_info.app_jump_info);
      paramRspBody.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = a(paramArticleSummary.video_column_info.default_jump_info);
      localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo = paramRspBody;
      if (paramArticleSummary.msg_fusion_biu_info.has())
      {
        paramRspBody = new FusionBiuInfo();
        paramRspBody.jdField_b_of_type_Boolean = paramArticleSummary.msg_fusion_biu_info.bool_is_biu.get();
        paramRspBody.jdField_a_of_type_Boolean = paramArticleSummary.msg_fusion_biu_info.bool_is_gray.get();
        paramRspBody.jdField_a_of_type_Long = paramArticleSummary.msg_fusion_biu_info.uint64_feeds_id.get();
        paramRspBody.jdField_a_of_type_Int = paramArticleSummary.msg_fusion_biu_info.uint32_biu_count.get();
        localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo = paramRspBody;
      }
      return localVideoInfo;
      l = 0L;
      break;
      bool = false;
      break label5093;
      bool = false;
      break label5136;
    }
  }
  
  public void a(npw paramnpw, int paramInt1, VideoInfo paramVideoInfo, String paramString, int paramInt2)
  {
    if (paramVideoInfo == null) {
      return;
    }
    ThreadManagerV2.executeOnSubThread(new VideoPlayRecommendHandler.6(this, paramInt2, paramInt1, paramVideoInfo, paramString, paramnpw));
  }
  
  public void a(npw paramnpw, long paramLong1, VideoInfo paramVideoInfo, int paramInt1, ArrayList<VideoInfo> paramArrayList1, String paramString1, long paramLong2, boolean paramBoolean, int paramInt2, String paramString2, String paramString3, WeishiRedDotInfo paramWeishiRedDotInfo, int paramInt3, String paramString4, byte[] paramArrayOfByte, int paramInt4, int paramInt5, ArrayList<VideoInfo> paramArrayList2)
  {
    if (paramVideoInfo == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 4, "getRecommendList()  videoInfo == null, RETURN");
      }
      return;
    }
    ThreadManager.post(new VideoPlayRecommendHandler.3(this, paramnpw, paramLong1, paramVideoInfo, paramInt1, paramArrayList1, paramString1, paramLong2, paramBoolean, paramInt2, paramString2, paramString3, paramWeishiRedDotInfo, paramInt3, paramString4, paramArrayOfByte, paramInt4, paramInt5, paramArrayList2), 5, null, true);
  }
  
  public void a(npw paramnpw, long paramLong1, VideoInfo paramVideoInfo, int paramInt1, ArrayList<VideoInfo> paramArrayList1, String paramString1, long paramLong2, boolean paramBoolean, int paramInt2, String paramString2, String paramString3, WeishiRedDotInfo paramWeishiRedDotInfo, int paramInt3, String paramString4, byte[] paramArrayOfByte, int paramInt4, ArrayList<VideoInfo> paramArrayList2)
  {
    if (paramVideoInfo == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 4, "getRecommendList()  videoInfo == null, RETURN");
      }
      return;
    }
    ThreadManager.post(new VideoPlayRecommendHandler.1(this, paramnpw, paramLong1, paramVideoInfo, paramInt1, paramArrayList1, paramString1, paramLong2, paramBoolean, paramInt2, paramString2, paramString3, paramWeishiRedDotInfo, paramInt3, paramString4, paramArrayOfByte, paramInt4, paramArrayList2), 5, null, true);
  }
  
  public void a(npw paramnpw, long paramLong1, VideoInfo paramVideoInfo, int paramInt1, ArrayList<VideoInfo> paramArrayList1, String paramString1, long paramLong2, boolean paramBoolean, int paramInt2, String paramString2, String paramString3, WeishiRedDotInfo paramWeishiRedDotInfo, int paramInt3, String paramString4, byte[] paramArrayOfByte, ArrayList<VideoInfo.AdTagInfo> paramArrayList, int paramInt4, int paramInt5, int paramInt6, ArrayList<VideoInfo> paramArrayList2)
  {
    if (paramVideoInfo == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 4, "getRecommendList()  videoInfo == null, RETURN");
      }
      return;
    }
    ThreadManager.post(new VideoPlayRecommendHandler.2(this, paramArrayList, paramnpw, paramLong1, paramVideoInfo, paramInt1, paramArrayList1, paramString1, paramLong2, paramBoolean, paramInt2, paramString2, paramString3, paramWeishiRedDotInfo, paramInt3, paramString4, paramArrayOfByte, paramInt4, paramInt5, paramInt6, paramArrayList2), 5, null, true);
  }
  
  public void a(npw paramnpw, long paramLong, String paramString, int paramInt, VideoInfo paramVideoInfo)
  {
    ThreadManager.post(new VideoPlayRecommendHandler.4(this, paramLong, paramInt, paramString, paramnpw, paramVideoInfo), 5, null, true);
  }
  
  public void a(npw paramnpw, String paramString, int paramInt, boolean paramBoolean)
  {
    oidb_0x6cf.ReqBody localReqBody = new oidb_0x6cf.ReqBody();
    localReqBody.uint32_req_source.set(16);
    if (!TextUtils.isEmpty(paramString)) {
      localReqBody.bytes_cookie.set(ByteStringMicro.copyFromUtf8(paramString));
    }
    localReqBody.uint32_req_sub_source.set(paramInt);
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      localReqBody.uint32_has_cache_pre_video.set(paramInt);
      localReqBody.uint32_req_sim_type.set(bhvh.c());
      if (qol.e())
      {
        int i = qjn.a().a();
        localReqBody.uint32_entrance_one_day_display_count.set(i);
      }
      paramString = pow.a("OidbSvc.0x6cf", 1743, 1, localReqBody.toByteArray());
      paramString.addAttribute("is_from_first_recommend_video", Boolean.valueOf(true));
      paramString.addAttribute("VALUE_OBSERVER_TAG", Integer.valueOf(paramnpw.hashCode()));
      sendPbReq(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "has cache pre video: " + paramInt);
      }
      return;
    }
  }
  
  protected Class<? extends ajtg> observerClass()
  {
    return npw.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     npv
 * JD-Core Version:    0.7.0.1
 */