import com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class rbu
  extends JobSegment
{
  public rbu(DefaultDoraemonAppInfoHelper paramDefaultDoraemonAppInfoHelper) {}
  
  protected void a(JobContext paramJobContext, rbv paramrbv)
  {
    if (!this.a.a) {
      this.a.a();
    }
    notifyResult(paramrbv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     rbu
 * JD-Core Version:    0.7.0.1
 */