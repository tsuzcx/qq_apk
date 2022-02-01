package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IThumbController;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.ImageFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.PictureFileViewer;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import java.util.List;

class PictureFilePresenter$4
  implements AdapterView.OnItemSelectedListener
{
  PictureFilePresenter$4(PictureFilePresenter paramPictureFilePresenter) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    PictureFilePresenter.a(this.a, paramInt);
    paramAdapterView = this.a.a;
    boolean bool;
    if (PictureFilePresenter.c(this.a) == PictureFilePresenter.d(this.a)) {
      bool = true;
    } else {
      bool = false;
    }
    paramAdapterView.d(bool);
    this.a.a(paramInt);
    if (this.a.f != null) {
      this.a.f.a(paramInt);
    }
    paramAdapterView = (FileBrowserModelBase.ImageFileInfo)PictureFilePresenter.e(this.a).get(paramInt);
    if (paramAdapterView == null)
    {
      FMToastUtil.b(BaseApplicationImpl.getContext().getString(2131889341));
      return;
    }
    this.a.c.Q().a(paramAdapterView);
    this.a.c.a(paramInt, paramAdapterView);
    paramAdapterView = this.a.a;
    paramView = this.a;
    paramAdapterView.c(PictureFilePresenter.a(paramView, PictureFilePresenter.f(paramView)));
    this.a.a.e();
    if (this.a.e != null) {
      this.a.e.h();
    }
    if (this.a.b)
    {
      this.a.f.a(true);
      this.a.a.a(false);
      PictureFilePresenter.a(this.a, true);
    }
    this.a.b = true;
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.PictureFilePresenter.4
 * JD-Core Version:    0.7.0.1
 */