package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import appt;
import aprb;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class VideoFilePresenter$12
  implements Runnable
{
  public VideoFilePresenter$12(appt paramappt) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      appt.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration());
      this.this$0.jdField_a_of_type_Aprb.a(appt.a(this.this$0));
      this.this$0.jdField_a_of_type_Aprb.b(false);
      this.this$0.jdField_a_of_type_Aprb.g(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.12
 * JD-Core Version:    0.7.0.1
 */