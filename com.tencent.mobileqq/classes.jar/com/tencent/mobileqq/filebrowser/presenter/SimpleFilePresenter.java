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
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  protected SimpleFileBrowserView a;
  private Runnable jdField_a_of_type_JavaLangRunnable = null;
  private boolean jdField_a_of_type_Boolean = false;
  
  public SimpleFilePresenter(IFileBrowserModel paramIFileBrowserModel, Activity paramActivity)
  {
    super(paramIFileBrowserModel, paramActivity);
  }
  
  private void j()
  {
    this.jdField_a_of_type_JavaLangRunnable = new SimpleFilePresenter.2(this);
  }
  
  private void r()
  {
    Object localObject = this.jdField_a_of_type_JavaLangRunnable;
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks((Runnable)localObject);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView;
    if (localObject != null) {
      ((SimpleFileBrowserView)localObject).d(false);
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = simple");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.f(false);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.e(false);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.e(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a());
    if (FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.b())) {
      k();
    } else {
      g();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a(this);
    q();
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
    String str = this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.d();
    if (TextUtils.isEmpty(str)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.d(true);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.c(str);
    if (this.jdField_a_of_type_JavaLangRunnable == null)
    {
      j();
      this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  protected void a(SimpleFileBrowserView paramSimpleFileBrowserView)
  {
    super.a(paramSimpleFileBrowserView);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView = paramSimpleFileBrowserView;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.b(false);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.c(true);
    b(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a());
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.b(true);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.c(false);
    f();
    h();
    r();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.b(true);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.c(false);
    f();
    h();
    if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserListener.a();
    }
    r();
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.c(false);
    f();
    h();
    r();
  }
  
  protected void g()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SimpleFilePresenter handleCloudFile: fileName[");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a());
      localStringBuilder.append("]");
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a() == 5)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.e(2130844325);
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.f(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.e());
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.d(QQFileManagerUtil.c(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a()));
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.c())) && (16 != this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.d())) {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.h(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.c());
    } else {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.g(false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.d() == 16)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.d(BaseApplication.getContext().getString(2131692353));
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.d())
    {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.d(BaseApplication.getContext().getString(2131692559));
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.d(BaseApplication.getContext().getString(2131692353));
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.b())
    {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.f();
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.c(true);
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.b(false);
      b(0.0F);
      return;
    }
    n();
  }
  
  protected void h()
  {
    if ((FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.b())) && (QbSdk.isSuportOpenFile(QQFileManagerUtil.h(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a()), 2)))
    {
      String str = this.jdField_a_of_type_AndroidContentContext.getString(2131694650);
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.b(str, new SimpleFilePresenter.1(this));
    }
  }
  
  public void i()
  {
    r();
    super.i();
  }
  
  protected void k()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SimpleFilePresenter handleLocalFile: fileName[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a());
      ((StringBuilder)localObject).append("] filePath[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.b());
      ((StringBuilder)localObject).append("]");
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.d(QQFileManagerUtil.c(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a()));
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.h(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.b());
    if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.d() == 16)
    {
      localObject = BaseApplication.getContext().getString(2131692353);
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.d((String)localObject);
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.e(true);
    }
    h();
  }
  
  protected void n() {}
  
  protected void p()
  {
    super.p();
    h();
  }
  
  void q()
  {
    if (FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.h(false);
      return;
    }
    String str = KingCardProcessor.c().c.a();
    IKingCardManager localIKingCardManager = ((IVasService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IVasService.class, "")).getKingCardManager();
    if ((NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext)) && (!NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidContentContext)) && (KingCardProcessor.c().c.jdField_a_of_type_Boolean) && (!localIKingCardManager.isKingCard()) && (!TextUtils.isEmpty(str)))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.b(new SimpleFilePresenter.3(this, str));
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewSimpleFileBrowserView.h(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.SimpleFilePresenter
 * JD-Core Version:    0.7.0.1
 */