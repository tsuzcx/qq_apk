package com.tencent.mobileqq.filebrowser.presenter;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filebrowser.IFileBrowserData;
import com.tencent.mobileqq.filebrowser.IFileBrowserListener;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.view.DocFileBrowserView;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.LocalTbsViewManagerCallback;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.immersive.ImmersiveUtils;

class DocExportFilePresenter$3
  implements LocalTbsViewManager.LocalTbsViewManagerCallback
{
  DocExportFilePresenter$3(DocExportFilePresenter paramDocExportFilePresenter) {}
  
  public void a(String paramString, Drawable paramDrawable1, Drawable paramDrawable2, View.OnClickListener paramOnClickListener) {}
  
  public void a(boolean paramBoolean)
  {
    DocExportFilePresenter.a(this.a, paramBoolean);
    if (this.a.g != null) {
      this.a.g.a(paramBoolean);
    }
    if ((paramBoolean) && (this.a.b.e()))
    {
      this.a.b.c();
      return;
    }
    if ((!paramBoolean) && (this.a.b.d() != null)) {
      this.a.b.a(this.a.c.E());
    }
  }
  
  public boolean a()
  {
    return DocExportFilePresenter.a(this.a);
  }
  
  public View b()
  {
    return null;
  }
  
  public void b(boolean paramBoolean)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.a.g != null)) {
      this.a.g.b();
    }
    if (paramBoolean)
    {
      LocalTbsViewManager.a().b(false);
      this.a.b.a(this.a.d.c(), this);
      DocExportFilePresenter localDocExportFilePresenter = this.a;
      localDocExportFilePresenter.a = false;
      QQToast.makeText(localDocExportFilePresenter.f, 2, 2131889268, 1).show();
      ThreadManagerV2.getUIHandlerV2().postDelayed(new DocExportFilePresenter.3.1(this), 800L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.DocExportFilePresenter.3
 * JD-Core Version:    0.7.0.1
 */