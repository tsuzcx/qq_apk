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
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
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
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.biz.framework.click.RIJListViewGroupHandlerClick;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsFirstVideoRecommendationManager;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
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
import com.tencent.mobileqq.kandian.glue.viola.wormhole.Wormhole;
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
  public static boolean a = false;
  public static int b;
  private static int jdField_d_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = new ReadinjoyTabFrame.17(this);
  private SparseArray<Bundle> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ReadinjoyTabFrame.26(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FragmentManager jdField_a_of_type_AndroidxFragmentAppFragmentManager;
  private FrameFragment jdField_a_of_type_ComTencentMobileqqAppFrameFragment;
  private ClipDianDianTouchAreaLayout jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetClipDianDianTouchAreaLayout;
  private DuplicateEventLayout jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetDuplicateEventLayout;
  private ReadinjoySlidingIndicator jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadinjoySlidingIndicator;
  private ReadinjoyViewLayer jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadinjoyViewLayer;
  private ReadInJoyBaseFragment jdField_a_of_type_ComTencentMobileqqKandianBizCommonFragmentReadInJoyBaseFragment;
  protected ReadInJoyTabTopSearchHeaderController a;
  private VideoFeedsFirstVideoRecommendationManager jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsFirstVideoRecommendationManager;
  private ColorBandVideoEntranceButton jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton;
  private ReadInJoyChannelViewPager.CustomFragmentPagerAdapter jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager$CustomFragmentPagerAdapter;
  private ReadInJoyChannelViewPager jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager;
  private ReadInJoyChannelViewPagerController jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPagerController;
  private ReadinjoyTabFrame.InitWebProcessRunnable jdField_a_of_type_ComTencentMobileqqKandianBizTabReadinjoyTabFrame$InitWebProcessRunnable = new ReadinjoyTabFrame.InitWebProcessRunnable();
  private BubblePopupWindow jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow;
  private ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ReadinjoyTabFrame.19(this);
  private ChannelCoverInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelCoverInfo;
  private RedTouch jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  public Runnable a;
  private ConcurrentHashMap<Integer, ReadInJoySubChannelFragment> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private int[] jdField_a_of_type_ArrayOfInt = new int[1];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[1];
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = 0L;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = false;
  private long jdField_d_of_type_Long = 0L;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private boolean jdField_d_of_type_Boolean = false;
  private View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean = false;
  private View f;
  private View g;
  private View h;
  
  public ReadinjoyTabFrame(FrameFragment paramFrameFragment)
  {
    this.jdField_a_of_type_JavaLangRunnable = new ReadinjoyTabFrame.13(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment = paramFrameFragment;
  }
  
  private void A()
  {
    if (ReadInJoyHelper.m())
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadinjoySlidingIndicator.a().clearAnimation();
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadinjoySlidingIndicator.a().setVisibility(0);
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
        QLog.d("ReadInJoyTabFrame", 1, "show channel entrance failed.");
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadinjoySlidingIndicator.a().setOnClickListener(new ReadinjoyTabFrame.7(this));
      return;
    }
    if (ReadInJoyHelper.l())
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadinjoySlidingIndicator.a().clearAnimation();
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadinjoySlidingIndicator.a().setVisibility(4);
      }
      catch (Throwable localThrowable2)
      {
        localThrowable2.printStackTrace();
        QLog.d("ReadInJoyTabFrame", 1, "hide channel entrance failed.");
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadinjoySlidingIndicator.a().setOnClickListener(new ReadinjoyTabFrame.8(this));
        return;
      }
      catch (Throwable localThrowable3)
      {
        localThrowable3.printStackTrace();
        QLog.d("ReadInJoyTabFrame", 1, "set click listener failed.");
      }
    }
  }
  
  private void E()
  {
    VideoReport.setElementId(this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton, "entrance_button");
    VideoReport.setElementParams(this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton, new RIJDtParamBuilder().a("14").c("click_entrance").a(Integer.valueOf(0)).a().a());
    VideoReport.setElementReportPolicy(this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton, ReportPolicy.REPORT_POLICY_CLICK);
  }
  
  private void F()
  {
    QBaseActivity localQBaseActivity = a();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton = new ColorBandVideoEntranceButton(localQBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetClipDianDianTouchAreaLayout = new ClipDianDianTouchAreaLayout(localQBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetClipDianDianTouchAreaLayout.setId(2131373756);
    E();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 85);
    localLayoutParams.bottomMargin = a().getDimensionPixelOffset(2131297336);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetClipDianDianTouchAreaLayout.setLayoutParams(localLayoutParams);
    localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 48);
    localLayoutParams.bottomMargin = a().getDimensionPixelOffset(2131296905);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.setOnVideoCoverClickListener(new ReadinjoyTabFrame.10(this));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetClipDianDianTouchAreaLayout.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetClipDianDianTouchAreaLayout.setTouchWidget(this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton, 0);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadinjoyViewLayer.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetClipDianDianTouchAreaLayout);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetClipDianDianTouchAreaLayout.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.getViewTreeObserver().addOnGlobalLayoutListener(this);
    d();
    int i = ReadInJoyHelper.e();
    if (i != 3)
    {
      if (i != 4)
      {
        if (i == 6) {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.setDefaultDrawable(a().getDrawable(2130842890));
        }
      }
      else {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.setDefaultDrawable(a().getDrawable(2130849704));
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.setDefaultDrawable(a().getDrawable(2130849666));
    }
    RecommendFeedsDiandianEntranceManager.getInstance().addEntryRefreshListener(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsFirstVideoRecommendationManager = new VideoFeedsFirstVideoRecommendationManager(this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton, localQBaseActivity);
  }
  
  private void G()
  {
    int i = RecommendFeedsDiandianEntranceManager.getDefaultFeedsIconSrcId();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton != null)
    {
      Drawable localDrawable = a().getDrawable(i);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.setDefaultDrawable(localDrawable);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.a();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.setDataSource(null);
    }
  }
  
  private void H()
  {
    Object localObject1 = this.jdField_a_of_type_MqqAppAppRuntime.getApplication();
    int i = SharedPreUtils.e((Context)localObject1);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetClipDianDianTouchAreaLayout;
    boolean bool1;
    if ((localObject2 != null) && (((ClipDianDianTouchAreaLayout)localObject2).getVisibility() == 0)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton;
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
    if ((SharedPreUtils.a((Context)localObject1, a().getCurrentAccountUin(), i, "key_sp_is_first_show_waist_popwindow")) && (ReadInJoyHelper.e() == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.getUserVisibleHint()))
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetClipDianDianTouchAreaLayout;
      if ((localObject2 != null) && (((ClipDianDianTouchAreaLayout)localObject2).getVisibility() == 0))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton;
        if ((localObject2 != null) && (((ColorBandVideoEntranceButton)localObject2).getVisibility() == 0) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.a() != null))
        {
          SharedPreUtils.a((Context)localObject1, a().getCurrentAccountUin(), i, "key_sp_is_first_show_waist_popwindow");
          localObject1 = a();
          i = DisplayUtil.a((Context)localObject1, 12.0F);
          int j = DisplayUtil.a((Context)localObject1, 9.0F);
          localObject2 = new BubblePopupWindow((Context)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow = ((BubblePopupWindow)localObject2);
          Object localObject3 = new TextView((Context)localObject1);
          ((TextView)localObject3).setPadding(i, j, i, j);
          ((BubblePopupWindow)localObject2).setContentView((View)localObject3);
          ((TextView)localObject3).setText(a().getString(2131718139));
          ((BubblePopupWindow)localObject2).setAnimationStyle(2131756209);
          ((BubblePopupWindow)localObject2).b(-16777216);
          ((BubblePopupWindow)localObject2).setSoftInputMode(1);
          ((BubblePopupWindow)localObject2).setInputMethodMode(2);
          ((BubblePopupWindow)localObject2).a(((BubblePopupWindow)localObject2).b() / 2 - DisplayUtil.a((Context)localObject1, 43.0F), 0, 0, 0);
          localObject3 = new int[2];
          this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.a().getLocationOnScreen((int[])localObject3);
          i = ScreenUtil.SCREEN_WIDTH;
          j = DisplayUtil.a((Context)localObject1, 15.0F);
          int k = ((BubblePopupWindow)localObject2).b();
          int m = localObject3[1];
          int n = ((BubblePopupWindow)localObject2).a();
          int i1 = ((BubblePopupWindow)localObject2).c();
          int i2 = DisplayUtil.a((Context)localObject1, 5.0F);
          ((BubblePopupWindow)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.a(), 48, i - j - k, m - n - i1 - i2);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ReadinjoyTabFrame.11(this), 3000L);
          localObject1 = new VideoR5.Builder(null, null, null, null).a().a();
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009A21", "0X8009A21", 0, 0, "0", "0", null, (String)localObject1, false);
        }
      }
    }
  }
  
  private void I()
  {
    BubblePopupWindow localBubblePopupWindow = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow;
    if (localBubblePopupWindow != null) {
      localBubblePopupWindow.dismiss();
    }
  }
  
  private void J()
  {
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_MqqAppAppRuntime);
    Object localObject;
    if (bool)
    {
      if (this.jdField_e_of_type_AndroidViewView == null) {
        this.jdField_e_of_type_AndroidViewView = ((ViewStub)a(2131376108)).inflate();
      }
      localObject = this.jdField_e_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      if (this.f == null)
      {
        localObject = (BaseActivity)a();
        if (localObject != null)
        {
          localObject = ((BaseActivity)localObject).getLayoutInflater();
          if (localObject != null) {
            this.f = ((LayoutInflater)localObject).inflate(2131560251, null);
          }
        }
      }
      localObject = this.f;
      if (localObject != null)
      {
        if (((View)localObject).getParent() == null)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetClipDianDianTouchAreaLayout;
          if (localObject != null) {
            ((ClipDianDianTouchAreaLayout)localObject).addView(this.f);
          }
        }
        this.f.setVisibility(0);
      }
    }
    else
    {
      localObject = this.jdField_e_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.f;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
    h(bool);
  }
  
  private void K()
  {
    int i = 0;
    while (i < 1)
    {
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2)
          {
            this.jdField_a_of_type_ArrayOfJavaLangString[i] = HardCodeUtil.a(2131712923);
            this.jdField_a_of_type_ArrayOfInt[i] = 2131376124;
          }
        }
        else
        {
          this.jdField_a_of_type_ArrayOfJavaLangString[i] = HardCodeUtil.a(2131712855);
          this.jdField_a_of_type_ArrayOfInt[i] = 2131376141;
        }
      }
      else
      {
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = HardCodeUtil.a(2131693524);
        this.jdField_a_of_type_ArrayOfInt[i] = 2131376113;
      }
      i += 1;
    }
  }
  
  private void L()
  {
    int i = ReadInJoyHelper.e();
    if (RecommendFeedsDiandianEntranceManager.isFollowOrTribeFeedsType(i))
    {
      QLog.d("ReadInJoyTabFrame", 1, "request 0xdcb");
      RecommendFeedsDiandianEntranceManager.getInstance().checkAndReqRefreshDianDianIcon();
    }
    if (RecommendFeedsDiandianEntranceManager.isColoumnFeedsType(i))
    {
      QLog.d("ReadInJoyTabFrame", 1, "request 0x6cf coloumn");
      r();
    }
  }
  
  private void M()
  {
    if (a().findViewById(16908305) != null) {
      a().getDimensionPixelOffset(2131297336);
    }
  }
  
  private void N()
  {
    if (!"2225164739".equals(a().getCurrentAccountUin())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = new PopupMenuDialog.MenuItem();
    ((PopupMenuDialog.MenuItem)localObject).id = 0;
    ((PopupMenuDialog.MenuItem)localObject).title = HardCodeUtil.a(2131712841);
    ((PopupMenuDialog.MenuItem)localObject).iconId = 2130842629;
    localArrayList.add(localObject);
    localObject = new PopupMenuDialog.MenuItem();
    ((PopupMenuDialog.MenuItem)localObject).id = 1;
    ((PopupMenuDialog.MenuItem)localObject).title = HardCodeUtil.a(2131713025);
    ((PopupMenuDialog.MenuItem)localObject).iconId = 2130842629;
    localArrayList.add(localObject);
    localObject = new PopupMenuDialog.MenuItem();
    ((PopupMenuDialog.MenuItem)localObject).id = 2;
    ((PopupMenuDialog.MenuItem)localObject).title = HardCodeUtil.a(2131712965);
    ((PopupMenuDialog.MenuItem)localObject).titleSize = 14.0F;
    ((PopupMenuDialog.MenuItem)localObject).iconId = 2130842629;
    localArrayList.add(localObject);
    localObject = new PopupMenuDialog.MenuItem();
    ((PopupMenuDialog.MenuItem)localObject).id = 3;
    ((PopupMenuDialog.MenuItem)localObject).title = HardCodeUtil.a(2131712894);
    ((PopupMenuDialog.MenuItem)localObject).iconId = 2130842629;
    localArrayList.add(localObject);
    PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
    localMenuItem.id = 4;
    if (!ReadInJoyUtils.a()) {
      localObject = "打开预加载UI";
    } else {
      localObject = "取消预加载UI";
    }
    localMenuItem.title = ((String)localObject);
    localMenuItem.iconId = 2130842629;
    localArrayList.add(localMenuItem);
    localMenuItem = new PopupMenuDialog.MenuItem();
    localMenuItem.id = 5;
    if (!((Boolean)RIJSPUtils.a("dynamicFeeds", Boolean.valueOf(false))).booleanValue()) {
      localObject = "打开动态频道feeds";
    } else {
      localObject = "取消动态频道feeds";
    }
    localMenuItem.title = ((String)localObject);
    localMenuItem.titleSize = 12.0F;
    localMenuItem.iconId = 2130842629;
    localArrayList.add(localMenuItem);
    localMenuItem = new PopupMenuDialog.MenuItem();
    localMenuItem.id = 6;
    if (!FeedsSPUtils.a(this.jdField_a_of_type_MqqAppAppRuntime)) {
      localObject = HardCodeUtil.a(2131712799);
    } else {
      localObject = "切换到Web";
    }
    localMenuItem.title = ((String)localObject);
    localMenuItem.titleSize = 12.0F;
    localMenuItem.iconId = 2130842629;
    localArrayList.add(localMenuItem);
    PopupMenuDialog.build(a(), localArrayList, new ReadinjoyTabFrame.24(this)).showAsDropDown(this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch);
  }
  
  private void O()
  {
    boolean bool = StudyModeManager.a();
    if (bool == this.jdField_e_of_type_Boolean) {
      return;
    }
    this.jdField_e_of_type_Boolean = bool;
    bool = StudyModeManager.a();
    int j = 8;
    int k = 0;
    int i;
    if (bool)
    {
      i = 0;
    }
    else
    {
      i = 8;
      j = 0;
    }
    Object localObject = this.jdField_b_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setVisibility(j);
    }
    localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localObject != null) {
      ((ViewGroup)localObject).setVisibility(j);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localObject != null) {
      ((RelativeLayout)localObject).setVisibility(i);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager;
    if (localObject != null) {
      ((ReadInJoyChannelViewPager)localObject).setSlideLeftAndRight(this.jdField_e_of_type_Boolean ^ true);
    }
    localObject = this.jdField_d_of_type_AndroidWidgetImageView;
    if (localObject != null)
    {
      if (RIJStudyModeUtils.a()) {
        i = k;
      } else {
        i = 4;
      }
      ((ImageView)localObject).setVisibility(i);
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    if ((a() instanceof ReadInJoyRecommendFeedsFragment)) {
      d();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateStudyModelUI, isStudyMode= ");
    ((StringBuilder)localObject).append(this.jdField_e_of_type_Boolean);
    QLog.d("ReadInJoyTabFrame", 1, ((StringBuilder)localObject).toString());
  }
  
  private void P()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.c();
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.d();
    ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchReadInJoySelfActivity(a(), bool);
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = RIJTransMergeKanDianReport.a();
        localJSONObject.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        if (!bool) {
          break label255;
        }
        i = 2;
        localJSONObject.put("reddot", i);
        localJSONObject.put("kandian_mode", RIJAppSetting.a());
        localJSONObject.put("kandian_mode_new", VideoReporter.a());
        Object localObject = (ReadInJoySkinManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
        if ((((ReadInJoySkinManager)localObject).a() != 1) || (TextUtils.isEmpty(((ReadInJoySkinManager)localObject).a()))) {
          break label260;
        }
        localObject = ((ReadInJoySkinManager)localObject).a();
        localJSONObject.put("skin_id", localObject);
        localJSONObject.put("button_state", 0);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(a(), "", "0X8007DB0", "0X8007DB0", 0, 0, "4", "", "", localJSONObject.toString(), false);
        localObject = new HashMap();
        ((Map)localObject).put("uin", RIJQQAppInterfaceUtil.a());
        UserAction.onUserAction("actRIJSelfPage", (Map)localObject, false, false);
        UserAction.onUserAction("actRIJSelfPage", (Map)localObject, false, false);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      PublicTracker.a(null, "self_tab_cost");
      return;
      label255:
      int i = 1;
      continue;
      label260:
      String str = "0";
    }
  }
  
  private int a(boolean paramBoolean)
  {
    int j = a().getDimensionPixelOffset(2131297336);
    int i;
    if (paramBoolean) {
      i = ViewUtils.b(5.0F);
    } else {
      i = 0;
    }
    Object localObject = this.jdField_a_of_type_AndroidxFragmentAppFragmentManager;
    if (localObject != null)
    {
      localObject = ((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
      if ((localObject instanceof MainFragment))
      {
        int k = RIJWindowUtils.a.a((MainFragment)localObject);
        if (k != 0) {
          return k;
        }
      }
    }
    return j + i;
  }
  
  private VideoInfo a()
  {
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 7);
    double d1 = DeviceInfoUtil.i();
    Double.isNaN(d1);
    int i = (int)(d1 * 0.4D);
    d1 = DeviceInfoUtil.j();
    Double.isNaN(d1);
    int j = (int)(d1 * 0.4D);
    Object localObject2 = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationOnScreen((int[])localObject2);
    int k = localObject2[0];
    int m = this.jdField_a_of_type_AndroidViewView.getWidth();
    int n = localObject2[1];
    int i1 = this.jdField_a_of_type_AndroidViewView.getHeight();
    ((Bundle)localObject1).putInt("item_x", k + m - i);
    ((Bundle)localObject1).putInt("item_y", n + i1 - j);
    ((Bundle)localObject1).putInt("item_width", i);
    ((Bundle)localObject1).putInt("item_height", j);
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton;
    if (localObject2 != null)
    {
      ((Bundle)localObject1).putInt("item_image_width", ((ColorBandVideoEntranceButton)localObject2).a());
      ((Bundle)localObject1).putInt("item_image_height", this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.b());
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsFirstVideoRecommendationManager;
    if (localObject2 != null)
    {
      boolean bool = ((VideoFeedsFirstVideoRecommendationManager)localObject2).a((Bundle)localObject1);
      localObject2 = (VideoInfo)((Bundle)localObject1).getParcelable("VIDEO_OBJ");
      if (ReadInJoyHelper.e() == 1)
      {
        localObject1 = FeedsChannelDataHelper.a((VideoInfo)localObject2);
        if ((localObject1 != null) && ((localObject1 instanceof BaseArticleInfo))) {
          RIJListViewGroupHandlerClick.a(a(), null, (AbsBaseArticleInfo)localObject1, false, 0, 0, false, 1004);
        } else {
          ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchChannelActivity(a(), 56, a().getString(2131719066), 3, 1004);
        }
      }
      else
      {
        VideoFeedsHelper.a(a(), (Bundle)localObject1, bool ^ true, 11);
        d(3);
      }
      return localObject2;
    }
    QLog.d("ReadInJoyTabFrame", 1, "videoManager is null, can't jump to videoPlayActivity!");
    return null;
  }
  
  private void a(int paramInt, PositionData paramPositionData)
  {
    Object localObject = a();
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
    ThreadManager.excute(new ReadinjoyTabFrame.18(this, paramVideoInfo, (ReadInJoySkinManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)), 16, null, true);
  }
  
  public static void a(String paramString)
  {
    try
    {
      localObject = new RIJTransMergeKanDianReport.ReportR5Builder();
      ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).addNetworkType();
      ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).addVersion();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramString, paramString, 0, 0, "", "", "", ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).build(), false);
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
  
  private void b(String paramString)
  {
    RIJSPUtils.a("KEY_ENTRANCE_SCHEMA", paramString);
  }
  
  private void c(View paramView)
  {
    int j = RIJColumnDataSource.b;
    try
    {
      paramView = paramView.getTag();
      i = j;
      if (paramView == null) {
        break label37;
      }
      i = Integer.parseInt(String.valueOf(paramView));
    }
    catch (Exception paramView)
    {
      int i;
      label26:
      Object localObject;
      EntranceIconInfo localEntranceIconInfo;
      break label26;
    }
    QLog.d("ReadInJoyTabFrame", 1, "parseInt error!");
    i = j;
    label37:
    paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton;
    if ((paramView != null) && (paramView.a() != null))
    {
      paramView = new StringBuilder();
      paramView.append("entrancebutton has red dot: ");
      paramView.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.a());
      QLog.d("ReadInJoyTabFrame", 1, paramView.toString());
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.a();
      if ((localObject instanceof VideoInfo.EntranceDownloadInfo))
      {
        paramView = (VideoInfo.EntranceDownloadInfo)localObject;
        if (paramView.a != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("entrancebutton downloadinfo: ");
          ((StringBuilder)localObject).append(paramView.a);
          QLog.d("ReadInJoyTabFrame", 1, ((StringBuilder)localObject).toString());
          if (QLog.isColorLevel()) {
            QLog.d("VideoEntranceButton", 2, "resolveUrlJumpInfo");
          }
          VideoFeedsHelper.a(a(), paramView.a);
          if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsFirstVideoRecommendationManager == null) {
            break label599;
          }
          VideoFeedsFirstVideoRecommendationManager.b(paramView);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsFirstVideoRecommendationManager.a();
          break label599;
        }
      }
      if ((localObject instanceof EntranceIconInfo))
      {
        localEntranceIconInfo = (EntranceIconInfo)localObject;
        localObject = localEntranceIconInfo.c;
        paramView = new StringBuilder();
        paramView.append("entranceIconInfo recommendfeeds jumpSchema ");
        paramView.append((String)localObject);
        QLog.d("ReadInJoyTabFrame", 1, paramView.toString());
        paramView = (View)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramView = RecommendFeedsDiandianEntranceManager.getFeedsDefaultSchema(localEntranceIconInfo.jdField_a_of_type_Int);
        }
        if (!TextUtils.isEmpty(paramView))
        {
          ReadInJoyUtils.a(a(), paramView);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.setDataSource(null);
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
        if (paramView.a == null) {
          ReadInJoyUtils.a(a(), ReadInJoyHelper.a());
        } else {
          VideoFeedsHelper.a(a(), paramView.a);
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.setDataSource(null);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.a();
        RecommendFeedsDiandianEntranceManager.getInstance().columnDiandianClickReport(paramView, i, 0, a());
      }
      else
      {
        QLog.d("ReadInJoyTabFrame", 1, "lauch videofeeds");
        a(a());
      }
    }
    else
    {
      j = RecommendFeedsDiandianEntranceManager.getInstance().getEntryFeedsType();
      paramView = new StringBuilder();
      paramView.append("diandian button jump to default url! feedType ");
      paramView.append(j);
      QLog.d("ReadInJoyTabFrame", 1, paramView.toString());
      paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton;
      if ((paramView != null) && (paramView.jdField_a_of_type_Boolean))
      {
        QLog.d("ReadInJoyTabFrame", 1, "isColumnDiandianBtn true");
        RecommendFeedsDiandianEntranceManager.getInstance().columnDiandianClickReport(null, i, 0, a());
        ReadInJoyUtils.a(a(), ReadInJoyHelper.a());
      }
      else if ((j != 2) && (j != 1))
      {
        QLog.d("ReadInJoyTabFrame", 1, "jump default schema");
        ReadInJoyUtils.a(a(), RecommendFeedsDiandianEntranceManager.getFeedsDefaultSchema(j));
      }
      else
      {
        QLog.d("ReadInJoyTabFrame", 1, "ENTRANCE_FEEDS_TYPE_VIDEO or ENTRANCE_FEEDS_TYPE_VIDEO_CHANNEL");
        a(a());
      }
    }
    label599:
    if (RIJKanDianYaobuIconClickReportAladdinConfig.a()) {
      b(2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoEntranceButton", 2, "performVideoFeedsClick");
    }
  }
  
  private void d(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsFirstVideoRecommendationManager != null) && (RecommendFeedsDiandianEntranceManager.getInstance().isVideoFeedsType())) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsFirstVideoRecommendationManager.a(paramInt);
    }
  }
  
  private boolean d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetClipDianDianTouchAreaLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton != null))
    {
      int i;
      if ((ReadInJoyHelper.a("sp_key_readinjoy_video_entrance_reddot_button_switch", true)) && (RIJDianDianEntryVisibleConfig.a.a(a()))) {
        i = 1;
      } else {
        i = 0;
      }
      int j;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.getVisibility() == 0) {
        j = 1;
      } else {
        j = 0;
      }
      if (i != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetClipDianDianTouchAreaLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.setVisibility(0);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetClipDianDianTouchAreaLayout.setVisibility(4);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.setVisibility(8);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setEntranceButton Visibility: ");
      String str;
      if (i != 0) {
        str = "true";
      } else {
        str = "false";
      }
      localStringBuilder.append(str);
      QLog.d("ReadInJoyTabFrame", 1, localStringBuilder.toString());
      if ((j == 0) && (i != 0)) {
        RecommendFeedsDiandianEntranceManager.getInstance().reportEntryIconExposure(0, a());
      }
      return j != i;
    }
    return false;
  }
  
  private void h(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetClipDianDianTouchAreaLayout != null)
    {
      int i = a(paramBoolean);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetClipDianDianTouchAreaLayout.getLayoutParams();
      localLayoutParams.bottomMargin = i;
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetClipDianDianTouchAreaLayout.setLayoutParams(localLayoutParams);
    }
  }
  
  public static void t()
  {
    RIJTabFrameDeliverPopupUtil.a("0X800AC6D", 3);
  }
  
  private void u()
  {
    d();
    G();
    RecommendFeedsDiandianEntranceManager.getInstance().onAccountChange();
    VideoFeedsFirstVideoRecommendationManager localVideoFeedsFirstVideoRecommendationManager = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsFirstVideoRecommendationManager;
    if (localVideoFeedsFirstVideoRecommendationManager != null) {
      localVideoFeedsFirstVideoRecommendationManager.d();
    }
  }
  
  private void v()
  {
    a(2131379023).setBackgroundDrawable(null);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyTabTopSearchHeaderController = new ReadInJoyTabTopSearchHeaderController(a(), (ViewGroup)a(2131379023));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131376049));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager = ((ReadInJoyChannelViewPager)a(2131376066));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131376046));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131378008));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)a(2131376603));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)a(2131364655));
    this.jdField_b_of_type_AndroidViewView = a(2131378803);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadinjoySlidingIndicator = ((ReadinjoySlidingIndicator)a(2131377670));
    K();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadinjoySlidingIndicator.setTabData(this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ArrayOfInt, ReadInJoyNaviController.d);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadinjoySlidingIndicator.setOnIndicatorChangeListener(this);
    int i = 1;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)a(2131378881));
    this.jdField_d_of_type_AndroidViewView = a(2131377865);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131376129));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131376128));
    this.h = a(2131377065);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131379868));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131379867));
    if (RIJKanDianOverDrawOptimizeAladdinConfig.a())
    {
      QLog.d("ReadInJoyTabFrame", 2, "overdraw switch open");
      localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout;
      if (localObject != null) {
        ((FrameLayout)localObject).setBackgroundColor(a().getColor(2131167394));
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager;
      if (localObject != null) {
        ((ReadInJoyChannelViewPager)localObject).setBackgroundColor(a().getColor(2131167333));
      }
    }
    else
    {
      QLog.d("ReadInJoyTabFrame", 2, "overdraw switch close");
    }
    boolean bool = RIJUgcUtils.m();
    int j = 8;
    if (bool) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    } else {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (RIJMsgBoxUtils.a() != 0) {
      i = 0;
    }
    Object localObject = a(2131371575);
    if (i != 0) {
      j = 0;
    }
    ((View)localObject).setVisibility(j);
    this.g = a(2131376100);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131371538));
    i = AIOUtils.b(3.0F, a());
    this.jdField_c_of_type_AndroidWidgetTextView.setPadding(i, 0, i, 0);
    this.g.setOnClickListener(new ReadinjoyTabFrame.1(this));
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(a().getBaseContext(), a(2131372007)).b(53).a();
    VideoReport.setElementId(this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch, "head_sculpture_button");
    VideoReport.setElementReportPolicy(this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch, ReportPolicy.REPORT_POLICY_CLICK);
    VideoReport.setElementParams(this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch, new RIJDtParamBuilder().a("14").c("click_head_sculpture").a().a());
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.setOnClickListener(new ReadinjoyTabFrame.2(this));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new ReadinjoyTabFrame.3(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new ReadinjoyTabFrame.4(this));
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
    IphoneTitleBarActivity.setLayerType(this.jdField_d_of_type_AndroidViewView);
    au_();
    aD_();
    z();
    y();
    localObject = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadinjoyViewLayer.findViewById(2131365118);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetDuplicateEventLayout.setViews((ViewGroup)localObject, this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetClipDianDianTouchAreaLayout);
    F();
    if ("2225164739".equals(a().getCurrentAccountUin())) {
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.setOnLongClickListener(new ReadinjoyTabFrame.5(this));
    }
    m();
  }
  
  private void w()
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView == null) {
      return;
    }
    boolean bool = RIJUgcUtils.m();
    if (bool) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    } else {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if ((QLog.isDebugVersion()) || (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[refreshDeliverButton] needShow = ");
      localStringBuilder.append(bool);
      QLog.i("ReadInJoyTabFrame", 2, localStringBuilder.toString());
    }
  }
  
  private void x()
  {
    SelectPositionModule localSelectPositionModule = ReadInJoyLogicEngine.a().a();
    if (localSelectPositionModule != null) {
      localSelectPositionModule.a();
    }
  }
  
  private void y()
  {
    b(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager$CustomFragmentPagerAdapter = new ReadInJoyChannelViewPager.CustomFragmentPagerAdapter(this.jdField_a_of_type_AndroidxFragmentAppFragmentManager);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyTabTopSearchHeaderController);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager$CustomFragmentPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPagerController = new ReadInJoyChannelViewPagerController(a(), this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPagerController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyTabTopSearchHeaderController);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPagerController.a(new ReadinjoyTabFrame.6(this));
  }
  
  private void z()
  {
    A();
  }
  
  protected void V_()
  {
    super.V_();
  }
  
  public int a()
  {
    ReadInJoyChannelViewPagerController localReadInJoyChannelViewPagerController = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPagerController;
    if (localReadInJoyChannelViewPagerController != null) {
      return localReadInJoyChannelViewPagerController.b();
    }
    return -1;
  }
  
  public int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    return 0;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560226, null);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadinjoyViewLayer = new ReadinjoyViewLayer(a().getBaseContext());
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadinjoyViewLayer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadinjoyViewLayer.addView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetDuplicateEventLayout = new DuplicateEventLayout(a());
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetDuplicateEventLayout.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadinjoyViewLayer);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetDuplicateEventLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetDuplicateEventLayout;
  }
  
  public ReadInJoyBaseFragment a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPagerController;
    if (localObject != null)
    {
      localObject = ((ReadInJoyChannelViewPagerController)localObject).a();
      if ((localObject instanceof ReadInJoyBaseFragment)) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonFragmentReadInJoyBaseFragment = ((ReadInJoyBaseFragment)localObject);
      }
    }
    ReadInJoyBaseFragment localReadInJoyBaseFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonFragmentReadInJoyBaseFragment;
    localObject = localReadInJoyBaseFragment;
    if (localReadInJoyBaseFragment != null)
    {
      localObject = localReadInJoyBaseFragment;
      if (localReadInJoyBaseFragment.a() == null)
      {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "FragmentOnStartError", false, NetConnInfoCenter.getServerTimeMillis() - this.jdField_d_of_type_Long, 0L, null, "", true);
        ThreadManager.getSubThreadHandler().postDelayed(new ReadinjoyTabFrame.9(this, localReadInJoyBaseFragment), 1000L);
        localObject = null;
      }
    }
    return localObject;
  }
  
  public ChannelCoverInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelCoverInfo;
  }
  
  protected String a()
  {
    return HardCodeUtil.a(2131693524);
  }
  
  protected void a()
  {
    super.a();
    ReadInJoyLogicEngineEventDispatcher.a().a();
    Object localObject = (BaseActivity)a();
    if ((localObject instanceof SplashActivity)) {
      this.jdField_a_of_type_AndroidxFragmentAppFragmentManager = ((SplashActivity)localObject).getSupportFragmentManager();
    } else if ((localObject instanceof BaseActivity)) {
      this.jdField_a_of_type_AndroidxFragmentAppFragmentManager = ((BaseActivity)localObject).getSupportFragmentManager();
    }
    if (localObject != null) {
      GdtManager.a().a((Context)localObject, new GdtManager.Params());
    }
    v();
    localObject = (KandianMergeManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    ((KandianMergeManager)localObject).a(this);
    ((KandianMergeManager)localObject).a(this);
    ((ReadInJoySkinManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    Wormhole.a();
    RIJRewardTaskLocalRepo.b().a();
  }
  
  public void a(int paramInt)
  {
    ReadInJoyChannelViewPagerController localReadInJoyChannelViewPagerController = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPagerController;
    if (localReadInJoyChannelViewPagerController != null) {
      localReadInJoyChannelViewPagerController.c(paramInt);
    }
  }
  
  protected void a(int paramInt, KandianMergeManager paramKandianMergeManager)
  {
    if ((paramKandianMergeManager.b()) || (paramKandianMergeManager.e() > 0))
    {
      if (paramInt == 6)
      {
        paramInt = a().getIntent().getIntExtra("jump_activity_launch_channel_id", 0);
        RIJChannelReporter.a(paramInt, "304");
      }
      else
      {
        paramInt = 0;
      }
      if ((paramInt == 0) || (paramInt == ChannelCoverInfoModule.a())) {
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
    paramConfiguration = a().getDisplayMetrics();
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
      this.jdField_c_of_type_Int = ((AladdinConfig)localObject2).getIntegerFromString("SearchBox_TopBGType", 0);
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
      if (this.jdField_c_of_type_Int == 1)
      {
        a(this.jdField_d_of_type_AndroidViewView, true);
        a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
        a(this.jdField_b_of_type_AndroidViewView, true);
        this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(-1);
        this.jdField_b_of_type_AndroidWidgetImageView.setColorFilter(-1);
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadinjoySlidingIndicator.a(2131167053, 2131167053, 2131167053);
        paramDrawable.setColorFilter(a().getColor(2131167053), PorterDuff.Mode.SRC_IN);
        ((ImageView)this.g).setImageDrawable(paramDrawable);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageView.clearColorFilter();
        this.jdField_b_of_type_AndroidWidgetImageView.clearColorFilter();
      }
      paramDrawable = (GradientDrawable)this.h.getBackground();
      paramDrawable.setStroke(ViewUtils.b(1.0F), Color.parseColor((String)localObject3));
      paramDrawable.setColor(Color.parseColor((String)localObject1));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor((String)localObject2));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor((String)localObject2));
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    aD_();
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    aD_();
  }
  
  public void a(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton == null) {
      return;
    }
    QLog.d("ReadInJoyTabFrame", 1, "onEntryIconRefresh");
    this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.setDataSource(paramIEntranceButtonDataSource);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.getVisibility() == 0)
    {
      if (paramIEntranceButtonDataSource != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.a(paramIEntranceButtonDataSource);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.setNotMsg();
    }
  }
  
  protected void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    ((ReadInJoyRefreshManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER)).a(0, "", -1L, 0);
    if (a() != null) {
      a().a(paramLogoutReason);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (a() != null) {
      a().a(this);
    }
    Object localObject = a().findViewById(16908305);
    if (localObject != null) {
      SlideActiveAnimController.a((View)localObject);
    }
    jdField_a_of_type_Boolean = true;
    ApngImage.playByTag(8);
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton;
    if ((localObject != null) && (((ColorBandVideoEntranceButton)localObject).getVisibility() == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.e();
      if (paramBoolean) {
        d(1);
      } else if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsFirstVideoRecommendationManager != null) {
        VideoFeedsFirstVideoRecommendationManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.a());
      }
    }
    if (paramBoolean)
    {
      localObject = ReadInJoyLogicEngine.a().a();
      if (localObject != null) {
        ((FreeNetFlowInfoModule)localObject).a(false);
      }
      RIJPushNotification.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyTabTopSearchHeaderController.c();
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton;
    if (localObject != null) {
      ((ColorBandVideoEntranceButton)localObject).g();
    }
    localObject = a().getIntent();
    ReadInJoyChannelViewPagerController localReadInJoyChannelViewPagerController = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPagerController;
    if (localReadInJoyChannelViewPagerController != null) {
      localReadInJoyChannelViewPagerController.c();
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      x();
      this.jdField_c_of_type_Boolean = true;
    }
    if (RIJTabFrameBase.a.a()) {
      RIJKanDianTabReport.a(true);
    }
    ReadInJoyLogicEngine.a().r();
    if (((Boolean)RIJSPUtils.a("key_sp_is_readinjoy_youngster_changed", Boolean.valueOf(false))).booleanValue())
    {
      if (((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonFragmentReadInJoyBaseFragment instanceof ReadInJoyRecommendFeedsFragment)) && (!((Intent)localObject).getBooleanExtra("is_watch_word_share", false))) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonFragmentReadInJoyBaseFragment.a(9);
      }
      RIJSPUtils.a("key_sp_is_readinjoy_youngster_changed", Boolean.valueOf(false));
    }
    O();
  }
  
  public void aD_()
  {
    SparseIntArray localSparseIntArray = ((KandianMergeManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a();
    int j = 0;
    while (j < localSparseIntArray.size())
    {
      int k = localSparseIntArray.keyAt(j);
      int m = localSparseIntArray.valueAt(j);
      int i;
      if (k != 0)
      {
        if (k != 1)
        {
          if (k != 2)
          {
            if (k == 3) {
              break label128;
            }
            i = -1;
          }
          else
          {
            i = 2131376124;
          }
        }
        else {
          i = 2131376141;
        }
      }
      else {
        i = 2131376113;
      }
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
      localMessage.arg1 = m;
      localMessage.arg2 = i;
      localMessage.obj = Integer.valueOf(k);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      label128:
      j += 1;
    }
    ThreadManager.getUIHandler().post(new ReadinjoyTabFrame.15(this));
  }
  
  public void ab_()
  {
    super.ab_();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.a() != this) {
      M();
    }
    jdField_a_of_type_Boolean = false;
    I();
    ApngImage.pauseByTag(8);
    ReadInJoyLogicEngine.n();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyTabTopSearchHeaderController.d();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton;
    if (localObject != null) {
      ((ColorBandVideoEntranceButton)localObject).f();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPagerController;
    if (localObject != null) {
      ((ReadInJoyChannelViewPagerController)localObject).d();
    }
  }
  
  public void at_()
  {
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if (localReadInJoyBaseFragment != null) {
      localReadInJoyBaseFragment.f();
    }
    try
    {
      RIJKanDianTabReport.a(a(), localReadInJoyBaseFragment);
      RIJKanDianTabReport.a(a(), true);
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ReadInJoyTabFrame", 1, localJSONException, new Object[0]);
    }
  }
  
  public void au_()
  {
    Drawable localDrawable = a().getDrawable(2130843048);
    if ((!ThemeUtil.isDefaultOrDIYTheme(false)) && (!ThemeUtil.isSimpleDayTheme(false)))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850473);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840334);
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130850433);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadinjoySlidingIndicator.a(2131167053, 2131167053, 2131167053);
      localDrawable.setColorFilter(a().getColor(2131167053), PorterDuff.Mode.SRC_IN);
      ((ImageView)this.g).setImageDrawable(localDrawable);
      a(this.jdField_d_of_type_AndroidViewView, false);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842962);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842958);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-1);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadinjoySlidingIndicator.a(2131166935, 2131166936, 2131166934);
      localDrawable.setColorFilter(a().getColor(2131165327), PorterDuff.Mode.SRC_IN);
      ((ImageView)this.g).setImageDrawable(localDrawable);
      a(localDrawable);
    }
    J();
    RIJAppSetting.a(a(), this, true, this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, this.jdField_c_of_type_Int);
    ReadInJoyLogicEngineEventDispatcher.a().g();
  }
  
  public int b()
  {
    return 0;
  }
  
  public void b(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadinjoyViewLayer.a(paramView);
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    aD_();
  }
  
  public void b(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton == null) {
      return;
    }
    QLog.d("ReadInJoyTabFrame", 1, "onAccountChange");
    this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.setDataSource(paramIEntranceButtonDataSource);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.getVisibility() == 0)
    {
      if (paramIEntranceButtonDataSource != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.a(paramIEntranceButtonDataSource);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.setNotMsg();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      A();
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      QLog.d("ReadInJoyTabFrame", 1, "init Channel Entry failed.");
    }
    ReadInJoyChannelViewPagerController localReadInJoyChannelViewPagerController = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPagerController;
    if (localReadInJoyChannelViewPagerController != null) {
      localReadInJoyChannelViewPagerController.f();
    }
  }
  
  public void c(int paramInt)
  {
    if (paramInt == 13)
    {
      ReadInJoyUtils.a(6);
      Object localObject = a().getIntent().getExtras();
      if (DailyFeedsDiandianEntranceManager.a((Bundle)localObject))
      {
        localObject = DailyFeedsDiandianEntranceManager.a((Bundle)localObject);
        if (localObject != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.setDataSource((IEntranceButtonDataSource)localObject);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.a((IEntranceButtonDataSource)localObject);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.postDelayed(new ReadinjoyTabFrame.25(this), 1000L);
        }
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    RIJAppSetting.a(a(), this, true, this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, this.jdField_c_of_type_Int);
    Object localObject = (KandianMergeManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    VideoReport.traversePage(this.jdField_a_of_type_AndroidViewView);
    if (paramBoolean)
    {
      a(this.jdField_a_of_type_Int, (KandianMergeManager)localObject);
      c(this.jdField_a_of_type_Int);
      ReadInJoyWebRenderEngine.c();
      s();
      L();
      p();
      RIJMsgReport.a.a();
      h(ThemeUtil.isInNightMode(this.jdField_a_of_type_MqqAppAppRuntime));
    }
    else
    {
      o();
      RIJAppSetting.a(a(), this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
      n();
    }
    g(paramBoolean);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("readinjoy tab change visiable : ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append("， launchFrom : ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    QLog.d("Q.readinjoy.4tab", 1, ((StringBuilder)localObject).toString());
    O();
    RIJPushNotifyManager.Companion.a().dismiss(false, "MATCH_ALL_UIN");
  }
  
  protected void d()
  {
    super.d();
    ((ReadInJoySkinManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton);
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyTabTopSearchHeaderController.e();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPagerController;
    if (localObject != null)
    {
      ((ReadInJoyChannelViewPagerController)localObject).e();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPagerController = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsFirstVideoRecommendationManager;
    if (localObject != null) {
      ((VideoFeedsFirstVideoRecommendationManager)localObject).c();
    }
    localObject = (KandianMergeManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    ((KandianMergeManager)localObject).b(this);
    ((KandianMergeManager)localObject).b(this);
    RIJCommentResultDispatcher.a().a();
    ReadInJoyDataProviderObserver.getInstance().removeFluencyObserver();
    KandianVideoUploadService.a(null);
    RecommendFeedsDiandianEntranceManager.getInstance().removeEntryRefreshListener(this);
    UserActionCollector.a().c();
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton;
    if (localObject != null) {
      ((ColorBandVideoEntranceButton)localObject).i();
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
    Object localObject1 = a();
    if (localObject1 != null)
    {
      ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setChannelID(((ReadInJoyBaseFragment)localObject1).b());
      localObject2 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSuperMaskChannelId ");
      localStringBuilder.append(((ReadInJoyBaseFragment)localObject1).b());
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
  
  public void e_(boolean paramBoolean)
  {
    if (!paramBoolean) {
      I();
    }
  }
  
  protected void f()
  {
    super.f();
    Object localObject = (KandianMergeManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    ((KandianMergeManager)localObject).a(this);
    ((KandianMergeManager)localObject).a(this);
    int i;
    if (RIJMsgBoxUtils.a() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    localObject = a(2131371575);
    if (i != 0) {
      i = 0;
    } else {
      i = 8;
    }
    ((View)localObject).setVisibility(i);
    m();
    ((ReadInJoySkinManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton);
    if (RIJUgcUtils.m()) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    } else {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    RIJDianDianEntryVisibleConfig.a.b();
    u();
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPagerController != null)
    {
      int j = 0;
      int i = j;
      if (!paramBoolean)
      {
        i = j;
        if (ChannelCoverInfoModule.a() != -1) {
          i = ChannelCoverInfoModule.a();
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPagerController.c(i);
    }
  }
  
  protected void g(boolean paramBoolean)
  {
    ReadInJoyChannelViewPagerController localReadInJoyChannelViewPagerController = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPagerController;
    if (localReadInJoyChannelViewPagerController != null) {
      localReadInJoyChannelViewPagerController.a(paramBoolean);
    }
  }
  
  public void i()
  {
    w();
  }
  
  public void m()
  {
    Object localObject = ((KandianMergeManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a();
    if (localObject != null)
    {
      int i = ((KandianMsgBoxRedPntInfo)localObject).mMsgCnt;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      if (i > 99) {
        localObject = "99+";
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public boolean m_()
  {
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    return ((a() != null) && (a().mChannelCoverId != 0)) || (localKandianMergeManager.e() > 0);
  }
  
  protected void n() {}
  
  protected void o()
  {
    int i = 0;
    while (i < 1)
    {
      ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
      if (localReadInJoyBaseFragment != null) {
        localReadInJoyBaseFragment.g();
      }
      i += 1;
    }
  }
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotColorBandVideoEntranceButton.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    H();
  }
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    QLog.d("ReadInJoyTabFrame", 2, new Object[] { "onLoadUserInfoFailed, uin = ", paramString1, Character.valueOf('\n'), "errMsg = ", paramString2 });
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    QLog.d("ReadInJoyTabFrame", 2, new Object[] { "onLoadUserInfoSucceed uin = ", paramString, Character.valueOf('\n'), "userInfo = ", paramReadInJoyUserInfo });
  }
  
  protected void p()
  {
    if ((StudyModeManager.a()) && (RIJStudyModeUtils.a())) {
      a("0X800AF05");
    }
  }
  
  protected void r()
  {
    if ((a() instanceof ReadInJoyRecommendFeedsFragment))
    {
      ReadInJoyDianDianEntranceModule localReadInJoyDianDianEntranceModule = ReadInJoyLogicEngine.a().a();
      if (localReadInJoyDianDianEntranceModule != null)
      {
        localReadInJoyDianDianEntranceModule.b(ReadInJoyHelper.e());
        return;
      }
      QLog.d("ReadInJoyTabFrame", 1, "requestColumn0x6cf failed!");
    }
  }
  
  protected void s()
  {
    long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    Object localObject = a();
    boolean bool = false;
    int i;
    if ((localObject != null) && (!(a() instanceof ReadInJoyRecommendFeedsFragment)))
    {
      long l2 = ReadInJoyHelper.d(RIJQQAppInterfaceUtil.a());
      if ((l1 >= l2) && (this.jdField_a_of_type_Long != 0L))
      {
        this.jdField_d_of_type_Boolean = true;
        ReadInJoyLogicEngineEventDispatcher.a().k();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("auto focus on recommend channel, exitTime : ");
        ((StringBuilder)localObject).append(l1);
        QLog.d("Q.readinjoy.4tab", 2, new Object[] { ((StringBuilder)localObject).toString(), ", timeLimit = ", Long.valueOf(l2) });
        i = 1;
      }
      else
      {
        i = 0;
      }
      if (StudyModeManager.a())
      {
        i = 1;
        bool = true;
      }
    }
    else
    {
      i = 0;
    }
    if (i != 0) {
      f(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame
 * JD-Core Version:    0.7.0.1
 */