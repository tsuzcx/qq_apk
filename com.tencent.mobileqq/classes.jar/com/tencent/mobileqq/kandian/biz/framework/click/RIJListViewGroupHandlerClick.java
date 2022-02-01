package com.tencent.mobileqq.kandian.biz.framework.click;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.Pair;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.VisibleForTesting;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.intervideo.now.NowFromData;
import com.tencent.mobileqq.intervideo.now.dynamic.IDynamicNowManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.TimeUtil;
import com.tencent.mobileqq.kandian.base.utils.ValueReference;
import com.tencent.mobileqq.kandian.base.video.player.data.AbsReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.base.video.player.data.ReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.biz.common.RIJMiniProgramUtils;
import com.tencent.mobileqq.kandian.biz.common.RIJTabFrameBase;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyChannelActivity;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentVerticalSmallVideo;
import com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCell;
import com.tencent.mobileqq.kandian.biz.pts.item.ProteusItemView;
import com.tencent.mobileqq.kandian.biz.pts.util.PGCShortContentUtils;
import com.tencent.mobileqq.kandian.biz.pts.util.RIJComponentConfigImage;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils;
import com.tencent.mobileqq.kandian.glue.report.KandianDailyReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.glue.router.ReadInJoyDailyJumpToKDTabUtils;
import com.tencent.mobileqq.kandian.glue.structmsg.FeedsStructMsg;
import com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoySrtUtils;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfoKt;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule;
import com.tencent.mobileqq.kandian.repo.feeds.PolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJBaseItemViewType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackVideoInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ShareWebPageInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.WendaInfo;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo.VideoExtraRepoerData;
import com.tencent.mobileqq.kandian.repo.ugc.srtutils.UGRuleManager;
import com.tencent.mobileqq.kandian.repo.video.entity.UGCVideoInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

