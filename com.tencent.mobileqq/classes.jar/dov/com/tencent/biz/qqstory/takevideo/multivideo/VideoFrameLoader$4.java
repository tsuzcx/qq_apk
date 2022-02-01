package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import bqti;
import bqtj;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

public class VideoFrameLoader$4
  implements Runnable
{
  public VideoFrameLoader$4(bqti parambqti) {}
  
  public void run()
  {
    if (bqti.b(this.this$0) != bqti.a(this.this$0).size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFrameLoader", 2, "onDecodeError , framecount error!" + bqti.b(this.this$0) + "-" + bqti.a(this.this$0).size());
      }
      if ((!bqti.c(this.this$0)) && (bqti.a(this.this$0).size() == 0))
      {
        bqti.a(this.this$0, true);
        this.this$0.b();
        bqti.a(this.this$0, new RetrieverDecodeRunnable(bqti.a(this.this$0), bqti.c(this.this$0), bqti.d(this.this$0), bqti.b(this.this$0), bqti.a(this.this$0), bqti.a(this.this$0), bqti.b(this.this$0), this.this$0));
        ThreadManager.post(bqti.a(this.this$0), 10, null, true);
        if (QLog.isColorLevel()) {
          QLog.d("VideoFrameLoader", 2, "onLoadEnd , retry with retriever!");
        }
      }
    }
    for (;;)
    {
      return;
      if (bqti.a(this.this$0) != null) {}
      for (bqtj localbqtj = (bqtj)bqti.a(this.this$0).get(); localbqtj != null; localbqtj = null)
      {
        localbqtj.c();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.4
 * JD-Core Version:    0.7.0.1
 */