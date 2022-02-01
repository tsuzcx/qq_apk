package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.os.Handler;
import atro;
import atsu;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;

public class VideoFilePresenter$10
  implements Runnable
{
  public VideoFilePresenter$10(atro paramatro) {}
  
  public void run()
  {
    if (atro.a(this.this$0) == null) {}
    do
    {
      return;
      this.this$0.jdField_a_of_type_Atsu.d(atro.a(this.this$0).isPlaying());
    } while ((atro.a(this.this$0)) || (!atro.a(this.this$0).isPlaying()));
    int i = (int)atro.a(this.this$0).getCurPlayingPos();
    int j = (int)atro.a(this.this$0).getVideoDurationMs();
    this.this$0.jdField_a_of_type_Atsu.b(i);
    if ((!atro.b(this.this$0)) && (i > atro.a(this.this$0))) {
      atro.a(this.this$0, i);
    }
    float f = i / j;
    if (f <= 0.001D)
    {
      atro.a(this.this$0).postDelayed(this.this$0.jdField_a_of_type_JavaLangRunnable, 100L);
      return;
    }
    if (i >= atro.a(this.this$0)) {
      this.this$0.jdField_a_of_type_Atsu.c((int)(f * 10000.0F));
    }
    atro.a(this.this$0).postDelayed(this.this$0.jdField_a_of_type_JavaLangRunnable, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.10
 * JD-Core Version:    0.7.0.1
 */