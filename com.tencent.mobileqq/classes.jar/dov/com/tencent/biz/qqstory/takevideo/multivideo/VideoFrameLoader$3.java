package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import bkju;
import bkjv;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

public class VideoFrameLoader$3
  implements Runnable
{
  public VideoFrameLoader$3(bkju parambkju) {}
  
  public void run()
  {
    if (bkju.b(this.this$0) != bkju.a(this.this$0).size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFrameLoader", 2, "onLoadEnd , framecount error!" + bkju.b(this.this$0) + "-" + bkju.a(this.this$0).size());
      }
      if ((!bkju.c(this.this$0)) && (bkju.a(this.this$0).size() == 0))
      {
        bkju.a(this.this$0, true);
        this.this$0.b();
        bkju.a(this.this$0, new RetrieverDecodeRunnable(bkju.a(this.this$0), bkju.c(this.this$0), bkju.d(this.this$0), bkju.b(this.this$0), bkju.a(this.this$0), bkju.a(this.this$0), bkju.b(this.this$0), this.this$0));
        ThreadManager.post(bkju.a(this.this$0), 10, null, true);
        if (QLog.isColorLevel()) {
          QLog.d("VideoFrameLoader", 2, "onLoadEnd , retry with retriever!");
        }
      }
    }
    for (;;)
    {
      return;
      if (bkju.a(this.this$0) != null) {}
      for (bkjv localbkjv = (bkjv)bkju.a(this.this$0).get(); localbkjv != null; localbkjv = null)
      {
        localbkjv.c();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.3
 * JD-Core Version:    0.7.0.1
 */