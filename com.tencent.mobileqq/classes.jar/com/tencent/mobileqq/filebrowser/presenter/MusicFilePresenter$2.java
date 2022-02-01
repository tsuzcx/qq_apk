package com.tencent.mobileqq.filebrowser.presenter;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.mobileqq.filebrowser.FileViewMusicService;
import com.tencent.mobileqq.filebrowser.IFileBrowserData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MusicFilePresenter$2
  implements SeekBar.OnSeekBarChangeListener
{
  MusicFilePresenter$2(MusicFilePresenter paramMusicFilePresenter) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a.a != null))
    {
      this.a.a.a(paramInt);
      this.a.b(paramInt);
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    MusicFilePresenter.a(this.a, false);
    if ((this.a.a != null) && (!this.a.a.b(this.a.d.c()))) {
      this.a.a.g();
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    MusicFilePresenter.a(this.a, true);
    if (this.a.a != null) {
      this.a.a.h();
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.MusicFilePresenter.2
 * JD-Core Version:    0.7.0.1
 */