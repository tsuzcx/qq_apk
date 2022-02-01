package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewMusicEvent;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnTransEventListener;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.MusicFileViewer;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.mediafocus.MediaFocusManager;
import com.tencent.mobileqq.mediafocus.MediaFocusManager.OnMediaFocusChangeListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;

public class MusicFilePresenter
  extends FileBrowserPresenterBase
  implements IFileViewMusicEvent, FileBrowserModelBase.OnTransEventListener
{
  protected FileViewMusicService a;
  protected MusicFileViewer a;
  private MediaFocusManager.OnMediaFocusChangeListener jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusManager$OnMediaFocusChangeListener = new MusicFilePresenter.6(this);
  private String jdField_a_of_type_JavaLangString;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean d = true;
  
  public MusicFilePresenter(FileBrowserModelBase paramFileBrowserModelBase, Activity paramActivity)
  {
    super(paramFileBrowserModelBase, paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerMusicFileViewer = new MusicFileViewer(paramActivity);
    a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerMusicFileViewer);
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a();
      b(i);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerMusicFileViewer.c(i);
      s();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerMusicFileViewer.d(this.jdField_a_of_type_Boolean);
      return;
      t();
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerMusicFileViewer.e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerMusicFileViewer.f(FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.c()));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerMusicFileViewer.c();
    h();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d();
    b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerMusicFileViewer.c(true);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b(this.jdField_a_of_type_JavaLangString))
    {
      b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerMusicFileViewer.d(QFileUtils.a(0L));
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b(this.jdField_a_of_type_JavaLangString))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void q()
  {
    FileManagerReporter.a("0X8004BE0");
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService == null) {
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "playMusic error. MusicService is null");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b(this.jdField_a_of_type_JavaLangString)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a(this);
    } while (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a(this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b();
    a(true);
    MediaFocusManager.a().a(1, this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusManager$OnMediaFocusChangeListener);
  }
  
  private void r()
  {
    FileManagerReporter.a("0X8004BE1");
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService == null) {
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "pauseMusic error. MusicService is null");
    }
    while (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a();
    a(false);
    MediaFocusManager.a().a(this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusManager$OnMediaFocusChangeListener);
  }
  
  private void s()
  {
    t();
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimer.scheduleAtFixedRate(new MusicFilePresenter.5(this), 0L, 1000L);
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = music");
    }
    c();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerMusicFileViewer.c(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerMusicFileViewer.a(new MusicFilePresenter.1(this));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerMusicFileViewer.b(new MusicFilePresenter.2(this));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a(this);
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
  }
  
  public void a(int paramInt)
  {
    String str = QFileUtils.a(paramInt);
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new MusicFilePresenter.3(this, str, paramInt));
  }
  
  public void a(String paramString)
  {
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 0, this.jdField_a_of_type_AndroidAppActivity.getString(2131692741), 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299166));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerMusicFileViewer.d(QFileUtils.a(0L));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerMusicFileViewer.c(0);
    a(false);
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public void at_()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerMusicFileViewer.d(QFileUtils.a(0L));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerMusicFileViewer.c(0);
    a(false);
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService = FileViewMusicService.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a(this.jdField_a_of_type_JavaLangString, new MusicFilePresenter.4(this));
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b()) {
      q();
    }
    a(c());
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerMusicFileViewer.d(QFileUtils.a(paramInt));
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerMusicFileViewer.a(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerMusicFileViewer.b(true);
    b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a());
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerMusicFileViewer.a(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerMusicFileViewer.b(false);
    h();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerMusicFileViewer.a(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerMusicFileViewer.b(false);
    h();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerMusicFileViewer.a(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerMusicFileViewer.b(false);
    h();
  }
  
  protected void h()
  {
    super.h();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.i() == 2) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerMusicFileViewer.a(false);
    }
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a(null);
    }
    t();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.b(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.c();
    }
    MediaFocusManager.a().b(this.jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusManager$OnMediaFocusChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService = null;
  }
  
  public void j()
  {
    super.j();
    t();
  }
  
  public void k()
  {
    super.k();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter
 * JD-Core Version:    0.7.0.1
 */