public class RIJListViewGroupHandlerClick
{
  public static AbsBaseArticleInfo a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    BaseArticleInfo localBaseArticleInfo = new BaseArticleInfo();
    localBaseArticleInfo.mChannelID = paramAbsBaseArticleInfo.mChannelID;
    NewPolymericInfo.PackArticleInfo localPackArticleInfo = (NewPolymericInfo.PackArticleInfo)paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
    localBaseArticleInfo.mStrategyId = localPackArticleInfo.jdField_a_of_type_Int;
    localBaseArticleInfo.mAlgorithmID = localPackArticleInfo.jdField_b_of_type_Long;
    localBaseArticleInfo.mTitle = localPackArticleInfo.jdField_a_of_type_JavaLangString;
    localBaseArticleInfo.mFirstPagePicUrl = localPackArticleInfo.jdField_c_of_type_JavaLangString;
    localBaseArticleInfo.mArticleContentUrl = localPackArticleInfo.jdField_d_of_type_JavaLangString;
    localBaseArticleInfo.mArticleID = localPackArticleInfo.jdField_a_of_type_Long;
    localBaseArticleInfo.mSubscribeID = localPackArticleInfo.jdField_e_of_type_JavaLangString;
    localBaseArticleInfo.mSubscribeName = localPackArticleInfo.jdField_f_of_type_JavaLangString;
    localBaseArticleInfo.innerUniqueID = localPackArticleInfo.jdField_g_of_type_JavaLangString;
    localBaseArticleInfo.mNewPolymericInfo = paramAbsBaseArticleInfo.mNewPolymericInfo;
    return localBaseArticleInfo;
  }
  
  public static void a(Context paramContext, BaseAdapter paramBaseAdapter, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(paramContext, paramBaseAdapter, paramAbsBaseArticleInfo, true, paramInt1, paramInt2, paramBoolean, 1);
  }
  
  public static void a(Context paramContext, BaseAdapter paramBaseAdapter, AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, int paramInt3)
  {
    Intent localIntent = new Intent(paramContext, ReadInJoyChannelActivity.class);
    localIntent.putExtra("channel_id", 56);
    localIntent.putExtra("channel_name", HardCodeUtil.a(2131713003));
    localIntent.putExtra("channel_type", 3);
    localIntent.putExtra("channel_from", paramInt3);
    localIntent.putExtra("is_channel_activity", true);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", paramAbsBaseArticleInfo.mArticleID);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", paramAbsBaseArticleInfo.mRecommendSeq);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", true);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", true);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_IS_UGC_VIDEO", RIJItemViewTypeUtils.x(paramAbsBaseArticleInfo) ^ true);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_INFO", paramAbsBaseArticleInfo);
    paramInt3 = RIJBaseItemViewType.a(paramAbsBaseArticleInfo);
    if ((paramBoolean1) && ((paramInt3 == 6) || (paramInt3 == 28) || (paramInt3 == 71)))
    {
      localIntent.putExtra("is_need_show_animation_translate", true);
      localIntent.putExtra("is_need_show_animation_adapter", true);
      if (paramBoolean2)
      {
        localIntent.putExtra("view_translation_animation_top", paramInt1);
        localIntent.putExtra("view_translation_animation_left", paramInt2);
      }
    }
    else if (paramBaseAdapter != null)
    {
      paramBaseAdapter.notifyDataSetChanged();
    }
    paramContext.startActivity(localIntent);
    VideoReporter.a.put(ReadInJoyChannelActivity.class, VideoReporter.b());
    VideoVolumeControl.getInstance().setMute(false, "jumpFromKandianFeed", 1);
  }
  
  private void a(View paramView, int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    if ((paramView instanceof ProteusItemView)) {
      a((ProteusItemView)paramView, paramBuilder.a());
    } else if ((paramView instanceof LinearLayout)) {
      a((LinearLayout)paramView, paramBuilder.a());
    }
    a(paramAbsBaseArticleInfo, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt, paramBuilder);
  }
  
  private void a(View paramView, int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJListViewGroupHandlerClick.Builder paramBuilder, Handler paramHandler)
  {
    if (a(paramAbsBaseArticleInfo, paramView))
    {
      RIJFrameworkReportManager.a(paramBuilder.a(), paramAbsBaseArticleInfo, paramBuilder.b());
      QLog.d("RIJListViewGroupHandlerClick", 2, "main feeds hit Gallery feeds");
    }
    else
    {
      b(paramAbsBaseArticleInfo, paramInt - 1, paramBuilder);
    }
    ReadInJoyLogicEngine.a().a(paramAbsBaseArticleInfo.mArticleID, System.currentTimeMillis());
    if (paramBuilder.a() != null) {}
    try
    {
      if (!TextUtils.isEmpty(ViolaAccessHelper.c(paramAbsBaseArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8())))
      {
        paramView = paramHandler;
        if (paramHandler == null) {
          paramView = new Handler(Looper.getMainLooper());
        }
        paramView.postDelayed(new RIJListViewGroupHandlerClick.1(this, paramBuilder), 2000L);
        return;
      }
      paramBuilder.a().notifyDataSetChanged();
      return;
    }
    catch (Exception paramView)
    {
      label134:
      break label134;
    }
    paramBuilder.a().notifyDataSetChanged();
  }
  
  private void a(View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    if (VideoFeedsHelper.a(paramAbsBaseArticleInfo, paramBuilder.a())) {
      return;
    }
    int i = RIJBaseItemViewType.a(paramAbsBaseArticleInfo);
    if ((i != 23) && (i != 26) && (i != 56) && (i != 59) && (i != 19) && (i != 17) && (i != 11) && (i != 28))
    {
      i = RIJBaseItemViewType.a(paramAbsBaseArticleInfo);
      if (a(paramAbsBaseArticleInfo, i))
      {
        a(paramAbsBaseArticleInfo, paramBuilder, i);
        return;
      }
      if (a(paramAbsBaseArticleInfo)) {
        c(paramAbsBaseArticleInfo, paramBuilder);
      }
      return;
    }
    a(paramAbsBaseArticleInfo, paramView, paramBuilder);
  }
  
  private void a(LinearLayout paramLinearLayout, Activity paramActivity)
  {
    paramLinearLayout = (TextView)paramLinearLayout.findViewById(2131365056);
    if (paramLinearLayout != null)
    {
      paramLinearLayout.setTextColor(paramActivity.getResources().getColor(2131166508));
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.videoanimation", 2, " change ui state after readed");
      }
    }
  }
  
  private void a(ProteusItemView paramProteusItemView, Activity paramActivity)
  {
    paramProteusItemView = (TextBase)paramProteusItemView.a().getVirtualView().findViewBaseByName("id_artilce_title");
    if (paramProteusItemView != null)
    {
      paramProteusItemView.setTextColor(paramActivity.getResources().getColor(2131166508));
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.videoanimation", 2, " change ui state after readed");
      }
    }
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, Activity paramActivity, int paramInt)
  {
    String str = paramAbsBaseArticleInfo.mArticleContentUrl;
    if (!TextUtils.isEmpty(str))
    {
      Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      paramActivity.startActivity(localIntent);
    }
    RIJFrameworkReportManager.a(paramActivity, paramAbsBaseArticleInfo, paramInt);
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, Activity paramActivity, int paramInt, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    if ((!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo)) && (paramReadInJoyBaseAdapter != null) && (!RIJItemViewTypeUtils.h(paramAbsBaseArticleInfo))) {
      RIJJumpUtils.a(paramActivity, paramAbsBaseArticleInfo, paramReadInJoyBaseAdapter, paramInt);
    }
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, View paramView, int paramInt, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    if ((paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList != null) && (paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      a(paramAbsBaseArticleInfo, (NewPolymericInfo.PackArticleInfo)paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0), paramView, paramInt, paramReadInJoyBaseAdapter);
      return;
    }
    QLog.e("RIJListViewGroupHandlerClick", 1, "handleJumpFullVideoPlayForNewPolymeric, bad data need backend check");
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo1, View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo2, Activity paramActivity)
  {
    if (a(paramAbsBaseArticleInfo2, paramView))
    {
      QLog.d("RIJListViewGroupHandlerClick", 2, "main feeds hit ShortContent feeds");
      QLog.d("RIJListViewGroupHandlerClick", 1, "tryJumpToUgUrl: true");
      paramAbsBaseArticleInfo2.clickJumpTarget = PGCShortContentUtils.a(ProteusSupportUtil.a(paramAbsBaseArticleInfo2), "-1");
    }
    else
    {
      QLog.d("RIJListViewGroupHandlerClick", 1, "short content redirectToOtherPage");
      PGCShortContentUtils.a(paramActivity, paramAbsBaseArticleInfo2);
    }
    paramAbsBaseArticleInfo1.clickArea = 7;
    RIJFrameworkReportManager.a(paramActivity, paramAbsBaseArticleInfo2, (int)paramAbsBaseArticleInfo1.mChannelID);
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo1, View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo2, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    if (paramAbsBaseArticleInfo1.isAccountShown) {
      paramAbsBaseArticleInfo1.clickArea = 7;
    }
    if (a(paramAbsBaseArticleInfo2, paramView))
    {
      QLog.d("RIJListViewGroupHandlerClick", 2, "main feeds hit ug normal feeds");
      ReadInJoyLogicEngine.a().a(paramAbsBaseArticleInfo2.mArticleID, System.currentTimeMillis());
      paramBuilder.a().notifyDataSetChanged();
      paramAbsBaseArticleInfo1.clickJumpTarget = PGCShortContentUtils.a(ProteusSupportUtil.a(paramAbsBaseArticleInfo2), "-1");
      RIJFrameworkReportManager.a(paramBuilder.a(), paramAbsBaseArticleInfo2, paramBuilder.b());
      return;
    }
    if (a(paramAbsBaseArticleInfo2, paramView, paramBuilder))
    {
      QLog.d("RIJListViewGroupHandlerClick", 2, "main feeds hit srt normal feeds");
      paramAbsBaseArticleInfo1.clickJumpTarget = PGCShortContentUtils.a(ReadInJoySrtUtils.a().a(), "-1");
      return;
    }
    if ((!UGRuleManager.c(paramAbsBaseArticleInfo2)) && (!ReadInJoySrtUtils.a().a()) && (RIJTransMergeKanDianReport.a(paramView.getContext(), paramAbsBaseArticleInfo2)))
    {
      RIJFrameworkReportManager.a(paramBuilder.a(), paramAbsBaseArticleInfo2, paramBuilder.b());
      ReadInJoyLogicEngine.a().a(paramAbsBaseArticleInfo2.mArticleID, System.currentTimeMillis());
      paramBuilder.a().notifyDataSetChanged();
      paramBuilder = RIJJumpUtils.b(paramAbsBaseArticleInfo2.getInnerUniqueID());
      paramAbsBaseArticleInfo1.clickJumpTarget = PGCShortContentUtils.a(paramBuilder, "-1");
      RIJJumpUtils.a(paramView.getContext(), paramAbsBaseArticleInfo2, paramBuilder);
      return;
    }
    if (ReadInJoyDailyJumpToKDTabUtils.a(paramView.getContext(), paramAbsBaseArticleInfo2.mArticleContentUrl))
    {
      RIJFrameworkReportManager.a(paramBuilder.a(), paramAbsBaseArticleInfo2, paramBuilder.b());
      ReadInJoyLogicEngine.a().a(paramAbsBaseArticleInfo2.mArticleID, System.currentTimeMillis());
      paramBuilder.a().notifyDataSetChanged();
      return;
    }
    paramAbsBaseArticleInfo1.clickJumpTarget = PGCShortContentUtils.a("", "3");
    b(paramAbsBaseArticleInfo2, paramBuilder);
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJListViewGroupHandlerClick.Builder paramBuilder, int paramInt)
  {
    if (b(paramAbsBaseArticleInfo, paramInt)) {
      a(paramAbsBaseArticleInfo, null, 0, 0, false, 0, paramBuilder);
    } else if ((paramInt != 95) && (paramInt != 94))
    {
      if (paramAbsBaseArticleInfo.isPGCShortContent()) {
        PGCShortContentUtils.a(paramBuilder.a(), paramAbsBaseArticleInfo);
      } else if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo)) {
        a(paramAbsBaseArticleInfo, paramBuilder);
      }
    }
    else {
      ReadInJoyUtils.a(paramBuilder.a(), paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityShareWebPageInfo.jdField_a_of_type_JavaLangString);
    }
    a(paramBuilder);
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, NewPolymericInfo.PackArticleInfo paramPackArticleInfo, View paramView, int paramInt, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    VideoPlayParam localVideoPlayParam = new VideoPlayParam();
    if (paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo == null)
    {
      QLog.e("handleJumpFullVideoPlayForNewPolymeric", 2, " bad data need backend check");
      return;
    }
    localVideoPlayParam.jdField_c_of_type_Long = paramPackArticleInfo.jdField_a_of_type_Long;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_b_of_type_Long);
    ((StringBuilder)localObject).append("");
    localVideoPlayParam.jdField_h_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    localVideoPlayParam.jdField_i_of_type_JavaLangString = paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_d_of_type_JavaLangString;
    localVideoPlayParam.jdField_k_of_type_JavaLangString = paramPackArticleInfo.jdField_e_of_type_JavaLangString;
    localVideoPlayParam.jdField_g_of_type_Int = paramPackArticleInfo.jdField_a_of_type_Int;
    localVideoPlayParam.jdField_g_of_type_Long = paramPackArticleInfo.jdField_b_of_type_Long;
    localObject = new ReadInJoyVideoReportData();
    ((ReadInJoyVideoReportData)localObject).a = Long.valueOf(paramPackArticleInfo.jdField_a_of_type_Long);
    ((ReadInJoyVideoReportData)localObject).jdField_b_of_type_JavaLangString = paramPackArticleInfo.jdField_g_of_type_JavaLangString;
    ((ReadInJoyVideoReportData)localObject).jdField_b_of_type_Int = paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_a_of_type_Int;
    ((ReadInJoyVideoReportData)localObject).jdField_c_of_type_JavaLangString = paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_a_of_type_JavaLangString;
    localVideoPlayParam.a = ((AbsReadInJoyVideoReportData)localObject);
    localVideoPlayParam.jdField_b_of_type_JavaLangString = paramPackArticleInfo.jdField_c_of_type_JavaLangString;
    localVideoPlayParam.jdField_c_of_type_JavaLangString = paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_a_of_type_JavaLangString;
    localVideoPlayParam.jdField_f_of_type_Int = paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_a_of_type_Int;
    localVideoPlayParam.jdField_c_of_type_Int = paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_b_of_type_Int;
    localVideoPlayParam.jdField_d_of_type_Int = paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_c_of_type_Int;
    localVideoPlayParam.jdField_b_of_type_Int = paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_d_of_type_Int;
    localVideoPlayParam.jdField_e_of_type_Long = paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_a_of_type_Long;
    localVideoPlayParam.jdField_j_of_type_JavaLangString = paramPackArticleInfo.jdField_g_of_type_JavaLangString;
    localVideoPlayParam.jdField_g_of_type_JavaLangString = paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_b_of_type_JavaLangString;
    localVideoPlayParam.jdField_d_of_type_JavaLangString = paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_f_of_type_JavaLangString;
    localVideoPlayParam.jdField_e_of_type_JavaLangString = paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_e_of_type_JavaLangString;
    localVideoPlayParam.jdField_f_of_type_JavaLangString = paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_g_of_type_JavaLangString;
    if (paramView != null)
    {
      localObject = new int[2];
      paramView.getLocationOnScreen((int[])localObject);
      localVideoPlayParam.jdField_h_of_type_Int = localObject[0];
      localVideoPlayParam.jdField_i_of_type_Int = localObject[1];
      localVideoPlayParam.jdField_j_of_type_Int = paramView.getWidth();
      localVideoPlayParam.jdField_k_of_type_Int = paramView.getHeight();
      if (((paramView instanceof ComponentContentVerticalSmallVideo)) && (((ComponentContentVerticalSmallVideo)paramView).jdField_a_of_type_Boolean))
      {
        localObject = RIJComponentConfigImage.a(3, paramInt);
        localVideoPlayParam.jdField_h_of_type_Int += (localVideoPlayParam.jdField_j_of_type_Int - ((Integer)((Pair)localObject).first).intValue()) / 2;
        localVideoPlayParam.jdField_j_of_type_Int = ((Integer)((Pair)localObject).first).intValue();
      }
    }
    localObject = new ReportInfo.VideoExtraRepoerData();
    ((ReportInfo.VideoExtraRepoerData)localObject).jdField_a_of_type_Int = 409409;
    paramReadInJoyBaseAdapter.a(localVideoPlayParam, paramAbsBaseArticleInfo);
    if (paramInt == 0) {
      VideoReporter.a(paramPackArticleInfo.jdField_a_of_type_Long, paramPackArticleInfo.jdField_g_of_type_JavaLangString, paramInt, (int)paramPackArticleInfo.jdField_b_of_type_Long, paramPackArticleInfo.jdField_a_of_type_Int, 24, -1L, (ReportInfo.VideoExtraRepoerData)localObject, -1, paramPackArticleInfo.jdField_k_of_type_JavaLangString);
    }
    ReadInJoyLogicEngine.a().a(paramPackArticleInfo.jdField_a_of_type_Long, System.currentTimeMillis());
    if (!(paramView instanceof ComponentContentVerticalSmallVideo)) {
      paramReadInJoyBaseAdapter.notifyDataSetChanged();
    }
  }
  
  private boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo, View paramView)
  {
    String str = ProteusSupportUtil.a(paramAbsBaseArticleInfo);
    if (!TextUtils.isEmpty(str))
    {
      if (UGRuleManager.a(str)) {
        RIJJumpUtils.a(paramView.getContext(), paramAbsBaseArticleInfo, str);
      } else {
        VideoFeedsHelper.a(BaseApplicationImpl.getApplication(), str);
      }
      paramView = new StringBuilder();
      paramView.append("UGRuleManager articleInfo hit ug title");
      paramView.append(paramAbsBaseArticleInfo.mTitle);
      QLog.d("RIJListViewGroupHandlerClick", 1, paramView.toString());
      return true;
    }
    return false;
  }
  
  private boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo1, View paramView, int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo2, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    if ((BaseArticleInfoKt.b(paramAbsBaseArticleInfo2)) && (paramAbsBaseArticleInfo2.mFeedType != 36))
    {
      paramAbsBaseArticleInfo1 = new StringBuilder();
      paramAbsBaseArticleInfo1.append("JumpAndForceInsert onVideoArticleClick() RETURN article.mArticleID:");
      paramAbsBaseArticleInfo1.append(paramAbsBaseArticleInfo2.mArticleID);
      paramAbsBaseArticleInfo1.append(" article.mTitle:");
      paramAbsBaseArticleInfo1.append(paramAbsBaseArticleInfo2.mTitle);
      QLog.d("Q.readinjoy.video", 2, paramAbsBaseArticleInfo1.toString());
      return true;
    }
    if (RIJBaseItemViewType.a(paramAbsBaseArticleInfo2) == 6) {
      if ((paramView instanceof ProteusItemView)) {
        a((ProteusItemView)paramView, paramBuilder.a());
      } else if ((paramView instanceof LinearLayout)) {
        a((LinearLayout)paramView, paramBuilder.a());
      }
    }
    if (a(paramAbsBaseArticleInfo2, paramView))
    {
      QLog.d("RIJListViewGroupHandlerClick", 2, "main feeds hit ug video feeds");
      ReadInJoyLogicEngine.a().a(paramAbsBaseArticleInfo2.mArticleID, System.currentTimeMillis());
      paramBuilder.a().notifyDataSetChanged();
      RIJFrameworkReportManager.a(paramBuilder.a(), paramAbsBaseArticleInfo2, paramBuilder.b());
    }
    else if (a(paramAbsBaseArticleInfo2, paramView, paramBuilder))
    {
      QLog.d("RIJListViewGroupHandlerClick", 2, "main feeds hit srt video feeds");
    }
    else if (RIJItemViewTypeUtils.C(paramAbsBaseArticleInfo2))
    {
      paramAbsBaseArticleInfo1 = new StringBuilder();
      paramAbsBaseArticleInfo1.append("isLargeImageMiniAppCard, jumpto: ");
      paramAbsBaseArticleInfo1.append(paramAbsBaseArticleInfo2.mArticleContentUrl);
      QLog.d("RIJListViewGroupHandlerClick", 1, paramAbsBaseArticleInfo1.toString());
      RIJMiniProgramUtils.a.a(paramAbsBaseArticleInfo2, 1, null);
      RIJFrameworkReportManager.b(paramAbsBaseArticleInfo2, paramBuilder.b());
    }
    else if (paramAbsBaseArticleInfo1.isAccountShown)
    {
      paramAbsBaseArticleInfo1.clickArea = 7;
      paramAbsBaseArticleInfo1.clickJumpTarget = PGCShortContentUtils.a("", "3");
      b(paramAbsBaseArticleInfo2, paramBuilder);
    }
    else
    {
      a(paramAbsBaseArticleInfo2, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt, paramBuilder);
    }
    if (QLog.isColorLevel())
    {
      paramAbsBaseArticleInfo1 = new StringBuilder();
      paramAbsBaseArticleInfo1.append("JumpAndForceInsert onVideoArticleClick() article.mArticleID:");
      paramAbsBaseArticleInfo1.append(paramAbsBaseArticleInfo2.mArticleID);
      paramAbsBaseArticleInfo1.append(" article.mTitle:");
      paramAbsBaseArticleInfo1.append(paramAbsBaseArticleInfo2.mTitle);
      paramAbsBaseArticleInfo1.append(" article.mSummary:");
      paramAbsBaseArticleInfo1.append(paramAbsBaseArticleInfo2.mSummary);
      paramAbsBaseArticleInfo1.append("mJsonVideoList:");
      paramAbsBaseArticleInfo1.append(paramAbsBaseArticleInfo2.mJsonVideoList);
      paramAbsBaseArticleInfo1.append(" videoJumpChannelID=");
      paramAbsBaseArticleInfo1.append(paramAbsBaseArticleInfo2.videoJumpChannelID);
      paramAbsBaseArticleInfo1.append(" videoJumpChannelName=");
      paramAbsBaseArticleInfo1.append(paramAbsBaseArticleInfo2.videoJumpChannelName);
      paramAbsBaseArticleInfo1.append(" videoJumpChannelType=");
      paramAbsBaseArticleInfo1.append(paramAbsBaseArticleInfo2.videoJumpChannelType);
      QLog.d("Q.readinjoy.video", 2, paramAbsBaseArticleInfo1.toString());
    }
    return false;
  }
  
  private boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo, View paramView, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    if (UGRuleManager.c(paramAbsBaseArticleInfo)) {
      return false;
    }
    boolean bool = ReadInJoySrtUtils.a().a(paramAbsBaseArticleInfo, null, null);
    String str = ReadInJoySrtUtils.a().a();
    if ((bool) && (!TextUtils.isEmpty(str)))
    {
      ReadInJoyLogicEngine.a().a(paramAbsBaseArticleInfo.mArticleID, System.currentTimeMillis());
      paramBuilder.a().notifyDataSetChanged();
      RIJFrameworkReportManager.a(paramBuilder.a(), paramAbsBaseArticleInfo, paramBuilder.b());
      RIJJumpUtils.a(paramView.getContext(), paramAbsBaseArticleInfo, str);
      return true;
    }
    return false;
  }
  
  private void b(View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    if (RIJItemViewTypeUtils.b(paramAbsBaseArticleInfo))
    {
      a(paramAbsBaseArticleInfo, paramBuilder);
      return;
    }
    RIJJumpUtils.a(paramBuilder.a(), paramAbsBaseArticleInfo, 1, false, 4, false);
  }
  
  private void b(RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    int j = paramBuilder.a().getCount();
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        Object localObject = paramBuilder.a().getItem(i);
        if ((localObject instanceof BaseArticleInfo))
        {
          localObject = (AbsBaseArticleInfo)localObject;
          BaseArticleInfoKt.a((AbsBaseArticleInfo)localObject, null, null, null);
          ((AbsBaseArticleInfo)localObject).invalidateProteusTemplateBean();
        }
        i += 1;
      }
    }
  }
  
  private void b(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    if ((paramAbsBaseArticleInfo != null) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.innerUniqueID)))
    {
      RIJFrameworkReportManager.a(paramBuilder.a(), paramAbsBaseArticleInfo, paramBuilder.b());
      paramBuilder.a().a(paramBuilder.b(), paramAbsBaseArticleInfo.mArticleID);
      RIJFeedsType.T(paramAbsBaseArticleInfo);
      if ((paramAbsBaseArticleInfo.mGalleryFeedsInfo != null) && (paramAbsBaseArticleInfo.mGalleryFeedsInfo.bytes_jump_url.has()) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8())))
      {
        String str = paramAbsBaseArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8();
        Bundle localBundle = new Bundle();
        localBundle.putString("big_brother_source_key", RIJJumpUtils.a(0));
        RIJJumpUtils.a(paramBuilder.a(), str, localBundle);
        GalleryReportedUtils.a(paramBuilder.a(), paramAbsBaseArticleInfo, paramBuilder.a());
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("RIJListViewGroupHandlerClick", 2, "jumpToGallery failed: url is null");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.e("RIJListViewGroupHandlerClick", 2, "jumpToGallery falied articleInfo is null or rowkey is empty");
    }
  }
  
  private void b(AbsBaseArticleInfo paramAbsBaseArticleInfo, Activity paramActivity, int paramInt)
  {
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo != null) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo.jdField_k_of_type_JavaLangString)))
    {
      RIJFrameworkReportManager.a(paramActivity, paramAbsBaseArticleInfo, paramInt);
      RIJJumpUtils.b(paramActivity, paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo.jdField_k_of_type_JavaLangString);
      ReadInJoyLogicEngine.a().a(paramAbsBaseArticleInfo.mArticleID, System.currentTimeMillis());
    }
  }
  
  private void b(AbsBaseArticleInfo paramAbsBaseArticleInfo, Activity paramActivity, int paramInt, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    RIJJumpUtils.a(paramActivity, paramAbsBaseArticleInfo, paramReadInJoyBaseAdapter, paramInt);
    ReadInJoyLogicEngine.a().a(paramAbsBaseArticleInfo.mArticleID, System.currentTimeMillis());
    paramReadInJoyBaseAdapter.notifyDataSetChanged();
    RIJJumpUtils.a(paramActivity, paramAbsBaseArticleInfo);
  }
  
  private boolean b(AbsBaseArticleInfo paramAbsBaseArticleInfo1, View paramView, int paramInt, ValueReference<Integer> paramValueReference, AbsBaseArticleInfo paramAbsBaseArticleInfo2, RIJListViewGroupHandlerClick.Builder paramBuilder, Handler paramHandler)
  {
    boolean bool3 = RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo2);
    boolean bool2 = false;
    boolean bool1 = false;
    if ((!bool3) && (!RIJItemViewTypeUtils.p(paramAbsBaseArticleInfo2)))
    {
      if (RIJItemViewTypeUtils.g(paramAbsBaseArticleInfo2))
      {
        b(paramView, paramAbsBaseArticleInfo2, paramBuilder);
        paramAbsBaseArticleInfo1 = "onOfficalRecommendClick";
        bool1 = bool2;
      }
      else if (RIJFeedsType.a(paramAbsBaseArticleInfo2))
      {
        if (a(paramAbsBaseArticleInfo1, paramView, paramInt, paramAbsBaseArticleInfo2, paramBuilder)) {
          bool1 = true;
        } else {
          paramValueReference.a(Integer.valueOf(4));
        }
        paramAbsBaseArticleInfo1 = "onVideoArticleClick";
      }
      else if (RIJFeedsType.c(paramAbsBaseArticleInfo2))
      {
        a(paramView, paramInt, paramAbsBaseArticleInfo2, paramBuilder, paramHandler);
        paramAbsBaseArticleInfo1 = "onGalleryClick";
        bool1 = bool2;
      }
      else if ((!RIJFeedsType.a(paramAbsBaseArticleInfo2.mArticleContentUrl, paramAbsBaseArticleInfo2.mChannelID, paramAbsBaseArticleInfo2)) && (!paramAbsBaseArticleInfo2.isAccountShown))
      {
        if (paramAbsBaseArticleInfo2.mFeedType == 26)
        {
          b(paramAbsBaseArticleInfo2, paramBuilder.a(), paramBuilder.b());
          paramAbsBaseArticleInfo1 = "onQuestionClick";
          bool1 = bool2;
        }
        else if (paramAbsBaseArticleInfo2.mFeedType == 23)
        {
          RIJJumpUtils.a(paramBuilder.a(), paramAbsBaseArticleInfo2, 1, false, 4, false);
          paramAbsBaseArticleInfo1 = "FeedsType_PGC_Gallery->jumpNewSocialSecondPage";
          bool1 = bool2;
        }
        else if (paramAbsBaseArticleInfo2.mFeedType == 34)
        {
          RIJJumpUtils.a(paramBuilder.a(), paramAbsBaseArticleInfo2.mArticleContentUrl, null);
          RIJFrameworkReportManager.b(paramAbsBaseArticleInfo2, paramBuilder.b());
          paramAbsBaseArticleInfo1 = "FeedsType_Scrip_Cms";
          bool1 = bool2;
        }
        else if (paramAbsBaseArticleInfo2.mFeedType == 39)
        {
          ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).jumpToMiniGame(paramAbsBaseArticleInfo2, paramBuilder.a(), paramInt);
          paramAbsBaseArticleInfo1 = "jumpToMiniGame";
          bool1 = bool2;
        }
        else
        {
          paramValueReference.a(Integer.valueOf(2));
          a(paramAbsBaseArticleInfo2, paramBuilder.a(), paramBuilder.b(), paramBuilder.a());
          paramAbsBaseArticleInfo1 = "onAdClick";
          bool1 = bool2;
        }
      }
      else
      {
        a(paramAbsBaseArticleInfo1, paramView, paramAbsBaseArticleInfo2, paramBuilder);
        paramValueReference.a(Integer.valueOf(2));
        paramAbsBaseArticleInfo1 = "onSupportNativeClick";
        bool1 = bool2;
      }
    }
    else
    {
      RIJJumpUtils.a(paramBuilder.a(), paramAbsBaseArticleInfo2, 0, false, 1, false);
      RIJFrameworkReportManager.b(paramAbsBaseArticleInfo2, paramBuilder.b());
      paramAbsBaseArticleInfo1 = "jumpNewSocialSecondPage";
      bool1 = bool2;
    }
    paramView = new StringBuilder();
    paramView.append("onItemClickPartTwo, jumpTarget= ");
    paramView.append(paramAbsBaseArticleInfo1);
    QLog.d("RIJListViewGroupHandlerClick", 1, paramView.toString());
    return bool1;
  }
  
  private void c(AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    if (RIJFeedsType.a(paramAbsBaseArticleInfo))
    {
      a(paramAbsBaseArticleInfo, null, 0, 0, false, 0, paramBuilder);
      return;
    }
    if (paramAbsBaseArticleInfo.isPGCShortContent())
    {
      PGCShortContentUtils.a(paramBuilder.a(), paramAbsBaseArticleInfo);
      return;
    }
    if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo)) {
      a(paramAbsBaseArticleInfo, paramBuilder);
    }
  }
  
  private void d(AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    if (paramAbsBaseArticleInfo.isPGCShortContent())
    {
      PGCShortContentUtils.a(paramBuilder.a(), paramAbsBaseArticleInfo);
      return;
    }
    a(paramAbsBaseArticleInfo, 2, paramBuilder);
  }
  
  private void e(AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface))
    {
      Object localObject3 = (QQAppInterface)localObject1;
      localObject1 = new NowFromData();
      if (paramBuilder.b() == 56)
      {
        ((NowFromData)localObject1).jdField_b_of_type_JavaLangString = "kandian_video";
        ((NowFromData)localObject1).jdField_a_of_type_JavaLangString = "kandian_video";
      }
      else
      {
        ((NowFromData)localObject1).jdField_b_of_type_JavaLangString = "kandian_shouye";
        ((NowFromData)localObject1).jdField_a_of_type_JavaLangString = "kandian_shouye";
      }
      Object localObject2 = new Bundle();
      int i = paramAbsBaseArticleInfo.mCommentIconType;
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      ((Bundle)localObject2).putBoolean("jump_now_switch", bool);
      try
      {
        localObject3 = (IDynamicNowManager)((QQAppInterface)localObject3).getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER);
        ((Bundle)localObject2).putString("roomid", paramAbsBaseArticleInfo.mArticleContentUrl);
        ((Bundle)localObject2).putString("fromid", ((NowFromData)localObject1).jdField_b_of_type_JavaLangString);
        ((IDynamicNowManager)localObject3).a((Bundle)localObject2);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("subscribeId to roomId error, ");
          ((StringBuilder)localObject2).append(localNumberFormatException.getMessage());
          QLog.d("RIJListViewGroupHandlerClick", 2, ((StringBuilder)localObject2).toString());
        }
      }
      RIJFrameworkReportManager.a(paramBuilder.a(), paramAbsBaseArticleInfo, paramBuilder.b());
    }
  }
  
  public void a(int paramInt, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    if ((paramBuilder.a() instanceof ReadInJoyNewFeedsActivity))
    {
      ((ReadInJoyNewFeedsActivity)paramBuilder.a()).d(paramInt);
    }
    else if ((paramBuilder.a() instanceof SplashActivity))
    {
      RIJTabFrameBase localRIJTabFrameBase = (RIJTabFrameBase)RIJJumpUtils.a(paramBuilder.a());
      if (localRIJTabFrameBase != null) {
        localRIJTabFrameBase.b(paramInt);
      }
    }
    if (DailyModeConfigHandler.c(paramBuilder.b())) {
      KandianDailyReportUtils.a(paramInt);
    }
    a(paramBuilder);
  }
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, HashMap<String, Integer> paramHashMap, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    if ((!StudyModeManager.a()) && (!paramAbsBaseArticleInfo.hasSearchWordInfo()))
    {
      int j = RIJBaseItemViewType.a(paramAbsBaseArticleInfo);
      int i = 3;
      if (((j == 3) || (RIJBaseItemViewType.a(paramAbsBaseArticleInfo) == 1)) && (paramAbsBaseArticleInfo.mIsShowSearchord == 1))
      {
        AladdinConfig localAladdinConfig = Aladdin.getConfig(201);
        j = 1000;
        int m = 0;
        int k;
        if (localAladdinConfig != null)
        {
          k = localAladdinConfig.getIntegerFromString("feeds_searchterm", 0);
          j = localAladdinConfig.getIntegerFromString("feeds_searchterm_max", 1000);
          i = localAladdinConfig.getIntegerFromString("feeds_pos_range_each_max", 3);
        }
        else
        {
          k = 0;
        }
        if (!DateUtils.isToday(SharedPreUtils.b("search_word_prefix_last_request_time")))
        {
          SharedPreUtils.a("search_word_prefix_last_request_time", System.currentTimeMillis());
          SharedPreUtils.a("search_word_prefix_show_times", 0L);
        }
        if (paramHashMap.containsKey(paramAbsBaseArticleInfo.mRefreshTime)) {
          m = ((Integer)paramHashMap.get(paramAbsBaseArticleInfo.mRefreshTime)).intValue();
        }
        if ((m < i) && (SharedPreUtils.b("search_word_prefix_show_times") < j) && (k == 1)) {
          ((UniteSearchHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.UNITE_SEARCH_HANDLER)).a(ByteStringMicro.copyFromUtf8(paramAbsBaseArticleInfo.innerUniqueID), new RIJListViewGroupHandlerClick.2(this, paramHashMap, paramAbsBaseArticleInfo, m, paramBuilder, paramInt));
        }
      }
    }
  }
  
  public void a(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof FeedItemCell)) {
      ((FeedItemCell)paramView).b();
    }
  }
  
  public void a(View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    if (paramInt == 2)
    {
      a(paramView, paramAbsBaseArticleInfo, paramBuilder);
      return;
    }
    if (paramInt == 1) {
      d(paramAbsBaseArticleInfo, paramBuilder);
    }
  }
  
  public void a(RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    Object localObject = paramBuilder.a().getItem(0);
    if ((paramBuilder.b() == 0) && ((localObject instanceof BaseArticleInfo)))
    {
      localObject = (AbsBaseArticleInfo)localObject;
      paramBuilder.a(NetConnInfoCenter.getServerTime());
      paramBuilder.a((AbsBaseArticleInfo)localObject);
      localObject = FeedsStructMsg.a((QQAppInterface)ReadInJoyUtils.a(), paramBuilder.a());
      String str = FeedsStructMsg.a(paramBuilder.a());
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).createFakeStructingMsgWithFields(RIJQQAppInterfaceUtil.b(), str, String.valueOf(paramBuilder.a()), (String)localObject, true);
    }
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    if (DailyModeConfigHandler.c(paramInt))
    {
      paramAbsBaseArticleInfo.mJumpType = 1;
      ReadInJoyHelper.a(paramAbsBaseArticleInfo);
    }
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    if (paramInt == 1)
    {
      RIJJumpUtils.a(paramBuilder.a(), paramAbsBaseArticleInfo, false);
      return;
    }
    if (paramInt == 2)
    {
      if ((RIJItemViewTypeUtils.c(paramAbsBaseArticleInfo)) && (RIJItemViewTypeUtils.b(paramAbsBaseArticleInfo)))
      {
        a(paramAbsBaseArticleInfo, paramBuilder);
        return;
      }
      RIJJumpUtils.a(paramBuilder.a(), paramAbsBaseArticleInfo, 3);
    }
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, View paramView, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    if (paramAbsBaseArticleInfo.mFeedType == 2) {
      return;
    }
    if (paramBuilder.b() == 0)
    {
      Integer localInteger = VideoFeedsHelper.a(paramBuilder.a(), paramAbsBaseArticleInfo);
      if (localInteger.intValue() != -1)
      {
        RIJFrameworkReportManager.a(paramAbsBaseArticleInfo, paramBuilder.a(), paramBuilder.b(), localInteger);
        return;
      }
    }
    if ((paramBuilder.b() == 0) && (!RIJFeedsType.z(paramAbsBaseArticleInfo)) && (!RIJFeedsType.D(paramAbsBaseArticleInfo)) && (!RIJFeedsType.E(paramAbsBaseArticleInfo)))
    {
      ReadInJoyLogicEngine.a().a(paramAbsBaseArticleInfo.mArticleID, System.currentTimeMillis());
      int i = paramAbsBaseArticleInfo.videoJumpChannelID;
      paramInt3 = 56;
      if (i > 0)
      {
        if (paramAbsBaseArticleInfo.videoJumpChannelID == 56)
        {
          if (QLog.isColorLevel())
          {
            paramView = new StringBuilder();
            paramView.append(" init translation animation for viewTop:");
            paramView.append(paramInt1);
            paramView.append("view left:");
            paramView.append(paramInt2);
            paramView.append("isFromItemClick:");
            paramView.append(paramBoolean);
            QLog.d("Q.readinjoy.videoanimation", 2, paramView.toString());
          }
          a(paramBuilder.a(), paramBuilder.a(), paramAbsBaseArticleInfo, paramInt1, paramInt2, paramBoolean);
        }
        else
        {
          paramView = new HashMap();
          paramView.put("param_key_insert_article_id", Long.valueOf(paramAbsBaseArticleInfo.mArticleID));
          ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchVideoSubChannelActivity(paramBuilder.a(), paramAbsBaseArticleInfo.videoJumpChannelID, paramAbsBaseArticleInfo.videoJumpChannelName, paramAbsBaseArticleInfo.videoJumpChannelType, 5, paramView);
        }
        paramInt1 = paramAbsBaseArticleInfo.videoJumpChannelID;
        RIJFrameworkReportManager.a(paramAbsBaseArticleInfo, paramBuilder.a(), paramBuilder.b());
      }
      else if (ReadInJoyHelper.d(BaseApplicationImpl.getApplication().getRuntime()) == 1)
      {
        a(paramBuilder.a(), paramBuilder.a(), paramAbsBaseArticleInfo, paramInt1, paramInt2, paramBoolean);
        RIJFrameworkReportManager.a(paramAbsBaseArticleInfo, paramBuilder.a(), paramBuilder.b());
        paramInt1 = paramInt3;
      }
      else
      {
        a(paramAbsBaseArticleInfo, paramView, paramBuilder);
        paramInt1 = -1;
      }
      if (paramInt1 != -1)
      {
        paramView = new ReportInfo.VideoExtraRepoerData();
        paramView.jdField_a_of_type_Int = paramInt1;
        VideoReporter.a(paramAbsBaseArticleInfo, paramBuilder.b(), 24, -1L, paramView);
      }
      if ((RIJBaseItemViewType.a(paramAbsBaseArticleInfo) != 6) && (RIJBaseItemViewType.a(paramAbsBaseArticleInfo) != 28)) {
        paramBuilder.a().notifyDataSetChanged();
      }
      return;
    }
    if (RIJFeedsType.E(paramAbsBaseArticleInfo)) {
      a(paramAbsBaseArticleInfo, (NewPolymericInfo.PackArticleInfo)paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(paramInt3), paramView, paramBuilder.b(), paramBuilder.a());
    } else {
      a(paramAbsBaseArticleInfo, paramView, paramBuilder);
    }
    ReadInJoyLogicEngine.a().a(paramAbsBaseArticleInfo.mArticleID, System.currentTimeMillis());
    if (!(paramView instanceof ComponentContentVerticalSmallVideo)) {
      paramBuilder.a().notifyDataSetChanged();
    }
    if (RIJFeedsType.C(paramAbsBaseArticleInfo))
    {
      paramView = ReadinjoyReportUtils.a(paramBuilder.a(), paramAbsBaseArticleInfo.mVideoAdsSource, paramInt3, paramAbsBaseArticleInfo.getInnerUniqueID(), 54, ReadinjoyReportUtils.a(paramAbsBaseArticleInfo), paramAbsBaseArticleInfo.videoReportInfo);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", String.valueOf(paramAbsBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long), "0X8008D33", "0X8008D33", 0, 0, Long.toString(paramAbsBaseArticleInfo.mFeedId), String.valueOf(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), paramView, false);
      RIJFrameworkReportManager.d(paramAbsBaseArticleInfo, paramInt3);
    }
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, View paramView, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    if (RIJFeedsType.h(paramAbsBaseArticleInfo))
    {
      a(paramAbsBaseArticleInfo, paramView, paramBuilder.b(), paramBuilder.a());
      return;
    }
    VideoPlayParam localVideoPlayParam = new VideoPlayParam();
    localVideoPlayParam.jdField_c_of_type_Long = paramAbsBaseArticleInfo.mArticleID;
    localVideoPlayParam.jdField_e_of_type_Long = paramAbsBaseArticleInfo.mXGFileSize;
    localVideoPlayParam.jdField_h_of_type_JavaLangString = paramAbsBaseArticleInfo.thirdUin;
    localVideoPlayParam.jdField_i_of_type_JavaLangString = paramAbsBaseArticleInfo.thirdUinName;
    localVideoPlayParam.jdField_k_of_type_JavaLangString = paramAbsBaseArticleInfo.mSubscribeID;
    localVideoPlayParam.jdField_g_of_type_Int = paramAbsBaseArticleInfo.mStrategyId;
    localVideoPlayParam.jdField_g_of_type_Long = paramAbsBaseArticleInfo.mAlgorithmID;
    ReadInJoyVideoReportData localReadInJoyVideoReportData = new ReadInJoyVideoReportData();
    localReadInJoyVideoReportData.a = Long.valueOf(paramAbsBaseArticleInfo.mArticleID);
    localReadInJoyVideoReportData.jdField_b_of_type_JavaLangString = paramAbsBaseArticleInfo.innerUniqueID;
    if (((!RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.n(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.p(paramAbsBaseArticleInfo))) || ((RIJItemViewTypeUtils.x(paramAbsBaseArticleInfo)) && ((!RIJFeedsType.C(paramAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.x(paramAbsBaseArticleInfo)))))
    {
      if ((RIJFeedsType.z(paramAbsBaseArticleInfo)) && (RIJFeedsType.a(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mPolymericSmallVideoCoverUrl != null))
      {
        localVideoPlayParam.jdField_b_of_type_JavaLangString = paramAbsBaseArticleInfo.mPolymericSmallVideoCoverUrl.getFile();
      }
      else
      {
        if (paramAbsBaseArticleInfo.mVideoCoverUrl == null) {
          localObject = null;
        } else {
          localObject = paramAbsBaseArticleInfo.mVideoCoverUrl.getFile();
        }
        localVideoPlayParam.jdField_b_of_type_JavaLangString = ((String)localObject);
      }
      localVideoPlayParam.jdField_c_of_type_JavaLangString = paramAbsBaseArticleInfo.mVideoVid;
      localVideoPlayParam.jdField_f_of_type_Int = paramAbsBaseArticleInfo.busiType;
      localVideoPlayParam.jdField_c_of_type_Int = paramAbsBaseArticleInfo.mVideoJsonWidth;
      localVideoPlayParam.jdField_d_of_type_Int = paramAbsBaseArticleInfo.mVideoJsonHeight;
      localReadInJoyVideoReportData.jdField_b_of_type_Int = paramAbsBaseArticleInfo.busiType;
      localVideoPlayParam.jdField_b_of_type_Int = paramAbsBaseArticleInfo.mVideoDuration;
      localVideoPlayParam.jdField_j_of_type_JavaLangString = paramAbsBaseArticleInfo.innerUniqueID;
      localVideoPlayParam.jdField_g_of_type_JavaLangString = paramAbsBaseArticleInfo.mThirdVideoURL;
      localVideoPlayParam.jdField_f_of_type_Long = paramAbsBaseArticleInfo.mThirdVideoURLExpireTime;
    }
    else
    {
      localVideoPlayParam.jdField_f_of_type_Int = ((UGCVideoInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b.get(0)).jdField_f_of_type_Int;
      localVideoPlayParam.jdField_c_of_type_Int = ((UGCVideoInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b.get(0)).jdField_a_of_type_Int;
      localVideoPlayParam.jdField_d_of_type_Int = ((UGCVideoInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b.get(0)).jdField_b_of_type_Int;
      localReadInJoyVideoReportData.jdField_b_of_type_Int = ((UGCVideoInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b.get(0)).jdField_f_of_type_Int;
      localVideoPlayParam.jdField_b_of_type_Int = ((int)(((UGCVideoInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b.get(0)).jdField_a_of_type_Long / 1000L));
      localVideoPlayParam.jdField_b_of_type_JavaLangString = ((UGCVideoInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b.get(0)).jdField_d_of_type_JavaLangString;
      localVideoPlayParam.jdField_j_of_type_JavaLangString = ((UGCVideoInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b.get(0)).jdField_g_of_type_JavaLangString;
      localVideoPlayParam.jdField_c_of_type_JavaLangString = ((UGCVideoInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b.get(0)).jdField_i_of_type_JavaLangString;
      if ((RIJFeedsType.z(paramAbsBaseArticleInfo)) && (RIJFeedsType.a(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mPolymericSmallVideoCoverUrl != null)) {
        localVideoPlayParam.jdField_b_of_type_JavaLangString = paramAbsBaseArticleInfo.mPolymericSmallVideoCoverUrl.getFile();
      } else {
        localVideoPlayParam.jdField_b_of_type_JavaLangString = ((UGCVideoInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b.get(0)).jdField_d_of_type_JavaLangString;
      }
    }
    localReadInJoyVideoReportData.jdField_c_of_type_JavaLangString = paramAbsBaseArticleInfo.mVideoVid;
    localVideoPlayParam.a = localReadInJoyVideoReportData;
    localVideoPlayParam.jdField_d_of_type_JavaLangString = paramAbsBaseArticleInfo.thirdIcon;
    localVideoPlayParam.jdField_e_of_type_JavaLangString = paramAbsBaseArticleInfo.thirdName;
    localVideoPlayParam.jdField_f_of_type_JavaLangString = paramAbsBaseArticleInfo.thirdAction;
    if (paramView != null)
    {
      localObject = new int[2];
      paramView.getLocationOnScreen((int[])localObject);
      localVideoPlayParam.jdField_h_of_type_Int = localObject[0];
      localVideoPlayParam.jdField_i_of_type_Int = localObject[1];
      localVideoPlayParam.jdField_j_of_type_Int = paramView.getWidth();
      localVideoPlayParam.jdField_k_of_type_Int = paramView.getHeight();
      if (((paramView instanceof ComponentContentVerticalSmallVideo)) && (((ComponentContentVerticalSmallVideo)paramView).jdField_a_of_type_Boolean))
      {
        localObject = RIJComponentConfigImage.a(3, paramBuilder.b());
        localVideoPlayParam.jdField_h_of_type_Int += (localVideoPlayParam.jdField_j_of_type_Int - ((Integer)((Pair)localObject).first).intValue()) / 2;
        localVideoPlayParam.jdField_j_of_type_Int = ((Integer)((Pair)localObject).first).intValue();
      }
      VideoFeedsHelper.a(localVideoPlayParam, paramView);
    }
    Object localObject = new ReportInfo.VideoExtraRepoerData();
    ((ReportInfo.VideoExtraRepoerData)localObject).jdField_a_of_type_Int = 409409;
    if (paramBuilder.b() != 56) {
      paramBuilder.a().a(localVideoPlayParam, paramAbsBaseArticleInfo);
    }
    if (paramBuilder.b() == 0) {
      VideoReporter.a(paramAbsBaseArticleInfo, paramBuilder.b(), 24, -1L, (ReportInfo.VideoExtraRepoerData)localObject);
    }
    ReadInJoyLogicEngine.a().a(paramAbsBaseArticleInfo.mArticleID, System.currentTimeMillis());
    if (!(paramView instanceof ComponentContentVerticalSmallVideo)) {
      paramBuilder.a().notifyDataSetChanged();
    }
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    if (RIJFeedsType.a(paramAbsBaseArticleInfo.mArticleContentUrl, paramAbsBaseArticleInfo.mChannelID, paramAbsBaseArticleInfo)) {
      b(paramAbsBaseArticleInfo, paramBuilder);
    } else {
      RIJJumpUtils.a(paramBuilder.a(), paramAbsBaseArticleInfo, paramBuilder.a(), paramBuilder.b());
    }
    ReadinjoyReportUtils.a(paramAbsBaseArticleInfo);
  }
  
  @VisibleForTesting
  boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (RIJItemViewTypeUtils.a(paramAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.g(paramAbsBaseArticleInfo)) || (RIJFeedsType.j(paramAbsBaseArticleInfo)) || (RIJFeedsType.k(paramAbsBaseArticleInfo)) || (RIJFeedsType.m(paramAbsBaseArticleInfo)) || (RIJFeedsType.n(paramAbsBaseArticleInfo));
  }
  
  @VisibleForTesting
  boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    return (RIJItemViewTypeUtils.c(paramInt)) || (RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.n(paramAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.p(paramAbsBaseArticleInfo));
  }
  
  public boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo1, View paramView, int paramInt, ValueReference<Integer> paramValueReference, AbsBaseArticleInfo paramAbsBaseArticleInfo2, RIJListViewGroupHandlerClick.Builder paramBuilder, Handler paramHandler)
  {
    boolean bool2 = RIJItemViewTypeUtils.B(paramAbsBaseArticleInfo2);
    boolean bool1 = false;
    if (bool2)
    {
      paramAbsBaseArticleInfo1 = "clickWeChatVideoCard";
    }
    else if (RIJItemViewTypeUtils.h(paramAbsBaseArticleInfo2))
    {
      RIJJumpUtils.b(paramBuilder.a(), paramAbsBaseArticleInfo2, 6);
      RIJFrameworkReportManager.a(paramBuilder.a(), paramAbsBaseArticleInfo2, paramBuilder.b());
      paramAbsBaseArticleInfo1 = "clickCommentBiuCard";
    }
    else if (RIJFeedsType.C(paramAbsBaseArticleInfo2))
    {
      a(paramAbsBaseArticleInfo2, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt, paramBuilder);
      paramValueReference.a(Integer.valueOf(4));
      paramAbsBaseArticleInfo1 = "handleVideoFeedsClickJump";
    }
    else if (paramAbsBaseArticleInfo2.mFeedType == 3)
    {
      e(paramAbsBaseArticleInfo2, paramBuilder);
      paramAbsBaseArticleInfo1 = "onNowFeedsClick";
    }
    else if (paramAbsBaseArticleInfo2.mFeedType == 13)
    {
      a(paramAbsBaseArticleInfo2, paramBuilder.a(), paramBuilder.b());
      paramAbsBaseArticleInfo1 = "onQEGameClick";
    }
    else if ((paramAbsBaseArticleInfo2.mFeedType != 22) && (paramAbsBaseArticleInfo2.mFeedType != 21) && (!RIJFeedsType.v(paramAbsBaseArticleInfo2)))
    {
      if (RIJBaseItemViewType.a(paramAbsBaseArticleInfo2))
      {
        a(paramAbsBaseArticleInfo1, paramView, paramAbsBaseArticleInfo2, paramBuilder.a());
        paramAbsBaseArticleInfo1 = "onPgcShortContentClick";
      }
      else if ((RIJItemViewTypeUtils.a(paramAbsBaseArticleInfo2)) && (RIJItemViewTypeUtils.b(paramAbsBaseArticleInfo2)))
      {
        a(paramAbsBaseArticleInfo2, paramBuilder);
        paramAbsBaseArticleInfo1 = "jumpArticleDetail";
      }
      else if (RIJItemViewTypeUtils.a(paramAbsBaseArticleInfo2))
      {
        RIJJumpUtils.a(paramBuilder.a(), paramAbsBaseArticleInfo2, 1, false, 4, false);
        paramAbsBaseArticleInfo1 = "RIJItemViewType -> jumpNewSocialSecondPage";
      }
      else if (RIJBaseItemViewType.a(paramAbsBaseArticleInfo2) == 71)
      {
        a(paramView, paramInt, paramAbsBaseArticleInfo2, paramBuilder);
        paramValueReference.a(Integer.valueOf(4));
        paramAbsBaseArticleInfo1 = "onUgcVideoAsPgcClick";
      }
      else if ((!RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo2)) && (!RIJItemViewTypeUtils.n(paramAbsBaseArticleInfo2)))
      {
        if ((!RIJFeedsType.j(paramAbsBaseArticleInfo2)) && (!RIJFeedsType.k(paramAbsBaseArticleInfo2)))
        {
          if (RIJFeedsType.f(paramAbsBaseArticleInfo2))
          {
            a(paramAbsBaseArticleInfo2, 1, paramBuilder);
            GalleryReportedUtils.a(paramBuilder.a(), paramAbsBaseArticleInfo2, paramBuilder.a());
            paramValueReference.a(Integer.valueOf(2));
            paramAbsBaseArticleInfo1 = "jumpSocialDetailPageWhenClick";
          }
          else
          {
            bool1 = b(paramAbsBaseArticleInfo1, paramView, paramInt, paramValueReference, paramAbsBaseArticleInfo2, paramBuilder, paramHandler);
            paramAbsBaseArticleInfo1 = "onItemClickPartTwo";
          }
        }
        else
        {
          RIJJumpUtils.a(paramBuilder.a(), paramAbsBaseArticleInfo2, 1, false, 4, false);
          RIJFrameworkReportManager.b(paramAbsBaseArticleInfo2, paramBuilder.b());
          RIJFrameworkReportManager.c(paramAbsBaseArticleInfo2, paramBuilder.b());
          paramAbsBaseArticleInfo1 = "isTopicRecommend->jumpNewSocialSecondPage";
        }
      }
      else
      {
        RIJJumpUtils.a(paramBuilder.a(), paramAbsBaseArticleInfo2, 4, false, 3, false);
        RIJFrameworkReportManager.b(paramAbsBaseArticleInfo2, paramBuilder.b());
        paramAbsBaseArticleInfo1 = "isUGC->jumpNewSocialSecondPage";
      }
    }
    else
    {
      RIJJumpUtils.a(paramBuilder.a(), paramAbsBaseArticleInfo2, 4, false, 3, false);
      paramAbsBaseArticleInfo1 = "jumpNewSocialSecondPage";
    }
    paramView = new StringBuilder();
    paramView.append("onItemClickPartOwn, jumpTarget= ");
    paramView.append(paramAbsBaseArticleInfo1);
    QLog.d("RIJListViewGroupHandlerClick", 1, paramView.toString());
    return bool1;
  }
  
  public void b(AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJListViewGroupHandlerClick.Builder paramBuilder)
  {
    TimeUtil.b("fast_web_show_light_house_1");
    FastWebModule localFastWebModule = ReadInJoyLogicEngine.a().a();
    AbsBaseArticleInfo localAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    if (RIJFeedsType.h(paramAbsBaseArticleInfo))
    {
      localAbsBaseArticleInfo = paramAbsBaseArticleInfo;
      if (!paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean) {
        localAbsBaseArticleInfo = a(paramAbsBaseArticleInfo);
      }
    }
    if (localFastWebModule != null) {
      paramBuilder.b(localFastWebModule.a(localAbsBaseArticleInfo.mArticleContentUrl, String.valueOf(localAbsBaseArticleInfo.innerUniqueID), localAbsBaseArticleInfo.mSubscribeID, 1, null));
    }
    b(localAbsBaseArticleInfo, paramBuilder.a(), paramBuilder.b(), paramBuilder.a());
  }
  
  @VisibleForTesting
  boolean b(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    return (paramInt == 11) || (paramInt == 28) || (RIJItemViewTypeUtils.a(paramAbsBaseArticleInfo) == 23) || (RIJItemViewTypeUtils.b(paramAbsBaseArticleInfo) == 56);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.click.RIJListViewGroupHandlerClick
 * JD-Core Version:    0.7.0.1
 */