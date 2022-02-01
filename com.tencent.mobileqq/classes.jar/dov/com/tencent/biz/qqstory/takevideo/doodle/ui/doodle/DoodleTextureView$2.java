package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import bqnt;
import bqoq;
import com.tencent.qphone.base.util.QLog;

class DoodleTextureView$2
  implements Runnable
{
  DoodleTextureView$2(DoodleTextureView paramDoodleTextureView) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      this.this$0.a.g();
      bqoq localbqoq = (bqoq)this.this$0.a.a(102);
      if (localbqoq != null) {
        localbqoq.b();
      }
      this.this$0.a = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DoodleTextureView", 2, "onDestroy end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleTextureView.2
 * JD-Core Version:    0.7.0.1
 */