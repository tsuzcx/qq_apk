package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

class VideoFrameLoader$4
  implements Runnable
{
  VideoFrameLoader$4(VideoFrameLoader paramVideoFrameLoader) {}
  
  public void run()
  {
    if (VideoFrameLoader.b(this.this$0) != VideoFrameLoader.a(this.this$0).size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFrameLoader", 2, "onDecodeError , framecount error!" + VideoFrameLoader.b(this.this$0) + "-" + VideoFrameLoader.a(this.this$0).size());
      }
      if ((!VideoFrameLoader.c(this.this$0)) && (VideoFrameLoader.a(this.this$0).size() == 0))
      {
        VideoFrameLoader.a(this.this$0, true);
        this.this$0.b();
        VideoFrameLoader.a(this.this$0, new RetrieverDecodeRunnable(VideoFrameLoader.a(this.this$0), VideoFrameLoader.c(this.this$0), VideoFrameLoader.d(this.this$0), VideoFrameLoader.b(this.this$0), VideoFrameLoader.a(this.this$0), VideoFrameLoader.a(this.this$0), VideoFrameLoader.b(this.this$0), this.this$0));
        ThreadManager.post(VideoFrameLoader.a(this.this$0), 10, null, true);
        if (QLog.isColorLevel()) {
          QLog.d("VideoFrameLoader", 2, "onLoadEnd , retry with retriever!");
        }
      }
    }
    for (;;)
    {
      return;
      if (VideoFrameLoader.a(this.this$0) != null) {}
      for (VideoFrameLoader.VideoFrameLoaderListener localVideoFrameLoaderListener = (VideoFrameLoader.VideoFrameLoaderListener)VideoFrameLoader.a(this.this$0).get(); localVideoFrameLoaderListener != null; localVideoFrameLoaderListener = null)
      {
        localVideoFrameLoaderListener.b();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.4
 * JD-Core Version:    0.7.0.1
 */