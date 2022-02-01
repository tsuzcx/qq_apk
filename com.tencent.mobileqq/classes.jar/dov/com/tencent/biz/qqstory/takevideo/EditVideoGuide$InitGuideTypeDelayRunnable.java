package dov.com.tencent.biz.qqstory.takevideo;

import java.util.concurrent.atomic.AtomicBoolean;

class EditVideoGuide$InitGuideTypeDelayRunnable
  implements Runnable
{
  private EditVideoGuide$InitGuideTypeDelayRunnable(EditVideoGuide paramEditVideoGuide) {}
  
  public void run()
  {
    if (this.this$0.a.compareAndSet(true, false))
    {
      this.this$0.b(false);
      this.this$0.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoGuide.InitGuideTypeDelayRunnable
 * JD-Core Version:    0.7.0.1
 */