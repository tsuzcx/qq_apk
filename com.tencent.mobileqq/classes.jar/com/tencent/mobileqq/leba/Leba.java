package com.tencent.mobileqq.leba;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.mobileqq.leba.business.ILebaRichApi;
import com.tencent.mobileqq.leba.business.LebaMainBizProxy;
import com.tencent.mobileqq.leba.controller.LebaController;
import com.tencent.mobileqq.leba.core.LebaHelper;
import com.tencent.mobileqq.leba.core.LebaShowListManager;
import com.tencent.mobileqq.leba.core.LebaUtil;
import com.tencent.mobileqq.leba.core.LebaWebPreloadHelper;
import com.tencent.mobileqq.leba.entity.InitViewParam;
import com.tencent.mobileqq.leba.entity.LeabOnPauseInfo;
import com.tencent.mobileqq.leba.entity.LebaClickReportInfo;
import com.tencent.mobileqq.leba.entity.LebaItemListener;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.feed.LebaFeedUtil;
import com.tencent.mobileqq.leba.logic.LebaPluginLogic;
import com.tencent.mobileqq.leba.observer.ResourcePluginListener;
import com.tencent.mobileqq.leba.report.DC03309ReportItem;
import com.tencent.mobileqq.leba.report.EXReportController;
import com.tencent.mobileqq.leba.report.LebaDaTong;
import com.tencent.mobileqq.leba.report.LebaReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.BlurUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.tianshu.ITianshuWebManager;
import com.tencent.mobileqq.widget.CommonLoadingView;
import com.tencent.mobileqq.widget.CommonLoadingView.OnFirstDrawListener;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.TextHook;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;
import mqq.app.MobileQQ;

