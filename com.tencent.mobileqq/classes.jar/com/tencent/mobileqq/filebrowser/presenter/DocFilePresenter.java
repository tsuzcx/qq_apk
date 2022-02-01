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
  protected boolean a = true;
  private final DocFileBrowserView k;
  private final TeamWorkFileImportObserver l = new DocFilePresenter.InnerTeamWorkFileImportObserver(this, null);
  private boolean m = false;
  private boolean n = false;
  private boolean o = false;
  private boolean p = false;
  private boolean q = false;
  private final LocalTbsViewManager.LocalTbsViewManagerCallback r = new DocFilePresenter.1(this);
  private boolean s = false;
  
  public DocFilePresenter(IFileBrowserModel paramIFileBrowserModel, Activity paramActivity)
  {
    super(paramIFileBrowserModel, paramActivity);
    this.k = new DocFileBrowserView(paramActivity);
    a(this.k);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (LocalTbsViewManager.a().b())
    {
      LocalTbsViewManager.a().b(true);
      this.c.a(paramInt);
      TeamWorkFileImportInfo localTeamWorkFileImportInfo = this.c.E();
      localTeamWorkFileImportInfo.t = paramBoolean;
      TeamWorkConvertUtils.b(localTeamWorkFileImportInfo);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.m = paramBoolean;
    if (this.g != null) {
      this.g.a(paramBoolean);
    }
    if ((paramBoolean) && (this.k.e()))
    {
      this.k.c();
      return;
    }
    if ((!paramBoolean) && ((this.k.d() != null) || (this.c.F()))) {
      this.k.a(this.c.E());
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    Object localObject = TencentDocLocalCooperationProcessor.a();
    if (paramBoolean) {
      localObject = ((TencentDocLocalCooperationBean)localObject).c;
    } else {
      localObject = ((TencentDocLocalCooperationBean)localObject).e;
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
  
  private void t()
  {
    LocalTbsViewManager.a().b(false);
    if ((this.q) && (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).targetTencentDocFormKeyWords(this.d.c(), this.d.a(), this.d.b())))
    {
      a(13, false);
      return;
    }
    if ((this.q) && (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).supportTencentDocForLocalCooperation(this.d.c(), this.d.a(), this.d.b())))
    {
      a(11, TencentDocLocalCooperationProcessor.a().c(this.d.a()));
      return;
    }
    if (this.c.F())
    {
      TeamWorkFileImportInfo localTeamWorkFileImportInfo = this.c.E();
      TeamWorkConvertUtils.a(localTeamWorkFileImportInfo);
      this.k.a(localTeamWorkFileImportInfo);
    }
  }
  
  public void a()
  {
    super.a();
    i();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 2864)
    {
      TeamWorkFileImportInfo localTeamWorkFileImportInfo;
      if (paramInt2 == 0)
      {
        localTeamWorkFileImportInfo = this.c.E();
        if ((localTeamWorkFileImportInfo != null) && (localTeamWorkFileImportInfo.F != null)) {
          ThreadManager.excute(new DocFilePresenter.2(this, localTeamWorkFileImportInfo), 128, null, false);
        }
      }
      else if (paramInt2 == -1)
      {
        TenDocLogReportHelper.a(null, "0X800A5A4");
        TenDocLogReportHelper.a(null, "0X800A5A3");
        localTeamWorkFileImportInfo = this.c.E();
        if (localTeamWorkFileImportInfo == null) {
          return;
        }
        String str = ((ITeamWorkFileImportHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName())).getUrlFromConvertedMap(localTeamWorkFileImportInfo);
        this.k.a(str, "open");
        Object localObject = paramIntent.getExtras();
        str = ((Bundle)localObject).getString("uin");
        int i = ((Bundle)localObject).getInt("uintype", 0);
        if (localTeamWorkFileImportInfo.F != null)
        {
          localObject = new ArrayList(1);
          ((List)localObject).add(str);
          boolean bool = TencentDocLocalCooperationProcessor.a().b(localTeamWorkFileImportInfo.c);
          a((List)localObject, localTeamWorkFileImportInfo.F, bool, i);
        }
      }
    }
    ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).checkDirectShareChangePolicy(paramInt1, paramInt2, paramIntent, this.c.E());
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
  
  public boolean g()
  {
    return this.a;
  }
  
  void i()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localAppRuntime instanceof AppInterface)) {
      ((AppInterface)localAppRuntime).addObserver(this.l);
    }
  }
  
  public void j()
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localObject instanceof AppInterface)) {
      ((AppInterface)localObject).removeObserver(this.l);
    }
    this.p = true;
    localObject = this.k;
    if (localObject != null)
    {
      ((DocFileBrowserView)localObject).f();
      this.k.b();
    }
    LocalTbsViewManager.a().a(this.e);
    super.j();
  }
  
  protected void k()
  {
    if (this.c.k() == 2) {
      LocalTbsViewManager.a().a(this.e, this.d.c(), this.r, true);
    }
    super.k();
  }
  
  public void l()
  {
    super.l();
    if ((this.n) && (this.q)) {
      this.k.b(this.d.c(), this.r);
    }
    this.n = true;
    this.o = false;
    if (this.c == null) {
      return;
    }
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = this.c.E();
    if (localTeamWorkFileImportInfo == null) {
      return;
    }
    if (localTeamWorkFileImportInfo.d())
    {
      if (!((ITeamWorkFileImportHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName())).isFileImporting(localTeamWorkFileImportInfo)) {
        TeamWorkConvertUtils.a(localTeamWorkFileImportInfo, "DocFilePresenter");
      }
    }
    else if ((localTeamWorkFileImportInfo.c()) && (this.s))
    {
      this.s = false;
      TeamWorkConvertUtils.b(localTeamWorkFileImportInfo);
    }
  }
  
  public void m()
  {
    super.m();
    this.o = true;
  }
  
  protected void n()
  {
    if (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).supportTencentDoc(TencentDocPreviewConfigProcessor.a().a(), this.d.c(), this.d.a(), this.d.b()))
    {
      this.c.a(7);
      TeamWorkConvertUtils.a(this.c.E(), "DocFilePresenter");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.DocFilePresenter
 * JD-Core Version:    0.7.0.1
 */