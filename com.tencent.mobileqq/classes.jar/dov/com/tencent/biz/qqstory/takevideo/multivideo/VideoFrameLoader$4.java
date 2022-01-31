package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import bitg;
import bith;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

public class VideoFrameLoader$4
  implements Runnable
{
  public VideoFrameLoader$4(bitg parambitg) {}
  
  public void run()
  {
    if (bitg.b(this.this$0) != bitg.a(this.this$0).size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFrameLoader", 2, "onDecodeError , framecount error!" + bitg.b(this.this$0) + "-" + bitg.a(this.this$0).size());
      }
      if ((!bitg.c(this.this$0)) && (bitg.a(this.this$0).size() == 0))
      {
        bitg.a(this.this$0, true);
        this.this$0.b();
        bitg.a(this.this$0, new RetrieverDecodeRunnable(bitg.a(this.this$0), bitg.c(this.this$0), bitg.d(this.this$0), bitg.b(this.this$0), bitg.a(this.this$0), bitg.a(this.this$0), bitg.b(this.this$0), this.this$0));
        ThreadManager.post(bitg.a(this.this$0), 10, null, true);
        if (QLog.isColorLevel()) {
          QLog.d("VideoFrameLoader", 2, "onLoadEnd , retry with retriever!");
        }
      }
    }
    for (;;)
    {
      return;
      if (bitg.a(this.this$0) != null) {}
      for (bith localbith = (bith)bitg.a(this.this$0).get(); localbith != null; localbith = null)
      {
        localbith.c();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.4
 * JD-Core Version:    0.7.0.1
 */