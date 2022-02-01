package com.tencent.mobileqq.filebrowser.presenter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filebrowser.IFileBrowserData;
import com.tencent.mobileqq.filebrowser.IFileBrowserListener;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.view.DocFileBrowserView;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.LocalTbsViewManagerCallback;
import com.tencent.mobileqq.filemanager.util.QBrowserUtils;
import com.tencent.widget.immersive.ImmersiveUtils;

class DocFilePresenter$1
  implements LocalTbsViewManager.LocalTbsViewManagerCallback
{
  DocFilePresenter$1(DocFilePresenter paramDocFilePresenter) {}
  
  public void a(String paramString, Drawable paramDrawable1, Drawable paramDrawable2, View.OnClickListener paramOnClickListener) {}
  
  public void a(boolean paramBoolean)
  {
    DocFilePresenter.a(this.a, paramBoolean);
  }
  
  public boolean a()
  {
    return DocFilePresenter.c(this.a);
  }
  
  public View b()
  {
    return DocFilePresenter.a(this.a).b(this.a.c.E());
  }
  
  public void b(boolean paramBoolean)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.a.g != null)) {
      this.a.g.b();
    }
    if (paramBoolean)
    {
      if (this.a.d.d() == 10) {
        QBrowserUtils.a(this.a.d.b());
      }
      DocFilePresenter.a(this.a).a(this.a.d.c(), this);
      DocFilePresenter.b(this.a, true);
      DocFilePresenter.b(this.a);
      this.a.a = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.DocFilePresenter.1
 * JD-Core Version:    0.7.0.1
 */