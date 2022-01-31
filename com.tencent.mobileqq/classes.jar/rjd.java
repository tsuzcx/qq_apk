import com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class rjd
  extends JobSegment
{
  public rjd(DefaultDoraemonAppInfoHelper paramDefaultDoraemonAppInfoHelper) {}
  
  protected void a(JobContext paramJobContext, rje paramrje)
  {
    if (!this.a.a) {
      this.a.a();
    }
    notifyResult(paramrje);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rjd
 * JD-Core Version:    0.7.0.1
 */