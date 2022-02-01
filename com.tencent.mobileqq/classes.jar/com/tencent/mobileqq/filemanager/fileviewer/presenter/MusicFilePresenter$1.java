package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.mobileqq.filebrowser.FileViewMusicService;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MusicFilePresenter$1
  implements SeekBar.OnSeekBarChangeListener
{
  MusicFilePresenter$1(MusicFilePresenter paramMusicFilePresenter) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a.b != null))
    {
      this.a.b.a(paramInt);
      this.a.b(paramInt);
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    MusicFilePresenter.a(this.a, false);
    if ((this.a.b != null) && (!this.a.b.b(MusicFilePresenter.a(this.a)))) {
      this.a.b.g();
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    MusicFilePresenter.a(this.a, true);
    if (this.a.b != null) {
      this.a.b.h();
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter.1
 * JD-Core Version:    0.7.0.1
 */