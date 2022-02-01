package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.filebrowser.FileViewMusicService;
import com.tencent.mobileqq.filebrowser.FileViewMusicService.IFileViewMusicEvent;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
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
  implements FileViewMusicService.IFileViewMusicEvent, FileBrowserModelBase.OnTransEventListener
{
  protected MusicFileViewer a;
  protected FileViewMusicService b;
  private String j;
  private Timer k;
  private boolean l = false;
  private boolean m = true;
  private MediaFocusManager.OnMediaFocusChangeListener n = new MusicFilePresenter.6(this);
  
  public MusicFilePresenter(FileBrowserModelBase paramFileBrowserModelBase, Activity paramActivity)
  {
    super(paramFileBrowserModelBase, paramActivity);
    this.a = new MusicFileViewer(paramActivity);
    a(this.a);
  }
  
  private void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
    if (this.l)
    {
      int i = this.b.b();
      b(i);
      this.a.c(i);
      x();
    }
    else
    {
      y();
    }
    this.a.d(this.l);
  }
  
  private void j()
  {
    this.a.e(this.c.v());
    this.a.f(FileUtil.a(this.c.x()));
    this.a.e();
    h();
    this.j = this.c.y();
    i();
    this.a.c(true);
    if (this.b.b(this.j))
    {
      b(this.b.b());
      return;
    }
    this.a.d(QFileUtils.a(0L));
  }
  
  private void u()
  {
    FileManagerReporter.a("0X8004BE0");
    FileViewMusicService localFileViewMusicService = this.b;
    if (localFileViewMusicService == null)
    {
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "playMusic error. MusicService is null");
      return;
    }
    if (!localFileViewMusicService.b(this.j))
    {
      this.b.a(this);
      if (!this.b.a(this.j)) {
        return;
      }
    }
    this.b.e();
    a(true);
    MediaFocusManager.b().a(1, this.n);
  }
  
  private void v()
  {
    FileManagerReporter.a("0X8004BE1");
    FileViewMusicService localFileViewMusicService = this.b;
    if (localFileViewMusicService == null)
    {
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "pauseMusic error. MusicService is null");
      return;
    }
    if (localFileViewMusicService.b(this.j))
    {
      this.b.d();
      a(false);
      MediaFocusManager.b().a(this.n);
    }
  }
  
  private boolean w()
  {
    FileViewMusicService localFileViewMusicService = this.b;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localFileViewMusicService != null)
    {
      bool1 = bool2;
      if (localFileViewMusicService.b(this.j))
      {
        bool1 = bool2;
        if (this.b.c()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void x()
  {
    y();
    this.k = new Timer();
    this.k.scheduleAtFixedRate(new MusicFilePresenter.5(this), 0L, 1000L);
  }
  
  private void y()
  {
    Timer localTimer = this.k;
    if (localTimer != null)
    {
      localTimer.cancel();
      this.k = null;
    }
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = music");
    }
    j();
    this.a.c(0);
    this.a.a(new MusicFilePresenter.1(this));
    this.a.b(new MusicFilePresenter.2(this));
    this.c.a(this);
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
  }
  
  public void a(int paramInt)
  {
    String str = QFileUtils.a(paramInt);
    this.d.runOnUiThread(new MusicFilePresenter.3(this, str, paramInt));
  }
  
  public void a(String paramString)
  {
    QQToast.makeText(this.d, 0, this.d.getString(2131889769), 1).show(this.d.getResources().getDimensionPixelSize(2131299920));
    this.a.d(QFileUtils.a(0L));
    this.a.c(0);
    a(false);
  }
  
  public void b(int paramInt)
  {
    this.a.d(QFileUtils.a(paramInt));
  }
  
  public boolean b()
  {
    return this.m;
  }
  
  public boolean c()
  {
    this.d.setRequestedOrientation(1);
    return false;
  }
  
  public void cf_()
  {
    this.a.d(QFileUtils.a(0L));
    this.a.c(0);
    a(false);
  }
  
  public void d()
  {
    this.a.a(false);
    this.a.b(true);
    b(this.c.J());
  }
  
  public void e()
  {
    this.a.a(true);
    this.a.b(false);
    h();
  }
  
  public void f()
  {
    this.a.a(true);
    this.a.b(false);
    h();
    if (this.e != null) {
      this.e.b();
    }
  }
  
  public void g()
  {
    this.a.a(true);
    this.a.b(false);
    h();
  }
  
  protected void h()
  {
    super.h();
    if (this.c.R() == 2) {
      this.a.a(false);
    }
  }
  
  public void i()
  {
    this.j = this.c.y();
    if (this.b == null) {
      this.b = FileViewMusicService.a();
    }
    this.b.a(this.j, new MusicFilePresenter.4(this));
    if (this.b.b(this.j)) {
      this.b.a(this);
    }
    if (this.c.q()) {
      u();
    }
    a(w());
  }
  
  public void k()
  {
    super.k();
    FileViewMusicService localFileViewMusicService = this.b;
    if (localFileViewMusicService != null) {
      localFileViewMusicService.a(null);
    }
    y();
    if (this.l)
    {
      localFileViewMusicService = this.b;
      if ((localFileViewMusicService != null) && (localFileViewMusicService.b(this.j))) {
        this.b.f();
      }
    }
    MediaFocusManager.b().b(this.n);
    this.b = null;
  }
  
  public void l()
  {
    super.l();
    y();
  }
  
  public void m()
  {
    super.m();
    j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter
 * JD-Core Version:    0.7.0.1
 */