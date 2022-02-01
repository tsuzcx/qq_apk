package com.tencent.mobileqq.leba;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mobileqq.leba.observer.ResourcePluginListener;
import com.tencent.mobileqq.leba.report.DC03309ReportItem;
import com.tencent.mobileqq.leba.report.EXReportController;
import com.tencent.mobileqq.leba.report.LebaReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.tianshu.ITianshuWebManager;
import com.tencent.mobileqq.widget.CommonLoadingView;
import com.tencent.mobileqq.widget.CommonLoadingView.OnFirstDrawListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
  implements View.OnClickListener, ViewStub.OnInflateListener, LebaItemListener, CommonLoadingView.OnFirstDrawListener, AbsListView.OnScrollListener
{
  private long jdField_a_of_type_Long = 0L;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new Leba.6(this);
  public View a;
  public ImageView a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public FPSXListView a;
  public ILebaRichApi a;
  public LebaMainBizProxy a;
  public LebaController a;
  private ResourcePluginListener jdField_a_of_type_ComTencentMobileqqLebaObserverResourcePluginListener = new Leba.5(this);
  public StudyModeChangeListener a;
  public IStudyModeManager a;
  private RedTouch jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
  public MqqWeakReferenceHandler a;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  public List<LebaViewItem> a;
  private boolean jdField_a_of_type_Boolean = false;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c = false;
  private boolean d = true;
  
  public Leba()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy = new LebaMainBizProxy();
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this.jdField_a_of_type_AndroidOsHandler$Callback);
  }
  
  private void b(boolean paramBoolean, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime == null) {
      return;
    }
    int i = LebaReportUtils.a(paramBoolean, paramRedTypeInfo);
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "trends_tab", "click_trends_tab", 0, 0, "", "", String.valueOf(i), "");
    n();
    if (paramBoolean) {
      ((IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "")).reportLevelZeroRedInfo(0, 31);
    }
  }
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)a(2131378881));
    QIphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131378803));
    QIphoneTitleBarActivity.setLayerType((ViewGroup)a(2131376636));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131369922));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131369249));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719445);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131369216));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    m();
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(a(), this.jdField_b_of_type_AndroidWidgetImageView).b(53).a();
    u();
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    else
    {
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850433);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167053));
    }
    SimpleUIUtil.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime != null)
    {
      ((ILebaHelperService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ILebaHelperService.class, "multi")).removeLebaListener(this.jdField_a_of_type_ComTencentMobileqqLebaObserverResourcePluginListener);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy;
      if (localObject != null) {
        ((LebaMainBizProxy)localObject).h();
      } else {
        LebaUtil.a("LebaFrame", "removeObservers", "ThirdParts");
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqStudymodeApiIStudyModeManager;
      if (localObject != null)
      {
        StudyModeChangeListener localStudyModeChangeListener = this.jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener;
        if (localStudyModeChangeListener != null)
        {
          ((IStudyModeManager)localObject).unregisterStudyModeChangeListener(localStudyModeChangeListener);
          return;
        }
      }
      LebaUtil.a("LebaFrame", "removeObservers", "StudyModeManager");
    }
  }
  
  private void r()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView = ((FPSXListView)a(2131369924));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131369914));
      localObject = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
      if (localObject != null)
      {
        ((FPSXListView)localObject).setActTAG("actFPSLeba");
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setReportType(2);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setNeedCheckSpringback(true);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOverscrollHeader(a().getDrawable(2130850581));
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOnScrollListener(this);
        if (a() == null) {
          localObject = null;
        } else {
          localObject = a().findViewById(16908307);
        }
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setPadding(0, 0, 0, ((View)localObject).getHeight());
        }
      }
      else
      {
        return;
      }
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(a()).inflate(2131561141, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView, false);
      localObject = this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy;
      if (localObject != null) {
        ((LebaMainBizProxy)localObject).a(this.jdField_a_of_type_AndroidViewView);
      } else {
        LebaUtil.a("LebaFrame", "initView", "ThirdParts");
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLebaControllerLebaController != null)
    {
      localObject = new InitViewParam();
      ((InitViewParam)localObject).jdField_a_of_type_MqqAppAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
      ((InitViewParam)localObject).jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
      ((InitViewParam)localObject).jdField_a_of_type_AndroidContentContext = a();
      ((InitViewParam)localObject).jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
      ((InitViewParam)localObject).jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView;
      ((InitViewParam)localObject).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaItemListener = this;
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerLebaController.a((InitViewParam)localObject);
    }
    k();
  }
  
  private void s()
  {
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "trends_tab", "click_tt_right", 0, 0, "", "", "", "");
    ((IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("150000");
    LebaShowListManager.a().jdField_a_of_type_Boolean = true;
    LebaUtil.a(a(), this.jdField_a_of_type_MqqAppAppRuntime);
  }
  
  private void t()
  {
    LebaMainBizProxy localLebaMainBizProxy = this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy;
    if (localLebaMainBizProxy != null) {
      localLebaMainBizProxy.b();
    } else {
      LebaUtil.a("LebaFrame", "updateRedFlag", "ThirdParts");
    }
    u();
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime == null)
    {
      QLog.i("LebaFrame", 1, "updateIconEntryRedTouch app == null");
      return;
    }
    if (QQTheme.f()) {
      return;
    }
    IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "");
    BusinessInfoCheckUpdate.AppInfo localAppInfo = localIRedTouchManager.getAppInfoByPath("150000");
    RedTouch localRedTouch = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
    if (localRedTouch == null) {
      return;
    }
    localRedTouch.b(53).a().a(localAppInfo);
    localIRedTouchManager.onReportRedPointExposure(localAppInfo);
  }
  
  protected void D()
  {
    super.D();
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559306, null);
    this.jdField_a_of_type_ComTencentMobileqqLebaControllerLebaController = new LebaController();
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  protected String a()
  {
    return HardCodeUtil.a(2131719445);
  }
  
  protected void a()
  {
    super.a();
    i();
    Leba.RealLebaProxy localRealLebaProxy = new Leba.RealLebaProxy();
    localRealLebaProxy.a = this;
    LebaMainBizProxy localLebaMainBizProxy = this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy;
    if (localLebaMainBizProxy != null) {
      localLebaMainBizProxy.a(localRealLebaProxy);
    } else {
      LebaUtil.a("LebaFrame", "onCreate", "ThirdParts");
    }
    o();
    ((ViewStub)a(2131378001)).setOnInflateListener(this);
    ((CommonLoadingView)a(2131365016)).setOnFirstDrawListener(this);
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(View paramView, LebaViewItem paramLebaViewItem, LebaClickReportInfo paramLebaClickReportInfo)
  {
    if (!c()) {
      return;
    }
    LebaMainBizProxy localLebaMainBizProxy = this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy;
    if (localLebaMainBizProxy != null)
    {
      localLebaMainBizProxy.a(paramView, paramLebaViewItem, paramLebaClickReportInfo);
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
    QLog.i("LebaFrame", 1, String.format("reportPluginClick id = %d pos = %d type = %d mode = %b hasAssistsText = %d", new Object[] { Long.valueOf(paramLebaClickReportInfo.jdField_a_of_type_Long), Integer.valueOf(paramLebaClickReportInfo.jdField_a_of_type_Int), Integer.valueOf(paramLebaClickReportInfo.b), Boolean.valueOf(paramLebaClickReportInfo.jdField_a_of_type_Boolean), Integer.valueOf(paramLebaClickReportInfo.c) }));
    if (paramLebaClickReportInfo.jdField_a_of_type_Boolean)
    {
      DC03309ReportItem localDC03309ReportItem = LebaReportUtils.a("plugin_clk");
      localDC03309ReportItem.a = String.valueOf(paramLebaClickReportInfo.jdField_a_of_type_Long);
      localDC03309ReportItem.c = String.valueOf(paramLebaClickReportInfo.jdField_a_of_type_Int);
      localDC03309ReportItem.d = String.valueOf(paramLebaClickReportInfo.b);
      localDC03309ReportItem.e = String.valueOf(paramLebaClickReportInfo.c);
      localDC03309ReportItem.f = String.valueOf(paramLebaClickReportInfo.d);
      localDC03309ReportItem.g = ThemeUtil.getCurrentThemeId();
      if (d()) {
        paramLebaClickReportInfo = "1";
      } else {
        paramLebaClickReportInfo = "2";
      }
      localDC03309ReportItem.h = paramLebaClickReportInfo;
      EXReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, localDC03309ReportItem);
      return;
    }
    ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "trends_tab", "Clk_plug_in", 0, 0, String.valueOf(paramLebaClickReportInfo.jdField_a_of_type_Long), String.valueOf(paramLebaClickReportInfo.jdField_a_of_type_Int), String.valueOf(paramLebaClickReportInfo.b), "");
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("leba.java onResume");
      ((StringBuilder)localObject).append(LebaShowListManager.jdField_a_of_type_Int);
      QLog.i("LebaFrame", 2, ((StringBuilder)localObject).toString());
    }
    LebaWebPreloadHelper.a(true);
    AbstractGifImage.resumeAll();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy;
    if (localObject != null) {
      ((LebaMainBizProxy)localObject).a(paramBoolean);
    } else {
      LebaUtil.a("LebaFrame", "onResume", "ThirdParts");
    }
    ((IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "")).residenceReport(System.currentTimeMillis());
    if ((this.jdField_a_of_type_Boolean) && ((LebaShowListManager.jdField_a_of_type_Int & 0x4) == 0))
    {
      if (LebaShowListManager.jdField_a_of_type_Int > 0)
      {
        localObject = new ArrayList();
        LebaUtil.a((List)localObject, LebaShowListManager.a().a(this.jdField_a_of_type_MqqAppAppRuntime));
        List localList = this.jdField_a_of_type_JavaUtilList;
        if (localList != null)
        {
          localList.clear();
          this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
          localObject = this.jdField_a_of_type_ComTencentMobileqqLebaControllerLebaController;
          if (localObject != null)
          {
            ((LebaController)localObject).b();
            t();
          }
        }
        LebaShowListManager.jdField_a_of_type_Int = 0;
      }
    }
    else {
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(11340002, 200L);
    }
    u();
    m();
    if (AppSetting.d)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(true);
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(a(2131691126));
      localObject = a(2131693876);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject);
      a().setTitle(a(2131693876));
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqLebaControllerLebaController;
    if (localObject != null) {
      ((LebaController)localObject).a();
    }
    ((IVasService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IVasService.class, "")).getTianshuWebManager().setTraceInfoOfLastClick("{}");
    ApngImage.playByTag(4);
    ((ILebaHelperService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ILebaHelperService.class, "multi")).checkModleAndRefesh();
  }
  
  public void a(boolean paramBoolean, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    LebaMainBizProxy localLebaMainBizProxy = this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy;
    if (localLebaMainBizProxy != null) {
      localLebaMainBizProxy.b(paramBoolean);
    } else {
      LebaUtil.a("LebaFrame", "onSwitchToLeba", "ThirdParts");
    }
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.postDelayed(new Leba.3(this, paramBoolean, paramRedTypeInfo), 150L);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    Object localObject;
    if (this.u)
    {
      localObject = new ArrayList();
      LebaUtil.a((List)localObject, LebaShowListManager.a().a(this.jdField_a_of_type_MqqAppAppRuntime));
      b(new Leba.8(this, (List)localObject));
    }
    else
    {
      LebaShowListManager.jdField_a_of_type_Int |= 0x2;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGameCenterMsgReceive, ");
      ((StringBuilder)localObject).append(this.u);
      QLog.i("LebaFrame", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void ab_()
  {
    ApngImage.pauseByTag(4);
    super.ab_();
    LebaWebPreloadHelper.a(false);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
    if (localObject1 != null) {
      ((FPSXListView)localObject1).b();
    }
    localObject1 = new LeabOnPauseInfo();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy;
    if (localObject2 != null)
    {
      ((LebaMainBizProxy)localObject2).d();
      this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy.a((LeabOnPauseInfo)localObject1);
    }
    else
    {
      LebaUtil.a("LebaFrame", "onPause", "ThirdParts");
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqLebaControllerLebaController;
    if (localObject2 != null) {
      ((LebaController)localObject2).a(this.jdField_a_of_type_MqqAppAppRuntime, ((LeabOnPauseInfo)localObject1).jdField_a_of_type_Int, ((LeabOnPauseInfo)localObject1).jdField_a_of_type_Boolean, ((LeabOnPauseInfo)localObject1).b);
    }
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.postDelayed(new Leba.2(this), 500L);
    if (QLog.isColorLevel()) {
      QLog.i("LebaFrame", 2, "leba.java onPause");
    }
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      r();
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("leba fillData->initLebaView exception:");
      localStringBuilder.append(localException);
      QLog.e("LebaFrame", 1, localStringBuilder.toString(), localException);
    }
    Object localObject = (ILebaHelperService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ILebaHelperService.class, "multi");
    ((ILebaHelperService)localObject).initLebaHelper();
    ((ILebaHelperService)localObject).addLebaListener(this.jdField_a_of_type_ComTencentMobileqqLebaObserverResourcePluginListener);
    localObject = this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy;
    if (localObject != null)
    {
      ((LebaMainBizProxy)localObject).i();
      this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy.c(paramBoolean);
    }
    else
    {
      LebaUtil.a("LebaFrame", "fillData", "ThirdParts");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqStudymodeApiIStudyModeManager != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener == null) {
        this.jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener = new Leba.MyStudyModeChangeListener(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqStudymodeApiIStudyModeManager.registerStudyModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener);
      return;
    }
    LebaUtil.a("LebaFrame", "fillData", "StudyModeManager");
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    super.c();
    if (QLog.isColorLevel()) {
      QLog.i("LebaFrame", 2, "onStop");
    }
  }
  
  public boolean c()
  {
    FPSXListView localFPSXListView = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
    if (localFPSXListView == null) {
      return true;
    }
    boolean bool = this.d;
    if (bool)
    {
      this.d = false;
      localFPSXListView.postDelayed(new Leba.7(this), 1000L);
      return bool;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LebaFrame", 2, "clickAction is dismiss,click too frequently.");
    }
    return bool;
  }
  
  protected void d()
  {
    p();
    LebaMainBizProxy localLebaMainBizProxy = this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy;
    if (localLebaMainBizProxy != null) {
      localLebaMainBizProxy.j();
    } else {
      LebaUtil.a("LebaFrame", "onDestroy", "ThirdParts");
    }
    super.d();
  }
  
  public boolean d()
  {
    LebaController localLebaController = this.jdField_a_of_type_ComTencentMobileqqLebaControllerLebaController;
    return (localLebaController != null) && (localLebaController.a() == 1);
  }
  
  protected void f()
  {
    super.f();
    m();
    if (QLog.isColorLevel()) {
      QLog.i("LebaFrame", 2, "onAccountChanged");
    }
    LebaMainBizProxy localLebaMainBizProxy = this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy;
    if (localLebaMainBizProxy != null) {
      localLebaMainBizProxy.k();
    } else {
      LebaUtil.a("LebaFrame", "onAccountChanged", "ThirdParts");
    }
    LebaShowListManager.a().a();
    t();
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.post(new Leba.1(this));
  }
  
  protected void h()
  {
    super.h();
    p();
    LebaMainBizProxy localLebaMainBizProxy = this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy;
    if (localLebaMainBizProxy != null)
    {
      localLebaMainBizProxy.c();
      return;
    }
    LebaUtil.a("LebaFrame", "onBeforeAccountChanged", "ThirdParts");
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessILebaRichApi == null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaBusinessILebaRichApi = ((ILebaRichApi)QRoute.api(ILebaRichApi.class));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqStudymodeApiIStudyModeManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqStudymodeApiIStudyModeManager = ((IStudyModeManager)QRoute.api(IStudyModeManager.class));
    }
  }
  
  void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaFrame", 2, "refreshLebaConfig. begin.");
    }
    ThreadManager.post(new Leba.4(this), 10, null, false);
    LebaMainBizProxy localLebaMainBizProxy = this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy;
    if (localLebaMainBizProxy != null)
    {
      localLebaMainBizProxy.g();
      return;
    }
    LebaUtil.a("LebaFrame", "refreshLebaConfig", "ThirdParts");
  }
  
  void k()
  {
    ILebaRichApi localILebaRichApi = this.jdField_a_of_type_ComTencentMobileqqLebaBusinessILebaRichApi;
    if (localILebaRichApi == null)
    {
      LebaUtil.a("LebaFrame", "setThemeDiyBgLeba", "RichApi");
      return;
    }
    localILebaRichApi.applyThemeBg(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_AndroidWidgetImageView, 2130838740, "-leba-");
    if (ThemeUtil.isNowThemeIsAnimate()) {
      this.c = true;
    }
  }
  
  public void l()
  {
    QLog.i("LebaFrame", 1, "onPostThemeChanged");
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setTag(null);
    }
    k();
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    else
    {
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850433);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167053));
    }
    SimpleUIUtil.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(11340002, 0L);
    m();
    localObject = this.jdField_a_of_type_ComTencentMobileqqLebaControllerLebaController;
    if (localObject != null) {
      ((LebaController)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy;
    if (localObject != null) {
      ((LebaMainBizProxy)localObject).e();
    } else {
      LebaUtil.a("LebaFrame", "onPostThemeChanged", "ThirdParts");
    }
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null) {
      TextHook.updateFont((View)localObject);
    }
  }
  
  public void m()
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      boolean bool2 = QQTheme.f();
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqStudymodeApiIStudyModeManager;
      boolean bool1;
      if ((localObject != null) && (((IStudyModeManager)localObject).getStudyModeSwitch())) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshMgrBtn isSimpleUI=");
      ((StringBuilder)localObject).append(bool2);
      ((StringBuilder)localObject).append(",isStudyMode=");
      ((StringBuilder)localObject).append(bool1);
      QLog.i("leba_study", 1, ((StringBuilder)localObject).toString());
      if ((!bool2) && (!bool1))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    }
  }
  
  public void n()
  {
    QLog.d("Leba", 1, "onLebaTabChange");
    LebaWebPreloadHelper.a(true);
    if (this.jdField_a_of_type_MqqAppAppRuntime != null)
    {
      localObject = (LebaHelper)((ILebaHelperService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ILebaHelperService.class, "multi")).getLebaHelper();
      if (localObject != null)
      {
        ((LebaHelper)localObject).c();
        ((LebaHelper)localObject).f();
      }
      else
      {
        QLog.i("LebaFrame", 1, "onLebaTabChange lebaHelper == null");
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy;
    if (localObject != null)
    {
      ((LebaMainBizProxy)localObject).f();
      return;
    }
    LebaUtil.a("LebaFrame", "onLebaTabChange", "ThirdParts");
  }
  
  public void onClick(View paramView)
  {
    if (c()) {
      s();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    b(false);
    if (!this.jdField_a_of_type_Boolean) {
      a(true);
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {
      return;
    }
    if (this.c)
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
    LebaController localLebaController = this.jdField_a_of_type_ComTencentMobileqqLebaControllerLebaController;
    if (localLebaController != null) {
      localLebaController.a(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.Leba
 * JD-Core Version:    0.7.0.1
 */