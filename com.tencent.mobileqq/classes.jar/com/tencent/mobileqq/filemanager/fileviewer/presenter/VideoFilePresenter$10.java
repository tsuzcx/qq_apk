package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.os.Handler;
import auaa;
import aubg;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;

public class VideoFilePresenter$10
  implements Runnable
{
  public VideoFilePresenter$10(auaa paramauaa) {}
  
  public void run()
  {
    if (auaa.a(this.this$0) == null) {}
    do
    {
      return;
      this.this$0.jdField_a_of_type_Aubg.d(auaa.a(this.this$0).isPlaying());
    } while ((auaa.a(this.this$0)) || (!auaa.a(this.this$0).isPlaying()));
    int i = (int)auaa.a(this.this$0).getCurPlayingPos();
    int j = (int)auaa.a(this.this$0).getVideoDurationMs();
    this.this$0.jdField_a_of_type_Aubg.b(i);
    if ((!auaa.b(this.this$0)) && (i > auaa.a(this.this$0))) {
      auaa.a(this.this$0, i);
    }
    float f = i / j;
    if (f <= 0.001D)
    {
      auaa.a(this.this$0).postDelayed(this.this$0.jdField_a_of_type_JavaLangRunnable, 100L);
      return;
    }
    if (i >= auaa.a(this.this$0)) {
      this.this$0.jdField_a_of_type_Aubg.c((int)(f * 10000.0F));
    }
    auaa.a(this.this$0).postDelayed(this.this$0.jdField_a_of_type_JavaLangRunnable, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.10
 * JD-Core Version:    0.7.0.1
 */