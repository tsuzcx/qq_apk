import com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class rel
  extends JobSegment
{
  public rel(DefaultDoraemonAppInfoHelper paramDefaultDoraemonAppInfoHelper) {}
  
  protected void a(JobContext paramJobContext, rem paramrem)
  {
    if (!this.a.a) {
      this.a.a();
    }
    notifyResult(paramrem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rel
 * JD-Core Version:    0.7.0.1
 */