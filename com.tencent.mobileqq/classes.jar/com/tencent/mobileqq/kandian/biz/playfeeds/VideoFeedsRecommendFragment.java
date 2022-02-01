package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.api.IPublicAccountArticleHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdDownloadService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdExposeFreshService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdSwitchService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJVideoAdService;
import com.tencent.mobileqq.kandian.ad.api.entity.IADVideoAppDownloadManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IADVideoFeedsGuideManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoAdExposureManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoAdStrategyReportManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoAdTimeLoadManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoAdVVAdloadStrategyManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoFeedsGameAdComManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoFeedsHardAdBarManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoFeedsSoftAdBarController;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.base.utils.TimeSliceHelper;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.view.widget.LifeCycleCallBack;
import com.tencent.mobileqq.kandian.base.view.widget.ListEventListener;
import com.tencent.mobileqq.kandian.base.view.widget.VideoFeedsAlphaMaskView;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasManager.AtlasCallbackImpl;
import com.tencent.mobileqq.kandian.biz.comment.entity.AnchorData;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.follow.popup.RIJFollowRecommendPopupCommand;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.ITKDHippyEventDispatcher;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.ITKDHippyEventReceiver;
import com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.ShortVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.TiktokVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskConfig;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskVideoTimer;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardVideoTipsManager;
import com.tencent.mobileqq.kandian.biz.reward.RIJVideoRewardCoinManager;
import com.tencent.mobileqq.kandian.biz.reward.RIJVideoRewardCoinManager.Callback;
import com.tencent.mobileqq.kandian.biz.video.VideoBehaviorsReporter;
import com.tencent.mobileqq.kandian.biz.video.VideoColumnBannerManager;
import com.tencent.mobileqq.kandian.biz.video.VideoColumnBannerManager.IVideoColumnBannerAction;
import com.tencent.mobileqq.kandian.biz.video.column.VideoColumnDataManager;
import com.tencent.mobileqq.kandian.biz.video.column.VideoColumnGuideManager;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsItemUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.kandian.glue.baseconfig.VideoConfig;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.video.VideoFullPlayController;
import com.tencent.mobileqq.kandian.glue.video.VideoVolumeController;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.glue.viola.event.ViolaEvent;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJSocialBottomViewAladdinConfig;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJVideoSingleModeConfigSp;
import com.tencent.mobileqq.kandian.repo.common.RIJLiveStatusModule;
import com.tencent.mobileqq.kandian.repo.feeds.ActionType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.follow.FollowListInfoModule;
import com.tencent.mobileqq.kandian.repo.follow.IFollowStatusObserver;
import com.tencent.mobileqq.kandian.repo.playfeeds.VideoPlayDianZanHandler;
import com.tencent.mobileqq.kandian.repo.playfeeds.VideoPlayDianZanObserver;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vip.CUKingCardUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class VideoFeedsRecommendFragment
  extends BaseFragment
  implements SimpleEventReceiver<ViolaEvent>, ListEventListener, VideoFeedsAdapter.AdapterEventListener, VideoFeedsRecommendManager.Listener, RIJVideoRewardCoinManager.Callback, VideoColumnBannerManager.IVideoColumnBannerAction
{
  private static int d;
  private int A = 5;
  private int B = 0;
  private long C;
  private String D;
  private long E = -1L;
  private long F = 0L;
  private boolean G = false;
  private boolean H = false;
  private boolean I = false;
  private boolean J = false;
  private boolean K = false;
  private boolean L = false;
  private boolean M = false;
  private boolean N = false;
  private boolean O = false;
  private boolean P = false;
  private boolean Q = true;
  private boolean R = false;
  private boolean S = false;
  private boolean T = true;
  private boolean U = false;
  private boolean V;
  private boolean W;
  private VideoFeedsRecommendPresenter X;
  private VideoFeedsPlayManager Y;
  private VideoFeedsRecommendManager Z;
  ViewGroup a;
  private IPublicAccountArticleObserver aA;
  private VideoPlayDianZanHandler aB;
  private VideoPlayDianZanObserver aC;
  private VideoFeedsRecommendFragment.FriendListObserver aD;
  private IVideoAdExposureManager aE;
  private IVideoAdTimeLoadManager aF;
  private IVideoAdStrategyReportManager aG;
  private IVideoAdVVAdloadStrategyManager aH;
  private VideoColumnDataManager aI;
  private RIJRewardTaskVideoTimer aJ;
  private VideoFeedsRecommendFragment.RIJObserver aK;
  private RIJLiveStatusModule aL;
  private VideoFeedsRecommendFragment.LiveStatusCallback aM;
  private boolean aN;
  private List<IFollowStatusObserver> aO = new ArrayList();
  private Handler aP = new Handler(Looper.getMainLooper());
  private final ITKDHippyEventReceiver aQ = new VideoFeedsRecommendFragment.5(this);
  private VideoFeedsCommentManager aa;
  private VideoFeedsInterruptedAdManager ab;
  private VideoFeedsShuntBarManager ac;
  private IVideoFeedsGameAdComManager ad;
  private IVideoFeedsSoftAdBarController ae;
  private IADVideoFeedsGuideManager af;
  private IADVideoAppDownloadManager ag;
  private VideoFeedsCommentManager.CommentEventListener ah;
  private VideoFeedsPlayManager.VideoStatusListener ai;
  private ReadInJoyAtlasManager.AtlasCallbackImpl aj;
  private LifeCycleCallBack ak;
  private VideoFeedsShareGuideController al;
  private VideoFeedsRecommendFragment.ScrollEventListenerImpl am;
  private VideoFullPlayController an;
  private VideoFeedsRecommendFragment.FullPlayCallbackImpl ao;
  private VideoFeedsLikeAnimateManager ap;
  private View.OnLayoutChangeListener aq;
  private VideoFeedsGuideProxy ar;
  private VideoColumnBannerManager as;
  private RIJRewardVideoTipsManager at;
  private RIJVideoRewardCoinManager au;
  private VideoPlayRecommendHandler av;
  private VideoFeedsRecommendFragment.PlayRecommendObserver aw;
  private VideoPlayCountHandler ax;
  private VideoPlayCountObserver ay;
  private IPublicAccountArticleHandler az;
  ImageView b;
  ImageView c;
  private ViewGroup e;
  private VideoFeedsRecyclerView f;
  private ViewGroup g;
  private VideoFeedsAdapter h;
  private LinearLayoutManager i;
  private QQAppInterface j;
  private Bundle k;
  private VideoItemHolder l;
  private ArrayList<VideoInfo> m = new ArrayList();
  private HashSet<VideoInfo> n = new HashSet();
  private HashSet<String> o;
  private VideoInfo p;
  private String q;
  private String r;
  private String s;
  private String t;
  private String u;
  private String v;
  private int w;
  private byte[] x;
  private int y = 0;
  private int z = 0;
  
  private void A()
  {
    this.av = ((VideoPlayRecommendHandler)this.j.getBusinessHandler(BusinessHandlerFactory.VIDEOPLAYRECOMMEND_HANDLER));
    this.av.a(this.w);
    this.Z = new VideoFeedsRecommendManager(this.j, getBaseActivity(), this.m, this.h, this.f);
    this.Z.a(this);
    this.Z.a(this.h);
    this.h.a(this.Z);
    this.X.a(this.Z);
    this.Y.a(this.Z);
    this.ax = ((VideoPlayCountHandler)this.j.getBusinessHandler(BusinessHandlerFactory.VIDEOPLAYCOUNT_HANDLER));
    this.ay = new VideoFeedsRecommendFragment.PlayCountObserver(this, null);
    this.aB = ((VideoPlayDianZanHandler)this.j.getBusinessHandler(BusinessHandlerFactory.PUBLIC_ACCOUNT_VIDEO_DIANZAN));
    this.aC = new VideoFeedsRecommendFragment.DianZanObserver(this, null);
    this.az = ((IPublicAccountArticleHandler)this.j.getBusinessHandler(BusinessHandlerFactory.PUBLIC_ACCOUNT_VIDEO_HANDLER));
    this.aA = ((IPublicAccountArticleObserver)QRoute.api(IPublicAccountArticleObserver.class));
    this.aA.setOnCallback(new VideoFeedsRecommendFragment.AricleObserver(this, null));
    this.aD = new VideoFeedsRecommendFragment.FriendListObserver(this, null);
    this.aK = new VideoFeedsRecommendFragment.RIJObserver(this, null);
    J();
    this.aF = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createVideoAdTimeLoadManager(this.h, this.m);
    this.aH = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createVideoAdVVAdloadStrategyManager(this.h, this.m, this.aF);
    this.aG = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createVideoAdStrategyReportManager();
    B();
    if (this.k.getBoolean("ARGS_HAS_EXTRA_VIDEO_DATAS", false)) {
      this.aw.a(true, this.k);
    }
    int i1 = this.k.getInt("ARGS_FIRST_INFO_POSITION", 0);
    if ((i1 > 0) && (i1 < this.m.size()))
    {
      this.h.a(i1);
      this.f.scrollToPosition(i1);
    }
    VideoInfo localVideoInfo = (VideoInfo)this.m.get(0);
    b(localVideoInfo);
    if ((localVideoInfo.t) && (TextUtils.isEmpty(localVideoInfo.r))) {
      localVideoInfo.r = ContactUtils.a(this.j, localVideoInfo.q, true);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localVideoInfo);
    a(localArrayList);
    this.aE = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createVideoAdExposureManager(this.h, this.m, this.f, this.aP);
    this.aE.a(this.T);
    this.h.a(this.aE);
    this.X.a(this.aE);
    this.aI = new VideoColumnDataManager(this.z);
    this.as = new VideoColumnBannerManager(getBaseActivity(), this.u, this.z, this.m, this.h, this.aI, this);
    this.h.a(this.as);
  }
  
  private void B()
  {
    if (!this.L)
    {
      F();
      IVideoAdTimeLoadManager localIVideoAdTimeLoadManager = this.aF;
      if (localIVideoAdTimeLoadManager != null)
      {
        ArrayList localArrayList = this.m;
        if (localArrayList != null) {
          localIVideoAdTimeLoadManager.a((VideoInfo)localArrayList.get(0));
        }
      }
    }
  }
  
  private void C()
  {
    if (this.T)
    {
      localObject = this.l;
      if ((localObject != null) && (((VideoItemHolder)localObject).az != null) && (this.l.az.c != null) && (this.l.az.c.n()) && (this.aE != null))
      {
        localObject = this.l.az.c;
        if ((((IRIJAdSwitchService)QRoute.api(IRIJAdSwitchService.class)).isNeedShowAnotherAd(((VideoInfo)localObject).as)) && (!this.aE.a(this.l.Z)))
        {
          localObject = this.aE.d(this.l.Z);
          if (localObject != null)
          {
            int i1 = this.l.getAdapterPosition() - 1;
            int i2 = this.l.Z;
            this.aE.a(i1, i2, (VideoInfo)localObject);
            ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).reportVideoFeeds(getBaseActivity(), 50, true);
            this.aP.postDelayed(new VideoFeedsRecommendFragment.2(this, i1 + 1), 0L);
            return;
          }
        }
        localObject = this.Y;
        if (localObject == null) {
          return;
        }
        ((VideoFeedsPlayManager)localObject).h();
        return;
      }
    }
    Object localObject = this.ai;
    if (localObject != null)
    {
      VideoItemHolder localVideoItemHolder = this.l;
      if (localVideoItemHolder != null) {
        ((VideoFeedsPlayManager.VideoStatusListener)localObject).d(localVideoItemHolder.az);
      }
    }
  }
  
  private void D()
  {
    if (this.L) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131913430));
    localStringBuilder.append(this.M);
    VideoFeedsPlayActivity.a(localStringBuilder.toString());
    if (this.M) {
      return;
    }
    F();
    this.h.f(1);
    this.h.a();
  }
  
  private void E()
  {
    long l2;
    QQAppInterface localQQAppInterface;
    long l1;
    if ((this.av != null) && (this.Z != null))
    {
      l2 = this.F;
      localQQAppInterface = this.j;
      l1 = l2;
      if (l2 == 0L)
      {
        l1 = l2;
        if (localQQAppInterface == null) {}
      }
    }
    try
    {
      l1 = Long.parseLong(localQQAppInterface.getCurrentAccountUin());
      this.av.a(this.Z.c(), l1, this.Z.b(), this.z, this.Z.a());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
  }
  
  private void F()
  {
    long l2;
    Object localObject1;
    long l1;
    if (this.av != null)
    {
      l2 = this.F;
      localObject1 = this.j;
      l1 = l2;
      if (l2 == 0L)
      {
        l1 = l2;
        if (localObject1 == null) {}
      }
    }
    try
    {
      l1 = Long.parseLong(((QQAppInterface)localObject1).getCurrentAccountUin());
      localObject1 = M();
      Object localObject2 = this.p;
      if (localObject2 != null)
      {
        if (((VideoInfo)localObject2).x > 0) {}
        for (i1 = this.p.x;; i1 = this.p.ay.b)
        {
          break label111;
          if (this.p.ay == null) {
            break;
          }
        }
      }
      int i1 = 0;
      label111:
      this.M = true;
      localObject2 = this.av;
      VideoFeedsRecommendFragment.PlayRecommendObserver localPlayRecommendObserver = this.aw;
      VideoInfo localVideoInfo = (VideoInfo)this.m.get(0);
      int i3 = this.z;
      ArrayList localArrayList1 = this.m;
      String str1 = ((VideoInfo)localArrayList1.get(0)).o;
      l2 = this.E;
      String str2 = this.r;
      String str3 = this.s;
      int i4 = this.y;
      byte[] arrayOfByte = this.x;
      ArrayList localArrayList2 = new ArrayList(this.n);
      Bundle localBundle = this.k;
      VideoItemHolder localVideoItemHolder = this.l;
      int i2;
      if (localVideoItemHolder == null) {
        i2 = 0;
      } else {
        i2 = localVideoItemHolder.Z;
      }
      ((VideoPlayRecommendHandler)localObject2).a(localPlayRecommendObserver, l1, localVideoInfo, i3, localArrayList1, str1, l2, true, i1, str2, str3, null, i4, (String)localObject1, arrayOfByte, 0, localArrayList2, localBundle, i2);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
  }
  
  private void G()
  {
    Object localObject = this.l;
    if ((localObject != null) && (((VideoItemHolder)localObject).az != null) && (this.l.az.c != null) && (VideoFeedsShareController.a(this.l.az.c.l)))
    {
      localObject = this.l.az.c;
      ((VideoInfo)localObject).aw += 1;
      this.h.a(this.l.az.c);
    }
  }
  
  private void H()
  {
    VideoFeedsGuideProxy localVideoFeedsGuideProxy = this.ar;
    if (localVideoFeedsGuideProxy != null) {
      localVideoFeedsGuideProxy.a();
    }
  }
  
  private void I()
  {
    VideoFeedsGuideProxy localVideoFeedsGuideProxy = this.ar;
    if (localVideoFeedsGuideProxy != null) {
      localVideoFeedsGuideProxy.a((VideoInfo)this.m.get(0));
    }
  }
  
  private void J()
  {
    if (this.aD != null) {
      getBaseActivity().addObserver(this.aD);
    }
    if (this.aw != null) {
      getBaseActivity().addObserver(this.aw);
    }
    if (this.ay != null) {
      getBaseActivity().addObserver(this.ay);
    }
    if (this.aA != null) {
      getBaseActivity().addObserver(this.aA.getBusinessObserver());
    }
    if (this.aC != null) {
      getBaseActivity().addObserver(this.aC);
    }
    if (this.aK != null) {
      ReadInJoyLogicEngineEventDispatcher.a().a(this.aK);
    }
  }
  
  private void K()
  {
    getBaseActivity().removeObserver(this.aD);
    getBaseActivity().removeObserver(this.aw);
    getBaseActivity().removeObserver(this.ay);
    getBaseActivity().removeObserver(this.aA.getBusinessObserver());
    getBaseActivity().removeObserver(this.aC);
    ReadInJoyLogicEngineEventDispatcher.a().b(this.aK);
    Object localObject = ReadInJoyLogicEngine.a().W();
    if (localObject != null)
    {
      Iterator localIterator = this.aO.iterator();
      while (localIterator.hasNext())
      {
        IFollowStatusObserver localIFollowStatusObserver = (IFollowStatusObserver)localIterator.next();
        if (localIFollowStatusObserver != null) {
          ((FollowListInfoModule)localObject).b(localIFollowStatusObserver);
        }
      }
    }
    this.aO.clear();
    localObject = this.aL;
    if (localObject != null) {
      ((RIJLiveStatusModule)localObject).b(this.aM);
    }
  }
  
  private void L()
  {
    Object localObject = this.aJ;
    if (localObject != null) {
      ((RIJRewardTaskVideoTimer)localObject).a();
    }
    localObject = this.X;
    if (localObject != null) {
      ((VideoFeedsRecommendPresenter)localObject).n();
    }
    VideoVolumeController.getInstance().requestOrAbandonAudioFocus(true, "videoFeeds doOnResume");
    localObject = this.Y;
    if ((localObject != null) && (!this.V) && (!this.W)) {
      ((VideoFeedsPlayManager)localObject).l();
    }
    localObject = this.ab;
    if ((localObject != null) && (((VideoFeedsInterruptedAdManager)localObject).a())) {
      this.ab.b();
    }
    localObject = this.h;
    if (localObject != null) {
      ((VideoFeedsAdapter)localObject).d();
    }
    localObject = this.af;
    if ((localObject != null) && (((IADVideoFeedsGuideManager)localObject).c()) && (this.af.i() != null))
    {
      localObject = this.h;
      if (localObject != null) {
        ((VideoFeedsAdapter)localObject).a(this.af.i());
      }
    }
    localObject = this.ag;
    if (localObject != null) {
      ((IADVideoAppDownloadManager)localObject).a();
    }
    localObject = this.ad;
    if (localObject != null) {
      ((IVideoFeedsGameAdComManager)localObject).s();
    }
    localObject = this.l;
    if ((localObject != null) && (((VideoItemHolder)localObject).az != null)) {
      a(this.l.az.c);
    }
    localObject = this.an;
    if (localObject != null) {
      ((VideoFullPlayController)localObject).a();
    }
    a(this.l, true);
    localObject = this.aF;
    if (localObject != null) {
      ((IVideoAdTimeLoadManager)localObject).c();
    }
    localObject = this.aH;
    if (localObject != null) {
      ((IVideoAdVVAdloadStrategyManager)localObject).a();
    }
    localObject = this.ae;
    if (localObject != null) {
      ((IVideoFeedsSoftAdBarController)localObject).a();
    }
    localObject = this.aG;
    if (localObject != null) {
      ((IVideoAdStrategyReportManager)localObject).d();
    }
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).instanceOfADVideoItemHolder(this.l)) {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).doADVideoItemHolderOnResume(this.l);
    }
  }
  
  private String M()
  {
    if (this.an != null)
    {
      VideoInfo localVideoInfo = this.p;
      if (localVideoInfo != null) {
        return VideoFeedsHelper.a(localVideoInfo.l, this.an.k(), this.k).toString();
      }
    }
    return null;
  }
  
  public static VideoFeedsRecommendFragment a(Bundle paramBundle, VideoInfo paramVideoInfo, String paramString1, String paramString2, String paramString3)
  {
    return a(paramBundle, paramVideoInfo, paramString1, paramString2, paramString3, false);
  }
  
  public static VideoFeedsRecommendFragment a(Bundle paramBundle, VideoInfo paramVideoInfo, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    return a(paramBundle, paramVideoInfo, paramString1, paramString2, paramString3, paramBoolean, 0);
  }
  
  public static VideoFeedsRecommendFragment a(Bundle paramBundle, VideoInfo paramVideoInfo, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("ARGS_SESSION_ID", paramString1);
    localBundle.putString("ARGS_VIDEO_CHANNEL_SESSION_ID", paramString3);
    localBundle.putParcelable("ARGS_REUQEST_VIDEO_INFO", paramVideoInfo);
    localBundle.putBoolean("ARGS_HAS_EXTRA_VIDEO_DATAS", paramBoolean);
    localBundle.putInt("ARGS_FIRST_INFO_POSITION", paramInt);
    localBundle.putString("ARGS_PAGE_SESSION_ID", paramString2);
    localBundle.putAll(paramBundle);
    paramBundle = new VideoFeedsRecommendFragment();
    paramBundle.setArguments(localBundle);
    return paramBundle;
  }
  
  private void a(float paramFloat)
  {
    VideoItemHolder localVideoItemHolder = this.l;
    if ((localVideoItemHolder instanceof TiktokVideoItemHolder))
    {
      TiktokVideoItemHolder localTiktokVideoItemHolder = (TiktokVideoItemHolder)localVideoItemHolder;
      ((TiktokVideoItemHolder)localVideoItemHolder).m.a(paramFloat, new VideoFeedsRecommendFragment.4(this, localTiktokVideoItemHolder));
    }
  }
  
  private void a(VideoInfo paramVideoInfo)
  {
    if (!TextUtils.isEmpty(paramVideoInfo.q))
    {
      if (paramVideoInfo.t) {
        return;
      }
      ThreadManager.post(new VideoFeedsRecommendFragment.CheckAccountFollowedRunnable(this, paramVideoInfo), 1, null, true);
    }
  }
  
  private void a(BaseItemHolder paramBaseItemHolder)
  {
    boolean bool2 = this.aa.k();
    boolean bool1 = false;
    if ((!bool2) && (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).instanceOfADVideoItemHolder(paramBaseItemHolder)) && ((paramBaseItemHolder instanceof BaseVideoItemHolder))) {
      bool1 = ((BaseVideoItemHolder)paramBaseItemHolder).az.c.a(getBaseActivity()) ^ true;
    }
    this.f.setNeedDetectOrientation(getBaseActivity(), bool1);
  }
  
  private void a(VideoItemHolder paramVideoItemHolder, boolean paramBoolean)
  {
    if ((paramVideoItemHolder != null) && (paramVideoItemHolder.az != null) && (paramVideoItemHolder.az.c != null))
    {
      if (paramBoolean)
      {
        TimeSliceHelper.c(paramVideoItemHolder.az.c.l);
        return;
      }
      TimeSliceHelper.d(paramVideoItemHolder.az.c.l);
    }
  }
  
  private void a(ViolaEvent paramViolaEvent)
  {
    if (a(paramViolaEvent.data.optString("rowkey"))) {
      return;
    }
    paramViolaEvent = paramViolaEvent.eventName;
    int i1 = -1;
    switch (paramViolaEvent.hashCode())
    {
    default: 
      break;
    case -355366270: 
      if (paramViolaEvent.equals("openCommentEditor")) {
        i1 = 0;
      }
      break;
    case -862628966: 
      if (paramViolaEvent.equals("onCommentEditorResume")) {
        i1 = 4;
      }
      break;
    case -999622423: 
      if (paramViolaEvent.equals("onCommentEditorPause")) {
        i1 = 2;
      }
      break;
    case -1011306261: 
      if (paramViolaEvent.equals("onCommentEditorClose")) {
        i1 = 1;
      }
      break;
    case -1774947655: 
      if (paramViolaEvent.equals("onCommentEditorWillClose")) {
        i1 = 3;
      }
      break;
    }
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 4) {
              return;
            }
            if (!this.V) {
              this.Y.l();
            }
          }
          else
          {
            this.W = true;
          }
        }
        else if (!this.W)
        {
          this.V = false;
          this.Y.m();
        }
      }
      else
      {
        this.V = false;
        this.W = false;
      }
    }
    else {
      this.V = true;
    }
  }
  
  private void a(List<VideoInfo> paramList)
  {
    try
    {
      paramList = c(paramList);
      this.aL.a(paramList);
      return;
    }
    catch (Exception paramList)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fetchLiveStatus error:");
      localStringBuilder.append(paramList);
      QLog.e("VideoFeedsRecommendFragment", 1, localStringBuilder.toString());
    }
  }
  
  private boolean a(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = true;
    if (bool1) {
      return true;
    }
    VideoItemHolder localVideoItemHolder = this.l;
    bool1 = bool2;
    if (localVideoItemHolder != null)
    {
      bool1 = bool2;
      if (localVideoItemHolder.az != null)
      {
        bool1 = bool2;
        if (this.l.az.c != null)
        {
          if (!TextUtils.equals(paramString, this.l.az.c.l)) {
            return true;
          }
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  private void b(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo.a != 0) && ((!TextUtils.isEmpty(paramVideoInfo.b)) || (!TextUtils.isEmpty(paramVideoInfo.l)))) {
      this.ax.a(paramVideoInfo.b, paramVideoInfo.l);
    }
    if ((RIJRewardTaskConfig.a()) && (!paramVideoInfo.aq))
    {
      ReadInJoyLogicEngine.a().j(paramVideoInfo.l);
      ReadInJoyLogicEngine.a().i(paramVideoInfo.l);
    }
  }
  
  private void b(ViolaEvent paramViolaEvent)
  {
    if ("RIJPlaySetupChangeNotification".equals(paramViolaEvent.eventName)) {}
    for (;;)
    {
      try
      {
        if (paramViolaEvent.data.getJSONObject("autoPlayChange").getBoolean("active")) {
          break label89;
        }
        bool = true;
        this.T = bool;
        this.Y.f(this.T);
        if (!this.T) {
          break label94;
        }
        i1 = 2;
        RIJSPUtils.a("SP_VIDEOFEEDS_LOOP_PLAYCONFIG", Integer.valueOf(i1));
        return;
      }
      catch (Exception paramViolaEvent)
      {
        QLog.e("VideoFeedsRecommendFragment", 1, "handle EVENT_PLAY_SETUP_CHANGE msg error.", paramViolaEvent);
      }
      return;
      label89:
      boolean bool = false;
      continue;
      label94:
      int i1 = 1;
    }
  }
  
  private void b(List<VideoInfo> paramList)
  {
    if (this.U)
    {
      QLog.w("VideoFeedsRecommendFragment", 1, "fetchFollowStatus cancel for activity is destroyed.");
      return;
    }
    VideoFeedsRecommendFragment.FollowStatusObserver localFollowStatusObserver = new VideoFeedsRecommendFragment.FollowStatusObserver(paramList);
    this.aO.add(localFollowStatusObserver);
    FollowListInfoModule.a(c(paramList), localFollowStatusObserver);
  }
  
  private List<Long> c(List<VideoInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = ((VideoInfo)paramList.next()).q;
      try
      {
        localArrayList.add(Long.valueOf(Long.parseLong(str)));
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("convert2LongList pass uin:");
        localStringBuilder.append(str);
        localStringBuilder.append(" for e:");
        localStringBuilder.append(localThrowable);
        QLog.e("VideoFeedsRecommendFragment", 1, localStringBuilder.toString());
      }
    }
    return localArrayList;
  }
  
  private void c(int paramInt)
  {
    if (this.f.getScrollState() != 0) {
      return;
    }
    Object localObject1 = null;
    Object localObject2 = (LinearLayoutManager)this.f.getLayoutManager();
    int i1 = ((LinearLayoutManager)localObject2).findFirstVisibleItemPosition();
    int i2 = ((LinearLayoutManager)localObject2).findLastVisibleItemPosition();
    while (i1 < i2)
    {
      localObject2 = this.f.getLayoutManager().findViewByPosition(i1);
      if (localObject2 == null)
      {
        localObject2 = localObject1;
      }
      else
      {
        Object localObject3 = this.f.getChildViewHolder((View)localObject2);
        if (i1 == paramInt) {
          localObject1 = localObject3;
        }
        if (localObject3 == null)
        {
          localObject2 = localObject1;
        }
        else
        {
          localObject2 = localObject1;
          if ((localObject3 instanceof BaseItemHolder))
          {
            localObject3 = ((BaseItemHolder)localObject3).W;
            localObject2 = localObject1;
            if (localObject3 != null)
            {
              ((VideoFeedsAlphaMaskView)localObject3).setAlpha(0.0F);
              localObject2 = localObject1;
            }
          }
        }
      }
      i1 += 1;
      localObject1 = localObject2;
    }
    localObject2 = this.Y;
    if ((localObject2 != null) && (!((VideoFeedsPlayManager)localObject2).k()) && (localObject1 != null))
    {
      this.f.a(localObject1);
      ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).recordVideoFeeds(getBaseActivity(), this.l);
      ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).recordVideoFeeds1px(getBaseActivity(), this.l);
      this.h.w.c();
      this.Y.h();
    }
  }
  
  private void d(int paramInt)
  {
    if ((this.S) && (paramInt == 1))
    {
      this.S = false;
      return;
    }
    a(this.l, false);
    VideoVolumeController.getInstance().requestOrAbandonAudioFocus(false, "videoFeeds doOnPause");
    Object localObject = this.h;
    if (localObject != null) {
      ((VideoFeedsAdapter)localObject).b(paramInt);
    }
    localObject = this.Y;
    if ((localObject != null) && (!this.V)) {
      ((VideoFeedsPlayManager)localObject).m();
    }
    localObject = this.ae;
    if (localObject != null) {
      ((IVideoFeedsSoftAdBarController)localObject).b();
    }
  }
  
  private void x()
  {
    this.k = getArguments();
    this.o = new HashSet();
    this.t = this.k.getString("ARGS_SESSION_ID");
    this.v = this.k.getString("ARGS_VIDEO_CHANNEL_SESSION_ID");
    this.u = this.k.getString("ARGS_PAGE_SESSION_ID");
    this.w = this.k.getInt("REPORT_VIDEO_FEEDS_CHANNEL_ID");
    Object localObject = this.k;
    boolean bool2 = false;
    this.K = ((Bundle)localObject).getBoolean("VIDEO_FROM_AIO", false);
    this.z = this.k.getInt("VIDEO_FROM_TYPE", -1);
    this.E = this.k.getLong("VIDEO_FROM_POLYMERIC_TOPIC_ID", -1L);
    this.F = this.k.getLong("VIDEO_FROM_POLYMERIC_PUIN", 0L);
    this.L = RIJVideoSingleModeConfigSp.a(this.z);
    this.C = this.k.getLong("VIDEO_PLAY_POSITION", 0L);
    this.D = this.k.getString("FIRST_VIDEO_TOKEN", "");
    this.N = this.k.getBoolean("VIDEO_SHOW_COMMENT", false);
    if ((this.k.getInt("VIDEO_FROM_TYPE", -1) != 2) && (this.k.getInt("VIDEO_FROM_TYPE", -1) != 3) && (this.k.getInt("VIDEO_FROM_TYPE", -1) != 6) && (this.k.getInt("VIDEO_FROM_TYPE", -1) != 7)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    this.P = bool1;
    boolean bool1 = this.P;
    this.Q = (bool1 ^ true);
    if ((this.C > 0L) && (bool1)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.R = bool1;
    this.H = this.k.getBoolean("KEY_IS_WEISHI_MODE", false);
    this.r = this.k.getString("VIDEO_COMMON_DATA");
    this.x = this.k.getByteArray("VIDEO_BUSINESS_INFO");
    if (((Integer)RIJSPUtils.b("SP_VIDEOFEEDS_LOOP_PLAYCONFIG", Integer.valueOf(2))).intValue() == 2) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.T = bool1;
    this.A = RIJAppSetting.b();
    this.B = VideoReporter.c();
    this.aL = ReadInJoyLogicEngine.a().s();
    this.aM = new VideoFeedsRecommendFragment.LiveStatusCallback(this, null);
    localObject = this.aL;
    if (localObject != null) {
      ((RIJLiveStatusModule)localObject).a(this.aM);
    }
    if (CUKingCardUtils.a() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.I = bool1;
    this.aj = new VideoFeedsRecommendFragment.FavoriteStatusCallback(this, null);
    if (d <= 0) {
      d = DisplayUtil.a(getBaseActivity(), 120.0F);
    }
    this.p = ((VideoInfo)this.k.getParcelable("ARGS_REUQEST_VIDEO_INFO"));
    localObject = new ArrayList();
    ((List)localObject).add(this.p);
    bool1 = bool2;
    if (this.m.size() > 1) {
      bool1 = true;
    }
    this.aw = new VideoFeedsRecommendFragment.PlayRecommendObserver(this, bool1);
    VideoFeedsRecommendFragment.PlayRecommendObserver.a(this.aw, (List)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initData() mVideoFromType = ");
      ((StringBuilder)localObject).append(this.z);
      QLog.d("VideoFeedsRecommendFragment", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initData() mBundle = ");
      ((StringBuilder)localObject).append(this.k.toString());
      QLog.d("VideoFeedsRecommendFragment", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initData() mVideoDataList[0] = ");
      ((StringBuilder)localObject).append(this.p.q());
      QLog.d("VideoFeedsRecommendFragment", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initData() needReloadTitle = ");
      ((StringBuilder)localObject).append(this.K);
      ((StringBuilder)localObject).append(", showSingleVideo = ");
      ((StringBuilder)localObject).append(this.L);
      ((StringBuilder)localObject).append(", mFirstVideoStartPosition = ");
      ((StringBuilder)localObject).append(this.C);
      ((StringBuilder)localObject).append(", mFirstVideoToken:");
      ((StringBuilder)localObject).append(this.D);
      QLog.d("VideoFeedsRecommendFragment", 2, ((StringBuilder)localObject).toString());
    }
    VideoConfig.a.b();
  }
  
  private void y()
  {
    try
    {
      if (VersionUtils.d()) {
        getBaseActivity().getWindow().setFlags(16777216, 16777216);
      }
      label22:
      this.f = ((VideoFeedsRecyclerView)this.e.findViewById(2131449704));
      VideoFeedsAccessibilityHelper.a.a(this.f);
      this.f.setScrollable(false);
      this.f.setExtraFooterCount(0);
      this.i = new VideoFeedsLayoutManager(getBaseActivity(), this.f, 1, false);
      this.f.setLayoutManager(this.i);
      this.ai = new VideoFeedsRecommendFragment.VideoStatusListenerImpl(this, null);
      this.Y = new VideoFeedsPlayManager(getBaseActivity().getApplicationContext(), this.j);
      this.Y.a(this.ai);
      this.Y.c(false);
      this.Y.f(this.T);
      this.Y.g(this.N);
      this.X = new VideoFeedsRecommendPresenter(getBaseActivity(), this.k, this.j, this.Y, this.f, this.T, this.m, this.z);
      this.af = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createADVideoFeedsGuideManager(getBaseActivity().getApplicationContext());
      this.af.a(new VideoFeedsRecommendFragment.1(this));
      this.ag = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createADVideoAppDownloadManager(getBaseActivity(), false);
      this.h = new VideoFeedsAdapter(getBaseActivity().getApplicationContext(), getBaseActivity(), this.k, this.f, this.i, this.j, this.H, this.z, this.X);
      this.h.f(getUserVisibleHint());
      this.h.b(this.K);
      Object localObject = this.h;
      int i1;
      if (this.L) {
        i1 = 3;
      } else {
        i1 = 1;
      }
      ((VideoFeedsAdapter)localObject).f(i1);
      this.h.a(this.m);
      this.h.a(this.Y);
      this.h.a(this.af);
      this.h.a(this.ag);
      this.h.a(this);
      this.h.c(this.Q);
      this.h.d(this.N);
      this.h.e(this.I);
      this.h.c((VideoInfo)this.m.get(0));
      this.h.a(this.C);
      this.h.a(this.D);
      this.am = new VideoFeedsRecommendFragment.ScrollEventListenerImpl(this, null);
      this.f.setAdapter(this.h);
      this.f.a(this.ak);
      this.f.a(this);
      this.f.addOnScrollListener(this.am);
      this.f.addOnItemTouchListener(this.am);
      this.ah = new VideoFeedsRecommendFragment.CommentEventListenerImpl(this, null);
      this.g = ((ViewGroup)this.e.findViewById(2131431115));
      this.aa = new VideoFeedsCommentManager(getBaseActivity(), getChildFragmentManager(), this.f, this.h, this.Y, this.g);
      this.aa.a((VideoInfo)this.m.get(0));
      this.aa.a(this.ah);
      this.aa.getTKDHippyEventDispatcher().register(this.aQ);
      if (this.N)
      {
        localObject = (AnchorData)this.k.getParcelable("VIDEO_COMMENT_ANCHOR");
        this.aa.a((AnchorData)localObject);
      }
      this.h.a(this.aa);
      this.k.getInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      this.ab = new VideoFeedsInterruptedAdManager(getBaseActivity(), this.j, this.ai, this.Y, this.h, this.H);
      this.ad = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createVideoFeedsGameAdComManager(this.j, getBaseActivity(), this.f);
      this.ae = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createVideoFeedsSoftAdBarController(this.j, getBaseActivity(), this.f);
      this.ae.a(this.m.get(0));
      this.ar = new VideoFeedsGuideProxy();
      localObject = new VideofeedsUserGuideController(getBaseActivity(), getBaseActivity().getAppRuntime(), this.e, true, this.N);
      this.ar.a((VideofeedsUserGuideController)localObject);
      this.ac = new VideoFeedsShuntBarManager(this.j, getBaseActivity(), this.h, (VideofeedsUserGuideController)localObject);
      this.ar.a(new VideoColumnGuideManager());
      this.au = new RIJVideoRewardCoinManager(getBaseActivity(), this);
      this.at = new RIJRewardVideoTipsManager(getBaseActivity(), this.au);
      this.h.a(this.au);
      z();
      if ((this.e instanceof FrameLayout))
      {
        this.ao = new VideoFeedsRecommendFragment.FullPlayCallbackImpl(this, null);
        this.an = new VideoFullPlayController(getBaseActivity(), (FrameLayout)this.e, this.ao);
        this.an.a(false);
        this.an.a(this.ao);
        this.an.a(this.ao);
      }
      this.ap = new VideoFeedsLikeAnimateManager(getBaseActivity(), 1);
      this.h.a(this.ap);
      this.aJ = new RIJRewardTaskVideoTimer();
      this.aJ.a(this.Y);
      if (!RIJSocialBottomViewAladdinConfig.b()) {
        this.al = new VideoFeedsShareGuideController(this.j, getBaseActivity(), this.X, null);
      }
      VideoVolumeController.getInstance().inKandianModule(getBaseActivity());
      VideoBehaviorsReporter.a().a(true);
      VideoBehaviorsReporter.a().a(2);
      return;
    }
    catch (Exception localException)
    {
      break label22;
    }
  }
  
  private void z()
  {
    this.a = ((ViewGroup)this.e.findViewById(2131438123));
    this.a.bringToFront();
    if (LiuHaiUtils.b())
    {
      int i1 = LiuHaiUtils.e(getBaseActivity());
      ViewGroup localViewGroup = this.a;
      localViewGroup.setPadding(localViewGroup.getPaddingLeft(), this.a.getPaddingTop() + i1, this.a.getPaddingRight(), this.a.getPaddingBottom());
    }
    this.b = ((ImageView)this.a.findViewById(2131445775));
    if ((!s()) && (getUserVisibleHint())) {
      this.b.setVisibility(0);
    }
    this.c = ((ImageView)this.a.findViewById(2131438109));
    if (this.k.getBoolean("VIDEO_SHOW_COMMENT", false)) {
      a(false);
    }
  }
  
  public void a()
  {
    D();
  }
  
  public void a(int paramInt)
  {
    if ((paramInt != 9) && (paramInt != 10) && (paramInt != 12)) {
      return;
    }
    G();
  }
  
  public void a(long paramLong)
  {
    Object localObject1 = this.l;
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = (VideoPlayerWrapper)((VideoItemHolder)localObject1).az.h;
    localObject1 = this.l.az.c;
    long l1;
    if (localObject2 != null) {
      l1 = ((VideoPlayerWrapper)localObject2).I();
    } else {
      l1 = 0L;
    }
    double d1;
    VideoItemHolder localVideoItemHolder;
    if (!this.J)
    {
      localObject3 = this.ab;
      if (localObject3 != null)
      {
        d1 = paramLong;
        Double.isNaN(d1);
        ((VideoFeedsInterruptedAdManager)localObject3).a((int)(d1 / 1000.0D));
      }
      localObject3 = this.ac;
      if (localObject3 != null)
      {
        localVideoItemHolder = this.l;
        d1 = paramLong;
        Double.isNaN(d1);
        int i1 = (int)(d1 / 1000.0D);
        d1 = l1;
        Double.isNaN(d1);
        ((VideoFeedsShuntBarManager)localObject3).a((VideoInfo)localObject1, localVideoItemHolder, i1, (int)(d1 / 1000.0D));
      }
      localObject3 = this.ar;
      if (localObject3 != null) {
        ((VideoFeedsGuideProxy)localObject3).a(this.l.az, paramLong, this.e, this.f);
      }
      this.as.a(this.l, paramLong, l1);
      localObject3 = this.al;
      if (localObject3 != null) {
        ((VideoFeedsShareGuideController)localObject3).a(paramLong, l1);
      }
    }
    Object localObject3 = this.ad;
    if (localObject3 != null) {
      ((IVideoFeedsGameAdComManager)localObject3).a(this.l, this.J);
    }
    localObject3 = this.ae;
    double d2;
    if (localObject3 != null)
    {
      localVideoItemHolder = this.l;
      boolean bool = this.J;
      d1 = paramLong;
      Double.isNaN(d1);
      d2 = l1;
      Double.isNaN(d2);
      ((IVideoFeedsSoftAdBarController)localObject3).a(localVideoItemHolder, bool, d1 * 100.0D / d2, l1);
    }
    localObject3 = this.Z;
    if ((localObject3 != null) && (localObject2 != null)) {
      ((VideoFeedsRecommendManager)localObject3).a(((VideoPlayerWrapper)localObject2).d(false));
    }
    localObject2 = this.at;
    if (localObject2 != null) {
      ((RIJRewardVideoTipsManager)localObject2).a(paramLong, l1, this.aa.k());
    }
    if ((this.l.az.c.aq) && (this.aE != null))
    {
      if ((((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).isNotVVStrategy()) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).isNotMixStrategy())) {
        return;
      }
      localObject1 = ((VideoInfo)localObject1).as;
      if ((((IRIJAdSwitchService)QRoute.api(IRIJAdSwitchService.class)).isNeedShowAnotherAd((VideoAdInfo)localObject1)) && (((IRIJAdSwitchService)QRoute.api(IRIJAdSwitchService.class)).isShowAdGuide((VideoAdInfo)localObject1)))
      {
        d1 = paramLong;
        d2 = l1;
        Double.isNaN(d2);
        if (d1 >= 0.8D * d2)
        {
          ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VIDEO_LINK", "fetchAnotherAd : 同时满足 出结束引导和循环展示  80%");
          this.aE.a((VideoAdInfo)localObject1, this.l.Z);
        }
        else
        {
          Double.isNaN(d2);
          if (d1 >= d2 * 0.5D)
          {
            ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VIDEO_LINK", "refreshFetchAnotherAdFlag : 同时满足 出结束引导和循环展示  50%");
            this.aE.c(this.l.Z);
          }
        }
      }
    }
    a((float)paramLong / (float)l1);
    this.X.a(paramLong, l1);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsRecommendFragment", 2, "onCenterViewChanged: ");
    }
    if ((paramViewHolder instanceof BaseItemHolder)) {
      a((BaseItemHolder)paramViewHolder);
    }
    if ((paramViewHolder instanceof VideoItemHolder))
    {
      Object localObject = this.ac;
      if (localObject != null) {
        ((VideoFeedsShuntBarManager)localObject).a(this.l);
      }
      localObject = this.ad;
      if (localObject != null) {
        ((IVideoFeedsGameAdComManager)localObject).a((VideoItemHolder)paramViewHolder);
      }
      localObject = this.ae;
      if (localObject != null) {
        ((IVideoFeedsSoftAdBarController)localObject).a(this.l, (VideoItemHolder)paramViewHolder);
      }
      localObject = this.af;
      VideoItemHolder localVideoItemHolder = (VideoItemHolder)paramViewHolder;
      ((IADVideoFeedsGuideManager)localObject).a(localVideoItemHolder);
      this.ag.a(localVideoItemHolder);
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).instanceOfADVideoItemHolder(paramViewHolder)) {
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).doADVideoItemHolderOnResume(localVideoItemHolder);
      }
      a(this.l, false);
      this.l = localVideoItemHolder;
      a(this.l, true);
      localObject = this.ab;
      if (localObject != null)
      {
        localVideoItemHolder = this.l;
        if ((localVideoItemHolder instanceof ShortVideoItemHolder)) {
          ((VideoFeedsInterruptedAdManager)localObject).a((ShortVideoItemHolder)localVideoItemHolder, VideoFeedsRecommendFragment.ScrollEventListenerImpl.a(this.am));
        }
      }
      if (this.l.Z > 0)
      {
        localObject = this.ar;
        if (localObject != null) {
          ((VideoFeedsGuideProxy)localObject).b(false);
        }
        H();
      }
      if (this.l.Z < this.m.size() - 1) {
        b((VideoInfo)this.m.get(this.l.Z + 1));
      }
      if ((this.l.az != null) && (this.l.az.c != null))
      {
        localObject = this.l.az.c;
        VideoFeedsAccessibilityHelper.a.a(this.l.aa, ((VideoInfo)localObject).k() * 1000);
        this.n.add(localObject);
      }
      this.as.a(this.l);
      this.aI.a(this.l);
      localObject = this.at;
      if (localObject != null)
      {
        localVideoItemHolder = this.l;
        if ((localVideoItemHolder instanceof ShortVideoItemHolder)) {
          ((RIJRewardVideoTipsManager)localObject).a((ShortVideoItemHolder)localVideoItemHolder);
        }
      }
      localObject = this.al;
      if (localObject != null) {
        ((VideoFeedsShareGuideController)localObject).a(this.l);
      }
    }
    SimpleEventBus.getInstance().dispatchEvent(new RIJFollowRecommendPopupCommand(1, null));
    if (this.ak != null)
    {
      boolean bool = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).instanceOfADVideoItemHolder(paramViewHolder);
      this.ak.b(bool);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    this.J = paramBoolean;
    paramViewHolder = this.ar;
    if (paramViewHolder != null) {
      paramViewHolder.a(paramBoolean);
    }
    paramViewHolder = this.at;
    if (paramViewHolder != null) {
      paramViewHolder.a(this.J);
    }
    if (paramBoolean)
    {
      this.a.setVisibility(8);
      H();
      paramViewHolder = this.Y;
      if (paramViewHolder != null) {
        paramViewHolder = paramViewHolder.e();
      } else {
        paramViewHolder = null;
      }
      if (paramViewHolder != null)
      {
        String str1 = new VideoR5.Builder(paramViewHolder.l(), paramViewHolder.q, paramViewHolder.b, paramViewHolder.l, this.Y.b(), paramViewHolder.k() * 1000L).a(409409).b().a();
        String str2 = paramViewHolder.q;
        if (!TextUtils.isEmpty(paramViewHolder.l)) {
          paramViewHolder = paramViewHolder.l;
        } else {
          paramViewHolder = "0";
        }
        PublicAccountReportUtils.a(null, str2, "0X8007411", "0X8007411", 0, 0, "0", "", paramViewHolder, str1, false);
      }
      paramViewHolder = this.Y;
      if (paramViewHolder != null) {
        paramViewHolder.f(false);
      }
      paramViewHolder = this.l;
      if ((paramViewHolder instanceof BaseVideoItemHolder)) {
        this.an.a(this.ao.a(paramViewHolder.az.c), 0);
      }
    }
    else
    {
      this.a.setVisibility(0);
      paramViewHolder = this.Y;
      if (paramViewHolder != null) {
        paramViewHolder.f(this.T);
      }
      paramViewHolder = this.an;
      if (paramViewHolder != null)
      {
        paramBoolean = paramViewHolder.f();
        this.an.c();
        this.an.e();
        this.ao.a(paramBoolean);
      }
    }
    SimpleEventBus.getInstance().dispatchEvent(new RIJFollowRecommendPopupCommand(1, null));
  }
  
  public void a(LifeCycleCallBack paramLifeCycleCallBack)
  {
    this.ak = paramLifeCycleCallBack;
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    VideoPlayDianZanHandler localVideoPlayDianZanHandler = this.aB;
    if (localVideoPlayDianZanHandler != null) {
      localVideoPlayDianZanHandler.a(paramVideoInfo, paramBoolean);
    }
    this.X.a(new RIJFeedsInsertAction(ActionType.ACTION_LOVE, 0, 0, 0));
  }
  
  public void a(VideoItemHolder paramVideoItemHolder) {}
  
  public void a(RIJFeedsInsertAction paramRIJFeedsInsertAction)
  {
    this.X.a(paramRIJFeedsInsertAction);
  }
  
  public void a(@NotNull String paramString, int paramInt)
  {
    if (getBaseActivity() != null) {
      QQToast.makeText(getBaseActivity(), paramString, 0).show();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ImageView localImageView;
    if (paramBoolean)
    {
      localImageView = this.b;
      if (localImageView != null) {
        localImageView.setVisibility(0);
      }
    }
    else
    {
      localImageView = this.b;
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      this.Y.g(true);
      this.f.setNeedDetectOrientation(getBaseActivity(), false);
      return;
    }
    this.Y.g(false);
    a(this.l);
  }
  
  public void a(boolean paramBoolean, @NotNull String paramString, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      paramString = n();
      if (paramString != null)
      {
        paramString.af = true;
        this.h.a(paramString);
        ReadInJoyLogicEngine.a().j(paramString.l);
        if (!this.J) {
          this.at.a(paramInt1);
        }
      }
    }
    else if (getBaseActivity() != null)
    {
      QQToast.makeText(getBaseActivity(), paramString, 0).show();
    }
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt != 24) && (paramInt != 25)) {
      return false;
    }
    if ((this.l != null) && (!this.J) && (VideoVolumeController.getInstance().isBizFocusing()))
    {
      if (paramInt == 25) {
        paramInt = -1;
      } else {
        paramInt = 1;
      }
      VideoVolumeController.getInstance().adjustMediaVolume(paramInt);
      this.l.aA.a(VideoVolumeController.getInstance().getMediaVolumeProgress());
      return true;
    }
    return false;
  }
  
  public void b()
  {
    E();
  }
  
  public void b(int paramInt)
  {
    this.y = paramInt;
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void b(boolean paramBoolean)
  {
    this.S = paramBoolean;
  }
  
  public void c() {}
  
  public void d()
  {
    this.ak.b();
    VideoFeedsShareGuideController localVideoFeedsShareGuideController = this.al;
    if ((localVideoFeedsShareGuideController != null) && (localVideoFeedsShareGuideController.b()))
    {
      this.X.f().a("0X800B944", this.al.d());
      return;
    }
    this.X.f().a("0X800B942", 0);
  }
  
  public void e()
  {
    IADVideoFeedsGuideManager localIADVideoFeedsGuideManager = this.af;
    if (localIADVideoFeedsGuideManager != null) {
      localIADVideoFeedsGuideManager.d();
    }
    a(this.l, false);
  }
  
  public void f()
  {
    IADVideoFeedsGuideManager localIADVideoFeedsGuideManager = this.af;
    if (localIADVideoFeedsGuideManager != null) {
      localIADVideoFeedsGuideManager.e();
    }
    a(this.l, true);
  }
  
  public boolean g()
  {
    if (!getUserVisibleHint()) {
      return false;
    }
    Object localObject = this.au;
    if ((localObject != null) && (((RIJVideoRewardCoinManager)localObject).k())) {
      return true;
    }
    localObject = this.aa;
    if ((localObject != null) && (((VideoFeedsCommentManager)localObject).k()))
    {
      this.aa.a(2);
      this.aa.h();
      return true;
    }
    localObject = this.l;
    if ((localObject != null) && (((VideoItemHolder)localObject).az != null))
    {
      localObject = this.l.az.c;
      VideoR5.Builder localBuilder = new VideoR5.Builder((VideoInfo)localObject);
      localBuilder.k(((VideoInfo)localObject).l).o(this.j.getCurrentAccountUin()).m(this.l.Y).l(this.l.Z);
      localBuilder.p(1).k(((VideoInfo)localObject).l);
      PublicAccountReportUtils.a(this.j, ((VideoInfo)localObject).q, "0X8009953", "0X8009953", 0, 0, "", "", "", localBuilder.b().a(), false);
    }
    return false;
  }
  
  public ArrayList<Class<ViolaEvent>> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ViolaEvent.class);
    return localArrayList;
  }
  
  public boolean h()
  {
    if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).instanceOfADVideoItemHolder(this.l)) && (this.l.az != null) && (this.l.az.c != null))
    {
      VideoInfo localVideoInfo = this.l.az.c;
      if (localVideoInfo.aq)
      {
        VideoFeedsAdapter localVideoFeedsAdapter = this.h;
        if ((localVideoFeedsAdapter != null) && (localVideoFeedsAdapter.w != null)) {
          this.h.w.a(localVideoInfo);
        }
      }
      return true;
    }
    return false;
  }
  
  public boolean i()
  {
    boolean bool = getUserVisibleHint();
    int i1 = 0;
    if (!bool) {
      return false;
    }
    Object localObject = this.au;
    if ((localObject != null) && (((RIJVideoRewardCoinManager)localObject).k())) {
      return true;
    }
    if (this.J)
    {
      localObject = this.f;
      if (localObject != null)
      {
        ((VideoFeedsRecyclerView)localObject).a();
        VideoFeedsPlayActivity.a("BackPressed, back to list from fullscreen");
        return true;
      }
    }
    localObject = this.aa;
    if ((localObject != null) && (((VideoFeedsCommentManager)localObject).k()))
    {
      localObject = this.aa;
      if (!this.aN) {
        i1 = 5;
      }
      ((VideoFeedsCommentManager)localObject).a(i1);
      this.aa.h();
      return true;
    }
    return false;
  }
  
  public VideoFeedsPlayManager j()
  {
    return this.Y;
  }
  
  public long k()
  {
    VideoFeedsPlayManager localVideoFeedsPlayManager = this.Y;
    if (localVideoFeedsPlayManager != null) {
      return localVideoFeedsPlayManager.b();
    }
    return 0L;
  }
  
  public long l()
  {
    VideoFeedsPlayManager localVideoFeedsPlayManager = this.Y;
    if (localVideoFeedsPlayManager != null) {
      return localVideoFeedsPlayManager.c();
    }
    return 0L;
  }
  
  public VideoInfo m()
  {
    ArrayList localArrayList = this.m;
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      return (VideoInfo)this.m.get(0);
    }
    return null;
  }
  
  public VideoInfo n()
  {
    VideoItemHolder localVideoItemHolder = this.l;
    if ((localVideoItemHolder != null) && (localVideoItemHolder.az != null)) {
      return this.l.az.c;
    }
    return null;
  }
  
  public void o()
  {
    if (QLog.isColorLevel()) {
      RIJAppSetting.a("VideoFeedsRecommendFragment", 2, "ListViewEventListener doOnLoadMoreData() 触发拉取推荐视频列表");
    }
    D();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 21)
    {
      Object localObject;
      if (paramInt1 != 117)
      {
        if (paramInt1 != 9999)
        {
          if (paramInt1 != 10001)
          {
            if (paramInt1 != 101)
            {
              if (paramInt1 != 102) {
                return;
              }
              if (paramInt2 != -1) {
                return;
              }
              localObject = paramIntent.getStringExtra("ARG_VIDEO_ARTICLE_ID");
              if ((!paramIntent.getBooleanExtra("KEY_VIDEO_BIU_SUCCESS", false)) || (localObject == null)) {
                return;
              }
              paramIntent = this.h;
              if (paramIntent == null) {
                return;
              }
              paramIntent = paramIntent.b((String)localObject);
              if (paramIntent == null) {
                return;
              }
              paramIntent.w += 1;
              this.h.a(paramIntent);
              return;
            }
            ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).dealRedPacketMVResult(getBaseActivity(), paramInt2, paramIntent);
          }
        }
        else
        {
          if (paramInt2 != -1) {
            return;
          }
          QQToast.makeText(getBaseActivity(), -1, getString(2131897939), 0).show(getBaseActivity().getTitleBarHeight());
        }
      }
      else
      {
        localObject = this.aa;
        if (localObject == null) {
          return;
        }
        ((VideoFeedsCommentManager)localObject).a(paramInt1, paramInt2, paramIntent);
        return;
      }
    }
    if (paramInt2 == -1) {
      G();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((this.aq == null) && (this.e != null))
    {
      this.aq = new VideoFeedsRecommendFragment.3(this, paramConfiguration);
      this.e.addOnLayoutChangeListener(this.aq);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.e = ((ViewGroup)VideoFeedsResourceLoader.a(2131626419, true, new ViewGroup.LayoutParams(-1, -1)));
    this.j = ((QQAppInterface)ReadInJoyUtils.b());
    x();
    y();
    A();
    paramLayoutInflater = this.ak;
    if (paramLayoutInflater != null) {
      paramLayoutInflater.a();
    }
    SimpleEventBus.getInstance().registerReceiver(this);
    return this.e;
  }
  
  public void onDestroyView()
  {
    this.U = true;
    Object localObject1 = this.h;
    if (localObject1 != null) {
      ((VideoFeedsAdapter)localObject1).e();
    }
    localObject1 = this.Y;
    if (localObject1 != null)
    {
      ((VideoFeedsPlayManager)localObject1).n();
      this.Y = null;
    }
    localObject1 = this.af;
    if (localObject1 != null)
    {
      ((IADVideoFeedsGuideManager)localObject1).a();
      this.af = null;
    }
    localObject1 = this.ag;
    if (localObject1 != null) {
      ((IADVideoAppDownloadManager)localObject1).c();
    }
    localObject1 = this.aE;
    if (localObject1 != null)
    {
      ((IVideoAdExposureManager)localObject1).a();
      this.aE = null;
    }
    localObject1 = this.aF;
    if (localObject1 != null)
    {
      ((IVideoAdTimeLoadManager)localObject1).e();
      this.aE = null;
    }
    localObject1 = this.aG;
    if (localObject1 != null)
    {
      ((IVideoAdStrategyReportManager)localObject1).c();
      this.aG = null;
    }
    localObject1 = this.f;
    if (localObject1 != null) {
      ((VideoFeedsRecyclerView)localObject1).h();
    }
    localObject1 = this.aP;
    if (localObject1 != null)
    {
      ((Handler)localObject1).removeCallbacksAndMessages(null);
      this.aP = null;
    }
    localObject1 = this.Z;
    if (localObject1 != null)
    {
      ((VideoFeedsRecommendManager)localObject1).d();
      this.Z = null;
    }
    localObject1 = this.ab;
    if (localObject1 != null)
    {
      ((VideoFeedsInterruptedAdManager)localObject1).e();
      this.ab = null;
    }
    localObject1 = this.ac;
    if (localObject1 != null)
    {
      ((VideoFeedsShuntBarManager)localObject1).a();
      this.ac = null;
    }
    localObject1 = this.ad;
    if (localObject1 != null)
    {
      ((IVideoFeedsGameAdComManager)localObject1).d();
      this.ad = null;
    }
    localObject1 = this.ae;
    if (localObject1 != null)
    {
      ((IVideoFeedsSoftAdBarController)localObject1).c();
      this.ae = null;
    }
    localObject1 = this.an;
    if (localObject1 != null) {
      ((VideoFullPlayController)localObject1).i();
    }
    localObject1 = this.as;
    if (localObject1 != null) {
      ((VideoColumnBannerManager)localObject1).a();
    }
    localObject1 = this.au;
    if (localObject1 != null) {
      ((RIJVideoRewardCoinManager)localObject1).i();
    }
    localObject1 = this.at;
    if (localObject1 != null) {
      ((RIJRewardVideoTipsManager)localObject1).a();
    }
    localObject1 = this.aa;
    if (localObject1 != null) {
      ((VideoFeedsCommentManager)localObject1).m();
    }
    localObject1 = this.al;
    if (localObject1 != null) {
      ((VideoFeedsShareGuideController)localObject1).c();
    }
    localObject1 = this.m.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (VideoInfo)((Iterator)localObject1).next();
      TimeSliceHelper.a(((VideoInfo)localObject2).l);
      if (((VideoInfo)localObject2).aH != null)
      {
        localObject2 = ((VideoInfo)localObject2).aH.iterator();
        while (((Iterator)localObject2).hasNext()) {
          TimeSliceHelper.a(((VideoInfo)((Iterator)localObject2).next()).l);
        }
      }
    }
    localObject1 = this.ap;
    if (localObject1 != null)
    {
      ((VideoFeedsLikeAnimateManager)localObject1).a();
      this.ap = null;
    }
    this.l = null;
    this.j = null;
    localObject1 = this.ar;
    if (localObject1 != null) {
      ((VideoFeedsGuideProxy)localObject1).b();
    }
    K();
    VideoBehaviorsReporter.a().b();
    VideoVolumeController.getInstance().outKandianModule(getBaseActivity());
    localObject1 = this.X;
    if (localObject1 != null) {
      ((VideoFeedsRecommendPresenter)localObject1).i();
    }
    ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).videoAdStrategyManagerOnDestroy();
    ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).videoAdTimeLoadManagerOnDestroy();
    localObject1 = this.aH;
    if (localObject1 != null) {
      ((IVideoAdVVAdloadStrategyManager)localObject1).d();
    }
    localObject1 = this.aG;
    if (localObject1 != null) {
      ((IVideoAdStrategyReportManager)localObject1).f();
    }
    ((IRIJAdExposeFreshService)QRoute.api(IRIJAdExposeFreshService.class)).exitScene("RIJAdRefreshSceneFloatVideo");
    ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).clearDownloadCache();
    VideoFeedsPlayActivity.a("VideoFeedsPlayActivity doOnDestroy()");
    super.onDestroyView();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onPause()
  {
    VideoFeedsPlayActivity.a("VideoFeedsPlayActivity doOnPause()");
    Object localObject = this.aJ;
    if (localObject != null) {
      ((RIJRewardTaskVideoTimer)localObject).b();
    }
    d(1);
    localObject = this.X;
    if (localObject != null) {
      ((VideoFeedsRecommendPresenter)localObject).m();
    }
    localObject = this.af;
    if (localObject != null) {
      ((IADVideoFeedsGuideManager)localObject).b();
    }
    localObject = this.an;
    if (localObject != null) {
      ((VideoFullPlayController)localObject).h();
    }
    localObject = this.ag;
    if (localObject != null) {
      ((IADVideoAppDownloadManager)localObject).b();
    }
    localObject = this.aF;
    if (localObject != null) {
      ((IVideoAdTimeLoadManager)localObject).d();
    }
    localObject = this.aH;
    if (localObject != null) {
      ((IVideoAdVVAdloadStrategyManager)localObject).c();
    }
    localObject = this.aG;
    if (localObject != null) {
      ((IVideoAdStrategyReportManager)localObject).e();
    }
    localObject = this.ae;
    if (localObject != null) {
      ((IVideoFeedsSoftAdBarController)localObject).b();
    }
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).instanceOfADVideoItemHolder(this.l)) {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).doADVideoItemHolderOnPause(this.l);
    }
    super.onPause();
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof ViolaEvent))
    {
      paramSimpleBaseEvent = (ViolaEvent)paramSimpleBaseEvent;
      a(paramSimpleBaseEvent);
      b(paramSimpleBaseEvent);
    }
  }
  
  public void onResume()
  {
    VideoFeedsPlayActivity.a("VideoFeedsPlayActivity doOnResume()");
    if (getUserVisibleHint()) {
      L();
    }
    super.onResume();
  }
  
  public void onStop()
  {
    VideoFeedsPlayActivity.a("VideoFeedsPlayActivity doOnStop()");
    d(2);
    super.onStop();
  }
  
  public boolean p()
  {
    return this.X.c();
  }
  
  public int q()
  {
    VideoItemHolder localVideoItemHolder = this.l;
    if (localVideoItemHolder != null) {
      return localVideoItemHolder.Z;
    }
    return 0;
  }
  
  public long r()
  {
    return this.C;
  }
  
  public boolean s()
  {
    VideoFeedsCommentManager localVideoFeedsCommentManager = this.aa;
    return (localVideoFeedsCommentManager != null) && (localVideoFeedsCommentManager.k());
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean) {
      L();
    } else {
      d(2);
    }
    VideoFeedsAdapter localVideoFeedsAdapter = this.h;
    if (localVideoFeedsAdapter != null) {
      localVideoFeedsAdapter.f(paramBoolean);
    }
  }
  
  public void t()
  {
    VideoFeedsRecyclerView localVideoFeedsRecyclerView = this.f;
    if (localVideoFeedsRecyclerView != null) {
      localVideoFeedsRecyclerView.setNeedDetectOrientation(getBaseActivity(), false);
    }
  }
  
  public void u()
  {
    if (this.f != null) {
      a(this.l);
    }
  }
  
  public void v()
  {
    this.X.l();
  }
  
  public void w()
  {
    this.X.a(this.m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendFragment
 * JD-Core Version:    0.7.0.1
 */