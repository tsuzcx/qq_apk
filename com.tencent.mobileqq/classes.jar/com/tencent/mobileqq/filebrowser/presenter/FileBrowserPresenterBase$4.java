package com.tencent.mobileqq.filebrowser.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filebrowser.IFileBrowserData;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FileBrowserPresenterBase$4
  implements View.OnClickListener
{
  FileBrowserPresenterBase$4(FileBrowserPresenterBase paramFileBrowserPresenterBase) {}
  
  public void onClick(View paramView)
  {
    this.a.c.a(this.a.e, this.a.d.c());
    this.a.h = true;
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase.4
 * JD-Core Version:    0.7.0.1
 */