public class Leba
  extends Frame
  implements ViewStub.OnInflateListener, LebaItemListener, CommonLoadingView.OnFirstDrawListener, AbsListView.OnScrollListener
{
  public FPSXListView a;
  public ImageView b;
  public List<LebaViewItem> c = new ArrayList();
  public View d;
  public LebaController e;
  public ILebaRichApi f;
  public LebaMainBizProxy g = new LebaMainBizProxy();
  public IStudyModeManager h;
  public StudyModeChangeListener i;
  Handler.Callback j = new Leba.7(this);
  public MqqWeakReferenceHandler k = new MqqWeakReferenceHandler(this.j);
  private View l;
  private ImmersiveTitleBar2 m;
  private RelativeLayout n;
  private RelativeLayout o;
  private TextView p;
  private ImageView q;
  private boolean r = false;
  private boolean s = true;
  private long t = 0L;
  private boolean u = false;
  private ResourcePluginListener v = new Leba.6(this);
  private boolean w = true;
  
  private void b(boolean paramBoolean, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (this.aF == null) {
      return;
    }
    int i1 = LebaReportUtils.a(paramBoolean, paramRedTypeInfo);
    ReportController.b(this.aF, "CliOper", "", "", "trends_tab", "click_trends_tab", 0, 0, "", "", String.valueOf(i1), "");
    r();
    if (paramBoolean) {
      ((IRedTouchManager)this.aF.getRuntimeService(IRedTouchManager.class, "")).reportLevelZeroRedInfo(0, 31);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (!n()) {
      return;
    }
    d(paramBoolean);
  }
  
  private void d(boolean paramBoolean)
  {
    ReportController.b(this.aF, "CliOper", "", "", "trends_tab", "click_tt_right", 0, 0, "", "", "", "");
    ((IRedTouchManager)this.aF.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("150000");
    LebaShowListManager.a().e = true;
    LebaUtil.a(P(), this.aF, paramBoolean);
  }
  
  private void u()
  {
    this.m = ((ImmersiveTitleBar2)d(2131447582));
    QIphoneTitleBarActivity.setLayerType(this.m);
    this.n = ((RelativeLayout)this.l.findViewById(2131447484));
    QIphoneTitleBarActivity.setLayerType((ViewGroup)d(2131444897));
    this.o = ((RelativeLayout)d(2131437063));
    this.aH = ((QQBlurView)d(2131429596));
    this.p = ((TextView)d(2131436227));
    this.p.setText(2131917005);
    a(this.p);
    this.q = ((ImageView)d(2131436194));
    this.q.setOnClickListener(new Leba.4(this));
    LebaDaTong.d(this.q);
    w();
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.n, true);
      a(this.m, true);
      a(this.o, true);
      this.p.setTextColor(-1);
    }
    else
    {
      if ((QQTheme.isSimpleWhite()) && (BlurUtil.a()))
      {
        this.m.setBackgroundColor(0);
        this.n.setBackgroundColor(0);
        this.o.setBackgroundColor(0);
        a(this.aH, d(2131445137));
      }
      else
      {
        a(this.m, false);
        a(this.n, false);
        this.o.setBackgroundResource(2130852228);
      }
      this.p.setTextColor(Q().getColorStateList(2131167990));
    }
    SimpleUIUtil.a(this.m, P().getWindow());
  }
  
  private void w()
  {
    if (this.q == null) {
      return;
    }
    int i1 = LebaPluginLogic.a();
    if ((i1 != 2) && (i1 != 1))
    {
      this.q.setVisibility(0);
      return;
    }
    this.q.setVisibility(8);
  }
  
  private void x()
  {
    if (this.aF != null)
    {
      ((ILebaHelperService)this.aF.getRuntimeService(ILebaHelperService.class, "multi")).removeLebaListener(this.v);
      Object localObject = this.g;
      if (localObject != null) {
        ((LebaMainBizProxy)localObject).h();
      } else {
        LebaUtil.a("LebaFrame", "removeObservers", "ThirdParts");
      }
      localObject = this.h;
      if (localObject != null)
      {
        StudyModeChangeListener localStudyModeChangeListener = this.i;
        if (localStudyModeChangeListener != null)
        {
          ((IStudyModeManager)localObject).unregisterStudyModeChangeListener(localStudyModeChangeListener);
          return;
        }
      }
      LebaUtil.a("LebaFrame", "removeObservers", "StudyModeManager");
    }
  }
  
  private void y()
  {
    Object localObject;
    if (this.a == null)
    {
      this.a = ((FPSXListView)d(2131437065));
      this.b = ((ImageView)d(2131437054));
      localObject = this.a;
      if (localObject != null)
      {
        ((FPSXListView)localObject).setActTAG("actFPSLeba");
        this.a.setReportType(2);
        this.a.setNeedCheckSpringback(true);
        this.a.setOverscrollHeader(Q().getDrawable(2130852377));
        this.a.setOnScrollListener(this);
        if (P() == null) {
          localObject = null;
        } else {
          localObject = P().findViewById(16908307);
        }
        if (localObject != null) {
          this.a.setPadding(0, 0, 0, ((View)localObject).getHeight());
        }
      }
      else
      {
        return;
      }
    }
    if (this.c == null) {
      this.c = new ArrayList();
    }
    if (this.d == null)
    {
      this.d = LayoutInflater.from(P()).inflate(2131627493, this.a, false);
      b((TextView)this.d.findViewById(2131448724));
      localObject = this.g;
      if (localObject != null) {
        ((LebaMainBizProxy)localObject).a(this.d);
      } else {
        LebaUtil.a("LebaFrame", "initView", "ThirdParts");
      }
    }
    if (this.e != null)
    {
      localObject = new InitViewParam();
      ((InitViewParam)localObject).a = this.aF;
      ((InitViewParam)localObject).b = this.c;
      ((InitViewParam)localObject).c = P();
      ((InitViewParam)localObject).d = this.a;
      ((InitViewParam)localObject).e = this.d;
      ((InitViewParam)localObject).f = this;
      this.e.a((InitViewParam)localObject);
    }
    o();
  }
  
  private void z()
  {
    LebaMainBizProxy localLebaMainBizProxy = this.g;
    if (localLebaMainBizProxy != null)
    {
      localLebaMainBizProxy.b();
      return;
    }
    LebaUtil.a("LebaFrame", "updateRedFlag", "ThirdParts");
  }
  
  protected void T()
  {
    super.T();
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    this.l = paramLayoutInflater.inflate(2131625255, null);
    this.e = new LebaController();
    return this.l;
  }
  
  protected void a()
  {
    super.a();
    l();
    Leba.RealLebaProxy localRealLebaProxy = new Leba.RealLebaProxy();
    localRealLebaProxy.a = this;
    LebaMainBizProxy localLebaMainBizProxy = this.g;
    if (localLebaMainBizProxy != null) {
      localLebaMainBizProxy.a(localRealLebaProxy);
    } else {
      LebaUtil.a("LebaFrame", "onCreate", "ThirdParts");
    }
    u();
    ((ViewStub)d(2131446488)).setOnInflateListener(this);
    ((CommonLoadingView)d(2131431148)).setOnFirstDrawListener(this);
    this.t = SystemClock.uptimeMillis();
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(View paramView, LebaViewItem paramLebaViewItem)
  {
    c(false);
  }
  
  public void a(View paramView, LebaViewItem paramLebaViewItem, int paramInt)
  {
    if (!n()) {
      return;
    }
    if (this.g != null)
    {
      LebaClickReportInfo localLebaClickReportInfo = new LebaClickReportInfo();
      localLebaClickReportInfo.d = false;
      localLebaClickReportInfo.a = paramLebaViewItem.a;
      localLebaClickReportInfo.b = (paramInt + 1);
      if ((paramView instanceof RedTouch)) {
        localLebaClickReportInfo.c = LebaConstant.a((RedTouch)paramView);
      }
      this.g.a(paramView, paramLebaViewItem, localLebaClickReportInfo);
      return;
    }
    LebaUtil.a("LebaFrame", "onPluginClick", "ThirdParts");
  }
  
  public void a(LebaClickReportInfo paramLebaClickReportInfo)
  {
    if (paramLebaClickReportInfo == null)
    {
      QLog.i("LebaFrame", 1, "reportPluginClick  reportInfo == null ");
      return;
    }
    QLog.i("LebaFrame", 1, String.format("reportPluginClick id = %d pos = %d type = %d mode = %b hasAssistsText = %d", new Object[] { Long.valueOf(paramLebaClickReportInfo.a), Integer.valueOf(paramLebaClickReportInfo.b), Integer.valueOf(paramLebaClickReportInfo.c), Boolean.valueOf(paramLebaClickReportInfo.d), Integer.valueOf(paramLebaClickReportInfo.e) }));
    if (paramLebaClickReportInfo.d)
    {
      DC03309ReportItem localDC03309ReportItem = LebaReportUtils.a("plugin_clk");
      localDC03309ReportItem.b = String.valueOf(paramLebaClickReportInfo.a);
      localDC03309ReportItem.d = String.valueOf(paramLebaClickReportInfo.b);
      localDC03309ReportItem.e = String.valueOf(paramLebaClickReportInfo.c);
      localDC03309ReportItem.f = String.valueOf(paramLebaClickReportInfo.e);
      localDC03309ReportItem.g = String.valueOf(paramLebaClickReportInfo.f);
      localDC03309ReportItem.h = ThemeUtil.getCurrentThemeId();
      if (t()) {
        paramLebaClickReportInfo = "1";
      } else {
        paramLebaClickReportInfo = "2";
      }
      localDC03309ReportItem.i = paramLebaClickReportInfo;
      EXReportController.a(this.aF, localDC03309ReportItem);
      return;
    }
    ReportController.a(this.aF, "CliOper", "", "", "trends_tab", "Clk_plug_in", 0, 0, String.valueOf(paramLebaClickReportInfo.a), String.valueOf(paramLebaClickReportInfo.b), String.valueOf(paramLebaClickReportInfo.c), "");
  }
  
  protected void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    if (QLog.isColorLevel()) {
      QLog.i("LebaFrame", 2, "onLogout");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    LebaFeedUtil.a(false);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("leba.java onResume");
      ((StringBuilder)localObject).append(LebaShowListManager.a);
      QLog.i("LebaFrame", 2, ((StringBuilder)localObject).toString());
    }
    LebaWebPreloadHelper.a(true);
    AbstractGifImage.resumeAll();
    Object localObject = this.g;
    if (localObject != null) {
      ((LebaMainBizProxy)localObject).a(paramBoolean);
    } else {
      LebaUtil.a("LebaFrame", "onResume", "ThirdParts");
    }
    w();
    ((IRedTouchManager)this.aF.getRuntimeService(IRedTouchManager.class, "")).residenceReport(System.currentTimeMillis());
    if ((this.r) && ((LebaShowListManager.a & 0x4) == 0))
    {
      if (LebaShowListManager.a > 0)
      {
        localObject = new ArrayList();
        LebaUtil.a((List)localObject, LebaShowListManager.a().a(this.aF));
        List localList = this.c;
        if (localList != null)
        {
          localList.clear();
          this.c.addAll((Collection)localObject);
          localObject = this.e;
          if (localObject != null)
          {
            ((LebaController)localObject).c();
            z();
          }
        }
        LebaShowListManager.a = 0;
      }
    }
    else {
      this.k.sendEmptyMessageDelayed(11340002, 200L);
    }
    if (AppSetting.e)
    {
      this.p.setFocusable(true);
      localObject = e(2131891481);
      this.p.setContentDescription((CharSequence)localObject);
      P().setTitle(e(2131891481));
    }
    localObject = this.e;
    if (localObject != null) {
      ((LebaController)localObject).b();
    }
    ((IVasService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IVasService.class, "")).getTianshuWebManager().setTraceInfoOfLastClick("{}");
    ApngImage.playByTag(4);
    ((ILebaHelperService)this.aF.getRuntimeService(ILebaHelperService.class, "multi")).checkModleAndRefesh();
  }
  
  public void a(boolean paramBoolean, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    LebaMainBizProxy localLebaMainBizProxy = this.g;
    if (localLebaMainBizProxy != null) {
      localLebaMainBizProxy.b(paramBoolean);
    } else {
      LebaUtil.a("LebaFrame", "onSwitchToLeba", "ThirdParts");
    }
    this.k.postDelayed(new Leba.3(this, paramBoolean, paramRedTypeInfo), 150L);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    Object localObject;
    if (this.aG)
    {
      localObject = new ArrayList();
      LebaUtil.a((List)localObject, LebaShowListManager.a().a(this.aF));
      b(new Leba.9(this, (List)localObject));
    }
    else
    {
      LebaShowListManager.a |= 0x2;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGameCenterMsgReceive, ");
      ((StringBuilder)localObject).append(this.aG);
      QLog.i("LebaFrame", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void b(TextView paramTextView)
  {
    if (paramTextView == null) {
      return;
    }
    if (QQTheme.isNowSimpleUI())
    {
      paramTextView.setTextSize(0, ViewUtils.dpToPx(14.0F));
      return;
    }
    paramTextView.setTextSize(0, ViewUtils.dpToPx(16.0F));
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      y();
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("leba fillData->initLebaView exception:");
      localStringBuilder.append(localException);
      QLog.e("LebaFrame", 1, localStringBuilder.toString(), localException);
    }
    Object localObject = (ILebaHelperService)this.aF.getRuntimeService(ILebaHelperService.class, "multi");
    ((ILebaHelperService)localObject).initLebaHelper();
    ((ILebaHelperService)localObject).addLebaListener(this.v);
    localObject = this.g;
    if (localObject != null)
    {
      ((LebaMainBizProxy)localObject).i();
      this.g.c(paramBoolean);
    }
    else
    {
      LebaUtil.a("LebaFrame", "fillData", "ThirdParts");
    }
    if (this.h != null)
    {
      if (this.i == null) {
        this.i = new Leba.MyStudyModeChangeListener(this);
      }
      this.h.registerStudyModeChangeListener(this.i);
      return;
    }
    LebaUtil.a("LebaFrame", "fillData", "StudyModeManager");
  }
  
  public void bQ_()
  {
    ApngImage.pauseByTag(4);
    super.bQ_();
    LebaWebPreloadHelper.a(false);
    Object localObject1 = this.a;
    if (localObject1 != null) {
      ((FPSXListView)localObject1).e();
    }
    localObject1 = new LeabOnPauseInfo();
    Object localObject2 = this.g;
    if (localObject2 != null)
    {
      ((LebaMainBizProxy)localObject2).d();
      this.g.a((LeabOnPauseInfo)localObject1);
    }
    else
    {
      LebaUtil.a("LebaFrame", "onPause", "ThirdParts");
    }
    localObject2 = this.e;
    if (localObject2 != null) {
      ((LebaController)localObject2).a(this.aF, ((LeabOnPauseInfo)localObject1).a, ((LeabOnPauseInfo)localObject1).b, ((LeabOnPauseInfo)localObject1).c);
    }
    this.k.postDelayed(new Leba.2(this), 500L);
    if (QLog.isColorLevel()) {
      QLog.i("LebaFrame", 2, "leba.java onPause");
    }
  }
  
  public void c()
  {
    super.c();
    if (QLog.isColorLevel()) {
      QLog.i("LebaFrame", 2, "onStop");
    }
  }
  
  protected String cy_()
  {
    return HardCodeUtil.a(2131917005);
  }
  
  public boolean cz_()
  {
    return this.r;
  }
  
  protected void d()
  {
    x();
    LebaMainBizProxy localLebaMainBizProxy = this.g;
    if (localLebaMainBizProxy != null) {
      localLebaMainBizProxy.j();
    } else {
      LebaUtil.a("LebaFrame", "onDestroy", "ThirdParts");
    }
    super.d();
  }
  
  protected void f()
  {
    super.f();
    if (QLog.isColorLevel()) {
      QLog.i("LebaFrame", 2, "onAccountChanged");
    }
    LebaMainBizProxy localLebaMainBizProxy = this.g;
    if (localLebaMainBizProxy != null) {
      localLebaMainBizProxy.k();
    } else {
      LebaUtil.a("LebaFrame", "onAccountChanged", "ThirdParts");
    }
    LebaShowListManager.a().b();
    z();
  }
  
  public void i()
  {
    this.k.post(new Leba.1(this));
  }
  
  protected void k()
  {
    super.k();
    x();
    LebaMainBizProxy localLebaMainBizProxy = this.g;
    if (localLebaMainBizProxy != null)
    {
      localLebaMainBizProxy.c();
      return;
    }
    LebaUtil.a("LebaFrame", "onBeforeAccountChanged", "ThirdParts");
  }
  
  public void l()
  {
    if (this.f == null) {
      this.f = ((ILebaRichApi)QRoute.api(ILebaRichApi.class));
    }
    if (this.h == null) {
      this.h = ((IStudyModeManager)QRoute.api(IStudyModeManager.class));
    }
  }
  
  void m()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaFrame", 2, "refreshLebaConfig. begin.");
    }
    ThreadManager.post(new Leba.5(this), 10, null, false);
    LebaMainBizProxy localLebaMainBizProxy = this.g;
    if (localLebaMainBizProxy != null)
    {
      localLebaMainBizProxy.g();
      return;
    }
    LebaUtil.a("LebaFrame", "refreshLebaConfig", "ThirdParts");
  }
  
  public boolean n()
  {
    FPSXListView localFPSXListView = this.a;
    if (localFPSXListView == null) {
      return true;
    }
    boolean bool = this.w;
    if (bool)
    {
      this.w = false;
      localFPSXListView.postDelayed(new Leba.8(this), 1000L);
      return bool;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LebaFrame", 2, "clickAction is dismiss,click too frequently.");
    }
    return bool;
  }
  
  protected void o()
  {
    if (this.b == null) {
      return;
    }
    if (QQTheme.isNowSimpleUI())
    {
      ImageView localImageView = this.b;
      int i1;
      if (QQTheme.isNowThemeIsNight()) {
        i1 = -16777216;
      } else {
        i1 = -1;
      }
      localImageView.setBackgroundColor(i1);
      this.b.setImageDrawable(null);
      return;
    }
    this.b.setBackgroundColor(0);
    p();
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    b(false);
    if (!this.r) {
      a(true);
    }
    this.r = true;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {
      return;
    }
    if (this.u)
    {
      if (paramInt != 0)
      {
        ApngImage.pauseByTag(4);
        if (QLog.isColorLevel()) {
          QLog.e("LebaFrame", 2, "onScrollStateChanged not SCROLL_STATE_IDLE");
        }
      }
      if (paramInt == 0)
      {
        ApngImage.playByTag(4);
        if (QLog.isColorLevel()) {
          QLog.e("LebaFrame", 2, "onScrollStateChanged SCROLL_STATE_IDLE");
        }
      }
    }
    LebaController localLebaController = this.e;
    if (localLebaController != null) {
      localLebaController.a(paramAbsListView, paramInt);
    }
  }
  
  void p()
  {
    ILebaRichApi localILebaRichApi = this.f;
    if (localILebaRichApi == null)
    {
      LebaUtil.a("LebaFrame", "setThemeDiyBgLeba", "RichApi");
      return;
    }
    localILebaRichApi.applyThemeBg(this.aF, this.b, 2130838959, "-leba-");
    if (ThemeUtil.isNowThemeIsAnimate()) {
      this.u = true;
    }
  }
  
  public void q()
  {
    QLog.i("LebaFrame", 1, "onPostThemeChanged");
    Object localObject = this.b;
    if (localObject != null) {
      ((ImageView)localObject).setTag(null);
    }
    o();
    a(this.aH, d(2131445137));
    a(this.p);
    w();
    localObject = this.d;
    if (localObject != null) {
      b((TextView)((View)localObject).findViewById(2131448724));
    }
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.n, true);
      a(this.m, true);
      a(this.o, true);
      this.p.setTextColor(-1);
    }
    else
    {
      if ((QQTheme.isSimpleWhite()) && (BlurUtil.a()))
      {
        this.m.setBackgroundColor(0);
        this.n.setBackgroundColor(0);
        this.o.setBackgroundColor(0);
      }
      else
      {
        a(this.m, false);
        a(this.n, false);
        this.o.setBackgroundResource(2130852228);
      }
      this.p.setTextColor(Q().getColorStateList(2131167990));
    }
    SimpleUIUtil.a(this.m, P().getWindow());
    this.k.sendEmptyMessageDelayed(11340002, 0L);
    localObject = this.e;
    if (localObject != null) {
      ((LebaController)localObject).d();
    }
    localObject = this.g;
    if (localObject != null) {
      ((LebaMainBizProxy)localObject).e();
    } else {
      LebaUtil.a("LebaFrame", "onPostThemeChanged", "ThirdParts");
    }
    localObject = this.d;
    if (localObject != null) {
      TextHook.updateFont((View)localObject);
    }
    ((ILebaHelperService)this.aF.getRuntimeService(ILebaHelperService.class, "multi")).checkModleAndRefesh();
  }
  
  public void r()
  {
    QLog.d("Leba", 1, "onLebaTabChange");
    LebaWebPreloadHelper.a(true);
    if (this.aF != null)
    {
      localObject = (LebaHelper)((ILebaHelperService)this.aF.getRuntimeService(ILebaHelperService.class, "multi")).getLebaHelper();
      if (localObject != null) {
        ((LebaHelper)localObject).d();
      } else {
        QLog.i("LebaFrame", 1, "onLebaTabChange lebaHelper == null");
      }
    }
    Object localObject = this.g;
    if (localObject != null) {
      ((LebaMainBizProxy)localObject).f();
    } else {
      LebaUtil.a("LebaFrame", "onLebaTabChange", "ThirdParts");
    }
    s();
    LebaDaTong.a(P(), this.l, "pg_discover_list_primary_page");
  }
  
  void s()
  {
    ABTestController.a().a("exp_shouq_dongtai_jianjie_copy_copy").h();
  }
  
  public boolean t()
  {
    LebaController localLebaController = this.e;
    return (localLebaController != null) && (localLebaController.a() == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.Leba
 * JD-Core Version:    0.7.0.1
 */