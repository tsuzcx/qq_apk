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
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService != null))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService.a(paramInt);
      this.a.b(paramInt);
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    MusicFilePresenter.a(this.a, false);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService != null) && (!this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService.b(this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.b()))) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService.d();
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    MusicFilePresenter.a(this.a, true);
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService.e();
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.MusicFilePresenter.2
 * JD-Core Version:    0.7.0.1
 */