package com.tencent.mobileqq.filebrowser.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.filebrowser.FileViewMusicService;
import com.tencent.mobileqq.filebrowser.FileViewMusicService.IFileViewMusicEvent;
import com.tencent.mobileqq.filebrowser.IFileBrowserData;
import com.tencent.mobileqq.filebrowser.IFileBrowserListener;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel.OnTransEventListener;
import com.tencent.mobileqq.filebrowser.view.MusicFileBrowserView;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QBrowserUtils;
import com.tencent.mobileqq.mediafocus.MediaFocusManager;
import com.tencent.mobileqq.mediafocus.MediaFocusManager.OnMediaFocusChangeListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;

public class MusicFilePresenter
  extends FileBrowserPresenterBase
  implements FileViewMusicService.IFileViewMusicEvent, IFileBrowserModel.OnTransEventListener
{
  protected FileViewMusicService a;
  private final MusicFileBrowserView jdField_a_of_type_ComTencentMobileqqFilebrowserViewMusicFileBrowserView;
  private final MediaFocusManager.OnMediaFocusChangeListener jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusManager$OnMediaFocusChangeListener = new MusicFilePresenter.1(this);
  private Timer jdField_a_of_type_JavaUtilTimer;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean d = true;
  
  public MusicFilePresenter(IFileBrowserModel paramIFileBrowserModel, Activity paramActivity)
  {
    super(paramIFileBrowserModel, paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewMusicFileBrowserView = new MusicFileBrowserView(paramActivity);
    a(this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewMusicFileBrowserView);
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService.a();
      b(i);
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewMusicFileBrowserView.a(i);
      n();
    }
    else
    {
      q();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewMusicFileBrowserView.e(this.jdField_a_of_type_Boolean);
  }
  
  private boolean b()
  {
    FileViewMusicService localFileViewMusicService = this.jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localFileViewMusicService != null)
    {
      bool1 = bool2;
      if (localFileViewMusicService.b(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.b()))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService.a()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewMusicFileBrowserView.e(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a());
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewMusicFileBrowserView.f(FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a()));
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewMusicFileBrowserView.a();
    f();
    k();
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewMusicFileBrowserView.a(true);
    if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService.b(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.b()))
    {
      b(this.jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService.a());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewMusicFileBrowserView.d(QBrowserUtils.a(0L));
  }
  
  private void h()
  {
    FileManagerReporter.a("0X8004BE0");
    FileViewMusicService localFileViewMusicService = this.jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService;
    if (localFileViewMusicService == null)
    {
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "playMusic error. MusicService is null");
      return;
    }
    if (!localFileViewMusicService.b(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService.a(this);
      if (!this.jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService.a(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.b())) {
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService.b();
    a(true);
    MediaFocusManager.a().a(1, this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusManager$OnMediaFocusChangeListener);
  }
  
  private void j()
  {
    FileManagerReporter.a("0X8004BE1");
    FileViewMusicService localFileViewMusicService = this.jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService;
    if (localFileViewMusicService == null)
    {
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "pauseMusic error. MusicService is null");
      return;
    }
    if (localFileViewMusicService.b(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService.a();
      a(false);
      MediaFocusManager.a().a(this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusManager$OnMediaFocusChangeListener);
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService = FileViewMusicService.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService.a(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.b(), new MusicFilePresenter.5(this));
    if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService.b(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.b())) {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService.a(this);
    }
    a(b());
  }
  
  private void n()
  {
    q();
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimer.scheduleAtFixedRate(new MusicFilePresenter.6(this), 0L, 1000L);
  }
  
  private void q()
  {
    Timer localTimer = this.jdField_a_of_type_JavaUtilTimer;
    if (localTimer != null)
    {
      localTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = music");
    }
    g();
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewMusicFileBrowserView.a(0);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewMusicFileBrowserView.a(new MusicFilePresenter.2(this));
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewMusicFileBrowserView.b(new MusicFilePresenter.3(this));
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a(this);
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
  }
  
  public void a(int paramInt)
  {
    String str = QBrowserUtils.a(paramInt);
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new MusicFilePresenter.4(this, str, paramInt));
  }
  
  public void a(String paramString)
  {
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, this.jdField_a_of_type_AndroidContentContext.getString(2131692698), 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewMusicFileBrowserView.d(QBrowserUtils.a(0L));
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewMusicFileBrowserView.a(0);
    a(false);
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public void ah_()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewMusicFileBrowserView.d(QBrowserUtils.a(0L));
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewMusicFileBrowserView.a(0);
    a(false);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewMusicFileBrowserView.b(false);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewMusicFileBrowserView.c(true);
    b(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a());
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewMusicFileBrowserView.d(QBrowserUtils.a(paramInt));
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewMusicFileBrowserView.b(true);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewMusicFileBrowserView.c(false);
    f();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewMusicFileBrowserView.b(true);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewMusicFileBrowserView.c(false);
    f();
    if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserListener.a();
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewMusicFileBrowserView.b(true);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewMusicFileBrowserView.c(false);
    f();
  }
  
  protected void f()
  {
    super.f();
    if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.c() == 2) {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewMusicFileBrowserView.b(false);
    }
  }
  
  public void i()
  {
    super.i();
    FileViewMusicService localFileViewMusicService = this.jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService;
    if (localFileViewMusicService != null) {
      localFileViewMusicService.a(null);
    }
    q();
    if (this.jdField_a_of_type_Boolean)
    {
      localFileViewMusicService = this.jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService;
      if ((localFileViewMusicService != null) && (localFileViewMusicService.b(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.b()))) {
        this.jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService.c();
      }
    }
    MediaFocusManager.a().b(this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusManager$OnMediaFocusChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService = null;
  }
  
  public void l()
  {
    super.l();
    g();
  }
  
  public void m()
  {
    super.m();
    q();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.MusicFilePresenter
 * JD-Core Version:    0.7.0.1
 */