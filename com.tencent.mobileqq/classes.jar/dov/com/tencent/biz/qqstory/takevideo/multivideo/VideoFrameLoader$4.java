package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import bprn;
import bpro;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

public class VideoFrameLoader$4
  implements Runnable
{
  public VideoFrameLoader$4(bprn parambprn) {}
  
  public void run()
  {
    if (bprn.b(this.this$0) != bprn.a(this.this$0).size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFrameLoader", 2, "onDecodeError , framecount error!" + bprn.b(this.this$0) + "-" + bprn.a(this.this$0).size());
      }
      if ((!bprn.c(this.this$0)) && (bprn.a(this.this$0).size() == 0))
      {
        bprn.a(this.this$0, true);
        this.this$0.b();
        bprn.a(this.this$0, new RetrieverDecodeRunnable(bprn.a(this.this$0), bprn.c(this.this$0), bprn.d(this.this$0), bprn.b(this.this$0), bprn.a(this.this$0), bprn.a(this.this$0), bprn.b(this.this$0), this.this$0));
        ThreadManager.post(bprn.a(this.this$0), 10, null, true);
        if (QLog.isColorLevel()) {
          QLog.d("VideoFrameLoader", 2, "onLoadEnd , retry with retriever!");
        }
      }
    }
    for (;;)
    {
      return;
      if (bprn.a(this.this$0) != null) {}
      for (bpro localbpro = (bpro)bprn.a(this.this$0).get(); localbpro != null; localbpro = null)
      {
        localbpro.c();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.4
 * JD-Core Version:    0.7.0.1
 */