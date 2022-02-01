package com.tencent.mobileqq.filebrowser.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocPreviewConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocPreviewConfigProcessor;
import com.tencent.mobileqq.filebrowser.IFileBrowserData;
import com.tencent.mobileqq.filebrowser.IFileBrowserListener;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.view.DocFileBrowserView;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.LocalTbsViewManagerCallback;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportObserver;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class DocFilePresenter
  extends SimpleFilePresenter
{
  private final DocFileBrowserView jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView;
  private final LocalTbsViewManager.LocalTbsViewManagerCallback jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewLocalTbsViewManager$LocalTbsViewManagerCallback = new DocFilePresenter.1(this);
  private final TeamWorkFileImportObserver jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportObserver = new DocFilePresenter.InnerTeamWorkFileImportObserver(this, null);
  protected boolean a;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  
  public DocFilePresenter(IFileBrowserModel paramIFileBrowserModel, Activity paramActivity)
  {
    super(paramIFileBrowserModel, paramActivity);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView = new DocFileBrowserView(paramActivity);
    a(this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (LocalTbsViewManager.a().a())
    {
      LocalTbsViewManager.a().b(true);
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a(paramInt);
      TeamWorkFileImportInfo localTeamWorkFileImportInfo = this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a();
      localTeamWorkFileImportInfo.g = paramBoolean;
      TeamWorkConvertUtils.b(localTeamWorkFileImportInfo);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserListener.a(paramBoolean);
    }
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.c();
      return;
    }
    if ((!paramBoolean) && ((this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.a() != null) || (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.f()))) {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.a(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a());
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    Object localObject = TencentDocLocalCooperationProcessor.a();
    if (paramBoolean) {
      localObject = ((TencentDocLocalCooperationBean)localObject).a;
    } else {
      localObject = ((TencentDocLocalCooperationBean)localObject).c;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if ((paramInt != 1) && (paramInt != 3000))
      {
        if (paramInt == 0) {
          paramInt = 0;
        } else {
          paramInt = 3;
        }
      }
      else {
        paramInt = 1;
      }
      ReportController.b(null, "dc00898", "", "", (String)localObject, (String)localObject, paramInt, 0, "", "", "", "");
    }
  }
  
  private void r()
  {
    LocalTbsViewManager.a().b(false);
    if ((this.h) && (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).targetTencentDocFormKeyWords(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.b(), this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a(), this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a())))
    {
      a(13, false);
      return;
    }
    if ((this.h) && (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).supportTencentDocForLocalCooperation(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.b(), this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a(), this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a())))
    {
      a(11, TencentDocLocalCooperationProcessor.a().b(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a()));
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.f())
    {
      TeamWorkFileImportInfo localTeamWorkFileImportInfo = this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a();
      TeamWorkConvertUtils.a(localTeamWorkFileImportInfo);
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.a(localTeamWorkFileImportInfo);
    }
  }
  
  public void a()
  {
    super.a();
    j();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 2864)
    {
      TeamWorkFileImportInfo localTeamWorkFileImportInfo;
      if (paramInt2 == 0)
      {
        localTeamWorkFileImportInfo = this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a();
        if ((localTeamWorkFileImportInfo != null) && (localTeamWorkFileImportInfo.m != null)) {
          ThreadManager.excute(new DocFilePresenter.2(this, localTeamWorkFileImportInfo), 128, null, false);
        }
      }
      else if (paramInt2 == -1)
      {
        TenDocLogReportHelper.a(null, "0X800A5A4");
        TenDocLogReportHelper.a(null, "0X800A5A3");
        localTeamWorkFileImportInfo = this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a();
        if (localTeamWorkFileImportInfo == null) {
          return;
        }
        String str = ((ITeamWorkFileImportHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName())).getUrlFromConvertedMap(localTeamWorkFileImportInfo);
        this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.a(str, "open");
        Object localObject = paramIntent.getExtras();
        str = ((Bundle)localObject).getString("uin");
        int j = ((Bundle)localObject).getInt("uintype", 0);
        if (localTeamWorkFileImportInfo.m != null)
        {
          localObject = new ArrayList(1);
          ((List)localObject).add(str);
          boolean bool = TencentDocLocalCooperationProcessor.a().a(localTeamWorkFileImportInfo.b);
          a((List)localObject, localTeamWorkFileImportInfo.m, bool, j);
        }
      }
    }
    ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).checkDirectShareChangePolicy(paramInt1, paramInt2, paramIntent, this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a());
  }
  
  public void a(List<String> paramList, String paramString, boolean paramBoolean, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramList == null) {
        return;
      }
      ThreadManager.excute(new DocFilePresenter.3(this, paramString, paramBoolean, paramInt, paramList), 128, null, false);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void i()
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localObject instanceof AppInterface)) {
      ((AppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportObserver);
    }
    this.g = true;
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView;
    if (localObject != null)
    {
      ((DocFileBrowserView)localObject).d();
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.b();
    }
    LocalTbsViewManager.a().a(this.jdField_a_of_type_AndroidAppActivity);
    super.i();
  }
  
  void j()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localAppRuntime instanceof AppInterface)) {
      ((AppInterface)localAppRuntime).addObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportObserver);
    }
  }
  
  protected void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.c() == 2) {
      LocalTbsViewManager.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.b(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewLocalTbsViewManager$LocalTbsViewManagerCallback, true);
    }
    super.k();
  }
  
  public void l()
  {
    super.l();
    if ((this.e) && (this.h)) {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.b(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.b(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewLocalTbsViewManager$LocalTbsViewManagerCallback);
    }
    this.e = true;
    this.f = false;
    if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel == null) {
      return;
    }
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a();
    if (localTeamWorkFileImportInfo == null) {
      return;
    }
    if (localTeamWorkFileImportInfo.d())
    {
      if (!((ITeamWorkFileImportHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName())).isFileImporting(localTeamWorkFileImportInfo)) {
        TeamWorkConvertUtils.a(localTeamWorkFileImportInfo, "DocFilePresenter");
      }
    }
    else if ((localTeamWorkFileImportInfo.c()) && (this.i))
    {
      this.i = false;
      TeamWorkConvertUtils.b(localTeamWorkFileImportInfo);
    }
  }
  
  public void m()
  {
    super.m();
    this.f = true;
  }
  
  protected void n()
  {
    if (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).supportTencentDoc(TencentDocPreviewConfigProcessor.a().a(), this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.b(), this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a(), this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a(7);
      TeamWorkConvertUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a(), "DocFilePresenter");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.DocFilePresenter
 * JD-Core Version:    0.7.0.1
 */