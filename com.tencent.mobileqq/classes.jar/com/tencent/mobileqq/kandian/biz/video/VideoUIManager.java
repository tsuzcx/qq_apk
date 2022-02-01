package com.tencent.mobileqq.kandian.biz.video;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.OnPatchPlayListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdBubbleNativeView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdMiniGuide;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdVideoGuide;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyPatchAdView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyVideoAdHighLightBar;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.businessCard.helpers.ViewHelper;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.drawable.RoundRectColorDrawable;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdShakeManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJPatchAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJVideoAdService;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.video.VideoPlayUtils;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoView;
import com.tencent.mobileqq.kandian.base.view.ReadInJoyLottieDrawable;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.base.view.widget.RoundAngleFrameLayout;
import com.tencent.mobileqq.kandian.base.view.widget.VideoViewGroup;
import com.tencent.mobileqq.kandian.base.view.widget.ZImageView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListView;
import com.tencent.mobileqq.kandian.biz.feeds.ReadInJoyArticleAdapter;
import com.tencent.mobileqq.kandian.biz.feeds.api.CountDownCallback;
import com.tencent.mobileqq.kandian.biz.feeds.api.IVideoUIManager;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.biz.playfeeds.MultiVideoHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsGestureLayout;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.pts.util.RIJComponentConfigImage;
import com.tencent.mobileqq.kandian.biz.video.api.OnPlayStateListener;
import com.tencent.mobileqq.kandian.biz.video.api.OnUIChangeListener;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeedback.MsgLayoutHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeedback.PlayFeedbackHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.CustomClickListener;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoBrightnessController;
import com.tencent.mobileqq.kandian.biz.video.viewholder.VideoFeedsViewHolder;
import com.tencent.mobileqq.kandian.glue.video.VideoFullPlayController;
import com.tencent.mobileqq.kandian.glue.video.VideoFullPlayController.OnFullPlayListener;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager.VideoStatusListener;
import com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.feeds.ArticlePatchStatus;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.vip.CUKingCardUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.oidb.articlesummary.articlesummary.UrlJumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.VideoDownloadBarInfo;

