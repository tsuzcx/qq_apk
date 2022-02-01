package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import com.tencent.mobileqq.mediafocus.MediaFocusManager.OnMediaFocusChangeListener;
import com.tencent.qphone.base.util.QLog;

class MusicFilePresenter$6
  implements MediaFocusManager.OnMediaFocusChangeListener
{
  MusicFilePresenter$6(MusicFilePresenter paramMusicFilePresenter) {}
  
  public void a(int paramInt)
  {
    if ((paramInt != -2) && (paramInt != -1))
    {
      if (paramInt != 1) {
        return;
      }
      QLog.i("FileBrowserPresenter<FileAssistant>", 1, "onFocusChange: MEDIAFOCUS_GAIN");
      if (!MusicFilePresenter.a(this.a)) {
        MusicFilePresenter.b(this.a);
      }
    }
    else
    {
      QLog.i("FileBrowserPresenter<FileAssistant>", 1, "onFocusChange: MEDIAFOCUS_LOSS");
      if (MusicFilePresenter.a(this.a)) {
        MusicFilePresenter.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter.6
 * JD-Core Version:    0.7.0.1
 */