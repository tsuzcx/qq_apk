package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import aoyb;
import aozd;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class VideoFilePresenter$12
  implements Runnable
{
  public VideoFilePresenter$12(aoyb paramaoyb) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      aoyb.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration());
      this.this$0.jdField_a_of_type_Aozd.a(aoyb.a(this.this$0));
      this.this$0.jdField_a_of_type_Aozd.b(false);
      this.this$0.jdField_a_of_type_Aozd.g(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.12
 * JD-Core Version:    0.7.0.1
 */