package com.tencent.mobileqq.filebrowser.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ApkSimpleFilePresenter$2
  implements View.OnClickListener
{
  ApkSimpleFilePresenter$2(ApkSimpleFilePresenter paramApkSimpleFilePresenter, String paramString) {}
  
  public void onClick(View paramView)
  {
    this.b.c.a(this.b.f, this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.ApkSimpleFilePresenter.2
 * JD-Core Version:    0.7.0.1
 */