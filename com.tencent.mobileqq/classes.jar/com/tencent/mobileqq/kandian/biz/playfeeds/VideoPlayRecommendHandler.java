package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdExposeFreshService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdReqFreshService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdSwitchService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJVideoAdService;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.UGDownloadInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.AdTagInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.DownloadBarInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.ECommerceEntranceInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.EntranceDownloadInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.InterruptedWeishiAd;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.LikeActionDownloadBar;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.LocationInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.SoftAdDownloadBarInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.SubscriptInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.TopBarInfo;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayRecommendConstants;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayRecommendHelper;
import com.tencent.mobileqq.kandian.repo.ad.SmallMiniGameInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.WeishiRedDotInfo;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RichTitleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.AccountVInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.AppAdInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ArticleSummary;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.BiuMultiLevel;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.BiuOneLevelItem;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.DisLikeInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.DownloadBarInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ECommerceEntranceInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.EntranceDownloadInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.FeedsIdInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.FeedsInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.InterruptedWeishiAd;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.JumpInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.LikeDownloadBarInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.PkgInstallInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.PosAdInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.PositionInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ReqBody;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.RspBody;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.SoftAdDownloadBarInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.SubscriptInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.TopBarInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.UGCFeedsInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.UGCVideoInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.UrlJumpInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.VideoColumnInfo;
import tencent.im.oidb.cmd0x885.oidb_0x885.AdTagInfo;

