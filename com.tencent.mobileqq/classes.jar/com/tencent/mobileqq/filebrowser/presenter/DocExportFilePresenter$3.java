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
  
  public View a()
  {
    return null;
  }
  
  public void a(String paramString, Drawable paramDrawable1, Drawable paramDrawable2, View.OnClickListener paramOnClickListener) {}
  
  public void a(boolean paramBoolean)
  {
    DocExportFilePresenter.a(this.a, paramBoolean);
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserListener != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserListener.a(paramBoolean);
    }
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.a()))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.c();
      return;
    }
    if ((!paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.a() != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.a(this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a());
    }
  }
  
  public boolean a()
  {
    return DocExportFilePresenter.a(this.a);
  }
  
  public void b(boolean paramBoolean)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserListener != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserListener.b();
    }
    if (paramBoolean)
    {
      LocalTbsViewManager.a().b(false);
      this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.a(this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.b(), this);
      DocExportFilePresenter localDocExportFilePresenter = this.a;
      localDocExportFilePresenter.jdField_a_of_type_Boolean = false;
      QQToast.a(localDocExportFilePresenter.jdField_a_of_type_AndroidContentContext, 2, 2131692280, 1).a();
      ThreadManagerV2.getUIHandlerV2().postDelayed(new DocExportFilePresenter.3.1(this), 800L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.DocExportFilePresenter.3
 * JD-Core Version:    0.7.0.1
 */