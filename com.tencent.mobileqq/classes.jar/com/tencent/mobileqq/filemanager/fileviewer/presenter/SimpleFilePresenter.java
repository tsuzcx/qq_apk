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
import com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationProcessor;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.LocalTbsViewManagerCallback;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnTransEventListener;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportObserver;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.config.business.qvip.KingCardConfig;
import com.tencent.mobileqq.vas.config.business.qvip.KingCardConfig.Item;
import com.tencent.mobileqq.vas.config.business.qvip.KingCardProcessor;
import com.tencent.mobileqq.vip.TMSManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import java.util.ArrayList;
import java.util.List;

public class SimpleFilePresenter
  extends FileBrowserPresenterBase
  implements FileBrowserModelBase.OnTransEventListener
{
  private Runnable a = null;
  private boolean b = false;
  protected boolean j = true;
  protected SimpleFileViewer k = new SimpleFileViewer(this.d);
  private volatile boolean l = false;
  private boolean m = false;
  private boolean n = false;
  private boolean o = false;
  private boolean p = false;
  private boolean q = false;
  private boolean r = false;
  private boolean s = false;
  private Handler t = new Handler();
  private TeamWorkFileImportObserver u = new SimpleFilePresenter.InnerTeamWorkFileImportObserver(this, null);
  private LocalTbsViewManager.LocalTbsViewManagerCallback v = new SimpleFilePresenter.5(this);
  
  public SimpleFilePresenter(FileBrowserModelBase paramFileBrowserModelBase, Activity paramActivity)
  {
    super(paramFileBrowserModelBase, paramActivity);
    a(this.k);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface)) && (LocalTbsViewManager.a().b()))
    {
      LocalTbsViewManager.a().b(true);
      this.c.d(paramInt);
      TeamWorkFileImportInfo localTeamWorkFileImportInfo = this.c.U();
      localTeamWorkFileImportInfo.t = paramBoolean;
      TeamWorkConvertUtils.b(localTeamWorkFileImportInfo);
    }
  }
  
  private final void a(boolean paramBoolean)
  {
    if (this.f != null) {
      this.f.a(paramBoolean);
    }
    if ((this.k.g()) && (paramBoolean))
    {
      this.k.e();
      return;
    }
    if (((this.k.f() != null) || (this.c.V())) && (!paramBoolean) && ((!this.n) || (this.o))) {
      this.k.b(this.c.U());
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
  
  private void v()
  {
    this.a = new SimpleFilePresenter.3(this);
  }
  
  private void w()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      this.t.removeCallbacks((Runnable)localObject);
      this.a = null;
    }
    localObject = this.k;
    if (localObject != null) {
      ((SimpleFileViewer)localObject).b(8);
    }
    this.b = true;
  }
  
  private final void x()
  {
    LocalTbsViewManager.a().b(false);
    if ((((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).targetTencentDocFormKeyWords(this.c.y(), this.c.v(), this.c.x())) && (this.m))
    {
      a(13, false);
      return;
    }
    if ((((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).supportTencentDocForLocalCooperation(this.c.y(), this.c.v(), this.c.x())) && (this.m))
    {
      a(11, TencentDocLocalCooperationProcessor.a().c(this.c.v()));
      return;
    }
    if (this.c.V())
    {
      TeamWorkFileImportInfo localTeamWorkFileImportInfo = this.c.U();
      TeamWorkConvertUtils.a(localTeamWorkFileImportInfo);
      if ((!this.n) || (this.o)) {
        this.k.b(localTeamWorkFileImportInfo);
      }
    }
  }
  
  public void a()
  {
    if (this.l)
    {
      this.l = false;
      return;
    }
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = simple");
    }
    this.k.d(false);
    this.k.c(false);
    if ((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface)) {
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(this.u);
    }
    this.k.d(this.c.v());
    if (FileManagerUtil.s(this.c.y())) {
      j();
    } else {
      cm_();
    }
    this.c.a(this);
    u();
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
    String str = this.c.Y();
    if (TextUtils.isEmpty(str)) {
      return;
    }
    this.k.b(0);
    this.k.b(str);
    if (this.a == null)
    {
      v();
      this.t.post(this.a);
      this.b = false;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 2864)
    {
      Object localObject1;
      if (paramInt2 == 0)
      {
        localObject1 = this.c.U();
        if ((localObject1 != null) && (((TeamWorkFileImportInfo)localObject1).F != null)) {
          ThreadManager.excute(new SimpleFilePresenter.1(this, (TeamWorkFileImportInfo)localObject1), 128, null, false);
        }
      }
      else if (paramInt2 == -1)
      {
        TenDocLogReportHelper.a(null, "0X800A5A4");
        TenDocLogReportHelper.a(null, "0X800A5A3");
        localObject1 = BaseApplicationImpl.sApplication.getRuntime();
        if ((localObject1 instanceof QQAppInterface))
        {
          Object localObject2 = (ITeamWorkFileImportHandler)((QQAppInterface)localObject1).getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_FILE_IMPORT_HANDLER);
          localObject1 = this.c.U();
          if (localObject2 != null)
          {
            if (localObject1 == null) {
              return;
            }
            localObject2 = ((ITeamWorkFileImportHandler)localObject2).getUrlFromConvertedMap((TeamWorkFileImportInfo)localObject1);
            this.k.a((String)localObject2, "open");
            Object localObject3 = paramIntent.getExtras();
            localObject2 = ((Bundle)localObject3).getString("uin");
            int i = ((Bundle)localObject3).getInt("uintype", 0);
            if ((localObject1 != null) && (((TeamWorkFileImportInfo)localObject1).F != null))
            {
              localObject3 = new ArrayList(1);
              ((List)localObject3).add(localObject2);
              boolean bool = TencentDocLocalCooperationProcessor.a().b(((TeamWorkFileImportInfo)localObject1).c);
              a((List)localObject3, ((TeamWorkFileImportInfo)localObject1).F, bool, i);
            }
          }
          else
          {
            return;
          }
        }
      }
    }
    ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).checkDirectShareChangePolicy(paramInt1, paramInt2, paramIntent, this.c.U());
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    paramConfiguration = new DisplayMetrics();
    this.d.getWindowManager().getDefaultDisplay().getMetrics(paramConfiguration);
    int i = paramConfiguration.widthPixels;
    int i1 = paramConfiguration.heightPixels;
    this.k.a(i, i1);
  }
  
  public void a(List<String> paramList, String paramString, boolean paramBoolean, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramList == null) {
        return;
      }
      ThreadManager.excute(new SimpleFilePresenter.2(this, paramString, paramBoolean, paramInt, paramList), 128, null, false);
    }
  }
  
  public boolean b()
  {
    return (this.j) && (!this.n);
  }
  
  public boolean c()
  {
    if (this.n) {
      this.d.setRequestedOrientation(4);
    } else if (this.j) {
      this.d.setRequestedOrientation(1);
    }
    return (!this.j) && (!this.n);
  }
  
  protected void cm_()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SimpleFilePresenter handleCloudFile: fileName[");
      localStringBuilder.append(this.c.v());
      localStringBuilder.append("]");
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, localStringBuilder.toString());
    }
    if (this.c.z() == 5)
    {
      this.k.d(2130845642);
      this.k.e(this.c.E());
    }
    else
    {
      this.k.c(FileManagerUtil.i(this.c.v()));
    }
    if ((!TextUtils.isEmpty(this.c.I())) && (16 != this.c.b())) {
      this.k.g(this.c.I());
    } else {
      this.k.e(false);
    }
    if (this.c.b() == 16)
    {
      this.k.c(BaseApplicationImpl.getContext().getString(2131889341));
      this.k.c(true);
      return;
    }
    if (this.c.F())
    {
      this.k.c(BaseApplicationImpl.getContext().getString(2131889582));
      this.k.c(true);
      return;
    }
    if (this.c.G())
    {
      this.k.c(BaseApplicationImpl.getContext().getString(2131889341));
      this.k.c(true);
      return;
    }
    if (this.c.P())
    {
      if (this.c.f() != null)
      {
        this.c.f().a();
        this.k.b(true);
        this.k.a(false);
        b(0.0F);
      }
    }
    else if (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).supportTencentDocForPreview(this.c.y(), this.c.v(), this.c.x()))
    {
      this.c.d(7);
      TeamWorkConvertUtils.a(this.c.U(), "SimpleFilePresenter<FileAssistant>");
    }
  }
  
  public void d()
  {
    this.k.a(false);
    this.k.b(true);
    b(this.c.J());
    int i = this.c.O();
    if ((i != 1) && (i == 4)) {}
  }
  
  public void e()
  {
    this.k.a(true);
    this.k.b(false);
    h();
    i();
    w();
  }
  
  public void f()
  {
    this.k.a(true);
    this.k.b(false);
    h();
    i();
    if (this.e != null) {
      this.e.b();
    }
    w();
  }
  
  public void g()
  {
    this.k.b(false);
    h();
    i();
    w();
  }
  
  protected void i()
  {
    if ((FileUtils.fileExistsAndNotEmpty(this.c.y())) && (QbSdk.isSuportOpenFile(FileManagerUtil.t(this.c.v()), 2)))
    {
      String str = this.d.getString(2131892336);
      this.k.b(str, new SimpleFilePresenter.4(this));
    }
  }
  
  protected void j()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SimpleFilePresenter handleLocalFile: fileName[");
      ((StringBuilder)localObject).append(this.c.v());
      ((StringBuilder)localObject).append("] filePath[");
      ((StringBuilder)localObject).append(this.c.y());
      ((StringBuilder)localObject).append("]");
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    if (this.c.R() == 2) {
      LocalTbsViewManager.a().a(this.d, this.c.y(), this.v, true);
    }
    this.k.c(FileManagerUtil.i(this.c.v()));
    this.k.g(this.c.D());
    this.d.getString(2131889341);
    if (this.c.b() == 16)
    {
      localObject = BaseApplicationImpl.getContext().getString(2131889341);
      this.k.c((String)localObject);
      this.k.c(true);
    }
    i();
  }
  
  public void k()
  {
    if ((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface)) {
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.u);
    }
    this.q = true;
    SimpleFileViewer localSimpleFileViewer = this.k;
    if (localSimpleFileViewer != null)
    {
      localSimpleFileViewer.h();
      this.k.i();
    }
    LocalTbsViewManager.a().a(this.d);
    w();
    super.k();
  }
  
  public void l()
  {
    super.l();
    this.s = true;
  }
  
  public void m()
  {
    super.m();
    if ((this.p) && (this.m)) {
      this.k.b(this.c.y(), this.v);
    }
    this.p = true;
    this.s = false;
    if ((this.c != null) && (this.c.U() != null))
    {
      TeamWorkFileImportInfo localTeamWorkFileImportInfo = this.c.U();
      if (localTeamWorkFileImportInfo.d())
      {
        if ((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface))
        {
          ITeamWorkFileImportHandler localITeamWorkFileImportHandler = (ITeamWorkFileImportHandler)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_FILE_IMPORT_HANDLER);
          if ((localITeamWorkFileImportHandler != null) && (!localITeamWorkFileImportHandler.isFileImporting(localTeamWorkFileImportInfo))) {
            TeamWorkConvertUtils.a(localTeamWorkFileImportInfo, "SimpleFilePresenter<FileAssistant>");
          }
        }
      }
      else if ((localTeamWorkFileImportInfo.c()) && (this.r))
      {
        this.r = false;
        TeamWorkConvertUtils.b(localTeamWorkFileImportInfo);
      }
    }
  }
  
  protected void p()
  {
    super.p();
    i();
  }
  
  protected void u()
  {
    if (FileUtils.fileExistsAndNotEmpty(this.c.y()))
    {
      this.k.g(false);
      return;
    }
    String str = KingCardProcessor.e().c.a();
    if ((NetworkUtil.isNetworkAvailable(this.d)) && (!NetworkUtil.isWifiConnected(this.d)) && (KingCardProcessor.e().c.a) && (!TMSManager.a().d()) && (!TextUtils.isEmpty(str))) {
      this.k.b(new SimpleFilePresenter.6(this, str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter
 * JD-Core Version:    0.7.0.1
 */