public class VideoPlayRecommendHandler
  extends BusinessHandler
  implements VideoPlayRecommendConstants
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = { "com.tencent.reading", "com.tencent.rijvideo", "com.tencent.weishi" };
  
  public VideoPlayRecommendHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public VideoPlayRecommendHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public static int a()
  {
    return VideoPlayRecommendHelper.a();
  }
  
  private VideoInfo.ECommerceEntranceInfo a(oidb_0x6cf.InterruptedWeishiAd paramInterruptedWeishiAd, oidb_0x6cf.RspBody paramRspBody)
  {
    VideoInfo.ECommerceEntranceInfo localECommerceEntranceInfo1;
    if (paramInterruptedWeishiAd.msg_ecommerce_entrance_info.has())
    {
      VideoInfo.ECommerceEntranceInfo localECommerceEntranceInfo2 = new VideoInfo.ECommerceEntranceInfo();
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
        localECommerceEntranceInfo2.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo = new UrlJumpInfo();
        localECommerceEntranceInfo2.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_a_of_type_Int = ((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).uint32_jump_type.get();
        localECommerceEntranceInfo2.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_b_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_jump_bundle);
        localECommerceEntranceInfo2.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_c_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_jump_schema);
        localECommerceEntranceInfo2.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_a_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_jump_url);
        localECommerceEntranceInfo2.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_d_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_clipboard_info);
        localECommerceEntranceInfo2.jdField_h_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_app_open_wording);
        localECommerceEntranceInfo2.jdField_g_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_app_download_wording);
        localECommerceEntranceInfo2.jdField_b_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_app_desc);
        localECommerceEntranceInfo2.jdField_c_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_icon_url);
        localECommerceEntranceInfo2.jdField_a_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_name);
        localECommerceEntranceInfo1 = localECommerceEntranceInfo2;
      }
    }
    else
    {
      localECommerceEntranceInfo1 = null;
    }
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
        label691:
        i += 1;
        continue;
        if (QLog.isColorLevel())
        {
          paramInterruptedWeishiAd = new StringBuilder();
          paramInterruptedWeishiAd.append("get commerceEntranceInfo in config: ");
          paramInterruptedWeishiAd.append(localECommerceEntranceInfo1.toString());
          QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, paramInterruptedWeishiAd.toString());
        }
        return localECommerceEntranceInfo1;
      }
      catch (Exception paramRspBody)
      {
        break label691;
      }
    }
  }
  
  private VideoInfo a(oidb_0x6cf.ArticleSummary paramArticleSummary, oidb_0x6cf.RspBody paramRspBody)
  {
    VideoInfo localVideoInfo = b(paramArticleSummary, paramRspBody);
    int j;
    int i;
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
        localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd = new VideoInfo.InterruptedWeishiAd();
        localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.jdField_a_of_type_JavaLangString = a(paramRspBody.bytes_ad_url);
        paramArticleSummary = localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd;
        boolean bool1 = paramRspBody.uint32_is_show_in_play_end.has();
        boolean bool2 = true;
        j = 0;
        if ((bool1) && (paramRspBody.uint32_is_show_in_play_end.get() == 1)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        paramArticleSummary.jdField_b_of_type_Boolean = bool1;
        paramArticleSummary = localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd;
        if ((paramRspBody.uint32_is_show_in_switch.has()) && (paramRspBody.uint32_is_show_in_switch.get() == 1)) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
        paramArticleSummary.jdField_a_of_type_Boolean = bool1;
        paramArticleSummary = localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd;
        if (paramRspBody.uint32_show_after_play_time.has()) {
          i = paramRspBody.uint32_show_after_play_time.get();
        } else {
          i = -1;
        }
        paramArticleSummary.jdField_a_of_type_Int = i;
        paramArticleSummary = a(paramRspBody.bytes_show_positon);
        if (paramArticleSummary != null) {
          paramArticleSummary = paramArticleSummary.split(",");
        } else {
          paramArticleSummary = null;
        }
        if ((paramArticleSummary != null) && (paramArticleSummary.length > 0))
        {
          localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.jdField_a_of_type_ArrayOfInt = new int[paramArticleSummary.length];
          i = 0;
        }
      }
    }
    for (;;)
    {
      if (i < paramArticleSummary.length) {}
      try
      {
        localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.jdField_a_of_type_ArrayOfInt[i] = Integer.parseInt(paramArticleSummary[i]);
        label343:
        i += 1;
        continue;
        paramArticleSummary = localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd;
        i = j;
        if (paramRspBody.uint32_interrupted_ad_type.has()) {
          i = paramRspBody.uint32_interrupted_ad_type.get();
        }
        paramArticleSummary.jdField_b_of_type_Int = i;
        if (paramRspBody.appInfo.has())
        {
          localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.jdField_d_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_app_download_wording);
          localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.jdField_e_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_app_open_wording);
          localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.jdField_b_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_name);
          localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.jdField_c_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_icon_url);
          localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo = new UrlJumpInfo();
          localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_a_of_type_Int = ((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).uint32_jump_type.get();
          localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_b_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_jump_bundle);
          localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_c_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_jump_schema);
          localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_a_of_type_JavaLangString = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_jump_url);
        }
        return localVideoInfo;
      }
      catch (Exception localException)
      {
        break label343;
      }
    }
  }
  
  private String a(PBBytesField paramPBBytesField)
  {
    if ((paramPBBytesField.has()) && (paramPBBytesField.get() != null)) {
      return paramPBBytesField.get().toStringUtf8();
    }
    return null;
  }
  
  private oidb_0x6cf.PositionInfo a()
  {
    if (ContextCompat.checkSelfPermission(BaseApplicationImpl.getContext(), "android.permission.ACCESS_FINE_LOCATION") == 0)
    {
      SosoLbsInfo localSosoLbsInfo = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("readinjoy_anti_cheating");
      if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null))
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getPositionInfo() latitude=");
          ((StringBuilder)localObject).append(localSosoLbsInfo.mLocation.mLat02);
          ((StringBuilder)localObject).append(", longitude=");
          ((StringBuilder)localObject).append(localSosoLbsInfo.mLocation.mLon02);
          QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, ((StringBuilder)localObject).toString());
        }
        if ((localSosoLbsInfo.mLocation.mLat02 != 0.0D) && (localSosoLbsInfo.mLocation.mLon02 != 0.0D))
        {
          localObject = new oidb_0x6cf.PositionInfo();
          ((oidb_0x6cf.PositionInfo)localObject).latitude.set((int)(localSosoLbsInfo.mLocation.mLat02 * 1000000.0D));
          ((oidb_0x6cf.PositionInfo)localObject).longitude.set((int)(localSosoLbsInfo.mLocation.mLon02 * 1000000.0D));
          return localObject;
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getPositionInfo() permission not granted");
    }
    return null;
  }
  
  /* Error */
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 399	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +13 -> 17
    //   7: aload_3
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore 5
    //   14: goto +6 -> 20
    //   17: iconst_0
    //   18: istore 5
    //   20: new 401	android/os/Bundle
    //   23: dup
    //   24: invokespecial 402	android/os/Bundle:<init>	()V
    //   27: astore 11
    //   29: invokestatic 227	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   32: ifeq +36 -> 68
    //   35: new 229	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   42: astore_2
    //   43: aload_2
    //   44: ldc_w 404
    //   47: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_2
    //   52: iload 5
    //   54: invokevirtual 407	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: ldc 242
    //   60: iconst_2
    //   61: aload_2
    //   62: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: aload_1
    //   69: ldc_w 409
    //   72: iconst_0
    //   73: invokestatic 415	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   76: invokevirtual 421	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   79: checkcast 411	java/lang/Boolean
    //   82: invokevirtual 424	java/lang/Boolean:booleanValue	()Z
    //   85: istore 7
    //   87: iload 5
    //   89: ifeq +1334 -> 1423
    //   92: new 426	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   95: dup
    //   96: invokespecial 427	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   99: astore_2
    //   100: aload_2
    //   101: aload_3
    //   102: checkcast 429	[B
    //   105: checkcast 429	[B
    //   108: invokevirtual 433	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   111: pop
    //   112: aload_2
    //   113: getfield 436	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   116: invokevirtual 90	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   119: istore 6
    //   121: iload 6
    //   123: ifeq +42 -> 165
    //   126: aload_2
    //   127: getfield 436	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   130: invokevirtual 93	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   133: bipush 83
    //   135: if_icmpne +30 -> 165
    //   138: invokestatic 227	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq +12 -> 153
    //   144: ldc 242
    //   146: iconst_2
    //   147: ldc_w 438
    //   150: invokestatic 256	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   153: aload 11
    //   155: ldc_w 440
    //   158: iconst_1
    //   159: invokevirtual 444	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   162: goto +12 -> 174
    //   165: aload 11
    //   167: ldc_w 440
    //   170: iconst_0
    //   171: invokevirtual 444	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   174: aload_2
    //   175: getfield 447	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   178: invokevirtual 267	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   181: invokevirtual 451	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   184: astore_2
    //   185: new 187	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody
    //   188: dup
    //   189: invokespecial 452	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:<init>	()V
    //   192: astore 12
    //   194: aload 12
    //   196: aload_2
    //   197: invokevirtual 453	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   200: pop
    //   201: aload 12
    //   203: getfield 456	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:uint64_pos_ad_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   206: invokevirtual 280	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   209: ifeq +15 -> 224
    //   212: aload_0
    //   213: aload 12
    //   215: getfield 456	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:uint64_pos_ad_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   218: invokevirtual 283	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   221: putfield 458	com/tencent/mobileqq/kandian/biz/playfeeds/VideoPlayRecommendHandler:jdField_a_of_type_Long	J
    //   224: aload 12
    //   226: getfield 461	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:bytes_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   229: invokevirtual 264	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   232: ifeq +33 -> 265
    //   235: aload 12
    //   237: getfield 461	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:bytes_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   240: invokevirtual 267	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   243: ifnull +22 -> 265
    //   246: aload 11
    //   248: ldc_w 463
    //   251: aload 12
    //   253: getfield 461	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:bytes_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   256: invokevirtual 267	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   259: invokevirtual 272	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   262: invokevirtual 467	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   265: aload 12
    //   267: getfield 470	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:bytes_ads_context	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   270: invokevirtual 264	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   273: ifeq +1324 -> 1597
    //   276: aload 12
    //   278: getfield 470	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:bytes_ads_context	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   281: invokevirtual 267	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   284: invokevirtual 272	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   287: astore 10
    //   289: iconst_1
    //   290: istore 4
    //   292: goto +3 -> 295
    //   295: aload_0
    //   296: getfield 472	com/tencent/mobileqq/kandian/biz/playfeeds/VideoPlayRecommendHandler:jdField_a_of_type_JavaTextSimpleDateFormat	Ljava/text/SimpleDateFormat;
    //   299: ifnonnull +17 -> 316
    //   302: aload_0
    //   303: new 474	java/text/SimpleDateFormat
    //   306: dup
    //   307: ldc_w 476
    //   310: invokespecial 479	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   313: putfield 472	com/tencent/mobileqq/kandian/biz/playfeeds/VideoPlayRecommendHandler:jdField_a_of_type_JavaTextSimpleDateFormat	Ljava/text/SimpleDateFormat;
    //   316: iload 7
    //   318: ifne +1008 -> 1326
    //   321: aload 12
    //   323: getfield 483	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:rpt_article_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   326: invokevirtual 486	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   329: ifeq +552 -> 881
    //   332: aload 12
    //   334: getfield 483	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:rpt_article_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   337: invokevirtual 489	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   340: ifnull +541 -> 881
    //   343: aload 12
    //   345: getfield 483	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:rpt_article_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   348: invokevirtual 489	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   351: astore 9
    //   353: aload 9
    //   355: ifnull +449 -> 804
    //   358: aload 9
    //   360: invokeinterface 493 1 0
    //   365: ifne +439 -> 804
    //   368: new 495	java/util/ArrayList
    //   371: dup
    //   372: aload 9
    //   374: invokeinterface 498 1 0
    //   379: invokespecial 501	java/util/ArrayList:<init>	(I)V
    //   382: astore_2
    //   383: new 495	java/util/ArrayList
    //   386: dup
    //   387: aload_2
    //   388: invokevirtual 502	java/util/ArrayList:size	()I
    //   391: invokespecial 501	java/util/ArrayList:<init>	(I)V
    //   394: astore 8
    //   396: invokestatic 227	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   399: istore 6
    //   401: iload 6
    //   403: ifeq +52 -> 455
    //   406: new 229	java/lang/StringBuilder
    //   409: dup
    //   410: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   413: astore_3
    //   414: aload_3
    //   415: ldc_w 504
    //   418: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: aload_3
    //   423: aload 9
    //   425: invokeinterface 498 1 0
    //   430: invokevirtual 507	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   433: pop
    //   434: ldc 242
    //   436: iconst_2
    //   437: aload_3
    //   438: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   444: goto +11 -> 455
    //   447: astore_3
    //   448: goto +4 -> 452
    //   451: astore_3
    //   452: goto +909 -> 1361
    //   455: ldc_w 509
    //   458: invokestatic 344	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   461: checkcast 509	com/tencent/mobileqq/kandian/ad/api/IRIJAdLogService
    //   464: astore 13
    //   466: new 229	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   473: astore 14
    //   475: aload_2
    //   476: astore_3
    //   477: aload 14
    //   479: ldc_w 511
    //   482: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: pop
    //   486: aload_2
    //   487: astore_3
    //   488: aload 14
    //   490: aload 9
    //   492: invokeinterface 498 1 0
    //   497: invokevirtual 507	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload_2
    //   502: astore_3
    //   503: aload 13
    //   505: ldc_w 513
    //   508: aload 14
    //   510: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: invokeinterface 515 3 0
    //   518: aload_2
    //   519: astore_3
    //   520: aload 9
    //   522: invokeinterface 519 1 0
    //   527: astore 13
    //   529: aload_2
    //   530: astore_3
    //   531: aload 13
    //   533: invokeinterface 524 1 0
    //   538: ifeq +233 -> 771
    //   541: aload_2
    //   542: astore_3
    //   543: aload 13
    //   545: invokeinterface 528 1 0
    //   550: checkcast 258	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary
    //   553: astore 9
    //   555: aload_0
    //   556: aload 9
    //   558: aload 12
    //   560: invokespecial 249	com/tencent/mobileqq/kandian/biz/playfeeds/VideoPlayRecommendHandler:b	(Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary;Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody;)Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo;
    //   563: astore_3
    //   564: aload_3
    //   565: ifnull +144 -> 709
    //   568: invokestatic 227	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   571: ifeq +42 -> 613
    //   574: new 229	java/lang/StringBuilder
    //   577: dup
    //   578: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   581: astore 9
    //   583: aload 9
    //   585: ldc_w 530
    //   588: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: pop
    //   592: aload 9
    //   594: aload_3
    //   595: invokevirtual 532	com/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo:e	()Ljava/lang/String;
    //   598: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: pop
    //   602: ldc 242
    //   604: iconst_2
    //   605: aload 9
    //   607: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   610: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   613: aload_2
    //   614: aload_3
    //   615: invokevirtual 536	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   618: pop
    //   619: aload 8
    //   621: aload_3
    //   622: getfield 539	com/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   625: invokevirtual 536	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   628: pop
    //   629: ldc_w 509
    //   632: invokestatic 344	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   635: checkcast 509	com/tencent/mobileqq/kandian/ad/api/IRIJAdLogService
    //   638: astore 9
    //   640: new 229	java/lang/StringBuilder
    //   643: dup
    //   644: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   647: astore 14
    //   649: aload 14
    //   651: ldc_w 541
    //   654: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: pop
    //   658: aload 14
    //   660: aload_3
    //   661: getfield 544	com/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo:jdField_r_of_type_Boolean	Z
    //   664: invokevirtual 407	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   667: pop
    //   668: aload 14
    //   670: ldc_w 546
    //   673: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: pop
    //   677: aload 14
    //   679: aload_3
    //   680: getfield 252	com/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   683: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: pop
    //   687: aload 9
    //   689: ldc_w 513
    //   692: aload 14
    //   694: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   697: invokeinterface 515 3 0
    //   702: goto +59 -> 761
    //   705: astore_3
    //   706: goto +7 -> 713
    //   709: goto +52 -> 761
    //   712: astore_3
    //   713: aload_2
    //   714: astore 9
    //   716: invokestatic 227	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   719: ifeq +42 -> 761
    //   722: new 229	java/lang/StringBuilder
    //   725: dup
    //   726: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   729: astore 14
    //   731: aload 14
    //   733: ldc_w 548
    //   736: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   739: pop
    //   740: aload 14
    //   742: aload_3
    //   743: invokevirtual 551	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   746: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: pop
    //   750: ldc 242
    //   752: iconst_2
    //   753: aload 14
    //   755: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   758: invokestatic 256	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   761: goto -232 -> 529
    //   764: astore_3
    //   765: aload 9
    //   767: astore_2
    //   768: goto +26 -> 794
    //   771: aload_2
    //   772: astore_3
    //   773: aload 8
    //   775: astore_2
    //   776: goto +32 -> 808
    //   779: astore 9
    //   781: aload_3
    //   782: astore_2
    //   783: aload 9
    //   785: astore_3
    //   786: goto +8 -> 794
    //   789: astore_3
    //   790: goto +4 -> 794
    //   793: astore_3
    //   794: goto +567 -> 1361
    //   797: astore_3
    //   798: aconst_null
    //   799: astore 8
    //   801: goto +560 -> 1361
    //   804: aconst_null
    //   805: astore_3
    //   806: aconst_null
    //   807: astore_2
    //   808: aload_3
    //   809: ifnull +16 -> 825
    //   812: aload_3
    //   813: astore 9
    //   815: aload_2
    //   816: astore 8
    //   818: aload_3
    //   819: invokevirtual 552	java/util/ArrayList:isEmpty	()Z
    //   822: ifeq +30 -> 852
    //   825: aload_3
    //   826: astore 9
    //   828: aload_2
    //   829: astore 8
    //   831: invokestatic 227	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   834: ifeq +18 -> 852
    //   837: aload_3
    //   838: astore 9
    //   840: aload_2
    //   841: astore 8
    //   843: ldc 242
    //   845: iconst_2
    //   846: ldc_w 554
    //   849: invokestatic 256	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   852: aload_3
    //   853: astore 9
    //   855: aload_2
    //   856: astore 8
    //   858: aload_0
    //   859: aload_3
    //   860: invokespecial 557	com/tencent/mobileqq/kandian/biz/playfeeds/VideoPlayRecommendHandler:a	(Ljava/util/List;)V
    //   863: aload_3
    //   864: astore 9
    //   866: aload_2
    //   867: astore 8
    //   869: aload 11
    //   871: ldc_w 559
    //   874: aload_3
    //   875: invokevirtual 563	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   878: goto +22 -> 900
    //   881: invokestatic 227	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   884: ifeq +12 -> 896
    //   887: ldc 242
    //   889: iconst_2
    //   890: ldc_w 565
    //   893: invokestatic 256	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   896: aconst_null
    //   897: astore_3
    //   898: aconst_null
    //   899: astore_2
    //   900: iload 4
    //   902: ifeq +25 -> 927
    //   905: aload_3
    //   906: astore 9
    //   908: aload_2
    //   909: astore 8
    //   911: ldc_w 567
    //   914: invokestatic 344	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   917: checkcast 567	com/tencent/mobileqq/kandian/ad/api/IRIJAdUtilService
    //   920: aload 10
    //   922: invokeinterface 570 2 0
    //   927: aload_3
    //   928: astore 9
    //   930: aload_2
    //   931: astore 8
    //   933: aload 12
    //   935: getfield 574	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:req_article_summary	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary;
    //   938: invokevirtual 575	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:has	()Z
    //   941: ifeq +158 -> 1099
    //   944: aload_3
    //   945: astore 9
    //   947: aload_2
    //   948: astore 8
    //   950: aload 12
    //   952: getfield 574	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:req_article_summary	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary;
    //   955: invokevirtual 576	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   958: ifnull +141 -> 1099
    //   961: aload_3
    //   962: astore 9
    //   964: aload_2
    //   965: astore 8
    //   967: aload_0
    //   968: aload 12
    //   970: getfield 574	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:req_article_summary	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary;
    //   973: invokevirtual 576	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   976: checkcast 258	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary
    //   979: aload 12
    //   981: invokespecial 578	com/tencent/mobileqq/kandian/biz/playfeeds/VideoPlayRecommendHandler:a	(Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$ArticleSummary;Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody;)Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo;
    //   984: astore 13
    //   986: aload_3
    //   987: astore 9
    //   989: aload_2
    //   990: astore 8
    //   992: invokestatic 227	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   995: ifeq +85 -> 1080
    //   998: aload_3
    //   999: astore 9
    //   1001: aload_2
    //   1002: astore 8
    //   1004: new 229	java/lang/StringBuilder
    //   1007: dup
    //   1008: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   1011: astore 14
    //   1013: aload_3
    //   1014: astore 9
    //   1016: aload_2
    //   1017: astore 8
    //   1019: aload 14
    //   1021: ldc_w 580
    //   1024: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1027: pop
    //   1028: aload 13
    //   1030: ifnull +576 -> 1606
    //   1033: aload_3
    //   1034: astore 9
    //   1036: aload_2
    //   1037: astore 8
    //   1039: aload 13
    //   1041: invokevirtual 532	com/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo:e	()Ljava/lang/String;
    //   1044: astore 10
    //   1046: goto +3 -> 1049
    //   1049: aload_3
    //   1050: astore 9
    //   1052: aload_2
    //   1053: astore 8
    //   1055: aload 14
    //   1057: aload 10
    //   1059: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1062: pop
    //   1063: aload_3
    //   1064: astore 9
    //   1066: aload_2
    //   1067: astore 8
    //   1069: ldc 242
    //   1071: iconst_2
    //   1072: aload 14
    //   1074: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1077: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1080: aload_3
    //   1081: astore 9
    //   1083: aload_2
    //   1084: astore 8
    //   1086: aload 11
    //   1088: ldc_w 582
    //   1091: aload 13
    //   1093: invokevirtual 586	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   1096: goto +30 -> 1126
    //   1099: aload_3
    //   1100: astore 9
    //   1102: aload_2
    //   1103: astore 8
    //   1105: invokestatic 227	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1108: ifeq +18 -> 1126
    //   1111: aload_3
    //   1112: astore 9
    //   1114: aload_2
    //   1115: astore 8
    //   1117: ldc 242
    //   1119: iconst_2
    //   1120: ldc_w 588
    //   1123: invokestatic 256	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1126: aload_3
    //   1127: astore 9
    //   1129: aload_2
    //   1130: astore 8
    //   1132: aload 12
    //   1134: getfield 191	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:msg_ecommerce_entrance_config	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$InterruptedWeishiAd;
    //   1137: invokevirtual 192	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$InterruptedWeishiAd:has	()Z
    //   1140: ifeq +51 -> 1191
    //   1143: aload_3
    //   1144: astore 9
    //   1146: aload_2
    //   1147: astore 8
    //   1149: aload 12
    //   1151: getfield 191	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:msg_ecommerce_entrance_config	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$InterruptedWeishiAd;
    //   1154: invokevirtual 193	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$InterruptedWeishiAd:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1157: ifnull +34 -> 1191
    //   1160: aload_3
    //   1161: astore 9
    //   1163: aload_2
    //   1164: astore 8
    //   1166: aload 11
    //   1168: ldc_w 590
    //   1171: aload_0
    //   1172: aload 12
    //   1174: getfield 191	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:msg_ecommerce_entrance_config	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$InterruptedWeishiAd;
    //   1177: invokevirtual 193	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$InterruptedWeishiAd:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1180: checkcast 41	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$InterruptedWeishiAd
    //   1183: aload 12
    //   1185: invokespecial 592	com/tencent/mobileqq/kandian/biz/playfeeds/VideoPlayRecommendHandler:a	(Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$InterruptedWeishiAd;Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody;)Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo$ECommerceEntranceInfo;
    //   1188: invokevirtual 586	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   1191: aload_3
    //   1192: astore 9
    //   1194: aload_2
    //   1195: astore 8
    //   1197: aload 12
    //   1199: getfield 595	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:uint32_is_end	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1202: invokevirtual 90	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1205: ifeq +42 -> 1247
    //   1208: aload_3
    //   1209: astore 9
    //   1211: aload_2
    //   1212: astore 8
    //   1214: aload 12
    //   1216: getfield 595	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:uint32_is_end	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1219: invokevirtual 93	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1222: ifne +392 -> 1614
    //   1225: iconst_1
    //   1226: istore 6
    //   1228: goto +3 -> 1231
    //   1231: aload_3
    //   1232: astore 9
    //   1234: aload_2
    //   1235: astore 8
    //   1237: aload 11
    //   1239: ldc_w 597
    //   1242: iload 6
    //   1244: invokevirtual 444	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   1247: aload_3
    //   1248: astore 9
    //   1250: aload_2
    //   1251: astore 8
    //   1253: aload 12
    //   1255: getfield 601	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:msg_entrance_download_info	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$EntranceDownloadInfo;
    //   1258: invokevirtual 604	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$EntranceDownloadInfo:has	()Z
    //   1261: ifeq +49 -> 1310
    //   1264: aload_3
    //   1265: astore 9
    //   1267: aload_2
    //   1268: astore 8
    //   1270: aload 12
    //   1272: getfield 601	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:msg_entrance_download_info	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$EntranceDownloadInfo;
    //   1275: invokevirtual 605	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$EntranceDownloadInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1278: ifnull +32 -> 1310
    //   1281: aload_3
    //   1282: astore 9
    //   1284: aload_2
    //   1285: astore 8
    //   1287: aload 11
    //   1289: ldc_w 607
    //   1292: aload_0
    //   1293: aload 12
    //   1295: getfield 601	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$RspBody:msg_entrance_download_info	Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$EntranceDownloadInfo;
    //   1298: invokevirtual 605	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$EntranceDownloadInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1301: checkcast 603	tencent/im/oidb/cmd0x6cf/oidb_0x6cf$EntranceDownloadInfo
    //   1304: invokevirtual 610	com/tencent/mobileqq/kandian/biz/playfeeds/VideoPlayRecommendHandler:a	(Ltencent/im/oidb/cmd0x6cf/oidb_0x6cf$EntranceDownloadInfo;)Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo$EntranceDownloadInfo;
    //   1307: invokevirtual 586	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   1310: aload_2
    //   1311: astore 10
    //   1313: aload_3
    //   1314: astore 9
    //   1316: goto +128 -> 1444
    //   1319: astore_3
    //   1320: aload 9
    //   1322: astore_2
    //   1323: goto +38 -> 1361
    //   1326: ldc_w 612
    //   1329: invokestatic 344	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1332: checkcast 612	com/tencent/mobileqq/kandian/ad/api/IRIJVideoAdService
    //   1335: aload 12
    //   1337: aload 11
    //   1339: aload_0
    //   1340: getfield 458	com/tencent/mobileqq/kandian/biz/playfeeds/VideoPlayRecommendHandler:jdField_a_of_type_Long	J
    //   1343: invokeinterface 616 5 0
    //   1348: goto +90 -> 1438
    //   1351: astore_3
    //   1352: goto +4 -> 1356
    //   1355: astore_3
    //   1356: aconst_null
    //   1357: astore 8
    //   1359: aconst_null
    //   1360: astore_2
    //   1361: aload 8
    //   1363: astore 10
    //   1365: aload_2
    //   1366: astore 9
    //   1368: invokestatic 227	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1371: ifeq +73 -> 1444
    //   1374: new 229	java/lang/StringBuilder
    //   1377: dup
    //   1378: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   1381: astore 9
    //   1383: aload 9
    //   1385: ldc_w 548
    //   1388: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1391: pop
    //   1392: aload 9
    //   1394: aload_3
    //   1395: invokevirtual 551	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1398: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1401: pop
    //   1402: ldc 242
    //   1404: iconst_2
    //   1405: aload 9
    //   1407: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1410: invokestatic 256	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1413: aload 8
    //   1415: astore 10
    //   1417: aload_2
    //   1418: astore 9
    //   1420: goto +24 -> 1444
    //   1423: invokestatic 227	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1426: ifeq +12 -> 1438
    //   1429: ldc 242
    //   1431: iconst_2
    //   1432: ldc_w 618
    //   1435: invokestatic 256	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1438: aconst_null
    //   1439: astore 10
    //   1441: aconst_null
    //   1442: astore 9
    //   1444: ldc_w 620
    //   1447: invokestatic 344	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1450: checkcast 620	com/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyUserInfoModule
    //   1453: aload 10
    //   1455: invokeinterface 624 2 0
    //   1460: pop
    //   1461: iload 7
    //   1463: ifne +85 -> 1548
    //   1466: aload_1
    //   1467: ldc_w 626
    //   1470: invokevirtual 629	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   1473: astore_2
    //   1474: aload_2
    //   1475: ifnull +25 -> 1500
    //   1478: aload_2
    //   1479: instanceof 411
    //   1482: ifeq +18 -> 1500
    //   1485: aload 11
    //   1487: ldc_w 626
    //   1490: aload_2
    //   1491: checkcast 411	java/lang/Boolean
    //   1494: invokevirtual 424	java/lang/Boolean:booleanValue	()Z
    //   1497: invokevirtual 444	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   1500: aload 11
    //   1502: ldc_w 631
    //   1505: aload_1
    //   1506: ldc_w 631
    //   1509: invokevirtual 629	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   1512: checkcast 17	java/lang/String
    //   1515: invokevirtual 467	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1518: ldc_w 612
    //   1521: invokestatic 344	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1524: checkcast 612	com/tencent/mobileqq/kandian/ad/api/IRIJVideoAdService
    //   1527: aload 11
    //   1529: aload 9
    //   1531: invokeinterface 635 3 0
    //   1536: aload 11
    //   1538: ldc_w 409
    //   1541: iconst_0
    //   1542: invokevirtual 444	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   1545: goto +12 -> 1557
    //   1548: aload 11
    //   1550: ldc_w 409
    //   1553: iconst_1
    //   1554: invokevirtual 444	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   1557: aload_1
    //   1558: ldc_w 637
    //   1561: invokevirtual 629	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   1564: astore_1
    //   1565: aload_1
    //   1566: instanceof 218
    //   1569: ifeq +18 -> 1587
    //   1572: aload 11
    //   1574: ldc_w 637
    //   1577: aload_1
    //   1578: checkcast 218	java/lang/Integer
    //   1581: invokevirtual 640	java/lang/Integer:intValue	()I
    //   1584: invokevirtual 644	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1587: aload_0
    //   1588: iconst_0
    //   1589: iload 5
    //   1591: aload 11
    //   1593: invokespecial 648	com/tencent/mobileqq/app/BusinessHandler:notifyUI	(IZLjava/lang/Object;)V
    //   1596: return
    //   1597: aconst_null
    //   1598: astore 10
    //   1600: iconst_0
    //   1601: istore 4
    //   1603: goto -1308 -> 295
    //   1606: ldc_w 650
    //   1609: astore 10
    //   1611: goto -562 -> 1049
    //   1614: iconst_0
    //   1615: istore 6
    //   1617: goto -386 -> 1231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1620	0	this	VideoPlayRecommendHandler
    //   0	1620	1	paramToServiceMsg	ToServiceMsg
    //   0	1620	2	paramFromServiceMsg	FromServiceMsg
    //   0	1620	3	paramObject	Object
    //   290	1312	4	i	int
    //   12	1578	5	bool1	boolean
    //   119	1497	6	bool2	boolean
    //   85	1377	7	bool3	boolean
    //   394	1020	8	localObject1	Object
    //   351	415	9	localObject2	Object
    //   779	5	9	localException	Exception
    //   813	717	9	localObject3	Object
    //   287	1323	10	localObject4	Object
    //   27	1565	11	localBundle	Bundle
    //   192	1144	12	localRspBody	oidb_0x6cf.RspBody
    //   464	628	13	localObject5	Object
    //   473	600	14	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   414	444	447	java/lang/Exception
    //   406	414	451	java/lang/Exception
    //   649	702	705	java/lang/Exception
    //   555	564	712	java/lang/Exception
    //   568	613	712	java/lang/Exception
    //   613	649	712	java/lang/Exception
    //   716	761	764	java/lang/Exception
    //   477	486	779	java/lang/Exception
    //   488	501	779	java/lang/Exception
    //   503	518	779	java/lang/Exception
    //   520	529	779	java/lang/Exception
    //   531	541	779	java/lang/Exception
    //   543	555	779	java/lang/Exception
    //   455	475	789	java/lang/Exception
    //   396	401	793	java/lang/Exception
    //   383	396	797	java/lang/Exception
    //   818	825	1319	java/lang/Exception
    //   831	837	1319	java/lang/Exception
    //   843	852	1319	java/lang/Exception
    //   858	863	1319	java/lang/Exception
    //   869	878	1319	java/lang/Exception
    //   911	927	1319	java/lang/Exception
    //   933	944	1319	java/lang/Exception
    //   950	961	1319	java/lang/Exception
    //   967	986	1319	java/lang/Exception
    //   992	998	1319	java/lang/Exception
    //   1004	1013	1319	java/lang/Exception
    //   1019	1028	1319	java/lang/Exception
    //   1039	1046	1319	java/lang/Exception
    //   1055	1063	1319	java/lang/Exception
    //   1069	1080	1319	java/lang/Exception
    //   1086	1096	1319	java/lang/Exception
    //   1105	1111	1319	java/lang/Exception
    //   1117	1126	1319	java/lang/Exception
    //   1132	1143	1319	java/lang/Exception
    //   1149	1160	1319	java/lang/Exception
    //   1166	1191	1319	java/lang/Exception
    //   1197	1208	1319	java/lang/Exception
    //   1214	1225	1319	java/lang/Exception
    //   1237	1247	1319	java/lang/Exception
    //   1253	1264	1319	java/lang/Exception
    //   1270	1281	1319	java/lang/Exception
    //   1287	1310	1319	java/lang/Exception
    //   881	896	1351	java/lang/Exception
    //   1326	1348	1351	java/lang/Exception
    //   92	121	1355	java/lang/Exception
    //   126	153	1355	java/lang/Exception
    //   153	162	1355	java/lang/Exception
    //   165	174	1355	java/lang/Exception
    //   174	224	1355	java/lang/Exception
    //   224	265	1355	java/lang/Exception
    //   265	289	1355	java/lang/Exception
    //   295	316	1355	java/lang/Exception
    //   321	353	1355	java/lang/Exception
    //   358	383	1355	java/lang/Exception
  }
  
  private void a(Object paramObject, long paramLong1, VideoInfo paramVideoInfo, int paramInt1, ArrayList<VideoInfo> paramArrayList1, String paramString1, long paramLong2, boolean paramBoolean, int paramInt2, String paramString2, String paramString3, WeishiRedDotInfo paramWeishiRedDotInfo, int paramInt3, String paramString4, byte[] paramArrayOfByte, ArrayList<oidb_0x885.AdTagInfo> paramArrayList, int paramInt4, int paramInt5, int paramInt6, int paramInt7, ArrayList<VideoInfo> paramArrayList2, Bundle paramBundle, int paramInt8)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(String paramString, VideoInfo paramVideoInfo)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        VideoInfo.LocationInfo localLocationInfo = new VideoInfo.LocationInfo();
        paramString = new JSONObject(paramString);
        localLocationInfo.jdField_a_of_type_JavaLangString = paramString.optString("location_name", null);
        int i = paramString.optInt("is_user_selected", 0);
        bool = true;
        if (i != 1) {
          break label126;
        }
        localLocationInfo.jdField_a_of_type_Boolean = bool;
        if (!TextUtils.isEmpty(localLocationInfo.jdField_a_of_type_JavaLangString))
        {
          paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LocationInfo = localLocationInfo;
          return;
        }
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel())
        {
          paramVideoInfo = new StringBuilder();
          paramVideoInfo.append("locationInfoStr parse Error=");
          paramVideoInfo.append(paramString.toString());
          QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, paramVideoInfo.toString());
        }
      }
      return;
      label126:
      boolean bool = false;
    }
  }
  
  private void a(List<VideoInfo> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      HashSet localHashSet1 = new HashSet();
      HashSet localHashSet2 = new HashSet();
      int i = 0;
      while (i < paramList.size())
      {
        VideoInfo localVideoInfo = (VideoInfo)paramList.get(i);
        if ((localVideoInfo.jdField_r_of_type_Boolean) && (localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo != null) && (localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo.o == 32))
        {
          localVideoInfo = (VideoInfo)((IRIJAdExposeFreshService)QRoute.api(IRIJAdExposeFreshService.class)).replace("RIJAdRefreshSceneFloatVideo", localVideoInfo);
          paramList.set(i, localVideoInfo);
          localHashSet1.add(Long.valueOf(localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo.jdField_e_of_type_Long));
          localHashSet2.add(localVideoInfo);
        }
        i += 1;
      }
      ((IRIJAdReqFreshService)QRoute.api(IRIJAdReqFreshService.class)).addAdIds("RIJAdRefreshSceneFloatVideo", localHashSet1);
      ((IRIJAdExposeFreshService)QRoute.api(IRIJAdExposeFreshService.class)).addVideoFloatReceiveAds("RIJAdRefreshSceneFloatVideo", localHashSet2);
    }
  }
  
  private void a(oidb_0x6cf.ReqBody paramReqBody)
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      oidb_0x6cf.PkgInstallInfo localPkgInstallInfo = new oidb_0x6cf.PkgInstallInfo();
      localPkgInstallInfo.bytes_pkg_name.set(ByteStringMicro.copyFromUtf8(str));
      str = PackageUtil.a(BaseApplicationImpl.getContext(), str);
      localPkgInstallInfo.uint32_is_installed.set(str.equals("0") ^ true);
      localPkgInstallInfo.bytes_version.set(ByteStringMicro.copyFromUtf8(str));
      localPkgInstallInfo.uint32_platform_type.set(1);
      localArrayList.add(localPkgInstallInfo);
      i += 1;
    }
    paramReqBody.rpt_pkg_install_info.set(localArrayList);
  }
  
  private boolean a(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo != null)
    {
      if (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo == null) {
        return false;
      }
      if (paramVideoInfo.t == 2)
      {
        if ((!TextUtils.isEmpty(paramVideoInfo.jdField_p_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo.jdField_f_of_type_JavaLangString))) {
          return true;
        }
      }
      else if ((paramVideoInfo.t == 1) && (!TextUtils.isEmpty(paramVideoInfo.jdField_p_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo.jdField_k_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo.jdField_f_of_type_JavaLangString))) {
        return true;
      }
    }
    return false;
  }
  
  private int b()
  {
    int i = NetworkUtil.getSystemNetwork(BaseApplicationImpl.getApplication().getApplicationContext());
    if (i != 1)
    {
      if ((i != 3) && (i != 4)) {
        return 2;
      }
      return 1;
    }
    return 0;
  }
  
  private VideoInfo b(oidb_0x6cf.ArticleSummary paramArticleSummary, oidb_0x6cf.RspBody paramRspBody)
  {
    localVideoInfo = new VideoInfo();
    if ((paramArticleSummary.bytes_article_title.has()) && (paramArticleSummary.bytes_article_title.get() != null)) {
      localVideoInfo.jdField_c_of_type_JavaLangString = paramArticleSummary.bytes_article_title.get().toStringUtf8();
    }
    localObject1 = a(paramRspBody.bytes_rsp_ug_interface_data);
    try
    {
      localObject2 = new JSONObject(((JSONObject)new JSONObject((String)localObject1).getJSONArray("items").get(0)).getString("extData"));
    }
    catch (Exception localException14)
    {
      try
      {
        localObject3 = ((JSONObject)new JSONObject((String)localObject1).getJSONArray("items").get(0)).getJSONObject("privateInfo");
        break label133;
        localObject3 = null;
      }
      catch (Exception localException14)
      {
        try
        {
          localObject1 = ((JSONObject)new JSONObject((String)localObject1).getJSONArray("items").get(0)).getString("backoffGroup");
          break label169;
          localObject1 = null;
          if ((localObject2 == null) || (localObject3 == null) || (TextUtils.isEmpty((CharSequence)localObject1))) {
            break label1682;
          }
        }
        catch (Exception localException14)
        {
          try
          {
            localObject5 = ((JSONObject)localObject2).optString("top_base_pic");
            localObject6 = ((JSONObject)localObject2).optString("top_redenv_pic");
            localObject7 = ((JSONObject)localObject2).optString("top_txt_showpic");
            str1 = ((JSONObject)localObject2).optString("top_close_pic");
          }
          catch (Exception localException14)
          {
            try
            {
              str2 = ((JSONObject)localObject2).optString("download_word_color");
            }
            catch (Exception localException14)
            {
              try
              {
                str3 = ((JSONObject)localObject2).optString("apk_link");
              }
              catch (Exception localException14)
              {
                try
                {
                  str4 = ((JSONObject)localObject3).getJSONObject(a(paramArticleSummary.bytes_kb_id)).optString("deepLink");
                }
                catch (Exception localException14)
                {
                  try
                  {
                    str5 = ((JSONObject)localObject2).optString("clipboard_data");
                  }
                  catch (Exception localException14)
                  {
                    try
                    {
                      localObject8 = ((JSONObject)localObject3).getJSONObject(a(paramArticleSummary.bytes_kb_id)).getJSONObject("statInfo").getJSONArray("999");
                    }
                    catch (Exception localException14)
                    {
                      try
                      {
                        localObject8 = (String)((JSONArray)localObject8).get(0);
                        str6 = ((JSONObject)localObject2).optString("pkg_name");
                      }
                      catch (Exception localException14)
                      {
                        try
                        {
                          str7 = ((JSONObject)localObject2).optString("top_downloading_txt");
                          str8 = ((JSONObject)localObject2).optString("top_dldparse_txt");
                          str9 = ((JSONObject)localObject2).optString("top_downloaded_txt");
                          i = ((JSONObject)localObject2).optInt("max_click_num");
                          j = ((JSONObject)localObject2).optInt("max_exposure_num");
                        }
                        catch (Exception localException14)
                        {
                          try
                          {
                            localJSONObject = ((JSONObject)localObject3).getJSONObject(a(paramArticleSummary.bytes_kb_id));
                          }
                          catch (Exception localException14)
                          {
                            try
                            {
                              JSONObject localJSONObject;
                              k = localJSONObject.getInt("useUG");
                              if (k != 2) {
                                break label650;
                              }
                              if ((TextUtils.isEmpty((CharSequence)localObject5)) || (TextUtils.isEmpty((CharSequence)localObject6)) || (TextUtils.isEmpty((CharSequence)localObject7)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str4)) || (TextUtils.isEmpty((CharSequence)localObject8)) || (TextUtils.isEmpty(str6))) {
                                break label932;
                              }
                              localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo = new UGDownloadInfo();
                              localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_a_of_type_JavaLangString = ((String)localObject5);
                              localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_b_of_type_JavaLangString = ((String)localObject6);
                              localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_c_of_type_JavaLangString = ((String)localObject7);
                              localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_d_of_type_JavaLangString = str1;
                              localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_e_of_type_JavaLangString = str2;
                              localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_f_of_type_JavaLangString = str3;
                              localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_g_of_type_JavaLangString = str4;
                              localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_h_of_type_JavaLangString = str5;
                              localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.i = ((String)localObject8);
                              localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_j_of_type_JavaLangString = str6;
                              localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_k_of_type_JavaLangString = str7;
                              localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_l_of_type_JavaLangString = str8;
                              localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_m_of_type_JavaLangString = str9;
                              localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_a_of_type_Int = i;
                              localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_b_of_type_Int = j;
                              localObject5 = localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo;
                            }
                            catch (Exception localException14)
                            {
                              try
                              {
                                Object localObject2;
                                Object localObject3;
                                Object localObject6;
                                Object localObject7;
                                String str1;
                                String str2;
                                String str3;
                                String str4;
                                String str5;
                                Object localObject8;
                                String str6;
                                String str7;
                                String str8;
                                String str9;
                                int i;
                                int j;
                                int k;
                                ((UGDownloadInfo)localObject5).jdField_n_of_type_JavaLangString = ((String)localObject1);
                                localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_c_of_type_Int = k;
                                break label956;
                                if ((k != 1) || (TextUtils.isEmpty((CharSequence)localObject5)) || (TextUtils.isEmpty((CharSequence)localObject6)) || (TextUtils.isEmpty((CharSequence)localObject7)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str5)) || (TextUtils.isEmpty((CharSequence)localObject8)) || (TextUtils.isEmpty(str6)) || (TextUtils.isEmpty(str7)) || (TextUtils.isEmpty(str8)) || (TextUtils.isEmpty(str9))) {
                                  break label932;
                                }
                                localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo = new UGDownloadInfo();
                                localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_a_of_type_JavaLangString = ((String)localObject5);
                                localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_b_of_type_JavaLangString = ((String)localObject6);
                                localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_c_of_type_JavaLangString = ((String)localObject7);
                                localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_d_of_type_JavaLangString = str1;
                                localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_e_of_type_JavaLangString = str2;
                                localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_f_of_type_JavaLangString = str3;
                                localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_g_of_type_JavaLangString = str4;
                                localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_h_of_type_JavaLangString = str5;
                                localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.i = ((String)localObject8);
                                localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_j_of_type_JavaLangString = str6;
                                localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_k_of_type_JavaLangString = str7;
                                localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_l_of_type_JavaLangString = str8;
                                localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_m_of_type_JavaLangString = str9;
                                localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_a_of_type_Int = i;
                                localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_b_of_type_Int = j;
                                Object localObject5 = localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo;
                                for (;;)
                                {
                                  try
                                  {
                                    ((UGDownloadInfo)localObject5).jdField_n_of_type_JavaLangString = ((String)localObject1);
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_c_of_type_Int = k;
                                  }
                                  catch (Exception localException16)
                                  {
                                    continue;
                                  }
                                  continue;
                                  continue;
                                  continue;
                                  continue;
                                  continue;
                                  continue;
                                  try
                                  {
                                    localObject5 = ((JSONObject)localObject2).optString("shoot_base_pic");
                                    localObject6 = ((JSONObject)localObject2).optString("shoot_redenv_pic");
                                    localObject7 = ((JSONObject)localObject2).optString("shoot_txt_showpic");
                                    str1 = ((JSONObject)localObject2).optString("shoot_close_pic");
                                    str2 = ((JSONObject)localObject2).optString("download_word_color");
                                    str3 = ((JSONObject)localObject2).optString("apk_link");
                                    str4 = ((JSONObject)localObject3).getJSONObject(a(paramArticleSummary.bytes_kb_id)).optString("deepLink");
                                    str5 = ((JSONObject)localObject2).optString("clipboard_data");
                                    localObject8 = (String)((JSONObject)localObject3).getJSONObject(a(paramArticleSummary.bytes_kb_id)).getJSONObject("statInfo").getJSONArray("999").get(0);
                                    str6 = ((JSONObject)localObject2).optString("pkg_name");
                                    str7 = ((JSONObject)localObject2).optString("shoot_downloading_txt");
                                    str8 = ((JSONObject)localObject2).optString("shoot_dldparse_txt");
                                    str9 = ((JSONObject)localObject2).optString("shoot_downloaded_txt");
                                    i = ((JSONObject)localObject2).optInt("max_click_num");
                                    j = ((JSONObject)localObject2).optInt("max_exposure_num");
                                    k = ((JSONObject)localObject3).getJSONObject(a(paramArticleSummary.bytes_kb_id)).getInt("useUG");
                                    if (k == 2)
                                    {
                                      if ((!TextUtils.isEmpty((CharSequence)localObject5)) && (!TextUtils.isEmpty((CharSequence)localObject6)) && (!TextUtils.isEmpty((CharSequence)localObject7)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str4)) && (!TextUtils.isEmpty((CharSequence)localObject8)) && (!TextUtils.isEmpty(str6)))
                                      {
                                        localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo = new UGDownloadInfo();
                                        localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_a_of_type_JavaLangString = ((String)localObject5);
                                        localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_b_of_type_JavaLangString = ((String)localObject6);
                                        localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_c_of_type_JavaLangString = ((String)localObject7);
                                        localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_d_of_type_JavaLangString = str1;
                                        localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_e_of_type_JavaLangString = str2;
                                        localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_f_of_type_JavaLangString = str3;
                                        localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_g_of_type_JavaLangString = str4;
                                        localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_h_of_type_JavaLangString = str5;
                                        localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.i = ((String)localObject8);
                                        localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_j_of_type_JavaLangString = str6;
                                        localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_k_of_type_JavaLangString = str7;
                                        localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_l_of_type_JavaLangString = str8;
                                        localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_m_of_type_JavaLangString = str9;
                                        localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_a_of_type_Int = i;
                                        localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_b_of_type_Int = j;
                                        localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_n_of_type_JavaLangString = ((String)localObject1);
                                        localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_c_of_type_Int = k;
                                      }
                                    }
                                    else if ((k == 1) && (!TextUtils.isEmpty((CharSequence)localObject5)) && (!TextUtils.isEmpty((CharSequence)localObject6)) && (!TextUtils.isEmpty((CharSequence)localObject7)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str5)) && (!TextUtils.isEmpty((CharSequence)localObject8)) && (!TextUtils.isEmpty(str6)) && (!TextUtils.isEmpty(str7)) && (!TextUtils.isEmpty(str8)) && (!TextUtils.isEmpty(str9)))
                                    {
                                      localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo = new UGDownloadInfo();
                                      localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_a_of_type_JavaLangString = ((String)localObject5);
                                      localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_b_of_type_JavaLangString = ((String)localObject6);
                                      localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_c_of_type_JavaLangString = ((String)localObject7);
                                      localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_d_of_type_JavaLangString = str1;
                                      localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_e_of_type_JavaLangString = str2;
                                      localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_f_of_type_JavaLangString = str3;
                                      localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_g_of_type_JavaLangString = str4;
                                      localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_h_of_type_JavaLangString = str5;
                                      localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.i = ((String)localObject8);
                                      localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_j_of_type_JavaLangString = str6;
                                      localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_k_of_type_JavaLangString = str7;
                                      localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_l_of_type_JavaLangString = str8;
                                      localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_m_of_type_JavaLangString = str9;
                                      localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_a_of_type_Int = i;
                                      localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_b_of_type_Int = j;
                                      localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_n_of_type_JavaLangString = ((String)localObject1);
                                      localVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_c_of_type_Int = k;
                                    }
                                  }
                                  catch (Exception localException2)
                                  {
                                    boolean bool1;
                                    long l1;
                                    continue;
                                  }
                                  if ((paramArticleSummary.bytes_article_summary.has()) && (paramArticleSummary.bytes_article_summary.get() != null)) {
                                    localVideoInfo.jdField_d_of_type_JavaLangString = paramArticleSummary.bytes_article_summary.get().toStringUtf8();
                                  }
                                  if ((paramArticleSummary.rpt_dislike_list.has()) && (paramArticleSummary.rpt_dislike_list.get() != null))
                                  {
                                    localObject1 = paramArticleSummary.rpt_dislike_list.get();
                                    if ((localObject1 != null) && (((List)localObject1).size() > 0))
                                    {
                                      j = ((List)localObject1).size();
                                      localVideoInfo.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
                                      i = 0;
                                      if (i < j)
                                      {
                                        localObject2 = new DislikeInfo();
                                        ((DislikeInfo)localObject2).a((oidb_0x6cf.DisLikeInfo)((List)localObject1).get(i));
                                        if (!TextUtils.isEmpty(((DislikeInfo)localObject2).jdField_a_of_type_JavaLangString)) {
                                          localVideoInfo.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
                                        }
                                        i += 1;
                                        continue;
                                      }
                                    }
                                  }
                                  bool1 = paramArticleSummary.uint64_time.has();
                                  l1 = 0L;
                                  if ((bool1) && (paramArticleSummary.uint64_time.get() != 0L))
                                  {
                                    localVideoInfo.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(paramArticleSummary.uint64_time.get() * 1000L));
                                    localVideoInfo.jdField_a_of_type_Long = paramArticleSummary.uint64_time.get();
                                  }
                                  localObject2 = this;
                                  if ((paramArticleSummary.bytes_subscribe_id.has()) && (paramArticleSummary.bytes_subscribe_id.get() != null)) {
                                    localVideoInfo.jdField_j_of_type_JavaLangString = paramArticleSummary.bytes_subscribe_id.get().toStringUtf8();
                                  }
                                  if ((paramArticleSummary.bytes_subscribe_name.has()) && (paramArticleSummary.bytes_subscribe_name.get() != null)) {
                                    localVideoInfo.jdField_k_of_type_JavaLangString = paramArticleSummary.bytes_subscribe_name.get().toStringUtf8();
                                  }
                                  if ((paramArticleSummary.bytes_article_content_url.has()) && (paramArticleSummary.bytes_article_content_url.get() != null)) {
                                    localVideoInfo.jdField_f_of_type_JavaLangString = paramArticleSummary.bytes_article_content_url.get().toStringUtf8();
                                  }
                                  if ((paramArticleSummary.bytes_aio_share_url.has()) && (paramArticleSummary.bytes_aio_share_url.get() != null)) {
                                    localVideoInfo.jdField_m_of_type_JavaLangString = paramArticleSummary.bytes_aio_share_url.get().toStringUtf8();
                                  }
                                  if ((paramArticleSummary.bytes_qzone_share_url.has()) && (paramArticleSummary.bytes_qzone_share_url.get() != null)) {
                                    localVideoInfo.jdField_n_of_type_JavaLangString = paramArticleSummary.bytes_qzone_share_url.get().toStringUtf8();
                                  }
                                  if (paramArticleSummary.uint32_strategy_id.has()) {
                                    localVideoInfo.jdField_p_of_type_Int = paramArticleSummary.uint32_strategy_id.get();
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
                                    localVideoInfo.jdField_s_of_type_Int = paramArticleSummary.uint32_like_count.get();
                                  }
                                  if (paramArticleSummary.uint32_biu_count.has()) {
                                    localVideoInfo.jdField_f_of_type_Int = paramArticleSummary.uint32_biu_count.get();
                                  }
                                  if (paramArticleSummary.uint32_ads_guide_time.has()) {
                                    localVideoInfo.i = paramArticleSummary.uint32_ads_guide_time.get();
                                  }
                                  if (paramArticleSummary.uint32_ads_jump_type.has()) {
                                    localVideoInfo.jdField_j_of_type_Int = paramArticleSummary.uint32_ads_jump_type.get();
                                  }
                                  if (paramArticleSummary.uint32_video_source_type.has())
                                  {
                                    if (paramArticleSummary.uint32_video_source_type.get() == 1) {
                                      bool1 = true;
                                    } else {
                                      bool1 = false;
                                    }
                                    localVideoInfo.jdField_e_of_type_Boolean = bool1;
                                  }
                                  if (paramArticleSummary.uint32_account_grade.has())
                                  {
                                    if (paramArticleSummary.uint32_account_grade.get() == 1) {
                                      bool1 = true;
                                    } else {
                                      bool1 = false;
                                    }
                                    localVideoInfo.jdField_a_of_type_Boolean = bool1;
                                  }
                                  if (paramArticleSummary.uint32_myself_like_status.has())
                                  {
                                    if (paramArticleSummary.uint32_myself_like_status.get() == 1) {
                                      bool1 = true;
                                    } else {
                                      bool1 = false;
                                    }
                                    localVideoInfo.jdField_q_of_type_Boolean = bool1;
                                  }
                                  if (paramArticleSummary.bytes_video_report_info.has()) {
                                    localVideoInfo.w = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.bytes_video_report_info);
                                  }
                                  if (paramArticleSummary.uint64_article_id.has()) {
                                    localVideoInfo.jdField_c_of_type_Long = paramArticleSummary.uint64_article_id.get();
                                  }
                                  if (paramArticleSummary.uint32_trigger_sec.has()) {
                                    localVideoInfo.jdField_m_of_type_Int = paramArticleSummary.uint32_trigger_sec.get();
                                  }
                                  if ((paramArticleSummary.msg_top_bar_info.has()) && (paramArticleSummary.msg_top_bar_info.get() != null))
                                  {
                                    localObject1 = paramArticleSummary.msg_top_bar_info;
                                    localObject3 = new VideoInfo.TopBarInfo();
                                    ((VideoInfo.TopBarInfo)localObject3).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo = new UrlJumpInfo();
                                    if (((oidb_0x6cf.TopBarInfo)localObject1).uint32_topbar_id.has()) {
                                      i = ((oidb_0x6cf.TopBarInfo)localObject1).uint32_topbar_id.get();
                                    } else {
                                      i = -1;
                                    }
                                    ((VideoInfo.TopBarInfo)localObject3).jdField_a_of_type_Int = i;
                                    ((VideoInfo.TopBarInfo)localObject3).jdField_a_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.TopBarInfo)localObject1).bytes_icon_url);
                                    ((VideoInfo.TopBarInfo)localObject3).jdField_b_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.TopBarInfo)localObject1).bytes_title);
                                    ((VideoInfo.TopBarInfo)localObject3).jdField_d_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.TopBarInfo)localObject1).bytes_common_data);
                                    ((VideoInfo.TopBarInfo)localObject3).jdField_c_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.TopBarInfo)localObject1).bytes_background_url);
                                    ((VideoInfo.TopBarInfo)localObject3).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_a_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.TopBarInfo)localObject1).bytes_jump_url);
                                    localObject5 = ((VideoInfo.TopBarInfo)localObject3).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo;
                                    if (((oidb_0x6cf.TopBarInfo)localObject1).uint32_jump_type.has()) {
                                      i = ((oidb_0x6cf.TopBarInfo)localObject1).uint32_jump_type.get();
                                    } else {
                                      i = 0;
                                    }
                                    ((UrlJumpInfo)localObject5).jdField_a_of_type_Int = i;
                                    ((VideoInfo.TopBarInfo)localObject3).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_b_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.TopBarInfo)localObject1).bytes_ios_jump_bundle);
                                    ((VideoInfo.TopBarInfo)localObject3).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_c_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.TopBarInfo)localObject1).bytes_jump_schema);
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$TopBarInfo = ((VideoInfo.TopBarInfo)localObject3);
                                  }
                                  if ((paramArticleSummary.msg_download_bar_info.has()) && (paramArticleSummary.msg_download_bar_info.get() != null))
                                  {
                                    localObject1 = paramArticleSummary.msg_download_bar_info;
                                    localObject3 = new VideoInfo.DownloadBarInfo();
                                    ((VideoInfo.DownloadBarInfo)localObject3).jdField_a_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.DownloadBarInfo)localObject1).bytes_logo_url);
                                    if (((oidb_0x6cf.DownloadBarInfo)localObject1).uint32_appear_time.has()) {
                                      i = ((oidb_0x6cf.DownloadBarInfo)localObject1).uint32_appear_time.get();
                                    } else {
                                      i = 0;
                                    }
                                    ((VideoInfo.DownloadBarInfo)localObject3).jdField_a_of_type_Int = i;
                                    if (((oidb_0x6cf.DownloadBarInfo)localObject1).uint32_button_bg_color.has()) {
                                      i = ((oidb_0x6cf.DownloadBarInfo)localObject1).uint32_button_bg_color.get();
                                    } else {
                                      i = 0;
                                    }
                                    ((VideoInfo.DownloadBarInfo)localObject3).jdField_b_of_type_Int = i;
                                    ((VideoInfo.DownloadBarInfo)localObject3).jdField_b_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.DownloadBarInfo)localObject1).bytes_download_button_text);
                                    ((VideoInfo.DownloadBarInfo)localObject3).jdField_c_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.DownloadBarInfo)localObject1).bytes_open_button_text);
                                    ((VideoInfo.DownloadBarInfo)localObject3).jdField_d_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.DownloadBarInfo)localObject1).bytes_common_data);
                                    ((VideoInfo.DownloadBarInfo)localObject3).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.DownloadBarInfo)localObject1).msg_url_jump_info);
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$DownloadBarInfo = ((VideoInfo.DownloadBarInfo)localObject3);
                                  }
                                  if ((paramArticleSummary.json_video_list.has()) && (paramArticleSummary.json_video_list.get() != null)) {}
                                  try
                                  {
                                    localVideoInfo.jdField_l_of_type_JavaLangString = paramArticleSummary.json_video_list.get().toStringUtf8();
                                    localObject1 = new JSONObject(paramArticleSummary.json_video_list.get().toStringUtf8()).getJSONArray("videos").optJSONObject(0);
                                  }
                                  catch (JSONException localJSONException1)
                                  {
                                    Object localObject4;
                                    long l2;
                                    boolean bool2;
                                    continue;
                                  }
                                  if (QLog.isColorLevel()) {
                                    QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, jsonVideoList 解析出错");
                                  }
                                  localObject1 = null;
                                  if (localObject1 != null)
                                  {
                                    localVideoInfo.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("vid");
                                    if (((JSONObject)localObject1).has("width")) {
                                      localVideoInfo.jdField_b_of_type_Int = ((JSONObject)localObject1).getInt("width");
                                    }
                                    if (((JSONObject)localObject1).has("height")) {
                                      localVideoInfo.jdField_c_of_type_Int = ((JSONObject)localObject1).getInt("height");
                                    }
                                    if (((JSONObject)localObject1).has("duration")) {
                                      try
                                      {
                                        localVideoInfo.jdField_d_of_type_Int = Integer.parseInt(((JSONObject)localObject1).optString("duration"));
                                      }
                                      catch (NumberFormatException localNumberFormatException)
                                      {
                                        localNumberFormatException.printStackTrace();
                                      }
                                    }
                                    localVideoInfo.jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).optString("picture");
                                    if (((JSONObject)localObject1).has("innerUniqueID")) {
                                      localVideoInfo.jdField_g_of_type_JavaLangString = ((JSONObject)localObject1).optString("innerUniqueID");
                                    }
                                    localVideoInfo.jdField_a_of_type_Int = 1;
                                    if (((JSONObject)localObject1).has("busiType")) {
                                      localVideoInfo.jdField_a_of_type_Int = ((JSONObject)localObject1).getInt("busiType");
                                    }
                                    localVideoInfo.o = ((JSONObject)localObject1).optString("thirdAction");
                                    localVideoInfo.jdField_p_of_type_JavaLangString = ((JSONObject)localObject1).optString("thirdIcon");
                                    localVideoInfo.jdField_q_of_type_JavaLangString = ((JSONObject)localObject1).optString("thirdUinName");
                                    if (!TextUtils.isEmpty(((JSONObject)localObject1).optString("thirdName"))) {
                                      localVideoInfo.jdField_k_of_type_JavaLangString = ((JSONObject)localObject1).optString("thirdName");
                                    }
                                    if (!TextUtils.isEmpty(((JSONObject)localObject1).optString("third_uin"))) {
                                      localVideoInfo.jdField_j_of_type_JavaLangString = ((JSONObject)localObject1).optString("third_uin");
                                    }
                                    localObject1 = ((JSONObject)localObject1).optJSONArray("video_info");
                                    if (localObject1 != null)
                                    {
                                      i = 0;
                                      if (i < ((JSONArray)localObject1).length())
                                      {
                                        localObject4 = ((JSONArray)localObject1).optJSONObject(i);
                                        if (localObject4 != null)
                                        {
                                          j = ((JSONObject)localObject4).optInt("network_type");
                                          l2 = ((JSONObject)localObject4).optLong("file_size");
                                          if (j == 2)
                                          {
                                            localVideoInfo.jdField_b_of_type_Long = l2;
                                            continue;
                                          }
                                        }
                                        i += 1;
                                        continue;
                                      }
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
                                        localObject4 = (oidb_0x6cf.FeedsIdInfo)((oidb_0x6cf.UGCFeedsInfo)localObject1).ugc_feeds_info.get();
                                        if (((oidb_0x6cf.FeedsIdInfo)localObject4).uint64_feeds_id.has()) {
                                          localVideoInfo.jdField_d_of_type_Long = ((oidb_0x6cf.FeedsIdInfo)localObject4).uint64_feeds_id.get();
                                        }
                                        if (((oidb_0x6cf.FeedsIdInfo)localObject4).uint32_feeds_type.has()) {
                                          localVideoInfo.jdField_h_of_type_Int = ((oidb_0x6cf.FeedsIdInfo)localObject4).uint32_feeds_type.get();
                                        }
                                      }
                                      if (((oidb_0x6cf.UGCFeedsInfo)localObject1).uint32_follow_status.has())
                                      {
                                        if (((oidb_0x6cf.UGCFeedsInfo)localObject1).uint32_follow_status.get() == 2) {
                                          bool1 = true;
                                        } else {
                                          bool1 = false;
                                        }
                                        localVideoInfo.jdField_p_of_type_Boolean = bool1;
                                      }
                                      if (((oidb_0x6cf.UGCFeedsInfo)localObject1).uint64_cuin.has()) {
                                        localVideoInfo.jdField_j_of_type_JavaLangString = String.valueOf(((oidb_0x6cf.UGCFeedsInfo)localObject1).uint64_cuin.get());
                                      }
                                      if ((((oidb_0x6cf.UGCFeedsInfo)localObject1).msg_ugc_video_info_list.has()) && (((oidb_0x6cf.UGCFeedsInfo)localObject1).msg_ugc_video_info_list.get() != null))
                                      {
                                        localObject4 = (oidb_0x6cf.UGCVideoInfo)((oidb_0x6cf.UGCFeedsInfo)localObject1).msg_ugc_video_info_list.get();
                                        localVideoInfo.jdField_r_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.UGCVideoInfo)localObject4).bytes_video_url);
                                        localVideoInfo.jdField_b_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.UGCVideoInfo)localObject4).bytes_pic_url);
                                        localVideoInfo.jdField_c_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.UGCVideoInfo)localObject4).bytes_title);
                                        localVideoInfo.jdField_d_of_type_Int = ((int)(((oidb_0x6cf.UGCVideoInfo)localObject4).uint64_duration.get() / 1000L));
                                        localVideoInfo.jdField_b_of_type_Int = ((oidb_0x6cf.UGCVideoInfo)localObject4).uint32_video_width.get();
                                        localVideoInfo.jdField_c_of_type_Int = ((oidb_0x6cf.UGCVideoInfo)localObject4).uint32_video_height.get();
                                        localVideoInfo.jdField_g_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.UGCVideoInfo)localObject4).bytes_uniq_id);
                                        localVideoInfo.jdField_a_of_type_Long = ((oidb_0x6cf.UGCVideoInfo)localObject4).uint32_create_time.get();
                                        localVideoInfo.jdField_f_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.UGCVideoInfo)localObject4).bytes_share_url);
                                        localVideoInfo.jdField_a_of_type_Int = ((oidb_0x6cf.UGCVideoInfo)localObject4).uint32_busi_type.get();
                                        localVideoInfo.jdField_a_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.UGCVideoInfo)localObject4).bytes_vid);
                                      }
                                      if (((oidb_0x6cf.UGCFeedsInfo)localObject1).msg_at_multi_level.has())
                                      {
                                        localObject4 = new ArrayList();
                                        localObject5 = (oidb_0x6cf.BiuMultiLevel)((oidb_0x6cf.UGCFeedsInfo)localObject1).msg_at_multi_level.get();
                                        if ((((oidb_0x6cf.BiuMultiLevel)localObject5).rpt_biu_mutli_level.has()) && (!((oidb_0x6cf.BiuMultiLevel)localObject5).rpt_biu_mutli_level.isEmpty()))
                                        {
                                          localObject5 = ((oidb_0x6cf.BiuMultiLevel)localObject5).rpt_biu_mutli_level.get();
                                          if ((localObject5 != null) && (((List)localObject5).size() > 0))
                                          {
                                            localObject5 = ((List)localObject5).iterator();
                                            if (((Iterator)localObject5).hasNext())
                                            {
                                              localObject6 = (oidb_0x6cf.BiuOneLevelItem)((Iterator)localObject5).next();
                                              localObject7 = new RichTitleInfo();
                                              ((RichTitleInfo)localObject7).jdField_a_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.BiuOneLevelItem)localObject6).bytes_biu_comments);
                                              if (((oidb_0x6cf.BiuOneLevelItem)localObject6).msg_jump_info.has())
                                              {
                                                ((RichTitleInfo)localObject7).jdField_b_of_type_JavaLangString = String.valueOf(((oidb_0x6cf.JumpInfo)((oidb_0x6cf.BiuOneLevelItem)localObject6).msg_jump_info.get()).uint64_id);
                                                ((RichTitleInfo)localObject7).jdField_c_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.JumpInfo)((oidb_0x6cf.BiuOneLevelItem)localObject6).msg_jump_info.get()).bytes_wording);
                                                ((RichTitleInfo)localObject7).jdField_d_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.JumpInfo)((oidb_0x6cf.BiuOneLevelItem)localObject6).msg_jump_info.get()).bytes_jump_url);
                                              }
                                              ((RichTitleInfo)localObject7).jdField_a_of_type_Int = ((oidb_0x6cf.BiuOneLevelItem)localObject6).op_type.get();
                                              ((ArrayList)localObject4).add(localObject7);
                                              continue;
                                            }
                                          }
                                        }
                                        localVideoInfo.jdField_d_of_type_JavaUtilArrayList = ((ArrayList)localObject4);
                                      }
                                      if (((oidb_0x6cf.UGCFeedsInfo)localObject1).bytes_location_info.has()) {
                                        ((VideoPlayRecommendHandler)localObject2).a(((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.UGCFeedsInfo)localObject1).bytes_location_info), localVideoInfo);
                                      }
                                    }
                                  }
                                  if ((paramArticleSummary.msg_feeds_info.has()) && (((oidb_0x6cf.FeedsInfo)paramArticleSummary.msg_feeds_info.get()).feeds_type.get() == 1))
                                  {
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo = new VideoAdInfo(((VideoPlayRecommendHandler)localObject2).jdField_a_of_type_Long, (oidb_0x6cf.PosAdInfo)((oidb_0x6cf.FeedsInfo)paramArticleSummary.msg_feeds_info.get()).msg_pos_ad_info.get());
                                    if (((oidb_0x6cf.FeedsInfo)paramArticleSummary.msg_feeds_info.get()).rpt_msg_neg_feedback.has()) {
                                      localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo.a(((oidb_0x6cf.FeedsInfo)paramArticleSummary.msg_feeds_info.get()).rpt_msg_neg_feedback.get());
                                    }
                                    if (QLog.isColorLevel())
                                    {
                                      localObject1 = new StringBuilder();
                                      ((StringBuilder)localObject1).append("getRecommendList recv adInfo=");
                                      ((StringBuilder)localObject1).append(localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo.toString());
                                      QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, ((StringBuilder)localObject1).toString());
                                    }
                                    localVideoInfo.jdField_r_of_type_Boolean = true;
                                    i = localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo.jdField_g_of_type_Int;
                                    if (i == 65)
                                    {
                                      localVideoInfo.t = 2;
                                      if (!((VideoPlayRecommendHandler)localObject2).a(localVideoInfo))
                                      {
                                        if (QLog.isColorLevel())
                                        {
                                          paramArticleSummary = new StringBuilder();
                                          paramArticleSummary.append("getRecommendList isInvalidImageAd traceID=");
                                          paramArticleSummary.append(localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo.jdField_h_of_type_JavaLangString);
                                          QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, paramArticleSummary.toString());
                                        }
                                        return null;
                                      }
                                    }
                                    else
                                    {
                                      if ((i != 185) && (i != 350) && (i != 450) && (i != 1122))
                                      {
                                        if (QLog.isColorLevel())
                                        {
                                          paramArticleSummary = new StringBuilder();
                                          paramArticleSummary.append("getRecommendList isUnknownTypeAd traceID=");
                                          paramArticleSummary.append(localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo.jdField_h_of_type_JavaLangString);
                                          QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, paramArticleSummary.toString());
                                        }
                                        return null;
                                      }
                                      localVideoInfo.t = 1;
                                      if (((VideoPlayRecommendHandler)localObject2).a(localVideoInfo)) {
                                        continue;
                                      }
                                      if (QLog.isColorLevel())
                                      {
                                        paramArticleSummary = new StringBuilder();
                                        paramArticleSummary.append("getRecommendList isInvalidVideoAd traceID=");
                                        paramArticleSummary.append(localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo.jdField_h_of_type_JavaLangString);
                                        QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, paramArticleSummary.toString());
                                      }
                                      return null;
                                    }
                                    localObject1 = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo);
                                    if (((IRIJAdSwitchService)QRoute.api(IRIJAdSwitchService.class)).isServerRspReport(null, localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo))
                                    {
                                      localObject4 = new JSONObject();
                                      try
                                      {
                                        ((JSONObject)localObject4).put("svrresp_result", 0);
                                        ((JSONObject)localObject4).put("svrresp_count", 1);
                                      }
                                      catch (JSONException localJSONException2)
                                      {
                                        localJSONException2.printStackTrace();
                                      }
                                      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(BaseApplication.getContext()).a(80).b(13).a((AdvertisementInfo)localObject1).a(localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo).b((JSONObject)localObject4));
                                    }
                                    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).preLoadAdForMiniProgram(((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo, Integer.valueOf(5), Integer.valueOf(3)));
                                  }
                                  localVideoInfo.u = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.bytes_video_logo_url);
                                  if (paramArticleSummary.msg_account_v_info.has())
                                  {
                                    if (paramArticleSummary.msg_account_v_info.uint32_is_unowned.get() == 1) {
                                      bool1 = true;
                                    } else {
                                      bool1 = false;
                                    }
                                    localVideoInfo.jdField_l_of_type_Boolean = bool1;
                                    localVideoInfo.jdField_n_of_type_Int = paramArticleSummary.msg_account_v_info.uint32_follow_count.get();
                                    if (paramArticleSummary.msg_account_v_info.uint32_is_show_follow.get() == 1) {
                                      bool1 = true;
                                    } else {
                                      bool1 = false;
                                    }
                                    localVideoInfo.jdField_j_of_type_Boolean = bool1;
                                  }
                                  if (paramArticleSummary.msg_like_download_bar_info.has())
                                  {
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LikeActionDownloadBar = new VideoInfo.LikeActionDownloadBar();
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LikeActionDownloadBar.jdField_b_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_like_download_bar_info.bytes_bar_text);
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LikeActionDownloadBar.jdField_a_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_like_download_bar_info.bytes_icon_url);
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LikeActionDownloadBar.jdField_c_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_like_download_bar_info.bytes_common_data);
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LikeActionDownloadBar.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo = new UrlJumpInfo();
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LikeActionDownloadBar.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_a_of_type_Int = ((oidb_0x6cf.UrlJumpInfo)paramArticleSummary.msg_like_download_bar_info.msg_url_jump_info.get()).uint32_jump_type.get();
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LikeActionDownloadBar.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_b_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.UrlJumpInfo)paramArticleSummary.msg_like_download_bar_info.msg_url_jump_info.get()).bytes_jump_bundle);
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LikeActionDownloadBar.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_c_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.UrlJumpInfo)paramArticleSummary.msg_like_download_bar_info.msg_url_jump_info.get()).bytes_jump_schema);
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LikeActionDownloadBar.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_a_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.UrlJumpInfo)paramArticleSummary.msg_like_download_bar_info.msg_url_jump_info.get()).bytes_jump_url);
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LikeActionDownloadBar.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_d_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.UrlJumpInfo)paramArticleSummary.msg_like_download_bar_info.msg_url_jump_info.get()).bytes_clipboard_info);
                                  }
                                  if (paramArticleSummary.msg_soft_ad_download_bar_info.has())
                                  {
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo = new VideoInfo.SoftAdDownloadBarInfo();
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_soft_ad_download_bar_info.bytes_title);
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo.jdField_b_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_soft_ad_download_bar_info.bytes_sub_title);
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo.jdField_c_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_soft_ad_download_bar_info.bytes_small_icon_url);
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo.jdField_d_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_soft_ad_download_bar_info.bytes_big_icon_url);
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_Int = paramArticleSummary.msg_soft_ad_download_bar_info.uint32_change_bigger_position.get();
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_soft_ad_download_bar_info.msg_url_jump_info);
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo.jdField_b_of_type_Int = paramArticleSummary.msg_soft_ad_download_bar_info.uint32_small_game_play_count.get();
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo.jdField_e_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_soft_ad_download_bar_info.bytes_small_game_rsp_pack);
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoAdSmallMiniGameInfo = SmallMiniGameInfo.a(localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo.jdField_e_of_type_JavaLangString);
                                  }
                                  if ((localVideoInfo.jdField_r_of_type_Boolean) && (localVideoInfo.t == 2)) {
                                    return null;
                                  }
                                  if (paramArticleSummary.msg_ecommerce_entrance_info.has())
                                  {
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo = new VideoInfo.ECommerceEntranceInfo();
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_ecommerce_entrance_info.bytes_title);
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_b_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_ecommerce_entrance_info.bytes_subtitle);
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_c_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_ecommerce_entrance_info.bytes_thumbnail_url);
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_d_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_ecommerce_entrance_info.bytes_link_icon_url);
                                    if (paramArticleSummary.msg_ecommerce_entrance_info.uint32_jump_type.has()) {
                                      localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_Int = paramArticleSummary.msg_ecommerce_entrance_info.uint32_jump_type.get();
                                    }
                                    if (paramArticleSummary.msg_ecommerce_entrance_info.uint32_ecommerce_id.has()) {
                                      localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_g_of_type_Int = paramArticleSummary.msg_ecommerce_entrance_info.uint32_ecommerce_id.get();
                                    }
                                    if (paramArticleSummary.msg_ecommerce_entrance_info.uint32_display_count_ver.has()) {
                                      localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_d_of_type_Int = paramArticleSummary.msg_ecommerce_entrance_info.uint32_display_count_ver.get();
                                    }
                                    if (paramArticleSummary.msg_ecommerce_entrance_info.uint32_one_day_max_display_count.has()) {
                                      localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_f_of_type_Int = paramArticleSummary.msg_ecommerce_entrance_info.uint32_one_day_max_display_count.get();
                                    }
                                    if (paramArticleSummary.msg_ecommerce_entrance_info.uint32_session_max_display_count.has()) {
                                      localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_e_of_type_Int = paramArticleSummary.msg_ecommerce_entrance_info.uint32_session_max_display_count.get();
                                    }
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_e_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_ecommerce_entrance_info.bytes_jump_url);
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_f_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_ecommerce_entrance_info.bytes_common_data);
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_c_of_type_Int = paramArticleSummary.msg_ecommerce_entrance_info.video_play_length.get();
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_Int = paramArticleSummary.msg_ecommerce_entrance_info.uint32_style.get();
                                    if (paramArticleSummary.msg_ecommerce_entrance_info.appInfo.has())
                                    {
                                      localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo = new UrlJumpInfo();
                                      localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_a_of_type_Int = ((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).uint32_jump_type.get();
                                      localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_b_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_jump_bundle);
                                      localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_c_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_jump_schema);
                                      localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_a_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_jump_url);
                                      localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_d_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_clipboard_info);
                                      localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_h_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_app_open_wording);
                                      localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_g_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_app_download_wording);
                                      localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_b_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_app_desc);
                                      localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_c_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_icon_url);
                                      localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_a_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_name);
                                    }
                                    if (QLog.isColorLevel())
                                    {
                                      localObject1 = new StringBuilder();
                                      ((StringBuilder)localObject1).append("commerceEntranceInfo: ");
                                      ((StringBuilder)localObject1).append(localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.toString());
                                      QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, ((StringBuilder)localObject1).toString());
                                    }
                                  }
                                  if ((paramRspBody.msg_ecommerce_entrance_config.has()) && (localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo != null) && (paramRspBody.msg_ecommerce_entrance_config.uint32_show_after_play_time.has())) {
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo.jdField_b_of_type_Int = paramRspBody.msg_ecommerce_entrance_config.uint32_show_after_play_time.get();
                                  }
                                  localVideoInfo.x = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.bytes_avatar_jump_url);
                                  if (paramArticleSummary.uint64_recommend_seq.has()) {
                                    l1 = paramArticleSummary.uint64_recommend_seq.get();
                                  }
                                  localVideoInfo.jdField_e_of_type_Long = l1;
                                  if (paramArticleSummary.uint32_is_first_page_use_gif.has())
                                  {
                                    if (paramArticleSummary.uint32_is_first_page_use_gif.get() == 1) {
                                      bool1 = true;
                                    } else {
                                      bool1 = false;
                                    }
                                    localVideoInfo.jdField_f_of_type_Boolean = bool1;
                                  }
                                  localVideoInfo.jdField_s_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.bytes_first_page_gif_url);
                                  if (paramArticleSummary.uint32_is_no_show_cover.has())
                                  {
                                    if (paramArticleSummary.uint32_is_no_show_cover.get() == 0) {
                                      bool1 = true;
                                    } else {
                                      bool1 = false;
                                    }
                                    localVideoInfo.jdField_g_of_type_Boolean = bool1;
                                  }
                                  VideoFeedsHelper.a(localVideoInfo);
                                  ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).parseKdTagInfo(paramArticleSummary, localVideoInfo);
                                  if (paramArticleSummary.video_column_info.has())
                                  {
                                    paramRspBody = new VideoColumnInfo();
                                    paramRspBody.jdField_a_of_type_Int = paramArticleSummary.video_column_info.uint32_column_id.get();
                                    paramRspBody.jdField_b_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.video_column_info.bytes_column_name);
                                    paramRspBody.jdField_c_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.video_column_info.bytes_column_icon_url);
                                    paramRspBody.jdField_c_of_type_Int = paramArticleSummary.video_column_info.uint32_subscribe_count.get();
                                    if (paramArticleSummary.video_column_info.uint32_is_subscribed.get() == 1) {
                                      bool1 = true;
                                    } else {
                                      bool1 = false;
                                    }
                                    paramRspBody.jdField_a_of_type_Boolean = bool1;
                                    paramRspBody.jdField_g_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.video_column_info.bytes_app_name);
                                    paramRspBody.jdField_h_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.video_column_info.bytes_app_icon_url);
                                    paramRspBody.jdField_c_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.video_column_info.subscribe_jump_info);
                                    paramRspBody.d = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.video_column_info.app_jump_info);
                                    paramRspBody.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.video_column_info.default_jump_info);
                                    paramRspBody.jdField_e_of_type_Int = paramArticleSummary.video_column_info.uint32_style.get();
                                    paramRspBody.i = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.video_column_info.bytes_from_txt);
                                    paramRspBody.jdField_b_of_type_Int = paramArticleSummary.video_column_info.uint32_video_count.get();
                                    paramRspBody.jdField_a_of_type_Long = paramArticleSummary.video_column_info.uint64_last_update_time.get();
                                    paramRspBody.jdField_f_of_type_Int = paramArticleSummary.video_column_info.uint32_update_count.get();
                                    localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityVideoColumnInfo = paramRspBody;
                                  }
                                  if ((paramArticleSummary.uint32_forbid_reprint_flag.has()) && (paramArticleSummary.uint32_forbid_reprint_flag.get() == 1)) {
                                    bool1 = true;
                                  } else {
                                    bool1 = false;
                                  }
                                  bool2 = true;
                                  localVideoInfo.jdField_k_of_type_Boolean = bool1;
                                  localVideoInfo.jdField_v_of_type_JavaLangString = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.bytes_wechat_share_url);
                                  if (paramArticleSummary.is_pgc_ahthor.get() == 1) {
                                    bool1 = bool2;
                                  } else {
                                    bool1 = false;
                                  }
                                  localVideoInfo.jdField_m_of_type_Boolean = bool1;
                                  paramRspBody = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.bytes_title_with_topic);
                                  if (!TextUtils.isEmpty(paramRspBody))
                                  {
                                    localVideoInfo.b(paramRspBody);
                                    if (QLog.isColorLevel())
                                    {
                                      localObject1 = new StringBuilder();
                                      ((StringBuilder)localObject1).append("decodeArticleSummary: richTitleJson=");
                                      ((StringBuilder)localObject1).append(paramRspBody);
                                      QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, ((StringBuilder)localObject1).toString());
                                    }
                                  }
                                  if (paramArticleSummary.msg_subscript_20.get() != null)
                                  {
                                    paramRspBody = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_subscript_20.bytes_subscript_txt);
                                    if (!TextUtils.isEmpty(paramRspBody))
                                    {
                                      localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SubscriptInfo = new VideoInfo.SubscriptInfo();
                                      localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SubscriptInfo.jdField_a_of_type_JavaLangString = paramRspBody;
                                      localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SubscriptInfo.jdField_c_of_type_Int = paramArticleSummary.msg_subscript_20.uint32_subscript_type.get();
                                      localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SubscriptInfo.jdField_a_of_type_Int = Color.parseColor(((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_subscript_20.bytes_subscript_color));
                                      localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SubscriptInfo.jdField_b_of_type_Int = Color.parseColor(((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_subscript_20.bytes_background_color));
                                    }
                                  }
                                  if (paramArticleSummary.uint32_share_count.has()) {
                                    localVideoInfo.jdField_v_of_type_Int = paramArticleSummary.uint32_share_count.get();
                                  }
                                  ((VideoPlayRecommendHandler)localObject2).a(((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.bytes_location_info), localVideoInfo);
                                  localVideoInfo.y = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.bytes_strategy_ids);
                                  return localVideoInfo;
                                  localException3 = localException3;
                                  break;
                                  localException4 = localException4;
                                  break label130;
                                  localException1 = localException1;
                                  break label166;
                                  localException5 = localException5;
                                  continue;
                                  localException6 = localException6;
                                  continue;
                                  localException7 = localException7;
                                  continue;
                                  localException8 = localException8;
                                  continue;
                                  localException9 = localException9;
                                  continue;
                                  localException10 = localException10;
                                  continue;
                                  localException11 = localException11;
                                  continue;
                                  localException12 = localException12;
                                  continue;
                                  localException13 = localException13;
                                  continue;
                                  localException14 = localException14;
                                }
                              }
                              catch (Exception localException15)
                              {
                                break label647;
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    localObject2 = null;
  }
  
  public VideoInfo.EntranceDownloadInfo a(oidb_0x6cf.EntranceDownloadInfo paramEntranceDownloadInfo)
  {
    if (paramEntranceDownloadInfo == null) {
      return null;
    }
    VideoInfo.EntranceDownloadInfo localEntranceDownloadInfo = new VideoInfo.EntranceDownloadInfo();
    localEntranceDownloadInfo.jdField_a_of_type_JavaLangString = a(paramEntranceDownloadInfo.bytes_icon_url);
    localEntranceDownloadInfo.jdField_b_of_type_JavaLangString = a(paramEntranceDownloadInfo.bytes_small_icon_url);
    boolean bool2 = paramEntranceDownloadInfo.uint32_is_use_gif.has();
    boolean bool1 = false;
    int i;
    if (bool2) {
      i = paramEntranceDownloadInfo.uint32_is_use_gif.get();
    } else {
      i = 0;
    }
    if (i > 0) {
      bool1 = true;
    }
    localEntranceDownloadInfo.jdField_a_of_type_Boolean = bool1;
    localEntranceDownloadInfo.jdField_c_of_type_JavaLangString = a(paramEntranceDownloadInfo.bytes_common_data);
    localEntranceDownloadInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo = a(paramEntranceDownloadInfo.msg_url_jump_info);
    return localEntranceDownloadInfo;
  }
  
  public UrlJumpInfo a(oidb_0x6cf.UrlJumpInfo paramUrlJumpInfo)
  {
    if ((paramUrlJumpInfo != null) && (paramUrlJumpInfo.has()) && (paramUrlJumpInfo.get() != null))
    {
      UrlJumpInfo localUrlJumpInfo = new UrlJumpInfo();
      int i;
      if (paramUrlJumpInfo.uint32_jump_type.has()) {
        i = paramUrlJumpInfo.uint32_jump_type.get();
      } else {
        i = 0;
      }
      localUrlJumpInfo.jdField_a_of_type_Int = i;
      localUrlJumpInfo.jdField_c_of_type_JavaLangString = a(paramUrlJumpInfo.bytes_jump_schema);
      localUrlJumpInfo.jdField_b_of_type_JavaLangString = a(paramUrlJumpInfo.bytes_jump_bundle);
      localUrlJumpInfo.jdField_a_of_type_JavaLangString = a(paramUrlJumpInfo.bytes_jump_url);
      localUrlJumpInfo.jdField_d_of_type_JavaLangString = a(paramUrlJumpInfo.bytes_clipboard_info);
      localUrlJumpInfo.jdField_e_of_type_JavaLangString = a(paramUrlJumpInfo.bytes_common_data);
      return localUrlJumpInfo;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(VideoPlayRecommendObserver paramVideoPlayRecommendObserver, long paramLong1, VideoInfo paramVideoInfo, int paramInt1, ArrayList<VideoInfo> paramArrayList1, String paramString1, long paramLong2, boolean paramBoolean, int paramInt2, String paramString2, String paramString3, WeishiRedDotInfo paramWeishiRedDotInfo, int paramInt3, String paramString4, byte[] paramArrayOfByte, int paramInt4, ArrayList<VideoInfo> paramArrayList2, int paramInt5)
  {
    a(paramVideoPlayRecommendObserver, paramLong1, paramVideoInfo, paramInt1, paramArrayList1, paramString1, paramLong2, paramBoolean, paramInt2, paramString2, paramString3, paramWeishiRedDotInfo, paramInt3, paramString4, paramArrayOfByte, paramInt4, paramArrayList2, null, paramInt5);
  }
  
  public void a(VideoPlayRecommendObserver paramVideoPlayRecommendObserver, long paramLong1, VideoInfo paramVideoInfo, int paramInt1, ArrayList<VideoInfo> paramArrayList1, String paramString1, long paramLong2, boolean paramBoolean, int paramInt2, String paramString2, String paramString3, WeishiRedDotInfo paramWeishiRedDotInfo, int paramInt3, String paramString4, byte[] paramArrayOfByte, int paramInt4, ArrayList<VideoInfo> paramArrayList2, Bundle paramBundle, int paramInt5)
  {
    if (paramVideoInfo == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 4, "getRecommendList()  videoInfo == null, RETURN");
      }
      return;
    }
    ThreadManager.post(new VideoPlayRecommendHandler.1(this, paramVideoPlayRecommendObserver, paramLong1, paramVideoInfo, paramInt1, paramArrayList1, paramString1, paramLong2, paramBoolean, paramInt2, paramString2, paramString3, paramWeishiRedDotInfo, paramInt3, paramString4, paramArrayOfByte, paramInt4, paramArrayList2, paramBundle, paramInt5), 5, null, true);
  }
  
  public void a(VideoPlayRecommendObserver paramVideoPlayRecommendObserver, long paramLong1, VideoInfo paramVideoInfo, int paramInt1, ArrayList<VideoInfo> paramArrayList1, String paramString1, long paramLong2, boolean paramBoolean, int paramInt2, String paramString2, String paramString3, WeishiRedDotInfo paramWeishiRedDotInfo, int paramInt3, String paramString4, byte[] paramArrayOfByte, ArrayList<VideoInfo.AdTagInfo> paramArrayList, int paramInt4, int paramInt5, int paramInt6, ArrayList<VideoInfo> paramArrayList2, int paramInt7)
  {
    if (paramVideoInfo == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 4, "getRecommendList()  videoInfo == null, RETURN");
      }
      return;
    }
    ThreadManager.post(new VideoPlayRecommendHandler.2(this, paramArrayList, paramVideoPlayRecommendObserver, paramLong1, paramVideoInfo, paramInt1, paramArrayList1, paramString1, paramLong2, paramBoolean, paramInt2, paramString2, paramString3, paramWeishiRedDotInfo, paramInt3, paramString4, paramArrayOfByte, paramInt4, paramInt5, paramInt6, paramArrayList2, paramInt7), 5, null, true);
  }
  
  public void a(VideoPlayRecommendObserver paramVideoPlayRecommendObserver, long paramLong, String paramString, int paramInt, VideoInfo paramVideoInfo)
  {
    ThreadManager.post(new VideoPlayRecommendHandler.3(this, paramLong, paramInt, paramString, paramVideoPlayRecommendObserver, paramVideoInfo), 5, null, true);
  }
  
  public void a(VideoPlayRecommendObserver paramVideoPlayRecommendObserver, String paramString, int paramInt, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return VideoPlayRecommendObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoPlayRecommendHandler
 * JD-Core Version:    0.7.0.1
 */