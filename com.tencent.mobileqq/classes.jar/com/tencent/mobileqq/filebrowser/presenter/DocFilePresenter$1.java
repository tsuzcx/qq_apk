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
  
  public View a()
  {
    return DocFilePresenter.a(this.a).a(this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a());
  }
  
  public void a(String paramString, Drawable paramDrawable1, Drawable paramDrawable2, View.OnClickListener paramOnClickListener) {}
  
  public void a(boolean paramBoolean)
  {
    DocFilePresenter.a(this.a, paramBoolean);
  }
  
  public boolean a()
  {
    return DocFilePresenter.a(this.a);
  }
  
  public void b(boolean paramBoolean)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserListener != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserListener.b();
    }
    if (paramBoolean)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a() == 10) {
        QBrowserUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a());
      }
      DocFilePresenter.a(this.a).a(this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.b(), this);
      DocFilePresenter.a(this.a, true);
      DocFilePresenter.a(this.a);
      this.a.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.DocFilePresenter.1
 * JD-Core Version:    0.7.0.1
 */