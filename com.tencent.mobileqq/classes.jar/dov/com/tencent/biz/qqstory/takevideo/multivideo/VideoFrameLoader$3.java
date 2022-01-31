package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import bmvv;
import bmvw;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

public class VideoFrameLoader$3
  implements Runnable
{
  public VideoFrameLoader$3(bmvv parambmvv) {}
  
  public void run()
  {
    if (bmvv.b(this.this$0) != bmvv.a(this.this$0).size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFrameLoader", 2, "onLoadEnd , framecount error!" + bmvv.b(this.this$0) + "-" + bmvv.a(this.this$0).size());
      }
      if ((!bmvv.c(this.this$0)) && (bmvv.a(this.this$0).size() == 0))
      {
        bmvv.a(this.this$0, true);
        this.this$0.b();
        bmvv.a(this.this$0, new RetrieverDecodeRunnable(bmvv.a(this.this$0), bmvv.c(this.this$0), bmvv.d(this.this$0), bmvv.b(this.this$0), bmvv.a(this.this$0), bmvv.a(this.this$0), bmvv.b(this.this$0), this.this$0));
        ThreadManager.post(bmvv.a(this.this$0), 10, null, true);
        if (QLog.isColorLevel()) {
          QLog.d("VideoFrameLoader", 2, "onLoadEnd , retry with retriever!");
        }
      }
    }
    for (;;)
    {
      return;
      if (bmvv.a(this.this$0) != null) {}
      for (bmvw localbmvw = (bmvw)bmvv.a(this.this$0).get(); localbmvw != null; localbmvw = null)
      {
        localbmvw.c();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.3
 * JD-Core Version:    0.7.0.1
 */