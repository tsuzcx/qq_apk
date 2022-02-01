package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import bnoq;
import bnor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

public class VideoFrameLoader$4
  implements Runnable
{
  public VideoFrameLoader$4(bnoq parambnoq) {}
  
  public void run()
  {
    if (bnoq.b(this.this$0) != bnoq.a(this.this$0).size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFrameLoader", 2, "onDecodeError , framecount error!" + bnoq.b(this.this$0) + "-" + bnoq.a(this.this$0).size());
      }
      if ((!bnoq.c(this.this$0)) && (bnoq.a(this.this$0).size() == 0))
      {
        bnoq.a(this.this$0, true);
        this.this$0.b();
        bnoq.a(this.this$0, new RetrieverDecodeRunnable(bnoq.a(this.this$0), bnoq.c(this.this$0), bnoq.d(this.this$0), bnoq.b(this.this$0), bnoq.a(this.this$0), bnoq.a(this.this$0), bnoq.b(this.this$0), this.this$0));
        ThreadManager.post(bnoq.a(this.this$0), 10, null, true);
        if (QLog.isColorLevel()) {
          QLog.d("VideoFrameLoader", 2, "onLoadEnd , retry with retriever!");
        }
      }
    }
    for (;;)
    {
      return;
      if (bnoq.a(this.this$0) != null) {}
      for (bnor localbnor = (bnor)bnoq.a(this.this$0).get(); localbnor != null; localbnor = null)
      {
        localbnor.b();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.4
 * JD-Core Version:    0.7.0.1
 */