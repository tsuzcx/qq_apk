package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PictureFilePresenter$2
  implements View.OnClickListener
{
  PictureFilePresenter$2(PictureFilePresenter paramPictureFilePresenter) {}
  
  public void onClick(View paramView)
  {
    PictureFilePresenter.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.PictureFilePresenter.2
 * JD-Core Version:    0.7.0.1
 */