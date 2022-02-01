package com.tencent.mobileqq.kandian.biz.framework.handlers;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.intervideo.now.dynamic.IDynamicNowManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdDownloadService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJSuperMaskService;
import com.tencent.mobileqq.kandian.ad.api.IRIJSurpriseVideoService;
import com.tencent.mobileqq.kandian.ad.api.entity.IADBaseAppDownloadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataFetchManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.ad.entity.IExposureSupplementManager;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyAnimUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListViewGroup;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyListViewGroup;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyView;
import com.tencent.mobileqq.kandian.biz.feeds.ReadInJoyArticleAdapter;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyChannelActivity;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyBaseViewController;
import com.tencent.mobileqq.kandian.biz.feeds.presenter.IReadInJoyPresenter;
import com.tencent.mobileqq.kandian.biz.feeds.presenter.ReadInJoyPresenterImpl;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.click.ListenerBuilder;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.pts.ReadInJoyModelImpl;
import com.tencent.mobileqq.kandian.biz.pts.data.Util;
import com.tencent.mobileqq.kandian.biz.pts.network.ReadInJoyPTSCostHelper;
import com.tencent.mobileqq.kandian.biz.pts.util.RIJComponentConfigImage;
import com.tencent.mobileqq.kandian.biz.share.VideoShareHelper;
import com.tencent.mobileqq.kandian.biz.video.NetInfoHandler;
import com.tencent.mobileqq.kandian.biz.video.PlayableItem;
import com.tencent.mobileqq.kandian.biz.video.RIJVideoOnScrollListener;
import com.tencent.mobileqq.kandian.biz.video.VideoAutoPlayController;
import com.tencent.mobileqq.kandian.biz.video.VideoBehaviorsReporter;
import com.tencent.mobileqq.kandian.biz.video.VideoUIManager;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.viewholder.BigImgVideoColumnItemViewHolder;
import com.tencent.mobileqq.kandian.biz.video.viewholder.BigImgVideoItemViewHolder;
import com.tencent.mobileqq.kandian.biz.video.viewholder.VideoColumnItemViewHolder;
import com.tencent.mobileqq.kandian.biz.video.viewholder.VideoFeedsTwoItemViewHolder;
import com.tencent.mobileqq.kandian.biz.video.viewholder.VideoFeedsViewHolder;
import com.tencent.mobileqq.kandian.biz.video.viewholder.VideoFeedsWithColumnViewHolder;
import com.tencent.mobileqq.kandian.biz.video.viewholder.ViewHolder;
import com.tencent.mobileqq.kandian.biz.video.viewholder.ViewHolder.VideoUIHandler;
import com.tencent.mobileqq.kandian.biz.video.viewholder.WeishiGridTwoItemViewHolder;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr;
import com.tencent.mobileqq.kandian.glue.video.VideoRecommendManager;
import com.tencent.mobileqq.kandian.glue.video.VideoResumeManager;
import com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl;
import com.tencent.mobileqq.kandian.glue.video.report.RIJVideoReportManager;
import com.tencent.mobileqq.kandian.glue.video.report.VideoPreloadReportData;
import com.tencent.mobileqq.kandian.glue.viola.event.ViolaEvent;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.ArticlePatchStatus;
import com.tencent.mobileqq.kandian.repo.feeds.RIJBaseItemViewType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoHandler
  extends BaseHandler
  implements Handler.Callback
{
  private static volatile boolean j = false;
  private long A;
  private VideoAutoPlayController B;
  private IADBaseAppDownloadManager C;
  protected boolean a = false;
  protected boolean b = false;
  protected VideoPlayManager c;
  protected VideoPreDownloadMgr d;
  protected VideoRecommendManager e;
  protected PlayableItem f = null;
  protected boolean g = false;
  protected boolean h = true;
  SimpleEventReceiver<ViolaEvent> i = new VideoHandler.11(this);
  private Context k;
  private boolean l;
  private ViewHolder.VideoUIHandler m;
  private Rect n = new Rect();
  private ListView o;
  private VideoShareHelper p;
  private AnimationSet q;
  private NetInfoHandler r;
  private boolean s = false;
  private Handler t;
  private TextView u;
  private LinearLayout v;
  private ViewStub w;
  private int x = 0;
  private int y = 0;
  private boolean z = true;
  
  private void T()
  {
    if (c() == 56)
    {
      VideoBehaviorsReporter.a().a(true);
      VideoBehaviorsReporter.a().a(0);
    }
    AppNetConnInfo.registerConnectionChangeReceiver(this.k, this.r);
    if ((i() instanceof ReadInJoyChannelActivity)) {
      this.g = i().getIntent().getBooleanExtra("is_need_show_animation_adapter", false);
    }
    if ((i() instanceof ReadInJoyChannelActivity)) {
      this.a = i().getIntent().getBooleanExtra("is_need_show_animation_translate", false);
    }
    this.q = ((AnimationSet)AnimationUtils.loadAnimation(this.k, 2130772157));
    if (!VideoFeedsHelper.f()) {
      this.q.setDuration(400L);
    }
    this.m.a.add(this);
    ListView localListView = this.o;
    if ((localListView instanceof ReadInJoyBaseListView)) {
      ((ReadInJoyBaseListView)localListView).a(new RIJVideoOnScrollListener(this));
    }
  }
  
  private VideoPlayParam U()
  {
    VideoPlayManager localVideoPlayManager = this.c;
    if (localVideoPlayManager != null) {
      return localVideoPlayManager.a();
    }
    return null;
  }
  
  private boolean V()
  {
    if (!RIJShowKanDianTabSp.b(f())) {
      return false;
    }
    if (!NetworkUtil.isNetworkAvailable(this.k)) {
      return false;
    }
    String str = RIJAppSetting.a(this.A);
    if ("2".equals(str)) {
      return false;
    }
    if ("0".equals(str)) {
      return true;
    }
    if ("1".equals(str)) {
      return NetworkUtil.isWifiConnected(this.k);
    }
    return false;
  }
  
  private boolean W()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = O();
    VideoPlayParam localVideoPlayParam = U();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localVideoPlayParam == null)
    {
      bool1 = bool2;
      if (localAbsBaseArticleInfo != null)
      {
        bool1 = bool2;
        if (f(0) != null)
        {
          bool1 = bool2;
          if (localAbsBaseArticleInfo.mArticleID == f(0).mArticleID) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private void X()
  {
    if (!NetworkUtil.isWifiConnected(this.k)) {
      try
      {
        Object localObject = this.c.a();
        long l1 = ((VideoPlayParam)localObject).j;
        localObject = f(((VideoPlayParam)localObject).e);
        if ((localObject != null) && (l1 != ((AbsBaseArticleInfo)localObject).mArticleID))
        {
          this.c.a(12);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("fixVideoPlayErrorState stopVideo videoVid:");
            localStringBuilder.append(((AbsBaseArticleInfo)localObject).getVideoVid());
            QLog.e("Q.readinjoy.video", 2, localStringBuilder.toString());
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("fixVideoPlayErrorState stopVideo throwable:");
          localStringBuilder.append(localThrowable.getMessage());
          QLog.e("Q.readinjoy.video", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  private void Y()
  {
    this.u = ((TextView)d().findViewById(2131441408));
    if (DailyModeConfigHandler.c(c()))
    {
      this.v = ((LinearLayout)d().findViewById(2131441407));
      return;
    }
    this.w = ((ViewStub)d().findViewById(2131441406));
  }
  
  private void Z()
  {
    this.B = VideoAutoPlayController.getInstance();
    this.B.setChannelFrom(this.A);
    if (c() == 56)
    {
      VideoReporter.b = VideoReporter.a(i().getIntent().getIntExtra("channel_from", -1));
      this.o.setContentBackground(new ColorDrawable(-1));
    }
    if (d().getViewController().j() != null)
    {
      g().a(d().getViewController().j(), this.B);
      return;
    }
    I();
  }
  
  public static PlayableItem a(View paramView)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof PlayableItem))) {
      return (PlayableItem)paramView.getTag();
    }
    return null;
  }
  
  public static AbsBaseArticleInfo a(VideoHandler paramVideoHandler, View paramView)
  {
    if ((paramVideoHandler != null) && (paramView != null))
    {
      if (!(paramView.getTag() instanceof PlayableItem)) {
        return null;
      }
      paramView = (PlayableItem)paramView.getTag();
      if (paramView != null) {
        return paramVideoHandler.f(paramView.b());
      }
    }
    return null;
  }
  
  public static void a(Context paramContext, ImageView paramImageView, VideoPlayParam paramVideoPlayParam)
  {
    if ((paramImageView != null) && (paramVideoPlayParam != null))
    {
      if (paramVideoPlayParam.h == null) {
        return;
      }
      paramContext = paramImageView.getLayoutParams();
      paramVideoPlayParam.h.getHeight();
      paramContext.height = paramVideoPlayParam.h.getHeight();
      paramImageView.setLayoutParams(paramContext);
    }
  }
  
  private void a(Intent paramIntent)
  {
    if ((c() == 0) && (!VideoResumeManager.a.a())) {
      return;
    }
    if (paramIntent == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onActivityResult for OPEN_FULLPLAY");
    }
    h().a().a(false);
    long l1 = paramIntent.getLongExtra("VIDEO_PLAY_POSITION", -1L);
    int i1 = paramIntent.getIntExtra("VIDEO_PLAY_STATUS", -1);
    if ((this.c.s()) && (this.c.r()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onActivityResult video is pause  && isPausedByMannul, just return");
      }
      return;
    }
    VideoPlayParam localVideoPlayParam = this.c.a();
    if (localVideoPlayParam == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onActivityResult getCurrentPlayVideoParam = null, just return");
      }
      return;
    }
    if (paramIntent.getExtras() != null) {
      paramIntent = paramIntent.getExtras().getString("VIDEO_ARTICLE_ID");
    } else {
      paramIntent = null;
    }
    if (!TextUtils.equals(localVideoPlayParam.y, paramIntent))
    {
      paramIntent = b(paramIntent);
      if (paramIntent == null)
      {
        l1 = localVideoPlayParam.k;
      }
      else
      {
        if (paramIntent.t != null) {
          paramIntent.t.k = l1;
        }
        bool = true;
        break label218;
      }
    }
    else
    {
      paramIntent = null;
    }
    boolean bool = false;
    label218:
    if (e(i1))
    {
      if (bool) {
        a(paramIntent);
      } else if ((l1 >= 0L) && (localVideoPlayParam != null)) {
        this.c.a((int)l1, localVideoPlayParam);
      } else {
        this.c.f(true);
      }
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("onActivityResult continue play, playResumeVideo:");
        paramIntent.append(bool);
        paramIntent.append(",startPosition:");
        paramIntent.append(l1);
        paramIntent.append(",curPlayParam:");
        paramIntent.append(localVideoPlayParam);
        QLog.d("Q.readinjoy.video", 2, paramIntent.toString());
      }
      VideoVolumeControl.getInstance().setMute(false, "readinoy video continuePlay", 1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onActivityResult stop play, should not continue play");
    }
    if (this.f != null)
    {
      long l2 = this.c.f();
      this.c.a(4);
      paramIntent = this.f.a();
      if (l1 > 0L) {
        l2 = l1;
      }
      paramIntent.k = l2;
      if (l1 > 0L) {
        this.f.a().p = -1;
      }
      this.f = null;
    }
  }
  
  private void a(View paramView, int paramInt)
  {
    if ((i() instanceof ReadInJoyChannelActivity))
    {
      if ((this.g) && (paramView != null) && (paramInt > 0) && (paramInt <= 2))
      {
        if ((paramInt == 1) && (this.h))
        {
          this.h = false;
          paramView.startAnimation(this.q);
        }
        else if (paramInt == 2)
        {
          if (this.g) {
            this.g = false;
          }
          paramView.startAnimation(this.q);
        }
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("adapter animation start at item position");
          paramView.append(paramInt);
          QLog.d("Q.readinjoy.videoanimation", 2, paramView.toString());
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.videoanimation", 2, " judge adapter animation show or not：");
      }
    }
  }
  
  private void a(ViewHolder paramViewHolder)
  {
    if (paramViewHolder != null)
    {
      if (this.m == null) {
        return;
      }
      if (paramViewHolder.c()) {
        paramViewHolder.a(this.m);
      }
    }
  }
  
  private void aa()
  {
    boolean bool = i().getIntent().getBooleanExtra("is_need_show_animation_translate", false);
    AbsBaseArticleInfo localAbsBaseArticleInfo = g().L();
    if ((bool) && ((i() instanceof ReadInJoyChannelActivity))) {
      if (this.z)
      {
        int i1 = RIJBaseItemViewType.c(localAbsBaseArticleInfo);
        if ((i1 != 6) && (i1 != 71))
        {
          if (i1 == 28)
          {
            i1 = ReadInJoyHelper.x(ReadInJoyUtils.b());
            ReadInJoyAnimUtils.a(ab(), localAbsBaseArticleInfo, i(), (ReadInJoyArticleAdapter)g(), c(), 0, i1);
            g(i1);
          }
        }
        else
        {
          this.y = i().getIntent().getIntExtra("view_translation_animation_left", 0);
          this.x = i().getIntent().getIntExtra("view_translation_animation_top", 0);
          ReadInJoyAnimUtils.a(ab(), localAbsBaseArticleInfo, i(), (ReadInJoyArticleAdapter)g(), c(), this.y, this.x);
          g(this.x);
        }
      }
      else
      {
        z();
      }
    }
    this.C = ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).createADBaseAppDownloadManager(i());
    g().b(this.C);
    ThreadManager.executeOnSubThread(new VideoHandler.7(this));
  }
  
  private LinearLayout ab()
  {
    if (DailyModeConfigHandler.c(c())) {
      return this.v;
    }
    if (this.v == null) {
      this.v = ((LinearLayout)this.w.inflate());
    }
    return this.v;
  }
  
  private void ac()
  {
    ThreadManager.executeOnSubThread(new VideoHandler.10(this));
  }
  
  private void ad()
  {
    boolean bool = d().getViewController().cQ_().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", false);
    if ((S()) && (!bool) && ((!RIJShowKanDianTabSp.c()) || ((d().getViewController().cQ_() instanceof ReadInJoyNewFeedsActivity))))
    {
      R();
      ae();
    }
    if (((!RIJShowKanDianTabSp.c()) || ((d().getViewController().cQ_() instanceof ReadInJoyNewFeedsActivity))) && (c() == 56)) {
      VideoReporter.b = VideoReporter.a(i().getIntent().getIntExtra("channel_from", -1));
    }
  }
  
  private void ae()
  {
    a().o();
  }
  
  private void af()
  {
    if (c() == 56) {
      ReadInJoyLogicEngine.a().a(56);
    }
  }
  
  public static void b(Context paramContext, ImageView paramImageView, VideoPlayParam paramVideoPlayParam)
  {
    if (paramImageView == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    localLayoutParams.width = ((int)RIJComponentConfigImage.a(paramContext, paramVideoPlayParam));
    paramImageView.setLayoutParams(localLayoutParams);
  }
  
  public static void b(View paramView)
  {
    if (paramView == null) {
      return;
    }
    View localView1 = null;
    if ((paramView.getTag() instanceof ViewHolder)) {
      localView1 = ((ViewHolder)paramView.getTag()).Q;
    }
    View localView2 = localView1;
    if (localView1 == null)
    {
      localView2 = localView1;
      if ((paramView.getTag(2131444340) instanceof ViewHolder)) {
        localView2 = ((ViewHolder)paramView.getTag(2131444340)).Q;
      }
    }
    if (localView2 == null) {
      return;
    }
    EventCollector.getInstance().onViewClicked(localView2);
  }
  
  private void b(VideoPlayParam paramVideoPlayParam1, VideoPlayParam paramVideoPlayParam2)
  {
    VideoPlayManager localVideoPlayManager = this.c;
    if (paramVideoPlayParam1 != paramVideoPlayParam2)
    {
      if (((paramVideoPlayParam1.D instanceof BaseArticleInfo)) && ((paramVideoPlayParam2.D instanceof BaseArticleInfo))) {
        ReadInJoyLogicEngine.a().a(c(), paramVideoPlayParam1.D, paramVideoPlayParam2.D);
      }
      this.o.clearFocus();
      this.o.postDelayed(new VideoHandler.4(this, paramVideoPlayParam1, localVideoPlayManager, paramVideoPlayParam2), 100L);
      return;
    }
    if (localVideoPlayManager.j() == 7) {
      a(paramVideoPlayParam1);
    }
  }
  
  private boolean b(PlayableItem paramPlayableItem)
  {
    return ((IRIJSurpriseVideoService)QRoute.api(IRIJSurpriseVideoService.class)).handleSearchResult(paramPlayableItem);
  }
  
  public static void c(View paramView)
  {
    if (paramView == null) {
      return;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  private void c(AbsListView paramAbsListView)
  {
    Object localObject1 = b(paramAbsListView);
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("playVideoInArea:");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("Q.readinjoy.video", 4, ((StringBuilder)localObject2).toString());
    }
    if (localObject1 != null)
    {
      paramAbsListView = ((PlayableItem)localObject1).a();
      localObject2 = this.c.a();
      if (paramAbsListView == this.c.b)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("error state not play");
          ((StringBuilder)localObject1).append(paramAbsListView.d);
          QLog.d("Q.readinjoy.video", 2, ((StringBuilder)localObject1).toString());
        }
        return;
      }
      if ((localObject2 == null) || (((VideoPlayParam)localObject2).j != paramAbsListView.j) || (((VideoPlayParam)localObject2).f != c()) || (this.c.s()) || (this.c.t()))
      {
        VideoVolumeControl.getInstance().startAudioPlay();
        a((PlayableItem)localObject1);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("checkPlayableArea vid: ");
          ((StringBuilder)localObject1).append(paramAbsListView.d);
          QLog.d("Q.readinjoy.video", 2, ((StringBuilder)localObject1).toString());
        }
      }
    }
    else
    {
      L();
      if (this.c.k() != null)
      {
        this.c.k().a(paramAbsListView);
        this.c.k().n();
      }
    }
  }
  
  private static boolean e(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 0) || (paramInt == 4);
  }
  
  private AbsBaseArticleInfo f(int paramInt)
  {
    return g().a(paramInt);
  }
  
  private void g(int paramInt)
  {
    ab().setLayerType(2, null);
    this.u.setLayerType(2, null);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.u, View.ALPHA, new float[] { 0.0F, 1.0F });
    localObjectAnimator1.addListener(new VideoHandler.8(this));
    localObjectAnimator1.setDuration(400L);
    localObjectAnimator1.setInterpolator(new LinearInterpolator());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(ab(), View.TRANSLATION_Y, new float[] { 0.0F, -paramInt });
    localObjectAnimator2.addListener(new VideoHandler.9(this));
    localObjectAnimator2.setDuration(400L);
    this.o.setAlpha(0.0F);
    localObjectAnimator2.start();
    this.u.setVisibility(0);
    localObjectAnimator1.start();
  }
  
  public VideoPlayManager A()
  {
    return this.c;
  }
  
  public PlayableItem B()
  {
    return this.f;
  }
  
  public VideoAutoPlayController C()
  {
    return this.B;
  }
  
  public VideoPreDownloadMgr D()
  {
    return this.d;
  }
  
  public VideoRecommendManager E()
  {
    return this.e;
  }
  
  public VideoShareHelper F()
  {
    return this.p;
  }
  
  public void G()
  {
    VideoAutoPlayController localVideoAutoPlayController = this.B;
    if (localVideoAutoPlayController != null) {
      localVideoAutoPlayController.setIsRefreshingList(false);
    }
  }
  
  public void H()
  {
    VideoPlayManager localVideoPlayManager = this.c;
    if (localVideoPlayManager != null)
    {
      localVideoPlayManager.a(new VideoHandler.2(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoHandler", 2, "mVideoPlayManager == null");
    }
  }
  
  public void I()
  {
    this.d = new VideoPreDownloadMgr(BaseApplicationImpl.getContext());
    VideoPreDownloadMgr localVideoPreDownloadMgr = this.d;
    int i1;
    if (c() == 56) {
      i1 = VideoPreloadReportData.b;
    } else {
      i1 = VideoPreloadReportData.a;
    }
    localVideoPreDownloadMgr.b = new VideoPreloadReportData(i1, VideoPreloadReportData.g);
    this.d.a(new VideoHandler.3(this));
  }
  
  public void J()
  {
    if ((h().a().s()) && (this.o != null))
    {
      this.d.b();
      int i2 = this.o.getFirstVisiblePosition();
      int i1 = i2;
      if (i2 >= t()) {
        i1 = 0;
      }
      this.d.a(i1);
      h().a().b(false);
    }
  }
  
  public void K()
  {
    VideoPreDownloadMgr localVideoPreDownloadMgr = this.d;
    if (localVideoPreDownloadMgr != null)
    {
      localVideoPreDownloadMgr.a();
      this.d = null;
    }
  }
  
  public void L()
  {
    this.c.a(9);
  }
  
  public void M()
  {
    VideoPlayManager localVideoPlayManager = this.c;
    if (localVideoPlayManager != null) {
      localVideoPlayManager.q();
    }
  }
  
  public void N()
  {
    this.m.removeMessages(1001);
  }
  
  public AbsBaseArticleInfo O()
  {
    return g().L();
  }
  
  public void P()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clearData ");
      ((StringBuilder)localObject).append(this.r);
      QLog.d("VideoHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.p;
    if (localObject != null) {
      ((VideoShareHelper)localObject).b();
    }
    localObject = this.t;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    AppNetConnInfo.unregisterNetInfoHandler(this.r);
  }
  
  public long Q()
  {
    VideoPlayManager localVideoPlayManager = this.c;
    if (localVideoPlayManager != null) {
      return localVideoPlayManager.f();
    }
    return 0L;
  }
  
  public void R()
  {
    VideoPlayManager localVideoPlayManager = d().getViewController().j();
    if ((localVideoPlayManager != null) && (localVideoPlayManager.a() != null)) {
      localVideoPlayManager.a(11);
    }
  }
  
  public boolean S()
  {
    return a().d();
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i1 = a(paramInt).intValue();
    Object localObject1;
    if ((paramView != null) && ((paramView.getTag() instanceof ViewHolder)))
    {
      localObject2 = (ViewHolder)paramView.getTag();
      ((ViewHolder)localObject2).P = paramInt;
      localObject1 = (IReadInJoyPresenter)paramView.getTag(2131449869);
      localObject3 = (ReadInJoyView)paramView.getTag(2131449873);
      paramViewGroup = paramView;
      paramView = (View)localObject3;
    }
    else
    {
      localObject2 = a(paramInt, paramView, paramViewGroup, i1);
      paramViewGroup = ((ViewHolder)localObject2).a(paramInt, paramViewGroup);
      ((ViewHolder)localObject2).Q = paramViewGroup;
      ((ViewHolder)localObject2).P = paramInt;
      paramViewGroup.setTag(localObject2);
      paramViewGroup.setTag(2131436721, w());
      localObject1 = new ReadInJoyPresenterImpl(i(), g().y().a(), v(), g(), g().B(), g().d());
      paramViewGroup.setTag(2131449869, localObject1);
      paramView = new ReadInJoyView(paramViewGroup);
      paramViewGroup.setTag(2131449873, paramView);
    }
    Object localObject3 = f(paramInt);
    ((ViewHolder)localObject2).a(g());
    if (localObject3 == null)
    {
      QLog.w("VideoHandler", 2, "article is null, return");
      return paramView.a();
    }
    long l1;
    if (i1 == 46)
    {
      l1 = System.currentTimeMillis();
      g().a((VideoFeedsTwoItemViewHolder)localObject2, (AbsBaseArticleInfo)localObject3);
      ReadInJoyPTSCostHelper.a("VideoHandler", String.valueOf(i1), "getProteusNormalView.configTwoItemVideo", System.currentTimeMillis() - l1);
    }
    else if (i1 == 4)
    {
      l1 = System.currentTimeMillis();
      g().a((VideoFeedsViewHolder)localObject2, (AbsBaseArticleInfo)localObject3, paramInt);
      ReadInJoyPTSCostHelper.a("VideoHandler", String.valueOf(i1), "getProteusNormalView.configVideoItemUI", System.currentTimeMillis() - l1);
      if ((g() != null) && (g().o() != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo((AbsBaseArticleInfo)localObject3)))
      {
        localObject2 = (AdvertisementInfo)localObject3;
        g().o().a(localObject2, g().a());
      }
    }
    else if (i1 == 70)
    {
      l1 = System.currentTimeMillis();
      g().a((WeishiGridTwoItemViewHolder)localObject2, (AbsBaseArticleInfo)localObject3, paramInt);
      ReadInJoyPTSCostHelper.a("VideoHandler", String.valueOf(i1), "getProteusNormalView.configWeishiGridTwoItemUI", System.currentTimeMillis() - l1);
    }
    else if (i1 == 118)
    {
      g().a((VideoColumnItemViewHolder)localObject2, (AbsBaseArticleInfo)localObject3, paramInt);
    }
    else if (i1 == 119)
    {
      g().a((VideoFeedsViewHolder)localObject2, (AbsBaseArticleInfo)localObject3, paramInt);
      localObject2 = (VideoFeedsWithColumnViewHolder)localObject2;
      ((VideoFeedsWithColumnViewHolder)localObject2).a(((AbsBaseArticleInfo)localObject3).mVideoColumnInfo);
      ((VideoFeedsWithColumnViewHolder)localObject2).a((AbsBaseArticleInfo)localObject3);
      ((VideoFeedsWithColumnViewHolder)localObject2).I.setTag(localObject2);
      ((VideoFeedsWithColumnViewHolder)localObject2).M.setTag(localObject2);
    }
    else if (i1 == 6)
    {
      g().a((BigImgVideoItemViewHolder)localObject2, (AbsBaseArticleInfo)localObject3, paramInt);
    }
    else if (i1 == 128)
    {
      g().a((BigImgVideoColumnItemViewHolder)localObject2, (AbsBaseArticleInfo)localObject3, paramInt);
    }
    Object localObject2 = null;
    if (paramInt < t() - 1) {
      localObject2 = f(paramInt + 1);
    }
    localObject2 = new ReadInJoyModelImpl(i(), (AbsBaseArticleInfo)localObject3, i1, c(), f(), paramInt, u(), t(), (AbsBaseArticleInfo)localObject2, g());
    paramViewGroup.setTag(2131449867, localObject2);
    ((IReadInJoyPresenter)localObject1).a(paramView, (IReadInJoyModel)localObject2, i1);
    return paramView.a();
  }
  
  public VideoFeedsViewHolder a(String paramString)
  {
    int i2 = this.o.getFirstVisiblePosition();
    this.o.getLastVisiblePosition();
    int i1 = Math.max(this.o.getHeaderViewsCount(), i2);
    for (;;)
    {
      int i3 = g().h().size();
      int i4 = this.o.getHeaderViewsCount();
      VideoFeedsViewHolder localVideoFeedsViewHolder = null;
      if (i1 >= i3 + i4) {
        break;
      }
      i3 = i1 - this.o.getHeaderViewsCount();
      AbsBaseArticleInfo localAbsBaseArticleInfo = f(i3);
      if ((4 == a(i3).intValue()) && (localAbsBaseArticleInfo != null) && (TextUtils.equals(localAbsBaseArticleInfo.getInnerUniqueID(), paramString)))
      {
        i1 -= i2;
        if ((i1 >= 0) && (i1 < this.o.getChildCount())) {
          paramString = this.o.getChildAt(i1);
        } else if ((i3 >= 0) && (i3 < g().h().size())) {
          paramString = a(i3, null, this.o);
        } else {
          paramString = null;
        }
        if (paramString != null) {
          localVideoFeedsViewHolder = (VideoFeedsViewHolder)paramString.getTag();
        }
        return localVideoFeedsViewHolder;
      }
      i1 += 1;
    }
    return null;
  }
  
  public ViewHolder a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    paramView = i();
    if (paramInt2 != 4)
    {
      if (paramInt2 != 6)
      {
        if (paramInt2 != 46)
        {
          if (paramInt2 != 70)
          {
            if (paramInt2 != 128)
            {
              if (paramInt2 != 118)
              {
                if (paramInt2 != 119) {
                  paramView = new VideoFeedsViewHolder(paramView, this);
                } else {
                  paramView = new VideoFeedsWithColumnViewHolder(paramView, this);
                }
              }
              else {
                paramView = new VideoColumnItemViewHolder(paramView, this);
              }
            }
            else {
              paramView = new BigImgVideoColumnItemViewHolder(paramView, this);
            }
          }
          else {
            paramView = new WeishiGridTwoItemViewHolder(paramView, this);
          }
        }
        else {
          paramView = new VideoFeedsTwoItemViewHolder(paramView, this);
        }
      }
      else {
        paramView = new BigImgVideoItemViewHolder(paramView, this);
      }
    }
    else {
      paramView = new VideoFeedsViewHolder(paramView, this);
    }
    a(paramView);
    return paramView;
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (this.c == null) {
      return;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "onActivityResult for REFRESH_EVENT_CHECK_PLAYAREA");
        }
        X();
        b(this.o, 50);
        QLog.d("gifvideo.VideoHandler", 2, "check shortcontent play");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "do nothing!");
      }
    }
    else
    {
      a(paramIntent);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    VideoPreDownloadMgr localVideoPreDownloadMgr;
    if (c() == 40677)
    {
      if (paramInt == 0)
      {
        localVideoPreDownloadMgr = this.d;
        if (localVideoPreDownloadMgr != null) {
          localVideoPreDownloadMgr.a(paramInt, paramBoolean);
        }
      }
    }
    else
    {
      localVideoPreDownloadMgr = this.d;
      if (localVideoPreDownloadMgr != null) {
        localVideoPreDownloadMgr.a(paramInt, paramBoolean);
      }
    }
  }
  
  public void a(View paramView1, View paramView2, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    super.a(paramView1, paramView2, paramAbsBaseArticleInfo, paramInt);
    a(paramView2, paramInt);
  }
  
  public void a(View paramView, ListView paramListView)
  {
    Y();
    Z();
    aa();
    ac();
    SimpleEventBus.getInstance().registerReceiver(this.i);
  }
  
  public void a(View paramView, ListView paramListView, long paramLong)
  {
    this.r = new NetInfoHandler(this);
    this.t = new Handler(Looper.getMainLooper());
    this.m = new ViewHolder.VideoUIHandler();
    this.l = ReadInJoyHelper.e();
    this.o = paramListView;
    this.k = i();
    this.p = new VideoShareHelper(i());
    T();
    this.A = paramLong;
    this.z = VideoFeedsHelper.f();
  }
  
  public void a(PlayableItem paramPlayableItem)
  {
    this.c.a(2);
    this.f = paramPlayableItem;
    h().a().a(this.f);
    this.c.a(paramPlayableItem.a());
  }
  
  public void a(VideoPlayParam paramVideoPlayParam)
  {
    this.m.postDelayed(new VideoHandler.5(this, paramVideoPlayParam), 1000L);
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, int paramInt)
  {
    if (this.f != null) {
      return;
    }
    Object localObject = a(paramVideoPlayParam.y);
    if (localObject != null)
    {
      this.f = ((PlayableItem)localObject);
      paramVideoPlayParam.h = ((VideoFeedsViewHolder)localObject).c;
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fixNowPlayHolder failed videoPlayParam:");
      ((StringBuilder)localObject).append(paramVideoPlayParam);
      ((StringBuilder)localObject).append("    callSource:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.e("VideoHandler", 2, ((StringBuilder)localObject).toString());
    }
    paramVideoPlayParam = this.c;
    if (paramVideoPlayParam != null)
    {
      if (paramVideoPlayParam.k() == null) {
        return;
      }
      paramVideoPlayParam = this.c.k();
      if (QLog.isColorLevel()) {
        QLog.i("VideoHandler", 2, "notifyVideoPositionChanged:");
      }
      paramVideoPlayParam.m();
    }
  }
  
  public void a(VideoPlayParam paramVideoPlayParam1, VideoPlayParam paramVideoPlayParam2)
  {
    ReadInJoyBaseListViewGroup localReadInJoyBaseListViewGroup = d();
    if ((localReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)localReadInJoyBaseListViewGroup).a(paramVideoPlayParam1, paramVideoPlayParam2);
    }
    if (this.A == 1002L)
    {
      int i1 = AIOUtils.b(44.5F, d().getResources());
      int i2 = d().getResources().getDimensionPixelOffset(2131299578);
      d().setPadding(0, i1 + i2, 0, 0);
    }
    b(paramVideoPlayParam1, paramVideoPlayParam2);
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo instanceof BaseArticleInfo)) {
      RIJVideoReportManager.a(paramVideoPlayParam, paramAbsBaseArticleInfo, h());
    }
  }
  
  public void a(VideoPlayManager paramVideoPlayManager, VideoAutoPlayController paramVideoAutoPlayController)
  {
    this.c = paramVideoPlayManager;
    this.B = paramVideoAutoPlayController;
    if (NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext())) {
      this.B.updateNetworkChange(true);
    } else {
      this.B.updateNetworkChange(false);
    }
    if ((this.c != null) && (!g().J()))
    {
      I();
      this.c.a(this.d);
      this.c.a(this.B);
      if (RIJShowKanDianTabSp.b(f())) {
        this.c.c(0);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    R();
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return (RIJFeedsType.a(f(paramInt1))) && (c() == 56) && (this.l) && (paramInt2 == 4);
  }
  
  public PlayableItem b(AbsListView paramAbsListView)
  {
    boolean bool = g().r();
    View localView = null;
    Object localObject2 = null;
    Object localObject1 = localView;
    if (bool)
    {
      localObject1 = localView;
      if (this.B != null)
      {
        if (paramAbsListView.getChildCount() <= 0) {
          return null;
        }
        int i1 = 0;
        while (i1 < paramAbsListView.getChildCount())
        {
          localView = paramAbsListView.getChildAt(i1);
          if (Util.a(localView)) {
            break;
          }
          if ((localView.getTag() instanceof PlayableItem))
          {
            localObject1 = (PlayableItem)localView.getTag();
            if (((PlayableItem)localObject1).a(localView))
            {
              paramAbsListView = (AbsListView)localObject1;
              break label118;
            }
          }
          i1 += 1;
        }
        paramAbsListView = null;
        label118:
        if (b(paramAbsListView)) {
          paramAbsListView = localObject2;
        }
        localObject1 = paramAbsListView;
        if (paramAbsListView == null)
        {
          localObject1 = paramAbsListView;
          if (QLog.isColorLevel())
          {
            QLog.w("Q.readinjoy.video", 2, "checkPlayableArea(): no item can auto play...");
            localObject1 = paramAbsListView;
          }
        }
      }
    }
    return localObject1;
  }
  
  public VideoFeedsViewHolder b(String paramString)
  {
    int i2 = this.o.getFirstVisiblePosition();
    int i3 = this.o.getLastVisiblePosition();
    int i1 = Math.max(this.o.getHeaderViewsCount(), i2);
    for (;;)
    {
      Object localObject1 = null;
      if (i1 > i3) {
        break;
      }
      int i4 = i1 - this.o.getHeaderViewsCount();
      Object localObject2 = f(i4);
      if ((localObject2 != null) && (4 == a(i4).intValue()) && (TextUtils.equals(((AbsBaseArticleInfo)localObject2).innerUniqueID, paramString)))
      {
        localObject2 = this.o.getChildAt(i1 - i2);
        paramString = localObject1;
        if (localObject2 != null) {
          paramString = (VideoFeedsViewHolder)((View)localObject2).getTag();
        }
        return paramString;
      }
      i1 += 1;
    }
    return null;
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    VideoPreDownloadMgr localVideoPreDownloadMgr = this.d;
    if (localVideoPreDownloadMgr != null) {
      localVideoPreDownloadMgr.a(paramInt, paramBoolean);
    }
  }
  
  public void b(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {
      return;
    }
    Object localObject = b(paramAbsListView);
    if (c() == 40677) {
      return;
    }
    VideoPlayManager localVideoPlayManager = this.c;
    if ((localVideoPlayManager != null) && (localVideoPlayManager.B())) {
      return;
    }
    if ((paramAbsListView.getFirstVisiblePosition() <= 5) && (!((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).isNormalMask()) && ((((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).getShowStatus() == 1) || (((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).getShowStatus() == 2))) {
      return;
    }
    if (localObject != null)
    {
      localObject = ((PlayableItem)localObject).a();
      if ((localObject != null) && (((VideoPlayParam)localObject).D != null) && (((VideoPlayParam)localObject).D.patchStatus.a.get() == 1)) {
        return;
      }
    }
    if ((this.c != null) && (this.B.canAutoPlayVideo()) && (!this.B.isRefreshingList()) && (paramAbsListView.getVisibility() == 0))
    {
      this.m.removeMessages(1001);
      this.m.sendEmptyMessageDelayed(1001, paramInt);
      if (QLog.isColorLevel())
      {
        paramAbsListView = new StringBuilder();
        paramAbsListView.append("checkPlayableArea delay: ");
        paramAbsListView.append(paramInt);
        QLog.d("Q.readinjoy.video", 2, paramAbsListView.toString());
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.c.a(9, paramBoolean);
  }
  
  public void c(AbsListView paramAbsListView, int paramInt)
  {
    if (c() != 0)
    {
      if (c() == 40677) {
        return;
      }
      if ((NetworkUtil.isNetworkAvailable(this.k)) && (this.c != null) && (paramAbsListView != null))
      {
        this.m.removeMessages(1001);
        this.m.sendEmptyMessageDelayed(1001, paramInt);
        if (QLog.isColorLevel())
        {
          paramAbsListView = new StringBuilder();
          paramAbsListView.append("force checkPlayableArea delay: ");
          paramAbsListView.append(paramInt);
          QLog.d("Q.readinjoy.video", 2, paramAbsListView.toString());
        }
      }
    }
  }
  
  public boolean d(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 46) || (paramInt == 70) || (paramInt == 118) || (paramInt == 119) || (paramInt == 6) || (paramInt == 128);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1001) {
      return false;
    }
    this.o.getGlobalVisibleRect(this.n);
    if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isVisibleRect(this.n)) {
      return false;
    }
    if (this.a)
    {
      if (this.b) {
        c(this.o);
      } else if (QLog.isColorLevel()) {
        QLog.w("VideoHandler", 2, "MSG_FOR_CHECK_PLAYAREA, 平移转场动画未做完，不触发自动播放");
      }
    }
    else {
      c(this.o);
    }
    return true;
  }
  
  public void j() {}
  
  public void k()
  {
    this.s = true;
    J();
    ad();
    af();
    this.t.postDelayed(new VideoHandler.1(this), 1000L);
  }
  
  public void l()
  {
    this.s = false;
    M();
    a().k();
  }
  
  public void m() {}
  
  public void n()
  {
    Object localObject = this.m;
    if (localObject != null)
    {
      ((ViewHolder.VideoUIHandler)localObject).removeCallbacksAndMessages(null);
      this.m.a.clear();
    }
    localObject = this.C;
    if (localObject != null) {
      ((IADBaseAppDownloadManager)localObject).a();
    }
    SimpleEventBus.getInstance().unRegisterReceiver(this.i);
  }
  
  public void o()
  {
    super.o();
    QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.a();
    if ((localQQAppInterface != null) && (!j))
    {
      j = true;
      ((IDynamicNowManager)localQQAppInterface.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER)).c();
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = this.m;
    if (paramView != null) {
      paramView.removeMessages(1001);
    }
  }
  
  public Boolean p()
  {
    if ((A() != null) && (A().k() != null) && (A().k().c()))
    {
      A().k().p();
      return Boolean.valueOf(true);
    }
    return super.p();
  }
  
  public void q() {}
  
  public void r()
  {
    super.r();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "notifyDataSetChanged");
    }
    Object localObject = this.c;
    if (localObject != null) {
      localObject = ((VideoPlayManager)localObject).a();
    } else {
      localObject = null;
    }
    if (((this.f != null) || (localObject != null)) && (this.d != null))
    {
      int i2 = -1;
      PlayableItem localPlayableItem = this.f;
      int i1 = i2;
      if (localPlayableItem != null)
      {
        i1 = i2;
        if (localPlayableItem.a() != null) {
          i1 = this.f.a().e;
        }
      }
      if (localObject != null) {
        i1 = ((VideoPlayParam)localObject).e;
      }
      this.d.a(i1, true);
    }
  }
  
  public int s()
  {
    return 0;
  }
  
  public boolean x()
  {
    return this.s;
  }
  
  public void y()
  {
    ReadInJoyBaseListViewGroup localReadInJoyBaseListViewGroup = d();
    if ((localReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)localReadInJoyBaseListViewGroup).cW_();
    }
    if (this.A == 1002L) {
      d().setPadding(0, 0, 0, 0);
    }
  }
  
  public void z()
  {
    this.b = true;
    if ((this.c != null) && ((W()) || (this.B.canAutoPlayVideo())) && (!this.B.isRefreshingList()))
    {
      ListView localListView = this.o;
      if ((localListView != null) && (localListView.getVisibility() == 0))
      {
        this.m.removeMessages(1001);
        this.m.sendEmptyMessage(1001);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "checkPlayableArea after transAnim: ");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler
 * JD-Core Version:    0.7.0.1
 */