package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.view.View;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.PictureFileViewer;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class PictureFilePresenter$3
  implements AdapterView.OnItemClickListener
{
  PictureFilePresenter$3(PictureFilePresenter paramPictureFilePresenter) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a;
    PictureFilePresenter.a(paramAdapterView, PictureFilePresenter.b(paramAdapterView) ^ true);
    if (this.a.f != null) {
      this.a.f.a(PictureFilePresenter.b(this.a));
    }
    if (PictureFilePresenter.b(this.a))
    {
      this.a.a.a(false);
      this.a.a.b(false);
    }
    else
    {
      this.a.a.a(true);
      this.a.h();
    }
    this.a.a.e(PictureFilePresenter.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.PictureFilePresenter.3
 * JD-Core Version:    0.7.0.1
 */