public class VideoUIManager
  implements View.OnClickListener, IVideoUIManager, OrientationDetector.OnOrientationChangedListener, OnPlayStateListener, CustomClickListener, VideoPlayManager.VideoStatusListener, AbsListView.OnScrollListener
{
  private ImageView A;
  private TextView B;
  private TextView C;
  private RelativeLayout D;
  private TextView E;
  private SeekBar F;
  private TextView G;
  private ImageView H;
  private LinearLayout I;
  private ImageView J;
  private TextView K;
  private SeekBar L;
  private ImageView M;
  private ImageView N;
  private ImageView O;
  private View P;
  private KandianUrlImageView Q;
  private TextView R;
  private View S;
  private KandianUrlImageView T;
  private TextView U;
  private TextView V;
  private TextView W;
  private ReadInJoyPatchAdView X;
  private ReadInJoyVideoAdHighLightBar Y;
  private ReadInJoyAdVideoGuide Z;
  public OnPatchPlayListener a;
  private SeekBar.OnSeekBarChangeListener aA = new VideoUIManager.8(this);
  private boolean aB = false;
  private int aC = 0;
  private articlesummary.VideoDownloadBarInfo aD;
  private boolean aE;
  private CountDownCallback aF;
  private ReadInJoyAdMiniGuide aa;
  private ReadInJoyAdBubbleNativeView ab;
  private RelativeLayout ac;
  private URLImageView ad;
  private RelativeLayout ae;
  private TextView af;
  private TextView ag;
  private TextView ah;
  private OrientationDetector ai;
  private boolean aj;
  private int ak;
  private int al;
  private RotateAnimation am;
  private View an;
  private boolean ao;
  private List<VideoUIManager.OnScreenChangeListener> ap;
  private OnUIChangeListener aq;
  private ArrayList<OnUIChangeListener> ar = new ArrayList(10);
  private int as;
  private TextView at;
  private boolean au;
  private boolean av = false;
  private ViewGroup aw;
  private int ax;
  private Runnable ay = new VideoUIManager.1(this);
  private Handler az = new VideoUIManager.2(this);
  protected int b;
  protected int c;
  public int d;
  private FrameLayout e;
  private ReadInJoyBaseListView f;
  private Activity g;
  private int h = -1;
  private int i = -1;
  private int j;
  private int[] k = new int[2];
  private VideoPlayParam l;
  private VideoPlayManager m;
  private VideoFullPlayController n;
  private VideoBrightnessController o;
  private MsgLayoutHelper p;
  private boolean q;
  private VideoViewGroup r;
  private URLImageView s;
  private VideoFeedsGestureLayout t;
  private KandianUrlImageView u;
  private RelativeLayout v;
  private View w;
  private TextView x;
  private TextView y;
  private TextView z;
  
  public VideoUIManager(FrameLayout paramFrameLayout, ReadInJoyBaseListView paramReadInJoyBaseListView, Activity paramActivity)
  {
    this.e = paramFrameLayout;
    this.f = paramReadInJoyBaseListView;
    this.g = paramActivity;
    this.p = new MsgLayoutHelper(this.e, this);
    this.n = new VideoFullPlayController(paramActivity, this.e, new VideoUIManager.3(this));
    this.ai = new OrientationDetector(this.g, this);
    this.o = new VideoBrightnessController(paramActivity);
    paramFrameLayout = this.g.getWindow();
    this.b = paramFrameLayout.getAttributes().flags;
    this.c = paramFrameLayout.getDecorView().getSystemUiVisibility();
    this.f.a(this);
    this.f.setScrollEventCallback(new VideoUIManager.4(this));
    this.am = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    this.am.setDuration(1000L);
    this.am.setRepeatCount(-1);
    this.am.setRepeatMode(1);
    this.am.setStartTime(-1L);
    paramFrameLayout = new LinearInterpolator();
    this.am.setInterpolator(paramFrameLayout);
    this.an = this.g.findViewById(2131447492);
  }
  
  private void B()
  {
    VideoAutoPlayController.sPauseScrollToNextVideo = false;
    this.aE = false;
    this.aD = null;
    this.aC = 0;
  }
  
  private void C()
  {
    if (this.av) {
      return;
    }
    this.r = ((VideoViewGroup)this.e.findViewById(2131449619));
    this.s = ((URLImageView)this.e.findViewById(2131437742));
    this.t = ((VideoFeedsGestureLayout)this.e.findViewById(2131434168));
    this.v = ((RelativeLayout)this.e.findViewById(2131447534));
    this.x = ((TextView)this.e.findViewById(2131447463));
    this.w = this.e.findViewById(2131447566);
    this.y = ((TextView)this.e.findViewById(2131432267));
    this.u = ((KandianUrlImageView)this.e.findViewById(2131435357));
    this.z = ((TextView)this.e.findViewById(2131440378));
    this.at = ((TextView)this.e.findViewById(2131439725));
    this.A = ((ImageView)this.e.findViewById(2131439638));
    this.B = ((TextView)this.e.findViewById(2131439639));
    this.C = ((TextView)this.e.findViewById(2131436799));
    this.L = ((SeekBar)this.e.findViewById(2131439724));
    this.D = ((RelativeLayout)this.e.findViewById(2131437986));
    this.I = ((LinearLayout)this.e.findViewById(2131433915));
    this.J = ((ImageView)this.e.findViewById(2131433911));
    this.K = ((TextView)this.e.findViewById(2131433913));
    this.E = ((TextView)this.e.findViewById(2131440766));
    this.F = ((SeekBar)this.e.findViewById(2131435807));
    this.G = ((TextView)this.e.findViewById(2131432269));
    this.H = ((ImageView)this.e.findViewById(2131433912));
    this.A.setOnClickListener(this);
    this.F.setOnSeekBarChangeListener(this.aA);
    this.H.setOnClickListener(this);
    this.J.setOnClickListener(this);
    this.t.setContext(this.g);
    this.t.setOnCustomClickListener(this);
    this.t.setSeekBar(this.F);
    this.t.setVideoBrightnessController(this.o);
    this.O = ((ImageView)this.e.findViewById(2131449775));
    this.M = ((ImageView)this.e.findViewById(2131449774));
    this.N = ((ImageView)this.e.findViewById(2131449772));
    this.O.setOnClickListener(this);
    this.M.setOnClickListener(this);
    this.X = ((ReadInJoyPatchAdView)this.e.findViewById(2131439876));
    D();
    this.Y = ((ReadInJoyVideoAdHighLightBar)this.e.findViewById(2131435042));
    this.Z = ((ReadInJoyAdVideoGuide)this.e.findViewById(2131427639));
    this.aa = ((ReadInJoyAdMiniGuide)this.e.findViewById(2131427731));
    this.ad = ((URLImageView)this.e.findViewById(2131427746));
    this.ae = ((RelativeLayout)this.e.findViewById(2131427726));
    this.af = ((TextView)this.e.findViewById(2131427727));
    this.ag = ((TextView)this.e.findViewById(2131427725));
    this.ah = ((TextView)this.e.findViewById(2131427743));
    this.ad.setOnClickListener(this);
    this.ac = ((RelativeLayout)this.e.findViewById(2131427663));
    this.ab = ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).addFeedsBubbleView(this.g, this.ac);
    UIUtils.a(this.O, 10, 10, 10, 10);
    UIUtils.a(this.M, 20, 20, 20, 20);
    VideoVolumeControl.getInstance().restoreFeedsVideoView(this.O);
    VideoVolumeControl.getInstance().restoreFeedsVideoView(this.M);
    this.av = true;
  }
  
  private void D()
  {
    this.a = new VideoUIManager.5(this);
    ((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).initPatchAdViewListener(this.g, this, this.m, this.n, this.aF, this.a);
  }
  
  private void E()
  {
    VideoPlayParam localVideoPlayParam = this.l;
    if (localVideoPlayParam == null) {
      return;
    }
    FrameLayout localFrameLayout = this.e;
    if ((localFrameLayout instanceof RoundAngleFrameLayout)) {
      ((RoundAngleFrameLayout)localFrameLayout).setRadius(localVideoPlayParam.R, this.l.S, this.l.T, this.l.U);
    }
  }
  
  private void F()
  {
    FrameLayout localFrameLayout = this.e;
    if ((localFrameLayout instanceof RoundAngleFrameLayout)) {
      ((RoundAngleFrameLayout)localFrameLayout).setRadius(0, 0, 0, 0);
    }
  }
  
  private void G()
  {
    if (c())
    {
      F();
      return;
    }
    E();
  }
  
  private void H()
  {
    Object localObject = this.l;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.videoVideoUIManager", 2, "innerConfigVideoUI() mPlayingVideoParam == null ERROR");
      }
      return;
    }
    this.x.setText(((VideoPlayParam)localObject).D.mTitle);
    this.K.setText(this.l.D.mTitle);
    this.K.getPaint().setFakeBoldText(true);
    this.x.getPaint().setFakeBoldText(true);
    this.x.setTextColor(this.g.getResources().getColor(2131168464));
    if (this.l.M) {
      this.x.setVisibility(8);
    }
    StringBuilder localStringBuilder;
    if (this.l.D.mVideoPlayCount == 0)
    {
      this.z.setVisibility(8);
    }
    else
    {
      this.z.setVisibility(0);
      localObject = this.z;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(VideoFeedsHelper.c(this.l.D.mVideoPlayCount));
      localStringBuilder.append(HardCodeUtil.a(2131913605));
      ((TextView)localObject).setText(localStringBuilder.toString());
    }
    this.G.setText(ReadInJoyDisplayUtils.a(this.l.l, true));
    VideoHandler.b(this.g, this.u, this.l);
    VideoHandler.a(this.g, this.u, this.l);
    localObject = this.l;
    if ((localObject != null) && (((VideoPlayParam)localObject).M)) {
      localObject = MultiVideoHelper.a(this.l.D.getVideoCoverUrlWithSmartCut(false).toString());
    }
    try
    {
      a(this.u, new URL((String)localObject));
    }
    catch (Exception localException)
    {
      label302:
      break label302;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("Q.readinjoy.videoVideoUIManager", 2, "coverImage URL MalformedURLException");
      break label340;
      a(this.u, this.l.D.getVideoCoverUrlWithSmartCut(false));
    }
    label340:
    if (this.l.D.mXGFileSize <= 0L)
    {
      this.B.setText(HardCodeUtil.a(2131913604));
    }
    else
    {
      localObject = this.B;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(VideoFeedsHelper.c(this.l.D.mXGFileSize));
      localStringBuilder.append(HardCodeUtil.a(2131913608));
      ((TextView)localObject).setText(localStringBuilder.toString());
    }
    this.t.setChannelID(this.l.f);
    if (NetworkUtil.isWifiConnected(this.g))
    {
      this.A.clearAnimation();
      this.A.setVisibility(0);
      this.A.setImageDrawable(this.g.getResources().getDrawable(2130844327));
      this.A.setTag(Integer.valueOf(1));
      this.B.setVisibility(8);
    }
    else
    {
      this.A.clearAnimation();
      this.A.setVisibility(8);
      localObject = this.g.getResources().getDrawable(2130844245);
      this.B.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
      this.B.setCompoundDrawablePadding(AIOUtils.b(6.0F, this.g.getResources()));
      this.B.setVisibility(0);
      if (CUKingCardUtils.a() == 1) {
        this.B.setText(HardCodeUtil.a(2131913603));
      }
    }
    l();
    this.L.setMax(this.l.l);
    this.F.setMax(this.l.l);
    R();
    d(this.l.P);
    G();
    this.e.setVisibility(0);
    if (this.l.D.patchStatus.a.get() != 1) {
      ((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).hidePathAd(this);
    }
    localObject = this.X;
    if ((localObject != null) && (((ReadInJoyPatchAdView)localObject).e()) && (this.X.getVideoPlayParam() != null) && (this.l != this.X.getVideoPlayParam())) {
      this.X.d();
    }
    ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).updateLightBarText(this.l, this.Y);
    ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).fillVideoBeforeEndGuide(this.l, this.Z);
    ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).logAdConfig(this.l);
  }
  
  private void I()
  {
    this.l.g = this.r;
  }
  
  private void J()
  {
    this.e.setTranslationY(0.0F);
    P();
    t();
    this.L.setVisibility(8);
    ViewGroup.LayoutParams localLayoutParams = this.e.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    this.e.setLayoutParams(localLayoutParams);
    this.r.a(false);
    this.t.setIsInFullScreen(true);
    this.t.a();
    this.m.c(0);
    this.e.setBackgroundColor(-16777216);
    d(true);
  }
  
  private void K()
  {
    Object localObject = this.m.a();
    if (localObject != null)
    {
      localObject = ((VideoPlayParam)localObject).D;
      if (localObject != null)
      {
        String str1 = new VideoR5.Builder(null, ((AbsBaseArticleInfo)localObject).getSubscribeUin(), ((AbsBaseArticleInfo)localObject).mVideoVid, ((AbsBaseArticleInfo)localObject).getInnerUniqueID(), this.m.f(), ((AbsBaseArticleInfo)localObject).getVideoDuration() * 1000L).a((int)((AbsBaseArticleInfo)localObject).mChannelID).b().a();
        String str2 = ((AbsBaseArticleInfo)localObject).getSubscribeUin();
        if (!TextUtils.isEmpty(((AbsBaseArticleInfo)localObject).getInnerUniqueID())) {
          localObject = ((AbsBaseArticleInfo)localObject).getInnerUniqueID();
        } else {
          localObject = "0";
        }
        PublicAccountReportUtils.a(null, str2, "0X8007411", "0X8007411", 0, 0, "0", "", (String)localObject, str1, false);
      }
    }
  }
  
  private void L()
  {
    Object localObject = this.l;
    if (localObject != null)
    {
      if (((VideoPlayParam)localObject).D == null) {
        return;
      }
      if (this.l.h == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.readinjoy.videoVideoUIManager", 2, "showXGToast failed for mPlayingVideoParam.feedsVideoCover is null");
        }
        return;
      }
      if (CUKingCardUtils.a() == 1)
      {
        localObject = HardCodeUtil.a(2131913607);
      }
      else if (this.l.D.mXGFileSize > 0L)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131913602));
        ((StringBuilder)localObject).append(VideoFeedsHelper.c(this.l.D.mXGFileSize));
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = HardCodeUtil.a(2131913601);
      }
      int[] arrayOfInt = new int[2];
      this.l.h.getLocationOnScreen(arrayOfInt);
      int i1 = arrayOfInt[1] - ImmersiveUtils.getStatusBarHeight(this.g);
      i1 = (i1 + (this.l.h.getHeight() + i1) - DisplayUtil.a(this.g, 40.0F)) / 2;
      VideoFeedsHelper.a(this.g, (String)localObject, i1);
    }
  }
  
  private boolean M()
  {
    return this.p.c();
  }
  
  private void N()
  {
    this.u.clearAnimation();
    this.u.setVisibility(0);
    ViewGroup.LayoutParams localLayoutParams = this.u.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    this.u.setLayoutParams(localLayoutParams);
    a(this.u, this.l.D.getVideoCoverUrlWithSmartCut(false));
  }
  
  private void O()
  {
    this.p.b();
    this.L.setVisibility(0);
  }
  
  private void P()
  {
    VideoFeedsHelper.a(this.v, 8, 300);
    this.D.setVisibility(8);
    VideoFeedsHelper.a(this.A, 8, 300);
    if (c()) {
      this.L.setVisibility(8);
    } else {
      this.L.setVisibility(0);
    }
    if (!VideoFeedsHelper.g()) {
      VideoFeedsHelper.a(this.v, 8, 300);
    }
  }
  
  private void Q()
  {
    Object localObject = this.m;
    int i1;
    if (localObject != null) {
      i1 = (int)(((VideoPlayManager)localObject).f() / 1000L);
    } else {
      i1 = 0;
    }
    ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).reportVideoPlayC2sBasedTimeFilter(i1, this.m);
    if (this.L.isEnabled())
    {
      if (this.L.getVisibility() != 0) {
        this.L.setVisibility(0);
      }
      this.L.setProgress(i1);
    }
    if ((this.F.getVisibility() == 0) && (this.F.isEnabled())) {
      this.F.setProgress(i1);
    }
    if (this.E.getVisibility() == 0) {
      this.E.setText(ReadInJoyDisplayUtils.a(i1, false));
    }
    localObject = this.aq;
    if ((localObject != null) && (this.l != null))
    {
      VideoPlayManager localVideoPlayManager = this.m;
      if (localVideoPlayManager != null) {
        ((OnUIChangeListener)localObject).a(localVideoPlayManager.a(), (int)this.m.f(), this.l.l * 1000);
      }
    }
    if ((this.l != null) && (this.m != null))
    {
      localObject = this.ar.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((OnUIChangeListener)((Iterator)localObject).next()).a(this.m.a(), (int)this.m.f(), this.l.l * 1000);
      }
      a(this.m.b(this.l.a()), this.l);
    }
  }
  
  private void R()
  {
    this.r.removeAllViews();
    this.t.a();
    this.u.setVisibility(0);
    this.v.setVisibility(0);
    this.w.setVisibility(0);
    t();
    O();
    this.L.setVisibility(8);
    this.y.setVisibility(8);
    ah();
    X();
    this.F.setEnabled(true);
    this.s.setVisibility(8);
    Object localObject = this.Y;
    if (localObject != null) {
      ((ReadInJoyVideoAdHighLightBar)localObject).setVisibility(8);
    }
    localObject = this.Z;
    if (localObject != null) {
      ((ReadInJoyAdVideoGuide)localObject).setVisibility(8);
    }
  }
  
  private boolean S()
  {
    return this.A.getVisibility() == 0;
  }
  
  private void T()
  {
    this.B.setVisibility(8);
    this.A.clearAnimation();
    this.A.setVisibility(8);
    this.az.removeMessages(103);
  }
  
  private void U()
  {
    try
    {
      if ((x() != null) && (this.f != null) && (this.l != null) && (this.f.getAdapter() != null))
      {
        if (this.l.D == null) {
          return;
        }
        if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdExpandLiveVideoCard(this.l.D)) {
          return;
        }
        x().a(0);
        ReadInJoyArticleAdapter localReadInJoyArticleAdapter = (ReadInJoyArticleAdapter)((HeaderViewListAdapter)this.f.getAdapter()).getWrappedAdapter();
        ((AdvertisementInfo)this.l.D).isSmallCard = true;
        ((AdvertisementInfo)this.l.D).clickPos = 40;
        localReadInJoyArticleAdapter.notifyDataSetChanged();
        ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(ReportAction.CLOSE, Integer.valueOf(0), (AdvertisementInfo)this.l.D, 3, 1, 1);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleAdLiveCloseClick(): error:");
      localStringBuilder.append(localException.getMessage());
      QLog.e("Q.readinjoy.videoVideoUIManager", 2, localStringBuilder.toString());
    }
  }
  
  private void V()
  {
    VideoPlayParam localVideoPlayParam = this.l;
    if ((localVideoPlayParam != null) && (localVideoPlayParam.D != null))
    {
      if (c()) {
        b(false);
      }
      this.az.post(new VideoUIManager.11(this));
      PlayFeedbackHelper.a(this.g, this.l.D, this.m.b(this.l.a()), 0, 0);
      PlayFeedbackHelper.a(this.l.a(), 0, 0);
    }
  }
  
  private void W()
  {
    Object localObject = this.l;
    if (localObject != null)
    {
      localObject = ((VideoPlayParam)localObject).D;
      if (localObject != null)
      {
        localObject = new VideoR5.Builder(null, this.l.A, ((AbsBaseArticleInfo)localObject).mVideoVid, ((AbsBaseArticleInfo)localObject).getInnerUniqueID()).a((int)((AbsBaseArticleInfo)localObject).mChannelID).b().a();
        PublicAccountReportUtils.a(null, "", "0X8009505", "0X8009505", 0, 0, "", this.n.g(), "", (String)localObject, false);
      }
    }
  }
  
  private void X()
  {
    Object localObject = this.L;
    if (localObject == null) {
      return;
    }
    ((SeekBar)localObject).setEnabled(true);
    int i1 = 0;
    localObject = this.m;
    if (localObject != null) {
      i1 = (int)(((VideoPlayManager)localObject).f() / 1000L);
    }
    this.L.setProgress(i1);
  }
  
  private void Y()
  {
    Object localObject = this.E;
    int i1 = 0;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.G;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.N;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.M;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
    localObject = this.F;
    if (localObject != null)
    {
      ((SeekBar)localObject).setEnabled(true);
      localObject = this.m;
      if (localObject != null) {
        i1 = (int)(((VideoPlayManager)localObject).f() / 1000L);
      }
      this.F.setProgress(i1);
    }
    localObject = this.az;
    if (localObject != null) {
      ((Handler)localObject).sendEmptyMessageDelayed(101, 3000L);
    }
  }
  
  private void Z()
  {
    Object localObject = this.l;
    if ((localObject != null) && (((VideoPlayParam)localObject).D != null) && (this.l.D.mVideoDownloadBarInfo != null))
    {
      this.aD = this.l.D.mVideoDownloadBarInfo;
      boolean bool = this.aD.uint32_appear_style.has();
      int i2 = 0;
      int i1 = i2;
      if (bool)
      {
        i1 = i2;
        if (this.aD.uint32_appear_style.get() >= 0)
        {
          this.aC = this.aD.uint32_appear_style.get();
          if ((this.aD.msg_url_jump_info.has()) && (this.aD.msg_url_jump_info.get() != null))
          {
            i1 = i2;
            if (this.aC == 1) {
              if ((this.aD.uint32_appear_time.has()) && (this.aD.uint32_appear_time.get() > 0))
              {
                i1 = this.aD.uint32_appear_time.get();
              }
              else
              {
                this.aC = 0;
                if (QLog.isColorLevel()) {
                  QLog.e("Q.readinjoy.videoVideoUIManager", 2, "checkIfHasDownloadInfo(), 协议字段不合法 2");
                }
              }
            }
          }
          else
          {
            this.aC = 0;
            if (QLog.isColorLevel()) {
              QLog.e("Q.readinjoy.videoVideoUIManager", 2, "checkIfHasDownloadInfo(), 协议字段不合法 1");
            }
            return;
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkIfHasDownloadInfo(), mDownloadBarStyle:");
        ((StringBuilder)localObject).append(this.aC);
        ((StringBuilder)localObject).append(", appearTime:");
        ((StringBuilder)localObject).append(i1);
        QLog.i("Q.readinjoy.videoVideoUIManager", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkIfHasDownloadInfo(), mVideoDownloadBarInfo == null, mPlayingVideoParam:");
      ((StringBuilder)localObject).append(this.l);
      QLog.e("Q.readinjoy.videoVideoUIManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private static Drawable a(Context paramContext, boolean paramBoolean)
  {
    int i2;
    int i1;
    if (paramBoolean)
    {
      i2 = DisplayUtil.a(paramContext, 12.0F);
      i1 = DisplayUtil.a(paramContext, 60.0F);
    }
    else
    {
      i2 = DisplayUtil.a(paramContext, 6.0F);
      i1 = DisplayUtil.a(paramContext, 28.0F);
    }
    return new RoundRectColorDrawable(-2565928, i2, i1, i1);
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    this.az.post(new VideoUIManager.6(this, paramInt, paramString1, paramString2));
  }
  
  private void a(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    paramImageView.setVisibility(0);
    if (VideoVolumeControl.getInstance().isMute())
    {
      paramImageView.setImageResource(2130844132);
      paramImageView.setContentDescription(HardCodeUtil.a(2131913606));
      return;
    }
    paramImageView.setImageResource(2130844133);
    paramImageView.setContentDescription(HardCodeUtil.a(2131913611));
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL)
  {
    ReadInJoyDisplayUtils.a(paramKandianUrlImageView, paramURL, this.g, false);
  }
  
  private void a(VideoPlayParam paramVideoPlayParam, int paramInt, Object paramObject)
  {
    if (paramInt == 3)
    {
      if (c()) {
        b(false);
      }
      k();
      return;
    }
    k();
  }
  
  private void a(boolean paramBoolean, VideoPlayParam paramVideoPlayParam1, VideoPlayParam paramVideoPlayParam2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onScreenChange   isFullScreen:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("  enterPlayParam:");
      ((StringBuilder)localObject).append(paramVideoPlayParam1);
      ((StringBuilder)localObject).append("   exitPlayParam:");
      ((StringBuilder)localObject).append(paramVideoPlayParam2);
      QLog.i("Q.readinjoy.videoVideoUIManager", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      localObject = this.n;
      int i1 = VideoPlayUtils.a(this.f, paramVideoPlayParam1.e);
      this.d = i1;
      ((VideoFullPlayController)localObject).a(paramVideoPlayParam1, i1);
    }
    else
    {
      this.n.c();
    }
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, paramBoolean ^ true);
    G();
    Object localObject = this.ap;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        VideoUIManager.OnScreenChangeListener localOnScreenChangeListener = (VideoUIManager.OnScreenChangeListener)((Iterator)localObject).next();
        if (localOnScreenChangeListener != null) {
          if (paramBoolean) {
            localOnScreenChangeListener.cW_();
          } else {
            localOnScreenChangeListener.a(paramVideoPlayParam1, paramVideoPlayParam2);
          }
        }
      }
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 != 0)
    {
      if (paramInt2 == 0) {
        return false;
      }
      bool1 = bool2;
      if (paramInt1 <= paramInt2) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void aa()
  {
    if (this.aE)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.readinjoy.videoVideoUIManager", 2, "checkIfShowDownloadBarPlaying(), mDownloadBarClicked, return");
      }
      return;
    }
    if (this.m.f() / 1000L >= this.aD.uint32_appear_time.get())
    {
      if ((!r()) && (!q()) && (this.m.j() == 3))
      {
        h(1);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.readinjoy.videoVideoUIManager", 2, "checkIfShowDownloadBarPlaying(): failure");
      }
    }
  }
  
  private void ab()
  {
    if (this.P == null)
    {
      this.P = ((ViewStub)this.e.findViewById(2131432089)).inflate();
      this.Q = ((KandianUrlImageView)this.P.findViewById(2131428620));
      this.R = ((TextView)this.P.findViewById(2131428622));
      this.P.setOnClickListener(this);
    }
    String str1 = ac();
    if (!TextUtils.isEmpty(str1)) {
      try
      {
        URL localURL = new URL(str1);
        this.Q.setImagePlaceHolder(a(this.g, false)).setImage(localURL);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    } else {
      this.Q.setBackgroundDrawable(a(this.g, false));
    }
    String str2 = ad();
    if (!TextUtils.isEmpty(str2)) {
      this.R.setText(str2);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showDownloadBarPlaying(), iconUrl:");
      localStringBuilder.append(str1);
      localStringBuilder.append("，iconText:");
      localStringBuilder.append(str2);
      QLog.d("Q.readinjoy.videoVideoUIManager", 2, localStringBuilder.toString());
    }
    this.P.setVisibility(0);
  }
  
  private String ac()
  {
    articlesummary.VideoDownloadBarInfo localVideoDownloadBarInfo = this.aD;
    if ((localVideoDownloadBarInfo != null) && (RIJPBFieldUtils.c(localVideoDownloadBarInfo.bytes_icon_url))) {
      return RIJPBFieldUtils.d(this.aD.bytes_icon_url);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.videoVideoUIManager", 2, "getDownloadIconUrl(), null:");
    }
    return null;
  }
  
  private String ad()
  {
    articlesummary.VideoDownloadBarInfo localVideoDownloadBarInfo = this.aD;
    if ((localVideoDownloadBarInfo != null) && (RIJPBFieldUtils.c(localVideoDownloadBarInfo.bytes_icon_text))) {
      return RIJPBFieldUtils.d(this.aD.bytes_icon_text);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.videoVideoUIManager", 2, "getDownloadIconText(), null:");
    }
    return null;
  }
  
  private void ae()
  {
    if ((this.aD.msg_url_jump_info.has()) && (this.aD.msg_url_jump_info.get() != null))
    {
      Object localObject = (articlesummary.UrlJumpInfo)this.aD.msg_url_jump_info.get();
      if (((articlesummary.UrlJumpInfo)localObject).uint32_jump_type.get() == 1)
      {
        if (RIJPBFieldUtils.c(((articlesummary.UrlJumpInfo)localObject).bytes_jump_url)) {
          ReadInJoyUtils.a(this.g, RIJPBFieldUtils.d(((articlesummary.UrlJumpInfo)localObject).bytes_jump_url));
        }
      }
      else if (((articlesummary.UrlJumpInfo)localObject).uint32_jump_type.get() == 2) {
        if ((RIJPBFieldUtils.c(((articlesummary.UrlJumpInfo)localObject).bytes_jump_bundle)) && (PackageUtil.a(this.g, RIJPBFieldUtils.d(((articlesummary.UrlJumpInfo)localObject).bytes_jump_bundle)))) {
          VideoFeedsHelper.a(this.g, RIJPBFieldUtils.d(((articlesummary.UrlJumpInfo)localObject).bytes_jump_schema));
        } else if (RIJPBFieldUtils.c(((articlesummary.UrlJumpInfo)localObject).bytes_jump_url)) {
          ReadInJoyUtils.a(this.g, RIJPBFieldUtils.d(((articlesummary.UrlJumpInfo)localObject).bytes_jump_url));
        }
      }
      this.aE = true;
      localObject = this.l;
      if ((localObject != null) && (((VideoPlayParam)localObject).D != null))
      {
        int i1 = this.aC;
        if (i1 == 1) {
          localObject = "0X8009BC5";
        }
        for (;;)
        {
          break;
          if (i1 == 2) {
            localObject = "0X8009BC7";
          } else {
            localObject = "";
          }
        }
        VideoR5.Builder localBuilder = new VideoR5.Builder("", this.l.A, this.l.d, this.l.D.innerUniqueID);
        localBuilder.a((int)this.l.f);
        articlesummary.VideoDownloadBarInfo localVideoDownloadBarInfo = this.aD;
        if ((localVideoDownloadBarInfo != null) && (localVideoDownloadBarInfo.msg_url_jump_info.has()) && (this.aD.msg_url_jump_info.get() != null)) {
          localBuilder.b(RIJPBFieldUtils.d(((articlesummary.UrlJumpInfo)this.aD.msg_url_jump_info.get()).bytes_common_data));
        }
        PublicAccountReportUtils.a(null, "", (String)localObject, (String)localObject, 0, 0, "3", "", "", localBuilder.b().a(), false);
      }
    }
  }
  
  private void af()
  {
    if (this.S == null)
    {
      this.S = ((ViewStub)this.e.findViewById(2131432090)).inflate();
      this.T = ((KandianUrlImageView)this.S.findViewById(2131428620));
      this.U = ((TextView)this.S.findViewById(2131428622));
      this.V = ((TextView)this.S.findViewById(2131444631));
      this.W = ((TextView)this.S.findViewById(2131432110));
      this.V.setOnClickListener(this);
      this.W.setOnClickListener(this);
      int i1 = DisplayUtil.a(this.g, 16.0F);
      localObject1 = this.g.getResources().getDrawable(2130844247);
      ((Drawable)localObject1).setBounds(0, 0, i1, i1);
      this.V.setCompoundDrawables((Drawable)localObject1, null, null, null);
      localObject1 = this.g.getResources().getDrawable(2130844152);
      ((Drawable)localObject1).setBounds(0, 0, i1, i1);
      this.W.setCompoundDrawables((Drawable)localObject1, null, null, null);
    }
    Object localObject1 = ac();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      try
      {
        URL localURL = new URL((String)localObject1);
        this.T.setImagePlaceHolder(a(this.g, true)).setImage(localURL);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    } else {
      this.T.setBackgroundDrawable(a(this.g, true));
    }
    String str = ad();
    if (!TextUtils.isEmpty(str)) {
      this.U.setText(str);
    }
    this.S.setVisibility(0);
    Object localObject2 = this.P;
    if (localObject2 != null) {
      ((View)localObject2).setVisibility(8);
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("showDownloadBarComplete(), iconUrl:");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("，iconText:");
      ((StringBuilder)localObject2).append(str);
      QLog.d("Q.readinjoy.videoVideoUIManager", 2, ((StringBuilder)localObject2).toString());
    }
    this.u.setVisibility(0);
    this.v.setVisibility(8);
    T();
    this.I.setVisibility(8);
    this.L.setVisibility(8);
    this.D.setVisibility(8);
  }
  
  private boolean ag()
  {
    int i1 = this.aC;
    boolean bool3 = false;
    boolean bool2 = false;
    View localView;
    boolean bool1;
    if (i1 != 1)
    {
      if (i1 != 2) {
        return false;
      }
      localView = this.S;
      bool1 = bool3;
      if (localView != null)
      {
        bool1 = bool2;
        if (localView.getVisibility() == 0) {
          bool1 = true;
        }
        return bool1;
      }
    }
    else
    {
      localView = this.P;
      bool1 = bool3;
      if (localView != null)
      {
        bool1 = bool3;
        if (localView.getVisibility() == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void ah()
  {
    i(1);
    i(2);
  }
  
  private void ai()
  {
    Object localObject = this.l;
    if (localObject != null)
    {
      if (((VideoPlayParam)localObject).D == null) {
        return;
      }
      if ((VideoFeedsHelper.h()) && (!TextUtils.isEmpty(this.l.D.mVideoLogoUrl)))
      {
        localObject = this.l.D.mVideoLogoUrl;
        try
        {
          if (((String)localObject).endsWith("zip"))
          {
            localObject = ReadInJoyLottieDrawable.a((String)localObject);
            ((ReadInJoyLottieDrawable)localObject).setRepeatCount(0);
            this.s.setImageDrawable((Drawable)localObject);
            ((ReadInJoyLottieDrawable)localObject).playAnimation();
          }
          else
          {
            localObject = new URL((String)localObject);
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mLoadingDrawable = new EmptyDrawable(0, 50, 150);
            localURLDrawableOptions.mPlayGifImage = true;
            localObject = URLDrawable.getDrawable((URL)localObject, localURLDrawableOptions);
            this.s.setImageDrawable((Drawable)localObject);
          }
          this.s.setVisibility(0);
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
      }
      this.s.setVisibility(8);
    }
  }
  
  private boolean aj()
  {
    URLImageView localURLImageView = this.s;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localURLImageView != null)
    {
      bool1 = bool2;
      if (localURLImageView.getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void ak()
  {
    this.ah.setVisibility(8);
    Object localObject = this.l;
    if (localObject != null)
    {
      if (((VideoPlayParam)localObject).D == null) {
        return;
      }
      if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(this.l.D)) {
        return;
      }
      localObject = ((AdvertisementInfo)this.l.D).mAdvertisementExtInfo;
      if (localObject == null) {
        return;
      }
      localObject = ((AdvertisementExtInfo)localObject).J;
      if (this.ah != null)
      {
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setCornerRadius(AIOUtils.b(4.0F, this.g.getResources()));
        localGradientDrawable.setColor(Color.parseColor("#4D000000"));
        this.ah.setBackgroundDrawable(localGradientDrawable);
        this.ah.setText((CharSequence)localObject);
      }
      this.ag.setMaxEms(15);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.ah.setVisibility(8);
        return;
      }
      this.ah.setVisibility(0);
      this.ag.setMaxEms(10);
    }
  }
  
  private void al()
  {
    Object localObject = this.l;
    if (localObject != null)
    {
      if (((VideoPlayParam)localObject).D == null) {
        return;
      }
      if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdExpandLiveVideoCard(this.l.D))
      {
        localObject = this.ad;
        if (localObject != null) {
          ((URLImageView)localObject).setVisibility(8);
        }
        localObject = this.ae;
        if (localObject != null) {
          ((RelativeLayout)localObject).setVisibility(8);
        }
        return;
      }
      localObject = this.ad;
      if (localObject != null)
      {
        ((URLImageView)localObject).setVisibility(0);
        localObject = URLDrawable.getDrawable("https://img.nfa.qq.com/gmaster_prod/16104096/gmaster_b5gbv9fgqyg_adtagclose.png", URLDrawable.URLDrawableOptions.obtain());
        this.ad.setImageDrawable((Drawable)localObject);
      }
      localObject = this.ae;
      if ((localObject != null) && (this.ag != null) && (this.af != null))
      {
        ((RelativeLayout)localObject).setVisibility(0);
        localObject = new GradientDrawable();
        ((GradientDrawable)localObject).setCornerRadius(AIOUtils.b(4.0F, this.g.getResources()));
        ((GradientDrawable)localObject).setColor(Color.parseColor("#4D000000"));
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setCornerRadius(AIOUtils.b(4.0F, this.g.getResources()));
        localGradientDrawable.setColor(Color.parseColor("#FFFF7121"));
        this.ae.setBackgroundDrawable((Drawable)localObject);
        this.af.setBackgroundDrawable(localGradientDrawable);
        this.af.setText(((AdvertisementInfo)this.l.D).mAdvertisementExtInfo.G);
        this.ag.setText(((AdvertisementInfo)this.l.D).mAdDesc);
      }
    }
  }
  
  private boolean am()
  {
    Object localObject = this.l;
    boolean bool2 = false;
    if (localObject == null) {
      return false;
    }
    localObject = ((VideoPlayParam)localObject).D;
    if (localObject == null) {
      return false;
    }
    boolean bool1 = bool2;
    if ((localObject instanceof AdvertisementInfo))
    {
      bool1 = bool2;
      if (((AdvertisementInfo)localObject).mAdvertisementExtInfo.l == 1035) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void b(VideoPlayParam paramVideoPlayParam, int paramInt, Object paramObject)
  {
    this.D.setVisibility(8);
    this.az.removeMessages(103);
    this.az.sendEmptyMessageDelayed(103, 1200L);
    this.az.removeMessages(100);
    this.L.setVisibility(8);
    this.O.setVisibility(8);
  }
  
  private void c(VideoPlayParam paramVideoPlayParam, int paramInt, Object paramObject)
  {
    if ((this.f.getFirstVisiblePosition() == 0) && (this.f.getChildAt(1) != null) && ((this.f.getChildAt(1).getTag() instanceof VideoFeedsViewHolder)))
    {
      paramObject = (VideoFeedsViewHolder)this.f.getChildAt(1).getTag();
      if ((paramObject != null) && (paramObject.z != null) && (paramObject.P == 0))
      {
        this.C.setVisibility(8);
        paramObject.z.setVisibility(8);
        if (QLog.isColorLevel()) {
          QLog.e("Q.readinjoy.videoVideoUIManager", 2, "隐藏大王卡引导Textview");
        }
      }
    }
    ((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).playPrePatchAd(paramVideoPlayParam, this, false, this.a);
    if (am())
    {
      this.aa.setVisibility(0);
      this.aa.setAdShakeInfo(b());
      ((IRIJAdShakeManager)QRoute.api(IRIJAdShakeManager.class)).registerListener(this.g, paramVideoPlayParam);
      return;
    }
    this.aa.d();
    ((IRIJAdShakeManager)QRoute.api(IRIJAdShakeManager.class)).unRegisterListener();
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.H.setImageDrawable(this.g.getResources().getDrawable(2130842768));
      return;
    }
    this.H.setImageDrawable(this.g.getResources().getDrawable(2130842769));
  }
  
  public static boolean c(VideoPlayParam paramVideoPlayParam)
  {
    if (paramVideoPlayParam == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.readinjoy.videoVideoUIManager", 2, "isProtraitVideo return false for videoPlayParam is null.");
      }
      return false;
    }
    return a(paramVideoPlayParam.n, paramVideoPlayParam.o);
  }
  
  private void d(int paramInt)
  {
    if (paramInt == 1)
    {
      this.x.setVisibility(8);
      this.w.setVisibility(8);
      this.z.setVisibility(8);
    }
    else
    {
      this.x.setVisibility(0);
      this.w.setVisibility(0);
      this.z.setVisibility(0);
    }
    if (c())
    {
      this.v.setVisibility(8);
      this.z.setVisibility(8);
    }
  }
  
  private void d(View paramView)
  {
    if (c()) {
      b(false);
    } else {
      o();
    }
    ThreadManager.executeOnSubThread(new VideoUIManager.9(this));
  }
  
  private void d(VideoPlayParam paramVideoPlayParam, int paramInt, Object paramObject)
  {
    this.az.removeMessages(103);
    this.az.sendEmptyMessage(102);
    if (paramInt == 2)
    {
      this.l.i.a().setBackgroundColor(this.g.getResources().getColor(2131165564));
      T();
      this.az.removeMessages(100);
      this.az.sendEmptyMessageDelayed(100, 3000L);
      if ((NetworkUtil.isMobileNetWork(this.g)) && (!this.au))
      {
        L();
        this.au = true;
      }
      a(this.O);
      if (this.l.M)
      {
        paramVideoPlayParam = this.O;
        if (paramVideoPlayParam != null) {
          paramVideoPlayParam.setVisibility(8);
        }
      }
      Z();
      ai();
      al();
      ak();
    }
    else if (paramInt == 4)
    {
      T();
    }
    else if (paramInt == 5)
    {
      if ((S()) && (r()))
      {
        e(2);
        this.az.removeMessages(101);
        this.az.sendEmptyMessageDelayed(101, 3000L);
      }
      else if (M())
      {
        O();
        if (NetworkUtil.isMobileNetWork(this.g)) {
          L();
        }
      }
      else if (this.l.M)
      {
        this.A.clearAnimation();
        this.A.setVisibility(8);
      }
    }
    if (!am())
    {
      this.aa.d();
      ((IRIJAdShakeManager)QRoute.api(IRIJAdShakeManager.class)).unRegisterListener();
      return;
    }
    this.aa.setVisibility(0);
    ((IRIJAdShakeManager)QRoute.api(IRIJAdShakeManager.class)).registerListener(this.g, b());
  }
  
  private void d(boolean paramBoolean)
  {
    if (!aj()) {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.s.getLayoutParams();
    if (paramBoolean)
    {
      localLayoutParams.width = DisplayUtil.a(this.g, 91.0F);
      localLayoutParams.height = DisplayUtil.a(this.g, 28.0F);
      localLayoutParams.rightMargin = DisplayUtil.a(this.g, 16.0F);
      localLayoutParams.topMargin = DisplayUtil.a(this.g, 16.0F);
    }
    else
    {
      localLayoutParams.width = DisplayUtil.a(this.g, 78.0F);
      localLayoutParams.height = DisplayUtil.a(this.g, 24.0F);
      localLayoutParams.rightMargin = DisplayUtil.a(this.g, 8.0F);
      localLayoutParams.topMargin = DisplayUtil.a(this.g, 8.0F);
    }
    this.s.setLayoutParams(localLayoutParams);
  }
  
  private void e(int paramInt)
  {
    if (this.B.getVisibility() == 0) {
      VideoFeedsHelper.a(this.B, 8, 300);
    }
    this.az.removeMessages(103);
    this.A.clearAnimation();
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        this.A.setVisibility(0);
        this.A.startAnimation(this.am);
        this.A.setImageDrawable(this.g.getResources().getDrawable(2130844325));
        this.A.setTag(Integer.valueOf(3));
        return;
      }
      this.A.setImageDrawable(this.g.getResources().getDrawable(2130844326));
      this.A.setTag(Integer.valueOf(2));
      if (!S()) {
        VideoFeedsHelper.a(this.A, 0, 300);
      }
    }
    else
    {
      this.A.setImageDrawable(this.g.getResources().getDrawable(2130844327));
      this.A.setTag(Integer.valueOf(1));
      if (!S()) {
        VideoFeedsHelper.a(this.A, 0, 300);
      }
    }
  }
  
  private void e(View paramView)
  {
    int i2 = ((Integer)paramView.getTag()).intValue();
    int i1 = 0;
    if (i2 != 1)
    {
      if (i2 == 2) {
        this.m.e(true);
      }
    }
    else
    {
      if (!VideoAutoPlayController.getInstance().canAutoPlayVideo()) {
        VideoVolumeControl.getInstance().setMute(false, "noAutoPlayClickVideoInReadInjoy", 1);
      }
      this.m.f(true);
    }
    if (2 == i2) {
      i1 = 1;
    }
    ThreadManager.executeOnSubThread(new VideoUIManager.10(this, i1));
  }
  
  private void e(VideoPlayParam paramVideoPlayParam, int paramInt, Object paramObject)
  {
    if (paramInt == 0)
    {
      this.D.setVisibility(8);
      O();
      e(3);
      this.L.setVisibility(8);
    }
    else if (paramInt == 3)
    {
      e(3);
    }
    this.az.removeMessages(102);
    this.az.removeMessages(103);
  }
  
  private void f(int paramInt)
  {
    if (this.L.getVisibility() != 0) {
      this.L.setVisibility(0);
    }
    this.L.setEnabled(false);
    this.L.setProgress(paramInt);
    this.az.removeMessages(104);
    this.az.sendEmptyMessageDelayed(104, 1500L);
  }
  
  private void f(VideoPlayParam paramVideoPlayParam, int paramInt, Object paramObject)
  {
    if (S()) {
      e(1);
    }
    if (this.l.M) {
      e(1);
    }
    this.az.removeMessages(100);
    this.az.removeMessages(101);
    this.az.removeMessages(102);
    this.az.removeMessages(103);
    if (am())
    {
      this.aa.d();
      ((IRIJAdShakeManager)QRoute.api(IRIJAdShakeManager.class)).unRegisterListener();
    }
  }
  
  private void g(int paramInt)
  {
    if (this.M.getVisibility() != 8) {
      this.M.setVisibility(8);
    }
    if (this.N.getVisibility() != 0)
    {
      this.N.setVisibility(0);
      this.N.setImageResource(2130844276);
    }
    if (paramInt == 0) {
      this.N.setEnabled(false);
    } else {
      this.N.setEnabled(true);
    }
    if (this.E.getVisibility() != 8) {
      this.E.setVisibility(8);
    }
    if (this.G.getVisibility() != 8) {
      this.G.setVisibility(8);
    }
    this.F.setEnabled(false);
    this.F.setProgress(paramInt);
    this.az.removeMessages(101);
    this.az.removeMessages(105);
    this.az.sendEmptyMessageDelayed(105, 1500L);
  }
  
  private void g(VideoPlayParam paramVideoPlayParam, int paramInt, Object paramObject)
  {
    this.az.removeMessages(102);
    this.az.removeMessages(101);
    this.az.removeMessages(103);
    this.r.removeAllViews();
    if ((paramObject instanceof int[]))
    {
      paramVideoPlayParam = (int[])paramObject;
      a(1, VideoPlayUtils.b(paramVideoPlayParam[0], paramVideoPlayParam[1]), HardCodeUtil.a(2131913610));
    }
  }
  
  private void h(int paramInt)
  {
    if (ag()) {
      return;
    }
    if (this.aE)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.readinjoy.videoVideoUIManager", 2, "showDownloadBar(): mDownloadBarClicked, just jump.");
      }
      return;
    }
    if (paramInt != 1)
    {
      if (paramInt == 2) {
        af();
      }
    }
    else {
      ab();
    }
    Object localObject = this.l;
    if ((localObject != null) && (((VideoPlayParam)localObject).D != null))
    {
      int i1 = this.aC;
      if (i1 == 1) {
        localObject = "0X8009BC4";
      }
      for (;;)
      {
        break;
        if (i1 == 2) {
          localObject = "0X8009BC6";
        } else {
          localObject = "";
        }
      }
      VideoR5.Builder localBuilder = new VideoR5.Builder("", this.l.A, this.l.d, this.l.D.innerUniqueID);
      localBuilder.a((int)this.l.f);
      articlesummary.VideoDownloadBarInfo localVideoDownloadBarInfo = this.aD;
      if ((localVideoDownloadBarInfo != null) && (localVideoDownloadBarInfo.msg_url_jump_info.has()) && (this.aD.msg_url_jump_info.get() != null)) {
        localBuilder.b(RIJPBFieldUtils.d(((articlesummary.UrlJumpInfo)this.aD.msg_url_jump_info.get()).bytes_common_data));
      }
      PublicAccountReportUtils.a(null, "", (String)localObject, (String)localObject, 0, 0, "3", "", "", localBuilder.b().a(), false);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showDownloadBar(), barStyle:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Q.readinjoy.videoVideoUIManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void h(VideoPlayParam paramVideoPlayParam, int paramInt, Object paramObject)
  {
    if ((!c(paramVideoPlayParam)) && (this.n.d()) && (this.l.Q))
    {
      this.n.a(paramVideoPlayParam);
      return;
    }
    if (this.aC == 2)
    {
      VideoAutoPlayController.sPauseScrollToNextVideo = true;
      h(2);
      this.az.removeCallbacksAndMessages(null);
    }
    else
    {
      b(false);
      k();
    }
    if (paramVideoPlayParam.D.patchStatus.a.get() == 1) {
      return;
    }
    boolean bool;
    if ((this.f.getFirstVisiblePosition() == 0) && (this.f.getChildAt(1) != null) && ((this.f.getChildAt(1).getTag() instanceof VideoFeedsViewHolder))) {
      bool = true;
    } else {
      bool = false;
    }
    ((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).playPostPatchAd(paramVideoPlayParam, this, bool, false, this.aF, this.n, this.a);
  }
  
  private void i(int paramInt)
  {
    View localView;
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      localView = this.S;
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
    else
    {
      localView = this.P;
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
  }
  
  public ReadInJoyAdBubbleNativeView A()
  {
    return this.ab;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onOrientationChanged=> orientation=");
      localStringBuilder.append(paramInt);
      QLog.d("Q.readinjoy.videoVideoUIManager", 2, localStringBuilder.toString());
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 8)
        {
          if (paramInt != 9) {
            return;
          }
          b(false);
          return;
        }
        b(8);
        return;
      }
      b(false);
      return;
    }
    b(0);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.e.getVisibility() != 0) {
      return;
    }
    int i1 = this.m.j();
    Object localObject;
    if ((i1 != 0) && (i1 != 1) && (i1 != 7) && (i1 != 2) && (i1 != 4))
    {
      if (this.aj) {
        return;
      }
      this.aj = true;
      a(true, this.m.a(), null);
      c(true);
      this.as = this.m.l();
      if ((paramBoolean) && (c(this.l)))
      {
        if (this.ai.a(false)) {
          this.ao = true;
        }
      }
      else if (paramInt == 0) {
        this.g.setRequestedOrientation(0);
      } else {
        this.g.setRequestedOrientation(8);
      }
      localObject = this.g.getWindow();
      ((Window)localObject).setFlags(1024, 1024);
      if ((this.e.getParent() instanceof ViewGroup))
      {
        this.aw = ((ViewGroup)this.e.getParent());
        this.ax = this.aw.indexOfChild(this.e);
        this.l.i.b();
        this.aw.removeView(this.e);
        this.l.i.c();
        ((Window)localObject).addContentView(this.e, new ViewGroup.LayoutParams(-1, -1));
      }
      this.ak = this.e.getWidth();
      this.al = this.e.getHeight();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("FullScreen => mOriginalWidth=");
        ((StringBuilder)localObject).append(this.ak);
        ((StringBuilder)localObject).append(", mOriginalHeight=");
        ((StringBuilder)localObject).append(this.al);
        ((StringBuilder)localObject).append(", playState=");
        ((StringBuilder)localObject).append(VideoPlayUtils.a(i1));
        ((StringBuilder)localObject).append("，userClickEnter:");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.d("Q.readinjoy.videoVideoUIManager", 2, ((StringBuilder)localObject).toString());
      }
      J();
      this.e.setTranslationY(0.0F);
      K();
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("innerEnterFullScreen => playState=");
      ((StringBuilder)localObject).append(VideoPlayUtils.a(i1));
      ((StringBuilder)localObject).append(", illegal state just ignore fullscreen.");
      QLog.e("Q.readinjoy.videoVideoUIManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(View paramView)
  {
    if (r())
    {
      t();
      return;
    }
    s();
  }
  
  public void a(View paramView, int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      if (r())
      {
        t();
        if (this.m.s()) {
          this.aB = true;
        }
      }
    }
    else if (this.aB)
    {
      s();
      this.aB = false;
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2) {}
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper, VideoPlayParam paramVideoPlayParam) {}
  
  public void a(CountDownCallback paramCountDownCallback)
  {
    this.aF = paramCountDownCallback;
  }
  
  public void a(VideoUIManager.OnScreenChangeListener paramOnScreenChangeListener)
  {
    if (this.ap == null) {
      this.ap = new ArrayList();
    }
    if (!this.ap.contains(paramOnScreenChangeListener)) {
      this.ap.add(paramOnScreenChangeListener);
    }
  }
  
  public void a(OnUIChangeListener paramOnUIChangeListener)
  {
    this.ar.add(paramOnUIChangeListener);
  }
  
  public void a(VideoPlayParam paramVideoPlayParam)
  {
    VideoFeedsHelper.a(this.u, 8, 300);
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, IVideoPlayerWrapper paramIVideoPlayerWrapper, int paramInt1, int paramInt2, Object paramObject)
  {
    paramIVideoPlayerWrapper = this.l;
    if ((paramIVideoPlayerWrapper != null) && (paramVideoPlayParam != null) && (paramIVideoPlayerWrapper == paramVideoPlayParam))
    {
      if (paramInt2 == 0)
      {
        a(paramVideoPlayParam, paramInt1, paramObject);
        return;
      }
      if (paramInt2 == 1)
      {
        b(paramVideoPlayParam, paramInt1, paramObject);
        return;
      }
      if (paramInt2 == 2)
      {
        c(paramVideoPlayParam, paramInt1, paramObject);
        return;
      }
      if (paramInt2 == 3)
      {
        d(paramVideoPlayParam, paramInt1, paramObject);
        return;
      }
      if (paramInt2 == 4)
      {
        e(paramVideoPlayParam, paramInt1, paramObject);
        return;
      }
      if (paramInt2 == 5)
      {
        f(paramVideoPlayParam, paramInt1, paramObject);
        return;
      }
      if (paramInt2 == 6)
      {
        g(paramVideoPlayParam, paramInt1, paramObject);
        return;
      }
      if (paramInt2 == 7) {
        h(paramVideoPlayParam, paramInt1, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.videoVideoUIManager", 2, "onStateChange(): mPlayingVideoParam and videoPlayParam not equal, just return;");
    }
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, boolean paramBoolean) {}
  
  public void a(VideoFullPlayController.OnFullPlayListener paramOnFullPlayListener)
  {
    this.n.a(paramOnFullPlayListener);
  }
  
  public void a(VideoPlayManager paramVideoPlayManager)
  {
    this.m = paramVideoPlayManager;
    this.m.a(this);
    this.m.a(this);
    if (this.t == null) {
      this.t = ((VideoFeedsGestureLayout)this.e.findViewById(2131434168));
    }
    this.t.setChannelID(this.m.o());
    this.t.setVideoPlayManager(paramVideoPlayManager);
    this.n.a(paramVideoPlayManager);
  }
  
  public void a(AbsListView paramAbsListView)
  {
    if (c()) {
      return;
    }
    int i3 = ((ReadInJoyBaseListView)paramAbsListView).getHeaderViewsCount();
    int i2 = paramAbsListView.getFirstVisiblePosition() - i3;
    int i1 = i2;
    if (i2 < 0) {
      i1 = 0;
    }
    i2 = paramAbsListView.getLastVisiblePosition() - i3;
    paramAbsListView = this.m;
    if ((paramAbsListView != null) && (paramAbsListView.a() != null))
    {
      i3 = this.m.a().e;
      if ((i3 >= 0) && ((i3 < i1) || (i3 > i2)))
      {
        if (QLog.isColorLevel())
        {
          paramAbsListView = new StringBuilder();
          paramAbsListView.append("triggerVideoRecycleCheck => stop video，firstVisblePosi:");
          paramAbsListView.append(i1);
          paramAbsListView.append(",lastVisiblePosi:");
          paramAbsListView.append(i2);
          paramAbsListView.append(",playingPosi:");
          paramAbsListView.append(i3);
          QLog.d("Q.readinjoy.videoVideoUIManager", 2, paramAbsListView.toString());
        }
        if (QLog.isColorLevel())
        {
          paramAbsListView = new StringBuilder();
          paramAbsListView.append("triggerVideoRecycleCheck => stop video，playParam:");
          paramAbsListView.append(this.m.a());
          QLog.d("Q.readinjoy.videoVideoUIManager", 2, paramAbsListView.toString());
        }
        this.m.a(ReportConstants.VideoEndType.SLIDE_LEAVE);
        this.m.a(10);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.ai;
    if (localObject != null) {
      ((OrientationDetector)localObject).a(paramBoolean);
    }
    if (this.ai != null)
    {
      localObject = this.l;
      if ((localObject != null) && (((VideoPlayParam)localObject).M))
      {
        this.ai.a(false);
        this.ao = false;
      }
    }
  }
  
  public VideoPlayParam b()
  {
    return this.l;
  }
  
  public void b(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void b(View paramView) {}
  
  public void b(OnUIChangeListener paramOnUIChangeListener)
  {
    this.ar.remove(paramOnUIChangeListener);
  }
  
  public void b(VideoPlayParam paramVideoPlayParam)
  {
    this.l = paramVideoPlayParam;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("playVideo(): videoPlayParam=");
      ((StringBuilder)localObject).append(paramVideoPlayParam);
      QLog.d("Q.readinjoy.videoVideoUIManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.l;
    if ((localObject != null) && (((VideoPlayParam)localObject).M))
    {
      a(false);
      this.ao = false;
    }
    C();
    H();
    I();
    m();
    if ((am()) && (!((IRIJAdShakeManager)QRoute.api(IRIJAdShakeManager.class)).hasShake()))
    {
      paramVideoPlayParam = (AdvertisementInfo)paramVideoPlayParam.D;
      ((IRIJAdShakeManager)QRoute.api(IRIJAdShakeManager.class)).setVideoPlayerManager(this.m);
      this.az.removeCallbacks(this.ay);
      this.az.postDelayed(this.ay, paramVideoPlayParam.shakeAppearTime);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.e.getVisibility() != 0) {
      return;
    }
    if (!this.aj) {
      return;
    }
    this.aj = false;
    this.n.e();
    c(false);
    this.g.setRequestedOrientation(1);
    Object localObject = this.g.getWindow();
    ((Window)localObject).clearFlags(1024);
    ((Window)localObject).addFlags(this.b);
    ((Window)localObject).getDecorView().setSystemUiVisibility(this.c);
    if ((this.e.getParent() instanceof ViewGroup))
    {
      this.l.i.b();
      ((ViewGroup)this.e.getParent()).removeView(this.e);
      this.l.i.c();
      this.aw.addView(this.e, this.ax, new ViewGroup.LayoutParams(-1, -1));
      this.aw = null;
    }
    t();
    localObject = this.e.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = this.ak;
    ((ViewGroup.LayoutParams)localObject).height = this.al;
    this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.r.a(true);
    this.t.setIsInFullScreen(false);
    this.t.a();
    if (this.ao) {
      this.ai.a(true);
    }
    this.m.c(this.as);
    this.e.setBackgroundColor(0);
    if ((this.n.b() != null) && ((this.n.b() instanceof VideoPlayParam))) {
      a(false, (VideoPlayParam)this.n.b(), this.l);
    }
    d(false);
    if (paramBoolean) {
      W();
    }
    l();
    m();
  }
  
  public void c(int paramInt)
  {
    if (this.L != null)
    {
      if (this.l == null) {
        return;
      }
      VideoVolumeControl.getInstance().adjustMediaVolume(paramInt);
      paramInt = (int)(VideoVolumeControl.getInstance().getMediaVolumeProgress() * this.l.l);
      if (r())
      {
        g(paramInt);
        return;
      }
      f(paramInt);
    }
  }
  
  public void c(View paramView)
  {
    if (paramView.getTag() != null)
    {
      if (!(paramView.getTag() instanceof PlayableItem)) {
        return;
      }
      int i1 = this.m.j();
      Object localObject1 = (PlayableItem)paramView.getTag();
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleItemClick():  playState=");
        ((StringBuilder)localObject2).append(VideoPlayUtils.a(i1));
        ((StringBuilder)localObject2).append(", view id: ");
        ((StringBuilder)localObject2).append(VideoFeedsHelper.b(paramView));
        QLog.d("Q.readinjoy.videoVideoUIManager", 2, ((StringBuilder)localObject2).toString());
      }
      if ((i1 == 7) && (ag()))
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.readinjoy.videoVideoUIManager", 2, "handleItemClick():  complete && isDownloadBarShowing, just return.");
        }
        return;
      }
      if (this.m.a() == null)
      {
        if (!VideoAutoPlayController.getInstance().canAutoPlayVideo()) {
          VideoVolumeControl.getInstance().setMute(false, "noAutoPlayClickVideoInReadInjoy", 1);
        }
        this.m.a(((PlayableItem)localObject1).a());
        paramView = ((PlayableItem)localObject1).a().D;
        if ((paramView != null) && (paramView.mChannelID == 56L) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramView)))
        {
          localObject2 = (AdvertisementInfo)paramView;
          ((AdvertisementInfo)localObject2).adbt = ((int)((PlayableItem)localObject1).a().k);
          ((AdvertisementInfo)localObject2).adpa = 1;
          ((AdvertisementInfo)localObject2).adpb = 2;
          ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.g).a(6).b(4).a((AdvertisementInfo)localObject2).a(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getVideoInfoObject(((AdvertisementInfo)localObject2).adbt, 0, ((AdvertisementInfo)localObject2).getAdbf(), 0, 1, 2, paramView.mVideoDuration * 1000, 9, 0, ((AdvertisementInfo)localObject2).videoReplayCount, ReportConstants.VideoEndType.CLICK_PAUSE, ((AdvertisementInfo)localObject2).isClickReplay, false)));
          ((AdvertisementInfo)localObject2).isClickReplay = false;
        }
      }
      else
      {
        if (this.m.n() == ((PlayableItem)localObject1).a().j)
        {
          if (i1 == 1) {
            return;
          }
          if ((i1 == 5) && (M()))
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.readinjoy.videoVideoUIManager", 2, "handleItemClick():  paused && isErrorLayoutShowing, just return.");
            }
            return;
          }
          if (r())
          {
            t();
            return;
          }
          s();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.videoVideoUIManager", 2, "handleItemClick():  点击非当前播放的视频feeds，播放点击的视频");
        }
        this.m.a(ReportConstants.VideoEndType.AD_AREA_CLICK);
        this.m.a(2);
        this.m.a(((PlayableItem)localObject1).a());
        paramView = ((PlayableItem)localObject1).a().D;
        if ((paramView != null) && (paramView.mChannelID == 56L) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramView)))
        {
          localObject1 = (IRIJAdService)QRoute.api(IRIJAdService.class);
          localObject2 = new AdReportData().a(this.g).a(6).b(4);
          AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)paramView;
          ((IRIJAdService)localObject1).report(((AdReportData)localObject2).a(localAdvertisementInfo).a(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getVideoInfoObject(0, 0, 1, 0, 1, 2, paramView.mVideoDuration * 1000, 9, 0, localAdvertisementInfo.videoReplayCount, ReportConstants.VideoEndType.CLICK_PAUSE, localAdvertisementInfo.isClickReplay, false)));
          localAdvertisementInfo.isClickReplay = false;
          localAdvertisementInfo.adbt = 0;
          localAdvertisementInfo.adpa = 1;
          localAdvertisementInfo.adpb = 2;
        }
        if (!VideoAutoPlayController.getInstance().canAutoPlayVideo()) {
          VideoVolumeControl.getInstance().setMute(false, "noAutoPlayClickVideoInReadInjoy", 1);
        }
      }
    }
  }
  
  public void c(OnUIChangeListener paramOnUIChangeListener)
  {
    this.aq = paramOnUIChangeListener;
  }
  
  public boolean c()
  {
    if (this.e.getVisibility() != 0) {
      return false;
    }
    return this.aj;
  }
  
  public void g()
  {
    this.n.a();
    if (this.aE) {
      i(1);
    }
    if (b() != null)
    {
      Object localObject = b().D;
      if ((((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).resumeFromPrePatchHomeBack((AbsBaseArticleInfo)localObject)) || (((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).resumeFromPosPatchHomeBack((AbsBaseArticleInfo)localObject)))
      {
        ReadInJoyPatchAdView localReadInJoyPatchAdView = this.X;
        if (localReadInJoyPatchAdView != null) {
          localReadInJoyPatchAdView.b();
        }
      }
      if (((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).resumeFromPrePatchClickBack((AbsBaseArticleInfo)localObject)) {
        this.m.a(b());
      }
      if (((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).resumeFromPosPatchClickBack((AbsBaseArticleInfo)localObject))
      {
        localObject = this.aF;
        if (localObject != null)
        {
          ((CountDownCallback)localObject).a(b());
          this.n.a();
        }
      }
      if ((am()) && (!((IRIJAdShakeManager)QRoute.api(IRIJAdShakeManager.class)).isSurpriseVideoPlaying()) && (!((IRIJAdShakeManager)QRoute.api(IRIJAdShakeManager.class)).isComplainBackToFeeds())) {
        this.m.a(b());
      }
    }
    ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).updateLightBarText(this.l, this.Y);
    ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).updateGuideBtnText(this.l, this.Z);
  }
  
  public void h()
  {
    this.n.h();
    if (am()) {
      ((IRIJAdShakeManager)QRoute.api(IRIJAdShakeManager.class)).setEggVideoState(true);
    }
  }
  
  public void i()
  {
    ReadInJoyPatchAdView localReadInJoyPatchAdView = this.X;
    if (localReadInJoyPatchAdView != null) {
      localReadInJoyPatchAdView.c();
    }
  }
  
  public void j()
  {
    ReadInJoyPatchAdView localReadInJoyPatchAdView = this.X;
    if (localReadInJoyPatchAdView != null) {
      localReadInJoyPatchAdView.c();
    }
  }
  
  public void k()
  {
    if (am())
    {
      this.aa.d();
      this.az.removeCallbacks(this.ay);
      ((IRIJAdShakeManager)QRoute.api(IRIJAdShakeManager.class)).unRegisterListener();
      ((IRIJAdShakeManager)QRoute.api(IRIJAdShakeManager.class)).onDestory();
    }
    this.e.setVisibility(8);
    this.az.removeCallbacksAndMessages(null);
    B();
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.videoVideoUIManager", 2, "updateVideoViewSize");
    }
    if (this.l == null) {
      return;
    }
    float f1 = DeviceInfoUtil.h(this.g);
    if (this.l.M)
    {
      if (this.l.N > 0) {
        f1 = this.l.N;
      }
    }
    else {
      f1 = RIJComponentConfigImage.a(this.g, this.l);
    }
    float f2;
    if ((this.l != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdSmallVideo(this.l.D))) {
      f2 = this.l.h.getHeight();
    } else {
      f2 = ReadInJoyDisplayUtils.b(this.l.n, this.l.o) * f1;
    }
    if (this.n.d())
    {
      this.ak = ((int)f1);
      this.al = ((int)f2);
      J();
      return;
    }
    Object localObject;
    if ((this.e.getLayoutParams() instanceof FrameLayout.LayoutParams))
    {
      localObject = (FrameLayout.LayoutParams)this.e.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).width = ((int)f1);
      ((FrameLayout.LayoutParams)localObject).height = ((int)f2);
      ((FrameLayout.LayoutParams)localObject).gravity = 1;
      this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    else if ((this.e.getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      localObject = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = ((int)f1);
      ((RelativeLayout.LayoutParams)localObject).height = ((int)f2);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.r.a(true);
    if ((this.l != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdSmallVideo(this.l.D)))
    {
      this.r.setCustomSize(1.0F, f2 / f1);
      return;
    }
    this.r.setCustomSize(1.0F, ReadInJoyDisplayUtils.b(this.l.n, this.l.o));
  }
  
  @TargetApi(11)
  public void m()
  {
    if (this.e.getVisibility() != 0) {
      return;
    }
    if (this.aj) {
      return;
    }
    VideoPlayParam localVideoPlayParam = this.l;
    if (localVideoPlayParam != null)
    {
      if (localVideoPlayParam.h == null) {
        return;
      }
      this.f.getLocationOnScreen(this.k);
      this.j = this.k[1];
      this.l.h.getLocationOnScreen(this.k);
      if ((this.e.getX() != this.l.h.getX()) && (this.l.h.getX() != 0.0F)) {
        ViewHelper.g(this.e, this.k[0]);
      }
      if ((this.l.D != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdExpandLiveVideoCard(this.l.D))) {
        ViewHelper.g(this.e, this.k[0]);
      }
      float f1 = this.k[1] - this.j;
      if (f1 == this.e.getTranslationY()) {
        return;
      }
      ViewHelper.f(this.e, f1);
    }
  }
  
  public void n()
  {
    FrameLayout localFrameLayout = this.e;
    if (localFrameLayout != null) {
      localFrameLayout.setVisibility(8);
    }
  }
  
  public void o()
  {
    a(0, true);
  }
  
  public void onClick(View paramView)
  {
    int i1 = this.m.j();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onClick(): current playState=");
      ((StringBuilder)localObject).append(VideoPlayUtils.a(i1));
      ((StringBuilder)localObject).append(", view id: ");
      ((StringBuilder)localObject).append(VideoFeedsHelper.b(paramView));
      QLog.d("Q.readinjoy.videoVideoUIManager", 2, ((StringBuilder)localObject).toString());
    }
    if (paramView.getId() == 2131433912)
    {
      d(paramView);
      return;
    }
    if (paramView.getId() == 2131439638)
    {
      e(paramView);
      return;
    }
    if (paramView.getId() == 2131432590)
    {
      if (this.m.s())
      {
        this.m.f(true);
        return;
      }
      if (this.m.j() == 6)
      {
        paramView = this.l;
        if (paramView != null)
        {
          PlayFeedbackHelper.b(paramView.a(), 0);
          this.m.a(this.l);
        }
      }
    }
    else
    {
      if (paramView.getId() == 2131433911)
      {
        p();
        return;
      }
      if ((paramView.getId() != 2131449774) && (paramView.getId() != 2131449775))
      {
        if (paramView.getId() == 2131444631)
        {
          this.p.a();
          this.m.a(this.l);
          paramView = this.l;
          if ((paramView != null) && (paramView.D != null))
          {
            paramView = new VideoR5.Builder("", this.l.A, this.l.d, this.l.D.innerUniqueID);
            paramView.a((int)this.l.f);
            PublicAccountReportUtils.a(null, "", "0X8009BC8", "0X8009BC8", 0, 0, "3", "", "", paramView.b().a(), false);
            paramView = (AdvertisementInfo)this.l.D;
            paramView.videoReplayCount += 1;
          }
        }
        else if ((paramView.getId() != 2131432110) && (paramView.getId() != 2131432117))
        {
          if (paramView.getId() == 2131449655)
          {
            V();
            return;
          }
          if (paramView.getId() == 2131427746) {
            U();
          }
        }
        else
        {
          ae();
        }
      }
      else
      {
        boolean bool = VideoVolumeControl.getInstance().isMute() ^ true;
        VideoVolumeControl.getInstance().setMute(bool, "user click audio btn", 1);
        paramView = this.l;
        if ((paramView != null) && (paramView.D != null))
        {
          localObject = new VideoR5.Builder("", this.l.A, this.l.d, this.l.D.innerUniqueID);
          ((VideoR5.Builder)localObject).a((int)this.l.f);
          if (bool) {
            paramView = "1";
          } else {
            paramView = "0";
          }
          ((VideoR5.Builder)localObject).b("status", paramView);
          PublicAccountReportUtils.a(null, "", "0X8009BD6", "0X8009BD6", 0, 0, "3", "", "", ((VideoR5.Builder)localObject).b().a(), false);
        }
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = paramInt2 + paramInt1 - 1;
    paramInt3 = this.h;
    if ((paramInt3 == -1) || (paramInt3 == paramInt1))
    {
      paramInt3 = this.i;
      if ((paramInt3 == -1) || (paramInt3 == paramInt2)) {}
    }
    else
    {
      a(paramAbsListView);
    }
    this.h = paramInt1;
    this.i = paramInt2;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      a(paramAbsListView);
    }
  }
  
  public void p()
  {
    b(true);
  }
  
  public boolean q()
  {
    RelativeLayout localRelativeLayout = this.v;
    boolean bool = false;
    if (localRelativeLayout == null) {
      return false;
    }
    if (localRelativeLayout.getVisibility() == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean r()
  {
    RelativeLayout localRelativeLayout = this.D;
    boolean bool = false;
    if (localRelativeLayout == null) {
      return false;
    }
    if (localRelativeLayout.getVisibility() == 0) {
      bool = true;
    }
    return bool;
  }
  
  public void s()
  {
    RelativeLayout localRelativeLayout = this.D;
    if (localRelativeLayout != null)
    {
      if (localRelativeLayout.getVisibility() == 0) {
        return;
      }
      if (c())
      {
        this.I.setVisibility(0);
        this.N.setVisibility(8);
        this.M.setVisibility(8);
      }
      else
      {
        this.I.setVisibility(8);
        this.w.setVisibility(8);
        if (this.v.getVisibility() != 0) {
          VideoFeedsHelper.a(this.v, 0, 300);
        }
        this.N.setVisibility(8);
        a(this.M);
      }
      int i1 = this.m.j();
      if (i1 == 5) {
        e(1);
      } else if (i1 == 3) {
        e(2);
      }
      this.p.a();
      VideoFeedsHelper.a(this.D, 0, 300);
      if (!this.q)
      {
        UIUtils.a(this.H, 10, 10, 10, 10);
        this.q = true;
      }
      this.L.setVisibility(8);
      this.O.setVisibility(8);
      this.az.removeMessages(100);
      ah();
      if (i1 == 5)
      {
        this.az.removeMessages(101);
      }
      else if (i1 == 3)
      {
        this.az.removeMessages(101);
        this.az.sendEmptyMessageDelayed(101, 3000L);
      }
      ThreadManager.executeOnSubThread(new VideoUIManager.7(this));
    }
  }
  
  public void t()
  {
    RelativeLayout localRelativeLayout = this.D;
    if (localRelativeLayout != null)
    {
      if (localRelativeLayout.getVisibility() != 0) {
        return;
      }
      VideoFeedsHelper.a(this.v, 8, 300);
      this.A.clearAnimation();
      VideoFeedsHelper.a(this.A, 8, 300);
      VideoFeedsHelper.a(this.D, 8, 300);
      if ((!c()) && (7 != this.m.j())) {
        this.L.setVisibility(0);
      } else {
        this.L.setVisibility(8);
      }
      this.F.setEnabled(true);
    }
  }
  
  public void u()
  {
    String str = HardCodeUtil.a(2131913612);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(VideoFeedsHelper.c(this.l.D.mXGFileSize));
    localStringBuilder.append(HardCodeUtil.a(2131913609));
    a(0, str, localStringBuilder.toString());
  }
  
  public void v()
  {
    Object localObject = this.n;
    if (localObject != null)
    {
      ((VideoFullPlayController)localObject).i();
      this.n = null;
    }
    this.m.b(this);
    this.az.removeCallbacksAndMessages(null);
    this.l = null;
    localObject = this.ai;
    if (localObject != null)
    {
      ((OrientationDetector)localObject).b();
      this.ai = null;
    }
    this.ao = false;
    localObject = this.o;
    if (localObject != null) {
      ((VideoBrightnessController)localObject).d();
    }
    if (this.a != null) {
      this.a = null;
    }
  }
  
  public ReadInJoyPatchAdView w()
  {
    return this.X;
  }
  
  public VideoPlayManager x()
  {
    return this.m;
  }
  
  public ReadInJoyVideoAdHighLightBar y()
  {
    return this.Y;
  }
  
  public ReadInJoyAdVideoGuide z()
  {
    return this.Z;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoUIManager
 * JD-Core Version:    0.7.0.1
 */