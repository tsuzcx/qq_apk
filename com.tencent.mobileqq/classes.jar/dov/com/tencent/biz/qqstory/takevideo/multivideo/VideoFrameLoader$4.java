package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import bnah;
import bnai;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

public class VideoFrameLoader$4
  implements Runnable
{
  public VideoFrameLoader$4(bnah parambnah) {}
  
  public void run()
  {
    if (bnah.b(this.this$0) != bnah.a(this.this$0).size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFrameLoader", 2, "onDecodeError , framecount error!" + bnah.b(this.this$0) + "-" + bnah.a(this.this$0).size());
      }
      if ((!bnah.c(this.this$0)) && (bnah.a(this.this$0).size() == 0))
      {
        bnah.a(this.this$0, true);
        this.this$0.b();
        bnah.a(this.this$0, new RetrieverDecodeRunnable(bnah.a(this.this$0), bnah.c(this.this$0), bnah.d(this.this$0), bnah.b(this.this$0), bnah.a(this.this$0), bnah.a(this.this$0), bnah.b(this.this$0), this.this$0));
        ThreadManager.post(bnah.a(this.this$0), 10, null, true);
        if (QLog.isColorLevel()) {
          QLog.d("VideoFrameLoader", 2, "onLoadEnd , retry with retriever!");
        }
      }
    }
    for (;;)
    {
      return;
      if (bnah.a(this.this$0) != null) {}
      for (bnai localbnai = (bnai)bnah.a(this.this$0).get(); localbnai != null; localbnai = null)
      {
        localbnai.c();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.4
 * JD-Core Version:    0.7.0.1
 */