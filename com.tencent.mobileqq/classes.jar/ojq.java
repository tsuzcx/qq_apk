import com.tencent.biz.qqstory.takevideo.EditVideoGuide;
import java.util.concurrent.atomic.AtomicBoolean;

public class ojq
  implements Runnable
{
  private ojq(EditVideoGuide paramEditVideoGuide) {}
  
  public void run()
  {
    if (this.a.a.compareAndSet(true, false))
    {
      this.a.a(false);
      this.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ojq
 * JD-Core Version:    0.7.0.1
 */