package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.LocalTbsViewManagerCallback;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.fileviewer.QFileBrowserUtils;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.widget.immersive.ImmersiveUtils;

class SimpleFilePresenter$5
  implements LocalTbsViewManager.LocalTbsViewManagerCallback
{
  SimpleFilePresenter$5(SimpleFilePresenter paramSimpleFilePresenter) {}
  
  public void a(String paramString, Drawable paramDrawable1, Drawable paramDrawable2, View.OnClickListener paramOnClickListener) {}
  
  public void a(boolean paramBoolean)
  {
    SimpleFilePresenter.a(this.a, paramBoolean);
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
    return this.a.k.a(this.a.c.U());
  }
  
  public void b(boolean paramBoolean)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.a.f != null)) {
      this.a.f.a();
    }
    if (paramBoolean)
    {
      if (this.a.c.z() == 10) {
        QFileBrowserUtils.a(this.a.c.x());
      }
      this.a.k.a(this.a.c.y(), this);
      SimpleFilePresenter.b(this.a, true);
      SimpleFilePresenter.d(this.a);
      this.a.j = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.5
 * JD-Core Version:    0.7.0.1
 */