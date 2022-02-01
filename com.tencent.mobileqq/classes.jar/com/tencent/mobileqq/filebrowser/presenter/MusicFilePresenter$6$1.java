package com.tencent.mobileqq.filebrowser.presenter;

import com.tencent.mobileqq.filebrowser.FileViewMusicService;
import com.tencent.mobileqq.filebrowser.IFileBrowserData;
import com.tencent.mobileqq.filebrowser.view.MusicFileBrowserView;

class MusicFilePresenter$6$1
  implements Runnable
{
  MusicFilePresenter$6$1(MusicFilePresenter.6 param6) {}
  
  public void run()
  {
    if ((this.a.this$0.jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService != null) && (this.a.this$0.jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService.b(this.a.this$0.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.b())))
    {
      int i = this.a.this$0.jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService.a();
      this.a.this$0.b(i);
      MusicFilePresenter.a(this.a.this$0).a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.MusicFilePresenter.6.1
 * JD-Core Version:    0.7.0.1
 */