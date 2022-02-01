package com.tencent.mobileqq.filemanager.activity.fileassistant;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.tendoc.TencentDocMyFileNameBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocMyFileNameProcessor;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.api.IFileAssistantExt;
import com.tencent.mobileqq.filemanager.api.IFileAssistantTipsConfig;
import com.tencent.mobileqq.filemanager.api.IFileAssistantTipsConfig.IBaseJump;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.widget.HeaderScrollView;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.CommonUtils;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.weiyun.WeiyunRemoteCommand;
import com.tencent.mobileqq.weiyun.api.IWeiyunApi;
import com.tencent.mobileqq.weiyun.api.IWeiyunHelper;
import com.tencent.mobileqq.weiyun.utils.PreferenceUtils;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Set;
import mqq.os.MqqHandler;

public class FileAssistantActivity
  extends BaseFileAssistantActivity
  implements OnItemSelectListener
{
  Handler jdField_a_of_type_AndroidOsHandler = new FileAssistantActivity.6(this, Looper.getMainLooper());
  ViewStub jdField_a_of_type_AndroidViewViewStub = null;
  private IFileAssistantExt jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFileAssistantExt;
  IFileAssistantTipsConfig jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFileAssistantTipsConfig;
  HeaderScrollView jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetHeaderScrollView;
  QfileTabBarView jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView = null;
  BusinessInfoCheckUpdate.AppInfo jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo;
  RedTouch jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
  private WeiyunRemoteCommand jdField_a_of_type_ComTencentMobileqqWeiyunWeiyunRemoteCommand;
  NavBarCommon jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon;
  private int[] jdField_a_of_type_ArrayOfInt = { 2131692539, 2131698402, 2131720374, 2131719601 };
  private ViewStub jdField_b_of_type_AndroidViewViewStub;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private FMObserver jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new FileAssistantActivity.5(this);
  BusinessInfoCheckUpdate.AppInfo jdField_b_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo;
  RedTouch jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch;
  private int[] jdField_b_of_type_ArrayOfInt = { 2130844371, 2130844372, 2130844377, 2130844421 };
  TextView jdField_c_of_type_AndroidWidgetTextView;
  BusinessInfoCheckUpdate.AppInfo jdField_c_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo;
  RedTouch jdField_c_of_type_ComTencentMobileqqTianshuUiRedTouch;
  TextView d;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  private String jdField_e_of_type_JavaLangString = HardCodeUtil.a(2131698185);
  TextView f;
  boolean l = false;
  boolean m = false;
  private volatile boolean n = false;
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" fileRedTouch deleteRedTouch path = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("FileAssistantActivity", 1, ((StringBuilder)localObject).toString());
    localObject = (IRedTouchManager)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
    if (paramAppInfo == null)
    {
      ((IRedTouchManager)localObject).onRedTouchItemClick(paramString);
      return;
    }
    ((IRedTouchManager)localObject).onRedTouchItemClick(paramAppInfo, null);
  }
  
  private void n()
  {
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369018));
    this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(getApplicationContext(), this.jdField_e_of_type_AndroidWidgetTextView).b(53).d(10).a();
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    ReportController.b(getAppRuntime(), "dc00898", "", "", "0X800906F", "0X800906F", 0, 0, "", "", "", "");
  }
  
  private void o()
  {
    TencentDocMyFileNameBean localTencentDocMyFileNameBean = TencentDocMyFileNameProcessor.a();
    if (localTencentDocMyFileNameBean != null)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(localTencentDocMyFileNameBean.a);
      this.d.setText(localTencentDocMyFileNameBean.b);
      this.jdField_e_of_type_JavaLangString = localTencentDocMyFileNameBean.c;
    }
  }
  
  private void p()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFileAssistantTipsConfig;
    if ((localObject != null) && (((IFileAssistantTipsConfig)localObject).a()))
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFileAssistantTipsConfig.a()))
      {
        QLog.i("FileAssistantActivity", 1, "FileAssistantTips not ready, textContent is null");
        return;
      }
      this.jdField_b_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131366398));
      this.jdField_b_of_type_AndroidViewViewStub.inflate();
      localObject = (TextView)findViewById(2131379927);
      TextView localTextView = (TextView)findViewById(2131379928);
      ImageView localImageView = (ImageView)findViewById(2131369526);
      ((TextView)localObject).setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFileAssistantTipsConfig.a());
      localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFileAssistantTipsConfig.b());
      localTextView.setOnClickListener(this);
      localImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFileAssistantTipsConfig.a();
      return;
    }
    QLog.i("FileAssistantActivity", 1, "FileAssistantTips is switch off");
  }
  
  private void q()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.jdField_b_of_type_AndroidViewViewStub.getHeight(), 0 });
    localValueAnimator.setDuration(300L);
    localValueAnimator.addUpdateListener(new FileAssistantActivity.2(this));
    localValueAnimator.addListener(new FileAssistantActivity.3(this));
    localValueAnimator.start();
  }
  
  private void r()
  {
    Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
    localIntent.putExtra("tab_tab_type", 1);
    localIntent.putExtra("qfile_entrance_type_key", 8);
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("category", 15);
      localIntent.putExtra("bundle", localBundle);
      localIntent.putExtra("from", "FileAssistant");
      localIntent.putExtra("custom_title", getString(2131692292));
      startActivityForResult(localIntent, 101);
      if (this.l)
      {
        FileManagerReporter.a("0X8005538");
        return;
      }
      FileManagerReporter.a("0X800681E");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void s()
  {
    try
    {
      Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putLong("category", 14L);
      localIntent.putExtra("bundle", localBundle);
      localIntent.putExtra("tab_tab_type", 3);
      localIntent.putExtra("from", "FileAssistant");
      startActivityForResult(localIntent, 101);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void t()
  {
    this.jdField_a_of_type_ComTencentMobileqqWeiyunWeiyunRemoteCommand = new WeiyunRemoteCommand();
    PluginCommunicationHandler.getInstance().register(this.jdField_a_of_type_ComTencentMobileqqWeiyunWeiyunRemoteCommand);
    ((IWeiyunHelper)QRoute.api(IWeiyunHelper.class)).notifyEnterFileAssit(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getApplication());
  }
  
  private void u()
  {
    Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
    localIntent.putExtra("tab_tab_type", 3);
    localIntent.putExtra("from", "FileAssistant");
    startActivityForResult(localIntent, 101);
  }
  
  private void v()
  {
    this.n = false;
    if (((IQQFileEngine)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IQQFileEngine.class)).hasQueriedVerifyPassword() == true)
    {
      ((IQQFileEngine)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IQQFileEngine.class)).queryNeedVerifyPwd();
      return;
    }
    if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
      localIntent.putExtra("tab_tab_type", 3);
      localIntent.putExtra("from", "FileAssistant");
      startActivityForResult(localIntent, 101);
      return;
    }
    FMToastUtil.a(BaseApplication.getContext().getString(2131698210));
  }
  
  private void w()
  {
    QLog.i("FileAssistantActivity", 1, "fileRedTouch updateAllRedTouch");
    x();
    z();
    y();
  }
  
  private void x()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch != null)
    {
      IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
      if (localIRedTouchManager == null) {
        return;
      }
      this.jdField_b_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo = localIRedTouchManager.getAppInfo(1, "100160.100163");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fileRedTouch updateDocsFileRedTouch info = ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
      QLog.i("FileAssistantActivity", 1, ((StringBuilder)localObject).toString());
      this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch.a(this.jdField_b_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
      localObject = this.jdField_b_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo;
      if (localObject != null) {
        localIRedTouchManager.onRedTouchItemExposure((BusinessInfoCheckUpdate.AppInfo)localObject, null);
      }
    }
  }
  
  private void y()
  {
    if (this.jdField_c_of_type_ComTencentMobileqqTianshuUiRedTouch != null)
    {
      IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
      if (localIRedTouchManager == null) {
        return;
      }
      this.jdField_c_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo = localIRedTouchManager.getAppInfo(1, "100160.100162");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fileRedTouch updateWeiyunBackupRedTouch info = ");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
      QLog.i("FileAssistantActivity", 1, ((StringBuilder)localObject).toString());
      this.jdField_c_of_type_ComTencentMobileqqTianshuUiRedTouch.a(this.jdField_c_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
      localObject = this.jdField_c_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo;
      if (localObject != null) {
        localIRedTouchManager.onRedTouchItemExposure((BusinessInfoCheckUpdate.AppInfo)localObject, null);
      }
    }
  }
  
  private void z()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null)
    {
      IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
      if (localIRedTouchManager == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo = localIRedTouchManager.getAppInfo(1, "100160.100164");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fileRedTouch updateWeiyunFileRedTouch info = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
      QLog.i("FileAssistantActivity", 1, ((StringBuilder)localObject).toString());
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a(this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
      localObject = this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo;
      if (localObject != null) {
        localIRedTouchManager.onRedTouchItemExposure((BusinessInfoCheckUpdate.AppInfo)localObject, null);
      }
    }
  }
  
  public ListView a()
  {
    QfileTabBarView localQfileTabBarView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView;
    if (localQfileTabBarView != null) {
      return localQfileTabBarView.a();
    }
    return null;
  }
  
  public void a(Set<FileInfo> paramSet)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(paramSet);
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a();
  }
  
  public void b(ArrayList<FileManagerEntity> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(paramArrayList);
  }
  
  public void c(ArrayList<WeiYunFileInfo> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.c(paramArrayList);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    ViewStub localViewStub = this.jdField_a_of_type_AndroidViewViewStub;
    if (localViewStub != null) {
      localViewStub.setVisibility(8);
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null) && ((paramIntent.getBooleanExtra("foward_editbar", false) == true) || (paramIntent.getBooleanExtra("destroy_last_activity", false) == true)) && (paramInt2 == 4))
    {
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).openAIO(this, paramIntent);
      finish();
    }
    if (paramInt1 == 10001) {
      ((IWeiyunApi)QRoute.api(IWeiyunApi.class)).initPwdRecord(this);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFileAssistantExt = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).createFileAssistantExt();
    setContentView(2131560773);
    ThreadManager.getFileThreadHandler().post(new FileAssistantActivity.1(this));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetHeaderScrollView = ((HeaderScrollView)findViewById(2131368136));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369101));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369108));
    this.d = ((TextView)findViewById(2131369175));
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(getApplicationContext(), this.d).b(53).d(10).a();
    n();
    this.f = ((TextView)findViewById(2131369019));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.f.setOnClickListener(this);
    findViewById(2131378304).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon = ((NavBarCommon)findViewById(2131376636));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(getString(2131692363));
    if (Build.VERSION.SDK_INT >= 21) {
      paramBundle = getDrawable(2130844317);
    } else {
      paramBundle = getResources().getDrawable(2130844317);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setOnItemSelectListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setRightImage(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setRightImageDesc(HardCodeUtil.a(2131698163));
    this.jdField_c_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon).b(53).d(5).e(10).a();
    o();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFileAssistantExt.a(this, this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetHeaderScrollView);
    m();
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).addObserver(this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    t();
    w();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFileAssistantExt.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, this.jdField_a_of_type_AndroidOsHandler);
    if (PreferenceUtils.a(this, this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getCurrentAccountUin()) == 1)
    {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).preloadMiniProcess();
      if (QLog.isColorLevel()) {
        QLog.d("FileAssistantActivity", 2, "doOnCreate, preload mini app process");
      }
    }
    paramBundle = getIntent();
    int j = 0;
    this.l = paramBundle.getBooleanExtra("COMEFROMDESK", false);
    paramBundle = new FileManagerReporter.FileAssistantReportData();
    paramBundle.b = "file_asst_in";
    paramBundle.a = 11;
    FileManagerReporter.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getCurrentAccountUin(), paramBundle);
    if (!((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).hasShortCut(this, new String[] { getString(2131692363) }))
    {
      int[] arrayOfInt1 = new int[this.jdField_a_of_type_ArrayOfInt.length + 1];
      paramBundle = new int[this.jdField_b_of_type_ArrayOfInt.length + 1];
      int i = 0;
      for (;;)
      {
        int[] arrayOfInt2 = this.jdField_a_of_type_ArrayOfInt;
        if (i >= arrayOfInt2.length) {
          break;
        }
        arrayOfInt1[i] = arrayOfInt2[i];
        i += 1;
      }
      arrayOfInt1[(arrayOfInt1.length - 1)] = 2131692336;
      this.jdField_a_of_type_ArrayOfInt = arrayOfInt1;
      i = j;
      for (;;)
      {
        arrayOfInt1 = this.jdField_b_of_type_ArrayOfInt;
        if (i >= arrayOfInt1.length) {
          break;
        }
        paramBundle[i] = arrayOfInt1[i];
        i += 1;
      }
      paramBundle[(paramBundle.length - 1)] = 2130844373;
      this.jdField_b_of_type_ArrayOfInt = paramBundle;
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.c();
    if (this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).deleteObserver(this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFileAssistantExt.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.n = true;
    this.jdField_a_of_type_ComTencentMobileqqWeiyunWeiyunRemoteCommand.a(null);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.rightViewText.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(getString(2131692363));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a();
    this.f.setText(2131698164);
    w();
    b();
  }
  
  public void j()
  {
    if (this.f != null)
    {
      if (f())
      {
        this.f.setText(2131690728);
        return;
      }
      this.f.setText(2131698164);
    }
  }
  
  protected void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView = ((QfileTabBarView)findViewById(2131366797));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setAttribution(1);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setHeaderScrollView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetHeaderScrollView);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(3, getString(2131692577));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(4, getString(2131692579));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(20, this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(5, getString(2131692587));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(6, getString(2131692581));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(7, getString(2131692578));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(3);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    int i = paramView.getId();
    if (i == 2131369019)
    {
      i();
      if (f())
      {
        this.f.setText(2131690728);
      }
      else
      {
        FileManagerReporter.a("0X8009C32");
        this.f.setText(2131698164);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(getString(2131692363));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a();
      this.rightViewText.setVisibility(8);
    }
    else if (i == 2131369101)
    {
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).checkPermission(this, new FileAssistantActivity.4(this));
    }
    else if (i == 2131369108)
    {
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).openPCFile(this);
      if (this.l) {
        FileManagerReporter.a("0X8005539");
      } else {
        FileManagerReporter.a("0X800681F");
      }
    }
    else
    {
      Object localObject;
      if (i == 2131369175)
      {
        i = PreferenceUtils.a(this, this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getCurrentAccountUin());
        if (i == 1)
        {
          localObject = PreferenceUtils.a(this, this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getCurrentAccountUin());
          i = PreferenceUtils.b(this, this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getCurrentAccountUin());
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            ((IWeiyunApi)QRoute.api(IWeiyunApi.class)).startWeiYunMiniApp(this, (String)localObject, i, null);
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("can not to start WeiYun Mini app, apkgUrl = ");
            localStringBuilder.append((String)localObject);
            localStringBuilder.append(", version = ");
            localStringBuilder.append(i);
            QLog.w("FileAssistantActivity", 2, localStringBuilder.toString());
            v();
          }
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("can not to start WeiYun Mini app, weiYunGrayConfig = ");
          ((StringBuilder)localObject).append(i);
          QLog.w("FileAssistantActivity", 2, ((StringBuilder)localObject).toString());
          v();
        }
        if (this.l) {
          FileManagerReporter.a("0X800553A");
        } else {
          FileManagerReporter.a("0X8006820");
        }
        a(this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo, "100160.100164");
      }
      else if (i == 2131369018)
      {
        FileManagerReporter.a("0X8009070");
        ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).gotoTIMTeamworkFileUrl(this, this.m);
        CommonUtils.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface);
        a(this.jdField_b_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo, "100160.100163");
      }
      else if (i == 2131369526)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFileAssistantTipsConfig.b();
        q();
      }
      else if (i == 2131379928)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFileAssistantTipsConfig.c();
        localObject = ((IQFileConfigManager)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).getFileAssistantTipsConfig().a();
        if (localObject != null) {
          ((IFileAssistantTipsConfig.IBaseJump)localObject).a(this);
        }
        q();
      }
      else if (i == 2131378304)
      {
        FileManagerReporter.a("0X8009C33");
        ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).startSeach(this);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if (paramInt == 5)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFileAssistantExt.a(this, this.jdField_c_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo, this.l, this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt);
      paramInt = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.getWidth();
      int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFileAssistantExt.a();
      int j = getResources().getDimensionPixelSize(2131298898);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFileAssistantExt.a(this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon, paramInt - i - j, 0);
      ReportController.b(getAppRuntime(), "dc00898", "", "", "0X800A15E", "0X800A15E", 0, 0, "", "", "", "");
      return;
    }
    if (paramInt == 4)
    {
      i();
      this.rightViewText.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(getString(2131692363));
      return;
    }
    if (paramInt == 1) {
      finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity
 * JD-Core Version:    0.7.0.1
 */