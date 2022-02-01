package com.tencent.mobileqq.filebrowser.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.filebrowser.IFileBrowserData;
import com.tencent.mobileqq.filebrowser.IFileBrowserListener;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel.OnTransEventListener;
import com.tencent.mobileqq.filebrowser.view.SimpleFileBrowserView;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.config.business.qvip.KingCardConfig;
import com.tencent.mobileqq.vas.config.business.qvip.KingCardConfig.Item;
import com.tencent.mobileqq.vas.config.business.qvip.KingCardProcessor;
import com.tencent.mobileqq.vas.manager.api.IKingCardManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class SimpleFilePresenter
  extends FileBrowserPresenterBase
  implements IFileBrowserModel.OnTransEventListener
{
  private final Handler a = new Handler();
  protected SimpleFileBrowserView b;
  private Runnable k = null;
  private boolean l = false;
  
  public SimpleFilePresenter(IFileBrowserModel paramIFileBrowserModel, Activity paramActivity)
  {
    super(paramIFileBrowserModel, paramActivity);
  }
  
  private void i()
  {
    this.k = new SimpleFilePresenter.2(this);
  }
  
  private void t()
  {
    Object localObject = this.k;
    if (localObject != null)
    {
      this.a.removeCallbacks((Runnable)localObject);
      this.k = null;
    }
    localObject = this.b;
    if (localObject != null) {
      ((SimpleFileBrowserView)localObject).d(false);
    }
    this.l = true;
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = simple");
    }
    this.b.f(false);
    this.b.e(false);
    this.b.e(this.d.a());
    if (FileUtil.b(this.d.c())) {
      k();
    } else {
      ce_();
    }
    this.c.a(this);
    s();
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
    String str = this.c.m();
    if (TextUtils.isEmpty(str)) {
      return;
    }
    this.b.d(true);
    this.b.c(str);
    if (this.k == null)
    {
      i();
      this.a.post(this.k);
      this.l = false;
    }
  }
  
  protected void a(SimpleFileBrowserView paramSimpleFileBrowserView)
  {
    super.a(paramSimpleFileBrowserView);
    this.b = paramSimpleFileBrowserView;
  }
  
  public void b()
  {
    this.b.b(false);
    this.b.c(true);
    b(this.c.l());
  }
  
  public void c()
  {
    this.b.b(true);
    this.b.c(false);
    f();
    h();
    t();
  }
  
  protected void ce_()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SimpleFilePresenter handleCloudFile: fileName[");
      localStringBuilder.append(this.d.a());
      localStringBuilder.append("]");
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, localStringBuilder.toString());
    }
    if (this.d.d() == 5)
    {
      this.b.e(2130845642);
      this.b.f(this.d.j());
    }
    else
    {
      this.b.d(QQFileManagerUtil.q(this.d.a()));
    }
    if ((!TextUtils.isEmpty(this.c.i())) && (16 != this.d.g())) {
      this.b.h(this.c.i());
    } else {
      this.b.g(false);
    }
    if (this.d.g() == 16)
    {
      this.b.d(BaseApplication.getContext().getString(2131889341));
      return;
    }
    if (this.c.p())
    {
      this.b.d(BaseApplication.getContext().getString(2131889582));
      return;
    }
    if (this.c.j())
    {
      this.b.d(BaseApplication.getContext().getString(2131889341));
      return;
    }
    if (this.c.n())
    {
      this.c.y();
      this.b.c(true);
      this.b.b(false);
      b(0.0F);
      return;
    }
    n();
  }
  
  public void d()
  {
    this.b.b(true);
    this.b.c(false);
    f();
    h();
    if (this.g != null) {
      this.g.a();
    }
    t();
  }
  
  public void e()
  {
    this.b.c(false);
    f();
    h();
    t();
  }
  
  public boolean g()
  {
    return true;
  }
  
  protected void h()
  {
    if ((FileUtils.fileExistsAndNotEmpty(this.d.c())) && (QbSdk.isSuportOpenFile(QQFileManagerUtil.y(this.d.a()), 2)))
    {
      String str = this.f.getString(2131892336);
      this.b.b(str, new SimpleFilePresenter.1(this));
    }
  }
  
  public void j()
  {
    t();
    super.j();
  }
  
  protected void k()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SimpleFilePresenter handleLocalFile: fileName[");
      ((StringBuilder)localObject).append(this.d.a());
      ((StringBuilder)localObject).append("] filePath[");
      ((StringBuilder)localObject).append(this.d.c());
      ((StringBuilder)localObject).append("]");
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    this.b.d(QQFileManagerUtil.q(this.d.a()));
    this.b.h(this.c.h());
    if (this.d.g() == 16)
    {
      localObject = BaseApplication.getContext().getString(2131889341);
      this.b.d((String)localObject);
      this.b.e(true);
    }
    h();
  }
  
  protected void n() {}
  
  protected void q()
  {
    super.q();
    h();
  }
  
  void s()
  {
    if (FileUtils.fileExistsAndNotEmpty(this.d.c()))
    {
      this.b.h(false);
      return;
    }
    String str = KingCardProcessor.e().c.a();
    IKingCardManager localIKingCardManager = ((IVasService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IVasService.class, "")).getKingCardManager();
    if ((NetworkUtil.isNetworkAvailable(this.f)) && (!NetworkUtil.isWifiConnected(this.f)) && (KingCardProcessor.e().c.a) && (!localIKingCardManager.isKingCard()) && (!TextUtils.isEmpty(str)))
    {
      this.b.b(new SimpleFilePresenter.3(this, str));
      this.b.h(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.SimpleFilePresenter
 * JD-Core Version:    0.7.0.1
 */