package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.qvip.KingCardConfig;
import com.tencent.mobileqq.config.business.qvip.KingCardConfig.Item;
import com.tencent.mobileqq.config.business.qvip.KingCardProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationProcessor;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalTbsViewManager;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalTbsViewManager.LocalTbsViewManagerCallback;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnTransEventListener;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanageraux.fileviewer.FileView.LocalTdsViewManager;
import com.tencent.mobileqq.filemanageraux.fileviewer.FileView.LocalTdsViewManager.LocalTdsViewManagerCallback;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportObserver;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.TMSManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import cooperation.qqreader.QRLocalManager;
import java.util.ArrayList;
import java.util.List;

public class SimpleFilePresenter
  extends FileBrowserPresenterBase
  implements FileBrowserModelBase.OnTransEventListener
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private LocalTbsViewManager.LocalTbsViewManagerCallback jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewLocalTbsViewManager$LocalTbsViewManagerCallback = new SimpleFilePresenter.5(this);
  protected SimpleFileViewer a;
  private LocalTdsViewManager.LocalTdsViewManagerCallback jdField_a_of_type_ComTencentMobileqqFilemanagerauxFileviewerFileViewLocalTdsViewManager$LocalTdsViewManagerCallback = new SimpleFilePresenter.6(this);
  private TeamWorkFileImportObserver jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportObserver = new SimpleFilePresenter.InnerTeamWorkFileImportObserver(this, null);
  private Runnable jdField_a_of_type_JavaLangRunnable = null;
  private boolean jdField_a_of_type_Boolean = false;
  protected boolean d = true;
  private volatile boolean e = false;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  
  public SimpleFilePresenter(FileBrowserModelBase paramFileBrowserModelBase, Activity paramActivity)
  {
    super(paramFileBrowserModelBase, paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer = new SimpleFileViewer(this.jdField_a_of_type_AndroidAppActivity);
    a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface)) && (LocalTbsViewManager.a().a()))
    {
      LocalTbsViewManager.a().b(true);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d(paramInt);
      TeamWorkFileImportInfo localTeamWorkFileImportInfo = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a();
      localTeamWorkFileImportInfo.g = paramBoolean;
      TeamWorkConvertUtils.b(localTeamWorkFileImportInfo);
    }
  }
  
  private final void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener.a(paramBoolean);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a()) && (paramBoolean)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c();
    }
    while (((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b() == null) && (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.j())) || (paramBoolean) || ((this.g) && (!this.h))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a());
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    int n = 1;
    Object localObject = TencentDocLocalCooperationProcessor.a();
    int m;
    if (paramBoolean)
    {
      localObject = ((TencentDocLocalCooperationBean)localObject).a;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        m = n;
        if (paramInt != 1)
        {
          if (paramInt != 3000) {
            break label80;
          }
          m = n;
        }
      }
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", (String)localObject, (String)localObject, m, 0, "", "", "", "");
      return;
      localObject = ((TencentDocLocalCooperationBean)localObject).c;
      break;
      label80:
      if (paramInt == 0) {
        m = 0;
      } else {
        m = 3;
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaLangRunnable = new SimpleFilePresenter.3(this);
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(8);
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  private final void t()
  {
    LocalTbsViewManager.a().b(false);
    if ((TeamWorkUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c())) && (this.f)) {
      a(13, false);
    }
    TeamWorkFileImportInfo localTeamWorkFileImportInfo;
    do
    {
      do
      {
        return;
        if ((TeamWorkUtils.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c())) && (this.f))
        {
          a(11, TencentDocLocalCooperationProcessor.a().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c()));
          return;
        }
      } while (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.j());
      localTeamWorkFileImportInfo = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a();
      TeamWorkConvertUtils.a(localTeamWorkFileImportInfo);
    } while ((this.g) && (!this.h));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(localTeamWorkFileImportInfo);
  }
  
  public void a()
  {
    if (this.e)
    {
      this.e = false;
      return;
    }
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = simple");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(false);
    if ((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface)) {
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c());
    if (FileManagerUtil.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d())) {
      q();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a(this);
      r();
      return;
      b();
    }
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
    String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.i();
    if (TextUtils.isEmpty(str)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(str);
    } while (this.jdField_a_of_type_JavaLangRunnable != null);
    c();
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 2864)
    {
      if (paramInt2 != 0) {
        break label55;
      }
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a();
      if ((paramIntent != null) && (paramIntent.m != null)) {
        ThreadManager.excute(new SimpleFilePresenter.1(this, paramIntent), 128, null, false);
      }
    }
    label54:
    label55:
    Object localObject1;
    do
    {
      do
      {
        do
        {
          break label54;
          do
          {
            return;
          } while (paramInt2 != -1);
          TenDocLogReportHelper.a(null, "0X800A5A4");
          TenDocLogReportHelper.a(null, "0X800A5A3");
          localObject1 = BaseApplicationImpl.sApplication.getRuntime();
        } while (!(localObject1 instanceof QQAppInterface));
        localObject2 = (TeamWorkFileImportHandler)((QQAppInterface)localObject1).getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_FILE_IMPORT_HANDLER);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a();
      } while ((localObject2 == null) || (localObject1 == null));
      localObject2 = ((TeamWorkFileImportHandler)localObject2).a((TeamWorkFileImportInfo)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a((String)localObject2, "open");
      localObject2 = paramIntent.getExtras();
      paramIntent = ((Bundle)localObject2).getString("uin");
      paramInt1 = ((Bundle)localObject2).getInt("uintype", 0);
    } while ((localObject1 == null) || (((TeamWorkFileImportInfo)localObject1).m == null));
    Object localObject2 = new ArrayList(1);
    ((List)localObject2).add(paramIntent);
    boolean bool = TencentDocLocalCooperationProcessor.a().a(((TeamWorkFileImportInfo)localObject1).b);
    a((List)localObject2, ((TeamWorkFileImportInfo)localObject1).m, bool, paramInt1);
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    paramConfiguration = new DisplayMetrics();
    this.jdField_a_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay().getMetrics(paramConfiguration);
    int m = paramConfiguration.widthPixels;
    int n = paramConfiguration.heightPixels;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(m, n);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(m, n);
  }
  
  public void a(List<String> paramList, String paramString, boolean paramBoolean, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null)) {
      return;
    }
    ThreadManager.excute(new SimpleFilePresenter.2(this, paramString, paramBoolean, paramInt, paramList), 128, null, false);
  }
  
  public boolean a()
  {
    return (this.d) && (!this.g);
  }
  
  protected void as_()
  {
    if ((FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d())) && (QbSdk.isSuportOpenFile(FileManagerUtil.g(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c()), 2)))
    {
      String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131694681);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(str, new SimpleFilePresenter.4(this));
    }
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "SimpleFilePresenter handleCloudFile: fileName[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c() + "]");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.e() == 5)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(2130844419);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.g());
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.h())) && (16 != this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b())) {
        break label161;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(false);
      label112:
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b() != 16) {
        break label178;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692421));
    }
    label161:
    label178:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c()));
        break;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.g(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.h());
        break label112;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d())
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692607));
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.e())
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692421));
          return;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.i()) {
          break label286;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a() == null);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a().a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(true);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(false);
      b(0.0F);
      return;
    } while (!TeamWorkUtils.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c()));
    label286:
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d(7);
    TeamWorkConvertUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a(), "SimpleFilePresenter<FileAssistant>");
  }
  
  public boolean b()
  {
    if (this.g) {
      this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(4);
    }
    while ((!this.d) && (!this.g))
    {
      return true;
      if (this.d) {
        this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
      }
    }
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(true);
    b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a());
    int m = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.h();
    if ((m != 1) && (m == 4)) {}
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(false);
    h();
    as_();
    s();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(false);
    h();
    as_();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null)
    {
      if ((BaseApplicationImpl.sProcessId != 1) || (!QRLocalManager.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c()))) {
        break label98;
      }
      QRLocalManager.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d(), true);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b();
    }
    for (;;)
    {
      s();
      return;
      label98:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(false);
    h();
    as_();
    s();
  }
  
  public void i()
  {
    if ((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface)) {
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportObserver);
    }
    this.j = true;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f();
    }
    LocalTbsViewManager.a().a(this.jdField_a_of_type_AndroidAppActivity);
    LocalTdsViewManager.a().a(this.jdField_a_of_type_AndroidAppActivity);
    s();
    super.i();
  }
  
  public void j()
  {
    super.j();
    this.l = true;
  }
  
  public void k()
  {
    super.k();
    if (this.i)
    {
      if (this.f) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewLocalTbsViewManager$LocalTbsViewManagerCallback);
      }
      if (this.g) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxFileviewerFileViewLocalTdsViewManager$LocalTdsViewManagerCallback);
      }
    }
    this.i = true;
    this.l = false;
    TeamWorkFileImportInfo localTeamWorkFileImportInfo;
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a() != null))
    {
      localTeamWorkFileImportInfo = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a();
      if (!localTeamWorkFileImportInfo.d()) {
        break label153;
      }
      if ((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface))
      {
        localTeamWorkFileImportHandler = (TeamWorkFileImportHandler)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_FILE_IMPORT_HANDLER);
        if ((localTeamWorkFileImportHandler != null) && (!localTeamWorkFileImportHandler.a(localTeamWorkFileImportInfo))) {
          TeamWorkConvertUtils.a(localTeamWorkFileImportInfo, "SimpleFilePresenter<FileAssistant>");
        }
      }
    }
    label153:
    while ((!localTeamWorkFileImportInfo.c()) || (!this.k))
    {
      TeamWorkFileImportHandler localTeamWorkFileImportHandler;
      return;
    }
    this.k = false;
    TeamWorkConvertUtils.b(localTeamWorkFileImportInfo);
  }
  
  protected void m()
  {
    super.m();
    as_();
  }
  
  protected void q()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "SimpleFilePresenter handleLocalFile: fileName[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c() + "] filePath[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d() + "]");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.i() == 2) {
      LocalTdsViewManager.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxFileviewerFileViewLocalTdsViewManager$LocalTdsViewManagerCallback, true);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c()));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.g(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.f());
    this.jdField_a_of_type_AndroidAppActivity.getString(2131692421);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b() == 16)
    {
      String str = BaseApplicationImpl.getContext().getString(2131692421);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(str);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(true);
    }
    as_();
  }
  
  protected void r()
  {
    if (FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d())) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.g(false);
    }
    String str;
    do
    {
      return;
      str = KingCardProcessor.c().c.a();
    } while ((!NetworkUtil.g(this.jdField_a_of_type_AndroidAppActivity)) || (NetworkUtil.h(this.jdField_a_of_type_AndroidAppActivity)) || (!KingCardProcessor.c().c.jdField_a_of_type_Boolean) || (TMSManager.a().b()) || (TextUtils.isEmpty(str)));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(new SimpleFilePresenter.7(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter
 * JD-Core Version:    0.7.0.1
 */