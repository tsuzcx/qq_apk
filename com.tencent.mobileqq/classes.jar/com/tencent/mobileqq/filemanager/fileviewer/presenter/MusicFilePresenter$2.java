package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MusicFilePresenter$2
  implements View.OnClickListener
{
  MusicFilePresenter$2(MusicFilePresenter paramMusicFilePresenter) {}
  
  public void onClick(View paramView)
  {
    if (MusicFilePresenter.a(this.a)) {
      MusicFilePresenter.a(this.a);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      MusicFilePresenter.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter.2
 * JD-Core Version:    0.7.0.1
 */