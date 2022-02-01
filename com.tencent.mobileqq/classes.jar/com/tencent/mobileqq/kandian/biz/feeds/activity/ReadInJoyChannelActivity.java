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
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
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
import mqq.app.Foreground;

public class ReadInJoyChannelActivity
  extends IphoneTitleBarActivity
  implements Observer
{
  String a = "";
  protected long b = 0L;
  protected ReadInJoyBaseViewController c = null;
  private boolean d;
  private boolean e = false;
  private boolean f = false;
  private MessageForStructing g;
  private long h = -1L;
  
  private void a(int paramInt)
  {
    runOnUiThread(new ReadInJoyChannelActivity.8(this, paramInt));
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      if (this.e) {
        return;
      }
      paramViewGroup.setOnClickListener(new ReadInJoyChannelActivity.5(this));
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if ((f()) && (this.b != 0L))
    {
      ReadInJoyBaseViewController localReadInJoyBaseViewController = this.c;
      if ((localReadInJoyBaseViewController != null) && (localReadInJoyBaseViewController.j() != null))
      {
        localReadInJoyBaseViewController = this.c;
        if (((localReadInJoyBaseViewController instanceof ReadInJoyChannelViewController)) && (((ReadInJoyChannelViewController)localReadInJoyBaseViewController).u() != null) && (((ReadInJoyChannelViewController)this.c).u().size() > 0)) {
          RIJStatisticCollectorReport.a(56, (System.currentTimeMillis() - this.b) / 1000L, this.c.j().a(), (AbsBaseArticleInfo)((ReadInJoyChannelViewController)this.c).u().get(0), paramBoolean);
        }
      }
    }
  }
  
  private void b(int paramInt)
  {
    VideoReport.addToDetectionWhitelist(this);
    VideoReport.setPageId(this, "118");
    VideoReport.setPageParams(this, new RIJDtParamBuilder().a(Integer.valueOf(paramInt)).b());
  }
  
  private void b(ViewGroup paramViewGroup)
  {
    if ((g()) && (ReadInJoyHelper.av(ReadInJoyUtils.b()))) {
      c(paramViewGroup);
    }
  }
  
  private void c(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(this).inflate(2131626436, paramViewGroup, false);
      paramViewGroup.addView(localViewGroup);
      d(localViewGroup);
      PublicAccountReportUtils.a(null, "", "0X8009337", "0X8009337", 0, 0, "", "", "", VideoReporter.d(), false);
      localViewGroup.setOnClickListener(new ReadInJoyChannelActivity.9(this));
    }
  }
  
  private void d(ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramViewGroup.findViewById(2131441417);
    if (WeishiGuideUtils.a(this))
    {
      paramViewGroup.setText(HardCodeUtil.a(2131910387));
      return;
    }
    paramViewGroup.setText(HardCodeUtil.a(2131910385));
  }
  
  public static boolean d()
  {
    Object localObject = Foreground.getTopActivity();
    boolean bool;
    if ((localObject instanceof ReadInJoyChannelActivity)) {
      bool = ((ReadInJoyChannelActivity)localObject).c();
    } else {
      bool = false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[isCurrentChannelFromImmersive] res = ");
    ((StringBuilder)localObject).append(bool);
    QLog.i("IphoneTitleBarActivity", 1, ((StringBuilder)localObject).toString());
    return bool;
  }
  
  private void e()
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
          this.a = ((String)localHashMap.get("channelName"));
          this.e = "1".equals(localHashMap.get("canDownRefresh"));
          bool2 = "1".equals(localHashMap.get("canUpRefresh"));
          bool1 = "1".equals(localHashMap.get("isImmersive"));
          ReadInJoyHelper.b(Integer.valueOf((String)localHashMap.get("channelID")).intValue());
          if (this.c != null)
          {
            ((ReadInJoyChannelViewController)this.c).a(this.e, bool2, bool1);
            ((ReadInJoyChannelViewController)this.c).k();
          }
          QLog.d("IphoneTitleBarActivity", 1, new Object[] { "handlerDynamicParams mCanPullDownRefresh=", Boolean.valueOf(this.e), " mCanPullUpRefresh=", Boolean.valueOf(bool2), " mChannelName=", this.a });
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
  
  private boolean f()
  {
    Intent localIntent = getIntent();
    boolean bool = false;
    if (localIntent.getIntExtra("channel_id", 0) == 56) {
      bool = true;
    }
    return bool;
  }
  
  private boolean g()
  {
    Intent localIntent = getIntent();
    boolean bool = false;
    if (localIntent.getIntExtra("channel_id", 0) == 40677) {
      bool = true;
    }
    return bool;
  }
  
  private boolean h()
  {
    Intent localIntent = getIntent();
    boolean bool = false;
    if (localIntent.getIntExtra("channel_id", 0) == 40830) {
      bool = true;
    }
    return bool;
  }
  
  private void i()
  {
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131444326);
    this.c = new ReadInJoyChannelViewController(this);
    ((ReadInJoyChannelViewController)this.c).c(getIntent().getIntExtra("channel_from", -1));
    this.c.a(localViewGroup);
    this.c.cT_();
    if ((g()) && ((this.c instanceof ReadInJoyChannelViewController))) {
      this.rightViewImg.setOnClickListener((View.OnClickListener)this.c);
    }
    if ((ThemeUtil.isInNightMode(ReadInJoyUtils.b())) && (this.titleRoot != null)) {
      View.inflate(this, 2131626298, this.titleRoot);
    }
    j();
    b(localViewGroup);
  }
  
  private void j()
  {
    if (g()) {
      this.g = WeishiReportUtil.f();
    }
  }
  
  private void k()
  {
    this.c.a(true);
    ThreadManager.executeOnSubThread(new ReadInJoyChannelActivity.6(this));
  }
  
  public void a()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      setImmersiveStatus();
      this.titleRoot = ((RelativeLayout)findViewById(2131447595));
      ImmersiveUtils.clearCoverForStatus(getWindow(), this.isClearCoverLayer);
      this.titleRoot.setFitsSystemWindows(false);
      this.titleRoot.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (ThemeUtil.isInNightMode(this.app))
      {
        if ((!SystemUtil.d()) && (!SystemUtil.g()))
        {
          this.mSystemBarComp.setStatusBarColor(-7829368);
        }
        else
        {
          this.mSystemBarComp.setStatusBarColor(-7829368);
          this.mSystemBarComp.setStatusBarDarkMode(true);
        }
      }
      else if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.d()) && (!SystemUtil.g()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.setStatusBarColor(-1);
      }
      else if (!SystemUtil.g())
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
    this.leftView.setBackgroundResource(2130851519);
    if (h()) {
      this.leftView.setText(HardCodeUtil.a(2131901576));
    }
    this.vg.setBackgroundColor(-1);
    a(this.vg);
    if ((getIntent().getBooleanExtra("is_need_show_animation_translate", false)) && (this.d))
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
  
  public boolean c()
  {
    return this.f;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ReadInJoyBaseViewController localReadInJoyBaseViewController = this.c;
    if (localReadInJoyBaseViewController != null) {
      localReadInJoyBaseViewController.a(paramInt1, paramInt2, paramIntent);
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.b = System.currentTimeMillis();
    VideoVolumeControl.getInstance().inKandianModule(this);
    this.d = VideoFeedsHelper.f();
    if (!this.d) {
      setTheme(2131952009);
    }
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().addFlags(-2147483648);
    }
    setContentView(2131626246);
    int i = getIntent().getIntExtra("channel_id", -1);
    ReadInJoyGlobalReporter.c(i);
    paramBundle = (ReadInJoyLogicManager)this.app.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    ReadInJoyWebProcessManager.a(this.app);
    setClickableTitle(getIntent().getStringExtra("channel_name"), new ReadInJoyChannelActivity.1(this));
    i();
    if (g())
    {
      ThreadManager.executeOnSubThread(new ReadInJoyChannelActivity.2(this));
      this.h = System.currentTimeMillis();
      WeishiReportUtil.a(getIntent().getIntExtra("channel_from", 9), WeishiReportUtil.e(this.g), WeishiReportUtil.c(this.g), WeishiReportUtil.d(this.g), WeishiReportUtil.a(this.h));
      if ((this.app != null) && (this.app.getMessageFacade() != null) && (!h())) {
        this.app.getMessageFacade().addObserver(this);
      }
      ViolaSoLoaderManager.a.a().a();
      ReadInJoyWebRenderEngine.e();
    }
    this.f = getIntent().getBooleanExtra("from_immersive", false);
    paramBundle = new StringBuilder();
    paramBundle.append("[doOnCreate] isFromImmersive = ");
    paramBundle.append(this.f);
    QLog.i("IphoneTitleBarActivity", 1, paramBundle.toString());
    e();
    b(i);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    ((ReadInJoyLogicManager)ReadInJoyUtils.b().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().o(getIntent().getIntExtra("channel_id", 0));
    this.b = 0L;
    ReadInJoyBaseViewController localReadInJoyBaseViewController = this.c;
    if (localReadInJoyBaseViewController != null) {
      localReadInJoyBaseViewController.e();
    }
    VideoVolumeControl.getInstance().outKandianModule(this);
    ReadInJoyScreenShotReporter.a(this).b();
    if (g())
    {
      ThreadManager.executeOnSubThread(new ReadInJoyChannelActivity.3(this));
      WeishiReportUtil.a(getIntent().getIntExtra("channel_from", 9), WeishiReportUtil.e(this.g), WeishiReportUtil.c(this.g), WeishiReportUtil.d(this.g), WeishiReportUtil.a(this.h), this.h, "");
      this.h = -1L;
      if ((this.app != null) && (this.app.getMessageFacade() != null)) {
        this.app.getMessageFacade().deleteObserver(this);
      }
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.c.h();
    ReadInJoyScreenShotReporter.a(this).a();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    a();
    this.c.i();
    ReadInJoyScreenShotReporter.a(this).a(getIntent().getIntExtra("channel_type", 0), getIntent().getIntExtra("channel_id", 0));
    if ((RIJShowKanDianTabSp.c()) && (f())) {
      ReadInJoyLogicEngine.a().a(56);
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    PlayFeedsSPUtils.a(getAppRuntime());
    this.c.f();
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler))) {
      ((FlingGestureHandler)this.mFlingHandler).mTopLayout.setOnFlingGesture(new ReadInJoyChannelActivity.4(this));
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    VideoVolumeControl.getInstance().requestOrAbandonAudioFocus(false, "ReadInJoyChannelActivity doOnStop");
    this.c.g();
  }
  
  protected boolean onBackEvent()
  {
    Object localObject = this.c.j();
    if ((localObject != null) && (((VideoPlayManager)localObject).k() != null))
    {
      localObject = ((VideoPlayManager)localObject).k();
      if (((VideoUIManager)localObject).c())
      {
        ((VideoUIManager)localObject).p();
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
    if (g())
    {
      this.rightViewImg.setImageResource(2130843951);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyChannelActivity
 * JD-Core Version:    0.7.0.1
 */