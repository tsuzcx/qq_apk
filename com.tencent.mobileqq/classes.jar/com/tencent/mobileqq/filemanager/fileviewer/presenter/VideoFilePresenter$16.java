package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import arnb;
import aron;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class VideoFilePresenter$16
  implements Runnable
{
  public VideoFilePresenter$16(arnb paramarnb) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      arnb.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration());
      this.this$0.jdField_a_of_type_Aron.a(arnb.a(this.this$0));
      this.this$0.jdField_a_of_type_Aron.b(false);
      this.this$0.jdField_a_of_type_Aron.f(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.16
 * JD-Core Version:    0.7.0.1
 */