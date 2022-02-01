package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.os.TraceCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJVideoAdService;
import com.tencent.mobileqq.kandian.ad.api.entity.IADVideoAppDownloadManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IADVideoFeedsGuideManager;
import com.tencent.mobileqq.kandian.ad.api.entity.INegativeHelper;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoAdExposureManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoFeedsHardAdBarManager;
import com.tencent.mobileqq.kandian.base.bandwidth.VideoPreloadStrategyConoller;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.view.widget.ListEventListener;
import com.tencent.mobileqq.kandian.biz.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsInsertModule;
import com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.FooterItemHolder;
import com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.ShortVideoItemDelegate;
import com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.ShortVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.TiktokVideoItemDelegate;
import com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.TiktokVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.reward.RIJVideoRewardCoinManager;
import com.tencent.mobileqq.kandian.biz.reward.RIJVideoRewardCoinManager.Companion;
import com.tencent.mobileqq.kandian.biz.reward.RIJVideoRewardCoinManager.RIJRewardInfo;
import com.tencent.mobileqq.kandian.biz.video.FeedsChannelDataHelper;
import com.tencent.mobileqq.kandian.biz.video.VideoColumnBannerManager;
import com.tencent.mobileqq.kandian.biz.video.playfeedback.PlayFeedbackHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IMsgLayoutHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAdapter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsFollowButton;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsItemUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsPlayManager;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsVideoUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.delegate.BaseVideoItemDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.UGDownloadInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoBrightnessController;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.LikeActionDownloadBar;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.LocationInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr;
import com.tencent.mobileqq.kandian.glue.video.VideoResumeManager;
import com.tencent.mobileqq.kandian.glue.video.report.VideoPreloadReportData;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule;
import com.tencent.mobileqq.kandian.repo.biu.BiuBehaviour;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.ActionType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo.VideoExtraRepoerData;
import com.tencent.mobileqq.kandian.repo.video.entity.LiveStatus;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoCardType;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.KandianPopupWindowForAd;
import com.tencent.widget.PopupMenuDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoFeedsAdapter
  extends RecyclerView.Adapter<BaseItemHolder>
  implements VideoFeedsRecommendManager.Listener, IVideoFeedsAdapter, IReadInJoyUserInfoModule.RefreshUserInfoCallBack, VideoCardType
{
  private static boolean jdField_d_of_type_Boolean = false;
  public int a;
  public long a;
  public Activity a;
  private Context jdField_a_of_type_AndroidContentContext;
  public ColorDrawable a;
  public Drawable a;
  public Handler a;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView.RecycledViewPool jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$RecycledViewPool = new RecyclerView.RecycledViewPool();
  public Animation a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IADVideoFeedsGuideManager jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIADVideoFeedsGuideManager;
  public INegativeHelper a;
  private IVideoAdExposureManager jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdExposureManager;
  public IVideoFeedsHardAdBarManager a;
  public ListEventListener a;
  public VideoFeedsAdapter.AdapterEventListener a;
  public VideoFeedsCommentManager a;
  public VideoFeedsLikeAnimateManager a;
  public VideoFeedsPlayManager a;
  private VideoFeedsRecommendManager jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendManager;
  private VideoFeedsRecommendPresenter jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter;
  private VideoFeedsReporter jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsReporter;
  FooterItemHolder jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsFooterItemHolder;
  private RIJVideoRewardCoinManager jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager;
  public VideoColumnBannerManager a;
  public VideoBrightnessController a;
  private VideoInfo jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
  public VideoFeedsRecyclerView a;
  public BaseVideoItemHolder a;
  private VideoItemHolder jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder;
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new VideoFeedsAdapter.12(this);
  public KandianPopupWindowForAd a;
  public PopupMenuDialog a;
  private String jdField_a_of_type_JavaLangString;
  private List<VideoInfo> jdField_a_of_type_JavaUtilList;
  private Map<Integer, Bitmap> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  public boolean a;
  public int b;
  private long b;
  public Drawable b;
  public boolean b;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = 0L;
  public boolean c;
  private int jdField_d_of_type_Int = 1;
  private int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean = true;
  private boolean f = false;
  private boolean g = true;
  private boolean h = false;
  private boolean i = true;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private final boolean m;
  private boolean n = false;
  private boolean o = true;
  
  VideoFeedsAdapter(Context paramContext, Activity paramActivity, Bundle paramBundle, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, LinearLayoutManager paramLinearLayoutManager, QQAppInterface paramQQAppInterface, boolean paramBoolean, int paramInt, VideoFeedsRecommendPresenter paramVideoFeedsRecommendPresenter)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = null;
    this.jdField_a_of_type_Long = -2147483648L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler = new VideoFeedsAdapter.3(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetListEventListener = new VideoFeedsAdapter.4(this);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView = paramVideoFeedsRecyclerView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetListEventListener);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = paramLinearLayoutManager;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ImageUtil.a(true);
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165327));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoBrightnessController = new VideoBrightnessController(paramActivity);
    jdField_d_of_type_Boolean = paramBoolean;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd = new KandianPopupWindowForAd(this.jdField_a_of_type_AndroidAppActivity);
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidAppActivity.getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(1930498322);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter = paramVideoFeedsRecommendPresenter;
    setHasStableIds(true);
    registerAdapterDataObserver(new VideoFeedsAdapter.ActionInspector(this, null));
    this.jdField_b_of_type_Boolean = SimpleUIUtil.a();
    this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityINegativeHelper = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createNegativeHelper(paramActivity, this);
    this.m = ReadInJoyHelper.b();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsReporter = paramVideoFeedsRecommendPresenter.a();
    this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoFeedsHardAdBarManager = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createVideoFeedsHardAdBarManager(paramContext, this.m, paramActivity, this);
    paramVideoFeedsRecommendPresenter.a(this);
  }
  
  private String a(int paramInt)
  {
    if (paramInt == 1) {
      return HardCodeUtil.a(2131715997);
    }
    if (paramInt == 2) {
      return HardCodeUtil.a(2131715994);
    }
    return null;
  }
  
  private void a(View paramView, VideoInfo paramVideoInfo)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter;
    if (localObject != null)
    {
      ((VideoFeedsRecommendPresenter)localObject).a();
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
      if ((localObject instanceof VideoItemHolder))
      {
        ImageView localImageView = ((BaseVideoItemHolder)localObject).g;
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.e()) {
          localObject = "click_pause";
        } else {
          localObject = "click_play";
        }
        VideoFeedsHelper.a(localImageView, paramVideoInfo, (String)localObject);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIMsgLayoutHelper.a();
    if (paramView.getId() == 2131366291) {
      PlayFeedbackHelper.b(paramVideoInfo.g, 2);
    }
  }
  
  private void a(View paramView, BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131380754: 
      paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
      if ((paramView != null) && (paramView.j != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter.e();
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsReporter.c(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo, "0X8009F42");
        return;
      }
      break;
    case 2131380695: 
      i(paramVideoInfo);
      return;
    case 2131372166: 
      a(paramBaseItemHolder);
      return;
    case 2131366291: 
    case 2131372826: 
      a(paramView, paramVideoInfo);
    }
  }
  
  private void a(AbsVideoFeedsUGView paramAbsVideoFeedsUGView, boolean paramBoolean)
  {
    if (paramAbsVideoFeedsUGView != null) {
      paramAbsVideoFeedsUGView.setActive(paramBoolean);
    }
  }
  
  private void a(FooterItemHolder paramFooterItemHolder)
  {
    int i1 = this.jdField_d_of_type_Int;
    if (i1 == 1)
    {
      paramFooterItemHolder.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      paramFooterItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramFooterItemHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramFooterItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(a(1));
      return;
    }
    if (i1 == 2)
    {
      paramFooterItemHolder.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      paramFooterItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramFooterItemHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramFooterItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(a(2));
      return;
    }
    if (i1 == 3)
    {
      if (paramFooterItemHolder.jdField_a_of_type_Int == 6)
      {
        paramFooterItemHolder.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        paramFooterItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        paramFooterItemHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramFooterItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(a(1));
        return;
      }
      paramFooterItemHolder.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      paramFooterItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramFooterItemHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void a(VideoInfo paramVideoInfo, int paramInt, Integer paramInteger)
  {
    if (paramVideoInfo == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager;
    if (localObject != null) {
      ((VideoFeedsPlayManager)localObject).a(ReportConstants.VideoEndType.AD_AREA_CLICK);
    }
    localObject = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo);
    int i1;
    if (paramVideoInfo.b(this.jdField_a_of_type_AndroidAppActivity)) {
      i1 = 10;
    } else {
      i1 = 5;
    }
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.jdField_a_of_type_AndroidContentContext).a(1).b(i1).b(paramInteger).a((AdvertisementInfo)localObject).a(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo).c(paramInt));
  }
  
  private void a(VideoInfo paramVideoInfo, BaseItemHolder paramBaseItemHolder, boolean paramBoolean)
  {
    if ((paramVideoInfo.r) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).instanceOfADVideoItemHolder(paramBaseItemHolder)))
    {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).showVideoAdToast(paramBaseItemHolder, "暂不支持biu");
      return;
    }
    RIJUserLevelModule.getInstance().doActionsByUserLevel(this.jdField_a_of_type_AndroidAppActivity, 2, new VideoFeedsAdapter.6(this, paramVideoInfo, paramBaseItemHolder, paramBoolean));
  }
  
  private void a(VideoInfo paramVideoInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramVideoInfo == null) {
      return;
    }
    b(paramVideoInfo, paramBoolean2);
    Object localObject1 = new VideoR5.Builder(paramVideoInfo.d(), paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.a(), paramVideoInfo.c() * 1000);
    ((VideoR5.Builder)localObject1).g(paramBoolean1).h(paramBoolean2).b(this.m);
    if (!jdField_d_of_type_Boolean)
    {
      ((VideoR5.Builder)localObject1).e(paramVideoInfo.f).c(paramVideoInfo.jdField_p_of_type_Int).a(-1).a(paramVideoInfo.w).M(0);
      localObject2 = new ReportInfo.VideoExtraRepoerData();
      ((ReportInfo.VideoExtraRepoerData)localObject2).jdField_d_of_type_Int = ((int)this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.a());
      ((ReportInfo.VideoExtraRepoerData)localObject2).jdField_e_of_type_Int = (paramVideoInfo.c() * 1000);
      ((ReportInfo.VideoExtraRepoerData)localObject2).jdField_b_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      VideoReporter.b(paramVideoInfo, this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1), 25, -1, (ReportInfo.VideoExtraRepoerData)localObject2, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.g);
    }
    localObject1 = ((VideoR5.Builder)localObject1).a().a();
    if (jdField_d_of_type_Boolean)
    {
      localObject2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      str = paramVideoInfo.j;
      if (!TextUtils.isEmpty(paramVideoInfo.g)) {
        paramVideoInfo = paramVideoInfo.g;
      } else {
        paramVideoInfo = "0";
      }
      ((IPublicAccountReportUtils)localObject2).publicAccountReportClickEvent(null, str, "0X8009299", "0X8009299", 0, 0, "0", "0", paramVideoInfo, (String)localObject1, false);
      return;
    }
    Object localObject2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    String str = paramVideoInfo.j;
    if (!TextUtils.isEmpty(paramVideoInfo.g)) {
      paramVideoInfo = paramVideoInfo.g;
    } else {
      paramVideoInfo = "0";
    }
    ((IPublicAccountReportUtils)localObject2).publicAccountReportClickEvent(null, str, "0X8007B89", "0X8007B89", 0, 0, "0", "0", paramVideoInfo, (String)localObject1, false);
  }
  
  @RequiresApi(api=16)
  private void a(VideoPlayParam paramVideoPlayParam)
  {
    VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_c_of_type_ComTencentImageURLImageView, 8, 0);
    this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getViewTreeObserver().addOnDrawListener(new VideoFeedsAdapter.1(this, paramVideoPlayParam));
  }
  
  private void a(BaseItemHolder paramBaseItemHolder)
  {
    if ((paramBaseItemHolder.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.b())) {
      VideoFeedsHelper.a(((VideoItemHolder)paramBaseItemHolder).d, 8, 200);
    }
    paramBaseItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter;
    if (paramBaseItemHolder != null) {
      paramBaseItemHolder.a();
    }
  }
  
  private void a(BaseVideoItemHolder paramBaseVideoItemHolder, VideoInfo paramVideoInfo)
  {
    VideoPlayParam localVideoPlayParam2 = paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
    VideoPlayParam localVideoPlayParam1 = localVideoPlayParam2;
    if (localVideoPlayParam2 == null)
    {
      localVideoPlayParam1 = new VideoPlayParam();
      localVideoPlayParam1.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate = paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsVideoUIDelegate;
      localVideoPlayParam1.jdField_a_of_type_AndroidOsBundle.putInt("jump_from_scene", this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 0));
    }
    localVideoPlayParam1.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo = paramVideoInfo;
    localVideoPlayParam1.jdField_a_of_type_Int = paramVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity, paramBaseVideoItemHolder.jdField_d_of_type_Int);
    localVideoPlayParam1.jdField_a_of_type_AndroidViewViewGroup = paramBaseVideoItemHolder.jdField_b_of_type_AndroidViewViewGroup;
    localVideoPlayParam1.jdField_b_of_type_Int = paramBaseVideoItemHolder.jdField_c_of_type_Int;
    localVideoPlayParam1.jdField_a_of_type_Boolean = false;
    localVideoPlayParam1.jdField_a_of_type_AndroidOsBundle.putInt("video_feeds_index", paramBaseVideoItemHolder.jdField_c_of_type_Int);
    localVideoPlayParam1.jdField_a_of_type_Long = VideoResumeManager.a.a(paramVideoInfo.g, paramVideoInfo.jdField_a_of_type_JavaLangString);
    localVideoPlayParam1.jdField_b_of_type_Boolean = true;
    if (paramVideoInfo.r) {
      if (paramVideoInfo.b(this.jdField_a_of_type_AndroidAppActivity)) {
        localVideoPlayParam1.jdField_a_of_type_AndroidOsBundle.putInt("ad_origin", 10);
      } else {
        localVideoPlayParam1.jdField_a_of_type_AndroidOsBundle.putInt("ad_origin", 5);
      }
    }
    paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsVideoUIDelegate.b(true);
    paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam = localVideoPlayParam1;
    paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIMsgLayoutHelper.a(this, paramBaseVideoItemHolder);
  }
  
  private void a(BaseVideoItemHolder paramBaseVideoItemHolder, boolean paramBoolean, long paramLong, int paramInt)
  {
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_Long != 0L) {
        ThreadManager.excute(new VideoFeedsAdapter.2(this, paramLong), 16, null, true);
      }
      if ((paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null) && (paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData != null))
      {
        paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.o = paramLong;
        paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.u = ReadInJoyUtils.a(paramInt, paramBaseVideoItemHolder.jdField_c_of_type_Int, false);
      }
      if ((paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null) && (paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizAdReportReadinjoyAdVideoReportData != null)) {
        paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizAdReportReadinjoyAdVideoReportData.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  private void a(VideoItemHolder paramVideoItemHolder, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramVideoInfo.r) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).instanceOfADVideoItemHolder(paramVideoItemHolder)))
    {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).showVideoAdToast(paramVideoItemHolder, "作者设置暂不可评论");
      return;
    }
    c(paramVideoItemHolder, paramVideoInfo);
  }
  
  private boolean a(RecyclerView paramRecyclerView, List<VideoInfo> paramList, VideoInfo paramVideoInfo)
  {
    int i2 = paramRecyclerView.getChildCount();
    int i3 = paramList.indexOf(paramVideoInfo);
    int i1 = 0;
    while (i1 < i2)
    {
      paramList = paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i1));
      if ((i3 >= 0) && ((paramList instanceof VideoItemHolder)))
      {
        paramList = (VideoItemHolder)paramList;
        if (paramList.jdField_b_of_type_Int == i3)
        {
          paramList.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.c(paramVideoInfo);
          return true;
        }
      }
      i1 += 1;
    }
    return false;
  }
  
  private boolean a(RecyclerView paramRecyclerView, List<VideoInfo> paramList, String paramString)
  {
    int i2 = paramRecyclerView.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i1));
      if ((localObject instanceof VideoItemHolder))
      {
        localObject = (VideoItemHolder)localObject;
        int i3 = ((VideoItemHolder)localObject).jdField_b_of_type_Int;
        if (i3 < paramList.size())
        {
          VideoInfo localVideoInfo = (VideoInfo)paramList.get(i3);
          if (paramString.equals(localVideoInfo.j)) {
            ((VideoItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.c(localVideoInfo);
          }
        }
      }
      i1 += 1;
    }
    return false;
  }
  
  private boolean a(VideoInfo paramVideoInfo, String paramString)
  {
    if ((paramVideoInfo.j != null) && (paramVideoInfo.j.equals(paramString)))
    {
      boolean bool = paramVideoInfo.jdField_p_of_type_Boolean;
      paramVideoInfo.jdField_p_of_type_Boolean = true;
      return bool ^ true;
    }
    return false;
  }
  
  private void b(View paramView, int paramInt1, int paramInt2)
  {
    VideoItemHolder localVideoItemHolder = (VideoItemHolder)paramView.getTag();
    if (localVideoItemHolder != this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder) {
      return;
    }
    if (!this.o) {
      return;
    }
    int i2;
    Object localObject;
    JSONObject localJSONObject;
    String str1;
    if ((localVideoItemHolder != null) && (localVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null) && ((localVideoItemHolder instanceof BaseVideoItemHolder)) && (!TextUtils.isEmpty(localVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.g)))
    {
      paramView = localVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
      boolean bool = paramView.q;
      i2 = 1;
      bool ^= true;
      paramView.q = true;
      int i1;
      if (bool) {
        i1 = paramView.s + 1;
      } else {
        i1 = paramView.s;
      }
      paramView.s = i1;
      localVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.a(paramInt1, paramInt2, bool);
      if (bool)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter$AdapterEventListener;
        if (localObject != null) {
          ((VideoFeedsAdapter.AdapterEventListener)localObject).a(paramView, paramView.q);
        }
        j(paramView);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendManager;
      if (localObject != null) {
        ((VideoFeedsRecommendManager)localObject).a(3, paramView, 0L);
      }
      VideoFeedsHelper.a(localVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityAbsVideoFeedsGestureLayout, paramView, "click_like", "double");
      VideoReport.reportEvent("clck", localVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityAbsVideoFeedsGestureLayout, null);
      localJSONObject = new JSONObject();
      str1 = localVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.d();
    }
    try
    {
      localJSONObject.put("channel_id", 409409);
      localJSONObject.put("rowkey", localVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.g);
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimateManager == null) {
        break label511;
      }
      paramInt1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimateManager.a();
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        IPublicAccountReportUtils localIPublicAccountReportUtils;
        String str2;
        continue;
        paramInt1 = 0;
        continue;
        paramView = "";
        continue;
        paramInt1 = 0;
      }
    }
    localJSONObject.put("style", paramInt1);
    localJSONObject.put("algorithm_id", paramView.f);
    if (paramView.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LikeActionDownloadBar != null)
    {
      paramView = paramView.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LikeActionDownloadBar.jdField_c_of_type_JavaLangString;
      localJSONObject.put("common_data", paramView);
      if (!this.m) {
        break label523;
      }
      paramInt1 = i2;
      localJSONObject.put("interact_button_style", paramInt1);
      if (jdField_d_of_type_Boolean) {
        paramView = "0X80097F5";
      } else {
        paramView = "0X80091AA";
      }
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      str2 = localVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.j;
      if (!TextUtils.isEmpty(localVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.g)) {
        localObject = localVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.g;
      } else {
        localObject = "0";
      }
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str2, paramView, paramView, 0, 0, "0", "0", (String)localObject, VideoReporter.a(str1, localVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.j, localVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString, localVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.g, localJSONObject), false);
    }
  }
  
  private void b(View paramView, BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo)
  {
    AdvertisementInfo localAdvertisementInfo = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoFeedsHardAdBarManager.a(paramVideoInfo, false);
    switch (paramView.getId())
    {
    default: 
    case 2131380615: 
      b(paramBaseItemHolder, paramVideoInfo);
      return;
    case 2131380597: 
      g(paramVideoInfo);
      return;
    case 2131368122: 
      a(paramVideoInfo, paramVideoInfo);
      return;
    case 2131368090: 
      h(paramVideoInfo);
      return;
    case 2131367921: 
      b((VideoItemHolder)paramBaseItemHolder, paramVideoInfo);
      return;
    case 2131367154: 
      a((VideoItemHolder)paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo);
      return;
    case 2131367153: 
      b((VideoItemHolder)paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo);
      return;
    case 2131367148: 
      paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter$AdapterEventListener;
      if (paramView != null)
      {
        paramView.d();
        return;
      }
      break;
    case 2131367143: 
      f(paramVideoInfo);
      return;
    case 2131367132: 
      RIJUserLevelModule.getInstance().doActionsByUserLevel(this.jdField_a_of_type_AndroidAppActivity, 3, new VideoFeedsAdapter.5(this, paramBaseItemHolder, paramVideoInfo));
      return;
    case 2131367124: 
    case 2131372094: 
      a(paramVideoInfo, paramBaseItemHolder, false);
      return;
    case 2131365003: 
      a(paramView);
      return;
    case 2131364715: 
    case 2131367407: 
      paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView;
      if (paramView != null)
      {
        paramView.b();
        return;
      }
      break;
    case 2131361862: 
      paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView;
      if (paramView != null) {
        paramView.a();
      }
      break;
    }
  }
  
  private void b(VideoInfo paramVideoInfo, BaseItemHolder paramBaseItemHolder, boolean paramBoolean)
  {
    if ((paramBaseItemHolder instanceof VideoItemHolder)) {
      VideoFeedsHelper.a(((VideoItemHolder)paramBaseItemHolder).l, paramVideoInfo, "click_biu");
    }
    if ((paramVideoInfo instanceof VideoInfo))
    {
      int i1 = BiuBehaviour.a();
      boolean bool = true;
      if (i1 != 1) {
        bool = false;
      }
      a(paramVideoInfo, paramBoolean, bool);
      paramBaseItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendManager;
      if (paramBaseItemHolder != null) {
        paramBaseItemHolder.a(2, paramVideoInfo, 0L);
      }
    }
  }
  
  private void b(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    try
    {
      localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, ReadInJoyDeliverBiuActivity.class);
      if ((paramVideoInfo.jdField_a_of_type_Int == 6) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null)) {
        ((Intent)localObject).putExtra("feedsType", paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedType);
      }
      ((Intent)localObject).putExtra("ARG_VIDEO_ARTICLE_ID", paramVideoInfo.g);
      ((Intent)localObject).putExtra("biu_src", 2);
      ((Intent)localObject).putExtra("arg_from_type", 8);
      ((Intent)localObject).putExtra("arg_article_info", paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
      ((Intent)localObject).putExtra("fast_biu_type", paramBoolean);
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject, 102);
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
      return;
    }
    catch (Exception paramVideoInfo)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("innerOpenReadInJoyBiuActivity error exception = ");
        ((StringBuilder)localObject).append(paramVideoInfo.getMessage());
        QLog.e("Q.pubaccount.video.feedsVideoFeedsAdapter", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void b(BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo)
  {
    if (((paramBaseItemHolder instanceof ShortVideoItemHolder)) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityVideoColumnInfo != null))
    {
      VideoFeedsHelper.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityVideoColumnInfo.a);
      paramBaseItemHolder = new VideoR5.Builder(paramVideoInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityVideoColumnInfo).j(paramVideoInfo.g).M(0).a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X800AC2C", "0X800AC2C", 0, 0, "", "", "", paramBaseItemHolder.a(), false);
    }
  }
  
  private void b(BaseVideoItemHolder paramBaseVideoItemHolder)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
    if ((localObject != null) && (((BaseVideoItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper != null))
    {
      localObject = (VideoPlayerWrapper)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
      if ((!((VideoPlayerWrapper)localObject).a()) && (!((VideoPlayerWrapper)localObject).b()) && (!((VideoPlayerWrapper)localObject).c()) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_c_of_type_Int == paramBaseVideoItemHolder.jdField_c_of_type_Int - 1) && (ReadInJoyHelper.y(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (VideoPreloadStrategyConoller.a().a((VideoPlayerWrapper)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper))) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.b(paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam);
      }
    }
  }
  
  private void b(VideoItemHolder paramVideoItemHolder, VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIADVideoFeedsGuideManager.e();
    this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoFeedsHardAdBarManager.a(false, paramVideoItemHolder);
    a(paramVideoItemHolder);
    this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoFeedsHardAdBarManager.a(paramVideoInfo, 21, Integer.valueOf(0), false);
  }
  
  private void b(VideoItemHolder paramVideoItemHolder, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.r)
    {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, 1000, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager);
      a(paramVideoInfo, 1000, ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, false, null));
      return;
    }
    d(paramVideoItemHolder, paramVideoInfo);
  }
  
  private void c(BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo)
  {
    paramVideoInfo.q ^= true;
    int i1;
    if (paramVideoInfo.q) {
      i1 = paramVideoInfo.s + 1;
    } else if (paramVideoInfo.s > 0) {
      i1 = paramVideoInfo.s - 1;
    } else {
      i1 = 0;
    }
    paramVideoInfo.s = i1;
    if ((paramBaseItemHolder instanceof VideoItemHolder))
    {
      paramBaseItemHolder = (VideoItemHolder)paramBaseItemHolder;
      paramBaseItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.f();
      ImageView localImageView = paramBaseItemHolder.jdField_m_of_type_AndroidWidgetImageView;
      if (paramVideoInfo.q) {
        paramBaseItemHolder = "click_like";
      } else {
        paramBaseItemHolder = "cancel_like";
      }
      VideoFeedsHelper.a(localImageView, paramVideoInfo, paramBaseItemHolder);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimateManager != null) && (paramVideoInfo.q)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimateManager.a((float)(DeviceInfoUtil.i() / 2L), (float)(DeviceInfoUtil.j() / 2L));
    }
    paramBaseItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendManager;
    if (paramBaseItemHolder != null) {
      paramBaseItemHolder.a(3, paramVideoInfo, 0L);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter$AdapterEventListener != null) && (!paramVideoInfo.r)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter$AdapterEventListener.a(paramVideoInfo, paramVideoInfo.q);
    }
    j(paramVideoInfo);
  }
  
  private void c(BaseVideoItemHolder paramBaseVideoItemHolder)
  {
    paramBaseVideoItemHolder = paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
    if ((paramBaseVideoItemHolder != null) && ((paramBaseVideoItemHolder.jdField_a_of_type_Boolean) || ((paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper != null) && (paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper.b() != 0))))
    {
      paramBaseVideoItemHolder.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.c(paramBaseVideoItemHolder);
    }
  }
  
  private void c(VideoItemHolder paramVideoItemHolder, VideoInfo paramVideoInfo)
  {
    VideoFeedsHelper.a(paramVideoItemHolder.jdField_m_of_type_AndroidViewViewGroup, paramVideoInfo, "click_comment");
    JSONObject localJSONObject = new JSONObject();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager.e();
    for (;;)
    {
      try
      {
        if (paramVideoInfo.w == null) {
          break label209;
        }
        paramVideoItemHolder = paramVideoInfo.w;
        localJSONObject.put("video_report_info", paramVideoItemHolder);
        int i1 = 0;
        localJSONObject.put("video_type", 0);
        if (this.m) {
          i1 = 1;
        }
        localJSONObject.put("interact_button_style", i1);
      }
      catch (JSONException paramVideoItemHolder)
      {
        paramVideoItemHolder.printStackTrace();
      }
      if (jdField_d_of_type_Boolean)
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80092A1", "0X80092A1", 0, 0, "", "", "", VideoReporter.a("", "", paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, localJSONObject), false);
        return;
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008E54", "0X8008E54", 0, 0, "", "", "", VideoReporter.a("", "", paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, localJSONObject), false);
      return;
      label209:
      paramVideoItemHolder = "";
    }
  }
  
  private void d(VideoItemHolder paramVideoItemHolder, VideoInfo paramVideoInfo)
  {
    VideoFeedsHelper.a(paramVideoItemHolder.p, paramVideoInfo, "click_write_comment");
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager.g();
    String str1;
    if (jdField_d_of_type_Boolean) {
      str1 = "0X800948A";
    } else {
      str1 = "0X8009485";
    }
    if (paramVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null) {
      paramVideoItemHolder = paramVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
    } else {
      paramVideoItemHolder = null;
    }
    Object localObject = new VideoR5.Builder(null, paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g);
    long l2 = -1L;
    if (paramVideoItemHolder != null) {
      l1 = paramVideoItemHolder.a(paramVideoItemHolder.h());
    } else {
      l1 = -1L;
    }
    localObject = ((VideoR5.Builder)localObject).d(l1);
    if (paramVideoItemHolder != null) {
      l1 = paramVideoItemHolder.a();
    } else {
      l1 = -1L;
    }
    localObject = ((VideoR5.Builder)localObject).a(l1);
    long l1 = l2;
    if (paramVideoItemHolder != null) {
      l1 = paramVideoItemHolder.b();
    }
    localObject = ((VideoR5.Builder)localObject).c(l1).a(409409).a(paramVideoInfo.w).u(this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("VIDEO_FROM_TYPE", -1)).a().a();
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    String str2 = paramVideoInfo.j;
    if (!TextUtils.isEmpty(paramVideoInfo.g)) {
      paramVideoItemHolder = paramVideoInfo.g;
    } else {
      paramVideoItemHolder = "0";
    }
    localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str2, str1, str1, 0, 0, "", "", paramVideoItemHolder, (String)localObject, false);
    if (ReadInJoyHelper.l(RIJQQAppInterfaceUtil.a())) {
      return;
    }
    paramVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendManager;
    if (paramVideoItemHolder != null) {
      paramVideoItemHolder.a(4, paramVideoInfo, 0L);
    }
  }
  
  private void f(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.n) {
      RIJVideoRewardCoinManager.a.a();
    } else {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager.a(new RIJVideoRewardCoinManager.RIJRewardInfo(paramVideoInfo.g, paramVideoInfo.j, paramVideoInfo), 1);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsReporter.a(paramVideoInfo, "0X800B2EB");
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2, null);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.a(false, null);
  }
  
  private void g(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LocationInfo != null)
    {
      String str1 = paramVideoInfo.j;
      String str3 = paramVideoInfo.jdField_a_of_type_JavaLangString;
      Object localObject = paramVideoInfo.g;
      String str2 = "";
      str3 = new VideoR5.Builder("", str1, str3, (String)localObject).j(paramVideoInfo.g).a().a();
      localObject = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      if (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LocationInfo.jdField_a_of_type_Boolean) {
        str1 = "1";
      } else {
        str1 = "2";
      }
      if (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LocationInfo.jdField_a_of_type_Boolean) {
        paramVideoInfo = str2;
      } else {
        paramVideoInfo = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LocationInfo.jdField_a_of_type_JavaLangString;
      }
      ((IPublicAccountReportUtils)localObject).publicAccountReportClickEvent(null, "", "0X800B4D0", "0X800B4D0", 0, 0, str1, paramVideoInfo, "", str3, false);
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(8);
    BaseVideoItemHolder localBaseVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
    if ((localBaseVideoItemHolder != null) && ((localBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate instanceof ShortVideoItemDelegate))) {
      ((ShortVideoItemDelegate)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate).b();
    }
  }
  
  private void h(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.jdField_p_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("followPubAccount onClick() puin=");
      ((StringBuilder)localObject).append(paramVideoInfo.j);
      ((StringBuilder)localObject).append(", isFollowed=");
      ((StringBuilder)localObject).append(paramVideoInfo.jdField_p_of_type_Boolean);
      ((StringBuilder)localObject).append(", pname=");
      ((StringBuilder)localObject).append(paramVideoInfo.k);
      QLog.d("Q.pubaccount.video.feedsVideoFeedsAdapter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
    if ((localObject instanceof VideoItemHolder)) {
      VideoFeedsHelper.a(((VideoItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsFollowButton, paramVideoInfo, "click_follow");
    }
    String str1 = new VideoR5.Builder(null, paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.a(), 1000L * paramVideoInfo.c()).a(paramVideoInfo.w).M(0).a().a();
    boolean bool = jdField_d_of_type_Boolean;
    localObject = "0";
    IPublicAccountReportUtils localIPublicAccountReportUtils;
    String str2;
    if (bool)
    {
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      str2 = paramVideoInfo.j;
      if (!TextUtils.isEmpty(paramVideoInfo.g)) {
        localObject = paramVideoInfo.g;
      }
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str2, "0X800929B", "0X800929B", 0, 0, "", "", (String)localObject, str1, false);
    }
    else
    {
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      str2 = paramVideoInfo.j;
      if (!TextUtils.isEmpty(paramVideoInfo.g)) {
        localObject = paramVideoInfo.g;
      }
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str2, "0X80078FD", "0X80078FD", 0, 0, "", "", (String)localObject, str1, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsReporter.a(paramVideoInfo, "0X800B1A7", true, true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsReporter.a(paramVideoInfo, "0X800B1A6", false, true);
    b(paramVideoInfo);
  }
  
  private void h(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feedsVideoFeedsAdapter", 2, "handleConnetNetWorkChange");
    }
    VideoFeedsPlayManager localVideoFeedsPlayManager = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager;
    if (localVideoFeedsPlayManager != null)
    {
      if (!this.jdField_e_of_type_Boolean) {
        return;
      }
      localVideoFeedsPlayManager.e(paramBoolean);
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsAdapter.13(this, paramBoolean));
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 3000L);
    BaseVideoItemHolder localBaseVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
    if (localBaseVideoItemHolder == null) {
      return;
    }
    if (localBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsVideoUIDelegate.a()) {
      l1 = System.currentTimeMillis();
    } else {
      l1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsVideoUIDelegate.a();
    }
    long l1 = Math.max(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.a(), l1);
    l1 = 3000L - (System.currentTimeMillis() - l1);
    if (l1 > 0L)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, l1);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager != null)
    {
      localBaseVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
      if ((localBaseVideoItemHolder != null) && (localBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate != null))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.d())
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.j(false);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.e();
      }
    }
  }
  
  private void i(VideoInfo paramVideoInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null)
    {
      if (paramVideoInfo == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.a(false);
      if (!TextUtils.isEmpty(paramVideoInfo.g))
      {
        PlayFeedbackHelper.a(this.jdField_a_of_type_AndroidAppActivity, FeedsChannelDataHelper.a(paramVideoInfo), this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper, 2, 0);
        PlayFeedbackHelper.a(paramVideoInfo.g, 2, 0);
      }
    }
  }
  
  private void j()
  {
    if (this.j)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 50L);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.a();
  }
  
  private void j(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("channel_id", 409409);
      boolean bool = paramVideoInfo.q;
      i2 = 1;
      if (!bool) {
        break label317;
      }
      i1 = 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i2;
        Object localObject;
        String str2;
        String str3;
        IPublicAccountReportUtils localIPublicAccountReportUtils;
        String str4;
        continue;
        int i1 = 1;
        continue;
        String str1 = "";
        continue;
        i1 = 0;
        continue;
        i1 = 0;
      }
    }
    localJSONObject.put("type", i1);
    localObject = paramVideoInfo.w;
    str2 = "";
    if (localObject != null)
    {
      localObject = paramVideoInfo.w;
      localJSONObject.put("video_report_info", localObject);
      if (paramVideoInfo.q)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimateManager == null) {
          break label330;
        }
        i1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimateManager.a();
        localJSONObject.put("style", i1);
      }
      localJSONObject.put("algorithm_id", paramVideoInfo.f);
      localObject = str2;
      if (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LikeActionDownloadBar != null) {
        localObject = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LikeActionDownloadBar.jdField_c_of_type_JavaLangString;
      }
      localJSONObject.put("common_data", localObject);
      localJSONObject.put("video_type", 0);
      if (!this.m) {
        break label335;
      }
      i1 = i2;
      localJSONObject.put("interact_button_style", i1);
      if (jdField_d_of_type_Boolean) {
        localObject = "0X800929C";
      } else {
        localObject = "0X80091A9";
      }
      str3 = paramVideoInfo.d();
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      str4 = paramVideoInfo.j;
      if (!TextUtils.isEmpty(paramVideoInfo.g)) {
        str2 = paramVideoInfo.g;
      } else {
        str2 = "0";
      }
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str4, (String)localObject, (String)localObject, 0, 0, "0", "0", str2, VideoReporter.a(str3, paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, localJSONObject), false);
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.b();
  }
  
  private void l()
  {
    BaseVideoItemHolder localBaseVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
    if ((localBaseVideoItemHolder instanceof VideoItemHolder)) {
      VideoFeedsHelper.a(((VideoItemHolder)localBaseVideoItemHolder).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsFollowButton.a(), 8, 600);
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr = new VideoPreDownloadMgr(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr.a = new VideoPreloadReportData(VideoPreloadReportData.jdField_c_of_type_Int, VideoPreloadReportData.g);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr.a(new VideoFeedsAdapter.11(this));
  }
  
  private void n()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleNotNetWorkChange mIsActivityOnResume = ");
      ((StringBuilder)localObject).append(this.jdField_e_of_type_Boolean);
      QLog.d("Q.pubaccount.video.feedsVideoFeedsAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if (!this.jdField_e_of_type_Boolean) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager;
    if (localObject != null) {
      ((VideoFeedsPlayManager)localObject).e(false);
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  @Nullable
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  @NotNull
  public ColorDrawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  }
  
  @NotNull
  public Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public Drawable a(int paramInt)
  {
    Bitmap localBitmap;
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt)))
    {
      localBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), paramInt);
      if (localBitmap == null) {
        return this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(paramInt);
      }
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localBitmap);
    }
    else
    {
      localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    }
    return new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap);
  }
  
  @Nullable
  public IVideoFeedsPlayManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager;
  }
  
  public VideoInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    VideoInfo localVideoInfo;
    do
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (VideoInfo)localIterator.next();
          if (paramString.equals(((VideoInfo)localObject).g)) {
            return localObject;
          }
        } while (((VideoInfo)localObject).jdField_c_of_type_JavaUtilArrayList == null);
        localObject = ((VideoInfo)localObject).jdField_c_of_type_JavaUtilArrayList.iterator();
      }
      localVideoInfo = (VideoInfo)((Iterator)localObject).next();
    } while (!paramString.equals(localVideoInfo.g));
    return localVideoInfo;
    return null;
  }
  
  @Nullable
  public VideoFeedsRecyclerView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView;
  }
  
  public BaseItemHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    localObject1 = LayoutInflater.from(paramViewGroup.getContext());
    localObject4 = null;
    switch (paramInt)
    {
    case 3: 
    default: 
      paramViewGroup = null;
      localObject1 = paramViewGroup;
      localObject3 = localObject4;
      break;
    case 8: 
      localObject1 = VideoFeedsResourceLoader.a(2131560357, true, new ViewGroup.LayoutParams(-1, -1));
      paramViewGroup = (ShortVideoItemHolder)((View)localObject1).getTag();
      localObject2 = paramViewGroup;
      if (paramViewGroup == null) {
        localObject2 = new TiktokVideoItemHolder((View)localObject1);
      }
      localObject5 = new TiktokVideoItemDelegate((TiktokVideoItemHolder)localObject2, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter, this);
      try
      {
        paramInt = LiuHaiUtils.b(this.jdField_a_of_type_AndroidAppActivity);
        localObject3 = localObject4;
        paramViewGroup = (ViewGroup)localObject5;
        localObject1 = localObject2;
        if (LiuHaiUtils.b())
        {
          localObject3 = localObject4;
          paramViewGroup = (ViewGroup)localObject5;
          localObject1 = localObject2;
          if (paramInt > 0)
          {
            localObject3 = localObject4;
            paramViewGroup = (ViewGroup)localObject5;
            localObject1 = localObject2;
            if (((ShortVideoItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsAbsVideoFeedsUGView != null)
            {
              paramViewGroup = (View)((ShortVideoItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsAbsVideoFeedsUGView.getParent();
              paramViewGroup.setPadding(paramViewGroup.getPaddingLeft(), paramViewGroup.getPaddingTop() + paramInt, paramViewGroup.getPaddingRight(), paramViewGroup.getPaddingBottom());
              localObject3 = localObject4;
              paramViewGroup = (ViewGroup)localObject5;
              localObject1 = localObject2;
            }
          }
        }
      }
      catch (Exception paramViewGroup)
      {
        paramViewGroup.printStackTrace();
        localObject3 = localObject4;
        paramViewGroup = (ViewGroup)localObject5;
        localObject1 = localObject2;
      }
    case 6: 
      localObject2 = VideoFeedsResourceLoader.a(2131560337, true, new ViewGroup.LayoutParams(-1, -1));
      localObject1 = (FooterItemHolder)((View)localObject2).getTag();
      paramViewGroup = (ViewGroup)localObject1;
      if (localObject1 == null) {
        paramViewGroup = new FooterItemHolder((View)localObject2, paramInt);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsFooterItemHolder = paramViewGroup;
      localObject2 = null;
      localObject1 = localObject2;
      localObject3 = paramViewGroup;
      paramViewGroup = (ViewGroup)localObject2;
      break;
    case 4: 
    case 5: 
    case 7: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560325, paramViewGroup, false);
      if (!this.m) {
        ((LayoutInflater)localObject1).inflate(2131560368, (ViewGroup)paramViewGroup.findViewById(2131365007), true);
      }
      ((LayoutInflater)localObject1).inflate(2131560363, (ViewGroup)paramViewGroup.findViewById(2131365005), true);
      ((LayoutInflater)localObject1).inflate(2131560365, (ViewGroup)paramViewGroup.findViewById(2131365003), true);
      localObject1 = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createADVideoItemHolder(paramViewGroup, paramInt);
      paramViewGroup = (BaseVideoItemDelegate)((IRIJAdService)QRoute.api(IRIJAdService.class)).createADVideoItemDelegate(localObject1, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter, this);
      localObject3 = localObject4;
      break;
    case 2: 
      localObject1 = VideoFeedsResourceLoader.a(2131560341, true, new ViewGroup.LayoutParams(-1, -1));
      paramViewGroup = (ShortVideoItemHolder)((View)localObject1).getTag();
      localObject2 = paramViewGroup;
      if (paramViewGroup == null) {
        localObject2 = new ShortVideoItemHolder((View)localObject1);
      }
      localObject5 = new ShortVideoItemDelegate((ShortVideoItemHolder)localObject2, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter, this);
    }
    try
    {
      paramInt = LiuHaiUtils.b(this.jdField_a_of_type_AndroidAppActivity);
      localObject3 = localObject4;
      paramViewGroup = (ViewGroup)localObject5;
      localObject1 = localObject2;
      if (LiuHaiUtils.b())
      {
        localObject3 = localObject4;
        paramViewGroup = (ViewGroup)localObject5;
        localObject1 = localObject2;
        if (paramInt > 0)
        {
          localObject3 = localObject4;
          paramViewGroup = (ViewGroup)localObject5;
          localObject1 = localObject2;
          if (((ShortVideoItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsAbsVideoFeedsUGView != null)
          {
            paramViewGroup = (View)((ShortVideoItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsAbsVideoFeedsUGView.getParent();
            paramViewGroup.setPadding(paramViewGroup.getPaddingLeft(), paramViewGroup.getPaddingTop() + paramInt, paramViewGroup.getPaddingRight(), paramViewGroup.getPaddingBottom());
            localObject3 = localObject4;
            paramViewGroup = (ViewGroup)localObject5;
            localObject1 = localObject2;
          }
        }
      }
    }
    catch (Exception paramViewGroup)
    {
      for (;;)
      {
        localObject3 = localObject4;
        paramViewGroup = (ViewGroup)localObject5;
        localObject1 = localObject2;
      }
    }
    if (localObject1 != null)
    {
      ((BaseVideoItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate = paramViewGroup;
      ((BaseVideoItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsVideoUIDelegate = new VideoFeedsVideoUIDelegate((BaseVideoItemHolder)localObject1, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager, this.h);
      ((BaseVideoItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsVideoUIDelegate.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter);
      return localObject1;
    }
    return localObject3;
  }
  
  @Nullable
  public BaseVideoItemHolder a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
  }
  
  @Nullable
  public Object a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoBrightnessController;
  }
  
  public void a()
  {
    int i1 = this.jdField_a_of_type_JavaUtilList.size();
    int i2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.getHeaderViewsCount();
    RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.findViewHolderForLayoutPosition(i1 + i2 - 1);
    if ((localViewHolder instanceof FooterItemHolder)) {
      a((FooterItemHolder)localViewHolder);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    VideoFeedsLikeAnimateManager localVideoFeedsLikeAnimateManager = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimateManager;
    if (localVideoFeedsLikeAnimateManager != null) {
      localVideoFeedsLikeAnimateManager.a(paramFloat1, paramFloat2);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      if (paramBoolean) {
        localHandler.removeMessages(paramInt);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(paramInt, paramLong);
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
  }
  
  public void a(View paramView)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager;
    if ((localObject != null) && (((VideoFeedsCommentManager)localObject).b()) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager.c()))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager.h();
      return;
    }
    if (!this.o) {
      return;
    }
    paramView = (BaseVideoItemHolder)paramView.getTag();
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
    if (paramView != localObject)
    {
      if (localObject != null)
      {
        if ((paramView != null) && (paramView.jdField_c_of_type_Int == this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_c_of_type_Int + 1) && (paramView.jdField_c_of_type_Int != getItemCount()))
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.a();
          return;
        }
        if ((paramView != null) && (paramView.jdField_c_of_type_Int == this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_c_of_type_Int - 1)) {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.b();
        }
      }
      return;
    }
    paramView.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.a();
    VideoFeedsHelper.a(paramView.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityAbsVideoFeedsGestureLayout, paramView.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo, "click_contentid");
    VideoReport.reportEvent("clck", paramView.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityAbsVideoFeedsGestureLayout, null);
    int i1 = paramView.jdField_a_of_type_Int;
    if (i1 != 2)
    {
      if ((i1 != 5) && (i1 != 7)) {
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager;
      if ((localObject == null) || (!((VideoFeedsPlayManager)localObject).d())) {
        break label383;
      }
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("channel_id", 409409);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X80091AB", "0X80091AB", 0, 0, "", "", "", VideoReporter.a(null, null, paramView.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.g, (JSONObject)localObject), false);
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager;
      if ((localObject != null) && (((VideoFeedsPlayManager)localObject).d())) {
        localObject = new JSONObject();
      }
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        ((JSONObject)localObject).put("channel_id", 409409);
        label323:
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X80091AB", "0X80091AB", 0, 0, "", "", "", VideoReporter.a(null, null, paramView.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.g, (JSONObject)localObject), false);
        label383:
        return;
        localJSONException1 = localJSONException1;
      }
      catch (JSONException localJSONException2)
      {
        break label323;
      }
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView = (VideoItemHolder)paramView.getTag();
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      if (paramView.d.getVisibility() == 0)
      {
        paramView.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.a(2);
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.b()) {
          this.n = true;
        }
      }
    }
    else if (this.n)
    {
      paramView.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.a(1);
      this.n = false;
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    RIJUserLevelModule.getInstance().doActionsByUserLevel(this.jdField_a_of_type_AndroidAppActivity, 3, new VideoFeedsAdapter.7(this, paramView, paramInt1, paramInt2));
  }
  
  public void a(@Nullable View paramView, int paramInt, @Nullable Object paramObject)
  {
    INegativeHelper localINegativeHelper = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityINegativeHelper;
    if (localINegativeHelper != null) {
      localINegativeHelper.a(paramView, paramInt, paramObject);
    }
  }
  
  public void a(IADVideoAppDownloadManager paramIADVideoAppDownloadManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoFeedsHardAdBarManager.a(paramIADVideoAppDownloadManager);
  }
  
  public void a(IADVideoFeedsGuideManager paramIADVideoFeedsGuideManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIADVideoFeedsGuideManager = paramIADVideoFeedsGuideManager;
  }
  
  public void a(IVideoAdExposureManager paramIVideoAdExposureManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdExposureManager = paramIVideoAdExposureManager;
  }
  
  public void a(VideoFeedsAdapter.AdapterEventListener paramAdapterEventListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter$AdapterEventListener = paramAdapterEventListener;
  }
  
  public void a(VideoFeedsCommentManager paramVideoFeedsCommentManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager = paramVideoFeedsCommentManager;
  }
  
  public void a(VideoFeedsLikeAnimateManager paramVideoFeedsLikeAnimateManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimateManager = paramVideoFeedsLikeAnimateManager;
  }
  
  public void a(VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    m();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.a(new VideoFeedsAdapter.9(this));
  }
  
  public void a(VideoFeedsRecommendManager paramVideoFeedsRecommendManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendManager = paramVideoFeedsRecommendManager;
  }
  
  public void a(TiktokVideoItemHolder paramTiktokVideoItemHolder)
  {
    Object localObject = paramTiktokVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
    VideoPlayerWrapper localVideoPlayerWrapper = null;
    if (localObject != null) {
      localObject = paramTiktokVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
    } else {
      localObject = null;
    }
    if (paramTiktokVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null) {
      localVideoPlayerWrapper = (VideoPlayerWrapper)paramTiktokVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
    }
    paramTiktokVideoItemHolder = new VideoR5.Builder((VideoInfo)localObject);
    long l2 = -1L;
    if (localVideoPlayerWrapper != null) {
      l1 = localVideoPlayerWrapper.a();
    } else {
      l1 = -1L;
    }
    paramTiktokVideoItemHolder = paramTiktokVideoItemHolder.a(l1);
    long l1 = l2;
    if (localVideoPlayerWrapper != null) {
      l1 = localVideoPlayerWrapper.b();
    }
    paramTiktokVideoItemHolder = paramTiktokVideoItemHolder.c(l1).a();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B28A", "0X800B28A", 0, 0, "3", "", "", paramTiktokVideoItemHolder.a(), false);
  }
  
  public void a(RIJVideoRewardCoinManager paramRIJVideoRewardCoinManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager = paramRIJVideoRewardCoinManager;
  }
  
  public void a(VideoColumnBannerManager paramVideoColumnBannerManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoColumnBannerManager = paramVideoColumnBannerManager;
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo instanceof VideoInfo)) {
      a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView, this.jdField_a_of_type_JavaUtilList, paramVideoInfo);
    }
  }
  
  public void a(@Nullable VideoInfo paramVideoInfo, @Nullable VideoItemHolder paramVideoItemHolder)
  {
    if ((paramVideoItemHolder instanceof ShortVideoItemHolder)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoColumnBannerManager.b(paramVideoInfo, (ShortVideoItemHolder)paramVideoItemHolder);
    }
  }
  
  public void a(@Nullable VideoInfo paramVideoInfo, @Nullable Object paramObject)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
    if ((localObject instanceof VideoItemHolder)) {
      VideoFeedsHelper.a(((VideoItemHolder)localObject).j, paramVideoInfo, "click_puin");
    }
    localObject = paramVideoInfo.d();
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager != null) && (paramVideoInfo.b(this.jdField_a_of_type_AndroidAppActivity))) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager.h();
    }
    if (paramVideoInfo.r)
    {
      if ((paramObject instanceof AdvertisementInfo))
      {
        paramObject = ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)paramObject, null, 3, true, null);
        this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoFeedsHardAdBarManager.a(paramVideoInfo, 0, paramObject, false);
      }
    }
    else
    {
      if ((paramVideoInfo.x != null) && (!paramVideoInfo.x.equals("")))
      {
        ReadInJoyUtils.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo.x);
        return;
      }
      paramObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
      if (((paramObject instanceof ShortVideoItemHolder)) && (((ShortVideoItemHolder)paramObject).jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityLiveStatus != null) && (!TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityLiveStatus.d)))
      {
        ReadInJoyUtils.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityLiveStatus.d);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsReporter.b(paramVideoInfo, "0X800B17E");
      }
      else if (paramVideoInfo.l)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feedsVideoFeedsAdapter", 2, "onClick: video unowned");
        }
      }
      else if (paramVideoInfo.jdField_a_of_type_Int == 6)
      {
        if (!TextUtils.isEmpty(paramVideoInfo.j)) {
          a(paramVideoInfo, true);
        }
      }
      else if ((!TextUtils.isEmpty(paramVideoInfo.j)) && (!paramVideoInfo.j.equals("16888")))
      {
        a(paramVideoInfo, false);
      }
      paramObject = new VideoR5.Builder((String)localObject, paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.a(), paramVideoInfo.c() * 1000L).a(-1).M(0).a().a();
      localObject = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      String str = paramVideoInfo.j;
      if (!TextUtils.isEmpty(paramVideoInfo.g)) {
        paramVideoInfo = paramVideoInfo.g;
      } else {
        paramVideoInfo = "0";
      }
      ((IPublicAccountReportUtils)localObject).publicAccountReportClickEvent(null, str, "0X8007410", "0X8007410", 0, 0, "0", "", paramVideoInfo, paramObject, false);
    }
  }
  
  public void a(VideoInfo paramVideoInfo, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsReporter.a(paramVideoInfo, paramString);
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramVideoInfo.j))
    {
      if (this.jdField_a_of_type_AndroidAppActivity == null) {
        return;
      }
      paramVideoInfo = VideoFeedsHelper.a(paramVideoInfo, paramBoolean, false);
      ReadInJoyUtils.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo);
    }
  }
  
  public void a(VideoFeedsRecyclerView paramVideoFeedsRecyclerView, List<VideoInfo> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((VideoInfo)paramList.next()).a();
      }
    }
    int i2 = paramVideoFeedsRecyclerView.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      paramList = paramVideoFeedsRecyclerView.getChildViewHolder(paramVideoFeedsRecyclerView.getChildAt(i1));
      if ((paramList instanceof VideoItemHolder)) {
        ((VideoItemHolder)paramList).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.d();
      }
      i1 += 1;
    }
  }
  
  public void a(BaseItemHolder paramBaseItemHolder, int paramInt)
  {
    paramBaseItemHolder.jdField_b_of_type_Int = paramInt;
    paramBaseItemHolder.jdField_c_of_type_Int = paramInt;
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdExposureManager;
      if (localObject != null)
      {
        localObject = ((IVideoAdExposureManager)localObject).b(paramInt);
        if (localObject != null) {
          this.jdField_a_of_type_JavaUtilList.set(paramInt, localObject);
        }
      }
      a(paramBaseItemHolder, (VideoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      return;
    }
    a(paramBaseItemHolder, null);
  }
  
  public void a(BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo)
  {
    int i1 = paramBaseItemHolder.jdField_a_of_type_Int;
    if ((i1 != 3) && (i1 != 6))
    {
      paramBaseItemHolder = (BaseVideoItemHolder)paramBaseItemHolder;
      c(paramBaseItemHolder);
      a(paramBaseItemHolder, paramVideoInfo);
      VideoFeedsDiversionHandler.a.a(paramBaseItemHolder);
      TraceCompat.beginSection("refreshMenuUI");
      paramBaseItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.b(paramVideoInfo);
      TraceCompat.endSection();
      TraceCompat.beginSection("refreshContentUI");
      paramBaseItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.a(paramVideoInfo, this.f);
      if (!TextUtils.isEmpty(paramVideoInfo.j)) {
        try
        {
          long l1 = Long.parseLong(paramVideoInfo.j);
          ReadInJoyUserInfo localReadInJoyUserInfo = ReadInJoyUserInfoModule.a(l1, null);
          if ((localReadInJoyUserInfo != null) && (localReadInJoyUserInfo.isReadlTimeRead())) {
            ReadInJoyUserInfoModule.a(l1, this, true);
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.pubaccount.video.feedsVideoFeedsAdapter", 2, "onBindViewHolder: ", localException);
          }
        }
      }
      TraceCompat.endSection();
      if ((this.j) && (paramBaseItemHolder == this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder)) {
        paramBaseItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.c(this.j);
      }
      b(paramBaseItemHolder);
      VideoReport.setElementExposePolicy(paramBaseItemHolder.itemView, ExposurePolicy.REPORT_FIRST);
      VideoReport.setElementEndExposePolicy(paramBaseItemHolder.itemView, EndExposurePolicy.REPORT_ALL);
      VideoReport.setElementId(paramBaseItemHolder.itemView, "card");
      VideoReport.setElementReuseIdentifier(paramBaseItemHolder.itemView, paramVideoInfo.g);
      VideoReport.setElementExposureMinRate(paramBaseItemHolder.itemView, 0.1D);
      return;
    }
    paramBaseItemHolder = (FooterItemHolder)paramBaseItemHolder;
    a(paramBaseItemHolder);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsFooterItemHolder = paramBaseItemHolder;
  }
  
  public void a(BaseVideoItemHolder paramBaseVideoItemHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "adapter playVideo (VideoItemHolder holder) ");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2, null);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.a(ReportConstants.VideoEndType.SLIDE_LEAVE);
    BaseVideoItemHolder localBaseVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
    int i1;
    if (localBaseVideoItemHolder != null) {
      i1 = localBaseVideoItemHolder.jdField_c_of_type_Int;
    } else {
      i1 = -1;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder = paramBaseVideoItemHolder;
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_c_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_Long == 0L))
    {
      paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
      this.jdField_c_of_type_Long = 0L;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangString = null;
    }
    else
    {
      paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_JavaLangString = null;
      paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_c_of_type_Boolean = false;
    }
    boolean bool;
    if ((this.i) && (!a(paramBaseVideoItemHolder))) {
      bool = false;
    } else {
      bool = true;
    }
    this.i = false;
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_b_of_type_Long;
    paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_AndroidOsBundle.putBoolean("is_auto_play", bool);
    if (bool)
    {
      if ((ReadInJoyHelper.d(this.jdField_c_of_type_Int)) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_c_of_type_Boolean) && (Build.VERSION.SDK_INT >= 16)) {
        a(paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.a(paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam, false);
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.a(paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam);
    }
    a(paramBaseVideoItemHolder, bool, l1 - l2, i1);
    if (paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null) {
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).videoPlayRealtimeReport(paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.g, paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString, 0, 0);
    }
  }
  
  public void a(VideoItemHolder paramVideoItemHolder, VideoInfo paramVideoInfo)
  {
    if (StudyModeManager.a()) {
      return;
    }
    if (paramVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsAbsVideoFeedsUGView != null) {
      paramVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsAbsVideoFeedsUGView.a();
    }
    if (paramVideoItemHolder.jdField_b_of_type_ComTencentMobileqqKandianBizPlayfeedsAbsVideoFeedsUGView != null) {
      paramVideoItemHolder.jdField_b_of_type_ComTencentMobileqqKandianBizPlayfeedsAbsVideoFeedsUGView.a();
    }
    if ((paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo != null) || (paramVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo != null))
    {
      if ((paramVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsAbsVideoFeedsUGView != null) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo != null) && ((paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_c_of_type_Int == 1) || (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_c_of_type_Int == 2))) {
        paramVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsAbsVideoFeedsUGView.setInfo(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo, paramVideoInfo.jdField_c_of_type_JavaLangString, "VideoPlay_ContentMix");
      }
      if ((paramVideoItemHolder.jdField_b_of_type_ComTencentMobileqqKandianBizPlayfeedsAbsVideoFeedsUGView != null) && (paramVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo != null) && ((paramVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_c_of_type_Int == 1) || (paramVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo.jdField_c_of_type_Int == 2))) {
        paramVideoItemHolder.jdField_b_of_type_ComTencentMobileqqKandianBizPlayfeedsAbsVideoFeedsUGView.setInfo(paramVideoInfo.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityUGDownloadInfo, paramVideoInfo.jdField_c_of_type_JavaLangString, "VideoPlay_Shooting");
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(List<VideoInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(BaseVideoItemHolder paramBaseVideoItemHolder)
  {
    Object localObject = paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsVideoUIDelegate;
    int i2 = 0;
    ((IVideoFeedsVideoUIDelegate)localObject).b(false);
    if ((paramBaseVideoItemHolder.jdField_c_of_type_Int == this.jdField_e_of_type_Int) && (this.jdField_a_of_type_AndroidContentContext != null) && (paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null) && (paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null))
    {
      localObject = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
      int i3 = ((Bundle)localObject).getInt("VIDEO_FROM_TYPE", 0);
      if ((!(NetworkUtil.isMobileNetWork(this.jdField_a_of_type_AndroidContentContext) ^ true)) && (!this.h)) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if ((localQQAppInterface != null) && (localQQAppInterface.isVideoChatting())) {
        return false;
      }
      if (i3 == 27)
      {
        if (Aladdin.getConfig(271).getIntegerFromString("auto_play", 1) == 1)
        {
          paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsVideoUIDelegate.b(i1 ^ 0x1);
          return true;
        }
        paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsVideoUIDelegate.b(i1 ^ 0x1);
        return false;
      }
      if (i1 != 0)
      {
        paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsVideoUIDelegate.b(false);
        return true;
      }
      int i1 = ((Bundle)localObject).getInt("VIDEO_PLAY_STATUS", 0);
      boolean bool;
      if (((2 != i3) && (6 != i3) && (5 != i3)) || (3 != i1)) {
        bool = true;
      } else {
        bool = false;
      }
      paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsVideoUIDelegate.b(bool);
      if ((33 != i3) && (1 != i3) && (12 != i3))
      {
        i1 = i2;
        if (11 != i3) {}
      }
      else
      {
        i1 = 1;
      }
      return i1 ^ 0x1;
    }
    return true;
  }
  
  public boolean a(@Nullable String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoFeedsHardAdBarManager.a(paramString);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public Drawable b()
  {
    return this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public VideoInfo b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    VideoInfo localVideoInfo;
    do
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (VideoInfo)localIterator.next();
          if (paramString.equals(((VideoInfo)localObject).jdField_a_of_type_JavaLangString)) {
            return localObject;
          }
        } while (((VideoInfo)localObject).jdField_c_of_type_JavaUtilArrayList == null);
        localObject = ((VideoInfo)localObject).jdField_c_of_type_JavaUtilArrayList.iterator();
      }
      localVideoInfo = (VideoInfo)((Iterator)localObject).next();
    } while (!paramString.equals(localVideoInfo.jdField_a_of_type_JavaLangString));
    return localVideoInfo;
    return null;
  }
  
  @Nullable
  public Object b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoFeedsHardAdBarManager;
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    this.jdField_e_of_type_Boolean = false;
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeMessages(2, null);
    }
    ApngImage.pauseByTag(28);
    ApngImage.pauseByTag(29);
    ApngImage.pauseByTag(30);
    if (paramInt == 1) {
      ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).doOnVideoPause(this.jdField_a_of_type_AndroidAppActivity);
    }
  }
  
  public void b(View paramView) {}
  
  public void b(VideoInfo paramVideoInfo)
  {
    Object localObject1 = paramVideoInfo.j;
    boolean bool1 = paramVideoInfo.jdField_b_of_type_Boolean;
    Object localObject2 = paramVideoInfo.jdField_p_of_type_JavaLangString;
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("followPubAccount() uin=");
      ((StringBuilder)localObject3).append((String)localObject1);
      QLog.d("Q.pubaccount.video.feedsVideoFeedsAdapter", 2, ((StringBuilder)localObject3).toString());
    }
    if (localObject1 != null)
    {
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (localObject3 == null) {
        return;
      }
      VideoFeedsHelper.a((QQAppInterface)localObject3, (String)localObject1, bool1, (String)localObject2, false);
      localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
      bool1 = false;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (VideoInfo)((Iterator)localObject2).next();
        boolean bool2 = bool1 | a((VideoInfo)localObject3, (String)localObject1);
        bool1 = bool2;
        if (((VideoInfo)localObject3).jdField_c_of_type_JavaUtilArrayList != null)
        {
          localObject3 = ((VideoInfo)localObject3).jdField_c_of_type_JavaUtilArrayList.iterator();
          for (;;)
          {
            bool1 = bool2;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            bool2 |= a((VideoInfo)((Iterator)localObject3).next(), (String)localObject1);
          }
        }
      }
      if (bool1) {
        b((String)localObject1);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("followPubAccount() isDataChanged=");
        ((StringBuilder)localObject1).append(bool1);
        QLog.d("Q.pubaccount.video.feedsVideoFeedsAdapter", 2, ((StringBuilder)localObject1).toString());
      }
      ReadInJoyLogicEngine.a().a().a(409409L, paramVideoInfo.g, paramVideoInfo.j, 2);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter.a(new RIJFeedsInsertAction(ActionType.ACTION_FOLLOW, 0, 0, 0));
    }
  }
  
  public void b(@Nullable VideoInfo paramVideoInfo, @Nullable VideoItemHolder paramVideoItemHolder)
  {
    if ((paramVideoItemHolder instanceof ShortVideoItemHolder)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoColumnBannerManager.a(paramVideoInfo, (ShortVideoItemHolder)paramVideoItemHolder);
    }
  }
  
  public void b(String paramString)
  {
    a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView, this.jdField_a_of_type_JavaUtilList, paramString);
  }
  
  void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void c()
  {
    int i2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView;
      localObject = ((VideoFeedsRecyclerView)localObject).getChildViewHolder(((VideoFeedsRecyclerView)localObject).getChildAt(i1));
      if ((localObject instanceof VideoItemHolder))
      {
        localObject = (VideoItemHolder)localObject;
        if (((VideoItemHolder)localObject).jdField_c_of_type_Int == this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_c_of_type_Int + 1)
        {
          localObject = ((VideoItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
          if ((localObject != null) && ((((VideoPlayParam)localObject).jdField_a_of_type_Boolean) || ((((VideoPlayParam)localObject).jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper != null) && (!((VideoPlayParam)localObject).jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper.a()))))
          {
            ((VideoPlayParam)localObject).jdField_a_of_type_Boolean = false;
            this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.c((VideoPlayParam)localObject);
          }
        }
      }
      i1 += 1;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr;
    if (localObject != null) {
      ((VideoPreDownloadMgr)localObject).d();
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void c(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo = paramVideoInfo;
  }
  
  public void c(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean c()
  {
    VideoFeedsCommentManager localVideoFeedsCommentManager = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager;
    if (localVideoFeedsCommentManager != null) {
      return localVideoFeedsCommentManager.b();
    }
    return false;
  }
  
  public void d()
  {
    this.jdField_e_of_type_Boolean = true;
    BaseVideoItemHolder localBaseVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
    if ((localBaseVideoItemHolder != null) && (localBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).instanceOfADVideoItemDelegate(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate))) {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).doADVideoItemDelegateOnResume(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate);
    }
    ApngImage.playByTag(28);
    ApngImage.playByTag(29);
    ApngImage.playByTag(30);
    ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).doOnVideoResume();
  }
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void d(VideoInfo paramVideoInfo)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.contains(paramVideoInfo)))
    {
      int i1 = this.jdField_a_of_type_JavaUtilList.indexOf(paramVideoInfo);
      g();
      this.jdField_a_of_type_JavaUtilList.remove(paramVideoInfo);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder = null;
      notifyItemRemoved(i1);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean d()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsReporter.a();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter$AdapterEventListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter$AdapterEventListener = null;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
    if (localObject != null) {
      ((BaseVideoItemHolder)localObject).jdField_c_of_type_ComTencentImageURLImageView = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityINegativeHelper;
    if (localObject != null) {
      ((INegativeHelper)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
    if (localObject != null) {
      AppNetConnInfo.unregisterNetInfoHandler((INetInfoHandler)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoBrightnessController;
    if (localObject != null)
    {
      ((VideoBrightnessController)localObject).b();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoBrightnessController = null;
    }
    ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).destroyFromVideoFeeds();
    DownloadManagerV2.a().b(VideoFeedsUGView.a);
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder;
    if (localObject != null)
    {
      a(((VideoItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsAbsVideoFeedsUGView, false);
      a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_b_of_type_ComTencentMobileqqKandianBizPlayfeedsAbsVideoFeedsUGView, false);
    }
  }
  
  void e(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void e(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsReporter.b(paramVideoInfo);
    BaseVideoItemHolder localBaseVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
    if ((localBaseVideoItemHolder != null) && (localBaseVideoItemHolder.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper != null)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsReporter.a((VideoPlayerWrapper)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper, paramVideoInfo.w);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void f()
  {
    Object localObject = this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog;
    if ((localObject != null) && (((PopupMenuDialog)localObject).isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityINegativeHelper;
    if (localObject != null) {
      ((INegativeHelper)localObject).a();
    }
  }
  
  public void f(boolean paramBoolean)
  {
    if ((!this.k) && (paramBoolean) && (this.l))
    {
      BaseVideoItemHolder localBaseVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
      if ((localBaseVideoItemHolder instanceof VideoItemHolder)) {
        a((VideoItemHolder)localBaseVideoItemHolder);
      }
      this.l = false;
    }
    this.k = paramBoolean;
  }
  
  public void g(boolean paramBoolean) {}
  
  public int getItemCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size() + 1;
  }
  
  public long getItemId(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return ((VideoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).hashCode();
    }
    FooterItemHolder localFooterItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsFooterItemHolder;
    int i1 = paramInt;
    if (localFooterItemHolder != null)
    {
      i1 = paramInt;
      if (localFooterItemHolder.itemView != null) {
        i1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsFooterItemHolder.itemView.hashCode();
      }
    }
    return i1;
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (paramInt >= 0) && (paramInt < ((List)localObject).size()))
    {
      localObject = (VideoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (((VideoInfo)localObject).r)
      {
        if (((VideoInfo)localObject).t == 1) {
          return 7;
        }
      }
      else
      {
        if (this.m) {
          return 8;
        }
        return 2;
      }
    }
    return 6;
  }
  
  @TargetApi(11)
  public void onClick(View paramView)
  {
    BaseItemHolder localBaseItemHolder = (BaseItemHolder)paramView.getTag();
    Object localObject;
    if ((localBaseItemHolder instanceof VideoItemHolder))
    {
      VideoInfo localVideoInfo = ((VideoItemHolder)localBaseItemHolder).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
      if ((localObject != null) && (((BaseVideoItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null))
      {
        localObject = localVideoInfo;
        if (localVideoInfo == this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo) {
          break label64;
        }
      }
    }
    else
    {
      localObject = null;
    }
    label64:
    if (localObject == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoFeedsHardAdBarManager.a(paramView, localBaseItemHolder, localObject, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager);
    b(paramView, localBaseItemHolder, (VideoInfo)localObject);
    a(paramView, localBaseItemHolder, (VideoInfo)localObject);
  }
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2) {}
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (paramReadInJoyUserInfo != null) {
      VideoFeedsHelper.a(new VideoFeedsAdapter.10(this, paramString));
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    BaseItemHolder localBaseItemHolder = (BaseItemHolder)paramView.getTag();
    Object localObject;
    if ((localBaseItemHolder instanceof VideoItemHolder))
    {
      VideoInfo localVideoInfo = ((VideoItemHolder)localBaseItemHolder).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
      if ((localObject != null) && (((BaseVideoItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null))
      {
        localObject = localVideoInfo;
        if (localVideoInfo == this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo) {}
      }
      else
      {
        return false;
      }
    }
    else
    {
      localObject = null;
    }
    if (localObject == null) {
      return false;
    }
    if (paramView.getId() != 2131367124) {
      return false;
    }
    a((VideoInfo)localObject, localBaseItemHolder, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsAdapter
 * JD-Core Version:    0.7.0.1
 */