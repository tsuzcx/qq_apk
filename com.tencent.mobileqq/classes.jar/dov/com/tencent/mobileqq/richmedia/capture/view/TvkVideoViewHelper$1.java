package dov.com.tencent.mobileqq.richmedia.capture.view;

import brfq;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class TvkVideoViewHelper$1
  implements Runnable
{
  public TvkVideoViewHelper$1(brfq parambrfq) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TvkVideoViewHelper", 2, "onVideoPrepared");
    }
    this.this$0.a = true;
    if (QLog.isColorLevel()) {
      QLog.d("TvkVideoViewHelper", 2, "start play");
    }
    brfq.a(this.this$0).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.TvkVideoViewHelper.1
 * JD-Core Version:    0.7.0.1
 */