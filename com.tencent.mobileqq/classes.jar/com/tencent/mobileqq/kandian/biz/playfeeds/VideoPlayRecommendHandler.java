package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
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
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
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
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
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
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class VideoPlayRecommendHandler
  extends BusinessHandler
  implements VideoPlayRecommendConstants
{
  private long a;
  private SimpleDateFormat b;
  private int c;
  private String[] d = { "com.tencent.reading", "com.tencent.rijvideo", "com.tencent.weishi" };
  
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
      localECommerceEntranceInfo2.a = a(paramInterruptedWeishiAd.msg_ecommerce_entrance_info.bytes_title);
      localECommerceEntranceInfo2.b = a(paramInterruptedWeishiAd.msg_ecommerce_entrance_info.bytes_subtitle);
      localECommerceEntranceInfo2.c = a(paramInterruptedWeishiAd.msg_ecommerce_entrance_info.bytes_thumbnail_url);
      localECommerceEntranceInfo2.d = a(paramInterruptedWeishiAd.msg_ecommerce_entrance_info.bytes_link_icon_url);
      if (paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_jump_type.has()) {
        localECommerceEntranceInfo2.e = paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_jump_type.get();
      }
      if (paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_ecommerce_id.has()) {
        localECommerceEntranceInfo2.n = paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_ecommerce_id.get();
      }
      if (paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_display_count_ver.has()) {
        localECommerceEntranceInfo2.k = paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_display_count_ver.get();
      }
      if (paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_one_day_max_display_count.has()) {
        localECommerceEntranceInfo2.m = paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_one_day_max_display_count.get();
      }
      if (paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_session_max_display_count.has()) {
        localECommerceEntranceInfo2.l = paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_session_max_display_count.get();
      }
      localECommerceEntranceInfo2.f = a(paramInterruptedWeishiAd.msg_ecommerce_entrance_info.bytes_jump_url);
      localECommerceEntranceInfo2.j = a(paramInterruptedWeishiAd.msg_ecommerce_entrance_info.bytes_common_data);
      localECommerceEntranceInfo2.o = paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_style.get();
      localECommerceEntranceInfo1 = localECommerceEntranceInfo2;
      if (paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.has())
      {
        localECommerceEntranceInfo2.p = new UrlJumpInfo();
        localECommerceEntranceInfo2.p.a = ((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).uint32_jump_type.get();
        localECommerceEntranceInfo2.p.c = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_jump_bundle);
        localECommerceEntranceInfo2.p.d = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_jump_schema);
        localECommerceEntranceInfo2.p.b = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_jump_url);
        localECommerceEntranceInfo2.p.e = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_clipboard_info);
        localECommerceEntranceInfo2.r = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_app_open_wording);
        localECommerceEntranceInfo2.q = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_app_download_wording);
        localECommerceEntranceInfo2.b = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_app_desc);
        localECommerceEntranceInfo2.c = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_icon_url);
        localECommerceEntranceInfo2.a = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_name);
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
        localECommerceEntranceInfo1.h = paramRspBody.msg_ecommerce_entrance_config.uint32_show_after_play_time.get();
      }
      paramInterruptedWeishiAd = a(paramRspBody.msg_ecommerce_entrance_config.bytes_show_positon);
      if (!TextUtils.isEmpty(paramInterruptedWeishiAd))
      {
        paramInterruptedWeishiAd = paramInterruptedWeishiAd.split(",");
        if ((paramInterruptedWeishiAd != null) && (paramInterruptedWeishiAd.length > 0))
        {
          localECommerceEntranceInfo1.g = new int[paramInterruptedWeishiAd.length];
          i = 0;
        }
      }
    }
    for (;;)
    {
      if (i < paramInterruptedWeishiAd.length) {}
      try
      {
        localECommerceEntranceInfo1.g[i] = Integer.parseInt(paramInterruptedWeishiAd[i]);
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
      if ((TextUtils.isEmpty(localVideoInfo.g)) && (QLog.isColorLevel())) {
        QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "req_article_summary getRecommendList 获取原文章标题, NULL ERROR");
      }
      if ((paramArticleSummary.bytes_inner_id.has()) && (paramArticleSummary.bytes_inner_id.get() != null)) {
        localVideoInfo.l = paramArticleSummary.bytes_inner_id.get().toStringUtf8();
      }
      if (paramArticleSummary.uint64_article_id.has()) {
        localVideoInfo.u = paramArticleSummary.uint64_article_id.get();
      }
      if (paramRspBody.msg_interrupted_ad_weishi.has())
      {
        paramRspBody = (oidb_0x6cf.InterruptedWeishiAd)paramRspBody.msg_interrupted_ad_weishi.get();
        localVideoInfo.aE = new VideoInfo.InterruptedWeishiAd();
        localVideoInfo.aE.e = a(paramRspBody.bytes_ad_url);
        paramArticleSummary = localVideoInfo.aE;
        boolean bool1 = paramRspBody.uint32_is_show_in_play_end.has();
        boolean bool2 = true;
        j = 0;
        if ((bool1) && (paramRspBody.uint32_is_show_in_play_end.get() == 1)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        paramArticleSummary.c = bool1;
        paramArticleSummary = localVideoInfo.aE;
        if ((paramRspBody.uint32_is_show_in_switch.has()) && (paramRspBody.uint32_is_show_in_switch.get() == 1)) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
        paramArticleSummary.b = bool1;
        paramArticleSummary = localVideoInfo.aE;
        if (paramRspBody.uint32_show_after_play_time.has()) {
          i = paramRspBody.uint32_show_after_play_time.get();
        } else {
          i = -1;
        }
        paramArticleSummary.d = i;
        paramArticleSummary = a(paramRspBody.bytes_show_positon);
        if (paramArticleSummary != null) {
          paramArticleSummary = paramArticleSummary.split(",");
        } else {
          paramArticleSummary = null;
        }
        if ((paramArticleSummary != null) && (paramArticleSummary.length > 0))
        {
          localVideoInfo.aE.a = new int[paramArticleSummary.length];
          i = 0;
        }
      }
    }
    for (;;)
    {
      if (i < paramArticleSummary.length) {}
      try
      {
        localVideoInfo.aE.a[i] = Integer.parseInt(paramArticleSummary[i]);
        label344:
        i += 1;
        continue;
        paramArticleSummary = localVideoInfo.aE;
        i = j;
        if (paramRspBody.uint32_interrupted_ad_type.has()) {
          i = paramRspBody.uint32_interrupted_ad_type.get();
        }
        paramArticleSummary.f = i;
        if (paramRspBody.appInfo.has())
        {
          localVideoInfo.aE.i = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_app_download_wording);
          localVideoInfo.aE.j = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_app_open_wording);
          localVideoInfo.aE.g = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_name);
          localVideoInfo.aE.h = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_icon_url);
          localVideoInfo.aE.k = new UrlJumpInfo();
          localVideoInfo.aE.k.a = ((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).uint32_jump_type.get();
          localVideoInfo.aE.k.c = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_jump_bundle);
          localVideoInfo.aE.k.d = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_jump_schema);
          localVideoInfo.aE.k.b = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_jump_url);
        }
        return localVideoInfo;
      }
      catch (Exception localException)
      {
        break label344;
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
  
  private void a(ToServiceMsg paramToServiceMsg, Bundle paramBundle, ArrayList<VideoInfo> paramArrayList, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      Object localObject = paramToServiceMsg.getAttribute("is_from_first_recommend_video");
      if ((localObject != null) && ((localObject instanceof Boolean))) {
        paramBundle.putBoolean("is_from_first_recommend_video", ((Boolean)localObject).booleanValue());
      }
      paramBundle.putString("VALUE_REQUEST_VIDEO_ARTICLE_ID", (String)paramToServiceMsg.getAttribute("VALUE_REQUEST_VIDEO_ARTICLE_ID"));
      ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).putAdTagIntoBundle(paramBundle, paramArrayList);
      paramBundle.putBoolean("VALUE_REQUEST_GAME_DATA", false);
    }
    else
    {
      paramBundle.putBoolean("VALUE_REQUEST_GAME_DATA", true);
    }
    paramToServiceMsg = paramToServiceMsg.getAttribute("VALUE_OBSERVER_TAG");
    if ((paramToServiceMsg instanceof Integer)) {
      paramBundle.putInt("VALUE_OBSERVER_TAG", ((Integer)paramToServiceMsg).intValue());
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Bundle localBundle = new Bundle();
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleGetRecommendList onReceive :");
      paramFromServiceMsg.append(bool1);
      QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, paramFromServiceMsg.toString());
    }
    boolean bool3 = ((Boolean)paramToServiceMsg.getAttribute("VALUE_REQUEST_GAME_DATA", Boolean.valueOf(false))).booleanValue();
    if (bool1) {}
    for (;;)
    {
      Object localObject3;
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        bool2 = paramFromServiceMsg.uint32_result.has();
        if ((bool2) && (paramFromServiceMsg.uint32_result.get() == 83))
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, 热门长视频黑名单");
          }
          localBundle.putBoolean("VALUE_USER_IN_BLACK", true);
        }
        else
        {
          localBundle.putBoolean("VALUE_USER_IN_BLACK", false);
        }
        paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
        oidb_0x6cf.RspBody localRspBody = new oidb_0x6cf.RspBody();
        localRspBody.mergeFrom(paramFromServiceMsg);
        if (localRspBody.uint64_pos_ad_time.has()) {
          this.a = localRspBody.uint64_pos_ad_time.get();
        }
        if ((localRspBody.bytes_cookie.has()) && (localRspBody.bytes_cookie.get() != null)) {
          localBundle.putString("VALUE_COOKIE", localRspBody.bytes_cookie.get().toStringUtf8());
        }
        if (!localRspBody.bytes_ads_context.has()) {
          break label1528;
        }
        localObject5 = localRspBody.bytes_ads_context.get().toStringUtf8();
        i = 1;
        if (this.b == null) {
          this.b = new SimpleDateFormat("yyyy-MM-dd");
        }
        if (!bool3)
        {
          Object localObject4;
          if ((localRspBody.rpt_article_list.has()) && (localRspBody.rpt_article_list.get() != null))
          {
            Object localObject2 = localRspBody.rpt_article_list.get();
            if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
            {
              paramFromServiceMsg = new ArrayList(((List)localObject2).size());
              try
              {
                paramObject = new ArrayList(paramFromServiceMsg.size());
                try
                {
                  bool2 = QLog.isColorLevel();
                  if (bool2) {
                    try
                    {
                      StringBuilder localStringBuilder = new StringBuilder();
                      localStringBuilder.append("handleGetRecommendList, 解析推荐视频列表: article size=");
                      localStringBuilder.append(((List)localObject2).size());
                      QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, localStringBuilder.toString());
                    }
                    catch (Exception localException1)
                    {
                      break label1419;
                    }
                  }
                  localObject4 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
                  localObject6 = new StringBuilder();
                  Object localObject1 = paramFromServiceMsg;
                  try
                  {
                    ((StringBuilder)localObject6).append("视频浮层混排回包: article size=");
                    localObject1 = paramFromServiceMsg;
                    ((StringBuilder)localObject6).append(((List)localObject2).size());
                    localObject1 = paramFromServiceMsg;
                    ((IRIJAdLogService)localObject4).d("AdVideoDataLink", ((StringBuilder)localObject6).toString());
                    localObject1 = paramFromServiceMsg;
                    localObject4 = ((List)localObject2).iterator();
                    localObject1 = paramFromServiceMsg;
                    if (((Iterator)localObject4).hasNext())
                    {
                      localObject1 = paramFromServiceMsg;
                      localObject2 = (oidb_0x6cf.ArticleSummary)((Iterator)localObject4).next();
                      try
                      {
                        localObject1 = b((oidb_0x6cf.ArticleSummary)localObject2, localRspBody);
                        if (localObject1 != null)
                        {
                          if (QLog.isColorLevel())
                          {
                            localObject2 = new StringBuilder();
                            ((StringBuilder)localObject2).append("handleGetRecommendList，解析推荐视频列表：article = ");
                            ((StringBuilder)localObject2).append(((VideoInfo)localObject1).q());
                            QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, ((StringBuilder)localObject2).toString());
                          }
                          paramFromServiceMsg.add(localObject1);
                          paramObject.add(((VideoInfo)localObject1).q);
                          localObject2 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
                          localObject6 = new StringBuilder();
                          try
                          {
                            ((StringBuilder)localObject6).append("isAd = ");
                            ((StringBuilder)localObject6).append(((VideoInfo)localObject1).aq);
                            ((StringBuilder)localObject6).append(" article = ");
                            ((StringBuilder)localObject6).append(((VideoInfo)localObject1).g);
                            ((IRIJAdLogService)localObject2).d("AdVideoDataLink", ((StringBuilder)localObject6).toString());
                          }
                          catch (Exception localException2) {}
                        }
                      }
                      catch (Exception localException3)
                      {
                        localObject2 = paramFromServiceMsg;
                      }
                      try
                      {
                        if (QLog.isColorLevel())
                        {
                          localObject6 = new StringBuilder();
                          ((StringBuilder)localObject6).append("getRecommendList, ERROR e=");
                          ((StringBuilder)localObject6).append(localException3.getMessage());
                          QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, ((StringBuilder)localObject6).toString());
                        }
                      }
                      catch (Exception localException4)
                      {
                        paramFromServiceMsg = (FromServiceMsg)localObject2;
                      }
                    }
                  }
                  catch (Exception localException11)
                  {
                    paramFromServiceMsg = localException4;
                    Exception localException5 = localException11;
                  }
                }
                catch (Exception localException6) {}
                paramFromServiceMsg = null;
              }
              catch (Exception localException7) {}
            }
            paramObject = null;
            if (paramFromServiceMsg != null)
            {
              localObject4 = paramFromServiceMsg;
              localObject3 = paramObject;
            }
          }
          try
          {
            if (paramFromServiceMsg.isEmpty())
            {
              localObject4 = paramFromServiceMsg;
              localObject3 = paramObject;
              if (QLog.isColorLevel())
              {
                localObject4 = paramFromServiceMsg;
                localObject3 = paramObject;
                QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, 返回的rpt_article_list 中合法数据为空");
              }
            }
            localObject4 = paramFromServiceMsg;
            localObject3 = paramObject;
            a(paramFromServiceMsg);
            localObject4 = paramFromServiceMsg;
            localObject3 = paramObject;
            localBundle.putParcelableArrayList("VIDEO_RECOMMEND_LIST", paramFromServiceMsg);
          }
          catch (Exception localException8)
          {
            try
            {
              if (QLog.isColorLevel()) {
                QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, 返回的rpt_article_list null");
              }
              paramFromServiceMsg = null;
              paramObject = null;
              if (i != 0)
              {
                localObject4 = paramFromServiceMsg;
                localObject3 = paramObject;
                ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).saveAdCookie((String)localObject5);
              }
              localObject4 = paramFromServiceMsg;
              localObject3 = paramObject;
              if (localRspBody.req_article_summary.has())
              {
                localObject4 = paramFromServiceMsg;
                localObject3 = paramObject;
                if (localRspBody.req_article_summary.get() != null)
                {
                  localObject4 = paramFromServiceMsg;
                  localObject3 = paramObject;
                  localObject5 = a((oidb_0x6cf.ArticleSummary)localRspBody.req_article_summary.get(), localRspBody);
                  localObject4 = paramFromServiceMsg;
                  localObject3 = paramObject;
                  if (QLog.isColorLevel())
                  {
                    localObject4 = paramFromServiceMsg;
                    localObject3 = paramObject;
                    localObject6 = new StringBuilder();
                    localObject4 = paramFromServiceMsg;
                    localObject3 = paramObject;
                    ((StringBuilder)localObject6).append("handleGetRecommendList，解析第一个视频的详细信息：firstVideoInfo = ");
                    if (localObject5 == null) {
                      break label1537;
                    }
                    localObject4 = paramFromServiceMsg;
                    localObject3 = paramObject;
                    String str1 = ((VideoInfo)localObject5).q();
                    localObject4 = paramFromServiceMsg;
                    localObject3 = paramObject;
                    ((StringBuilder)localObject6).append(str1);
                    localObject4 = paramFromServiceMsg;
                    localObject3 = paramObject;
                    QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, ((StringBuilder)localObject6).toString());
                  }
                  localObject4 = paramFromServiceMsg;
                  localObject3 = paramObject;
                  localBundle.putParcelable("VALUE_REQUEST_VIDEO_DETAIL_INFO", (Parcelable)localObject5);
                  continue;
                }
              }
              localObject4 = paramFromServiceMsg;
              localObject3 = paramObject;
              if (QLog.isColorLevel())
              {
                localObject4 = paramFromServiceMsg;
                localObject3 = paramObject;
                QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "handleGetRecommendList: 返回的req_article_summary null");
              }
              localObject4 = paramFromServiceMsg;
              localObject3 = paramObject;
              if (localRspBody.msg_ecommerce_entrance_config.has())
              {
                localObject4 = paramFromServiceMsg;
                localObject3 = paramObject;
                if (localRspBody.msg_ecommerce_entrance_config.get() != null)
                {
                  localObject4 = paramFromServiceMsg;
                  localObject3 = paramObject;
                  localBundle.putParcelable("VALUE_ECOMMERCE_ENTRANCE_INFO", a((oidb_0x6cf.InterruptedWeishiAd)localRspBody.msg_ecommerce_entrance_config.get(), localRspBody));
                }
              }
              localObject4 = paramFromServiceMsg;
              localObject3 = paramObject;
              if (localRspBody.uint32_is_end.has())
              {
                localObject4 = paramFromServiceMsg;
                localObject3 = paramObject;
                if (localRspBody.uint32_is_end.get() != 0) {
                  break label1545;
                }
                bool2 = true;
                localObject4 = paramFromServiceMsg;
                localObject3 = paramObject;
                localBundle.putBoolean("VALUE_HAS_MORE_DATA", bool2);
              }
              localObject4 = paramFromServiceMsg;
              localObject3 = paramObject;
              if (localRspBody.msg_entrance_download_info.has())
              {
                localObject4 = paramFromServiceMsg;
                localObject3 = paramObject;
                if (localRspBody.msg_entrance_download_info.get() != null)
                {
                  localObject4 = paramFromServiceMsg;
                  localObject3 = paramObject;
                  localBundle.putParcelable("value_entrance_download_info", a((oidb_0x6cf.EntranceDownloadInfo)localRspBody.msg_entrance_download_info.get()));
                }
              }
              localObject4 = paramFromServiceMsg;
              localObject3 = paramObject;
              localObject6 = paramFromServiceMsg;
              localObject5 = paramObject;
              if (!localRspBody.uint32_auto_play_mode.has()) {
                break label1501;
              }
              localObject4 = paramFromServiceMsg;
              localObject3 = paramObject;
              localBundle.putInt("value_autoplay_mode", localRspBody.uint32_auto_play_mode.get());
              localObject6 = paramFromServiceMsg;
              localObject5 = paramObject;
            }
            catch (Exception localException9)
            {
              break label1415;
            }
            localException8 = localException8;
            paramFromServiceMsg = (FromServiceMsg)localObject4;
            paramObject = localObject3;
            break label1419;
          }
        }
        else
        {
          ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).parseTagInfoResult(localRspBody, localBundle, this.a);
        }
      }
      catch (Exception localException10) {}
      label1415:
      paramFromServiceMsg = null;
      paramObject = null;
      label1419:
      Object localObject6 = paramFromServiceMsg;
      Object localObject5 = paramObject;
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("getRecommendList, ERROR e=");
        ((StringBuilder)localObject3).append(localException10.getMessage());
        QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, ((StringBuilder)localObject3).toString());
        localObject6 = paramFromServiceMsg;
        localObject5 = paramObject;
        break label1501;
        if (QLog.isColorLevel()) {
          QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, 返回的rpt_article_list null 或者直接出错了");
        }
        localObject6 = null;
        localObject5 = null;
      }
      label1501:
      ReadInJoyUserInfoModule.a((List)localObject5);
      a(paramToServiceMsg, localBundle, (ArrayList)localObject6, bool3);
      super.notifyUI(0, bool1, localBundle);
      return;
      label1528:
      localObject5 = null;
      int i = 0;
      continue;
      label1537:
      String str2 = "null";
      continue;
      label1545:
      boolean bool2 = false;
    }
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
        localLocationInfo.b = paramString.optString("location_name", null);
        int i = paramString.optInt("is_user_selected", 0);
        bool = true;
        if (i != 1) {
          break label126;
        }
        localLocationInfo.a = bool;
        if (!TextUtils.isEmpty(localLocationInfo.b))
        {
          paramVideoInfo.aN = localLocationInfo;
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
        if ((localVideoInfo.aq) && (localVideoInfo.as != null) && (localVideoInfo.as.ae == 32))
        {
          localVideoInfo = (VideoInfo)((IRIJAdExposeFreshService)QRoute.api(IRIJAdExposeFreshService.class)).replace("RIJAdRefreshSceneFloatVideo", localVideoInfo);
          paramList.set(i, localVideoInfo);
          localHashSet1.add(Long.valueOf(localVideoInfo.as.G));
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
    String[] arrayOfString = this.d;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      oidb_0x6cf.PkgInstallInfo localPkgInstallInfo = new oidb_0x6cf.PkgInstallInfo();
      localPkgInstallInfo.bytes_pkg_name.set(ByteStringMicro.copyFromUtf8(str));
      str = PackageUtil.b(BaseApplicationImpl.getContext(), str);
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
      if (paramVideoInfo.as == null) {
        return false;
      }
      if (paramVideoInfo.ar == 2)
      {
        if ((!TextUtils.isEmpty(paramVideoInfo.B)) && (!TextUtils.isEmpty(paramVideoInfo.g)) && (!TextUtils.isEmpty(paramVideoInfo.f)) && (!TextUtils.isEmpty(paramVideoInfo.k))) {
          return true;
        }
      }
      else if ((paramVideoInfo.ar == 1) && (!TextUtils.isEmpty(paramVideoInfo.B)) && (!TextUtils.isEmpty(paramVideoInfo.r)) && (!TextUtils.isEmpty(paramVideoInfo.g)) && (!TextUtils.isEmpty(paramVideoInfo.b)) && (!TextUtils.isEmpty(paramVideoInfo.k))) {
        return true;
      }
    }
    return false;
  }
  
  private VideoInfo b(oidb_0x6cf.ArticleSummary paramArticleSummary, oidb_0x6cf.RspBody paramRspBody)
  {
    localVideoInfo = new VideoInfo();
    if ((paramArticleSummary.bytes_article_title.has()) && (paramArticleSummary.bytes_article_title.get() != null)) {
      localVideoInfo.g = paramArticleSummary.bytes_article_title.get().toStringUtf8();
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
                              localVideoInfo.az = new UGDownloadInfo();
                              localVideoInfo.az.a = ((String)localObject5);
                              localVideoInfo.az.b = ((String)localObject6);
                              localVideoInfo.az.c = ((String)localObject7);
                              localVideoInfo.az.d = str1;
                              localVideoInfo.az.e = str2;
                              localVideoInfo.az.f = str3;
                              localVideoInfo.az.g = str4;
                              localVideoInfo.az.h = str5;
                              localVideoInfo.az.i = ((String)localObject8);
                              localVideoInfo.az.j = str6;
                              localVideoInfo.az.k = str7;
                              localVideoInfo.az.l = str8;
                              localVideoInfo.az.m = str9;
                              localVideoInfo.az.n = i;
                              localVideoInfo.az.o = j;
                              localObject5 = localVideoInfo.az;
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
                                ((UGDownloadInfo)localObject5).p = ((String)localObject1);
                                localVideoInfo.az.q = k;
                                break label956;
                                if ((k != 1) || (TextUtils.isEmpty((CharSequence)localObject5)) || (TextUtils.isEmpty((CharSequence)localObject6)) || (TextUtils.isEmpty((CharSequence)localObject7)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str5)) || (TextUtils.isEmpty((CharSequence)localObject8)) || (TextUtils.isEmpty(str6)) || (TextUtils.isEmpty(str7)) || (TextUtils.isEmpty(str8)) || (TextUtils.isEmpty(str9))) {
                                  break label932;
                                }
                                localVideoInfo.az = new UGDownloadInfo();
                                localVideoInfo.az.a = ((String)localObject5);
                                localVideoInfo.az.b = ((String)localObject6);
                                localVideoInfo.az.c = ((String)localObject7);
                                localVideoInfo.az.d = str1;
                                localVideoInfo.az.e = str2;
                                localVideoInfo.az.f = str3;
                                localVideoInfo.az.g = str4;
                                localVideoInfo.az.h = str5;
                                localVideoInfo.az.i = ((String)localObject8);
                                localVideoInfo.az.j = str6;
                                localVideoInfo.az.k = str7;
                                localVideoInfo.az.l = str8;
                                localVideoInfo.az.m = str9;
                                localVideoInfo.az.n = i;
                                localVideoInfo.az.o = j;
                                Object localObject5 = localVideoInfo.az;
                                for (;;)
                                {
                                  try
                                  {
                                    ((UGDownloadInfo)localObject5).p = ((String)localObject1);
                                    localVideoInfo.az.q = k;
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
                                        localVideoInfo.aA = new UGDownloadInfo();
                                        localVideoInfo.aA.a = ((String)localObject5);
                                        localVideoInfo.aA.b = ((String)localObject6);
                                        localVideoInfo.aA.c = ((String)localObject7);
                                        localVideoInfo.aA.d = str1;
                                        localVideoInfo.aA.e = str2;
                                        localVideoInfo.aA.f = str3;
                                        localVideoInfo.aA.g = str4;
                                        localVideoInfo.aA.h = str5;
                                        localVideoInfo.aA.i = ((String)localObject8);
                                        localVideoInfo.aA.j = str6;
                                        localVideoInfo.aA.k = str7;
                                        localVideoInfo.aA.l = str8;
                                        localVideoInfo.aA.m = str9;
                                        localVideoInfo.aA.n = i;
                                        localVideoInfo.aA.o = j;
                                        localVideoInfo.aA.p = ((String)localObject1);
                                        localVideoInfo.aA.q = k;
                                      }
                                    }
                                    else if ((k == 1) && (!TextUtils.isEmpty((CharSequence)localObject5)) && (!TextUtils.isEmpty((CharSequence)localObject6)) && (!TextUtils.isEmpty((CharSequence)localObject7)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str5)) && (!TextUtils.isEmpty((CharSequence)localObject8)) && (!TextUtils.isEmpty(str6)) && (!TextUtils.isEmpty(str7)) && (!TextUtils.isEmpty(str8)) && (!TextUtils.isEmpty(str9)))
                                    {
                                      localVideoInfo.aA = new UGDownloadInfo();
                                      localVideoInfo.aA.a = ((String)localObject5);
                                      localVideoInfo.aA.b = ((String)localObject6);
                                      localVideoInfo.aA.c = ((String)localObject7);
                                      localVideoInfo.aA.d = str1;
                                      localVideoInfo.aA.e = str2;
                                      localVideoInfo.aA.f = str3;
                                      localVideoInfo.aA.g = str4;
                                      localVideoInfo.aA.h = str5;
                                      localVideoInfo.aA.i = ((String)localObject8);
                                      localVideoInfo.aA.j = str6;
                                      localVideoInfo.aA.k = str7;
                                      localVideoInfo.aA.l = str8;
                                      localVideoInfo.aA.m = str9;
                                      localVideoInfo.aA.n = i;
                                      localVideoInfo.aA.o = j;
                                      localVideoInfo.aA.p = ((String)localObject1);
                                      localVideoInfo.aA.q = k;
                                    }
                                  }
                                  catch (Exception localException2)
                                  {
                                    boolean bool1;
                                    long l1;
                                    continue;
                                  }
                                  if ((paramArticleSummary.bytes_article_summary.has()) && (paramArticleSummary.bytes_article_summary.get() != null)) {
                                    localVideoInfo.h = paramArticleSummary.bytes_article_summary.get().toStringUtf8();
                                  }
                                  if ((paramArticleSummary.rpt_dislike_list.has()) && (paramArticleSummary.rpt_dislike_list.get() != null))
                                  {
                                    localObject1 = paramArticleSummary.rpt_dislike_list.get();
                                    if ((localObject1 != null) && (((List)localObject1).size() > 0))
                                    {
                                      j = ((List)localObject1).size();
                                      localVideoInfo.ax = new ArrayList();
                                      i = 0;
                                      if (i < j)
                                      {
                                        localObject2 = new DislikeInfo();
                                        ((DislikeInfo)localObject2).a((oidb_0x6cf.DisLikeInfo)((List)localObject1).get(i));
                                        if (!TextUtils.isEmpty(((DislikeInfo)localObject2).c)) {
                                          localVideoInfo.ax.add(localObject2);
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
                                    localVideoInfo.i = this.b.format(Long.valueOf(paramArticleSummary.uint64_time.get() * 1000L));
                                    localVideoInfo.j = paramArticleSummary.uint64_time.get();
                                  }
                                  localObject2 = this;
                                  if ((paramArticleSummary.bytes_subscribe_id.has()) && (paramArticleSummary.bytes_subscribe_id.get() != null)) {
                                    localVideoInfo.q = paramArticleSummary.bytes_subscribe_id.get().toStringUtf8();
                                  }
                                  if ((paramArticleSummary.bytes_subscribe_name.has()) && (paramArticleSummary.bytes_subscribe_name.get() != null)) {
                                    localVideoInfo.r = paramArticleSummary.bytes_subscribe_name.get().toStringUtf8();
                                  }
                                  if ((paramArticleSummary.bytes_article_content_url.has()) && (paramArticleSummary.bytes_article_content_url.get() != null)) {
                                    localVideoInfo.k = paramArticleSummary.bytes_article_content_url.get().toStringUtf8();
                                  }
                                  if ((paramArticleSummary.bytes_aio_share_url.has()) && (paramArticleSummary.bytes_aio_share_url.get() != null)) {
                                    localVideoInfo.y = paramArticleSummary.bytes_aio_share_url.get().toStringUtf8();
                                  }
                                  if ((paramArticleSummary.bytes_qzone_share_url.has()) && (paramArticleSummary.bytes_qzone_share_url.get() != null)) {
                                    localVideoInfo.z = paramArticleSummary.bytes_qzone_share_url.get().toStringUtf8();
                                  }
                                  if (paramArticleSummary.uint32_strategy_id.has()) {
                                    localVideoInfo.ai = paramArticleSummary.uint32_strategy_id.get();
                                  }
                                  if (paramArticleSummary.uint64_algorithm_id.has()) {
                                    localVideoInfo.ah = paramArticleSummary.uint64_algorithm_id.get();
                                  }
                                  if ((paramArticleSummary.bytes_recommend_reason.has()) && (paramArticleSummary.bytes_recommend_reason.get() != null)) {
                                    localVideoInfo.m = paramArticleSummary.bytes_recommend_reason.get().toStringUtf8();
                                  }
                                  if (paramArticleSummary.uint32_video_comment_count.has()) {
                                    localVideoInfo.p = paramArticleSummary.uint32_video_comment_count.get();
                                  }
                                  if (paramArticleSummary.uint32_like_count.has()) {
                                    localVideoInfo.an = paramArticleSummary.uint32_like_count.get();
                                  }
                                  if (paramArticleSummary.uint32_biu_count.has()) {
                                    localVideoInfo.w = paramArticleSummary.uint32_biu_count.get();
                                  }
                                  if (paramArticleSummary.uint32_ads_guide_time.has()) {
                                    localVideoInfo.L = paramArticleSummary.uint32_ads_guide_time.get();
                                  }
                                  if (paramArticleSummary.uint32_ads_jump_type.has()) {
                                    localVideoInfo.M = paramArticleSummary.uint32_ads_jump_type.get();
                                  }
                                  if (paramArticleSummary.uint32_video_source_type.has())
                                  {
                                    if (paramArticleSummary.uint32_video_source_type.get() == 1) {
                                      bool1 = true;
                                    } else {
                                      bool1 = false;
                                    }
                                    localVideoInfo.K = bool1;
                                  }
                                  if (paramArticleSummary.uint32_account_grade.has())
                                  {
                                    if (paramArticleSummary.uint32_account_grade.get() == 1) {
                                      bool1 = true;
                                    } else {
                                      bool1 = false;
                                    }
                                    localVideoInfo.s = bool1;
                                  }
                                  if (paramArticleSummary.uint32_myself_like_status.has())
                                  {
                                    if (paramArticleSummary.uint32_myself_like_status.get() == 1) {
                                      bool1 = true;
                                    } else {
                                      bool1 = false;
                                    }
                                    localVideoInfo.am = bool1;
                                  }
                                  if (paramArticleSummary.bytes_video_report_info.has()) {
                                    localVideoInfo.ao = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.bytes_video_report_info);
                                  }
                                  if (paramArticleSummary.uint64_article_id.has()) {
                                    localVideoInfo.u = paramArticleSummary.uint64_article_id.get();
                                  }
                                  if (paramArticleSummary.uint32_trigger_sec.has()) {
                                    localVideoInfo.U = paramArticleSummary.uint32_trigger_sec.get();
                                  }
                                  if ((paramArticleSummary.msg_top_bar_info.has()) && (paramArticleSummary.msg_top_bar_info.get() != null))
                                  {
                                    localObject1 = paramArticleSummary.msg_top_bar_info;
                                    localObject3 = new VideoInfo.TopBarInfo();
                                    ((VideoInfo.TopBarInfo)localObject3).e = new UrlJumpInfo();
                                    if (((oidb_0x6cf.TopBarInfo)localObject1).uint32_topbar_id.has()) {
                                      i = ((oidb_0x6cf.TopBarInfo)localObject1).uint32_topbar_id.get();
                                    } else {
                                      i = -1;
                                    }
                                    ((VideoInfo.TopBarInfo)localObject3).a = i;
                                    ((VideoInfo.TopBarInfo)localObject3).b = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.TopBarInfo)localObject1).bytes_icon_url);
                                    ((VideoInfo.TopBarInfo)localObject3).c = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.TopBarInfo)localObject1).bytes_title);
                                    ((VideoInfo.TopBarInfo)localObject3).f = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.TopBarInfo)localObject1).bytes_common_data);
                                    ((VideoInfo.TopBarInfo)localObject3).d = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.TopBarInfo)localObject1).bytes_background_url);
                                    ((VideoInfo.TopBarInfo)localObject3).e.b = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.TopBarInfo)localObject1).bytes_jump_url);
                                    localObject5 = ((VideoInfo.TopBarInfo)localObject3).e;
                                    if (((oidb_0x6cf.TopBarInfo)localObject1).uint32_jump_type.has()) {
                                      i = ((oidb_0x6cf.TopBarInfo)localObject1).uint32_jump_type.get();
                                    } else {
                                      i = 0;
                                    }
                                    ((UrlJumpInfo)localObject5).a = i;
                                    ((VideoInfo.TopBarInfo)localObject3).e.c = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.TopBarInfo)localObject1).bytes_ios_jump_bundle);
                                    ((VideoInfo.TopBarInfo)localObject3).e.d = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.TopBarInfo)localObject1).bytes_jump_schema);
                                    localVideoInfo.aD = ((VideoInfo.TopBarInfo)localObject3);
                                  }
                                  if ((paramArticleSummary.msg_download_bar_info.has()) && (paramArticleSummary.msg_download_bar_info.get() != null))
                                  {
                                    localObject1 = paramArticleSummary.msg_download_bar_info;
                                    localObject3 = new VideoInfo.DownloadBarInfo();
                                    ((VideoInfo.DownloadBarInfo)localObject3).b = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.DownloadBarInfo)localObject1).bytes_logo_url);
                                    if (((oidb_0x6cf.DownloadBarInfo)localObject1).uint32_appear_time.has()) {
                                      i = ((oidb_0x6cf.DownloadBarInfo)localObject1).uint32_appear_time.get();
                                    } else {
                                      i = 0;
                                    }
                                    ((VideoInfo.DownloadBarInfo)localObject3).a = i;
                                    if (((oidb_0x6cf.DownloadBarInfo)localObject1).uint32_button_bg_color.has()) {
                                      i = ((oidb_0x6cf.DownloadBarInfo)localObject1).uint32_button_bg_color.get();
                                    } else {
                                      i = 0;
                                    }
                                    ((VideoInfo.DownloadBarInfo)localObject3).e = i;
                                    ((VideoInfo.DownloadBarInfo)localObject3).c = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.DownloadBarInfo)localObject1).bytes_download_button_text);
                                    ((VideoInfo.DownloadBarInfo)localObject3).d = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.DownloadBarInfo)localObject1).bytes_open_button_text);
                                    ((VideoInfo.DownloadBarInfo)localObject3).g = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.DownloadBarInfo)localObject1).bytes_common_data);
                                    ((VideoInfo.DownloadBarInfo)localObject3).f = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.DownloadBarInfo)localObject1).msg_url_jump_info);
                                    localVideoInfo.aF = ((VideoInfo.DownloadBarInfo)localObject3);
                                  }
                                  if ((paramArticleSummary.json_video_list.has()) && (paramArticleSummary.json_video_list.get() != null)) {}
                                  try
                                  {
                                    localVideoInfo.v = paramArticleSummary.json_video_list.get().toStringUtf8();
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
                                    localVideoInfo.b = ((JSONObject)localObject1).optString("vid");
                                    if (((JSONObject)localObject1).has("width")) {
                                      localVideoInfo.c = ((JSONObject)localObject1).getInt("width");
                                    }
                                    if (((JSONObject)localObject1).has("height")) {
                                      localVideoInfo.d = ((JSONObject)localObject1).getInt("height");
                                    }
                                    if (((JSONObject)localObject1).has("duration")) {
                                      try
                                      {
                                        localVideoInfo.e = Integer.parseInt(((JSONObject)localObject1).optString("duration"));
                                      }
                                      catch (NumberFormatException localNumberFormatException)
                                      {
                                        localNumberFormatException.printStackTrace();
                                      }
                                    }
                                    localVideoInfo.f = ((JSONObject)localObject1).optString("picture");
                                    if (((JSONObject)localObject1).has("innerUniqueID")) {
                                      localVideoInfo.l = ((JSONObject)localObject1).optString("innerUniqueID");
                                    }
                                    localVideoInfo.a = 1;
                                    if (((JSONObject)localObject1).has("busiType")) {
                                      localVideoInfo.a = ((JSONObject)localObject1).getInt("busiType");
                                    }
                                    localVideoInfo.A = ((JSONObject)localObject1).optString("thirdAction");
                                    localVideoInfo.B = ((JSONObject)localObject1).optString("thirdIcon");
                                    localVideoInfo.C = ((JSONObject)localObject1).optString("thirdUinName");
                                    if (!TextUtils.isEmpty(((JSONObject)localObject1).optString("thirdName"))) {
                                      localVideoInfo.r = ((JSONObject)localObject1).optString("thirdName");
                                    }
                                    if (!TextUtils.isEmpty(((JSONObject)localObject1).optString("third_uin"))) {
                                      localVideoInfo.q = ((JSONObject)localObject1).optString("third_uin");
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
                                            localVideoInfo.n = l2;
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
                                    localVideoInfo.t = true;
                                    if ((paramArticleSummary.msg_ugc_feeds_info.has()) && (paramArticleSummary.msg_ugc_feeds_info.get() != null))
                                    {
                                      localObject1 = (oidb_0x6cf.UGCFeedsInfo)paramArticleSummary.msg_ugc_feeds_info.get();
                                      if ((((oidb_0x6cf.UGCFeedsInfo)localObject1).ugc_feeds_info.has()) && (((oidb_0x6cf.UGCFeedsInfo)localObject1).ugc_feeds_info.get() != null))
                                      {
                                        localObject4 = (oidb_0x6cf.FeedsIdInfo)((oidb_0x6cf.UGCFeedsInfo)localObject1).ugc_feeds_info.get();
                                        if (((oidb_0x6cf.FeedsIdInfo)localObject4).uint64_feeds_id.has()) {
                                          localVideoInfo.E = ((oidb_0x6cf.FeedsIdInfo)localObject4).uint64_feeds_id.get();
                                        }
                                        if (((oidb_0x6cf.FeedsIdInfo)localObject4).uint32_feeds_type.has()) {
                                          localVideoInfo.F = ((oidb_0x6cf.FeedsIdInfo)localObject4).uint32_feeds_type.get();
                                        }
                                      }
                                      if (((oidb_0x6cf.UGCFeedsInfo)localObject1).uint32_follow_status.has())
                                      {
                                        if (((oidb_0x6cf.UGCFeedsInfo)localObject1).uint32_follow_status.get() == 2) {
                                          bool1 = true;
                                        } else {
                                          bool1 = false;
                                        }
                                        localVideoInfo.al = bool1;
                                      }
                                      if (((oidb_0x6cf.UGCFeedsInfo)localObject1).uint64_cuin.has()) {
                                        localVideoInfo.q = String.valueOf(((oidb_0x6cf.UGCFeedsInfo)localObject1).uint64_cuin.get());
                                      }
                                      if ((((oidb_0x6cf.UGCFeedsInfo)localObject1).msg_ugc_video_info_list.has()) && (((oidb_0x6cf.UGCFeedsInfo)localObject1).msg_ugc_video_info_list.get() != null))
                                      {
                                        localObject4 = (oidb_0x6cf.UGCVideoInfo)((oidb_0x6cf.UGCFeedsInfo)localObject1).msg_ugc_video_info_list.get();
                                        localVideoInfo.D = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.UGCVideoInfo)localObject4).bytes_video_url);
                                        localVideoInfo.f = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.UGCVideoInfo)localObject4).bytes_pic_url);
                                        localVideoInfo.g = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.UGCVideoInfo)localObject4).bytes_title);
                                        localVideoInfo.e = ((int)(((oidb_0x6cf.UGCVideoInfo)localObject4).uint64_duration.get() / 1000L));
                                        localVideoInfo.c = ((oidb_0x6cf.UGCVideoInfo)localObject4).uint32_video_width.get();
                                        localVideoInfo.d = ((oidb_0x6cf.UGCVideoInfo)localObject4).uint32_video_height.get();
                                        localVideoInfo.l = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.UGCVideoInfo)localObject4).bytes_uniq_id);
                                        localVideoInfo.j = ((oidb_0x6cf.UGCVideoInfo)localObject4).uint32_create_time.get();
                                        localVideoInfo.k = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.UGCVideoInfo)localObject4).bytes_share_url);
                                        localVideoInfo.a = ((oidb_0x6cf.UGCVideoInfo)localObject4).uint32_busi_type.get();
                                        localVideoInfo.b = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.UGCVideoInfo)localObject4).bytes_vid);
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
                                              ((RichTitleInfo)localObject7).a = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.BiuOneLevelItem)localObject6).bytes_biu_comments);
                                              if (((oidb_0x6cf.BiuOneLevelItem)localObject6).msg_jump_info.has())
                                              {
                                                ((RichTitleInfo)localObject7).b = String.valueOf(((oidb_0x6cf.JumpInfo)((oidb_0x6cf.BiuOneLevelItem)localObject6).msg_jump_info.get()).uint64_id);
                                                ((RichTitleInfo)localObject7).c = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.JumpInfo)((oidb_0x6cf.BiuOneLevelItem)localObject6).msg_jump_info.get()).bytes_wording);
                                                ((RichTitleInfo)localObject7).d = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.JumpInfo)((oidb_0x6cf.BiuOneLevelItem)localObject6).msg_jump_info.get()).bytes_jump_url);
                                              }
                                              ((RichTitleInfo)localObject7).e = ((oidb_0x6cf.BiuOneLevelItem)localObject6).op_type.get();
                                              ((ArrayList)localObject4).add(localObject7);
                                              continue;
                                            }
                                          }
                                        }
                                        localVideoInfo.aL = ((ArrayList)localObject4);
                                      }
                                      if (((oidb_0x6cf.UGCFeedsInfo)localObject1).bytes_location_info.has()) {
                                        ((VideoPlayRecommendHandler)localObject2).a(((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.UGCFeedsInfo)localObject1).bytes_location_info), localVideoInfo);
                                      }
                                    }
                                  }
                                  if ((paramArticleSummary.msg_feeds_info.has()) && (((oidb_0x6cf.FeedsInfo)paramArticleSummary.msg_feeds_info.get()).feeds_type.get() == 1))
                                  {
                                    localVideoInfo.as = new VideoAdInfo(((VideoPlayRecommendHandler)localObject2).a, (oidb_0x6cf.PosAdInfo)((oidb_0x6cf.FeedsInfo)paramArticleSummary.msg_feeds_info.get()).msg_pos_ad_info.get());
                                    if (((oidb_0x6cf.FeedsInfo)paramArticleSummary.msg_feeds_info.get()).rpt_msg_neg_feedback.has()) {
                                      localVideoInfo.as.a(((oidb_0x6cf.FeedsInfo)paramArticleSummary.msg_feeds_info.get()).rpt_msg_neg_feedback.get());
                                    }
                                    if (QLog.isColorLevel())
                                    {
                                      localObject1 = new StringBuilder();
                                      ((StringBuilder)localObject1).append("getRecommendList recv adInfo=");
                                      ((StringBuilder)localObject1).append(localVideoInfo.as.toString());
                                      QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, ((StringBuilder)localObject1).toString());
                                    }
                                    localVideoInfo.aq = true;
                                    i = localVideoInfo.as.I;
                                    if (i == 65)
                                    {
                                      localVideoInfo.ar = 2;
                                      if (!((VideoPlayRecommendHandler)localObject2).a(localVideoInfo))
                                      {
                                        if (QLog.isColorLevel())
                                        {
                                          paramArticleSummary = new StringBuilder();
                                          paramArticleSummary.append("getRecommendList isInvalidImageAd traceID=");
                                          paramArticleSummary.append(localVideoInfo.as.m);
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
                                          paramArticleSummary.append(localVideoInfo.as.m);
                                          QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, paramArticleSummary.toString());
                                        }
                                        return null;
                                      }
                                      localVideoInfo.ar = 1;
                                      if (((VideoPlayRecommendHandler)localObject2).a(localVideoInfo)) {
                                        continue;
                                      }
                                      if (QLog.isColorLevel())
                                      {
                                        paramArticleSummary = new StringBuilder();
                                        paramArticleSummary.append("getRecommendList isInvalidVideoAd traceID=");
                                        paramArticleSummary.append(localVideoInfo.as.m);
                                        QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, paramArticleSummary.toString());
                                      }
                                      return null;
                                    }
                                    localObject1 = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(localVideoInfo.as);
                                    if (((IRIJAdSwitchService)QRoute.api(IRIJAdSwitchService.class)).isServerRspReport(null, localVideoInfo.as))
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
                                      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(BaseApplication.getContext()).a(80).b(13).a((AdvertisementInfo)localObject1).a(localVideoInfo.as).b((JSONObject)localObject4));
                                    }
                                    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).preLoadAdForMiniProgram(((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(localVideoInfo.as, Integer.valueOf(5), Integer.valueOf(3)));
                                  }
                                  localVideoInfo.X = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.bytes_video_logo_url);
                                  if (paramArticleSummary.msg_account_v_info.has())
                                  {
                                    if (paramArticleSummary.msg_account_v_info.uint32_is_unowned.get() == 1) {
                                      bool1 = true;
                                    } else {
                                      bool1 = false;
                                    }
                                    localVideoInfo.ac = bool1;
                                    localVideoInfo.Y = paramArticleSummary.msg_account_v_info.uint32_follow_count.get();
                                    if (paramArticleSummary.msg_account_v_info.uint32_is_show_follow.get() == 1) {
                                      bool1 = true;
                                    } else {
                                      bool1 = false;
                                    }
                                    localVideoInfo.Z = bool1;
                                  }
                                  if (paramArticleSummary.msg_like_download_bar_info.has())
                                  {
                                    localVideoInfo.aJ = new VideoInfo.LikeActionDownloadBar();
                                    localVideoInfo.aJ.b = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_like_download_bar_info.bytes_bar_text);
                                    localVideoInfo.aJ.a = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_like_download_bar_info.bytes_icon_url);
                                    localVideoInfo.aJ.d = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_like_download_bar_info.bytes_common_data);
                                    localVideoInfo.aJ.c = new UrlJumpInfo();
                                    localVideoInfo.aJ.c.a = ((oidb_0x6cf.UrlJumpInfo)paramArticleSummary.msg_like_download_bar_info.msg_url_jump_info.get()).uint32_jump_type.get();
                                    localVideoInfo.aJ.c.c = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.UrlJumpInfo)paramArticleSummary.msg_like_download_bar_info.msg_url_jump_info.get()).bytes_jump_bundle);
                                    localVideoInfo.aJ.c.d = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.UrlJumpInfo)paramArticleSummary.msg_like_download_bar_info.msg_url_jump_info.get()).bytes_jump_schema);
                                    localVideoInfo.aJ.c.b = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.UrlJumpInfo)paramArticleSummary.msg_like_download_bar_info.msg_url_jump_info.get()).bytes_jump_url);
                                    localVideoInfo.aJ.c.e = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.UrlJumpInfo)paramArticleSummary.msg_like_download_bar_info.msg_url_jump_info.get()).bytes_clipboard_info);
                                  }
                                  if (paramArticleSummary.msg_soft_ad_download_bar_info.has())
                                  {
                                    localVideoInfo.aK = new VideoInfo.SoftAdDownloadBarInfo();
                                    localVideoInfo.aK.a = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_soft_ad_download_bar_info.bytes_title);
                                    localVideoInfo.aK.b = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_soft_ad_download_bar_info.bytes_sub_title);
                                    localVideoInfo.aK.c = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_soft_ad_download_bar_info.bytes_small_icon_url);
                                    localVideoInfo.aK.d = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_soft_ad_download_bar_info.bytes_big_icon_url);
                                    localVideoInfo.aK.e = paramArticleSummary.msg_soft_ad_download_bar_info.uint32_change_bigger_position.get();
                                    localVideoInfo.aK.f = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_soft_ad_download_bar_info.msg_url_jump_info);
                                    localVideoInfo.aK.h = paramArticleSummary.msg_soft_ad_download_bar_info.uint32_small_game_play_count.get();
                                    localVideoInfo.aK.g = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_soft_ad_download_bar_info.bytes_small_game_rsp_pack);
                                    localVideoInfo.aK.i = SmallMiniGameInfo.a(localVideoInfo.aK.g);
                                  }
                                  if ((localVideoInfo.aq) && (localVideoInfo.ar == 2)) {
                                    return null;
                                  }
                                  if (paramArticleSummary.msg_ecommerce_entrance_info.has())
                                  {
                                    localVideoInfo.aG = new VideoInfo.ECommerceEntranceInfo();
                                    localVideoInfo.aG.a = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_ecommerce_entrance_info.bytes_title);
                                    localVideoInfo.aG.b = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_ecommerce_entrance_info.bytes_subtitle);
                                    localVideoInfo.aG.c = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_ecommerce_entrance_info.bytes_thumbnail_url);
                                    localVideoInfo.aG.d = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_ecommerce_entrance_info.bytes_link_icon_url);
                                    if (paramArticleSummary.msg_ecommerce_entrance_info.uint32_jump_type.has()) {
                                      localVideoInfo.aG.e = paramArticleSummary.msg_ecommerce_entrance_info.uint32_jump_type.get();
                                    }
                                    if (paramArticleSummary.msg_ecommerce_entrance_info.uint32_ecommerce_id.has()) {
                                      localVideoInfo.aG.n = paramArticleSummary.msg_ecommerce_entrance_info.uint32_ecommerce_id.get();
                                    }
                                    if (paramArticleSummary.msg_ecommerce_entrance_info.uint32_display_count_ver.has()) {
                                      localVideoInfo.aG.k = paramArticleSummary.msg_ecommerce_entrance_info.uint32_display_count_ver.get();
                                    }
                                    if (paramArticleSummary.msg_ecommerce_entrance_info.uint32_one_day_max_display_count.has()) {
                                      localVideoInfo.aG.m = paramArticleSummary.msg_ecommerce_entrance_info.uint32_one_day_max_display_count.get();
                                    }
                                    if (paramArticleSummary.msg_ecommerce_entrance_info.uint32_session_max_display_count.has()) {
                                      localVideoInfo.aG.l = paramArticleSummary.msg_ecommerce_entrance_info.uint32_session_max_display_count.get();
                                    }
                                    localVideoInfo.aG.f = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_ecommerce_entrance_info.bytes_jump_url);
                                    localVideoInfo.aG.j = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_ecommerce_entrance_info.bytes_common_data);
                                    localVideoInfo.aG.i = paramArticleSummary.msg_ecommerce_entrance_info.video_play_length.get();
                                    localVideoInfo.aG.o = paramArticleSummary.msg_ecommerce_entrance_info.uint32_style.get();
                                    if (paramArticleSummary.msg_ecommerce_entrance_info.appInfo.has())
                                    {
                                      localVideoInfo.aG.p = new UrlJumpInfo();
                                      localVideoInfo.aG.p.a = ((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).uint32_jump_type.get();
                                      localVideoInfo.aG.p.c = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_jump_bundle);
                                      localVideoInfo.aG.p.d = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_jump_schema);
                                      localVideoInfo.aG.p.b = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_jump_url);
                                      localVideoInfo.aG.p.e = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_clipboard_info);
                                      localVideoInfo.aG.r = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_app_open_wording);
                                      localVideoInfo.aG.q = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_app_download_wording);
                                      localVideoInfo.aG.b = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_app_desc);
                                      localVideoInfo.aG.c = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_icon_url);
                                      localVideoInfo.aG.a = ((VideoPlayRecommendHandler)localObject2).a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_name);
                                    }
                                    if (QLog.isColorLevel())
                                    {
                                      localObject1 = new StringBuilder();
                                      ((StringBuilder)localObject1).append("commerceEntranceInfo: ");
                                      ((StringBuilder)localObject1).append(localVideoInfo.aG.toString());
                                      QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, ((StringBuilder)localObject1).toString());
                                    }
                                  }
                                  if ((paramRspBody.msg_ecommerce_entrance_config.has()) && (localVideoInfo.aG != null) && (paramRspBody.msg_ecommerce_entrance_config.uint32_show_after_play_time.has())) {
                                    localVideoInfo.aG.h = paramRspBody.msg_ecommerce_entrance_config.uint32_show_after_play_time.get();
                                  }
                                  localVideoInfo.ap = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.bytes_avatar_jump_url);
                                  if (paramArticleSummary.uint64_recommend_seq.has()) {
                                    l1 = paramArticleSummary.uint64_recommend_seq.get();
                                  }
                                  localVideoInfo.N = l1;
                                  if (paramArticleSummary.uint32_is_first_page_use_gif.has())
                                  {
                                    if (paramArticleSummary.uint32_is_first_page_use_gif.get() == 1) {
                                      bool1 = true;
                                    } else {
                                      bool1 = false;
                                    }
                                    localVideoInfo.P = bool1;
                                  }
                                  localVideoInfo.Q = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.bytes_first_page_gif_url);
                                  if (paramArticleSummary.uint32_is_no_show_cover.has())
                                  {
                                    if (paramArticleSummary.uint32_is_no_show_cover.get() == 0) {
                                      bool1 = true;
                                    } else {
                                      bool1 = false;
                                    }
                                    localVideoInfo.R = bool1;
                                  }
                                  VideoFeedsHelper.a(localVideoInfo);
                                  ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).parseKdTagInfo(paramArticleSummary, localVideoInfo);
                                  if (paramArticleSummary.video_column_info.has())
                                  {
                                    paramRspBody = new VideoColumnInfo();
                                    paramRspBody.b = paramArticleSummary.video_column_info.uint32_column_id.get();
                                    paramRspBody.c = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.video_column_info.bytes_column_name);
                                    paramRspBody.d = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.video_column_info.bytes_column_icon_url);
                                    paramRspBody.g = paramArticleSummary.video_column_info.uint32_subscribe_count.get();
                                    if (paramArticleSummary.video_column_info.uint32_is_subscribed.get() == 1) {
                                      bool1 = true;
                                    } else {
                                      bool1 = false;
                                    }
                                    paramRspBody.h = bool1;
                                    paramRspBody.l = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.video_column_info.bytes_app_name);
                                    paramRspBody.m = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.video_column_info.bytes_app_icon_url);
                                    paramRspBody.p = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.video_column_info.subscribe_jump_info);
                                    paramRspBody.q = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.video_column_info.app_jump_info);
                                    paramRspBody.n = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.video_column_info.default_jump_info);
                                    paramRspBody.u = paramArticleSummary.video_column_info.uint32_style.get();
                                    paramRspBody.s = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.video_column_info.bytes_from_txt);
                                    paramRspBody.f = paramArticleSummary.video_column_info.uint32_video_count.get();
                                    paramRspBody.e = paramArticleSummary.video_column_info.uint64_last_update_time.get();
                                    paramRspBody.v = paramArticleSummary.video_column_info.uint32_update_count.get();
                                    localVideoInfo.ay = paramRspBody;
                                  }
                                  if ((paramArticleSummary.uint32_forbid_reprint_flag.has()) && (paramArticleSummary.uint32_forbid_reprint_flag.get() == 1)) {
                                    bool1 = true;
                                  } else {
                                    bool1 = false;
                                  }
                                  bool2 = true;
                                  localVideoInfo.aa = bool1;
                                  localVideoInfo.ab = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.bytes_wechat_share_url);
                                  if (paramArticleSummary.is_pgc_ahthor.get() == 1) {
                                    bool1 = bool2;
                                  } else {
                                    bool1 = false;
                                  }
                                  localVideoInfo.ad = bool1;
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
                                      localVideoInfo.aM = new VideoInfo.SubscriptInfo();
                                      localVideoInfo.aM.a = paramRspBody;
                                      localVideoInfo.aM.d = paramArticleSummary.msg_subscript_20.uint32_subscript_type.get();
                                      localVideoInfo.aM.b = Color.parseColor(((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_subscript_20.bytes_subscript_color));
                                      localVideoInfo.aM.c = Color.parseColor(((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.msg_subscript_20.bytes_background_color));
                                    }
                                  }
                                  if (paramArticleSummary.uint32_share_count.has()) {
                                    localVideoInfo.aw = paramArticleSummary.uint32_share_count.get();
                                  }
                                  ((VideoPlayRecommendHandler)localObject2).a(((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.bytes_location_info), localVideoInfo);
                                  localVideoInfo.aU = ((VideoPlayRecommendHandler)localObject2).a(paramArticleSummary.bytes_strategy_ids);
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
  
  private oidb_0x6cf.PositionInfo b()
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
  
  private int c()
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
  
  public VideoInfo.EntranceDownloadInfo a(oidb_0x6cf.EntranceDownloadInfo paramEntranceDownloadInfo)
  {
    if (paramEntranceDownloadInfo == null) {
      return null;
    }
    VideoInfo.EntranceDownloadInfo localEntranceDownloadInfo = new VideoInfo.EntranceDownloadInfo();
    localEntranceDownloadInfo.a = a(paramEntranceDownloadInfo.bytes_icon_url);
    localEntranceDownloadInfo.b = a(paramEntranceDownloadInfo.bytes_small_icon_url);
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
    localEntranceDownloadInfo.c = bool1;
    localEntranceDownloadInfo.d = a(paramEntranceDownloadInfo.bytes_common_data);
    localEntranceDownloadInfo.e = a(paramEntranceDownloadInfo.msg_url_jump_info);
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
      localUrlJumpInfo.a = i;
      localUrlJumpInfo.d = a(paramUrlJumpInfo.bytes_jump_schema);
      localUrlJumpInfo.c = a(paramUrlJumpInfo.bytes_jump_bundle);
      localUrlJumpInfo.b = a(paramUrlJumpInfo.bytes_jump_url);
      localUrlJumpInfo.e = a(paramUrlJumpInfo.bytes_clipboard_info);
      localUrlJumpInfo.f = a(paramUrlJumpInfo.bytes_common_data);
      return localUrlJumpInfo;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoPlayRecommendHandler
 * JD-Core Version:    0.7.0.1
 */