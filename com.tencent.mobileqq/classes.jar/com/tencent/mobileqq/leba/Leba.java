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
    if (this.jdField_a_of_type_MqqAppAppRuntime == null) {}
    do
    {
      return;
      int i = LebaReportUtils.a(paramBoolean, paramRedTypeInfo);
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "trends_tab", "click_trends_tab", 0, 0, "", "", String.valueOf(i), "");
      o();
    } while (!paramBoolean);
    ((IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "")).reportLevelZeroRedInfo(0, 31);
  }
  
  private void p()
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)a(2131379533));
    QIphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131379451));
    QIphoneTitleBarActivity.setLayerType((ViewGroup)a(2131377159));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131370254));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131369534));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719721);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131369501));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    m();
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(a(), this.jdField_b_of_type_AndroidWidgetImageView).b(53).a();
    v();
    if (ThemeUtil.a(false))
    {
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    for (;;)
    {
      SimpleUIUtil.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      return;
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850507);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167030));
    }
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime != null)
    {
      ((ILebaHelperService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ILebaHelperService.class, "multi")).removeLebaListener(this.jdField_a_of_type_ComTencentMobileqqLebaObserverResourcePluginListener);
      if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy == null) {
        break label72;
      }
      this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy.h();
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqStudymodeApiIStudyModeManager != null) && (this.jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqStudymodeApiIStudyModeManager.unregisterStudyModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener);
      return;
      label72:
      LebaUtil.a("LebaFrame", "removeObservers", "ThirdParts");
    }
    LebaUtil.a("LebaFrame", "removeObservers", "StudyModeManager");
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView = ((FPSXListView)a(2131370256));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131370246));
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setActTAG("actFPSLeba");
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setReportType(2);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setNeedCheckSpringback(true);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOverscrollHeader(a().getDrawable(2130850655));
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOnScrollListener(this);
      }
    }
    else
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(a()).inflate(2131561298, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView, false);
        if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy == null) {
          break label231;
        }
        this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy.a(this.jdField_a_of_type_AndroidViewView);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqLebaControllerLebaController != null)
      {
        InitViewParam localInitViewParam = new InitViewParam();
        localInitViewParam.jdField_a_of_type_MqqAppAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
        localInitViewParam.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
        localInitViewParam.jdField_a_of_type_AndroidContentContext = a();
        localInitViewParam.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
        localInitViewParam.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView;
        localInitViewParam.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaItemListener = this;
        this.jdField_a_of_type_ComTencentMobileqqLebaControllerLebaController.a(localInitViewParam);
      }
      i();
      return;
      label231:
      LebaUtil.a("LebaFrame", "initView", "ThirdParts");
    }
  }
  
  private void t()
  {
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "trends_tab", "click_tt_right", 0, 0, "", "", "", "");
    ((IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("150000");
    LebaShowListManager.a().jdField_a_of_type_Boolean = true;
    LebaUtil.a(a(), this.jdField_a_of_type_MqqAppAppRuntime);
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy.b();
    }
    for (;;)
    {
      v();
      return;
      LebaUtil.a("LebaFrame", "updateRedFlag", "ThirdParts");
    }
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime == null) {
      QLog.i("LebaFrame", 1, "updateIconEntryRedTouch app == null");
    }
    IRedTouchManager localIRedTouchManager;
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    do
    {
      do
      {
        return;
      } while (QQTheme.e());
      localIRedTouchManager = (IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "");
      localAppInfo = localIRedTouchManager.getAppInfoByPath("150000");
    } while (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch == null);
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.b(53).a().a(localAppInfo);
    localIRedTouchManager.onReportRedPointExposure(localAppInfo);
  }
  
  public void E()
  {
    super.E();
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559431, null);
    this.jdField_a_of_type_ComTencentMobileqqLebaControllerLebaController = new LebaController();
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(View paramView, LebaViewItem paramLebaViewItem, LebaClickReportInfo paramLebaClickReportInfo)
  {
    if (!c()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy.a(paramView, paramLebaViewItem, paramLebaClickReportInfo);
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
      localDC03309ReportItem.g = ThemeUtil.a();
      if (d()) {}
      for (paramLebaClickReportInfo = "1";; paramLebaClickReportInfo = "2")
      {
        localDC03309ReportItem.h = paramLebaClickReportInfo;
        EXReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, localDC03309ReportItem);
        return;
      }
    }
    ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "trends_tab", "Clk_plug_in", 0, 0, String.valueOf(paramLebaClickReportInfo.jdField_a_of_type_Long), String.valueOf(paramLebaClickReportInfo.jdField_a_of_type_Int), String.valueOf(paramLebaClickReportInfo.b), "");
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    if (QLog.isColorLevel()) {
      QLog.i("LebaFrame", 2, "onLogout");
    }
  }
  
  public void a(boolean paramBoolean, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy.b(paramBoolean);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.postDelayed(new Leba.3(this, paramBoolean, paramRedTypeInfo), 150L);
      return;
      LebaUtil.a("LebaFrame", "onSwitchToLeba", "ThirdParts");
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (this.w)
    {
      ArrayList localArrayList = new ArrayList();
      LebaUtil.a(localArrayList, LebaShowListManager.a().a(this.jdField_a_of_type_MqqAppAppRuntime));
      b(new Leba.8(this, localArrayList));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LebaFrame", 2, "onGameCenterMsgReceive, " + this.w);
      }
      return;
      LebaShowListManager.jdField_a_of_type_Int |= 0x2;
    }
  }
  
  public String a_()
  {
    return HardCodeUtil.a(2131719721);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessILebaRichApi == null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaBusinessILebaRichApi = ((ILebaRichApi)QRoute.api(ILebaRichApi.class));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqStudymodeApiIStudyModeManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqStudymodeApiIStudyModeManager = ((IStudyModeManager)QRoute.api(IStudyModeManager.class));
    }
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.i("LebaFrame", 2, "leba.java onResume" + LebaShowListManager.jdField_a_of_type_Int);
    }
    LebaWebPreloadHelper.a(true);
    AbstractGifImage.resumeAll();
    if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy.a(paramBoolean);
      ((IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "")).residenceReport(System.currentTimeMillis());
      if ((this.jdField_a_of_type_Boolean) && ((LebaShowListManager.jdField_a_of_type_Int & 0x4) == 0)) {
        break label263;
      }
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(11340002, 200L);
    }
    for (;;)
    {
      v();
      m();
      Object localObject;
      if (AppSetting.d)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(true);
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(a(2131691205));
        localObject = a(2131693920);
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject);
        a().setTitle(a(2131693920));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqLebaControllerLebaController != null) {
        this.jdField_a_of_type_ComTencentMobileqqLebaControllerLebaController.a();
      }
      ((IVasService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IVasService.class, "")).getTianshuWebManager().a("{}");
      ApngImage.playByTag(4);
      ((ILebaHelperService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ILebaHelperService.class, "multi")).checkModleAndRefesh();
      return;
      LebaUtil.a("LebaFrame", "onResume", "ThirdParts");
      break;
      label263:
      if (LebaShowListManager.jdField_a_of_type_Int > 0)
      {
        localObject = new ArrayList();
        LebaUtil.a((List)localObject, LebaShowListManager.a().a(this.jdField_a_of_type_MqqAppAppRuntime));
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
          if (this.jdField_a_of_type_ComTencentMobileqqLebaControllerLebaController != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqLebaControllerLebaController.b();
            u();
          }
        }
        LebaShowListManager.jdField_a_of_type_Int = 0;
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.post(new Leba.1(this));
  }
  
  public boolean c()
  {
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView == null) {
      bool1 = true;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = this.d;
      if (this.d)
      {
        this.d = false;
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.postDelayed(new Leba.7(this), 1000L);
        return bool2;
      }
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("LebaFrame", 2, "clickAction is dismiss,click too frequently.");
    return bool2;
  }
  
  public void d()
  {
    super.d();
    q();
    if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy.c();
      return;
    }
    LebaUtil.a("LebaFrame", "onBeforeAccountChanged", "ThirdParts");
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqLebaControllerLebaController != null) && (this.jdField_a_of_type_ComTencentMobileqqLebaControllerLebaController.a() == 1);
  }
  
  public void e(boolean paramBoolean)
  {
    try
    {
      s();
      ILebaHelperService localILebaHelperService = (ILebaHelperService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ILebaHelperService.class, "multi");
      localILebaHelperService.initLebaHelper();
      localILebaHelperService.addLebaListener(this.jdField_a_of_type_ComTencentMobileqqLebaObserverResourcePluginListener);
      if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy.i();
        this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy.c(paramBoolean);
        if (this.jdField_a_of_type_ComTencentMobileqqStudymodeApiIStudyModeManager == null) {
          break label144;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener == null) {
          this.jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener = new Leba.MyStudyModeChangeListener(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqStudymodeApiIStudyModeManager.registerStudyModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("LebaFrame", 1, "leba fillData->initLebaView exception:" + localException, localException);
        continue;
        LebaUtil.a("LebaFrame", "fillData", "ThirdParts");
      }
      label144:
      LebaUtil.a("LebaFrame", "fillData", "StudyModeManager");
    }
  }
  
  public boolean e_()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void f()
  {
    super.f();
    b();
    Leba.RealLebaProxy localRealLebaProxy = new Leba.RealLebaProxy();
    localRealLebaProxy.a = this;
    if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy.a(localRealLebaProxy);
    }
    for (;;)
    {
      p();
      ((ViewStub)a(2131378609)).setOnInflateListener(this);
      ((CommonLoadingView)a(2131365136)).setOnFirstDrawListener(this);
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      return;
      LebaUtil.a("LebaFrame", "onCreate", "ThirdParts");
    }
  }
  
  void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaFrame", 2, "refreshLebaConfig. begin.");
    }
    ThreadManager.post(new Leba.4(this), 10, null, false);
    if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy.g();
      return;
    }
    LebaUtil.a("LebaFrame", "refreshLebaConfig", "ThirdParts");
  }
  
  public void h()
  {
    super.h();
    if (QLog.isColorLevel()) {
      QLog.i("LebaFrame", 2, "onStop");
    }
  }
  
  void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessILebaRichApi == null) {
      LebaUtil.a("LebaFrame", "setThemeDiyBgLeba", "RichApi");
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqLebaBusinessILebaRichApi.applyThemeBg(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_AndroidWidgetImageView, 2130838980, "-leba-");
    } while (!ThemeUtil.c());
    this.c = true;
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaFrame", 2, "onPostThemeChanged");
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(null);
    }
    i();
    if (ThemeUtil.a(false))
    {
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      SimpleUIUtil.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(11340002, 0L);
      m();
      if (this.jdField_a_of_type_ComTencentMobileqqLebaControllerLebaController != null) {
        this.jdField_a_of_type_ComTencentMobileqqLebaControllerLebaController.c();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy == null) {
        break label196;
      }
      this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy.e();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        TextHook.updateFont(this.jdField_a_of_type_AndroidViewView);
      }
      return;
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850507);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167030));
      break;
      label196:
      LebaUtil.a("LebaFrame", "onPostThemeChanged", "ThirdParts");
    }
  }
  
  public void k()
  {
    q();
    if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy.j();
    }
    for (;;)
    {
      super.k();
      return;
      LebaUtil.a("LebaFrame", "onDestroy", "ThirdParts");
    }
  }
  
  public void l()
  {
    super.l();
    m();
    if (QLog.isColorLevel()) {
      QLog.i("LebaFrame", 2, "onAccountChanged");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy.k();
    }
    for (;;)
    {
      LebaShowListManager.a().a();
      u();
      return;
      LebaUtil.a("LebaFrame", "onAccountChanged", "ThirdParts");
    }
  }
  
  public void m()
  {
    boolean bool2;
    if (this.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      bool2 = QQTheme.e();
      if ((this.jdField_a_of_type_ComTencentMobileqqStudymodeApiIStudyModeManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqStudymodeApiIStudyModeManager.getStudyModeSwitch())) {
        break label86;
      }
    }
    label86:
    for (boolean bool1 = true;; bool1 = false)
    {
      QLog.i("leba_study", 1, "refreshMgrBtn isSimpleUI=" + bool2 + ",isStudyMode=" + bool1);
      if ((!bool2) && (!bool1)) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void n()
  {
    ApngImage.pauseByTag(4);
    super.n();
    LebaWebPreloadHelper.a(false);
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.b();
    }
    LeabOnPauseInfo localLeabOnPauseInfo = new LeabOnPauseInfo();
    if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy.d();
      this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy.a(localLeabOnPauseInfo);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqLebaControllerLebaController != null) {
        this.jdField_a_of_type_ComTencentMobileqqLebaControllerLebaController.a(this.jdField_a_of_type_MqqAppAppRuntime, localLeabOnPauseInfo.jdField_a_of_type_Int, localLeabOnPauseInfo.jdField_a_of_type_Boolean, localLeabOnPauseInfo.b);
      }
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.postDelayed(new Leba.2(this), 500L);
      if (QLog.isColorLevel()) {
        QLog.i("LebaFrame", 2, "leba.java onPause");
      }
      return;
      LebaUtil.a("LebaFrame", "onPause", "ThirdParts");
    }
  }
  
  public void o()
  {
    QLog.d("Leba", 1, "onLebaTabChange");
    LebaWebPreloadHelper.a(true);
    if (this.jdField_a_of_type_MqqAppAppRuntime != null)
    {
      LebaHelper localLebaHelper = (LebaHelper)((ILebaHelperService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ILebaHelperService.class, "multi")).getLebaHelper();
      if (localLebaHelper == null) {
        break label71;
      }
      localLebaHelper.c();
      localLebaHelper.f();
    }
    while (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaMainBizProxy.f();
      return;
      label71:
      QLog.i("LebaFrame", 1, "onLebaTabChange lebaHelper == null");
    }
    LebaUtil.a("LebaFrame", "onLebaTabChange", "ThirdParts");
  }
  
  public void onClick(View paramView)
  {
    if (!c()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      t();
    }
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    e(false);
    if (!this.jdField_a_of_type_Boolean) {
      b(true);
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {}
    do
    {
      return;
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
    } while (this.jdField_a_of_type_ComTencentMobileqqLebaControllerLebaController == null);
    this.jdField_a_of_type_ComTencentMobileqqLebaControllerLebaController.a(paramAbsListView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.Leba
 * JD-Core Version:    0.7.0.1
 */