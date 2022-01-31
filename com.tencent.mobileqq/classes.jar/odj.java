import com.tencent.biz.qqstory.takevideo.EditVideoGuide;
import java.util.concurrent.atomic.AtomicBoolean;

public class odj
  implements Runnable
{
  private odj(EditVideoGuide paramEditVideoGuide) {}
  
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
 * Qualified Name:     odj
 * JD-Core Version:    0.7.0.1
 */