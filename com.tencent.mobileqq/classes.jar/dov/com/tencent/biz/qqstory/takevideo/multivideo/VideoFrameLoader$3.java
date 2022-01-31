package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import bkkl;
import bkkm;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

public class VideoFrameLoader$3
  implements Runnable
{
  public VideoFrameLoader$3(bkkl parambkkl) {}
  
  public void run()
  {
    if (bkkl.b(this.this$0) != bkkl.a(this.this$0).size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFrameLoader", 2, "onLoadEnd , framecount error!" + bkkl.b(this.this$0) + "-" + bkkl.a(this.this$0).size());
      }
      if ((!bkkl.c(this.this$0)) && (bkkl.a(this.this$0).size() == 0))
      {
        bkkl.a(this.this$0, true);
        this.this$0.b();
        bkkl.a(this.this$0, new RetrieverDecodeRunnable(bkkl.a(this.this$0), bkkl.c(this.this$0), bkkl.d(this.this$0), bkkl.b(this.this$0), bkkl.a(this.this$0), bkkl.a(this.this$0), bkkl.b(this.this$0), this.this$0));
        ThreadManager.post(bkkl.a(this.this$0), 10, null, true);
        if (QLog.isColorLevel()) {
          QLog.d("VideoFrameLoader", 2, "onLoadEnd , retry with retriever!");
        }
      }
    }
    for (;;)
    {
      return;
      if (bkkl.a(this.this$0) != null) {}
      for (bkkm localbkkm = (bkkm)bkkl.a(this.this$0).get(); localbkkm != null; localbkkm = null)
      {
        localbkkm.c();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.3
 * JD-Core Version:    0.7.0.1
 */