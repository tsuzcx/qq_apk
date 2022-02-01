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
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
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
  private static boolean A = false;
  private int B;
  private VideoFeedsRecommendPresenter C;
  private LinearLayoutManager D;
  private List<VideoInfo> E;
  private Context F;
  private QQAppInterface G;
  private IADVideoFeedsGuideManager H;
  private boolean I = true;
  private boolean J = false;
  private boolean K = true;
  private boolean L = false;
  private boolean M = true;
  private long N;
  private Map<Integer, Bitmap> O = new ConcurrentHashMap();
  private int P = 1;
  private VideoFeedsRecommendManager Q;
  private VideoPreDownloadMgr R;
  private boolean S = false;
  private boolean T = false;
  private boolean U = false;
  private VideoInfo V;
  private int W = 0;
  private long X = 0L;
  private String Y;
  private RecyclerView.RecycledViewPool Z = new RecyclerView.RecycledViewPool();
  public VideoFeedsAdapter.AdapterEventListener a;
  private IVideoAdExposureManager aa;
  private final boolean ab;
  private RIJVideoRewardCoinManager ac;
  private VideoFeedsReporter ad;
  private VideoItemHolder ae;
  private boolean af = false;
  private INetInfoHandler ag = new VideoFeedsAdapter.12(this);
  private boolean ah = true;
  public VideoFeedsCommentManager b;
  public VideoFeedsLikeAnimateManager c;
  public VideoFeedsRecyclerView d;
  public Activity e;
  public VideoFeedsPlayManager f;
  public VideoBrightnessController g;
  public BaseVideoItemHolder h;
  public boolean i = false;
  public Drawable j = null;
  public ColorDrawable k;
  public Animation l;
  public PopupMenuDialog m = null;
  public KandianPopupWindowForAd n;
  FooterItemHolder o;
  public Drawable p;
  public long q = -2147483648L;
  public boolean r;
  public int s = 0;
  public int t = 0;
  public INegativeHelper u;
  public VideoColumnBannerManager v;
  public IVideoFeedsHardAdBarManager w;
  public Handler x = new VideoFeedsAdapter.3(this, Looper.getMainLooper());
  public ListEventListener y = new VideoFeedsAdapter.4(this);
  public boolean z = false;
  
  VideoFeedsAdapter(Context paramContext, Activity paramActivity, Bundle paramBundle, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, LinearLayoutManager paramLinearLayoutManager, QQAppInterface paramQQAppInterface, boolean paramBoolean, int paramInt, VideoFeedsRecommendPresenter paramVideoFeedsRecommendPresenter)
  {
    this.F = paramContext;
    this.d = paramVideoFeedsRecyclerView;
    this.e = paramActivity;
    this.G = paramQQAppInterface;
    this.d.a(this.y);
    this.D = paramLinearLayoutManager;
    this.j = ImageUtil.a(true);
    this.k = new ColorDrawable(this.F.getResources().getColor(2131165564));
    this.g = new VideoBrightnessController(paramActivity);
    A = paramBoolean;
    this.B = paramInt;
    this.n = new KandianPopupWindowForAd(this.e);
    AppNetConnInfo.registerConnectionChangeReceiver(this.e.getApplication(), this.ag);
    this.p = new ColorDrawable(1930498322);
    this.C = paramVideoFeedsRecommendPresenter;
    setHasStableIds(true);
    registerAdapterDataObserver(new VideoFeedsAdapter.ActionInspector(this, null));
    this.r = SimpleUIUtil.e();
    this.u = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createNegativeHelper(paramActivity, this);
    this.ab = ReadInJoyHelper.b();
    this.ad = paramVideoFeedsRecommendPresenter.f();
    this.w = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createVideoFeedsHardAdBarManager(paramContext, this.ab, paramActivity, this);
    paramVideoFeedsRecommendPresenter.a(this);
  }
  
  private void A()
  {
    this.d.a();
  }
  
  private void B()
  {
    BaseVideoItemHolder localBaseVideoItemHolder = this.h;
    if ((localBaseVideoItemHolder instanceof VideoItemHolder)) {
      VideoFeedsHelper.a(((VideoItemHolder)localBaseVideoItemHolder).aL.getView(), 8, 600);
    }
  }
  
  private void C()
  {
    this.R = new VideoPreDownloadMgr(this.e.getApplicationContext());
    this.R.b = new VideoPreloadReportData(VideoPreloadReportData.c, VideoPreloadReportData.g);
    this.R.a(new VideoFeedsAdapter.11(this));
  }
  
  private void D()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleNotNetWorkChange mIsActivityOnResume = ");
      ((StringBuilder)localObject).append(this.I);
      QLog.d("Q.pubaccount.video.feedsVideoFeedsAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if (!this.I) {
      return;
    }
    Object localObject = this.f;
    if (localObject != null) {
      ((VideoFeedsPlayManager)localObject).e(false);
    }
  }
  
  private void a(View paramView, VideoInfo paramVideoInfo)
  {
    Object localObject = this.C;
    if (localObject != null)
    {
      ((VideoFeedsRecommendPresenter)localObject).h();
      localObject = this.h;
      if ((localObject instanceof VideoItemHolder))
      {
        ImageView localImageView = ((BaseVideoItemHolder)localObject).ad;
        if (this.f.o()) {
          localObject = "click_pause";
        } else {
          localObject = "click_play";
        }
        VideoFeedsHelper.a(localImageView, paramVideoInfo, (String)localObject);
      }
    }
    this.h.aC.a();
    if (paramView.getId() == 2131432590) {
      PlayFeedbackHelper.b(paramVideoInfo.l, 2);
    }
  }
  
  private void a(View paramView, BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131449722: 
      paramView = this.h;
      if ((paramView != null) && (paramView.ay != null))
      {
        this.C.k();
        this.ad.c(this.h.az.c, "0X8009F42");
        return;
      }
      break;
    case 2131449655: 
      i(paramVideoInfo);
      return;
    case 2131439639: 
      a(paramBaseItemHolder);
      return;
    case 2131432590: 
    case 2131440375: 
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
    int i1 = this.P;
    if (i1 == 1)
    {
      paramFooterItemHolder.a.setVisibility(0);
      paramFooterItemHolder.b.setVisibility(0);
      paramFooterItemHolder.c.setVisibility(0);
      paramFooterItemHolder.c.setText(g(1));
      return;
    }
    if (i1 == 2)
    {
      paramFooterItemHolder.a.setVisibility(0);
      paramFooterItemHolder.b.setVisibility(8);
      paramFooterItemHolder.c.setVisibility(0);
      paramFooterItemHolder.c.setText(g(2));
      return;
    }
    if (i1 == 3)
    {
      if (paramFooterItemHolder.X == 6)
      {
        paramFooterItemHolder.a.setVisibility(0);
        paramFooterItemHolder.b.setVisibility(0);
        paramFooterItemHolder.c.setVisibility(0);
        paramFooterItemHolder.c.setText(g(1));
        return;
      }
      paramFooterItemHolder.a.setVisibility(8);
      paramFooterItemHolder.b.setVisibility(8);
      paramFooterItemHolder.c.setVisibility(8);
    }
  }
  
  private void a(VideoInfo paramVideoInfo, int paramInt, Integer paramInteger)
  {
    if (paramVideoInfo == null) {
      return;
    }
    Object localObject = this.f;
    if (localObject != null) {
      ((VideoFeedsPlayManager)localObject).a(ReportConstants.VideoEndType.AD_AREA_CLICK);
    }
    localObject = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(paramVideoInfo.as);
    int i1;
    if (paramVideoInfo.e(this.e)) {
      i1 = 10;
    } else {
      i1 = 5;
    }
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.F).a(1).b(i1).b(paramInteger).a((AdvertisementInfo)localObject).a(paramVideoInfo.as).c(paramInt));
  }
  
  private void a(VideoInfo paramVideoInfo, BaseItemHolder paramBaseItemHolder, boolean paramBoolean)
  {
    if ((paramVideoInfo.aq) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).instanceOfADVideoItemHolder(paramBaseItemHolder)))
    {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).showVideoAdToast(paramBaseItemHolder, "暂不支持biu");
      return;
    }
    RIJUserLevelModule.getInstance().doActionsByUserLevel(this.e, 2, new VideoFeedsAdapter.6(this, paramVideoInfo, paramBaseItemHolder, paramBoolean));
  }
  
  private void a(VideoInfo paramVideoInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramVideoInfo == null) {
      return;
    }
    b(paramVideoInfo, paramBoolean2);
    Object localObject1 = new VideoR5.Builder(paramVideoInfo.l(), paramVideoInfo.q, paramVideoInfo.b, paramVideoInfo.l, this.f.b(), paramVideoInfo.k() * 1000);
    ((VideoR5.Builder)localObject1).i(paramBoolean1).j(paramBoolean2).d(this.ab);
    if (!A)
    {
      ((VideoR5.Builder)localObject1).e(paramVideoInfo.ah).c(paramVideoInfo.ai).a(-1).b(paramVideoInfo.ao).M(0);
      localObject2 = new ReportInfo.VideoExtraRepoerData();
      ((ReportInfo.VideoExtraRepoerData)localObject2).d = ((int)this.f.b());
      ((ReportInfo.VideoExtraRepoerData)localObject2).e = (paramVideoInfo.k() * 1000);
      ((ReportInfo.VideoExtraRepoerData)localObject2).b = this.e.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      VideoReporter.b(paramVideoInfo, this.e.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1), 25, -1, (ReportInfo.VideoExtraRepoerData)localObject2, this.V.l);
    }
    localObject1 = ((VideoR5.Builder)localObject1).b().a();
    if (A)
    {
      localObject2 = paramVideoInfo.q;
      if (!TextUtils.isEmpty(paramVideoInfo.l)) {
        paramVideoInfo = paramVideoInfo.l;
      } else {
        paramVideoInfo = "0";
      }
      PublicAccountReportUtils.a(null, (String)localObject2, "0X8009299", "0X8009299", 0, 0, "0", "0", paramVideoInfo, (String)localObject1, false);
      return;
    }
    Object localObject2 = paramVideoInfo.q;
    if (!TextUtils.isEmpty(paramVideoInfo.l)) {
      paramVideoInfo = paramVideoInfo.l;
    } else {
      paramVideoInfo = "0";
    }
    PublicAccountReportUtils.a(null, (String)localObject2, "0X8007B89", "0X8007B89", 0, 0, "0", "0", paramVideoInfo, (String)localObject1, false);
  }
  
  @RequiresApi(api=16)
  private void a(VideoPlayParam paramVideoPlayParam)
  {
    VideoFeedsHelper.b(this.h.ao, 8, 0);
    this.e.getWindow().getDecorView().getViewTreeObserver().addOnDrawListener(new VideoFeedsAdapter.1(this, paramVideoPlayParam));
  }
  
  private void a(BaseItemHolder paramBaseItemHolder)
  {
    if ((paramBaseItemHolder.X == 2) && (this.f.i())) {
      VideoFeedsHelper.a(((VideoItemHolder)paramBaseItemHolder).af, 8, 200);
    }
    paramBaseItemHolder = this.C;
    if (paramBaseItemHolder != null) {
      paramBaseItemHolder.h();
    }
  }
  
  private void a(BaseVideoItemHolder paramBaseVideoItemHolder, VideoInfo paramVideoInfo)
  {
    VideoPlayParam localVideoPlayParam2 = paramBaseVideoItemHolder.az;
    VideoPlayParam localVideoPlayParam1 = localVideoPlayParam2;
    if (localVideoPlayParam2 == null)
    {
      localVideoPlayParam1 = new VideoPlayParam();
      localVideoPlayParam1.o = paramBaseVideoItemHolder.aB;
      localVideoPlayParam1.g.putInt("jump_from_scene", this.e.getIntent().getIntExtra("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 0));
    }
    localVideoPlayParam1.c = paramVideoInfo;
    localVideoPlayParam1.d = paramVideoInfo.a(this.e, paramBaseVideoItemHolder.aD);
    localVideoPlayParam1.a = paramBaseVideoItemHolder.ab;
    localVideoPlayParam1.k = paramBaseVideoItemHolder.Z;
    localVideoPlayParam1.i = false;
    localVideoPlayParam1.g.putInt("video_feeds_index", paramBaseVideoItemHolder.Z);
    localVideoPlayParam1.j = VideoResumeManager.a.a(paramVideoInfo.l, paramVideoInfo.b);
    localVideoPlayParam1.l = true;
    if (paramVideoInfo.aq) {
      if (paramVideoInfo.e(this.e)) {
        localVideoPlayParam1.g.putInt("ad_origin", 10);
      } else {
        localVideoPlayParam1.g.putInt("ad_origin", 5);
      }
    }
    paramBaseVideoItemHolder.aB.b(true);
    paramBaseVideoItemHolder.az = localVideoPlayParam1;
    paramBaseVideoItemHolder.aC.a(this, paramBaseVideoItemHolder);
  }
  
  private void a(BaseVideoItemHolder paramBaseVideoItemHolder, boolean paramBoolean, long paramLong, int paramInt)
  {
    if (paramBoolean)
    {
      if (this.N != 0L) {
        ThreadManager.excute(new VideoFeedsAdapter.2(this, paramLong), 16, null, true);
      }
      if ((paramBaseVideoItemHolder.az != null) && (paramBaseVideoItemHolder.az.e != null))
      {
        paramBaseVideoItemHolder.az.e.I = paramLong;
        paramBaseVideoItemHolder.az.e.ak = ReadInJoyUtils.a(paramInt, paramBaseVideoItemHolder.Z, false);
      }
      if ((paramBaseVideoItemHolder.az != null) && (paramBaseVideoItemHolder.az.f != null)) {
        paramBaseVideoItemHolder.az.f.f = true;
      }
    }
  }
  
  private void a(VideoItemHolder paramVideoItemHolder, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramVideoInfo.aq) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).instanceOfADVideoItemHolder(paramVideoItemHolder)))
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
        if (paramList.Y == i3)
        {
          paramList.aA.c(paramVideoInfo);
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
        int i3 = ((VideoItemHolder)localObject).Y;
        if (i3 < paramList.size())
        {
          VideoInfo localVideoInfo = (VideoInfo)paramList.get(i3);
          if (paramString.equals(localVideoInfo.q)) {
            ((VideoItemHolder)localObject).aA.c(localVideoInfo);
          }
        }
      }
      i1 += 1;
    }
    return false;
  }
  
  private void b(View paramView, int paramInt1, int paramInt2)
  {
    VideoItemHolder localVideoItemHolder = (VideoItemHolder)paramView.getTag();
    if (localVideoItemHolder != this.h) {
      return;
    }
    if (!this.ah) {
      return;
    }
    int i2;
    Object localObject;
    JSONObject localJSONObject;
    String str1;
    if ((localVideoItemHolder != null) && (localVideoItemHolder.az.c != null) && ((localVideoItemHolder instanceof BaseVideoItemHolder)) && (!TextUtils.isEmpty(localVideoItemHolder.az.c.l)))
    {
      paramView = localVideoItemHolder.az.c;
      boolean bool = paramView.am;
      i2 = 1;
      bool ^= true;
      paramView.am = true;
      int i1;
      if (bool) {
        i1 = paramView.an + 1;
      } else {
        i1 = paramView.an;
      }
      paramView.an = i1;
      localVideoItemHolder.aA.a(paramInt1, paramInt2, bool);
      if (bool)
      {
        localObject = this.a;
        if (localObject != null) {
          ((VideoFeedsAdapter.AdapterEventListener)localObject).a(paramView, paramView.am);
        }
        j(paramView);
      }
      localObject = this.Q;
      if (localObject != null) {
        ((VideoFeedsRecommendManager)localObject).a(3, paramView, 0L);
      }
      VideoFeedsHelper.a(localVideoItemHolder.ac, paramView, "click_like", "double");
      VideoReport.reportEvent("clck", localVideoItemHolder.ac, null);
      localJSONObject = new JSONObject();
      str1 = localVideoItemHolder.az.c.l();
    }
    try
    {
      localJSONObject.put("channel_id", 409409);
      localJSONObject.put("rowkey", localVideoItemHolder.az.c.l);
      if (this.c == null) {
        break label496;
      }
      paramInt1 = this.c.b();
    }
    catch (Exception paramView)
    {
      for (;;)
      {
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
    localJSONObject.put("algorithm_id", paramView.ah);
    if (paramView.aJ != null)
    {
      paramView = paramView.aJ.d;
      localJSONObject.put("common_data", paramView);
      if (!this.ab) {
        break label508;
      }
      paramInt1 = i2;
      localJSONObject.put("interact_button_style", paramInt1);
      if (A) {
        paramView = "0X80097F5";
      } else {
        paramView = "0X80091AA";
      }
      str2 = localVideoItemHolder.az.c.q;
      if (!TextUtils.isEmpty(localVideoItemHolder.az.c.l)) {
        localObject = localVideoItemHolder.az.c.l;
      } else {
        localObject = "0";
      }
      PublicAccountReportUtils.a(null, str2, paramView, paramView, 0, 0, "0", "0", (String)localObject, VideoReporter.a(str1, localVideoItemHolder.az.c.q, localVideoItemHolder.az.c.b, localVideoItemHolder.az.c.l, localJSONObject), false);
    }
  }
  
  private void b(View paramView, BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo)
  {
    AdvertisementInfo localAdvertisementInfo = this.w.a(paramVideoInfo, false);
    switch (paramView.getId())
    {
    default: 
    case 2131449573: 
      b(paramBaseItemHolder, paramVideoInfo);
      return;
    case 2131449555: 
      g(paramVideoInfo);
      return;
    case 2131434977: 
      a(paramVideoInfo, paramVideoInfo);
      return;
    case 2131434944: 
      h(paramVideoInfo);
      return;
    case 2131434509: 
      b((VideoItemHolder)paramBaseItemHolder, paramVideoInfo);
      return;
    case 2131433608: 
      a((VideoItemHolder)paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo);
      return;
    case 2131433607: 
      b((VideoItemHolder)paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo);
      return;
    case 2131433602: 
      paramView = this.a;
      if (paramView != null)
      {
        paramView.d();
        return;
      }
      break;
    case 2131433597: 
      f(paramVideoInfo);
      return;
    case 2131433586: 
      RIJUserLevelModule.getInstance().doActionsByUserLevel(this.e, 3, new VideoFeedsAdapter.5(this, paramBaseItemHolder, paramVideoInfo));
      return;
    case 2131433578: 
    case 2131439562: 
      a(paramVideoInfo, paramBaseItemHolder, false);
      return;
    case 2131431135: 
      a(paramView);
      return;
    case 2131430821: 
    case 2131433908: 
      paramView = this.d;
      if (paramView != null)
      {
        paramView.a();
        return;
      }
      break;
    case 2131427415: 
      paramView = this.d;
      if (paramView != null) {
        paramView.b();
      }
      break;
    }
  }
  
  private void b(VideoInfo paramVideoInfo, BaseItemHolder paramBaseItemHolder, boolean paramBoolean)
  {
    if ((paramBaseItemHolder instanceof VideoItemHolder)) {
      VideoFeedsHelper.a(((VideoItemHolder)paramBaseItemHolder).aR, paramVideoInfo, "click_biu");
    }
    if ((paramVideoInfo instanceof VideoInfo))
    {
      int i1 = BiuBehaviour.a();
      boolean bool = true;
      if (i1 != 1) {
        bool = false;
      }
      a(paramVideoInfo, paramBoolean, bool);
      paramBaseItemHolder = this.Q;
      if (paramBaseItemHolder != null) {
        paramBaseItemHolder.a(2, paramVideoInfo, 0L);
      }
    }
  }
  
  private void b(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    try
    {
      localObject = new Intent(this.e, ReadInJoyDeliverBiuActivity.class);
      if ((paramVideoInfo.a == 6) && (paramVideoInfo.aB != null)) {
        ((Intent)localObject).putExtra("feedsType", paramVideoInfo.aB.mFeedType);
      }
      ((Intent)localObject).putExtra("ARG_VIDEO_ARTICLE_ID", paramVideoInfo.l);
      ((Intent)localObject).putExtra("biu_src", 2);
      ((Intent)localObject).putExtra("arg_from_type", 8);
      ((Intent)localObject).putExtra("arg_article_info", paramVideoInfo.aB);
      ((Intent)localObject).putExtra("fast_biu_type", paramBoolean);
      this.e.startActivityForResult((Intent)localObject, 102);
      this.e.overridePendingTransition(0, 0);
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
    if (((paramBaseItemHolder instanceof ShortVideoItemHolder)) && (paramVideoInfo.ay != null))
    {
      VideoFeedsHelper.a(this.e, paramVideoInfo.ay.n);
      paramBaseItemHolder = new VideoR5.Builder(paramVideoInfo).a(paramVideoInfo.ay).k(paramVideoInfo.l).M(0).b();
      PublicAccountReportUtils.a(this.G, "", "0X800AC2C", "0X800AC2C", 0, 0, "", "", "", paramBaseItemHolder.a(), false);
    }
  }
  
  private void b(VideoItemHolder paramVideoItemHolder, VideoInfo paramVideoInfo)
  {
    this.H.f();
    this.w.a(false, paramVideoItemHolder);
    a(paramVideoItemHolder);
    this.w.a(paramVideoInfo, 21, Integer.valueOf(0), false);
  }
  
  private void b(VideoItemHolder paramVideoItemHolder, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.aq)
    {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, 1000, this.f);
      a(paramVideoInfo, 1000, ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.e, paramAdvertisementInfo, null, 3, false, null));
      return;
    }
    d(paramVideoItemHolder, paramVideoInfo);
  }
  
  private boolean b(VideoInfo paramVideoInfo, String paramString)
  {
    if ((paramVideoInfo.q != null) && (paramVideoInfo.q.equals(paramString)))
    {
      boolean bool = paramVideoInfo.al;
      paramVideoInfo.al = true;
      return bool ^ true;
    }
    return false;
  }
  
  private void c(BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo)
  {
    paramVideoInfo.am ^= true;
    int i1;
    if (paramVideoInfo.am) {
      i1 = paramVideoInfo.an + 1;
    } else if (paramVideoInfo.an > 0) {
      i1 = paramVideoInfo.an - 1;
    } else {
      i1 = 0;
    }
    paramVideoInfo.an = i1;
    if ((paramBaseItemHolder instanceof VideoItemHolder))
    {
      paramBaseItemHolder = (VideoItemHolder)paramBaseItemHolder;
      paramBaseItemHolder.aA.f();
      ImageView localImageView = paramBaseItemHolder.aS;
      if (paramVideoInfo.am) {
        paramBaseItemHolder = "click_like";
      } else {
        paramBaseItemHolder = "cancel_like";
      }
      VideoFeedsHelper.a(localImageView, paramVideoInfo, paramBaseItemHolder);
    }
    if ((this.c != null) && (paramVideoInfo.am)) {
      this.c.a((float)(DeviceInfoUtil.D() / 2L), (float)(DeviceInfoUtil.E() / 2L));
    }
    paramBaseItemHolder = this.Q;
    if (paramBaseItemHolder != null) {
      paramBaseItemHolder.a(3, paramVideoInfo, 0L);
    }
    if ((this.a != null) && (!paramVideoInfo.aq)) {
      this.a.a(paramVideoInfo, paramVideoInfo.am);
    }
    j(paramVideoInfo);
  }
  
  private void c(BaseVideoItemHolder paramBaseVideoItemHolder)
  {
    Object localObject = this.h;
    if ((localObject != null) && (((BaseVideoItemHolder)localObject).az != null) && (this.h.az.h != null))
    {
      localObject = (VideoPlayerWrapper)this.h.az.h;
      if ((!((VideoPlayerWrapper)localObject).i()) && (!((VideoPlayerWrapper)localObject).j()) && (!((VideoPlayerWrapper)localObject).k()) && (this.h.Z == paramBaseVideoItemHolder.Z - 1) && (ReadInJoyHelper.ab(this.G)) && (VideoPreloadStrategyConoller.a().a((VideoPlayerWrapper)this.h.az.h))) {
        this.f.b(paramBaseVideoItemHolder.az);
      }
    }
  }
  
  private void c(VideoItemHolder paramVideoItemHolder, VideoInfo paramVideoInfo)
  {
    VideoFeedsHelper.a(paramVideoItemHolder.aO, paramVideoInfo, "click_comment");
    JSONObject localJSONObject = new JSONObject();
    this.b.e();
    for (;;)
    {
      try
      {
        if (paramVideoInfo.ao == null) {
          break label187;
        }
        paramVideoItemHolder = paramVideoInfo.ao;
        localJSONObject.put("video_report_info", paramVideoItemHolder);
        int i1 = 0;
        localJSONObject.put("video_type", 0);
        if (this.ab) {
          i1 = 1;
        }
        localJSONObject.put("interact_button_style", i1);
      }
      catch (JSONException paramVideoItemHolder)
      {
        paramVideoItemHolder.printStackTrace();
      }
      if (A)
      {
        PublicAccountReportUtils.a(null, "", "0X80092A1", "0X80092A1", 0, 0, "", "", "", VideoReporter.a("", "", paramVideoInfo.b, paramVideoInfo.l, localJSONObject), false);
        return;
      }
      PublicAccountReportUtils.a(null, "", "0X8008E54", "0X8008E54", 0, 0, "", "", "", VideoReporter.a("", "", paramVideoInfo.b, paramVideoInfo.l, localJSONObject), false);
      return;
      label187:
      paramVideoItemHolder = "";
    }
  }
  
  private void d(BaseVideoItemHolder paramBaseVideoItemHolder)
  {
    paramBaseVideoItemHolder = paramBaseVideoItemHolder.az;
    if ((paramBaseVideoItemHolder != null) && ((paramBaseVideoItemHolder.i) || ((paramBaseVideoItemHolder.h != null) && (paramBaseVideoItemHolder.h.h() != 0))))
    {
      paramBaseVideoItemHolder.i = false;
      this.f.c(paramBaseVideoItemHolder);
    }
  }
  
  private void d(VideoItemHolder paramVideoItemHolder, VideoInfo paramVideoInfo)
  {
    VideoFeedsHelper.a(paramVideoItemHolder.aM, paramVideoInfo, "click_write_comment");
    this.b.g();
    String str1;
    if (A) {
      str1 = "0X800948A";
    } else {
      str1 = "0X8009485";
    }
    if (paramVideoItemHolder.az != null) {
      paramVideoItemHolder = paramVideoItemHolder.az.h;
    } else {
      paramVideoItemHolder = null;
    }
    Object localObject = new VideoR5.Builder(null, paramVideoInfo.q, paramVideoInfo.b, paramVideoInfo.l);
    long l2 = -1L;
    if (paramVideoItemHolder != null) {
      l1 = paramVideoItemHolder.d(paramVideoItemHolder.p());
    } else {
      l1 = -1L;
    }
    localObject = ((VideoR5.Builder)localObject).d(l1);
    if (paramVideoItemHolder != null) {
      l1 = paramVideoItemHolder.C();
    } else {
      l1 = -1L;
    }
    localObject = ((VideoR5.Builder)localObject).a(l1);
    long l1 = l2;
    if (paramVideoItemHolder != null) {
      l1 = paramVideoItemHolder.I();
    }
    localObject = ((VideoR5.Builder)localObject).c(l1).a(409409).b(paramVideoInfo.ao).u(this.e.getIntent().getIntExtra("VIDEO_FROM_TYPE", -1)).b().a();
    String str2 = paramVideoInfo.q;
    if (!TextUtils.isEmpty(paramVideoInfo.l)) {
      paramVideoItemHolder = paramVideoInfo.l;
    } else {
      paramVideoItemHolder = "0";
    }
    PublicAccountReportUtils.a(null, str2, str1, str1, 0, 0, "", "", paramVideoItemHolder, (String)localObject, false);
    if (ReadInJoyHelper.q(RIJQQAppInterfaceUtil.e())) {
      return;
    }
    paramVideoItemHolder = this.Q;
    if (paramVideoItemHolder != null) {
      paramVideoItemHolder.a(4, paramVideoInfo, 0L);
    }
  }
  
  private void f(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.af) {
      RIJVideoRewardCoinManager.a.a();
    } else {
      this.ac.a(new RIJVideoRewardCoinManager.RIJRewardInfo(paramVideoInfo.l, paramVideoInfo.q, paramVideoInfo), 1);
    }
    this.ad.a(paramVideoInfo, "0X800B2EB");
  }
  
  private String g(int paramInt)
  {
    if (paramInt == 1) {
      return HardCodeUtil.a(2131913449);
    }
    if (paramInt == 2) {
      return HardCodeUtil.a(2131913446);
    }
    return null;
  }
  
  private void g(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.aN != null)
    {
      String str1 = paramVideoInfo.q;
      String str3 = paramVideoInfo.b;
      String str4 = paramVideoInfo.l;
      String str2 = "";
      str3 = new VideoR5.Builder("", str1, str3, str4).k(paramVideoInfo.l).b().a();
      if (paramVideoInfo.aN.a) {
        str1 = "1";
      } else {
        str1 = "2";
      }
      if (paramVideoInfo.aN.a) {
        paramVideoInfo = str2;
      } else {
        paramVideoInfo = paramVideoInfo.aN.b;
      }
      PublicAccountReportUtils.a(null, "", "0X800B4D0", "0X800B4D0", 0, 0, str1, paramVideoInfo, "", str3, false);
    }
  }
  
  private void h(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.al) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("followPubAccount onClick() puin=");
      ((StringBuilder)localObject).append(paramVideoInfo.q);
      ((StringBuilder)localObject).append(", isFollowed=");
      ((StringBuilder)localObject).append(paramVideoInfo.al);
      ((StringBuilder)localObject).append(", pname=");
      ((StringBuilder)localObject).append(paramVideoInfo.r);
      QLog.d("Q.pubaccount.video.feedsVideoFeedsAdapter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.h;
    if ((localObject instanceof VideoItemHolder)) {
      VideoFeedsHelper.a(((VideoItemHolder)localObject).aL, paramVideoInfo, "click_follow");
    }
    String str1 = new VideoR5.Builder(null, paramVideoInfo.q, paramVideoInfo.b, paramVideoInfo.l, this.f.b(), 1000L * paramVideoInfo.k()).b(paramVideoInfo.ao).M(0).b().a();
    boolean bool = A;
    localObject = "0";
    String str2;
    if (bool)
    {
      str2 = paramVideoInfo.q;
      if (!TextUtils.isEmpty(paramVideoInfo.l)) {
        localObject = paramVideoInfo.l;
      }
      PublicAccountReportUtils.a(null, str2, "0X800929B", "0X800929B", 0, 0, "", "", (String)localObject, str1, false);
    }
    else
    {
      str2 = paramVideoInfo.q;
      if (!TextUtils.isEmpty(paramVideoInfo.l)) {
        localObject = paramVideoInfo.l;
      }
      PublicAccountReportUtils.a(null, str2, "0X80078FD", "0X80078FD", 0, 0, "", "", (String)localObject, str1, false);
    }
    this.ad.a(paramVideoInfo, "0X800B1A7", true, true);
    this.ad.a(paramVideoInfo, "0X800B1A6", false, true);
    b(paramVideoInfo);
  }
  
  private void h(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feedsVideoFeedsAdapter", 2, "handleConnetNetWorkChange");
    }
    VideoFeedsPlayManager localVideoFeedsPlayManager = this.f;
    if (localVideoFeedsPlayManager != null)
    {
      if (!this.I) {
        return;
      }
      localVideoFeedsPlayManager.e(paramBoolean);
      this.x.post(new VideoFeedsAdapter.13(this, paramBoolean));
    }
  }
  
  private void i(VideoInfo paramVideoInfo)
  {
    if (this.h.az != null)
    {
      if (paramVideoInfo == null) {
        return;
      }
      this.d.a(false);
      if (!TextUtils.isEmpty(paramVideoInfo.l))
      {
        PlayFeedbackHelper.a(this.e, FeedsChannelDataHelper.a(paramVideoInfo), this.h.az.h, 2, 0);
        PlayFeedbackHelper.a(paramVideoInfo.l, 2, 0);
      }
    }
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
      boolean bool = paramVideoInfo.am;
      i2 = 1;
      if (!bool) {
        break label302;
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
    localObject = paramVideoInfo.ao;
    str2 = "";
    if (localObject != null)
    {
      localObject = paramVideoInfo.ao;
      localJSONObject.put("video_report_info", localObject);
      if (paramVideoInfo.am)
      {
        if (this.c == null) {
          break label315;
        }
        i1 = this.c.b();
        localJSONObject.put("style", i1);
      }
      localJSONObject.put("algorithm_id", paramVideoInfo.ah);
      localObject = str2;
      if (paramVideoInfo.aJ != null) {
        localObject = paramVideoInfo.aJ.d;
      }
      localJSONObject.put("common_data", localObject);
      localJSONObject.put("video_type", 0);
      if (!this.ab) {
        break label320;
      }
      i1 = i2;
      localJSONObject.put("interact_button_style", i1);
      if (A) {
        localObject = "0X800929C";
      } else {
        localObject = "0X80091A9";
      }
      str3 = paramVideoInfo.l();
      str4 = paramVideoInfo.q;
      if (!TextUtils.isEmpty(paramVideoInfo.l)) {
        str2 = paramVideoInfo.l;
      } else {
        str2 = "0";
      }
      PublicAccountReportUtils.a(null, str4, (String)localObject, (String)localObject, 0, 0, "0", "0", str2, VideoReporter.a(str3, paramVideoInfo.q, paramVideoInfo.b, paramVideoInfo.l, localJSONObject), false);
    }
  }
  
  private void w()
  {
    this.x.removeMessages(2, null);
    this.f.a(false, null);
  }
  
  private void x()
  {
    this.x.removeMessages(8);
    BaseVideoItemHolder localBaseVideoItemHolder = this.h;
    if ((localBaseVideoItemHolder != null) && ((localBaseVideoItemHolder.aA instanceof ShortVideoItemDelegate))) {
      ((ShortVideoItemDelegate)this.h.aA).b();
    }
  }
  
  private void y()
  {
    this.x.sendEmptyMessageDelayed(0, 3000L);
    BaseVideoItemHolder localBaseVideoItemHolder = this.h;
    if (localBaseVideoItemHolder == null) {
      return;
    }
    if (localBaseVideoItemHolder.aB.b()) {
      l1 = System.currentTimeMillis();
    } else {
      l1 = this.h.aB.c();
    }
    long l1 = Math.max(this.d.getLastActionDownTimeStamp(), l1);
    l1 = 3000L - (System.currentTimeMillis() - l1);
    if (l1 > 0L)
    {
      this.x.removeMessages(0);
      this.x.sendEmptyMessageDelayed(0, l1);
      return;
    }
    if (this.f != null)
    {
      localBaseVideoItemHolder = this.h;
      if ((localBaseVideoItemHolder != null) && (localBaseVideoItemHolder.aA != null))
      {
        if (this.f.k())
        {
          this.h.aA.k(false);
          return;
        }
        this.h.aA.e();
      }
    }
  }
  
  private void z()
  {
    if (this.S)
    {
      this.x.sendEmptyMessage(3);
      this.x.sendEmptyMessageDelayed(2, 50L);
    }
    this.d.b();
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
      localObject1 = VideoFeedsResourceLoader.a(2131626403, true, new ViewGroup.LayoutParams(-1, -1));
      paramViewGroup = (ShortVideoItemHolder)((View)localObject1).getTag();
      localObject2 = paramViewGroup;
      if (paramViewGroup == null) {
        localObject2 = new TiktokVideoItemHolder((View)localObject1);
      }
      localObject5 = new TiktokVideoItemDelegate((TiktokVideoItemHolder)localObject2, this.C, this);
      try
      {
        paramInt = LiuHaiUtils.e(this.e);
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
            if (((ShortVideoItemHolder)localObject2).aE != null)
            {
              paramViewGroup = (View)((ShortVideoItemHolder)localObject2).aE.getParent();
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
      localObject2 = VideoFeedsResourceLoader.a(2131626383, true, new ViewGroup.LayoutParams(-1, -1));
      localObject1 = (FooterItemHolder)((View)localObject2).getTag();
      paramViewGroup = (ViewGroup)localObject1;
      if (localObject1 == null) {
        paramViewGroup = new FooterItemHolder((View)localObject2, paramInt);
      }
      this.o = paramViewGroup;
      localObject2 = null;
      localObject1 = localObject2;
      localObject3 = paramViewGroup;
      paramViewGroup = (ViewGroup)localObject2;
      break;
    case 4: 
    case 5: 
    case 7: 
      paramViewGroup = LayoutInflater.from(this.F).inflate(2131626371, paramViewGroup, false);
      if (!this.ab) {
        ((LayoutInflater)localObject1).inflate(2131626414, (ViewGroup)paramViewGroup.findViewById(2131431139), true);
      }
      ((LayoutInflater)localObject1).inflate(2131626409, (ViewGroup)paramViewGroup.findViewById(2131431137), true);
      ((LayoutInflater)localObject1).inflate(2131626411, (ViewGroup)paramViewGroup.findViewById(2131431135), true);
      localObject1 = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createADVideoItemHolder(paramViewGroup, paramInt);
      paramViewGroup = (BaseVideoItemDelegate)((IRIJAdService)QRoute.api(IRIJAdService.class)).createADVideoItemDelegate(localObject1, this.C, this);
      localObject3 = localObject4;
      break;
    case 2: 
      localObject1 = VideoFeedsResourceLoader.a(2131626387, true, new ViewGroup.LayoutParams(-1, -1));
      paramViewGroup = (ShortVideoItemHolder)((View)localObject1).getTag();
      localObject2 = paramViewGroup;
      if (paramViewGroup == null) {
        localObject2 = new ShortVideoItemHolder((View)localObject1);
      }
      localObject5 = new ShortVideoItemDelegate((ShortVideoItemHolder)localObject2, this.C, this);
    }
    try
    {
      paramInt = LiuHaiUtils.e(this.e);
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
          if (((ShortVideoItemHolder)localObject2).aE != null)
          {
            paramViewGroup = (View)((ShortVideoItemHolder)localObject2).aE.getParent();
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
      ((BaseVideoItemHolder)localObject1).aA = paramViewGroup;
      ((BaseVideoItemHolder)localObject1).aB = new VideoFeedsVideoUIDelegate((BaseVideoItemHolder)localObject1, this.f, this.L);
      ((BaseVideoItemHolder)localObject1).aB.a(this.C);
      return localObject1;
    }
    return localObject3;
  }
  
  public void a()
  {
    int i1 = this.E.size();
    int i2 = this.d.getHeaderViewsCount();
    RecyclerView.ViewHolder localViewHolder = this.d.findViewHolderForLayoutPosition(i1 + i2 - 1);
    if ((localViewHolder instanceof FooterItemHolder)) {
      a((FooterItemHolder)localViewHolder);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    VideoFeedsLikeAnimateManager localVideoFeedsLikeAnimateManager = this.c;
    if (localVideoFeedsLikeAnimateManager != null) {
      localVideoFeedsLikeAnimateManager.a(paramFloat1, paramFloat2);
    }
  }
  
  public void a(int paramInt)
  {
    this.W = paramInt;
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    Handler localHandler = this.x;
    if (localHandler != null)
    {
      if (paramBoolean) {
        localHandler.removeMessages(paramInt);
      }
      this.x.sendEmptyMessageDelayed(paramInt, paramLong);
    }
  }
  
  public void a(long paramLong)
  {
    this.X = paramLong;
  }
  
  public void a(View paramView)
  {
    Object localObject = this.b;
    if ((localObject != null) && (((VideoFeedsCommentManager)localObject).k()) && (this.b.l()))
    {
      this.b.h();
      return;
    }
    if (!this.ah) {
      return;
    }
    paramView = (BaseVideoItemHolder)paramView.getTag();
    localObject = this.h;
    if (paramView != localObject)
    {
      if (localObject != null)
      {
        if ((paramView != null) && (paramView.Z == this.h.Z + 1) && (paramView.Z != getItemCount()))
        {
          this.d.b();
          return;
        }
        if ((paramView != null) && (paramView.Z == this.h.Z - 1)) {
          this.d.c();
        }
      }
      return;
    }
    paramView.aA.a();
    VideoFeedsHelper.a(paramView.ac, paramView.az.c, "click_contentid");
    VideoReport.reportEvent("clck", paramView.ac, null);
    int i1 = paramView.X;
    if (i1 != 2)
    {
      if ((i1 != 5) && (i1 != 7)) {
        return;
      }
      localObject = this.f;
      if ((localObject == null) || (!((VideoFeedsPlayManager)localObject).k())) {
        break label361;
      }
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("channel_id", 409409);
      PublicAccountReportUtils.a(null, null, "0X80091AB", "0X80091AB", 0, 0, "", "", "", VideoReporter.a(null, null, paramView.az.c.b, paramView.az.c.l, (JSONObject)localObject), false);
      return;
      localObject = this.f;
      if ((localObject != null) && (((VideoFeedsPlayManager)localObject).k())) {
        localObject = new JSONObject();
      }
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        ((JSONObject)localObject).put("channel_id", 409409);
        label312:
        PublicAccountReportUtils.a(null, null, "0X80091AB", "0X80091AB", 0, 0, "", "", "", VideoReporter.a(null, null, paramView.az.c.b, paramView.az.c.l, (JSONObject)localObject), false);
        label361:
        return;
        localJSONException1 = localJSONException1;
      }
      catch (JSONException localJSONException2)
      {
        break label312;
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
      if (paramView.af.getVisibility() == 0)
      {
        paramView.aA.a(2);
        if (this.f.i()) {
          this.af = true;
        }
      }
    }
    else if (this.af)
    {
      paramView.aA.a(1);
      this.af = false;
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    RIJUserLevelModule.getInstance().doActionsByUserLevel(this.e, 3, new VideoFeedsAdapter.7(this, paramView, paramInt1, paramInt2));
  }
  
  public void a(@Nullable View paramView, int paramInt, @Nullable Object paramObject)
  {
    INegativeHelper localINegativeHelper = this.u;
    if (localINegativeHelper != null) {
      localINegativeHelper.a(paramView, paramInt, paramObject);
    }
  }
  
  public void a(IADVideoAppDownloadManager paramIADVideoAppDownloadManager)
  {
    this.w.a(paramIADVideoAppDownloadManager);
  }
  
  public void a(IADVideoFeedsGuideManager paramIADVideoFeedsGuideManager)
  {
    this.H = paramIADVideoFeedsGuideManager;
  }
  
  public void a(IVideoAdExposureManager paramIVideoAdExposureManager)
  {
    this.aa = paramIVideoAdExposureManager;
  }
  
  public void a(VideoFeedsAdapter.AdapterEventListener paramAdapterEventListener)
  {
    this.a = paramAdapterEventListener;
  }
  
  public void a(VideoFeedsCommentManager paramVideoFeedsCommentManager)
  {
    this.b = paramVideoFeedsCommentManager;
  }
  
  public void a(VideoFeedsLikeAnimateManager paramVideoFeedsLikeAnimateManager)
  {
    this.c = paramVideoFeedsLikeAnimateManager;
  }
  
  public void a(VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    this.f = paramVideoFeedsPlayManager;
    C();
    this.f.a(this.R);
    this.f.a(new VideoFeedsAdapter.9(this));
  }
  
  public void a(VideoFeedsRecommendManager paramVideoFeedsRecommendManager)
  {
    this.Q = paramVideoFeedsRecommendManager;
  }
  
  public void a(TiktokVideoItemHolder paramTiktokVideoItemHolder)
  {
    Object localObject = paramTiktokVideoItemHolder.az;
    VideoPlayerWrapper localVideoPlayerWrapper = null;
    if (localObject != null) {
      localObject = paramTiktokVideoItemHolder.az.c;
    } else {
      localObject = null;
    }
    if (paramTiktokVideoItemHolder.az != null) {
      localVideoPlayerWrapper = (VideoPlayerWrapper)paramTiktokVideoItemHolder.az.h;
    }
    paramTiktokVideoItemHolder = new VideoR5.Builder((VideoInfo)localObject);
    long l2 = -1L;
    if (localVideoPlayerWrapper != null) {
      l1 = localVideoPlayerWrapper.C();
    } else {
      l1 = -1L;
    }
    paramTiktokVideoItemHolder = paramTiktokVideoItemHolder.a(l1);
    long l1 = l2;
    if (localVideoPlayerWrapper != null) {
      l1 = localVideoPlayerWrapper.I();
    }
    PublicAccountReportUtils.a(null, "", "0X800B28A", "0X800B28A", 0, 0, "3", "", "", paramTiktokVideoItemHolder.c(l1).b().a(), false);
  }
  
  public void a(RIJVideoRewardCoinManager paramRIJVideoRewardCoinManager)
  {
    this.ac = paramRIJVideoRewardCoinManager;
  }
  
  public void a(VideoColumnBannerManager paramVideoColumnBannerManager)
  {
    this.v = paramVideoColumnBannerManager;
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo instanceof VideoInfo)) {
      a(this.d, this.E, paramVideoInfo);
    }
  }
  
  public void a(@Nullable VideoInfo paramVideoInfo, @Nullable VideoItemHolder paramVideoItemHolder)
  {
    if ((paramVideoItemHolder instanceof ShortVideoItemHolder)) {
      this.v.b(paramVideoInfo, (ShortVideoItemHolder)paramVideoItemHolder);
    }
  }
  
  public void a(@Nullable VideoInfo paramVideoInfo, @Nullable Object paramObject)
  {
    Object localObject = this.h;
    if ((localObject instanceof VideoItemHolder)) {
      VideoFeedsHelper.a(((VideoItemHolder)localObject).aH, paramVideoInfo, "click_puin");
    }
    localObject = paramVideoInfo.l();
    if ((this.b != null) && (paramVideoInfo.e(this.e))) {
      this.b.h();
    }
    if (paramVideoInfo.aq)
    {
      if ((paramObject instanceof AdvertisementInfo))
      {
        paramObject = ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.e, (AdvertisementInfo)paramObject, null, 3, true, null);
        this.w.a(paramVideoInfo, 0, paramObject, false);
      }
    }
    else
    {
      if ((paramVideoInfo.ap != null) && (!paramVideoInfo.ap.equals("")))
      {
        ReadInJoyUtils.a(this.e, paramVideoInfo.ap);
        return;
      }
      paramObject = this.h;
      if (((paramObject instanceof ShortVideoItemHolder)) && (((ShortVideoItemHolder)paramObject).a.getVisibility() == 0) && (paramVideoInfo.aO != null) && (!TextUtils.isEmpty(paramVideoInfo.aO.g)))
      {
        ReadInJoyUtils.a(this.e, paramVideoInfo.aO.g);
        this.ad.b(paramVideoInfo, "0X800B17E");
      }
      else if (paramVideoInfo.ac)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feedsVideoFeedsAdapter", 2, "onClick: video unowned");
        }
      }
      else if (paramVideoInfo.a == 6)
      {
        if (!TextUtils.isEmpty(paramVideoInfo.q)) {
          a(paramVideoInfo, true);
        }
      }
      else if ((!TextUtils.isEmpty(paramVideoInfo.q)) && (!paramVideoInfo.q.equals("16888")))
      {
        a(paramVideoInfo, false);
      }
      paramObject = new VideoR5.Builder((String)localObject, paramVideoInfo.q, paramVideoInfo.b, paramVideoInfo.l, this.f.b(), paramVideoInfo.k() * 1000L).a(-1).M(0).b().a();
      localObject = paramVideoInfo.q;
      if (!TextUtils.isEmpty(paramVideoInfo.l)) {
        paramVideoInfo = paramVideoInfo.l;
      } else {
        paramVideoInfo = "0";
      }
      PublicAccountReportUtils.a(null, (String)localObject, "0X8007410", "0X8007410", 0, 0, "0", "", paramVideoInfo, paramObject, false);
    }
  }
  
  public void a(VideoInfo paramVideoInfo, String paramString)
  {
    this.ad.a(paramVideoInfo, paramString);
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramVideoInfo.q))
    {
      if (this.e == null) {
        return;
      }
      paramVideoInfo = VideoFeedsHelper.a(paramVideoInfo, paramBoolean, false);
      ReadInJoyUtils.a(this.e, paramVideoInfo);
    }
  }
  
  public void a(VideoFeedsRecyclerView paramVideoFeedsRecyclerView, List<VideoInfo> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((VideoInfo)paramList.next()).r();
      }
    }
    int i2 = paramVideoFeedsRecyclerView.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      paramList = paramVideoFeedsRecyclerView.getChildViewHolder(paramVideoFeedsRecyclerView.getChildAt(i1));
      if ((paramList instanceof VideoItemHolder)) {
        ((VideoItemHolder)paramList).aA.d();
      }
      i1 += 1;
    }
  }
  
  public void a(BaseItemHolder paramBaseItemHolder, int paramInt)
  {
    paramBaseItemHolder.Y = paramInt;
    paramBaseItemHolder.Z = paramInt;
    if ((paramInt >= 0) && (paramInt < this.E.size()))
    {
      Object localObject = this.aa;
      if (localObject != null)
      {
        localObject = ((IVideoAdExposureManager)localObject).i(paramInt);
        if (localObject != null) {
          this.E.set(paramInt, localObject);
        }
      }
      a(paramBaseItemHolder, (VideoInfo)this.E.get(paramInt));
      return;
    }
    a(paramBaseItemHolder, null);
  }
  
  public void a(BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo)
  {
    int i1 = paramBaseItemHolder.X;
    if ((i1 != 3) && (i1 != 6))
    {
      paramBaseItemHolder = (BaseVideoItemHolder)paramBaseItemHolder;
      d(paramBaseItemHolder);
      a(paramBaseItemHolder, paramVideoInfo);
      VideoFeedsDiversionHandler.a.a(paramBaseItemHolder);
      TraceCompat.beginSection("refreshMenuUI");
      paramBaseItemHolder.aA.b(paramVideoInfo);
      TraceCompat.endSection();
      TraceCompat.beginSection("refreshContentUI");
      paramBaseItemHolder.aA.a(paramVideoInfo, this.J);
      if (!TextUtils.isEmpty(paramVideoInfo.q)) {
        try
        {
          long l1 = Long.parseLong(paramVideoInfo.q);
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
      if ((this.S) && (paramBaseItemHolder == this.h)) {
        paramBaseItemHolder.aA.d(this.S);
      }
      c(paramBaseItemHolder);
      VideoReport.setElementExposePolicy(paramBaseItemHolder.itemView, ExposurePolicy.REPORT_FIRST);
      VideoReport.setElementEndExposePolicy(paramBaseItemHolder.itemView, EndExposurePolicy.REPORT_ALL);
      VideoReport.setElementId(paramBaseItemHolder.itemView, "card");
      VideoReport.setElementReuseIdentifier(paramBaseItemHolder.itemView, paramVideoInfo.l);
      VideoReport.setElementExposureMinRate(paramBaseItemHolder.itemView, 0.1D);
      return;
    }
    paramBaseItemHolder = (FooterItemHolder)paramBaseItemHolder;
    a(paramBaseItemHolder);
    this.o = paramBaseItemHolder;
  }
  
  public void a(BaseVideoItemHolder paramBaseVideoItemHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "adapter playVideo (VideoItemHolder holder) ");
    }
    this.x.removeMessages(2, null);
    this.f.a(ReportConstants.VideoEndType.SLIDE_LEAVE);
    BaseVideoItemHolder localBaseVideoItemHolder = this.h;
    int i1;
    if (localBaseVideoItemHolder != null) {
      i1 = localBaseVideoItemHolder.Z;
    } else {
      i1 = -1;
    }
    this.h = paramBaseVideoItemHolder;
    if ((this.h.Z == 0) && (this.h.Y == 0) && (this.h.az.j == 0L))
    {
      paramBaseVideoItemHolder.az.j = this.X;
      this.X = 0L;
    }
    if (!TextUtils.isEmpty(this.Y))
    {
      paramBaseVideoItemHolder.az.m = this.Y;
      paramBaseVideoItemHolder.az.n = true;
      this.Y = null;
    }
    else
    {
      paramBaseVideoItemHolder.az.m = null;
      paramBaseVideoItemHolder.az.n = false;
    }
    boolean bool;
    if ((this.M) && (!b(paramBaseVideoItemHolder))) {
      bool = false;
    } else {
      bool = true;
    }
    this.M = false;
    long l1 = System.currentTimeMillis();
    long l2 = this.N;
    paramBaseVideoItemHolder.az.g.putBoolean("is_auto_play", bool);
    if (bool)
    {
      if ((ReadInJoyHelper.n(this.B)) && (this.h.az.n) && (Build.VERSION.SDK_INT >= 16)) {
        a(paramBaseVideoItemHolder.az);
      } else {
        this.f.a(paramBaseVideoItemHolder.az, false);
      }
    }
    else {
      this.f.a(paramBaseVideoItemHolder.az);
    }
    a(paramBaseVideoItemHolder, bool, l1 - l2, i1);
    if (paramBaseVideoItemHolder.az.c != null) {
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).videoPlayRealtimeReport(paramBaseVideoItemHolder.az.c.l, paramBaseVideoItemHolder.az.c.b, 0, 0);
    }
  }
  
  public void a(VideoItemHolder paramVideoItemHolder, VideoInfo paramVideoInfo)
  {
    if (StudyModeManager.h()) {
      return;
    }
    if (paramVideoItemHolder.aE != null) {
      paramVideoItemHolder.aE.a();
    }
    if (paramVideoItemHolder.aF != null) {
      paramVideoItemHolder.aF.a();
    }
    if ((paramVideoInfo.az != null) || (paramVideoInfo.aA != null))
    {
      if ((paramVideoItemHolder.aE != null) && (paramVideoInfo.az != null) && ((paramVideoInfo.az.q == 1) || (paramVideoInfo.az.q == 2))) {
        paramVideoItemHolder.aE.setInfo(paramVideoInfo.az, paramVideoInfo.g, "VideoPlay_ContentMix");
      }
      if ((paramVideoItemHolder.aF != null) && (paramVideoInfo.aA != null) && ((paramVideoInfo.aA.q == 1) || (paramVideoInfo.aA.q == 2))) {
        paramVideoItemHolder.aF.setInfo(paramVideoInfo.aA, paramVideoInfo.g, "VideoPlay_Shooting");
      }
    }
  }
  
  public void a(String paramString)
  {
    this.Y = paramString;
  }
  
  public void a(List<VideoInfo> paramList)
  {
    this.E = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }
  
  public VideoInfo b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    VideoInfo localVideoInfo;
    do
    {
      Iterator localIterator = this.E.iterator();
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (VideoInfo)localIterator.next();
          if (paramString.equals(((VideoInfo)localObject).l)) {
            return localObject;
          }
        } while (((VideoInfo)localObject).aH == null);
        localObject = ((VideoInfo)localObject).aH.iterator();
      }
      localVideoInfo = (VideoInfo)((Iterator)localObject).next();
    } while (!paramString.equals(localVideoInfo.l));
    return localVideoInfo;
    return null;
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    this.I = false;
    Handler localHandler = this.x;
    if (localHandler != null) {
      localHandler.removeMessages(2, null);
    }
    ApngImage.pauseByTag(28);
    ApngImage.pauseByTag(29);
    ApngImage.pauseByTag(30);
    if (paramInt == 1) {
      ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).doOnVideoPause(this.e);
    }
  }
  
  public void b(View paramView) {}
  
  public void b(VideoInfo paramVideoInfo)
  {
    Object localObject1 = paramVideoInfo.q;
    boolean bool1 = paramVideoInfo.t;
    Object localObject2 = paramVideoInfo.B;
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
      localObject3 = this.G;
      if (localObject3 == null) {
        return;
      }
      VideoFeedsHelper.a((QQAppInterface)localObject3, (String)localObject1, bool1, (String)localObject2, false);
      localObject2 = this.E.iterator();
      bool1 = false;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (VideoInfo)((Iterator)localObject2).next();
        boolean bool2 = bool1 | b((VideoInfo)localObject3, (String)localObject1);
        bool1 = bool2;
        if (((VideoInfo)localObject3).aH != null)
        {
          localObject3 = ((VideoInfo)localObject3).aH.iterator();
          for (;;)
          {
            bool1 = bool2;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            bool2 |= b((VideoInfo)((Iterator)localObject3).next(), (String)localObject1);
          }
        }
      }
      if (bool1) {
        d((String)localObject1);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("followPubAccount() isDataChanged=");
        ((StringBuilder)localObject1).append(bool1);
        QLog.d("Q.pubaccount.video.feedsVideoFeedsAdapter", 2, ((StringBuilder)localObject1).toString());
      }
      ReadInJoyLogicEngine.a().q().a(409409L, paramVideoInfo.l, paramVideoInfo.q, 2);
      this.C.a(new RIJFeedsInsertAction(ActionType.ACTION_FOLLOW, 0, 0, 0));
    }
  }
  
  public void b(@Nullable VideoInfo paramVideoInfo, @Nullable VideoItemHolder paramVideoItemHolder)
  {
    if ((paramVideoItemHolder instanceof ShortVideoItemHolder)) {
      this.v.a(paramVideoInfo, (ShortVideoItemHolder)paramVideoItemHolder);
    }
  }
  
  void b(boolean paramBoolean)
  {
    this.J = paramBoolean;
  }
  
  public boolean b(BaseVideoItemHolder paramBaseVideoItemHolder)
  {
    Object localObject = paramBaseVideoItemHolder.aB;
    int i2 = 0;
    ((IVideoFeedsVideoUIDelegate)localObject).b(false);
    if ((paramBaseVideoItemHolder.Z == this.W) && (this.F != null) && (paramBaseVideoItemHolder.az != null) && (paramBaseVideoItemHolder.az.c != null))
    {
      localObject = this.e.getIntent().getExtras();
      int i3 = ((Bundle)localObject).getInt("VIDEO_FROM_TYPE", 0);
      if ((!(NetworkUtil.isMobileNetWork(this.F) ^ true)) && (!this.L)) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      QQAppInterface localQQAppInterface = this.G;
      if ((localQQAppInterface != null) && (localQQAppInterface.isVideoChatting())) {
        return false;
      }
      if (i3 == 27)
      {
        if (Aladdin.getConfig(271).getIntegerFromString("auto_play", 1) == 1)
        {
          paramBaseVideoItemHolder.aB.b(i1 ^ 0x1);
          return true;
        }
        paramBaseVideoItemHolder.aB.b(i1 ^ 0x1);
        return false;
      }
      if (i1 != 0)
      {
        paramBaseVideoItemHolder.aB.b(false);
        return true;
      }
      int i1 = ((Bundle)localObject).getInt("VIDEO_PLAY_STATUS", 0);
      boolean bool;
      if (((2 != i3) && (6 != i3) && (5 != i3)) || (3 != i1)) {
        bool = true;
      } else {
        bool = false;
      }
      paramBaseVideoItemHolder.aB.b(bool);
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
  
  public VideoInfo c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    VideoInfo localVideoInfo;
    do
    {
      Iterator localIterator = this.E.iterator();
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (VideoInfo)localIterator.next();
          if (paramString.equals(((VideoInfo)localObject).b)) {
            return localObject;
          }
        } while (((VideoInfo)localObject).aH == null);
        localObject = ((VideoInfo)localObject).aH.iterator();
      }
      localVideoInfo = (VideoInfo)((Iterator)localObject).next();
    } while (!paramString.equals(localVideoInfo.b));
    return localVideoInfo;
    return null;
  }
  
  public void c()
  {
    int i2 = this.d.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      localObject = this.d;
      localObject = ((VideoFeedsRecyclerView)localObject).getChildViewHolder(((VideoFeedsRecyclerView)localObject).getChildAt(i1));
      if ((localObject instanceof VideoItemHolder))
      {
        localObject = (VideoItemHolder)localObject;
        if (((VideoItemHolder)localObject).Z == this.h.Z + 1)
        {
          localObject = ((VideoItemHolder)localObject).az;
          if ((localObject != null) && ((((VideoPlayParam)localObject).i) || ((((VideoPlayParam)localObject).h != null) && (!((VideoPlayParam)localObject).h.i()))))
          {
            ((VideoPlayParam)localObject).i = false;
            this.f.c((VideoPlayParam)localObject);
          }
        }
      }
      i1 += 1;
    }
    Object localObject = this.R;
    if (localObject != null) {
      ((VideoPreDownloadMgr)localObject).d();
    }
  }
  
  public void c(int paramInt)
  {
    this.t = paramInt;
  }
  
  public void c(VideoInfo paramVideoInfo)
  {
    this.V = paramVideoInfo;
  }
  
  public void c(boolean paramBoolean)
  {
    this.K = paramBoolean;
  }
  
  public void d()
  {
    this.I = true;
    BaseVideoItemHolder localBaseVideoItemHolder = this.h;
    if ((localBaseVideoItemHolder != null) && (localBaseVideoItemHolder.aA != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).instanceOfADVideoItemDelegate(this.h.aA))) {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).doADVideoItemDelegateOnResume(this.h.aA);
    }
    ApngImage.playByTag(28);
    ApngImage.playByTag(29);
    ApngImage.playByTag(30);
    ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).doOnVideoResume();
  }
  
  public void d(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void d(VideoInfo paramVideoInfo)
  {
    List localList = this.E;
    if ((localList != null) && (localList.contains(paramVideoInfo)))
    {
      int i1 = this.E.indexOf(paramVideoInfo);
      w();
      this.E.remove(paramVideoInfo);
      this.h = null;
      notifyItemRemoved(i1);
    }
  }
  
  public void d(String paramString)
  {
    a(this.d, this.E, paramString);
  }
  
  public void d(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }
  
  public Drawable e(int paramInt)
  {
    Bitmap localBitmap;
    if (!this.O.containsKey(Integer.valueOf(paramInt)))
    {
      localBitmap = BitmapFactory.decodeResource(this.F.getResources(), paramInt);
      if (localBitmap == null) {
        return this.F.getResources().getDrawable(paramInt);
      }
      this.O.put(Integer.valueOf(paramInt), localBitmap);
    }
    else
    {
      localBitmap = (Bitmap)this.O.get(Integer.valueOf(paramInt));
    }
    return new BitmapDrawable(this.F.getResources(), localBitmap);
  }
  
  public void e()
  {
    this.ad.a();
    if (this.a != null) {
      this.a = null;
    }
    Object localObject = this.h;
    if (localObject != null) {
      ((BaseVideoItemHolder)localObject).ao = null;
    }
    this.x.removeCallbacksAndMessages(null);
    this.x = null;
    this.m = null;
    this.G = null;
    localObject = this.u;
    if (localObject != null) {
      ((INegativeHelper)localObject).b();
    }
    localObject = this.ag;
    if (localObject != null) {
      AppNetConnInfo.unregisterNetInfoHandler((INetInfoHandler)localObject);
    }
    localObject = this.g;
    if (localObject != null)
    {
      ((VideoBrightnessController)localObject).d();
      this.g = null;
    }
    ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).destroyFromVideoFeeds();
    DownloadManagerV2.a().b(VideoFeedsUGView.k);
    localObject = this.ae;
    if (localObject != null)
    {
      a(((VideoItemHolder)localObject).aE, false);
      a(this.ae.aF, false);
    }
  }
  
  public void e(VideoInfo paramVideoInfo)
  {
    this.ad.b(paramVideoInfo);
    BaseVideoItemHolder localBaseVideoItemHolder = this.h;
    if ((localBaseVideoItemHolder != null) && (localBaseVideoItemHolder.Y == 0) && (this.h.az.h != null)) {
      this.ad.a((VideoPlayerWrapper)this.h.az.h, paramVideoInfo.ao);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.L = paramBoolean;
  }
  
  public boolean e(@Nullable String paramString)
  {
    return this.w.a(paramString);
  }
  
  public void f()
  {
    Object localObject = this.m;
    if ((localObject != null) && (((PopupMenuDialog)localObject).isShowing())) {
      this.m.dismiss();
    }
    localObject = this.u;
    if (localObject != null) {
      ((INegativeHelper)localObject).a();
    }
  }
  
  void f(int paramInt)
  {
    this.P = paramInt;
  }
  
  public void f(boolean paramBoolean)
  {
    if ((!this.T) && (paramBoolean) && (this.U))
    {
      BaseVideoItemHolder localBaseVideoItemHolder = this.h;
      if ((localBaseVideoItemHolder instanceof VideoItemHolder)) {
        a((VideoItemHolder)localBaseVideoItemHolder);
      }
      this.U = false;
    }
    this.T = paramBoolean;
  }
  
  @Nullable
  public Object g()
  {
    return this.g;
  }
  
  public void g(boolean paramBoolean) {}
  
  public int getItemCount()
  {
    List localList = this.E;
    if (localList == null) {
      return 0;
    }
    return localList.size() + 1;
  }
  
  public long getItemId(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.E.size())) {
      return ((VideoInfo)this.E.get(paramInt)).hashCode();
    }
    FooterItemHolder localFooterItemHolder = this.o;
    int i1 = paramInt;
    if (localFooterItemHolder != null)
    {
      i1 = paramInt;
      if (localFooterItemHolder.itemView != null) {
        i1 = this.o.itemView.hashCode();
      }
    }
    return i1;
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = this.E;
    if ((localObject != null) && (paramInt >= 0) && (paramInt < ((List)localObject).size()))
    {
      localObject = (VideoInfo)this.E.get(paramInt);
      if (((VideoInfo)localObject).aq)
      {
        if (((VideoInfo)localObject).ar == 1) {
          return 7;
        }
      }
      else
      {
        if (this.ab) {
          return 8;
        }
        return 2;
      }
    }
    return 6;
  }
  
  @NotNull
  public ColorDrawable h()
  {
    return this.k;
  }
  
  public boolean i()
  {
    return this.i;
  }
  
  @Nullable
  public Activity j()
  {
    return this.e;
  }
  
  @Nullable
  public Object k()
  {
    return this.w;
  }
  
  public int l()
  {
    return this.t;
  }
  
  public int m()
  {
    return this.s;
  }
  
  @NotNull
  public Drawable n()
  {
    return this.j;
  }
  
  @Nullable
  public BaseVideoItemHolder o()
  {
    return this.h;
  }
  
  @TargetApi(11)
  public void onClick(View paramView)
  {
    BaseItemHolder localBaseItemHolder = (BaseItemHolder)paramView.getTag();
    Object localObject;
    if ((localBaseItemHolder instanceof VideoItemHolder))
    {
      VideoInfo localVideoInfo = ((VideoItemHolder)localBaseItemHolder).az.c;
      localObject = this.h;
      if ((localObject != null) && (((BaseVideoItemHolder)localObject).az != null))
      {
        localObject = localVideoInfo;
        if (localVideoInfo == this.h.az.c) {
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
    this.w.a(paramView, localBaseItemHolder, localObject, this.f);
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
      VideoInfo localVideoInfo = ((VideoItemHolder)localBaseItemHolder).az.c;
      localObject = this.h;
      if ((localObject != null) && (((BaseVideoItemHolder)localObject).az != null))
      {
        localObject = localVideoInfo;
        if (localVideoInfo == this.h.az.c) {}
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
    if (paramView.getId() != 2131433578) {
      return false;
    }
    a((VideoInfo)localObject, localBaseItemHolder, true);
    return true;
  }
  
  @Nullable
  public IVideoFeedsPlayManager p()
  {
    return this.f;
  }
  
  @Nullable
  public VideoFeedsRecyclerView q()
  {
    return this.d;
  }
  
  public boolean r()
  {
    return this.z;
  }
  
  public boolean s()
  {
    VideoFeedsCommentManager localVideoFeedsCommentManager = this.b;
    if (localVideoFeedsCommentManager != null) {
      return localVideoFeedsCommentManager.k();
    }
    return false;
  }
  
  public boolean t()
  {
    return this.r;
  }
  
  @NotNull
  public Drawable u()
  {
    return this.p;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsAdapter
 * JD-Core Version:    0.7.0.1
 */