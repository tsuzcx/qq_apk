package com.tencent.mobileqq.kandian.biz.feeds.activity;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyScreenShotReporter;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyWebProcessManager;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyBaseViewController;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyChannelViewController;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.video.VideoUIManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.RIJWeiShiLegacyUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyWebRenderEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJStatisticCollectorReport;
import com.tencent.mobileqq.kandian.glue.report.ReadInJoyGlobalReporter;
import com.tencent.mobileqq.kandian.glue.report.WeishiReportUtil;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl;
import com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoaderManager;
import com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoaderManager.Companion;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.playfeeds.PlayFeedsSPUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;

public class ReadInJoyChannelActivity
  extends IphoneTitleBarActivity
  implements Observer
{
  protected long a;
  private MessageForStructing jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
  protected ReadInJoyBaseViewController a;
  String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long = -1L;
  private boolean jdField_b_of_type_Boolean = false;
  
  public ReadInJoyChannelActivity()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController = null;
  }
  
  private void a(int paramInt)
  {
    runOnUiThread(new ReadInJoyChannelActivity.8(this, paramInt));
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      if (this.jdField_b_of_type_Boolean) {
        return;
      }
      paramViewGroup.setOnClickListener(new ReadInJoyChannelActivity.5(this));
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if ((a()) && (this.jdField_a_of_type_Long != 0L))
    {
      ReadInJoyBaseViewController localReadInJoyBaseViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController;
      if ((localReadInJoyBaseViewController != null) && (localReadInJoyBaseViewController.a() != null))
      {
        localReadInJoyBaseViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController;
        if (((localReadInJoyBaseViewController instanceof ReadInJoyChannelViewController)) && (((ReadInJoyChannelViewController)localReadInJoyBaseViewController).a() != null) && (((ReadInJoyChannelViewController)this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController).a().size() > 0)) {
          RIJStatisticCollectorReport.a(56, (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L, this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController.a().a(), (AbsBaseArticleInfo)((ReadInJoyChannelViewController)this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController).a().get(0), paramBoolean);
        }
      }
    }
  }
  
  private boolean a()
  {
    Intent localIntent = getIntent();
    boolean bool = false;
    if (localIntent.getIntExtra("channel_id", 0) == 56) {
      bool = true;
    }
    return bool;
  }
  
  private void b(int paramInt)
  {
    VideoReport.addToDetectionWhitelist(this);
    VideoReport.setPageId(this, "118");
    VideoReport.setPageParams(this, new RIJDtParamBuilder().a(Integer.valueOf(paramInt)).a());
  }
  
  private void b(ViewGroup paramViewGroup)
  {
    if ((b()) && (ReadInJoyHelper.F(ReadInJoyUtils.a()))) {
      c(paramViewGroup);
    }
  }
  
  private boolean b()
  {
    Intent localIntent = getIntent();
    boolean bool = false;
    if (localIntent.getIntExtra("channel_id", 0) == 40677) {
      bool = true;
    }
    return bool;
  }
  
  private void c()
  {
    for (;;)
    {
      try
      {
        if (!getIntent().getBooleanExtra("is_daily_dynamic_child_channel", false)) {
          return;
        }
        HashMap localHashMap = (HashMap)getIntent().getSerializableExtra("channel_map_data");
        if (localHashMap != null)
        {
          this.jdField_a_of_type_JavaLangString = ((String)localHashMap.get("channelName"));
          this.jdField_b_of_type_Boolean = "1".equals(localHashMap.get("canDownRefresh"));
          bool2 = "1".equals(localHashMap.get("canUpRefresh"));
          bool1 = "1".equals(localHashMap.get("isImmersive"));
          ReadInJoyHelper.b(Integer.valueOf((String)localHashMap.get("channelID")).intValue());
          if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController != null)
          {
            ((ReadInJoyChannelViewController)this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController).a(this.jdField_b_of_type_Boolean, bool2, bool1);
            ((ReadInJoyChannelViewController)this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController).d();
          }
          QLog.d("IphoneTitleBarActivity", 1, new Object[] { "handlerDynamicParams mCanPullDownRefresh=", Boolean.valueOf(this.jdField_b_of_type_Boolean), " mCanPullUpRefresh=", Boolean.valueOf(bool2), " mChannelName=", this.jdField_a_of_type_JavaLangString });
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.d("IphoneTitleBarActivity", 1, new Object[] { "handlerDynamicParams mCanPullDownRefresh error, e=", localException.toString() });
        return;
      }
      boolean bool1 = false;
      boolean bool2 = false;
    }
  }
  
  private void c(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(this).inflate(2131560390, paramViewGroup, false);
      paramViewGroup.addView(localViewGroup);
      d(localViewGroup);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009337", "0X8009337", 0, 0, "", "", "", VideoReporter.c(), false);
      localViewGroup.setOnClickListener(new ReadInJoyChannelActivity.9(this));
    }
  }
  
  private boolean c()
  {
    Intent localIntent = getIntent();
    boolean bool = false;
    if (localIntent.getIntExtra("channel_id", 0) == 40830) {
      bool = true;
    }
    return bool;
  }
  
  private void d()
  {
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131376123);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController = new ReadInJoyChannelViewController(this);
    ((ReadInJoyChannelViewController)this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController).c(getIntent().getIntExtra("channel_from", -1));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController.a(localViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController.aw_();
    if ((b()) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController instanceof ReadInJoyChannelViewController))) {
      this.rightViewImg.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController);
    }
    if ((ThemeUtil.isInNightMode(ReadInJoyUtils.a())) && (this.titleRoot != null)) {
      View.inflate(this, 2131560251, this.titleRoot);
    }
    e();
    b(localViewGroup);
  }
  
  private void d(ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramViewGroup.findViewById(2131373743);
    if (WeishiGuideUtils.a(this))
    {
      paramViewGroup.setText(HardCodeUtil.a(2131712814));
      return;
    }
    paramViewGroup.setText(HardCodeUtil.a(2131712812));
  }
  
  private void e()
  {
    if (b()) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = WeishiReportUtil.b();
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController.a(true);
    ThreadManager.executeOnSubThread(new ReadInJoyChannelActivity.6(this));
  }
  
  public void a()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      setImmersiveStatus();
      this.titleRoot = ((RelativeLayout)findViewById(2131378893));
      ImmersiveUtils.clearCoverForStatus(getWindow(), this.isClearCoverLayer);
      this.titleRoot.setFitsSystemWindows(false);
      this.titleRoot.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (ThemeUtil.isInNightMode(this.app))
      {
        if ((!SystemUtil.b()) && (!SystemUtil.d()))
        {
          this.mSystemBarComp.setStatusBarColor(-7829368);
        }
        else
        {
          this.mSystemBarComp.setStatusBarColor(-7829368);
          this.mSystemBarComp.setStatusBarDarkMode(true);
        }
      }
      else if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.setStatusBarColor(-1);
      }
      else if (!SystemUtil.d())
      {
        this.mSystemBarComp.setStatusBarColor(-2368549);
      }
      else
      {
        this.mSystemBarComp.setStatusBarColor(-1);
        this.mSystemBarComp.setStatusBarDarkMode(true);
      }
    }
    this.centerView.setTextColor(-16777216);
    this.leftView.setTextColor(-14408926);
    this.leftView.setBackgroundResource(2130849814);
    if (c()) {
      this.leftView.setText(HardCodeUtil.a(2131712725));
    }
    this.vg.setBackgroundColor(-1);
    a(this.vg);
    if ((getIntent().getBooleanExtra("is_need_show_animation_translate", false)) && (this.jdField_a_of_type_Boolean))
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(400L);
      this.vg.startAnimation(localAlphaAnimation);
    }
  }
  
  public void b()
  {
    if (this.leftView != null) {
      ThreadManager.post(new ReadInJoyChannelActivity.7(this), 5, null, true);
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ReadInJoyBaseViewController localReadInJoyBaseViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController;
    if (localReadInJoyBaseViewController != null) {
      localReadInJoyBaseViewController.a(paramInt1, paramInt2, paramIntent);
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    VideoVolumeControl.getInstance().inKandianModule(this);
    this.jdField_a_of_type_Boolean = VideoFeedsHelper.c();
    if (!this.jdField_a_of_type_Boolean) {
      setTheme(2131755316);
    }
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().addFlags(-2147483648);
    }
    setContentView(2131560199);
    int i = getIntent().getIntExtra("channel_id", -1);
    ReadInJoyGlobalReporter.c(i);
    paramBundle = (ReadInJoyLogicManager)this.app.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    ReadInJoyWebProcessManager.a(this.app);
    setClickableTitle(getIntent().getStringExtra("channel_name"), new ReadInJoyChannelActivity.1(this));
    d();
    if (b())
    {
      ThreadManager.executeOnSubThread(new ReadInJoyChannelActivity.2(this));
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      WeishiReportUtil.a(getIntent().getIntExtra("channel_from", 9), WeishiReportUtil.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), WeishiReportUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), WeishiReportUtil.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), WeishiReportUtil.a(this.jdField_b_of_type_Long));
      if ((this.app != null) && (this.app.getMessageFacade() != null) && (!c())) {
        this.app.getMessageFacade().addObserver(this);
      }
      ViolaSoLoaderManager.a.a().a();
      ReadInJoyWebRenderEngine.c();
    }
    c();
    b(i);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    ((ReadInJoyLogicManager)ReadInJoyUtils.a().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().i(getIntent().getIntExtra("channel_id", 0));
    this.jdField_a_of_type_Long = 0L;
    ReadInJoyBaseViewController localReadInJoyBaseViewController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController;
    if (localReadInJoyBaseViewController != null) {
      localReadInJoyBaseViewController.e();
    }
    VideoVolumeControl.getInstance().outKandianModule(this);
    ReadInJoyScreenShotReporter.a(this).b();
    if (b())
    {
      ThreadManager.executeOnSubThread(new ReadInJoyChannelActivity.3(this));
      WeishiReportUtil.a(getIntent().getIntExtra("channel_from", 9), WeishiReportUtil.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), WeishiReportUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), WeishiReportUtil.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), WeishiReportUtil.a(this.jdField_b_of_type_Long), this.jdField_b_of_type_Long, "");
      this.jdField_b_of_type_Long = -1L;
      if ((this.app != null) && (this.app.getMessageFacade() != null)) {
        this.app.getMessageFacade().deleteObserver(this);
      }
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController.h();
    ReadInJoyScreenShotReporter.a(this).a();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    a();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController.i();
    ReadInJoyScreenShotReporter.a(this).a(getIntent().getIntExtra("channel_type", 0), getIntent().getIntExtra("channel_id", 0));
    if ((RIJShowKanDianTabSp.c()) && (a())) {
      ReadInJoyLogicEngine.a().a(56);
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    PlayFeedsSPUtils.a(getAppRuntime());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController.f();
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler))) {
      ((FlingGestureHandler)this.mFlingHandler).mTopLayout.setOnFlingGesture(new ReadInJoyChannelActivity.4(this));
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    VideoVolumeControl.getInstance().requestOrAbandonAudioFocus(false, "ReadInJoyChannelActivity doOnStop");
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController.g();
  }
  
  protected boolean onBackEvent()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController.a();
    if ((localObject != null) && (((VideoPlayManager)localObject).a() != null))
    {
      localObject = ((VideoPlayManager)localObject).a();
      if (((VideoUIManager)localObject).a())
      {
        ((VideoUIManager)localObject).j();
        return true;
      }
    }
    a(false);
    finish();
    return true;
  }
  
  protected View onCreateRightView()
  {
    Object localObject = super.onCreateRightView();
    if (b())
    {
      this.rightViewImg.setImageResource(2130842995);
      this.rightViewImg.setVisibility(0);
      localObject = this.rightViewImg;
    }
    return localObject;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((!paramObservable.isSendFromLocal()) && (!RIJWeiShiLegacyUtils.a.a(paramObservable))) {
        b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyChannelActivity
 * JD-Core Version:    0.7.0.1
 */