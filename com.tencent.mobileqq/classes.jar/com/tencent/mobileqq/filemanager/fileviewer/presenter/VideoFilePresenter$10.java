package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.os.Handler;
import aujj;
import aukp;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;

public class VideoFilePresenter$10
  implements Runnable
{
  public VideoFilePresenter$10(aujj paramaujj) {}
  
  public void run()
  {
    if (aujj.a(this.this$0) == null) {}
    do
    {
      return;
      this.this$0.jdField_a_of_type_Aukp.d(aujj.a(this.this$0).isPlaying());
    } while ((aujj.a(this.this$0)) || (!aujj.a(this.this$0).isPlaying()));
    int i = (int)aujj.a(this.this$0).getCurPlayingPos();
    int j = (int)aujj.a(this.this$0).getVideoDurationMs();
    this.this$0.jdField_a_of_type_Aukp.b(i);
    if ((!aujj.b(this.this$0)) && (i > aujj.a(this.this$0))) {
      aujj.a(this.this$0, i);
    }
    float f = i / j;
    if (f <= 0.001D)
    {
      aujj.a(this.this$0).postDelayed(this.this$0.jdField_a_of_type_JavaLangRunnable, 100L);
      return;
    }
    if (i >= aujj.a(this.this$0)) {
      this.this$0.jdField_a_of_type_Aukp.c((int)(f * 10000.0F));
    }
    aujj.a(this.this$0).postDelayed(this.this$0.jdField_a_of_type_JavaLangRunnable, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.10
 * JD-Core Version:    0.7.0.1
 */