package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.os.Handler;
import asvt;
import aswz;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;

public class VideoFilePresenter$10
  implements Runnable
{
  public VideoFilePresenter$10(asvt paramasvt) {}
  
  public void run()
  {
    if (asvt.a(this.this$0) == null) {}
    do
    {
      return;
      this.this$0.jdField_a_of_type_Aswz.d(asvt.a(this.this$0).isPlaying());
    } while ((asvt.a(this.this$0)) || (!asvt.a(this.this$0).isPlaying()));
    int i = (int)asvt.a(this.this$0).getCurPlayingPos();
    int j = (int)asvt.a(this.this$0).getVideoDurationMs();
    this.this$0.jdField_a_of_type_Aswz.b(i);
    if ((!asvt.b(this.this$0)) && (i > asvt.a(this.this$0))) {
      asvt.a(this.this$0, i);
    }
    float f = i / j;
    if (f <= 0.001D)
    {
      asvt.a(this.this$0).postDelayed(this.this$0.jdField_a_of_type_JavaLangRunnable, 100L);
      return;
    }
    if (i >= asvt.a(this.this$0)) {
      this.this$0.jdField_a_of_type_Aswz.c((int)(f * 10000.0F));
    }
    asvt.a(this.this$0).postDelayed(this.this$0.jdField_a_of_type_JavaLangRunnable, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.10
 * JD-Core Version:    0.7.0.1
 */