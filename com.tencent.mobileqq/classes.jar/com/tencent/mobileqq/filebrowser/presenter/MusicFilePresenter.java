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
  private final MusicFileBrowserView b;
  private Timer k;
  private boolean l = false;
  private final MediaFocusManager.OnMediaFocusChangeListener m = new MusicFilePresenter.1(this);
  private boolean n = true;
  
  public MusicFilePresenter(IFileBrowserModel paramIFileBrowserModel, Activity paramActivity)
  {
    super(paramIFileBrowserModel, paramActivity);
    this.b = new MusicFileBrowserView(paramActivity);
    a(this.b);
  }
  
  private void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
    if (this.l)
    {
      int i = this.a.b();
      b(i);
      this.b.a(i);
      t();
    }
    else
    {
      u();
    }
    this.b.e(this.l);
  }
  
  private void h()
  {
    this.b.e(this.d.a());
    this.b.f(FileUtil.a(this.d.b()));
    this.b.a();
    f();
    n();
    this.b.a(true);
    if (this.a.b(this.d.c()))
    {
      b(this.a.b());
      return;
    }
    this.b.d(QBrowserUtils.b(0L));
  }
  
  private void i()
  {
    FileManagerReporter.a("0X8004BE0");
    FileViewMusicService localFileViewMusicService = this.a;
    if (localFileViewMusicService == null)
    {
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "playMusic error. MusicService is null");
      return;
    }
    if (!localFileViewMusicService.b(this.d.c()))
    {
      this.a.a(this);
      if (!this.a.a(this.d.c())) {
        return;
      }
    }
    this.a.e();
    a(true);
    MediaFocusManager.b().a(1, this.m);
  }
  
  private void k()
  {
    FileManagerReporter.a("0X8004BE1");
    FileViewMusicService localFileViewMusicService = this.a;
    if (localFileViewMusicService == null)
    {
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "pauseMusic error. MusicService is null");
      return;
    }
    if (localFileViewMusicService.b(this.d.c()))
    {
      this.a.d();
      a(false);
      MediaFocusManager.b().a(this.m);
    }
  }
  
  private void n()
  {
    if (this.a == null) {
      this.a = FileViewMusicService.a();
    }
    this.a.a(this.d.c(), new MusicFilePresenter.5(this));
    if (this.a.b(this.d.c())) {
      this.a.a(this);
    }
    a(s());
  }
  
  private boolean s()
  {
    FileViewMusicService localFileViewMusicService = this.a;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localFileViewMusicService != null)
    {
      bool1 = bool2;
      if (localFileViewMusicService.b(this.d.c()))
      {
        bool1 = bool2;
        if (this.a.c()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void t()
  {
    u();
    this.k = new Timer();
    this.k.scheduleAtFixedRate(new MusicFilePresenter.6(this), 0L, 1000L);
  }
  
  private void u()
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
    h();
    this.b.a(0);
    this.b.a(new MusicFilePresenter.2(this));
    this.b.b(new MusicFilePresenter.3(this));
    this.c.a(this);
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
  }
  
  public void a(int paramInt)
  {
    String str = QBrowserUtils.b(paramInt);
    this.e.runOnUiThread(new MusicFilePresenter.4(this, str, paramInt));
  }
  
  public void a(String paramString)
  {
    QQToast.makeText(this.f, 0, this.f.getString(2131889769), 1).show(this.f.getResources().getDimensionPixelSize(2131299920));
    this.b.d(QBrowserUtils.b(0L));
    this.b.a(0);
    a(false);
  }
  
  public void b()
  {
    this.b.b(false);
    this.b.c(true);
    b(this.c.l());
  }
  
  public void b(int paramInt)
  {
    this.b.d(QBrowserUtils.b(paramInt));
  }
  
  public void c()
  {
    this.b.b(true);
    this.b.c(false);
    f();
  }
  
  public void cf_()
  {
    this.b.d(QBrowserUtils.b(0L));
    this.b.a(0);
    a(false);
  }
  
  public void d()
  {
    this.b.b(true);
    this.b.c(false);
    f();
    if (this.g != null) {
      this.g.a();
    }
  }
  
  public void e()
  {
    this.b.b(true);
    this.b.c(false);
    f();
  }
  
  protected void f()
  {
    super.f();
    if (this.c.k() == 2) {
      this.b.b(false);
    }
  }
  
  public boolean g()
  {
    return this.n;
  }
  
  public void j()
  {
    super.j();
    FileViewMusicService localFileViewMusicService = this.a;
    if (localFileViewMusicService != null) {
      localFileViewMusicService.a(null);
    }
    u();
    if (this.l)
    {
      localFileViewMusicService = this.a;
      if ((localFileViewMusicService != null) && (localFileViewMusicService.b(this.d.c()))) {
        this.a.f();
      }
    }
    MediaFocusManager.b().b(this.m);
    this.a = null;
  }
  
  public void l()
  {
    super.l();
    h();
  }
  
  public void m()
  {
    super.m();
    u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.MusicFilePresenter
 * JD-Core Version:    0.7.0.1
 */