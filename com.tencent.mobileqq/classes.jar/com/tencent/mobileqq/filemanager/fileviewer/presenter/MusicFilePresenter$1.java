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
    if ((paramBoolean) && (this.a.a != null))
    {
      this.a.a.a(paramInt);
      this.a.b(paramInt);
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    MusicFilePresenter.a(this.a, false);
    if ((this.a.a != null) && (!this.a.a.b(MusicFilePresenter.a(this.a)))) {
      this.a.a.d();
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    MusicFilePresenter.a(this.a, true);
    if (this.a.a != null) {
      this.a.a.e();
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter.1
 * JD-Core Version:    0.7.0.1
 */