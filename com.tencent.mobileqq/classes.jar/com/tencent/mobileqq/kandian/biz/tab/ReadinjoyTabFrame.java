package com.tencent.mobileqq.kandian.biz.tab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.gdtad.util.GdtManager;
import com.tencent.gdtad.util.GdtManager.Params;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJSuperMaskService;
import com.tencent.mobileqq.kandian.base.report.ReadInJoyDataProviderObserver;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.base.view.widget.ClipDianDianTouchAreaLayout;
import com.tencent.mobileqq.kandian.base.view.widget.DuplicateEventLayout;
import com.tencent.mobileqq.kandian.base.view.widget.ReadinjoySlidingIndicator;
import com.tencent.mobileqq.kandian.base.view.widget.ReadinjoySlidingIndicator.OnIndicatorChangeListener;
import com.tencent.mobileqq.kandian.base.view.widget.ReadinjoyViewLayer;
import com.tencent.mobileqq.kandian.base.view.widget.TwoLineContentDialog;
import com.tencent.mobileqq.kandian.biz.comment.RIJCommentResultDispatcher;
import com.tencent.mobileqq.kandian.biz.common.RIJTabFrameBase;
import com.tencent.mobileqq.kandian.biz.common.RIJTabFrameBase.Companion;
import com.tencent.mobileqq.kandian.biz.common.RIJWindowUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyDialogUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment.OnNofityVisibleCallback;
import com.tencent.mobileqq.kandian.biz.diandian.DailyFeedsDiandianEntranceManager;
import com.tencent.mobileqq.kandian.biz.diandian.RecommendFeedsDiandianEntranceManager;
import com.tencent.mobileqq.kandian.biz.feeds.channelbanner.RIJChannelReporter;
import com.tencent.mobileqq.kandian.biz.feeds.channelbanner.RIJDianDianEntryVisibleConfig;
import com.tencent.mobileqq.kandian.biz.feeds.channelbanner.RIJDianDianEntryVisibleConfig.Companion;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyTabTopSearchHeaderController;
import com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyRecommendFeedsFragment;
import com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoySubChannelFragment;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.UserActionCollector;
import com.tencent.mobileqq.kandian.biz.framework.api.impl.ReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.biz.framework.click.RIJListViewGroupHandlerClick;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsFirstVideoRecommendationManager;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.privatechat.api.impl.RIJPrivateChatServiceImpl;
import com.tencent.mobileqq.kandian.biz.privatechat.api.impl.RIJPrivateChatServiceImpl.Companion;
import com.tencent.mobileqq.kandian.biz.push.OnTabRedNumsChangeListenner;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.push.RIJPushNotification;
import com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyManager;
import com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyManager.Companion;
import com.tencent.mobileqq.kandian.biz.reddot.ColorBandVideoEntranceButton;
import com.tencent.mobileqq.kandian.biz.reddot.OnEntryIconRefreshListener;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskLocalRepo;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoyRefreshManager;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinManager;
import com.tencent.mobileqq.kandian.biz.skin.SlideActiveAnimController;
import com.tencent.mobileqq.kandian.biz.ugc.KandianVideoUploadService;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.biz.video.FeedsChannelDataHelper;
import com.tencent.mobileqq.kandian.biz.video.discovery.BubblePopupWindow;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.EntranceDownloadInfo;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyWebRenderEngine;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.glue.report.RIJKanDianTabReport;
import com.tencent.mobileqq.kandian.glue.report.RIJMsgReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.kandian.glue.router.msgbox.api.impl.RIJMsgBoxUtils;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJKanDianOverDrawOptimizeAladdinConfig;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJKanDianYaobuIconClickReportAladdinConfig;
import com.tencent.mobileqq.kandian.repo.common.FreeNetFlowInfoModule;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.diandian.EntranceIconInfo;
import com.tencent.mobileqq.kandian.repo.diandian.IEntranceButtonDataSource;
import com.tencent.mobileqq.kandian.repo.diandian.RIJColumnDataSource;
import com.tencent.mobileqq.kandian.repo.diandian.ReadInJoyDianDianEntranceModule;
import com.tencent.mobileqq.kandian.repo.feeds.ChannelCoverInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.FeedsSPUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJStudyModeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.SelectPositionModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PositionData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.kandian.repo.push.api.MessageObserver;
import com.tencent.mobileqq.kandian.repo.reddot.KandianMsgBoxRedPntInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ReportPolicy;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadinjoyTabFrame
  extends RIJTabFrameBase
  implements ViewTreeObserver.OnGlobalLayoutListener, ReadinjoySlidingIndicator.OnIndicatorChangeListener, ReadInJoyBaseFragment.OnNofityVisibleCallback, OnTabRedNumsChangeListenner, OnEntryIconRefreshListener, IReadInJoyUserInfoModule.RefreshUserInfoCallBack, MessageObserver
{
  private static int I = 0;
  public static boolean f = false;
  public static int g;
  private TextView A;
  private int B;
  private SparseArray<Bundle> C = new SparseArray();
  private long D = 0L;
  private FrameLayout E;
  private ReadInJoyBaseFragment F;
  private FragmentManager G;
  private ConcurrentHashMap<Integer, ReadInJoySubChannelFragment> H = new ConcurrentHashMap();
  private boolean J = false;
  private long K = 0L;
  private VideoFeedsFirstVideoRecommendationManager L;
  private ReadInJoyChannelViewPager M;
  private ReadInJoyChannelViewPager.CustomFragmentPagerAdapter N;
  private ViewGroup O;
  private ReadInJoyChannelViewPagerController P;
  private View Q;
  private TextView R;
  private BubblePopupWindow S;
  private FrameFragment T;
  private boolean U = false;
  private ReadinjoyTabFrame.InitWebProcessRunnable V = new ReadinjoyTabFrame.InitWebProcessRunnable();
  private RelativeLayout W;
  private ImageView X;
  private ImageView Y;
  private View Z;
  private ChannelCoverInfo aa;
  private Handler ab = new ReadinjoyTabFrame.17(this);
  private boolean ac = false;
  private ReadInJoyObserver ad = new ReadinjoyTabFrame.19(this);
  private boolean ae = false;
  private View.OnClickListener af = new ReadinjoyTabFrame.26(this);
  protected ReadInJoyTabTopSearchHeaderController e;
  public Runnable h = new ReadinjoyTabFrame.13(this);
  private View i;
  private View j;
  private View k;
  private ReadinjoySlidingIndicator l;
  private String[] m = new String[1];
  private int[] n = new int[1];
  private View o;
  private ImmersiveTitleBar2 p;
  private RedTouch q;
  private View r;
  private ImageView s;
  private ImageView t;
  private ReadinjoyViewLayer u;
  private ColorBandVideoEntranceButton v;
  private ClipDianDianTouchAreaLayout w;
  private DuplicateEventLayout x;
  private View y;
  private TextView z;
  
  public ReadinjoyTabFrame(FrameFragment paramFrameFragment)
  {
    super(paramFrameFragment);
    this.T = paramFrameFragment;
  }
  
  public static void E()
  {
    RIJTabFrameDeliverPopupUtil.a("0X800AC6D", 3);
  }
  
  private void F()
  {
    ac();
    U();
    RecommendFeedsDiandianEntranceManager.getInstance().onAccountChange();
    VideoFeedsFirstVideoRecommendationManager localVideoFeedsFirstVideoRecommendationManager = this.L;
    if (localVideoFeedsFirstVideoRecommendationManager != null) {
      localVideoFeedsFirstVideoRecommendationManager.d();
    }
  }
  
  private void G()
  {
    d(2131447745).setBackgroundDrawable(null);
    this.e = new ReadInJoyTabTopSearchHeaderController(P(), (ViewGroup)d(2131447745));
    this.E = ((FrameLayout)d(2131444249));
    this.M = ((ReadInJoyChannelViewPager)d(2131444266));
    this.O = ((ViewGroup)d(2131444246));
    this.W = ((RelativeLayout)d(2131446495));
    this.X = ((ImageView)d(2131444863));
    this.Y = ((ImageView)d(2131430742));
    this.j = d(2131447484);
    this.l = ((ReadinjoySlidingIndicator)d(2131446094));
    Y();
    this.l.setTabData(this.m, this.n, ReadInJoyNaviController.d);
    this.l.setOnIndicatorChangeListener(this);
    int i1 = 1;
    this.ac = true;
    this.p = ((ImmersiveTitleBar2)d(2131447582));
    this.o = d(2131446342);
    this.s = ((ImageView)d(2131444332));
    this.t = ((ImageView)d(2131444331));
    this.Z = d(2131445434);
    this.z = ((TextView)d(2131448726));
    this.A = ((TextView)d(2131448725));
    if (RIJKanDianOverDrawOptimizeAladdinConfig.a())
    {
      QLog.d("ReadInJoyTabFrame", 2, "overdraw switch open");
      localObject = this.E;
      if (localObject != null) {
        ((FrameLayout)localObject).setBackgroundColor(Q().getColor(2131168464));
      }
      localObject = this.M;
      if (localObject != null) {
        ((ReadInJoyChannelViewPager)localObject).setBackgroundColor(Q().getColor(2131168376));
      }
    }
    else
    {
      QLog.d("ReadInJoyTabFrame", 2, "overdraw switch close");
    }
    boolean bool = RIJUgcUtils.l();
    int i2 = 8;
    if (bool) {
      this.t.setVisibility(0);
    } else {
      this.t.setVisibility(8);
    }
    if (RIJMsgBoxUtils.a() != 0) {
      i1 = 0;
    }
    Object localObject = d(2131438956);
    if (i1 != 0) {
      i2 = 0;
    }
    ((View)localObject).setVisibility(i2);
    this.Q = d(2131444303);
    this.R = ((TextView)d(2131438917));
    i1 = AIOUtils.b(3.0F, Q());
    this.R.setPadding(i1, 0, i1, 0);
    this.Q.setOnClickListener(new ReadinjoyTabFrame.1(this));
    this.q = new RedTouch(P().getBaseContext(), d(2131439465)).c(53).a();
    VideoReport.setElementId(this.q, "head_sculpture_button");
    VideoReport.setElementReportPolicy(this.q, ReportPolicy.REPORT_POLICY_CLICK);
    VideoReport.setElementParams(this.q, new RIJDtParamBuilder().a("14").c("click_head_sculpture").a().c());
    this.q.setOnClickListener(new ReadinjoyTabFrame.2(this));
    this.X.setOnClickListener(new ReadinjoyTabFrame.3(this));
    this.t.setOnClickListener(new ReadinjoyTabFrame.4(this));
    IphoneTitleBarActivity.setLayerType(this.p);
    IphoneTitleBarActivity.setLayerType(this.o);
    cP_();
    da_();
    K();
    J();
    localObject = (ViewGroup)this.u.findViewById(2131431265);
    this.x.setViews((ViewGroup)localObject, this.w);
    O();
    if ("2225164739".equals(t().getCurrentAccountUin())) {
      this.q.setOnLongClickListener(new ReadinjoyTabFrame.5(this));
    }
    w();
  }
  
  private void H()
  {
    if (this.t == null) {
      return;
    }
    boolean bool = RIJUgcUtils.l();
    if (bool) {
      this.t.setVisibility(0);
    } else {
      this.t.setVisibility(8);
    }
    if ((QLog.isDebugVersion()) || (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[refreshDeliverButton] needShow = ");
      localStringBuilder.append(bool);
      QLog.i("ReadInJoyTabFrame", 2, localStringBuilder.toString());
    }
  }
  
  private void I()
  {
    SelectPositionModule localSelectPositionModule = ReadInJoyLogicEngine.a().j();
    if (localSelectPositionModule != null) {
      localSelectPositionModule.d();
    }
  }
  
  private void J()
  {
    b(this.E);
    this.N = new ReadInJoyChannelViewPager.CustomFragmentPagerAdapter(this.G);
    this.N.a(this.e);
    this.M.setAdapter(this.N);
    this.P = new ReadInJoyChannelViewPagerController(P(), this.O, this.M);
    this.P.a(this.e);
    this.P.a(new ReadinjoyTabFrame.6(this));
  }
  
  private void K()
  {
    L();
  }
  
  private void L()
  {
    if (ReadInJoyHelper.w())
    {
      try
      {
        this.l.getTabsContainerBtnImage().clearAnimation();
        this.l.getTabsContainerBtnImage().setVisibility(0);
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
        QLog.d("ReadInJoyTabFrame", 1, "show channel entrance failed.");
      }
      this.l.getTabsContainerWrapper().setOnClickListener(new ReadinjoyTabFrame.7(this));
      return;
    }
    if (ReadInJoyHelper.v())
    {
      try
      {
        this.l.getTabsContainerBtnImage().clearAnimation();
        this.l.getTabsContainerBtnImage().setVisibility(4);
      }
      catch (Throwable localThrowable2)
      {
        localThrowable2.printStackTrace();
        QLog.d("ReadInJoyTabFrame", 1, "hide channel entrance failed.");
      }
      try
      {
        this.l.getTabsContainerWrapper().setOnClickListener(new ReadinjoyTabFrame.8(this));
        return;
      }
      catch (Throwable localThrowable3)
      {
        localThrowable3.printStackTrace();
        QLog.d("ReadInJoyTabFrame", 1, "set click listener failed.");
      }
    }
  }
  
  private VideoInfo M()
  {
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 7);
    double d = DeviceInfoUtil.D();
    Double.isNaN(d);
    int i1 = (int)(d * 0.4D);
    d = DeviceInfoUtil.E();
    Double.isNaN(d);
    int i2 = (int)(d * 0.4D);
    Object localObject2 = new int[2];
    this.i.getLocationOnScreen((int[])localObject2);
    int i3 = localObject2[0];
    int i4 = this.i.getWidth();
    int i5 = localObject2[1];
    int i6 = this.i.getHeight();
    ((Bundle)localObject1).putInt("item_x", i3 + i4 - i1);
    ((Bundle)localObject1).putInt("item_y", i5 + i6 - i2);
    ((Bundle)localObject1).putInt("item_width", i1);
    ((Bundle)localObject1).putInt("item_height", i2);
    localObject2 = this.v;
    if (localObject2 != null)
    {
      ((Bundle)localObject1).putInt("item_image_width", ((ColorBandVideoEntranceButton)localObject2).getCoverWidth());
      ((Bundle)localObject1).putInt("item_image_height", this.v.getCoverHeight());
    }
    localObject2 = this.L;
    if (localObject2 != null)
    {
      boolean bool = ((VideoFeedsFirstVideoRecommendationManager)localObject2).a((Bundle)localObject1);
      localObject2 = (VideoInfo)((Bundle)localObject1).getParcelable("VIDEO_OBJ");
      if (ReadInJoyHelper.K() == 1)
      {
        localObject1 = FeedsChannelDataHelper.a((VideoInfo)localObject2);
        if ((localObject1 != null) && ((localObject1 instanceof BaseArticleInfo))) {
          RIJListViewGroupHandlerClick.a(P(), null, (AbsBaseArticleInfo)localObject1, false, 0, 0, false, 1004);
        } else {
          ReadInJoyActivityHelper.INSTANCE.launchChannelActivity(P(), 56, Q().getString(2131916602), 3, 1004);
        }
      }
      else
      {
        VideoFeedsHelper.a(P(), (Bundle)localObject1, bool ^ true, 11);
        f(3);
      }
      return localObject2;
    }
    QLog.d("ReadInJoyTabFrame", 1, "videoManager is null, can't jump to videoPlayActivity!");
    return null;
  }
  
  private void N()
  {
    VideoReport.setElementId(this.v, "entrance_button");
    VideoReport.setElementParams(this.v, new RIJDtParamBuilder().a("14").c("click_entrance").a(Integer.valueOf(0)).a().c());
    VideoReport.setElementReportPolicy(this.v, ReportPolicy.REPORT_POLICY_CLICK);
  }
  
  private void O()
  {
    QBaseActivity localQBaseActivity = P();
    this.v = new ColorBandVideoEntranceButton(localQBaseActivity);
    this.w = new ClipDianDianTouchAreaLayout(localQBaseActivity);
    this.w.setId(2131441430);
    N();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 85);
    localLayoutParams.bottomMargin = Q().getDimensionPixelOffset(2131297771);
    this.w.setLayoutParams(localLayoutParams);
    localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 48);
    localLayoutParams.bottomMargin = Q().getDimensionPixelOffset(2131297284);
    this.v.setLayoutParams(localLayoutParams);
    this.v.setOnVideoCoverClickListener(new ReadinjoyTabFrame.10(this));
    this.w.addView(this.v);
    this.w.setTouchWidget(this.v, 0);
    this.u.addView(this.w);
    this.w.setVisibility(4);
    this.v.setVisibility(8);
    this.v.getViewTreeObserver().addOnGlobalLayoutListener(this);
    ac();
    int i1 = ReadInJoyHelper.K();
    if (i1 != 3)
    {
      if (i1 != 4)
      {
        if (i1 == 6) {
          this.v.setDefaultDrawable(Q().getDrawable(2130843846));
        }
      }
      else {
        this.v.setDefaultDrawable(Q().getDrawable(2130851410));
      }
    }
    else {
      this.v.setDefaultDrawable(Q().getDrawable(2130851371));
    }
    RecommendFeedsDiandianEntranceManager.getInstance().addEntryRefreshListener(this);
    this.L = new VideoFeedsFirstVideoRecommendationManager(this.v, localQBaseActivity);
  }
  
  private void U()
  {
    int i1 = RecommendFeedsDiandianEntranceManager.getDefaultFeedsIconSrcId();
    if (this.v != null)
    {
      Drawable localDrawable = Q().getDrawable(i1);
      this.v.setDefaultDrawable(localDrawable);
      this.v.a();
      this.v.setDataSource(null);
    }
  }
  
  private void V()
  {
    Object localObject1 = this.aF.getApplication();
    int i1 = SharedPreUtils.h((Context)localObject1);
    Object localObject2 = this.w;
    boolean bool1;
    if ((localObject2 != null) && (((ClipDianDianTouchAreaLayout)localObject2).getVisibility() == 0)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localObject2 = this.v;
    boolean bool2;
    if ((localObject2 != null) && (((ColorBandVideoEntranceButton)localObject2).getVisibility() == 0)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initBubblePopWindow mEntranceLayout:");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append("   btnVisible:");
      ((StringBuilder)localObject2).append(bool2);
      QLog.d("ReadInJoyTabFrame", 2, ((StringBuilder)localObject2).toString());
    }
    if ((SharedPreUtils.b((Context)localObject1, t().getCurrentAccountUin(), i1, "key_sp_is_first_show_waist_popwindow")) && (ReadInJoyHelper.K() == 1) && (this.T.getUserVisibleHint()))
    {
      localObject2 = this.w;
      if ((localObject2 != null) && (((ClipDianDianTouchAreaLayout)localObject2).getVisibility() == 0))
      {
        localObject2 = this.v;
        if ((localObject2 != null) && (((ColorBandVideoEntranceButton)localObject2).getVisibility() == 0) && (this.v.getAnchorView() != null))
        {
          SharedPreUtils.a((Context)localObject1, t().getCurrentAccountUin(), i1, "key_sp_is_first_show_waist_popwindow");
          localObject1 = P();
          i1 = DisplayUtil.a((Context)localObject1, 12.0F);
          int i2 = DisplayUtil.a((Context)localObject1, 9.0F);
          localObject2 = new BubblePopupWindow((Context)localObject1);
          this.S = ((BubblePopupWindow)localObject2);
          Object localObject3 = new TextView((Context)localObject1);
          ((TextView)localObject3).setPadding(i1, i2, i1, i2);
          ((BubblePopupWindow)localObject2).setContentView((View)localObject3);
          ((TextView)localObject3).setText(Q().getString(2131915617));
          ((BubblePopupWindow)localObject2).setAnimationStyle(2131953359);
          ((BubblePopupWindow)localObject2).b(-16777216);
          ((BubblePopupWindow)localObject2).setSoftInputMode(1);
          ((BubblePopupWindow)localObject2).setInputMethodMode(2);
          ((BubblePopupWindow)localObject2).a(((BubblePopupWindow)localObject2).b() / 2 - DisplayUtil.a((Context)localObject1, 43.0F), 0, 0, 0);
          localObject3 = new int[2];
          this.v.getAnchorView().getLocationOnScreen((int[])localObject3);
          i1 = ScreenUtil.SCREEN_WIDTH;
          i2 = DisplayUtil.a((Context)localObject1, 15.0F);
          int i3 = ((BubblePopupWindow)localObject2).b();
          int i4 = localObject3[1];
          int i5 = ((BubblePopupWindow)localObject2).a();
          int i6 = ((BubblePopupWindow)localObject2).c();
          int i7 = DisplayUtil.a((Context)localObject1, 5.0F);
          ((BubblePopupWindow)localObject2).a(this.v.getAnchorView(), 48, i1 - i2 - i3, i4 - i5 - i6 - i7);
          this.ab.postDelayed(new ReadinjoyTabFrame.11(this), 3000L);
          PublicAccountReportUtils.a(null, "", "0X8009A21", "0X8009A21", 0, 0, "0", "0", null, new VideoR5.Builder(null, null, null, null).b().a(), false);
        }
      }
    }
  }
  
  private void W()
  {
    BubblePopupWindow localBubblePopupWindow = this.S;
    if (localBubblePopupWindow != null) {
      localBubblePopupWindow.dismiss();
    }
  }
  
  private void X()
  {
    boolean bool = ThemeUtil.isInNightMode(this.aF);
    Object localObject;
    if (bool)
    {
      if (this.r == null) {
        this.r = ((ViewStub)d(2131444311)).inflate();
      }
      localObject = this.r;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      if (this.y == null)
      {
        localObject = (BaseActivity)P();
        if (localObject != null)
        {
          localObject = ((BaseActivity)localObject).getLayoutInflater();
          if (localObject != null) {
            this.y = ((LayoutInflater)localObject).inflate(2131626298, null);
          }
        }
      }
      localObject = this.y;
      if (localObject != null)
      {
        if (((View)localObject).getParent() == null)
        {
          localObject = this.w;
          if (localObject != null) {
            ((ClipDianDianTouchAreaLayout)localObject).addView(this.y);
          }
        }
        this.y.setVisibility(0);
      }
    }
    else
    {
      localObject = this.r;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.y;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
    h(bool);
  }
  
  private void Y()
  {
    int i1 = 0;
    while (i1 < 1)
    {
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 == 2)
          {
            this.m[i1] = HardCodeUtil.a(2131899712);
            this.n[i1] = 2131444327;
          }
        }
        else
        {
          this.m[i1] = HardCodeUtil.a(2131910426);
          this.n[i1] = 2131444343;
        }
      }
      else
      {
        this.m[i1] = HardCodeUtil.a(2131891080);
        this.n[i1] = 2131444316;
      }
      i1 += 1;
    }
  }
  
  private void Z()
  {
    int i1 = ReadInJoyHelper.K();
    if (RecommendFeedsDiandianEntranceManager.isFollowOrTribeFeedsType(i1))
    {
      QLog.d("ReadInJoyTabFrame", 1, "request 0xdcb");
      RecommendFeedsDiandianEntranceManager.getInstance().checkAndReqRefreshDianDianIcon();
    }
    if (RecommendFeedsDiandianEntranceManager.isColoumnFeedsType(i1))
    {
      QLog.d("ReadInJoyTabFrame", 1, "request 0x6cf coloumn");
      B();
    }
  }
  
  private void a(int paramInt, PositionData paramPositionData)
  {
    Object localObject = P();
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        paramPositionData = new StringBuilder();
        paramPositionData.append("showLocationChangedDialog invalid type = ");
        paramPositionData.append(paramInt);
        QLog.e("ReadInJoyTabFrame", 2, paramPositionData.toString());
        return;
      }
      paramPositionData = ReadInJoyDialogUtil.a((Context)localObject, String.format("你当前在%s，暂无本地频道。", new Object[] { paramPositionData.cityGPS }), "是否保留原定位？");
      paramPositionData.setPositiveButton("确认", new ReadinjoyTabFrame.22(this));
      paramPositionData.setNegativeButton("取消", new ReadinjoyTabFrame.23(this));
      paramPositionData.show();
      return;
    }
    localObject = DialogUtil.a((Activity)localObject, String.format("你当前在%s，是否切换定位？", new Object[] { paramPositionData.cityGPS }));
    ((QQCustomDialog)localObject).setPositiveButton("确认", new ReadinjoyTabFrame.20(this, paramPositionData));
    ((QQCustomDialog)localObject).setNegativeButton("取消", new ReadinjoyTabFrame.21(this));
    ((QQCustomDialog)localObject).setCanceledOnTouchOutside(true);
    ((QQCustomDialog)localObject).show();
  }
  
  private void a(VideoInfo paramVideoInfo)
  {
    ThreadManager.excute(new ReadinjoyTabFrame.18(this, paramVideoInfo, (ReadInJoySkinManager)this.aF.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)), 16, null, true);
  }
  
  public static void a(String paramString)
  {
    try
    {
      localObject = new RIJTransMergeKanDianReport.ReportR5Builder();
      ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).addNetworkType();
      ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).addVersion();
      PublicAccountReportUtils.a(null, "", paramString, paramString, 0, 0, "", "", "", ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).build(), false);
      return;
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("gradeEntryReport error! e= ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ReadInJoyTabFrame", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private void aa()
  {
    if (P().findViewById(16908305) != null) {
      Q().getDimensionPixelOffset(2131297771);
    }
  }
  
  private void ab()
  {
    if (!"2225164739".equals(t().getCurrentAccountUin())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = new PopupMenuDialog.MenuItem();
    ((PopupMenuDialog.MenuItem)localObject).id = 0;
    ((PopupMenuDialog.MenuItem)localObject).title = HardCodeUtil.a(2131910413);
    ((PopupMenuDialog.MenuItem)localObject).iconId = 2130843582;
    localArrayList.add(localObject);
    localObject = new PopupMenuDialog.MenuItem();
    ((PopupMenuDialog.MenuItem)localObject).id = 1;
    ((PopupMenuDialog.MenuItem)localObject).title = HardCodeUtil.a(2131910587);
    ((PopupMenuDialog.MenuItem)localObject).iconId = 2130843582;
    localArrayList.add(localObject);
    localObject = new PopupMenuDialog.MenuItem();
    ((PopupMenuDialog.MenuItem)localObject).id = 2;
    ((PopupMenuDialog.MenuItem)localObject).title = HardCodeUtil.a(2131910531);
    ((PopupMenuDialog.MenuItem)localObject).titleSize = 14.0F;
    ((PopupMenuDialog.MenuItem)localObject).iconId = 2130843582;
    localArrayList.add(localObject);
    localObject = new PopupMenuDialog.MenuItem();
    ((PopupMenuDialog.MenuItem)localObject).id = 3;
    ((PopupMenuDialog.MenuItem)localObject).title = HardCodeUtil.a(2131910464);
    ((PopupMenuDialog.MenuItem)localObject).iconId = 2130843582;
    localArrayList.add(localObject);
    PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
    localMenuItem.id = 4;
    if (!ReadInJoyUtils.g()) {
      localObject = "打开预加载UI";
    } else {
      localObject = "取消预加载UI";
    }
    localMenuItem.title = ((String)localObject);
    localMenuItem.iconId = 2130843582;
    localArrayList.add(localMenuItem);
    localMenuItem = new PopupMenuDialog.MenuItem();
    localMenuItem.id = 5;
    if (!((Boolean)RIJSPUtils.b("dynamicFeeds", Boolean.valueOf(false))).booleanValue()) {
      localObject = "打开动态频道feeds";
    } else {
      localObject = "取消动态频道feeds";
    }
    localMenuItem.title = ((String)localObject);
    localMenuItem.titleSize = 12.0F;
    localMenuItem.iconId = 2130843582;
    localArrayList.add(localMenuItem);
    localMenuItem = new PopupMenuDialog.MenuItem();
    localMenuItem.id = 6;
    if (!FeedsSPUtils.a(this.aF)) {
      localObject = HardCodeUtil.a(2131910372);
    } else {
      localObject = "切换到Web";
    }
    localMenuItem.title = ((String)localObject);
    localMenuItem.titleSize = 12.0F;
    localMenuItem.iconId = 2130843582;
    localArrayList.add(localMenuItem);
    PopupMenuDialog.build(P(), localArrayList, new ReadinjoyTabFrame.24(this)).showAsDropDown(this.q);
  }
  
  private boolean ac()
  {
    if ((this.w != null) && (this.v != null))
    {
      int i1;
      if ((ReadInJoyHelper.a("sp_key_readinjoy_video_entrance_reddot_button_switch", true)) && (RIJDianDianEntryVisibleConfig.a.a(g()))) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      int i2;
      if (this.v.getVisibility() == 0) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      if (i1 != 0)
      {
        this.w.setVisibility(0);
        this.v.setVisibility(0);
      }
      else
      {
        this.w.setVisibility(4);
        this.v.setVisibility(8);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setEntranceButton Visibility: ");
      String str;
      if (i1 != 0) {
        str = "true";
      } else {
        str = "false";
      }
      localStringBuilder.append(str);
      QLog.d("ReadInJoyTabFrame", 1, localStringBuilder.toString());
      if ((i2 == 0) && (i1 != 0)) {
        RecommendFeedsDiandianEntranceManager.getInstance().reportEntryIconExposure(0, g());
      }
      return i2 != i1;
    }
    return false;
  }
  
  private void ad()
  {
    boolean bool = StudyModeManager.h();
    if (bool == this.ae) {
      return;
    }
    this.ae = bool;
    bool = StudyModeManager.h();
    int i2 = 8;
    int i3 = 0;
    int i1;
    if (bool)
    {
      i1 = 0;
    }
    else
    {
      i1 = 8;
      i2 = 0;
    }
    Object localObject = this.j;
    if (localObject != null) {
      ((View)localObject).setVisibility(i2);
    }
    localObject = this.O;
    if (localObject != null) {
      ((ViewGroup)localObject).setVisibility(i2);
    }
    localObject = this.W;
    if (localObject != null) {
      ((RelativeLayout)localObject).setVisibility(i1);
    }
    localObject = this.M;
    if (localObject != null) {
      ((ReadInJoyChannelViewPager)localObject).setSlideLeftAndRight(this.ae ^ true);
    }
    localObject = this.Y;
    if (localObject != null)
    {
      if (RIJStudyModeUtils.a()) {
        i1 = i3;
      } else {
        i1 = 4;
      }
      ((ImageView)localObject).setVisibility(i1);
      this.Y.setOnClickListener(this.af);
    }
    if ((p() instanceof ReadInJoyRecommendFeedsFragment)) {
      ac();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateStudyModelUI, isStudyMode= ");
    ((StringBuilder)localObject).append(this.ae);
    QLog.d("ReadInJoyTabFrame", 1, ((StringBuilder)localObject).toString());
  }
  
  private void ae()
  {
    boolean bool = this.q.h();
    this.q.g();
    ReadInJoyActivityHelper.INSTANCE.launchReadInJoySelfActivity(P(), bool);
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = RIJTransMergeKanDianReport.d();
        localJSONObject.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        if (!bool) {
          break label236;
        }
        i1 = 2;
        localJSONObject.put("reddot", i1);
        localJSONObject.put("kandian_mode", RIJAppSetting.b());
        localJSONObject.put("kandian_mode_new", VideoReporter.c());
        Object localObject = (ReadInJoySkinManager)this.aF.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
        if ((((ReadInJoySkinManager)localObject).c() != 1) || (TextUtils.isEmpty(((ReadInJoySkinManager)localObject).b()))) {
          break label241;
        }
        localObject = ((ReadInJoySkinManager)localObject).b();
        localJSONObject.put("skin_id", localObject);
        localJSONObject.put("button_state", 0);
        PublicAccountReportUtils.a(t(), "", "0X8007DB0", "0X8007DB0", 0, 0, "4", "", "", localJSONObject.toString(), false);
        localObject = new HashMap();
        ((Map)localObject).put("uin", RIJQQAppInterfaceUtil.d());
        UserAction.onUserAction("actRIJSelfPage", (Map)localObject, false, false);
        UserAction.onUserAction("actRIJSelfPage", (Map)localObject, false, false);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      PublicTracker.a(null, "self_tab_cost");
      return;
      label236:
      int i1 = 1;
      continue;
      label241:
      String str = "0";
    }
  }
  
  private void b(String paramString)
  {
    RIJSPUtils.a("KEY_ENTRANCE_SCHEMA", paramString);
  }
  
  private void c(View paramView)
  {
    int i2 = RIJColumnDataSource.k;
    try
    {
      paramView = paramView.getTag();
      i1 = i2;
      if (paramView == null) {
        break label38;
      }
      i1 = Integer.parseInt(String.valueOf(paramView));
    }
    catch (Exception paramView)
    {
      int i1;
      label26:
      Object localObject;
      EntranceIconInfo localEntranceIconInfo;
      break label26;
    }
    QLog.d("ReadInJoyTabFrame", 1, "parseInt error!");
    i1 = i2;
    label38:
    paramView = this.v;
    if ((paramView != null) && (paramView.getDataSource() != null))
    {
      paramView = new StringBuilder();
      paramView.append("entrancebutton has red dot: ");
      paramView.append(this.v.getDataSource());
      QLog.d("ReadInJoyTabFrame", 1, paramView.toString());
      localObject = this.v.getDataSource();
      if ((localObject instanceof VideoInfo.EntranceDownloadInfo))
      {
        paramView = (VideoInfo.EntranceDownloadInfo)localObject;
        if (paramView.e != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("entrancebutton downloadinfo: ");
          ((StringBuilder)localObject).append(paramView.e);
          QLog.d("ReadInJoyTabFrame", 1, ((StringBuilder)localObject).toString());
          if (QLog.isColorLevel()) {
            QLog.d("VideoEntranceButton", 2, "resolveUrlJumpInfo");
          }
          VideoFeedsHelper.a(P(), paramView.e);
          if (this.L == null) {
            break label609;
          }
          VideoFeedsFirstVideoRecommendationManager.b(paramView);
          this.L.a();
          break label609;
        }
      }
      if ((localObject instanceof EntranceIconInfo))
      {
        localEntranceIconInfo = (EntranceIconInfo)localObject;
        localObject = localEntranceIconInfo.d;
        paramView = new StringBuilder();
        paramView.append("entranceIconInfo recommendfeeds jumpSchema ");
        paramView.append((String)localObject);
        QLog.d("ReadInJoyTabFrame", 1, paramView.toString());
        paramView = (View)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramView = RecommendFeedsDiandianEntranceManager.getFeedsDefaultSchema(localEntranceIconInfo.a);
        }
        if (!TextUtils.isEmpty(paramView))
        {
          ReadInJoyUtils.a(P(), paramView);
          this.v.setDataSource(null);
          b(paramView);
        }
        RecommendFeedsDiandianEntranceManager.getInstance().clearRedIconInfo();
      }
      else if ((localObject instanceof RIJColumnDataSource))
      {
        paramView = (RIJColumnDataSource)localObject;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("column button jump to red source! ");
        ((StringBuilder)localObject).append(paramView);
        QLog.d("ReadInJoyTabFrame", 1, ((StringBuilder)localObject).toString());
        if (paramView.d == null) {
          ReadInJoyUtils.a(P(), ReadInJoyHelper.M());
        } else {
          VideoFeedsHelper.a(P(), paramView.d);
        }
        this.v.setDataSource(null);
        this.v.a();
        RecommendFeedsDiandianEntranceManager.getInstance().columnDiandianClickReport(paramView, i1, 0, g());
      }
      else
      {
        QLog.d("ReadInJoyTabFrame", 1, "lauch videofeeds");
        a(M());
      }
    }
    else
    {
      i2 = RecommendFeedsDiandianEntranceManager.getInstance().getEntryFeedsType();
      paramView = new StringBuilder();
      paramView.append("diandian button jump to default url! feedType ");
      paramView.append(i2);
      QLog.d("ReadInJoyTabFrame", 1, paramView.toString());
      paramView = this.v;
      if ((paramView != null) && (paramView.g))
      {
        QLog.d("ReadInJoyTabFrame", 1, "isColumnDiandianBtn true");
        RecommendFeedsDiandianEntranceManager.getInstance().columnDiandianClickReport(null, i1, 0, g());
        ReadInJoyUtils.a(P(), ReadInJoyHelper.M());
      }
      else if ((i2 != 2) && (i2 != 1))
      {
        QLog.d("ReadInJoyTabFrame", 1, "jump default schema");
        ReadInJoyUtils.a(P(), RecommendFeedsDiandianEntranceManager.getFeedsDefaultSchema(i2));
      }
      else
      {
        QLog.d("ReadInJoyTabFrame", 1, "ENTRANCE_FEEDS_TYPE_VIDEO or ENTRANCE_FEEDS_TYPE_VIDEO_CHANNEL");
        a(M());
      }
    }
    label609:
    if (RIJKanDianYaobuIconClickReportAladdinConfig.a()) {
      b(2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoEntranceButton", 2, "performVideoFeedsClick");
    }
  }
  
  private void f(int paramInt)
  {
    if ((this.L != null) && (RecommendFeedsDiandianEntranceManager.getInstance().isVideoFeedsType())) {
      this.L.a(paramInt);
    }
  }
  
  private void h(boolean paramBoolean)
  {
    if (this.w != null)
    {
      int i1 = i(paramBoolean);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.w.getLayoutParams();
      localLayoutParams.bottomMargin = i1;
      this.w.setLayoutParams(localLayoutParams);
    }
  }
  
  private int i(boolean paramBoolean)
  {
    int i2 = Q().getDimensionPixelOffset(2131297771);
    int i1;
    if (paramBoolean) {
      i1 = ViewUtils.dpToPx(5.0F);
    } else {
      i1 = 0;
    }
    Object localObject = this.G;
    if (localObject != null)
    {
      localObject = ((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
      if ((localObject instanceof MainFragment))
      {
        int i3 = RIJWindowUtils.a.a((MainFragment)localObject);
        if (i3 != 0) {
          return i3;
        }
      }
    }
    return i2 + i1;
  }
  
  protected void A()
  {
    if ((StudyModeManager.h()) && (RIJStudyModeUtils.a())) {
      a("0X800AF05");
    }
  }
  
  protected void B()
  {
    if ((p() instanceof ReadInJoyRecommendFeedsFragment))
    {
      ReadInJoyDianDianEntranceModule localReadInJoyDianDianEntranceModule = ReadInJoyLogicEngine.a().l();
      if (localReadInJoyDianDianEntranceModule != null)
      {
        localReadInJoyDianDianEntranceModule.b(ReadInJoyHelper.K());
        return;
      }
      QLog.d("ReadInJoyTabFrame", 1, "requestColumn0x6cf failed!");
    }
  }
  
  protected void C()
  {
    long l1 = System.currentTimeMillis() - this.a;
    Object localObject = p();
    boolean bool = false;
    int i1;
    if ((localObject != null) && (!(p() instanceof ReadInJoyRecommendFeedsFragment)))
    {
      long l2 = ReadInJoyHelper.at(RIJQQAppInterfaceUtil.e());
      if ((l1 >= l2) && (this.a != 0L))
      {
        this.ac = true;
        ReadInJoyLogicEngineEventDispatcher.a().k();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("auto focus on recommend channel, exitTime : ");
        ((StringBuilder)localObject).append(l1);
        QLog.d("Q.readinjoy.4tab", 2, new Object[] { ((StringBuilder)localObject).toString(), ", timeLimit = ", Long.valueOf(l2) });
        i1 = 1;
      }
      else
      {
        i1 = 0;
      }
      if (StudyModeManager.h())
      {
        i1 = 1;
        bool = true;
      }
    }
    else
    {
      i1 = 0;
    }
    if (i1 != 0) {
      f(bool);
    }
  }
  
  public int D()
  {
    return 0;
  }
  
  public int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    return 0;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    this.i = paramLayoutInflater.inflate(2131626273, null);
    this.u = new ReadinjoyViewLayer(P().getBaseContext());
    this.u.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.u.addView(this.i);
    this.x = new DuplicateEventLayout(P());
    this.x.addView(this.u);
    this.x.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    return this.x;
  }
  
  protected void a()
  {
    super.a();
    ReadInJoyLogicEngineEventDispatcher.a().b();
    Object localObject = (BaseActivity)P();
    if ((localObject instanceof SplashActivity)) {
      this.G = ((SplashActivity)localObject).getSupportFragmentManager();
    } else if ((localObject instanceof BaseActivity)) {
      this.G = ((BaseActivity)localObject).getSupportFragmentManager();
    }
    if (localObject != null) {
      GdtManager.a().a((Context)localObject, new GdtManager.Params());
    }
    G();
    localObject = (KandianMergeManager)this.aF.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    ((KandianMergeManager)localObject).a(this);
    ((KandianMergeManager)localObject).a(this);
    ((ReadInJoySkinManager)this.aF.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a(this.v);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.ad);
    RIJRewardTaskLocalRepo.f().d();
  }
  
  public void a(int paramInt)
  {
    ReadInJoyChannelViewPagerController localReadInJoyChannelViewPagerController = this.P;
    if (localReadInJoyChannelViewPagerController != null) {
      localReadInJoyChannelViewPagerController.c(paramInt);
    }
  }
  
  protected void a(int paramInt, KandianMergeManager paramKandianMergeManager)
  {
    if ((paramKandianMergeManager.d()) || (paramKandianMergeManager.R() > 0))
    {
      if (paramInt == 6)
      {
        paramInt = P().getIntent().getIntExtra("jump_activity_launch_channel_id", 0);
        RIJChannelReporter.a(paramInt, "304");
      }
      else
      {
        paramInt = 0;
      }
      if ((paramInt == 0) || (paramInt == ChannelCoverInfoModule.g())) {
        f(false);
      }
      paramKandianMergeManager = new StringBuilder();
      paramKandianMergeManager.append("onTabChange, has red point, switch to main fragment,channeldId;");
      paramKandianMergeManager.append(paramInt);
      QLog.d("ReadInJoyTabFrame", 1, paramKandianMergeManager.toString());
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    paramConfiguration = Q().getDisplayMetrics();
    float f2 = FontSettingManager.getFontLevel() / 16.0F;
    float f1 = f2;
    if (f2 == 0.0F) {
      f1 = 1.0F;
    }
    f1 = paramConfiguration.density / f1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onConfigurationChanged densityNoScale : ");
    localStringBuilder.append(f1);
    localStringBuilder.append(", screenWidth : ");
    localStringBuilder.append(paramConfiguration.widthPixels);
    QLog.d("ReadInJoyTabFrame", 1, localStringBuilder.toString());
    Utils.init(f1, paramConfiguration.widthPixels);
  }
  
  public void a(Drawable paramDrawable)
  {
    Object localObject2 = Aladdin.getConfig(313);
    if (localObject2 != null)
    {
      this.B = ((AladdinConfig)localObject2).getIntegerFromString("SearchBox_TopBGType", 0);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("#");
      ((StringBuilder)localObject1).append(((AladdinConfig)localObject2).getString("SearchBox_BGColor", "f5f6fa"));
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("#");
      ((StringBuilder)localObject3).append(((AladdinConfig)localObject2).getString("SearchBox_BorderColor", "faf6fa"));
      localObject3 = ((StringBuilder)localObject3).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("#");
      localStringBuilder.append(((AladdinConfig)localObject2).getString("SearchBox_TextColor", "737373"));
      localObject2 = localStringBuilder.toString();
      if (this.B == 1)
      {
        a(this.o, true);
        a(this.p, true);
        a(this.j, true);
        this.s.setColorFilter(-1);
        this.t.setColorFilter(-1);
        this.l.a(2131167990, 2131167990, 2131167990);
        paramDrawable.setColorFilter(Q().getColor(2131167990), PorterDuff.Mode.SRC_IN);
        ((ImageView)this.Q).setImageDrawable(paramDrawable);
      }
      else
      {
        this.s.clearColorFilter();
        this.t.clearColorFilter();
      }
      paramDrawable = (GradientDrawable)this.Z.getBackground();
      paramDrawable.setStroke(ViewUtils.dpToPx(1.0F), Color.parseColor((String)localObject3));
      paramDrawable.setColor(Color.parseColor((String)localObject1));
      this.z.setTextColor(Color.parseColor((String)localObject2));
      this.A.setTextColor(Color.parseColor((String)localObject2));
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    da_();
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    da_();
  }
  
  public void a(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    if (this.v == null) {
      return;
    }
    QLog.d("ReadInJoyTabFrame", 1, "onEntryIconRefresh");
    this.v.setDataSource(paramIEntranceButtonDataSource);
    if (this.v.getVisibility() == 0)
    {
      if (paramIEntranceButtonDataSource != null)
      {
        this.v.a(paramIEntranceButtonDataSource);
        return;
      }
      this.v.setNotMsg();
    }
  }
  
  protected void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    ((ReadInJoyRefreshManager)this.aF.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER)).a(0, "", -1L, 0);
    if (p() != null) {
      p().a(paramLogoutReason);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (p() != null) {
      p().a(this);
    }
    Object localObject = P().findViewById(16908305);
    if (localObject != null) {
      SlideActiveAnimController.a((View)localObject);
    }
    f = true;
    ApngImage.playByTag(8);
    localObject = this.v;
    if ((localObject != null) && (((ColorBandVideoEntranceButton)localObject).getVisibility() == 0))
    {
      this.v.e();
      if (paramBoolean) {
        f(1);
      } else if (this.L != null) {
        VideoFeedsFirstVideoRecommendationManager.a(this.v.getDataSource());
      }
    }
    if (paramBoolean)
    {
      localObject = ReadInJoyLogicEngine.a().U();
      if (localObject != null) {
        ((FreeNetFlowInfoModule)localObject).a(false);
      }
      RIJPushNotification.c();
    }
    this.e.c();
    localObject = this.v;
    if (localObject != null) {
      ((ColorBandVideoEntranceButton)localObject).g();
    }
    localObject = P().getIntent();
    ReadInJoyChannelViewPagerController localReadInJoyChannelViewPagerController = this.P;
    if (localReadInJoyChannelViewPagerController != null) {
      localReadInJoyChannelViewPagerController.e();
    }
    if (!this.U)
    {
      I();
      this.U = true;
    }
    if (RIJTabFrameBase.d.a()) {
      RIJKanDianTabReport.a(true);
    }
    ReadInJoyLogicEngine.a().Y();
    if (((Boolean)RIJSPUtils.b("key_sp_is_readinjoy_youngster_changed", Boolean.valueOf(false))).booleanValue())
    {
      if (((this.F instanceof ReadInJoyRecommendFeedsFragment)) && (!((Intent)localObject).getBooleanExtra("is_watch_word_share", false))) {
        this.F.a(9);
      }
      RIJSPUtils.a("key_sp_is_readinjoy_youngster_changed", Boolean.valueOf(false));
    }
    ad();
  }
  
  public void b(View paramView)
  {
    this.u.a(paramView);
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    da_();
  }
  
  public void b(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    if (this.v == null) {
      return;
    }
    QLog.d("ReadInJoyTabFrame", 1, "onAccountChange");
    this.v.setDataSource(paramIEntranceButtonDataSource);
    if (this.v.getVisibility() == 0)
    {
      if (paramIEntranceButtonDataSource != null)
      {
        this.v.a(paramIEntranceButtonDataSource);
        return;
      }
      this.v.setNotMsg();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      L();
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      QLog.d("ReadInJoyTabFrame", 1, "init Channel Entry failed.");
    }
    ReadInJoyChannelViewPagerController localReadInJoyChannelViewPagerController = this.P;
    if (localReadInJoyChannelViewPagerController != null) {
      localReadInJoyChannelViewPagerController.m();
    }
  }
  
  public void bQ_()
  {
    super.bQ_();
    if (this.T.v() != this) {
      aa();
    }
    f = false;
    W();
    ApngImage.pauseByTag(8);
    ReadInJoyLogicEngine.L();
    this.e.d();
    Object localObject = this.v;
    if (localObject != null) {
      ((ColorBandVideoEntranceButton)localObject).f();
    }
    localObject = this.P;
    if (localObject != null) {
      ((ReadInJoyChannelViewPagerController)localObject).f();
    }
  }
  
  protected void bS_()
  {
    super.bS_();
  }
  
  public void c(int paramInt)
  {
    if (paramInt == 13)
    {
      ReadInJoyUtils.a(6);
      Object localObject = P().getIntent().getExtras();
      if (DailyFeedsDiandianEntranceManager.a((Bundle)localObject))
      {
        localObject = DailyFeedsDiandianEntranceManager.b((Bundle)localObject);
        if (localObject != null)
        {
          this.v.setDataSource((IEntranceButtonDataSource)localObject);
          this.v.a((IEntranceButtonDataSource)localObject);
          this.v.postDelayed(new ReadinjoyTabFrame.25(this), 1000L);
        }
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    RIJAppSetting.a(P(), this, true, this.p, this.B);
    Object localObject = (KandianMergeManager)this.aF.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    VideoReport.traversePage(this.i);
    if (paramBoolean)
    {
      a(this.c, (KandianMergeManager)localObject);
      c(this.c);
      ReadInJoyWebRenderEngine.e();
      C();
      Z();
      A();
      RIJMsgReport.a.a();
      h(ThemeUtil.isInNightMode(this.aF));
    }
    else
    {
      z();
      RIJAppSetting.a(P(), this.p);
      y();
    }
    g(paramBoolean);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("readinjoy tab change visiable : ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append("， launchFrom : ");
    ((StringBuilder)localObject).append(this.c);
    QLog.d("Q.readinjoy.4tab", 1, ((StringBuilder)localObject).toString());
    ad();
    RIJPushNotifyManager.Companion.a().dismiss(false, "MATCH_ALL_UIN");
  }
  
  public void cP_()
  {
    Drawable localDrawable = Q().getDrawable(2130844003);
    if ((!ThemeUtil.isDefaultOrDIYTheme(false)) && (!ThemeUtil.isSimpleDayTheme(false)))
    {
      this.s.setImageResource(2130852269);
      this.t.setImageResource(2130841074);
      this.j.setBackgroundResource(2130852228);
      this.l.a(2131167990, 2131167990, 2131167990);
      localDrawable.setColorFilter(Q().getColor(2131167990), PorterDuff.Mode.SRC_IN);
      ((ImageView)this.Q).setImageDrawable(localDrawable);
      a(this.o, false);
    }
    else
    {
      this.s.setImageResource(2130843918);
      this.t.setImageResource(2130843914);
      this.j.setBackgroundColor(-1);
      this.l.a(2131167856, 2131167857, 2131167855);
      localDrawable.setColorFilter(Q().getColor(2131165564), PorterDuff.Mode.SRC_IN);
      ((ImageView)this.Q).setImageDrawable(localDrawable);
      a(localDrawable);
    }
    X();
    RIJAppSetting.a(P(), this, true, this.p, this.B);
    ReadInJoyLogicEngineEventDispatcher.a().g();
  }
  
  protected String cy_()
  {
    return HardCodeUtil.a(2131891080);
  }
  
  protected void d()
  {
    super.d();
    ((ReadInJoySkinManager)this.aF.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).b(this.v);
    ReadInJoyLogicEngineEventDispatcher.a().b(this.ad);
    this.e.e();
    Object localObject = this.P;
    if (localObject != null)
    {
      ((ReadInJoyChannelViewPagerController)localObject).g();
      this.P = null;
    }
    localObject = this.L;
    if (localObject != null) {
      ((VideoFeedsFirstVideoRecommendationManager)localObject).c();
    }
    localObject = (KandianMergeManager)this.aF.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    ((KandianMergeManager)localObject).b(this);
    ((KandianMergeManager)localObject).b(this);
    RIJCommentResultDispatcher.a().c();
    ReadInJoyDataProviderObserver.getInstance().removeFluencyObserver();
    KandianVideoUploadService.a(null);
    RecommendFeedsDiandianEntranceManager.getInstance().removeEntryRefreshListener(this);
    UserActionCollector.a().d();
    localObject = this.v;
    if (localObject != null) {
      ((ColorBandVideoEntranceButton)localObject).i();
    }
  }
  
  public void da_()
  {
    SparseIntArray localSparseIntArray = ((KandianMergeManager)this.aF.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).G();
    int i2 = 0;
    while (i2 < localSparseIntArray.size())
    {
      int i3 = localSparseIntArray.keyAt(i2);
      int i4 = localSparseIntArray.valueAt(i2);
      int i1;
      if (i3 != 0)
      {
        if (i3 != 1)
        {
          if (i3 != 2)
          {
            if (i3 == 3) {
              break label128;
            }
            i1 = -1;
          }
          else
          {
            i1 = 2131444327;
          }
        }
        else {
          i1 = 2131444343;
        }
      }
      else {
        i1 = 2131444316;
      }
      Message localMessage = this.ab.obtainMessage(2);
      localMessage.arg1 = i4;
      localMessage.arg2 = i1;
      localMessage.obj = Integer.valueOf(i3);
      this.ab.sendMessage(localMessage);
      label128:
      i2 += 1;
    }
    ThreadManager.getUIHandler().post(new ReadinjoyTabFrame.15(this));
  }
  
  public void e()
  {
    ReadInJoyBaseFragment localReadInJoyBaseFragment = p();
    if (localReadInJoyBaseFragment != null) {
      localReadInJoyBaseFragment.l();
    }
    try
    {
      RIJKanDianTabReport.a(t(), localReadInJoyBaseFragment);
      RIJKanDianTabReport.a(t(), true);
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ReadInJoyTabFrame", 1, localJSONException, new Object[0]);
    }
  }
  
  protected void e(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setChannelID(-1);
      localObject1 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("setSuperMaskChannelId -1 : visible = ");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((IRIJAdLogService)localObject1).d("ReadInJoySuperMaskAd", ((StringBuilder)localObject2).toString());
      return;
    }
    Object localObject1 = p();
    if (localObject1 != null)
    {
      ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setChannelID(((ReadInJoyBaseFragment)localObject1).d());
      localObject2 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSuperMaskChannelId ");
      localStringBuilder.append(((ReadInJoyBaseFragment)localObject1).d());
      localStringBuilder.append(" : visible = ");
      localStringBuilder.append(paramBoolean);
      ((IRIJAdLogService)localObject2).d("ReadInJoySuperMaskAd", localStringBuilder.toString());
      return;
    }
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setChannelID(-1);
    localObject1 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("setSuperMaskChannelId -1 : visible = ");
    ((StringBuilder)localObject2).append(paramBoolean);
    ((IRIJAdLogService)localObject1).d("ReadInJoySuperMaskAd", ((StringBuilder)localObject2).toString());
  }
  
  protected void f()
  {
    super.f();
    Object localObject = (KandianMergeManager)this.aF.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    ((KandianMergeManager)localObject).a(this);
    ((KandianMergeManager)localObject).a(this);
    int i1;
    if (RIJMsgBoxUtils.a() == 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    localObject = d(2131438956);
    if (i1 != 0) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((View)localObject).setVisibility(i1);
    w();
    ((ReadInJoySkinManager)this.aF.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a(this.v);
    if (RIJUgcUtils.l()) {
      this.t.setVisibility(0);
    } else {
      this.t.setVisibility(8);
    }
    RIJDianDianEntryVisibleConfig.a.b();
    F();
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.P != null)
    {
      int i2 = 0;
      int i1 = i2;
      if (!paramBoolean)
      {
        i1 = i2;
        if (ChannelCoverInfoModule.g() != -1) {
          i1 = ChannelCoverInfoModule.g();
        }
      }
      this.P.c(i1);
    }
  }
  
  public int g()
  {
    ReadInJoyChannelViewPagerController localReadInJoyChannelViewPagerController = this.P;
    if (localReadInJoyChannelViewPagerController != null) {
      return localReadInJoyChannelViewPagerController.h();
    }
    return -1;
  }
  
  protected void g(boolean paramBoolean)
  {
    ReadInJoyChannelViewPagerController localReadInJoyChannelViewPagerController = this.P;
    if (localReadInJoyChannelViewPagerController != null) {
      localReadInJoyChannelViewPagerController.a(paramBoolean);
    }
  }
  
  public void j_(boolean paramBoolean)
  {
    if (!paramBoolean) {
      W();
    }
  }
  
  public boolean l()
  {
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.T.A.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    return ((x() != null) && (x().mChannelCoverId != 0)) || (localKandianMergeManager.R() > 0);
  }
  
  public void m()
  {
    H();
  }
  
  public void onGlobalLayout()
  {
    this.v.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    V();
  }
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    QLog.d("ReadInJoyTabFrame", 2, new Object[] { "onLoadUserInfoFailed, uin = ", paramString1, Character.valueOf('\n'), "errMsg = ", paramString2 });
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    QLog.d("ReadInJoyTabFrame", 2, new Object[] { "onLoadUserInfoSucceed uin = ", paramString, Character.valueOf('\n'), "userInfo = ", paramReadInJoyUserInfo });
  }
  
  public ReadInJoyBaseFragment p()
  {
    Object localObject = this.P;
    if (localObject != null)
    {
      localObject = ((ReadInJoyChannelViewPagerController)localObject).l();
      if ((localObject instanceof ReadInJoyBaseFragment)) {
        this.F = ((ReadInJoyBaseFragment)localObject);
      }
    }
    ReadInJoyBaseFragment localReadInJoyBaseFragment = this.F;
    localObject = localReadInJoyBaseFragment;
    if (localReadInJoyBaseFragment != null)
    {
      localObject = localReadInJoyBaseFragment;
      if (localReadInJoyBaseFragment.v() == null)
      {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "FragmentOnStartError", false, NetConnInfoCenter.getServerTimeMillis() - this.K, 0L, null, "", true);
        ThreadManager.getSubThreadHandler().postDelayed(new ReadinjoyTabFrame.9(this, localReadInJoyBaseFragment), 1000L);
        localObject = null;
      }
    }
    return localObject;
  }
  
  public void w()
  {
    Object localObject = ((KandianMergeManager)this.aF.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).Q();
    if (localObject != null)
    {
      int i1 = RIJPrivateChatServiceImpl.Companion.a().getTotalRedCount((KandianMsgBoxRedPntInfo)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      if (i1 > 99) {
        localObject = "99+";
      }
      this.R.setText((CharSequence)localObject);
      this.R.setVisibility(0);
      return;
    }
    this.R.setVisibility(8);
  }
  
  public ChannelCoverInfo x()
  {
    return this.aa;
  }
  
  protected void y() {}
  
  protected void z()
  {
    int i1 = 0;
    while (i1 < 1)
    {
      ReadInJoyBaseFragment localReadInJoyBaseFragment = p();
      if (localReadInJoyBaseFragment != null) {
        localReadInJoyBaseFragment.n();
      }
      i1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame
 * JD-Core Version:    0.7.0.1
 */