package com.tencent.mobileqq.filebrowser.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MusicFilePresenter$3
  implements View.OnClickListener
{
  MusicFilePresenter$3(MusicFilePresenter paramMusicFilePresenter) {}
  
  public void onClick(View paramView)
  {
    if (MusicFilePresenter.a(this.a)) {
      MusicFilePresenter.b(this.a);
    } else {
      MusicFilePresenter.a(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.MusicFilePresenter.3
 * JD-Core Version:    0.7.0.1
 */