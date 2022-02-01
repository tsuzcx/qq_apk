package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import asvt;
import aswz;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;

public class VideoFilePresenter$6
  implements Runnable
{
  public VideoFilePresenter$6(asvt paramasvt) {}
  
  public void run()
  {
    if (asvt.a(this.this$0) != null) {
      this.this$0.a.d(asvt.a(this.this$0).isPlaying());
    }
    for (;;)
    {
      asvt.d(this.this$0);
      return;
      this.this$0.a.d(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.6
 * JD-Core Version:    0.7.0.1
 */