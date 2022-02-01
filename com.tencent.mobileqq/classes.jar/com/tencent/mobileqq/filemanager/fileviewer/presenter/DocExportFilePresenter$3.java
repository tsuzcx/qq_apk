package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.LocalTbsViewManagerCallback;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.immersive.ImmersiveUtils;

class DocExportFilePresenter$3
  implements LocalTbsViewManager.LocalTbsViewManagerCallback
{
  DocExportFilePresenter$3(DocExportFilePresenter paramDocExportFilePresenter) {}
  
  public void a(String paramString, Drawable paramDrawable1, Drawable paramDrawable2, View.OnClickListener paramOnClickListener) {}
  
  public void a(boolean paramBoolean)
  {
    if (this.a.f != null) {
      this.a.f.a(paramBoolean);
    }
    if ((this.a.b.g()) && (paramBoolean))
    {
      this.a.b.e();
      return;
    }
    if ((this.a.b.f() != null) && (!paramBoolean)) {
      this.a.b.b(this.a.c.U());
    }
  }
  
  public boolean a()
  {
    if (this.a.e != null) {
      return this.a.e.e();
    }
    return false;
  }
  
  public View b()
  {
    return null;
  }
  
  public void b(boolean paramBoolean)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.a.f != null)) {
      this.a.f.a();
    }
    if (paramBoolean)
    {
      LocalTbsViewManager.a().b(false);
      this.a.b.a(this.a.c.y(), this);
      DocExportFilePresenter localDocExportFilePresenter = this.a;
      localDocExportFilePresenter.a = false;
      QQToast.makeText(localDocExportFilePresenter.d, 2, 2131889268, 1).show();
      ThreadManagerV2.getUIHandlerV2().postDelayed(new DocExportFilePresenter.3.1(this), 800L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.DocExportFilePresenter.3
 * JD-Core Version:    0.7.0.1
 */